package com.bytedance.android.shopping.api.mall.idl;

import com.bytedance.android.ec.hybrid.list.entity.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final k a;
    public final int b;
    public final boolean c;
    public final long d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof b) == false) goto L14;
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r6.b) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L12;
        return false;
    L12:
        if (this.d == r6.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        k r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = ((r1 * 31) + this.b) * 31;
        boolean r3 = this.c;
        ?? r4 = r3;
        if (r3 == false) goto L9;
        r4 = 1;
    L9:
        int r5 = (r2 + r4) * 31;
        long r6 = this.d;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "MallSaasStraightOutCache(listVo=" + this.a + ", cursor=" + this.b + ", hasMore=" + this.c + ", createTime=" + this.d + ")";
    }

    public b(k r2, int r3, boolean r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "listVo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
