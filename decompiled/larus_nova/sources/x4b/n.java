package x4b;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f562483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f562484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Thread f562485c;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f562486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f562487b;

        public b(n r100, Runnable r101) {
            this.f562486a = r100;
            this.f562487b = r101;
        }

        public final void a() {
            if (this.f562486a.f562484b.compareAndSet(false, true) == true) goto L5;
            Log.w("SerialExecutor", "serial task may occur crash, isRunning not reset");
            this.f562486a.f562484b.set(false);
        L5:
            n r100 = this.f562486a;
            r100.f562485c = ThreadMethodProxy.currentThread();
            this.f562487b.run();
            this.f562486a.f562484b.set(false);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // x4b.d
    public final void f() {
        if (this.f562484b.get() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), this.f562485c) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("serial thread check failed");
    }

    @Override // x4b.d
    public final void shutdown() {
        this.f562483a.shutdown();
    }

    public n(ExecutorService r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f562483a = r100;
        this.f562484b = new AtomicBoolean(false);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        if (this.f562483a.isShutdown() == false) goto L5;
        return;
    L5:
        this.f562483a.execute(new b(this, r100));
    }
}
