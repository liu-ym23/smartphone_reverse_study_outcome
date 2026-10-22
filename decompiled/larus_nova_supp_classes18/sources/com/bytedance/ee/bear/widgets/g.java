package com.bytedance.ee.bear.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends AnimatorListenerAdapter {
    public final /* synthetic */ BaseItemAnimator.d a;
    public final /* synthetic */ ViewPropertyAnimator b;
    public final /* synthetic */ View c;
    public final /* synthetic */ BaseItemAnimator d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        this.b.setListener(null);
        this.c.setTranslationX(0.0f);
        this.c.setTranslationY(0.0f);
        this.d.dispatchChangeFinished(this.a.b, false);
        this.d.k.remove(this.a.b);
        this.d.dispatchFinishedWhenDone();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        this.d.dispatchChangeStarting(this.a.b, false);
    }

    public g(BaseItemAnimator r1, BaseItemAnimator.d r2, ViewPropertyAnimator r3, View r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
