package com.larksuite.component.card.plugin.select;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;

/* JADX INFO: loaded from: classes24.dex */
public class CenterSmoothScroller extends LinearSmoothScroller {
    public CenterSmoothScroller(Context r100) {
        super(r100);
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final float calculateSpeedPerPixel(DisplayMetrics r100) {
        return 100.0f / r100.densityDpi;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateDtToFit(int r100, int r101, int r102, int r103, int r104) {
        return (r102 + ((r103 - r102) / 2)) - (r100 + ((r101 - r100) / 2));
    }
}
