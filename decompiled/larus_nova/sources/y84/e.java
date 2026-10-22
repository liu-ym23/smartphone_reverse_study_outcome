package y84;

/* JADX INFO: loaded from: classes10.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f566896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f566897b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Float.compare(this.f566896a, r101.f566896a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f566897b, r101.f566897b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f566896a) * 31) + Float.floatToIntBits(this.f566897b);
    }

    public final String toString() {
        return "DirectionResult(bearing=" + this.f566896a + ", confidence=" + this.f566897b + ")";
    }

    public e(float r100, float r101) {
        this.f566896a = r100;
        this.f566897b = r101;
    }
}
