package com.bytedance.ee.bear.facade.common.widget;

import android.animation.Animator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Animator.AnimatorListener {
    public final /* synthetic */ CustomTitleView a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    public b(CustomTitleView r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        CustomTitleView r3 = this.a;
        CustomTitleView.b(r3, r3.l);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        CustomTitleView r3 = this.a;
        CustomTitleView.b(r3, r3.l);
    }
}
