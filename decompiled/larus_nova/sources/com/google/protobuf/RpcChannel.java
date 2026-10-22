package com.google.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public interface RpcChannel {
    void callMethod(Descriptors.MethodDescriptor r100, RpcController r101, Message r102, Message r103, RpcCallback<Message> r104);
}
