package oy7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f527152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f527153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f527154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f527155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f527156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f527157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f527158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f527159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f527160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f527161l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f527150a, r101.f527150a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527151b, r101.f527151b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f527152c, r101.f527152c) == true) goto L18;
        return false;
    L18:
        if (this.f527153d == r101.f527153d) goto L21;
        return false;
    L21:
        if (this.f527154e == r101.f527154e) goto L24;
        return false;
    L24:
        if (this.f527155f == r101.f527155f) goto L27;
        return false;
    L27:
        if (this.f527156g == r101.f527156g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f527157h, r101.f527157h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f527158i, r101.f527158i) == true) goto L36;
        return false;
    L36:
        if (this.f527159j == r101.f527159j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f527160k, r101.f527160k) == true) goto L42;
        return false;
    L42:
        if (this.f527161l == r101.f527161l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f527150a.hashCode() * 31) + this.f527151b.hashCode()) * 31) + this.f527152c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f527153d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f527154e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f527155f == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f527156g == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        String r110 = this.f527157h;
        int r111 = 0;
        if (r110 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r109 + r112) * 31;
        String r114 = this.f527158i;
        if (r114 == null) goto L26;
        r111 = r114.hashCode();
    L26:
        int r115 = (((((r113 + r111) * 31) + this.f527159j) * 31) + this.f527160k.hashCode()) * 31;
        if (this.f527161l == true) goto L31;
        r101 = 1237;
    L31:
        return r115 + r101;
    L21:
        r112 = r110.hashCode();
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "HashTagViewData(id=" + this.f527150a + ", tagInstanceId=" + this.f527151b + ", name=" + this.f527152c + ", isCollected=" + this.f527153d + ", isAdded=" + this.f527154e + ", isAuthorized=" + this.f527155f + ", isDeletable=" + this.f527156g + ", appLink=" + this.f527157h + ", hashTagOwnerName=" + this.f527158i + ", permissionType=" + this.f527159j + ", teamworkerCount=" + this.f527160k + ", isNeedCreate=" + this.f527161l + ')';
    }

    public e(String r100, String r101, String r102, boolean r103, boolean r104, boolean r105, boolean r106, String r110, String r111, int r112, String r113, boolean r114, int r115) {
        if ((r115 & 512) == 0) goto L6;
        r112 = 0;
    L6:
        if ((r115 & 1024) == 0) goto L9;
        r113 = "";
    L9:
        if ((r115 & 2048) == 0) goto L11;
        r114 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "tagInstanceId");
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r113, "teamworkerCount");
        this.f527150a = r100;
        this.f527151b = r101;
        this.f527152c = r102;
        this.f527153d = r103;
        this.f527154e = r104;
        this.f527155f = r105;
        this.f527156g = r106;
        this.f527157h = r110;
        this.f527158i = r111;
        this.f527159j = r112;
        this.f527160k = r113;
        this.f527161l = r114;
    }
}
