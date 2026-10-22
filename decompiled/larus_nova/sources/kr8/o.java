package kr8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f505868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f505869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f505870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f505871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f505872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f505873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f505874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f505875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f505876i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f505877j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f505878k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f505879l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f505880m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f505881n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f505868a, r101.f505868a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f505869b, r101.f505869b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f505870c, r101.f505870c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f505871d, r101.f505871d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f505872e, r101.f505872e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f505873f, r101.f505873f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f505874g, r101.f505874g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f505875h, r101.f505875h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f505876i, r101.f505876i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f505877j, r101.f505877j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f505878k, r101.f505878k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f505879l, r101.f505879l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f505880m, r101.f505880m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f505881n, r101.f505881n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f505868a.hashCode() * 31) + this.f505869b.hashCode()) * 31) + this.f505870c.hashCode()) * 31;
        String r101 = this.f505871d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f505872e.hashCode()) * 31;
        String r105 = this.f505873f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f505874g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f505875h;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f505876i;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f505877j;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f505878k;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f505879l;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f505880m;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        String r129 = this.f505881n;
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
        return "MusicAppletMobContext(currentPage=" + this.f505868a + ", appEnterMethod=" + this.f505869b + ", appKey=" + this.f505870c + ", doubaoAppsMessageId=" + this.f505871d + ", fromEntrance=" + this.f505872e + ", videoId=" + this.f505873f + ", userId=" + this.f505874g + ", genreId=" + this.f505875h + ", genreName=" + this.f505876i + ", genderId=" + this.f505877j + ", genderName=" + this.f505878k + ", modelId=" + this.f505879l + ", modelName=" + this.f505880m + ", templateId=" + this.f505881n + ')';
    }

    public o(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, String r113, String r114, String r115) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "appEnterMethod");
        Intrinsics.checkNotNullParameter(r102, com.heytap.mcssdk.constant.b.f276376z);
        Intrinsics.checkNotNullParameter(r104, "fromEntrance");
        this.f505868a = r100;
        this.f505869b = r101;
        this.f505870c = r102;
        this.f505871d = r103;
        this.f505872e = r104;
        this.f505873f = r105;
        this.f505874g = r106;
        this.f505875h = r107;
        this.f505876i = r110;
        this.f505877j = r111;
        this.f505878k = r112;
        this.f505879l = r113;
        this.f505880m = r114;
        this.f505881n = r115;
    }
}
