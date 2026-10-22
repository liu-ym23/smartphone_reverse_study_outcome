package com.obric.oui.orecyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes34.dex */
public final class n extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p.a f401855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f401856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f401857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f401858d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f401856b.setListener(null);
        this.f401857c.setAlpha(1.0f);
        this.f401857c.setTranslationX(0.0f);
        this.f401857c.setTranslationY(0.0f);
        this.f401858d.c(this.f401855a.f401876a);
        this.f401858d.f401875r.remove(this.f401855a.f401876a);
        this.f401858d.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        p r101 = this.f401858d;
        RecyclerView.y r102 = this.f401855a.f401876a;
        r101.getClass();
    }

    public n(p r100, p.a r101, ViewPropertyAnimator r102, View r103) {
        this.f401858d = r100;
        this.f401855a = r101;
        this.f401856b = r102;
        this.f401857c = r103;
    }
}
