package com.google.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public interface Service {
    void callMethod(Descriptors.MethodDescriptor r100, RpcController r101, Message r102, RpcCallback<Message> r103);

    Descriptors.ServiceDescriptor getDescriptorForType();

    Message getRequestPrototype(Descriptors.MethodDescriptor r100);

    Message getResponsePrototype(Descriptors.MethodDescriptor r100);
}
