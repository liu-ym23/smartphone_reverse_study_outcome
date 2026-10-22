package oy;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f527110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f527111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f527112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f527113d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Float.compare(this.f527110a, r101.f527110a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f527111b, r101.f527111b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f527112c, r101.f527112c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f527113d, r101.f527113d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f527110a) * 31) + Float.floatToIntBits(this.f527111b)) * 31) + Float.floatToIntBits(this.f527112c)) * 31) + Float.floatToIntBits(this.f527113d);
    }

    public final String toString() {
        return "PlayerFrame(x=" + this.f527110a + ", y=" + this.f527111b + ", width=" + this.f527112c + ", height=" + this.f527113d + ")";
    }

    public c(float r100, float r101, float r102, float r103) {
        this.f527110a = r100;
        this.f527111b = r101;
        this.f527112c = r102;
        this.f527113d = r103;
    }
}
