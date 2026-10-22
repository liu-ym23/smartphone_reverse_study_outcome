package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes23.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite build();

        MessageLite buildPartial();

        Builder clear();

        Builder clone();

        boolean mergeDelimitedFrom(InputStream r100) throws IOException;

        boolean mergeDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException;

        Builder mergeFrom(ByteString r100) throws InvalidProtocolBufferException;

        Builder mergeFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

        Builder mergeFrom(CodedInputStream r100) throws IOException;

        Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException;

        Builder mergeFrom(MessageLite r100);

        Builder mergeFrom(InputStream r100) throws IOException;

        Builder mergeFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException;

        Builder mergeFrom(byte[] r100) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r100, int r101, int r102, ExtensionRegistryLite r103) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeDelimitedTo(OutputStream r100) throws IOException;

    void writeTo(CodedOutputStream r100) throws IOException;

    void writeTo(OutputStream r100) throws IOException;
}
