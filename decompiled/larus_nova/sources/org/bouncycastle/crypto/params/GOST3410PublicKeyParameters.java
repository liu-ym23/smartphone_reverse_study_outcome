package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410PublicKeyParameters extends GOST3410KeyParameters {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f525318y;

    public GOST3410PublicKeyParameters(BigInteger r100, GOST3410Parameters r101) {
        super(false, r101);
        this.f525318y = r100;
    }

    public BigInteger getY() {
        return this.f525318y;
    }
}
