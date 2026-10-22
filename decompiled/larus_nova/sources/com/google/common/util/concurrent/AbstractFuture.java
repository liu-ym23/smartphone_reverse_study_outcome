package com.google.common.util.concurrent;

import com.byted.cast.common.TeaEventTrack;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import me.ele.lancet.base.annotations.Skip;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {
    private static final AtomicHelper ATOMIC_HELPER = null;
    static final boolean GENERATE_CANCELLATION_CAUSES = false;
    private static final Object NULL = null;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log = null;

    @CheckForNull
    private volatile Listener listeners;

    @CheckForNull
    private volatile Object value;

    @CheckForNull
    private volatile Waiter waiters;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractFuture$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract boolean casListeners(AbstractFuture<?> r100, @CheckForNull Listener r101, Listener r102);

        public abstract boolean casValue(AbstractFuture<?> r100, @CheckForNull Object r101, Object r102);

        public abstract boolean casWaiters(AbstractFuture<?> r100, @CheckForNull Waiter r101, @CheckForNull Waiter r102);

        public abstract Listener gasListeners(AbstractFuture<?> r100, Listener r101);

        public abstract Waiter gasWaiters(AbstractFuture<?> r100, Waiter r101);

        public abstract void putNext(Waiter r100, @CheckForNull Waiter r101);

        public abstract void putThread(Waiter r100, Thread r101);

        public /* synthetic */ AtomicHelper(AnonymousClass1 r100) {
            this();
        }
    }

    public static final class Cancellation {

        @CheckForNull
        static final Cancellation CAUSELESS_CANCELLED = null;

        @CheckForNull
        static final Cancellation CAUSELESS_INTERRUPTED = null;

        @CheckForNull
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES == false) goto L5;
            CAUSELESS_CANCELLED = null;
            CAUSELESS_INTERRUPTED = null;
            return;
        L5:
            CAUSELESS_CANCELLED = new Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new Cancellation(true, null);
        }

        public Cancellation(boolean r100, @CheckForNull Throwable r101) {
            this.wasInterrupted = r100;
            this.cause = r101;
        }
    }

    public static final class Failure {
        static final Failure FALLBACK_INSTANCE = null;
        final Throwable exception;

        static {
            final String r100 = "Failure occurred while trying to finish a future.";
            FALLBACK_INSTANCE = new Failure(new AnonymousClass1(r100));
        }

        public Failure(Throwable r100) {
            r100.getClass();
            this.exception = r100;
        }
    }

    public static final class Listener {
        static final Listener TOMBSTONE = null;

        @CheckForNull
        final Executor executor;

        @CheckForNull
        Listener next;

        @CheckForNull
        final Runnable task;

        static {
            TOMBSTONE = new Listener();
        }

        public Listener() {
            this.task = null;
            this.executor = null;
        }

        public Listener(Runnable r100, Executor r101) {
            this.task = r100;
            this.executor = r101;
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> listenersUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> waitersUpdater;

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public Listener gasListeners(AbstractFuture<?> r100, Listener r101) {
            return this.listenersUpdater.getAndSet(r100, r101);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public Waiter gasWaiters(AbstractFuture<?> r100, Waiter r101) {
            return this.waitersUpdater.getAndSet(r100, r101);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putNext(Waiter r100, @CheckForNull Waiter r101) {
            this.waiterNextUpdater.lazySet(r100, r101);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putThread(Waiter r100, Thread r101) {
            this.waiterThreadUpdater.lazySet(r100, r101);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casListeners(AbstractFuture<?> r100, @CheckForNull Listener r101, Listener r102) {
            AtomicReferenceFieldUpdater<AbstractFuture, Listener> r103 = this.listenersUpdater;
        L4:
            if (r103.compareAndSet(r100, r101, r102) == true) goto L5;
            if (r103.get(r100) == r101) goto L4;
            return false;
        L5:
            return true;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casValue(AbstractFuture<?> r100, @CheckForNull Object r101, Object r102) {
            AtomicReferenceFieldUpdater<AbstractFuture, Object> r103 = this.valueUpdater;
        L4:
            if (r103.compareAndSet(r100, r101, r102) == true) goto L5;
            if (r103.get(r100) == r101) goto L4;
            return false;
        L5:
            return true;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casWaiters(AbstractFuture<?> r100, @CheckForNull Waiter r101, @CheckForNull Waiter r102) {
            AtomicReferenceFieldUpdater<AbstractFuture, Waiter> r103 = this.waitersUpdater;
        L4:
            if (r103.compareAndSet(r100, r101, r102) == true) goto L5;
            if (r103.get(r100) == r101) goto L4;
            return false;
        L5:
            return true;
        }

        public SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> r100, AtomicReferenceFieldUpdater<Waiter, Waiter> r101, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> r102, AtomicReferenceFieldUpdater<AbstractFuture, Listener> r103, AtomicReferenceFieldUpdater<AbstractFuture, Object> r104) {
            super(null);
            this.waiterThreadUpdater = r100;
            this.waiterNextUpdater = r101;
            this.waitersUpdater = r102;
            this.listenersUpdater = r103;
            this.valueUpdater = r104;
        }
    }

    public static final class SetFuture<V> implements Runnable {
        final ListenableFuture<? extends V> future;
        final AbstractFuture<V> owner;

        @Override // java.lang.Runnable
        public void run() {
            com_google_common_util_concurrent_AbstractFuture$SetFuture_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_google_common_util_concurrent_AbstractFuture$SetFuture__run$___twin___() {
            if (AbstractFuture.access$300(this.owner) == this) goto L5;
            return;
        L5:
            Object r100 = AbstractFuture.access$400(this.future);
            if (AbstractFuture.access$200().casValue(this.owner, this, r100) == false) goto L9;
            AbstractFuture.access$500(this.owner, false);
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_google_common_util_concurrent_AbstractFuture$SetFuture_com_larus_apm_impl_protector_RunnableLancet_run(SetFuture r100) {
            r100.com_google_common_util_concurrent_AbstractFuture$SetFuture__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public SetFuture(AbstractFuture<V> r100, ListenableFuture<? extends V> r101) {
            this.owner = r100;
            this.future = r101;
        }
    }

    public static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super(null);
        }

        public /* synthetic */ SynchronizedHelper(AnonymousClass1 r100) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public Listener gasListeners(AbstractFuture<?> r100, Listener r101) {
            monitor-enter(r100);
            Listener r102 = AbstractFuture.access$700(r100);     // Catch: Throwable -> L8
            if (r102 == r101) goto L6;
            AbstractFuture.access$702(r100, r101);     // Catch: Throwable -> L8
        L6:
            monitor-exit(r100);     // Catch: Throwable -> L8
            return r102;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public Waiter gasWaiters(AbstractFuture<?> r100, Waiter r101) {
            monitor-enter(r100);
            Waiter r102 = AbstractFuture.access$800(r100);     // Catch: Throwable -> L8
            if (r102 == r101) goto L6;
            AbstractFuture.access$802(r100, r101);     // Catch: Throwable -> L8
        L6:
            monitor-exit(r100);     // Catch: Throwable -> L8
            return r102;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putNext(Waiter r100, @CheckForNull Waiter r101) {
            r100.next = r101;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putThread(Waiter r100, Thread r101) {
            r100.thread = r101;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casListeners(AbstractFuture<?> r100, @CheckForNull Listener r101, Listener r102) {
            monitor-enter(r100);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (AbstractFuture.access$700(r100) != r101) goto L9;
            AbstractFuture.access$702(r100, r102);     // Catch: Throwable -> L12
            monitor-exit(r100);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L12
            return false;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casValue(AbstractFuture<?> r100, @CheckForNull Object r101, Object r102) {
            monitor-enter(r100);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (AbstractFuture.access$300(r100) != r101) goto L9;
            AbstractFuture.access$302(r100, r102);     // Catch: Throwable -> L12
            monitor-exit(r100);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L12
            return false;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casWaiters(AbstractFuture<?> r100, @CheckForNull Waiter r101, @CheckForNull Waiter r102) {
            monitor-enter(r100);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (AbstractFuture.access$800(r100) != r101) goto L9;
            AbstractFuture.access$802(r100, r102);     // Catch: Throwable -> L12
            monitor-exit(r100);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L12
            return false;
        }
    }

    public interface Trusted<V> extends ListenableFuture<V> {
    }

    public static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @ParametricNullness
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        public TrustedFuture() {
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean r100) {
            return super.cancel(r100);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable r100, Executor r101) {
            super.addListener(r100, r101);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @ParametricNullness
        public final V get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(r100, r101);
        }
    }

    public static final class UnsafeAtomicHelper extends AtomicHelper {
        static final long LISTENERS_OFFSET = 0;
        static final Unsafe UNSAFE = null;
        static final long VALUE_OFFSET = 0;
        static final long WAITERS_OFFSET = 0;
        static final long WAITER_NEXT_OFFSET = 0;
        static final long WAITER_THREAD_OFFSET = 0;

        private UnsafeAtomicHelper() {
            super(null);
        }

        static {
            Unsafe r100 = Unsafe.getUnsafe();     // Catch: SecurityException -> L4
        L17:
            WAITERS_OFFSET = r100.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));     // Catch: RuntimeException -> L7 NoSuchFieldException -> L9
            LISTENERS_OFFSET = r100.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));     // Catch: RuntimeException -> L7 NoSuchFieldException -> L9
            VALUE_OFFSET = r100.objectFieldOffset(AbstractFuture.class.getDeclaredField("value"));     // Catch: RuntimeException -> L7 NoSuchFieldException -> L9
            WAITER_THREAD_OFFSET = r100.objectFieldOffset(Waiter.class.getDeclaredField("thread"));     // Catch: RuntimeException -> L7 NoSuchFieldException -> L9
            WAITER_NEXT_OFFSET = r100.objectFieldOffset(Waiter.class.getDeclaredField(TeaEventTrack.ACTION_DRAMA_NEXT));     // Catch: RuntimeException -> L7 NoSuchFieldException -> L9
            UNSAFE = r100;     // Catch: RuntimeException -> L7 NoSuchFieldException -> L9
            return;
        L9:
            e = move-exception;
            throw new RuntimeException(e);
        L7:
            e = move-exception;
            throw e;
        L4:
            r100 = (Unsafe) AccessController.doPrivileged(new AnonymousClass1());     // Catch: PrivilegedActionException -> L12
        L12:
            e = move-exception;
            throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }

        public /* synthetic */ UnsafeAtomicHelper(AnonymousClass1 r100) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public Listener gasListeners(AbstractFuture<?> r100, Listener r101) {
        L2:
            Listener r102 = AbstractFuture.access$700(r100);
            if (r101 == r102) goto L4;
            if (casListeners(r100, r102, r101) == false) goto L2;
            return r102;
        L4:
            return r102;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public Waiter gasWaiters(AbstractFuture<?> r100, Waiter r101) {
        L2:
            Waiter r102 = AbstractFuture.access$800(r100);
            if (r101 == r102) goto L4;
            if (casWaiters(r100, r102, r101) == false) goto L2;
            return r102;
        L4:
            return r102;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putNext(Waiter r100, @CheckForNull Waiter r101) {
            UNSAFE.putObject(r100, WAITER_NEXT_OFFSET, r101);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putThread(Waiter r100, Thread r101) {
            UNSAFE.putObject(r100, WAITER_THREAD_OFFSET, r101);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casListeners(AbstractFuture<?> r100, @CheckForNull Listener r101, Listener r102) {
            return d.a(UNSAFE, r100, LISTENERS_OFFSET, r101, r102);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casValue(AbstractFuture<?> r100, @CheckForNull Object r101, Object r102) {
            return d.a(UNSAFE, r100, VALUE_OFFSET, r101, r102);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casWaiters(AbstractFuture<?> r100, @CheckForNull Waiter r101, @CheckForNull Waiter r102) {
            return d.a(UNSAFE, r100, WAITERS_OFFSET, r101, r102);
        }
    }

    public static final class Waiter {
        static final Waiter TOMBSTONE = null;

        @CheckForNull
        volatile Waiter next;

        @CheckForNull
        volatile Thread thread;

        public Waiter(boolean r100) {
        }

        static {
            TOMBSTONE = new Waiter(false);
        }

        public void unpark() {
            Thread r100 = this.thread;
            if (r100 == null) goto L6;
            this.thread = null;
            LockSupport.unpark(ThreadMethodProxy.getAttachThread(r100));
            return;
        }

        public Waiter() {
            AbstractFuture.access$200().putThread(this, ThreadMethodProxy.currentThread());
        }

        public void setNext(@CheckForNull Waiter r100) {
            AbstractFuture.access$200().putNext(this, r100);
        }
    }

    public void afterDone() {
    }

    public void interruptTask() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.common.util.concurrent.AbstractFuture$1] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.logging.Logger] */
    static {
        boolean r100 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));     // Catch: SecurityException -> L4
    L5:
        GENERATE_CANCELLATION_CAUSES = r100;
        log = Logger.getLogger(AbstractFuture.class.getName());
        ?? r101 = 0;
        r101 = 0;
        AtomicHelper r102 = new UnsafeAtomicHelper(r101);     // Catch: Error -> L8 Throwable -> L10
        e = null;
    L17:
        ATOMIC_HELPER = r102;
        if (r101 == 0) goto L20;
        ?? r103 = log;
        Level r104 = Level.SEVERE;
        r103.log(r104, "UnsafeAtomicHelper is broken!", e);
        r103.log(r104, "SafeAtomicHelper is broken!", r101);
    L20:
        NULL = new Object();
        return;
    L10:
        e = e;
        r102 = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, TeaEventTrack.ACTION_DRAMA_NEXT), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));     // Catch: Error -> L13 Throwable -> L15
    L15:
        e = move-exception;
        r102 = new SynchronizedHelper(r101);
        r101 = e;
    L4:
        r100 = false;
        goto L5
    }

    private void releaseWaiters() {
        Waiter r100 = ATOMIC_HELPER.gasWaiters(this, Waiter.TOMBSTONE);
    L3:
        if (r100 == null) goto L5;
        r100.unpark();
        r100 = r100.next;
        goto L3
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object r100 = this.value;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L7:
        return (!(r100 instanceof SetFuture)) & r101;
    L5:
        r101 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public String pendingToString() {
        if ((this instanceof ScheduledFuture) == true) goto L5;
        return null;
    L5:
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.") == false) goto L5;
        r100.append(getClass().getSimpleName());
    L6:
        r100.append('@');
        r100.append(Integer.toHexString(System.identityHashCode(this)));
        r100.append("[status=");
        if (isCancelled() == false) goto L10;
        r100.append("CANCELLED");
    L13:
        r100.append("]");
        return r100.toString();
    L10:
        if (isDone() == false) goto L12;
        addDoneString(r100);
        goto L13
    L12:
        addPendingString(r100);
        goto L13
    L5:
        r100.append(getClass().getName());
        goto L6
    }

    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    @CheckForNull
    public final Throwable tryInternalFastPathGetFailure() {
        if ((this instanceof Trusted) == false) goto L8;
        Object r100 = this.value;
        if ((r100 instanceof Failure) == true) goto L7;
        return null;
    L7:
        return ((Failure) r100).exception;
    L8:
        return null;
    }

    public final boolean wasInterrupted() {
        Object r100 = this.value;
        if ((r100 instanceof Cancellation) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Cancellation) r100).wasInterrupted == false) goto L7;
        return true;
    }

    @Override // java.util.concurrent.Future
    @ParametricNullness
    public V get() throws InterruptedException, ExecutionException {
        if (Thread.interrupted() == true) goto L34;
        Object r100 = this.value;
        if (r100 == null) goto L7;
        boolean r101 = true;
    L9:
        if ((r101 & (!(r100 instanceof SetFuture))) == true) goto L11;
        Waiter r102 = this.waiters;
        if (r102 == Waiter.TOMBSTONE) goto L31;
        Waiter r103 = new Waiter();
    L15:
        r103.setNext(r102);
        if (ATOMIC_HELPER.casWaiters(this, r102, r103) == true) goto L17;
        r102 = this.waiters;
        if (r102 != Waiter.TOMBSTONE) goto L15;
    L17:
        LockSupport.park(this);
        if (Thread.interrupted() == true) goto L27;
        Object r104 = this.value;
        if (r104 == null) goto L22;
        boolean r105 = true;
    L24:
        if ((r105 & (!(r104 instanceof SetFuture))) == false) goto L17;
        return getDoneValue(r104);
    L22:
        r105 = false;
        goto L24
    L27:
        removeWaiter(r103);
        throw new InterruptedException();
    L31:
        Object r106 = this.value;
        Objects.requireNonNull(r106);
        return getDoneValue(r106);
    L11:
        return getDoneValue(r100);
    L7:
        r101 = false;
        goto L9
    L34:
        throw new InterruptedException();
    }

    public AbstractFuture() {
    }

    public static /* synthetic */ AtomicHelper access$200() {
        return ATOMIC_HELPER;
    }

    public static /* synthetic */ Object access$300(AbstractFuture r100) {
        return r100.value;
    }

    public static /* synthetic */ Object access$400(ListenableFuture r100) {
        return getFutureValue(r100);
    }

    public static /* synthetic */ Listener access$700(AbstractFuture r100) {
        return r100.listeners;
    }

    public static /* synthetic */ Waiter access$800(AbstractFuture r100) {
        return r100.waiters;
    }

    private void addDoneString(StringBuilder r100) {
        Object r101 = getUninterruptibly(this);     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        r100.append("SUCCESS, result=[");     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        appendResultObject(r100, r101);     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        r100.append("]");     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
    L15:
        return;
    L7:
        r100.append("CANCELLED");
        return;
    L5:
        e = move-exception;
        r100.append("UNKNOWN, cause=[");
        r100.append(e.getClass());
        r100.append(" thrown from get()]");
        return;
    L8:
        e = move-exception;
        r100.append("FAILURE, cause=[");
        r100.append(e.getCause());
        r100.append("]");
    }

    private void addPendingString(StringBuilder r100) {
        int r101 = r100.length();
        r100.append("PENDING");
        Object r102 = this.value;
        if ((r102 instanceof SetFuture) == false) goto L25;
        r100.append(", setFuture=[");
        appendUserObject(r100, ((SetFuture) r102).future);
        r100.append("]");
    L22:
        if (isDone() == false) goto L27;
        r100.delete(r101, r100.length());
        addDoneString(r100);
        return;
    L27:
        return;
    L25:
        String r103 = pendingToString();     // Catch: Throwable -> L11 RuntimeException -> L13
        com.google.common.base.l.a r104 = com.google.common.base.l.f274724a;     // Catch: Throwable -> L11 RuntimeException -> L13
        if (r103 == null) goto L15;
        if (r103.isEmpty() == true) goto L15;
        boolean r105 = false;
    L16:
        if (r105 == false) goto L19;
        r103 = null;
    L19:
        if (r103 == null) goto L22;
        r100.append(", info=[");
        r100.append(r103);
        r100.append("]");
    L15:
        r105 = true;
    L11:
        e = move-exception;
        r103 = "Exception thrown from implementation: " + e.getClass();
        goto L19
    }

    @CheckForNull
    private Listener clearListeners(@CheckForNull Listener r100) {
        Listener r101 = ATOMIC_HELPER.gasListeners(this, Listener.TOMBSTONE);
        Listener r102 = r100;
        Listener r103 = r101;
    L3:
        if (r103 == null) goto L5;
        Listener r104 = r103.next;
        r103.next = r102;
        r102 = r103;
        r103 = r104;
        goto L3
    L5:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ParametricNullness
    private V getDoneValue(Object r100) throws ExecutionException {
        if ((r100 instanceof Cancellation) == true) goto L13;
        if ((r100 instanceof Failure) == true) goto L11;
        if (r100 == NULL) goto L9;
        return r100;
    L9:
        return (V) NullnessCasts.uncheckedNull();
    L11:
        throw new ExecutionException(((Failure) r100).exception);
    L13:
        throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) r100).cause);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Object getFutureValue(ListenableFuture<?> r100) {
        if ((r100 instanceof Trusted) == false) goto L15;
        Object r101 = ((AbstractFuture) r100).value;
        if ((r101 instanceof Cancellation) == false) goto L12;
        Cancellation r102 = (Cancellation) r101;
        if (r102.wasInterrupted == false) goto L12;
        if (r102.cause == null) goto L11;
        r101 = new Cancellation(false, r102.cause);
        goto L12
    L11:
        r101 = Cancellation.CAUSELESS_CANCELLED;
    L12:
        Objects.requireNonNull(r101);
        return r101;
    L15:
        if ((r100 instanceof InternalFutureFailureAccess) == false) goto L20;
        Throwable r103 = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) r100);
        if (r103 == null) goto L20;
        return new Failure(r103);
    L20:
        boolean r104 = r100.isCancelled();
        if (((!GENERATE_CANCELLATION_CAUSES) & r104) == false) goto L48;
        Cancellation r105 = Cancellation.CAUSELESS_CANCELLED;
        Objects.requireNonNull(r105);
        return r105;
    L48:
        Object r106 = getUninterruptibly(r100);     // Catch: Error -> L31 RuntimeException -> L33 CancellationException -> L36 ExecutionException -> L42
        if (r104 == true) goto L27;
        if (r106 == null) goto L30;
        return r106;
    L30:
        return NULL;
    L27:
        return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + r100));
    L31:
        e = e;
    L35:
        return new Failure(e);
    L36:
        e = move-exception;
        if (r104 == true) goto L41;
        return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + r100, e));
    L41:
        return new Cancellation(false, e);
    L33:
        e = e;
    L42:
        e = move-exception;
        if (r104 == false) goto L47;
        return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + r100, e));
    L47:
        return new Failure(e.getCause());
    }

    @ParametricNullness
    private static <V> V getUninterruptibly(Future<V> r100) throws ExecutionException {
        boolean r101 = false;
    L12:
        V r102 = r100.get();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r101 == false) goto L6;
        ThreadMethodProxy.currentThread().interrupt();
    L6:
        return r102;
    L11:
        r101 = true;
    L7:
        th = move-exception;
        if (r101 == false) goto L10;
        ThreadMethodProxy.currentThread().interrupt();
    L10:
        throw th;
    }

    private void removeWaiter(Waiter r100) {
        r100.thread = null;
    L3:
        Waiter r101 = this.waiters;
        if (r101 == Waiter.TOMBSTONE) goto L5;
        Waiter r102 = null;
    L7:
        if (r101 == null) goto L19;
        Waiter r103 = r101.next;
        if (r101.thread == null) goto L11;
        r102 = r101;
    L18:
        r101 = r103;
        goto L7
    L11:
        if (r102 == null) goto L16;
        r102.next = r103;
        if (r102.thread != null) goto L18;
    L16:
        if (ATOMIC_HELPER.casWaiters(this, r101, r103) == true) goto L18;
    L19:
        return;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r100) {
        Object r101 = this.value;
        if (r101 != null) goto L5;
        boolean r102 = true;
    L7:
        if ((r102 | (r101 instanceof SetFuture)) == true) goto L9;
        return false;
    L9:
        if (GENERATE_CANCELLATION_CAUSES == false) goto L11;
        Cancellation r103 = new Cancellation(r100, new CancellationException("Future.cancel() was called."));
    L15:
        boolean r104 = false;
        AbstractFuture<V> r105 = this;
    L17:
        if (ATOMIC_HELPER.casValue(r105, r101, r103) == true) goto L18;
        r101 = r105.value;
        if ((r101 instanceof SetFuture) == true) goto L17;
        return r104;
    L18:
        complete(r105, r100);
        if ((r101 instanceof SetFuture) == false) goto L46;
        ListenableFuture<? extends V> r106 = ((SetFuture) r101).future;
        if ((r106 instanceof Trusted) == false) goto L29;
        r105 = (AbstractFuture) r106;
        r101 = r105.value;
        if (r101 != null) goto L25;
        boolean r107 = true;
    L27:
        if ((r107 | (r101 instanceof SetFuture)) == false) goto L47;
        r104 = true;
        goto L17
    L47:
        return true;
    L25:
        r107 = false;
        goto L27
    L29:
        r106.cancel(r100);
        return true;
    L46:
        return true;
    L11:
        if (r100 == false) goto L13;
        r103 = Cancellation.CAUSELESS_INTERRUPTED;
    L14:
        Objects.requireNonNull(r103);
        goto L15
    L13:
        r103 = Cancellation.CAUSELESS_CANCELLED;
        goto L14
    L5:
        r102 = false;
        goto L7
    }

    final void maybePropagateCancellationTo(@CheckForNull Future<?> r100) {
        if (r100 == null) goto L4;
        boolean r101 = true;
    L6:
        if ((r101 & isCancelled()) == false) goto L9;
        r100.cancel(wasInterrupted());
        return;
    L9:
        return;
    L4:
        r101 = false;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean set(@ParametricNullness V r100) {
        if (r100 != null) goto L5;
        r100 = (V) NULL;
    L5:
        if (ATOMIC_HELPER.casValue(this, null, r100) == false) goto L8;
        complete(this, false);
        return true;
    L8:
        return false;
    }

    public boolean setException(Throwable r100) {
        r100.getClass();
        Failure r101 = new Failure(r100);
        if (ATOMIC_HELPER.casValue(this, null, r101) == false) goto L6;
        complete(this, false);
        return true;
    L6:
        return false;
    }

    public boolean setFuture(ListenableFuture<? extends V> r100) {
        r100.getClass();
        Object r101 = this.value;
        if (r101 != null) goto L25;
        if (r100.isDone() == false) goto L11;
        Object r102 = getFutureValue(r100);
        if (ATOMIC_HELPER.casValue(this, null, r102) == false) goto L10;
        complete(this, false);
        return true;
    L10:
        return false;
    L11:
        SetFuture r103 = new SetFuture(this, r100);
        if (ATOMIC_HELPER.casValue(this, null, r103) == true) goto L30;
        r101 = this.value;
        goto L25
    L30:
        r100.addListener(r103, DirectExecutor.INSTANCE);     // Catch: Error -> L15 Throwable -> L17
    L22:
        return true;
    L17:
        e = move-exception;
        Failure r104 = new Failure(e);     // Catch: Throwable -> L20
    L21:
        ATOMIC_HELPER.casValue(this, r103, r104);
    L20:
        r104 = Failure.FALLBACK_INSTANCE;
    L25:
        if ((r101 instanceof Cancellation) == false) goto L27;
        r100.cancel(((Cancellation) r101).wasInterrupted);
    L27:
        return false;
    }

    public static /* synthetic */ Object access$302(AbstractFuture r100, Object r101) {
        r100.value = r101;
        return r101;
    }

    public static /* synthetic */ void access$500(AbstractFuture r100, boolean r101) {
        complete(r100, r101);
    }

    public static /* synthetic */ Listener access$702(AbstractFuture r100, Listener r101) {
        r100.listeners = r101;
        return r101;
    }

    public static /* synthetic */ Waiter access$802(AbstractFuture r100, Waiter r101) {
        r100.waiters = r101;
        return r101;
    }

    private void appendResultObject(StringBuilder r100, @CheckForNull Object r101) {
        if (r101 != null) goto L4;
        r100.append("null");
        return;
    L4:
        if (r101 != this) goto L6;
        r100.append("this future");
        return;
    L6:
        r100.append(r101.getClass().getName());
        r100.append("@");
        r100.append(Integer.toHexString(System.identityHashCode(r101)));
    }

    private void appendUserObject(StringBuilder r100, @CheckForNull Object r101) {
        if (r101 != this) goto L4;
        r100.append("this future");     // Catch: StackOverflowError -> L6 Throwable -> L8
    L11:
        return;
    L4:
        r100.append(r101);     // Catch: StackOverflowError -> L6 Throwable -> L8
    L8:
        e = move-exception;
        r100.append("Exception thrown from implementation: ");
        r100.append(e.getClass());
    }

    private static CancellationException cancellationExceptionWithCause(String r100, @CheckForNull Throwable r101) {
        CancellationException r102 = new CancellationException(r100);
        r102.initCause(r101);
        return r102;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private static void complete(AbstractFuture<V> r100, boolean r101) {
        Listener r102 = null;
    L3:
        r100.releaseWaiters();
        if (r101 == false) goto L6;
        r100.interruptTask();
        r101 = false;
    L6:
        r100.afterDone();
        Listener r103 = r100.clearListeners(r102);
    L7:
        if (r103 == null) goto L17;
        r102 = r103.next;
        Runnable r104 = r103.task;
        Objects.requireNonNull(r104);
        Runnable r105 = r104;
        if ((r105 instanceof SetFuture) == false) goto L15;
        SetFuture r106 = (SetFuture) r105;
        r100 = r106.owner;
        if (((AbstractFuture) r100).value != r106) goto L16;
        Object r107 = getFutureValue(r106.future);
        if (ATOMIC_HELPER.casValue(r100, r106, r107) == true) goto L3;
    L16:
        r103 = r102;
        goto L7
    L15:
        Executor r108 = r103.executor;
        Objects.requireNonNull(r108);
        executeListener(r105, r108);
        goto L16
    }

    private static void executeListener(Runnable r100, Executor r101) {
        r101.execute(r100);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        log.log(Level.SEVERE, "RuntimeException while executing runnable " + r100 + " with executor " + r101, e);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r100, Executor r101) {
        com.google.common.base.m.l(r100, "Runnable was null.");
        com.google.common.base.m.l(r101, "Executor was null.");
        if (isDone() == true) goto L12;
        Listener r102 = this.listeners;
        if (r102 == Listener.TOMBSTONE) goto L12;
        Listener r103 = new Listener(r100, r101);
    L7:
        r103.next = r102;
        if (ATOMIC_HELPER.casListeners(this, r102, r103) == true) goto L9;
        r102 = this.listeners;
        if (r102 != Listener.TOMBSTONE) goto L7;
    L9:
        return;
    L12:
        executeListener(r100, r101);
    }

    @Override // java.util.concurrent.Future
    @ParametricNullness
    public V get(long r210, TimeUnit r211) throws InterruptedException, TimeoutException, ExecutionException {
        long r100 = r211.toNanos(r210);
        if (Thread.interrupted() == true) goto L81;
        Object r101 = this.value;
        if (r101 == null) goto L7;
        boolean r102 = true;
    L9:
        if ((r102 & (!(r101 instanceof SetFuture))) == false) goto L13;
        return getDoneValue(r101);
    L13:
        if (r100 <= 0) goto L15;
        long r110 = System.nanoTime() + r100;
    L17:
        if (r100 < 1000) goto L43;
        Waiter r103 = this.waiters;
        if (r103 == Waiter.TOMBSTONE) goto L40;
        Waiter r111 = new Waiter();
    L21:
        r111.setNext(r103);
        if (ATOMIC_HELPER.casWaiters(this, r103, r111) == true) goto L23;
        r103 = this.waiters;
        if (r103 != Waiter.TOMBSTONE) goto L21;
    L23:
        OverflowAvoidingLockSupport.parkNanos(this, r100);
        if (Thread.interrupted() == true) goto L36;
        Object r104 = this.value;
        if (r104 == null) goto L28;
        boolean r105 = true;
    L30:
        if ((r105 & (!(r104 instanceof SetFuture))) == true) goto L32;
        r100 = r110 - System.nanoTime();
        if (r100 >= 1000) goto L23;
        removeWaiter(r111);
        goto L43
    L32:
        return getDoneValue(r104);
    L28:
        r105 = false;
        goto L30
    L36:
        removeWaiter(r111);
        throw new InterruptedException();
    L40:
        Object r106 = this.value;
        Objects.requireNonNull(r106);
        return getDoneValue(r106);
    L43:
        if (r100 <= 0) goto L57;
        Object r107 = this.value;
        if (r107 == null) goto L47;
        boolean r108 = true;
    L49:
        if ((r108 & (!(r107 instanceof SetFuture))) == true) goto L51;
        if (Thread.interrupted() == true) goto L56;
        r100 = r110 - System.nanoTime();
        goto L43
    L56:
        throw new InterruptedException();
    L51:
        return getDoneValue(r107);
    L47:
        r108 = false;
        goto L49
    L57:
        String r109 = toString();
        String r112 = r211.toString();
        Locale r113 = Locale.ROOT;
        String r114 = r112.toLowerCase(r113);
        String r115 = "Waited " + r210 + " " + r211.toString().toLowerCase(r113);
        if ((r100 + 1000) >= 0) goto L75;
        String r116 = r115 + " (plus ";
        long r117 = -r100;
        long r118 = r211.convert(r117, TimeUnit.NANOSECONDS);
        long r119 = r117 - r211.toNanos(r118);
        if (r118 != 0) goto L62;
    L65:
        boolean r120 = true;
    L66:
        if (r118 <= 0) goto L71;
        String r121 = r116 + r118 + " " + r114;
        if (r120 == false) goto L70;
        r121 = r121 + ",";
    L70:
        r116 = r121 + " ";
    L71:
        if (r120 == false) goto L73;
        r116 = r116 + r119 + " nanoseconds ";
    L73:
        r115 = r116 + "delay)";
        goto L75
    L62:
        if (r119 > 1000) goto L65;
        r120 = false;
    L75:
        if (isDone() == false) goto L79;
        throw new TimeoutException(r115 + " but future completed as timeout expired");
    L79:
        throw new TimeoutException(r115 + " for " + r109);
    L15:
        r110 = 0;
        goto L17
    L7:
        r102 = false;
        goto L9
    L81:
        throw new InterruptedException();
    }
}
