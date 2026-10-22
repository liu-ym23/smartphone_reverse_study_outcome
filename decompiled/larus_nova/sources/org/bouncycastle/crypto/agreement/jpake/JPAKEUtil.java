package org.bouncycastle.crypto.agreement.jpake;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class JPAKEUtil {
    static final BigInteger ONE = null;
    static final BigInteger ZERO = null;

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
    }

    public JPAKEUtil() {
    }

    public static BigInteger calculateA(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103) {
        return r102.modPow(r103, r100);
    }

    public static BigInteger calculateGA(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103) {
        return r101.multiply(r102).multiply(r103).mod(r100);
    }

    public static BigInteger calculateGx(BigInteger r100, BigInteger r101, BigInteger r102) {
        return r101.modPow(r102, r100);
    }

    private static BigInteger calculateHashForZeroKnowledgeProof(BigInteger r100, BigInteger r101, BigInteger r102, String r103, Digest r104) {
        r104.reset();
        updateDigestIncludingSize(r104, r100);
        updateDigestIncludingSize(r104, r101);
        updateDigestIncludingSize(r104, r102);
        updateDigestIncludingSize(r104, r103);
        byte[] r105 = new byte[r104.getDigestSize()];
        r104.doFinal(r105, 0);
        return new BigInteger(r105);
    }

    public static BigInteger calculateKeyingMaterial(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103, BigInteger r104, BigInteger r105) {
        return r102.modPow(r103.multiply(r104).negate().mod(r101), r100).multiply(r105).modPow(r103, r100);
    }

    private static byte[] calculateMacKey(BigInteger r100, Digest r101) {
        r101.reset();
        updateDigest(r101, r100);
        updateDigest(r101, "JPAKE_KC");
        byte[] r102 = new byte[r101.getDigestSize()];
        r101.doFinal(r102, 0);
        return r102;
    }

    public static BigInteger calculateMacTag(String r100, String r101, BigInteger r102, BigInteger r103, BigInteger r104, BigInteger r105, BigInteger r106, Digest r107) {
        byte[] r108 = calculateMacKey(r106, r107);
        HMac r109 = new HMac(r107);
        byte[] r110 = new byte[r109.getMacSize()];
        r109.init(new KeyParameter(r108));
        updateMac(r109, "KC_1_U");
        updateMac(r109, r100);
        updateMac(r109, r101);
        updateMac(r109, r102);
        updateMac(r109, r103);
        updateMac(r109, r104);
        updateMac(r109, r105);
        r109.doFinal(r110, 0);
        Arrays.fill(r108, (byte) 0);
        return new BigInteger(r110);
    }

    public static BigInteger calculateS(char[] r100) {
        return new BigInteger(Strings.toUTF8ByteArray(r100));
    }

    public static BigInteger calculateX2s(BigInteger r100, BigInteger r101, BigInteger r102) {
        return r101.multiply(r102).mod(r100);
    }

    public static BigInteger[] calculateZeroKnowledgeProof(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103, BigInteger r104, String r105, Digest r106, SecureRandom r110) {
        BigInteger r111 = BigIntegers.createRandomInRange(ZERO, r101.subtract(ONE), r110);
        BigInteger r107 = r102.modPow(r111, r100);
        return new BigInteger[]{r107, r111.subtract(r104.multiply(calculateHashForZeroKnowledgeProof(r102, r107, r103, r105, r106))).mod(r101)};
    }

    public static BigInteger generateX1(BigInteger r100, SecureRandom r101) {
        return BigIntegers.createRandomInRange(ZERO, r100.subtract(ONE), r101);
    }

    public static BigInteger generateX2(BigInteger r100, SecureRandom r101) {
        BigInteger r102 = ONE;
        return BigIntegers.createRandomInRange(r102, r100.subtract(r102), r101);
    }

    private static byte[] intToByteArray(int r100) {
        return new byte[]{(byte) (r100 >>> 24), (byte) (r100 >>> 16), (byte) (r100 >>> 8), (byte) r100};
    }

    private static void updateDigest(Digest r100, String r101) {
        byte[] r102 = Strings.toUTF8ByteArray(r101);
        r100.update(r102, 0, r102.length);
        Arrays.fill(r102, (byte) 0);
    }

    private static void updateDigest(Digest r100, BigInteger r101) {
        byte[] r102 = BigIntegers.asUnsignedByteArray(r101);
        r100.update(r102, 0, r102.length);
        Arrays.fill(r102, (byte) 0);
    }

    private static void updateDigestIncludingSize(Digest r100, String r101) {
        byte[] r102 = Strings.toUTF8ByteArray(r101);
        r100.update(intToByteArray(r102.length), 0, 4);
        r100.update(r102, 0, r102.length);
        Arrays.fill(r102, (byte) 0);
    }

    private static void updateDigestIncludingSize(Digest r100, BigInteger r101) {
        byte[] r102 = BigIntegers.asUnsignedByteArray(r101);
        r100.update(intToByteArray(r102.length), 0, 4);
        r100.update(r102, 0, r102.length);
        Arrays.fill(r102, (byte) 0);
    }

    private static void updateMac(Mac r100, String r101) {
        byte[] r102 = Strings.toUTF8ByteArray(r101);
        r100.update(r102, 0, r102.length);
        Arrays.fill(r102, (byte) 0);
    }

    private static void updateMac(Mac r100, BigInteger r101) {
        byte[] r102 = BigIntegers.asUnsignedByteArray(r101);
        r100.update(r102, 0, r102.length);
        Arrays.fill(r102, (byte) 0);
    }

    public static void validateGa(BigInteger r100) throws CryptoException {
        if (r100.equals(ONE) == true) goto L6;
        return;
    L6:
        throw new CryptoException("ga is equal to 1.  It should not be.  The chances of this happening are on the order of 2^160 for a 160-bit q.  Try again.");
    }

    public static void validateGx4(BigInteger r100) throws CryptoException {
        if (r100.equals(ONE) == true) goto L6;
        return;
    L6:
        throw new CryptoException("g^x validation failed.  g^x should not be 1.");
    }

    public static void validateMacTag(String r100, String r101, BigInteger r110, BigInteger r111, BigInteger r112, BigInteger r113, BigInteger r114, Digest r115, BigInteger r116) throws CryptoException {
        if (calculateMacTag(r101, r100, r112, r113, r110, r111, r114, r115).equals(r116) == false) goto L6;
        return;
    L6:
        throw new CryptoException("Partner MacTag validation failed. Therefore, the password, MAC, or digest algorithm of each participant does not match.");
    }

    public static void validateNotNull(Object r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r101 + " must not be null");
    }

    public static void validateParticipantIdsDiffer(String r100, String r101) throws CryptoException {
        if (r100.equals(r101) == true) goto L6;
        return;
    L6:
        throw new CryptoException("Both participants are using the same participantId (" + r100 + "). This is not allowed. Each participant must use a unique participantId.");
    }

    public static void validateParticipantIdsEqual(String r100, String r101) throws CryptoException {
        if (r100.equals(r101) == false) goto L6;
        return;
    L6:
        throw new CryptoException("Received payload from incorrect partner (" + r101 + "). Expected to receive payload from " + r100 + ".");
    }

    public static void validateZeroKnowledgeProof(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103, BigInteger[] r104, String r105, Digest r106) throws CryptoException {
        BigInteger r107 = r104[0];
        BigInteger r108 = r104[1];
        BigInteger r109 = calculateHashForZeroKnowledgeProof(r102, r107, r103, r105, r106);
        if (r103.compareTo(ZERO) != 1) goto L12;
        if (r103.compareTo(r100) != (-1)) goto L12;
        if (r103.modPow(r101, r100).compareTo(ONE) != 0) goto L12;
        if (r102.modPow(r108, r100).multiply(r103.modPow(r109, r100)).mod(r100).compareTo(r107) != 0) goto L12;
        return;
    L12:
        throw new CryptoException("Zero-knowledge proof validation failed");
    }
}
