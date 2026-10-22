package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public interface RawAgreement {
    void calculateAgreement(CipherParameters r100, byte[] r101, int r102);

    int getAgreementSize();

    void init(CipherParameters r100);
}
