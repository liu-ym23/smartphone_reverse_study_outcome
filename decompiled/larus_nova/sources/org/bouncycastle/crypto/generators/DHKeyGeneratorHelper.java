package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
class DHKeyGeneratorHelper {
    static final DHKeyGeneratorHelper INSTANCE = null;
    private static final BigInteger ONE = null;
    private static final BigInteger TWO = null;

    static {
        INSTANCE = new DHKeyGeneratorHelper();
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
    }

    private DHKeyGeneratorHelper() {
    }

    public BigInteger calculatePrivate(DHParameters r100, SecureRandom r101) {
        int r102 = r100.getL();
        if (r102 == 0) goto L8;
        int r103 = r102 >>> 2;
    L5:
        BigInteger r104 = BigIntegers.createRandomBigInteger(r102, r101).setBit(r102 - 1);
        if (WNafUtil.getNafWeight(r104) < r103) goto L5;
        return r104;
    L8:
        BigInteger r105 = TWO;
        int r106 = r100.getM();
        if (r106 == 0) goto L11;
        BigInteger r107 = ONE.shiftLeft(r106 - 1);
    L12:
        BigInteger r108 = r100.getQ();
        if (r108 != null) goto L15;
        r108 = r100.getP();
    L15:
        BigInteger r109 = r108.subtract(r105);
        int r110 = r109.bitLength() >>> 2;
    L16:
        BigInteger r111 = BigIntegers.createRandomInRange(r107, r109, r101);
        if (WNafUtil.getNafWeight(r111) < r110) goto L16;
        return r111;
    L11:
        r107 = r105;
        goto L12
    }

    public BigInteger calculatePublic(DHParameters r100, BigInteger r101) {
        return r100.getG().modPow(r101, r100.getP());
    }
}
