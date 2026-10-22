package com.obric.oui.orecyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes34.dex */
public final class o extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p.a f401859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f401860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f401861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f401862d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f401860b.setListener(null);
        this.f401861c.setAlpha(1.0f);
        this.f401861c.setTranslationX(0.0f);
        this.f401861c.setTranslationY(0.0f);
        this.f401862d.c(this.f401859a.f401877b);
        this.f401862d.f401875r.remove(this.f401859a.f401877b);
        this.f401862d.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        p r101 = this.f401862d;
        RecyclerView.y r102 = this.f401859a.f401877b;
        r101.getClass();
    }

    public o(p r100, p.a r101, ViewPropertyAnimator r102, View r103) {
        this.f401862d = r100;
        this.f401859a = r101;
        this.f401860b = r102;
        this.f401861c = r103;
    }
}
