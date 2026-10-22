package vb0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f553994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f553995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f553996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f553997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f553998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f553999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f554000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f554001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f554002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f554003j;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L26;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f553994a, r101.f553994a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f553995b, r101.f553995b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f553996c, r101.f553996c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f553997d, r101.f553997d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f553998e, r101.f553998e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f553999f, r101.f553999f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f554000g, r101.f554000g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f554001h, r101.f554001h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f554002i, r101.f554002i) == true) goto L24;
        return false;
    L24:
        if (this.f554003j == r101.f554003j) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        Long r100 = this.f553994a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f553995b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f553996c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f553997d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f553998e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.f553999f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f554000g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f554001h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f554002i;
        if (r125 == null) goto L37;
        r101 = r125.hashCode();
    L37:
        int r126 = (r124 + r101) * 31;
        boolean r127 = this.f554003j;
        ?? r128 = r127;
        if (r127 == false) goto L41;
        r128 = 1;
    L41:
        return r126 + r128;
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
        return "OrderSongUIState(orderSongUnReadNum=" + this.f553994a + ", applyListenUnreadNum=" + this.f553995b + ", applySingUnreadNum=" + this.f553996c + ", multiChorusUnreadNum=" + this.f553997d + ", applyUnreadNum=" + this.f553998e + ", applyTotalNum=" + this.f553999f + ", infoLynxUrl=" + this.f554000g + ", highScoreSongCount=" + this.f554001h + ", isRequestRecommendApi=" + this.f554002i + ", isOrderSongDialogShown=" + this.f554003j + ")";
    }

    public /* synthetic */ a(int r110) {
        this(0L, 0L, 0L, 0L, 0L, 0L, null, null, null, false);
    }

    public a(Long r100, Long r101, Long r102, Long r103, Long r104, Long r105, String r106, String r107, Boolean r108, boolean r110) {
        this.f553994a = r100;
        this.f553995b = r101;
        this.f553996c = r102;
        this.f553997d = r103;
        this.f553998e = r104;
        this.f553999f = r105;
        this.f554000g = r106;
        this.f554001h = r107;
        this.f554002i = r108;
        this.f554003j = r110;
    }

    public static a a(a r110, Long r111, Long r112, Long r113, Long r114, Long r115, Long r116, String r117, String r118, Boolean r210, boolean r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        Long r100 = r110.f553994a;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Long r101 = r110.f553995b;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Long r102 = r110.f553996c;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Long r103 = r110.f553997d;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Long r104 = r110.f553998e;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Long r105 = r110.f553999f;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.f554000g;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.f554001h;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Boolean r119 = r110.f554002i;
    L39:
        if ((r212 & 512) == 0) goto L41;
        boolean r108 = r110.f554003j;
    L42:
        r110.getClass();
        return new a(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L42
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
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
