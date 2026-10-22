package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalParameters implements CipherParameters {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BigInteger f525309g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f525310l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BigInteger f525311p;

    public ElGamalParameters(BigInteger r100, BigInteger r101) {
        this(r100, r101, 0);
    }

    public ElGamalParameters(BigInteger r100, BigInteger r101, int r102) {
        this.f525309g = r101;
        this.f525311p = r100;
        this.f525310l = r102;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ElGamalParameters) == true) goto L5;
        return false;
    L5:
        ElGamalParameters r101 = (ElGamalParameters) r100;
        if (r101.getP().equals(this.f525311p) == true) goto L8;
        return false;
    L8:
        if (r101.getG().equals(this.f525309g) == true) goto L10;
        return false;
    L10:
        if (r101.getL() != this.f525310l) goto L15;
        return true;
    L15:
        return false;
    }

    public BigInteger getG() {
        return this.f525309g;
    }

    public int getL() {
        return this.f525310l;
    }

    public BigInteger getP() {
        return this.f525311p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.f525310l;
    }
}
