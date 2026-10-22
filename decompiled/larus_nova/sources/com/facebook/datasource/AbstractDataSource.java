package com.facebook.datasource;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public abstract class AbstractDataSource<T> implements DataSource<T> {

    @Nullable
    private Object mCallerContext;
    private DataSourceStatus mDataSourceStatus;

    @Nullable
    private Map<String, Object> mExtras;
    private Throwable mFailureThrowable;
    private boolean mIsClosed;
    private boolean mOptOnNewResultMsg;
    private float mProgress;

    @Nullable
    private T mResult;
    private final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> mSubscribers;

    public static final enum DataSourceStatus extends Enum<DataSourceStatus> {
        private static final /* synthetic */ DataSourceStatus[] $VALUES = null;
        public static final DataSourceStatus FAILURE = null;
        public static final DataSourceStatus IN_PROGRESS = null;
        public static final DataSourceStatus SUCCESS = null;

        static {
            DataSourceStatus r100 = new DataSourceStatus("IN_PROGRESS", 0);
            IN_PROGRESS = r100;
            DataSourceStatus r101 = new DataSourceStatus("SUCCESS", 1);
            SUCCESS = r101;
            DataSourceStatus r102 = new DataSourceStatus("FAILURE", 2);
            FAILURE = r102;
            $VALUES = new DataSourceStatus[]{r100, r101, r102};
        }

        public static DataSourceStatus[] values() {
            return (DataSourceStatus[]) $VALUES.clone();
        }

        public static DataSourceStatus valueOf(String r100) {
            return (DataSourceStatus) Enum.valueOf(DataSourceStatus.class, r100);
        }

        private DataSourceStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    private synchronized boolean wasCancelled() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == false) goto L8;
        if (isFinished() == true) goto L8;
        boolean r100 = true;
    L9:
        monitor-exit(this);
        return r100;
    L8:
        r100 = false;
        goto L9
    }

    @Override // com.facebook.datasource.DataSource
    public boolean close() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsClosed == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L22
        return false;
    L8:
        this.mIsClosed = true;     // Catch: Throwable -> L22
        T r100 = this.mResult;     // Catch: Throwable -> L22
        this.mResult = null;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        if (r100 == null) goto L13;
        closeResult(r100);
    L13:
        if (isFinished() == true) goto L15;
        notifyDataSubscribers();
    L15:
        monitor-enter(this);
        this.mSubscribers.clear();     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return true;
    L19:
        th = move-exception;
        throw th;
    }

    public void closeResult(@Nullable T r100) {
    }

    @Override // com.facebook.datasource.DataSource
    @Nullable
    public synchronized Throwable getFailureCause() {
        monitor-enter(this);
        Throwable r100 = this.mFailureThrowable;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized float getProgress() {
        monitor-enter(this);
        float r100 = this.mProgress;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.datasource.DataSource
    @Nullable
    public synchronized T getResult() {
        monitor-enter(this);
        T r100 = this.mResult;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean hasFailed() {
        monitor-enter(this);
        if (this.mDataSourceStatus != DataSourceStatus.FAILURE) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean hasMultipleResults() {
        return false;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean hasResult() {
        monitor-enter(this);
        if (this.mResult == null) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean isClosed() {
        monitor-enter(this);
        boolean r100 = this.mIsClosed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean isFinished() {
        monitor-enter(this);
        if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public void notifyProgressUpdate() {
        Iterator<Pair<DataSubscriber<T>, Executor>> r100 = this.mSubscribers.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Pair<DataSubscriber<T>, Executor> r101 = r100.next();
        final DataSubscriber r102 = (DataSubscriber) r101.first;
        ((Executor) r101.second).execute(new AnonymousClass3(this, r102));
        goto L4
    }

    public AbstractDataSource() {
        this.mResult = null;
        this.mFailureThrowable = null;
        this.mProgress = 0.0f;
        this.mOptOnNewResultMsg = false;
        this.mIsClosed = false;
        this.mDataSourceStatus = DataSourceStatus.IN_PROGRESS;
        this.mSubscribers = new ConcurrentLinkedQueue();
    }

    private boolean isMainThread() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(new Handler(Looper.getMainLooper()).getLooper())) goto L5;
        return true;
    L5:
        return false;
    }

    private void notifyDataSubscribers() {
        boolean r100 = hasFailed();
        boolean r101 = wasCancelled();
        Iterator<Pair<DataSubscriber<T>, Executor>> r102 = this.mSubscribers.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Pair<DataSubscriber<T>, Executor> r103 = r102.next();
        notifyDataSubscriber((DataSubscriber) r103.first, (Executor) r103.second, r100, r101);
        goto L4
    }

    @Override // com.facebook.datasource.DataSource
    @Nullable
    public Map<String, Object> getExtras() {
        return this.mExtras;
    }

    private synchronized boolean setFailureInternal(Throwable r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsClosed == false) goto L6;
    L12:
        monitor-exit(this);
        return false;
    L6:
        if (this.mDataSourceStatus != DataSourceStatus.IN_PROGRESS) goto L12;
        this.mDataSourceStatus = DataSourceStatus.FAILURE;     // Catch: Throwable -> L15
        this.mFailureThrowable = r100;     // Catch: Throwable -> L15
        monitor-exit(this);
        return true;
    }

    private synchronized boolean setProgressInternal(float r100) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsClosed == false) goto L6;
    L17:
        monitor-exit(this);
        return false;
    L6:
        if (this.mDataSourceStatus != DataSourceStatus.IN_PROGRESS) goto L17;
        if (r100 >= this.mProgress) goto L13;
        monitor-exit(this);
        return false;
    L13:
        this.mProgress = r100;     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    }

    public void setCallerContext(@Nullable Object r100) {
        this.mCallerContext = r100;
    }

    public boolean setFailure(Throwable r100) {
        boolean r101 = setFailureInternal(r100);
        if (r101 == false) goto L5;
        notifyDataSubscribers();
    L5:
        return r101;
    }

    public void setOptOnNewResultMsg(boolean r100) {
        this.mOptOnNewResultMsg = r100;
    }

    public boolean setProgress(float r100) {
        boolean r101 = setProgressInternal(r100);
        if (r101 == false) goto L5;
        notifyProgressUpdate();
    L5:
        return r101;
    }

    private boolean setResultInternal(@Nullable T r100, boolean r101) {
        T r102 = null;
        monitor-enter(this);     // Catch: Throwable -> L33
    L30:
        th = th;
    L31:
        monitor-exit(this);     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L33
    L37:
        if (this.mIsClosed == false) goto L7;
    L23:
        monitor-exit(this);     // Catch: Throwable -> L28
        if (r100 == null) goto L44;
        closeResult(r100);
        return false;
    L44:
        return false;
    L7:
        if (this.mDataSourceStatus != DataSourceStatus.IN_PROGRESS) goto L23;
        if (r101 == false) goto L11;
        this.mDataSourceStatus = DataSourceStatus.SUCCESS;     // Catch: Throwable -> L30
        this.mProgress = 1.0f;     // Catch: Throwable -> L30
    L11:
        T r103 = this.mResult;     // Catch: Throwable -> L30
        if (r103 != r100) goto L41;
        T r104 = null;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L28
        if (r104 == null) goto L43;
        closeResult(r104);
        return true;
    L43:
        return true;
    L41:
        this.mResult = r100;     // Catch: Throwable -> L15
        r104 = r103;
    L15:
        th = th;
        r102 = r103;
    L28:
        th = move-exception;
        r102 = r100;
        th = th;
    L33:
        th = move-exception;
        if (r102 == null) goto L36;
        closeResult(r102);
    L36:
        throw th;
    }

    public boolean setResult(@Nullable T r100, boolean r101) {
        boolean r102 = setResultInternal(r100, r101);
        if (r102 == false) goto L5;
        notifyDataSubscribers();
    L5:
        return r102;
    }

    @Override // com.facebook.datasource.DataSource
    public void subscribe(DataSubscriber<T> r100, Executor r101) {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsClosed == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L9:
        if (this.mDataSourceStatus != DataSourceStatus.IN_PROGRESS) goto L12;
        this.mSubscribers.add(Pair.create(r100, r101));     // Catch: Throwable -> L24
    L12:
        if (hasResult() == false) goto L14;
    L19:
        boolean r102 = true;
    L20:
        monitor-exit(this);     // Catch: Throwable -> L24
        if (r102 == false) goto L28;
        notifyDataSubscriber(r100, r101, hasFailed(), wasCancelled());
        return;
    L28:
        return;
    L14:
        if (isFinished() == true) goto L19;
        if (wasCancelled() == true) goto L19;
        r102 = false;
        goto L20
    }

    private void notifyDataSubscriber(final DataSubscriber<T> r100, Executor r101, final boolean r102, final boolean r103) {
        if (FrescoOptUtil.isOptOnNewResultMsg() == false) goto L5;
    L6:
        if (r102 == true) goto L23;
        if (r103 == true) goto L23;
        if ((r101 instanceof UiThreadImmediateExecutorService) == true) goto L23;
        if (isMainThread() == true) goto L23;
        if (FrescoOptUtil.isOptEnabledForBiz(FrescoOptUtil.OPT_ON_NEW_RESULT_MSG, this.mCallerContext) == false) goto L23;
        if (FLog.isLoggable(2) == false) goto L17;
        FLog.v("AbstractDataSource", "onNewResult sendMessageAtFrontOfQueue");
    L17:
        Handler r104 = new Handler(Looper.getMainLooper());
        Message r105 = Message.obtain(r104, new AnonymousClass1(this, r100));
        if (Build.VERSION.SDK_INT < 22) goto L21;
        r105.setAsynchronous(true);
    L21:
        if (r104.sendMessageAtFrontOfQueue(r105) == false) goto L23;
        return;
    L23:
        r101.execute(new AnonymousClass2(this, r102, r100, r103));
        return;
    L5:
        if (this.mOptOnNewResultMsg == false) goto L23;
        goto L6
    }
}
