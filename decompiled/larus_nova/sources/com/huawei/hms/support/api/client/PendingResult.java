package com.huawei.hms.support.api.client;

import android.os.Looper;
import com.huawei.hms.support.api.client.Result;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public abstract class PendingResult<R extends Result> {
    public PendingResult() {
    }

    public abstract R await();

    public abstract R await(long r100, TimeUnit r101);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(Looper r100, ResultCallback<R> r101);

    public abstract void setResultCallback(ResultCallback<R> r100);

    public abstract void setResultCallback(ResultCallback<R> r100, long r101, TimeUnit r102);

    public <S extends Result> ConvertedResult<S> convertResult(ResultConvert<? super R, ? extends S> r100) {
        throw new UnsupportedOperationException();
    }
}
