package com.google.common.hash;

import com.google.common.base.m;
import com.google.common.math.LongMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract enum BloomFilterStrategies extends Enum<BloomFilterStrategies> implements BloomFilter.Strategy {
    public static final BloomFilterStrategies MURMUR128_MITZ_32 = null;
    public static final BloomFilterStrategies MURMUR128_MITZ_64 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BloomFilterStrategies[] f275556a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicLongArray f275557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f275558b;

        public final long a() {
            return ((long) this.f275557a.length()) * 64;
        }

        public final int hashCode() {
            return Arrays.hashCode(e(this.f275557a));
        }

        public a(long r110) {
            boolean r100 = false;
            if (r110 <= 0) goto L5;
            boolean r101 = true;
        L6:
            m.c(r101, "data length is zero!");
            RoundingMode r102 = RoundingMode.CEILING;
            r102.getClass();
            long r103 = r110 / 64;
            long r111 = r110 - (r103 * 64);
            if (r111 == 0) goto L35;
            int r112 = ((int) ((r110 ^ 64) >> 63)) | 1;
            switch(LongMath.a.f275623a[r102.ordinal()]) {
                case 1: goto L28;
                case 2: goto L32;
                case 3: goto L26;
                case 4: goto L27;
                case 5: goto L24;
                case 6: goto L13;
                case 7: goto L13;
                case 8: goto L13;
                default: goto L12;
            };
        L13:
            long r113 = Math.abs(r111);
            long r114 = r113 - (Math.abs(64) - r113);
            if (r114 == 0) goto L16;
            if (r114 <= 0) goto L32;
        L16:
            if (r102 == RoundingMode.HALF_UP) goto L27;
            if (r102 != RoundingMode.HALF_EVEN) goto L32;
            if ((1 & r103) == 0) goto L32;
        L24:
            if (r112 <= 0) goto L32;
        L26:
            if (r112 >= 0) goto L32;
        L27:
            boolean r104 = true;
        L33:
            if (r104 == false) goto L35;
            r103 = r103 + ((long) r112);
            goto L35
        L28:
            if (r111 != 0) goto L30;
            boolean r105 = true;
        L31:
            if (r105 == true) goto L32;
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        L30:
            r105 = false;
        L32:
            r104 = false;
            goto L33
        L12:
            throw new AssertionError();
        L35:
            int r106 = (int) r103;
            if (r106 != r103) goto L38;
            r100 = true;
        L38:
            m.f(r100, "Out of range: %s", r103);
            this.f275557a = new AtomicLongArray(r106);
            this.f275558b = LongAddables.f275572a.get();
            return;
        L5:
            r101 = false;
            goto L6
        }

        public static long[] e(AtomicLongArray r100) {
            int r101 = r100.length();
            long[] r102 = new long[r101];
            int r103 = 0;
        L3:
            if (r103 >= r101) goto L5;
            r102[r103] = r100.get(r103);
            r103 = r103 + 1;
            goto L3
        L5:
            return r102;
        }

        public final boolean b(long r100) {
            long r101 = this.f275557a.get((int) (r100 >>> 6));
            if (((1 << ((int) r100)) & r101) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean d(long r110) {
            if (b(r110) == false) goto L5;
            return false;
        L5:
            int r100 = (int) (r110 >>> 6);
            long r111 = 1 << ((int) r110);
        L6:
            long r101 = this.f275557a.get(r100);
            long r102 = r101 | r111;
            if (r101 == r102) goto L8;
            if (this.f275557a.compareAndSet(r100, r101, r102) == false) goto L6;
            this.f275558b.increment();
            return true;
        L8:
            return false;
        }

        public final boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof a) == true) goto L5;
            return false;
        L5:
            return Arrays.equals(e(this.f275557a), e(((a) r100).f275557a));
        }

        public a(long[] r100) {
            int r101 = 0;
            if (r100.length <= 0) goto L5;
            boolean r102 = true;
        L6:
            m.c(r102, "data length is zero!");
            this.f275557a = new AtomicLongArray(r100);
            this.f275558b = LongAddables.f275572a.get();
            int r103 = r100.length;
            long r104 = 0;
        L7:
            if (r101 >= r103) goto L9;
            r104 = r104 + ((long) Long.bitCount(r100[r101]));
            r101 = r101 + 1;
            goto L7
        L9:
            this.f275558b.add(r104);
            return;
        L5:
            r102 = false;
            goto L6
        }

        public final void c(int r110, long r111) {
        L2:
            long r100 = this.f275557a.get(r110);
            long r101 = r100 | r111;
            if (r100 == r101) goto L4;
            if (this.f275557a.compareAndSet(r110, r100, r101) == false) goto L2;
            boolean r112 = true;
        L8:
            if (r112 == false) goto L14;
            this.f275558b.add(Long.bitCount(r101) - Long.bitCount(r100));
            return;
        L14:
            return;
        L4:
            r112 = false;
            goto L8
        }
    }

    public BloomFilterStrategies() {
        throw null;
    }

    @Override // com.google.common.hash.BloomFilter.Strategy
    public abstract /* synthetic */ <T> boolean mightContain(@ParametricNullness T r100, Funnel<? super T> r101, int r102, a r103);

    @Override // com.google.common.hash.BloomFilter.Strategy
    public abstract /* synthetic */ <T> boolean put(@ParametricNullness T r100, Funnel<? super T> r101, int r102, a r103);

    static {
        final String r100 = "MURMUR128_MITZ_32";
        final int r101 = 0;
        BloomFilterStrategies r102 = new AnonymousClass1(r100, r101);
        MURMUR128_MITZ_32 = r102;
        final String r103 = "MURMUR128_MITZ_64";
        final int r104 = 1;
        BloomFilterStrategies r105 = new AnonymousClass2(r103, r104);
        MURMUR128_MITZ_64 = r105;
        f275556a = new BloomFilterStrategies[]{r102, r105};
    }

    public static BloomFilterStrategies[] values() {
        return (BloomFilterStrategies[]) f275556a.clone();
    }

    public static BloomFilterStrategies valueOf(String r100) {
        return (BloomFilterStrategies) r27.a.a(BloomFilterStrategies.class, r100);
    }

    public BloomFilterStrategies(String r100, int r101, AnonymousClass1 r102) {
        super(r100, r101);
    }
}
