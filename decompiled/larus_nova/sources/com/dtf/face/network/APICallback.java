package com.dtf.face.network;

/* JADX INFO: loaded from: classes3.dex */
public interface APICallback<T> {
    void onError(String r100, String r101, String r102);

    void onSuccess(T r100);
}
