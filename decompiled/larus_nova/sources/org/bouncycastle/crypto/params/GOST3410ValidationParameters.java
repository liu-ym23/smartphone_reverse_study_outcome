package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410ValidationParameters {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f525319c;
    private long cL;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private int f525320x0;
    private long x0L;

    public GOST3410ValidationParameters(int r100, int r101) {
        this.f525320x0 = r100;
        this.f525319c = r101;
    }

    public GOST3410ValidationParameters(long r100, long r101) {
        this.x0L = r100;
        this.cL = r101;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof GOST3410ValidationParameters) == true) goto L5;
        return false;
    L5:
        GOST3410ValidationParameters r101 = (GOST3410ValidationParameters) r100;
        if (r101.f525319c == this.f525319c) goto L9;
        return false;
    L9:
        if (r101.f525320x0 == this.f525320x0) goto L12;
        return false;
    L12:
        if (r101.cL == this.cL) goto L15;
        return false;
    L15:
        if (r101.x0L == this.x0L) goto L17;
        return false;
    L17:
        return true;
    }

    public int getC() {
        return this.f525319c;
    }

    public long getCL() {
        return this.cL;
    }

    public int getX0() {
        return this.f525320x0;
    }

    public long getX0L() {
        return this.x0L;
    }

    public int hashCode() {
        int r100 = this.f525320x0 ^ this.f525319c;
        long r101 = this.x0L;
        int r102 = (r100 ^ ((int) r101)) ^ ((int) (r101 >> 32));
        long r103 = this.cL;
        return (r102 ^ ((int) r103)) ^ ((int) (r103 >> 32));
    }
}
