package com.facebook.datasource;

/* JADX INFO: loaded from: classes22.dex */
public interface DataSubscriber<T> {
    void onCancellation(DataSource<T> r100);

    void onFailure(DataSource<T> r100);

    void onNewResult(DataSource<T> r100);

    void onProgressUpdate(DataSource<T> r100);
}
