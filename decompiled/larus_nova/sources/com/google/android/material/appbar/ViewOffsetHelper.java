package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes23.dex */
class ViewOffsetHelper {
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;
    private final View view;

    private void updateOffsets() {
        View r100 = this.view;
        ViewCompat.offsetTopAndBottom(r100, this.offsetTop - (r100.getTop() - this.layoutTop));
        View r101 = this.view;
        ViewCompat.offsetLeftAndRight(r101, this.offsetLeft - (r101.getLeft() - this.layoutLeft));
    }

    public void onViewLayout() {
        this.layoutTop = this.view.getTop();
        this.layoutLeft = this.view.getLeft();
        updateOffsets();
    }

    public int getLayoutLeft() {
        return this.layoutLeft;
    }

    public int getLayoutTop() {
        return this.layoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    public ViewOffsetHelper(View r100) {
        this.view = r100;
    }

    public boolean setLeftAndRightOffset(int r100) {
        if (this.offsetLeft == r100) goto L6;
        this.offsetLeft = r100;
        updateOffsets();
        return true;
    L6:
        return false;
    }

    public boolean setTopAndBottomOffset(int r100) {
        if (this.offsetTop == r100) goto L6;
        this.offsetTop = r100;
        updateOffsets();
        return true;
    L6:
        return false;
    }
}
