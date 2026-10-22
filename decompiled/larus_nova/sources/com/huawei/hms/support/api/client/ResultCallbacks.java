package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.Releasable;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    private static final String TAG = "ResultCallbacks";

    public ResultCallbacks() {
    }

    public abstract void onFailure(Status r100);

    public abstract void onSuccess(R r100);

    public final void onResult(R r100) {
        Status r101 = r100.getStatus();     // Catch: Exception -> L9
        if (r101.isSuccess() == false) goto L5;
        onSuccess(r100);     // Catch: Exception -> L9
    L12:
        return;
    L5:
        onFailure(r101);     // Catch: Exception -> L9
        if ((r100 instanceof Releasable) == false) goto L12;
        ((Releasable) r100).release();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        HMSLog.w(TAG, "Failed to release " + r100 + ", reason: " + e);
    }

    @Override // com.huawei.hms.support.api.client.ResultCallback
    public /* bridge */ /* synthetic */ void onResult(Object r100) {
        onResult((Result) r100);
    }
}
