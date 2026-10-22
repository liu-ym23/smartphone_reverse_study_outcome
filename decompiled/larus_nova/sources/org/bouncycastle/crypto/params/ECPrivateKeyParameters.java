package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class ECPrivateKeyParameters extends ECKeyParameters {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BigInteger f525307d;

    public ECPrivateKeyParameters(BigInteger r100, ECDomainParameters r101) {
        super(true, r101);
        this.f525307d = r101.validatePrivateScalar(r100);
    }

    public BigInteger getD() {
        return this.f525307d;
    }
}
