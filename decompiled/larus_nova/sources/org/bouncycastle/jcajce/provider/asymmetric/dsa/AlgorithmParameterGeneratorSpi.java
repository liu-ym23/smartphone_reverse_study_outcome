package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.generators.DSAParametersGenerator;
import org.bouncycastle.crypto.params.DSAParameterGenerationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;

/* JADX INFO: loaded from: classes42.dex */
public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    protected DSAParameterGenerationParameters params;
    protected SecureRandom random;
    protected int strength;

    public AlgorithmParameterGeneratorSpi() {
        this.strength = 2048;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() {
        if (this.strength > 1024) goto L5;
        DSAParametersGenerator r100 = new DSAParametersGenerator();
    L7:
        if (this.random != null) goto L9;
        this.random = CryptoServicesRegistrar.getSecureRandom();
    L9:
        int r101 = PrimeCertaintyCalculator.getDefaultCertainty(this.strength);
        int r102 = this.strength;
        if (r102 != 1024) goto L12;
        DSAParameterGenerationParameters r103 = new DSAParameterGenerationParameters(1024, 160, r101, this.random);
        this.params = r103;
        r100.init(r103);
    L15:
        DSAParameters r104 = r100.generateParameters();
        AlgorithmParameters r105 = createParametersInstance("DSA");     // Catch: Exception -> L18
        r105.init(new DSAParameterSpec(r104.getP(), r104.getQ(), r104.getG()));     // Catch: Exception -> L18
        return r105;
    L18:
        e = move-exception;
        throw new RuntimeException(e.getMessage());
    L12:
        if (r102 <= 1024) goto L14;
        DSAParameterGenerationParameters r106 = new DSAParameterGenerationParameters(r102, 256, r101, this.random);
        this.params = r106;
        r100.init(r106);
        goto L15
    L14:
        r100.init(r102, r101, this.random);
        goto L15
    L5:
        r100 = new DSAParametersGenerator(new SHA256Digest());
        goto L7
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int r100, SecureRandom r101) {
        if (r100 < 512) goto L22;
        if (r100 > 3072) goto L22;
        if (r100 <= 1024) goto L9;
    L13:
        if (r100 > 1024) goto L15;
    L19:
        this.strength = r100;
        this.random = r101;
        return;
    L15:
        if ((r100 % 1024) == 0) goto L19;
        throw new InvalidParameterException("strength must be a multiple of 1024 above 1024 bits.");
    L9:
        if ((r100 % 64) == 0) goto L13;
        throw new InvalidParameterException("strength must be a multiple of 64 below 1024 bits.");
    L22:
        throw new InvalidParameterException("strength must be from 512 - 3072");
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(AlgorithmParameterSpec r100, SecureRandom r101) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSA parameter generation.");
    }
}
