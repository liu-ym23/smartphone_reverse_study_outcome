package k40;

/* JADX INFO: loaded from: classes45.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f501730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f501731b;

    public g() {
        this(0.0f, 0.0f);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
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
        return Float.valueOf(this.f501730a);
    }

    public final Float b() {
        return Float.valueOf(this.f501731b);
    }

    public g(float r100, float r101) {
        this.f501730a = r100;
        this.f501731b = r101;
    }
}
