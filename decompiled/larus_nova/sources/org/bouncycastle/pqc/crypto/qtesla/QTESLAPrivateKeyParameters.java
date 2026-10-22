package org.bouncycastle.pqc.crypto.qtesla;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public final class QTESLAPrivateKeyParameters extends AsymmetricKeyParameter {
    private byte[] privateKey;
    private int securityCategory;

    public QTESLAPrivateKeyParameters(int r100, byte[] r101) {
        super(true);
        if (r101.length != QTESLASecurityCategory.getPrivateSize(r100)) goto L7;
        this.securityCategory = r100;
        this.privateKey = Arrays.clone(r101);
        return;
    L7:
        throw new IllegalArgumentException("invalid key size for security category");
    }

    public byte[] getSecret() {
        return Arrays.clone(this.privateKey);
    }

    public int getSecurityCategory() {
        return this.securityCategory;
    }
}
