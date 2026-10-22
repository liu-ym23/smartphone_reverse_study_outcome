package org.bouncycastle.crypto;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public interface DSA {
    BigInteger[] generateSignature(byte[] r100);

    void init(boolean r100, CipherParameters r101);

    boolean verifySignature(byte[] r100, BigInteger r101, BigInteger r102);
}
