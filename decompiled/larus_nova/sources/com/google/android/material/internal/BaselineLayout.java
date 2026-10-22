package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes23.dex */
public class BaselineLayout extends ViewGroup {
    private int baseline;

    @Override // android.view.View
    public int getBaseline() {
        return this.baseline;
    }

    public BaselineLayout(Context r100) {
        super(r100, null, 0);
        this.baseline = -1;
    }

    public BaselineLayout(Context r100, AttributeSet r101) {
        super(r100, r101, 0);
        this.baseline = -1;
    }

    @Override // android.view.View
    public void onMeasure(int r110, int r111) {
        int r100 = getChildCount();
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
        int r105 = -1;
        int r106 = -1;
    L3:
        if (r101 >= r100) goto L12;
        View r107 = getChildAt(r101);
        if (r107.getVisibility() == 8) goto L11;
        measureChild(r107, r110, r111);
        int r108 = r107.getBaseline();
        if (r108 == (-1)) goto L10;
        r105 = Math.max(r105, r108);
        r106 = Math.max(r106, r107.getMeasuredHeight() - r108);
    L10:
        r103 = Math.max(r103, r107.getMeasuredWidth());
        r102 = Math.max(r102, r107.getMeasuredHeight());
        r104 = View.combineMeasuredStates(r104, r107.getMeasuredState());
    L11:
        r101 = r101 + 1;
        goto L3
    L12:
        if (r105 == (-1)) goto L14;
        r102 = Math.max(r102, Math.max(r106, getPaddingBottom()) + r105);
        this.baseline = r105;
    L14:
        int r109 = Math.max(r102, getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r103, getSuggestedMinimumWidth()), r110, r104), View.resolveSizeAndState(r109, r111, r104 << 16));
    }

    public BaselineLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.baseline = -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        int r103 = getChildCount();
        int r104 = getPaddingLeft();
        int r112 = ((r110 - r101) - getPaddingRight()) - r104;
        int r105 = getPaddingTop();
        int r113 = 0;
    L3:
        if (r113 >= r103) goto L15;
        View r106 = getChildAt(r113);
        if (r106.getVisibility() == 8) goto L14;
        int r107 = r106.getMeasuredWidth();
        int r108 = r106.getMeasuredHeight();
        int r109 = ((r112 - r107) / 2) + r104;
        if (this.baseline != (-1)) goto L10;
    L12:
        int r114 = r105;
    L13:
        r106.layout(r109, r114, r107 + r109, r108 + r114);
        goto L14
    L10:
        if (r106.getBaseline() == (-1)) goto L12;
        r114 = (this.baseline + r105) - r106.getBaseline();
    L14:
        r113 = r113 + 1;
        goto L3
    }
}
