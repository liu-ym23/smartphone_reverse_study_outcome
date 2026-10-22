package org.bouncycastle.crypto;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public interface BasicAgreement {
    BigInteger calculateAgreement(CipherParameters r100);

    int getFieldSize();

    void init(CipherParameters r100);
}
