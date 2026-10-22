package lja;

/* JADX INFO: loaded from: classes33.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f509523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f509524b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Float.compare(this.f509523a, r101.f509523a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f509524b, r101.f509524b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f509523a) * 31) + Float.floatToIntBits(this.f509524b);
    }

    public final String toString() {
        return "Point(x=" + this.f509523a + ", y=" + this.f509524b + ")";
    }

    public e(float r100, float r101) {
        this.f509523a = r100;
        this.f509524b = r101;
    }
}
