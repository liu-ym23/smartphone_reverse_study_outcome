package com.obric.oui.blur;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f398866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f398867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f398868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f398869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f398870e;

    public a() {
        int r100 = 0;
        float r101 = 0.0f;
        this(r101, r100, r100, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(Float.valueOf(this.f398866a), Float.valueOf(r101.f398866a)) == true) goto L12;
        return false;
    L12:
        if (this.f398867b == r101.f398867b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.f398868c), Float.valueOf(r101.f398868c)) == true) goto L18;
        return false;
    L18:
        if (this.f398869d == r101.f398869d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(this.f398870e), Float.valueOf(r101.f398870e)) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((Float.floatToIntBits(this.f398866a) * 31) + this.f398867b) * 31) + Float.floatToIntBits(this.f398868c)) * 31) + this.f398869d) * 31) + Float.floatToIntBits(this.f398870e);
    }

    public final String toString() {
        return "BlurConfig(blurRadius=" + this.f398866a + ", direction=" + this.f398867b + ", alpha=" + this.f398868c + ", curveType=" + this.f398869d + ", endPoint=" + this.f398870e + ')';
    }

    public /* synthetic */ a(float r100, int r110, int r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        float r101 = 0.0f;
    L7:
        if ((r112 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r112 & 4) == 0) goto L13;
        float r103 = 1.0f;
    L15:
        if ((r112 & 8) == 0) goto L17;
        int r104 = 0;
    L19:
        if ((r112 & 16) == 0) goto L21;
        float r105 = 1.0f;
    L22:
        this(r101, r102, r103, r104, r105);
        return;
    L21:
        r105 = 0.0f;
        goto L22
    L17:
        r104 = r111;
        goto L19
    L13:
        r103 = 0.0f;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public a(float r100, int r101, float r102, int r103, float r104) {
        this.f398866a = r100;
        this.f398867b = r101;
        this.f398868c = r102;
        this.f398869d = r103;
        this.f398870e = r104;
    }
}
