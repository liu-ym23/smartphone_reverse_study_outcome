package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes23.dex */
public interface Message extends MessageLite, MessageOrBuilder {

    public interface Builder extends MessageLite.Builder, MessageOrBuilder {
        Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101);

        Message build();

        Message buildPartial();

        Builder clear();

        Builder clearField(Descriptors.FieldDescriptor r100);

        Builder clearOneof(Descriptors.OneofDescriptor r100);

        Builder clone();

        @Override // com.google.protobuf.MessageOrBuilder
        Descriptors.Descriptor getDescriptorForType();

        Builder getFieldBuilder(Descriptors.FieldDescriptor r100);

        Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r100, int r101);

        boolean mergeDelimitedFrom(InputStream r100) throws IOException;

        boolean mergeDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException;

        Builder mergeFrom(ByteString r100) throws InvalidProtocolBufferException;

        Builder mergeFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

        Builder mergeFrom(CodedInputStream r100) throws IOException;

        Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException;

        Builder mergeFrom(Message r100);

        Builder mergeFrom(InputStream r100) throws IOException;

        Builder mergeFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException;

        Builder mergeFrom(byte[] r100) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r100, int r101, int r102, ExtensionRegistryLite r103) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

        Builder mergeUnknownFields(UnknownFieldSet r100);

        Builder newBuilderForField(Descriptors.FieldDescriptor r100);

        Builder setField(Descriptors.FieldDescriptor r100, Object r101);

        Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102);

        Builder setUnknownFields(UnknownFieldSet r100);
    }

    boolean equals(Object r100);

    Parser<? extends Message> getParserForType();

    int hashCode();

    Builder newBuilderForType();

    Builder toBuilder();

    String toString();
}
