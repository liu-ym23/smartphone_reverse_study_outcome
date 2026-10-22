package org.bouncycastle.pqc.crypto.qtesla;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public final class QTESLAPublicKeyParameters extends AsymmetricKeyParameter {
    private byte[] publicKey;
    private int securityCategory;

    public QTESLAPublicKeyParameters(int r100, byte[] r101) {
        super(false);
        if (r101.length != QTESLASecurityCategory.getPublicSize(r100)) goto L7;
        this.securityCategory = r100;
        this.publicKey = Arrays.clone(r101);
        return;
    L7:
        throw new IllegalArgumentException("invalid key size for security category");
    }

    public byte[] getPublicData() {
        return Arrays.clone(this.publicKey);
    }

    public int getSecurityCategory() {
        return this.securityCategory;
    }
}
