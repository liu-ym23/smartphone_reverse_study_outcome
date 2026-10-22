package com.google.common.util.concurrent;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class AggregateFutureState<OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    private static final AtomicHelper ATOMIC_HELPER = null;
    private static final Logger log = null;
    private volatile int remaining;

    @CheckForNull
    private volatile Set<Throwable> seenExceptions;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AggregateFutureState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract void compareAndSetSeenExceptions(AggregateFutureState<?> r100, @CheckForNull Set<Throwable> r101, Set<Throwable> r102);

        public abstract int decrementAndGetRemainingCount(AggregateFutureState<?> r100);

        public /* synthetic */ AtomicHelper(AnonymousClass1 r100) {
            this();
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicIntegerFieldUpdater<AggregateFutureState<?>> remainingCountUpdater;
        final AtomicReferenceFieldUpdater<AggregateFutureState<?>, Set<Throwable>> seenExceptionsUpdater;

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int decrementAndGetRemainingCount(AggregateFutureState<?> r100) {
            return this.remainingCountUpdater.decrementAndGet(r100);
        }

        public SafeAtomicHelper(AtomicReferenceFieldUpdater r100, AtomicIntegerFieldUpdater r101) {
            super(null);
            this.seenExceptionsUpdater = r100;
            this.remainingCountUpdater = r101;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void compareAndSetSeenExceptions(AggregateFutureState<?> r100, @CheckForNull Set<Throwable> r101, Set<Throwable> r102) {
            AtomicReferenceFieldUpdater<AggregateFutureState<?>, Set<Throwable>> r103 = this.seenExceptionsUpdater;
        L4:
            if (r103.compareAndSet(r100, r101, r102) == true) goto L8;
            if (r103.get(r100) == r101) goto L4;
            return;
        }
    }

    public static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super(null);
        }

        public /* synthetic */ SynchronizedAtomicHelper(AnonymousClass1 r100) {
            this();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int decrementAndGetRemainingCount(AggregateFutureState<?> r100) {
            monitor-enter(r100);
            int r101 = AggregateFutureState.access$306(r100);     // Catch: Throwable -> L6
            monitor-exit(r100);     // Catch: Throwable -> L6
            return r101;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void compareAndSetSeenExceptions(AggregateFutureState<?> r100, @CheckForNull Set<Throwable> r101, Set<Throwable> r102) {
            monitor-enter(r100);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (AggregateFutureState.access$200(r100) != r101) goto L6;
            AggregateFutureState.access$202(r100, r102);     // Catch: Throwable -> L8
        L6:
            monitor-exit(r100);     // Catch: Throwable -> L8
        }
    }

    public abstract void addInitialException(Set<Throwable> r100);

    public final void clearSeenExceptions() {
        this.seenExceptions = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        log = Logger.getLogger(AggregateFutureState.class.getName());
        Throwable r100 = null;
        Object[] r101 = 0;
        AtomicHelper r102 = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining"));     // Catch: Error -> L5 Throwable -> L7
    L9:
        ATOMIC_HELPER = r102;
        if (r100 == null) goto L15;
        log.log(Level.SEVERE, "SafeAtomicHelper is broken!", r100);
        return;
    L15:
        return;
    L7:
        e = move-exception;
        SynchronizedAtomicHelper r103 = new SynchronizedAtomicHelper(r101 == true ? 1 : 0);
        r100 = e;
        r102 = r103;
        goto L9
    }

    public final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
    }

    public final Set<Throwable> getOrInitSeenExceptions() {
        Set<Throwable> r100 = this.seenExceptions;
        if (r100 != null) goto L6;
        Set<Throwable> r101 = Collections.newSetFromMap(new ConcurrentHashMap());
        addInitialException(r101);
        ATOMIC_HELPER.compareAndSetSeenExceptions(this, null, r101);
        Set<Throwable> r102 = this.seenExceptions;
        Objects.requireNonNull(r102);
        return r102;
    L6:
        return r100;
    }

    public AggregateFutureState(int r100) {
        this.seenExceptions = null;
        this.remaining = r100;
    }

    public static /* synthetic */ Set access$200(AggregateFutureState r100) {
        return r100.seenExceptions;
    }

    public static /* synthetic */ int access$306(AggregateFutureState r100) {
        int r101 = r100.remaining - 1;
        r100.remaining = r101;
        return r101;
    }

    public static /* synthetic */ Set access$202(AggregateFutureState r100, Set r101) {
        r100.seenExceptions = r101;
        return r101;
    }
}
