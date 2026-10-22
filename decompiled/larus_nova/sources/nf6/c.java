package nf6;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f518955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f518956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f518957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f518958d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Float.compare(this.f518955a, r101.f518955a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f518956b, r101.f518956b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f518957c, r101.f518957c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f518958d, r101.f518958d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f518955a) * 31) + Float.floatToIntBits(this.f518956b)) * 31) + Float.floatToIntBits(this.f518957c)) * 31) + Float.floatToIntBits(this.f518958d);
    }

    public final String toString() {
        return "Scale2D(sx=" + this.f518955a + ", sy=" + this.f518956b + ", px=" + this.f518957c + ", py=" + this.f518958d + ")";
    }

    public c() {
        this.f518955a = 0.0f;
        this.f518956b = 0.0f;
        this.f518957c = 0.0f;
        this.f518958d = 0.0f;
    }
}
