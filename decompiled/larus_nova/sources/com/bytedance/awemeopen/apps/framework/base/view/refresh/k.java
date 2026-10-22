package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes14.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f193433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoadMoreFrameLayout f193434b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        float r101 = r100.getAnimatedFraction();
        int r102 = LoadMoreFrameLayout.a(this.f193434b);
        LoadMoreFrameLayout r103 = this.f193434b;
        if (r101 != 1.0f) goto L5;
        int r104 = -(r102 + r103.f193358m);
    L6:
        LoadMoreFrameLayout.b(r103, r104);
        return;
    L5:
        double r105 = 1.0d - Math.pow(r101, 3.0d);
        int r106 = this.f193433a;
        LoadMoreFrameLayout r107 = this.f193434b;
        r104 = (int) ((r105 * ((double) (r106 + r107.f193358m))) - ((double) (LoadMoreFrameLayout.a(r107) + this.f193434b.f193358m)));
        goto L6
    }

    public k(LoadMoreFrameLayout r100, int r101) {
        this.f193434b = r100;
        this.f193433a = r101;
    }
}
