package com.larus.office.card.sheet;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f361599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f361600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f361601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f361602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f361603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f361604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f361605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f361606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f361607i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f361608j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f361609k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f361610l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f361611m;

    public a() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 8191);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f361599a, r101.f361599a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f361600b, r101.f361600b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f361601c, r101.f361601c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f361602d, r101.f361602d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f361603e, r101.f361603e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f361604f, r101.f361604f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f361605g, r101.f361605g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f361606h, r101.f361606h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f361607i, r101.f361607i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f361608j, r101.f361608j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f361609k, r101.f361609k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f361610l, r101.f361610l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f361611m, r101.f361611m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f361599a.hashCode() * 31) + this.f361600b.hashCode()) * 31) + this.f361601c.hashCode()) * 31;
        String r101 = this.f361602d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f361603e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((((((((r104 + r106) * 31) + this.f361604f.hashCode()) * 31) + this.f361605g.hashCode()) * 31) + this.f361606h.hashCode()) * 31) + this.f361607i.hashCode()) * 31) + this.f361608j.hashCode()) * 31;
        String r108 = this.f361609k;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f361610l;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f361611m;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeCardSheetDownloadParams(token=" + this.f361599a + ", fileName=" + this.f361600b + ", resourceId=" + this.f361601c + ", artifactMetaId=" + this.f361602d + ", artifactType=" + this.f361603e + ", userType=" + this.f361604f + ", messageId=" + this.f361605g + ", conversationId=" + this.f361606h + ", botId=" + this.f361607i + ", sectionId=" + this.f361608j + ", clickFrom=" + this.f361609k + ", spreadsheetVersion=" + this.f361610l + ", resourceType=" + this.f361611m + ')';
    }

    public /* synthetic */ a(String r110, String r111, String r210, String r211, Integer r212, String r213, String r214, String r215, String r216, String r217, String r218, Integer r219, int r310) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r112 = "";
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r113 = "";
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r114 = "";
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r115 = "";
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Integer r118 = null;
    L54:
        this(r100, r101, r102, r103, r104, r105, r112, r113, r114, r115, r116, r117, r118);
        return;
    L53:
        r118 = r219;
        goto L54
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r113 = r214;
        goto L35
    L29:
        r112 = r213;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public a(String r100, String r101, String r102, String r103, Integer r104, String r105, String r106, String r107, String r110, String r111, String r112, String r113, Integer r114) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r102, "resourceId");
        Intrinsics.checkNotNullParameter(r105, "userType");
        Intrinsics.checkNotNullParameter(r106, "messageId");
        Intrinsics.checkNotNullParameter(r107, "conversationId");
        Intrinsics.checkNotNullParameter(r110, "botId");
        Intrinsics.checkNotNullParameter(r111, "sectionId");
        this.f361599a = r100;
        this.f361600b = r101;
        this.f361601c = r102;
        this.f361602d = r103;
        this.f361603e = r104;
        this.f361604f = r105;
        this.f361605g = r106;
        this.f361606h = r107;
        this.f361607i = r110;
        this.f361608j = r111;
        this.f361609k = r112;
        this.f361610l = r113;
        this.f361611m = r114;
    }
}
