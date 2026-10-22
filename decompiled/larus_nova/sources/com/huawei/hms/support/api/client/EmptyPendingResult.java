package com.huawei.hms.support.api.client;

import android.os.Looper;
import com.huawei.hms.support.api.client.Result;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public class EmptyPendingResult<R extends Result> extends PendingResult<R> {
    private R result;

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void cancel() {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public boolean isCanceled() {
        return false;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(Looper r100, ResultCallback<R> r101) {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> r100) {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> r100, long r101, TimeUnit r102) {
    }

    public EmptyPendingResult() {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await() {
        return this.result;
    }

    public R getResult() {
        return this.result;
    }

    public void setResult(R r100) {
        this.result = r100;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long r100, TimeUnit r101) {
        return this.result;
    }
}
