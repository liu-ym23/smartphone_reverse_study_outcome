package com.google.android.material.tabs;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;

/* JADX INFO: loaded from: classes23.dex */
public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context r100) {
        this(r100, null);
    }

    public TabItem(Context r100, AttributeSet r101) {
        super(r100, r101);
        TintTypedArray r102 = TintTypedArray.obtainStyledAttributes(r100, r101, new int[]{R.attr.icon, R.attr.layout, R.attr.text});
        this.text = r102.getText(2);
        this.icon = r102.getDrawable(0);
        this.customLayout = r102.getResourceId(1, 0);
        r102.recycle();
    }
}
