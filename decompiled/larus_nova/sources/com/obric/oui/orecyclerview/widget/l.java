package com.obric.oui.orecyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes34.dex */
public final class l extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.y f401845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f401846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f401847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f401848d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f401846b.setAlpha(1.0f);
        this.f401846b.animate().setInterpolator(p.f401863s);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f401847c.setListener(null);
        this.f401848d.c(this.f401845a);
        this.f401848d.f401872o.remove(this.f401845a);
        this.f401846b.animate().setInterpolator(p.f401863s);
        this.f401848d.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f401848d.getClass();
    }

    public l(p r100, RecyclerView.y r101, View r102, ViewPropertyAnimator r103) {
        this.f401848d = r100;
        this.f401845a = r101;
        this.f401846b = r102;
        this.f401847c = r103;
    }
}
