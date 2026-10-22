package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class IncreasingQualityDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    private final boolean mDataSourceLazy;
    private final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

    public class IncreasingQualityDataSource extends AbstractDataSource<T> {

        @Nullable
        private ArrayList<DataSource<T>> mDataSources;

        @Nullable
        private Throwable mDelayedError;
        private AtomicInteger mFinishedDataSources;
        private int mIndexOfDataSourceWithResult;
        private int mNumberOfDataSources;
        final /* synthetic */ IncreasingQualityDataSourceSupplier this$0;

        public class InternalDataSubscriber implements DataSubscriber<T> {
            private int mIndex;
            final /* synthetic */ IncreasingQualityDataSource this$1;

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> r100) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> r100) {
                IncreasingQualityDataSource.access$300(this.this$1, this.mIndex, r100);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> r100) {
                if (r100.hasResult() == false) goto L6;
                IncreasingQualityDataSource.access$200(this.this$1, this.mIndex, r100);
                return;
            L6:
                if (r100.isFinished() == false) goto L10;
                IncreasingQualityDataSource.access$300(this.this$1, this.mIndex, r100);
                return;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> r100) {
                if (this.mIndex != 0) goto L6;
                this.this$1.setProgress(r100.getProgress());
                return;
            }

            public InternalDataSubscriber(IncreasingQualityDataSource r100, int r101) {
                this.this$1 = r100;
                this.mIndex = r101;
            }
        }

        @Nullable
        private synchronized DataSource<T> getDataSourceWithResult() {
            monitor-enter(this);
            DataSource<T> r100 = getDataSource(this.mIndexOfDataSourceWithResult);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @Nullable
        public synchronized T getResult() {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (IncreasingQualityDataSourceSupplier.access$000(this.this$0) == false) goto L6;
            ensureDataSourceInitialized();     // Catch: Throwable -> L13
        L6:
            DataSource<T> r100 = getDataSourceWithResult();     // Catch: Throwable -> L13
            if (r100 == null) goto L10;
            T r101 = r100.getResult();     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);
            return r101;
        L10:
            r101 = null;
            goto L11
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean hasResult() {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (IncreasingQualityDataSourceSupplier.access$000(this.this$0) == false) goto L6;
            ensureDataSourceInitialized();     // Catch: Throwable -> L14
        L6:
            DataSource<T> r100 = getDataSourceWithResult();     // Catch: Throwable -> L14
            if (r100 == null) goto L11;
            if (r100.hasResult() == false) goto L11;
            boolean r101 = true;
        L12:
            monitor-exit(this);
            return r101;
        L11:
            r101 = false;
            goto L12
        }

        private void ensureDataSourceInitialized() {
            if (this.mFinishedDataSources == null) goto L5;
            return;
        L5:
            monitor-enter(this);
        L16:
            th = move-exception;
            throw th;
        L7:
            if (this.mFinishedDataSources != null) goto L14;
            int r100 = 0;
            this.mFinishedDataSources = new AtomicInteger(0);     // Catch: Throwable -> L16
            int r101 = IncreasingQualityDataSourceSupplier.access$100(this.this$0).size();     // Catch: Throwable -> L16
            this.mNumberOfDataSources = r101;     // Catch: Throwable -> L16
            this.mIndexOfDataSourceWithResult = r101;     // Catch: Throwable -> L16
            this.mDataSources = new ArrayList(r101);     // Catch: Throwable -> L16
        L9:
            if (r100 >= r101) goto L14;
            DataSource<T> r102 = (DataSource) ((Supplier) IncreasingQualityDataSourceSupplier.access$100(this.this$0).get(r100)).get();     // Catch: Throwable -> L16
            this.mDataSources.add(r102);     // Catch: Throwable -> L16
            r102.subscribe(new InternalDataSubscriber(this, r100), CallerThreadExecutor.getInstance());     // Catch: Throwable -> L16
            if (r102.hasResult() == true) goto L14;
            r100 = r100 + 1;     // Catch: Throwable -> L16
        L14:
            monitor-exit(this);     // Catch: Throwable -> L16
        }

        private void maybeSetFailure() {
            if (this.mFinishedDataSources.incrementAndGet() != this.mNumberOfDataSources) goto L8;
            Throwable r100 = this.mDelayedError;
            if (r100 == null) goto L9;
            setFailure(r100);
            return;
        L9:
            return;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            if (IncreasingQualityDataSourceSupplier.access$000(this.this$0) == false) goto L5;
            ensureDataSourceInitialized();
        L5:
            monitor-enter(this);
            int r100 = 0;
            if (super.close() == true) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L18
            return false;
        L10:
            ArrayList<DataSource<T>> r101 = this.mDataSources;     // Catch: Throwable -> L18
            this.mDataSources = null;     // Catch: Throwable -> L18
            monitor-exit(this);     // Catch: Throwable -> L18
            if (r101 != null) goto L14;
            return true;
        L14:
            if (r100 >= r101.size()) goto L23;
            closeSafely(r101.get(r100));
            r100 = r100 + 1;
            goto L14
        L23:
            return true;
        L18:
            th = move-exception;
            throw th;
        }

        public ArrayList<DataSource<T>> getDataSources() {
            return this.mDataSources;
        }

        public IncreasingQualityDataSource(IncreasingQualityDataSourceSupplier r100) {
            this.this$0 = r100;
            if (IncreasingQualityDataSourceSupplier.access$000(r100) == true) goto L6;
            ensureDataSourceInitialized();
            return;
        }

        private void closeSafely(DataSource<T> r100) {
            if (r100 == null) goto L5;
            r100.close();
            return;
        }

        @Nullable
        private synchronized DataSource<T> getAndClearDataSource(int r100) {
            monitor-enter(this);
            ArrayList<DataSource<T>> r101 = this.mDataSources;     // Catch: Throwable -> L10
            DataSource<T> r102 = null;
            if (r101 != null) goto L6;
        L8:
            monitor-exit(this);
            return r102;
        L6:
            if (r100 >= r101.size()) goto L8;
            r102 = this.mDataSources.set(r100, null);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        @Nullable
        private synchronized DataSource<T> getDataSource(int r100) {
            monitor-enter(this);
            ArrayList<DataSource<T>> r101 = this.mDataSources;     // Catch: Throwable -> L12
            if (r101 != null) goto L6;
        L9:
            DataSource<T> r102 = null;
        L10:
            monitor-exit(this);
            return r102;
        L6:
            if (r100 >= r101.size()) goto L9;
            r102 = this.mDataSources.get(r100);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        private void onDataSourceFailed(int r100, DataSource<T> r101) {
            closeSafely(tryGetAndClearDataSource(r100, r101));
            if (r100 != 0) goto L5;
            this.mDelayedError = r101.getFailureCause();
        L5:
            maybeSetFailure();
        }

        private void onDataSourceNewResult(int r100, DataSource<T> r101) {
            maybeSetIndexOfDataSourceWithResult(r100, r101, r101.isFinished());
            if (r101 != getDataSourceWithResult()) goto L10;
            if (r100 == 0) goto L6;
        L8:
            boolean r102 = false;
        L9:
            setResult(null, r102);
            goto L10
        L6:
            if (r101.isFinished() == false) goto L8;
            r102 = true;
        L10:
            maybeSetFailure();
        }

        @Nullable
        private synchronized DataSource<T> tryGetAndClearDataSource(int r100, DataSource<T> r101) {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L4:
            if (r101 != getDataSourceWithResult()) goto L9;
            monitor-exit(this);
            return null;
        L9:
            if (r101 != getDataSource(r100)) goto L13;
            DataSource<T> r102 = getAndClearDataSource(r100);     // Catch: Throwable -> L15
            monitor-exit(this);
            return r102;
        L13:
            monitor-exit(this);
            return r101;
        }

        public static /* synthetic */ void access$200(IncreasingQualityDataSource r100, int r101, DataSource r102) {
            r100.onDataSourceNewResult(r101, r102);
        }

        public static /* synthetic */ void access$300(IncreasingQualityDataSource r100, int r101, DataSource r102) {
            r100.onDataSourceFailed(r101, r102);
        }

        private void maybeSetIndexOfDataSourceWithResult(int r100, DataSource<T> r101, boolean r102) {
            monitor-enter(this);
            int r103 = this.mIndexOfDataSourceWithResult;     // Catch: Throwable -> L22
            if (r101 == getDataSource(r100)) goto L6;
        L20:
            monitor-exit(this);     // Catch: Throwable -> L22
            return;
        L6:
            if (r100 == this.mIndexOfDataSourceWithResult) goto L20;
            if (getDataSourceWithResult() == null) goto L15;
            if (r102 == true) goto L12;
        L14:
            r100 = r103;
        L16:
            monitor-exit(this);     // Catch: Throwable -> L22
        L17:
            if (r103 <= r100) goto L19;
            closeSafely(getAndClearDataSource(r103));
            r103 = r103 - 1;
            goto L17
        L19:
            return;
        L12:
            if (r100 >= this.mIndexOfDataSourceWithResult) goto L14;
        L15:
            this.mIndexOfDataSourceWithResult = r100;     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;
        }
    }

    @Override // com.facebook.common.internal.Supplier
    public DataSource<T> get() {
        return new IncreasingQualityDataSource(this);
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

    public static /* synthetic */ boolean access$000(IncreasingQualityDataSourceSupplier r100) {
        return r100.mDataSourceLazy;
    }

    public static /* synthetic */ List access$100(IncreasingQualityDataSourceSupplier r100) {
        return r100.mDataSourceSuppliers;
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> r100) {
        return create(r100, false);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof IncreasingQualityDataSourceSupplier) == true) goto L10;
        return false;
    L10:
        return Objects.equal(this.mDataSourceSuppliers, ((IncreasingQualityDataSourceSupplier) r100).mDataSourceSuppliers);
    }

    private IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> r100, boolean r101) {
        Preconditions.checkArgument(!r100.isEmpty(), "List of suppliers is empty!");
        this.mDataSourceSuppliers = r100;
        this.mDataSourceLazy = r101;
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> r100, boolean r101) {
        return new IncreasingQualityDataSourceSupplier(r100, r101);
    }
}
