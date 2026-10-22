package w73;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f558495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f558496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f558497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f558498d;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Float.compare(this.f558495a, r101.f558495a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f558496b, r101.f558496b) == 0) goto L10;
        return false;
    L10:
        if (this.f558497c == r101.f558497c) goto L12;
        return false;
    L12:
        if (this.f558498d == r101.f558498d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f558495a) * 31) + Float.floatToIntBits(this.f558496b)) * 31) + this.f558497c) * 31) + this.f558498d;
    }

    public final String toString() {
        return "SharedUIVariables(lastOffset=" + this.f558495a + ", lastBottomFraction=" + this.f558496b + ", upSpace=" + this.f558497c + ", downSpace=" + this.f558498d + ")";
    }

    public a(int r100) {
        this.f558495a = 0.0f;
        this.f558496b = 0.0f;
        this.f558497c = 0;
        this.f558498d = 0;
    }
}
