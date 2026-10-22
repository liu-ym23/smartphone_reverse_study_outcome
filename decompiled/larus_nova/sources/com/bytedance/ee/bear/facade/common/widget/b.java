package com.bytedance.ee.bear.facade.common.widget;

import android.animation.Animator;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomTitleView f226581a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public b(CustomTitleView r100) {
        this.f226581a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        CustomTitleView r101 = this.f226581a;
        CustomTitleView.b(r101, r101.f226463l);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        CustomTitleView r101 = this.f226581a;
        CustomTitleView.b(r101, r101.f226463l);
    }
}
