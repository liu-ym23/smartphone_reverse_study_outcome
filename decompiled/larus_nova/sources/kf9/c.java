package kf9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f503218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f503219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f503220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f503221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f503222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f503223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f503224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f503225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f503226i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f503227j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f503228k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f503229l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f503230m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f503231n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f503232o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f503233p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f503234q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final h f503235r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final h f503236s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f503237t;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f503218a, r101.f503218a) == true) goto L12;
        return false;
    L12:
        if (this.f503219b == r101.f503219b) goto L15;
        return false;
    L15:
        if (this.f503220c == r101.f503220c) goto L18;
        return false;
    L18:
        if (this.f503221d == r101.f503221d) goto L21;
        return false;
    L21:
        if (this.f503222e == r101.f503222e) goto L24;
        return false;
    L24:
        if (this.f503223f == r101.f503223f) goto L27;
        return false;
    L27:
        if (this.f503224g == r101.f503224g) goto L30;
        return false;
    L30:
        if (this.f503225h == r101.f503225h) goto L33;
        return false;
    L33:
        if (this.f503226i == r101.f503226i) goto L36;
        return false;
    L36:
        if (this.f503227j == r101.f503227j) goto L39;
        return false;
    L39:
        if (this.f503228k == r101.f503228k) goto L42;
        return false;
    L42:
        if (this.f503229l == r101.f503229l) goto L45;
        return false;
    L45:
        if (this.f503230m == r101.f503230m) goto L48;
        return false;
    L48:
        if (this.f503231n == r101.f503231n) goto L51;
        return false;
    L51:
        if (this.f503232o == r101.f503232o) goto L54;
        return false;
    L54:
        if (this.f503233p == r101.f503233p) goto L57;
        return false;
    L57:
        if (this.f503234q == r101.f503234q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f503235r, r101.f503235r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f503236s, r101.f503236s) == true) goto L66;
        return false;
    L66:
        if (this.f503237t == r101.f503237t) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f503218a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.f503219b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f503220c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f503221d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f503222e;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f503223f;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f503224g;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        int r114 = 1231;
        if (this.f503225h == false) goto L9;
        int r115 = 1231;
    L10:
        long r116 = this.f503226i;
        int r117 = (((r113 + r115) * 31) + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.f503227j;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = this.f503228k;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = this.f503229l;
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        long r124 = this.f503230m;
        int r125 = (r123 + ((int) (r124 ^ (r124 >>> 32)))) * 31;
        long r126 = this.f503231n;
        int r127 = (r125 + ((int) (r126 ^ (r126 >>> 32)))) * 31;
        long r128 = this.f503232o;
        int r129 = (r127 + ((int) (r128 ^ (r128 >>> 32)))) * 31;
        long r130 = this.f503233p;
        int r131 = (r129 + ((int) (r130 ^ (r130 >>> 32)))) * 31;
        if (this.f503234q == false) goto L13;
        int r132 = 1231;
    L14:
        int r133 = (((((r131 + r132) * 31) + this.f503235r.hashCode()) * 31) + this.f503236s.hashCode()) * 31;
        if (this.f503237t == true) goto L19;
        r114 = 1237;
    L19:
        return r133 + r114;
    L13:
        r132 = 1237;
        goto L14
    L9:
        r115 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AVQueryTraceData(asrTaskId=" + this.f503218a + ", queryRound=" + this.f503219b + ", startListenTimestampMs=" + this.f503220c + ", queryBeginDuration=" + this.f503221d + ", queryFirstDuration=" + this.f503222e + ", softVadTimestampMs=" + this.f503223f + ", hardVadTimestampMs=" + this.f503224g + ", isHitPreQuery=" + this.f503225h + ", lastRespCostTime=" + this.f503226i + ", prefetchBacktrackTime=" + this.f503227j + ", userLastAudioClientTimestampMs=" + this.f503228k + ", answerStartDuration=" + this.f503229l + ", asrDuration=" + this.f503230m + ", queryEndDuration=" + this.f503231n + ", queryEndTimestampMs=" + this.f503232o + ", queryFullDuration=" + this.f503233p + ", isQueryFirstReceived=" + this.f503234q + ", isQueryFirstReport=" + this.f503235r + ", isVideoQualityReport=" + this.f503236s + ", replyPair=" + this.f503237t + ')';
    }

    public final void a() {
        fe9.a r100 = fe9.a.f476620a;
        r100.e("AVTraceContext", "reset queryTraceData start");
        this.f503218a = null;
        this.f503219b = -1;
        this.f503220c = -1;
        this.f503221d = -1;
        this.f503222e = -1;
        this.f503223f = -1;
        this.f503224g = -1;
        this.f503225h = false;
        this.f503231n = -1;
        this.f503232o = -1;
        this.f503233p = -1;
        this.f503226i = -1;
        this.f503227j = -1;
        this.f503228k = -1;
        this.f503229l = -1;
        this.f503230m = -1;
        this.f503234q = false;
        this.f503235r.b();
        this.f503236s.b();
        this.f503237t = false;
        r100.e("AVTraceContext", "reset queryTraceData end");
    }

    public c(int r100) {
        h r101 = new h();
        h r102 = new h();
        Intrinsics.checkNotNullParameter(r101, "isQueryFirstReport");
        Intrinsics.checkNotNullParameter(r102, "isVideoQualityReport");
        this.f503218a = null;
        this.f503219b = -1;
        this.f503220c = -1;
        this.f503221d = -1;
        this.f503222e = -1;
        this.f503223f = -1;
        this.f503224g = -1;
        this.f503225h = false;
        this.f503226i = -1;
        this.f503227j = -1;
        this.f503228k = -1;
        this.f503229l = -1;
        this.f503230m = -1;
        this.f503231n = -1;
        this.f503232o = -1;
        this.f503233p = -1;
        this.f503234q = false;
        this.f503235r = r101;
        this.f503236s = r102;
        this.f503237t = false;
    }
}
