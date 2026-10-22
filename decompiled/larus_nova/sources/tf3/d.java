package tf3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f545723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f545724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f545725d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f545722a, r101.f545722a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f545723b, r101.f545723b) == true) goto L10;
        return false;
    L10:
        if (this.f545724c == r101.f545724c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f545725d, r101.f545725d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f545722a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f545723b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f545724c) * 31;
        String r107 = this.f545725d;
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
        return "CouponServiceVO(tag=" + this.f545722a + ", tagHeader=" + this.f545723b + ", type=" + this.f545724c + ", id=" + this.f545725d + ")";
    }

    public d() {
        this.f545722a = "";
        this.f545723b = "";
        this.f545724c = 1;
        this.f545725d = "";
    }

    public final int getType() {
        return this.f545724c;
    }
}
