package org.bouncycastle.util.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Provider;
import java.security.SecureRandom;
import kotlin.UByte;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class FixedSecureRandom extends SecureRandom {
    private static java.math.BigInteger ANDROID;
    private static java.math.BigInteger CLASSPATH;
    private static java.math.BigInteger REGULAR;
    private static final boolean isAndroidStyle = false;
    private static final boolean isClasspathStyle = false;
    private static final boolean isRegularStyle = false;
    private byte[] _data;
    private int _index;

    public static class BigInteger extends Source {
        public BigInteger(int r100, String r101) {
            super(FixedSecureRandom.access$000(r100, Hex.decode(r101)));
        }

        public BigInteger(int r100, byte[] r101) {
            super(FixedSecureRandom.access$000(r100, r101));
        }

        public BigInteger(String r100) {
            this(Hex.decode(r100));
        }

        public BigInteger(byte[] r100) {
            super(r100);
        }
    }

    public static class Data extends Source {
        public Data(byte[] r100) {
            super(r100);
        }
    }

    public static class DummyProvider extends Provider {
        public DummyProvider() {
            super("BCFIPS_FIXED_RNG", 1.0d, "BCFIPS Fixed Secure Random Provider");
        }
    }

    public static class RandomChecker extends SecureRandom {
        byte[] data;
        int index;

        public RandomChecker() {
            super(null, new DummyProvider());
            this.data = Hex.decode("01020304ffffffff0506070811111111");
            this.index = 0;
        }

        @Override // java.security.SecureRandom, java.util.Random
        public void nextBytes(byte[] r100) {
            System.arraycopy(this.data, this.index, r100, 0, r100.length);
            this.index += r100.length;
        }
    }

    public static class Source {
        byte[] data;

        public Source(byte[] r100) {
            this.data = r100;
        }
    }

    static {
        REGULAR = new java.math.BigInteger("01020304ffffffff0506070811111111", 16);
        ANDROID = new java.math.BigInteger("1111111105060708ffffffff01020304", 16);
        CLASSPATH = new java.math.BigInteger("3020104ffffffff05060708111111", 16);
        java.math.BigInteger r100 = new java.math.BigInteger(128, new RandomChecker());
        java.math.BigInteger r101 = new java.math.BigInteger(120, new RandomChecker());
        isAndroidStyle = r100.equals(ANDROID);
        isRegularStyle = r100.equals(REGULAR);
        isClasspathStyle = r101.equals(CLASSPATH);
    }

    public FixedSecureRandom(byte[] r100) {
        this(new Source[]{new Data(r100)});
    }

    public FixedSecureRandom(Source[] r110) {
        super(null, new DummyProvider());
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        int r101 = 0;
        if (isRegularStyle == false) goto L28;
        if (isClasspathStyle == false) goto L22;
    L7:
        if (r101 == r110.length) goto L51;
        Source r102 = r110[r101];     // Catch: IOException -> L19
        if ((r102 instanceof BigInteger) == false) goto L17;
        byte[] r103 = r102.data;     // Catch: IOException -> L19
        int r104 = r103.length - (r103.length % 4);     // Catch: IOException -> L19
        int r105 = (r103.length - r104) - 1;     // Catch: IOException -> L19
    L11:
        if (r105 < 0) goto L13;
        r100.write(r103[r105]);     // Catch: IOException -> L19
        r105 = r105 - 1;     // Catch: IOException -> L19
        goto L11
    L13:
        int r106 = r103.length - r104;     // Catch: IOException -> L19
    L15:
        if (r106 >= r103.length) goto L18;
        r100.write(r103, r106, 4);     // Catch: IOException -> L19
        r106 = r106 + 4;     // Catch: IOException -> L19
    L18:
        r101 = r101 + 1;
        goto L7
    L17:
        r100.write(r102.data);     // Catch: IOException -> L19
    L20:
        throw new IllegalArgumentException("can't save value source.");
    L51:
        this._data = r100.toByteArray();
        return;
    L22:
        if (r101 == r110.length) goto L51;
        r100.write(r110[r101].data);     // Catch: IOException -> L25
        r101 = r101 + 1;
    L26:
        throw new IllegalArgumentException("can't save value source.");
    L28:
        if (isAndroidStyle == false) goto L54;
        int r107 = 0;
    L31:
        if (r107 == r110.length) goto L51;
        Source r108 = r110[r107];     // Catch: IOException -> L49
        if ((r108 instanceof BigInteger) == false) goto L47;
        byte[] r109 = r108.data;     // Catch: IOException -> L49
        int r111 = r109.length - (r109.length % 4);     // Catch: IOException -> L49
        int r112 = 0;
    L35:
        if (r112 >= r111) goto L38;
        r112 = r112 + 4;     // Catch: IOException -> L49
        r100.write(r109, r109.length - r112, 4);     // Catch: IOException -> L49
        goto L35
    L38:
        if ((r109.length - r111) == 0) goto L43;
        int r113 = 0;
    L41:
        if (r113 == (4 - (r109.length - r111))) goto L43;
        r100.write(0);     // Catch: IOException -> L49
        r113 = r113 + 1;     // Catch: IOException -> L49
    L43:
        int r114 = 0;
    L45:
        if (r114 == (r109.length - r111)) goto L48;
        r100.write(r109[r111 + r114]);     // Catch: IOException -> L49
        r114 = r114 + 1;     // Catch: IOException -> L49
    L48:
        r107 = r107 + 1;
        goto L31
    L47:
        r100.write(r108.data);     // Catch: IOException -> L49
    L50:
        throw new IllegalArgumentException("can't save value source.");
    L54:
        throw new IllegalStateException("Unrecognized BigInteger implementation");
    }

    public FixedSecureRandom(byte[][] r100) {
        this(buildDataArray(r100));
    }

    public static /* synthetic */ byte[] access$000(int r100, byte[] r101) {
        return expandToBitLength(r100, r101);
    }

    private static Data[] buildDataArray(byte[][] r100) {
        Data[] r101 = new Data[r100.length];
        int r102 = 0;
    L4:
        if (r102 == r100.length) goto L6;
        r101[r102] = new Data(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    private static byte[] expandToBitLength(int r100, byte[] r101) {
        int r102 = (r100 + 7) / 8;
        if (r102 <= r101.length) goto L11;
        byte[] r103 = new byte[r102];
        System.arraycopy(r101, 0, r103, r102 - r101.length, r101.length);
        if (isAndroidStyle == false) goto L9;
        int r104 = r100 % 8;
        if (r104 == 0) goto L9;
        Pack.intToBigEndian(Pack.bigEndianToInt(r103, 0) << (8 - r104), r103, 0);
    L9:
        return r103;
    L11:
        if (isAndroidStyle == true) goto L13;
    L17:
        return r101;
    L13:
        if (r100 >= (r101.length * 8)) goto L17;
        int r105 = r100 % 8;
        if (r105 == 0) goto L17;
        Pack.intToBigEndian(Pack.bigEndianToInt(r101, 0) << (8 - r105), r101, 0);
        goto L17
    }

    private int nextValue() {
        byte[] r100 = this._data;
        int r101 = this._index;
        this._index = r101 + 1;
        return r100[r101] & UByte.MAX_VALUE;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int r100) {
        byte[] r101 = new byte[r100];
        nextBytes(r101);
        return r101;
    }

    public boolean isExhausted() {
        if (this._index != this._data.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] r100) {
        System.arraycopy(this._data, this._index, r100, 0, r100.length);
        this._index += r100.length;
    }

    @Override // java.util.Random
    public int nextInt() {
        return ((((nextValue() << 24) | 0) | (nextValue() << 16)) | (nextValue() << 8)) | nextValue();
    }

    @Override // java.util.Random
    public long nextLong() {
        return ((((((((((long) nextValue()) << 56) | 0) | (((long) nextValue()) << 48)) | (((long) nextValue()) << 40)) | (((long) nextValue()) << 32)) | (((long) nextValue()) << 24)) | (((long) nextValue()) << 16)) | (((long) nextValue()) << 8)) | ((long) nextValue());
    }
}
