package com.huawei.hms.support.api.client;

import android.app.Activity;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    private static final String TAG = "ResolvingResultCallbacks";
    private final Activity mActivity;
    private final int requestCode;

    @Override // com.huawei.hms.support.api.client.ResultCallbacks
    public abstract void onSuccess(R r100);

    public abstract void onUnresolvableFailure(Status r100);

    @Override // com.huawei.hms.support.api.client.ResultCallbacks
    public final void onFailure(Status r100) {
    L7:
        e = move-exception;
        HMSLog.e(TAG, "Failed to start resolution: " + e);
        onUnresolvableFailure(Status.RESULT_INTERNAL_ERROR);
        return;
    L3:
        if (r100.hasResolution() == false) goto L5;
        r100.startResolutionForResult(this.mActivity, this.requestCode);     // Catch: Exception -> L7
    L10:
        return;
    L5:
        onUnresolvableFailure(r100);     // Catch: Exception -> L7
        goto L10
    }

    public ResolvingResultCallbacks(Activity r100, int r101) {
        this.mActivity = (Activity) Preconditions.checkNotNull(r100, "Activity must not be null");
        this.requestCode = r101;
    }
}
