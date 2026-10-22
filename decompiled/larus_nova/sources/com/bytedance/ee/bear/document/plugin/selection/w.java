package com.bytedance.ee.bear.document.plugin.selection;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes16.dex */
public final class w extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f220995a;

    public w(v r100) {
        this.f220995a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f220995a.f220969h = null;
    }
}
