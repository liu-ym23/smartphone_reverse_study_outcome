package j80;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f497667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f497668b;

    public d() {
        this(0.0f, 0.0f);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Float.compare(a().floatValue(), r101.a().floatValue()) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(b().floatValue(), r101.b().floatValue()) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(a().floatValue()) * 31) + Float.floatToIntBits(b().floatValue());
    }

    public final String toString() {
        return "Vec2f(x=" + a() + ", y=" + b() + ")";
    }

    public final Float a() {
        return Float.valueOf(this.f497667a);
    }

    public final Float b() {
        return Float.valueOf(this.f497668b);
    }

    public d(float r100, float r101) {
        this.f497667a = r100;
        this.f497668b = r101;
    }
}
