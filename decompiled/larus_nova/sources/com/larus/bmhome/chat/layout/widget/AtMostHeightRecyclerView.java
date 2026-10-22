package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes25.dex */
public class AtMostHeightRecyclerView extends RecyclerView {
    public AtMostHeightRecyclerView(Context r100) {
        super(r100);
    }

    public AtMostHeightRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (getVisibility() != 8) goto L5;
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(0, 1073741824));
        return;
    L5:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public AtMostHeightRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
