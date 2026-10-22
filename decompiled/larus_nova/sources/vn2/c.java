package vn2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f556429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f556430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f556431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f556432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f556433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f556434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f556435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f556436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f556437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f556438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f556439k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f556440l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L28;
        c r101 = (c) r100;
        if (this.f556430b == r101.f556430b) goto L8;
        return false;
    L8:
        if (this.f556431c == r101.f556431c) goto L10;
        return false;
    L10:
        if (this.f556432d == r101.f556432d) goto L12;
        return false;
    L12:
        if (this.f556433e == r101.f556433e) goto L14;
        return false;
    L14:
        if (this.f556434f == r101.f556434f) goto L16;
        return false;
    L16:
        if (this.f556435g == r101.f556435g) goto L18;
        return false;
    L18:
        if (this.f556436h == r101.f556436h) goto L20;
        return false;
    L20:
        if (this.f556437i == r101.f556437i) goto L22;
        return false;
    L22:
        if (this.f556438j == r101.f556438j) goto L24;
        return false;
    L24:
        if (this.f556439k == r101.f556439k) goto L26;
        return false;
    L26:
        if (this.f556440l == r101.f556440l) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f556430b * 31;
        long r101 = this.f556431c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f556432d;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f556433e;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f556434f;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f556435g;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f556436h;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.f556437i;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.f556438j;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        long r117 = this.f556439k;
        int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        long r119 = this.f556440l;
        return r118 + ((int) (r119 ^ (r119 >>> 32)));
    }

    public final String toString() {
        return "GcInfoNew(no=" + this.f556430b + ", gcCount=" + this.f556431c + ", gcTime=" + this.f556432d + ", gcPauseTime=" + this.f556433e + ", blockGcCount=" + this.f556434f + ", blockGcTime=" + this.f556435g + ", minorFaults=" + this.f556436h + ", majorFaults=" + this.f556437i + ", kBytesAllocated=" + this.f556438j + ", kBytesFreed=" + this.f556439k + ", tickTime=" + this.f556440l + ")";
    }

    public final d a(c r110) {
        Intrinsics.checkNotNullParameter(r110, "old");
        float r100 = (this.f556440l - r110.f556440l) / 1000.0f;
        return new d(this.f556430b, (this.f556431c - r110.f556431c) / r100, (this.f556432d - r110.f556432d) / r100, (this.f556433e - r110.f556433e) / r100, (this.f556434f - r110.f556434f) / r100, (this.f556435g - r110.f556435g) / r100, (this.f556429a - r110.f556429a) / r100, (this.f556436h - r110.f556436h) / r100, (this.f556437i - r110.f556437i) / r100, (this.f556438j - r110.f556438j) / r100, (this.f556439k - r110.f556439k) / r100);
    }

    public c(int r100, long r101, long r102, long r103, long r110, long r111, long r112, long r113, long r114, long r210, long r211) {
        this.f556430b = r100;
        this.f556431c = r101;
        this.f556432d = r102;
        this.f556433e = r103;
        this.f556434f = r110;
        this.f556435g = r111;
        this.f556436h = r112;
        this.f556437i = r113;
        this.f556438j = r114;
        this.f556439k = r210;
        this.f556440l = r211;
        this.f556429a = -1;
    }
}
