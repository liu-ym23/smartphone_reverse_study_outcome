package l79;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f507825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f507826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f507827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f507828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f507829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f507830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f507831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f507832h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f507833i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f507834j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f507835k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f507836l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f507825a, r101.f507825a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f507826b, r101.f507826b) == true) goto L15;
        return false;
    L15:
        if (this.f507827c == r101.f507827c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f507828d, r101.f507828d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f507829e, r101.f507829e) == true) goto L24;
        return false;
    L24:
        if (this.f507830f == r101.f507830f) goto L27;
        return false;
    L27:
        if (this.f507831g == r101.f507831g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f507832h, r101.f507832h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f507833i, r101.f507833i) == true) goto L36;
        return false;
    L36:
        if (this.f507834j == r101.f507834j) goto L39;
        return false;
    L39:
        if (this.f507835k == r101.f507835k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f507836l, r101.f507836l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f507825a.hashCode() * 31) + this.f507826b.hashCode()) * 31) + this.f507827c) * 31) + this.f507828d.hashCode()) * 31) + this.f507829e.hashCode()) * 31;
        long r101 = this.f507830f;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f507831g;
        int r104 = (((((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f507832h.hashCode()) * 31) + this.f507833i.hashCode()) * 31) + this.f507834j) * 31) + this.f507835k) * 31;
        String r105 = this.f507836l;
        if (r105 != null) goto L5;
        int r106 = 0;
    L7:
        return r104 + r106;
    L5:
        r106 = r105.hashCode();
        goto L7
    }

    public final String toString() {
        return "DriveFileMineEntity(fileToken=" + this.f507825a + ", driveToken=" + this.f507826b + ", orderIndex=" + this.f507827c + ", fileName=" + this.f507828d + ", fileURL=" + this.f507829e + ", openTime=" + this.f507830f + ", editTime=" + this.f507831g + ", iconInfo=" + this.f507832h + ", fileTypeValue=" + this.f507833i + ", isOwner=" + this.f507834j + ", driveObjType=" + this.f507835k + ", extra=" + this.f507836l + ')';
    }

    public a(String r100, String r101, int r102, String r103, String r104, long r105, long r106, String r110, String r111, int r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "fileToken");
        Intrinsics.checkNotNullParameter(r101, "driveToken");
        Intrinsics.checkNotNullParameter(r103, "fileName");
        Intrinsics.checkNotNullParameter(r104, "fileURL");
        Intrinsics.checkNotNullParameter(r110, "iconInfo");
        Intrinsics.checkNotNullParameter(r111, "fileTypeValue");
        this.f507825a = r100;
        this.f507826b = r101;
        this.f507827c = r102;
        this.f507828d = r103;
        this.f507829e = r104;
        this.f507830f = r105;
        this.f507831g = r106;
        this.f507832h = r110;
        this.f507833i = r111;
        this.f507834j = r112;
        this.f507835k = r113;
        this.f507836l = r114;
    }
}
