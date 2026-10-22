package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f431764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f431765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f431766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f431767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f431768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f431769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f431770g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f431771h;

    public j() {
        boolean r100 = false;
        this(r100, r100, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f431764a, r101.f431764a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f431765b, r101.f431765b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f431766c, r101.f431766c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f431767d, r101.f431767d) == true) goto L21;
        return false;
    L21:
        if (this.f431768e == r101.f431768e) goto L24;
        return false;
    L24:
        if (this.f431769f == r101.f431769f) goto L27;
        return false;
    L27:
        if (this.f431770g == r101.f431770g) goto L30;
        return false;
    L30:
        if (this.f431771h == r101.f431771h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f431764a.hashCode() * 31) + this.f431765b.hashCode()) * 31) + this.f431766c.hashCode()) * 31) + this.f431767d.hashCode()) * 31;
        long r101 = this.f431768e;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        int r103 = 1231;
        if (this.f431769f == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        if (this.f431770g == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r105 + r106) * 31;
        if (this.f431771h == true) goto L15;
        r103 = 1237;
    L15:
        return r107 + r103;
    L9:
        r106 = 1237;
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoubaoMentionUiState(recommend=" + this.f431764a + ", search=" + this.f431765b + ", searchKey=" + this.f431766c + ", requestId=" + this.f431767d + ", searchRefreshVersion=" + this.f431768e + ", showDepartmentInSearch=" + this.f431769f + ", isFromDoubaoBot=" + this.f431770g + ", enableDoubaoMention=" + this.f431771h + ')';
    }

    public /* synthetic */ j(boolean r110, boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        b.c r100 = b.c.f431753a;
    L7:
        if ((r112 & 2) == 0) goto L9;
        b.c r101 = b.c.f431753a;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r112 & 64) == 0) goto L21;
        boolean r113 = false;
    L23:
        if ((r112 & 128) == 0) goto L25;
        boolean r114 = true;
    L26:
        this(r100, r101, r102, r103, 0, false, r113, r114);
        return;
    L25:
        r114 = r111;
        goto L26
    L21:
        r113 = r110;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public j(b r100, b r101, String r102, String r103, long r104, boolean r105, boolean r106, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "recommend");
        Intrinsics.checkNotNullParameter(r101, "search");
        Intrinsics.checkNotNullParameter(r102, "searchKey");
        Intrinsics.checkNotNullParameter(r103, "requestId");
        this.f431764a = r100;
        this.f431765b = r101;
        this.f431766c = r102;
        this.f431767d = r103;
        this.f431768e = r104;
        this.f431769f = r105;
        this.f431770g = r106;
        this.f431771h = r110;
    }

    public static j a(j r110, b r111, b r112, String r113, String r114, long r115, boolean r116, boolean r117, int r118) {
        if ((r118 & 1) == 0) goto L5;
        b r100 = r110.f431764a;
    L7:
        if ((r118 & 2) == 0) goto L9;
        b r101 = r110.f431765b;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r102 = r110.f431766c;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r103 = r110.f431767d;
    L19:
        if ((r118 & 16) == 0) goto L21;
        long r104 = r110.f431768e;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r105 = r110.f431769f;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r106 = r110.f431770g;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r107 = r110.f431771h;
    L34:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "recommend");
        Intrinsics.checkNotNullParameter(r101, "search");
        Intrinsics.checkNotNullParameter(r102, "searchKey");
        Intrinsics.checkNotNullParameter(r103, "requestId");
        return new j(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r117;
        goto L34
    L29:
        r106 = false;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
