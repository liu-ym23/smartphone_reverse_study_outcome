package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public interface ECConstants {
    public static final BigInteger EIGHT = null;
    public static final BigInteger FOUR = null;
    public static final BigInteger ONE = null;
    public static final BigInteger THREE = null;
    public static final BigInteger TWO = null;
    public static final BigInteger ZERO = null;

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
        THREE = BigInteger.valueOf(3);
        FOUR = BigInteger.valueOf(4);
        EIGHT = BigInteger.valueOf(8);
    }
}
