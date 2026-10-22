package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.generators.DHParametersGenerator;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;

/* JADX INFO: loaded from: classes42.dex */
public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f525352l;
    protected SecureRandom random;
    protected int strength;

    public AlgorithmParameterGeneratorSpi() {
        this.strength = 2048;
        this.f525352l = 0;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() {
        DHParametersGenerator r100 = new DHParametersGenerator();
        int r101 = PrimeCertaintyCalculator.getDefaultCertainty(this.strength);
        r100.init(this.strength, r101, CryptoServicesRegistrar.getSecureRandom(this.random));
        DHParameters r102 = r100.generateParameters();
        AlgorithmParameters r103 = createParametersInstance("DH");     // Catch: Exception -> L5
        r103.init(new DHParameterSpec(r102.getP(), r102.getG(), this.f525352l));     // Catch: Exception -> L5
        return r103;
    L5:
        e = move-exception;
        throw new RuntimeException(e.getMessage());
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int r100, SecureRandom r101) {
        this.strength = r100;
        this.random = r101;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(AlgorithmParameterSpec r100, SecureRandom r101) throws InvalidAlgorithmParameterException {
        if ((r100 instanceof DHGenParameterSpec) == false) goto L7;
        DHGenParameterSpec r102 = (DHGenParameterSpec) r100;
        this.strength = r102.getPrimeSize();
        this.f525352l = r102.getExponentSize();
        this.random = r101;
        return;
    L7:
        throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
    }
}
