package com.ss.android.lark.keyboard.ime;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes36.dex */
public final class o implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImeWrapper f429404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f429405b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        ImeWrapper r101 = this.f429404a;
        ImeWrapper.P(r101, r101.f429362w + 1);
        this.f429405b.invoke(Float.valueOf(0.0f));
    }

    public o(ImeWrapper r100, Function1 r101) {
        this.f429404a = r100;
        this.f429405b = r101;
    }
}
