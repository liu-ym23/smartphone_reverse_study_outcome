package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public final class SettableDataSource<T> extends AbstractDataSource<CloseableReference<T>> {
    public static <V> SettableDataSource<V> create() {
        return new SettableDataSource();
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    public CloseableReference<T> getResult() {
        return CloseableReference.cloneOrNull((CloseableReference) super.getResult());
    }

    private SettableDataSource() {
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    public /* bridge */ /* synthetic */ Object getResult() {
        return getResult();
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public /* bridge */ /* synthetic */ void closeResult(@Nullable Object r100) {
        closeResult((CloseableReference) r100);
    }

    public boolean set(@Nullable CloseableReference<T> r100) {
        return super.setResult(CloseableReference.cloneOrNull(r100), true);
    }

    public boolean setException(Throwable r100) {
        return super.setFailure(r100);
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setProgress(float r100) {
        return super.setProgress(r100);
    }

    public void closeResult(@Nullable CloseableReference<T> r100) {
        CloseableReference.closeSafely(r100);
    }
}
