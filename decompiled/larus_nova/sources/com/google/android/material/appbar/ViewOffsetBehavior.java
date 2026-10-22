package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes23.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private ViewOffsetHelper viewOffsetHelper;

    public int getLeftAndRightOffset() {
        ViewOffsetHelper r100 = this.viewOffsetHelper;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getLeftAndRightOffset();
    }

    public int getTopAndBottomOffset() {
        ViewOffsetHelper r100 = this.viewOffsetHelper;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getTopAndBottomOffset();
    }

    public ViewOffsetBehavior() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public boolean setLeftAndRightOffset(int r100) {
        ViewOffsetHelper r101 = this.viewOffsetHelper;
        if (r101 != null) goto L5;
        this.tempLeftRightOffset = r100;
        return false;
    L5:
        return r101.setLeftAndRightOffset(r100);
    }

    public boolean setTopAndBottomOffset(int r100) {
        ViewOffsetHelper r101 = this.viewOffsetHelper;
        if (r101 != null) goto L5;
        this.tempTopBottomOffset = r100;
        return false;
    L5:
        return r101.setTopAndBottomOffset(r100);
    }

    public ViewOffsetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public void layoutChild(CoordinatorLayout r100, V r101, int r102) {
        r100.onLayoutChild(r101, r102);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        layoutChild(r100, r101, r102);
        if (this.viewOffsetHelper != null) goto L5;
        this.viewOffsetHelper = new ViewOffsetHelper(r101);
    L5:
        this.viewOffsetHelper.onViewLayout();
        int r103 = this.tempTopBottomOffset;
        if (r103 == 0) goto L8;
        this.viewOffsetHelper.setTopAndBottomOffset(r103);
        this.tempTopBottomOffset = 0;
    L8:
        int r104 = this.tempLeftRightOffset;
        if (r104 == 0) goto L13;
        this.viewOffsetHelper.setLeftAndRightOffset(r104);
        this.tempLeftRightOffset = 0;
        return true;
    L13:
        return true;
    }
}
