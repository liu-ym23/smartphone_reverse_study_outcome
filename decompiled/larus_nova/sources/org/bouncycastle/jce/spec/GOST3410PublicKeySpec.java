package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410PublicKeySpec implements KeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigInteger f525419a;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BigInteger f525420p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BigInteger f525421q;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f525422y;

    public GOST3410PublicKeySpec(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103) {
        this.f525422y = r100;
        this.f525420p = r101;
        this.f525421q = r102;
        this.f525419a = r103;
    }

    public BigInteger getA() {
        return this.f525419a;
    }

    public BigInteger getP() {
        return this.f525420p;
    }

    public BigInteger getQ() {
        return this.f525421q;
    }

    public BigInteger getY() {
        return this.f525422y;
    }
}
