package lja;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f509512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f509513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f509514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f509515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f509516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f509517f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (Float.compare(this.f509512a, r101.f509512a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f509513b, r101.f509513b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f509514c, r101.f509514c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f509515d, r101.f509515d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f509516e, r101.f509516e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f509517f, r101.f509517f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        return (((((((((Float.floatToIntBits(this.f509512a) * 31) + Float.floatToIntBits(this.f509513b)) * 31) + Float.floatToIntBits(this.f509514c)) * 31) + Float.floatToIntBits(this.f509515d)) * 31) + Float.floatToIntBits(this.f509516e)) * 31) + Float.floatToIntBits(this.f509517f);
    }

    public final String toString() {
        return "ControlPoint(handleLarge=" + this.f509512a + ", distanceOuter=" + this.f509513b + ", distanceInner=" + this.f509514c + ", handleMedium=" + this.f509515d + ", curveInner=" + this.f509516e + ", curveOuter=" + this.f509517f + ")";
    }

    public b() {
        this.f509512a = 67.45f;
        this.f509513b = 51.16f;
        this.f509514c = 34.86f;
        this.f509515d = 22.07f;
        this.f509516e = 13.36f;
        this.f509517f = 4.64f;
    }
}
