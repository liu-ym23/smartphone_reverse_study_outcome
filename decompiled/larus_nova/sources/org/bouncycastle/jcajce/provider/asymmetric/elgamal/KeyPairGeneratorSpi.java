package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.generators.ElGamalKeyPairGenerator;
import org.bouncycastle.crypto.generators.ElGamalParametersGenerator;
import org.bouncycastle.crypto.params.ElGamalKeyGenerationParameters;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class KeyPairGeneratorSpi extends KeyPairGenerator {
    int certainty;
    ElGamalKeyPairGenerator engine;
    boolean initialised;
    ElGamalKeyGenerationParameters param;
    SecureRandom random;
    int strength;

    public KeyPairGeneratorSpi() {
        super("ElGamal");
        this.engine = new ElGamalKeyPairGenerator();
        this.strength = 1024;
        this.certainty = 20;
        this.random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (this.initialised == true) goto L9;
        DHParameterSpec r100 = BouncyCastleProvider.CONFIGURATION.getDHDefaultParameters(this.strength);
        if (r100 == null) goto L7;
        ElGamalKeyGenerationParameters r101 = new ElGamalKeyGenerationParameters(this.random, new ElGamalParameters(r100.getP(), r100.getG(), r100.getL()));
    L8:
        this.param = r101;
        this.engine.init(this.param);
        this.initialised = true;
        goto L9
    L7:
        ElGamalParametersGenerator r102 = new ElGamalParametersGenerator();
        r102.init(this.strength, this.certainty, this.random);
        r101 = new ElGamalKeyGenerationParameters(this.random, r102.generateParameters());
    L9:
        AsymmetricCipherKeyPair r103 = this.engine.generateKeyPair();
        ElGamalPublicKeyParameters r104 = (ElGamalPublicKeyParameters) r103.getPublic();
        ElGamalPrivateKeyParameters r105 = (ElGamalPrivateKeyParameters) r103.getPrivate();
        return new KeyPair(new BCElGamalPublicKey(r104), new BCElGamalPrivateKey(r105));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int r100, SecureRandom r101) {
        this.strength = r100;
        this.random = r101;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec r100, SecureRandom r101) throws InvalidAlgorithmParameterException {
        boolean r102 = r100 instanceof ElGamalParameterSpec;
        if (r102 == false) goto L5;
    L9:
        if (r102 == false) goto L11;
        ElGamalParameterSpec r103 = (ElGamalParameterSpec) r100;
        ElGamalKeyGenerationParameters r104 = new ElGamalKeyGenerationParameters(r101, new ElGamalParameters(r103.getP(), r103.getG()));
    L12:
        this.param = r104;
        this.engine.init(this.param);
        this.initialised = true;
        return;
    L11:
        DHParameterSpec r105 = (DHParameterSpec) r100;
        r104 = new ElGamalKeyGenerationParameters(r101, new ElGamalParameters(r105.getP(), r105.getG(), r105.getL()));
        goto L12
    L5:
        if ((r100 instanceof DHParameterSpec) == true) goto L9;
        throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec or an ElGamalParameterSpec");
    }
}
