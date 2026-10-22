package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.ElGamalKeyGenerationParameters;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private ElGamalKeyGenerationParameters param;

    public ElGamalKeyPairGenerator() {
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        DHKeyGeneratorHelper r100 = DHKeyGeneratorHelper.INSTANCE;
        ElGamalParameters r101 = this.param.getParameters();
        DHParameters r102 = new DHParameters(r101.getP(), r101.getG(), null, r101.getL());
        BigInteger r103 = r100.calculatePrivate(r102, this.param.getRandom());
        return new AsymmetricCipherKeyPair(new ElGamalPublicKeyParameters(r100.calculatePublic(r102, r103), r101), new ElGamalPrivateKeyParameters(r103, r101));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        this.param = (ElGamalKeyGenerationParameters) r100;
    }
}
