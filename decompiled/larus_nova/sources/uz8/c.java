package uz8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f552209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f552210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f552211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f552212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f552213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f552214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f552215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f552216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f552217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f552218j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f552219k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f552220l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f552221m;

    public c() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f552209a, r101.f552209a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f552210b, r101.f552210b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f552211c, r101.f552211c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f552212d, r101.f552212d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f552213e, r101.f552213e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f552214f, r101.f552214f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f552215g, r101.f552215g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f552216h, r101.f552216h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f552217i, r101.f552217i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f552218j, r101.f552218j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f552219k, r101.f552219k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f552220l, r101.f552220l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f552221m, r101.f552221m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f552209a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f552210b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f552211c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f552212d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f552213e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f552214f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f552215g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f552216h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f552217i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f552218j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f552219k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f552220l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f552221m;
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
        return "MobSubscriptionEntryConfig(enterMethod=" + this.f552209a + ", messageId=" + this.f552210b + ", triggerScene=" + this.f552211c + ", featureKey=" + this.f552212d + ", featureDetail=" + this.f552213e + ", subsPurchaseId=" + this.f552214f + ", thresholdType=" + this.f552215g + ", thresholdValue=" + this.f552216h + ", isBackendCallback=" + this.f552217i + ", comQuotaCostReqId=" + this.f552218j + ", comQuotaCostFkId=" + this.f552219k + ", comWindowGapReqId=" + this.f552220l + ", comWindowGapIntentId=" + this.f552221m + ')';
    }

    public c(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, String r113) {
        this.f552209a = r100;
        this.f552210b = r101;
        this.f552211c = r102;
        this.f552212d = r103;
        this.f552213e = r104;
        this.f552214f = r105;
        this.f552215g = r106;
        this.f552216h = r107;
        this.f552217i = r108;
        this.f552218j = r110;
        this.f552219k = r111;
        this.f552220l = r112;
        this.f552221m = r113;
    }
}
