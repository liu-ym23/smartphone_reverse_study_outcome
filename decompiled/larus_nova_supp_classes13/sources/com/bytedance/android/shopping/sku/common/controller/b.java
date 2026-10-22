package com.bytedance.android.shopping.sku.common.controller;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final boolean a;
    public final long b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof b) == false) goto L10;
        b r6 = (b) r5;
        if (this.a == r6.a) goto L8;
        return false;
    L8:
        if (this.b == r6.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        long r2 = this.b;
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    }

    public final String toString() {
        return "SkuBigPicModeData(isBigPicMode=" + this.a + ", timestamp=" + this.b + ")";
    }

    public b(boolean r1, long r2) {
        this.a = r1;
        this.b = r2;
    }
}
