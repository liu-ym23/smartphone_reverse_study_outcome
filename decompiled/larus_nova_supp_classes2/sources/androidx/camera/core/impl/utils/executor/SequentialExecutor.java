package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class SequentialExecutor implements Executor {
    private static final String TAG = "SequentialExecutor";
    private final Executor mExecutor;
    final Deque<Runnable> mQueue;
    private final QueueWorker mWorker;
    long mWorkerRunCount;
    WorkerRunningState mWorkerRunningState;

    public final class QueueWorker implements Runnable {
        final /* synthetic */ SequentialExecutor this$0;

        private void workOnQueue() {
            boolean r0 = false;
            boolean r1 = false;
        L36:
            Deque<Runnable> r2 = this.this$0.mQueue;     // Catch: Throwable -> L31
            monitor-enter(r2);     // Catch: Throwable -> L31
            if (r0 == false) goto L35;
        L13:
            Runnable r3 = this.this$0.mQueue.poll();     // Catch: Throwable -> L28
            if (r3 == null) goto L15;
            monitor-exit(r2);     // Catch: Throwable -> L28
            r1 = r1 | Thread.interrupted();
            r3.run();     // Catch: RuntimeException -> L25 Throwable -> L31
        L25:
            e = move-exception;
            Logger.e(SequentialExecutor.TAG, "Exception while executing runnable " + r3, e);     // Catch: Throwable -> L31
            goto L36
        L15:
            this.this$0.mWorkerRunningState = WorkerRunningState.IDLE;     // Catch: Throwable -> L28
            monitor-exit(r2);     // Catch: Throwable -> L28
            if (r1 == false) goto L45;
            ThreadMethodProxy.currentThread().interrupt();
            return;
        L45:
            return;
        L35:
            SequentialExecutor r4 = this.this$0;     // Catch: Throwable -> L28
            WorkerRunningState r5 = r4.mWorkerRunningState;     // Catch: Throwable -> L28
            WorkerRunningState r6 = WorkerRunningState.RUNNING;     // Catch: Throwable -> L28
            if (r5 == r6) goto L8;
            r4.mWorkerRunCount++;     // Catch: Throwable -> L28
            r4.mWorkerRunningState = r6;     // Catch: Throwable -> L28
            r0 = true;
            goto L13
        L8:
            monitor-exit(r2);     // Catch: Throwable -> L28
            if (r1 == false) goto L44;
            ThreadMethodProxy.currentThread().interrupt();
            return;
        L44:
            return;
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            if (r1 == false) goto L34;
            ThreadMethodProxy.currentThread().interrupt();
        L34:
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx_camera_core_impl_utils_executor_SequentialExecutor$QueueWorker_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_camera_core_impl_utils_executor_SequentialExecutor$QueueWorker__run$___twin___() {
            workOnQueue();     // Catch: Error -> L4
            return;
        L4:
            e = move-exception;
            monitor-enter(this.this$0.mQueue);
            SequentialExecutor r2 = this.this$0;     // Catch: Throwable -> L10
            r2.mWorkerRunningState = WorkerRunningState.IDLE;     // Catch: Throwable -> L10
            throw e;
        L10:
            th = move-exception;
            throw th;
        }

        public QueueWorker(SequentialExecutor r1) {
            this.this$0 = r1;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_camera_core_impl_utils_executor_SequentialExecutor$QueueWorker_com_larus_apm_impl_protector_RunnableLancet_run(QueueWorker r1) {
            r1.androidx_camera_core_impl_utils_executor_SequentialExecutor$QueueWorker__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
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

        public static WorkerRunningState valueOf(String r1) {
            return (WorkerRunningState) r27.a.a(WorkerRunningState.class, r1);
        }

        private WorkerRunningState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public SequentialExecutor(Executor r3) {
        this.mQueue = new ArrayDeque();
        this.mWorker = new QueueWorker(this);
        this.mWorkerRunningState = WorkerRunningState.IDLE;
        this.mWorkerRunCount = 0;
        this.mExecutor = (Executor) Preconditions.checkNotNull(r3);
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable r9) {
        Preconditions.checkNotNull(r9);
        Deque<Runnable> r0 = this.mQueue;
        monitor-enter(r0);
        WorkerRunningState r1 = this.mWorkerRunningState;     // Catch: Throwable -> L56
        if (r1 == WorkerRunningState.RUNNING) goto L53;
        WorkerRunningState r2 = WorkerRunningState.QUEUED;     // Catch: Throwable -> L56
        if (r1 == r2) goto L53;
        long r3 = this.mWorkerRunCount;     // Catch: Throwable -> L56
        Runnable r4 = new AnonymousClass1(this, r9);     // Catch: Throwable -> L56
        this.mQueue.add(r4);     // Catch: Throwable -> L56
        WorkerRunningState r10 = WorkerRunningState.QUEUING;     // Catch: Throwable -> L56
        this.mWorkerRunningState = r10;     // Catch: Throwable -> L56
        monitor-exit(r0);     // Catch: Throwable -> L56
        boolean r5 = true;
        this.mExecutor.execute(this.mWorker);     // Catch: Throwable -> L31 RuntimeException -> L33
        if (this.mWorkerRunningState != r10) goto L17;
        r5 = false;
    L17:
        if (r5 == false) goto L19;
        return;
    L19:
        Deque<Runnable> r6 = this.mQueue;
        monitor-enter(r6);
    L28:
        th = move-exception;
        throw th;
    L22:
        if (this.mWorkerRunCount == r3) goto L24;
    L26:
        monitor-exit(r6);     // Catch: Throwable -> L28
        return;
    L24:
        if (this.mWorkerRunningState != r10) goto L26;
        this.mWorkerRunningState = r2;     // Catch: Throwable -> L28
    L31:
        e = move-exception;
        Deque<Runnable> r7 = this.mQueue;
        monitor-enter(r7);
        WorkerRunningState r8 = this.mWorkerRunningState;     // Catch: Throwable -> L50
        if (r8 == WorkerRunningState.IDLE) goto L41;
        if (r8 == WorkerRunningState.QUEUING) goto L41;
    L43:
        r5 = false;
    L45:
        if ((e instanceof RejectedExecutionException) == false) goto L49;
        if (r5 == true) goto L49;
        monitor-exit(r7);     // Catch: Throwable -> L50
        return;
    L49:
        throw e;     // Catch: Throwable -> L50
    L41:
        if (this.mQueue.removeLastOccurrence(r4) == false) goto L43;
    L50:
        th = move-exception;
        throw th;
    L53:
        this.mQueue.add(r9);     // Catch: Throwable -> L56
        monitor-exit(r0);     // Catch: Throwable -> L56
        return;
    L56:
        th = move-exception;
        throw th;
    }
}
