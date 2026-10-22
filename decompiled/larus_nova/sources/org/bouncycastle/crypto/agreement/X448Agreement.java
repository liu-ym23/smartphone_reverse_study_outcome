package org.bouncycastle.crypto.agreement;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.RawAgreement;
import org.bouncycastle.crypto.params.X448PrivateKeyParameters;
import org.bouncycastle.crypto.params.X448PublicKeyParameters;

/* JADX INFO: loaded from: classes42.dex */
public final class X448Agreement implements RawAgreement {
    private X448PrivateKeyParameters privateKey;

    public X448Agreement() {
    }

    @Override // org.bouncycastle.crypto.RawAgreement
    public void calculateAgreement(CipherParameters r100, byte[] r101, int r102) {
        this.privateKey.generateSecret((X448PublicKeyParameters) r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.RawAgreement
    public int getAgreementSize() {
        return 56;
    }

    @Override // org.bouncycastle.crypto.RawAgreement
    public void init(CipherParameters r100) {
        this.privateKey = (X448PrivateKeyParameters) r100;
    }
}
