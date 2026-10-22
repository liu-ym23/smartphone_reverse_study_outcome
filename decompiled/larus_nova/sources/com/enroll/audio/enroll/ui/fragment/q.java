package com.enroll.audio.enroll.ui.fragment;

import android.animation.Animator;
import android.view.View;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes22.dex */
public final class q implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f273886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f273887b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        FLogger.f375446a.i("EnrollStageView", "animator cancel");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        FLogger.f375446a.i("EnrollStageView", "animator end");
        this.f273886a.setVisibility(8);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f273887b.setVisibility(0);
    }

    public q(View r100, View r101) {
        this.f273886a = r100;
        this.f273887b = r101;
    }
}
