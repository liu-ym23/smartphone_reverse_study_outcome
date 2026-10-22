package org.bouncycastle.jce.spec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class ECPrivateKeySpec extends ECKeySpec {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BigInteger f525406d;

    public ECPrivateKeySpec(BigInteger r100, ECParameterSpec r101) {
        super(r101);
        this.f525406d = r100;
    }

    public BigInteger getD() {
        return this.f525406d;
    }
}
