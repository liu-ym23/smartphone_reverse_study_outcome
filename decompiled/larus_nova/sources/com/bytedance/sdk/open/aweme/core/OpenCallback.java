package com.bytedance.sdk.open.aweme.core;

/* JADX INFO: loaded from: classes22.dex */
public interface OpenCallback<T> {
    void onFail(int r100, String r101);

    void onSuccess(T r100);
}
