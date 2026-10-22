package com.google.common.util.concurrent;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable DONE = null;
    private static final int MAX_BUSY_WAIT_SPINS = 1000;
    private static final Runnable PARKED = null;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.InterruptibleTask$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Blocker extends AbstractOwnableSynchronizer implements Runnable {
        private final InterruptibleTask<?> task;

        public void com_google_common_util_concurrent_InterruptibleTask$Blocker__run$___twin___() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com_google_common_util_concurrent_InterruptibleTask$Blocker_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public String toString() {
            return this.task.toString();
        }

        public Thread getOwner() {
            return getExclusiveOwnerThread();
        }

        private Blocker(InterruptibleTask<?> r100) {
            this.task = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_google_common_util_concurrent_InterruptibleTask$Blocker_com_larus_apm_impl_protector_RunnableLancet_run(Blocker r100) {
            r100.com_google_common_util_concurrent_InterruptibleTask$Blocker__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        private void setOwner(Thread r100) {
            setExclusiveOwnerThread(r100);
        }

        public /* synthetic */ Blocker(InterruptibleTask r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static /* synthetic */ void access$200(Blocker r100, Thread r101) {
            r100.setOwner(r101);
        }
    }

    public static final class DoNothingRunnable implements Runnable {
        private DoNothingRunnable() {
        }

        public void com_google_common_util_concurrent_InterruptibleTask$DoNothingRunnable__run$___twin___() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com_google_common_util_concurrent_InterruptibleTask$DoNothingRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public /* synthetic */ DoNothingRunnable(AnonymousClass1 r100) {
            this();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_google_common_util_concurrent_InterruptibleTask$DoNothingRunnable_com_larus_apm_impl_protector_RunnableLancet_run(DoNothingRunnable r100) {
            r100.com_google_common_util_concurrent_InterruptibleTask$DoNothingRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract void afterRanInterruptiblyFailure(Throwable r100);

    public abstract void afterRanInterruptiblySuccess(@ParametricNullness T r100);

    public abstract boolean isDone();

    @Override // java.lang.Runnable
    public final void run() {
        com_google_common_util_concurrent_InterruptibleTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @ParametricNullness
    public abstract T runInterruptibly() throws Exception;

    public abstract String toPendingString();

    static {
        AnonymousClass1 r100 = null;
        DONE = new DoNothingRunnable(r100);
        PARKED = new DoNothingRunnable(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void com_google_common_util_concurrent_InterruptibleTask__run$___twin___() {
        Thread r100 = ThreadMethodProxy.currentThread();
        Object r101 = null;
        if (compareAndSet(null, r100) == true) goto L5;
        return;
    L5:
        boolean r102 = !isDone();
        if (r102 == false) goto L24;
        r101 = runInterruptibly();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Platform.restoreInterruptIfIsInterruptedException(th);     // Catch: Throwable -> L16
        if (compareAndSet(r100, DONE) == true) goto L14;
        waitForInterrupt(r100);
    L14:
        if (r102 == false) goto L33;
        afterRanInterruptiblyFailure(th);
        return;
    L33:
        return;
    L16:
        th = move-exception;
        if (compareAndSet(r100, DONE) == true) goto L20;
        waitForInterrupt(r100);
    L20:
        if (r102 == false) goto L22;
        afterRanInterruptiblySuccess(NullnessCasts.uncheckedCastNullableTToT(null));
    L22:
        throw th;
    L24:
        if (compareAndSet(r100, DONE) == true) goto L26;
        waitForInterrupt(r100);
    L26:
        if (r102 == false) goto L35;
        afterRanInterruptiblySuccess(NullnessCasts.uncheckedCastNullableTToT(r101));
        return;
    }

    public final void interruptTask() {
        Runnable r100 = get();
        if ((r100 instanceof Thread) == false) goto L15;
        Blocker r101 = new Blocker(this, null);
        Blocker.access$200(r101, ThreadMethodProxy.currentThread());
        if (compareAndSet(r100, r101) == false) goto L18;
        ((Thread) r100).interrupt();     // Catch: Throwable -> L10
        if (getAndSet(DONE) != PARKED) goto L19;
        LockSupport.unpark(ThreadMethodProxy.getAttachThread((Thread) r100));
        return;
    L19:
        return;
    L10:
        th = move-exception;
        if (getAndSet(DONE) != PARKED) goto L14;
        LockSupport.unpark(ThreadMethodProxy.getAttachThread((Thread) r100));
    L14:
        throw th;
    L18:
        return;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        Runnable r100 = get();
        if (r100 != DONE) goto L6;
        String r101 = "running=[DONE]";
    L13:
        return r101 + ", " + toPendingString();
    L6:
        if ((r100 instanceof Blocker) == false) goto L9;
        r101 = "running=[INTERRUPTED]";
        goto L13
    L9:
        if ((r100 instanceof Thread) == false) goto L11;
        r101 = "running=[RUNNING ON " + ((Thread) r100).getName() + "]";
        goto L13
    L11:
        r101 = "running=[NOT STARTED YET]";
        goto L13
    }

    public InterruptibleTask() {
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_google_common_util_concurrent_InterruptibleTask_com_larus_apm_impl_protector_RunnableLancet_run(InterruptibleTask r100) {
        r100.com_google_common_util_concurrent_InterruptibleTask__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private void waitForInterrupt(Thread r100) {
        Runnable r101 = get();
        Blocker r102 = null;
        boolean r103 = false;
        int r104 = 0;
    L3:
        boolean r105 = r101 instanceof Blocker;
        if (r105 == false) goto L6;
    L11:
        if (r105 == false) goto L13;
        r102 = (Blocker) r101;
    L13:
        r104 = r104 + 1;
        if (r104 <= 1000) goto L26;
        Runnable r106 = PARKED;
        if (r101 == r106) goto L20;
        if (compareAndSet(r101, r106) == true) goto L20;
    L27:
        r101 = get();
    L20:
        if (Thread.interrupted() == true) goto L24;
        if (r103 == true) goto L24;
        r103 = false;
    L25:
        LockSupport.park(r102);
    L24:
        r103 = true;
        goto L25
    L26:
        Thread.yield();
        goto L27
    L6:
        if (r101 == PARKED) goto L11;
        if (r103 == false) goto L32;
        r100.interrupt();
        return;
    }
}
