package com.bytedance.ee.bear.lark.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocsItemLinearView extends LinearLayout {
    public DocsItemLinearView(Context r1) {
        super(r1);
    }

    public static HorizontalScrollView a(View r2) {
        Object r3 = r2.getParent();
        if (r3 != null) goto L5;
    L12:
        return null;
    L5:
        if ((r3 instanceof HorizontalScrollView) == false) goto L9;
        return (HorizontalScrollView) r3;
    L9:
        if ((r3 instanceof View) == false) goto L12;
        return a((View) r3);
    }

    public DocsItemLinearView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r3), 0), r4);
        int r5 = getMeasuredWidth();
        int r6 = getMeasuredHeight();
        HorizontalScrollView r0 = a(this);
        if (r0 == null) goto L6;
        setMeasuredDimension(Math.max(r0.getMeasuredWidth() + r0.getScrollX(), r5), r6);
        return;
    }

    public DocsItemLinearView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
