package org.bouncycastle.pqc.crypto;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public interface MessageSigner {
    byte[] generateSignature(byte[] r100);

    void init(boolean r100, CipherParameters r101);

    boolean verifySignature(byte[] r100, byte[] r101);
}
