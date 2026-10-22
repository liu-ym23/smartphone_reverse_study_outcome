package org.bouncycastle.pqc.crypto.qtesla;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public final class QTESLAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private SecureRandom secureRandom;
    private int securityCategory;

    public QTESLAKeyPairGenerator() {
    }

    private byte[] allocatePrivate(int r100) {
        return new byte[QTESLASecurityCategory.getPrivateSize(r100)];
    }

    private byte[] allocatePublic(int r100) {
        return new byte[QTESLASecurityCategory.getPublicSize(r100)];
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        byte[] r100 = allocatePrivate(this.securityCategory);
        byte[] r101 = allocatePublic(this.securityCategory);
        int r102 = this.securityCategory;
        if (r102 != 5) goto L5;
        QTesla1p.generateKeyPair(r101, r100, this.secureRandom);
    L11:
        return new AsymmetricCipherKeyPair(new QTESLAPublicKeyParameters(this.securityCategory, r101), new QTESLAPrivateKeyParameters(this.securityCategory, r100));
    L5:
        if (r102 != 6) goto L8;
        QTesla3p.generateKeyPair(r101, r100, this.secureRandom);
        goto L11
    L8:
        throw new IllegalArgumentException("unknown security category: " + this.securityCategory);
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        QTESLAKeyGenerationParameters r101 = (QTESLAKeyGenerationParameters) r100;
        this.secureRandom = r101.getRandom();
        this.securityCategory = r101.getSecurityCategory();
    }
}
