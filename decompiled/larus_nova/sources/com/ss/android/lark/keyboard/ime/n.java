package com.ss.android.lark.keyboard.ime;

import android.animation.Animator;
import android.animation.ValueAnimator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes36.dex */
public final class n implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImeWrapper f429401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f429402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f429403c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        ImeWrapper r101 = this.f429401a;
        ImeWrapper.P(r101, r101.f429362w - 1);
        this.f429402b.invoke(Float.valueOf(1000.0f));
        this.f429401a.setTranslationY(0.0f);
        this.f429401a.A.remove(this.f429403c);
    }

    public n(ImeWrapper r100, Function1 r101, ValueAnimator r102) {
        this.f429401a = r100;
        this.f429402b = r101;
        this.f429403c = r102;
    }
}
