package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410PrivateKeyParameters extends GOST3410KeyParameters {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BigInteger f525317x;

    public GOST3410PrivateKeyParameters(BigInteger r100, GOST3410Parameters r101) {
        super(true, r101);
        this.f525317x = r100;
    }

    public BigInteger getX() {
        return this.f525317x;
    }
}
