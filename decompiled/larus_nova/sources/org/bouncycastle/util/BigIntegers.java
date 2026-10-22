package org.bouncycastle.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;

/* JADX INFO: loaded from: classes42.dex */
public final class BigIntegers {
    private static final int MAX_ITERATIONS = 1000;
    private static final int MAX_SMALL = 0;
    public static final BigInteger ONE = null;
    private static final BigInteger SMALL_PRIMES_PRODUCT = null;
    private static final BigInteger THREE = null;
    public static final BigInteger TWO = null;
    public static final BigInteger ZERO = null;

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
        THREE = BigInteger.valueOf(3);
        SMALL_PRIMES_PRODUCT = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);
        MAX_SMALL = BigInteger.valueOf(743).bitLength();
    }

    public BigIntegers() {
    }

    public static void asUnsignedByteArray(BigInteger r100, byte[] r101, int r102, int r103) {
        byte[] r104 = r100.toByteArray();
        if (r104.length != r103) goto L7;
        System.arraycopy(r104, 0, r101, r102, r103);
        return;
    L7:
        if (r104[0] != 0) goto L11;
        int r105 = 1;
        if (r104.length == 1) goto L11;
    L12:
        int r106 = r104.length - r105;
        if (r106 > r103) goto L17;
        int r107 = (r103 - r106) + r102;
        Arrays.fill(r101, r102, r107, (byte) 0);
        System.arraycopy(r104, r105, r101, r107, r106);
        return;
    L17:
        throw new IllegalArgumentException("standard length exceeded for value");
    L11:
        r105 = 0;
        goto L12
    }

    public static byte[] asUnsignedByteArray(int r100, BigInteger r101) {
        byte[] r102 = r101.toByteArray();
        if (r102.length != r100) goto L5;
        return r102;
    L5:
        int r103 = 0;
        if (r102[0] == 0) goto L8;
    L10:
        int r104 = r102.length - r103;
        if (r104 > r100) goto L15;
        byte[] r105 = new byte[r100];
        System.arraycopy(r102, r103, r105, r100 - r104, r104);
        return r105;
    L15:
        throw new IllegalArgumentException("standard length exceeded for value");
    L8:
        if (r102.length == 1) goto L10;
        r103 = 1;
        goto L10
    }

    public static byte[] asUnsignedByteArray(BigInteger r100) {
        byte[] r101 = r100.toByteArray();
        if (r101[0] == 0) goto L5;
    L8:
        return r101;
    L5:
        if (r101.length == 1) goto L8;
        int r102 = r101.length - 1;
        byte[] r103 = new byte[r102];
        System.arraycopy(r101, 1, r103, 0, r102);
        return r103;
    }

    private static byte[] createRandom(int r100, SecureRandom r101) throws IllegalArgumentException {
        if (r100 < 1) goto L7;
        int r102 = (r100 + 7) / 8;
        byte[] r103 = new byte[r102];
        r101.nextBytes(r103);
        r103[0] = (byte) (r103[0] & ((byte) (255 >>> ((r102 * 8) - r100))));
        return r103;
    L7:
        throw new IllegalArgumentException("bitLength must be at least 1");
    }

    public static BigInteger createRandomBigInteger(int r100, SecureRandom r101) {
        return new BigInteger(1, createRandom(r100, r101));
    }

    public static BigInteger createRandomInRange(BigInteger r100, BigInteger r101, SecureRandom r102) {
        int r103 = r100.compareTo(r101);
        if (r103 < 0) goto L9;
        if (r103 > 0) goto L7;
        return r100;
    L7:
        throw new IllegalArgumentException("'min' may not be greater than 'max'");
    L9:
        if (r100.bitLength() <= (r101.bitLength() / 2)) goto L13;
        BigInteger r104 = createRandomInRange(ZERO, r101.subtract(r100), r102);
    L12:
        return r104.add(r100);
    L13:
        int r105 = 0;
    L15:
        if (r105 >= 1000) goto L22;
        BigInteger r106 = createRandomBigInteger(r101.bitLength(), r102);
        if (r106.compareTo(r100) < 0) goto L21;
        if (r106.compareTo(r101) > 0) goto L21;
        return r106;
    L21:
        r105 = r105 + 1;
        goto L15
    L22:
        r104 = createRandomBigInteger(r101.subtract(r100).bitLength() - 1, r102);
        goto L12
    }

    public static BigInteger createRandomPrime(int r100, int r101, SecureRandom r102) {
        if (r100 < 2) goto L19;
        if (r100 == 2) goto L6;
    L10:
        byte[] r103 = createRandom(r100, r102);
        r103[0] = (byte) (((byte) (1 << (7 - ((r103.length * 8) - r100)))) | r103[0]);
        int r104 = r103.length - 1;
        r103[r104] = (byte) (r103[r104] | 1);
        BigInteger r105 = new BigInteger(1, r103);
        if (r100 <= MAX_SMALL) goto L16;
    L13:
        if (r105.gcd(SMALL_PRIMES_PRODUCT).equals(ONE) == true) goto L16;
        r105 = r105.add(TWO);
    L16:
        if (r105.isProbablePrime(r101) == false) goto L10;
        return r105;
    L6:
        if (r102.nextInt() >= 0) goto L9;
        return TWO;
    L9:
        return THREE;
    L19:
        throw new IllegalArgumentException("bitLength < 2");
    }

    public static BigInteger fromUnsignedByteArray(byte[] r100) {
        return new BigInteger(1, r100);
    }

    public static BigInteger fromUnsignedByteArray(byte[] r100, int r101, int r102) {
        if (r101 == 0) goto L4;
    L5:
        byte[] r103 = new byte[r102];
        System.arraycopy(r100, r101, r103, 0, r102);
        r100 = r103;
    L7:
        return new BigInteger(1, r100);
    L4:
        if (r102 == r100.length) goto L7;
        goto L5
    }

    public static int getUnsignedByteLength(BigInteger r100) {
        if (r100.equals(ZERO) == false) goto L7;
        return 1;
    L7:
        return (r100.bitLength() + 7) / 8;
    }

    public static int intValueExact(BigInteger r100) {
        if (r100.bitLength() > 31) goto L7;
        return r100.intValue();
    L7:
        throw new ArithmeticException("BigInteger out of int range");
    }

    public static long longValueExact(BigInteger r100) {
        if (r100.bitLength() > 63) goto L7;
        return r100.longValue();
    L7:
        throw new ArithmeticException("BigInteger out of long range");
    }

    public static BigInteger modOddInverse(BigInteger r100, BigInteger r101) {
        if (r100.testBit(0) == false) goto L20;
        if (r100.signum() != 1) goto L18;
        if (r101.signum() >= 0) goto L9;
    L10:
        r101 = r101.mod(r100);
    L11:
        int r102 = r100.bitLength();
        int[] r103 = Nat.fromBigInteger(r102, r100);
        int[] r104 = Nat.fromBigInteger(r102, r101);
        int r105 = r103.length;
        int[] r106 = Nat.create(r105);
        if (Mod.modOddInverse(r103, r104, r106) == 0) goto L16;
        return Nat.toBigInteger(r105, r106);
    L16:
        throw new ArithmeticException("BigInteger not invertible.");
    L9:
        if (r101.compareTo(r100) < 0) goto L11;
    L18:
        throw new ArithmeticException("BigInteger: modulus not positive");
    L20:
        throw new IllegalArgumentException("'M' must be odd");
    }

    public static BigInteger modOddInverseVar(BigInteger r100, BigInteger r101) {
        if (r100.testBit(0) == false) goto L27;
        if (r100.signum() != 1) goto L25;
        BigInteger r102 = ONE;
        if (r100.equals(r102) == false) goto L11;
        return ZERO;
    L11:
        if (r101.signum() >= 0) goto L13;
    L14:
        r101 = r101.mod(r100);
    L16:
        if (r101.equals(r102) == false) goto L18;
        return r102;
    L18:
        int r103 = r100.bitLength();
        int[] r104 = Nat.fromBigInteger(r103, r100);
        int[] r105 = Nat.fromBigInteger(r103, r101);
        int r106 = r104.length;
        int[] r107 = Nat.create(r106);
        if (Mod.modOddInverseVar(r104, r105, r107) == false) goto L23;
        return Nat.toBigInteger(r106, r107);
    L23:
        throw new ArithmeticException("BigInteger not invertible.");
    L13:
        if (r101.compareTo(r100) < 0) goto L16;
    L25:
        throw new ArithmeticException("BigInteger: modulus not positive");
    L27:
        throw new IllegalArgumentException("'M' must be odd");
    }
}
