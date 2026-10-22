package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.DSAParameterGenerationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAValidationParameters;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class DSAParametersGenerator {
    private static final BigInteger ONE = null;
    private static final BigInteger TWO = null;
    private static final BigInteger ZERO = null;
    private int L;
    private int N;
    private int certainty;
    private Digest digest;
    private int iterations;
    private SecureRandom random;
    private int usageIndex;
    private boolean use186_3;

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
    }

    public DSAParametersGenerator() {
        this(DigestFactory.createSHA1());
    }

    public DSAParametersGenerator(Digest r100) {
        this.digest = r100;
    }

    private static BigInteger calculateGenerator_FIPS186_2(BigInteger r100, BigInteger r101, SecureRandom r102) {
        BigInteger r103 = r100.subtract(ONE).divide(r101);
        BigInteger r104 = r100.subtract(TWO);
    L3:
        BigInteger r105 = BigIntegers.createRandomInRange(TWO, r104, r102).modPow(r103, r100);
        if (r105.bitLength() <= 1) goto L3;
        return r105;
    }

    private static BigInteger calculateGenerator_FIPS186_3_Unverifiable(BigInteger r100, BigInteger r101, SecureRandom r102) {
        return calculateGenerator_FIPS186_2(r100, r101, r102);
    }

    private static BigInteger calculateGenerator_FIPS186_3_Verifiable(Digest r100, BigInteger r101, BigInteger r102, byte[] r103, int r110) {
        BigInteger r104 = r101.subtract(ONE).divide(r102);
        byte[] r105 = Hex.decodeStrict("6767656E");
        int r106 = ((r103.length + r105.length) + 1) + 2;
        byte[] r107 = new byte[r106];
        System.arraycopy(r103, 0, r107, 0, r103.length);
        System.arraycopy(r105, 0, r107, r103.length, r105.length);
        r107[r106 - 3] = (byte) r110;
        byte[] r108 = new byte[r100.getDigestSize()];
        int r111 = 1;
    L4:
        if (r111 >= 65536) goto L9;
        inc(r107);
        hash(r100, r107, r108, 0);
        BigInteger r109 = new BigInteger(1, r108).modPow(r104, r101);
        if (r109.compareTo(TWO) >= 0) goto L7;
        r111 = r111 + 1;
        goto L4
    L7:
        return r109;
    L9:
        return null;
    }

    private DSAParameters generateParameters_FIPS186_2() {
        int r100 = 20;
        byte[] r101 = new byte[20];
        byte[] r102 = new byte[20];
        byte[] r103 = new byte[20];
        byte[] r104 = new byte[20];
        int r105 = this.L;
        int r106 = (r105 - 1) / 160;
        int r107 = r105 / 8;
        byte[] r108 = new byte[r107];
        if ((this.digest instanceof SHA1Digest) == false) goto L25;
    L4:
        this.random.nextBytes(r101);
        hash(this.digest, r101, r102, 0);
        System.arraycopy(r101, 0, r103, 0, r100);
        inc(r103);
        hash(this.digest, r103, r103, 0);
        int r109 = 0;
    L5:
        if (r109 == r100) goto L7;
        r104[r109] = (byte) (r102[r109] ^ r103[r109]);
        r109 = r109 + 1;
        goto L5
    L7:
        r104[0] = (byte) (r104[0] | ByteCompanionObject.MIN_VALUE);
        r104[19] = (byte) (r104[19] | 1);
        BigInteger r110 = new BigInteger(1, r104);
        if (isProbablePrime(r110) == false) goto L4;
        byte[] r111 = Arrays.clone(r101);
        inc(r111);
        int r112 = 0;
    L12:
        if (r112 >= 4096) goto L4;
        int r113 = 1;
    L14:
        if (r113 > r106) goto L16;
        inc(r111);
        hash(this.digest, r111, r108, r107 - (r113 * 20));
        r113 = r113 + 1;
        goto L14
    L16:
        int r114 = r107 - (r106 * 20);
        inc(r111);
        hash(this.digest, r111, r102, 0);
        System.arraycopy(r102, 20 - r114, r108, 0, r114);
        r108[0] = (byte) (r108[0] | ByteCompanionObject.MIN_VALUE);
        BigInteger r115 = new BigInteger(1, r108);
        BigInteger r116 = r115.subtract(r115.mod(r110.shiftLeft(1)).subtract(ONE));
        if (r116.bitLength() != this.L) goto L23;
        if (isProbablePrime(r116) == false) goto L23;
        return new DSAParameters(r116, r110, calculateGenerator_FIPS186_2(r116, r110, this.random), new DSAValidationParameters(r101, r112));
    L23:
        r112 = r112 + 1;
        r100 = 20;
        goto L12
    L25:
        throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
    }

    private DSAParameters generateParameters_FIPS186_3() {
        Digest r100 = this.digest;
        int r101 = r100.getDigestSize() * 8;
        byte[] r102 = new byte[this.N / 8];
        int r103 = this.L;
        int r104 = (r103 - 1) / r101;
        int r105 = (r103 - 1) % r101;
        int r106 = r103 / 8;
        byte[] r107 = new byte[r106];
        int r108 = r100.getDigestSize();
        byte[] r109 = new byte[r108];
    L3:
        this.random.nextBytes(r102);
        int r110 = 0;
        hash(r100, r102, r109, 0);
        BigInteger r111 = new BigInteger(1, r109).mod(ONE.shiftLeft(this.N - 1)).setBit(0).setBit(this.N - 1);
        if (isProbablePrime(r111) == false) goto L3;
        byte[] r112 = Arrays.clone(r102);
        int r113 = this.L * 4;
        int r114 = 0;
    L7:
        if (r114 >= r113) goto L3;
        int r115 = 1;
    L9:
        if (r115 > r104) goto L11;
        inc(r112);
        hash(r100, r112, r107, r106 - (r115 * r108));
        r115 = r115 + 1;
        goto L9
    L11:
        int r116 = r106 - (r104 * r108);
        inc(r112);
        hash(r100, r112, r109, r110);
        System.arraycopy(r109, r108 - r116, r107, r110, r116);
        r107[r110] = (byte) (r107[r110] | ByteCompanionObject.MIN_VALUE);
        BigInteger r117 = new BigInteger(1, r107);
        BigInteger r118 = r117.subtract(r117.mod(r111.shiftLeft(1)).subtract(ONE));
        if (r118.bitLength() != this.L) goto L24;
        if (isProbablePrime(r118) == false) goto L24;
        int r119 = this.usageIndex;
        if (r119 < 0) goto L23;
        BigInteger r120 = calculateGenerator_FIPS186_3_Verifiable(r100, r118, r111, r102, r119);
        if (r120 == null) goto L23;
        return new DSAParameters(r118, r111, r120, new DSAValidationParameters(r102, r114, this.usageIndex));
    L23:
        return new DSAParameters(r118, r111, calculateGenerator_FIPS186_3_Unverifiable(r118, r111, this.random), new DSAValidationParameters(r102, r114));
    L24:
        r114 = r114 + 1;
        r110 = 0;
        goto L7
    }

    private static int getDefaultN(int r100) {
        if (r100 <= 1024) goto L5;
        return 256;
    L5:
        return 160;
    }

    private static int getMinimumIterations(int r100) {
        if (r100 > 1024) goto L6;
        return 40;
    L6:
        return (((r100 - 1) / 1024) * 8) + 48;
    }

    private static void hash(Digest r100, byte[] r101, byte[] r102, int r103) {
        r100.update(r101, 0, r101.length);
        r100.doFinal(r102, r103);
    }

    private static void inc(byte[] r100) {
        int r101 = r100.length - 1;
    L3:
        if (r101 < 0) goto L8;
        byte r102 = (byte) ((r100[r101] + 1) & 255);
        r100[r101] = r102;
        if (r102 != 0) goto L11;
        r101 = r101 - 1;
        goto L3
    L11:
        return;
    }

    private boolean isProbablePrime(BigInteger r100) {
        return r100.isProbablePrime(this.certainty);
    }

    public DSAParameters generateParameters() {
        if (this.use186_3 == false) goto L6;
        return generateParameters_FIPS186_3();
    L6:
        return generateParameters_FIPS186_2();
    }

    public void init(int r100, int r101, SecureRandom r102) {
        this.L = r100;
        this.N = getDefaultN(r100);
        this.certainty = r101;
        this.iterations = Math.max(getMinimumIterations(this.L), (r101 + 1) / 2);
        this.random = r102;
        this.use186_3 = false;
        this.usageIndex = -1;
    }

    public void init(DSAParameterGenerationParameters r100) {
        int r101 = r100.getL();
        int r102 = r100.getN();
        if (r101 < 1024) goto L34;
        if (r101 > 3072) goto L34;
        if ((r101 % 1024) != 0) goto L34;
        if (r101 != 1024) goto L15;
        if (r102 == 160) goto L15;
        throw new IllegalArgumentException("N must be 160 for L = 1024");
    L15:
        if (r101 == 2048) goto L17;
    L22:
        if (r101 != 3072) goto L28;
        if (r102 == 256) goto L28;
        throw new IllegalArgumentException("N must be 256 for L = 3072");
    L28:
        if ((this.digest.getDigestSize() * 8) < r102) goto L32;
        this.L = r101;
        this.N = r102;
        this.certainty = r100.getCertainty();
        this.iterations = Math.max(getMinimumIterations(r101), (this.certainty + 1) / 2);
        this.random = r100.getRandom();
        this.use186_3 = true;
        this.usageIndex = r100.getUsageIndex();
        return;
    L32:
        throw new IllegalStateException("Digest output size too small for value of N");
    L17:
        if (r102 == 224) goto L22;
        if (r102 == 256) goto L22;
        throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
    L34:
        throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
    }
}
