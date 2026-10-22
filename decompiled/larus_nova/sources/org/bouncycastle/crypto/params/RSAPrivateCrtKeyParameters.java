package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {
    private BigInteger dP;
    private BigInteger dQ;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BigInteger f525333e;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BigInteger f525334p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BigInteger f525335q;
    private BigInteger qInv;

    public RSAPrivateCrtKeyParameters(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103, BigInteger r104, BigInteger r105, BigInteger r106, BigInteger r107) {
        super(true, r100, r102);
        this.f525333e = r101;
        this.f525334p = r103;
        this.f525335q = r104;
        this.dP = r105;
        this.dQ = r106;
        this.qInv = r107;
    }

    public BigInteger getDP() {
        return this.dP;
    }

    public BigInteger getDQ() {
        return this.dQ;
    }

    public BigInteger getP() {
        return this.f525334p;
    }

    public BigInteger getPublicExponent() {
        return this.f525333e;
    }

    public BigInteger getQ() {
        return this.f525335q;
    }

    public BigInteger getQInv() {
        return this.qInv;
    }
}
