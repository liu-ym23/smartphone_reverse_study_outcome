package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class DSAPublicKeyParameters extends DSAKeyParameters {
    private static final BigInteger ONE = null;
    private static final BigInteger TWO = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f525304y;

    static {
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
    }

    public DSAPublicKeyParameters(BigInteger r100, DSAParameters r101) {
        super(false, r101);
        this.f525304y = validate(r100, r101);
    }

    private BigInteger validate(BigInteger r100, DSAParameters r101) {
        if (r101 == null) goto L12;
        BigInteger r102 = TWO;
        if (r102.compareTo(r100) > 0) goto L11;
        if (r101.getP().subtract(r102).compareTo(r100) < 0) goto L11;
        if (ONE.equals(r100.modPow(r101.getQ(), r101.getP())) == false) goto L11;
        return r100;
    L11:
        throw new IllegalArgumentException("y value does not appear to be in correct group");
    L12:
        return r100;
    }

    public BigInteger getY() {
        return this.f525304y;
    }
}
