package oy;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f527116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f527117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f527118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f527119d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Float.compare(this.f527116a, r101.f527116a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f527117b, r101.f527117b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f527118c, r101.f527118c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f527119d, r101.f527119d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f527116a) * 31) + Float.floatToIntBits(this.f527117b)) * 31) + Float.floatToIntBits(this.f527118c)) * 31) + Float.floatToIntBits(this.f527119d);
    }

    public final String toString() {
        return "ContainerFrame[" + this.f527116a + ", " + this.f527117b + ", " + this.f527118c + ", " + this.f527119d + ']';
    }

    public e(float r100, float r101, float r102, float r103) {
        this.f527116a = r100;
        this.f527117b = r101;
        this.f527118c = r102;
        this.f527119d = r103;
    }
}
