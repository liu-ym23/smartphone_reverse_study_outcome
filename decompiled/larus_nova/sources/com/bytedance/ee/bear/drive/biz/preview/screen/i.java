package com.bytedance.ee.bear.drive.biz.preview.screen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f223728a;

    public i(k r100) {
        this.f223728a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        View r101 = this.f223728a.f223732c;
        if (r101 == null) goto L5;
        r101.setVisibility(4);
    L5:
        View r102 = this.f223728a.f223731b;
        if (r102 == null) goto L9;
        r102.setVisibility(8);
        return;
    }
}
