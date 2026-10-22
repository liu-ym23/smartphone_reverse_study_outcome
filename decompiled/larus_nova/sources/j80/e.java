package j80;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f497669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f497670b;

    public e() {
        this(0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (a().intValue() == r101.a().intValue()) goto L8;
        return false;
    L8:
        if (b().intValue() == r101.b().intValue()) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (a().intValue() * 31) + b().intValue();
    }

    public final String toString() {
        return "Vec2i(x=" + a() + ", y=" + b() + ")";
    }

    public final Integer a() {
        return Integer.valueOf(this.f497669a);
    }

    public final Integer b() {
        return Integer.valueOf(this.f497670b);
    }

    public e(int r100, int r101) {
        this.f497669a = r100;
        this.f497670b = r101;
    }
}
