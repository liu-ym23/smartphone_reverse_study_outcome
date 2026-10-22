package l79;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f507837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f507838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f507839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f507840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f507841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f507842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f507843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f507844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f507845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f507846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f507847k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f507848l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f507837a, r101.f507837a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f507838b, r101.f507838b) == true) goto L15;
        return false;
    L15:
        if (this.f507839c == r101.f507839c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f507840d, r101.f507840d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f507841e, r101.f507841e) == true) goto L24;
        return false;
    L24:
        if (this.f507842f == r101.f507842f) goto L27;
        return false;
    L27:
        if (this.f507843g == r101.f507843g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f507844h, r101.f507844h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f507845i, r101.f507845i) == true) goto L36;
        return false;
    L36:
        if (this.f507846j == r101.f507846j) goto L39;
        return false;
    L39:
        if (this.f507847k == r101.f507847k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f507848l, r101.f507848l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f507837a.hashCode() * 31) + this.f507838b.hashCode()) * 31) + this.f507839c) * 31) + this.f507840d.hashCode()) * 31) + this.f507841e.hashCode()) * 31;
        long r101 = this.f507842f;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f507843g;
        int r104 = (((((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f507844h.hashCode()) * 31) + this.f507845i.hashCode()) * 31) + this.f507846j) * 31) + this.f507847k) * 31;
        String r105 = this.f507848l;
        if (r105 != null) goto L5;
        int r106 = 0;
    L7:
        return r104 + r106;
    L5:
        r106 = r105.hashCode();
        goto L7
    }

    public final String toString() {
        return "DriveFileRecentEntity(fileToken=" + this.f507837a + ", driveToken=" + this.f507838b + ", orderIndex=" + this.f507839c + ", fileName=" + this.f507840d + ", fileURL=" + this.f507841e + ", openTime=" + this.f507842f + ", editTime=" + this.f507843g + ", iconInfo=" + this.f507844h + ", fileTypeValue=" + this.f507845i + ", isOwner=" + this.f507846j + ", driveObjType=" + this.f507847k + ", extra=" + this.f507848l + ')';
    }

    public b(String r100, String r101, int r102, String r103, String r104, long r105, long r106, String r110, String r111, int r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "fileToken");
        Intrinsics.checkNotNullParameter(r101, "driveToken");
        Intrinsics.checkNotNullParameter(r103, "fileName");
        Intrinsics.checkNotNullParameter(r104, "fileURL");
        Intrinsics.checkNotNullParameter(r110, "iconInfo");
        Intrinsics.checkNotNullParameter(r111, "fileTypeValue");
        this.f507837a = r100;
        this.f507838b = r101;
        this.f507839c = r102;
        this.f507840d = r103;
        this.f507841e = r104;
        this.f507842f = r105;
        this.f507843g = r106;
        this.f507844h = r110;
        this.f507845i = r111;
        this.f507846j = r112;
        this.f507847k = r113;
        this.f507848l = r114;
    }
}
