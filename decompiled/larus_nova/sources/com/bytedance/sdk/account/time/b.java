package com.bytedance.sdk.account.time;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f269505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f269506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f269507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f269508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f269509e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L30:
        return true;
    L5:
        if ((r100 instanceof b) == false) goto L29;
        b r101 = (b) r100;
        if (this.f269505a != r101.f269505a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L29;
        if (this.f269506b != r101.f269506b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L29;
        if (this.f269507c != r101.f269507c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L29;
        if (this.f269508d != r101.f269508d) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L29;
        if (Intrinsics.areEqual(this.f269509e, r101.f269509e) == false) goto L29;
    L24:
        r105 = false;
        goto L25
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L29:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f269505a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f269506b;
        int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f269507c) * 31) + this.f269508d) * 31;
        c r104 = this.f269509e;
        if (r104 == null) goto L5;
        int r105 = r104.hashCode();
    L7:
        return r103 + r105;
    L5:
        r105 = 0;
        goto L7
    }

    public final String toString() {
        return "GetTimeResult(timeMillis=" + this.f269505a + ", serverTimeMillis=" + this.f269506b + ", timeSource=" + this.f269507c + ", flags=" + this.f269508d + ", config=" + this.f269509e + ")";
    }

    public b(long r100, long r101, int r102, int r103, c r104) {
        this.f269505a = r100;
        this.f269506b = r101;
        this.f269507c = r102;
        this.f269508d = r103;
        this.f269509e = r104;
    }
}
