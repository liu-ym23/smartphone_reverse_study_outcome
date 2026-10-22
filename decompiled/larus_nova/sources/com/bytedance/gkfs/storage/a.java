package com.bytedance.gkfs.storage;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f245303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f245304b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f245303a == r101.f245303a) goto L8;
        return false;
    L8:
        if (this.f245304b == r101.f245304b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f245303a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f245304b;
    }

    public final String toString() {
        return "ChunkBlockIndexingInfo(offset=" + this.f245303a + ", size=" + this.f245304b + ")";
    }

    public final int b() {
        return this.f245304b;
    }

    public /* synthetic */ a(int r100) {
        this(0, 0);
    }

    public a(long r100, int r101) {
        this.f245303a = r100;
        this.f245304b = r101;
    }

    public static a a(a r100, long r101) {
        int r102 = r100.f245304b;
        r100.getClass();
        return new a(r101, r102);
    }
}
