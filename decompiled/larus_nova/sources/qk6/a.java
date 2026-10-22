package qk6;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements nf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f533548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f533549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f533550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f533551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f533552e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (this.f533548a == r101.f533548a) goto L8;
        return false;
    L8:
        if (Float.compare(this.f533549b, r101.f533549b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f533550c, r101.f533550c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f533551d, r101.f533551d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f533552e, r101.f533552e) == 0) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return (((((((this.f533548a * 31) + Float.floatToIntBits(this.f533549b)) * 31) + Float.floatToIntBits(this.f533550c)) * 31) + Float.floatToIntBits(this.f533551d)) * 31) + Float.floatToIntBits(this.f533552e);
    }

    public final String toString() {
        return "Rotate3D(offset=" + this.f533548a + ", a=" + this.f533549b + ", x=" + this.f533550c + ", y=" + this.f533551d + ", z=" + this.f533552e + ")";
    }

    public a() {
        this.f533548a = 0;
        this.f533549b = 0.0f;
        this.f533550c = 0.0f;
        this.f533551d = 0.0f;
        this.f533552e = 0.0f;
    }
}
