package com.bytedance.awemeopen.apps.framework.feed.pages.recommend;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final long e;

    public j() {
        this(null, 0, 0, 0, 0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((((((r1 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        long r3 = this.e;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "HostCoverParam(hostCoverUrl=" + this.a + ", hostCoverWidth=" + this.b + ", hostCoverHeight=" + this.c + ", excludedHeight=" + this.d + ", doubleBallLoadingDelay=" + this.e + ')';
    }

    public j(String r1, int r2, int r3, int r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
