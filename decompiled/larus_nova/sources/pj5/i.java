package pj5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f529477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f529478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f529479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f529480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f529481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f529482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f529483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f529484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f529485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f529486j;

    public i() {
        this(false, null, false, false, null, false, 0, false, 0, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f529477a == r101.f529477a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f529478b, r101.f529478b) == true) goto L15;
        return false;
    L15:
        if (this.f529479c == r101.f529479c) goto L18;
        return false;
    L18:
        if (this.f529480d == r101.f529480d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f529481e, r101.f529481e) == true) goto L24;
        return false;
    L24:
        if (this.f529482f == r101.f529482f) goto L27;
        return false;
    L27:
        if (this.f529483g == r101.f529483g) goto L30;
        return false;
    L30:
        if (this.f529484h == r101.f529484h) goto L33;
        return false;
    L33:
        if (this.f529485i == r101.f529485i) goto L36;
        return false;
    L36:
        if (this.f529486j == r101.f529486j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f529477a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f529478b.hashCode()) * 31;
        if (this.f529479c == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f529480d == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((((r104 + r105) * 31) + this.f529481e.hashCode()) * 31) + this.f529482f) * 31;
        if (this.f529483g == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (((r106 + r107) * 31) + this.f529484h) * 31;
        if (this.f529485i == true) goto L22;
        r100 = 1237;
    L22:
        int r109 = (r108 + r100) * 31;
        long r110 = this.f529486j;
        return r109 + ((int) (r110 ^ (r110 >>> 32)));
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DocFreshNessEntity(isSelected=" + this.f529477a + ", srcName=" + this.f529478b + ", isNews=" + this.f529479c + ", showDesc=" + this.f529480d + ", description=" + this.f529481e + ", descColor=" + this.f529482f + ", showUpdateTime=" + this.f529483g + ", freshStatus=" + this.f529484h + ", isCustomer=" + this.f529485i + ", dateTime=" + this.f529486j + ')';
    }

    public i(boolean r100, String r101, boolean r102, boolean r103, String r104, boolean r110, int r111, boolean r112, long r113, int r114) {
        if ((r114 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r114 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r114 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r114 & 8) == 0) goto L15;
        r103 = false;
    L15:
        if ((r114 & 16) == 0) goto L18;
        r104 = "";
    L18:
        if ((r114 & 32) == 0) goto L20;
        int r105 = -1;
    L22:
        if ((r114 & 64) == 0) goto L25;
        r110 = false;
    L25:
        if ((r114 & 128) == 0) goto L28;
        r111 = -1;
    L28:
        if ((r114 & 256) == 0) goto L31;
        r112 = false;
    L31:
        if ((r114 & 512) == 0) goto L33;
        r113 = -1;
    L33:
        Intrinsics.checkNotNullParameter(r101, "srcName");
        Intrinsics.checkNotNullParameter(r104, "description");
        this.f529477a = r100;
        this.f529478b = r101;
        this.f529479c = r102;
        this.f529480d = r103;
        this.f529481e = r104;
        this.f529482f = r105;
        this.f529483g = r110;
        this.f529484h = r111;
        this.f529485i = r112;
        this.f529486j = r113;
        return;
    L20:
        r105 = 0;
        goto L22
    }
}
