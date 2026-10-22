package com.bytedance.ee.bear.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseItemAnimator.d f240211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f240212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f240213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BaseItemAnimator f240214d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f240212b.setListener(null);
        this.f240213c.setTranslationX(0.0f);
        this.f240213c.setTranslationY(0.0f);
        this.f240214d.dispatchChangeFinished(this.f240211a.f240014b, false);
        this.f240214d.f240006k.remove(this.f240211a.f240014b);
        this.f240214d.dispatchFinishedWhenDone();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f240214d.dispatchChangeStarting(this.f240211a.f240014b, false);
    }

    public g(BaseItemAnimator r100, BaseItemAnimator.d r101, ViewPropertyAnimator r102, View r103) {
        this.f240214d = r100;
        this.f240211a = r101;
        this.f240212b = r102;
        this.f240213c = r103;
    }
}
