package com.larus.share.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f368923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f368924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f368925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f368926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f368927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f368928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f368929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f368930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f368931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f368932j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f368933k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f368923a, r101.f368923a) == true) goto L12;
        return false;
    L12:
        if (this.f368924b == r101.f368924b) goto L15;
        return false;
    L15:
        if (this.f368925c == r101.f368925c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f368926d, r101.f368926d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f368927e, r101.f368927e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f368928f, r101.f368928f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f368929g, r101.f368929g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f368930h, r101.f368930h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f368931i, r101.f368931i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f368932j, r101.f368932j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f368933k, r101.f368933k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f368923a.hashCode() * 31;
        int r101 = 1231;
        if (this.f368924b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f368925c == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        String r105 = this.f368926d;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f368927e;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f368928f;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f368929g;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        Integer r118 = this.f368930h;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f368931i;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Integer r124 = this.f368932j;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        Integer r127 = this.f368933k;
        if (r127 == null) goto L43;
        r106 = r127.hashCode();
    L43:
        return r126 + r106;
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShareDocPermissionParams(token=" + this.f368923a + ", isPublic=" + this.f368924b + ", isLandscape=" + this.f368925c + ", aipptTaskId=" + this.f368926d + ", presentationId=" + this.f368927e + ", spreadsheetId=" + this.f368928f + ", resourceId=" + this.f368929g + ", resourceType=" + this.f368930h + ", artifactMetaId=" + this.f368931i + ", artifactType=" + this.f368932j + ", fileType=" + this.f368933k + ')';
    }

    public i(String r100, boolean r101, boolean r102, String r103, String r104, String r105, String r106, Integer r110, String r111, Integer r112, Integer r113, int r114) {
        if ((r114 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r114 & 16) == 0) goto L9;
        r104 = null;
    L9:
        if ((r114 & 32) == 0) goto L12;
        r105 = null;
    L12:
        if ((r114 & 64) == 0) goto L15;
        r106 = null;
    L15:
        if ((r114 & 128) == 0) goto L18;
        r110 = null;
    L18:
        if ((r114 & 256) == 0) goto L21;
        r111 = null;
    L21:
        if ((r114 & 512) == 0) goto L24;
        r112 = null;
    L24:
        if ((r114 & 1024) == 0) goto L26;
        r113 = null;
    L26:
        Intrinsics.checkNotNullParameter(r100, "token");
        this.f368923a = r100;
        this.f368924b = r101;
        this.f368925c = r102;
        this.f368926d = r103;
        this.f368927e = r104;
        this.f368928f = r105;
        this.f368929g = r106;
        this.f368930h = r110;
        this.f368931i = r111;
        this.f368932j = r112;
        this.f368933k = r113;
    }
}
