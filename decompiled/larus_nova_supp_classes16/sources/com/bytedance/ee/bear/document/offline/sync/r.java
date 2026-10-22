package com.bytedance.ee.bear.document.offline.sync;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r {
    public final String a;
    public final int b;
    public final int c;
    public final String d;
    public final String e;
    public final int f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
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
        int r3 = ((((r2 * 31) + this.b) * 31) + this.c) * 31;
        String r4 = this.d;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.e;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((r6 + r1) * 31) + this.f;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "JSONObjData(memberId=" + this.a + ", baseRev=" + this.b + ", version=" + this.c + ", type=" + this.d + ", token=" + this.e + ", openType=" + this.f + ')';
    }

    public final String getType() {
        return this.d;
    }

    public r(String r1, String r2) {
        this.a = r1;
        this.b = 0;
        this.c = 0;
        this.d = "CLIENT_VARS";
        this.e = r2;
        this.f = 1;
    }
}
