package com.bytedance.ee.bear.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseItemAnimator.d f240207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f240208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f240209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BaseItemAnimator f240210d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f240208b.setListener(null);
        this.f240209c.setTranslationX(0.0f);
        this.f240209c.setTranslationY(0.0f);
        this.f240210d.dispatchChangeFinished(this.f240207a.f240013a, true);
        this.f240210d.f240006k.remove(this.f240207a.f240013a);
        this.f240210d.dispatchFinishedWhenDone();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f240210d.dispatchChangeStarting(this.f240207a.f240013a, true);
    }

    public f(BaseItemAnimator r100, BaseItemAnimator.d r101, ViewPropertyAnimator r102, View r103) {
        this.f240210d = r100;
        this.f240207a = r101;
        this.f240208b = r102;
        this.f240209c = r103;
    }
}
