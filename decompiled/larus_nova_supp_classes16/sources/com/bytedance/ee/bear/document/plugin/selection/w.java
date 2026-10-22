package com.bytedance.ee.bear.document.plugin.selection;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w extends AnimatorListenerAdapter {
    public final /* synthetic */ v a;

    public w(v r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        this.a.h = null;
    }
}
