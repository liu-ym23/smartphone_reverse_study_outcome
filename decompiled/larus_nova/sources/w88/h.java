package w88;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f558670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f558671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f558672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f558673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f558674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f558675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f558676i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f558668a, r101.f558668a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558669b, r101.f558669b) == true) goto L15;
        return false;
    L15:
        if (this.f558670c == r101.f558670c) goto L18;
        return false;
    L18:
        if (Double.compare(this.f558671d, r101.f558671d) == 0) goto L21;
        return false;
    L21:
        if (this.f558672e == r101.f558672e) goto L24;
        return false;
    L24:
        if (this.f558673f == r101.f558673f) goto L27;
        return false;
    L27:
        if (this.f558674g == r101.f558674g) goto L30;
        return false;
    L30:
        if (this.f558675h == r101.f558675h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f558676i, r101.f558676i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f558668a.hashCode() * 31) + this.f558669b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f558670c == false) goto L5;
        int r102 = 1231;
    L6:
        long r103 = Double.doubleToLongBits(this.f558671d);
        int r104 = (((((((r100 + r102) * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f558672e) * 31) + this.f558673f) * 31;
        long r105 = this.f558674g;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        if (this.f558675h == true) goto L10;
        r101 = 1237;
    L10:
        int r107 = (r106 + r101) * 31;
        Long r108 = this.f558676i;
        if (r108 != null) goto L13;
        int r109 = 0;
    L15:
        return r107 + r109;
    L13:
        r109 = r108.hashCode();
        goto L15
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraOAlbumPreviewItem(id=" + this.f558668a + ", filePath=" + this.f558669b + ", isVideo=" + this.f558670c + ", durationMs=" + this.f558671d + ", width=" + this.f558672e + ", height=" + this.f558673f + ", createTime=" + this.f558674g + ", inProgress=" + this.f558675h + ", systemGalleryId=" + this.f558676i + ')';
    }

    public h(String r100, String r101, boolean r102, double r103, int r104, int r105, long r106, boolean r110, Long r111) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "filePath");
        this.f558668a = r100;
        this.f558669b = r101;
        this.f558670c = r102;
        this.f558671d = r103;
        this.f558672e = r104;
        this.f558673f = r105;
        this.f558674g = r106;
        this.f558675h = r110;
        this.f558676i = r111;
    }
}
