package com.bytedance.ies.uikit.refresh;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable.c f249176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable f249177b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
        MaterialProgressDrawable.c r101 = this.f249176a;
        r101.f249162l = r101.f249155e;
        float r102 = r101.f249156f;
        r101.f249163m = r102;
        r101.f249164n = r101.f249157g;
        r101.f249161k = (r101.f249161k + 1) % r101.f249160j.length;
        r101.f249155e = r102;
        r101.a();
        MaterialProgressDrawable r103 = this.f249177b;
        if (r103.f249149j == false) goto L7;
        r103.f249149j = false;
        r100.setDuration(1333);
        MaterialProgressDrawable.c r104 = this.f249176a;
        if (r104.f249165o == false) goto L9;
        r104.f249165o = false;
        r104.a();
        return;
    L9:
        return;
    L7:
        r103.f249146g = (r103.f249146g + 1.0f) % 5.0f;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        this.f249177b.f249146g = 0.0f;
    }

    public b(MaterialProgressDrawable r100, MaterialProgressDrawable.c r101) {
        this.f249177b = r100;
        this.f249176a = r101;
    }
}
