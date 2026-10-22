package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes42.dex */
public interface DSAKCalculator {
    void init(BigInteger r100, BigInteger r101, byte[] r102);

    void init(BigInteger r100, SecureRandom r101);

    boolean isDeterministic();

    BigInteger nextK();
}
