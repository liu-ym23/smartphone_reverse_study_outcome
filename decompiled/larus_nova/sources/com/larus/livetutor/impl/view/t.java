package com.larus.livetutor.impl.view;

import android.animation.Animator;

/* JADX INFO: loaded from: classes30.dex */
public final class t implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveTutorContinueButton f356905a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    public t(LiveTutorContinueButton r100) {
        this.f356905a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f356905a.f356706a.f355937b.setText("");
    }
}
