package com.facebook.datasource;

import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: classes22.dex */
public class SimpleDataSource<T> extends AbstractDataSource<T> {
    public static <T> SimpleDataSource<T> create() {
        return new SimpleDataSource();
    }

    private SimpleDataSource() {
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setFailure(Throwable r100) {
        return super.setFailure((Throwable) Preconditions.checkNotNull(r100));
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setProgress(float r100) {
        return super.setProgress(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean setResult(T r100) {
        return super.setResult(Preconditions.checkNotNull(r100), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setResult(T r100, boolean r101) {
        return super.setResult(Preconditions.checkNotNull(r100), r101);
    }
}
