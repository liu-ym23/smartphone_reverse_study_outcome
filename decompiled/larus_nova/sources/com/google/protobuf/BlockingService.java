package com.google.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public interface BlockingService {
    Message callBlockingMethod(Descriptors.MethodDescriptor r100, RpcController r101, Message r102) throws ServiceException;

    Descriptors.ServiceDescriptor getDescriptorForType();

    Message getRequestPrototype(Descriptors.MethodDescriptor r100);

    Message getResponsePrototype(Descriptors.MethodDescriptor r100);
}
