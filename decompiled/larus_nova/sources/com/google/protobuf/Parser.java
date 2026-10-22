package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes23.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream r100) throws InvalidProtocolBufferException;

    MessageType parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString r100) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

    MessageType parseFrom(CodedInputStream r100) throws InvalidProtocolBufferException;

    MessageType parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream r100) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r100) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r100, int r101, int r102, ExtensionRegistryLite r103) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

    MessageType parsePartialDelimitedFrom(InputStream r100) throws InvalidProtocolBufferException;

    MessageType parsePartialDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(ByteString r100) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream r100) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(InputStream r100) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(InputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r100) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r100, int r101, int r102, ExtensionRegistryLite r103) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;
}
