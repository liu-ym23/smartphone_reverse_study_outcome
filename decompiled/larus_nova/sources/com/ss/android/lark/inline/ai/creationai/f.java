package com.ss.android.lark.inline.ai.creationai;

import android.animation.Animator;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationAIDragView f427104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f427105b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        CreationAIDragView.b(this.f427104a);
        if (this.f427105b == false) goto L9;
        CreationAIDragView r101 = this.f427104a;
        if (r101.B == false) goto L7;
        r101.f426924e.c();
        return;
    L7:
        r101.f426924e.onClose();
        return;
    }

    public f(CreationAIDragView r100, boolean r101) {
        this.f427104a = r100;
        this.f427105b = r101;
    }
}
