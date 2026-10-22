package com.huawei.hms.support.api.client;

import com.huawei.hms.support.api.client.Result;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ConvertedResult<R extends Result> {
    public abstract <S extends Result> ConvertedResult<S> convertResult(ResultConvert<? super R, ? extends S> r100);

    public abstract void finalExec(ResultCallbacks<? super R> r100);

    public ConvertedResult() {
    }
}
