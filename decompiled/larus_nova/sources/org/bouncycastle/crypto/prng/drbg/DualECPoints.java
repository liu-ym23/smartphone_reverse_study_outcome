package org.bouncycastle.crypto.prng.drbg;

import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public class DualECPoints {
    private final int cofactor;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ECPoint f525339p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ECPoint f525340q;
    private final int securityStrength;

    public DualECPoints(int r100, ECPoint r101, ECPoint r102, int r103) {
        if (r101.getCurve().equals(r102.getCurve()) == false) goto L7;
        this.securityStrength = r100;
        this.f525339p = r101;
        this.f525340q = r102;
        this.cofactor = r103;
        return;
    L7:
        throw new IllegalArgumentException("points need to be on the same curve");
    }

    private static int log2(int r100) {
        int r101 = 0;
    L3:
        r100 = r100 >> 1;
        if (r100 == 0) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return r101;
    }

    public int getCofactor() {
        return this.cofactor;
    }

    public int getMaxOutlen() {
        return ((this.f525339p.getCurve().getFieldSize() - (log2(this.cofactor) + 13)) / 8) * 8;
    }

    public ECPoint getP() {
        return this.f525339p;
    }

    public ECPoint getQ() {
        return this.f525340q;
    }

    public int getSecurityStrength() {
        return this.securityStrength;
    }

    public int getSeedLen() {
        return this.f525339p.getCurve().getFieldSize();
    }
}
