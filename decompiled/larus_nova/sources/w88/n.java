package w88;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f558694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f558695c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f558693a, r101.f558693a) == true) goto L12;
        return false;
    L12:
        if (this.f558694b == r101.f558694b) goto L15;
        return false;
    L15:
        if (this.f558695c == r101.f558695c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f558693a.hashCode() * 31;
        long r101 = this.f558694b;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f558695c;
    }

    public final String toString() {
        return "GalleryStorageBucketInfo(name=" + this.f558693a + ", bytes=" + this.f558694b + ", fileCount=" + this.f558695c + ')';
    }

    public n(String r100, long r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f558693a = r100;
        this.f558694b = r101;
        this.f558695c = r102;
    }
}
