package com.bytedance.ugc.glue.http;

/* JADX INFO: loaded from: classes22.dex */
public abstract class UGCSimpleRequestWithHeader<T> extends UGCRequest<T> implements UGCCallbackWithHeader<T> {
    public UGCSimpleRequestWithHeader() {
        setCallbackWithHeader(this);
    }
}
