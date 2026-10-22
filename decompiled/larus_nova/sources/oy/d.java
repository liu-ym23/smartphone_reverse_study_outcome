package oy;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f527114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f527115b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Float.compare(this.f527114a, r101.f527114a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f527115b, r101.f527115b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f527114a) * 31) + Float.floatToIntBits(this.f527115b);
    }

    public final String toString() {
        return "PlublicScreenInfo[" + this.f527114a + ", " + this.f527115b + ']';
    }

    public d(float r100, float r101) {
        this.f527114a = r100;
        this.f527115b = r101;
    }
}
