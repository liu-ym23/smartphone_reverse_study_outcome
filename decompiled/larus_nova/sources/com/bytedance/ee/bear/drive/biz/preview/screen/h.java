package com.bytedance.ee.bear.drive.biz.preview.screen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f223727a;

    public h(k r100) {
        this.f223727a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        View r101 = this.f223727a.f223732c;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
        k r102 = this.f223727a;
        k.j(r102.f223732c, r102.f223735f);
    L5:
        View r103 = this.f223727a.f223731b;
        if (r103 == null) goto L9;
        r103.setVisibility(0);
        k r104 = this.f223727a;
        k.j(r104.f223731b, r104.f223736g);
        return;
    }
}
