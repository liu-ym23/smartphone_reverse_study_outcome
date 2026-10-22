package com.larus.office.base.utils;

/* JADX INFO: loaded from: classes29.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f361179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f361180b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Float.compare(this.f361179a, r101.f361179a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f361180b, r101.f361180b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f361179a) * 31) + Float.floatToIntBits(this.f361180b);
    }

    public final String toString() {
        return "SvgDimensions(width=" + this.f361179a + ", height=" + this.f361180b + ')';
    }

    public p(float r100, float r101) {
        this.f361179a = r100;
        this.f361180b = r101;
    }
}
