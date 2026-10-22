package vj2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f555402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f555403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f555404c;

    public d() {
        this(null, null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f555402a, r101.f555402a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f555403b, r101.f555403b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f555404c, r101.f555404c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f555402a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f555403b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f555404c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PageGetRequestProductInfo(productId=" + this.f555402a + ", promotionId=" + this.f555403b + ", skuId=" + this.f555404c + ")";
    }

    public d(String r100, String r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this.f555402a = r100;
        this.f555403b = r101;
        this.f555404c = r102;
    }
}
