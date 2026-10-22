package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes18.dex */
public class MaxHeightLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f240107a;

    public MaxHeightLayout(Context r100) {
        super(r100);
    }

    public void setMaxHeight(int r100) {
        this.f240107a = r100;
    }

    public MaxHeightLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r101);
        int r103 = View.MeasureSpec.getSize(r101);
        int r104 = this.f240107a;
        if (r103 <= r104) goto L6;
        r103 = r104;
    L6:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(r103, r102));
    }

    public MaxHeightLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
