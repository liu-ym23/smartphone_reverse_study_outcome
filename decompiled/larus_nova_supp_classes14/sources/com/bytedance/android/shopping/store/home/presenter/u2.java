package com.bytedance.android.shopping.store.home.presenter;

import android.animation.Animator;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u2 implements Animator.AnimatorListener {
    public final /* synthetic */ t2 a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    public u2(t2 r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ViewGroup r3 = this.a.y;
        if (r3 == null) goto L6;
        r3.setVisibility(8);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ViewGroup r3 = this.a.y;
        if (r3 == null) goto L6;
        r3.setVisibility(8);
        return;
    }
}
