package com.larus.bmhome.chat.doclink;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f302909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f302910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f302911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f302912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f302913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f302914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f302915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f302916h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f302917i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f302918j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f302919k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f302920l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f302921m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f302909a, r101.f302909a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f302910b, r101.f302910b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f302911c, r101.f302911c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f302912d, r101.f302912d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f302913e, r101.f302913e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f302914f, r101.f302914f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f302915g, r101.f302915g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f302916h, r101.f302916h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f302917i, r101.f302917i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f302918j, r101.f302918j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f302919k, r101.f302919k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f302920l, r101.f302920l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f302921m, r101.f302921m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f302909a.hashCode() * 31) + this.f302910b.hashCode()) * 31) + this.f302911c.hashCode()) * 31;
        String r101 = this.f302912d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f302913e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f302914f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f302915g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f302916h;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f302917i;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f302918j;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f302919k;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f302920l;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        String r129 = this.f302921m;
        if (r129 == null) goto L43;
        r102 = r129.hashCode();
    L43:
        return r128 + r102;
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
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
        return "MessageDocPreviewEntity(previewId=" + this.f302909a + ", title=" + this.f302910b + ", url=" + this.f302911c + ", iconKey=" + this.f302912d + ", iconColorToken=" + this.f302913e + ", iconColorValue=" + this.f302914f + ", iconColorKeyType=" + this.f302915g + ", iconColorKeyValue=" + this.f302916h + ", iconColorKeyAlpha=" + this.f302917i + ", iconUnicode=" + this.f302918j + ", netIconKey=" + this.f302919k + ", fileType=" + this.f302920l + ", matchedUrl=" + this.f302921m + ')';
    }

    public static h a(h r110, String r111, String r112, String r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        String r100 = r110.f302909a;
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r101 = r110.f302910b;
    L11:
        if ((r211 & 4) == 0) goto L13;
        String r102 = r110.f302911c;
    L15:
        if ((r211 & 8) == 0) goto L17;
        String r103 = r110.f302912d;
    L19:
        if ((r211 & 16) == 0) goto L21;
        String r104 = r110.f302913e;
    L23:
        if ((r211 & 32) == 0) goto L25;
        Integer r105 = r110.f302914f;
    L27:
        if ((r211 & 64) == 0) goto L29;
        Integer r113 = r110.f302915g;
    L31:
        if ((r211 & 128) == 0) goto L33;
        Integer r114 = r110.f302916h;
    L35:
        if ((r211 & 256) == 0) goto L37;
        Integer r115 = r110.f302917i;
    L39:
        if ((r211 & 512) == 0) goto L41;
        String r116 = r110.f302918j;
    L43:
        if ((r211 & 1024) == 0) goto L45;
        String r117 = r110.f302919k;
    L47:
        if ((r211 & 2048) == 0) goto L49;
        String r118 = r110.f302920l;
    L51:
        if ((r211 & 4096) == 0) goto L53;
        String r119 = r110.f302921m;
    L54:
        Intrinsics.checkNotNullParameter(r100, "previewId");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "url");
        return new h(r100, r101, r102, r103, r104, r105, r113, r114, r115, r116, r117, r118, r119);
    L53:
        r119 = r210;
        goto L54
    L49:
        r118 = null;
        goto L51
    L45:
        r117 = null;
        goto L47
    L41:
        r116 = null;
        goto L43
    L37:
        r115 = null;
        goto L39
    L33:
        r114 = null;
        goto L35
    L29:
        r113 = null;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public h(String r100, String r101, String r102, String r103, String r104, Integer r105, Integer r106, Integer r107, Integer r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "previewId");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "url");
        this.f302909a = r100;
        this.f302910b = r101;
        this.f302911c = r102;
        this.f302912d = r103;
        this.f302913e = r104;
        this.f302914f = r105;
        this.f302915g = r106;
        this.f302916h = r107;
        this.f302917i = r110;
        this.f302918j = r111;
        this.f302919k = r112;
        this.f302920l = r113;
        this.f302921m = r114;
    }
}
