package w33;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f558129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f558130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f558131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f558132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f558133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f558134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f558135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f558136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f558137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f558138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f558139k;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L28;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f558129a, r101.f558129a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f558130b, r101.f558130b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f558131c, r101.f558131c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558132d, r101.f558132d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f558133e, r101.f558133e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f558134f, r101.f558134f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f558135g, r101.f558135g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f558136h, r101.f558136h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f558137i, r101.f558137i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f558138j, r101.f558138j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f558139k, r101.f558139k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.f558129a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f558130b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f558131c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f558132d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f558133e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.f558134f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.f558135g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.f558136h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.f558137i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.f558138j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Long r131 = this.f558139k;
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
        return "FlowTimestamp(starterStart=" + this.f558129a + ", queryFetchStart=" + this.f558130b + ", queryFetchEnd=" + this.f558131c + ", containerStart=" + this.f558132d + ", buildRequestStart=" + this.f558133e + ", buildRequestEnd=" + this.f558134f + ", protocolDispatchEnd=" + this.f558135g + ", pageDidMount=" + this.f558136h + ", renderFinished=" + this.f558137i + ", respParseStart=" + this.f558138j + ", respParseEnd=" + this.f558139k + ")";
    }

    public /* synthetic */ d(int r110) {
        this(null, null, null, null, null, null, null, null, null, null, null);
    }

    public d(Long r100, Long r101, Long r102, Long r103, Long r104, Long r105, Long r106, Long r107, Long r108, Long r110, Long r111) {
        this.f558129a = r100;
        this.f558130b = r101;
        this.f558131c = r102;
        this.f558132d = r103;
        this.f558133e = r104;
        this.f558134f = r105;
        this.f558135g = r106;
        this.f558136h = r107;
        this.f558137i = r108;
        this.f558138j = r110;
        this.f558139k = r111;
    }

    public static d a(d r110, Long r111, Long r112, Long r113, Long r114, Long r115, Long r116, Long r117, Long r210, Long r211, Long r212, Long r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        Long r100 = r110.f558129a;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Long r101 = r110.f558130b;
    L11:
        if ((r214 & 4) == 0) goto L13;
        Long r102 = r110.f558131c;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Long r103 = r110.f558132d;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Long r104 = r110.f558133e;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Long r105 = r110.f558134f;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Long r106 = r110.f558135g;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Long r107 = r110.f558136h;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Long r118 = r110.f558137i;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Long r119 = r110.f558138j;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Long r108 = r110.f558139k;
    L47:
        return new d(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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
