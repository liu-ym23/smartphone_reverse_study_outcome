package jl1;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f499523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f499524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f499525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f499526d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Float.compare(this.f499523a, r101.f499523a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f499524b, r101.f499524b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f499525c, r101.f499525c) == 0) goto L12;
        return false;
    L12:
        if (this.f499526d == r101.f499526d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f499523a) * 31) + Float.floatToIntBits(this.f499524b)) * 31) + Float.floatToIntBits(this.f499525c)) * 31) + this.f499526d;
    }

    public final String toString() {
        return "DanmuTextViewShadowLayer(radius=" + this.f499523a + ", dx=" + this.f499524b + ", dy=" + this.f499525c + ", color=" + this.f499526d + ")";
    }

    public a(float r100, float r101, float r102, int r103) {
        this.f499523a = r100;
        this.f499524b = r101;
        this.f499525c = r102;
        this.f499526d = r103;
    }
}
