package com.larus.camera.impl.ui.component.result.general;

import android.animation.Animator;

/* JADX INFO: loaded from: classes26.dex */
public final class k implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ResultDetectAnimationView f322306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ResultDetectAnimationView f322307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ResultDetectAnimationView f322308c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f322307b.setImageBitmap(null);
        this.f322307b.setVisibility(4);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f322306a.setImageBitmap(null);
        this.f322306a.setVisibility(4);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f322308c.setVisibility(0);
    }

    public k(ResultDetectAnimationView r100, ResultDetectAnimationView r101, ResultDetectAnimationView r102) {
        this.f322306a = r100;
        this.f322307b = r101;
        this.f322308c = r102;
    }
}
