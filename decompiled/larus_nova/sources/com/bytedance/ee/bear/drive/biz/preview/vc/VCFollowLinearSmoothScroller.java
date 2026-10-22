package com.bytedance.ee.bear.drive.biz.preview.vc;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;

/* JADX INFO: loaded from: classes16.dex */
public class VCFollowLinearSmoothScroller extends LinearSmoothScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f223793a;

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int getVerticalSnapPreference() {
        return -1;
    }

    public VCFollowLinearSmoothScroller(Context r100) {
        super(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void setTargetPosition(int r100) {
        super.setTargetPosition(r100);
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateDtToFit(int r100, int r101, int r102, int r103, int r104) {
        if (r100 < r102) goto L4;
        if (r100 <= r102) goto L9;
        return (this.f223793a + r102) - r100;
    L9:
        return this.f223793a;
    L4:
        return (r102 - r100) + this.f223793a;
    }
}
