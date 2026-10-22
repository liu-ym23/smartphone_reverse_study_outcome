package kw9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f506431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f506432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f506433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f506434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f506435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f506436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f506437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f506438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f506439k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f506440l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f506441m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f506442n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f506443o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f506444p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f506445q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f506446r;

    public e() {
        this(null, null, null, null, null, null, 262143);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f506429a, r101.f506429a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506430b, r101.f506430b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506431c, r101.f506431c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506432d, r101.f506432d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506433e, r101.f506433e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f506434f, r101.f506434f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f506435g, r101.f506435g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f506436h, r101.f506436h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f506437i, r101.f506437i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f506438j, r101.f506438j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f506439k, r101.f506439k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f506440l, r101.f506440l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f506441m, r101.f506441m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f506442n, r101.f506442n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f506443o, r101.f506443o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f506444p, r101.f506444p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f506445q, r101.f506445q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f506446r, r101.f506446r) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f506429a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f506430b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f506431c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f506432d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f506433e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f506434f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (((((r115 + r117) * 31) + this.f506435g.hashCode()) * 31) + this.f506436h.hashCode()) * 31;
        Integer r119 = this.f506437i;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (((((((((((((r118 + r120) * 31) + this.f506438j.hashCode()) * 31) + this.f506439k.hashCode()) * 31) + this.f506440l.hashCode()) * 31) + this.f506441m.hashCode()) * 31) + this.f506442n.hashCode()) * 31) + this.f506443o.hashCode()) * 31;
        String r122 = this.f506444p;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f506445q;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f506446r;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SheetDownloadParams(token=" + this.f506429a + ", currentPage=" + this.f506430b + ", previousPage=" + this.f506431c + ", artifactMetaId=" + this.f506432d + ", artifactType=" + this.f506433e + ", aipptTaskId=" + this.f506434f + ", presentationId=" + this.f506435g + ", resourceId=" + this.f506436h + ", resourceType=" + this.f506437i + ", canvasType=" + this.f506438j + ", userType=" + this.f506439k + ", messageId=" + this.f506440l + ", conversationId=" + this.f506441m + ", botId=" + this.f506442n + ", sectionId=" + this.f506443o + ", artifactCreateMethod=" + this.f506444p + ", clickFrom=" + this.f506445q + ", spreadsheetVersion=" + this.f506446r + ')';
    }

    public /* synthetic */ e(String r210, String r211, String r212, String r213, String r214, String r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r216 & 32) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r216 & 64) == 0) goto L21;
        String r110 = "";
    L23:
        if ((r216 & 128) == 0) goto L25;
        String r111 = "";
    L27:
        if ((r216 & 512) == 0) goto L29;
        String r112 = "";
    L31:
        if ((r216 & 1024) == 0) goto L33;
        String r113 = "";
    L35:
        if ((r216 & 2048) == 0) goto L37;
        String r114 = "";
    L39:
        if ((r216 & 4096) == 0) goto L41;
        String r115 = "";
    L43:
        if ((r216 & 8192) == 0) goto L45;
        String r116 = "";
    L47:
        if ((r216 & 16384) == 0) goto L49;
        String r117 = "";
    L51:
        if ((r216 & 65536) == 0) goto L53;
        String r217 = null;
    L54:
        this(r100, r101, r102, null, null, r103, r110, r111, null, r112, r113, r114, r115, r116, r117, null, r217, null);
        return;
    L53:
        r217 = r215;
        goto L54
    L49:
        r117 = null;
        goto L51
    L45:
        r116 = r214;
        goto L47
    L41:
        r115 = r213;
        goto L43
    L37:
        r114 = null;
        goto L39
    L33:
        r113 = null;
        goto L35
    L29:
        r112 = null;
        goto L31
    L25:
        r111 = null;
        goto L27
    L21:
        r110 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public e(String r110, String r111, String r112, String r113, Integer r114, String r115, String r116, String r117, Integer r118, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218) {
        Intrinsics.checkNotNullParameter(r116, "presentationId");
        Intrinsics.checkNotNullParameter(r117, "resourceId");
        Intrinsics.checkNotNullParameter(r210, "canvasType");
        Intrinsics.checkNotNullParameter(r211, "userType");
        Intrinsics.checkNotNullParameter(r212, "messageId");
        Intrinsics.checkNotNullParameter(r213, "conversationId");
        Intrinsics.checkNotNullParameter(r214, "botId");
        Intrinsics.checkNotNullParameter(r215, "sectionId");
        this.f506429a = r110;
        this.f506430b = r111;
        this.f506431c = r112;
        this.f506432d = r113;
        this.f506433e = r114;
        this.f506434f = r115;
        this.f506435g = r116;
        this.f506436h = r117;
        this.f506437i = r118;
        this.f506438j = r210;
        this.f506439k = r211;
        this.f506440l = r212;
        this.f506441m = r213;
        this.f506442n = r214;
        this.f506443o = r215;
        this.f506444p = r216;
        this.f506445q = r217;
        this.f506446r = r218;
    }
}
