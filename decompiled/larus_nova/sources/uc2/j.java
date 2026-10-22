package uc2;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f549450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f549451b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (Float.compare(this.f549450a, r101.f549450a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f549451b, r101.f549451b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f549450a) * 31) + Float.floatToIntBits(this.f549451b);
    }

    public final String toString() {
        return "PointF(x=" + this.f549450a + ", y=" + this.f549451b + ")";
    }

    public j(float r100, float r101) {
        this.f549450a = r100;
        this.f549451b = r101;
    }
}
