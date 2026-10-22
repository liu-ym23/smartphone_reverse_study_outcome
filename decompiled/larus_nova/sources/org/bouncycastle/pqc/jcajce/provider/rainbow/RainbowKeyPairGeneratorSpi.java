package org.bouncycastle.pqc.jcajce.provider.rainbow;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.pqc.crypto.rainbow.RainbowKeyGenerationParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowKeyPairGenerator;
import org.bouncycastle.pqc.crypto.rainbow.RainbowParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.RainbowParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowKeyPairGeneratorSpi extends KeyPairGenerator {
    RainbowKeyPairGenerator engine;
    boolean initialised;
    RainbowKeyGenerationParameters param;
    SecureRandom random;
    int strength;

    public RainbowKeyPairGeneratorSpi() {
        super("Rainbow");
        this.engine = new RainbowKeyPairGenerator();
        this.strength = 1024;
        this.random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (this.initialised == true) goto L5;
        RainbowKeyGenerationParameters r100 = new RainbowKeyGenerationParameters(this.random, new RainbowParameters(new RainbowParameterSpec().getVi()));
        this.param = r100;
        this.engine.init(r100);
        this.initialised = true;
    L5:
        AsymmetricCipherKeyPair r101 = this.engine.generateKeyPair();
        RainbowPublicKeyParameters r102 = (RainbowPublicKeyParameters) r101.getPublic();
        RainbowPrivateKeyParameters r103 = (RainbowPrivateKeyParameters) r101.getPrivate();
        return new KeyPair(new BCRainbowPublicKey(r102), new BCRainbowPrivateKey(r103));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int r100, SecureRandom r101) {
        this.strength = r100;
        this.random = r101;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec r100, SecureRandom r101) throws InvalidAlgorithmParameterException {
        if ((r100 instanceof RainbowParameterSpec) == false) goto L7;
        RainbowKeyGenerationParameters r102 = new RainbowKeyGenerationParameters(r101, new RainbowParameters(((RainbowParameterSpec) r100).getVi()));
        this.param = r102;
        this.engine.init(r102);
        this.initialised = true;
        return;
    L7:
        throw new InvalidAlgorithmParameterException("parameter object not a RainbowParameterSpec");
    }
}
