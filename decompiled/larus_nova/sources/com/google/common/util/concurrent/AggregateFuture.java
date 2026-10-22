package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.z2;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class AggregateFuture<InputT, OutputT> extends AggregateFutureState<OutputT> {
    private static final Logger logger = null;
    private final boolean allMustSucceed;
    private final boolean collectsValues;

    @CheckForNull
    private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;

    public static final enum ReleaseResourcesReason extends Enum<ReleaseResourcesReason> {
        private static final /* synthetic */ ReleaseResourcesReason[] $VALUES = null;
        public static final ReleaseResourcesReason ALL_INPUT_FUTURES_PROCESSED = null;
        public static final ReleaseResourcesReason OUTPUT_FUTURE_DONE = null;

        private static /* synthetic */ ReleaseResourcesReason[] $values() {
            return new ReleaseResourcesReason[]{OUTPUT_FUTURE_DONE, ALL_INPUT_FUTURES_PROCESSED};
        }

        static {
            OUTPUT_FUTURE_DONE = new ReleaseResourcesReason("OUTPUT_FUTURE_DONE", 0);
            ALL_INPUT_FUTURES_PROCESSED = new ReleaseResourcesReason("ALL_INPUT_FUTURES_PROCESSED", 1);
            $VALUES = $values();
        }

        public static ReleaseResourcesReason[] values() {
            return (ReleaseResourcesReason[]) $VALUES.clone();
        }

        public static ReleaseResourcesReason valueOf(String r100) {
            return (ReleaseResourcesReason) r27.a.a(ReleaseResourcesReason.class, r100);
        }

        private ReleaseResourcesReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ void a(AggregateFuture r100, ListenableFuture r101, int r102) {
        r100.lambda$init$0(r101, r102);
    }

    public static /* synthetic */ void b(AggregateFuture r100, ImmutableCollection r101) {
        r100.lambda$init$1(r101);
    }

    public abstract void collectOneValue(int r100, @ParametricNullness InputT r101);

    public abstract void handleAllCompleted();

    static {
        logger = Logger.getLogger(AggregateFuture.class.getName());
    }

    public final void init() {
        Objects.requireNonNull(this.futures);
        if (this.futures.isEmpty() == false) goto L7;
        handleAllCompleted();
        return;
    L7:
        if (this.allMustSucceed == false) goto L13;
        z2<? extends ListenableFuture<? extends InputT>> r100 = this.futures.iterator();
        final int r101 = 0;
    L10:
        if (r100.hasNext() == false) goto L20;
        final ListenableFuture<? extends InputT> r102 = r100.next();
        int r103 = r101 + 1;
        r102.addListener(new k(this, r102, r101), MoreExecutors.directExecutor());
        r101 = r103;
        goto L10
    L20:
        return;
    L13:
        if (this.collectsValues == false) goto L15;
        final ImmutableCollection<? extends ListenableFuture<? extends InputT>> r104 = this.futures;
    L16:
        Runnable r105 = new l(this, r104);
        z2<? extends ListenableFuture<? extends InputT>> r106 = this.futures.iterator();
    L18:
        if (r106.hasNext() == false) goto L23;
        r106.next().addListener(r105, MoreExecutors.directExecutor());
        goto L18
    L23:
        return;
    L15:
        r104 = null;
        goto L16
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public final String pendingToString() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> r100 = this.futures;
        if (r100 == null) goto L7;
        return "futures=" + r100;
    L7:
        return super.pendingToString();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        super.afterDone();
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> r100 = this.futures;
        releaseResources(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        boolean r101 = isCancelled();
        if (r100 == null) goto L5;
        boolean r102 = true;
    L7:
        if ((r101 & r102) == false) goto L12;
        boolean r103 = wasInterrupted();
        z2<? extends ListenableFuture<? extends InputT>> r104 = r100.iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        r104.next().cancel(r103);
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        r102 = false;
        goto L7
    }

    private void decrementCountAndMaybeComplete(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> r100) {
        int r101 = decrementRemainingAndGet();
        if (r101 < 0) goto L5;
        boolean r102 = true;
    L6:
        com.google.common.base.m.p(r102, "Less than 0 remaining futures");
        if (r101 != 0) goto L10;
        processCompleted(r100);
        return;
    L10:
        return;
    L5:
        r102 = false;
        goto L6
    }

    private void handleException(Throwable r100) {
        r100.getClass();
        if (this.allMustSucceed == false) goto L11;
        if (setException(r100) == true) goto L11;
        if (addCausalChain(getOrInitSeenExceptions(), r100) == false) goto L11;
        log(r100);
        return;
    L11:
        if ((r100 instanceof Error) == false) goto L14;
        log(r100);
        return;
    }

    private /* synthetic */ void lambda$init$1(ImmutableCollection r100) {
        decrementCountAndMaybeComplete(r100);
    }

    private static void log(Throwable r100) {
        if ((r100 instanceof Error) == false) goto L5;
        String r101 = "Input Future failed with Error";
    L6:
        logger.log(Level.SEVERE, r101, r100);
        return;
    L5:
        r101 = "Got more than one input Future failure. Logging failures after the first";
        goto L6
    }

    private void processCompleted(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> r100) {
        if (r100 == null) goto L10;
        z2<? extends Future<? extends InputT>> r101 = r100.iterator();
        int r102 = 0;
    L5:
        if (r101.hasNext() == false) goto L10;
        Future<? extends InputT> r103 = r101.next();
        if (r103.isCancelled() == true) goto L9;
        collectValueFromNonCancelledFuture(r102, r103);
    L9:
        r102 = r102 + 1;
    L10:
        clearSeenExceptions();
        handleAllCompleted();
        releaseResources(ReleaseResourcesReason.ALL_INPUT_FUTURES_PROCESSED);
    }

    @Override // com.google.common.util.concurrent.AggregateFutureState
    public final void addInitialException(Set<Throwable> r100) {
        r100.getClass();
        if (isCancelled() == true) goto L6;
        Throwable r101 = tryInternalFastPathGetFailure();
        Objects.requireNonNull(r101);
        addCausalChain(r100, r101);
        return;
    }

    public void releaseResources(ReleaseResourcesReason r100) {
        r100.getClass();
        this.futures = null;
    }

    private static boolean addCausalChain(Set<Throwable> r100, Throwable r101) {
    L2:
        if (r101 == null) goto L8;
        if (r100.add(r101) == false) goto L5;
        r101 = r101.getCause();
        goto L2
    L5:
        return false;
    L8:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void collectValueFromNonCancelledFuture(int r100, Future<? extends InputT> r101) {
        collectOneValue(r100, Futures.getDone(r101));     // Catch: Error -> L4 RuntimeException -> L6 ExecutionException -> L8
    L14:
        return;
    L4:
        e = e;
    L7:
        handleException(e);
        return;
    L6:
        e = e;
    L8:
        e = move-exception;
        handleException(e.getCause());
    }

    private /* synthetic */ void lambda$init$0(ListenableFuture r100, int r101) {
    L9:
        th = move-exception;
        decrementCountAndMaybeComplete(null);
        throw th;
    L4:
        if (r100.isCancelled() == false) goto L6;
        this.futures = null;     // Catch: Throwable -> L9
        cancel(false);     // Catch: Throwable -> L9
    L7:
        decrementCountAndMaybeComplete(null);
        return;
    L6:
        collectValueFromNonCancelledFuture(r101, r100);     // Catch: Throwable -> L9
        goto L7
    }

    public AggregateFuture(ImmutableCollection<? extends ListenableFuture<? extends InputT>> r100, boolean r101, boolean r102) {
        super(r100.size());
        this.futures = r100;
        this.allMustSucceed = r101;
        this.collectsValues = r102;
    }
}
