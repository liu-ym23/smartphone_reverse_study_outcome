package com.larus.livetutor.impl.tutor.controller;

import android.animation.Animator;
import com.airbnb.lottie.LottieAnimationView;

/* JADX INFO: loaded from: classes30.dex */
public final class h implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveTutorAnimController f356489a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    public h(LiveTutorAnimController r100) {
        this.f356489a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        LottieAnimationView r101 = this.f356489a.f356431c;
        if (r101 == null) goto L5;
        j19.c.f(r101);
        r101.setRepeatCount(0);
        r101.playAnimation();
    L5:
        kj9.b.a("[LiveTutorAnimController] startTransitionAnim start");
    }
}
