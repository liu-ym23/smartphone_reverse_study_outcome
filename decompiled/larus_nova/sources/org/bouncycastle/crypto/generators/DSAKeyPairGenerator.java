package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.DSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class DSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = null;
    private DSAKeyGenerationParameters param;

    static {
        ONE = BigInteger.valueOf(1);
    }

    public DSAKeyPairGenerator() {
    }

    private static BigInteger calculatePublicKey(BigInteger r100, BigInteger r101, BigInteger r102) {
        return r101.modPow(r102, r100);
    }

    private static BigInteger generatePrivateKey(BigInteger r100, SecureRandom r101) {
        int r102 = r100.bitLength() >>> 2;
    L3:
        BigInteger r103 = ONE;
        BigInteger r104 = BigIntegers.createRandomInRange(r103, r100.subtract(r103), r101);
        if (WNafUtil.getNafWeight(r104) < r102) goto L3;
        return r104;
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        DSAParameters r100 = this.param.getParameters();
        BigInteger r101 = generatePrivateKey(r100.getQ(), this.param.getRandom());
        return new AsymmetricCipherKeyPair(new DSAPublicKeyParameters(calculatePublicKey(r100.getP(), r100.getG(), r101), r100), new DSAPrivateKeyParameters(r101, r100));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        this.param = (DSAKeyGenerationParameters) r100;
    }
}
