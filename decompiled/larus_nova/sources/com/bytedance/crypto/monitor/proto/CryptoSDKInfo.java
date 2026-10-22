package com.bytedance.crypto.monitor.proto;

import com.bytedance.mt.protector.impl.collections.ListProtector;
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
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.RuntimeVersion;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class CryptoSDKInfo extends GeneratedMessage implements CryptoSDKInfoOrBuilder {
    private static final CryptoSDKInfo DEFAULT_INSTANCE = null;
    public static final int ERROR_TRACE_FIELD_NUMBER = 5;
    public static final int NORMAL_TRACE_FIELD_NUMBER = 4;
    private static final Parser<CryptoSDKInfo> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    public static final int TRAIN_NUM_FIELD_NUMBER = 2;
    public static final int VERSION_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private List<ErrorTrace> errorTrace_;
    private byte memoizedIsInitialized;
    private List<NormalTrace> normalTrace_;
    private long timestamp_;
    private int trainNum_;
    private int version_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CryptoSDKInfoOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> errorTraceBuilder_;
        private List<ErrorTrace> errorTrace_;
        private RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> normalTraceBuilder_;
        private List<NormalTrace> normalTrace_;
        private long timestamp_;
        private int trainNum_;
        private int version_;

        private Builder() {
            this.normalTrace_ = Collections.emptyList();
            this.errorTrace_ = Collections.emptyList();
        }

        public /* synthetic */ Builder(AnonymousClass1 r100) {
            this();
        }

        private Builder(AbstractMessage.BuilderParent r100) {
            super(r100);
            this.normalTrace_ = Collections.emptyList();
            this.errorTrace_ = Collections.emptyList();
        }

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r100, AnonymousClass1 r101) {
            this(r100);
        }

        private void buildPartial0(CryptoSDKInfo r100) {
            int r101 = this.bitField0_;
            if ((r101 & 1) == 0) goto L5;
            CryptoSDKInfo.access$502(r100, this.version_);
            int r102 = 1;
        L7:
            if ((r101 & 2) == 0) goto L10;
            CryptoSDKInfo.access$602(r100, this.trainNum_);
            r102 = r102 | 2;
        L10:
            if ((r101 & 4) == 0) goto L12;
            CryptoSDKInfo.access$702(r100, this.timestamp_);
            r102 = r102 | 4;
        L12:
            CryptoSDKInfo.access$876(r100, r102);
            return;
        L5:
            r102 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(CryptoSDKInfo r100) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r101 = this.normalTraceBuilder_;
            if (r101 == null) goto L5;
            List r102 = r101.build();
        L9:
            CryptoSDKInfo.access$302(r100, r102);
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r103 = this.errorTraceBuilder_;
            if (r103 == null) goto L12;
            List r104 = r103.build();
        L16:
            CryptoSDKInfo.access$402(r100, r104);
            return;
        L12:
            if ((this.bitField0_ & 16) == 0) goto L14;
            this.errorTrace_ = Collections.unmodifiableList(this.errorTrace_);
            this.bitField0_ &= -17;
        L14:
            r104 = this.errorTrace_;
            goto L16
        L5:
            if ((this.bitField0_ & 8) == 0) goto L7;
            this.normalTrace_ = Collections.unmodifiableList(this.normalTrace_);
            this.bitField0_ &= -9;
        L7:
            r102 = this.normalTrace_;
            goto L9
        }

        private void ensureErrorTraceIsMutable() {
            if ((this.bitField0_ & 16) != 0) goto L6;
            this.errorTrace_ = new ArrayList(this.errorTrace_);
            this.bitField0_ |= 16;
            return;
        }

        private void ensureNormalTraceIsMutable() {
            if ((this.bitField0_ & 8) != 0) goto L6;
            this.normalTrace_ = new ArrayList(this.normalTrace_);
            this.bitField0_ |= 8;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_descriptor;
        }

        private RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> internalGetErrorTraceFieldBuilder() {
            if (this.errorTraceBuilder_ != null) goto L10;
            List<ErrorTrace> r100 = this.errorTrace_;
            if ((this.bitField0_ & 16) == 0) goto L7;
            boolean r101 = true;
        L8:
            this.errorTraceBuilder_ = new RepeatedFieldBuilder(r100, r101, getParentForChildren(), isClean());
            this.errorTrace_ = null;
            goto L10
        L7:
            r101 = false;
        L10:
            return this.errorTraceBuilder_;
        }

        private RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> internalGetNormalTraceFieldBuilder() {
            if (this.normalTraceBuilder_ != null) goto L10;
            List<NormalTrace> r100 = this.normalTrace_;
            if ((this.bitField0_ & 8) == 0) goto L7;
            boolean r101 = true;
        L8:
            this.normalTraceBuilder_ = new RepeatedFieldBuilder(r100, r101, getParentForChildren(), isClean());
            this.normalTrace_ = null;
            goto L10
        L7:
            r101 = false;
        L10:
            return this.normalTraceBuilder_;
        }

        public Builder addAllErrorTrace(Iterable<? extends ErrorTrace> r100) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r101 = this.errorTraceBuilder_;
            if (r101 != null) goto L5;
            ensureErrorTraceIsMutable();
            AbstractMessageLite.Builder.addAll(r100, this.errorTrace_);
            onChanged();
        L6:
            return this;
        L5:
            r101.addAllMessages(r100);
            goto L6
        }

        public Builder addAllNormalTrace(Iterable<? extends NormalTrace> r100) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r101 = this.normalTraceBuilder_;
            if (r101 != null) goto L5;
            ensureNormalTraceIsMutable();
            AbstractMessageLite.Builder.addAll(r100, this.normalTrace_);
            onChanged();
        L6:
            return this;
        L5:
            r101.addAllMessages(r100);
            goto L6
        }

        public Builder addErrorTrace(int r100, ErrorTrace.Builder r101) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r102 = this.errorTraceBuilder_;
            if (r102 != null) goto L5;
            ensureErrorTraceIsMutable();
            ListProtector.add(this.errorTrace_, r100, r101.build());
            onChanged();
        L6:
            return this;
        L5:
            r102.addMessage(r100, r101.build());
            goto L6
        }

        public Builder addErrorTrace(int r100, ErrorTrace r101) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r102 = this.errorTraceBuilder_;
            if (r102 != null) goto L5;
            r101.getClass();
            ensureErrorTraceIsMutable();
            ListProtector.add(this.errorTrace_, r100, r101);
            onChanged();
        L6:
            return this;
        L5:
            r102.addMessage(r100, r101);
            goto L6
        }

        public Builder addErrorTrace(ErrorTrace.Builder r100) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r101 = this.errorTraceBuilder_;
            if (r101 != null) goto L5;
            ensureErrorTraceIsMutable();
            this.errorTrace_.add(r100.build());
            onChanged();
        L6:
            return this;
        L5:
            r101.addMessage(r100.build());
            goto L6
        }

        public Builder addErrorTrace(ErrorTrace r100) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r101 = this.errorTraceBuilder_;
            if (r101 != null) goto L5;
            r100.getClass();
            ensureErrorTraceIsMutable();
            this.errorTrace_.add(r100);
            onChanged();
        L6:
            return this;
        L5:
            r101.addMessage(r100);
            goto L6
        }

        public ErrorTrace.Builder addErrorTraceBuilder() {
            return (ErrorTrace.Builder) internalGetErrorTraceFieldBuilder().addBuilder(ErrorTrace.getDefaultInstance());
        }

        public ErrorTrace.Builder addErrorTraceBuilder(int r100) {
            return (ErrorTrace.Builder) internalGetErrorTraceFieldBuilder().addBuilder(r100, ErrorTrace.getDefaultInstance());
        }

        public Builder addNormalTrace(int r100, NormalTrace.Builder r101) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r102 = this.normalTraceBuilder_;
            if (r102 != null) goto L5;
            ensureNormalTraceIsMutable();
            ListProtector.add(this.normalTrace_, r100, r101.build());
            onChanged();
        L6:
            return this;
        L5:
            r102.addMessage(r100, r101.build());
            goto L6
        }

        public Builder addNormalTrace(int r100, NormalTrace r101) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r102 = this.normalTraceBuilder_;
            if (r102 != null) goto L5;
            r101.getClass();
            ensureNormalTraceIsMutable();
            ListProtector.add(this.normalTrace_, r100, r101);
            onChanged();
        L6:
            return this;
        L5:
            r102.addMessage(r100, r101);
            goto L6
        }

        public Builder addNormalTrace(NormalTrace.Builder r100) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r101 = this.normalTraceBuilder_;
            if (r101 != null) goto L5;
            ensureNormalTraceIsMutable();
            this.normalTrace_.add(r100.build());
            onChanged();
        L6:
            return this;
        L5:
            r101.addMessage(r100.build());
            goto L6
        }

        public Builder addNormalTrace(NormalTrace r100) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r101 = this.normalTraceBuilder_;
            if (r101 != null) goto L5;
            r100.getClass();
            ensureNormalTraceIsMutable();
            this.normalTrace_.add(r100);
            onChanged();
        L6:
            return this;
        L5:
            r101.addMessage(r100);
            goto L6
        }

        public NormalTrace.Builder addNormalTraceBuilder() {
            return (NormalTrace.Builder) internalGetNormalTraceFieldBuilder().addBuilder(NormalTrace.getDefaultInstance());
        }

        public NormalTrace.Builder addNormalTraceBuilder(int r100) {
            return (NormalTrace.Builder) internalGetNormalTraceFieldBuilder().addBuilder(r100, NormalTrace.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CryptoSDKInfo build() {
            CryptoSDKInfo r100 = buildPartial();
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
        public CryptoSDKInfo buildPartial() {
            CryptoSDKInfo r100 = new CryptoSDKInfo(this, null);
            buildPartialRepeatedFields(r100);
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
            this.version_ = 0;
            this.trainNum_ = 0;
            this.timestamp_ = 0;
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r100 = this.normalTraceBuilder_;
            if (r100 != null) goto L5;
            this.normalTrace_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -9;
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r101 = this.errorTraceBuilder_;
            if (r101 != null) goto L9;
            this.errorTrace_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -17;
            return this;
        L9:
            this.errorTrace_ = null;
            r101.clear();
            goto L10
        L5:
            this.normalTrace_ = null;
            r100.clear();
            goto L6
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

        public Builder clearErrorTrace() {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r100 = this.errorTraceBuilder_;
            if (r100 != null) goto L5;
            this.errorTrace_ = Collections.emptyList();
            this.bitField0_ &= -17;
            onChanged();
        L6:
            return this;
        L5:
            r100.clear();
            goto L6
        }

        public Builder clearNormalTrace() {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r100 = this.normalTraceBuilder_;
            if (r100 != null) goto L5;
            this.normalTrace_ = Collections.emptyList();
            this.bitField0_ &= -9;
            onChanged();
        L6:
            return this;
        L5:
            r100.clear();
            goto L6
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -5;
            this.timestamp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTrainNum() {
            this.bitField0_ &= -3;
            this.trainNum_ = 0;
            onChanged();
            return this;
        }

        public Builder clearVersion() {
            this.bitField0_ &= -2;
            this.version_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CryptoSDKInfo getDefaultInstanceForType() {
            return CryptoSDKInfo.getDefaultInstance();
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
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_descriptor;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public ErrorTrace getErrorTrace(int r100) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r101 = this.errorTraceBuilder_;
            if (r101 != null) goto L7;
            Object r102 = ListProtector.get(this.errorTrace_, r100);
        L6:
            return (ErrorTrace) r102;
        L7:
            r102 = r101.getMessage(r100);
            goto L6
        }

        public ErrorTrace.Builder getErrorTraceBuilder(int r100) {
            return (ErrorTrace.Builder) internalGetErrorTraceFieldBuilder().getBuilder(r100);
        }

        public List<ErrorTrace.Builder> getErrorTraceBuilderList() {
            return internalGetErrorTraceFieldBuilder().getBuilderList();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public int getErrorTraceCount() {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r100 = this.errorTraceBuilder_;
            if (r100 != null) goto L7;
            return this.errorTrace_.size();
        L7:
            return r100.getCount();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public List<ErrorTrace> getErrorTraceList() {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r100 = this.errorTraceBuilder_;
            if (r100 != null) goto L7;
            return Collections.unmodifiableList(this.errorTrace_);
        L7:
            return r100.getMessageList();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public ErrorTraceOrBuilder getErrorTraceOrBuilder(int r100) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r101 = this.errorTraceBuilder_;
            if (r101 != null) goto L7;
            Object r102 = ListProtector.get(this.errorTrace_, r100);
        L6:
            return (ErrorTraceOrBuilder) r102;
        L7:
            r102 = r101.getMessageOrBuilder(r100);
            goto L6
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public List<? extends ErrorTraceOrBuilder> getErrorTraceOrBuilderList() {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r100 = this.errorTraceBuilder_;
            if (r100 == null) goto L7;
            return r100.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.errorTrace_);
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public NormalTrace getNormalTrace(int r100) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r101 = this.normalTraceBuilder_;
            if (r101 != null) goto L7;
            Object r102 = ListProtector.get(this.normalTrace_, r100);
        L6:
            return (NormalTrace) r102;
        L7:
            r102 = r101.getMessage(r100);
            goto L6
        }

        public NormalTrace.Builder getNormalTraceBuilder(int r100) {
            return (NormalTrace.Builder) internalGetNormalTraceFieldBuilder().getBuilder(r100);
        }

        public List<NormalTrace.Builder> getNormalTraceBuilderList() {
            return internalGetNormalTraceFieldBuilder().getBuilderList();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public int getNormalTraceCount() {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r100 = this.normalTraceBuilder_;
            if (r100 != null) goto L7;
            return this.normalTrace_.size();
        L7:
            return r100.getCount();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public List<NormalTrace> getNormalTraceList() {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r100 = this.normalTraceBuilder_;
            if (r100 != null) goto L7;
            return Collections.unmodifiableList(this.normalTrace_);
        L7:
            return r100.getMessageList();
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public NormalTraceOrBuilder getNormalTraceOrBuilder(int r100) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r101 = this.normalTraceBuilder_;
            if (r101 != null) goto L7;
            Object r102 = ListProtector.get(this.normalTrace_, r100);
        L6:
            return (NormalTraceOrBuilder) r102;
        L7:
            r102 = r101.getMessageOrBuilder(r100);
            goto L6
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public List<? extends NormalTraceOrBuilder> getNormalTraceOrBuilderList() {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r100 = this.normalTraceBuilder_;
            if (r100 == null) goto L7;
            return r100.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.normalTrace_);
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public int getTrainNum() {
            return this.trainNum_;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public boolean hasTrainNum() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
        public boolean hasVersion() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CryptoSDKInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(CryptoSDKInfo r100) {
            if (r100 != CryptoSDKInfo.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r100.hasVersion() == false) goto L9;
            setVersion(r100.getVersion());
        L9:
            if (r100.hasTrainNum() == false) goto L12;
            setTrainNum(r100.getTrainNum());
        L12:
            if (r100.hasTimestamp() == false) goto L14;
            setTimestamp(r100.getTimestamp());
        L14:
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r101 = null;
            if (this.normalTraceBuilder_ != null) goto L24;
            if (CryptoSDKInfo.access$300(r100).isEmpty() == true) goto L34;
            if (this.normalTrace_.isEmpty() == false) goto L21;
            this.normalTrace_ = CryptoSDKInfo.access$300(r100);
            this.bitField0_ &= -9;
        L22:
            onChanged();
            goto L34
        L21:
            ensureNormalTraceIsMutable();
            this.normalTrace_.addAll(CryptoSDKInfo.access$300(r100));
        L34:
            if (this.errorTraceBuilder_ != null) goto L43;
            if (CryptoSDKInfo.access$400(r100).isEmpty() == false) goto L38;
        L51:
            mergeUnknownFields(r100.getUnknownFields());
            onChanged();
            return this;
        L38:
            if (this.errorTrace_.isEmpty() == false) goto L40;
            this.errorTrace_ = CryptoSDKInfo.access$400(r100);
            this.bitField0_ &= -17;
        L41:
            onChanged();
            goto L51
        L40:
            ensureErrorTraceIsMutable();
            this.errorTrace_.addAll(CryptoSDKInfo.access$400(r100));
            goto L41
        L43:
            if (CryptoSDKInfo.access$400(r100).isEmpty() == true) goto L51;
            if (this.errorTraceBuilder_.isEmpty() == false) goto L50;
            this.errorTraceBuilder_.dispose();
            this.errorTraceBuilder_ = null;
            this.errorTrace_ = CryptoSDKInfo.access$400(r100);
            this.bitField0_ &= -17;
            if (CryptoSDKInfo.access$1000() == false) goto L49;
            r101 = internalGetErrorTraceFieldBuilder();
        L49:
            this.errorTraceBuilder_ = r101;
            goto L51
        L50:
            this.errorTraceBuilder_.addAllMessages(CryptoSDKInfo.access$400(r100));
            goto L51
        L24:
            if (CryptoSDKInfo.access$300(r100).isEmpty() == true) goto L34;
            if (this.normalTraceBuilder_.isEmpty() == false) goto L32;
            this.normalTraceBuilder_.dispose();
            this.normalTraceBuilder_ = null;
            this.normalTrace_ = CryptoSDKInfo.access$300(r100);
            this.bitField0_ &= -9;
            if (CryptoSDKInfo.access$900() == false) goto L30;
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r102 = internalGetNormalTraceFieldBuilder();
        L31:
            this.normalTraceBuilder_ = r102;
            goto L34
        L30:
            r102 = null;
            goto L31
        L32:
            this.normalTraceBuilder_.addAllMessages(CryptoSDKInfo.access$300(r100));
            goto L34
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) {
            r101.getClass();
            boolean r102 = false;
        L3:
            if (r102 == true) goto L40;
            int r103 = r100.readTag();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            if (r103 == 0) goto L32;
            if (r103 == 8) goto L29;
            if (r103 == 16) goto L28;
            if (r103 != 24) goto L13;
            this.timestamp_ = r100.readInt64();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            int r104 = this.bitField0_ | 4;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
        L30:
            this.bitField0_ = r104;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L3
        L13:
            if (r103 == 34) goto L22;
            if (r103 != 42) goto L17;
            MessageLite r105 = (ErrorTrace) r100.readMessage(ErrorTrace.parser(), r101);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            RepeatedFieldBuilder r106 = this.errorTraceBuilder_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            if (r106 == null) goto L21;
        L26:
            r106.addMessage(r105);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L3
        L21:
            ensureErrorTraceIsMutable();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            List r107 = this.errorTrace_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
        L25:
            r107.add(r105);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L3
        L17:
            if (parseUnknownField(r100, r101, r103) == true) goto L3;
        L22:
            r105 = (NormalTrace) r100.readMessage(NormalTrace.parser(), r101);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r106 = this.normalTraceBuilder_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            if (r106 != null) goto L26;
            ensureNormalTraceIsMutable();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r107 = this.normalTrace_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L25
        L28:
            this.trainNum_ = r100.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r104 = this.bitField0_ | 2;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            goto L30
        L29:
            this.version_ = r100.readInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            r104 = this.bitField0_ | 1;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
        L32:
            r102 = true;
            goto L3
        L35:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            onChanged();
            throw th;
        L40:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r100) {
            if ((r100 instanceof CryptoSDKInfo) == true) goto L5;
            super.mergeFrom(r100);
            return this;
        L5:
            return mergeFrom((CryptoSDKInfo) r100);
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

        public Builder removeErrorTrace(int r100) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r101 = this.errorTraceBuilder_;
            if (r101 != null) goto L5;
            ensureErrorTraceIsMutable();
            ListProtector.remove(this.errorTrace_, r100);
            onChanged();
        L6:
            return this;
        L5:
            r101.remove(r100);
            goto L6
        }

        public Builder removeNormalTrace(int r100) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r101 = this.normalTraceBuilder_;
            if (r101 != null) goto L5;
            ensureNormalTraceIsMutable();
            ListProtector.remove(this.normalTrace_, r100);
            onChanged();
        L6:
            return this;
        L5:
            r101.remove(r100);
            goto L6
        }

        public Builder setErrorTrace(int r100, ErrorTrace.Builder r101) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r102 = this.errorTraceBuilder_;
            if (r102 != null) goto L5;
            ensureErrorTraceIsMutable();
            ListProtector.set(this.errorTrace_, r100, r101.build());
            onChanged();
        L6:
            return this;
        L5:
            r102.setMessage(r100, r101.build());
            goto L6
        }

        public Builder setErrorTrace(int r100, ErrorTrace r101) {
            RepeatedFieldBuilder<ErrorTrace, ErrorTrace.Builder, ErrorTraceOrBuilder> r102 = this.errorTraceBuilder_;
            if (r102 != null) goto L5;
            r101.getClass();
            ensureErrorTraceIsMutable();
            ListProtector.set(this.errorTrace_, r100, r101);
            onChanged();
        L6:
            return this;
        L5:
            r102.setMessage(r100, r101);
            goto L6
        }

        public Builder setNormalTrace(int r100, NormalTrace.Builder r101) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r102 = this.normalTraceBuilder_;
            if (r102 != null) goto L5;
            ensureNormalTraceIsMutable();
            ListProtector.set(this.normalTrace_, r100, r101.build());
            onChanged();
        L6:
            return this;
        L5:
            r102.setMessage(r100, r101.build());
            goto L6
        }

        public Builder setNormalTrace(int r100, NormalTrace r101) {
            RepeatedFieldBuilder<NormalTrace, NormalTrace.Builder, NormalTraceOrBuilder> r102 = this.normalTraceBuilder_;
            if (r102 != null) goto L5;
            r101.getClass();
            ensureNormalTraceIsMutable();
            ListProtector.set(this.normalTrace_, r100, r101);
            onChanged();
        L6:
            return this;
        L5:
            r102.setMessage(r100, r101);
            goto L6
        }

        public Builder setTimestamp(long r100) {
            this.timestamp_ = r100;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setTrainNum(int r100) {
            this.trainNum_ = r100;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setVersion(int r100) {
            this.version_ = r100;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", CryptoSDKInfo.class.getName());
        DEFAULT_INSTANCE = new CryptoSDKInfo();
        PARSER = new AnonymousClass1();
    }

    private CryptoSDKInfo() {
        this.version_ = 0;
        this.trainNum_ = 0;
        this.timestamp_ = 0;
        this.memoizedIsInitialized = -1;
        this.normalTrace_ = Collections.emptyList();
        this.errorTrace_ = Collections.emptyList();
    }

    private CryptoSDKInfo(GeneratedMessage.Builder<?> r100) {
        super(r100);
        this.version_ = 0;
        this.trainNum_ = 0;
        this.timestamp_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public /* synthetic */ CryptoSDKInfo(GeneratedMessage.Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static /* synthetic */ boolean access$1000() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ List access$300(CryptoSDKInfo r100) {
        return r100.normalTrace_;
    }

    public static /* synthetic */ List access$302(CryptoSDKInfo r100, List r101) {
        r100.normalTrace_ = r101;
        return r101;
    }

    public static /* synthetic */ List access$400(CryptoSDKInfo r100) {
        return r100.errorTrace_;
    }

    public static /* synthetic */ List access$402(CryptoSDKInfo r100, List r101) {
        r100.errorTrace_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$502(CryptoSDKInfo r100, int r101) {
        r100.version_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$602(CryptoSDKInfo r100, int r101) {
        r100.trainNum_ = r101;
        return r101;
    }

    public static /* synthetic */ long access$702(CryptoSDKInfo r100, long r101) {
        r100.timestamp_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$876(CryptoSDKInfo r100, int r101) {
        int r102 = r101 | r100.bitField0_;
        r100.bitField0_ = r102;
        return r102;
    }

    public static /* synthetic */ boolean access$900() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static CryptoSDKInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CryptoSDKInfo r100) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
    }

    public static CryptoSDKInfo parseDelimitedFrom(InputStream r100) {
        return (CryptoSDKInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r100);
    }

    public static CryptoSDKInfo parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) {
        return (CryptoSDKInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r100, r101);
    }

    public static CryptoSDKInfo parseFrom(ByteString r100) {
        return PARSER.parseFrom(r100);
    }

    public static CryptoSDKInfo parseFrom(ByteString r100, ExtensionRegistryLite r101) {
        return PARSER.parseFrom(r100, r101);
    }

    public static CryptoSDKInfo parseFrom(CodedInputStream r100) {
        return (CryptoSDKInfo) GeneratedMessage.parseWithIOException(PARSER, r100);
    }

    public static CryptoSDKInfo parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) {
        return (CryptoSDKInfo) GeneratedMessage.parseWithIOException(PARSER, r100, r101);
    }

    public static CryptoSDKInfo parseFrom(InputStream r100) {
        return (CryptoSDKInfo) GeneratedMessage.parseWithIOException(PARSER, r100);
    }

    public static CryptoSDKInfo parseFrom(InputStream r100, ExtensionRegistryLite r101) {
        return (CryptoSDKInfo) GeneratedMessage.parseWithIOException(PARSER, r100, r101);
    }

    public static CryptoSDKInfo parseFrom(ByteBuffer r100) {
        return PARSER.parseFrom(r100);
    }

    public static CryptoSDKInfo parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) {
        return PARSER.parseFrom(r100, r101);
    }

    public static CryptoSDKInfo parseFrom(byte[] r100) {
        return PARSER.parseFrom(r100);
    }

    public static CryptoSDKInfo parseFrom(byte[] r100, ExtensionRegistryLite r101) {
        return PARSER.parseFrom(r100, r101);
    }

    public static Parser<CryptoSDKInfo> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof CryptoSDKInfo) == false) goto L8;
        CryptoSDKInfo r101 = (CryptoSDKInfo) r100;
        if (hasVersion() == r101.hasVersion()) goto L13;
        return false;
    L13:
        if (hasVersion() == false) goto L18;
        if (getVersion() == r101.getVersion()) goto L18;
        return false;
    L18:
        if (hasTrainNum() == r101.hasTrainNum()) goto L21;
        return false;
    L21:
        if (hasTrainNum() == false) goto L26;
        if (getTrainNum() == r101.getTrainNum()) goto L26;
        return false;
    L26:
        if (hasTimestamp() == r101.hasTimestamp()) goto L29;
        return false;
    L29:
        if (hasTimestamp() == false) goto L34;
        if (getTimestamp() == r101.getTimestamp()) goto L34;
        return false;
    L34:
        if (getNormalTraceList().equals(r101.getNormalTraceList()) == true) goto L37;
        return false;
    L37:
        if (getErrorTraceList().equals(r101.getErrorTraceList()) == true) goto L40;
        return false;
    L40:
        if (getUnknownFields().equals(r101.getUnknownFields()) == true) goto L42;
        return false;
    L42:
        return true;
    L8:
        return super.equals(r100);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CryptoSDKInfo getDefaultInstanceForType() {
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

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public ErrorTrace getErrorTrace(int r100) {
        return (ErrorTrace) ListProtector.get(this.errorTrace_, r100);
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public int getErrorTraceCount() {
        return this.errorTrace_.size();
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public List<ErrorTrace> getErrorTraceList() {
        return this.errorTrace_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public ErrorTraceOrBuilder getErrorTraceOrBuilder(int r100) {
        return (ErrorTraceOrBuilder) ListProtector.get(this.errorTrace_, r100);
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public List<? extends ErrorTraceOrBuilder> getErrorTraceOrBuilderList() {
        return this.errorTrace_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public NormalTrace getNormalTrace(int r100) {
        return (NormalTrace) ListProtector.get(this.normalTrace_, r100);
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public int getNormalTraceCount() {
        return this.normalTrace_.size();
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public List<NormalTrace> getNormalTraceList() {
        return this.normalTrace_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public NormalTraceOrBuilder getNormalTraceOrBuilder(int r100) {
        return (NormalTraceOrBuilder) ListProtector.get(this.normalTrace_, r100);
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public List<? extends NormalTraceOrBuilder> getNormalTraceOrBuilderList() {
        return this.normalTrace_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CryptoSDKInfo> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r100 = this.memoizedSize;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        int r101 = 0;
        if ((this.bitField0_ & 1) == 0) goto L8;
        int r102 = CodedOutputStream.computeInt32Size(1, this.version_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r102 = r102 + CodedOutputStream.computeUInt32Size(2, this.trainNum_);
    L13:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r102 = r102 + CodedOutputStream.computeInt64Size(3, this.timestamp_);
    L15:
        int r103 = 0;
    L17:
        if (r103 >= this.normalTrace_.size()) goto L20;
        r102 = r102 + CodedOutputStream.computeMessageSize(4, (MessageLite) ListProtector.get(this.normalTrace_, r103));
        r103 = r103 + 1;
    L20:
        if (r101 >= this.errorTrace_.size()) goto L22;
        r102 = r102 + CodedOutputStream.computeMessageSize(5, (MessageLite) ListProtector.get(this.errorTrace_, r101));
        r101 = r101 + 1;
        goto L20
    L22:
        int r104 = r102 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r104;
        return r104;
    L8:
        r102 = 0;
        goto L10
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public int getTrainNum() {
        return this.trainNum_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public int getVersion() {
        return this.version_;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public boolean hasTimestamp() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public boolean hasTrainNum() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.crypto.monitor.proto.CryptoSDKInfoOrBuilder
    public boolean hasVersion() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r100 = this.memoizedHashCode;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        int r101 = getDescriptor().hashCode() + 779;
        if (hasVersion() == false) goto L9;
        r101 = (((r101 * 37) + 1) * 53) + getVersion();
    L9:
        if (hasTrainNum() == false) goto L12;
        r101 = (((r101 * 37) + 2) * 53) + getTrainNum();
    L12:
        if (hasTimestamp() == false) goto L15;
        r101 = (((r101 * 37) + 3) * 53) + Internal.hashLong(getTimestamp());
    L15:
        if (getNormalTraceCount() <= 0) goto L18;
        r101 = (((r101 * 37) + 4) * 53) + getNormalTraceList().hashCode();
    L18:
        if (getErrorTraceCount() <= 0) goto L20;
        r101 = (((r101 * 37) + 5) * 53) + getErrorTraceList().hashCode();
    L20:
        int r102 = (r101 * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r102;
        return r102;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return CryptoSDKProto.internal_static_com_bytedance_crypto_monitor_proto_CryptoSDKInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CryptoSDKInfo.class, Builder.class);
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
        r100.writeInt32(1, this.version_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r100.writeUInt32(2, this.trainNum_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L11;
        r100.writeInt64(3, this.timestamp_);
    L11:
        int r101 = 0;
        int r102 = 0;
    L13:
        if (r102 >= this.normalTrace_.size()) goto L16;
        r100.writeMessage(4, (MessageLite) ListProtector.get(this.normalTrace_, r102));
        r102 = r102 + 1;
    L16:
        if (r101 >= this.errorTrace_.size()) goto L18;
        r100.writeMessage(5, (MessageLite) ListProtector.get(this.errorTrace_, r101));
        r101 = r101 + 1;
        goto L16
    L18:
        getUnknownFields().writeTo(r100);
    }
}
