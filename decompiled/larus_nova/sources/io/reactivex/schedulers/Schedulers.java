package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.i;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes41.dex */
public final class Schedulers {
    static final Scheduler COMPUTATION = null;
    static final Scheduler IO = null;
    static final Scheduler NEW_THREAD = null;
    static final Scheduler SINGLE = null;
    static final Scheduler TRAMPOLINE = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final io.reactivex.internal.schedulers.a f495093a = null;

        static {
            f495093a = new io.reactivex.internal.schedulers.a();
        }
    }

    public static final class b implements Callable<Scheduler> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Scheduler call() throws Exception {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return a.f495093a;
        }
    }

    public static final class c implements Callable<Scheduler> {
        public c() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Scheduler call() throws Exception {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return d.f495094a;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final io.reactivex.internal.schedulers.e f495094a = null;

        static {
            f495094a = new io.reactivex.internal.schedulers.e();
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final io.reactivex.internal.schedulers.f f495095a = null;

        static {
            f495095a = new io.reactivex.internal.schedulers.f();
        }
    }

    public static final class f implements Callable<Scheduler> {
        public f() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Scheduler call() throws Exception {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return e.f495095a;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f495096a = null;

        static {
            f495096a = new j();
        }
    }

    public static final class h implements Callable<Scheduler> {
        public h() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Scheduler call() throws Exception {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return g.f495096a;
        }
    }

    static {
        SINGLE = RxJavaPlugins.initSingleScheduler(new h());
        COMPUTATION = RxJavaPlugins.initComputationScheduler(new b());
        IO = RxJavaPlugins.initIoScheduler(new c());
        TRAMPOLINE = k.f494999a;
        NEW_THREAD = RxJavaPlugins.initNewThreadScheduler(new f());
    }

    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler(COMPUTATION);
    }

    public static Scheduler io() {
        return RxJavaPlugins.onIoScheduler(IO);
    }

    public static Scheduler newThread() {
        return RxJavaPlugins.onNewThreadScheduler(NEW_THREAD);
    }

    public static Scheduler single() {
        return RxJavaPlugins.onSingleScheduler(SINGLE);
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    public static void shutdown() {
        computation().shutdown();
        io().shutdown();
        newThread().shutdown();
        single().shutdown();
        trampoline().shutdown();
        ScheduledExecutorService r100 = i.f494990c.getAndSet(null);
        if (r100 == null) goto L5;
        r100.shutdownNow();
    L5:
        ((ConcurrentHashMap) i.f494991d).clear();
    }

    public static void start() {
        computation().start();
        io().start();
        newThread().start();
        single().start();
        trampoline().start();
        i.b();
    }

    public static Scheduler trampoline() {
        return TRAMPOLINE;
    }

    public static Scheduler from(Executor r100) {
        return new ExecutorScheduler(r100, false);
    }

    public static Scheduler from(Executor r100, boolean r101) {
        return new ExecutorScheduler(r100, r101);
    }
}
