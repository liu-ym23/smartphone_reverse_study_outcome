package com.larus.livetutor.impl.view;

import android.animation.Animator;
import com.larus.common_ui.venus.ShapeLinearLayout;

/* JADX INFO: loaded from: classes30.dex */
public final class k1 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShapeLinearLayout f356863a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public k1(ShapeLinearLayout r100) {
        this.f356863a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        com.larus.utils.e1.q(this.f356863a);
    }
}
