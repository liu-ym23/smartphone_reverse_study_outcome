package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import java.util.concurrent.CountDownLatch;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class DataSources {

    public static class ValueHolder<T> {

        @Nullable
        public T value;

        private ValueHolder() {
            this.value = null;
        }

        public /* synthetic */ ValueHolder(AnonymousClass1 r100) {
            this();
        }
    }

    private DataSources() {
    }

    public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(final Throwable r100) {
        return new AnonymousClass1(r100);
    }

    public static <T> DataSource<T> immediateDataSource(T r100) {
        SimpleDataSource r101 = SimpleDataSource.create();
        r101.setResult(r100);
        return r101;
    }

    public static <T> DataSource<T> immediateFailedDataSource(Throwable r100) {
        SimpleDataSource r101 = SimpleDataSource.create();
        r101.setFailure(r100);
        return r101;
    }

    @Nullable
    public static <T> T waitForFinalResult(DataSource<T> r100) throws Throwable {
        final CountDownLatch r101 = new CountDownLatch(1);
        AnonymousClass1 r102 = null;
        final ValueHolder r103 = new ValueHolder(r102);
        final ValueHolder r104 = new ValueHolder(r102);
        r100.subscribe(new AnonymousClass2(r103, r101, r104), new AnonymousClass3());
        r101.await();
        T r105 = r104.value;
        if (r105 != null) goto L7;
        return r103.value;
    L7:
        throw ((Throwable) r105);
    }
}
