package com.ss.android.lark.keyboard.ime;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes36.dex */
public final class r implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImeWrapper f429410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f429411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f429412c;

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
        ImeWrapper r101 = this.f429410a;
        ImeWrapper.P(r101, r101.f429362w + 1);
        b r102 = b.f429377a;
        final int r103 = this.f429411b;
        final int r104 = this.f429412c;
        final ImeWrapper r105 = this.f429410a;
        Function0<String> r106 = new ImeWrapper$startCompatInsetsAnimation$1$1$1(r103, r104, r105);
        r102.getClass();
        b.a("ImeWrapper", r106);
    }

    public r(ImeWrapper r100, int r101, int r102) {
        this.f429410a = r100;
        this.f429411b = r101;
        this.f429412c = r102;
    }
}
