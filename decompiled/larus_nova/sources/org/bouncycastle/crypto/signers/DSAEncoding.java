package org.bouncycastle.crypto.signers;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public interface DSAEncoding {
    BigInteger[] decode(BigInteger r100, byte[] r101) throws IOException;

    byte[] encode(BigInteger r100, BigInteger r101, BigInteger r102) throws IOException;
}
