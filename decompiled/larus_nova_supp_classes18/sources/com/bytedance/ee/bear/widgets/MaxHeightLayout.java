package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MaxHeightLayout extends FrameLayout {
    public int a;

    public MaxHeightLayout(Context r1) {
        super(r1);
    }

    public void setMaxHeight(int r1) {
        this.a = r1;
    }

    public MaxHeightLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        int r0 = View.MeasureSpec.getMode(r4);
        int r5 = View.MeasureSpec.getSize(r4);
        int r1 = this.a;
        if (r5 <= r1) goto L6;
        r5 = r1;
    L6:
        super.onMeasure(r3, View.MeasureSpec.makeMeasureSpec(r5, r0));
    }

    public MaxHeightLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
