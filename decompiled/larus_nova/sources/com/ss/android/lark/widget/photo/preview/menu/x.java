package com.ss.android.lark.widget.photo.preview.menu;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes38.dex */
public final class x implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f447021a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public x(View r100) {
        this.f447021a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        this.f447021a.setVisibility(8);
    }
}
