package com.ss.android.lark.chat.message.menu.v2;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes35.dex */
public final class c0 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f415719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b0 f415720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f415721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f415722d;

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
        this.f415719a.invoke();
        b0 r101 = this.f415720b;
        float r102 = r101.f415697g + (this.f415721c - this.f415722d);
        r101.f415697g = r102;
        r101.f415693c.setTranslationY(r101.f415704n - r102);
    }

    public c0(Function0 r100, b0 r101, float r102, int r103) {
        this.f415719a = r100;
        this.f415720b = r101;
        this.f415721c = r102;
        this.f415722d = r103;
    }
}
