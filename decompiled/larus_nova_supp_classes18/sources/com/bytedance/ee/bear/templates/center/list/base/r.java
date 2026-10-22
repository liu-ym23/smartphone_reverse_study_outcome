package com.bytedance.ee.bear.templates.center.list.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r {
    public final String a;
    public final String b;
    public final int c;
    public final boolean d;
    public final long e;
    public final int f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof r) == true) goto L8;
        return false;
    L8:
        r r9 = (r) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
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
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        long r3 = this.e;
        return ((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.f;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "RequestParams(cacheKey=" + this.a + ", lastIndex=" + this.b + ", filterType=" + this.c + ", isLoadMore=" + this.d + ", categoryId=" + this.e + ", pageNumber=" + this.f + ')';
    }

    public r(String r2, String r3, int r4, boolean r5, long r6, int r8) {
        Intrinsics.checkNotNullParameter(r2, "cacheKey");
        Intrinsics.checkNotNullParameter(r3, "lastIndex");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
    }

    public /* synthetic */ r(String r10, String r11, int r12, boolean r13, long r14, int r16, int r17) {
        if ((r16 & 2) == 0) goto L5;
        String r3 = "0";
    L7:
        if ((r16 & 8) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r16 & 16) == 0) goto L13;
        long r6 = -1;
    L14:
        this(r10, r3, r12, r5, r6, 0);
        return;
    L13:
        r6 = r14;
        goto L14
    L9:
        r5 = r13;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }
}
