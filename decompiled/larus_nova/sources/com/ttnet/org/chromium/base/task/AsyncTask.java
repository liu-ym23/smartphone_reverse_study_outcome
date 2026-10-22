package com.ttnet.org.chromium.base.task;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AsyncTask<Result> {
    private static final String GET_STATUS_UMA_HISTOGRAM = "Android.Jank.AsyncTaskGetOnUiThreadStatus";
    public static final Executor SERIAL_EXECUTOR = null;
    private static final StealRunnableHandler STEAL_RUNNABLE_HANDLER = null;
    private static final String TAG = "AsyncTask";
    public static final Executor THREAD_POOL_EXECUTOR = null;
    private final AtomicBoolean mCancelled;
    private final AsyncTask<Result>.NamedFutureTask mFuture;
    private volatile int mStatus;
    private final AtomicBoolean mTaskInvoked;
    private final Callable<Result> mWorker;

    /* JADX INFO: loaded from: classes41.dex */
    public class NamedFutureTask extends FutureTask<Result> {
        final /* synthetic */ AsyncTask this$0;

        @Override // java.util.concurrent.FutureTask
        public void done() {
            AsyncTask.access$500(this.this$0, get());     // Catch: CancellationException -> L4 ExecutionException -> L5 InterruptedException -> L8
        L14:
            return;
        L8:
            e = move-exception;
            Log.w(AsyncTask.TAG, e.toString(), new Object[0]);
            return;
        L4:
            AsyncTask.access$500(this.this$0, null);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException("An error occurred while executing doInBackground()", e.getCause());
        }

        public Class getBlamedClass() {
            return this.this$0.getClass();
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            TraceEvent r100 = TraceEvent.scoped("AsyncTask.run: ".concat(AsyncTask.access$400(this.this$0).getBlamedClass().getName()));
            super.run();     // Catch: Throwable -> L7
            if (r100 == null) goto L18;
            r100.close();
            return;
        L18:
            return;
        L7:
            th = move-exception;
            if (r100 != null) goto L16;
        L13:
            throw th;
        L16:
            r100.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public NamedFutureTask(AsyncTask r100, Callable<Result> r101) {
            this.this$0 = r100;
            super(r101);
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
        public static final int FINISHED = 2;
        public static final int NUM_ENTRIES = 3;
        public static final int PENDING = 0;
        public static final int RUNNING = 1;
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class StealRunnableHandler implements RejectedExecutionHandler {
        private StealRunnableHandler() {
        }

        public /* synthetic */ StealRunnableHandler(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(r100);
        }
    }

    public static /* synthetic */ void a(Runnable r100) {
        lambda$static$0(r100);
    }

    public static /* synthetic */ void b(AsyncTask r100, Object r101) {
        r100.lambda$postResult$1(r101);
    }

    public abstract Result doInBackground();

    public void onCancelled() {
    }

    public abstract void onPostExecute(Result r100);

    public void onPreExecute() {
    }

    static {
        THREAD_POOL_EXECUTOR = new b();
        SERIAL_EXECUTOR = new SerialExecutor();
        STEAL_RUNNABLE_HANDLER = new StealRunnableHandler(null);
    }

    private void executionPreamble() {
        if (this.mStatus == 0) goto L13;
        int r100 = this.mStatus;
        if (r100 == 1) goto L12;
        if (r100 != 2) goto L13;
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    L12:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
    L13:
        this.mStatus = 1;
        onPreExecute();
    }

    public static void takeOverAndroidThreadPool() {
        ThreadPoolExecutor r100 = (ThreadPoolExecutor) android.os.AsyncTask.THREAD_POOL_EXECUTOR;
        r100.setRejectedExecutionHandler(STEAL_RUNNABLE_HANDLER);
        r100.shutdown();
    }

    public final int getUmaStatus() {
        if (this.mStatus != 1) goto L9;
        if (this.mTaskInvoked.get() == true) goto L9;
        return 0;
    L9:
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public AsyncTask() {
        this.mStatus = 0;
        this.mCancelled = new AtomicBoolean();
        this.mTaskInvoked = new AtomicBoolean();
        Callable<Result> r100 = new AnonymousClass1(this);
        this.mWorker = r100;
        this.mFuture = new NamedFutureTask(this, r100);
    }

    public final Result get() throws InterruptedException, ExecutionException {
        int r100 = getUmaStatus();
        if (r100 == 2) goto L22;
        if (ThreadUtils.runningOnUiThread() == false) goto L22;
        RecordHistogram.recordEnumeratedHistogram(GET_STATUS_UMA_HISTOGRAM, r100, 3);
        StackTraceElement[] r101 = new Exception().getStackTrace();
        if (r101.length <= 1) goto L9;
        String r102 = r101[1].getClassName() + '.' + r101[1].getMethodName() + '.';
    L10:
        TraceEvent r103 = TraceEvent.scoped(r102 + "AsyncTask.get");
        Result r104 = this.mFuture.get();     // Catch: Throwable -> L14
        if (r103 == null) goto L27;
        r103.close();
        return r104;
    L27:
        return r104;
    L14:
        th = move-exception;
        if (r103 != null) goto L25;
    L20:
        throw th;
    L25:
        r103.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    L9:
        r102 = "";
    L22:
        return this.mFuture.get();
    }

    public final int getStatus() {
        return this.mStatus;
    }

    public static /* synthetic */ AtomicBoolean access$100(AsyncTask r100) {
        return r100.mTaskInvoked;
    }

    public static /* synthetic */ AtomicBoolean access$200(AsyncTask r100) {
        return r100.mCancelled;
    }

    public static /* synthetic */ NamedFutureTask access$400(AsyncTask r100) {
        return r100.mFuture;
    }

    private void finish(Result r100) {
        if (isCancelled() == false) goto L5;
        onCancelled(r100);
    L6:
        this.mStatus = 2;
        return;
    L5:
        onPostExecute(r100);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$postResult$1(Object r100) {
        finish(r100);
    }

    private static /* synthetic */ void lambda$static$0(Runnable r100) {
        PostTask.postTask(TaskTraits.BEST_EFFORT_MAY_BLOCK, r100);
    }

    private void postResult(final Result r100) {
        if ((this instanceof BackgroundOnlyAsyncTask) == false) goto L5;
        this.mStatus = 2;
        return;
    L5:
        ThreadUtils.postOnUiThread(new a(this, r100));
    }

    private void postResultIfNotInvoked(Result r100) {
        if (this.mTaskInvoked.get() == true) goto L6;
        postResult(r100);
        return;
    }

    public final boolean cancel(boolean r100) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(r100);
    }

    public final AsyncTask<Result> executeOnExecutor(Executor r100) {
        executionPreamble();
        r100.execute(this.mFuture);
        return this;
    }

    public final AsyncTask<Result> executeOnTaskRunner(TaskRunner r100) {
        executionPreamble();
        r100.postTask(this.mFuture);
        return this;
    }

    public final AsyncTask<Result> executeWithTaskTraits(TaskTraits r100) {
        executionPreamble();
        PostTask.postTask(r100, this.mFuture);
        return this;
    }

    public void onCancelled(Result r100) {
        onCancelled();
    }

    public static /* synthetic */ void access$300(AsyncTask r100, Object r101) {
        r100.postResult(r101);
    }

    public static /* synthetic */ void access$500(AsyncTask r100, Object r101) {
        r100.postResultIfNotInvoked(r101);
    }

    public final Result get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
        int r102 = getUmaStatus();
        if (r102 == 2) goto L22;
        if (ThreadUtils.runningOnUiThread() == false) goto L22;
        RecordHistogram.recordEnumeratedHistogram(GET_STATUS_UMA_HISTOGRAM, r102, 3);
        StackTraceElement[] r103 = new Exception().getStackTrace();
        if (r103.length <= 1) goto L9;
        String r104 = r103[1].getClassName() + '.' + r103[1].getMethodName() + '.';
    L10:
        TraceEvent r105 = TraceEvent.scoped(r104 + "AsyncTask.get");
        Result r106 = this.mFuture.get(r100, r101);     // Catch: Throwable -> L14
        if (r105 == null) goto L27;
        r105.close();
        return r106;
    L27:
        return r106;
    L14:
        th = move-exception;
        if (r105 != null) goto L25;
    L20:
        throw th;
    L25:
        r105.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    L9:
        r104 = "";
    L22:
        return this.mFuture.get(r100, r101);
    }
}
