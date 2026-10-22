package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes14.dex */
public final class q implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable.c f193450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable f193451b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
        MaterialProgressDrawable.c r101 = this.f193450a;
        r101.f193405l = r101.f193398e;
        float r102 = r101.f193399f;
        r101.f193406m = r102;
        r101.f193407n = r101.f193400g;
        r101.f193404k = (r101.f193404k + 1) % r101.f193403j.length;
        r101.f193398e = r102;
        r101.a();
        MaterialProgressDrawable r103 = this.f193451b;
        if (r103.f193392j == false) goto L7;
        r103.f193392j = false;
        r100.setDuration(1333);
        MaterialProgressDrawable.c r104 = this.f193450a;
        if (r104.f193408o == false) goto L9;
        r104.f193408o = false;
        r104.a();
        return;
    L9:
        return;
    L7:
        r103.f193389g = (r103.f193389g + 1.0f) % 5.0f;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        this.f193451b.f193389g = 0.0f;
    }

    public q(MaterialProgressDrawable r100, MaterialProgressDrawable.c r101) {
        this.f193451b = r100;
        this.f193450a = r101;
    }
}
