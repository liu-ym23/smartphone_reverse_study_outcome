package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410PrivateKeySpec implements KeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigInteger f525412a;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BigInteger f525413p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BigInteger f525414q;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BigInteger f525415x;

    public GOST3410PrivateKeySpec(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103) {
        this.f525415x = r100;
        this.f525413p = r101;
        this.f525414q = r102;
        this.f525412a = r103;
    }

    public BigInteger getA() {
        return this.f525412a;
    }

    public BigInteger getP() {
        return this.f525413p;
    }

    public BigInteger getQ() {
        return this.f525414q;
    }

    public BigInteger getX() {
        return this.f525415x;
    }
}
