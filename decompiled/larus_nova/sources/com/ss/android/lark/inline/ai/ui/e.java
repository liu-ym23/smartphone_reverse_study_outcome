package com.ss.android.lark.inline.ai.ui;

import android.animation.Animator;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InlineAIDragView f427492a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public e(InlineAIDragView r100) {
        this.f427492a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Runnable r101 = this.f427492a.T;
        if (r101 == null) goto L5;
        r101.run();
    L5:
        this.f427492a.T = null;
    }
}
