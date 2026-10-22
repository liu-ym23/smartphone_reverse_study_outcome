package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = null;

    public AbstractParser() {
    }

    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }

    private MessageType checkMessageInitialized(MessageType r100) throws InvalidProtocolBufferException {
        if (r100 != null) goto L4;
    L8:
        return r100;
    L4:
        if (r100.isInitialized() == true) goto L8;
        throw newUninitializedMessageException(r100).asInvalidProtocolBufferException().setUnfinishedMessage(r100);
    }

    private UninitializedMessageException newUninitializedMessageException(MessageType r100) {
        if ((r100 instanceof AbstractMessageLite) == false) goto L7;
        return ((AbstractMessageLite) r100).newUninitializedMessageException();
    L7:
        return new UninitializedMessageException(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialDelimitedFrom(r100, r101));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public MessageType parseFrom(InputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r100, r101));
    }

    public MessageType parsePartialDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        int r102 = r100.read();     // Catch: IOException -> L9
        if (r102 != (-1)) goto L6;
        return null;
    L6:
        return (MessageType) parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(r100, CodedInputStream.readRawVarint32(r102, r100)), r101);
    L9:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage());
    }

    public MessageType parsePartialFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        CodedInputStream r102 = r100.newCodedInput();     // Catch: InvalidProtocolBufferException -> L9
        MessageType r103 = parsePartialFrom(r102, r101);     // Catch: InvalidProtocolBufferException -> L9
        r102.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L6
        return r103;
    L6:
        e = move-exception;
        throw e.setUnfinishedMessage(r103);     // Catch: InvalidProtocolBufferException -> L9
    L9:
        e = move-exception;
        throw e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public MessageType parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r100, r101));
    }

    public MessageType parsePartialFrom(InputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        CodedInputStream r102 = CodedInputStream.newInstance(r100);
        MessageType r103 = parsePartialFrom(r102, r101);
        r102.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r103;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r103);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return parseFrom(r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return parseFrom(r100, r101);
    }
}
