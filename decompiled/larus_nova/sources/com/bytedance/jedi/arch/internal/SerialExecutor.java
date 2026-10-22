package com.bytedance.jedi.arch.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/jedi/arch/internal/SerialExecutor;", "Ljava/util/concurrent/Executor;", "()V", "mActive", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/lang/Runnable;", "mTasks", "Ljava/util/concurrent/LinkedBlockingQueue;", "execute", "", "r", "scheduleNext", "Companion", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SerialExecutor implements Executor {
    public static final Companion Companion = null;
    private static final Lazy<ThreadPoolExecutor> UNBOUND_EXECUTOR$delegate = null;
    private static final Lazy<Executor> WORKER$delegate = null;
    private final AtomicReference<Runnable> mActive;
    private final LinkedBlockingQueue<Runnable> mTasks;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/jedi/arch/internal/SerialExecutor$Companion;", "", "()V", "CPU_COUNT", "", "getCPU_COUNT", "()I", "MAXIMUM_POOL_SIZE", "getMAXIMUM_POOL_SIZE", "UNBOUND_EXECUTOR", "Ljava/util/concurrent/ThreadPoolExecutor;", "getUNBOUND_EXECUTOR$arch_release", "()Ljava/util/concurrent/ThreadPoolExecutor;", "UNBOUND_EXECUTOR$delegate", "Lkotlin/Lazy;", "WORKER", "Ljava/util/concurrent/Executor;", "getWORKER", "()Ljava/util/concurrent/Executor;", "WORKER$delegate", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final int getCPU_COUNT() {
            return Runtime.getRuntime().availableProcessors();
        }

        private final int getMAXIMUM_POOL_SIZE() {
            return (getCPU_COUNT() * 2) + 1;
        }

        private final Executor getWORKER() {
            return (Executor) SerialExecutor.access$getWORKER$delegate$cp().getValue();
        }

        public final ThreadPoolExecutor getUNBOUND_EXECUTOR$arch_release() {
            return (ThreadPoolExecutor) SerialExecutor.access$getUNBOUND_EXECUTOR$delegate$cp().getValue();
        }

        public static final /* synthetic */ int access$getMAXIMUM_POOL_SIZE(Companion r100) {
            return r100.getMAXIMUM_POOL_SIZE();
        }

        public static final /* synthetic */ Executor access$getWORKER(Companion r100) {
            return r100.getWORKER();
        }
    }

    public static /* synthetic */ void a(Runnable r100, SerialExecutor r101) {
        execute$lambda$0(r100, r101);
    }

    private final synchronized void scheduleNext() {
        monitor-enter(this);
        AtomicReference<Runnable> r100 = this.mActive;     // Catch: Throwable -> L10
        Runnable r101 = this.mTasks.poll();     // Catch: Throwable -> L10
        if (r101 == null) goto L6;
        Companion.access$getWORKER(Companion).execute(r101);     // Catch: Throwable -> L10
    L7:
        r100.set(r101);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r101 = null;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        Companion = new Companion(null);
        WORKER$delegate = LazyKt.lazy(SerialExecutor$Companion$WORKER$2.INSTANCE);
        UNBOUND_EXECUTOR$delegate = LazyKt.lazy(SerialExecutor$Companion$UNBOUND_EXECUTOR$2.INSTANCE);
    }

    public SerialExecutor() {
        this.mTasks = new LinkedBlockingQueue();
        this.mActive = new AtomicReference();
    }

    public static final /* synthetic */ Lazy access$getUNBOUND_EXECUTOR$delegate$cp() {
        return UNBOUND_EXECUTOR$delegate;
    }

    public static final /* synthetic */ Lazy access$getWORKER$delegate$cp() {
        return WORKER$delegate;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "r");     // Catch: Throwable -> L8
        this.mTasks.offer(new d(r100, this));     // Catch: Throwable -> L8
        if (this.mActive.get() != null) goto L6;
        scheduleNext();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static final void execute$lambda$0(Runnable r100, SerialExecutor r101) {
        Intrinsics.checkNotNullParameter(r100, "$r");
        Intrinsics.checkNotNullParameter(r101, "this$0");
        r100.run();     // Catch: Throwable -> L6
        r101.scheduleNext();
        return;
    L6:
        th = move-exception;
        r101.scheduleNext();
        throw th;
    }
}
