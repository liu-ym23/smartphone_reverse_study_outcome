package com.bytedance.ee.bear.drive.biz.comment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class z0 extends AnimatorListenerAdapter {
    public final /* synthetic */ a1 a;

    public z0(a1 r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1) {
        super.onAnimationEnd(r1);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        a1.i r0 = this.a.w;
        if (r0 == null) goto L5;
        r0.a(false, false);
    L5:
        super.onAnimationStart(r3);
    }
}
