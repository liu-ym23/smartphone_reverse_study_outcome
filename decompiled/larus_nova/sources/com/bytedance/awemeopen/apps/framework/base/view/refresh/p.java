package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes14.dex */
public final class p extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable.c f193448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialProgressDrawable f193449b;

    public p(MaterialProgressDrawable r100, MaterialProgressDrawable.c r101) {
        this.f193449b = r100;
        this.f193448a = r101;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        if (this.f193449b.f193392j == false) goto L5;
        MaterialProgressDrawable.c r102 = this.f193448a;
        float r103 = (float) (Math.floor(r102.f193407n / 0.8f) + 1.0d);
        float r104 = r102.f193405l;
        r102.f193398e = r104 + ((r102.f193406m - r104) * r100);
        r102.a();
        float r105 = r102.f193407n;
        r102.f193400g = r105 + ((r103 - r105) * r100);
        r102.a();
        return;
    L5:
        MaterialProgressDrawable.c r106 = this.f193448a;
        float r107 = (float) Math.toRadians(((double) r106.f193401h) / (r106.f193411r * 6.283185307179586d));
        MaterialProgressDrawable.c r108 = this.f193448a;
        float r109 = r108.f193406m;
        float r110 = r108.f193405l;
        float r111 = r108.f193407n;
        float r112 = r109 + ((0.8f - r107) * MaterialProgressDrawable.f193382m.getInterpolation(r100));
        MaterialProgressDrawable.c r113 = this.f193448a;
        r113.f193399f = r112;
        r113.a();
        float r114 = r110 + (MaterialProgressDrawable.f193381l.getInterpolation(r100) * 0.8f);
        MaterialProgressDrawable.c r115 = this.f193448a;
        r115.f193398e = r114;
        r115.a();
        MaterialProgressDrawable.c r116 = this.f193448a;
        r116.f193400g = r111 + (0.25f * r100);
        r116.a();
        MaterialProgressDrawable r117 = this.f193449b;
        r117.f193385c = (r100 * 144.0f) + ((r117.f193389g / 5.0f) * 720.0f);
        r117.invalidateSelf();
    }
}
