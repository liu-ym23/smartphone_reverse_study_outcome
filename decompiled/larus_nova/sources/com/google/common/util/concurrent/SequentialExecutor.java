package com.google.common.util.concurrent;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class SequentialExecutor implements Executor {
    private static final Logger log = null;
    private final Executor executor;
    private final Deque<Runnable> queue;
    private final QueueWorker worker;
    private long workerRunCount;
    private WorkerRunningState workerRunningState;

    public final class QueueWorker implements Runnable {

        @CheckForNull
        Runnable task;
        final /* synthetic */ SequentialExecutor this$0;

        private void workOnQueue() {
            boolean r100 = false;
            boolean r101 = false;
        L40:
            Deque r102 = SequentialExecutor.access$100(this.this$0);     // Catch: Throwable -> L36
            monitor-enter(r102);     // Catch: Throwable -> L36
            if (r100 == false) goto L43;
        L13:
            Runnable r103 = (Runnable) SequentialExecutor.access$100(this.this$0).poll();     // Catch: Throwable -> L33
            this.task = r103;     // Catch: Throwable -> L33
            if (r103 == null) goto L15;
            monitor-exit(r102);     // Catch: Throwable -> L33
            r101 = r101 | Thread.interrupted();
            this.task.run();     // Catch: Throwable -> L26 RuntimeException -> L28
        L24:
            this.task = null;     // Catch: Throwable -> L36
        L28:
            e = move-exception;
            SequentialExecutor.access$400().log(Level.SEVERE, "Exception while executing runnable " + this.task, e);     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            this.task = null;     // Catch: Throwable -> L36
            throw th;     // Catch: Throwable -> L36
        L15:
            SequentialExecutor.access$202(this.this$0, WorkerRunningState.IDLE);     // Catch: Throwable -> L33
            monitor-exit(r102);     // Catch: Throwable -> L33
            if (r101 == false) goto L49;
            ThreadMethodProxy.currentThread().interrupt();
            return;
        L49:
            return;
        L43:
            WorkerRunningState r104 = SequentialExecutor.access$200(this.this$0);     // Catch: Throwable -> L33
            WorkerRunningState r105 = WorkerRunningState.RUNNING;     // Catch: Throwable -> L33
            if (r104 == r105) goto L8;
            SequentialExecutor.access$308(this.this$0);     // Catch: Throwable -> L33
            SequentialExecutor.access$202(this.this$0, r105);     // Catch: Throwable -> L33
            r100 = true;
            goto L13
        L8:
            monitor-exit(r102);     // Catch: Throwable -> L33
            if (r101 == false) goto L48;
            ThreadMethodProxy.currentThread().interrupt();
            return;
        L48:
            return;
        L33:
            th = move-exception;
            throw th;     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            if (r101 == false) goto L39;
            ThreadMethodProxy.currentThread().interrupt();
        L39:
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_google_common_util_concurrent_SequentialExecutor$QueueWorker_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public String toString() {
            Runnable r100 = this.task;
            if (r100 == null) goto L7;
            return "SequentialExecutorWorker{running=" + r100 + com.alipay.sdk.m.u.i.f25855d;
        L7:
            return "SequentialExecutorWorker{state=" + SequentialExecutor.access$200(this.this$0) + com.alipay.sdk.m.u.i.f25855d;
        }

        public void com_google_common_util_concurrent_SequentialExecutor$QueueWorker__run$___twin___() {
            workOnQueue();     // Catch: Error -> L4
            return;
        L4:
            e = move-exception;
            monitor-enter(SequentialExecutor.access$100(this.this$0));
            SequentialExecutor.access$202(this.this$0, WorkerRunningState.IDLE);     // Catch: Throwable -> L10
            throw e;
        L10:
            th = move-exception;
            throw th;
        }

        private QueueWorker(SequentialExecutor r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_google_common_util_concurrent_SequentialExecutor$QueueWorker_com_larus_apm_impl_protector_RunnableLancet_run(QueueWorker r100) {
            r100.com_google_common_util_concurrent_SequentialExecutor$QueueWorker__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ QueueWorker(SequentialExecutor r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static final enum WorkerRunningState extends Enum<WorkerRunningState> {
        private static final /* synthetic */ WorkerRunningState[] $VALUES = null;
        public static final WorkerRunningState IDLE = null;
        public static final WorkerRunningState QUEUED = null;
        public static final WorkerRunningState QUEUING = null;
        public static final WorkerRunningState RUNNING = null;

        private static /* synthetic */ WorkerRunningState[] $values() {
            return new WorkerRunningState[]{IDLE, QUEUING, QUEUED, RUNNING};
        }

        static {
            IDLE = new WorkerRunningState("IDLE", 0);
            QUEUING = new WorkerRunningState("QUEUING", 1);
            QUEUED = new WorkerRunningState("QUEUED", 2);
            RUNNING = new WorkerRunningState("RUNNING", 3);
            $VALUES = $values();
        }

        public static WorkerRunningState[] values() {
            return (WorkerRunningState[]) $VALUES.clone();
        }

        public static WorkerRunningState valueOf(String r100) {
            return (WorkerRunningState) r27.a.a(WorkerRunningState.class, r100);
        }

        private WorkerRunningState(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        log = Logger.getLogger(SequentialExecutor.class.getName());
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.executor + com.alipay.sdk.m.u.i.f25855d;
    }

    public static /* synthetic */ Logger access$400() {
        return log;
    }

    public SequentialExecutor(Executor r100) {
        this.queue = new ArrayDeque();
        this.workerRunningState = WorkerRunningState.IDLE;
        this.workerRunCount = 0;
        this.worker = new QueueWorker(this, null);
        r100.getClass();
        this.executor = r100;
    }

    public static /* synthetic */ Deque access$100(SequentialExecutor r100) {
        return r100.queue;
    }

    public static /* synthetic */ WorkerRunningState access$200(SequentialExecutor r100) {
        return r100.workerRunningState;
    }

    public static /* synthetic */ long access$308(SequentialExecutor r100) {
        long r101 = r100.workerRunCount;
        r100.workerRunCount = 1 + r101;
        return r101;
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable r100) {
        r100.getClass();
        Deque<Runnable> r101 = this.queue;
        monitor-enter(r101);
        WorkerRunningState r102 = this.workerRunningState;     // Catch: Throwable -> L56
        if (r102 == WorkerRunningState.RUNNING) goto L53;
        WorkerRunningState r103 = WorkerRunningState.QUEUED;     // Catch: Throwable -> L56
        if (r102 == r103) goto L53;
        long r104 = this.workerRunCount;     // Catch: Throwable -> L56
        Runnable r105 = new AnonymousClass1(this, r100);     // Catch: Throwable -> L56
        this.queue.add(r105);     // Catch: Throwable -> L56
        WorkerRunningState r106 = WorkerRunningState.QUEUING;     // Catch: Throwable -> L56
        this.workerRunningState = r106;     // Catch: Throwable -> L56
        monitor-exit(r101);     // Catch: Throwable -> L56
        boolean r107 = true;
        this.executor.execute(this.worker);     // Catch: Throwable -> L31 RuntimeException -> L33
        if (this.workerRunningState != r106) goto L17;
        r107 = false;
    L17:
        if (r107 == false) goto L19;
        return;
    L19:
        Deque<Runnable> r108 = this.queue;
        monitor-enter(r108);
    L28:
        th = move-exception;
        throw th;
    L22:
        if (this.workerRunCount == r104) goto L24;
    L26:
        monitor-exit(r108);     // Catch: Throwable -> L28
        return;
    L24:
        if (this.workerRunningState != r106) goto L26;
        this.workerRunningState = r103;     // Catch: Throwable -> L28
    L31:
        e = move-exception;
        Deque<Runnable> r109 = this.queue;
        monitor-enter(r109);
        WorkerRunningState r110 = this.workerRunningState;     // Catch: Throwable -> L50
        if (r110 == WorkerRunningState.IDLE) goto L41;
        if (r110 == WorkerRunningState.QUEUING) goto L41;
    L43:
        r107 = false;
    L45:
        if ((e instanceof RejectedExecutionException) == false) goto L49;
        if (r107 == true) goto L49;
        monitor-exit(r109);     // Catch: Throwable -> L50
        return;
    L49:
        throw e;     // Catch: Throwable -> L50
    L41:
        if (this.queue.removeLastOccurrence(r105) == false) goto L43;
    L50:
        th = move-exception;
        throw th;
    L53:
        this.queue.add(r100);     // Catch: Throwable -> L56
        monitor-exit(r101);     // Catch: Throwable -> L56
        return;
    L56:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ WorkerRunningState access$202(SequentialExecutor r100, WorkerRunningState r101) {
        r100.workerRunningState = r101;
        return r101;
    }
}
