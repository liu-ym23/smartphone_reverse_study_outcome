package com.larus.camera.impl.widget;

import android.animation.Animator;

/* JADX INFO: loaded from: classes26.dex */
public final class m implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EduPreviewLoadingView f322919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EduPreviewLoadingView f322920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EduPreviewLoadingView f322921c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f322920b.setImageBitmap(null);
        this.f322920b.setVisibility(4);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f322919a.setImageBitmap(null);
        this.f322919a.setVisibility(4);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f322921c.setVisibility(0);
    }

    public m(EduPreviewLoadingView r100, EduPreviewLoadingView r101, EduPreviewLoadingView r102) {
        this.f322919a = r100;
        this.f322920b = r101;
        this.f322921c = r102;
    }
}
