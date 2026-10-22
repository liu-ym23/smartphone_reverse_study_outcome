package org.bouncycastle.pqc.crypto.lms;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class LMSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    LMSKeyGenerationParameters param;

    public LMSKeyPairGenerator() {
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        SecureRandom r100 = this.param.getRandom();
        byte[] r101 = new byte[16];
        r100.nextBytes(r101);
        byte[] r102 = new byte[32];
        r100.nextBytes(r102);
        LMSPrivateKeyParameters r103 = LMS.generateKeys(this.param.getParameters().getLMSigParam(), this.param.getParameters().getLMOTSParam(), 0, r101, r102);
        return new AsymmetricCipherKeyPair(r103.getPublicKey(), r103);
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        this.param = (LMSKeyGenerationParameters) r100;
    }
}
