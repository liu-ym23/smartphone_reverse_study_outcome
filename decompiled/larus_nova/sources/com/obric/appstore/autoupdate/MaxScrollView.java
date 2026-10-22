package com.obric.appstore.autoupdate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes32.dex */
public class MaxScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f385107a;

    public MaxScrollView(Context r100) {
        super(r100);
        this.f385107a = 0;
    }

    public void setMaxHeight(int r100) {
        this.f385107a = r100;
        requestLayout();
    }

    public MaxScrollView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f385107a = 0;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f385107a;
        if (r102 <= 0) goto L5;
        r101 = View.MeasureSpec.makeMeasureSpec(r102, Integer.MIN_VALUE);
    L5:
        super.onMeasure(r100, r101);
    }

    public MaxScrollView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f385107a = 0;
    }
}
