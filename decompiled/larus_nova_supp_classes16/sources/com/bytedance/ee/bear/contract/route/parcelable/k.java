package com.bytedance.ee.bear.contract.route.parcelable;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k {
    public final String a;
    public final String b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final String f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.c) * 31;
        int r7 = 1231;
        if (this.d == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.e == true) goto L18;
        r7 = 1237;
    L18:
        int r10 = (r9 + r7) * 31;
        String r11 = this.f;
        if (r11 == null) goto L23;
        r1 = r11.hashCode();
    L23:
        return r10 + r1;
    L13:
        r8 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TraceRouteEntry(wikiToken=" + this.a + ", objToken=" + this.b + ", objType=" + this.c + ", inSpace=" + this.d + ", redirected=" + this.e + ", logId=" + this.f + ')';
    }

    public k(String r1, String r2, int r3, boolean r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = false;
        this.e = r4;
        this.f = r5;
    }
}
