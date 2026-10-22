package com.ss.android.lark.search.doubao.api.request;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f439999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f440000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f440001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f440002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f440003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f440004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u f440005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f440006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j f440007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f440008j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final n f440009k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final w f440010l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f440011m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f439999a, r101.f439999a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f440000b, r101.f440000b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f440001c, r101.f440001c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f440002d, r101.f440002d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f440003e, r101.f440003e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(null, null) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f440004f, r101.f440004f) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f440005g, r101.f440005g) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f440006h, r101.f440006h) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f440007i, r101.f440007i) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f440008j, r101.f440008j) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f440009k, r101.f440009k) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f440010l, r101.f440010l) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f440011m, r101.f440011m) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f439999a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f440000b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f440001c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        l r110 = this.f440002d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        f r113 = this.f440003e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((r112 + r114) * 31) + 0) * 31;
        p r116 = this.f440004f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        u r119 = this.f440005g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        b r122 = this.f440006h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        j r125 = this.f440007i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        h r128 = this.f440008j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        n r131 = this.f440009k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        w r134 = this.f440010l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        d r137 = this.f440011m;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
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
        return "SearchRequestDslModel(query=" + this.f439999a + ", pageSize=" + this.f440000b + ", tagName=" + this.f440001c + ", layout=" + this.f440002d + ", commonFilter=" + this.f440003e + ", doc=null, message=" + this.f440004f + ", user=" + this.f440005g + ", bot=" + this.f440006h + ", groupChat=" + this.f440007i + ", department=" + this.f440008j + ", mailContact=" + this.f440009k + ", userGroup=" + this.f440010l + ", collaboratorPermissions=" + this.f440011m + ')';
    }

    public s(String r100, Integer r101, String r102, l r103, f r104, p r105, u r106, b r107, j r108, h r110, n r111, w r112, d r113) {
        this.f439999a = r100;
        this.f440000b = r101;
        this.f440001c = r102;
        this.f440002d = r103;
        this.f440003e = r104;
        this.f440004f = r105;
        this.f440005g = r106;
        this.f440006h = r107;
        this.f440007i = r108;
        this.f440008j = r110;
        this.f440009k = r111;
        this.f440010l = r112;
        this.f440011m = r113;
    }
}
