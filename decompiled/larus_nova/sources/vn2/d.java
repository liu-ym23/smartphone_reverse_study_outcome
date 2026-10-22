package vn2;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f556441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f556442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f556443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f556444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f556445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f556446f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f556447g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f556448h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f556449i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f556450j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f556451k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L28;
        d r101 = (d) r100;
        if (this.f556441a == r101.f556441a) goto L8;
        return false;
    L8:
        if (Float.compare(this.f556442b, r101.f556442b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f556443c, r101.f556443c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f556444d, r101.f556444d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f556445e, r101.f556445e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f556446f, r101.f556446f) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f556447g, r101.f556447g) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(this.f556448h, r101.f556448h) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.f556449i, r101.f556449i) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f556450j, r101.f556450j) == 0) goto L26;
        return false;
    L26:
        if (Float.compare(this.f556451k, r101.f556451k) == 0) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((((this.f556441a * 31) + Float.floatToIntBits(this.f556442b)) * 31) + Float.floatToIntBits(this.f556443c)) * 31) + Float.floatToIntBits(this.f556444d)) * 31) + Float.floatToIntBits(this.f556445e)) * 31) + Float.floatToIntBits(this.f556446f)) * 31) + Float.floatToIntBits(this.f556447g)) * 31) + Float.floatToIntBits(this.f556448h)) * 31) + Float.floatToIntBits(this.f556449i)) * 31) + Float.floatToIntBits(this.f556450j)) * 31) + Float.floatToIntBits(this.f556451k);
    }

    public final String toString() {
        return "GcInfoPerSecond(no=" + this.f556441a + ", gcCountPerSecond=" + this.f556442b + ", gcTimePerSecond=" + this.f556443c + ", gcPauseTimePerSecond=" + this.f556444d + ", blockGcCountPerSecond=" + this.f556445e + ", blockGcTimePerSecond=" + this.f556446f + ", waitGcTimePerSecond=" + this.f556447g + ", minorFaultsPerSecond=" + this.f556448h + ", majorFaultsPerSecond=" + this.f556449i + ", kBytesAllocatedPerSecond=" + this.f556450j + ", kBytesFreedPerSecond=" + this.f556451k + ")";
    }

    public d(int r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r108, float r110, float r111) {
        this.f556441a = r100;
        this.f556442b = r101;
        this.f556443c = r102;
        this.f556444d = r103;
        this.f556445e = r104;
        this.f556446f = r105;
        this.f556447g = r106;
        this.f556448h = r107;
        this.f556449i = r108;
        this.f556450j = r110;
        this.f556451k = r111;
    }
}
