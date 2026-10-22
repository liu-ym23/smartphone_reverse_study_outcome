package com.bytedance.ee.bear.contract;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f0 {
    public final String a;
    public final int b;
    public final boolean c;
    public final int d;
    public final c0.e e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r6 = (f0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((r3 + r4) * 31) + this.d) * 31;
        c0.e r6 = this.e;
        if (r6 == null) goto L15;
        r1 = r6.hashCode();
    L15:
        return r5 + r1;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ListSubscribeBean(token=" + this.a + ", type=" + this.b + ", isSubscribe=" + this.c + ", subscribeType=" + this.d + ", callback=" + this.e + ')';
    }

    public final int getType() {
        return this.b;
    }

    public f0(String r1, int r2, boolean r3, int r4, c0.e r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
