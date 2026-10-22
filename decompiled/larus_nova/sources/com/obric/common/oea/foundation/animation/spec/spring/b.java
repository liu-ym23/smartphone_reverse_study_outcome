package com.obric.common.oea.foundation.animation.spec.spring;

import cja.e;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class b implements gja.a<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f396389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f396390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f396391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f396392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f396393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f396394f;

    @Override // gja.a
    public final String dump() {
        return "FloatSpringSpec(dampingRatio: " + this.f396391c + ", stiffness: " + this.f396392d + ", delay: " + this.f396393e + ", visibilityThreshold: " + this.f396394f + ", delta: " + this.f396390b + ')';
    }

    @Override // gja.a
    public final boolean a(long r100, long r101) {
        if (r100 < (r101 + (((long) this.f396393e) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // gja.a
    public final long b(Float r100, Float r101, float r102) {
        float r103 = r100.floatValue();
        float r104 = r101.floatValue();
        e r105 = this.f396389a;
        double r106 = r105.f23992a;
        float r107 = r105.f23997f;
        float r108 = r103 - r104;
        float r109 = this.f396394f;
        float r110 = r102 / r109;
        return c.b((float) (r106 * r106), r107, r110, r108 / r109, this.f396390b) * 1000000;
    }

    public b(float r100, float r101, int r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 1.0f;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 1.0f;
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r103 & 8) == 0) goto L14;
        float r104 = 0.01f;
    L15:
        this.f396391c = r100;
        this.f396392d = r101;
        this.f396393e = r102;
        this.f396394f = r104;
        e r105 = new e();
        if (r100 < 0) goto L20;
        r105.f23997f = r100;
        r105.f23993b = false;
        r105.a(r101);
        Unit r106 = Unit.INSTANCE;
        this.f396389a = r105;
        this.f396390b = 1.0f;
        return;
    L20:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    L14:
        r104 = 0.0f;
        goto L15
    }

    @Override // gja.a
    public final Float c(long r100, Float r101, Float r110, float r111) {
        float r102 = r101.floatValue();
        float r112 = r110.floatValue();
        long r103 = e(r100, r102, r112, r111) / 1000000;
        e r104 = this.f396389a;
        r104.f23998g = r112;
        return Float.valueOf(r104.b(r102, r111, r103).a());
    }

    @Override // gja.a
    public final float d(long r100, Float r101, Float r110, float r111) {
        float r102 = r101.floatValue();
        float r112 = r110.floatValue();
        long r103 = e(r100, r102, r112, r111) / 1000000;
        e r104 = this.f396389a;
        r104.f23998g = r112;
        return r104.b(r102, r111, r103).b();
    }

    public final long e(long r110, float r111, float r112, float r113) {
        e r100 = this.f396389a;
        double r101 = r100.f23992a;
        float r102 = r100.f23997f;
        float r114 = r111 - r112;
        float r115 = this.f396394f;
        long r116 = c.b((float) (r101 * r101), r102, r113 / r115, r114 / r115, this.f396390b) * 1000000;
        long r103 = r110 - (((long) this.f396393e) * 1000000);
        if (r116 < 0) goto L5;
        long r104 = r116;
    L7:
        return RangesKt.coerceIn(r103, 0, r104);
    L5:
        r104 = 0;
        goto L7
    }
}
