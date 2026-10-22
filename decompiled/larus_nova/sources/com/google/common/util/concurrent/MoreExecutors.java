package com.google.common.util.concurrent;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.common.collect.Lists;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class MoreExecutors {

    public static class Application {
        public Application() {
        }

        public void addShutdownHook(Thread r100) {
            ThreadMethodProxy.addShutdownHook(Runtime.getRuntime(), r100);
        }

        public final ExecutorService getExitingExecutorService(ThreadPoolExecutor r100) {
            return getExitingExecutorService(r100, 120, TimeUnit.SECONDS);
        }

        public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor r100) {
            return getExitingScheduledExecutorService(r100, 120, TimeUnit.SECONDS);
        }

        public final void addDelayedShutdownHook(final ExecutorService r100, final long r110, final TimeUnit r111) {
            r100.getClass();
            r111.getClass();
            addShutdownHook(MoreExecutors.newThread("DelayedShutdownHook-for-" + r100, new AnonymousClass1(this, r100, r110, r111)));
        }

        public final ExecutorService getExitingExecutorService(ThreadPoolExecutor r100, long r101, TimeUnit r102) {
            MoreExecutors.access$000(r100);
            ExecutorService r103 = Executors.unconfigurableExecutorService(r100);
            addDelayedShutdownHook(r100, r101, r102);
            return r103;
        }

        public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor r100, long r101, TimeUnit r102) {
            MoreExecutors.access$000(r100);
            ScheduledExecutorService r103 = Executors.unconfigurableScheduledExecutorService(r100);
            addDelayedShutdownHook(r100, r101, r102);
            return r103;
        }
    }

    public static final class DirectExecutorService extends AbstractListeningExecutorService {
        private final Object lock;
        private int runningTasks;
        private boolean shutdown;

        private void endTask() {
            Object r100 = this.lock;
            monitor-enter(r100);
            int r101 = this.runningTasks - 1;     // Catch: Throwable -> L9
            this.runningTasks = r101;     // Catch: Throwable -> L9
            if (r101 != 0) goto L7;
            this.lock.notifyAll();     // Catch: Throwable -> L9
        L7:
            monitor-exit(r100);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private void startTask() {
            Object r100 = this.lock;
            monitor-enter(r100);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.shutdown == true) goto L10;
            this.runningTasks++;     // Catch: Throwable -> L11
            monitor-exit(r100);     // Catch: Throwable -> L11
            return;
        L10:
            throw new RejectedExecutionException("Executor already shutdown");     // Catch: Throwable -> L11
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            Object r100 = this.lock;
            monitor-enter(r100);
            boolean r101 = this.shutdown;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            Object r100 = this.lock;
            monitor-enter(r100);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.shutdown == true) goto L7;
        L9:
            boolean r101 = false;
        L10:
            monitor-exit(r100);     // Catch: Throwable -> L12
            return r101;
        L7:
            if (this.runningTasks != 0) goto L9;
            r101 = true;
            goto L10
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            Object r100 = this.lock;
            monitor-enter(r100);
            this.shutdown = true;     // Catch: Throwable -> L10
            if (this.runningTasks != 0) goto L8;
            this.lock.notifyAll();     // Catch: Throwable -> L10
        L8:
            monitor-exit(r100);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        private DirectExecutorService() {
            this.lock = new Object();
            this.runningTasks = 0;
            this.shutdown = false;
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }

        public /* synthetic */ DirectExecutorService(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            startTask();
            r100.run();     // Catch: Throwable -> L6
            endTask();
            return;
        L6:
            th = move-exception;
            endTask();
            throw th;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long r100, TimeUnit r101) throws InterruptedException {
            long r102 = r101.toNanos(r100);
            Object r103 = this.lock;
            monitor-enter(r103);
        L20:
        L17:
            th = move-exception;
            throw th;
        L5:
            if (this.shutdown == false) goto L12;
            if (this.runningTasks != 0) goto L12;
            monitor-exit(r103);     // Catch: Throwable -> L17
            return true;
        L12:
            if (r102 <= 0) goto L13;
            long r104 = System.nanoTime();     // Catch: Throwable -> L17
            TimeUnit.NANOSECONDS.timedWait(this.lock, r102);     // Catch: Throwable -> L17
            r102 = r102 - (System.nanoTime() - r104);     // Catch: Throwable -> L17
            goto L20
        L13:
            monitor-exit(r103);     // Catch: Throwable -> L17
            return false;
        }
    }

    public static class ListeningDecorator extends AbstractListeningExecutorService {
        private final ExecutorService delegate;

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.delegate.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.delegate.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.delegate.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.delegate.shutdownNow();
        }

        public final String toString() {
            return super.toString() + "[" + this.delegate + "]";
        }

        public ListeningDecorator(ExecutorService r100) {
            r100.getClass();
            this.delegate = r100;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            this.delegate.execute(r100);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long r100, TimeUnit r101) throws InterruptedException {
            return this.delegate.awaitTermination(r100, r101);
        }
    }

    public static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
        final ScheduledExecutorService delegate;

        public static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
            private final ScheduledFuture<?> scheduledDelegate;

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean r100) {
                boolean r101 = super.cancel(r100);
                if (r101 == false) goto L5;
                this.scheduledDelegate.cancel(r100);
            L5:
                return r101;
            }

            @Override // java.lang.Comparable
            public /* bridge */ /* synthetic */ int compareTo(Delayed r100) {
                return compareTo2(r100);
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit r100) {
                return this.scheduledDelegate.getDelay(r100);
            }

            /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
            public int compareTo2(Delayed r100) {
                return this.scheduledDelegate.compareTo(r100);
            }

            public ListenableScheduledTask(ListenableFuture<V> r100, ScheduledFuture<?> r101) {
                super(r100);
                this.scheduledDelegate = r101;
            }
        }

        public static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {
            private final Runnable delegate;

            @Override // java.lang.Runnable
            public void run() {
                com_google_common_util_concurrent_MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_google_common_util_concurrent_MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask__run$___twin___() {
                this.delegate.run();     // Catch: Error -> L4 Throwable -> L6
                return;
            L6:
                e = move-exception;
                setException(e);
                throw e;
            }

            @Override // com.google.common.util.concurrent.AbstractFuture
            public String pendingToString() {
                return "task=[" + this.delegate + "]";
            }

            public NeverSuccessfulListenableFutureTask(Runnable r100) {
                r100.getClass();
                this.delegate = r100;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_google_common_util_concurrent_MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask_com_larus_apm_impl_protector_RunnableLancet_run(NeverSuccessfulListenableFutureTask r100) {
                r100.com_google_common_util_concurrent_MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public ScheduledListeningDecorator(ScheduledExecutorService r100) {
            super(r100);
            r100.getClass();
            this.delegate = r100;
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> schedule(Runnable r100, long r101, TimeUnit r102) {
            TrustedListenableFutureTask r103 = TrustedListenableFutureTask.create(r100, null);
            return new ListenableScheduledTask(r103, this.delegate.schedule(r103, r101, r102));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public <V> ListenableScheduledFuture<V> schedule(Callable<V> r100, long r101, TimeUnit r102) {
            TrustedListenableFutureTask r103 = TrustedListenableFutureTask.create(r100);
            return new ListenableScheduledTask(r103, this.delegate.schedule(r103, r101, r102));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable r100, long r101, TimeUnit r102) {
            return schedule(r100, r101, r102);
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable r100, long r101, TimeUnit r102) {
            return schedule(r100, r101, r102);
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable r100, long r110, long r111, TimeUnit r112) {
            NeverSuccessfulListenableFutureTask r101 = new NeverSuccessfulListenableFutureTask(r100);
            return new ListenableScheduledTask(r101, this.delegate.scheduleAtFixedRate(r101, r110, r111, r112));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable r100, long r110, long r111, TimeUnit r112) {
            NeverSuccessfulListenableFutureTask r101 = new NeverSuccessfulListenableFutureTask(r100);
            return new ListenableScheduledTask(r101, this.delegate.scheduleWithFixedDelay(r101, r110, r111, r112));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable r100, long r101, long r102, TimeUnit r103) {
            return scheduleAtFixedRate(r100, r101, r102, r103);
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        public /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable r100, long r101, long r102, TimeUnit r103) {
            return scheduleWithFixedDelay(r100, r101, r102, r103);
        }
    }

    private MoreExecutors() {
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static boolean isAppEngineWithApiClasses() {
        if (System.getProperty("com.google.appengine.runtime.environment") != null) goto L11;
        return false;
    L11:
        INVOKESTATIC_com_google_common_util_concurrent_MoreExecutors_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.google.appengine.api.utils.SystemProperty");     // Catch: Throwable -> L10
        if (INVOKESTATIC_com_google_common_util_concurrent_MoreExecutors_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) == null) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public static ListeningExecutorService newDirectExecutorService() {
        return new DirectExecutorService(null);
    }

    public static ThreadFactory platformThreadFactory() {
        if (isAppEngineWithApiClasses() == false) goto L5;
        return (ThreadFactory) INVOKESTATIC_com_google_common_util_concurrent_MoreExecutors_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
    L22:
        e = move-exception;
        throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
    L25:
        e = move-exception;
        throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
    L19:
        e = move-exception;
        throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
    L8:
        e = move-exception;
        Throwable r100 = e.getCause();
        Object r101 = com.google.common.base.u.f274740a;
        r100.getClass();
        if ((r100 instanceof RuntimeException) == true) goto L18;
        if ((r100 instanceof Error) == true) goto L16;
        throw new RuntimeException(r100);
    L16:
        throw ((Error) r100);
    L18:
        throw ((RuntimeException) r100);
    L5:
        return Executors.defaultThreadFactory();
    }

    public static Executor directExecutor() {
        return DirectExecutor.INSTANCE;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_google_common_util_concurrent_MoreExecutors_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ void access$000(ThreadPoolExecutor r100) {
        useDaemonThreadFactory(r100);
    }

    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor r100) {
        return new Application().getExitingExecutorService(r100);
    }

    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor r100) {
        return new Application().getExitingScheduledExecutorService(r100);
    }

    public static ListeningExecutorService listeningDecorator(ExecutorService r100) {
        if ((r100 instanceof ListeningExecutorService) == false) goto L6;
        return (ListeningExecutorService) r100;
    L6:
        if ((r100 instanceof ScheduledExecutorService) == false) goto L8;
        ListeningExecutorService r101 = new ScheduledListeningDecorator((ScheduledExecutorService) r100);
    L10:
        return r101;
    L8:
        r101 = new ListeningDecorator(r100);
        goto L10
    }

    public static Executor newSequentialExecutor(Executor r100) {
        return new SequentialExecutor(r100);
    }

    private static void useDaemonThreadFactory(ThreadPoolExecutor r100) {
        r100.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(r100.getThreadFactory()).build());
    }

    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService r100) {
        if ((r100 instanceof ListeningScheduledExecutorService) == false) goto L6;
        return (ListeningScheduledExecutorService) r100;
    L6:
        return new ScheduledListeningDecorator(r100);
    }

    public static Thread newThread(String r100, Runnable r101) {
        r100.getClass();
        r101.getClass();
        Thread r102 = platformThreadFactory().newThread(r101);
        Objects.requireNonNull(r102);
        ThreadMethodProxy.setName(r102, r100);     // Catch: SecurityException -> L5
    L4:
        return r102;
    }

    public static Executor rejectionPropagatingExecutor(final Executor r100, final AbstractFuture<?> r101) {
        r100.getClass();
        r101.getClass();
        if (r100 != directExecutor()) goto L6;
        return r100;
    L6:
        return new AnonymousClass5(r100, r101);
    }

    public static Executor renamingDecorator(final Executor r100, final com.google.common.base.t<String> r101) {
        r100.getClass();
        r101.getClass();
        return new AnonymousClass2(r100, r101);
    }

    public static ExecutorService renamingDecorator(final ExecutorService r100, final com.google.common.base.t<String> r101) {
        r100.getClass();
        r101.getClass();
        return new AnonymousClass3(r100, r101);
    }

    public static ScheduledExecutorService renamingDecorator(final ScheduledExecutorService r100, final com.google.common.base.t<String> r101) {
        r100.getClass();
        r101.getClass();
        return new AnonymousClass4(r100, r101);
    }

    public static void addDelayedShutdownHook(ExecutorService r100, long r101, TimeUnit r102) {
        new Application().addDelayedShutdownHook(r100, r101, r102);
    }

    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor r100, long r101, TimeUnit r102) {
        return new Application().getExitingExecutorService(r100, r101, r102);
    }

    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor r100, long r101, TimeUnit r102) {
        return new Application().getExitingScheduledExecutorService(r100, r101, r102);
    }

    public static boolean shutdownAndAwaitTermination(ExecutorService r100, long r101, TimeUnit r102) {
        long r103 = r102.toNanos(r101) / 2;
        r100.shutdown();
        TimeUnit r104 = TimeUnit.NANOSECONDS;     // Catch: InterruptedException -> L7
        if (r100.awaitTermination(r103, r104) == true) goto L9;
        r100.shutdownNow();     // Catch: InterruptedException -> L7
        r100.awaitTermination(r103, r104);     // Catch: InterruptedException -> L7
    L9:
        return r100.isTerminated();
    L7:
        ThreadMethodProxy.currentThread().interrupt();
        r100.shutdownNow();
        goto L9
    }

    private static <T> ListenableFuture<T> submitAndAddQueueListener(ListeningExecutorService r100, Callable<T> r101, final BlockingQueue<Future<T>> r102) {
        final ListenableFuture<T> r103 = r100.submit(r101);
        r103.addListener(new AnonymousClass1(r102, r103), directExecutor());
        return r103;
    }

    @ParametricNullness
    public static <T> T invokeAnyImpl(ListeningExecutorService r110, Collection<? extends Callable<T>> r111, boolean r112, long r113, TimeUnit r210) throws InterruptedException, ExecutionException, TimeoutException {
        r110.getClass();
        r210.getClass();
        int r100 = r111.size();
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        com.google.common.base.m.b(r101);
        ArrayList r102 = Lists.d(r100);
        LinkedBlockingQueue r103 = new LinkedBlockingQueue();
        long r104 = r210.toNanos(r113);
        if (r112 == true) goto L50;
        long r105 = 0;
    L12:
        Iterator<? extends Callable<T>> r106 = r111.iterator();     // Catch: Throwable -> L9
        r102.add(submitAndAddQueueListener(r110, r106.next(), r103));     // Catch: Throwable -> L9
        int r107 = r100 - 1;     // Catch: Throwable -> L9
        ExecutionException r114 = null;
        int r115 = 1;
    L13:
        Future r116 = (Future) r103.poll();     // Catch: Throwable -> L9
        if (r116 != null) goto L28;
        if (r107 <= 0) goto L17;
        r107 = r107 - 1;     // Catch: Throwable -> L9
        r102.add(submitAndAddQueueListener(r110, r106.next(), r103));     // Catch: Throwable -> L9
        r115 = r115 + 1;     // Catch: Throwable -> L9
        goto L28
    L17:
        if (r115 == 0) goto L18;
        if (r112 == false) goto L27;
        r116 = (Future) r103.poll(r104, TimeUnit.NANOSECONDS);     // Catch: Throwable -> L9
        if (r116 == null) goto L26;
        long r117 = System.nanoTime();     // Catch: Throwable -> L9
        r104 = r104 - (r117 - r105);     // Catch: Throwable -> L9
    L29:
        long r108 = r104;
        int r109 = r107;
        if (r116 == null) goto L44;
        r115 = r115 - 1;
        T r118 = (T) r116.get();
    L33:
        Iterator r119 = r102.iterator();
    L35:
        if (r119.hasNext() == false) goto L37;
        ((Future) r119.next()).cancel(true);
        goto L35
    L37:
        return r118;
    L38:
        e = move-exception;
        r114 = new ExecutionException(e);     // Catch: Throwable -> L9
    L42:
        e = move-exception;
        r114 = e;
    L9:
        th = move-exception;
        Iterator r120 = r102.iterator();
    L47:
        if (r120.hasNext() == false) goto L49;
        ((Future) r120.next()).cancel(true);
        goto L47
    L49:
        throw th;
    L44:
        r107 = r109;
        r104 = r108;
        r105 = r117;
        goto L13
    L26:
        throw new TimeoutException();     // Catch: Throwable -> L9
    L27:
        r116 = (Future) r103.take();     // Catch: Throwable -> L9
        goto L28
    L18:
        if (r114 == null) goto L20;
        throw r114;     // Catch: Throwable -> L9
    L20:
        throw new ExecutionException(null);     // Catch: Throwable -> L9
    L28:
        r117 = r105;
        goto L29
    L50:
        r105 = System.nanoTime();     // Catch: Throwable -> L9
        goto L12
    L5:
        r101 = false;
        goto L6
    }
}
