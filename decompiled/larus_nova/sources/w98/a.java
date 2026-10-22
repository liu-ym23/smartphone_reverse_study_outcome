package w98;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f558745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f558746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f558747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f558748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f558749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f558750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f558751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f558752h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f558753i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f558754j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f558755k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f558756l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f558757m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f558758n;

    public a() {
        this(null, null, null, 0, 16383);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f558745a, r101.f558745a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558746b, r101.f558746b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558747c, r101.f558747c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f558748d, r101.f558748d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f558749e, r101.f558749e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f558750f, r101.f558750f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f558751g, r101.f558751g) == true) goto L30;
        return false;
    L30:
        if (this.f558752h == r101.f558752h) goto L33;
        return false;
    L33:
        if (this.f558753i == r101.f558753i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f558754j, r101.f558754j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f558755k, r101.f558755k) == true) goto L42;
        return false;
    L42:
        if (this.f558756l == r101.f558756l) goto L45;
        return false;
    L45:
        if (this.f558757m == r101.f558757m) goto L48;
        return false;
    L48:
        if (this.f558758n == r101.f558758n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f558745a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f558746b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f558747c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f558748d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f558749e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.f558750f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.f558751g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (((((r118 + r120) * 31) + this.f558752h) * 31) + this.f558753i) * 31;
        Long r122 = this.f558754j;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        b r125 = this.f558755k;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        int r126 = (((r124 + r101) * 31) + this.f558756l) * 31;
        if (this.f558757m == false) goto L41;
        int r127 = 1231;
    L43:
        return ((r126 + r127) * 31) + this.f558758n;
    L41:
        r127 = 1237;
        goto L43
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
        return "LiveAITraceModel(startTime=" + this.f558745a + ", wakeStartTime=" + this.f558746b + ", p2pConnectionDurationMillis=" + this.f558747c + ", onConnectFinishTime=" + this.f558748d + ", onFirstVideoIFrameReceivedTime=" + this.f558749e + ", onFirstVideoCodecInfoReceivedTime=" + this.f558750f + ", onFirstFileDownlinkReceivedTime=" + this.f558751g + ", frameCount=" + this.f558752h + ", fps=" + this.f558753i + ", disconnectTime=" + this.f558754j + ", mirrorData=" + this.f558755k + ", requestKeyFrameCount=" + this.f558756l + ", hasReportedVideoInit=" + this.f558757m + ", wakeMode=" + this.f558758n + ')';
    }

    public a(Long r100, Long r101, Long r102, int r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 256) == 0) goto L14;
        int r105 = 2;
    L16:
        if ((r104 & 8192) == 0) goto L18;
        r103 = 0;
    L18:
        this.f558745a = r100;
        this.f558746b = r101;
        this.f558747c = r102;
        this.f558748d = null;
        this.f558749e = null;
        this.f558750f = null;
        this.f558751g = null;
        this.f558752h = 0;
        this.f558753i = r105;
        this.f558754j = null;
        this.f558755k = null;
        this.f558756l = 0;
        this.f558757m = false;
        this.f558758n = r103;
        return;
    L14:
        r105 = 0;
        goto L16
    }
}
