package com.bytedance.ies.uikit.refresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable.c f249174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable f249175b;

    public a(MaterialProgressDrawable r100, MaterialProgressDrawable.c r101) {
        this.f249175b = r100;
        this.f249174a = r101;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        if (this.f249175b.f249149j == false) goto L5;
        MaterialProgressDrawable.c r102 = this.f249174a;
        float r103 = (float) (Math.floor(r102.f249164n / 0.8f) + 1.0d);
        float r104 = r102.f249162l;
        r102.f249155e = r104 + ((r102.f249163m - r104) * r100);
        r102.a();
        float r105 = r102.f249164n;
        r102.f249157g = r105 + ((r103 - r105) * r100);
        r102.a();
        return;
    L5:
        MaterialProgressDrawable.c r106 = this.f249174a;
        float r107 = (float) Math.toRadians(((double) r106.f249158h) / (r106.f249168r * 6.283185307179586d));
        MaterialProgressDrawable.c r108 = this.f249174a;
        float r109 = r108.f249163m;
        float r110 = r108.f249162l;
        float r111 = r108.f249164n;
        float r112 = r109 + ((0.8f - r107) * MaterialProgressDrawable.f249139m.getInterpolation(r100));
        MaterialProgressDrawable.c r113 = this.f249174a;
        r113.f249156f = r112;
        r113.a();
        float r114 = r110 + (MaterialProgressDrawable.f249138l.getInterpolation(r100) * 0.8f);
        MaterialProgressDrawable.c r115 = this.f249174a;
        r115.f249155e = r114;
        r115.a();
        MaterialProgressDrawable.c r116 = this.f249174a;
        r116.f249157g = r111 + (0.25f * r100);
        r116.a();
        MaterialProgressDrawable r117 = this.f249175b;
        r117.f249142c = (r100 * 144.0f) + ((r117.f249146g / 5.0f) * 720.0f);
        r117.invalidateSelf();
    }
}
