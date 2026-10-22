package com.larksuite.framework.callback;

/* JADX INFO: loaded from: classes24.dex */
public interface IRequestCallback<S, E> extends ICallback {
    void onError(E r100);

    void onSuccess(S r100);
}
