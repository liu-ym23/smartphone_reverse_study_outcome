package fy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f479168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f479169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f479170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f479171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f479172e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (this.f479168a == r101.f479168a) goto L8;
        return false;
    L8:
        if (this.f479169b == r101.f479169b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f479170c, r101.f479170c) == true) goto L12;
        return false;
    L12:
        if (this.f479171d == r101.f479171d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f479172e, r101.f479172e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f479168a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f479169b) * 31;
        String r102 = this.f479170c;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (((r101 + r104) * 31) + this.f479171d) * 31;
        String r106 = this.f479172e;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        return r105 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "FinishParams(channelId=" + this.f479168a + ", scene=" + this.f479169b + ", reqSrc=" + this.f479170c + ", fromAudience=" + this.f479171d + ", subReqSrc=" + this.f479172e + ")";
    }

    public d(long r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "reqSrc");
        this.f479168a = r100;
        this.f479169b = r101;
        this.f479170c = r102;
        this.f479171d = 0;
        this.f479172e = null;
    }
}
