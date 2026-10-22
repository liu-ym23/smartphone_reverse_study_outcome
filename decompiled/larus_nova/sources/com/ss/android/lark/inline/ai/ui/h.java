package com.ss.android.lark.inline.ai.ui;

import android.animation.Animator;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InlineAIDragView f427505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f427506b;

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
        InlineAIDragView.b(this.f427505a);
        if (this.f427506b == false) goto L9;
        InlineAIDragView r101 = this.f427505a;
        if (r101.A == false) goto L7;
        r101.f427358e.c();
        return;
    L7:
        r101.f427358e.onClose();
        return;
    }

    public h(InlineAIDragView r100, boolean r101) {
        this.f427505a = r100;
        this.f427506b = r101;
    }
}
