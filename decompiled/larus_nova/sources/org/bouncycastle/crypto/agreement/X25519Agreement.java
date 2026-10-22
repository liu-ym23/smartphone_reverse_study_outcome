package org.bouncycastle.crypto.agreement;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.RawAgreement;
import org.bouncycastle.crypto.params.X25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;

/* JADX INFO: loaded from: classes42.dex */
public final class X25519Agreement implements RawAgreement {
    private X25519PrivateKeyParameters privateKey;

    public X25519Agreement() {
    }

    @Override // org.bouncycastle.crypto.RawAgreement
    public void calculateAgreement(CipherParameters r100, byte[] r101, int r102) {
        this.privateKey.generateSecret((X25519PublicKeyParameters) r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.RawAgreement
    public int getAgreementSize() {
        return 32;
    }

    @Override // org.bouncycastle.crypto.RawAgreement
    public void init(CipherParameters r100) {
        this.privateKey = (X25519PrivateKeyParameters) r100;
    }
}
