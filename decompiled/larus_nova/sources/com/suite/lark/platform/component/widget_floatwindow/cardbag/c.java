package com.suite.lark.platform.component.widget_floatwindow.cardbag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f461173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f461174b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        super.onAnimationCancel(r100);
        e.a r101 = this.f461173a;
        if (r101 != null) goto L5;
        return;
    L5:
        ((DialogAnimationLayout.a) r101).a();
        e.a(this.f461174b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        super.onAnimationEnd(r100);
        e.a r101 = this.f461173a;
        if (r101 != null) goto L5;
        return;
    L5:
        ((DialogAnimationLayout.a) r101).a();
        e.a(this.f461174b);
    }

    public c(DialogAnimationLayout.a r100, DialogAnimationLayout r101) {
        this.f461173a = r100;
        this.f461174b = r101;
    }
}
