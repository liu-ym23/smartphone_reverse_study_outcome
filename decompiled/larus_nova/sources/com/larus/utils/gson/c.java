package com.larus.utils.gson;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f375404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f375405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f375406c;

    public c() {
        this(false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f375404a == r101.f375404a) goto L12;
        return false;
    L12:
        if (this.f375405b == r101.f375405b) goto L15;
        return false;
    L15:
        if (this.f375406c == r101.f375406c) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r100 = this.f375404a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f375405b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f375406c;
        if (r107 == true) goto L13;
        r101 = r107;
    L13:
        return r106 + r101;
    }

    public final String toString() {
        return "FilterConfig(enable=" + this.f375404a + ", collectionEnable=" + this.f375405b + ", mapEnable=" + this.f375406c + ')';
    }

    public c(boolean r100, boolean r101, boolean r102) {
        this.f375404a = r100;
        this.f375405b = r101;
        this.f375406c = r102;
    }
}
