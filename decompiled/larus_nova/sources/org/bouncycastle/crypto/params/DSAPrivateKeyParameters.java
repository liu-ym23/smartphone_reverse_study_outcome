package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class DSAPrivateKeyParameters extends DSAKeyParameters {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BigInteger f525303x;

    public DSAPrivateKeyParameters(BigInteger r100, DSAParameters r101) {
        super(true, r101);
        this.f525303x = r100;
    }

    public BigInteger getX() {
        return this.f525303x;
    }
}
