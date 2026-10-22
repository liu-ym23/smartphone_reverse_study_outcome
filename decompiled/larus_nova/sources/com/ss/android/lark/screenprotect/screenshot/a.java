package com.ss.android.lark.screenprotect.screenshot;

import android.animation.Animator;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenshotPreviewActivity f439814a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public a(ScreenshotPreviewActivity r100) {
        this.f439814a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f439814a.finish();
    }
}
