package com.google.common.util.concurrent;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class Striped<L> {
    private static final int ALL_SET = -1;
    private static final int LARGE_LAZY_CUTOFF = 1024;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.Striped$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class CompactStriped<L> extends PowerOfTwoStriped<L> {
        private final Object[] array;

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.array.length;
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int r100) {
            return (L) this.array[r100];
        }

        private CompactStriped(int r100, com.google.common.base.t<L> r101) {
            super(r100);
            int r102 = 0;
            if (r100 > 1073741824) goto L5;
            boolean r103 = true;
        L6:
            com.google.common.base.m.c(r103, "Stripes must be <= 2^30)");
            this.array = new Object[this.mask + 1];
        L7:
            Object[] r104 = this.array;
            if (r102 >= r104.length) goto L10;
            r104[r102] = r101.get();
            r102 = r102 + 1;
            goto L7
        L10:
            return;
        L5:
            r103 = false;
            goto L6
        }

        public /* synthetic */ CompactStriped(int r100, com.google.common.base.t r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
        final ConcurrentMap<Integer, L> locks;
        final int size;
        final com.google.common.base.t<L> supplier;

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int r100) {
            if (this.size == Integer.MAX_VALUE) goto L5;
            com.google.common.base.m.j(r100, size());
        L5:
            L r101 = this.locks.get(Integer.valueOf(r100));
            if (r101 == null) goto L8;
            return r101;
        L8:
            L r102 = this.supplier.get();
            return (L) com.google.common.base.j.a(this.locks.putIfAbsent(Integer.valueOf(r100), r102), r102);
        }

        public LargeLazyStriped(int r100, com.google.common.base.t<L> r101) {
            super(r100);
            int r102 = this.mask;
            if (r102 != (-1)) goto L5;
            int r103 = Integer.MAX_VALUE;
        L6:
            this.size = r103;
            this.supplier = r101;
            MapMaker r104 = new MapMaker();
            r104.f();
            this.locks = r104.c();
            return;
        L5:
            r103 = r102 + 1;
            goto L6
        }
    }

    public static class PaddedLock extends ReentrantLock {
        long unused1;
        long unused2;
        long unused3;

        public PaddedLock() {
            super(false);
        }
    }

    public static class PaddedSemaphore extends Semaphore {
        long unused1;
        long unused2;
        long unused3;

        public PaddedSemaphore(int r100) {
            super(r100, false);
        }
    }

    public static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        final int mask;

        public PowerOfTwoStriped(int r100) {
            super(null);
            if (r100 <= 0) goto L5;
            boolean r101 = true;
        L6:
            com.google.common.base.m.c(r101, "Stripes must be positive");
            if (r100 <= 1073741824) goto L9;
            int r102 = -1;
        L10:
            this.mask = r102;
            return;
        L9:
            r102 = Striped.access$200(r100) - 1;
            goto L10
        L5:
            r101 = false;
            goto L6
        }

        @Override // com.google.common.util.concurrent.Striped
        public final L get(Object r100) {
            return getAt(indexFor(r100));
        }

        @Override // com.google.common.util.concurrent.Striped
        public final int indexFor(Object r100) {
            return Striped.access$300(r100.hashCode()) & this.mask;
        }
    }

    public static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
        final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        final ReferenceQueue<L> queue;
        final int size;
        final com.google.common.base.t<L> supplier;

        public static final class ArrayReference<L> extends WeakReference<L> {
            final int index;

            public ArrayReference(L r100, int r101, ReferenceQueue<L> r102) {
                super(r100, r102);
                this.index = r101;
            }
        }

        private void drainQueue() {
        L2:
            Reference<? extends L> r100 = this.queue.poll();
            if (r100 == null) goto L11;
            ArrayReference<? extends L> r101 = (ArrayReference) r100;
            AtomicReferenceArray<ArrayReference<? extends L>> r102 = this.locks;
            int r103 = r101.index;
        L6:
            if (r102.compareAndSet(r103, r101, null) == true) goto L2;
            if (r102.get(r103) == r101) goto L6;
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int r100) {
            if (this.size == Integer.MAX_VALUE) goto L5;
            com.google.common.base.m.j(r100, size());
        L5:
            ArrayReference<? extends L> r101 = this.locks.get(r100);
            if (r101 != null) goto L8;
            L r102 = null;
        L9:
            if (r102 == null) goto L11;
            return r102;
        L11:
            L r103 = this.supplier.get();
            ArrayReference<? extends L> r104 = new ArrayReference(r103, r100, this.queue);
        L12:
            AtomicReferenceArray<ArrayReference<? extends L>> r105 = this.locks;
        L14:
            if (r105.compareAndSet(r100, r101, r104) == true) goto L15;
            if (r105.get(r100) == r101) goto L14;
            boolean r106 = false;
        L19:
            if (r106 == true) goto L26;
            r101 = this.locks.get(r100);
            if (r101 != null) goto L23;
            L r107 = null;
        L24:
            if (r107 == null) goto L12;
            return r107;
        L23:
            r107 = r101.get();
            goto L24
        L26:
            drainQueue();
            return r103;
        L15:
            r106 = true;
            goto L19
        L8:
            r102 = r101.get();
            goto L9
        }

        public SmallLazyStriped(int r100, com.google.common.base.t<L> r101) {
            super(r100);
            this.queue = new ReferenceQueue();
            int r102 = this.mask;
            if (r102 != (-1)) goto L5;
            int r103 = Integer.MAX_VALUE;
        L6:
            this.size = r103;
            this.locks = new AtomicReferenceArray(r103);
            this.supplier = r101;
            return;
        L5:
            r103 = r102 + 1;
            goto L6
        }
    }

    public static final class WeakSafeCondition extends ForwardingCondition {
        private final Condition delegate;
        private final WeakSafeReadWriteLock strongReference;

        @Override // com.google.common.util.concurrent.ForwardingCondition
        public Condition delegate() {
            return this.delegate;
        }

        public WeakSafeCondition(Condition r100, WeakSafeReadWriteLock r101) {
            this.delegate = r100;
            this.strongReference = r101;
        }
    }

    public static final class WeakSafeLock extends ForwardingLock {
        private final Lock delegate;
        private final WeakSafeReadWriteLock strongReference;

        @Override // com.google.common.util.concurrent.ForwardingLock, java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new WeakSafeCondition(this.delegate.newCondition(), this.strongReference);
        }

        @Override // com.google.common.util.concurrent.ForwardingLock
        public Lock delegate() {
            return this.delegate;
        }

        public WeakSafeLock(Lock r100, WeakSafeReadWriteLock r101) {
            this.delegate = r100;
            this.strongReference = r101;
        }
    }

    public static final class WeakSafeReadWriteLock implements ReadWriteLock {
        private final ReadWriteLock delegate;

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new WeakSafeLock(this.delegate.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new WeakSafeLock(this.delegate.writeLock(), this);
        }

        public WeakSafeReadWriteLock() {
            this.delegate = new ReentrantReadWriteLock();
        }
    }

    private Striped() {
    }

    public static /* synthetic */ Semaphore a(int r100) {
        return lambda$lazyWeakSemaphore$2(r100);
    }

    public static /* synthetic */ Lock b() {
        return lambda$lazyWeakLock$0();
    }

    public static /* synthetic */ Semaphore c(int r100) {
        return lambda$semaphore$1(r100);
    }

    private static int smear(int r100) {
        int r101 = r100 ^ ((r100 >>> 20) ^ (r100 >>> 12));
        int r102 = (r101 >>> 7) ^ r101;
        return (r101 >>> 4) ^ r102;
    }

    public abstract L get(Object r100);

    public abstract L getAt(int r100);

    public abstract int indexFor(Object r100);

    public abstract int size();

    private static /* synthetic */ Lock lambda$lazyWeakLock$0() {
        return new ReentrantLock(false);
    }

    public /* synthetic */ Striped(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ int access$200(int r100) {
        return ceilToPowerOfTwo(r100);
    }

    public static /* synthetic */ int access$300(int r100) {
        return smear(r100);
    }

    private static int ceilToPowerOfTwo(int r100) {
        return 1 << com.google.common.math.c.d(r100, RoundingMode.CEILING);
    }

    private static /* synthetic */ Semaphore lambda$lazyWeakSemaphore$2(int r100) {
        return new Semaphore(r100, false);
    }

    private static /* synthetic */ Semaphore lambda$semaphore$1(int r100) {
        return new PaddedSemaphore(r100);
    }

    public static Striped<Lock> lazyWeakLock(int r100) {
        return lazy(r100, new c0());
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int r100) {
        return lazy(r100, new a0());
    }

    public static Striped<Lock> lock(int r100) {
        return custom(r100, new d0());
    }

    public static Striped<ReadWriteLock> readWriteLock(int r100) {
        return custom(r100, new b0());
    }

    public Iterable<L> bulkGet(Iterable<? extends Object> r100) {
        ArrayList r101 = Lists.b(r100);
        if (r101.isEmpty() == true) goto L5;
        int[] r102 = new int[r101.size()];
        int r103 = 0;
    L8:
        if (r103 >= r101.size()) goto L10;
        r102[r103] = indexFor(ListProtector.get(r101, r103));
        r103 = r103 + 1;
        goto L8
    L10:
        Arrays.sort(r102);
        int r104 = r102[0];
        ListProtector.set(r101, 0, getAt(r104));
        int r105 = 1;
    L12:
        if (r105 >= r101.size()) goto L19;
        int r106 = r102[r105];
        if (r106 != r104) goto L16;
        ListProtector.set(r101, r105, ListProtector.get(r101, r105 - 1));
    L17:
        r105 = r105 + 1;
        goto L12
    L16:
        ListProtector.set(r101, r105, getAt(r106));
        r104 = r106;
        goto L17
    L19:
        return Collections.unmodifiableList(r101);
    L5:
        return ImmutableList.of();
    }

    public static <L> Striped<L> custom(int r100, com.google.common.base.t<L> r101) {
        return new CompactStriped(r100, r101, null);
    }

    private static <L> Striped<L> lazy(int r100, com.google.common.base.t<L> r101) {
        if (r100 >= 1024) goto L6;
        return new SmallLazyStriped(r100, r101);
    L6:
        return new LargeLazyStriped(r100, r101);
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int r100, final int r101) {
        return lazy(r100, new z(r101));
    }

    public static Striped<Semaphore> semaphore(int r100, final int r101) {
        return custom(r100, new y(r101));
    }
}
