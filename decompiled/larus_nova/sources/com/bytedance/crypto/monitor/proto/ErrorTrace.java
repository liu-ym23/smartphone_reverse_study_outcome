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
import com.google.protobuf.SingleFieldBuilder;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes15.dex */
public final class ErrorTrace extends GeneratedMessage implements ErrorTraceOrBuilder {
    public static final int CLOUD_SYNC_DATA_FIELD_NUMBER = 100;
    private static final ErrorTrace DEFAULT_INSTANCE = null;
    public static final int ERR_CODE_FIELD_NUMBER = 4;
    public static final int EVENT_ID_FIELD_NUMBER = 2;
    public static final int MODULE_ID_FIELD_NUMBER = 1;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 3;
    private static final Parser<ErrorTrace> PARSER = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private CloudSyncData cloudSyncData_;
    private int errCode_;
    private int eventId_;
    private byte memoizedIsInitialized;
    private int moduleId_;
    private volatile Object packageName_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ErrorTraceOrBuilder {
        private int bitField0_;
        private SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> cloudSyncDataBuilder_;
        private CloudSyncData cloudSyncData_;
        private int errCode_;
        private int eventId_;
        private int moduleId_;
        private Object packageName_;

        private Builder() {
            this.packageName_ = "";
            maybeForceBuilderInitialization();
        }

        public /* synthetic */ Builder(AnonymousClass1 r100) {
            this();
        }

        private Builder(AbstractMessage.BuilderParent r100) {
            super(r100);
            this.packageName_ = "";
            maybeForceBuilderInitialization();
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r100, AnonymousClass1 r101) {
            this(r100);
        }

        private void buildPartial0(ErrorTrace r100) {
            int r101 = this.bitField0_;
            if ((r101 & 1) == 0) goto L5;
            ErrorTrace.access$402(r100, this.moduleId_);
            int r102 = 1;
        L7:
            if ((r101 & 2) == 0) goto L10;
            ErrorTrace.access$502(r100, this.eventId_);
            r102 = r102 | 2;
        L10:
            if ((r101 & 4) == 0) goto L13;
            ErrorTrace.access$602(r100, this.packageName_);
            r102 = r102 | 4;
        L13:
            if ((r101 & 8) == 0) goto L16;
            ErrorTrace.access$702(r100, this.errCode_);
            r102 = r102 | 8;
        L16:
            if ((r101 & 16) == 0) goto L22;
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r103 = this.cloudSyncDataBuilder_;
            if (r103 != null) goto L20;
            CloudSyncData r104 = this.cloudSyncData_;
        L21:
            ErrorTrace.access$802(r100, r104);
            r102 = r102 | 16;
            goto L22
        L20:
            r104 = (CloudSyncData) r103.build();
        L22:
            ErrorTrace.access$976(r100, r102);
            return;
        L5:
            r102 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_descriptor;
        }

        private SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> internalGetCloudSyncDataFieldBuilder() {
            if (this.cloudSyncDataBuilder_ != null) goto L6;
            this.cloudSyncDataBuilder_ = new SingleFieldBuilder(getCloudSyncData(), getParentForChildren(), isClean());
            this.cloudSyncData_ = null;
        L6:
            return this.cloudSyncDataBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (ErrorTrace.access$200() == false) goto L6;
            internalGetCloudSyncDataFieldBuilder();
            return;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ErrorTrace build() {
            ErrorTrace r100 = buildPartial();
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
        public ErrorTrace buildPartial() {
            ErrorTrace r100 = new ErrorTrace(this, null);
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
            this.moduleId_ = 0;
            this.eventId_ = 0;
            this.packageName_ = "";
            this.errCode_ = 0;
            this.cloudSyncData_ = null;
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r100 = this.cloudSyncDataBuilder_;
            if (r100 == null) goto L5;
            r100.dispose();
            this.cloudSyncDataBuilder_ = null;
        L5:
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

        public Builder clearCloudSyncData() {
            this.bitField0_ &= -17;
            this.cloudSyncData_ = null;
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r100 = this.cloudSyncDataBuilder_;
            if (r100 == null) goto L5;
            r100.dispose();
            this.cloudSyncDataBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearErrCode() {
            this.bitField0_ &= -9;
            this.errCode_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEventId() {
            this.bitField0_ &= -3;
            this.eventId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearModuleId() {
            this.bitField0_ &= -2;
            this.moduleId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPackageName() {
            this.packageName_ = ErrorTrace.getDefaultInstance().getPackageName();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public CloudSyncData getCloudSyncData() {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r100 = this.cloudSyncDataBuilder_;
            if (r100 != null) goto L9;
            CloudSyncData r101 = this.cloudSyncData_;
            if (r101 == null) goto L7;
            return r101;
        L7:
            return CloudSyncData.getDefaultInstance();
        L9:
            return (CloudSyncData) r100.getMessage();
        }

        public CloudSyncData.Builder getCloudSyncDataBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (CloudSyncData.Builder) internalGetCloudSyncDataFieldBuilder().getBuilder();
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public CloudSyncDataOrBuilder getCloudSyncDataOrBuilder() {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r100 = this.cloudSyncDataBuilder_;
            if (r100 != null) goto L5;
            CloudSyncData r101 = this.cloudSyncData_;
            if (r101 == null) goto L9;
            return r101;
        L9:
            return CloudSyncData.getDefaultInstance();
        L5:
            return (CloudSyncDataOrBuilder) r100.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ErrorTrace getDefaultInstanceForType() {
            return ErrorTrace.getDefaultInstance();
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
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_descriptor;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public int getEventId() {
            return this.eventId_;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public int getModuleId() {
            return this.moduleId_;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public String getPackageName() {
            Object r100 = this.packageName_;
            if ((r100 instanceof String) == true) goto L9;
            ByteString r101 = (ByteString) r100;
            String r102 = r101.toStringUtf8();
            if (r101.isValidUtf8() == false) goto L7;
            this.packageName_ = r102;
        L7:
            return r102;
        L9:
            return (String) r100;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public ByteString getPackageNameBytes() {
            Object r100 = this.packageName_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.packageName_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public boolean hasCloudSyncData() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public boolean hasErrCode() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public boolean hasEventId() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public boolean hasModuleId() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
        public boolean hasPackageName() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_fieldAccessorTable.ensureFieldAccessorsInitialized(ErrorTrace.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeCloudSyncData(CloudSyncData r100) {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r101 = this.cloudSyncDataBuilder_;
            if (r101 == null) goto L5;
            r101.mergeFrom(r100);
        L14:
            if (this.cloudSyncData_ == null) goto L16;
            this.bitField0_ |= 16;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 16) == 0) goto L11;
            CloudSyncData r102 = this.cloudSyncData_;
            if (r102 == null) goto L11;
            if (r102 == CloudSyncData.getDefaultInstance()) goto L11;
            getCloudSyncDataBuilder().mergeFrom(r100);
        L11:
            this.cloudSyncData_ = r100;
            goto L14
        }

        public Builder mergeFrom(ErrorTrace r100) {
            if (r100 != ErrorTrace.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r100.hasModuleId() == false) goto L9;
            setModuleId(r100.getModuleId());
        L9:
            if (r100.hasEventId() == false) goto L12;
            setEventId(r100.getEventId());
        L12:
            if (r100.hasPackageName() == false) goto L15;
            this.packageName_ = ErrorTrace.access$600(r100);
            this.bitField0_ |= 4;
            onChanged();
        L15:
            if (r100.hasErrCode() == false) goto L18;
            setErrCode(r100.getErrCode());
        L18:
            if (r100.hasCloudSyncData() == false) goto L20;
            mergeCloudSyncData(r100.getCloudSyncData());
        L20:
            mergeUnknownFields(r100.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) {
            r101.getClass();
            boolean r102 = false;
        L3:
            if (r102 == true) goto L34;
            int r103 = r100.readTag();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            if (r103 == 0) goto L26;
            if (r103 == 8) goto L23;
            if (r103 == 16) goto L22;
            if (r103 == 26) goto L21;
            if (r103 == 32) goto L20;
            if (r103 != 802) goto L17;
            r100.readMessage(internalGetCloudSyncDataFieldBuilder().getBuilder(), r101);     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            int r104 = this.bitField0_ | 16;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
        L24:
            this.bitField0_ = r104;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L3
        L17:
            if (parseUnknownField(r100, r101, r103) == true) goto L3;
        L20:
            this.errCode_ = r100.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            r104 = this.bitField0_ | 8;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L24
        L21:
            this.packageName_ = r100.readBytes();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            r104 = this.bitField0_ | 4;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L24
        L22:
            this.eventId_ = r100.readUInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            r104 = this.bitField0_ | 2;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L24
        L23:
            this.moduleId_ = r100.readUInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            r104 = this.bitField0_ | 1;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
        L26:
            r102 = true;
            goto L3
        L29:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            onChanged();
            throw th;
        L34:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r100) {
            if ((r100 instanceof ErrorTrace) == true) goto L5;
            super.mergeFrom(r100);
            return this;
        L5:
            return mergeFrom((ErrorTrace) r100);
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

        public Builder setCloudSyncData(CloudSyncData.Builder r100) {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r101 = this.cloudSyncDataBuilder_;
            CloudSyncData r102 = r100.build();
            if (r101 != null) goto L5;
            this.cloudSyncData_ = r102;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r101.setMessage(r102);
            goto L6
        }

        public Builder setCloudSyncData(CloudSyncData r100) {
            SingleFieldBuilder<CloudSyncData, CloudSyncData.Builder, CloudSyncDataOrBuilder> r101 = this.cloudSyncDataBuilder_;
            if (r101 != null) goto L5;
            r100.getClass();
            this.cloudSyncData_ = r100;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r101.setMessage(r100);
            goto L6
        }

        public Builder setErrCode(int r100) {
            this.errCode_ = r100;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setEventId(int r100) {
            this.eventId_ = r100;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setModuleId(int r100) {
            this.moduleId_ = r100;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setPackageName(String r100) {
            r100.getClass();
            this.packageName_ = r100;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setPackageNameBytes(ByteString r100) {
            r100.getClass();
            this.packageName_ = r100;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", ErrorTrace.class.getName());
        DEFAULT_INSTANCE = new ErrorTrace();
        PARSER = new AnonymousClass1();
    }

    private ErrorTrace() {
        this.moduleId_ = 0;
        this.eventId_ = 0;
        this.packageName_ = "";
        this.errCode_ = 0;
        this.memoizedIsInitialized = -1;
        this.packageName_ = "";
    }

    private ErrorTrace(GeneratedMessage.Builder<?> r100) {
        super(r100);
        this.moduleId_ = 0;
        this.eventId_ = 0;
        this.packageName_ = "";
        this.errCode_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ ErrorTrace(GeneratedMessage.Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static /* synthetic */ boolean access$200() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ int access$402(ErrorTrace r100, int r101) {
        r100.moduleId_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$502(ErrorTrace r100, int r101) {
        r100.eventId_ = r101;
        return r101;
    }

    public static /* synthetic */ Object access$600(ErrorTrace r100) {
        return r100.packageName_;
    }

    public static /* synthetic */ Object access$602(ErrorTrace r100, Object r101) {
        r100.packageName_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$702(ErrorTrace r100, int r101) {
        r100.errCode_ = r101;
        return r101;
    }

    public static /* synthetic */ CloudSyncData access$802(ErrorTrace r100, CloudSyncData r101) {
        r100.cloudSyncData_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$976(ErrorTrace r100, int r101) {
        int r102 = r101 | r100.bitField0_;
        r100.bitField0_ = r102;
        return r102;
    }

    public static ErrorTrace getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ErrorTrace r100) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
    }

    public static ErrorTrace parseDelimitedFrom(InputStream r100) {
        return (ErrorTrace) GeneratedMessage.parseDelimitedWithIOException(PARSER, r100);
    }

    public static ErrorTrace parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) {
        return (ErrorTrace) GeneratedMessage.parseDelimitedWithIOException(PARSER, r100, r101);
    }

    public static ErrorTrace parseFrom(ByteString r100) {
        return PARSER.parseFrom(r100);
    }

    public static ErrorTrace parseFrom(ByteString r100, ExtensionRegistryLite r101) {
        return PARSER.parseFrom(r100, r101);
    }

    public static ErrorTrace parseFrom(CodedInputStream r100) {
        return (ErrorTrace) GeneratedMessage.parseWithIOException(PARSER, r100);
    }

    public static ErrorTrace parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) {
        return (ErrorTrace) GeneratedMessage.parseWithIOException(PARSER, r100, r101);
    }

    public static ErrorTrace parseFrom(InputStream r100) {
        return (ErrorTrace) GeneratedMessage.parseWithIOException(PARSER, r100);
    }

    public static ErrorTrace parseFrom(InputStream r100, ExtensionRegistryLite r101) {
        return (ErrorTrace) GeneratedMessage.parseWithIOException(PARSER, r100, r101);
    }

    public static ErrorTrace parseFrom(ByteBuffer r100) {
        return PARSER.parseFrom(r100);
    }

    public static ErrorTrace parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) {
        return PARSER.parseFrom(r100, r101);
    }

    public static ErrorTrace parseFrom(byte[] r100) {
        return PARSER.parseFrom(r100);
    }

    public static ErrorTrace parseFrom(byte[] r100, ExtensionRegistryLite r101) {
        return PARSER.parseFrom(r100, r101);
    }

    public static Parser<ErrorTrace> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ErrorTrace) == false) goto L8;
        ErrorTrace r101 = (ErrorTrace) r100;
        if (hasModuleId() == r101.hasModuleId()) goto L13;
        return false;
    L13:
        if (hasModuleId() == false) goto L18;
        if (getModuleId() == r101.getModuleId()) goto L18;
        return false;
    L18:
        if (hasEventId() == r101.hasEventId()) goto L21;
        return false;
    L21:
        if (hasEventId() == false) goto L26;
        if (getEventId() == r101.getEventId()) goto L26;
        return false;
    L26:
        if (hasPackageName() == r101.hasPackageName()) goto L29;
        return false;
    L29:
        if (hasPackageName() == false) goto L34;
        if (getPackageName().equals(r101.getPackageName()) == true) goto L34;
        return false;
    L34:
        if (hasErrCode() == r101.hasErrCode()) goto L37;
        return false;
    L37:
        if (hasErrCode() == false) goto L42;
        if (getErrCode() == r101.getErrCode()) goto L42;
        return false;
    L42:
        if (hasCloudSyncData() == r101.hasCloudSyncData()) goto L45;
        return false;
    L45:
        if (hasCloudSyncData() == false) goto L50;
        if (getCloudSyncData().equals(r101.getCloudSyncData()) == true) goto L50;
        return false;
    L50:
        if (getUnknownFields().equals(r101.getUnknownFields()) == true) goto L52;
        return false;
    L52:
        return true;
    L8:
        return super.equals(r100);
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public CloudSyncData getCloudSyncData() {
        CloudSyncData r100 = this.cloudSyncData_;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CloudSyncData.getDefaultInstance();
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public CloudSyncDataOrBuilder getCloudSyncDataOrBuilder() {
        CloudSyncData r100 = this.cloudSyncData_;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CloudSyncData.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ErrorTrace getDefaultInstanceForType() {
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

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public int getErrCode() {
        return this.errCode_;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public int getEventId() {
        return this.eventId_;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public int getModuleId() {
        return this.moduleId_;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public String getPackageName() {
        Object r100 = this.packageName_;
        if ((r100 instanceof String) == true) goto L5;
        ByteString r101 = (ByteString) r100;
        String r102 = r101.toStringUtf8();
        if (r101.isValidUtf8() == false) goto L9;
        this.packageName_ = r102;
    L9:
        return r102;
    L5:
        return (String) r100;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public ByteString getPackageNameBytes() {
        Object r100 = this.packageName_;
        if ((r100 instanceof String) == false) goto L7;
        ByteString r101 = ByteString.copyFromUtf8((String) r100);
        this.packageName_ = r101;
        return r101;
    L7:
        return (ByteString) r100;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ErrorTrace> getParserForType() {
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
        r101 = 0 + CodedOutputStream.computeUInt32Size(1, this.moduleId_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r101 = r101 + CodedOutputStream.computeUInt32Size(2, this.eventId_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r101 = r101 + GeneratedMessage.computeStringSize(3, this.packageName_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r101 = r101 + CodedOutputStream.computeInt32Size(4, this.errCode_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L20;
        r101 = r101 + CodedOutputStream.computeMessageSize(100, getCloudSyncData());
    L20:
        int r102 = r101 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r102;
        return r102;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public boolean hasCloudSyncData() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public boolean hasErrCode() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public boolean hasEventId() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public boolean hasModuleId() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.crypto.monitor.proto.ErrorTraceOrBuilder
    public boolean hasPackageName() {
        if ((this.bitField0_ & 4) == 0) goto L5;
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
        if (hasModuleId() == false) goto L9;
        r101 = (((r101 * 37) + 1) * 53) + getModuleId();
    L9:
        if (hasEventId() == false) goto L12;
        r101 = (((r101 * 37) + 2) * 53) + getEventId();
    L12:
        if (hasPackageName() == false) goto L15;
        r101 = (((r101 * 37) + 3) * 53) + getPackageName().hashCode();
    L15:
        if (hasErrCode() == false) goto L18;
        r101 = (((r101 * 37) + 4) * 53) + getErrCode();
    L18:
        if (hasCloudSyncData() == false) goto L20;
        r101 = (((r101 * 37) + 100) * 53) + getCloudSyncData().hashCode();
    L20:
        int r102 = (r101 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r102;
        return r102;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_ErrorTrace_fieldAccessorTable.ensureFieldAccessorsInitialized(ErrorTrace.class, Builder.class);
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
        r100.writeUInt32(1, this.moduleId_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r100.writeUInt32(2, this.eventId_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        GeneratedMessage.writeString(r100, 3, this.packageName_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r100.writeInt32(4, this.errCode_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L17;
        r100.writeMessage(100, getCloudSyncData());
    L17:
        getUnknownFields().writeTo(r100);
    }
}
