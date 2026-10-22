package com.obric.oui.orecyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes34.dex */
public final class k extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.y f401841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f401842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f401843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f401844d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f401843c.setListener(null);
        this.f401842b.setAlpha(1.0f);
        this.f401844d.c(this.f401841a);
        this.f401844d.f401874q.remove(this.f401841a);
        this.f401842b.animate().setInterpolator(p.f401863s);
        this.f401844d.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f401844d.getClass();
        this.f401842b.animate().setInterpolator(p.f401863s);
    }

    public k(p r100, RecyclerView.y r101, View r102, ViewPropertyAnimator r103) {
        this.f401844d = r100;
        this.f401841a = r101;
        this.f401842b = r102;
        this.f401843c = r103;
    }
}
