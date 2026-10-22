package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.MessageSigner;

/* JADX INFO: loaded from: classes42.dex */
public class HSSSigner implements MessageSigner {
    private HSSPrivateKeyParameters privKey;
    private HSSPublicKeyParameters pubKey;

    public HSSSigner() {
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] r100) {
        return HSS.generateSignature(this.privKey, r100).getEncoded();
    L4:
        e = move-exception;
        throw new IllegalStateException("unable to encode signature: " + e.getMessage());
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public void init(boolean r100, CipherParameters r101) {
        if (r100 == false) goto L4;
        this.privKey = (HSSPrivateKeyParameters) r101;
        return;
    L4:
        this.pubKey = (HSSPublicKeyParameters) r101;
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] r100, byte[] r101) {
        HSSPublicKeyParameters r102 = this.pubKey;     // Catch: IOException -> L4
        return HSS.verifySignature(r102, HSSSignature.getInstance(r101, r102.getL()), r100);
    L4:
        e = move-exception;
        throw new IllegalStateException("unable to decode signature: " + e.getMessage());
    }
}
