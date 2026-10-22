package kc0;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f502372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f502373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f502374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f502375d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Float.compare(this.f502372a, r101.f502372a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f502373b, r101.f502373b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f502374c, r101.f502374c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f502375d, r101.f502375d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f502372a) * 31) + Float.floatToIntBits(this.f502373b)) * 31) + Float.floatToIntBits(this.f502374c)) * 31) + Float.floatToIntBits(this.f502375d);
    }

    public final String toString() {
        return "AreaInfo(x=" + this.f502372a + ", y=" + this.f502373b + ", w=" + this.f502374c + ", h=" + this.f502375d + ")";
    }

    public a(float r100, float r101, float r102, float r103) {
        this.f502372a = r100;
        this.f502373b = r101;
        this.f502374c = r102;
        this.f502375d = r103;
    }
}
