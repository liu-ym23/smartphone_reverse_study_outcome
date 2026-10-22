package org.bouncycastle.pqc.crypto;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes42.dex */
public interface MessageEncryptor {
    void init(boolean r100, CipherParameters r101);

    byte[] messageDecrypt(byte[] r100) throws InvalidCipherTextException;

    byte[] messageEncrypt(byte[] r100);
}
