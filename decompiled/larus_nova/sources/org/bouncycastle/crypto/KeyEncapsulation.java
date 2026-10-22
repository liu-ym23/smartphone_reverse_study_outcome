package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public interface KeyEncapsulation {
    CipherParameters decrypt(byte[] r100, int r101, int r102, int r103);

    CipherParameters encrypt(byte[] r100, int r101, int r102);

    void init(CipherParameters r100);
}
