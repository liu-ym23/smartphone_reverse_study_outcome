package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;

/* JADX INFO: loaded from: classes23.dex */
public class ResolvePendingResult<T extends IMessageEntity> extends PendingResultImpl<ResolveResult<T>, T> {
    public T get() {
        return (T) await().getValue();
    }

    @Override // com.huawei.hms.support.api.PendingResultImpl
    public ResolveResult<T> onComplete(T r100) {
        ResolveResult<T> r101 = new ResolveResult(r100);
        r101.setStatus(new Status(0));
        return r101;
    }

    @Override // com.huawei.hms.support.api.PendingResultImpl
    public /* bridge */ /* synthetic */ Result onComplete(IMessageEntity r100) {
        return onComplete(r100);
    }

    public ResolvePendingResult(ApiClient r100, String r101, IMessageEntity r102, Class<T> r103) {
        super(r100, r101, r102, r103);
    }

    public static <R extends IMessageEntity> ResolvePendingResult<R> build(ApiClient r100, String r101, IMessageEntity r102, Class<R> r103) {
        return new ResolvePendingResult(r100, r101, r102, r103);
    }
}
