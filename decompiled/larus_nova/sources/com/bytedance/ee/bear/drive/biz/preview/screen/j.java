package com.bytedance.ee.bear.drive.biz.preview.screen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f223729a;

    public j(k r100) {
        this.f223729a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        View r101 = this.f223729a.f223732c;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        View r102 = this.f223729a.f223731b;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
        return;
    }
}
