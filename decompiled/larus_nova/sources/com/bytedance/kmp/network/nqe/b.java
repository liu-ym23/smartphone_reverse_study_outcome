package com.bytedance.kmp.network.nqe;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EffectiveConnectionType f252541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f252542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f252543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f252544d;

    public b() {
        this(null, null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f252541a == r101.f252541a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f252542b, r101.f252542b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f252543c, r101.f252543c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f252544d, r101.f252544d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f252541a.hashCode() * 31) + this.f252542b.hashCode()) * 31) + this.f252543c.hashCode()) * 31) + this.f252544d.hashCode();
    }

    public final String toString() {
        return "NetworkQualityState(effectiveConnectionType=" + this.f252541a + ", rttAndThroughput=" + this.f252542b + ", tcpPacketLoss=" + this.f252543c + ", quicPacketLoss=" + this.f252544d + ')';
    }

    public b(EffectiveConnectionType r100, d r101, c r102, c r103) {
        Intrinsics.checkNotNullParameter(r100, "effectiveConnectionType");
        Intrinsics.checkNotNullParameter(r101, "rttAndThroughput");
        Intrinsics.checkNotNullParameter(r102, "tcpPacketLoss");
        Intrinsics.checkNotNullParameter(r103, "quicPacketLoss");
        this.f252541a = r100;
        this.f252542b = r101;
        this.f252543c = r102;
        this.f252544d = r103;
    }

    public b(EffectiveConnectionType r100, d r101, c r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = EffectiveConnectionType.UNKNOWN;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = d.f252551d;
    L9:
        if ((r103 & 4) == 0) goto L11;
        c r104 = c.f252545f;
    L13:
        if ((r103 & 8) == 0) goto L15;
        r102 = c.f252545f;
    L15:
        this(r100, r101, r104, r102);
        return;
    L11:
        r104 = null;
        goto L13
    }

    public static b a(b r100, EffectiveConnectionType r101, d r102, c r103, c r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f252541a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f252542b;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f252543c;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.f252544d;
    L14:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "effectiveConnectionType");
        Intrinsics.checkNotNullParameter(r102, "rttAndThroughput");
        Intrinsics.checkNotNullParameter(r103, "tcpPacketLoss");
        Intrinsics.checkNotNullParameter(r104, "quicPacketLoss");
        return new b(r101, r102, r103, r104);
    }
}
