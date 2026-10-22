package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class FirstAvailableDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    private final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

    /* JADX INFO: renamed from: com.facebook.datasource.FirstAvailableDataSourceSupplier$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class FirstAvailableDataSource extends AbstractDataSource<T> {
        private DataSource<T> mCurrentDataSource;
        private DataSource<T> mDataSourceWithResult;
        private int mIndex;
        final /* synthetic */ FirstAvailableDataSourceSupplier this$0;

        public class InternalDataSubscriber implements DataSubscriber<T> {
            final /* synthetic */ FirstAvailableDataSource this$1;

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> r100) {
            }

            private InternalDataSubscriber(FirstAvailableDataSource r100) {
                this.this$1 = r100;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> r100) {
                FirstAvailableDataSource.access$200(this.this$1, r100);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> r100) {
                if (r100.hasResult() == false) goto L6;
                FirstAvailableDataSource.access$300(this.this$1, r100);
                return;
            L6:
                if (r100.isFinished() == false) goto L10;
                FirstAvailableDataSource.access$200(this.this$1, r100);
                return;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> r100) {
                float r101 = this.this$1.getProgress();
                this.this$1.setProgress(Math.max(r101, r100.getProgress()));
            }

            public /* synthetic */ InternalDataSubscriber(FirstAvailableDataSource r100, AnonymousClass1 r101) {
                this(r100);
            }
        }

        @Nullable
        private synchronized DataSource<T> getDataSourceWithResult() {
            monitor-enter(this);
            DataSource<T> r100 = this.mDataSourceWithResult;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        @Nullable
        private synchronized Supplier<DataSource<T>> getNextSupplier() {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (isClosed() == false) goto L6;
        L10:
            monitor-exit(this);
            return null;
        L6:
            if (this.mIndex >= FirstAvailableDataSourceSupplier.access$100(this.this$0).size()) goto L10;
            List r100 = FirstAvailableDataSourceSupplier.access$100(this.this$0);     // Catch: Throwable -> L13
            int r101 = this.mIndex;     // Catch: Throwable -> L13
            this.mIndex = r101 + 1;     // Catch: Throwable -> L13
            Supplier<DataSource<T>> r102 = (Supplier) r100.get(r101);     // Catch: Throwable -> L13
            monitor-exit(this);
            return r102;
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
            DataSource<T> r100 = this.mCurrentDataSource;     // Catch: Throwable -> L12
            this.mCurrentDataSource = null;     // Catch: Throwable -> L12
            DataSource<T> r101 = this.mDataSourceWithResult;     // Catch: Throwable -> L12
            this.mDataSourceWithResult = null;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            closeSafely(r101);
            closeSafely(r100);
            return true;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @Nullable
        public synchronized T getResult() {
            monitor-enter(this);
            DataSource<T> r100 = getDataSourceWithResult();     // Catch: Throwable -> L10
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
        public synchronized boolean hasResult() {
            monitor-enter(this);
            DataSource<T> r100 = getDataSourceWithResult();     // Catch: Throwable -> L11
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

        private boolean startNextDataSource() {
            Supplier<DataSource<T>> r100 = getNextSupplier();
            AnonymousClass1 r101 = null;
            if (r100 == null) goto L5;
            DataSource<T> r102 = r100.get();
        L7:
            if (setCurrentDataSource(r102) == false) goto L11;
            if (r102 == null) goto L11;
            r102.subscribe(new InternalDataSubscriber(this, r101), CallerThreadExecutor.getInstance());
            return true;
        L11:
            closeSafely(r102);
            return false;
        L5:
            r102 = null;
            goto L7
        }

        public Supplier<DataSource<T>> getCurrentSupplier() {
            if (isClosed() == false) goto L5;
            return null;
        L5:
            if (this.mIndex <= FirstAvailableDataSourceSupplier.access$100(this.this$0).size()) goto L7;
            return null;
        L7:
            return (Supplier) FirstAvailableDataSourceSupplier.access$100(this.this$0).get(this.mIndex - 1);
        }

        public FirstAvailableDataSource(FirstAvailableDataSourceSupplier r100) {
            this.this$0 = r100;
            this.mIndex = 0;
            this.mCurrentDataSource = null;
            this.mDataSourceWithResult = null;
            if (startNextDataSource() == true) goto L6;
            setFailure(new RuntimeException("No data source supplier or supplier returned null."));
            return;
        }

        private synchronized boolean clearCurrentDataSource(DataSource<T> r100) {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L4:
            if (isClosed() == false) goto L6;
        L12:
            monitor-exit(this);
            return false;
        L6:
            if (r100 != this.mCurrentDataSource) goto L12;
            this.mCurrentDataSource = null;     // Catch: Throwable -> L15
            monitor-exit(this);
            return true;
        }

        private void closeSafely(DataSource<T> r100) {
            if (r100 == null) goto L5;
            r100.close();
            return;
        }

        private void onDataSourceFailed(DataSource<T> r100) {
            if (clearCurrentDataSource(r100) == true) goto L6;
            return;
        L6:
            if (r100 == getDataSourceWithResult()) goto L9;
            closeSafely(r100);
        L9:
            if ((r100.getFailureCause() instanceof OutOfMemoryError) == false) goto L12;
            setFailure(r100.getFailureCause());
        L12:
            if (startNextDataSource() == true) goto L15;
            setFailure(r100.getFailureCause());
            return;
        }

        private void onDataSourceNewResult(DataSource<T> r100) {
            maybeSetDataSourceWithResult(r100, r100.isFinished());
            if (r100 != getDataSourceWithResult()) goto L6;
            setResult(null, r100.isFinished());
            return;
        }

        private synchronized boolean setCurrentDataSource(DataSource<T> r100) {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (isClosed() == false) goto L8;
            monitor-exit(this);
            return false;
        L8:
            this.mCurrentDataSource = r100;     // Catch: Throwable -> L12
            monitor-exit(this);
            return true;
        }

        public static /* synthetic */ void access$200(FirstAvailableDataSource r100, DataSource r101) {
            r100.onDataSourceFailed(r101);
        }

        public static /* synthetic */ void access$300(FirstAvailableDataSource r100, DataSource r101) {
            r100.onDataSourceNewResult(r101);
        }

        private void maybeSetDataSourceWithResult(DataSource<T> r100, boolean r101) {
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L4:
            if (r100 != this.mCurrentDataSource) goto L16;
            DataSource<T> r102 = this.mDataSourceWithResult;     // Catch: Throwable -> L18
            if (r100 == r102) goto L16;
            if (r102 == null) goto L12;
            if (r101 == true) goto L12;
            r102 = null;
        L13:
            monitor-exit(this);     // Catch: Throwable -> L18
            closeSafely(r102);
            return;
        L12:
            this.mDataSourceWithResult = r100;     // Catch: Throwable -> L18
        L16:
            monitor-exit(this);     // Catch: Throwable -> L18
        }
    }

    @Override // com.facebook.common.internal.Supplier
    public DataSource<T> get() {
        return new FirstAvailableDataSource(this);
    }

    public int hashCode() {
        return this.mDataSourceSuppliers.hashCode();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("list", this.mDataSourceSuppliers).toString();
    }

    @Override // com.facebook.common.internal.Supplier
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    private FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> r100) {
        Preconditions.checkArgument(!r100.isEmpty(), "List of suppliers is empty!");
        this.mDataSourceSuppliers = r100;
    }

    public static /* synthetic */ List access$100(FirstAvailableDataSourceSupplier r100) {
        return r100.mDataSourceSuppliers;
    }

    public static <T> FirstAvailableDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> r100) {
        return new FirstAvailableDataSourceSupplier(r100);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof FirstAvailableDataSourceSupplier) == true) goto L10;
        return false;
    L10:
        return Objects.equal(this.mDataSourceSuppliers, ((FirstAvailableDataSourceSupplier) r100).mDataSourceSuppliers);
    }
}
