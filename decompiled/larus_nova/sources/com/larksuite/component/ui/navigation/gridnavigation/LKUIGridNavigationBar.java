package com.larksuite.component.ui.navigation.gridnavigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import android.widget.GridView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import f08.a;
import j08.b;

/* JADX INFO: loaded from: classes24.dex */
public class LKUIGridNavigationBar extends GridView {
    public LKUIGridNavigationBar(Context r100) {
        this(r100, null);
    }

    public void setAdapter(a r100) {
        super.setAdapter(r100);
    }

    public void setGridItemImageHeight(int r100) {
        if (a.f475009a != null) goto L5;
        return;
    L5:
        if (getAdapter() != null) goto L7;
        return;
    L7:
        if ((getAdapter() instanceof BaseAdapter) == false) goto L12;
        ((BaseAdapter) getAdapter()).notifyDataSetChanged();
        return;
    }

    public void setGridItemImageWidth(int r100) {
        if (a.f475009a != null) goto L5;
        return;
    L5:
        if (getAdapter() != null) goto L7;
        return;
    L7:
        if ((getAdapter() instanceof BaseAdapter) == false) goto L12;
        ((BaseAdapter) getAdapter()).notifyDataSetChanged();
        return;
    }

    public void setGridItemTextColor(int r100) {
        if (a.f475009a != null) goto L5;
        return;
    L5:
        if (getAdapter() != null) goto L7;
        return;
    L7:
        if ((getAdapter() instanceof BaseAdapter) == false) goto L12;
        ((BaseAdapter) getAdapter()).notifyDataSetChanged();
        return;
    }

    public void setGridItemTextSize(float r100) {
        b.e(getContext(), r100);
        if (a.f475009a != null) goto L5;
        return;
    L5:
        if (getAdapter() != null) goto L7;
        return;
    L7:
        if ((getAdapter() instanceof BaseAdapter) == false) goto L12;
        ((BaseAdapter) getAdapter()).notifyDataSetChanged();
        return;
    }

    public LKUIGridNavigationBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LKUIGridNavigationBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        if (r101 == null) goto L5;
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.grid_navigation_image_height, R.attr.grid_navigation_image_width, R.attr.grid_navigation_textColor, R.attr.grid_navigation_textSize});
        r103.getColor(2, ContextCompat.getColor(getContext(), R.color.lkui_N900));
        r103.getDimension(3, b.e(getContext(), 14.0f));
        r103.getDimensionPixelSize(0, 140);
        r103.getDimensionPixelSize(1, 140);
        r103.recycle();
    L6:
        a.f475009a = new f08.b();
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setSelector(R.color.lkui_transparent);
        return;
    L5:
        ContextCompat.getColor(getContext(), R.color.lkui_N900);
        b.e(getContext(), 14.0f);
        goto L6
    }
}
