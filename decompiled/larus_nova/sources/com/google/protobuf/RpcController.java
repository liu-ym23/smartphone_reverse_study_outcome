package com.google.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public interface RpcController {
    String errorText();

    boolean failed();

    boolean isCanceled();

    void notifyOnCancel(RpcCallback<Object> r100);

    void reset();

    void setFailed(String r100);

    void startCancel();
}
