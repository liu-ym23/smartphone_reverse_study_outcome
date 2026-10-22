package qg4;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f532863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f532864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f532865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f532866d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Float.compare(this.f532863a, r101.f532863a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f532864b, r101.f532864b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f532865c, r101.f532865c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f532866d, r101.f532866d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f532863a) * 31) + Float.floatToIntBits(this.f532864b)) * 31) + Float.floatToIntBits(this.f532865c)) * 31) + Float.floatToIntBits(this.f532866d);
    }

    public final String toString() {
        return "DrawPositions(currentDrawX=" + this.f532863a + ", currentDrawY=" + this.f532864b + ", nextDrawX=" + this.f532865c + ", nextDrawY=" + this.f532866d + ")";
    }

    public a(float r100, float r101, float r102, float r103) {
        this.f532863a = r100;
        this.f532864b = r101;
        this.f532865c = r102;
        this.f532866d = r103;
    }
}
