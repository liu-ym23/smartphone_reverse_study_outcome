package com.google.protobuf;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public interface MessageOrBuilder extends MessageLiteOrBuilder {
    List<String> findInitializationErrors();

    Map<Descriptors.FieldDescriptor, Object> getAllFields();

    Message getDefaultInstanceForType();

    Descriptors.Descriptor getDescriptorForType();

    Object getField(Descriptors.FieldDescriptor r100);

    String getInitializationErrorString();

    Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r100);

    Object getRepeatedField(Descriptors.FieldDescriptor r100, int r101);

    int getRepeatedFieldCount(Descriptors.FieldDescriptor r100);

    UnknownFieldSet getUnknownFields();

    boolean hasField(Descriptors.FieldDescriptor r100);

    boolean hasOneof(Descriptors.OneofDescriptor r100);
}
