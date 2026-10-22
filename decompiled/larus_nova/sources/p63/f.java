package p63;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f527908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f527909d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f527906a, r101.f527906a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f527907b, r101.f527907b) == true) goto L10;
        return false;
    L10:
        if (this.f527908c == r101.f527908c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527909d, r101.f527909d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f527906a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f527907b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f527908c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f527909d;
        if (r109 == null) goto L14;
        r101 = r109.hashCode();
    L14:
        return r108 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SkuDetail(skuId=" + this.f527906a + ", specInfo=" + this.f527907b + ", count=" + this.f527908c + ", skuChosenPrice=" + this.f527909d + ")";
    }

    public /* synthetic */ f(String r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = "";
    L5:
        String r103 = r101;
        if ((r102 & 4) == 0) goto L8;
        long r104 = 1;
    L9:
        this(r100, r103, r104, null);
        return;
    L8:
        r104 = 0;
        goto L9
    }

    public f(String r100, String r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "skuId");
        Intrinsics.checkNotNullParameter(r101, "specInfo");
        this.f527906a = r100;
        this.f527907b = r101;
        this.f527908c = r102;
        this.f527909d = r103;
    }
}
