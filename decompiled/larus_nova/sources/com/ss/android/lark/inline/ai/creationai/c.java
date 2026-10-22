package com.ss.android.lark.inline.ai.creationai;

import android.animation.Animator;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationAIDragView f427048a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public c(CreationAIDragView r100) {
        this.f427048a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Runnable r101 = this.f427048a.T;
        if (r101 == null) goto L5;
        r101.run();
    L5:
        this.f427048a.T = null;
    }
}
