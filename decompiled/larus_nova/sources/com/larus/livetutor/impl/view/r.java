package com.larus.livetutor.impl.view;

import android.animation.Animator;

/* JADX INFO: loaded from: classes30.dex */
public final class r implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveTutorContinueButton f356897a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    public r(LiveTutorContinueButton r100) {
        this.f356897a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        com.larus.utils.e1.x(this.f356897a);
    }
}
