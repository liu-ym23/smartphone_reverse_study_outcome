package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes14.dex */
public final class s implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animation.AnimationListener f193452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f193453b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        Animation.AnimationListener r101 = this.f193452a;
        if (r101 == null) goto L5;
        r101.onAnimationEnd(r100);
    L5:
        this.f193453b.b(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
        Animation.AnimationListener r101 = this.f193452a;
        if (r101 == null) goto L6;
        r101.onAnimationRepeat(r100);
        return;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        Animation.AnimationListener r101 = this.f193452a;
        if (r101 == null) goto L6;
        r101.onAnimationStart(r100);
        return;
    }

    public s(DoubleBallSwipeRefreshLayout.e r100, DoubleBallSwipeRefreshLayout.b r101) {
        this.f193453b = r100;
        this.f193452a = r101;
    }
}
