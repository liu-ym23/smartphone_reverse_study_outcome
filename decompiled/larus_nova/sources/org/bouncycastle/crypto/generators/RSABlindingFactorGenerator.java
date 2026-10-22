package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class RSABlindingFactorGenerator {
    private static BigInteger ONE;
    private static BigInteger ZERO;
    private RSAKeyParameters key;
    private SecureRandom random;

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
    }

    public RSABlindingFactorGenerator() {
    }

    public BigInteger generateBlindingFactor() {
        RSAKeyParameters r100 = this.key;
        if (r100 == null) goto L13;
        BigInteger r101 = r100.getModulus();
        int r102 = r101.bitLength() - 1;
    L5:
        BigInteger r103 = BigIntegers.createRandomBigInteger(r102, this.random);
        BigInteger r104 = r103.gcd(r101);
        if (r103.equals(ZERO) == true) goto L5;
        if (r103.equals(ONE) == true) goto L5;
        if (r104.equals(ONE) == false) goto L5;
        return r103;
    L13:
        throw new IllegalStateException("generator not initialised");
    }

    public void init(CipherParameters r100) {
        if ((r100 instanceof ParametersWithRandom) == false) goto L5;
        ParametersWithRandom r101 = (ParametersWithRandom) r100;
        this.key = (RSAKeyParameters) r101.getParameters();
        SecureRandom r102 = r101.getRandom();
    L6:
        this.random = r102;
        if ((this.key instanceof RSAPrivateCrtKeyParameters) == true) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("generator requires RSA public key");
    L5:
        this.key = (RSAKeyParameters) r100;
        r102 = CryptoServicesRegistrar.getSecureRandom();
        goto L6
    }
}
