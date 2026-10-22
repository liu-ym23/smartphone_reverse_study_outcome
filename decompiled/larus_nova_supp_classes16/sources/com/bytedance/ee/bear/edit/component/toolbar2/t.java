package com.bytedance.ee.bear.edit.component.toolbar2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;

    public t(View r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        this.a.setTranslationX(0.0f);
    }
}
