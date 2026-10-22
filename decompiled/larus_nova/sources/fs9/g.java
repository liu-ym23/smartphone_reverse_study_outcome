package fs9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f478666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f478667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f478668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f478669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ic8.r f478670f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f478665a, r101.f478665a) == true) goto L12;
        return false;
    L12:
        if (this.f478666b == r101.f478666b) goto L15;
        return false;
    L15:
        if (this.f478667c == r101.f478667c) goto L18;
        return false;
    L18:
        if (this.f478668d == r101.f478668d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f478669e, r101.f478669e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f478670f, r101.f478670f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f478665a.hashCode() * 31;
        long r101 = this.f478666b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f478667c;
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f478668d) * 31;
        h r105 = this.f478669e;
        int r106 = 0;
        if (r105 != null) goto L5;
        int r107 = 0;
    L6:
        int r108 = (r104 + r107) * 31;
        ic8.r r109 = this.f478670f;
        if (r109 == null) goto L11;
        r106 = r109.hashCode();
    L11:
        return r108 + r106;
    L5:
        r107 = r105.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoImageEditInitParams(imageUrl=" + this.f478665a + ", imageWidth=" + this.f478666b + ", imageHeight=" + this.f478667c + ", imageBeautifyId=" + this.f478668d + ", trackParams=" + this.f478669e + ", driveInfo=" + this.f478670f + ')';
    }

    public g(String r100, long r101, long r102, int r103, h r104, ic8.r r110, int r111) {
        if ((r111 & 16) == 0) goto L6;
        r104 = null;
    L6:
        if ((r111 & 32) == 0) goto L8;
        r110 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "imageUrl");
        this.f478665a = r100;
        this.f478666b = r101;
        this.f478667c = r102;
        this.f478668d = r103;
        this.f478669e = r104;
        this.f478670f = r110;
    }
}
