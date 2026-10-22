package com.obric.audio.enroll.ui.fragment;

import android.animation.Animator;
import android.view.View;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes33.dex */
public final class d0 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f395651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f395652b;

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
        this.f395651a.setVisibility(8);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f395652b.setVisibility(0);
    }

    public d0(View r100, View r101) {
        this.f395651a = r100;
        this.f395652b = r101;
    }
}
