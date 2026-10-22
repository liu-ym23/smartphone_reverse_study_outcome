package com.google.common.util.concurrent;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractScheduledService implements Service {
    private static final Logger logger = null;
    private final AbstractService delegate;

    public interface Cancellable {
        void cancel(boolean r100);

        boolean isCancelled();
    }

    public static abstract class CustomScheduler extends Scheduler {

        public final class ReschedulableCallable implements Callable<Void> {

            @CheckForNull
            private SupplantableFuture cancellationDelegate;
            private final ScheduledExecutorService executor;
            private final ReentrantLock lock;
            private final AbstractService service;
            final /* synthetic */ CustomScheduler this$0;
            private final Runnable wrappedRunnable;

            @Override // java.util.concurrent.Callable
            @CheckForNull
            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public Void call2() throws Exception {
                this.wrappedRunnable.run();
                reschedule();
                return null;
            }

            public Cancellable reschedule() {
                Schedule r100 = this.this$0.getNextSchedule();     // Catch: Throwable -> L19
                this.lock.lock();
                Cancellable r101 = initializeOrUpdateCancellationDelegate(r100);     // Catch: Throwable -> L6 Throwable -> L8 RuntimeException -> L10
                this.lock.unlock();
                Throwable r102 = null;
            L14:
                if (r102 == null) goto L16;
                this.service.notifyFailed(r102);
            L16:
                return r101;
            L6:
                th = move-exception;
                this.lock.unlock();
                throw th;
            L8:
                e = move-exception;
                r102 = e;
                r101 = new FutureAsCancellable(Futures.immediateCancelledFuture());     // Catch: Throwable -> L6
                this.lock.unlock();
            L19:
                th = move-exception;
                Platform.restoreInterruptIfIsInterruptedException(th);
                this.service.notifyFailed(th);
                return new FutureAsCancellable(Futures.immediateCancelledFuture());
            }

            @Override // java.util.concurrent.Callable
            @CheckForNull
            public /* bridge */ /* synthetic */ Void call() throws Exception {
                return call2();
            }

            private Cancellable initializeOrUpdateCancellationDelegate(Schedule r100) {
                SupplantableFuture r101 = this.cancellationDelegate;
                if (r101 != null) goto L7;
                SupplantableFuture r102 = new SupplantableFuture(this.lock, submitToExecutor(r100));
                this.cancellationDelegate = r102;
                return r102;
            L7:
                if (SupplantableFuture.access$600(r101).isCancelled() == true) goto L10;
                SupplantableFuture.access$602(this.cancellationDelegate, submitToExecutor(r100));
            L10:
                return this.cancellationDelegate;
            }

            private ScheduledFuture<Void> submitToExecutor(Schedule r100) {
                return this.executor.schedule(this, Schedule.access$700(r100), Schedule.access$800(r100));
            }

            public ReschedulableCallable(CustomScheduler r100, AbstractService r101, ScheduledExecutorService r102, Runnable r103) {
                this.this$0 = r100;
                this.lock = new ReentrantLock();
                this.wrappedRunnable = r103;
                this.executor = r102;
                this.service = r101;
            }
        }

        public static final class Schedule {
            private final long delay;
            private final TimeUnit unit;

            public static /* synthetic */ long access$700(Schedule r100) {
                return r100.delay;
            }

            public static /* synthetic */ TimeUnit access$800(Schedule r100) {
                return r100.unit;
            }

            public Schedule(long r100, TimeUnit r101) {
                this.delay = r100;
                r101.getClass();
                this.unit = r101;
            }
        }

        public static final class SupplantableFuture implements Cancellable {
            private Future<Void> currentFuture;
            private final ReentrantLock lock;

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public boolean isCancelled() {
                this.lock.lock();
                boolean r100 = this.currentFuture.isCancelled();     // Catch: Throwable -> L6
                this.lock.unlock();
                return r100;
            L6:
                th = move-exception;
                this.lock.unlock();
                throw th;
            }

            public static /* synthetic */ Future access$600(SupplantableFuture r100) {
                return r100.currentFuture;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public void cancel(boolean r100) {
                this.lock.lock();
                this.currentFuture.cancel(r100);     // Catch: Throwable -> L6
                this.lock.unlock();
                return;
            L6:
                th = move-exception;
                this.lock.unlock();
                throw th;
            }

            public SupplantableFuture(ReentrantLock r100, Future<Void> r101) {
                this.lock = r100;
                this.currentFuture = r101;
            }

            public static /* synthetic */ Future access$602(SupplantableFuture r100, Future r101) {
                r100.currentFuture = r101;
                return r101;
            }
        }

        public CustomScheduler() {
            super(null);
        }

        public abstract Schedule getNextSchedule() throws Exception;

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        public final Cancellable schedule(AbstractService r100, ScheduledExecutorService r101, Runnable r102) {
            return new ReschedulableCallable(this, r100, r101, r102).reschedule();
        }
    }

    public static final class FutureAsCancellable implements Cancellable {
        private final Future<?> delegate;

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        public FutureAsCancellable(Future<?> r100) {
            this.delegate = r100;
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public void cancel(boolean r100) {
            this.delegate.cancel(r100);
        }
    }

    public static abstract class Scheduler {
        private Scheduler() {
        }

        public abstract Cancellable schedule(AbstractService r100, ScheduledExecutorService r101, Runnable r102);

        public /* synthetic */ Scheduler(AnonymousClass1 r100) {
            this();
        }

        public static Scheduler newFixedDelaySchedule(final long r100, final long r110, final TimeUnit r111) {
            r111.getClass();
            if (r110 <= 0) goto L5;
            boolean r101 = true;
        L6:
            com.google.common.base.m.f(r101, "delay must be > 0, found %s", r110);
            return new AnonymousClass1(r100, r110, r111);
        L5:
            r101 = false;
            goto L6
        }

        public static Scheduler newFixedRateSchedule(final long r100, final long r110, final TimeUnit r111) {
            r111.getClass();
            if (r110 <= 0) goto L5;
            boolean r101 = true;
        L6:
            com.google.common.base.m.f(r101, "period must be > 0, found %s", r110);
            return new AnonymousClass2(r100, r110, r111);
        L5:
            r101 = false;
            goto L6
        }
    }

    public final class ServiceDelegate extends AbstractService {

        @CheckForNull
        private volatile ScheduledExecutorService executorService;
        private final ReentrantLock lock;

        @CheckForNull
        private volatile Cancellable runningTask;
        private final Runnable task;
        final /* synthetic */ AbstractScheduledService this$0;

        public class Task implements Runnable {
            final /* synthetic */ ServiceDelegate this$1;

            @Override // java.lang.Runnable
            public void run() {
                com_google_common_util_concurrent_AbstractScheduledService$ServiceDelegate$Task_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_google_common_util_concurrent_AbstractScheduledService$ServiceDelegate$Task__run$___twin___() {
                ServiceDelegate.access$200(this.this$1).lock();
                Cancellable r100 = ServiceDelegate.access$300(this.this$1);     // Catch: Throwable -> L9
                Objects.requireNonNull(r100);     // Catch: Throwable -> L9
                if (r100.isCancelled() == false) goto L7;
                ServiceDelegate.access$200(this.this$1).unlock();
                return;
            L7:
                this.this$1.this$0.runOneIteration();     // Catch: Throwable -> L9
            L8:
                ServiceDelegate.access$200(this.this$1).unlock();
                return;
            L9:
                th = move-exception;
                Platform.restoreInterruptIfIsInterruptedException(th);     // Catch: Throwable -> L18
                this.this$1.this$0.shutDown();     // Catch: Exception -> L13 Throwable -> L18
            L15:
                this.this$1.notifyFailed(th);     // Catch: Throwable -> L18
                Cancellable r101 = ServiceDelegate.access$300(this.this$1);     // Catch: Throwable -> L18
                Objects.requireNonNull(r101);     // Catch: Throwable -> L18
                r101.cancel(false);     // Catch: Throwable -> L18
                goto L8
            L13:
                e = move-exception;
                Platform.restoreInterruptIfIsInterruptedException(e);     // Catch: Throwable -> L18
                AbstractScheduledService.access$400().log(Level.WARNING, "Error while attempting to shut down the service after failure.", e);     // Catch: Throwable -> L18
            L18:
                th = move-exception;
                ServiceDelegate.access$200(this.this$1).unlock();
                throw th;
            }

            public Task(ServiceDelegate r100) {
                this.this$1 = r100;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_google_common_util_concurrent_AbstractScheduledService$ServiceDelegate$Task_com_larus_apm_impl_protector_RunnableLancet_run(Task r100) {
                r100.com_google_common_util_concurrent_AbstractScheduledService$ServiceDelegate$Task__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static /* synthetic */ void a(ServiceDelegate r100) {
            r100.lambda$doStop$2();
        }

        public static /* synthetic */ void b(ServiceDelegate r100) {
            r100.lambda$doStart$1();
        }

        public static /* synthetic */ String c(ServiceDelegate r100) {
            return r100.lambda$doStart$0();
        }

        private /* synthetic */ String lambda$doStart$0() {
            return this.this$0.serviceName() + " " + state();
        }

        private /* synthetic */ void lambda$doStart$1() {
            this.lock.lock();
            this.this$0.startUp();     // Catch: Throwable -> L5
            Objects.requireNonNull(this.executorService);     // Catch: Throwable -> L5
            this.runningTask = this.this$0.scheduler().schedule(AbstractScheduledService.access$500(this.this$0), this.executorService, this.task);     // Catch: Throwable -> L5
            notifyStarted();     // Catch: Throwable -> L5
        L9:
            this.lock.unlock();
            return;
        L5:
            th = move-exception;
            Platform.restoreInterruptIfIsInterruptedException(th);     // Catch: Throwable -> L11
            notifyFailed(th);     // Catch: Throwable -> L11
            if (this.runningTask == null) goto L9;
            this.runningTask.cancel(false);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }

        private /* synthetic */ void lambda$doStop$2() {
            this.lock.lock();     // Catch: Throwable -> L12
        L9:
            th = move-exception;
            this.lock.unlock();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L4:
            if (state() == Service.State.STOPPING) goto L7;
            this.lock.unlock();     // Catch: Throwable -> L12
            return;
        L7:
            this.this$0.shutDown();     // Catch: Throwable -> L9
            this.lock.unlock();     // Catch: Throwable -> L12
            notifyStopped();     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            Platform.restoreInterruptIfIsInterruptedException(th);
            notifyFailed(th);
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            this.executorService = MoreExecutors.renamingDecorator(this.this$0.executor(), new i(this));
            this.executorService.execute(new j(this));
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStop() {
            Objects.requireNonNull(this.runningTask);
            Objects.requireNonNull(this.executorService);
            this.runningTask.cancel(false);
            this.executorService.execute(new h(this));
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return this.this$0.toString();
        }

        private ServiceDelegate(AbstractScheduledService r100) {
            this.this$0 = r100;
            this.lock = new ReentrantLock();
            this.task = new Task(this);
        }

        public static /* synthetic */ ReentrantLock access$200(ServiceDelegate r100) {
            return r100.lock;
        }

        public static /* synthetic */ Cancellable access$300(ServiceDelegate r100) {
            return r100.runningTask;
        }

        public /* synthetic */ ServiceDelegate(AbstractScheduledService r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public abstract void runOneIteration() throws Exception;

    public abstract Scheduler scheduler();

    public void shutDown() throws Exception {
    }

    public void startUp() throws Exception {
    }

    static {
        logger = Logger.getLogger(AbstractScheduledService.class.getName());
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public ScheduledExecutorService executor() {
        final ScheduledExecutorService r100 = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new C1ThreadFactoryImpl(this));
        addListener(new AnonymousClass1(this, r100), MoreExecutors.directExecutor());
        return r100;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    public AbstractScheduledService() {
        this.delegate = new ServiceDelegate(this, null);
    }

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public static /* synthetic */ Logger access$400() {
        return logger;
    }

    public static /* synthetic */ AbstractService access$500(AbstractScheduledService r100) {
        return r100.delegate;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener r100, Executor r101) {
        this.delegate.addListener(r100, r101);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long r100, TimeUnit r101) throws TimeoutException {
        this.delegate.awaitRunning(r100, r101);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long r100, TimeUnit r101) throws TimeoutException {
        this.delegate.awaitTerminated(r100, r101);
    }
}
