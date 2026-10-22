package com.obric.oui.orecyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes34.dex */
public final class m extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.y f401849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f401850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f401851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f401852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f401853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p f401854f;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        if (this.f401850b == 0) goto L6;
        this.f401851c.setTranslationX(0.0f);
    L6:
        if (this.f401852d == 0) goto L9;
        this.f401851c.setTranslationY(0.0f);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f401853e.setListener(null);
        this.f401854f.c(this.f401849a);
        this.f401854f.f401873p.remove(this.f401849a);
        this.f401854f.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f401854f.getClass();
    }

    public m(p r100, RecyclerView.y r101, int r102, View r103, int r104, ViewPropertyAnimator r105) {
        this.f401854f = r100;
        this.f401849a = r101;
        this.f401850b = r102;
        this.f401851c = r103;
        this.f401852d = r104;
        this.f401853e = r105;
    }
}
