package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes24.dex */
public class AlignParentWidthRelativeLayout extends RelativeLayout {
    public AlignParentWidthRelativeLayout(Context r100) {
        super(r100);
    }

    public AlignParentWidthRelativeLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        int r103 = getChildCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        View r105 = getChildAt(r104);
        if (r105.getVisibility() == 8) goto L7;
        ((RelativeLayout.LayoutParams) r105.getLayoutParams()).width = r102;
    L7:
        r104 = r104 + 1;
        goto L3
    }

    public AlignParentWidthRelativeLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
