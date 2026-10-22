package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class NHAgreement {
    private NHPrivateKeyParameters privKey;

    public NHAgreement() {
    }

    public byte[] calculateAgreement(CipherParameters r100) {
        byte[] r101 = new byte[32];
        NewHope.sharedA(r101, this.privKey.secData, ((NHPublicKeyParameters) r100).pubData);
        return r101;
    }

    public void init(CipherParameters r100) {
        this.privKey = (NHPrivateKeyParameters) r100;
    }
}
