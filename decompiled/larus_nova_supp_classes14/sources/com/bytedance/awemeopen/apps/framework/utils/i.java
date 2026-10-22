package com.bytedance.awemeopen.apps.framework.utils;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements TypeEvaluator<PointF> {
    public final PointF a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;

    public i(PointF r6, PointF r7) {
        this.a = new PointF();
        float r0 = r6.x * 3.0f;
        float r2 = r7.x * 3.0f;
        this.b = r0 - r2;
        this.c = r2 - (r0 * 2.0f);
        this.d = r0;
        float r8 = r6.y * 3.0f;
        float r9 = r7.y * 3.0f;
        this.e = r8 - r9;
        this.f = r9 - (2.0f * r8);
        this.g = r8;
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r7, PointF r8, PointF r9) {
        PointF r10 = r8;
        PointF r11 = r9;
        float r0 = r10.x;
        float r2 = r0 * 3.0f;
        float r12 = r10.y;
        float r1 = 3.0f * r12;
        PointF r3 = this.a;
        r3.x = (((((((((r11.x - r0) + this.b) * r7) + r2) + this.c) * r7) - r2) + this.d) * r7) + r0;
        r3.y = (r7 * ((((((((r11.y - r12) + this.e) * r7) + r1) + this.f) * r7) - r1) + this.g)) + r12;
        return r3;
    }
}
