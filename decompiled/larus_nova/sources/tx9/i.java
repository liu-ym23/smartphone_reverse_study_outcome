package tx9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f547860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f547861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f547862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f547863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f547864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f547865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f547866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f547867i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f547868j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f547869k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f547870l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f547871m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f547872n;

    public i() {
        this(null, null, null, null, null, "record", null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f547859a, r101.f547859a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547860b, r101.f547860b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f547861c, r101.f547861c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f547862d, r101.f547862d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f547863e, r101.f547863e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f547864f, r101.f547864f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f547865g, r101.f547865g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f547866h, r101.f547866h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f547867i, r101.f547867i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f547868j, r101.f547868j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f547869k, r101.f547869k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f547870l, r101.f547870l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f547871m, r101.f547871m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f547872n, r101.f547872n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f547859a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f547860b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f547861c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f547862d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f547863e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((r112 + r114) * 31) + this.f547864f.hashCode()) * 31;
        Integer r116 = this.f547865g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f547866h;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f547867i;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f547868j;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f547869k;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f547870l;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.f547871m;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f547872n;
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
        return "AudioRecordBlockFunnelContext(recordId=" + this.f547859a + ", recordIdV2=" + this.f547860b + ", messageId=" + this.f547861c + ", replyMessageId=" + this.f547862d + ", conversationId=" + this.f547863e + ", scene=" + this.f547864f + ", blockType=" + this.f547865g + ", blockId=" + this.f547866h + ", recordMinutesBlockStatus=" + this.f547867i + ", deviceId=" + this.f547868j + ", userId=" + this.f547869k + ", recordCreateDid=" + this.f547870l + ", serverFailCode=" + this.f547871m + ", serverFailInfo=" + this.f547872n + ')';
    }

    public static i a(i r110, String r111) {
        String r100 = r110.f547859a;
        String r101 = r110.f547861c;
        String r102 = r110.f547862d;
        String r103 = r110.f547863e;
        String r104 = r110.f547864f;
        Integer r105 = r110.f547865g;
        String r106 = r110.f547866h;
        Integer r107 = r110.f547867i;
        String r112 = r110.f547868j;
        String r113 = r110.f547869k;
        String r114 = r110.f547870l;
        Integer r115 = r110.f547871m;
        String r116 = r110.f547872n;
        Intrinsics.checkNotNullParameter(r104, "scene");
        return new i(r100, r111, r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r115, r116);
    }

    public i(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106, String r107, Integer r110, String r111, String r112, String r113, Integer r114, String r115) {
        Intrinsics.checkNotNullParameter(r105, "scene");
        this.f547859a = r100;
        this.f547860b = r101;
        this.f547861c = r102;
        this.f547862d = r103;
        this.f547863e = r104;
        this.f547864f = r105;
        this.f547865g = r106;
        this.f547866h = r107;
        this.f547867i = r110;
        this.f547868j = r111;
        this.f547869k = r112;
        this.f547870l = r113;
        this.f547871m = r114;
        this.f547872n = r115;
    }
}
