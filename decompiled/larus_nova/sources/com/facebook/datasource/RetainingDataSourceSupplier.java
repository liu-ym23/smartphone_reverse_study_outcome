package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Supplier;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class RetainingDataSourceSupplier<T> implements Supplier<DataSource<T>> {

    @Nullable
    private Supplier<DataSource<T>> mCurrentDataSourceSupplier;
    private final Set<RetainingDataSource> mDataSources;

    /* JADX INFO: renamed from: com.facebook.datasource.RetainingDataSourceSupplier$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class RetainingDataSource<T> extends AbstractDataSource<T> {

        @Nullable
        private DataSource<T> mDataSource;

        public class InternalDataSubscriber implements DataSubscriber<T> {
            final /* synthetic */ RetainingDataSource this$0;

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> r100) {
            }

            private InternalDataSubscriber(RetainingDataSource r100) {
                this.this$0 = r100;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> r100) {
                RetainingDataSource.access$300(this.this$0, r100);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> r100) {
                if (r100.hasResult() == false) goto L6;
                RetainingDataSource.access$200(this.this$0, r100);
                return;
            L6:
                if (r100.isFinished() == false) goto L10;
                RetainingDataSource.access$300(this.this$0, r100);
                return;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> r100) {
                RetainingDataSource.access$400(this.this$0, r100);
            }

            public /* synthetic */ InternalDataSubscriber(RetainingDataSource r100, AnonymousClass1 r101) {
                this(r100);
            }
        }

        private void onDataSourceFailed(DataSource<T> r100) {
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (super.close() == true) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L12
            return false;
        L8:
            DataSource<T> r100 = this.mDataSource;     // Catch: Throwable -> L12
            this.mDataSource = null;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            closeSafely(r100);
            return true;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @Nullable
        public synchronized T getResult() {
            monitor-enter(this);
            DataSource<T> r100 = this.mDataSource;     // Catch: Throwable -> L10
            if (r100 == null) goto L7;
            T r101 = r100.getResult();     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
            return r101;
        L7:
            r101 = null;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean hasMultipleResults() {
            return true;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean hasResult() {
            monitor-enter(this);
            DataSource<T> r100 = this.mDataSource;     // Catch: Throwable -> L11
            if (r100 == null) goto L8;
            if (r100.hasResult() == false) goto L8;
            boolean r101 = true;
        L9:
            monitor-exit(this);
            return r101;
        L8:
            r101 = false;
        L11:
            th = move-exception;
            throw th;
        }

        private RetainingDataSource() {
            this.mDataSource = null;
        }

        public /* synthetic */ RetainingDataSource(AnonymousClass1 r100) {
            this();
        }

        private static <T> void closeSafely(DataSource<T> r100) {
            if (r100 == null) goto L5;
            r100.close();
            return;
        }

        private void onDataSourceNewResult(DataSource<T> r100) {
            if (r100 != this.mDataSource) goto L6;
            setResult(null, false);
            return;
        }

        private void onDatasourceProgress(DataSource<T> r100) {
            if (r100 != this.mDataSource) goto L6;
            setProgress(r100.getProgress());
            return;
        }

        public void setSupplier(@Nullable Supplier<DataSource<T>> r100) {
            if (isClosed() == false) goto L5;
            return;
        L5:
            AnonymousClass1 r101 = null;
            if (r100 == null) goto L8;
            DataSource<T> r102 = r100.get();
        L9:
            monitor-enter(this);
        L21:
            th = move-exception;
            throw th;
        L11:
            if (isClosed() == false) goto L15;
            closeSafely(r102);     // Catch: Throwable -> L21
            monitor-exit(this);     // Catch: Throwable -> L21
            return;
        L15:
            DataSource<T> r103 = this.mDataSource;     // Catch: Throwable -> L21
            this.mDataSource = r102;     // Catch: Throwable -> L21
            monitor-exit(this);     // Catch: Throwable -> L21
            if (r102 == null) goto L19;
            r102.subscribe(new InternalDataSubscriber(this, r101), CallerThreadExecutor.getInstance());
        L19:
            closeSafely(r103);
            return;
        L8:
            r102 = null;
            goto L9
        }

        public static /* synthetic */ void access$200(RetainingDataSource r100, DataSource r101) {
            r100.onDataSourceNewResult(r101);
        }

        public static /* synthetic */ void access$300(RetainingDataSource r100, DataSource r101) {
            r100.onDataSourceFailed(r101);
        }

        public static /* synthetic */ void access$400(RetainingDataSource r100, DataSource r101) {
            r100.onDatasourceProgress(r101);
        }
    }

    @Override // com.facebook.common.internal.Supplier
    public DataSource<T> get() {
        RetainingDataSource r100 = new RetainingDataSource(null);
        r100.setSupplier(this.mCurrentDataSourceSupplier);
        this.mDataSources.add(r100);
        return r100;
    }

    public RetainingDataSourceSupplier() {
        this.mDataSources = Collections.newSetFromMap(new WeakHashMap());
        this.mCurrentDataSourceSupplier = null;
    }

    @Override // com.facebook.common.internal.Supplier
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public void replaceSupplier(Supplier<DataSource<T>> r100) {
        this.mCurrentDataSourceSupplier = r100;
        Iterator<RetainingDataSource> r101 = this.mDataSources.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        RetainingDataSource r102 = r101.next();
        if (r102.isClosed() == true) goto L4;
        r102.setSupplier(r100);
        goto L4
    }
}
