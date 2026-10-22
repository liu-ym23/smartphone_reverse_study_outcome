package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalParameterSpec implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BigInteger f525408g;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BigInteger f525409p;

    public ElGamalParameterSpec(BigInteger r100, BigInteger r101) {
        this.f525409p = r100;
        this.f525408g = r101;
    }

    public BigInteger getG() {
        return this.f525408g;
    }

    public BigInteger getP() {
        return this.f525409p;
    }
}
