package com.bytedance.android.shopping.store.restore;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m {
    public final n a;
    public final long b;
    public final long c;
    public final s d;
    public final Map<Integer, com.bytedance.android.ec.hybrid.list.entity.k> e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof m) == false) goto L16;
        m r7 = (m) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        n r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.c;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        s r7 = this.d;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (r6 + r8) * 31;
        Map<Integer, com.bytedance.android.ec.hybrid.list.entity.k> r10 = this.e;
        if (r10 == null) goto L14;
        r1 = r10.hashCode();
    L14:
        return r9 + r1;
    L9:
        r8 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ShopPageFullData(key=" + this.a + ", createdAtMs=" + this.b + ", ttlMs=" + this.c + ", shopPageStatus=" + this.d + ", productTabData=" + this.e + ")";
    }

    public m(n r2, long r3, s r5, Map r6) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r5, "shopPageStatus");
        Intrinsics.checkNotNullParameter(r6, "productTabData");
        this.a = r2;
        this.b = r3;
        this.c = 43200000;
        this.d = r5;
        this.e = r6;
    }
}
