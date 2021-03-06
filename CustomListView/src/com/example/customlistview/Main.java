package com.example.customlistview;

import com.example.customlistview.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class Main extends ListActivity{
	String[] list = {"ipsum", "laurum", "etgort", "youturt", "semilale", "tortouse",
			"germone", "alchemisery","nupperror", "surrondstores" };
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ListView lv = getListView();
		setListAdapter(new MyAdapter(this, R.layout.row, list));		
		
	}
	
	class MyAdapter extends ArrayAdapter{
		private String[] myList;
		private Context context;

		public MyAdapter(Context context, int resource, String[] objects) {
			super(context, resource, objects);
			myList = objects;
			this.context = context;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView label;
			//reuse converView if you can to speed up scrolling on listview
			if(convertView == null){
				//inflate the listview
				LayoutInflater inflator = ((Activity)context).getLayoutInflater();
				convertView = inflator.inflate(R.layout.row, parent, false);
				convertView.setTag(R.id.textView1, convertView.findViewById(R.id.textView1));
				
			}
			
			label = (TextView) convertView.getTag(R.id.textView1);
			label.setText(myList[position]);
			
			if(myList[position].contains("s")){
				label.setTextColor(Color.RED);
			}
			
			
			return convertView;
		}
		
		
		
		
		

	}
	
	

}
