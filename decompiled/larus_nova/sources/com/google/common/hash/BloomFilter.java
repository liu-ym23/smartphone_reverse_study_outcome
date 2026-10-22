package com.google.common.hash;

import androidx.camera.video.AudioStats;
import com.google.common.base.m;
import com.google.common.base.n;
import com.google.common.base.s;
import com.google.common.math.LongMath;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckForNull;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class BloomFilter<T> implements n<T>, Serializable {
    private final BloomFilterStrategies.a bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    public static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        public Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.a(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
        }

        public SerialForm(BloomFilter<T> r100) {
            this.data = BloomFilterStrategies.a.e(BloomFilter.access$000(r100).f275557a);
            this.numHashFunctions = BloomFilter.access$100(r100);
            this.funnel = BloomFilter.access$200(r100);
            this.strategy = BloomFilter.access$300(r100);
        }
    }

    public interface Strategy extends Serializable {
        <T> boolean mightContain(@ParametricNullness T r100, Funnel<? super T> r101, int r102, BloomFilterStrategies.a r103);

        int ordinal();

        <T> boolean put(@ParametricNullness T r100, Funnel<? super T> r101, int r102, BloomFilterStrategies.a r103);
    }

    public static /* synthetic */ class a {
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits});
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    public long approximateElementCount() {
        double r100 = this.bits.a();
        double r101 = ((-Math.log1p(-(this.bits.f275558b.sum() / r100))) * r100) / ((double) this.numHashFunctions);
        RoundingMode r102 = RoundingMode.HALF_UP;
        int r103 = com.google.common.math.a.f275624a;
        if (com.google.common.math.b.a(r101) == false) goto L56;
        boolean r104 = true;
        switch(com.google.common.math.a.C3859a.f275625a[r102.ordinal()]) {
            case 1: goto L37;
            case 2: goto L30;
            case 3: goto L24;
            case 4: goto L38;
            case 5: goto L16;
            case 6: goto L14;
            case 7: goto L11;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        double r105 = Math.rint(r101);
        if (Math.abs(r101 - r105) != 0.5d) goto L40;
        r105 = r101;
    L40:
        if (((-9.223372036854776E18d) - r105) >= 1.0d) goto L42;
        boolean r106 = true;
    L44:
        if (r105 < 9.223372036854776E18d) goto L48;
        r104 = false;
    L48:
        if ((r106 & r104) == false) goto L52;
        return (long) r105;
    L52:
        throw new ArithmeticException("rounded value is out of range for input " + r101 + " and rounding mode " + r102);
    L42:
        r106 = false;
        goto L44
    L11:
        r105 = Math.rint(r101);
        if (Math.abs(r101 - r105) != 0.5d) goto L40;
        r105 = Math.copySign(0.5d, r101) + r101;
        goto L40
    L14:
        r105 = Math.rint(r101);
        goto L40
    L38:
        r105 = r101;
        goto L40
    L7:
        throw new AssertionError();
    L16:
        if (com.google.common.math.a.a(r101) == true) goto L61;
        long r107 = (long) r101;
        if (r101 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L21;
        int r108 = 1;
    L22:
        r105 = r107 + ((long) r108);
        goto L40
    L21:
        r108 = -1;
        goto L22
    L61:
        r105 = r101;
        goto L40
    L24:
        if (r101 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L26;
        r105 = r101;
        goto L40
    L26:
        if (com.google.common.math.a.a(r101) == true) goto L62;
        long r109 = ((long) r101) + 1;
    L35:
        r105 = r109;
        goto L40
    L62:
        r105 = r101;
        goto L40
    L30:
        if (r101 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L32;
        r105 = r101;
        goto L40
    L32:
        if (com.google.common.math.a.a(r101) == true) goto L63;
        r109 = ((long) r101) - 1;
        goto L35
    L63:
        r105 = r101;
        goto L40
    L37:
        if (com.google.common.math.a.a(r101) == false) goto L54;
        r105 = r101;
        goto L40
    L54:
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    L56:
        throw new ArithmeticException("input is infinite or NaN");
    }

    public long bitSize() {
        return this.bits.a();
    }

    public BloomFilter<T> copy() {
        BloomFilterStrategies.a r100 = this.bits;
        r100.getClass();
        return new BloomFilter(new BloomFilterStrategies.a(BloomFilterStrategies.a.e(r100.f275557a)), this.numHashFunctions, this.funnel, this.strategy);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.f275558b.sum() / bitSize(), this.numHashFunctions);
    }

    public static /* synthetic */ BloomFilterStrategies.a access$000(BloomFilter r100) {
        return r100.bits;
    }

    public static /* synthetic */ int access$100(BloomFilter r100) {
        return r100.numHashFunctions;
    }

    public static /* synthetic */ Funnel access$200(BloomFilter r100) {
        return r100.funnel;
    }

    public static /* synthetic */ Strategy access$300(BloomFilter r100) {
        return r100.strategy;
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.base.n
    public boolean apply(@ParametricNullness T r100) {
        return mightContain(r100);
    }

    @Override // com.google.common.base.n
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof BloomFilter) == false) goto L18;
        BloomFilter r101 = (BloomFilter) r100;
        if (this.numHashFunctions == r101.numHashFunctions) goto L10;
    L16:
        return false;
    L10:
        if (this.funnel.equals(r101.funnel) == false) goto L16;
        if (this.bits.equals(r101.bits) == false) goto L16;
        if (this.strategy.equals(r101.strategy) == false) goto L16;
        return true;
    L18:
        return false;
    }

    public boolean isCompatible(BloomFilter<T> r100) {
        r100.getClass();
        if (this != r100) goto L5;
    L13:
        return false;
    L5:
        if (this.numHashFunctions != r100.numHashFunctions) goto L13;
        if (bitSize() != r100.bitSize()) goto L13;
        if (this.strategy.equals(r100.strategy) == false) goto L13;
        if (this.funnel.equals(r100.funnel) == false) goto L13;
        return true;
    }

    public boolean mightContain(@ParametricNullness T r100) {
        return this.strategy.mightContain(r100, this.funnel, this.numHashFunctions, this.bits);
    }

    public boolean put(@ParametricNullness T r100) {
        return this.strategy.put(r100, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> r100) {
        r100.getClass();
        boolean r101 = true;
        int r102 = 0;
        if (this == r100) goto L5;
        boolean r103 = true;
    L6:
        m.c(r103, "Cannot combine a BloomFilter with itself.");
        int r104 = this.numHashFunctions;
        int r105 = r100.numHashFunctions;
        if (r104 != r105) goto L9;
        boolean r106 = true;
    L10:
        m.e(r106, "BloomFilters must have the same number of hash functions (%s != %s)", r104, r105);
        if (bitSize() != r100.bitSize()) goto L13;
        boolean r107 = true;
    L14:
        long r108 = bitSize();
        long r109 = r100.bitSize();
        if (r107 == false) goto L26;
        m.i(this.strategy.equals(r100.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, r100.strategy);
        m.i(this.funnel.equals(r100.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, r100.funnel);
        BloomFilterStrategies.a r110 = this.bits;
        BloomFilterStrategies.a r111 = r100.bits;
        if (r110.f275557a.length() == r111.f275557a.length()) goto L20;
        r101 = false;
    L20:
        m.e(r101, "BitArrays must be of equal length (%s != %s)", r110.f275557a.length(), r111.f275557a.length());
    L22:
        if (r102 >= r110.f275557a.length()) goto L24;
        r110.c(r102, r111.f275557a.get(r102));
        r102 = r102 + 1;
        goto L22
    L24:
        return;
    L26:
        throw new IllegalArgumentException(s.a("BloomFilters must have the same size underlying bit arrays (%s != %s)", new Object[]{Long.valueOf(r108), Long.valueOf(r109)}));
    L13:
        r107 = false;
        goto L14
    L9:
        r106 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public void writeTo(OutputStream r110) throws IOException {
        DataOutputStream r100 = new DataOutputStream(r110);
        long r101 = this.strategy.ordinal();
        byte r111 = (byte) r101;
        boolean r102 = true;
        int r103 = 0;
        if (r111 != r101) goto L5;
        boolean r104 = true;
    L6:
        m.f(r104, "Out of range: %s", r101);
        r100.writeByte(r111);
        long r105 = this.numHashFunctions;
        if ((r105 >> 8) == 0) goto L10;
        r102 = false;
    L10:
        m.f(r102, "out of range: %s", r105);
        r100.writeByte((byte) r105);
        r100.writeInt(this.bits.f275557a.length());
    L12:
        if (r103 >= this.bits.f275557a.length()) goto L14;
        r100.writeLong(this.bits.f275557a.get(r103));
        r103 = r103 + 1;
        goto L12
    L14:
        return;
    L5:
        r104 = false;
        goto L6
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r100, long r101) {
        return create(r100, r101, 0.03d);
    }

    public static long optimalNumOfBits(long r100, double r101) {
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        r101 = Double.MIN_VALUE;
    L6:
        return (long) (((-r100) * Math.log(r101)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    public static int optimalNumOfHashFunctions(long r100, long r101) {
        return Math.max(1, (int) Math.round((r101 / r100) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream r110, Funnel<? super T> r111) throws IOException {
        m.l(r110, "InputStream");
        m.l(r111, "Funnel");
        byte r100 = -1;
        DataInputStream r101 = new DataInputStream(r110);     // Catch: RuntimeException -> L19
        byte r112 = r101.readByte();     // Catch: RuntimeException -> L19
        int r102 = r101.readByte() & UByte.MAX_VALUE;
        int r103 = r101.readInt();     // Catch: RuntimeException -> L14
        BloomFilterStrategies r104 = BloomFilterStrategies.values()[r112];     // Catch: RuntimeException -> L12
        BloomFilterStrategies.a r105 = new BloomFilterStrategies.a(LongMath.b(r103, 64));     // Catch: RuntimeException -> L12
        int r106 = 0;
    L8:
        if (r106 >= r103) goto L10;
        r105.c(r106, r101.readLong());     // Catch: RuntimeException -> L12
        r106 = r106 + 1;     // Catch: RuntimeException -> L12
        goto L8
    L10:
        return new BloomFilter(r105, r102, r111, r104);
    L12:
        RuntimeException e100 = e;
        r100 = r112;
        int r113 = r103;
    L22:
        throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + r100 + " numHashFunctions: " + r102 + " dataLength: " + r113, e100);
    L14:
        e100 = e;
    L18:
        r100 = r112;
        r113 = -1;
    L16:
        e100 = e;
        r102 = -1;
    L19:
        e = move-exception;
        e100 = e;
        r113 = -1;
        r102 = -1;
        goto L22
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r100, int r101) {
        return create(r100, r101);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r100, long r101, double r102) {
        return create(r100, r101, r102, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r100, int r101, double r102) {
        return create(r100, r101, r102);
    }

    public BloomFilter(BloomFilterStrategies.a r100, int r101, Funnel<? super T> r102, Strategy r103) {
        boolean r104 = true;
        if (r101 <= 0) goto L5;
        boolean r105 = true;
    L6:
        m.d(r105, "numHashFunctions (%s) must be > 0", r101);
        if (r101 <= 255) goto L10;
        r104 = false;
    L10:
        m.d(r104, "numHashFunctions (%s) must be <= 255", r101);
        r100.getClass();
        this.bits = r100;
        this.numHashFunctions = r101;
        r102.getClass();
        this.funnel = r102;
        r103.getClass();
        this.strategy = r103;
        return;
    L5:
        r105 = false;
        goto L6
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r100, long r101, double r102, Strategy r110) {
        r100.getClass();
        boolean r103 = true;
        if (r101 < 0) goto L5;
        boolean r104 = true;
    L6:
        m.f(r104, "Expected insertions (%s) must be >= 0", r101);
        if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        boolean r105 = true;
    L10:
        m.h(r105, "False positive probability (%s) must be > 0.0", Double.valueOf(r102));
        if (r102 < 1.0d) goto L14;
        r103 = false;
    L14:
        m.h(r103, "False positive probability (%s) must be < 1.0", Double.valueOf(r102));
        r110.getClass();
        if (r101 != 0) goto L17;
        r101 = 1;
    L17:
        long r106 = optimalNumOfBits(r101, r102);
        return new BloomFilter(new BloomFilterStrategies.a(r106), optimalNumOfHashFunctions(r101, r106), r100, r110);
    L20:
        e = move-exception;
        throw new IllegalArgumentException("Could not create BloomFilter of " + r106 + " bits", e);
    L9:
        r105 = false;
        goto L10
    L5:
        r104 = false;
        goto L6
    }

    public /* synthetic */ BloomFilter(BloomFilterStrategies.a r100, int r101, Funnel r102, Strategy r103, a r104) {
        this(r100, r101, r102, r103);
    }
}
