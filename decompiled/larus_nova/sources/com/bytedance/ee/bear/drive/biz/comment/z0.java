package com.bytedance.ee.bear.drive.biz.comment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes16.dex */
public final class z0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f222837a;

    public z0(a1 r100) {
        this.f222837a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        super.onAnimationEnd(r100);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        a1.i r101 = this.f222837a.f222694w;
        if (r101 == null) goto L5;
        r101.a(false, false);
    L5:
        super.onAnimationStart(r100);
    }
}
