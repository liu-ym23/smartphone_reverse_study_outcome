package com.bytedance.caijing.sdk.infra.base.impl.task;

import android.os.Process;
import com.bytedance.caijing.sdk.infra.base.api.task.CJThreadService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J/\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\"\u0004\b\u0000\u0010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/task/CJThreadServiceDefaultImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/task/CJThreadService;", "Ljava/lang/Runnable;", "task", "", "executeCPU", "R", "result", "Ljava/util/concurrent/Future;", "executeCPUFuture", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/Future;", "executeIO", "executeLogic", "removeCPU", "removeIO", "Ljava/util/concurrent/RejectedExecutionHandler;", "sRejectHandler", "Ljava/util/concurrent/RejectedExecutionHandler;", "Ljava/util/concurrent/ThreadPoolExecutor;", "sFixedThreadPool", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "singleLogic", "executorIO", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "cj-host-service-impl-thread_release"}, k = 1, mv = {1, 6, 0})
public final class CJThreadServiceDefaultImpl implements CJThreadService {
    private static final int CPU_COUNT = 0;
    public static final b Companion = null;
    private final ThreadPoolExecutor executor;
    private final ThreadPoolExecutor executorIO;
    private final ThreadPoolExecutor sFixedThreadPool;
    private final RejectedExecutionHandler sRejectHandler;
    private final ThreadPoolExecutor singleLogic;

    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f202719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f202720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f202721c;

        /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.impl.task.CJThreadServiceDefaultImpl$a$a, reason: collision with other inner class name */
        public static final class C2941a {
        }

        public static final class b extends PthreadThreadV2 {
            @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
            public final void run() {
                Process.setThreadPriority(getPriority());     // Catch: Throwable -> L4
                super.run();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(Runnable r100, ThreadGroup r101, String r102) {
                super(r101, r100, r102, 0);
            }
        }

        static {
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            ThreadGroup r101 = new ThreadGroup("CJPool");
            this.f202719a = r101;
            this.f202720b = new AtomicInteger(1);
            r101.setDaemon(false);
            r101.setMaxPriority(10);
            this.f202721c = "CJPool-" + r100 + '-';
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "r");
            b r101 = new b(r100, this.f202719a, this.f202721c + this.f202720b.getAndIncrement());
            if (r101.isDaemon() == false) goto L6;
            r101.setDaemon(false);
        L6:
            if (r101.getPriority() == 5) goto L8;
            ThreadMethodProxy.setPriority(r101, 5);
        L8:
            return r101;
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c extends PThreadPoolExecutor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJThreadServiceDefaultImpl f202722a;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "command");
            super.execute(r100);     // Catch: OutOfMemoryError -> L5
            return;
        L5:
            this.f202722a.executeCPU(r100);
        }

        public c(CJThreadServiceDefaultImpl r110, TimeUnit r111, SynchronousQueue r112, a r113, d r114) {
            this.f202722a = r110;
            super(0, 128, 60, r111, r112, r113, r114);
        }
    }

    public static final class d implements RejectedExecutionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJThreadServiceDefaultImpl f202723a;

        public d(CJThreadServiceDefaultImpl r100) {
            this.f202723a = r100;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
            CJThreadServiceDefaultImpl.access$getSFixedThreadPool$p(this.f202723a).execute(r100);
        }
    }

    static {
        Companion = new b();
        CPU_COUNT = Runtime.getRuntime().availableProcessors();
    }

    public CJThreadServiceDefaultImpl() {
        d r100 = new d(this);
        this.sRejectHandler = r100;
        int r101 = CPU_COUNT;
        int r102 = r101 - 2;
        int r103 = Math.max(2, r102);
        int r104 = Math.max(2, r102);
        TimeUnit r105 = TimeUnit.SECONDS;
        this.sFixedThreadPool = new PThreadPoolExecutor(r103, r104, 30, r105, new LinkedBlockingQueue(), new a("FIX"));
        this.executor = new PThreadPoolExecutor(Math.max(4, r101 - 1), Math.max(8, r101 * 2), 30, r105, new LinkedBlockingQueue(64), new a("CPU"), r100);
        this.singleLogic = new PThreadPoolExecutor(1, 1, 30, r105, new LinkedBlockingQueue(64), new a("Logic"), r100);
        this.executorIO = new c(this, r105, new SynchronousQueue(), new a("IO"), r100);
    }

    public static final /* synthetic */ ThreadPoolExecutor access$getSFixedThreadPool$p(CJThreadServiceDefaultImpl r100) {
        return r100.sFixedThreadPool;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.task.CJThreadService
    public void executeCPU(Runnable r100) {
        this.executor.execute(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.task.CJThreadService
    public void executeIO(Runnable r100) {
        this.executorIO.execute(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.task.CJThreadService
    public void executeLogic(Runnable r100) {
        this.singleLogic.execute(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.task.CJThreadService
    public void removeCPU(Runnable r100) {
        this.executor.remove(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.task.CJThreadService
    public void removeIO(Runnable r100) {
        this.executorIO.remove(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.task.CJThreadService
    public <R> Future<R> executeCPUFuture(Runnable r100, R r101) {
        return this.executor.submit(r100, r101);
    }
}
