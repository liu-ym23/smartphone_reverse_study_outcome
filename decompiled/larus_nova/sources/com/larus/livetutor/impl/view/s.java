package com.larus.livetutor.impl.view;

import android.animation.Animator;

/* JADX INFO: loaded from: classes30.dex */
public final class s implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveTutorContinueButton f356901a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public s(LiveTutorContinueButton r100) {
        this.f356901a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        LiveTutorContinueButton r101 = this.f356901a;
        r101.f356706a.f355937b.setText(r101.f356709d);
    }
}
