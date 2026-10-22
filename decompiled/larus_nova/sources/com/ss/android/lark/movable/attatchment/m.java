package com.ss.android.lark.movable.attatchment;

/* JADX INFO: loaded from: classes36.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f432641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f432642b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Float.compare(this.f432641a, r101.f432641a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f432642b, r101.f432642b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f432641a) * 31) + Float.floatToIntBits(this.f432642b);
    }

    public final String toString() {
        return "ImageMeasureSize(width=" + this.f432641a + ", height=" + this.f432642b + ')';
    }

    public m(float r100, float r101) {
        this.f432641a = r100;
        this.f432642b = r101;
    }
}
