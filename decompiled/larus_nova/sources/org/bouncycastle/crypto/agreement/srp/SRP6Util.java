package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class SRP6Util {
    private static BigInteger ONE;
    private static BigInteger ZERO;

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
    }

    public SRP6Util() {
    }

    public static BigInteger calculateK(Digest r100, BigInteger r101, BigInteger r102) {
        return hashPaddedPair(r100, r101, r101, r102);
    }

    public static BigInteger calculateKey(Digest r100, BigInteger r101, BigInteger r102) {
        byte[] r103 = getPadded(r102, (r101.bitLength() + 7) / 8);
        r100.update(r103, 0, r103.length);
        byte[] r104 = new byte[r100.getDigestSize()];
        r100.doFinal(r104, 0);
        return new BigInteger(1, r104);
    }

    public static BigInteger calculateM1(Digest r100, BigInteger r101, BigInteger r102, BigInteger r103, BigInteger r104) {
        return hashPaddedTriplet(r100, r101, r102, r103, r104);
    }

    public static BigInteger calculateM2(Digest r100, BigInteger r101, BigInteger r102, BigInteger r103, BigInteger r104) {
        return hashPaddedTriplet(r100, r101, r102, r103, r104);
    }

    public static BigInteger calculateU(Digest r100, BigInteger r101, BigInteger r102, BigInteger r103) {
        return hashPaddedPair(r100, r101, r102, r103);
    }

    public static BigInteger calculateX(Digest r100, BigInteger r101, byte[] r102, byte[] r103, byte[] r104) {
        int r105 = r100.getDigestSize();
        byte[] r106 = new byte[r105];
        r100.update(r103, 0, r103.length);
        r100.update((byte) 58);
        r100.update(r104, 0, r104.length);
        r100.doFinal(r106, 0);
        r100.update(r102, 0, r102.length);
        r100.update(r106, 0, r105);
        r100.doFinal(r106, 0);
        return new BigInteger(1, r106);
    }

    public static BigInteger generatePrivateValue(Digest r100, BigInteger r101, BigInteger r102, SecureRandom r103) {
        return BigIntegers.createRandomInRange(ONE.shiftLeft(Math.min(256, r101.bitLength() / 2) - 1), r101.subtract(ONE), r103);
    }

    private static byte[] getPadded(BigInteger r100, int r101) {
        byte[] r102 = BigIntegers.asUnsignedByteArray(r100);
        if (r102.length >= r101) goto L6;
        byte[] r103 = new byte[r101];
        System.arraycopy(r102, 0, r103, r101 - r102.length, r102.length);
        return r103;
    L6:
        return r102;
    }

    private static BigInteger hashPaddedPair(Digest r100, BigInteger r101, BigInteger r102, BigInteger r103) {
        int r104 = (r101.bitLength() + 7) / 8;
        byte[] r105 = getPadded(r102, r104);
        byte[] r106 = getPadded(r103, r104);
        r100.update(r105, 0, r105.length);
        r100.update(r106, 0, r106.length);
        byte[] r107 = new byte[r100.getDigestSize()];
        r100.doFinal(r107, 0);
        return new BigInteger(1, r107);
    }

    private static BigInteger hashPaddedTriplet(Digest r100, BigInteger r101, BigInteger r102, BigInteger r103, BigInteger r104) {
        int r105 = (r101.bitLength() + 7) / 8;
        byte[] r106 = getPadded(r102, r105);
        byte[] r107 = getPadded(r103, r105);
        byte[] r108 = getPadded(r104, r105);
        r100.update(r106, 0, r106.length);
        r100.update(r107, 0, r107.length);
        r100.update(r108, 0, r108.length);
        byte[] r109 = new byte[r100.getDigestSize()];
        r100.doFinal(r109, 0);
        return new BigInteger(1, r109);
    }

    public static BigInteger validatePublicValue(BigInteger r100, BigInteger r101) throws CryptoException {
        BigInteger r102 = r101.mod(r100);
        if (r102.equals(ZERO) == true) goto L6;
        return r102;
    L6:
        throw new CryptoException("Invalid public value: 0");
    }
}
