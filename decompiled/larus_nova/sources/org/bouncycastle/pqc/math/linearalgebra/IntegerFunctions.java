package org.bouncycastle.pqc.math.linearalgebra;

import androidx.camera.video.AudioStats;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larksuite.component.card.plugin.FetchCardPlugin;
import com.ss.bduploader.BDAbstractUpload;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.bduploader.UploadKeys;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.VideoRef;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public final class IntegerFunctions {
    private static final BigInteger FOUR = null;
    private static final BigInteger ONE = null;
    private static final int[] SMALL_PRIMES = null;
    private static final long SMALL_PRIME_PRODUCT = 152125131763605L;
    private static final BigInteger TWO = null;
    private static final BigInteger ZERO = null;
    private static final int[] jacobiTable = null;

    /* JADX INFO: renamed from: sr, reason: collision with root package name */
    private static SecureRandom f525614sr;

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
        FOUR = BigInteger.valueOf(4);
        SMALL_PRIMES = new int[]{3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};
        f525614sr = null;
        jacobiTable = new int[]{0, 1, 0, -1, 0, -1, 0, 1};
    }

    private IntegerFunctions() {
    }

    public static BigInteger binomial(int r100, int r101) {
        BigInteger r102 = ONE;
        if (r100 != 0) goto L9;
        if (r101 != 0) goto L7;
        return r102;
    L7:
        return ZERO;
    L9:
        if (r101 <= (r100 >>> 1)) goto L11;
        r101 = r100 - r101;
    L11:
        int r103 = 1;
    L12:
        if (r103 > r101) goto L14;
        r102 = r102.multiply(BigInteger.valueOf(r100 - (r103 - 1))).divide(BigInteger.valueOf(r103));
        r103 = r103 + 1;
        goto L12
    L14:
        return r102;
    }

    public static int bitCount(int r100) {
        int r101 = 0;
    L3:
        if (r100 == 0) goto L5;
        r101 = r101 + (r100 & 1);
        r100 = r100 >>> 1;
        goto L3
    L5:
        return r101;
    }

    public static int ceilLog(int r100) {
        int r101 = 0;
        int r102 = 1;
    L3:
        if (r102 >= r100) goto L5;
        r102 = r102 << 1;
        r101 = r101 + 1;
        goto L3
    L5:
        return r101;
    }

    public static int ceilLog(BigInteger r100) {
        BigInteger r101 = ONE;
        int r102 = 0;
    L4:
        if (r101.compareTo(r100) >= 0) goto L6;
        r102 = r102 + 1;
        r101 = r101.shiftLeft(1);
        goto L4
    L6:
        return r102;
    }

    public static int ceilLog256(int r100) {
        if (r100 != 0) goto L5;
        return 1;
    L5:
        if (r100 >= 0) goto L7;
        r100 = -r100;
    L7:
        int r101 = 0;
    L8:
        if (r100 <= 0) goto L10;
        r101 = r101 + 1;
        r100 = r100 >>> 8;
        goto L8
    L10:
        return r101;
    }

    public static int ceilLog256(long r100) {
        if (r100 != 0) goto L6;
        return 1;
    L6:
        if (r100 >= 0) goto L8;
        r100 = -r100;
    L8:
        int r101 = 0;
    L10:
        if (r100 <= 0) goto L12;
        r101 = r101 + 1;
        r100 = r100 >>> 8;
        goto L10
    L12:
        return r101;
    }

    public static BigInteger divideAndRound(BigInteger r100, BigInteger r101) {
        if (r100.signum() >= 0) goto L7;
        return divideAndRound(r100.negate(), r101).negate();
    L7:
        if (r101.signum() >= 0) goto L11;
        return divideAndRound(r100, r101.negate()).negate();
    L11:
        return r100.shiftLeft(1).add(r101).divide(r101.shiftLeft(1));
    }

    public static BigInteger[] divideAndRound(BigInteger[] r100, BigInteger r101) {
        BigInteger[] r102 = new BigInteger[r100.length];
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        r102[r103] = divideAndRound(r100[r103], r101);
        r103 = r103 + 1;
        goto L4
    L6:
        return r102;
    }

    public static int[] extGCD(int r100, int r101) {
        BigInteger[] r102 = extgcd(BigInteger.valueOf(r100), BigInteger.valueOf(r101));
        return new int[]{r102[0].intValue(), r102[1].intValue(), r102[2].intValue()};
    }

    public static BigInteger[] extgcd(BigInteger r100, BigInteger r110) {
        BigInteger r101 = ONE;
        BigInteger r102 = ZERO;
        if (r110.signum() == 0) goto L10;
        BigInteger r103 = r100;
        BigInteger r104 = r110;
    L6:
        if (r104.signum() == 0) goto L8;
        BigInteger[] r105 = r103.divideAndRemainder(r104);
        BigInteger r106 = r105[0];
        BigInteger r107 = r105[1];
        BigInteger r108 = r102;
        r102 = r101.subtract(r106.multiply(r102));
        r101 = r108;
        r103 = r104;
        r104 = r107;
        goto L6
    L8:
        r102 = r103.subtract(r100.multiply(r101)).divide(r110);
        r100 = r103;
    L10:
        return new BigInteger[]{r100, r101, r102};
    }

    public static float floatPow(float r100, int r101) {
        float r102 = 1.0f;
    L3:
        if (r101 <= 0) goto L5;
        r102 = r102 * r100;
        r101 = r101 - 1;
        goto L3
    L5:
        return r102;
    }

    public static int floorLog(int r100) {
        if (r100 > 0) goto L5;
        return -1;
    L5:
        int r101 = r100 >>> 1;
        int r102 = 0;
    L6:
        if (r101 <= 0) goto L8;
        r102 = r102 + 1;
        r101 = r101 >>> 1;
        goto L6
    L8:
        return r102;
    }

    public static int floorLog(BigInteger r100) {
        BigInteger r101 = ONE;
        int r102 = -1;
    L4:
        if (r101.compareTo(r100) > 0) goto L6;
        r102 = r102 + 1;
        r101 = r101.shiftLeft(1);
        goto L4
    L6:
        return r102;
    }

    public static int gcd(int r100, int r101) {
        return BigInteger.valueOf(r100).gcd(BigInteger.valueOf(r101)).intValue();
    }

    public static float intRoot(int r100, int r101) {
        float r102 = r100 / r101;
        float r103 = 0.0f;
    L4:
        if (Math.abs(r103 - r102) <= 1.0E-4d) goto L9;
    L5:
        float r104 = floatPow(r102, r101);
        if (Float.isInfinite(r104) == false) goto L8;
        r102 = (r102 + r103) / 2.0f;
        goto L5
    L8:
        r103 = r102;
        r102 = r102 - ((r104 - r100) / (r101 * floatPow(r102, r101 - 1)));
        goto L4
    L9:
        return r102;
    }

    public static byte[] integerToOctets(BigInteger r100) {
        byte[] r101 = r100.abs().toByteArray();
        if ((r100.bitLength() & 7) == 0) goto L5;
        return r101;
    L5:
        int r102 = r100.bitLength() >> 3;
        byte[] r103 = new byte[r102];
        System.arraycopy(r101, 1, r103, 0, r102);
        return r103;
    }

    public static boolean isIncreasing(int[] r100) {
        int r101 = 1;
    L4:
        if (r101 >= r100.length) goto L10;
        if (r100[r101 - 1] >= r100[r101]) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return false;
    L10:
        return true;
    }

    public static int isPower(int r100, int r101) {
        if (r100 > 0) goto L5;
        return -1;
    L5:
        int r102 = 0;
    L7:
        if (r100 <= 1) goto L12;
        if ((r100 % r101) != 0) goto L10;
        r100 = r100 / r101;
        r102 = r102 + 1;
        goto L7
    L10:
        return -1;
    L12:
        return r102;
    }

    public static boolean isPrime(int r100) {
        if (r100 >= 2) goto L6;
        return false;
    L6:
        if (r100 != 2) goto L9;
        return true;
    L9:
        if ((r100 & 1) != 0) goto L12;
        return false;
    L12:
        if (r100 >= 42) goto L21;
        int r101 = 0;
    L14:
        int[] r102 = SMALL_PRIMES;
        if (r101 >= r102.length) goto L21;
        if (r100 == r102[r101]) goto L18;
        r101 = r101 + 1;
        goto L14
    L18:
        return true;
    L21:
        if ((r100 % 3) != 0) goto L23;
    L47:
        return false;
    L23:
        if ((r100 % 5) == 0) goto L47;
        if ((r100 % 7) == 0) goto L47;
        if ((r100 % 11) == 0) goto L47;
        if ((r100 % 13) == 0) goto L47;
        if ((r100 % 17) == 0) goto L47;
        if ((r100 % 19) == 0) goto L47;
        if ((r100 % 23) == 0) goto L47;
        if ((r100 % 29) == 0) goto L47;
        if ((r100 % 31) == 0) goto L47;
        if ((r100 % 37) == 0) goto L47;
        if ((r100 % 41) == 0) goto L47;
        return BigInteger.valueOf(r100).isProbablePrime(20);
    }

    public static int jacobi(BigInteger r100, BigInteger r110) {
        BigInteger r101 = ZERO;
        if (r110.equals(r101) == false) goto L7;
        return r100.abs().equals(ONE) ? 1 : 0;
    L7:
        if (r100.testBit(0) == false) goto L9;
    L11:
        long r102 = 1;
        if (r110.signum() != (-1)) goto L17;
        r110 = r110.negate();
        if (r100.signum() != (-1)) goto L17;
        r102 = -1;
    L17:
        if (r110.testBit(0) == true) goto L20;
        r101 = r101.add(ONE);
        r110 = r110.divide(TWO);
        goto L17
    L20:
        if (r101.testBit(0) == false) goto L23;
        r102 = r102 * ((long) jacobiTable[r100.intValue() & 7]);
    L23:
        if (r100.signum() >= 0) goto L29;
        if (r110.testBit(1) == false) goto L27;
        r102 = -r102;
    L27:
        r100 = r100.negate();
    L29:
        if (r100.signum() == 0) goto L47;
        BigInteger r103 = ZERO;
    L32:
        if (r100.testBit(0) == true) goto L35;
        r103 = r103.add(ONE);
        r100 = r100.divide(TWO);
        goto L32
    L35:
        if (r103.testBit(0) == false) goto L38;
        r102 = r102 * ((long) jacobiTable[r110.intValue() & 7]);
    L38:
        if (r100.compareTo(r110) < 0) goto L40;
        BigInteger r104 = r110;
        r110 = r100;
        r100 = r104;
    L45:
        BigInteger r111 = r110.subtract(r100);
        r110 = r100;
        r100 = r111;
        goto L29
    L40:
        if (r110.testBit(1) == false) goto L45;
        if (r100.testBit(1) == false) goto L45;
        r102 = -r102;
        goto L45
    L47:
        if (r110.equals(ONE) == true) goto L49;
        return 0;
    L49:
        return (int) r102;
    L9:
        if (r110.testBit(0) == true) goto L11;
        return 0;
    }

    public static BigInteger leastCommonMultiple(BigInteger[] r100) {
        int r101 = r100.length;
        BigInteger r102 = r100[0];
        int r103 = 1;
    L3:
        if (r103 >= r101) goto L5;
        BigInteger r104 = r102.gcd(r100[r103]);
        r102 = r102.multiply(r100[r103]).divide(r104);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static int leastDiv(int r100) {
        if (r100 >= 0) goto L4;
        r100 = -r100;
    L4:
        if (r100 != 0) goto L8;
        return 1;
    L8:
        if ((r100 & 1) != 0) goto L11;
        return 2;
    L11:
        int r101 = 3;
    L13:
        if (r101 > (r100 / r101)) goto L18;
        if ((r100 % r101) == 0) goto L16;
        r101 = r101 + 2;
        goto L13
    L16:
        return r101;
    L18:
        return r100;
    }

    public static double log(double r100) {
        double r101 = 1.0d;
        if (r100 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L8:
        int r102 = 0;
        double r103 = r100;
    L10:
        if (r103 <= 2.0d) goto L13;
        r103 = r103 / 2.0d;
        r102 = r102 + 1;
        r101 = r101 * 2.0d;
        goto L10
    L13:
        return r102 + logBKM(r100 / r101);
    L5:
        if (r100 >= 1.0d) goto L8;
        return -log(1.0d / r100);
    }

    public static double log(long r100) {
        int r101 = floorLog(BigInteger.valueOf(r100));
        return ((double) r101) + logBKM(r100 / ((double) (1 << r101)));
    }

    private static double logBKM(double r110) {
        double[] r100 = {1.0d, 0.5849625007211562d, 0.32192809488736235d, 0.16992500144231237d, 0.0874628412503394d, 0.044394119358453436d, 0.02236781302845451d, 0.01122725542325412d, 0.005624549193878107d, 0.0028150156070540383d, 0.0014081943928083889d, 7.042690112466433E-4d, 3.5217748030102726E-4d, 1.7609948644250602E-4d, 8.80524301221769E-5d, 4.4026886827316716E-5d, 2.2013611360340496E-5d, 1.1006847667481442E-5d, 5.503434330648604E-6d, 2.751719789561283E-6d, 1.375860550841138E-6d, 6.879304394358497E-7d, 3.4396526072176454E-7d, 1.7198264061184464E-7d, 8.599132286866321E-8d, 4.299566207501687E-8d, 2.1497831197679756E-8d, 1.0748915638882709E-8d, 5.374457829452062E-9d, 2.687228917228708E-9d, 1.3436144592400231E-9d, 6.718072297764289E-10d, 3.3590361492731876E-10d, 1.6795180747343547E-10d, 8.397590373916176E-11d, 4.1987951870191886E-11d, 2.0993975935248694E-11d, 1.0496987967662534E-11d, 5.2484939838408146E-12d, 2.624246991922794E-12d, 1.3121234959619935E-12d, 6.56061747981146E-13d, 3.2803087399061026E-13d, 1.6401543699531447E-13d, 8.200771849765956E-14d, 4.1003859248830365E-14d, 2.0501929624415328E-14d, 1.02509648122077E-14d, 5.1254824061038595E-15d, 2.5627412030519317E-15d, 1.2813706015259665E-15d, 6.406853007629834E-16d, 3.203426503814917E-16d, 1.6017132519074588E-16d, 8.008566259537294E-17d, 4.004283129768647E-17d, 2.0021415648843235E-17d, 1.0010707824421618E-17d, 5.005353912210809E-18d, 2.5026769561054044E-18d, 1.2513384780527022E-18d, 6.256692390263511E-19d, 3.1283461951317555E-19d, 1.5641730975658778E-19d, 7.820865487829389E-20d, 3.9104327439146944E-20d, 1.9552163719573472E-20d, 9.776081859786736E-21d, 4.888040929893368E-21d, 2.444020464946684E-21d, 1.222010232473342E-21d, 6.11005116236671E-22d, 3.055025581183355E-22d, 1.5275127905916775E-22d, 7.637563952958387E-23d, 3.818781976479194E-23d, 1.909390988239597E-23d, 9.546954941197984E-24d, 4.773477470598992E-24d, 2.386738735299496E-24d, 1.193369367649748E-24d, 5.96684683824874E-25d, 2.98342341912437E-25d, 1.491711709562185E-25d, 7.458558547810925E-26d, 3.7292792739054626E-26d, 1.8646396369527313E-26d, 9.323198184763657E-27d, 4.661599092381828E-27d, 2.330799546190914E-27d, 1.165399773095457E-27d, 5.826998865477285E-28d, 2.9134994327386427E-28d, 1.4567497163693213E-28d, 7.283748581846607E-29d, 3.6418742909233034E-29d, 1.8209371454616517E-29d, 9.104685727308258E-30d, 4.552342863654129E-30d, 2.2761714318270646E-30d};
        double r101 = 1.0d;
        double r102 = 0.0d;
        int r103 = 0;
        double r104 = 1.0d;
    L4:
        if (r103 >= 53) goto L9;
        double r105 = (r101 * r104) + r101;
        if (r105 > r110) goto L8;
        r102 = r102 + r100[r103];
        r101 = r105;
    L8:
        r104 = r104 * 0.5d;
        r103 = r103 + 1;
        goto L4
    L9:
        return r102;
    }

    public static int maxPower(int r100) {
        int r101 = 0;
        if (r100 == 0) goto L8;
        int r102 = 1;
    L6:
        if ((r100 & r102) != 0) goto L8;
        r101 = r101 + 1;
        r102 = r102 << 1;
    L8:
        return r101;
    }

    public static long mod(long r100, long r101) {
        long r102 = r100 % r101;
        if (r102 < 0) goto L5;
        return r102;
    L5:
        return r102 + r101;
    }

    public static int modInverse(int r100, int r101) {
        return BigInteger.valueOf(r100).modInverse(BigInteger.valueOf(r101)).intValue();
    }

    public static long modInverse(long r100, long r101) {
        return BigInteger.valueOf(r100).modInverse(BigInteger.valueOf(r101)).longValue();
    }

    public static int modPow(int r100, int r101, int r102) {
        if (r102 > 0) goto L4;
        return 0;
    L4:
        if ((r102 * r102) > Integer.MAX_VALUE) goto L19;
        if (r101 < 0) goto L20;
        int r103 = ((r100 % r102) + r102) % r102;
        int r104 = 1;
    L8:
        if (r101 <= 0) goto L13;
        if ((r101 & 1) != 1) goto L12;
        r104 = (r104 * r103) % r102;
    L12:
        r103 = (r103 * r103) % r102;
        r101 = r101 >>> 1;
        goto L8
    L13:
        return r104;
    L20:
        return 0;
    L19:
        return 0;
    }

    public static BigInteger nextPrime(long r110) {
        if (r110 > 1) goto L7;
        return BigInteger.valueOf(2);
    L7:
        if (r110 == 2) goto L9;
        long r100 = (r110 + 1) + (r110 & 1);
        boolean r101 = false;
        long r111 = 0;
    L12:
        if (r100 > (r110 << 1)) goto L27;
        if (r101 == true) goto L27;
        long r112 = 3;
    L16:
        if (r112 > (r100 >> 1)) goto L22;
        if (r101 == true) goto L22;
        if ((r100 % r112) != 0) goto L21;
        r101 = true;
    L21:
        r112 = r112 + 2;
    L22:
        if (r101 == true) goto L25;
        r111 = r100;
    L25:
        r101 = !r101;
        r100 = r100 + 2;
    L27:
        return BigInteger.valueOf(r111);
    L9:
        return BigInteger.valueOf(3);
    }

    public static BigInteger nextProbablePrime(BigInteger r100) {
        return nextProbablePrime(r100, 20);
    }

    public static BigInteger nextProbablePrime(BigInteger r100, int r101) {
        if (r100.signum() < 0) goto L46;
        if (r100.signum() == 0) goto L46;
        BigInteger r102 = ONE;
        if (r100.equals(r102) == true) goto L46;
        BigInteger r103 = r100.add(r102);
        if (r103.testBit(0) == true) goto L13;
        r103 = r103.add(r102);
    L13:
        if (r103.bitLength() <= 6) goto L40;
        long r104 = r103.remainder(BigInteger.valueOf(SMALL_PRIME_PRODUCT)).longValue();
        if ((r104 % 3) == 0) goto L47;
        if ((r104 % 5) == 0) goto L47;
        if ((r104 % 7) == 0) goto L47;
        if ((r104 % 11) == 0) goto L47;
        if ((r104 % 13) == 0) goto L47;
        if ((r104 % 17) == 0) goto L47;
        if ((r104 % 19) == 0) goto L47;
        if ((r104 % 23) == 0) goto L47;
        if ((r104 % 29) == 0) goto L47;
        if ((r104 % 31) == 0) goto L47;
        if ((r104 % 37) == 0) goto L47;
        if ((r104 % 41) != 0) goto L40;
    L47:
        r103 = r103.add(TWO);
    L40:
        if (r103.bitLength() < 4) goto L41;
        if (r103.isProbablePrime(r101) == false) goto L47;
        return r103;
    L41:
        return r103;
    L46:
        return TWO;
    }

    public static int nextSmallerPrime(int r100) {
        if (r100 > 2) goto L7;
        return 1;
    L7:
        if (r100 != 3) goto L10;
        return 2;
    L10:
        if ((r100 & 1) != 0) goto L12;
        int r101 = r100 - 1;
    L13:
        if (r101 <= 3) goto L17;
        if (isPrime(r101) == true) goto L17;
    L12:
        r101 = r101 - 2;
    L17:
        return r101;
    L18:
        r101 = r100 - 2;
        goto L13
    }

    public static BigInteger octetsToInteger(byte[] r100) {
        return octetsToInteger(r100, 0, r100.length);
    }

    public static BigInteger octetsToInteger(byte[] r100, int r101, int r102) {
        byte[] r103 = new byte[r102 + 1];
        r103[0] = 0;
        System.arraycopy(r100, r101, r103, 1, r102);
        return new BigInteger(r103);
    }

    public static int order(int r100, int r101) {
        int r102 = r100 % r101;
        if (r102 == 0) goto L12;
        int r103 = 1;
    L5:
        if (r102 == 1) goto L10;
        r102 = (r102 * r100) % r101;
        if (r102 >= 0) goto L9;
        r102 = r102 + r101;
    L9:
        r103 = r103 + 1;
        goto L5
    L10:
        return r103;
    L12:
        throw new IllegalArgumentException(r100 + " is not an element of Z/(" + r101 + "Z)^*; it is not meaningful to compute its order.");
    }

    public static boolean passesSmallPrimeTest(BigInteger r100) {
        int[] r101 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 199, 211, 223, VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL, 229, 233, VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X, 241, 251, 257, MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 307, 311, 313, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT, 331, 337, 347, 349, 353, 359, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME, 373, MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS, MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, 401, 409, 419, 421, 431, BDAbstractUpload.KeyIsRetryStatesDir, UploadKeys.KeyIsEnd2EndEncryptionOption, UploadKeys.KeyIsGetVideoMeta, BDVideoUploaderBase.KeyIsDynamicSliceNormalSize, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_DNS_TIME, 461, MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_WIDTH, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_ERR_NO_VIDEO, 479, TTVideoEngineInterface.PLAYER_OPTION_SET_NETSPEED_LEVEL, TTVideoEngineInterface.PLAYER_OPTION_PREPARE_CACHE_MS, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_BARRAGE_MASK, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, FetchCardPlugin.SERVER_ERROR, 601, 607, 613, 617, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_TYPE, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM, 659, 661, 673, 677, 683, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_REQUEST_LOG, 701, TTVideoEngineInterface.PLAYER_OPTION_SET_PRECISE_PAUSE_PTS, 719, 727, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, TTVideoEngineInterface.NETWORK_PREDICTOR_DEFAULT_INITIAL_SPEED, TTVideoEngineInterface.PLAYER_OPTION_FETCH_WITH_ABILITY_OPTION, 751, MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAYER_REQ_OFFSET, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_INACCURATE_START, 769, 773, 787, 797, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLUSH_SEEK, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_VOICE_IN_PREPARE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPT_SUB_SEARCH, MediaPlayer.MEDIA_PLAYER_OPTION_RTM_SIGNAL_ANSWER_UPDATED_TIME, 853, TTVideoEngineInterface.PLAYER_OPTION_NET_SPEED_UPDATE_INTERVAL, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_SUBTITLE_LAZY_LOADING, TTVideoEngineInterface.PLAYER_OPTION_HW_DYNAMIC_FRAME_DROPPING_CHECK_PERIOD, 877, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE_WITH_OES, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_PLUGIN_PACKAGE_NAME, 907, MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_PRIMARIES, 919, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_ENABLE_BANDWIDTH_STRATEGY, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_REUSED, 953, TTVideoEngineInterface.PLAYER_OPTION_OPTIMIZE_ENGINE_THREAD_POOL_IMPL, TTVideoEngineInterface.PLAYER_OPTION_GSKEY_CPU_REFRESH_FIX, TTVideoEngineInterface.PLAYER_OPTION_CODEC_AND_SURFACE_REUSE, 983, 991, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_UPGRADE_TIME_THRESHOLD, 1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, 1201, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPTIMIZE_PRERENDER, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPTIMIZE_ASYNC_DOWNLOAD, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPTIMIZE_DASH_SEEK, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, MediaPlayer.MEDIA_PLAYER_OPTION_GS_AUDIO_ADAPTER_MAX_USE_COUNT, 1319, MediaPlayer.MEDIA_PLAYER_OPTION_FLUSH_WHEN_SETSURFACE, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_DEATH_CHECK_INTERVAL_MS, MediaPlayer.MEDIA_PLAYER_OPTION_GS_AUDIOTRACK_POOL_SAMPLES_CHECK, 1367, 1373, 1381, 1399, SpeechEngineDefines.MESSAGE_TYPE_TTS_AUDIO_DATA_END, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499};
        int r102 = 0;
    L3:
        if (r102 >= 239) goto L8;
        if (r100.mod(BigInteger.valueOf(r101[r102])).equals(ZERO) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static int pow(int r100, int r101) {
        int r102 = 1;
    L3:
        if (r101 <= 0) goto L8;
        if ((r101 & 1) != 1) goto L7;
        r102 = r102 * r100;
    L7:
        r100 = r100 * r100;
        r101 = r101 >>> 1;
        goto L3
    L8:
        return r102;
    }

    public static long pow(long r100, int r101) {
        long r102 = 1;
    L3:
        if (r101 <= 0) goto L8;
        if ((r101 & 1) != 1) goto L7;
        r102 = r102 * r100;
    L7:
        r100 = r100 * r100;
        r101 = r101 >>> 1;
        goto L3
    L8:
        return r102;
    }

    public static BigInteger randomize(BigInteger r100) {
        if (f525614sr != null) goto L6;
        f525614sr = CryptoServicesRegistrar.getSecureRandom();
    L6:
        return randomize(r100, f525614sr);
    }

    public static BigInteger randomize(BigInteger r100, SecureRandom r101) {
        int r102 = r100.bitLength();
        BigInteger r103 = BigInteger.valueOf(0);
        if (r101 != null) goto L8;
        r101 = f525614sr;
        if (r101 != null) goto L8;
        r101 = CryptoServicesRegistrar.getSecureRandom();
    L8:
        int r104 = 0;
    L10:
        if (r104 >= 20) goto L16;
        r103 = BigIntegers.createRandomBigInteger(r102, r101);
        if (r103.compareTo(r100) < 0) goto L13;
        r104 = r104 + 1;
        goto L10
    L13:
        return r103;
    L16:
        return r103.mod(r100);
    }

    public static BigInteger reduceInto(BigInteger r100, BigInteger r101, BigInteger r102) {
        return r100.subtract(r101).mod(r102.subtract(r101)).add(r101);
    }

    public static BigInteger ressol(BigInteger r210, BigInteger r211) throws IllegalArgumentException {
        BigInteger r100 = ZERO;
        BigInteger r101 = r210;
        if (r101.compareTo(r100) >= 0) goto L6;
        r101 = r210.add(r211);
    L6:
        if (r101.equals(r100) == false) goto L9;
        return r100;
    L9:
        if (r211.equals(TWO) == false) goto L11;
        return r101;
    L11:
        int r102 = 1;
        if (r211.testBit(0) == true) goto L14;
    L21:
        BigInteger r103 = r211.subtract(ONE);
        long r104 = 0;
    L23:
        if (r103.testBit(0) == true) goto L25;
        r104 = r104 + 1;
        r103 = r103.shiftRight(1);
        goto L23
    L25:
        BigInteger r105 = ONE;
        BigInteger r106 = r103.subtract(r105).shiftRight(1);
        BigInteger r110 = r101.modPow(r106, r211);
        BigInteger r111 = r110.multiply(r110).remainder(r211).multiply(r101).remainder(r211);
        BigInteger r112 = r110.multiply(r101).remainder(r211);
        if (r111.equals(r105) == false) goto L28;
        return r112;
    L28:
        BigInteger r107 = TWO;
    L30:
        if (jacobi(r107, r211) != 1) goto L32;
        r107 = r107.add(ONE);
        goto L30
    L32:
        BigInteger r108 = r107.modPow(r106.multiply(TWO).add(ONE), r211);
    L34:
        if (r111.compareTo(ONE) != r102) goto L48;
        long r113 = 0;
        BigInteger r109 = r111;
    L36:
        BigInteger r114 = ONE;
        if (r109.equals(r114) == true) goto L39;
        r109 = r109.multiply(r109).mod(r211);
        r113 = r113 + 1;
        goto L36
    L39:
        long r115 = r104 - r113;
        if (r115 == 0) goto L47;
        long r116 = 0;
    L43:
        if (r116 >= (r115 - 1)) goto L45;
        r114 = r114.shiftLeft(1);
        r116 = r116 + 1;
        goto L43
    L45:
        BigInteger r117 = r108.modPow(r114, r211);
        r112 = r112.multiply(r117).remainder(r211);
        r108 = r117.multiply(r117).remainder(r211);
        r111 = r111.multiply(r108).mod(r211);
        r104 = r113;
        r102 = 1;
        goto L34
    L47:
        throw new IllegalArgumentException("No quadratic residue: " + r101 + ", " + r211);
    L48:
        return r112;
    L14:
        if (r211.testBit(1) == false) goto L21;
        if (jacobi(r101, r211) != 1) goto L20;
        return r101.modPow(r211.add(ONE).shiftRight(2), r211);
    L20:
        throw new IllegalArgumentException("No quadratic residue: " + r101 + ", " + r211);
    }

    public static BigInteger squareRoot(BigInteger r100) {
        BigInteger r101 = ZERO;
        if (r100.compareTo(r101) < 0) goto L18;
        int r102 = r100.bitLength();
        if ((r102 & 1) == 0) goto L7;
        r101 = r101.add(ONE);
        int r103 = r102 - 1;
    L8:
        if (r103 <= 0) goto L16;
        BigInteger r104 = FOUR;
        BigInteger r105 = r101.multiply(r104);
        int r106 = r103 - 1;
        if (r100.testBit(r106) == false) goto L12;
        int r107 = 2;
    L13:
        r103 = r106 - 1;
        r101 = r105.add(BigInteger.valueOf(r107 + (r100.testBit(r103) ? 1 : 0)));
        BigInteger r108 = r101.multiply(r104);
        BigInteger r109 = ONE;
        BigInteger r110 = r108.add(r109);
        r101 = r101.multiply(TWO);
        if (r101.compareTo(r110) == (-1)) goto L8;
        r101 = r101.add(r109);
        r101 = r101.subtract(r110);
        goto L8
    L12:
        r107 = 0;
        goto L13
    L16:
        return r101;
    L7:
        r103 = r102;
        goto L8
    L18:
        throw new ArithmeticException("cannot extract root of negative number" + r100 + ".");
    }
}
