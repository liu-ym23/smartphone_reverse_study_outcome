package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
class DHParametersHelper {
    private static final BigInteger ONE = null;
    private static final BigInteger TWO = null;

    static {
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
    }

    public DHParametersHelper() {
    }

    public static BigInteger[] generateSafePrimes(int r100, int r101, SecureRandom r102) {
        int r103 = r100 - 1;
        int r104 = r100 >>> 2;
    L3:
        BigInteger r105 = BigIntegers.createRandomPrime(r103, 2, r102);
        BigInteger r106 = r105.shiftLeft(1).add(ONE);
        if (r106.isProbablePrime(r101) == false) goto L3;
        if (r101 <= 2) goto L11;
        if (r105.isProbablePrime(r101 - 2) == false) goto L3;
    L11:
        if (WNafUtil.getNafWeight(r106) < r104) goto L3;
        return new BigInteger[]{r106, r105};
    }

    public static BigInteger selectGenerator(BigInteger r100, BigInteger r101, SecureRandom r102) {
        BigInteger r103 = r100.subtract(TWO);
    L3:
        BigInteger r104 = TWO;
        BigInteger r105 = BigIntegers.createRandomInRange(r104, r103, r102).modPow(r104, r100);
        if (r105.equals(ONE) == true) goto L3;
        return r105;
    }
}
