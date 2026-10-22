package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public interface DSAEncoder {
    BigInteger[] decode(byte[] r100) throws IOException;

    byte[] encode(BigInteger r100, BigInteger r101) throws IOException;
}
