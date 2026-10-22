package hda;

/* JADX INFO: loaded from: classes32.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f484772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f484773b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Float.compare(this.f484772a, r101.f484772a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f484773b, r101.f484773b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f484772a) * 31) + Float.floatToIntBits(this.f484773b);
    }

    public final String toString() {
        return "MemoryReviewDragDelta(dx=" + this.f484772a + ", dy=" + this.f484773b + ')';
    }

    public w(float r100, float r101) {
        this.f484772a = r100;
        this.f484773b = r101;
    }
}
