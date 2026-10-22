package org.bouncycastle.math;

import com.ss.ttm.player.MediaPlayer;
import java.math.BigInteger;
import java.security.SecureRandom;
import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Primes {
    private static final BigInteger ONE = null;
    public static final int SMALL_FACTOR_LIMIT = 211;
    private static final BigInteger THREE = null;
    private static final BigInteger TWO = null;

    /* JADX INFO: renamed from: org.bouncycastle.math.Primes$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class MROutput {
        private BigInteger factor;
        private boolean provablyComposite;

        private MROutput(boolean r100, BigInteger r101) {
            this.provablyComposite = r100;
            this.factor = r101;
        }

        public static /* synthetic */ MROutput access$000() {
            return probablyPrime();
        }

        public static /* synthetic */ MROutput access$100(BigInteger r100) {
            return provablyCompositeWithFactor(r100);
        }

        public static /* synthetic */ MROutput access$200() {
            return provablyCompositeNotPrimePower();
        }

        private static MROutput probablyPrime() {
            return new MROutput(false, null);
        }

        private static MROutput provablyCompositeNotPrimePower() {
            return new MROutput(true, null);
        }

        private static MROutput provablyCompositeWithFactor(BigInteger r100) {
            return new MROutput(true, r100);
        }

        public BigInteger getFactor() {
            return this.factor;
        }

        public boolean isNotPrimePower() {
            if (this.provablyComposite == true) goto L5;
        L7:
            return false;
        L5:
            if (this.factor != null) goto L7;
            return true;
        }

        public boolean isProvablyComposite() {
            return this.provablyComposite;
        }
    }

    public static class STOutput {
        private BigInteger prime;
        private int primeGenCounter;
        private byte[] primeSeed;

        private STOutput(BigInteger r100, byte[] r101, int r102) {
            this.prime = r100;
            this.primeSeed = r101;
            this.primeGenCounter = r102;
        }

        public /* synthetic */ STOutput(BigInteger r100, byte[] r101, int r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }

        public BigInteger getPrime() {
            return this.prime;
        }

        public int getPrimeGenCounter() {
            return this.primeGenCounter;
        }

        public byte[] getPrimeSeed() {
            return this.primeSeed;
        }
    }

    static {
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
        THREE = BigInteger.valueOf(3);
    }

    public Primes() {
    }

    private static void checkCandidate(BigInteger r100, String r101) {
        if (r100 == null) goto L9;
        if (r100.signum() < 1) goto L9;
        if (r100.bitLength() < 2) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("'" + r101 + "' must be non-null and >= 2");
    }

    public static MROutput enhancedMRProbablePrimeTest(BigInteger r110, SecureRandom r111, int r112) {
        checkCandidate(r110, "candidate");
        if (r111 == null) goto L55;
        if (r112 < 1) goto L53;
        if (r110.bitLength() != 2) goto L11;
        return MROutput.access$000();
    L11:
        if (r110.testBit(0) == false) goto L13;
        BigInteger r100 = r110.subtract(ONE);
        BigInteger r101 = r110.subtract(TWO);
        int r102 = r100.getLowestSetBit();
        BigInteger r103 = r100.shiftRight(r102);
        int r104 = 0;
    L15:
        if (r104 >= r112) goto L51;
        BigInteger r105 = BigIntegers.createRandomInRange(TWO, r101, r111);
        BigInteger r106 = r105.gcd(r110);
        BigInteger r107 = ONE;
        if (r106.compareTo(r107) > 0) goto L19;
        BigInteger r108 = r105.modPow(r103, r110);
        if (r108.equals(r107) == true) goto L49;
        if (r108.equals(r100) == true) goto L49;
        int r109 = 1;
    L26:
        if (r109 >= r102) goto L34;
        BigInteger r113 = r108.modPow(TWO, r110);
        if (r113.equals(r100) == true) goto L29;
        if (r113.equals(ONE) == true) goto L35;
        r109 = r109 + 1;
        r108 = r113;
    L35:
        boolean r114 = false;
    L36:
        if (r114 == true) goto L49;
        BigInteger r115 = ONE;
        if (r113.equals(r115) == true) goto L43;
        r108 = r113.modPow(TWO, r110);
        if (r108.equals(r115) == false) goto L43;
        r108 = r113;
    L43:
        BigInteger r116 = r108.subtract(r115).gcd(r110);
        if (r116.compareTo(r115) <= 0) goto L48;
        return MROutput.access$100(r116);
    L48:
        return MROutput.access$200();
    L29:
        r114 = true;
        goto L36
    L34:
        r113 = r108;
    L49:
        r104 = r104 + 1;
        goto L15
    L19:
        return MROutput.access$100(r106);
    L51:
        return MROutput.access$000();
    L13:
        return MROutput.access$100(TWO);
    L53:
        throw new IllegalArgumentException("'iterations' must be > 0");
    L55:
        throw new IllegalArgumentException("'random' cannot be null");
    }

    private static int extract32(byte[] r100) {
        int r101 = Math.min(4, r100.length);
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L5;
        int r104 = r102 + 1;
        r103 = r103 | ((r100[r100.length - r104] & UByte.MAX_VALUE) << (r102 * 8));
        r102 = r104;
        goto L3
    L5:
        return r103;
    }

    public static STOutput generateSTRandomPrime(Digest r100, int r101, byte[] r102) {
        if (r100 == null) goto L15;
        if (r101 < 2) goto L13;
        if (r102 == null) goto L11;
        if (r102.length == 0) goto L11;
        return implSTRandomPrime(r100, r101, Arrays.clone(r102));
    L11:
        throw new IllegalArgumentException("'inputSeed' cannot be null or empty");
    L13:
        throw new IllegalArgumentException("'length' must be >= 2");
    L15:
        throw new IllegalArgumentException("'hash' cannot be null");
    }

    public static boolean hasAnySmallFactors(BigInteger r100) {
        checkCandidate(r100, "candidate");
        return implHasAnySmallFactors(r100);
    }

    private static void hash(Digest r100, byte[] r101, byte[] r102, int r103) {
        r100.update(r101, 0, r101.length);
        r100.doFinal(r102, r103);
    }

    private static BigInteger hashGen(Digest r100, byte[] r101, int r102) {
        int r103 = r100.getDigestSize();
        int r104 = r102 * r103;
        byte[] r105 = new byte[r104];
        int r106 = 0;
    L4:
        if (r106 >= r102) goto L7;
        r104 = r104 - r103;
        hash(r100, r101, r105, r104);
        inc(r101, 1);
        r106 = r106 + 1;
        goto L4
    L7:
        return new BigInteger(1, r105);
    }

    private static boolean implHasAnySmallFactors(BigInteger r100) {
        int r101 = r100.mod(BigInteger.valueOf(223092870)).intValue();
        if ((r101 % 2) != 0) goto L5;
    L108:
        return true;
    L5:
        if ((r101 % 3) == 0) goto L108;
        if ((r101 % 5) == 0) goto L108;
        if ((r101 % 7) == 0) goto L108;
        if ((r101 % 11) == 0) goto L108;
        if ((r101 % 13) == 0) goto L108;
        if ((r101 % 17) == 0) goto L108;
        if ((r101 % 19) == 0) goto L108;
        if ((r101 % 23) == 0) goto L108;
        int r102 = r100.mod(BigInteger.valueOf(58642669)).intValue();
        if ((r102 % 29) == 0) goto L108;
        if ((r102 % 31) == 0) goto L108;
        if ((r102 % 37) == 0) goto L108;
        if ((r102 % 41) == 0) goto L108;
        if ((r102 % 43) == 0) goto L108;
        int r103 = r100.mod(BigInteger.valueOf(600662303)).intValue();
        if ((r103 % 47) == 0) goto L108;
        if ((r103 % 53) == 0) goto L108;
        if ((r103 % 59) == 0) goto L108;
        if ((r103 % 61) == 0) goto L108;
        if ((r103 % 67) == 0) goto L108;
        int r104 = r100.mod(BigInteger.valueOf(33984931)).intValue();
        if ((r104 % 71) == 0) goto L108;
        if ((r104 % 73) == 0) goto L108;
        if ((r104 % 79) == 0) goto L108;
        if ((r104 % 83) == 0) goto L108;
        int r105 = r100.mod(BigInteger.valueOf(89809099)).intValue();
        if ((r105 % 89) == 0) goto L108;
        if ((r105 % 97) == 0) goto L108;
        if ((r105 % 101) == 0) goto L108;
        if ((r105 % 103) == 0) goto L108;
        int r106 = r100.mod(BigInteger.valueOf(167375713)).intValue();
        if ((r106 % 107) == 0) goto L108;
        if ((r106 % 109) == 0) goto L108;
        if ((r106 % 113) == 0) goto L108;
        if ((r106 % 127) == 0) goto L108;
        int r107 = r100.mod(BigInteger.valueOf(371700317)).intValue();
        if ((r107 % 131) == 0) goto L108;
        if ((r107 % 137) == 0) goto L108;
        if ((r107 % 139) == 0) goto L108;
        if ((r107 % 149) == 0) goto L108;
        int r108 = r100.mod(BigInteger.valueOf(645328247)).intValue();
        if ((r108 % 151) == 0) goto L108;
        if ((r108 % 157) == 0) goto L108;
        if ((r108 % 163) == 0) goto L108;
        if ((r108 % 167) == 0) goto L108;
        int r109 = r100.mod(BigInteger.valueOf(1070560157)).intValue();
        if ((r109 % 173) == 0) goto L108;
        if ((r109 % 179) == 0) goto L108;
        if ((r109 % 181) == 0) goto L108;
        if ((r109 % 191) == 0) goto L108;
        int r110 = r100.mod(BigInteger.valueOf(1596463769)).intValue();
        if ((r110 % 193) == 0) goto L108;
        if ((r110 % MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY) == 0) goto L108;
        if ((r110 % 199) == 0) goto L108;
        if ((r110 % 211) == 0) goto L108;
        return false;
    }

    private static boolean implMRProbablePrimeToBase(BigInteger r100, BigInteger r101, BigInteger r102, int r103, BigInteger r104) {
        BigInteger r105 = r104.modPow(r102, r100);
        if (r105.equals(ONE) == false) goto L5;
        return true;
    L5:
        if (r105.equals(r101) == true) goto L23;
        int r106 = 1;
    L9:
        if (r106 >= r103) goto L17;
        r105 = r105.modPow(TWO, r100);
        if (r105.equals(r101) == true) goto L24;
        if (r105.equals(ONE) == true) goto L15;
        r106 = r106 + 1;
        goto L9
    L15:
        return false;
    L24:
        return true;
    L17:
        return false;
    L23:
        return true;
    }

    private static STOutput implSTRandomPrime(Digest r110, int r111, byte[] r112) {
        int r100 = r110.getDigestSize();
        AnonymousClass1 r101 = null;
        int r102 = 1;
        if (r111 >= 33) goto L14;
        byte[] r103 = new byte[r100];
        byte[] r104 = new byte[r100];
        int r105 = 0;
    L5:
        hash(r110, r112, r103, 0);
        inc(r112, 1);
        hash(r110, r112, r104, 0);
        inc(r112, 1);
        r105 = r105 + 1;
        long r113 = ((long) (((extract32(r103) ^ extract32(r104)) & ((-1) >>> (32 - r111))) | ((1 << (r111 - 1)) | 1))) & BodyPartID.bodyIdMax;
        if (isPrime32(r113) == true) goto L8;
        if (r105 <= (r111 * 4)) goto L5;
        throw new IllegalStateException("Too many iterations in Shawe-Taylor Random_Prime Routine");
    L8:
        return new STOutput(BigInteger.valueOf(r113), r112, r105, r101);
    L14:
        STOutput r106 = implSTRandomPrime(r110, (r111 + 3) / 2, r112);
        BigInteger r107 = r106.getPrime();
        byte[] r108 = r106.getPrimeSeed();
        int r109 = r106.getPrimeGenCounter();
        int r114 = r111 - 1;
        int r115 = (r114 / (r100 * 8)) + 1;
        BigInteger r116 = hashGen(r110, r108, r115);
        BigInteger r117 = ONE;
        BigInteger r118 = r116.mod(r117.shiftLeft(r114)).setBit(r114);
        BigInteger r119 = r107.shiftLeft(1);
        BigInteger r120 = r118.subtract(r117).divide(r119).add(r117).shiftLeft(1);
        BigInteger r121 = r120.multiply(r107).add(r117);
        int r122 = r109;
        int r123 = 0;
    L16:
        if (r121.bitLength() <= r111) goto L18;
        BigInteger r124 = ONE;
        r120 = r124.shiftLeft(r114).subtract(r124).divide(r119).add(r124).shiftLeft(r102);
        r121 = r120.multiply(r107).add(r124);
    L18:
        r122 = r122 + r102;
        if (implHasAnySmallFactors(r121) == true) goto L27;
        BigInteger r125 = hashGen(r110, r108, r115).mod(r121.subtract(THREE)).add(TWO);
        BigInteger r126 = r120.add(BigInteger.valueOf(r123));
        BigInteger r127 = r125.modPow(r126, r121);
        BigInteger r128 = ONE;
        if (r121.gcd(r127.subtract(r128)).equals(r128) == true) goto L23;
    L26:
        AnonymousClass1 r129 = null;
        r120 = r126;
        r123 = 0;
    L29:
        if (r122 >= ((r111 * 4) + r109)) goto L32;
        r123 = r123 + 2;
        r121 = r121.add(r119);
        r101 = r129;
        r102 = 1;
        goto L16
    L32:
        throw new IllegalStateException("Too many iterations in Shawe-Taylor Random_Prime Routine");
    L23:
        if (r127.modPow(r107, r121).equals(r128) == false) goto L26;
        return new STOutput(r121, r108, r122, null);
    L27:
        r129 = r101;
        inc(r108, r115);
        goto L29
    }

    private static void inc(byte[] r100, int r101) {
        int r102 = r100.length;
    L3:
        if (r101 <= 0) goto L7;
        r102 = r102 - 1;
        if (r102 < 0) goto L10;
        int r103 = r101 + (r100[r102] & 255);
        r100[r102] = (byte) r103;
        r101 = r103 >>> 8;
        goto L3
    L10:
        return;
    }

    public static boolean isMRProbablePrime(BigInteger r100, SecureRandom r101, int r110) {
        checkCandidate(r100, "candidate");
        if (r101 == null) goto L22;
        if (r110 < 1) goto L20;
        if (r100.bitLength() != 2) goto L10;
        return true;
    L10:
        if (r100.testBit(0) == true) goto L12;
        return false;
    L12:
        BigInteger r102 = r100.subtract(ONE);
        BigInteger r103 = r100.subtract(TWO);
        int r104 = r102.getLowestSetBit();
        BigInteger r105 = r102.shiftRight(r104);
        int r106 = 0;
    L13:
        if (r106 >= r110) goto L18;
        if (implMRProbablePrimeToBase(r100, r102, r105, r104, BigIntegers.createRandomInRange(TWO, r103, r101)) == false) goto L16;
        r106 = r106 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    L20:
        throw new IllegalArgumentException("'iterations' must be > 0");
    L22:
        throw new IllegalArgumentException("'random' cannot be null");
    }

    public static boolean isMRProbablePrimeToBase(BigInteger r100, BigInteger r101) {
        checkCandidate(r100, "candidate");
        checkCandidate(r101, "base");
        BigInteger r102 = ONE;
        if (r101.compareTo(r100.subtract(r102)) >= 0) goto L11;
        if (r100.bitLength() != 2) goto L8;
        return true;
    L8:
        BigInteger r103 = r100.subtract(r102);
        int r104 = r103.getLowestSetBit();
        return implMRProbablePrimeToBase(r100, r103, r103.shiftRight(r104), r104, r101);
    L11:
        throw new IllegalArgumentException("'base' must be < ('candidate' - 1)");
    }

    private static boolean isPrime32(long r110) {
        if ((r110 >>> 32) != 0) goto L36;
        if (r110 > 5) goto L14;
        if (r110 != 2) goto L9;
    L11:
        return true;
    L9:
        if (r110 == 3) goto L11;
        if (r110 == 5) goto L11;
        return false;
    L14:
        if ((1 & r110) != 0) goto L16;
    L34:
        return false;
    L16:
        if ((r110 % 3) == 0) goto L34;
        if ((r110 % 5) == 0) goto L34;
        long[] r100 = {1, 7, 11, 13, 17, 19, 23, 29};
        long r101 = 0;
        int r102 = 1;
    L22:
        if (r102 < 8) goto L24;
        r101 = r101 + 30;
        if ((r101 * r101) >= r110) goto L32;
        r102 = 0;
        goto L22
    L32:
        return true;
    L24:
        if ((r110 % (r100[r102] + r101)) == 0) goto L26;
        r102 = r102 + 1;
        goto L22
    L26:
        if (r110 >= 30) goto L45;
        return true;
    L45:
        return false;
    L36:
        throw new IllegalArgumentException("Size limit exceeded");
    }
}
