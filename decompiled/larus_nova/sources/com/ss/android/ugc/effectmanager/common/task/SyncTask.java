package com.ss.android.ugc.effectmanager.common.task;

/* JADX INFO: loaded from: classes40.dex */
public class SyncTask<T> {
    private boolean mCanceled;
    private SyncTaskListener<T> mSyncTaskListener;

    public SyncTask() {
    }

    public void cancel() {
        this.mCanceled = true;
    }

    public void execute() {
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public void onFinally(SyncTask<T> r100) {
        SyncTaskListener<T> r101 = this.mSyncTaskListener;
        if (r101 == null) goto L6;
        r101.onFinally(r100);
        return;
    }

    public void onStart(SyncTask<T> r100) {
        SyncTaskListener<T> r101 = this.mSyncTaskListener;
        if (r101 == null) goto L6;
        r101.onStart(r100);
        return;
    }

    public void setListener(SyncTaskListener<T> r100) {
        this.mSyncTaskListener = r100;
    }

    public void onFailed(SyncTask<T> r100, ExceptionResult r101) {
        SyncTaskListener<T> r102 = this.mSyncTaskListener;
        if (r102 == null) goto L6;
        r102.onFailed(r100, r101);
        return;
    }

    public void onResponse(SyncTask<T> r100, T r101) {
        SyncTaskListener<T> r102 = this.mSyncTaskListener;
        if (r102 == null) goto L6;
        r102.onResponse(r100, r101);
        return;
    }

    public void onProgress(SyncTask<T> r100, int r101, long r102) {
        SyncTaskListener<T> r103 = this.mSyncTaskListener;
        if (r103 == null) goto L6;
        r103.onProgress(r100, r101, r102);
        return;
    }
}
