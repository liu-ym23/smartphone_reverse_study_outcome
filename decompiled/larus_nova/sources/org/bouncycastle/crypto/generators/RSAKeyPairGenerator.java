package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.math.Primes;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class RSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = null;
    private RSAKeyGenerationParameters param;

    static {
        ONE = BigInteger.valueOf(1);
    }

    public RSAKeyPairGenerator() {
    }

    private static int getNumberOfIterations(int r100, int r101) {
        if (r100 < 1536) goto L12;
        if (r101 > 100) goto L7;
        return 3;
    L7:
        if (r101 > 128) goto L10;
        return 4;
    L10:
        return 4 + (((r101 - 128) + 1) / 2);
    L12:
        if (r100 < 1024) goto L21;
        if (r101 > 100) goto L16;
        return 4;
    L16:
        if (r101 > 112) goto L19;
        return 5;
    L19:
        return (((r101 - 112) + 1) / 2) + 5;
    L21:
        if (r100 < 512) goto L30;
        if (r101 > 80) goto L25;
        return 5;
    L25:
        if (r101 > 100) goto L28;
        return 7;
    L28:
        return 7 + (((r101 - 100) + 1) / 2);
    L30:
        if (r101 > 80) goto L33;
        return 40;
    L33:
        return 40 + (((r101 - 80) + 1) / 2);
    }

    public BigInteger chooseRandomPrime(int r100, BigInteger r101, BigInteger r102) {
        int r103 = 0;
    L4:
        if (r103 == (r100 * 5)) goto L19;
        BigInteger r104 = BigIntegers.createRandomPrime(r100, 1, this.param.getRandom());
        BigInteger r105 = r104.mod(r101);
        BigInteger r106 = ONE;
        if (r105.equals(r106) == true) goto L16;
        if (r104.multiply(r104).compareTo(r102) < 0) goto L16;
        if (isProbablePrime(r104) == false) goto L16;
        if (r101.gcd(r104.subtract(r106)).equals(r106) == false) goto L16;
        return r104;
    L16:
        r103 = r103 + 1;
        goto L4
    L19:
        throw new IllegalStateException("unable to generate prime number for RSA key");
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        RSAKeyPairGenerator r100 = this;
        int r101 = r100.param.getStrength();
        int r102 = (r101 + 1) / 2;
        int r103 = r101 - r102;
        int r104 = r101 / 2;
        int r105 = r104 - 100;
        int r106 = r101 / 3;
        if (r105 >= r106) goto L5;
        r105 = r106;
    L5:
        int r107 = r101 >> 2;
        BigInteger r108 = BigInteger.valueOf(2).pow(r104);
        BigInteger r109 = ONE;
        BigInteger r110 = r109.shiftLeft(r101 - 1);
        BigInteger r111 = r109.shiftLeft(r105);
        AsymmetricCipherKeyPair r112 = null;
        boolean r113 = false;
    L6:
        if (r113 == true) goto L30;
        BigInteger r114 = r100.param.getPublicExponent();
    L8:
        BigInteger r115 = r100.chooseRandomPrime(r102, r114, r110);
    L9:
        BigInteger r116 = r100.chooseRandomPrime(r103, r114, r110);
        BigInteger r117 = r116.subtract(r115).abs();
        if (r117.bitLength() < r105) goto L29;
        if (r117.compareTo(r111) <= 0) goto L29;
        BigInteger r118 = r115.multiply(r116);
        if (r118.bitLength() == r101) goto L18;
        r115 = r115.max(r116);
        goto L9
    L18:
        if (WNafUtil.getNafWeight(r118) < r107) goto L8;
        if (r115.compareTo(r116) >= 0) goto L23;
        BigInteger r119 = r115;
        r115 = r116;
    L24:
        BigInteger r120 = ONE;
        BigInteger r121 = r115.subtract(r120);
        BigInteger r122 = r119.subtract(r120);
        int r210 = r101;
        BigInteger r123 = r114.modInverse(r121.divide(r121.gcd(r122)).multiply(r122));
        if (r123.compareTo(r108) <= 0) goto L28;
        r112 = new AsymmetricCipherKeyPair(new RSAKeyParameters(false, r118, r114), new RSAPrivateCrtKeyParameters(r118, r114, r123, r115, r119, r123.remainder(r121), r123.remainder(r122), BigIntegers.modOddInverse(r115, r119)));
        r113 = true;
    L28:
        r100 = this;
        r101 = r210;
        goto L6
    L23:
        r119 = r116;
    L29:
        r100 = this;
        r101 = r101;
        goto L9
    L30:
        return r112;
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        this.param = (RSAKeyGenerationParameters) r100;
    }

    public boolean isProbablePrime(BigInteger r100) {
        int r101 = getNumberOfIterations(r100.bitLength(), this.param.getCertainty());
        if (Primes.hasAnySmallFactors(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (Primes.isMRProbablePrime(r100, this.param.getRandom(), r101) == false) goto L7;
        return true;
    }
}
