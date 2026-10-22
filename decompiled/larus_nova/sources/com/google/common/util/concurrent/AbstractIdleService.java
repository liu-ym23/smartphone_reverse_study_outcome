package com.google.common.util.concurrent;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractIdleService implements Service {
    private final Service delegate;
    private final com.google.common.base.t<String> threadNameSupplier;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractIdleService$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class DelegateService extends AbstractService {
        final /* synthetic */ AbstractIdleService this$0;

        public static /* synthetic */ void a(DelegateService r100) {
            r100.lambda$doStop$1();
        }

        public static /* synthetic */ void b(DelegateService r100) {
            r100.lambda$doStart$0();
        }

        private /* synthetic */ void lambda$doStart$0() {
            this.this$0.startUp();     // Catch: Throwable -> L4
            notifyStarted();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Platform.restoreInterruptIfIsInterruptedException(th);
            notifyFailed(th);
        }

        private /* synthetic */ void lambda$doStop$1() {
            this.this$0.shutDown();     // Catch: Throwable -> L4
            notifyStopped();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Platform.restoreInterruptIfIsInterruptedException(th);
            notifyFailed(th);
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            MoreExecutors.renamingDecorator(this.this$0.executor(), AbstractIdleService.access$200(this.this$0)).execute(new g(this));
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStop() {
            MoreExecutors.renamingDecorator(this.this$0.executor(), AbstractIdleService.access$200(this.this$0)).execute(new f(this));
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return this.this$0.toString();
        }

        private DelegateService(AbstractIdleService r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ DelegateService(AbstractIdleService r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public final class ThreadNameSupplier implements com.google.common.base.t<String> {
        final /* synthetic */ AbstractIdleService this$0;

        @Override // com.google.common.base.t
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public String get2() {
            return this.this$0.serviceName() + " " + this.this$0.state();
        }

        @Override // com.google.common.base.t
        public /* bridge */ /* synthetic */ String get() {
            return get2();
        }

        private ThreadNameSupplier(AbstractIdleService r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ ThreadNameSupplier(AbstractIdleService r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static /* synthetic */ void a(AbstractIdleService r100, Runnable r101) {
        r100.lambda$executor$0(r101);
    }

    public abstract void shutDown() throws Exception;

    public abstract void startUp() throws Exception;

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public Executor executor() {
        return new e(this);
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

    public AbstractIdleService() {
        AnonymousClass1 r100 = null;
        this.threadNameSupplier = new ThreadNameSupplier(this, r100);
        this.delegate = new DelegateService(this, r100);
    }

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public static /* synthetic */ com.google.common.base.t access$200(AbstractIdleService r100) {
        return r100.threadNameSupplier;
    }

    private /* synthetic */ void lambda$executor$0(Runnable r100) {
        ThreadMethodProxy.start(MoreExecutors.newThread(this.threadNameSupplier.get(), r100));
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
