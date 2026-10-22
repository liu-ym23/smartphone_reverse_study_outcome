package tl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f546600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f546601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f546602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f546603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f546604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f546605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f546606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f546607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f546608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f546609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f546610k;

    public a() {
        this(null, null, null, null, null, null, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L28;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f546600a, r101.f546600a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f546601b, r101.f546601b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f546602c, r101.f546602c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f546603d, r101.f546603d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f546604e, r101.f546604e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f546605f, r101.f546605f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f546606g, r101.f546606g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f546607h, r101.f546607h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f546608i, r101.f546608i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f546609j, r101.f546609j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f546610k, r101.f546610k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.f546600a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f546601b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f546602c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f546603d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f546604e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.f546605f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f546606g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f546607h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.f546608i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.f546609j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f546610k;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShareInfoRequestParam(orderId=" + this.f546600a + ", productId=" + this.f546601b + ", content=" + this.f546602c + ", rankShop=" + this.f546603d + ", rankLogistic=" + this.f546604e + ", rankGood=" + this.f546605f + ", customChoiceTitle=" + this.f546606g + ", customChoiceOption=" + this.f546607h + ", price=" + this.f546608i + ", sales=" + this.f546609j + ", imageUrl=" + this.f546610k + ")";
    }

    public a(Long r100, Long r101, String r102, Long r103, Long r104, Long r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 32) == 0) goto L20;
        r105 = null;
    L20:
        this.f546600a = r100;
        this.f546601b = r101;
        this.f546602c = r102;
        this.f546603d = r103;
        this.f546604e = r104;
        this.f546605f = r105;
        this.f546606g = null;
        this.f546607h = null;
        this.f546608i = null;
        this.f546609j = null;
        this.f546610k = null;
    }
}
