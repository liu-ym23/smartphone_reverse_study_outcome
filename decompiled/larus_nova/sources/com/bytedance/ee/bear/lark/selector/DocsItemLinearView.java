package com.bytedance.ee.bear.lark.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes16.dex */
public class DocsItemLinearView extends LinearLayout {
    public DocsItemLinearView(Context r100) {
        super(r100);
    }

    public static HorizontalScrollView a(View r100) {
        Object r101 = r100.getParent();
        if (r101 != null) goto L5;
    L12:
        return null;
    L5:
        if ((r101 instanceof HorizontalScrollView) == false) goto L9;
        return (HorizontalScrollView) r101;
    L9:
        if ((r101 instanceof View) == false) goto L12;
        return a((View) r101);
    }

    public DocsItemLinearView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r100), 0), r101);
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        HorizontalScrollView r104 = a(this);
        if (r104 == null) goto L6;
        setMeasuredDimension(Math.max(r104.getMeasuredWidth() + r104.getScrollX(), r102), r103);
        return;
    }

    public DocsItemLinearView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
