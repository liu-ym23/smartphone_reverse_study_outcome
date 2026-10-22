package x4c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f562492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f562494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f562495d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f562492a == r101.f562492a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f562493b, r101.f562493b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f562494c, r101.f562494c) == true) goto L18;
        return false;
    L18:
        if (this.f562495d == r101.f562495d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f562492a * 31) + this.f562493b.hashCode()) * 31) + this.f562494c.hashCode()) * 31;
        long r101 = this.f562495d;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "CacheEntry(id=" + this.f562492a + ", key=" + this.f562493b + ", value=" + this.f562494c + ", lastAccessTime=" + this.f562495d + ')';
    }

    public f(int r100, String r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        this.f562492a = r100;
        this.f562493b = r101;
        this.f562494c = r102;
        this.f562495d = r103;
    }
}
