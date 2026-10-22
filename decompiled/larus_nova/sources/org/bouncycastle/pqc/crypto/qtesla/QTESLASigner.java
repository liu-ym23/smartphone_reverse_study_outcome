package org.bouncycastle.pqc.crypto.qtesla;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageSigner;

/* JADX INFO: loaded from: classes42.dex */
public class QTESLASigner implements MessageSigner {
    private QTESLAPrivateKeyParameters privateKey;
    private QTESLAPublicKeyParameters publicKey;
    private SecureRandom secureRandom;

    public QTESLASigner() {
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] r100) {
        byte[] r101 = new byte[QTESLASecurityCategory.getSignatureSize(this.privateKey.getSecurityCategory())];
        int r102 = this.privateKey.getSecurityCategory();
        if (r102 != 5) goto L5;
        QTesla1p.generateSignature(r101, r100, 0, r100.length, this.privateKey.getSecret(), this.secureRandom);
    L10:
        return r101;
    L5:
        if (r102 != 6) goto L8;
        QTesla3p.generateSignature(r101, r100, 0, r100.length, this.privateKey.getSecret(), this.secureRandom);
        goto L10
    L8:
        throw new IllegalArgumentException("unknown security category: " + this.privateKey.getSecurityCategory());
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public void init(boolean r100, CipherParameters r101) {
        if (r100 == true) goto L5;
        this.privateKey = null;
        QTESLAPublicKeyParameters r102 = (QTESLAPublicKeyParameters) r101;
        this.publicKey = r102;
        int r103 = r102.getSecurityCategory();
    L10:
        QTESLASecurityCategory.validate(r103);
        return;
    L5:
        if ((r101 instanceof ParametersWithRandom) == false) goto L7;
        ParametersWithRandom r104 = (ParametersWithRandom) r101;
        this.secureRandom = r104.getRandom();
        this.privateKey = (QTESLAPrivateKeyParameters) r104.getParameters();
    L8:
        this.publicKey = null;
        r103 = this.privateKey.getSecurityCategory();
        goto L10
    L7:
        this.secureRandom = CryptoServicesRegistrar.getSecureRandom();
        this.privateKey = (QTESLAPrivateKeyParameters) r101;
        goto L8
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] r100, byte[] r101) {
        int r102 = this.publicKey.getSecurityCategory();
        if (r102 != 5) goto L5;
        int r103 = QTesla1p.verifying(r100, r101, 0, r101.length, this.publicKey.getPublicData());
    L10:
        if (r103 != 0) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r102 != 6) goto L8;
        r103 = QTesla3p.verifying(r100, r101, 0, r101.length, this.publicKey.getPublicData());
        goto L10
    L8:
        throw new IllegalArgumentException("unknown security category: " + this.publicKey.getSecurityCategory());
    }
}
