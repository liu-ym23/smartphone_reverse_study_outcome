package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ LoadMoreFrameLayout b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r7) {
        float r8 = r7.getAnimatedFraction();
        int r0 = LoadMoreFrameLayout.a(this.b);
        LoadMoreFrameLayout r1 = this.b;
        if (r8 != 1.0f) goto L5;
        int r9 = -(r0 + r1.m);
    L6:
        LoadMoreFrameLayout.b(r1, r9);
        return;
    L5:
        double r4 = 1.0d - Math.pow(r8, 3.0d);
        int r10 = this.a;
        LoadMoreFrameLayout r2 = this.b;
        r9 = (int) ((r4 * ((double) (r10 + r2.m))) - ((double) (LoadMoreFrameLayout.a(r2) + this.b.m)));
        goto L6
    }

    public k(LoadMoreFrameLayout r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
