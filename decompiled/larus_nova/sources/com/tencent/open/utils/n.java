package com.tencent.open.utils;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f461875a;

    public byte[] a() {
        long r100 = this.f461875a;
        return new byte[]{(byte) (255 & r100), (byte) ((65280 & r100) >> 8), (byte) ((16711680 & r100) >> 16), (byte) ((r100 & 4278190080L) >> 24)};
    }

    public int hashCode() {
        return (int) this.f461875a;
    }

    public long b() {
        return this.f461875a;
    }

    public n(long r100) {
        this.f461875a = r100;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        if (this.f461875a != ((n) r100).b()) goto L12;
        return true;
    L12:
        return false;
    }
}
