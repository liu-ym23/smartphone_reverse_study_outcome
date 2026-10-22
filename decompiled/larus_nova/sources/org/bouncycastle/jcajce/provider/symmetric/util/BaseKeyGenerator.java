package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class BaseKeyGenerator extends KeyGeneratorSpi {
    protected String algName;
    protected int defaultKeySize;
    protected CipherKeyGenerator engine;
    protected int keySize;
    protected boolean uninitialised;

    public BaseKeyGenerator(String r100, int r101, CipherKeyGenerator r102) {
        this.uninitialised = true;
        this.algName = r100;
        this.defaultKeySize = r101;
        this.keySize = r101;
        this.engine = r102;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public SecretKey engineGenerateKey() {
        if (this.uninitialised == false) goto L6;
        this.engine.init(new KeyGenerationParameters(CryptoServicesRegistrar.getSecureRandom(), this.defaultKeySize));
        this.uninitialised = false;
    L6:
        return new SecretKeySpec(this.engine.generateKey(), this.algName);
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(int r100, SecureRandom r101) {
        if (r101 == null) goto L9;
    L4:
        this.engine.init(new KeyGenerationParameters(r101, r100));     // Catch: IllegalArgumentException -> L6
        this.uninitialised = false;     // Catch: IllegalArgumentException -> L6
        return;
    L6:
        e = move-exception;
        throw new InvalidParameterException(e.getMessage());
    L9:
        r101 = CryptoServicesRegistrar.getSecureRandom();     // Catch: IllegalArgumentException -> L6
        goto L4
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(SecureRandom r100) {
        if (r100 == null) goto L5;
        this.engine.init(new KeyGenerationParameters(r100, this.defaultKeySize));
        this.uninitialised = false;
        return;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(AlgorithmParameterSpec r100, SecureRandom r101) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("Not Implemented");
    }
}
