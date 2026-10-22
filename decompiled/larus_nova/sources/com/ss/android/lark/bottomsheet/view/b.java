package com.ss.android.lark.bottomsheet.view;

import android.animation.Animator;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC4773a f410756a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public b(com.ss.android.lark.bottomsheet.h r100) {
        this.f410756a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        a.InterfaceC4773a r101 = this.f410756a;
        if (r101 == null) goto L6;
        r101.c();
        return;
    }
}
