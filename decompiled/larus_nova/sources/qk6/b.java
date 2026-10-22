package qk6;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements nf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f533553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f533554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f533555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f533556d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (this.f533553a == r101.f533553a) goto L8;
        return false;
    L8:
        if (Float.compare(this.f533554b, r101.f533554b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f533555c, r101.f533555c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f533556d, r101.f533556d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f533553a * 31) + Float.floatToIntBits(this.f533554b)) * 31) + Float.floatToIntBits(this.f533555c)) * 31) + Float.floatToIntBits(this.f533556d);
    }

    public final String toString() {
        return "Scale3D(offset=" + this.f533553a + ", x=" + this.f533554b + ", y=" + this.f533555c + ", z=" + this.f533556d + ")";
    }

    public b() {
        this.f533553a = 0;
        this.f533554b = 0.0f;
        this.f533555c = 0.0f;
        this.f533556d = 0.0f;
    }
}
