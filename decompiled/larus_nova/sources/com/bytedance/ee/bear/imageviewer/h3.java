package com.bytedance.ee.bear.imageviewer;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes16.dex */
public final class h3 implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f226936a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public h3(View r100) {
        this.f226936a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        this.f226936a.setVisibility(8);
    }
}
