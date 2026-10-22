package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s implements Animation.AnimationListener {
    public final /* synthetic */ Animation.AnimationListener a;
    public final /* synthetic */ t b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        Animation.AnimationListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.onAnimationEnd(r2);
    L5:
        this.b.b(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r2) {
        Animation.AnimationListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onAnimationRepeat(r2);
        return;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r2) {
        Animation.AnimationListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onAnimationStart(r2);
        return;
    }

    public s(DoubleBallSwipeRefreshLayout.e r1, DoubleBallSwipeRefreshLayout.b r2) {
        this.b = r1;
        this.a = r2;
    }
}
