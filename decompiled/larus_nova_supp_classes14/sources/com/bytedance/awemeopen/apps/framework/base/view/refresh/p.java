package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p extends Animation {
    public final /* synthetic */ MaterialProgressDrawable.c a;
    public final /* synthetic */ MaterialProgressDrawable b;

    public p(MaterialProgressDrawable r1, MaterialProgressDrawable.c r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r8, Transformation r9) {
        if (this.b.j == false) goto L5;
        MaterialProgressDrawable.c r10 = this.a;
        float r0 = (float) (Math.floor(r10.n / 0.8f) + 1.0d);
        float r1 = r10.l;
        r10.e = r1 + ((r10.m - r1) * r8);
        r10.a();
        float r2 = r10.n;
        r10.g = r2 + ((r0 - r2) * r8);
        r10.a();
        return;
    L5:
        MaterialProgressDrawable.c r11 = this.a;
        float r12 = (float) Math.toRadians(((double) r11.h) / (r11.r * 6.283185307179586d));
        MaterialProgressDrawable.c r3 = this.a;
        float r4 = r3.m;
        float r5 = r3.l;
        float r6 = r3.n;
        float r7 = r4 + ((0.8f - r12) * MaterialProgressDrawable.m.getInterpolation(r8));
        MaterialProgressDrawable.c r13 = this.a;
        r13.f = r7;
        r13.a();
        float r14 = r5 + (MaterialProgressDrawable.l.getInterpolation(r8) * 0.8f);
        MaterialProgressDrawable.c r15 = this.a;
        r15.e = r14;
        r15.a();
        MaterialProgressDrawable.c r16 = this.a;
        r16.g = r6 + (0.25f * r8);
        r16.a();
        MaterialProgressDrawable r17 = this.b;
        r17.c = (r8 * 144.0f) + ((r17.g / 5.0f) * 720.0f);
        r17.invalidateSelf();
    }
}
