package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes42.dex */
class SeedDerive {
    private final byte[] I;
    private final Digest digest;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f525538j;
    private final byte[] masterSeed;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f525539q;

    public SeedDerive(byte[] r100, byte[] r101, Digest r102) {
        this.I = r100;
        this.masterSeed = r101;
        this.digest = r102;
    }

    public void deriveSeed(byte[] r100, boolean r101) {
        deriveSeed(r100, r101, 0);
    }

    public void deriveSeed(byte[] r100, boolean r101, int r102) {
        deriveSeed(r100, r102);
        if (r101 == false) goto L6;
        this.f525538j++;
        return;
    }

    public byte[] deriveSeed(byte[] r100, int r101) {
        if (r100.length < this.digest.getDigestSize()) goto L7;
        Digest r102 = this.digest;
        byte[] r103 = this.I;
        r102.update(r103, 0, r103.length);
        this.digest.update((byte) (this.f525539q >>> 24));
        this.digest.update((byte) (this.f525539q >>> 16));
        this.digest.update((byte) (this.f525539q >>> 8));
        this.digest.update((byte) this.f525539q);
        this.digest.update((byte) (this.f525538j >>> 8));
        this.digest.update((byte) this.f525538j);
        this.digest.update((byte) -1);
        Digest r104 = this.digest;
        byte[] r105 = this.masterSeed;
        r104.update(r105, 0, r105.length);
        this.digest.doFinal(r100, r101);
        return r100;
    L7:
        throw new IllegalArgumentException("target length is less than digest size.");
    }

    public byte[] getI() {
        return this.I;
    }

    public int getJ() {
        return this.f525538j;
    }

    public byte[] getMasterSeed() {
        return this.masterSeed;
    }

    public int getQ() {
        return this.f525539q;
    }

    public void setJ(int r100) {
        this.f525538j = r100;
    }

    public void setQ(int r100) {
        this.f525539q = r100;
    }
}
