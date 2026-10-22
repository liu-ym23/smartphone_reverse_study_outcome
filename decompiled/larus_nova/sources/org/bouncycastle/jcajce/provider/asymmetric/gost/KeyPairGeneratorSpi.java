package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.generators.GOST3410KeyPairGenerator;
import org.bouncycastle.crypto.params.GOST3410KeyGenerationParameters;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

/* JADX INFO: loaded from: classes42.dex */
public class KeyPairGeneratorSpi extends KeyPairGenerator {
    GOST3410KeyPairGenerator engine;
    GOST3410ParameterSpec gost3410Params;
    boolean initialised;
    GOST3410KeyGenerationParameters param;
    SecureRandom random;
    int strength;

    public KeyPairGeneratorSpi() {
        super("GOST3410");
        this.engine = new GOST3410KeyPairGenerator();
        this.strength = 1024;
        this.random = null;
        this.initialised = false;
    }

    private void init(GOST3410ParameterSpec r100, SecureRandom r101) {
        GOST3410PublicKeyParameterSetSpec r102 = r100.getPublicKeyParameters();
        GOST3410KeyGenerationParameters r103 = new GOST3410KeyGenerationParameters(r101, new GOST3410Parameters(r102.getP(), r102.getQ(), r102.getA()));
        this.param = r103;
        this.engine.init(r103);
        this.initialised = true;
        this.gost3410Params = r100;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (this.initialised == true) goto L5;
        init(new GOST3410ParameterSpec(CryptoProObjectIdentifiers.gostR3410_94_CryptoPro_A.getId()), CryptoServicesRegistrar.getSecureRandom());
    L5:
        AsymmetricCipherKeyPair r100 = this.engine.generateKeyPair();
        GOST3410PublicKeyParameters r101 = (GOST3410PublicKeyParameters) r100.getPublic();
        GOST3410PrivateKeyParameters r102 = (GOST3410PrivateKeyParameters) r100.getPrivate();
        return new KeyPair(new BCGOST3410PublicKey(r101, this.gost3410Params), new BCGOST3410PrivateKey(r102, this.gost3410Params));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int r100, SecureRandom r101) {
        this.strength = r100;
        this.random = r101;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec r100, SecureRandom r101) throws InvalidAlgorithmParameterException {
        if ((r100 instanceof GOST3410ParameterSpec) == false) goto L7;
        init((GOST3410ParameterSpec) r100, r101);
        return;
    L7:
        throw new InvalidAlgorithmParameterException("parameter object not a GOST3410ParameterSpec");
    }
}
