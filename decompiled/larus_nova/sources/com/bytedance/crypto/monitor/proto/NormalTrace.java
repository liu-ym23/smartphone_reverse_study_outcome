package com.bytedance.crypto.monitor.proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes15.dex */
public final class NormalTrace extends GeneratedMessage implements NormalTraceOrBuilder {
    public static final int APP_ID_FIELD_NUMBER = 4;
    private static final NormalTrace DEFAULT_INSTANCE = null;
    public static final int ERR_CODE_FIELD_NUMBER = 6;
    public static final int EVENT_ID_FIELD_NUMBER = 2;
    public static final int MODULE_ID_FIELD_NUMBER = 1;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 3;
    private static final Parser<NormalTrace> PARSER = null;
    public static final int TIME_CONSUMPTION_FIELD_NUMBER = 8;
    public static final int TOTAL_CALLS_FIELD_NUMBER = 7;
    public static final int TOTAL_DATA_SIZE_FIELD_NUMBER = 9;
    public static final int USERID_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private volatile Object appId_;
    private int bitField0_;
    private int errCode_;
    private int eventId_;
    private byte memoizedIsInitialized;
    private int moduleId_;
    private volatile Object packageName_;
    private long timeConsumption_;
    private int totalCalls_;
    private long totalDataSize_;
    private int userid_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements NormalTraceOrBuilder {
        private Object appId_;
        private int bitField0_;
        private int errCode_;
        private int eventId_;
        private int moduleId_;
        private Object packageName_;
        private long timeConsumption_;
        private int totalCalls_;
        private long totalDataSize_;
        private int userid_;

        private Builder() {
            this.packageName_ = "";
            this.appId_ = "";
        }

        public /* synthetic */ Builder(AnonymousClass1 r100) {
            this();
        }

        private Builder(AbstractMessage.BuilderParent r100) {
            super(r100);
            this.packageName_ = "";
            this.appId_ = "";
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r100, AnonymousClass1 r101) {
            this(r100);
        }

        private void buildPartial0(NormalTrace r100) {
            int r101 = this.bitField0_;
            if ((r101 & 1) == 0) goto L5;
            NormalTrace.access$302(r100, this.moduleId_);
            int r102 = 1;
        L7:
            if ((r101 & 2) == 0) goto L10;
            NormalTrace.access$402(r100, this.eventId_);
            r102 = r102 | 2;
        L10:
            if ((r101 & 4) == 0) goto L13;
            NormalTrace.access$502(r100, this.packageName_);
            r102 = r102 | 4;
        L13:
            if ((r101 & 8) == 0) goto L16;
            NormalTrace.access$602(r100, this.appId_);
            r102 = r102 | 8;
        L16:
            if ((r101 & 16) == 0) goto L19;
            NormalTrace.access$702(r100, this.userid_);
            r102 = r102 | 16;
        L19:
            if ((r101 & 32) == 0) goto L22;
            NormalTrace.access$802(r100, this.errCode_);
            r102 = r102 | 32;
        L22:
            if ((r101 & 64) == 0) goto L25;
            NormalTrace.access$902(r100, this.totalCalls_);
            r102 = r102 | 64;
        L25:
            if ((r101 & 128) == 0) goto L28;
            NormalTrace.access$1002(r100, this.timeConsumption_);
            r102 = r102 | 128;
        L28:
            if ((r101 & 256) == 0) goto L30;
            NormalTrace.access$1102(r100, this.totalDataSize_);
            r102 = r102 | 256;
        L30:
            NormalTrace.access$1276(r100, r102);
            return;
        L5:
            r102 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_descriptor;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NormalTrace build() {
            NormalTrace r100 = buildPartial();
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
        public NormalTrace buildPartial() {
            NormalTrace r100 = new NormalTrace(this, null);
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
            this.appId_ = "";
            this.userid_ = 0;
            this.errCode_ = 0;
            this.totalCalls_ = 0;
            this.timeConsumption_ = 0;
            this.totalDataSize_ = 0;
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

        public Builder clearAppId() {
            this.appId_ = NormalTrace.getDefaultInstance().getAppId();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder clearErrCode() {
            this.bitField0_ &= -33;
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
            this.packageName_ = NormalTrace.getDefaultInstance().getPackageName();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearTimeConsumption() {
            this.bitField0_ &= -129;
            this.timeConsumption_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalCalls() {
            this.bitField0_ &= -65;
            this.totalCalls_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalDataSize() {
            this.bitField0_ &= -257;
            this.totalDataSize_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUserid() {
            this.bitField0_ &= -17;
            this.userid_ = 0;
            onChanged();
            return this;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public String getAppId() {
            Object r100 = this.appId_;
            if ((r100 instanceof String) == true) goto L9;
            ByteString r101 = (ByteString) r100;
            String r102 = r101.toStringUtf8();
            if (r101.isValidUtf8() == false) goto L7;
            this.appId_ = r102;
        L7:
            return r102;
        L9:
            return (String) r100;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public ByteString getAppIdBytes() {
            Object r100 = this.appId_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.appId_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public NormalTrace getDefaultInstanceForType() {
            return NormalTrace.getDefaultInstance();
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
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_descriptor;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public int getErrCode() {
            return this.errCode_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public int getEventId() {
            return this.eventId_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public int getModuleId() {
            return this.moduleId_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
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

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public ByteString getPackageNameBytes() {
            Object r100 = this.packageName_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.packageName_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public long getTimeConsumption() {
            return this.timeConsumption_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public int getTotalCalls() {
            return this.totalCalls_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public long getTotalDataSize() {
            return this.totalDataSize_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public int getUserid() {
            return this.userid_;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasAppId() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasErrCode() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasEventId() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasModuleId() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasPackageName() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasTimeConsumption() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasTotalCalls() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasTotalDataSize() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
        public boolean hasUserid() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_fieldAccessorTable.ensureFieldAccessorsInitialized(NormalTrace.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(NormalTrace r100) {
            if (r100 != NormalTrace.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r100.hasModuleId() == false) goto L9;
            setModuleId(r100.getModuleId());
        L9:
            if (r100.hasEventId() == false) goto L12;
            setEventId(r100.getEventId());
        L12:
            if (r100.hasPackageName() == false) goto L15;
            this.packageName_ = NormalTrace.access$500(r100);
            this.bitField0_ |= 4;
            onChanged();
        L15:
            if (r100.hasAppId() == false) goto L18;
            this.appId_ = NormalTrace.access$600(r100);
            this.bitField0_ |= 8;
            onChanged();
        L18:
            if (r100.hasUserid() == false) goto L21;
            setUserid(r100.getUserid());
        L21:
            if (r100.hasErrCode() == false) goto L24;
            setErrCode(r100.getErrCode());
        L24:
            if (r100.hasTotalCalls() == false) goto L27;
            setTotalCalls(r100.getTotalCalls());
        L27:
            if (r100.hasTimeConsumption() == false) goto L30;
            setTimeConsumption(r100.getTimeConsumption());
        L30:
            if (r100.hasTotalDataSize() == false) goto L32;
            setTotalDataSize(r100.getTotalDataSize());
        L32:
            mergeUnknownFields(r100.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) {
            r101.getClass();
            boolean r102 = false;
        L3:
            if (r102 == true) goto L46;
            int r103 = r100.readTag();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            if (r103 == 0) goto L38;
            if (r103 == 8) goto L35;
            int r104 = 16;
            if (r103 == 16) goto L34;
            if (r103 == 26) goto L33;
            if (r103 == 34) goto L32;
            if (r103 == 40) goto L30;
            if (r103 == 48) goto L29;
            r104 = 64;
            if (r103 == 56) goto L28;
            if (r103 == 64) goto L27;
            if (r103 != 72) goto L24;
            this.totalDataSize_ = r100.readUInt64();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            int r105 = this.bitField0_ | 256;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L36:
            this.bitField0_ = r105;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L3
        L24:
            if (parseUnknownField(r100, r101, r103) == true) goto L3;
        L27:
            this.timeConsumption_ = r100.readUInt64();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r105 = this.bitField0_ | 128;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L28:
            this.totalCalls_ = r100.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L31:
            r105 = this.bitField0_ | r104;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L29:
            this.errCode_ = r100.readInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r105 = this.bitField0_ | 32;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L30:
            this.userid_ = r100.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L31
        L32:
            this.appId_ = r100.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r105 = this.bitField0_ | 8;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L33:
            this.packageName_ = r100.readBytes();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r105 = this.bitField0_ | 4;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L34:
            this.eventId_ = r100.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r105 = this.bitField0_ | 2;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            goto L36
        L35:
            this.moduleId_ = r100.readUInt32();     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
            r105 = this.bitField0_ | 1;     // Catch: Throwable -> L39 InvalidProtocolBufferException -> L41
        L38:
            r102 = true;
            goto L3
        L39:
            th = move-exception;
            onChanged();
            throw th;
        L41:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L39
        L46:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r100) {
            if ((r100 instanceof NormalTrace) == true) goto L5;
            super.mergeFrom(r100);
            return this;
        L5:
            return mergeFrom((NormalTrace) r100);
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

        public Builder setAppId(String r100) {
            r100.getClass();
            this.appId_ = r100;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setAppIdBytes(ByteString r100) {
            r100.getClass();
            this.appId_ = r100;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setErrCode(int r100) {
            this.errCode_ = r100;
            this.bitField0_ |= 32;
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

        public Builder setTimeConsumption(long r100) {
            this.timeConsumption_ = r100;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setTotalCalls(int r100) {
            this.totalCalls_ = r100;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setTotalDataSize(long r100) {
            this.totalDataSize_ = r100;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setUserid(int r100) {
            this.userid_ = r100;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", NormalTrace.class.getName());
        DEFAULT_INSTANCE = new NormalTrace();
        PARSER = new AnonymousClass1();
    }

    private NormalTrace() {
        this.moduleId_ = 0;
        this.eventId_ = 0;
        this.packageName_ = "";
        this.appId_ = "";
        this.userid_ = 0;
        this.errCode_ = 0;
        this.totalCalls_ = 0;
        this.timeConsumption_ = 0;
        this.totalDataSize_ = 0;
        this.memoizedIsInitialized = -1;
        this.packageName_ = "";
        this.appId_ = "";
    }

    private NormalTrace(GeneratedMessage.Builder<?> r100) {
        super(r100);
        this.moduleId_ = 0;
        this.eventId_ = 0;
        this.packageName_ = "";
        this.appId_ = "";
        this.userid_ = 0;
        this.errCode_ = 0;
        this.totalCalls_ = 0;
        this.timeConsumption_ = 0;
        this.totalDataSize_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ NormalTrace(GeneratedMessage.Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static /* synthetic */ long access$1002(NormalTrace r100, long r101) {
        r100.timeConsumption_ = r101;
        return r101;
    }

    public static /* synthetic */ long access$1102(NormalTrace r100, long r101) {
        r100.totalDataSize_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$1276(NormalTrace r100, int r101) {
        int r102 = r101 | r100.bitField0_;
        r100.bitField0_ = r102;
        return r102;
    }

    public static /* synthetic */ int access$302(NormalTrace r100, int r101) {
        r100.moduleId_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$402(NormalTrace r100, int r101) {
        r100.eventId_ = r101;
        return r101;
    }

    public static /* synthetic */ Object access$500(NormalTrace r100) {
        return r100.packageName_;
    }

    public static /* synthetic */ Object access$502(NormalTrace r100, Object r101) {
        r100.packageName_ = r101;
        return r101;
    }

    public static /* synthetic */ Object access$600(NormalTrace r100) {
        return r100.appId_;
    }

    public static /* synthetic */ Object access$602(NormalTrace r100, Object r101) {
        r100.appId_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$702(NormalTrace r100, int r101) {
        r100.userid_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$802(NormalTrace r100, int r101) {
        r100.errCode_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$902(NormalTrace r100, int r101) {
        r100.totalCalls_ = r101;
        return r101;
    }

    public static NormalTrace getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(NormalTrace r100) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
    }

    public static NormalTrace parseDelimitedFrom(InputStream r100) {
        return (NormalTrace) GeneratedMessage.parseDelimitedWithIOException(PARSER, r100);
    }

    public static NormalTrace parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) {
        return (NormalTrace) GeneratedMessage.parseDelimitedWithIOException(PARSER, r100, r101);
    }

    public static NormalTrace parseFrom(ByteString r100) {
        return PARSER.parseFrom(r100);
    }

    public static NormalTrace parseFrom(ByteString r100, ExtensionRegistryLite r101) {
        return PARSER.parseFrom(r100, r101);
    }

    public static NormalTrace parseFrom(CodedInputStream r100) {
        return (NormalTrace) GeneratedMessage.parseWithIOException(PARSER, r100);
    }

    public static NormalTrace parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) {
        return (NormalTrace) GeneratedMessage.parseWithIOException(PARSER, r100, r101);
    }

    public static NormalTrace parseFrom(InputStream r100) {
        return (NormalTrace) GeneratedMessage.parseWithIOException(PARSER, r100);
    }

    public static NormalTrace parseFrom(InputStream r100, ExtensionRegistryLite r101) {
        return (NormalTrace) GeneratedMessage.parseWithIOException(PARSER, r100, r101);
    }

    public static NormalTrace parseFrom(ByteBuffer r100) {
        return PARSER.parseFrom(r100);
    }

    public static NormalTrace parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) {
        return PARSER.parseFrom(r100, r101);
    }

    public static NormalTrace parseFrom(byte[] r100) {
        return PARSER.parseFrom(r100);
    }

    public static NormalTrace parseFrom(byte[] r100, ExtensionRegistryLite r101) {
        return PARSER.parseFrom(r100, r101);
    }

    public static Parser<NormalTrace> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof NormalTrace) == false) goto L8;
        NormalTrace r101 = (NormalTrace) r100;
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
        if (hasAppId() == r101.hasAppId()) goto L37;
        return false;
    L37:
        if (hasAppId() == false) goto L42;
        if (getAppId().equals(r101.getAppId()) == true) goto L42;
        return false;
    L42:
        if (hasUserid() == r101.hasUserid()) goto L45;
        return false;
    L45:
        if (hasUserid() == false) goto L50;
        if (getUserid() == r101.getUserid()) goto L50;
        return false;
    L50:
        if (hasErrCode() == r101.hasErrCode()) goto L53;
        return false;
    L53:
        if (hasErrCode() == false) goto L58;
        if (getErrCode() == r101.getErrCode()) goto L58;
        return false;
    L58:
        if (hasTotalCalls() == r101.hasTotalCalls()) goto L61;
        return false;
    L61:
        if (hasTotalCalls() == false) goto L66;
        if (getTotalCalls() == r101.getTotalCalls()) goto L66;
        return false;
    L66:
        if (hasTimeConsumption() == r101.hasTimeConsumption()) goto L69;
        return false;
    L69:
        if (hasTimeConsumption() == false) goto L74;
        if (getTimeConsumption() == r101.getTimeConsumption()) goto L74;
        return false;
    L74:
        if (hasTotalDataSize() == r101.hasTotalDataSize()) goto L77;
        return false;
    L77:
        if (hasTotalDataSize() == false) goto L82;
        if (getTotalDataSize() == r101.getTotalDataSize()) goto L82;
        return false;
    L82:
        if (getUnknownFields().equals(r101.getUnknownFields()) == true) goto L84;
        return false;
    L84:
        return true;
    L8:
        return super.equals(r100);
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public String getAppId() {
        Object r100 = this.appId_;
        if ((r100 instanceof String) == true) goto L5;
        ByteString r101 = (ByteString) r100;
        String r102 = r101.toStringUtf8();
        if (r101.isValidUtf8() == false) goto L9;
        this.appId_ = r102;
    L9:
        return r102;
    L5:
        return (String) r100;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public ByteString getAppIdBytes() {
        Object r100 = this.appId_;
        if ((r100 instanceof String) == false) goto L7;
        ByteString r101 = ByteString.copyFromUtf8((String) r100);
        this.appId_ = r101;
        return r101;
    L7:
        return (ByteString) r100;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public NormalTrace getDefaultInstanceForType() {
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

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public int getErrCode() {
        return this.errCode_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public int getEventId() {
        return this.eventId_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public int getModuleId() {
        return this.moduleId_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
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

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
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
    public Parser<NormalTrace> getParserForType() {
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
        r101 = r101 + GeneratedMessage.computeStringSize(4, this.appId_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r101 = r101 + CodedOutputStream.computeUInt32Size(5, this.userid_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r101 = r101 + CodedOutputStream.computeInt32Size(6, this.errCode_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r101 = r101 + CodedOutputStream.computeInt32Size(7, this.totalCalls_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r101 = r101 + CodedOutputStream.computeUInt64Size(8, this.timeConsumption_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L32;
        r101 = r101 + CodedOutputStream.computeUInt64Size(9, this.totalDataSize_);
    L32:
        int r102 = r101 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r102;
        return r102;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public long getTimeConsumption() {
        return this.timeConsumption_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public int getTotalCalls() {
        return this.totalCalls_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public long getTotalDataSize() {
        return this.totalDataSize_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public int getUserid() {
        return this.userid_;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasAppId() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasErrCode() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasEventId() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasModuleId() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasPackageName() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasTimeConsumption() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasTotalCalls() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasTotalDataSize() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.NormalTraceOrBuilder
    public boolean hasUserid() {
        if ((this.bitField0_ & 16) == 0) goto L5;
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
        if (hasAppId() == false) goto L18;
        r101 = (((r101 * 37) + 4) * 53) + getAppId().hashCode();
    L18:
        if (hasUserid() == false) goto L21;
        r101 = (((r101 * 37) + 5) * 53) + getUserid();
    L21:
        if (hasErrCode() == false) goto L24;
        r101 = (((r101 * 37) + 6) * 53) + getErrCode();
    L24:
        if (hasTotalCalls() == false) goto L27;
        r101 = (((r101 * 37) + 7) * 53) + getTotalCalls();
    L27:
        if (hasTimeConsumption() == false) goto L30;
        r101 = (((r101 * 37) + 8) * 53) + Internal.hashLong(getTimeConsumption());
    L30:
        if (hasTotalDataSize() == false) goto L32;
        r101 = (((r101 * 37) + 9) * 53) + Internal.hashLong(getTotalDataSize());
    L32:
        int r102 = (r101 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r102;
        return r102;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_NormalTrace_fieldAccessorTable.ensureFieldAccessorsInitialized(NormalTrace.class, Builder.class);
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
        GeneratedMessage.writeString(r100, 4, this.appId_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r100.writeUInt32(5, this.userid_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r100.writeInt32(6, this.errCode_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r100.writeInt32(7, this.totalCalls_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r100.writeUInt64(8, this.timeConsumption_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L29;
        r100.writeUInt64(9, this.totalDataSize_);
    L29:
        getUnknownFields().writeTo(r100);
    }
}
