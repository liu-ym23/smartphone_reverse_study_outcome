package com.huawei.hms.common.api.internal;

import android.os.Looper;
import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PendingResult<R> f277056a;

    public final void addStatusListener() {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void cancel() {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final boolean isCanceled() {
        return false;
    }

    @Override // com.huawei.hms.common.api.OptionalPendingResult
    public final boolean isDone() {
        return false;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        return (R) this.f277056a.await();
    }

    @Override // com.huawei.hms.common.api.OptionalPendingResult
    public final R get() {
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    public OptionalPendingResultImpl(PendingResult<R> r100) {
        this.f277056a = r100;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(ResultCallback<R> r100) {
        this.f277056a.setResultCallback(r100);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await(long r100, TimeUnit r101) {
        return (R) this.f277056a.await(r100, r101);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(Looper r100, ResultCallback<R> r101) {
        this.f277056a.setResultCallback(r100, r101);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(ResultCallback<R> r100, long r101, TimeUnit r102) {
        setResultCallback(r100);
    }
}
