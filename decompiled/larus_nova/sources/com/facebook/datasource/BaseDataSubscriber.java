package com.facebook.datasource;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BaseDataSubscriber<T> implements DataSubscriber<T> {
    public BaseDataSubscriber() {
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onCancellation(DataSource<T> r100) {
    }

    public abstract void onFailureImpl(DataSource<T> r100);

    public abstract void onNewResultImpl(DataSource<T> r100);

    @Override // com.facebook.datasource.DataSubscriber
    public void onProgressUpdate(DataSource<T> r100) {
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onFailure(DataSource<T> r100) {
        onFailureImpl(r100);     // Catch: Throwable -> L5
        r100.close();
        return;
    L5:
        th = move-exception;
        r100.close();
        throw th;
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onNewResult(DataSource<T> r100) {
        boolean r101 = r100.isFinished();
        onNewResultImpl(r100);     // Catch: Throwable -> L7
        if (r101 == false) goto L13;
        r100.close();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r101 == false) goto L10;
        r100.close();
    L10:
        throw th;
    }
}
