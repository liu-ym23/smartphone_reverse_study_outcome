package com.huawei.hms.common.api;

import com.huawei.hms.support.api.client.Result;

/* JADX INFO: loaded from: classes23.dex */
public class Response<T extends Result> {
    protected T result;

    public Response() {
    }

    public T getResult() {
        return this.result;
    }

    public Response(T r100) {
        this.result = r100;
    }

    public void setResult(T r100) {
        this.result = r100;
    }
}
