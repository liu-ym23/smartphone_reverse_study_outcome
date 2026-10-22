package com.bytedance.gkfs.io;

/* JADX INFO: loaded from: classes19.dex */
public final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f245226d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f245227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f245228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f245229c;

    public static final class a {
    }

    public m() {
        int r100 = 0;
        this(r100, 0, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L12;
        m r101 = (m) r100;
        if (this.f245227a == r101.f245227a) goto L8;
        return false;
    L8:
        if (this.f245228b == r101.f245228b) goto L10;
        return false;
    L10:
        if (this.f245229c == r101.f245229c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f245227a * 31;
        long r101 = this.f245228b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f245229c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    static {
        int r100 = 0;
        f245226d = new m(r100, 0, 6);
    }

    public final String toString() {
        return "GkFSFileHeaderMeta(version=" + this.f245227a + ", fileOriginSize=" + this.f245228b + ", size=" + this.f245229c + ')';
    }

    public /* synthetic */ m(int r100, long r101, int r110) {
        if ((r110 & 1) == 0) goto L5;
        int r102 = 1;
    L7:
        if ((r110 & 4) == 0) goto L9;
        r101 = 0;
    L9:
        this(r102, 0, r101);
        return;
    L5:
        r102 = r100;
        goto L7
    }

    public m(int r100, long r101, long r102) {
        this.f245227a = r100;
        this.f245228b = r101;
        this.f245229c = r102;
    }
}
