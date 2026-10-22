package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKeyGenerationParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKeyPairGenerator;
import org.bouncycastle.pqc.crypto.mceliece.McElieceParameters;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceKeyGenParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceKeyPairGeneratorSpi extends KeyPairGenerator {
    McElieceKeyPairGenerator kpg;

    public McElieceKeyPairGeneratorSpi() {
        super("McEliece");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        AsymmetricCipherKeyPair r100 = this.kpg.generateKeyPair();
        McEliecePrivateKeyParameters r101 = (McEliecePrivateKeyParameters) r100.getPrivate();
        return new KeyPair(new BCMcEliecePublicKey((McEliecePublicKeyParameters) r100.getPublic()), new BCMcEliecePrivateKey(r101));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int r100, SecureRandom r101) {
        initialize(new McElieceKeyGenParameterSpec(), r101);     // Catch: InvalidAlgorithmParameterException -> L5
        return;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec r100, SecureRandom r101) throws InvalidAlgorithmParameterException {
        this.kpg = new McElieceKeyPairGenerator();
        McElieceKeyGenParameterSpec r102 = (McElieceKeyGenParameterSpec) r100;
        McElieceKeyGenerationParameters r103 = new McElieceKeyGenerationParameters(r101, new McElieceParameters(r102.getM(), r102.getT()));
        this.kpg.init(r103);
    }
}
