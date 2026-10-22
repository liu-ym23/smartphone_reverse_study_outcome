package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException;
}
