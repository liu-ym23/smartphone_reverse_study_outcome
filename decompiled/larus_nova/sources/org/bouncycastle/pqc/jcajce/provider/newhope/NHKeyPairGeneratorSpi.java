package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.newhope.NHKeyPairGenerator;
import org.bouncycastle.pqc.crypto.newhope.NHPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;

/* JADX INFO: loaded from: classes42.dex */
public class NHKeyPairGeneratorSpi extends KeyPairGenerator {
    NHKeyPairGenerator engine;
    boolean initialised;
    SecureRandom random;

    public NHKeyPairGeneratorSpi() {
        super("NH");
        this.engine = new NHKeyPairGenerator();
        this.random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (this.initialised == true) goto L5;
        this.engine.init(new KeyGenerationParameters(this.random, 1024));
        this.initialised = true;
    L5:
        AsymmetricCipherKeyPair r100 = this.engine.generateKeyPair();
        NHPublicKeyParameters r101 = (NHPublicKeyParameters) r100.getPublic();
        NHPrivateKeyParameters r102 = (NHPrivateKeyParameters) r100.getPrivate();
        return new KeyPair(new BCNHPublicKey(r101), new BCNHPrivateKey(r102));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int r100, SecureRandom r101) {
        if (r100 != 1024) goto L7;
        this.engine.init(new KeyGenerationParameters(r101, 1024));
        this.initialised = true;
        return;
    L7:
        throw new IllegalArgumentException("strength must be 1024 bits");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec r100, SecureRandom r101) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("parameter object not recognised");
    }
}
