package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ListDataSource<T> extends AbstractDataSource<List<CloseableReference<T>>> {
    private final DataSource<CloseableReference<T>>[] mDataSources;
    private int mFinishedDataSources;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.datasource.ListDataSource$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class InternalDataSubscriber implements DataSubscriber<CloseableReference<T>> {
        boolean mFinished;
        final /* synthetic */ ListDataSource this$0;

        private synchronized boolean tryFinish() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (this.mFinished == false) goto L9;
            monitor-exit(this);
            return false;
        L9:
            this.mFinished = true;     // Catch: Throwable -> L12
            monitor-exit(this);
            return true;
        }

        private InternalDataSubscriber(ListDataSource r100) {
            this.this$0 = r100;
            this.mFinished = false;
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<T>> r100) {
            ListDataSource.access$200(this.this$0);
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onFailure(DataSource<CloseableReference<T>> r100) {
            ListDataSource.access$100(this.this$0, r100);
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onNewResult(DataSource<CloseableReference<T>> r100) {
            if (r100.isFinished() == true) goto L5;
            return;
        L5:
            if (tryFinish() == false) goto L9;
            ListDataSource.access$300(this.this$0);
            return;
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onProgressUpdate(DataSource<CloseableReference<T>> r100) {
            ListDataSource.access$400(this.this$0);
        }

        public /* synthetic */ InternalDataSubscriber(ListDataSource r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    private synchronized boolean increaseAndCheckIfLast() {
        monitor-enter(this);
        boolean r100 = true;
        int r101 = this.mFinishedDataSources + 1;     // Catch: Throwable -> L9
        this.mFinishedDataSources = r101;     // Catch: Throwable -> L9
        if (r101 == this.mDataSources.length) goto L7;
        r100 = false;
    L7:
        monitor-exit(this);
        return r100;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    public synchronized List<CloseableReference<T>> getResult() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (hasResult() == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ArrayList r100 = new ArrayList(this.mDataSources.length);     // Catch: Throwable -> L14
        DataSource<CloseableReference<T>>[] r101 = this.mDataSources;     // Catch: Throwable -> L14
        int r102 = r101.length;     // Catch: Throwable -> L14
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L12;
        r100.add(r101[r103].getResult());     // Catch: Throwable -> L14
        r103 = r103 + 1;
        goto L9
    L12:
        monitor-exit(this);
        return r100;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public synchronized boolean hasResult() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == true) goto L8;
        if (this.mFinishedDataSources != this.mDataSources.length) goto L8;
        boolean r100 = true;
    L9:
        monitor-exit(this);
        return r100;
    L8:
        r100 = false;
        goto L9
    }

    private void onDataSourceCancelled() {
        setFailure(new CancellationException());
    }

    private void onDataSourceProgress() {
        DataSource<CloseableReference<T>>[] r100 = this.mDataSources;
        int r101 = r100.length;
        float r102 = 0.0f;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102 = r102 + r100[r103].getProgress();
        r103 = r103 + 1;
        goto L3
    L5:
        setProgress(r102 / this.mDataSources.length);
    }

    private void onDataSourceFinished() {
        if (increaseAndCheckIfLast() == false) goto L6;
        setResult(null, true);
        return;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean close() {
        int r100 = 0;
        if (super.close() == true) goto L5;
        return false;
    L5:
        DataSource<CloseableReference<T>>[] r101 = this.mDataSources;
        int r102 = r101.length;
    L6:
        if (r100 >= r102) goto L8;
        r101[r100].close();
        r100 = r100 + 1;
        goto L6
    L8:
        return true;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    public /* bridge */ /* synthetic */ Object getResult() {
        return getResult();
    }

    public ListDataSource(DataSource<CloseableReference<T>>[] r100) {
        this.mDataSources = r100;
        this.mFinishedDataSources = 0;
    }

    public static /* synthetic */ void access$200(ListDataSource r100) {
        r100.onDataSourceCancelled();
    }

    public static /* synthetic */ void access$300(ListDataSource r100) {
        r100.onDataSourceFinished();
    }

    public static /* synthetic */ void access$400(ListDataSource r100) {
        r100.onDataSourceProgress();
    }

    public static <T> ListDataSource<T> create(DataSource<CloseableReference<T>>... r100) {
        Preconditions.checkNotNull(r100);
        int r101 = 0;
        if (r100.length <= 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkState(r102);
        ListDataSource<T> r103 = new ListDataSource(r100);
        int r104 = r100.length;
    L7:
        if (r101 >= r104) goto L12;
        DataSource<CloseableReference<T>> r105 = r100[r101];
        if (r105 == null) goto L11;
        r105.subscribe(new InternalDataSubscriber(r103, null), CallerThreadExecutor.getInstance());
    L11:
        r101 = r101 + 1;
        goto L7
    L12:
        return r103;
    L5:
        r102 = false;
        goto L6
    }

    private void onDataSourceFailed(DataSource<CloseableReference<T>> r100) {
        setFailure(r100.getFailureCause());
    }

    public static /* synthetic */ void access$100(ListDataSource r100, DataSource r101) {
        r100.onDataSourceFailed(r101);
    }
}
