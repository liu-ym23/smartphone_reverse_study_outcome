package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class ECKeyPairGenerator implements AsymmetricCipherKeyPairGenerator, ECConstants {
    ECDomainParameters params;
    SecureRandom random;

    public ECKeyPairGenerator() {
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger r100 = this.params.getN();
        int r101 = r100.bitLength();
        int r102 = r101 >>> 2;
    L3:
        BigInteger r103 = BigIntegers.createRandomBigInteger(r101, this.random);
        if (r103.compareTo(ECConstants.ONE) < 0) goto L3;
        if (r103.compareTo(r100) >= 0) goto L3;
        if (WNafUtil.getNafWeight(r103) < r102) goto L3;
        return new AsymmetricCipherKeyPair(new ECPublicKeyParameters(createBasePointMultiplier().multiply(this.params.getG(), r103), this.params), new ECPrivateKeyParameters(r103, this.params));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        ECKeyGenerationParameters r101 = (ECKeyGenerationParameters) r100;
        this.random = r101.getRandom();
        this.params = r101.getDomainParameters();
    }
}
