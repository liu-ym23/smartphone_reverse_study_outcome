package com.larus.avlink.gallery.processor;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f292667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f292668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f292669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f292670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f292671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f292672f;

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
        if (this.f292667a == r101.f292667a) goto L12;
        return false;
    L12:
        if (this.f292668b == r101.f292668b) goto L15;
        return false;
    L15:
        if (this.f292669c == r101.f292669c) goto L18;
        return false;
    L18:
        if (this.f292670d == r101.f292670d) goto L21;
        return false;
    L21:
        if (this.f292671e == r101.f292671e) goto L24;
        return false;
    L24:
        if (this.f292672f == r101.f292672f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f292667a;
        int r101 = ((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f292668b) * 31) + this.f292669c) * 31) + this.f292670d) * 31) + this.f292671e) * 31;
        long r102 = this.f292672f;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "AllTaskModel(totalSize=" + this.f292667a + ", photoCount=" + this.f292668b + ", videoCount=" + this.f292669c + ", photoSuccessCount=" + this.f292670d + ", videoSuccessCount=" + this.f292671e + "), mediaDuration=" + this.f292672f;
    }

    public a(int r100) {
        this.f292667a = 0;
        this.f292668b = 0;
        this.f292669c = 0;
        this.f292670d = 0;
        this.f292671e = 0;
        this.f292672f = 0;
    }
}
