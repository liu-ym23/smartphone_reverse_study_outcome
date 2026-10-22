package com.google.common.util.concurrent;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractExecutionThreadService implements Service {
    private static final Logger logger = null;
    private final Service delegate;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService$1, reason: invalid class name */
    public class AnonymousClass1 extends AbstractService {
        final /* synthetic */ AbstractExecutionThreadService this$0;

        public static /* synthetic */ void a(AnonymousClass1 r100) {
            r100.lambda$doStart$1();
        }

        public static /* synthetic */ String b(AnonymousClass1 r100) {
            return r100.lambda$doStart$0();
        }

        private /* synthetic */ String lambda$doStart$0() {
            return this.this$0.serviceName();
        }

        private /* synthetic */ void lambda$doStart$1() {
            this.this$0.startUp();     // Catch: Throwable -> L16
            notifyStarted();     // Catch: Throwable -> L16
            if (isRunning() == true) goto L21;
        L14:
            this.this$0.shutDown();     // Catch: Throwable -> L16
            notifyStopped();     // Catch: Throwable -> L16
            return;
        L21:
            this.this$0.run();     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            Platform.restoreInterruptIfIsInterruptedException(th);     // Catch: Throwable -> L16
            this.this$0.shutDown();     // Catch: Exception -> L10 Throwable -> L16
        L12:
            notifyFailed(th);     // Catch: Throwable -> L16
            return;
        L10:
            e = move-exception;
            Platform.restoreInterruptIfIsInterruptedException(e);     // Catch: Throwable -> L16
            AbstractExecutionThreadService.access$000().log(Level.WARNING, "Error while attempting to shut down the service after failure.", e);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Platform.restoreInterruptIfIsInterruptedException(th);
            notifyFailed(th);
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            MoreExecutors.renamingDecorator(this.this$0.executor(), new b(this)).execute(new c(this));
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStop() {
            this.this$0.triggerShutdown();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return this.this$0.toString();
        }

        public AnonymousClass1(AbstractExecutionThreadService r100) {
            this.this$0 = r100;
        }
    }

    public static /* synthetic */ void a(AbstractExecutionThreadService r100, Runnable r101) {
        r100.lambda$executor$0(r101);
    }

    public abstract void run() throws Exception;

    public void shutDown() throws Exception {
    }

    public void startUp() throws Exception {
    }

    public void triggerShutdown() {
    }

    static {
        logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public Executor executor() {
        return new a(this);
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

    public AbstractExecutionThreadService() {
        this.delegate = new AnonymousClass1(this);
    }

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public static /* synthetic */ Logger access$000() {
        return logger;
    }

    private /* synthetic */ void lambda$executor$0(Runnable r100) {
        ThreadMethodProxy.start(MoreExecutors.newThread(serviceName(), r100));
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
