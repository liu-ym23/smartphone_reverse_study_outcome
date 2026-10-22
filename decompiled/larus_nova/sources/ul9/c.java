package ul9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Float f550615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f550616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f550617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f550618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f550619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f550620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f550621g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f550615a, r101.f550615a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f550616b, r101.f550616b) == true) goto L15;
        return false;
    L15:
        if (this.f550617c == r101.f550617c) goto L18;
        return false;
    L18:
        if (Float.compare(this.f550618d, r101.f550618d) == 0) goto L21;
        return false;
    L21:
        if (this.f550619e == r101.f550619e) goto L24;
        return false;
    L24:
        if (this.f550620f == r101.f550620f) goto L27;
        return false;
    L27:
        if (this.f550621g == r101.f550621g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Float r100 = this.f550615a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((((r101 * 31) + this.f550616b.hashCode()) * 31) + this.f550617c) * 31) + Float.floatToIntBits(this.f550618d)) * 31;
        long r103 = this.f550619e;
        return ((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f550620f) * 31) + this.f550621g;
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BaiduNaviLocInfo(gpsDir=" + this.f550615a + ", geoPoint=" + this.f550616b + ", radius=" + this.f550617c + ", speed=" + this.f550618d + ", gpsTime=" + this.f550619e + ", satelliteCount=" + this.f550620f + ", locationType=" + this.f550621g + ')';
    }

    public c(Float r100, a r101, int r102, float r103, long r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r101, "geoPoint");
        this.f550615a = r100;
        this.f550616b = r101;
        this.f550617c = r102;
        this.f550618d = r103;
        this.f550619e = r104;
        this.f550620f = r105;
        this.f550621g = r106;
    }
}
