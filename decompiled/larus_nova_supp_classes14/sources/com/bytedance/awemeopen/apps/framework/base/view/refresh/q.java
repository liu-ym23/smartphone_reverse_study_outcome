package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q implements Animation.AnimationListener {
    public final /* synthetic */ MaterialProgressDrawable.c a;
    public final /* synthetic */ MaterialProgressDrawable b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r5) {
        MaterialProgressDrawable.c r0 = this.a;
        r0.l = r0.e;
        float r1 = r0.f;
        r0.m = r1;
        r0.n = r0.g;
        r0.k = (r0.k + 1) % r0.j.length;
        r0.e = r1;
        r0.a();
        MaterialProgressDrawable r2 = this.b;
        if (r2.j == false) goto L7;
        r2.j = false;
        r5.setDuration(1333);
        MaterialProgressDrawable.c r6 = this.a;
        if (r6.o == false) goto L9;
        r6.o = false;
        r6.a();
        return;
    L9:
        return;
    L7:
        r2.g = (r2.g + 1.0f) % 5.0f;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r2) {
        this.b.g = 0.0f;
    }

    public q(MaterialProgressDrawable r1, MaterialProgressDrawable.c r2) {
        this.b = r1;
        this.a = r2;
    }
}
