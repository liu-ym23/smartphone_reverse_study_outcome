package com.bytedance.android.shopping.api.mall.feed;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final boolean a;
    public final int b;
    public final boolean c;
    public final int d;
    public final int e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L16;
        c r4 = (c) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = ((r2 * 31) + this.b) * 31;
        boolean r4 = this.c;
        if (r4 == true) goto L10;
        r1 = r4;
    L10:
        return ((((r3 + r1) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        return "ECMallFeedImagePrefetchConfig(firstScreenEnable=" + this.a + ", firstScreenCount=" + this.b + ", loadMoreEnable=" + this.c + ", loadMoreCount=" + this.d + ", loadMoreImmPreloadNum=" + this.e + ")";
    }

    public c(boolean r1, int r2, boolean r3, int r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
