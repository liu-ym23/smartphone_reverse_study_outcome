package com.larus.voicecall.impl.utils;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f379528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f379529b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        this.f379528a.setVisibility(4);
        if (this.f379529b.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        c.b(this.f379529b);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public b(View r100, View r101) {
        this.f379528a = r100;
        this.f379529b = r101;
    }
}
