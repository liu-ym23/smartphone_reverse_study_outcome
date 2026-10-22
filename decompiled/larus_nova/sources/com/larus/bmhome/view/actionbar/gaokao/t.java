package com.larus.bmhome.view.actionbar.gaokao;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes26.dex */
public final class t implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f316800a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    public t(View r100) {
        this.f316800a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        this.f316800a.setVisibility(0);
    }
}
