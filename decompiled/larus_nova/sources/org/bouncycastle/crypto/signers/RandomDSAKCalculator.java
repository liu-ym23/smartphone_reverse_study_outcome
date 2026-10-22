package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class RandomDSAKCalculator implements DSAKCalculator {
    private static final BigInteger ZERO = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BigInteger f525343q;
    private SecureRandom random;

    static {
        ZERO = BigInteger.valueOf(0);
    }

    public RandomDSAKCalculator() {
    }

    @Override // org.bouncycastle.crypto.signers.DSAKCalculator
    public void init(BigInteger r100, BigInteger r101, byte[] r102) {
        throw new IllegalStateException("Operation not supported");
    }

    @Override // org.bouncycastle.crypto.signers.DSAKCalculator
    public void init(BigInteger r100, SecureRandom r101) {
        this.f525343q = r100;
        this.random = r101;
    }

    @Override // org.bouncycastle.crypto.signers.DSAKCalculator
    public boolean isDeterministic() {
        return false;
    }

    @Override // org.bouncycastle.crypto.signers.DSAKCalculator
    public BigInteger nextK() {
        int r100 = this.f525343q.bitLength();
    L3:
        BigInteger r101 = BigIntegers.createRandomBigInteger(r100, this.random);
        if (r101.equals(ZERO) == true) goto L3;
        if (r101.compareTo(this.f525343q) >= 0) goto L3;
        return r101;
    }
}
