package com.bytedance.ugc.glue.http;

/* JADX INFO: loaded from: classes22.dex */
public abstract class UGCSimpleRequest<T> extends UGCRequest<T> implements UGCCallback<T> {
    public UGCSimpleRequest() {
        setCallback(this);
    }
}
