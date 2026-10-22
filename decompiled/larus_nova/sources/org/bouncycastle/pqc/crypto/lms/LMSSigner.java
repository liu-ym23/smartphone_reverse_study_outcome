package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.MessageSigner;

/* JADX INFO: loaded from: classes42.dex */
public class LMSSigner implements MessageSigner {
    private LMSPrivateKeyParameters privKey;
    private LMSPublicKeyParameters pubKey;

    public LMSSigner() {
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] r100) {
        return LMS.generateSign(this.privKey, r100).getEncoded();
    L4:
        e = move-exception;
        throw new IllegalStateException("unable to encode signature: " + e.getMessage());
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public void init(boolean r100, CipherParameters r101) {
        if (r100 == false) goto L4;
        this.privKey = (LMSPrivateKeyParameters) r101;
        return;
    L4:
        this.pubKey = (LMSPublicKeyParameters) r101;
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] r100, byte[] r101) {
        return LMS.verifySignature(this.pubKey, LMSSignature.getInstance(r101), r100);
    L4:
        e = move-exception;
        throw new IllegalStateException("unable to decode signature: " + e.getMessage());
    }
}
