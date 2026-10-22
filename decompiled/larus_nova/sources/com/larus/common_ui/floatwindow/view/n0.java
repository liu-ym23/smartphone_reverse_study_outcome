package com.larus.common_ui.floatwindow.view;

import android.animation.Animator;

/* JADX INFO: loaded from: classes27.dex */
public final class n0 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f327545a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public n0(m0 r100) {
        this.f327545a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        m0 r101 = this.f327545a;
        r101.f327533i = SingleFloatWindowState.MAXIMIZE;
    }
}
