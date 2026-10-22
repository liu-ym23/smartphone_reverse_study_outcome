package com.bytedance.locallife.dito.utils;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f258691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f258692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f258693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f258694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f258695e;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Float.compare(this.f258691a, r101.f258691a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f258692b, r101.f258692b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f258693c, r101.f258693c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f258694d, r101.f258694d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f258695e, r101.f258695e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((Float.floatToIntBits(this.f258691a) * 31) + Float.floatToIntBits(this.f258692b)) * 31) + Float.floatToIntBits(this.f258693c)) * 31) + Float.floatToIntBits(this.f258694d)) * 31) + Float.floatToIntBits(this.f258695e);
    }

    public final String toString() {
        return "Corners(radius=" + this.f258691a + ", topLeft=" + this.f258692b + ", topRight=" + this.f258693c + ", bottomLeft=" + this.f258694d + ", bottomRight=" + this.f258695e + ')';
    }

    public d(int r100) {
        this.f258691a = 0.0f;
        this.f258692b = Float.NaN;
        this.f258693c = Float.NaN;
        this.f258694d = Float.NaN;
        this.f258695e = Float.NaN;
    }

    public final float a(float r100) {
        Float r101 = Float.valueOf(r100);
        boolean r102 = false;
        if (r101.floatValue() < 0) goto L5;
        r102 = true;
    L5:
        if (r102 == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L11;
        return r101.floatValue();
    L11:
        return this.f258691a;
    }
}
