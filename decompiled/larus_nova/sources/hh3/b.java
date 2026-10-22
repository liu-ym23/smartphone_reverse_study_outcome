package hh3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f485170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f485171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f485172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f485173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f485174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f485175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f485176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f485177h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L22;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f485170a, r101.f485170a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f485171b, r101.f485171b) == true) goto L10;
        return false;
    L10:
        if (this.f485172c == r101.f485172c) goto L12;
        return false;
    L12:
        if (this.f485173d == r101.f485173d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f485174e, r101.f485174e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f485175f, r101.f485175f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f485176g, r101.f485176g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f485177h, r101.f485177h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f485170a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f485171b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f485172c) * 31) + this.f485173d) * 31;
        String r107 = this.f485174e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f485175f;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f485176g;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f485177h;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SimilarProductRequestParam(awemeId=" + this.f485170a + ", productFrameId=" + this.f485171b + ", cursor=" + this.f485172c + ", count=" + this.f485173d + ", penetrateData=" + this.f485174e + ", sortRule=" + this.f485175f + ", feedBack=" + this.f485176g + ", filters=" + this.f485177h + ")";
    }

    public b(String r100, String r101, int r102, int r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "awemeId");
        Intrinsics.checkNotNullParameter(r101, "productFrameId");
        this.f485170a = r100;
        this.f485171b = r101;
        this.f485172c = r102;
        this.f485173d = r103;
        this.f485174e = r104;
        this.f485175f = r105;
        this.f485176g = r106;
        this.f485177h = r107;
    }
}
