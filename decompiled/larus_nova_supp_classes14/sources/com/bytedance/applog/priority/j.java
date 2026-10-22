package com.bytedance.applog.priority;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public final String a;
    public final long b;
    public final int c;
    public final int d;
    public final int e;
    public final long f;

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
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        long r2 = this.b;
        int r3 = ((((((((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
        long r4 = this.f;
        return r3 + ((int) (r4 ^ (r4 >>> 32)));
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PriorityUser(uuid=" + this.a + ", userId=" + this.b + ", userIsLogin=" + this.c + ", userIsAuth=" + this.d + ", userType=" + this.e + ", uid=" + this.f + ')';
    }

    public j(String r1, long r2, int r4, int r5, int r6, long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
