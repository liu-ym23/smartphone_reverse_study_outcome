package org.bouncycastle.pqc.jcajce.provider.qtesla;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.pqc.crypto.qtesla.QTESLAKeyGenerationParameters;
import org.bouncycastle.pqc.crypto.qtesla.QTESLAKeyPairGenerator;
import org.bouncycastle.pqc.crypto.qtesla.QTESLAPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.qtesla.QTESLAPublicKeyParameters;
import org.bouncycastle.pqc.crypto.qtesla.QTESLASecurityCategory;
import org.bouncycastle.pqc.jcajce.spec.QTESLAParameterSpec;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class KeyPairGeneratorSpi extends KeyPairGenerator {
    private static final Map catLookup = null;
    private QTESLAKeyPairGenerator engine;
    private boolean initialised;
    private QTESLAKeyGenerationParameters param;
    private SecureRandom random;

    static {
        HashMap r100 = new HashMap();
        catLookup = r100;
        r100.put(QTESLASecurityCategory.getName(5), Integers.valueOf(5));
        r100.put(QTESLASecurityCategory.getName(6), Integers.valueOf(6));
    }

    public KeyPairGeneratorSpi() {
        super("qTESLA");
        this.engine = new QTESLAKeyPairGenerator();
        this.random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (this.initialised == true) goto L5;
        QTESLAKeyGenerationParameters r100 = new QTESLAKeyGenerationParameters(6, this.random);
        this.param = r100;
        this.engine.init(r100);
        this.initialised = true;
    L5:
        AsymmetricCipherKeyPair r101 = this.engine.generateKeyPair();
        QTESLAPublicKeyParameters r102 = (QTESLAPublicKeyParameters) r101.getPublic();
        QTESLAPrivateKeyParameters r103 = (QTESLAPrivateKeyParameters) r101.getPrivate();
        return new KeyPair(new BCqTESLAPublicKey(r102), new BCqTESLAPrivateKey(r103));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int r100, SecureRandom r101) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec r100, SecureRandom r101) throws InvalidAlgorithmParameterException {
        if ((r100 instanceof QTESLAParameterSpec) == false) goto L7;
        QTESLAKeyGenerationParameters r102 = new QTESLAKeyGenerationParameters(((Integer) catLookup.get(((QTESLAParameterSpec) r100).getSecurityCategory())).intValue(), r101);
        this.param = r102;
        this.engine.init(r102);
        this.initialised = true;
        return;
    L7:
        throw new InvalidAlgorithmParameterException("parameter object not a QTESLAParameterSpec");
    }
}
