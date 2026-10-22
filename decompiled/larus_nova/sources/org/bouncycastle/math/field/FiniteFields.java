package org.bouncycastle.math.field;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public abstract class FiniteFields {
    static final FiniteField GF_2 = null;
    static final FiniteField GF_3 = null;

    static {
        GF_2 = new PrimeField(BigInteger.valueOf(2));
        GF_3 = new PrimeField(BigInteger.valueOf(3));
    }

    public FiniteFields() {
    }

    public static PolynomialExtensionField getBinaryExtensionField(int[] r100) {
        if (r100[0] != 0) goto L15;
        int r101 = 1;
    L6:
        if (r101 >= r100.length) goto L13;
        if (r100[r101] <= r100[r101 - 1]) goto L11;
        r101 = r101 + 1;
        goto L6
    L11:
        throw new IllegalArgumentException("Polynomial exponents must be monotonically increasing");
    L13:
        return new GenericPolynomialExtensionField(GF_2, new GF2Polynomial(r100));
    L15:
        throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
    }

    public static FiniteField getPrimeField(BigInteger r100) {
        int r101 = r100.bitLength();
        if (r100.signum() <= 0) goto L19;
        if (r101 < 2) goto L19;
        if (r101 >= 3) goto L17;
        int r102 = r100.intValue();
        if (r102 == 2) goto L15;
        if (r102 != 3) goto L17;
        return GF_3;
    L15:
        return GF_2;
    L17:
        return new PrimeField(r100);
    L19:
        throw new IllegalArgumentException("'characteristic' must be >= 2");
    }
}
