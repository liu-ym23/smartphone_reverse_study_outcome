package yq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f568860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f568861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f568862c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f568860a == r101.f568860a) goto L12;
        return false;
    L12:
        if (this.f568861b == r101.f568861b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f568862c, r101.f568862c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f568860a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f568861b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.f568862c;
        if (r104 != null) goto L5;
        int r105 = 0;
    L7:
        return r103 + r105;
    L5:
        r105 = r104.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowDataLoaderCacheInfo(mediaSize=" + this.f568860a + ", cacheSizeFromZero=" + this.f568861b + ", localFilePath=" + this.f568862c + ')';
    }

    public /* synthetic */ a(int r100) {
        this(0, 0, null);
    }

    public a(long r100, long r101, String r102) {
        this.f568860a = r100;
        this.f568861b = r101;
        this.f568862c = r102;
    }
}
