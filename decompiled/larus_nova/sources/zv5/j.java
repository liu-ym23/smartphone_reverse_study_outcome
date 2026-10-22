package zv5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f573705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f573707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f573708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f573709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f573710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f573711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f573712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f573713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f573714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f573715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f573716l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f573717m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f573718n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f573719o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f573720p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f573721q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f573722r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f573723s;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f573705a, r101.f573705a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573706b, r101.f573706b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f573707c, r101.f573707c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f573708d, r101.f573708d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f573709e, r101.f573709e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f573710f, r101.f573710f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f573711g, r101.f573711g) == true) goto L30;
        return false;
    L30:
        if (this.f573712h == r101.f573712h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f573713i, r101.f573713i) == true) goto L36;
        return false;
    L36:
        if (this.f573714j == r101.f573714j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f573715k, r101.f573715k) == true) goto L42;
        return false;
    L42:
        if (this.f573716l == r101.f573716l) goto L45;
        return false;
    L45:
        if (this.f573717m == r101.f573717m) goto L48;
        return false;
    L48:
        if (this.f573718n == r101.f573718n) goto L51;
        return false;
    L51:
        if (this.f573719o == r101.f573719o) goto L54;
        return false;
    L54:
        if (this.f573720p == r101.f573720p) goto L57;
        return false;
    L57:
        if (this.f573721q == r101.f573721q) goto L60;
        return false;
    L60:
        if (this.f573722r == r101.f573722r) goto L63;
        return false;
    L63:
        if (this.f573723s == r101.f573723s) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f573705a.hashCode() * 31) + this.f573706b.hashCode()) * 31) + this.f573707c.hashCode()) * 31) + this.f573708d.hashCode()) * 31) + this.f573709e.hashCode()) * 31;
        Long r101 = this.f573710f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f573711g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f573712h) * 31;
        Integer r108 = this.f573713i;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (r107 + r102) * 31;
        int r110 = 1231;
        if (this.f573714j == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (((r109 + r111) * 31) + this.f573715k.hashCode()) * 31;
        if (this.f573716l == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        if (this.f573717m == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        if (this.f573718n == false) goto L29;
        int r117 = 1231;
    L30:
        int r118 = (r116 + r117) * 31;
        if (this.f573719o == false) goto L33;
        int r119 = 1231;
    L34:
        int r120 = (r118 + r119) * 31;
        if (this.f573720p == false) goto L37;
        int r121 = 1231;
    L38:
        int r122 = (r120 + r121) * 31;
        if (this.f573721q == false) goto L41;
        int r123 = 1231;
    L42:
        int r124 = (r122 + r123) * 31;
        if (this.f573722r == false) goto L45;
        int r125 = 1231;
    L46:
        int r126 = (r124 + r125) * 31;
        if (this.f573723s == true) goto L51;
        r110 = 1237;
    L51:
        return r126 + r110;
    L45:
        r125 = 1237;
        goto L46
    L41:
        r123 = 1237;
        goto L42
    L37:
        r121 = 1237;
        goto L38
    L33:
        r119 = 1237;
        goto L34
    L29:
        r117 = 1237;
        goto L30
    L25:
        r115 = 1237;
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = 1237;
        goto L18
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchMixedFeedChat(chatId=" + this.f573705a + ", userId=" + this.f573706b + ", avatarUrl=" + this.f573707c + ", title=" + this.f573708d + ", preview=" + this.f573709e + ", displayTime=" + this.f573710f + ", backupUpdateTimeMs=" + this.f573711g + ", unreadCount=" + this.f573712h + ", chatType=" + this.f573713i + ", isShortcut=" + this.f573714j + ", avatarKey=" + this.f573715k + ", isPublic=" + this.f573716l + ", isDepartment=" + this.f573717m + ", isResigned=" + this.f573718n + ", isFrozen=" + this.f573719o + ", isBlocked=" + this.f573720p + ", isOnLeave=" + this.f573721q + ", isExternal=" + this.f573722r + ", isAgent=" + this.f573723s + ')';
    }

    public j(String r100, String r110, String r111, String r112, String r113, Long r114, Long r115, int r116, Integer r117, boolean r118, String r119, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r110, "userId");
        Intrinsics.checkNotNullParameter(r111, "avatarUrl");
        Intrinsics.checkNotNullParameter(r112, "title");
        Intrinsics.checkNotNullParameter(r113, "preview");
        Intrinsics.checkNotNullParameter(r119, "avatarKey");
        this.f573705a = r100;
        this.f573706b = r110;
        this.f573707c = r111;
        this.f573708d = r112;
        this.f573709e = r113;
        this.f573710f = r114;
        this.f573711g = r115;
        this.f573712h = r116;
        this.f573713i = r117;
        this.f573714j = r118;
        this.f573715k = r119;
        this.f573716l = r210;
        this.f573717m = r211;
        this.f573718n = r212;
        this.f573719o = r213;
        this.f573720p = r214;
        this.f573721q = r215;
        this.f573722r = r216;
        this.f573723s = r217;
    }
}
