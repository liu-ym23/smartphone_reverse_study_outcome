package yt8;

import com.larus.bmhome.bigimg.t1;
import com.larus.platform.model.GeoLocationInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f569151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f569152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f569153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f569154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f569155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f569156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f569157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f569158h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f569159i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final GeoLocationInfo f569160j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f569161k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f569162l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f569163m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f569151a, r101.f569151a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f569152b, r101.f569152b) == true) goto L15;
        return false;
    L15:
        if (this.f569153c == r101.f569153c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f569154d, r101.f569154d) == true) goto L21;
        return false;
    L21:
        if (this.f569155e == r101.f569155e) goto L24;
        return false;
    L24:
        if (this.f569156f == r101.f569156f) goto L27;
        return false;
    L27:
        if (this.f569157g == r101.f569157g) goto L30;
        return false;
    L30:
        if (this.f569158h == r101.f569158h) goto L33;
        return false;
    L33:
        if (this.f569159i == r101.f569159i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f569160j, r101.f569160j) == true) goto L39;
        return false;
    L39:
        if (this.f569161k == r101.f569161k) goto L42;
        return false;
    L42:
        if (this.f569162l == r101.f569162l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f569151a.hashCode() * 31) + this.f569152b.hashCode()) * 31;
        long r101 = this.f569153c;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f569154d.hashCode()) * 31) + this.f569155e) * 31;
        int r103 = 1231;
        if (this.f569156f == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        if (this.f569157g == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r105 + r106) * 31;
        if (this.f569158h == true) goto L14;
        r103 = 1237;
    L14:
        int r108 = (((r107 + r103) * 31) + this.f569159i) * 31;
        GeoLocationInfo r109 = this.f569160j;
        if (r109 != null) goto L17;
        int r110 = 0;
    L19:
        return ((((r108 + r110) * 31) + this.f569161k) * 31) + this.f569162l;
    L17:
        r110 = r109.hashCode();
        goto L19
    L9:
        r106 = 1237;
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImageFileItem(name=" + this.f569151a + ", path=" + this.f569152b + ", lastModified=" + this.f569153c + ", mediaID=" + this.f569154d + ", side=" + this.f569155e + ", inSelectMode=" + this.f569156f + ", isSelected=" + this.f569157g + ", inProgressing=" + this.f569158h + ", index=" + this.f569159i + ", geoLocationInfo=" + this.f569160j + ", width=" + this.f569161k + ", height=" + this.f569162l + ')';
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final GeoLocationInfo a() {
        return this.f569160j;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final boolean b() {
        return this.f569156f;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final int c() {
        return this.f569155e;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final boolean d() {
        return this.f569158h;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final long e() {
        return this.f569153c;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final String g() {
        return this.f569154d;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final int getIndex() {
        return this.f569159i;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final int getMediaType() {
        return this.f569163m;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final String getName() {
        return this.f569151a;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final String getPath() {
        return this.f569152b;
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final boolean isSelected() {
        return this.f569157g;
    }

    public /* synthetic */ a(String r110, String r111, long r112, String r113, boolean r210, boolean r211, int r212, GeoLocationInfo r213, int r214, int r215) {
        this(r110, r111, r112, r113, 0, r210, false, r211, r212, r213, r214, r215);
    }

    @Override // com.larus.bmhome.bigimg.t1
    public final t1 f(String r110, String r111, long r112, String r210, int r211, boolean r212, boolean r213, boolean r214, int r215, GeoLocationInfo r216) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "path");
        Intrinsics.checkNotNullParameter(r210, "mediaID");
        return new a(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, this.f569161k, this.f569162l);
    }

    public a(String r100, String r101, long r102, String r103, int r104, boolean r105, boolean r106, boolean r110, int r111, GeoLocationInfo r112, int r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r103, "mediaID");
        this.f569151a = r100;
        this.f569152b = r101;
        this.f569153c = r102;
        this.f569154d = r103;
        this.f569155e = r104;
        this.f569156f = r105;
        this.f569157g = r106;
        this.f569158h = r110;
        this.f569159i = r111;
        this.f569160j = r112;
        this.f569161k = r113;
        this.f569162l = r114;
        this.f569163m = 1;
    }
}
