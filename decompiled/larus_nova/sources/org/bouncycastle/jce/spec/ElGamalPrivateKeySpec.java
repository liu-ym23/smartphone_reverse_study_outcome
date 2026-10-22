package org.bouncycastle.jce.spec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalPrivateKeySpec extends ElGamalKeySpec {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BigInteger f525410x;

    public ElGamalPrivateKeySpec(BigInteger r100, ElGamalParameterSpec r101) {
        super(r101);
        this.f525410x = r100;
    }

    public BigInteger getX() {
        return this.f525410x;
    }
}
