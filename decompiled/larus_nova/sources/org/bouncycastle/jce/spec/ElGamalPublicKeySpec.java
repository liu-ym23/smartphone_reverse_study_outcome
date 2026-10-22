package org.bouncycastle.jce.spec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalPublicKeySpec extends ElGamalKeySpec {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f525411y;

    public ElGamalPublicKeySpec(BigInteger r100, ElGamalParameterSpec r101) {
        super(r101);
        this.f525411y = r100;
    }

    public BigInteger getY() {
        return this.f525411y;
    }
}
