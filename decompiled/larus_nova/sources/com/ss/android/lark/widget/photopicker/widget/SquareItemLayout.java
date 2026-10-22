package com.ss.android.lark.widget.photopicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes38.dex */
public class SquareItemLayout extends RelativeLayout {
    public SquareItemLayout(Context r100) {
        super(r100);
    }

    public SquareItemLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(RelativeLayout.getDefaultSize(0, r100), RelativeLayout.getDefaultSize(0, r101));
        int r102 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        super.onMeasure(r102, r102);
    }

    public SquareItemLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
