package yt8;

import com.larus.bmhome.bigimg.t1;
import com.larus.platform.model.GeoLocationInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p implements t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f569194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f569195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f569196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f569197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f569198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f569199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f569200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f569201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f569202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final GeoLocationInfo f569203j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final double f569204k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f569205l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f569206m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f569207n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f569208o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f569194a, r101.f569194a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f569195b, r101.f569195b) == true) goto L15;
        return false;
    L15:
        if (this.f569196c == r101.f569196c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f569197d, r101.f569197d) == true) goto L21;
        return false;
    L21:
        if (this.f569198e == r101.f569198e) goto L24;
        return false;
    L24:
        if (this.f569199f == r101.f569199f) goto L27;
        return false;
    L27:
        if (this.f569200g == r101.f569200g) goto L30;
        return false;
    L30:
        if (this.f569201h == r101.f569201h) goto L33;
        return false;
    L33:
        if (this.f569202i == r101.f569202i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f569203j, r101.f569203j) == true) goto L39;
        return false;
    L39:
        if (Double.compare(this.f569204k, r101.f569204k) == 0) goto L42;
        return false;
    L42:
        if (this.f569205l == r101.f569205l) goto L45;
        return false;
    L45:
        if (this.f569206m == r101.f569206m) goto L48;
        return false;
    L48:
        if (this.f569207n == r101.f569207n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f569194a.hashCode() * 31) + this.f569195b.hashCode()) * 31;
        long r101 = this.f569196c;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f569197d.hashCode()) * 31) + this.f569198e) * 31;
        int r103 = 1231;
        if (this.f569199f == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        if (this.f569200g == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r105 + r106) * 31;
        if (this.f569201h == true) goto L14;
        r103 = 1237;
    L14:
        int r108 = (((r107 + r103) * 31) + this.f569202i) * 31;
        GeoLocationInfo r109 = this.f569203j;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        long r112 = Double.doubleToLongBits(this.f569204k);
        return ((((((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.f569205l) * 31) + this.f569206m) * 31) + this.f569207n;
    L17:
        r110 = r109.hashCode();
        goto L18
    L9:
        r106 = 1237;
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "VideoFileItem(name=" + this.f569194a + ", path=" + this.f569195b + ", lastModified=" + this.f569196c + ", mediaID=" + this.f569197d + ", side=" + this.f569198e + ", inSelectMode=" + this.f569199f + ", isSelected=" + this.f569200g + ", inProgressing=" + this.f569201h + ", index=" + this.f569202i + ", geoLocationInfo=" + this.f569203j + ", duration=" + this.f569204k + ", width=" + this.f569205l + ", height=" + this.f569206m + ", bitrate=" + this.f569207n + ')';
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final GeoLocationInfo a() {
        return this.f569203j;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final boolean b() {
        return this.f569199f;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final int c() {
        return this.f569198e;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final boolean d() {
        return this.f569201h;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final long e() {
        return this.f569196c;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final String g() {
        return this.f569197d;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final int getIndex() {
        return this.f569202i;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final int getMediaType() {
        return this.f569208o;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final String getName() {
        return this.f569194a;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final String getPath() {
        return this.f569195b;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final boolean isSelected() {
        return this.f569200g;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final t1 f(String r210, String r211, long r212, String r213, int r214, boolean r215, boolean r216, boolean r217, int r218, GeoLocationInfo r310) {
        Intrinsics.checkNotNullParameter(r210, "name");
        Intrinsics.checkNotNullParameter(r211, "path");
        Intrinsics.checkNotNullParameter(r213, "mediaID");
        return new p(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, this.f569204k, this.f569205l, this.f569206m, this.f569207n);
    }

    public /* synthetic */ p(String r110, String r111, long r210, String r211, boolean r212, boolean r213, int r214, GeoLocationInfo r215, double r216, int r217, int r310) {
        this(r110, r111, r210, r211, 0, r212, false, r213, r214, r215, r216, r217, r310, 0);
    }

    public p(String r100, String r101, long r102, String r110, int r111, boolean r112, boolean r113, boolean r114, int r115, GeoLocationInfo r116, double r117, int r118, int r210, int r211) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r110, "mediaID");
        this.f569194a = r100;
        this.f569195b = r101;
        this.f569196c = r102;
        this.f569197d = r110;
        this.f569198e = r111;
        this.f569199f = r112;
        this.f569200g = r113;
        this.f569201h = r114;
        this.f569202i = r115;
        this.f569203j = r116;
        this.f569204k = r117;
        this.f569205l = r118;
        this.f569206m = r210;
        this.f569207n = r211;
        this.f569208o = 2;
    }
}
