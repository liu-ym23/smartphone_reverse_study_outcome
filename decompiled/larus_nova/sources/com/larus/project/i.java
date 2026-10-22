package com.larus.project;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f367029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f367030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f367031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f367032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f367033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f367034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f367035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f367036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f367037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f367038j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f367029a, r101.f367029a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f367030b, r101.f367030b) == true) goto L15;
        return false;
    L15:
        if (this.f367031c == r101.f367031c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f367032d, r101.f367032d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f367033e, r101.f367033e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f367034f, r101.f367034f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f367035g, r101.f367035g) == true) goto L30;
        return false;
    L30:
        if (this.f367036h == r101.f367036h) goto L33;
        return false;
    L33:
        if (this.f367037i == r101.f367037i) goto L36;
        return false;
    L36:
        if (this.f367038j == r101.f367038j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f367029a.hashCode() * 31) + this.f367030b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f367031c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        String r104 = this.f367032d;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f367033e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f367034f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f367035g;
        if (r114 == null) goto L22;
        r105 = r114.hashCode();
    L22:
        int r115 = (r113 + r105) * 31;
        if (this.f367036h == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        if (this.f367037i == false) goto L29;
        int r118 = 1231;
    L30:
        int r119 = (r117 + r118) * 31;
        if (this.f367038j == true) goto L35;
        r101 = 1237;
    L35:
        return r119 + r101;
    L29:
        r118 = 1237;
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "TaskProject(projectId=" + this.f367029a + ", name=" + this.f367030b + ", isCloudProject=" + this.f367031c + ", folderName=" + this.f367032d + ", workspace=" + this.f367033e + ", deviceId=" + this.f367034f + ", deviceName=" + this.f367035g + ", isDeviceOnline=" + this.f367036h + ", isSelected=" + this.f367037i + ", isEnabled=" + this.f367038j + ')';
    }

    public /* synthetic */ i(String r110, String r111, boolean r112, String r113, String r114, String r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, false, false, true);
    }

    public i(String r100, String r101, boolean r102, String r103, String r104, String r105, String r106, boolean r107, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "projectId");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f367029a = r100;
        this.f367030b = r101;
        this.f367031c = r102;
        this.f367032d = r103;
        this.f367033e = r104;
        this.f367034f = r105;
        this.f367035g = r106;
        this.f367036h = r107;
        this.f367037i = r110;
        this.f367038j = r111;
    }
}
