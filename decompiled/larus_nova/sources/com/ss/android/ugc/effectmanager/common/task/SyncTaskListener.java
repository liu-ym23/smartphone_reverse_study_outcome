package com.ss.android.ugc.effectmanager.common.task;

/* JADX INFO: loaded from: classes40.dex */
public interface SyncTaskListener<T> {
    void onFailed(SyncTask<T> r100, ExceptionResult r101);

    void onFinally(SyncTask<T> r100);

    void onProgress(SyncTask<T> r100, int r101, long r102);

    void onResponse(SyncTask<T> r100, T r101);

    void onStart(SyncTask<T> r100);
}
