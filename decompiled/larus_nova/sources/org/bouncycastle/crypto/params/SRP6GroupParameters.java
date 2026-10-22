package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class SRP6GroupParameters {
    private BigInteger N;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BigInteger f525336g;

    public SRP6GroupParameters(BigInteger r100, BigInteger r101) {
        this.N = r100;
        this.f525336g = r101;
    }

    public BigInteger getG() {
        return this.f525336g;
    }

    public BigInteger getN() {
        return this.N;
    }
}
