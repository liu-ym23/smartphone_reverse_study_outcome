package com.huawei.hms.support.api;

import com.huawei.hms.support.api.client.Result;

/* JADX INFO: loaded from: classes23.dex */
public class ResolveResult<T> extends Result {
    private T entity;

    public ResolveResult() {
        this.entity = null;
    }

    public T getValue() {
        return this.entity;
    }

    public ResolveResult(T r100) {
        this.entity = r100;
    }
}
