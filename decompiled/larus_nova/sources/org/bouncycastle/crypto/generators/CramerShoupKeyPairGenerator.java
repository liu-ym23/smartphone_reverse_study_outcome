package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.CramerShoupKeyGenerationParameters;
import org.bouncycastle.crypto.params.CramerShoupParameters;
import org.bouncycastle.crypto.params.CramerShoupPrivateKeyParameters;
import org.bouncycastle.crypto.params.CramerShoupPublicKeyParameters;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class CramerShoupKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = null;
    private CramerShoupKeyGenerationParameters param;

    static {
        ONE = BigInteger.valueOf(1);
    }

    public CramerShoupKeyPairGenerator() {
    }

    private CramerShoupPublicKeyParameters calculatePublicKey(CramerShoupParameters r100, CramerShoupPrivateKeyParameters r101) {
        BigInteger r102 = r100.getG1();
        BigInteger r103 = r100.getG2();
        BigInteger r104 = r100.getP();
        return new CramerShoupPublicKeyParameters(r100, r102.modPow(r101.getX1(), r104).multiply(r103.modPow(r101.getX2(), r104)), r102.modPow(r101.getY1(), r104).multiply(r103.modPow(r101.getY2(), r104)), r102.modPow(r101.getZ(), r104));
    }

    private CramerShoupPrivateKeyParameters generatePrivateKey(SecureRandom r110, CramerShoupParameters r111) {
        BigInteger r100 = r111.getP();
        return new CramerShoupPrivateKeyParameters(r111, generateRandomElement(r100, r110), generateRandomElement(r100, r110), generateRandomElement(r100, r110), generateRandomElement(r100, r110), generateRandomElement(r100, r110));
    }

    private BigInteger generateRandomElement(BigInteger r100, SecureRandom r101) {
        BigInteger r102 = ONE;
        return BigIntegers.createRandomInRange(r102, r100.subtract(r102), r101);
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        CramerShoupParameters r100 = this.param.getParameters();
        CramerShoupPrivateKeyParameters r101 = generatePrivateKey(this.param.getRandom(), r100);
        CramerShoupPublicKeyParameters r102 = calculatePublicKey(r100, r101);
        r101.setPk(r102);
        return new AsymmetricCipherKeyPair(r102, r101);
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        this.param = (CramerShoupKeyGenerationParameters) r100;
    }
}
