package com.bytedance.gkfs.storage;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f245315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f245316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f245317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f245318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f245319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f245320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f245321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f245322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f245323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f245324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f245325k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L28;
        d r101 = (d) r100;
        if (this.f245315a == r101.f245315a) goto L8;
        return false;
    L8:
        if (this.f245316b == r101.f245316b) goto L10;
        return false;
    L10:
        if (this.f245317c == r101.f245317c) goto L12;
        return false;
    L12:
        if (this.f245318d == r101.f245318d) goto L14;
        return false;
    L14:
        if (this.f245319e == r101.f245319e) goto L16;
        return false;
    L16:
        if (this.f245320f == r101.f245320f) goto L18;
        return false;
    L18:
        if (this.f245321g == r101.f245321g) goto L20;
        return false;
    L20:
        if (this.f245322h == r101.f245322h) goto L22;
        return false;
    L22:
        if (this.f245323i == r101.f245323i) goto L24;
        return false;
    L24:
        if (this.f245324j == r101.f245324j) goto L26;
        return false;
    L26:
        if (this.f245325k == r101.f245325k) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f245315a * 31) + this.f245316b) * 31;
        long r101 = this.f245317c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f245318d;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f245319e;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f245320f;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f245321g;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f245322h;
        return ((((((r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31) + this.f245323i) * 31) + this.f245324j) * 31) + this.f245325k;
    }

    public final String toString() {
        return "GkFSGeneralStorageInfo(fileCount=" + this.f245315a + ", chunkCount=" + this.f245316b + ", chunkSize=" + this.f245317c + ", chunkDiskUsage=" + this.f245318d + ", majorFileUsage=" + this.f245319e + ", majorFileDiskUsage=" + this.f245320f + ", originSize=" + this.f245321g + ", dilutedSize=" + this.f245322h + ", indexingRepoSize=" + this.f245323i + ", indexingDBSize=" + this.f245324j + ", chunkRefsCount=" + this.f245325k + ")";
    }

    public d(int r100, int r101, long r102, long r103, long r110, long r111, long r112, long r113, int r114, int r115, int r210) {
        this.f245315a = r100;
        this.f245316b = r101;
        this.f245317c = r102;
        this.f245318d = r103;
        this.f245319e = r110;
        this.f245320f = r111;
        this.f245321g = r112;
        this.f245322h = r113;
        this.f245323i = r114;
        this.f245324j = r115;
        this.f245325k = r210;
    }
}
