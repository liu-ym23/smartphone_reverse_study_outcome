package com.bytedance.locallife.live.card;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f259212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nv6.n f259213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nv6.t f259214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f259215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f259216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f259217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f259218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f259219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f259220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f259221j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f259222k;

    public a() {
        this(null, null, null, 0, 0, 0, null, null, 0, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f259212a, r101.f259212a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f259213b, r101.f259213b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f259214c, r101.f259214c) == true) goto L18;
        return false;
    L18:
        if (this.f259215d == r101.f259215d) goto L21;
        return false;
    L21:
        if (this.f259216e == r101.f259216e) goto L24;
        return false;
    L24:
        if (this.f259217f == r101.f259217f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f259218g, r101.f259218g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f259219h, r101.f259219h) == true) goto L33;
        return false;
    L33:
        if (this.f259220i == r101.f259220i) goto L36;
        return false;
    L36:
        if (this.f259221j == r101.f259221j) goto L39;
        return false;
    L39:
        if (this.f259222k == r101.f259222k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f259212a.hashCode() * 31;
        nv6.n r101 = this.f259213b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        nv6.t r105 = this.f259214c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        long r107 = this.f259215d;
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f259216e;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f259217f;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        String r113 = this.f259218g;
        if (r113 != null) goto L13;
        int r114 = 0;
    L14:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f259219h;
        if (r116 == null) goto L18;
        r102 = r116.hashCode();
    L18:
        int r117 = (r115 + r102) * 31;
        long r118 = this.f259220i;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = this.f259221j;
        return ((r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31) + this.f259222k;
    L13:
        r114 = r113.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CardData(currentState=" + this.f259212a + ", groupPurchaseCardInfo=" + this.f259213b + ", groupPurchaseExtra=" + this.f259214c + ", requestStartTime=" + this.f259215d + ", requestDuration=" + this.f259216e + ", requestTime=" + this.f259217f + ", requestFrom=" + this.f259218g + ", from=" + this.f259219h + ", requestEndTime=" + this.f259220i + ", livePlatformDuration=" + this.f259221j + ", enterType=" + this.f259222k + ')';
    }

    public a(b r110, nv6.n r111, nv6.t r112, long r210, long r211, long r212, String r213, String r214, long r215, int r310) {
        if ((r310 & 1) == 0) goto L5;
        b r100 = b.f259223a;
    L6:
        String r101 = null;
        if ((r310 & 2) == 0) goto L9;
        nv6.n r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        nv6.t r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        long r104 = 0;
    L19:
        if ((r310 & 16) == 0) goto L21;
        long r113 = 0;
    L23:
        if ((r310 & 32) == 0) goto L25;
        long r114 = 0;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r105 = null;
    L31:
        if ((r310 & 128) != 0) goto L35;
        r101 = r214;
    L35:
        if ((r310 & 256) == 0) goto L37;
        long r106 = 0;
    L38:
        Intrinsics.checkNotNullParameter(r100, "currentState");
        this.f259212a = r100;
        this.f259213b = r102;
        this.f259214c = r103;
        this.f259215d = r104;
        this.f259216e = r113;
        this.f259217f = r114;
        this.f259218g = r105;
        this.f259219h = r101;
        this.f259220i = r106;
        this.f259221j = 0;
        this.f259222k = 0;
        return;
    L37:
        r106 = r215;
        goto L38
    L29:
        r105 = r213;
        goto L31
    L25:
        r114 = r212;
        goto L27
    L21:
        r113 = r211;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
