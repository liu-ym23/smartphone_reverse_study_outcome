package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.GOST3410KeyGenerationParameters;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private GOST3410KeyGenerationParameters param;

    public GOST3410KeyPairGenerator() {
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        GOST3410Parameters r100 = this.param.getParameters();
        SecureRandom r101 = this.param.getRandom();
        BigInteger r102 = r100.getQ();
        BigInteger r103 = r100.getP();
        BigInteger r104 = r100.getA();
    L3:
        BigInteger r105 = BigIntegers.createRandomBigInteger(256, r101);
        if (r105.signum() < 1) goto L3;
        if (r105.compareTo(r102) >= 0) goto L3;
        if (WNafUtil.getNafWeight(r105) < 64) goto L3;
        return new AsymmetricCipherKeyPair(new GOST3410PublicKeyParameters(r104.modPow(r105, r103), r100), new GOST3410PrivateKeyParameters(r105, r100));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        this.param = (GOST3410KeyGenerationParameters) r100;
    }
}
