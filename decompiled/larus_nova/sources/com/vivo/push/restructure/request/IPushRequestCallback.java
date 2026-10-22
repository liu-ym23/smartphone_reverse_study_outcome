package com.vivo.push.restructure.request;

/* JADX INFO: loaded from: classes41.dex */
public interface IPushRequestCallback<T> {
    void onError(int r100);

    void onSuccess(T r100);
}
