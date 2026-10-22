package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.generators.GOST3410ParametersGenerator;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

/* JADX INFO: loaded from: classes42.dex */
public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    protected SecureRandom random;
    protected int strength;

    public AlgorithmParameterGeneratorSpi() {
        this.strength = 1024;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() {
        GOST3410ParametersGenerator r100 = new GOST3410ParametersGenerator();
        SecureRandom r101 = this.random;
        if (r101 == null) goto L5;
        r100.init(this.strength, 2, r101);
    L6:
        GOST3410Parameters r102 = r100.generateParameters();
        AlgorithmParameters r103 = createParametersInstance("GOST3410");     // Catch: Exception -> L9
        r103.init(new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(r102.getP(), r102.getQ(), r102.getA())));     // Catch: Exception -> L9
        return r103;
    L9:
        e = move-exception;
        throw new RuntimeException(e.getMessage());
    L5:
        r100.init(this.strength, 2, CryptoServicesRegistrar.getSecureRandom());
        goto L6
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int r100, SecureRandom r101) {
        this.strength = r100;
        this.random = r101;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(AlgorithmParameterSpec r100, SecureRandom r101) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for GOST3410 parameter generation.");
    }
}
