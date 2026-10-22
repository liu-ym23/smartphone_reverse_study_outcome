package kf2;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f503171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f503172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f503173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f503174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f503175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f503176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f503177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f503178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f503179i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f503180j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f503181k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f503182l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f503183m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f503184n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f503185o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f503186p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f503187q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L40;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f503171a, r101.f503171a) == true) goto L8;
        return false;
    L8:
        if (this.f503172b == r101.f503172b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f503173c, r101.f503173c) == true) goto L12;
        return false;
    L12:
        if (this.f503174d == r101.f503174d) goto L14;
        return false;
    L14:
        if (this.f503175e == r101.f503175e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f503176f, r101.f503176f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f503177g, r101.f503177g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f503178h, r101.f503178h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f503179i, r101.f503179i) == true) goto L24;
        return false;
    L24:
        if (this.f503180j == r101.f503180j) goto L26;
        return false;
    L26:
        if (this.f503181k == r101.f503181k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f503182l, r101.f503182l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f503183m, r101.f503183m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f503184n, r101.f503184n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f503185o, r101.f503185o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f503186p, r101.f503186p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f503187q, r101.f503187q) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f503171a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f503172b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f503173c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        long r108 = this.f503174d;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f503175e;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.f503176f;
        if (r112 == null) goto L13;
        int r113 = r112.hashCode();
    L14:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f503177g;
        if (r115 == null) goto L17;
        int r116 = r115.hashCode();
    L18:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f503178h;
        if (r118 == null) goto L21;
        int r119 = r118.hashCode();
    L22:
        int r120 = (r117 + r119) * 31;
        Map<String, Object> r121 = this.f503179i;
        if (r121 == null) goto L25;
        int r122 = r121.hashCode();
    L26:
        int r123 = (r120 + r122) * 31;
        long r124 = this.f503180j;
        int r125 = (r123 + ((int) (r124 ^ (r124 >>> 32)))) * 31;
        long r126 = this.f503181k;
        int r127 = (r125 + ((int) (r126 ^ (r126 >>> 32)))) * 31;
        String r128 = this.f503182l;
        if (r128 == null) goto L29;
        int r129 = r128.hashCode();
    L30:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f503183m;
        if (r131 == null) goto L33;
        int r132 = r131.hashCode();
    L34:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f503184n;
        if (r134 == null) goto L37;
        int r135 = r134.hashCode();
    L38:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f503185o;
        if (r137 == null) goto L41;
        int r138 = r137.hashCode();
    L42:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f503186p;
        if (r140 == null) goto L45;
        int r141 = r140.hashCode();
    L46:
        int r142 = (r139 + r141) * 31;
        String r143 = this.f503187q;
        if (r143 == null) goto L50;
        r101 = r143.hashCode();
    L50:
        return r142 + r101;
    L45:
        r141 = 0;
        goto L46
    L41:
        r138 = 0;
        goto L42
    L37:
        r135 = 0;
        goto L38
    L33:
        r132 = 0;
        goto L34
    L29:
        r129 = 0;
        goto L30
    L25:
        r122 = 0;
        goto L26
    L21:
        r119 = 0;
        goto L22
    L17:
        r116 = 0;
        goto L18
    L13:
        r113 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RequestParam(url=" + this.f503171a + ", maxTime=" + this.f503172b + ", reqFrom=" + this.f503173c + ", isDraw=" + this.f503174d + ", roomId=" + this.f503175e + ", anchorId=" + this.f503176f + ", enterSource=" + this.f503177g + ", exemptImpressionGidList=" + this.f503178h + ", forceMap=" + this.f503179i + ", groupId=" + this.f503180j + ", groupType=" + this.f503181k + ", featureSequence=" + this.f503182l + ", skipFeatureSequence=" + this.f503183m + ", impressionRoomIds=" + this.f503184n + ", innerImprGids=" + this.f503185o + ", retryType=" + this.f503186p + ", cutKey=" + this.f503187q + ")";
    }

    public h(String r110, long r111, String r112, long r113, long r114, String r210, String r211, String r212, Map<String, ? extends Object> r213, long r214, long r215, String r216, String r310, String r311, String r312, String r313, String r314) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r112, "reqFrom");
        Intrinsics.checkNotNullParameter(r210, "anchorId");
        Intrinsics.checkNotNullParameter(r211, "enterSource");
        Intrinsics.checkNotNullParameter(r212, "exemptImpressionGidList");
        Intrinsics.checkNotNullParameter(r213, "forceMap");
        Intrinsics.checkNotNullParameter(r216, "featureSequence");
        Intrinsics.checkNotNullParameter(r310, "skipFeatureSequence");
        Intrinsics.checkNotNullParameter(r311, "impressionRoomIds");
        this.f503171a = r110;
        this.f503172b = r111;
        this.f503173c = r112;
        this.f503174d = r113;
        this.f503175e = r114;
        this.f503176f = r210;
        this.f503177g = r211;
        this.f503178h = r212;
        this.f503179i = r213;
        this.f503180j = r214;
        this.f503181k = r215;
        this.f503182l = r216;
        this.f503183m = r310;
        this.f503184n = r311;
        this.f503185o = r312;
        this.f503186p = r313;
        this.f503187q = r314;
    }
}
