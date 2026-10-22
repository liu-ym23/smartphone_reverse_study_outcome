package com.bytedance.crypto.monitor.proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes15.dex */
public final class CloudSyncData extends GeneratedMessage implements CloudSyncDataOrBuilder {
    public static final int CRYPTO_MODE_FIELD_NUMBER = 1;
    public static final int DATA_SIZE_FIELD_NUMBER = 2;
    private static final CloudSyncData DEFAULT_INSTANCE = null;
    private static final Parser<CloudSyncData> PARSER = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int cryptoMode_;
    private int dataSize_;
    private byte memoizedIsInitialized;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CloudSyncDataOrBuilder {
        private int bitField0_;
        private int cryptoMode_;
        private int dataSize_;

        private Builder() {
        }

        public /* synthetic */ Builder(AnonymousClass1 r100) {
            this();
        }

        private Builder(AbstractMessage.BuilderParent r100) {
            super(r100);
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r100, AnonymousClass1 r101) {
            this(r100);
        }

        private void buildPartial0(CloudSyncData r100) {
            int r101 = this.bitField0_;
            if ((r101 & 1) == 0) goto L5;
            CloudSyncData.access$302(r100, this.cryptoMode_);
            int r102 = 1;
        L7:
            if ((r101 & 2) == 0) goto L9;
            CloudSyncData.access$402(r100, this.dataSize_);
            r102 = r102 | 2;
        L9:
            CloudSyncData.access$576(r100, r102);
            return;
        L5:
            r102 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_descriptor;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CloudSyncData build() {
            CloudSyncData r100 = buildPartial();
            if (r100.isInitialized() == false) goto L6;
            return r100;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CloudSyncData buildPartial() {
            CloudSyncData r100 = new CloudSyncData(this, null);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r100);
        L5:
            onBuilt();
            return r100;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.cryptoMode_ = 0;
            this.dataSize_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        public Builder clearCryptoMode() {
            this.bitField0_ &= -2;
            this.cryptoMode_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDataSize() {
            this.bitField0_ &= -3;
            this.dataSize_ = 0;
            onChanged();
            return this;
        }

        @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
        public int getCryptoMode() {
            return this.cryptoMode_;
        }

        @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
        public int getDataSize() {
            return this.dataSize_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CloudSyncData getDefaultInstanceForType() {
            return CloudSyncData.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_descriptor;
        }

        @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
        public boolean hasCryptoMode() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
        public boolean hasDataSize() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_fieldAccessorTable.ensureFieldAccessorsInitialized(CloudSyncData.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(CloudSyncData r100) {
            if (r100 != CloudSyncData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r100.hasCryptoMode() == false) goto L9;
            setCryptoMode(r100.getCryptoMode());
        L9:
            if (r100.hasDataSize() == false) goto L11;
            setDataSize(r100.getDataSize());
        L11:
            mergeUnknownFields(r100.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) {
            r101.getClass();
            boolean r102 = false;
        L3:
            if (r102 == true) goto L25;
            int r103 = r100.readTag();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            if (r103 == 0) goto L17;
            if (r103 == 8) goto L14;
            if (r103 != 16) goto L11;
            this.dataSize_ = r100.readUInt32();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            int r104 = this.bitField0_ | 2;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
        L15:
            this.bitField0_ = r104;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            goto L3
        L11:
            if (parseUnknownField(r100, r101, r103) == true) goto L3;
        L14:
            this.cryptoMode_ = r100.readUInt32();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
            r104 = this.bitField0_ | 1;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
        L17:
            r102 = true;
            goto L3
        L20:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            onChanged();
            throw th;
        L25:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r100) {
            if ((r100 instanceof CloudSyncData) == true) goto L5;
            super.mergeFrom(r100);
            return this;
        L5:
            return mergeFrom((CloudSyncData) r100);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r100) {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r100) {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) {
            return mergeFrom(r100, r101);
        }

        public Builder setCryptoMode(int r100) {
            this.cryptoMode_ = r100;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setDataSize(int r100) {
            this.dataSize_ = r100;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", CloudSyncData.class.getName());
        DEFAULT_INSTANCE = new CloudSyncData();
        PARSER = new AnonymousClass1();
    }

    private CloudSyncData() {
        this.cryptoMode_ = 0;
        this.dataSize_ = 0;
        this.memoizedIsInitialized = -1;
    }

    private CloudSyncData(GeneratedMessage.Builder<?> r100) {
        super(r100);
        this.cryptoMode_ = 0;
        this.dataSize_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ CloudSyncData(GeneratedMessage.Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static /* synthetic */ int access$302(CloudSyncData r100, int r101) {
        r100.cryptoMode_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$402(CloudSyncData r100, int r101) {
        r100.dataSize_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$576(CloudSyncData r100, int r101) {
        int r102 = r101 | r100.bitField0_;
        r100.bitField0_ = r102;
        return r102;
    }

    public static CloudSyncData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CloudSyncData r100) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
    }

    public static CloudSyncData parseDelimitedFrom(InputStream r100) {
        return (CloudSyncData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r100);
    }

    public static CloudSyncData parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) {
        return (CloudSyncData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r100, r101);
    }

    public static CloudSyncData parseFrom(ByteString r100) {
        return PARSER.parseFrom(r100);
    }

    public static CloudSyncData parseFrom(ByteString r100, ExtensionRegistryLite r101) {
        return PARSER.parseFrom(r100, r101);
    }

    public static CloudSyncData parseFrom(CodedInputStream r100) {
        return (CloudSyncData) GeneratedMessage.parseWithIOException(PARSER, r100);
    }

    public static CloudSyncData parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) {
        return (CloudSyncData) GeneratedMessage.parseWithIOException(PARSER, r100, r101);
    }

    public static CloudSyncData parseFrom(InputStream r100) {
        return (CloudSyncData) GeneratedMessage.parseWithIOException(PARSER, r100);
    }

    public static CloudSyncData parseFrom(InputStream r100, ExtensionRegistryLite r101) {
        return (CloudSyncData) GeneratedMessage.parseWithIOException(PARSER, r100, r101);
    }

    public static CloudSyncData parseFrom(ByteBuffer r100) {
        return PARSER.parseFrom(r100);
    }

    public static CloudSyncData parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) {
        return PARSER.parseFrom(r100, r101);
    }

    public static CloudSyncData parseFrom(byte[] r100) {
        return PARSER.parseFrom(r100);
    }

    public static CloudSyncData parseFrom(byte[] r100, ExtensionRegistryLite r101) {
        return PARSER.parseFrom(r100, r101);
    }

    public static Parser<CloudSyncData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof CloudSyncData) == false) goto L8;
        CloudSyncData r101 = (CloudSyncData) r100;
        if (hasCryptoMode() == r101.hasCryptoMode()) goto L13;
        return false;
    L13:
        if (hasCryptoMode() == false) goto L18;
        if (getCryptoMode() == r101.getCryptoMode()) goto L18;
        return false;
    L18:
        if (hasDataSize() == r101.hasDataSize()) goto L21;
        return false;
    L21:
        if (hasDataSize() == false) goto L26;
        if (getDataSize() == r101.getDataSize()) goto L26;
        return false;
    L26:
        if (getUnknownFields().equals(r101.getUnknownFields()) == true) goto L28;
        return false;
    L28:
        return true;
    L8:
        return super.equals(r100);
    }

    @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
    public int getCryptoMode() {
        return this.cryptoMode_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
    public int getDataSize() {
        return this.dataSize_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CloudSyncData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CloudSyncData> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r100 = this.memoizedSize;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        int r101 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r101 = 0 + CodedOutputStream.computeUInt32Size(1, this.cryptoMode_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L11;
        r101 = r101 + CodedOutputStream.computeUInt32Size(2, this.dataSize_);
    L11:
        int r102 = r101 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r102;
        return r102;
    }

    @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
    public boolean hasCryptoMode() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.crypto.monitor.proto.CloudSyncDataOrBuilder
    public boolean hasDataSize() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r100 = this.memoizedHashCode;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        int r101 = getDescriptor().hashCode() + 779;
        if (hasCryptoMode() == false) goto L9;
        r101 = (((r101 * 37) + 1) * 53) + getCryptoMode();
    L9:
        if (hasDataSize() == false) goto L11;
        r101 = (((r101 * 37) + 2) * 53) + getDataSize();
    L11:
        int r102 = (r101 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r102;
        return r102;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CloudSyncData_fieldAccessorTable.ensureFieldAccessorsInitialized(CloudSyncData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r100 = this.memoizedIsInitialized;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 0) goto L8;
        return false;
    L8:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r100) {
        return new Builder(r100, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r100) {
        return newBuilderForType(r100);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r100 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r100);
    L6:
        return new Builder(r100).mergeFrom(this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r100) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r100.writeUInt32(1, this.cryptoMode_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L8;
        r100.writeUInt32(2, this.dataSize_);
    L8:
        getUnknownFields().writeTo(r100);
    }
}
