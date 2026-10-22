package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes25.dex */
public class AtMostHeightFrameLayout extends FrameLayout {
    public AtMostHeightFrameLayout(Context r100) {
        super(r100);
    }

    public AtMostHeightFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public AtMostHeightFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
