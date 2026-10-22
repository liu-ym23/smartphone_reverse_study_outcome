package org.bouncycastle.crypto.generators;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.X25519PrivateKeyParameters;

/* JADX INFO: loaded from: classes42.dex */
public class X25519KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private SecureRandom random;

    public X25519KeyPairGenerator() {
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        X25519PrivateKeyParameters r100 = new X25519PrivateKeyParameters(this.random);
        return new AsymmetricCipherKeyPair(r100.generatePublicKey(), r100);
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        this.random = r100.getRandom();
    }
}
