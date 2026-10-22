package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyPairGenerator;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceCCA2KeyPairGeneratorSpi extends KeyPairGenerator {
    private McElieceCCA2KeyPairGenerator kpg;

    public McElieceCCA2KeyPairGeneratorSpi() {
        super("McEliece-CCA2");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        AsymmetricCipherKeyPair r100 = this.kpg.generateKeyPair();
        McElieceCCA2PrivateKeyParameters r101 = (McElieceCCA2PrivateKeyParameters) r100.getPrivate();
        return new KeyPair(new BCMcElieceCCA2PublicKey((McElieceCCA2PublicKeyParameters) r100.getPublic()), new BCMcElieceCCA2PrivateKey(r101));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int r100, SecureRandom r101) {
        this.kpg = new McElieceCCA2KeyPairGenerator();
        McElieceCCA2KeyGenerationParameters r102 = new McElieceCCA2KeyGenerationParameters(r101, new McElieceCCA2Parameters());
        this.kpg.init(r102);
    }

    @Override // java.security.KeyPairGenerator
    public void initialize(AlgorithmParameterSpec r100) throws InvalidAlgorithmParameterException {
        this.kpg = new McElieceCCA2KeyPairGenerator();
        McElieceCCA2KeyGenParameterSpec r101 = (McElieceCCA2KeyGenParameterSpec) r100;
        McElieceCCA2KeyGenerationParameters r102 = new McElieceCCA2KeyGenerationParameters(CryptoServicesRegistrar.getSecureRandom(), new McElieceCCA2Parameters(r101.getM(), r101.getT(), r101.getDigest()));
        this.kpg.init(r102);
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec r100, SecureRandom r101) throws InvalidAlgorithmParameterException {
        this.kpg = new McElieceCCA2KeyPairGenerator();
        McElieceCCA2KeyGenParameterSpec r102 = (McElieceCCA2KeyGenParameterSpec) r100;
        McElieceCCA2KeyGenerationParameters r103 = new McElieceCCA2KeyGenerationParameters(r101, new McElieceCCA2Parameters(r102.getM(), r102.getT(), r102.getDigest()));
        this.kpg.init(r103);
    }
}
