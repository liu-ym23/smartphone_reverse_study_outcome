package com.larus.avlink.business.timeout;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraAvlinkTimeoutInterval f291710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraAvlinkTimeoutInterval f291711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraAvlinkTimeoutInterval f291712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoraAvlinkTimeoutInterval f291713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f291714e;

    public b() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f291710a == r101.f291710a) goto L12;
        return false;
    L12:
        if (this.f291711b == r101.f291711b) goto L15;
        return false;
    L15:
        if (this.f291712c == r101.f291712c) goto L18;
        return false;
    L18:
        if (this.f291713d == r101.f291713d) goto L21;
        return false;
    L21:
        if (this.f291714e == r101.f291714e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f291710a.hashCode() * 31) + this.f291711b.hashCode()) * 31) + this.f291712c.hashCode()) * 31) + this.f291713d.hashCode()) * 31) + this.f291714e;
    }

    public final String toString() {
        return "DoraAvlinkTimeoutConfig(userTimeoutInterval=" + this.f291710a + ", nonMainBotTimeoutInterval=" + this.f291711b + ", thinkingTimeoutInterval=" + this.f291712c + ", hardwareTimeoutInterval=" + this.f291713d + ", preEndSeconds=" + this.f291714e + ')';
    }

    public b(DoraAvlinkTimeoutInterval r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = DoraAvlinkTimeoutInterval.INTERVAL_8;
    L5:
        DoraAvlinkTimeoutInterval r102 = null;
        if ((r101 & 2) == 0) goto L8;
        DoraAvlinkTimeoutInterval r103 = DoraAvlinkTimeoutInterval.INTERVAL_15;
    L10:
        if ((r101 & 4) == 0) goto L12;
        DoraAvlinkTimeoutInterval r104 = DoraAvlinkTimeoutInterval.INTERVAL_30;
    L14:
        if ((r101 & 8) == 0) goto L17;
        r102 = DoraAvlinkTimeoutInterval.INTERVAL_40;
    L17:
        if ((r101 & 16) == 0) goto L19;
        int r105 = 4;
    L20:
        Intrinsics.checkNotNullParameter(r100, "userTimeoutInterval");
        Intrinsics.checkNotNullParameter(r103, "nonMainBotTimeoutInterval");
        Intrinsics.checkNotNullParameter(r104, "thinkingTimeoutInterval");
        Intrinsics.checkNotNullParameter(r102, "hardwareTimeoutInterval");
        this.f291710a = r100;
        this.f291711b = r103;
        this.f291712c = r104;
        this.f291713d = r102;
        this.f291714e = r105;
        return;
    L19:
        r105 = 0;
        goto L20
    L12:
        r104 = null;
        goto L14
    L8:
        r103 = null;
        goto L10
    }
}
