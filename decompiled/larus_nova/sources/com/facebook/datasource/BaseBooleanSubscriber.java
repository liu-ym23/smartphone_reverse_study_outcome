package com.facebook.datasource;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BaseBooleanSubscriber implements DataSubscriber<Boolean> {
    public BaseBooleanSubscriber() {
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onCancellation(DataSource<Boolean> r100) {
    }

    public abstract void onFailureImpl(DataSource<Boolean> r100);

    public abstract void onNewResultImpl(boolean r100);

    @Override // com.facebook.datasource.DataSubscriber
    public void onProgressUpdate(DataSource<Boolean> r100) {
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onFailure(DataSource<Boolean> r100) {
        onFailureImpl(r100);     // Catch: Throwable -> L5
        r100.close();
        return;
    L5:
        th = move-exception;
        r100.close();
        throw th;
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onNewResult(DataSource<Boolean> r100) {
        onNewResultImpl(r100.getResult().booleanValue());     // Catch: Throwable -> L5
        r100.close();
        return;
    L5:
        th = move-exception;
        r100.close();
        throw th;
    }
}
