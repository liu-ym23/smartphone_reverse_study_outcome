package org.bouncycastle.util.test;

import java.math.BigInteger;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class TestRandomBigInteger extends FixedSecureRandom {
    public TestRandomBigInteger(int r100, byte[] r101) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.BigInteger(r100, r101)});
    }

    public TestRandomBigInteger(String r100) {
        this(r100, 10);
    }

    public TestRandomBigInteger(String r100, int r101) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.BigInteger(BigIntegers.asUnsignedByteArray(new BigInteger(r100, r101)))});
    }

    public TestRandomBigInteger(byte[] r100) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.BigInteger(r100)});
    }
}
