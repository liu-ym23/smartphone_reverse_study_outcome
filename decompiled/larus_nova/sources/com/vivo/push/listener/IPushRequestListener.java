package com.vivo.push.listener;

/* JADX INFO: loaded from: classes41.dex */
public interface IPushRequestListener<T, V> {
    void onFail(V r100);

    void onSuccess(T r100);
}
