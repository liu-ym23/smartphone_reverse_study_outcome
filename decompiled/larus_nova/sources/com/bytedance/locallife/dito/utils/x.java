package com.bytedance.locallife.dito.utils;

/* JADX INFO: loaded from: classes21.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f258726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f258727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f258728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f258729d;

    public x() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (this.f258726a == r101.f258726a) goto L12;
        return false;
    L12:
        if (this.f258727b == r101.f258727b) goto L15;
        return false;
    L15:
        if (Float.compare(this.f258728c, r101.f258728c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f258729d, r101.f258729d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f258726a * 31) + this.f258727b) * 31) + Float.floatToIntBits(this.f258728c)) * 31) + Float.floatToIntBits(this.f258729d);
    }

    public final String toString() {
        return "Stroke(width=" + this.f258726a + ", color=" + this.f258727b + ", dashWidth=" + this.f258728c + ", dashGap=" + this.f258729d + ')';
    }

    public x(int r100) {
        this.f258726a = -1;
        this.f258727b = -1;
        this.f258728c = 0.0f;
        this.f258729d = 0.0f;
    }
}
