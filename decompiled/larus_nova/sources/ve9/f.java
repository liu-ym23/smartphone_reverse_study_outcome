package ve9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f554452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f554454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f554455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f554456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f554457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f554458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f554459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f554460i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f554461j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f554462k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f554463l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f554464m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f554465n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f554466o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f554452a == r101.f554452a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554453b, r101.f554453b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f554454c, r101.f554454c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f554455d, r101.f554455d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f554456e, r101.f554456e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f554457f, r101.f554457f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f554458g, r101.f554458g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f554459h, r101.f554459h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f554460i, r101.f554460i) == true) goto L36;
        return false;
    L36:
        if (this.f554461j == r101.f554461j) goto L39;
        return false;
    L39:
        if (this.f554462k == r101.f554462k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f554463l, r101.f554463l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f554464m, r101.f554464m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f554465n, r101.f554465n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f554466o, r101.f554466o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f554452a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((((((((((((((((r101 * 31) + this.f554453b.hashCode()) * 31) + this.f554454c.hashCode()) * 31) + this.f554455d.hashCode()) * 31) + this.f554456e.hashCode()) * 31) + this.f554457f.hashCode()) * 31) + this.f554458g.hashCode()) * 31) + this.f554459h.hashCode()) * 31) + this.f554460i.hashCode()) * 31) + this.f554461j) * 31;
        if (this.f554462k == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        b r104 = this.f554463l;
        int r105 = 0;
        if (r104 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (((((r103 + r106) * 31) + this.f554464m.hashCode()) * 31) + this.f554465n.hashCode()) * 31;
        c r108 = this.f554466o;
        if (r108 == null) goto L19;
        r105 = r108.hashCode();
    L19:
        return r107 + r105;
    L13:
        r106 = r104.hashCode();
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ConnectConfig(syncRealtimeCallEnabled=" + this.f554452a + ", appKey=" + this.f554453b + ", connectPoolBusiness=" + this.f554454c + ", opusBusinessInfo=" + this.f554455d + ", connectUrl=" + this.f554456e + ", commonHeader=" + this.f554457f + ", bizHeader=" + this.f554458g + ", spanHeader=" + this.f554459h + ", flowTraceContext=" + this.f554460i + ", connectTimeout=" + this.f554461j + ", frontierQuicEnabled=" + this.f554462k + ", audioRetransmitData=" + this.f554463l + ", isDenoiseFeaEnable=" + this.f554464m + ", namespace=" + this.f554465n + ", quicConnectConfig=" + this.f554466o + ')';
    }

    public f(boolean r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, int r212, boolean r213, b r214, String r215, String r216, c r217) {
        Intrinsics.checkNotNullParameter(r111, com.heytap.mcssdk.constant.b.f276376z);
        Intrinsics.checkNotNullParameter(r112, "connectPoolBusiness");
        Intrinsics.checkNotNullParameter(r113, "opusBusinessInfo");
        Intrinsics.checkNotNullParameter(r114, "connectUrl");
        Intrinsics.checkNotNullParameter(r115, "commonHeader");
        Intrinsics.checkNotNullParameter(r116, "bizHeader");
        Intrinsics.checkNotNullParameter(r210, "spanHeader");
        Intrinsics.checkNotNullParameter(r211, "flowTraceContext");
        Intrinsics.checkNotNullParameter(r215, "isDenoiseFeaEnable");
        Intrinsics.checkNotNullParameter(r216, "namespace");
        this.f554452a = r110;
        this.f554453b = r111;
        this.f554454c = r112;
        this.f554455d = r113;
        this.f554456e = r114;
        this.f554457f = r115;
        this.f554458g = r116;
        this.f554459h = r210;
        this.f554460i = r211;
        this.f554461j = r212;
        this.f554462k = r213;
        this.f554463l = r214;
        this.f554464m = r215;
        this.f554465n = r216;
        this.f554466o = r217;
    }
}
