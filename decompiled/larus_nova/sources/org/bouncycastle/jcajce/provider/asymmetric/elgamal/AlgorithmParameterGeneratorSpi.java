package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.generators.ElGamalParametersGenerator;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;

/* JADX INFO: loaded from: classes42.dex */
public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f525364l;
    protected SecureRandom random;
    protected int strength;

    public AlgorithmParameterGeneratorSpi() {
        this.strength = 1024;
        this.f525364l = 0;
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() {
        ElGamalParametersGenerator r100 = new ElGamalParametersGenerator();
        SecureRandom r101 = this.random;
        if (r101 == null) goto L5;
        r100.init(this.strength, 20, r101);
    L6:
        ElGamalParameters r102 = r100.generateParameters();
        AlgorithmParameters r103 = createParametersInstance("ElGamal");     // Catch: Exception -> L9
        r103.init(new DHParameterSpec(r102.getP(), r102.getG(), this.f525364l));     // Catch: Exception -> L9
        return r103;
    L9:
        e = move-exception;
        throw new RuntimeException(e.getMessage());
    L5:
        r100.init(this.strength, 20, CryptoServicesRegistrar.getSecureRandom());
        goto L6
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
        this.f525364l = r102.getExponentSize();
        this.random = r101;
        return;
    L7:
        throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
    }
}
