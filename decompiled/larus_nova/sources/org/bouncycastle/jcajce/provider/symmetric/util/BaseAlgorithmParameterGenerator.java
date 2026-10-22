package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;

/* JADX INFO: loaded from: classes42.dex */
public abstract class BaseAlgorithmParameterGenerator extends AlgorithmParameterGeneratorSpi {
    private final JcaJceHelper helper;
    protected SecureRandom random;
    protected int strength;

    public BaseAlgorithmParameterGenerator() {
        this.helper = new BCJcaJceHelper();
        this.strength = 1024;
    }

    public final AlgorithmParameters createParametersInstance(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.helper.createAlgorithmParameters(r100);
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int r100, SecureRandom r101) {
        this.strength = r100;
        this.random = r101;
    }
}
