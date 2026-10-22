package com.bytedance.ee.bear.middleground.comment.card;

import android.animation.Animator;
import android.animation.AnimatorSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l0 implements Animator.AnimatorListener {
    public final /* synthetic */ HalfScreenCardComment a;
    public final /* synthetic */ AnimatorSet b;
    public final /* synthetic */ AnimatorSet c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        this.a.v.setVisibility(8);
        this.c.removeAllListeners();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        this.a.v.setVisibility(8);
        this.b.removeAllListeners();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        this.a.v.setVisibility(0);
    }

    public l0(HalfScreenCardComment r1, AnimatorSet r2, AnimatorSet r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
