package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class DiscreteDomain<C extends Comparable> {
    final boolean supportsFastOffset;

    public static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BigIntegerDomain f275009a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final BigInteger f275010b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final BigInteger f275011c = null;
        private static final long serialVersionUID = 0;

        public BigIntegerDomain() {
            super(true, null);
        }

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }

        static {
            f275009a = new BigIntegerDomain();
            f275010b = BigInteger.valueOf(Long.MIN_VALUE);
            f275011c = BigInteger.valueOf(Long.MAX_VALUE);
        }

        public static /* synthetic */ BigIntegerDomain access$300() {
            return f275009a;
        }

        private Object readResolve() {
            return f275009a;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable next(Comparable r100) {
            return next((BigInteger) r100);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable previous(Comparable r100) {
            return previous((BigInteger) r100);
        }

        public BigInteger next(BigInteger r100) {
            return r100.add(BigInteger.ONE);
        }

        public BigInteger previous(BigInteger r100) {
            return r100.subtract(BigInteger.ONE);
        }

        public long distance(BigInteger r100, BigInteger r101) {
            return r101.subtract(r100).max(f275010b).min(f275011c).longValue();
        }

        public BigInteger offset(BigInteger r100, long r101) {
            o.c(r101);
            return r100.add(BigInteger.valueOf(r101));
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ long distance(Comparable r100, Comparable r101) {
            return distance((BigInteger) r100, (BigInteger) r101);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable offset(Comparable r100, long r101) {
            return offset((BigInteger) r100, r101);
        }
    }

    public static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final IntegerDomain f275012a = null;
        private static final long serialVersionUID = 0;

        public IntegerDomain() {
            super(true, null);
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }

        static {
            f275012a = new IntegerDomain();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer minValue() {
            return Integer.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer maxValue() {
            return Integer.MAX_VALUE;
        }

        public static /* synthetic */ IntegerDomain access$000() {
            return f275012a;
        }

        private Object readResolve() {
            return f275012a;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable maxValue() {
            return maxValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable minValue() {
            return minValue();
        }

        @CheckForNull
        public Integer next(Integer r100) {
            int r101 = r100.intValue();
            if (r101 != Integer.MAX_VALUE) goto L6;
            return null;
        L6:
            return Integer.valueOf(r101 + 1);
        }

        @CheckForNull
        public Integer previous(Integer r100) {
            int r101 = r100.intValue();
            if (r101 != Integer.MIN_VALUE) goto L6;
            return null;
        L6:
            return Integer.valueOf(r101 - 1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        @CheckForNull
        public /* bridge */ /* synthetic */ Comparable next(Comparable r100) {
            return next((Integer) r100);
        }

        @Override // com.google.common.collect.DiscreteDomain
        @CheckForNull
        public /* bridge */ /* synthetic */ Comparable previous(Comparable r100) {
            return previous((Integer) r100);
        }

        public long distance(Integer r100, Integer r101) {
            return ((long) r101.intValue()) - ((long) r100.intValue());
        }

        public Integer offset(Integer r100, long r101) {
            o.c(r101);
            long r102 = r100.longValue() + r101;
            int r103 = (int) r102;
            if (r103 != r102) goto L5;
            boolean r104 = true;
        L6:
            com.google.common.base.m.f(r104, "Out of range: %s", r102);
            return Integer.valueOf(r103);
        L5:
            r104 = false;
            goto L6
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ long distance(Comparable r100, Comparable r101) {
            return distance((Integer) r100, (Integer) r101);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable offset(Comparable r100, long r101) {
            return offset((Integer) r100, r101);
        }
    }

    public static final class LongDomain extends DiscreteDomain<Long> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LongDomain f275013a = null;
        private static final long serialVersionUID = 0;

        public LongDomain() {
            super(true, null);
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }

        static {
            f275013a = new LongDomain();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long minValue() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long maxValue() {
            return Long.MAX_VALUE;
        }

        public static /* synthetic */ LongDomain access$200() {
            return f275013a;
        }

        private Object readResolve() {
            return f275013a;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable maxValue() {
            return maxValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable minValue() {
            return minValue();
        }

        @CheckForNull
        public Long next(Long r100) {
            long r101 = r100.longValue();
            if (r101 != Long.MAX_VALUE) goto L6;
            return null;
        L6:
            return Long.valueOf(r101 + 1);
        }

        @CheckForNull
        public Long previous(Long r100) {
            long r101 = r100.longValue();
            if (r101 != Long.MIN_VALUE) goto L6;
            return null;
        L6:
            return Long.valueOf(r101 - 1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        @CheckForNull
        public /* bridge */ /* synthetic */ Comparable next(Comparable r100) {
            return next((Long) r100);
        }

        @Override // com.google.common.collect.DiscreteDomain
        @CheckForNull
        public /* bridge */ /* synthetic */ Comparable previous(Comparable r100) {
            return previous((Long) r100);
        }

        public long distance(Long r110, Long r111) {
            long r100 = r111.longValue() - r110.longValue();
            if (r111.longValue() <= r110.longValue()) goto L9;
            if (r100 >= 0) goto L9;
            return Long.MAX_VALUE;
        L9:
            if (r111.longValue() < r110.longValue()) goto L11;
        L14:
            return r100;
        L11:
            if (r100 <= 0) goto L14;
            return Long.MIN_VALUE;
        }

        public Long offset(Long r100, long r101) {
            o.c(r101);
            long r102 = r100.longValue() + r101;
            if (r102 >= 0) goto L10;
            if (r100.longValue() >= 0) goto L7;
            boolean r103 = true;
        L8:
            com.google.common.base.m.c(r103, "overflow");
            goto L10
        L7:
            r103 = false;
        L10:
            return Long.valueOf(r102);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ long distance(Comparable r100, Comparable r101) {
            return distance((Long) r100, (Long) r101);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable offset(Comparable r100, long r101) {
            return offset((Long) r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public DiscreteDomain() {
        this(false);
    }

    public abstract long distance(C r100, C r101);

    @CheckForNull
    public abstract C next(C r100);

    @CheckForNull
    public abstract C previous(C r100);

    public C maxValue() {
        throw new NoSuchElementException();
    }

    public C minValue() {
        throw new NoSuchElementException();
    }

    public static DiscreteDomain<BigInteger> bigIntegers() {
        return BigIntegerDomain.access$300();
    }

    public static DiscreteDomain<Integer> integers() {
        return IntegerDomain.access$000();
    }

    public static DiscreteDomain<Long> longs() {
        return LongDomain.access$200();
    }

    public DiscreteDomain(boolean r100) {
        this.supportsFastOffset = r100;
    }

    public /* synthetic */ DiscreteDomain(boolean r100, a r101) {
        this(r100);
    }

    public C offset(C r100, long r101) {
        o.c(r101);
        long r102 = 0;
        C r103 = r100;
    L4:
        if (r102 >= r101) goto L10;
        r103 = (C) next(r103);
        if (r103 == null) goto L9;
        r102 = r102 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("overflowed computing offset(" + r100 + ", " + r101 + ")");
    L10:
        return r103;
    }
}
