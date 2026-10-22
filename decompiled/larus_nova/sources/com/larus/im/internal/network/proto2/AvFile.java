package com.larus.im.internal.network.proto2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import com.larus.network.http.ServiceType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
public final class AvFile {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_FileBizInfo_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_FileBizInfo_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_FileData_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_FileData_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_FileDownlinkBody_ExtEntry_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_FileDownlinkBody_ExtEntry_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_FileDownlinkBody_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_FileDownlinkBody_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_FileResultBizInfo_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_FileResultBizInfo_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_FileResult_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_FileResult_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_FileUplinkBody_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_FileUplinkBody_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_ImageBaseInfo_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_ImageBaseInfo_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_OcrInfo_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_OcrInfo_fieldAccessorTable = null;

    public static final class FileBizInfo extends GeneratedMessageV3 implements FileBizInfoOrBuilder {
        public static final int BIZ_INFO_FIELD_NUMBER = 2;
        public static final int BIZ_TYPE_FIELD_NUMBER = 1;
        private static final FileBizInfo DEFAULT_INSTANCE = null;
        private static final Parser<FileBizInfo> PARSER = null;
        private static final long serialVersionUID = 0;
        private volatile Object bizInfo_;
        private int bizType_;
        private byte memoizedIsInitialized;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FileBizInfoOrBuilder {
            private Object bizInfo_;
            private int bizType_;

            public Builder clearBizType() {
                this.bizType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileBizInfo buildPartial() {
                FileBizInfo r100 = new FileBizInfo(this, null);
                FileBizInfo.access$3202(r100, this.bizType_);
                FileBizInfo.access$3302(r100, this.bizInfo_);
                onBuilt();
                return r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileBizInfoOrBuilder
            public String getBizInfo() {
                Object r100 = this.bizInfo_;
                if ((r100 instanceof String) == true) goto L7;
                String r101 = ((ByteString) r100).toStringUtf8();
                this.bizInfo_ = r101;
                return r101;
            L7:
                return (String) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileBizInfoOrBuilder
            public ByteString getBizInfoBytes() {
                Object r100 = this.bizInfo_;
                if ((r100 instanceof String) == false) goto L7;
                ByteString r101 = ByteString.copyFromUtf8((String) r100);
                this.bizInfo_ = r101;
                return r101;
            L7:
                return (ByteString) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileBizInfoOrBuilder
            public FileBizType getBizType() {
                FileBizType r100 = FileBizType.valueOf(this.bizType_);
                if (r100 == null) goto L5;
                return r100;
            L5:
                return FileBizType.UNRECOGNIZED;
            }

            private Builder() {
                this.bizType_ = 0;
                this.bizInfo_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvFile.access$2600();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileBizInfo build() {
                FileBizInfo r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bizType_ = 0;
                this.bizInfo_ = "";
                return this;
            }

            public Builder clearBizInfo() {
                this.bizInfo_ = FileBizInfo.getDefaultInstance().getBizInfo();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvFile.access$2600();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvFile.access$2700().ensureFieldAccessorsInitialized(FileBizInfo.class, Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                FileBizInfo.access$3000();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileBizInfoOrBuilder
            public int getBizTypeValue() {
                return this.bizType_;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FileBizInfo getDefaultInstanceForType() {
                return FileBizInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo8531clone() throws CloneNotSupportedException {
                return clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r100) {
                super(r100);
                this.bizType_ = 0;
                this.bizInfo_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor r100) {
                return (Builder) super.clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return (Builder) super.clearOneof(r100);
            }

            public Builder mergeFrom(FileBizInfo r100) {
                if (r100 != FileBizInfo.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (FileBizInfo.access$3200(r100) == 0) goto L9;
                setBizTypeValue(r100.getBizTypeValue());
            L9:
                if (r100.getBizInfo().isEmpty() == true) goto L11;
                this.bizInfo_ = FileBizInfo.access$3300(r100);
                onChanged();
            L11:
                mergeUnknownFields(FileBizInfo.access$3400(r100));
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.mergeUnknownFields(r100);
            }

            public Builder setBizInfo(String r100) {
                if (r100 == null) goto L6;
                this.bizInfo_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setBizInfoBytes(ByteString r100) {
                if (r100 == null) goto L6;
                FileBizInfo.access$3600(r100);
                this.bizInfo_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setBizType(FileBizType r100) {
                if (r100 == null) goto L6;
                this.bizType_ = r100.getNumber();
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setBizTypeValue(int r100) {
                this.bizType_ = r100;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.setUnknownFieldsProto3(r100);
            }

            public /* synthetic */ Builder(AnonymousClass1 r100) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r100) {
                if ((r100 instanceof FileBizInfo) == true) goto L5;
                super.mergeFrom(r100);
                return this;
            L5:
                return mergeFrom((FileBizInfo) r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r100, AnonymousClass1 r101) {
                this(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                FileBizInfo r102 = null;
                FileBizInfo r103 = (FileBizInfo) FileBizInfo.access$3500().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L7:
                th = th;
            L15:
                if (r102 == null) goto L17;
                mergeFrom(r102);
            L17:
                throw th;
            L9:
                e = move-exception;
                FileBizInfo r104 = (FileBizInfo) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r102 = r104;
                goto L15
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.setField(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return (Builder) super.setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }
        }

        static {
            DEFAULT_INSTANCE = new FileBizInfo();
            PARSER = new AnonymousClass1();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileBizInfoOrBuilder
        public String getBizInfo() {
            Object r100 = this.bizInfo_;
            if ((r100 instanceof String) == true) goto L5;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.bizInfo_ = r101;
            return r101;
        L5:
            return (String) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileBizInfoOrBuilder
        public ByteString getBizInfoBytes() {
            Object r100 = this.bizInfo_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.bizInfo_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileBizInfoOrBuilder
        public FileBizType getBizType() {
            FileBizType r100 = FileBizType.valueOf(this.bizType_);
            if (r100 == null) goto L5;
            return r100;
        L5:
            return FileBizType.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if (this.bizType_ == FileBizType.ImageBizType_UNSPECIFIED.getNumber()) goto L9;
            r101 = 0 + CodedOutputStream.computeEnumSize(1, this.bizType_);
        L9:
            if (getBizInfoBytes().isEmpty() == true) goto L11;
            r101 = r101 + GeneratedMessageV3.computeStringSize(2, this.bizInfo_);
        L11:
            int r102 = r101 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r102;
            return r102;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int r100 = this.memoizedHashCode;
            if (r100 == 0) goto L5;
            return r100;
        L5:
            int r101 = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.bizType_) * 37) + 2) * 53) + getBizInfo().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = r101;
            return r101;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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
        public Builder toBuilder() {
            AnonymousClass1 r100 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r100);
        L6:
            return new Builder(r100).mergeFrom(this);
        }

        private FileBizInfo() {
            this.memoizedIsInitialized = -1;
            this.bizType_ = 0;
            this.bizInfo_ = "";
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvFile.access$2600();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvFile.access$2700().ensureFieldAccessorsInitialized(FileBizInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static /* synthetic */ boolean access$3000() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ Parser access$3500() {
            return PARSER;
        }

        public static FileBizInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FileBizInfo> parser() {
            return PARSER;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileBizInfoOrBuilder
        public int getBizTypeValue() {
            return this.bizType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FileBizInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FileBizInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private FileBizInfo(GeneratedMessageV3.Builder<?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ int access$3200(FileBizInfo r100) {
            return r100.bizType_;
        }

        public static /* synthetic */ Object access$3300(FileBizInfo r100) {
            return r100.bizInfo_;
        }

        public static /* synthetic */ UnknownFieldSet access$3400(FileBizInfo r100) {
            return r100.unknownFields;
        }

        public static /* synthetic */ void access$3600(ByteString r100) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(r100);
        }

        public static Builder newBuilder(FileBizInfo r100) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
        }

        public static FileBizInfo parseDelimitedFrom(InputStream r100) throws IOException {
            return (FileBizInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
        }

        public static FileBizInfo parseFrom(ByteString r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof FileBizInfo) == false) goto L8;
            FileBizInfo r101 = (FileBizInfo) r100;
            if (this.bizType_ != r101.bizType_) goto L12;
            boolean r102 = true;
        L13:
            if (r102 == true) goto L15;
        L17:
            boolean r103 = false;
        L18:
            if (r103 == true) goto L20;
        L22:
            return false;
        L20:
            if (this.unknownFields.equals(r101.unknownFields) == false) goto L22;
            return true;
        L15:
            if (getBizInfo().equals(r101.getBizInfo()) == false) goto L17;
            r103 = true;
            goto L18
        L12:
            r102 = false;
            goto L13
        L8:
            return super.equals(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return new Builder(r100, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            if (this.bizType_ == FileBizType.ImageBizType_UNSPECIFIED.getNumber()) goto L6;
            r100.writeEnum(1, this.bizType_);
        L6:
            if (getBizInfoBytes().isEmpty() == true) goto L8;
            GeneratedMessageV3.writeString(r100, 2, this.bizInfo_);
        L8:
            this.unknownFields.writeTo(r100);
        }

        public static FileBizInfo parseFrom(CodedInputStream r100) throws IOException {
            return (FileBizInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return newBuilderForType(r100);
        }

        public static FileBizInfo parseFrom(InputStream r100) throws IOException {
            return (FileBizInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        public static FileBizInfo parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        public static FileBizInfo parseFrom(byte[] r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        private FileBizInfo(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this();
            if (r101 == null) goto L32;
            UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
            boolean r103 = false;
        L5:
            if (r103 == true) goto L29;
            int r104 = r100.readTag();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L24
            if (r104 == 0) goto L18;
            if (r104 != 8) goto L11;
            this.bizType_ = r100.readEnum();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L24
            goto L5
        L11:
            if (r104 != 18) goto L13;
            this.bizInfo_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L24
            goto L5
        L13:
            if (parseUnknownFieldProto3(r100, r102, r101, r104) == true) goto L5;
        L18:
            r103 = true;
            goto L5
        L19:
            th = move-exception;
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            throw th;
        L21:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L19
        L24:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L19
        L29:
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            return;
        L32:
            throw null;
        }

        public static /* synthetic */ int access$3202(FileBizInfo r100, int r101) {
            r100.bizType_ = r101;
            return r101;
        }

        public static /* synthetic */ Object access$3302(FileBizInfo r100, Object r101) {
            r100.bizInfo_ = r101;
            return r101;
        }

        public static FileBizInfo parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileBizInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
        }

        public static FileBizInfo parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ FileBizInfo(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static FileBizInfo parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileBizInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static FileBizInfo parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileBizInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static FileBizInfo parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public static FileBizInfo parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ FileBizInfo(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface FileBizInfoOrBuilder extends MessageOrBuilder {
        String getBizInfo();

        ByteString getBizInfoBytes();

        FileBizType getBizType();

        int getBizTypeValue();
    }

    public static final enum FileBizType extends Enum<FileBizType> implements ProtocolMessageEnum {
        private static final /* synthetic */ FileBizType[] $VALUES = null;
        public static final FileBizType DoraImage = null;
        public static final int DoraImage_VALUE = 1;
        public static final FileBizType DoraOcrMeta = null;
        public static final int DoraOcrMeta_VALUE = 2;
        public static final FileBizType ImageBizType_UNSPECIFIED = null;
        public static final int ImageBizType_UNSPECIFIED_VALUE = 0;
        public static final FileBizType UNRECOGNIZED = null;
        private static final FileBizType[] VALUES = null;
        private static final Internal.EnumLiteMap<FileBizType> internalValueMap = null;
        private final int value;

        static {
            FileBizType r100 = new FileBizType("ImageBizType_UNSPECIFIED", 0, 0);
            ImageBizType_UNSPECIFIED = r100;
            FileBizType r101 = new FileBizType("DoraImage", 1, 1);
            DoraImage = r101;
            FileBizType r102 = new FileBizType("DoraOcrMeta", 2, 2);
            DoraOcrMeta = r102;
            FileBizType r103 = new FileBizType("UNRECOGNIZED", 3, -1);
            UNRECOGNIZED = r103;
            $VALUES = new FileBizType[]{r100, r101, r102, r103};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        public static FileBizType[] values() {
            return (FileBizType[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ListProtector.get(AvFile.getDescriptor().getEnumTypes(), 2);
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
        }

        public static Internal.EnumLiteMap<FileBizType> internalGetValueMap() {
            return internalValueMap;
        }

        public static FileBizType forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return DoraOcrMeta;
        L12:
            return DoraImage;
        L14:
            return ImageBizType_UNSPECIFIED;
        }

        public static FileBizType valueOf(Descriptors.EnumValueDescriptor r100) {
            if (r100.getType() != getDescriptor()) goto L11;
            if (r100.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r100.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static FileBizType valueOf(String r100) {
            return (FileBizType) a.a(FileBizType.class, r100);
        }

        public static FileBizType valueOf(int r100) {
            return forNumber(r100);
        }

        private FileBizType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class FileData extends GeneratedMessageV3 implements FileDataOrBuilder {
        public static final int CHECKSUM_MD5_FIELD_NUMBER = 5;
        public static final int DATA_FIELD_NUMBER = 3;
        private static final FileData DEFAULT_INSTANCE = null;
        public static final int FILE_BIZ_INFO_FIELD_NUMBER = 12;
        public static final int FILE_TYPE_FIELD_NUMBER = 2;
        public static final int IMAGE_BASE_INFO_FIELD_NUMBER = 11;
        public static final int OCR_INFO_FIELD_NUMBER = 6;
        private static final Parser<FileData> PARSER = null;
        public static final int SIZE_BYTES_FIELD_NUMBER = 4;
        public static final int UPLOAD_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object checksumMd5_;
        private ByteString data_;
        private FileBizInfo fileBizInfo_;
        private int fileType_;
        private ImageBaseInfo imageBaseInfo_;
        private byte memoizedIsInitialized;
        private OcrInfo ocrInfo_;
        private long sizeBytes_;
        private volatile Object uploadId_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FileDataOrBuilder {
            private Object checksumMd5_;
            private ByteString data_;
            private SingleFieldBuilderV3<FileBizInfo, FileBizInfo.Builder, FileBizInfoOrBuilder> fileBizInfoBuilder_;
            private FileBizInfo fileBizInfo_;
            private int fileType_;
            private SingleFieldBuilderV3<ImageBaseInfo, ImageBaseInfo.Builder, ImageBaseInfoOrBuilder> imageBaseInfoBuilder_;
            private ImageBaseInfo imageBaseInfo_;
            private SingleFieldBuilderV3<OcrInfo, OcrInfo.Builder, OcrInfoOrBuilder> ocrInfoBuilder_;
            private OcrInfo ocrInfo_;
            private long sizeBytes_;
            private Object uploadId_;

            public Builder clearFileType() {
                this.fileType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private SingleFieldBuilderV3<FileBizInfo, FileBizInfo.Builder, FileBizInfoOrBuilder> getFileBizInfoFieldBuilder() {
                if (this.fileBizInfoBuilder_ != null) goto L6;
                this.fileBizInfoBuilder_ = new SingleFieldBuilderV3(getFileBizInfo(), getParentForChildren(), isClean());
                this.fileBizInfo_ = null;
            L6:
                return this.fileBizInfoBuilder_;
            }

            private SingleFieldBuilderV3<ImageBaseInfo, ImageBaseInfo.Builder, ImageBaseInfoOrBuilder> getImageBaseInfoFieldBuilder() {
                if (this.imageBaseInfoBuilder_ != null) goto L6;
                this.imageBaseInfoBuilder_ = new SingleFieldBuilderV3(getImageBaseInfo(), getParentForChildren(), isClean());
                this.imageBaseInfo_ = null;
            L6:
                return this.imageBaseInfoBuilder_;
            }

            private SingleFieldBuilderV3<OcrInfo, OcrInfo.Builder, OcrInfoOrBuilder> getOcrInfoFieldBuilder() {
                if (this.ocrInfoBuilder_ != null) goto L6;
                this.ocrInfoBuilder_ = new SingleFieldBuilderV3(getOcrInfo(), getParentForChildren(), isClean());
                this.ocrInfo_ = null;
            L6:
                return this.ocrInfoBuilder_;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileData buildPartial() {
                FileData r100 = new FileData(this, null);
                FileData.access$4402(r100, this.uploadId_);
                FileData.access$4502(r100, this.fileType_);
                FileData.access$4602(r100, this.data_);
                FileData.access$4702(r100, this.sizeBytes_);
                FileData.access$4802(r100, this.checksumMd5_);
                SingleFieldBuilderV3<OcrInfo, OcrInfo.Builder, OcrInfoOrBuilder> r101 = this.ocrInfoBuilder_;
                if (r101 != null) goto L5;
                FileData.access$4902(r100, this.ocrInfo_);
            L6:
                SingleFieldBuilderV3<ImageBaseInfo, ImageBaseInfo.Builder, ImageBaseInfoOrBuilder> r102 = this.imageBaseInfoBuilder_;
                if (r102 != null) goto L9;
                FileData.access$5002(r100, this.imageBaseInfo_);
            L10:
                SingleFieldBuilderV3<FileBizInfo, FileBizInfo.Builder, FileBizInfoOrBuilder> r103 = this.fileBizInfoBuilder_;
                if (r103 != null) goto L13;
                FileData.access$5102(r100, this.fileBizInfo_);
            L14:
                onBuilt();
                return r100;
            L13:
                FileData.access$5102(r100, (FileBizInfo) r103.build());
                goto L14
            L9:
                FileData.access$5002(r100, (ImageBaseInfo) r102.build());
                goto L10
            L5:
                FileData.access$4902(r100, (OcrInfo) r101.build());
                goto L6
            }

            public Builder clearFileBizInfo() {
                if (this.fileBizInfoBuilder_ != null) goto L5;
                this.fileBizInfo_ = null;
                onChanged();
            L6:
                return this;
            L5:
                this.fileBizInfo_ = null;
                this.fileBizInfoBuilder_ = null;
                goto L6
            }

            public Builder clearImageBaseInfo() {
                if (this.imageBaseInfoBuilder_ != null) goto L5;
                this.imageBaseInfo_ = null;
                onChanged();
            L6:
                return this;
            L5:
                this.imageBaseInfo_ = null;
                this.imageBaseInfoBuilder_ = null;
                goto L6
            }

            public Builder clearOcrInfo() {
                if (this.ocrInfoBuilder_ != null) goto L5;
                this.ocrInfo_ = null;
                onChanged();
            L6:
                return this;
            L5:
                this.ocrInfo_ = null;
                this.ocrInfoBuilder_ = null;
                goto L6
            }

            public Builder clearSizeBytes() {
                this.sizeBytes_ = 0;
                onChanged();
                return this;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public String getChecksumMd5() {
                Object r100 = this.checksumMd5_;
                if ((r100 instanceof String) == true) goto L7;
                String r101 = ((ByteString) r100).toStringUtf8();
                this.checksumMd5_ = r101;
                return r101;
            L7:
                return (String) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public ByteString getChecksumMd5Bytes() {
                Object r100 = this.checksumMd5_;
                if ((r100 instanceof String) == false) goto L7;
                ByteString r101 = ByteString.copyFromUtf8((String) r100);
                this.checksumMd5_ = r101;
                return r101;
            L7:
                return (ByteString) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public FileBizInfo getFileBizInfo() {
                SingleFieldBuilderV3<FileBizInfo, FileBizInfo.Builder, FileBizInfoOrBuilder> r100 = this.fileBizInfoBuilder_;
                if (r100 != null) goto L9;
                FileBizInfo r101 = this.fileBizInfo_;
                if (r101 == null) goto L7;
                return r101;
            L7:
                return FileBizInfo.getDefaultInstance();
            L9:
                return (FileBizInfo) r100.getMessage();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public FileBizInfoOrBuilder getFileBizInfoOrBuilder() {
                SingleFieldBuilderV3<FileBizInfo, FileBizInfo.Builder, FileBizInfoOrBuilder> r100 = this.fileBizInfoBuilder_;
                if (r100 != null) goto L5;
                FileBizInfo r101 = this.fileBizInfo_;
                if (r101 == null) goto L9;
                return r101;
            L9:
                return FileBizInfo.getDefaultInstance();
            L5:
                return (FileBizInfoOrBuilder) r100.getMessageOrBuilder();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public FileType getFileType() {
                FileType r100 = FileType.valueOf(this.fileType_);
                if (r100 == null) goto L5;
                return r100;
            L5:
                return FileType.UNRECOGNIZED;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public ImageBaseInfo getImageBaseInfo() {
                SingleFieldBuilderV3<ImageBaseInfo, ImageBaseInfo.Builder, ImageBaseInfoOrBuilder> r100 = this.imageBaseInfoBuilder_;
                if (r100 != null) goto L9;
                ImageBaseInfo r101 = this.imageBaseInfo_;
                if (r101 == null) goto L7;
                return r101;
            L7:
                return ImageBaseInfo.getDefaultInstance();
            L9:
                return (ImageBaseInfo) r100.getMessage();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public ImageBaseInfoOrBuilder getImageBaseInfoOrBuilder() {
                SingleFieldBuilderV3<ImageBaseInfo, ImageBaseInfo.Builder, ImageBaseInfoOrBuilder> r100 = this.imageBaseInfoBuilder_;
                if (r100 != null) goto L5;
                ImageBaseInfo r101 = this.imageBaseInfo_;
                if (r101 == null) goto L9;
                return r101;
            L9:
                return ImageBaseInfo.getDefaultInstance();
            L5:
                return (ImageBaseInfoOrBuilder) r100.getMessageOrBuilder();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public OcrInfo getOcrInfo() {
                SingleFieldBuilderV3<OcrInfo, OcrInfo.Builder, OcrInfoOrBuilder> r100 = this.ocrInfoBuilder_;
                if (r100 != null) goto L9;
                OcrInfo r101 = this.ocrInfo_;
                if (r101 == null) goto L7;
                return r101;
            L7:
                return OcrInfo.getDefaultInstance();
            L9:
                return (OcrInfo) r100.getMessage();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public OcrInfoOrBuilder getOcrInfoOrBuilder() {
                SingleFieldBuilderV3<OcrInfo, OcrInfo.Builder, OcrInfoOrBuilder> r100 = this.ocrInfoBuilder_;
                if (r100 != null) goto L5;
                OcrInfo r101 = this.ocrInfo_;
                if (r101 == null) goto L9;
                return r101;
            L9:
                return OcrInfo.getDefaultInstance();
            L5:
                return (OcrInfoOrBuilder) r100.getMessageOrBuilder();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public String getUploadId() {
                Object r100 = this.uploadId_;
                if ((r100 instanceof String) == true) goto L7;
                String r101 = ((ByteString) r100).toStringUtf8();
                this.uploadId_ = r101;
                return r101;
            L7:
                return (String) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public ByteString getUploadIdBytes() {
                Object r100 = this.uploadId_;
                if ((r100 instanceof String) == false) goto L7;
                ByteString r101 = ByteString.copyFromUtf8((String) r100);
                this.uploadId_ = r101;
                return r101;
            L7:
                return (ByteString) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public boolean hasFileBizInfo() {
                if (this.fileBizInfoBuilder_ == null) goto L5;
            L8:
                return true;
            L5:
                if (this.fileBizInfo_ != null) goto L8;
                return false;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public boolean hasImageBaseInfo() {
                if (this.imageBaseInfoBuilder_ == null) goto L5;
            L8:
                return true;
            L5:
                if (this.imageBaseInfo_ != null) goto L8;
                return false;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public boolean hasOcrInfo() {
                if (this.ocrInfoBuilder_ == null) goto L5;
            L8:
                return true;
            L5:
                if (this.ocrInfo_ != null) goto L8;
                return false;
            }

            private Builder() {
                this.uploadId_ = "";
                this.fileType_ = 0;
                this.data_ = ByteString.EMPTY;
                this.checksumMd5_ = "";
                this.ocrInfo_ = null;
                this.imageBaseInfo_ = null;
                this.fileBizInfo_ = null;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvFile.access$3800();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileData build() {
                FileData r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.uploadId_ = "";
                this.fileType_ = 0;
                this.data_ = ByteString.EMPTY;
                this.sizeBytes_ = 0;
                this.checksumMd5_ = "";
                if (this.ocrInfoBuilder_ != null) goto L5;
                this.ocrInfo_ = null;
            L7:
                if (this.imageBaseInfoBuilder_ != null) goto L9;
                this.imageBaseInfo_ = null;
            L11:
                if (this.fileBizInfoBuilder_ != null) goto L13;
                this.fileBizInfo_ = null;
            L14:
                return this;
            L13:
                this.fileBizInfo_ = null;
                this.fileBizInfoBuilder_ = null;
                goto L14
            L9:
                this.imageBaseInfo_ = null;
                this.imageBaseInfoBuilder_ = null;
                goto L11
            L5:
                this.ocrInfo_ = null;
                this.ocrInfoBuilder_ = null;
                goto L7
            }

            public Builder clearChecksumMd5() {
                this.checksumMd5_ = FileData.getDefaultInstance().getChecksumMd5();
                onChanged();
                return this;
            }

            public Builder clearData() {
                this.data_ = FileData.getDefaultInstance().getData();
                onChanged();
                return this;
            }

            public Builder clearUploadId() {
                this.uploadId_ = FileData.getDefaultInstance().getUploadId();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvFile.access$3800();
            }

            public FileBizInfo.Builder getFileBizInfoBuilder() {
                onChanged();
                return (FileBizInfo.Builder) getFileBizInfoFieldBuilder().getBuilder();
            }

            public ImageBaseInfo.Builder getImageBaseInfoBuilder() {
                onChanged();
                return (ImageBaseInfo.Builder) getImageBaseInfoFieldBuilder().getBuilder();
            }

            public OcrInfo.Builder getOcrInfoBuilder() {
                onChanged();
                return (OcrInfo.Builder) getOcrInfoFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvFile.access$3900().ensureFieldAccessorsInitialized(FileData.class, Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                FileData.access$4200();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public ByteString getData() {
                return this.data_;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public int getFileTypeValue() {
                return this.fileType_;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
            public long getSizeBytes() {
                return this.sizeBytes_;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FileData getDefaultInstanceForType() {
                return FileData.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo8531clone() throws CloneNotSupportedException {
                return clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r100) {
                super(r100);
                this.uploadId_ = "";
                this.fileType_ = 0;
                this.data_ = ByteString.EMPTY;
                this.checksumMd5_ = "";
                this.ocrInfo_ = null;
                this.imageBaseInfo_ = null;
                this.fileBizInfo_ = null;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor r100) {
                return (Builder) super.clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return (Builder) super.clearOneof(r100);
            }

            public Builder mergeFileBizInfo(FileBizInfo r100) {
                SingleFieldBuilderV3<FileBizInfo, FileBizInfo.Builder, FileBizInfoOrBuilder> r101 = this.fileBizInfoBuilder_;
                if (r101 != null) goto L9;
                FileBizInfo r102 = this.fileBizInfo_;
                if (r102 == null) goto L7;
                this.fileBizInfo_ = FileBizInfo.newBuilder(r102).mergeFrom(r100).buildPartial();
            L8:
                onChanged();
            L10:
                return this;
            L7:
                this.fileBizInfo_ = r100;
                goto L8
            L9:
                r101.mergeFrom(r100);
                goto L10
            }

            public Builder mergeFrom(FileData r100) {
                if (r100 != FileData.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.getUploadId().isEmpty() == true) goto L9;
                this.uploadId_ = FileData.access$4400(r100);
                onChanged();
            L9:
                if (FileData.access$4500(r100) == 0) goto L12;
                setFileTypeValue(r100.getFileTypeValue());
            L12:
                if (r100.getData() == ByteString.EMPTY) goto L15;
                setData(r100.getData());
            L15:
                if (r100.getSizeBytes() == 0) goto L18;
                setSizeBytes(r100.getSizeBytes());
            L18:
                if (r100.getChecksumMd5().isEmpty() == true) goto L21;
                this.checksumMd5_ = FileData.access$4800(r100);
                onChanged();
            L21:
                if (r100.hasOcrInfo() == false) goto L24;
                mergeOcrInfo(r100.getOcrInfo());
            L24:
                if (r100.hasImageBaseInfo() == false) goto L27;
                mergeImageBaseInfo(r100.getImageBaseInfo());
            L27:
                if (r100.hasFileBizInfo() == false) goto L29;
                mergeFileBizInfo(r100.getFileBizInfo());
            L29:
                mergeUnknownFields(FileData.access$5200(r100));
                onChanged();
                return this;
            }

            public Builder mergeImageBaseInfo(ImageBaseInfo r100) {
                SingleFieldBuilderV3<ImageBaseInfo, ImageBaseInfo.Builder, ImageBaseInfoOrBuilder> r101 = this.imageBaseInfoBuilder_;
                if (r101 != null) goto L9;
                ImageBaseInfo r102 = this.imageBaseInfo_;
                if (r102 == null) goto L7;
                this.imageBaseInfo_ = ImageBaseInfo.newBuilder(r102).mergeFrom(r100).buildPartial();
            L8:
                onChanged();
            L10:
                return this;
            L7:
                this.imageBaseInfo_ = r100;
                goto L8
            L9:
                r101.mergeFrom(r100);
                goto L10
            }

            public Builder mergeOcrInfo(OcrInfo r100) {
                SingleFieldBuilderV3<OcrInfo, OcrInfo.Builder, OcrInfoOrBuilder> r101 = this.ocrInfoBuilder_;
                if (r101 != null) goto L9;
                OcrInfo r102 = this.ocrInfo_;
                if (r102 == null) goto L7;
                this.ocrInfo_ = OcrInfo.newBuilder(r102).mergeFrom(r100).buildPartial();
            L8:
                onChanged();
            L10:
                return this;
            L7:
                this.ocrInfo_ = r100;
                goto L8
            L9:
                r101.mergeFrom(r100);
                goto L10
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.mergeUnknownFields(r100);
            }

            public Builder setChecksumMd5(String r100) {
                if (r100 == null) goto L6;
                this.checksumMd5_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setChecksumMd5Bytes(ByteString r100) {
                if (r100 == null) goto L6;
                FileData.access$5500(r100);
                this.checksumMd5_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setData(ByteString r100) {
                if (r100 == null) goto L6;
                this.data_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setFileBizInfo(FileBizInfo.Builder r100) {
                SingleFieldBuilderV3<FileBizInfo, FileBizInfo.Builder, FileBizInfoOrBuilder> r101 = this.fileBizInfoBuilder_;
                if (r101 != null) goto L5;
                this.fileBizInfo_ = r100.build();
                onChanged();
            L6:
                return this;
            L5:
                r101.setMessage(r100.build());
                goto L6
            }

            public Builder setFileType(FileType r100) {
                if (r100 == null) goto L6;
                this.fileType_ = r100.getNumber();
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setFileTypeValue(int r100) {
                this.fileType_ = r100;
                onChanged();
                return this;
            }

            public Builder setImageBaseInfo(ImageBaseInfo.Builder r100) {
                SingleFieldBuilderV3<ImageBaseInfo, ImageBaseInfo.Builder, ImageBaseInfoOrBuilder> r101 = this.imageBaseInfoBuilder_;
                if (r101 != null) goto L5;
                this.imageBaseInfo_ = r100.build();
                onChanged();
            L6:
                return this;
            L5:
                r101.setMessage(r100.build());
                goto L6
            }

            public Builder setOcrInfo(OcrInfo.Builder r100) {
                SingleFieldBuilderV3<OcrInfo, OcrInfo.Builder, OcrInfoOrBuilder> r101 = this.ocrInfoBuilder_;
                if (r101 != null) goto L5;
                this.ocrInfo_ = r100.build();
                onChanged();
            L6:
                return this;
            L5:
                r101.setMessage(r100.build());
                goto L6
            }

            public Builder setSizeBytes(long r100) {
                this.sizeBytes_ = r100;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.setUnknownFieldsProto3(r100);
            }

            public Builder setUploadId(String r100) {
                if (r100 == null) goto L6;
                this.uploadId_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setUploadIdBytes(ByteString r100) {
                if (r100 == null) goto L6;
                FileData.access$5400(r100);
                this.uploadId_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public /* synthetic */ Builder(AnonymousClass1 r100) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r100) {
                if ((r100 instanceof FileData) == true) goto L5;
                super.mergeFrom(r100);
                return this;
            L5:
                return mergeFrom((FileData) r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            public Builder setFileBizInfo(FileBizInfo r100) {
                SingleFieldBuilderV3<FileBizInfo, FileBizInfo.Builder, FileBizInfoOrBuilder> r101 = this.fileBizInfoBuilder_;
                if (r101 != null) goto L8;
                if (r100 == null) goto L7;
                this.fileBizInfo_ = r100;
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r101.setMessage(r100);
                goto L9
            }

            public Builder setImageBaseInfo(ImageBaseInfo r100) {
                SingleFieldBuilderV3<ImageBaseInfo, ImageBaseInfo.Builder, ImageBaseInfoOrBuilder> r101 = this.imageBaseInfoBuilder_;
                if (r101 != null) goto L8;
                if (r100 == null) goto L7;
                this.imageBaseInfo_ = r100;
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r101.setMessage(r100);
                goto L9
            }

            public Builder setOcrInfo(OcrInfo r100) {
                SingleFieldBuilderV3<OcrInfo, OcrInfo.Builder, OcrInfoOrBuilder> r101 = this.ocrInfoBuilder_;
                if (r101 != null) goto L8;
                if (r100 == null) goto L7;
                this.ocrInfo_ = r100;
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r101.setMessage(r100);
                goto L9
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r100, AnonymousClass1 r101) {
                this(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                FileData r102 = null;
                FileData r103 = (FileData) FileData.access$5300().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L7:
                th = th;
            L15:
                if (r102 == null) goto L17;
                mergeFrom(r102);
            L17:
                throw th;
            L9:
                e = move-exception;
                FileData r104 = (FileData) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r102 = r104;
                goto L15
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.setField(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return (Builder) super.setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }
        }

        static {
            DEFAULT_INSTANCE = new FileData();
            PARSER = new AnonymousClass1();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public String getChecksumMd5() {
            Object r100 = this.checksumMd5_;
            if ((r100 instanceof String) == true) goto L5;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.checksumMd5_ = r101;
            return r101;
        L5:
            return (String) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public ByteString getChecksumMd5Bytes() {
            Object r100 = this.checksumMd5_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.checksumMd5_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public FileBizInfo getFileBizInfo() {
            FileBizInfo r100 = this.fileBizInfo_;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return FileBizInfo.getDefaultInstance();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public FileType getFileType() {
            FileType r100 = FileType.valueOf(this.fileType_);
            if (r100 == null) goto L5;
            return r100;
        L5:
            return FileType.UNRECOGNIZED;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public ImageBaseInfo getImageBaseInfo() {
            ImageBaseInfo r100 = this.imageBaseInfo_;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return ImageBaseInfo.getDefaultInstance();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public OcrInfo getOcrInfo() {
            OcrInfo r100 = this.ocrInfo_;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return OcrInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if (getUploadIdBytes().isEmpty() == true) goto L9;
            r101 = 0 + GeneratedMessageV3.computeStringSize(1, this.uploadId_);
        L9:
            if (this.fileType_ == FileType.CONTENT_TYPE_UNSPECIFIED.getNumber()) goto L12;
            r101 = r101 + CodedOutputStream.computeEnumSize(2, this.fileType_);
        L12:
            if (this.data_.isEmpty() == true) goto L14;
            r101 = r101 + CodedOutputStream.computeBytesSize(3, this.data_);
        L14:
            long r102 = this.sizeBytes_;
            if (r102 == 0) goto L18;
            r101 = r101 + CodedOutputStream.computeInt64Size(4, r102);
        L18:
            if (getChecksumMd5Bytes().isEmpty() == true) goto L21;
            r101 = r101 + GeneratedMessageV3.computeStringSize(5, this.checksumMd5_);
        L21:
            if (this.ocrInfo_ == null) goto L24;
            r101 = r101 + CodedOutputStream.computeMessageSize(6, getOcrInfo());
        L24:
            if (this.imageBaseInfo_ == null) goto L27;
            r101 = r101 + CodedOutputStream.computeMessageSize(11, getImageBaseInfo());
        L27:
            if (this.fileBizInfo_ == null) goto L29;
            r101 = r101 + CodedOutputStream.computeMessageSize(12, getFileBizInfo());
        L29:
            int r103 = r101 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r103;
            return r103;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public String getUploadId() {
            Object r100 = this.uploadId_;
            if ((r100 instanceof String) == true) goto L5;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.uploadId_ = r101;
            return r101;
        L5:
            return (String) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public ByteString getUploadIdBytes() {
            Object r100 = this.uploadId_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.uploadId_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public boolean hasFileBizInfo() {
            if (this.fileBizInfo_ == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public boolean hasImageBaseInfo() {
            if (this.imageBaseInfo_ == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public boolean hasOcrInfo() {
            if (this.ocrInfo_ == null) goto L5;
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
            int r101 = ((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUploadId().hashCode()) * 37) + 2) * 53) + this.fileType_) * 37) + 3) * 53) + getData().hashCode()) * 37) + 4) * 53) + Internal.hashLong(getSizeBytes())) * 37) + 5) * 53) + getChecksumMd5().hashCode();
            if (hasOcrInfo() == false) goto L9;
            r101 = (((r101 * 37) + 6) * 53) + getOcrInfo().hashCode();
        L9:
            if (hasImageBaseInfo() == false) goto L12;
            r101 = (((r101 * 37) + 11) * 53) + getImageBaseInfo().hashCode();
        L12:
            if (hasFileBizInfo() == false) goto L14;
            r101 = (((r101 * 37) + 12) * 53) + getFileBizInfo().hashCode();
        L14:
            int r102 = (r101 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = r102;
            return r102;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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
        public Builder toBuilder() {
            AnonymousClass1 r100 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r100);
        L6:
            return new Builder(r100).mergeFrom(this);
        }

        private FileData() {
            this.memoizedIsInitialized = -1;
            this.uploadId_ = "";
            this.fileType_ = 0;
            this.data_ = ByteString.EMPTY;
            this.sizeBytes_ = 0;
            this.checksumMd5_ = "";
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvFile.access$3800();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public FileBizInfoOrBuilder getFileBizInfoOrBuilder() {
            return getFileBizInfo();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public ImageBaseInfoOrBuilder getImageBaseInfoOrBuilder() {
            return getImageBaseInfo();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public OcrInfoOrBuilder getOcrInfoOrBuilder() {
            return getOcrInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvFile.access$3900().ensureFieldAccessorsInitialized(FileData.class, Builder.class);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static /* synthetic */ boolean access$4200() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ Parser access$5300() {
            return PARSER;
        }

        public static FileData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FileData> parser() {
            return PARSER;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public int getFileTypeValue() {
            return this.fileType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FileData> getParserForType() {
            return PARSER;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDataOrBuilder
        public long getSizeBytes() {
            return this.sizeBytes_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FileData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private FileData(GeneratedMessageV3.Builder<?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ Object access$4400(FileData r100) {
            return r100.uploadId_;
        }

        public static /* synthetic */ int access$4500(FileData r100) {
            return r100.fileType_;
        }

        public static /* synthetic */ Object access$4800(FileData r100) {
            return r100.checksumMd5_;
        }

        public static /* synthetic */ UnknownFieldSet access$5200(FileData r100) {
            return r100.unknownFields;
        }

        public static /* synthetic */ void access$5400(ByteString r100) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(r100);
        }

        public static /* synthetic */ void access$5500(ByteString r100) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(r100);
        }

        public static Builder newBuilder(FileData r100) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
        }

        public static FileData parseDelimitedFrom(InputStream r100) throws IOException {
            return (FileData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
        }

        public static FileData parseFrom(ByteString r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof FileData) == false) goto L8;
            FileData r101 = (FileData) r100;
            if (getUploadId().equals(r101.getUploadId()) == false) goto L12;
            boolean r102 = true;
        L13:
            if (r102 == true) goto L15;
        L17:
            boolean r103 = false;
        L18:
            if (r103 == true) goto L20;
        L22:
            boolean r104 = false;
        L23:
            if (r104 == true) goto L25;
        L27:
            boolean r105 = false;
        L28:
            if (r105 == true) goto L30;
        L32:
            boolean r106 = false;
        L33:
            if (r106 == true) goto L35;
        L37:
            boolean r107 = false;
        L39:
            if (hasOcrInfo() == false) goto L45;
            if (r107 == true) goto L42;
        L44:
            r107 = false;
            goto L45
        L42:
            if (getOcrInfo().equals(r101.getOcrInfo()) == false) goto L44;
            r107 = true;
        L45:
            if (r107 == true) goto L47;
        L49:
            boolean r108 = false;
        L51:
            if (hasImageBaseInfo() == false) goto L57;
            if (r108 == true) goto L54;
        L56:
            r108 = false;
            goto L57
        L54:
            if (getImageBaseInfo().equals(r101.getImageBaseInfo()) == false) goto L56;
            r108 = true;
        L57:
            if (r108 == true) goto L59;
        L61:
            boolean r109 = false;
        L63:
            if (hasFileBizInfo() == false) goto L69;
            if (r109 == true) goto L66;
        L68:
            r109 = false;
            goto L69
        L66:
            if (getFileBizInfo().equals(r101.getFileBizInfo()) == false) goto L68;
            r109 = true;
        L69:
            if (r109 == true) goto L71;
        L73:
            return false;
        L71:
            if (this.unknownFields.equals(r101.unknownFields) == false) goto L73;
            return true;
        L59:
            if (hasFileBizInfo() != r101.hasFileBizInfo()) goto L61;
            r109 = true;
            goto L63
        L47:
            if (hasImageBaseInfo() != r101.hasImageBaseInfo()) goto L49;
            r108 = true;
            goto L51
        L35:
            if (hasOcrInfo() != r101.hasOcrInfo()) goto L37;
            r107 = true;
            goto L39
        L30:
            if (getChecksumMd5().equals(r101.getChecksumMd5()) == false) goto L32;
            r106 = true;
            goto L33
        L25:
            if (getSizeBytes() != r101.getSizeBytes()) goto L27;
            r105 = true;
            goto L28
        L20:
            if (getData().equals(r101.getData()) == false) goto L22;
            r104 = true;
            goto L23
        L15:
            if (this.fileType_ != r101.fileType_) goto L17;
            r103 = true;
            goto L18
        L12:
            r102 = false;
            goto L13
        L8:
            return super.equals(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return new Builder(r100, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            if (getUploadIdBytes().isEmpty() == true) goto L6;
            GeneratedMessageV3.writeString(r100, 1, this.uploadId_);
        L6:
            if (this.fileType_ == FileType.CONTENT_TYPE_UNSPECIFIED.getNumber()) goto L9;
            r100.writeEnum(2, this.fileType_);
        L9:
            if (this.data_.isEmpty() == true) goto L11;
            r100.writeBytes(3, this.data_);
        L11:
            long r101 = this.sizeBytes_;
            if (r101 == 0) goto L15;
            r100.writeInt64(4, r101);
        L15:
            if (getChecksumMd5Bytes().isEmpty() == true) goto L18;
            GeneratedMessageV3.writeString(r100, 5, this.checksumMd5_);
        L18:
            if (this.ocrInfo_ == null) goto L21;
            r100.writeMessage(6, getOcrInfo());
        L21:
            if (this.imageBaseInfo_ == null) goto L24;
            r100.writeMessage(11, getImageBaseInfo());
        L24:
            if (this.fileBizInfo_ == null) goto L26;
            r100.writeMessage(12, getFileBizInfo());
        L26:
            this.unknownFields.writeTo(r100);
        }

        public static FileData parseFrom(CodedInputStream r100) throws IOException {
            return (FileData) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return newBuilderForType(r100);
        }

        public static FileData parseFrom(InputStream r100) throws IOException {
            return (FileData) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        public static FileData parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        public static FileData parseFrom(byte[] r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        private FileData(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this();
            if (r101 == null) goto L67;
            UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
            boolean r103 = false;
        L5:
            if (r103 == true) goto L65;
            int r104 = r100.readTag();     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            if (r104 == 0) goto L54;
            if (r104 != 10) goto L11;
            this.uploadId_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            goto L5
        L11:
            if (r104 != 16) goto L13;
            this.fileType_ = r100.readEnum();     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            goto L5
        L13:
            if (r104 != 26) goto L15;
            this.data_ = r100.readBytes();     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            goto L5
        L15:
            if (r104 != 32) goto L17;
            this.sizeBytes_ = r100.readInt64();     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            goto L5
        L17:
            if (r104 != 42) goto L19;
            this.checksumMd5_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            goto L5
        L19:
            if (r104 != 50) goto L21;
            OcrInfo r105 = this.ocrInfo_;     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            if (r105 == null) goto L44;
            OcrInfo.Builder r106 = r105.toBuilder();     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
        L45:
            OcrInfo r107 = (OcrInfo) r100.readMessage(OcrInfo.parser(), r101);     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            this.ocrInfo_ = r107;     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            if (r106 == null) goto L5;
            r106.mergeFrom(r107);     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            this.ocrInfo_ = r106.buildPartial();     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            goto L5
        L44:
            r106 = null;
            goto L45
        L21:
            if (r104 != 90) goto L23;
            ImageBaseInfo r108 = this.imageBaseInfo_;     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            if (r108 == null) goto L37;
            ImageBaseInfo.Builder r109 = r108.toBuilder();     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
        L38:
            ImageBaseInfo r110 = (ImageBaseInfo) r100.readMessage(ImageBaseInfo.parser(), r101);     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            this.imageBaseInfo_ = r110;     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            if (r109 == null) goto L5;
            r109.mergeFrom(r110);     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            this.imageBaseInfo_ = r109.buildPartial();     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            goto L5
        L37:
            r109 = null;
            goto L38
        L23:
            if (r104 != 98) goto L25;
            FileBizInfo r111 = this.fileBizInfo_;     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            if (r111 == null) goto L30;
            FileBizInfo.Builder r112 = r111.toBuilder();     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
        L31:
            FileBizInfo r113 = (FileBizInfo) r100.readMessage(FileBizInfo.parser(), r101);     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            this.fileBizInfo_ = r113;     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            if (r112 == null) goto L5;
            r112.mergeFrom(r113);     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            this.fileBizInfo_ = r112.buildPartial();     // Catch: Throwable -> L55 IOException -> L57 InvalidProtocolBufferException -> L60
            goto L5
        L30:
            r112 = null;
            goto L31
        L25:
            if (parseUnknownFieldProto3(r100, r102, r101, r104) == true) goto L5;
        L54:
            r103 = true;
            goto L5
        L55:
            th = move-exception;
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            throw th;
        L60:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L55
        L57:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L55
        L65:
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            return;
        L67:
            throw null;
        }

        public static /* synthetic */ Object access$4402(FileData r100, Object r101) {
            r100.uploadId_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$4502(FileData r100, int r101) {
            r100.fileType_ = r101;
            return r101;
        }

        public static /* synthetic */ ByteString access$4602(FileData r100, ByteString r101) {
            r100.data_ = r101;
            return r101;
        }

        public static /* synthetic */ long access$4702(FileData r100, long r101) {
            r100.sizeBytes_ = r101;
            return r101;
        }

        public static /* synthetic */ Object access$4802(FileData r100, Object r101) {
            r100.checksumMd5_ = r101;
            return r101;
        }

        public static /* synthetic */ OcrInfo access$4902(FileData r100, OcrInfo r101) {
            r100.ocrInfo_ = r101;
            return r101;
        }

        public static /* synthetic */ ImageBaseInfo access$5002(FileData r100, ImageBaseInfo r101) {
            r100.imageBaseInfo_ = r101;
            return r101;
        }

        public static /* synthetic */ FileBizInfo access$5102(FileData r100, FileBizInfo r101) {
            r100.fileBizInfo_ = r101;
            return r101;
        }

        public static FileData parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
        }

        public static FileData parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ FileData(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static FileData parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileData) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static FileData parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileData) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static FileData parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public static FileData parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ FileData(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface FileDataOrBuilder extends MessageOrBuilder {
        String getChecksumMd5();

        ByteString getChecksumMd5Bytes();

        ByteString getData();

        FileBizInfo getFileBizInfo();

        FileBizInfoOrBuilder getFileBizInfoOrBuilder();

        FileType getFileType();

        int getFileTypeValue();

        ImageBaseInfo getImageBaseInfo();

        ImageBaseInfoOrBuilder getImageBaseInfoOrBuilder();

        OcrInfo getOcrInfo();

        OcrInfoOrBuilder getOcrInfoOrBuilder();

        long getSizeBytes();

        String getUploadId();

        ByteString getUploadIdBytes();

        boolean hasFileBizInfo();

        boolean hasImageBaseInfo();

        boolean hasOcrInfo();
    }

    public static final class FileDownlinkBody extends GeneratedMessageV3 implements FileDownlinkBodyOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final FileDownlinkBody DEFAULT_INSTANCE = null;
        public static final int EXT_FIELD_NUMBER = 11;
        public static final int FILE_RESULTS_FIELD_NUMBER = 3;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        private static final Parser<FileDownlinkBody> PARSER = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private long code_;
        private MapField<String, String> ext_;
        private List<FileResult> fileResults_;
        private byte memoizedIsInitialized;
        private volatile Object message_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FileDownlinkBodyOrBuilder {
            private int bitField0_;
            private long code_;
            private MapField<String, String> ext_;
            private RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> fileResultsBuilder_;
            private List<FileResult> fileResults_;
            private Object message_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private void ensureFileResultsIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.fileResults_ = new ArrayList(this.fileResults_);
                this.bitField0_ |= 4;
                return;
            }

            private RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> getFileResultsFieldBuilder() {
                if (this.fileResultsBuilder_ != null) goto L10;
                List<FileResult> r100 = this.fileResults_;
                if ((this.bitField0_ & 4) != 4) goto L7;
                boolean r101 = true;
            L8:
                this.fileResultsBuilder_ = new RepeatedFieldBuilderV3(r100, r101, getParentForChildren(), isClean());
                this.fileResults_ = null;
                goto L10
            L7:
                r101 = false;
            L10:
                return this.fileResultsBuilder_;
            }

            private MapField<String, String> internalGetExt() {
                MapField<String, String> r100 = this.ext_;
                if (r100 == null) goto L5;
                return r100;
            L5:
                return MapField.emptyMapField(ExtDefaultEntryHolder.defaultEntry);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileDownlinkBody buildPartial() {
                FileDownlinkBody r100 = new FileDownlinkBody(this, null);
                FileDownlinkBody.access$10302(r100, this.code_);
                FileDownlinkBody.access$10402(r100, this.message_);
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r101 = this.fileResultsBuilder_;
                if (r101 == null) goto L5;
                FileDownlinkBody.access$10502(r100, r101.build());
            L9:
                FileDownlinkBody.access$10602(r100, internalGetExt());
                FileDownlinkBody.access$10600(r100).makeImmutable();
                FileDownlinkBody.access$10702(r100, 0);
                onBuilt();
                return r100;
            L5:
                if ((this.bitField0_ & 4) != 4) goto L7;
                this.fileResults_ = Collections.unmodifiableList(this.fileResults_);
                this.bitField0_ &= -5;
            L7:
                FileDownlinkBody.access$10502(r100, this.fileResults_);
                goto L9
            }

            public Builder clearCode() {
                this.code_ = 0;
                onChanged();
                return this;
            }

            public Builder clearFileResults() {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r100 = this.fileResultsBuilder_;
                if (r100 != null) goto L5;
                this.fileResults_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
            L6:
                return this;
            L5:
                r100.clear();
                goto L6
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public int getFileResultsCount() {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r100 = this.fileResultsBuilder_;
                if (r100 != null) goto L7;
                return this.fileResults_.size();
            L7:
                return r100.getCount();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public List<FileResult> getFileResultsList() {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r100 = this.fileResultsBuilder_;
                if (r100 != null) goto L7;
                return Collections.unmodifiableList(this.fileResults_);
            L7:
                return r100.getMessageList();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public List<? extends FileResultOrBuilder> getFileResultsOrBuilderList() {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r100 = this.fileResultsBuilder_;
                if (r100 == null) goto L7;
                return r100.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.fileResults_);
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public String getMessage() {
                Object r100 = this.message_;
                if ((r100 instanceof String) == true) goto L7;
                String r101 = ((ByteString) r100).toStringUtf8();
                this.message_ = r101;
                return r101;
            L7:
                return (String) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public ByteString getMessageBytes() {
                Object r100 = this.message_;
                if ((r100 instanceof String) == false) goto L7;
                ByteString r101 = ByteString.copyFromUtf8((String) r100);
                this.message_ = r101;
                return r101;
            L7:
                return (ByteString) r100;
            }

            private Builder() {
                this.message_ = "";
                this.fileResults_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvFile.access$9600();
            }

            private MapField<String, String> internalGetMutableExt() {
                onChanged();
                if (this.ext_ != null) goto L6;
                this.ext_ = MapField.newMapField(ExtDefaultEntryHolder.defaultEntry);
            L6:
                if (this.ext_.isMutable() == true) goto L9;
                this.ext_ = this.ext_.copy();
            L9:
                return this.ext_;
            }

            private void maybeForceBuilderInitialization() {
                if (FileDownlinkBody.access$10100() == false) goto L6;
                getFileResultsFieldBuilder();
                return;
            }

            public FileResult.Builder addFileResultsBuilder() {
                return (FileResult.Builder) getFileResultsFieldBuilder().addBuilder(FileResult.getDefaultInstance());
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileDownlinkBody build() {
                FileDownlinkBody r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.code_ = 0;
                this.message_ = "";
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r100 = this.fileResultsBuilder_;
                if (r100 != null) goto L5;
                this.fileResults_ = Collections.emptyList();
                this.bitField0_ &= -5;
            L6:
                internalGetMutableExt().clear();
                return this;
            L5:
                r100.clear();
                goto L6
            }

            public Builder clearExt() {
                internalGetMutableExt().getMutableMap().clear();
                return this;
            }

            public Builder clearMessage() {
                this.message_ = FileDownlinkBody.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvFile.access$9600();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public Map<String, String> getExt() {
                return getExtMap();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public int getExtCount() {
                return internalGetExt().getMap().size();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public Map<String, String> getExtMap() {
                return internalGetExt().getMap();
            }

            public List<FileResult.Builder> getFileResultsBuilderList() {
                return getFileResultsFieldBuilder().getBuilderList();
            }

            public Map<String, String> getMutableExt() {
                return internalGetMutableExt().getMutableMap();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvFile.access$9700().ensureFieldAccessorsInitialized(FileDownlinkBody.class, Builder.class);
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public long getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FileDownlinkBody getDefaultInstanceForType() {
                return FileDownlinkBody.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo8531clone() throws CloneNotSupportedException {
                return clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r100) {
                super(r100);
                this.message_ = "";
                this.fileResults_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addAllFileResults(Iterable<? extends FileResult> r100) {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r101 = this.fileResultsBuilder_;
                if (r101 != null) goto L5;
                ensureFileResultsIsMutable();
                AbstractMessageLite.Builder.addAll(r100, this.fileResults_);
                onChanged();
            L6:
                return this;
            L5:
                r101.addAllMessages(r100);
                goto L6
            }

            public Builder addFileResults(FileResult.Builder r100) {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r101 = this.fileResultsBuilder_;
                if (r101 != null) goto L5;
                ensureFileResultsIsMutable();
                this.fileResults_.add(r100.build());
                onChanged();
            L6:
                return this;
            L5:
                r101.addMessage(r100.build());
                goto L6
            }

            public FileResult.Builder addFileResultsBuilder(int r100) {
                return (FileResult.Builder) getFileResultsFieldBuilder().addBuilder(r100, FileResult.getDefaultInstance());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor r100) {
                return (Builder) super.clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return (Builder) super.clearOneof(r100);
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public boolean containsExt(String r100) {
                if (r100 == null) goto L6;
                return internalGetExt().getMap().containsKey(r100);
            L6:
                throw null;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public String getExtOrThrow(String r100) {
                if (r100 == null) goto L10;
                Map<String, String> r101 = internalGetExt().getMap();
                if (r101.containsKey(r100) == false) goto L8;
                return r101.get(r100);
            L8:
                throw new IllegalArgumentException();
            L10:
                throw null;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public FileResult getFileResults(int r100) {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r101 = this.fileResultsBuilder_;
                if (r101 != null) goto L7;
                return (FileResult) ListProtector.get(this.fileResults_, r100);
            L7:
                return (FileResult) r101.getMessage(r100);
            }

            public FileResult.Builder getFileResultsBuilder(int r100) {
                return (FileResult.Builder) getFileResultsFieldBuilder().getBuilder(r100);
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public FileResultOrBuilder getFileResultsOrBuilder(int r100) {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r101 = this.fileResultsBuilder_;
                if (r101 != null) goto L7;
                return (FileResultOrBuilder) ListProtector.get(this.fileResults_, r100);
            L7:
                return (FileResultOrBuilder) r101.getMessageOrBuilder(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMapField(int r100) {
                if (r100 != 11) goto L7;
                return internalGetExt();
            L7:
                throw new RuntimeException("Invalid map field number: " + r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMutableMapField(int r100) {
                if (r100 != 11) goto L7;
                return internalGetMutableExt();
            L7:
                throw new RuntimeException("Invalid map field number: " + r100);
            }

            public Builder mergeFrom(FileDownlinkBody r100) {
                if (r100 != FileDownlinkBody.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.getCode() == 0) goto L9;
                setCode(r100.getCode());
            L9:
                if (r100.getMessage().isEmpty() == true) goto L12;
                this.message_ = FileDownlinkBody.access$10400(r100);
                onChanged();
            L12:
                if (this.fileResultsBuilder_ != null) goto L21;
                if (FileDownlinkBody.access$10500(r100).isEmpty() == false) goto L16;
            L29:
                internalGetMutableExt().mergeFrom(FileDownlinkBody.access$10900(r100));
                mergeUnknownFields(FileDownlinkBody.access$11000(r100));
                onChanged();
                return this;
            L16:
                if (this.fileResults_.isEmpty() == false) goto L18;
                this.fileResults_ = FileDownlinkBody.access$10500(r100);
                this.bitField0_ &= -5;
            L19:
                onChanged();
                goto L29
            L18:
                ensureFileResultsIsMutable();
                this.fileResults_.addAll(FileDownlinkBody.access$10500(r100));
                goto L19
            L21:
                if (FileDownlinkBody.access$10500(r100).isEmpty() == true) goto L29;
                if (this.fileResultsBuilder_.isEmpty() == false) goto L28;
                this.fileResultsBuilder_.dispose();
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r101 = null;
                this.fileResultsBuilder_ = null;
                this.fileResults_ = FileDownlinkBody.access$10500(r100);
                this.bitField0_ &= -5;
                if (FileDownlinkBody.access$10800() == false) goto L27;
                r101 = getFileResultsFieldBuilder();
            L27:
                this.fileResultsBuilder_ = r101;
                goto L29
            L28:
                this.fileResultsBuilder_.addAllMessages(FileDownlinkBody.access$10500(r100));
                goto L29
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.mergeUnknownFields(r100);
            }

            public Builder putAllExt(Map<String, String> r100) {
                internalGetMutableExt().getMutableMap().putAll(r100);
                return this;
            }

            public Builder removeExt(String r100) {
                if (r100 == null) goto L6;
                internalGetMutableExt().getMutableMap().remove(r100);
                return this;
            L6:
                throw null;
            }

            public Builder removeFileResults(int r100) {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r101 = this.fileResultsBuilder_;
                if (r101 != null) goto L5;
                ensureFileResultsIsMutable();
                ListProtector.remove(this.fileResults_, r100);
                onChanged();
            L6:
                return this;
            L5:
                r101.remove(r100);
                goto L6
            }

            public Builder setCode(long r100) {
                this.code_ = r100;
                onChanged();
                return this;
            }

            public Builder setMessage(String r100) {
                if (r100 == null) goto L6;
                this.message_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setMessageBytes(ByteString r100) {
                if (r100 == null) goto L6;
                FileDownlinkBody.access$11200(r100);
                this.message_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.setUnknownFieldsProto3(r100);
            }

            public /* synthetic */ Builder(AnonymousClass1 r100) {
                this();
            }

            public Builder addFileResults(FileResult r100) {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r101 = this.fileResultsBuilder_;
                if (r101 != null) goto L8;
                if (r100 == null) goto L7;
                ensureFileResultsIsMutable();
                this.fileResults_.add(r100);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r101.addMessage(r100);
                goto L9
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r100) {
                if ((r100 instanceof FileDownlinkBody) == true) goto L5;
                super.mergeFrom(r100);
                return this;
            L5:
                return mergeFrom((FileDownlinkBody) r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r100, AnonymousClass1 r101) {
                this(r100);
            }

            public Builder addFileResults(int r100, FileResult.Builder r101) {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r102 = this.fileResultsBuilder_;
                if (r102 != null) goto L5;
                ensureFileResultsIsMutable();
                ListProtector.add(this.fileResults_, r100, r101.build());
                onChanged();
            L6:
                return this;
            L5:
                r102.addMessage(r100, r101.build());
                goto L6
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.addRepeatedField(r100, r101);
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
            public String getExtOrDefault(String r100, String r101) {
                if (r100 == null) goto L8;
                Map<String, String> r102 = internalGetExt().getMap();
                if (r102.containsKey(r100) == true) goto L6;
                return r101;
            L6:
                return r102.get(r100);
            L8:
                throw null;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                FileDownlinkBody r102 = null;
                FileDownlinkBody r103 = (FileDownlinkBody) FileDownlinkBody.access$11100().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L7:
                th = th;
            L15:
                if (r102 == null) goto L17;
                mergeFrom(r102);
            L17:
                throw th;
            L9:
                e = move-exception;
                FileDownlinkBody r104 = (FileDownlinkBody) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r102 = r104;
                goto L15
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            }

            public Builder putExt(String r100, String r101) {
                if (r100 == null) goto L8;
                if (r101 == null) goto L7;
                internalGetMutableExt().getMutableMap().put(r100, r101);
                return this;
            L7:
                throw null;
            L8:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.setField(r100, r101);
            }

            public Builder setFileResults(int r100, FileResult.Builder r101) {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r102 = this.fileResultsBuilder_;
                if (r102 != null) goto L5;
                ensureFileResultsIsMutable();
                ListProtector.set(this.fileResults_, r100, r101.build());
                onChanged();
            L6:
                return this;
            L5:
                r102.setMessage(r100, r101.build());
                goto L6
            }

            public Builder addFileResults(int r100, FileResult r101) {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r102 = this.fileResultsBuilder_;
                if (r102 != null) goto L8;
                if (r101 == null) goto L7;
                ensureFileResultsIsMutable();
                ListProtector.add(this.fileResults_, r100, r101);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r102.addMessage(r100, r101);
                goto L9
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            public Builder setFileResults(int r100, FileResult r101) {
                RepeatedFieldBuilderV3<FileResult, FileResult.Builder, FileResultOrBuilder> r102 = this.fileResultsBuilder_;
                if (r102 != null) goto L8;
                if (r101 == null) goto L7;
                ensureFileResultsIsMutable();
                ListProtector.set(this.fileResults_, r100, r101);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r102.setMessage(r100, r101);
                goto L9
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return (Builder) super.setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }
        }

        public static final class ExtDefaultEntryHolder {
            static final MapEntry<String, String> defaultEntry = null;

            private ExtDefaultEntryHolder() {
            }

            static {
                Descriptors.Descriptor r100 = AvFile.access$9800();
                WireFormat.FieldType r101 = WireFormat.FieldType.STRING;
                defaultEntry = MapEntry.newDefaultInstance(r100, r101, "", r101, "");
            }
        }

        static {
            DEFAULT_INSTANCE = new FileDownlinkBody();
            PARSER = new AnonymousClass1();
        }

        private MapField<String, String> internalGetExt() {
            MapField<String, String> r100 = this.ext_;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return MapField.emptyMapField(ExtDefaultEntryHolder.defaultEntry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public int getFileResultsCount() {
            return this.fileResults_.size();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public String getMessage() {
            Object r100 = this.message_;
            if ((r100 instanceof String) == true) goto L5;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.message_ = r101;
            return r101;
        L5:
            return (String) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public ByteString getMessageBytes() {
            Object r100 = this.message_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.message_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            long r101 = this.code_;
            int r102 = 0;
            if (r101 == 0) goto L8;
            int r103 = CodedOutputStream.computeInt64Size(1, r101) + 0;
        L10:
            if (getMessageBytes().isEmpty() == true) goto L13;
            r103 = r103 + GeneratedMessageV3.computeStringSize(2, this.message_);
        L13:
            if (r102 >= this.fileResults_.size()) goto L15;
            r103 = r103 + CodedOutputStream.computeMessageSize(3, (MessageLite) ListProtector.get(this.fileResults_, r102));
            r102 = r102 + 1;
            goto L13
        L15:
            Iterator<Map.Entry<String, String>> r104 = internalGetExt().getMap().entrySet().iterator();
        L17:
            if (r104.hasNext() == false) goto L19;
            Map.Entry<String, String> r105 = r104.next();
            r103 = r103 + CodedOutputStream.computeMessageSize(11, ExtDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(r105.getKey()).setValue(r105.getValue()).build());
            goto L17
        L19:
            int r106 = r103 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r106;
            return r106;
        L8:
            r103 = 0;
            goto L10
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int r100 = this.memoizedHashCode;
            if (r100 == 0) goto L5;
            return r100;
        L5:
            int r101 = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getCode())) * 37) + 2) * 53) + getMessage().hashCode();
            if (getFileResultsCount() <= 0) goto L9;
            r101 = (((r101 * 37) + 3) * 53) + getFileResultsList().hashCode();
        L9:
            if (internalGetExt().getMap().isEmpty() == true) goto L11;
            r101 = (((r101 * 37) + 11) * 53) + internalGetExt().hashCode();
        L11:
            int r102 = (r101 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = r102;
            return r102;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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
        public Builder toBuilder() {
            AnonymousClass1 r100 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r100);
        L6:
            return new Builder(r100).mergeFrom(this);
        }

        private FileDownlinkBody() {
            this.memoizedIsInitialized = -1;
            this.code_ = 0;
            this.message_ = "";
            this.fileResults_ = Collections.emptyList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvFile.access$9600();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public Map<String, String> getExt() {
            return getExtMap();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public int getExtCount() {
            return internalGetExt().getMap().size();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public Map<String, String> getExtMap() {
            return internalGetExt().getMap();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvFile.access$9700().ensureFieldAccessorsInitialized(FileDownlinkBody.class, Builder.class);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static /* synthetic */ boolean access$10100() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$10800() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ Parser access$11100() {
            return PARSER;
        }

        public static FileDownlinkBody getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FileDownlinkBody> parser() {
            return PARSER;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public long getCode() {
            return this.code_;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public List<FileResult> getFileResultsList() {
            return this.fileResults_;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public List<? extends FileResultOrBuilder> getFileResultsOrBuilderList() {
            return this.fileResults_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FileDownlinkBody> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FileDownlinkBody getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private FileDownlinkBody(GeneratedMessageV3.Builder<?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ Object access$10400(FileDownlinkBody r100) {
            return r100.message_;
        }

        public static /* synthetic */ List access$10500(FileDownlinkBody r100) {
            return r100.fileResults_;
        }

        public static /* synthetic */ MapField access$10600(FileDownlinkBody r100) {
            return r100.ext_;
        }

        public static /* synthetic */ MapField access$10900(FileDownlinkBody r100) {
            return r100.internalGetExt();
        }

        public static /* synthetic */ UnknownFieldSet access$11000(FileDownlinkBody r100) {
            return r100.unknownFields;
        }

        public static /* synthetic */ void access$11200(ByteString r100) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(r100);
        }

        public static Builder newBuilder(FileDownlinkBody r100) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
        }

        public static FileDownlinkBody parseDelimitedFrom(InputStream r100) throws IOException {
            return (FileDownlinkBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
        }

        public static FileDownlinkBody parseFrom(ByteString r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public boolean containsExt(String r100) {
            if (r100 == null) goto L6;
            return internalGetExt().getMap().containsKey(r100);
        L6:
            throw null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof FileDownlinkBody) == false) goto L8;
            FileDownlinkBody r101 = (FileDownlinkBody) r100;
            if (getCode() != r101.getCode()) goto L12;
            boolean r102 = true;
        L13:
            if (r102 == true) goto L15;
        L17:
            boolean r103 = false;
        L18:
            if (r103 == true) goto L20;
        L22:
            boolean r104 = false;
        L23:
            if (r104 == true) goto L25;
        L27:
            boolean r105 = false;
        L28:
            if (r105 == true) goto L30;
        L32:
            return false;
        L30:
            if (this.unknownFields.equals(r101.unknownFields) == false) goto L32;
            return true;
        L25:
            if (internalGetExt().equals(r101.internalGetExt()) == false) goto L27;
            r105 = true;
            goto L28
        L20:
            if (getFileResultsList().equals(r101.getFileResultsList()) == false) goto L22;
            r104 = true;
            goto L23
        L15:
            if (getMessage().equals(r101.getMessage()) == false) goto L17;
            r103 = true;
            goto L18
        L12:
            r102 = false;
            goto L13
        L8:
            return super.equals(r100);
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public String getExtOrThrow(String r100) {
            if (r100 == null) goto L10;
            Map<String, String> r101 = internalGetExt().getMap();
            if (r101.containsKey(r100) == false) goto L8;
            return r101.get(r100);
        L8:
            throw new IllegalArgumentException();
        L10:
            throw null;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public FileResult getFileResults(int r100) {
            return (FileResult) ListProtector.get(this.fileResults_, r100);
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public FileResultOrBuilder getFileResultsOrBuilder(int r100) {
            return (FileResultOrBuilder) ListProtector.get(this.fileResults_, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public MapField internalGetMapField(int r100) {
            if (r100 != 11) goto L7;
            return internalGetExt();
        L7:
            throw new RuntimeException("Invalid map field number: " + r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return new Builder(r100, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            long r101 = this.code_;
            if (r101 == 0) goto L6;
            r100.writeInt64(1, r101);
        L6:
            if (getMessageBytes().isEmpty() == true) goto L8;
            GeneratedMessageV3.writeString(r100, 2, this.message_);
        L8:
            int r102 = 0;
        L10:
            if (r102 >= this.fileResults_.size()) goto L12;
            r100.writeMessage(3, (MessageLite) ListProtector.get(this.fileResults_, r102));
            r102 = r102 + 1;
            goto L10
        L12:
            GeneratedMessageV3.serializeStringMapTo(r100, internalGetExt(), ExtDefaultEntryHolder.defaultEntry, 11);
            this.unknownFields.writeTo(r100);
        }

        public static FileDownlinkBody parseFrom(CodedInputStream r100) throws IOException {
            return (FileDownlinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return newBuilderForType(r100);
        }

        public static FileDownlinkBody parseFrom(InputStream r100) throws IOException {
            return (FileDownlinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        public static FileDownlinkBody parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        public static FileDownlinkBody parseFrom(byte[] r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        private FileDownlinkBody(CodedInputStream r100, ExtensionRegistryLite r110) throws InvalidProtocolBufferException {
            this();
            if (r110 == null) goto L51;
            UnknownFieldSet.Builder r101 = UnknownFieldSet.newBuilder();
            boolean r102 = false;
            int r103 = 0;
        L6:
            if (r102 == true) goto L46;
            int r104 = r100.readTag();     // Catch: Throwable -> L32 IOException -> L34 InvalidProtocolBufferException -> L37
            if (r104 == 0) goto L31;
            if (r104 != 8) goto L12;
            this.code_ = r100.readInt64();     // Catch: Throwable -> L32 IOException -> L34 InvalidProtocolBufferException -> L37
            goto L6
        L12:
            if (r104 != 18) goto L14;
            this.message_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L32 IOException -> L34 InvalidProtocolBufferException -> L37
            goto L6
        L14:
            if (r104 != 26) goto L16;
            if ((r103 & 4) == 4) goto L27;
            this.fileResults_ = new ArrayList();     // Catch: Throwable -> L32 IOException -> L34 InvalidProtocolBufferException -> L37
            r103 = r103 | 4;     // Catch: Throwable -> L32 IOException -> L34 InvalidProtocolBufferException -> L37
        L27:
            this.fileResults_.add((FileResult) r100.readMessage(FileResult.parser(), r110));     // Catch: Throwable -> L32 IOException -> L34 InvalidProtocolBufferException -> L37
            goto L6
        L16:
            if (r104 != 90) goto L18;
            if ((r103 & 8) == 8) goto L23;
            this.ext_ = MapField.newMapField(ExtDefaultEntryHolder.defaultEntry);     // Catch: Throwable -> L32 IOException -> L34 InvalidProtocolBufferException -> L37
            r103 = r103 | 8;     // Catch: Throwable -> L32 IOException -> L34 InvalidProtocolBufferException -> L37
        L23:
            MapEntry r105 = (MapEntry) r100.readMessage(ExtDefaultEntryHolder.defaultEntry.getParserForType(), r110);     // Catch: Throwable -> L32 IOException -> L34 InvalidProtocolBufferException -> L37
            this.ext_.getMutableMap().put((String) r105.getKey(), (String) r105.getValue());     // Catch: Throwable -> L32 IOException -> L34 InvalidProtocolBufferException -> L37
            goto L6
        L18:
            if (parseUnknownFieldProto3(r100, r101, r110, r104) == true) goto L6;
        L31:
            r102 = true;
            goto L6
        L32:
            th = move-exception;
            if ((r103 & 4) != 4) goto L43;
            this.fileResults_ = Collections.unmodifiableList(this.fileResults_);
        L43:
            this.unknownFields = r101.build();
            makeExtensionsImmutable();
            throw th;
        L37:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L32
        L34:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L32
        L46:
            if ((r103 & 4) != 4) goto L48;
            this.fileResults_ = Collections.unmodifiableList(this.fileResults_);
        L48:
            this.unknownFields = r101.build();
            makeExtensionsImmutable();
            return;
        L51:
            throw null;
        }

        public static /* synthetic */ long access$10302(FileDownlinkBody r100, long r101) {
            r100.code_ = r101;
            return r101;
        }

        public static /* synthetic */ Object access$10402(FileDownlinkBody r100, Object r101) {
            r100.message_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$10502(FileDownlinkBody r100, List r101) {
            r100.fileResults_ = r101;
            return r101;
        }

        public static /* synthetic */ MapField access$10602(FileDownlinkBody r100, MapField r101) {
            r100.ext_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$10702(FileDownlinkBody r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public static FileDownlinkBody parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileDownlinkBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
        }

        public static FileDownlinkBody parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileDownlinkBodyOrBuilder
        public String getExtOrDefault(String r100, String r101) {
            if (r100 == null) goto L8;
            Map<String, String> r102 = internalGetExt().getMap();
            if (r102.containsKey(r100) == true) goto L6;
            return r101;
        L6:
            return r102.get(r100);
        L8:
            throw null;
        }

        public /* synthetic */ FileDownlinkBody(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static FileDownlinkBody parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileDownlinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static FileDownlinkBody parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileDownlinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static FileDownlinkBody parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public static FileDownlinkBody parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ FileDownlinkBody(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface FileDownlinkBodyOrBuilder extends MessageOrBuilder {
        boolean containsExt(String r100);

        long getCode();

        Map<String, String> getExt();

        int getExtCount();

        Map<String, String> getExtMap();

        String getExtOrDefault(String r100, String r101);

        String getExtOrThrow(String r100);

        FileResult getFileResults(int r100);

        int getFileResultsCount();

        List<FileResult> getFileResultsList();

        FileResultOrBuilder getFileResultsOrBuilder(int r100);

        List<? extends FileResultOrBuilder> getFileResultsOrBuilderList();

        String getMessage();

        ByteString getMessageBytes();
    }

    public static final class FileResult extends GeneratedMessageV3 implements FileResultOrBuilder {
        public static final int BIZ_INFO_FIELD_NUMBER = 4;
        private static final FileResult DEFAULT_INSTANCE = null;
        private static final Parser<FileResult> PARSER = null;
        public static final int UPLOAD_ID_FIELD_NUMBER = 1;
        public static final int URI_FIELD_NUMBER = 2;
        public static final int URL_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private FileResultBizInfo bizInfo_;
        private byte memoizedIsInitialized;
        private volatile Object uploadId_;
        private volatile Object uri_;
        private volatile Object url_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FileResultOrBuilder {
            private SingleFieldBuilderV3<FileResultBizInfo, FileResultBizInfo.Builder, FileResultBizInfoOrBuilder> bizInfoBuilder_;
            private FileResultBizInfo bizInfo_;
            private Object uploadId_;
            private Object uri_;
            private Object url_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private SingleFieldBuilderV3<FileResultBizInfo, FileResultBizInfo.Builder, FileResultBizInfoOrBuilder> getBizInfoFieldBuilder() {
                if (this.bizInfoBuilder_ != null) goto L6;
                this.bizInfoBuilder_ = new SingleFieldBuilderV3(getBizInfo(), getParentForChildren(), isClean());
                this.bizInfo_ = null;
            L6:
                return this.bizInfoBuilder_;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileResult buildPartial() {
                FileResult r100 = new FileResult(this, null);
                FileResult.access$6302(r100, this.uploadId_);
                FileResult.access$6402(r100, this.uri_);
                FileResult.access$6502(r100, this.url_);
                SingleFieldBuilderV3<FileResultBizInfo, FileResultBizInfo.Builder, FileResultBizInfoOrBuilder> r101 = this.bizInfoBuilder_;
                if (r101 != null) goto L5;
                FileResult.access$6602(r100, this.bizInfo_);
            L6:
                onBuilt();
                return r100;
            L5:
                FileResult.access$6602(r100, (FileResultBizInfo) r101.build());
                goto L6
            }

            public Builder clearBizInfo() {
                if (this.bizInfoBuilder_ != null) goto L5;
                this.bizInfo_ = null;
                onChanged();
            L6:
                return this;
            L5:
                this.bizInfo_ = null;
                this.bizInfoBuilder_ = null;
                goto L6
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
            public FileResultBizInfo getBizInfo() {
                SingleFieldBuilderV3<FileResultBizInfo, FileResultBizInfo.Builder, FileResultBizInfoOrBuilder> r100 = this.bizInfoBuilder_;
                if (r100 != null) goto L9;
                FileResultBizInfo r101 = this.bizInfo_;
                if (r101 == null) goto L7;
                return r101;
            L7:
                return FileResultBizInfo.getDefaultInstance();
            L9:
                return (FileResultBizInfo) r100.getMessage();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
            public FileResultBizInfoOrBuilder getBizInfoOrBuilder() {
                SingleFieldBuilderV3<FileResultBizInfo, FileResultBizInfo.Builder, FileResultBizInfoOrBuilder> r100 = this.bizInfoBuilder_;
                if (r100 != null) goto L5;
                FileResultBizInfo r101 = this.bizInfo_;
                if (r101 == null) goto L9;
                return r101;
            L9:
                return FileResultBizInfo.getDefaultInstance();
            L5:
                return (FileResultBizInfoOrBuilder) r100.getMessageOrBuilder();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
            public String getUploadId() {
                Object r100 = this.uploadId_;
                if ((r100 instanceof String) == true) goto L7;
                String r101 = ((ByteString) r100).toStringUtf8();
                this.uploadId_ = r101;
                return r101;
            L7:
                return (String) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
            public ByteString getUploadIdBytes() {
                Object r100 = this.uploadId_;
                if ((r100 instanceof String) == false) goto L7;
                ByteString r101 = ByteString.copyFromUtf8((String) r100);
                this.uploadId_ = r101;
                return r101;
            L7:
                return (ByteString) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
            public String getUri() {
                Object r100 = this.uri_;
                if ((r100 instanceof String) == true) goto L7;
                String r101 = ((ByteString) r100).toStringUtf8();
                this.uri_ = r101;
                return r101;
            L7:
                return (String) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
            public ByteString getUriBytes() {
                Object r100 = this.uri_;
                if ((r100 instanceof String) == false) goto L7;
                ByteString r101 = ByteString.copyFromUtf8((String) r100);
                this.uri_ = r101;
                return r101;
            L7:
                return (ByteString) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
            public String getUrl() {
                Object r100 = this.url_;
                if ((r100 instanceof String) == true) goto L7;
                String r101 = ((ByteString) r100).toStringUtf8();
                this.url_ = r101;
                return r101;
            L7:
                return (String) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
            public ByteString getUrlBytes() {
                Object r100 = this.url_;
                if ((r100 instanceof String) == false) goto L7;
                ByteString r101 = ByteString.copyFromUtf8((String) r100);
                this.url_ = r101;
                return r101;
            L7:
                return (ByteString) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
            public boolean hasBizInfo() {
                if (this.bizInfoBuilder_ == null) goto L5;
            L8:
                return true;
            L5:
                if (this.bizInfo_ != null) goto L8;
                return false;
            }

            private Builder() {
                this.uploadId_ = "";
                this.uri_ = "";
                this.url_ = "";
                this.bizInfo_ = null;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvFile.access$5700();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileResult build() {
                FileResult r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.uploadId_ = "";
                this.uri_ = "";
                this.url_ = "";
                if (this.bizInfoBuilder_ != null) goto L5;
                this.bizInfo_ = null;
            L6:
                return this;
            L5:
                this.bizInfo_ = null;
                this.bizInfoBuilder_ = null;
                goto L6
            }

            public Builder clearUploadId() {
                this.uploadId_ = FileResult.getDefaultInstance().getUploadId();
                onChanged();
                return this;
            }

            public Builder clearUri() {
                this.uri_ = FileResult.getDefaultInstance().getUri();
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = FileResult.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            public FileResultBizInfo.Builder getBizInfoBuilder() {
                onChanged();
                return (FileResultBizInfo.Builder) getBizInfoFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvFile.access$5700();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvFile.access$5800().ensureFieldAccessorsInitialized(FileResult.class, Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                FileResult.access$6100();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FileResult getDefaultInstanceForType() {
                return FileResult.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo8531clone() throws CloneNotSupportedException {
                return clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r100) {
                super(r100);
                this.uploadId_ = "";
                this.uri_ = "";
                this.url_ = "";
                this.bizInfo_ = null;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor r100) {
                return (Builder) super.clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return (Builder) super.clearOneof(r100);
            }

            public Builder mergeBizInfo(FileResultBizInfo r100) {
                SingleFieldBuilderV3<FileResultBizInfo, FileResultBizInfo.Builder, FileResultBizInfoOrBuilder> r101 = this.bizInfoBuilder_;
                if (r101 != null) goto L9;
                FileResultBizInfo r102 = this.bizInfo_;
                if (r102 == null) goto L7;
                this.bizInfo_ = FileResultBizInfo.newBuilder(r102).mergeFrom(r100).buildPartial();
            L8:
                onChanged();
            L10:
                return this;
            L7:
                this.bizInfo_ = r100;
                goto L8
            L9:
                r101.mergeFrom(r100);
                goto L10
            }

            public Builder mergeFrom(FileResult r100) {
                if (r100 != FileResult.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.getUploadId().isEmpty() == true) goto L9;
                this.uploadId_ = FileResult.access$6300(r100);
                onChanged();
            L9:
                if (r100.getUri().isEmpty() == true) goto L12;
                this.uri_ = FileResult.access$6400(r100);
                onChanged();
            L12:
                if (r100.getUrl().isEmpty() == true) goto L15;
                this.url_ = FileResult.access$6500(r100);
                onChanged();
            L15:
                if (r100.hasBizInfo() == false) goto L17;
                mergeBizInfo(r100.getBizInfo());
            L17:
                mergeUnknownFields(FileResult.access$6700(r100));
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.mergeUnknownFields(r100);
            }

            public Builder setBizInfo(FileResultBizInfo.Builder r100) {
                SingleFieldBuilderV3<FileResultBizInfo, FileResultBizInfo.Builder, FileResultBizInfoOrBuilder> r101 = this.bizInfoBuilder_;
                if (r101 != null) goto L5;
                this.bizInfo_ = r100.build();
                onChanged();
            L6:
                return this;
            L5:
                r101.setMessage(r100.build());
                goto L6
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.setUnknownFieldsProto3(r100);
            }

            public Builder setUploadId(String r100) {
                if (r100 == null) goto L6;
                this.uploadId_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setUploadIdBytes(ByteString r100) {
                if (r100 == null) goto L6;
                FileResult.access$6900(r100);
                this.uploadId_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setUri(String r100) {
                if (r100 == null) goto L6;
                this.uri_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setUriBytes(ByteString r100) {
                if (r100 == null) goto L6;
                FileResult.access$7000(r100);
                this.uri_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setUrl(String r100) {
                if (r100 == null) goto L6;
                this.url_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setUrlBytes(ByteString r100) {
                if (r100 == null) goto L6;
                FileResult.access$7100(r100);
                this.url_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public /* synthetic */ Builder(AnonymousClass1 r100) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r100) {
                if ((r100 instanceof FileResult) == true) goto L5;
                super.mergeFrom(r100);
                return this;
            L5:
                return mergeFrom((FileResult) r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            public Builder setBizInfo(FileResultBizInfo r100) {
                SingleFieldBuilderV3<FileResultBizInfo, FileResultBizInfo.Builder, FileResultBizInfoOrBuilder> r101 = this.bizInfoBuilder_;
                if (r101 != null) goto L8;
                if (r100 == null) goto L7;
                this.bizInfo_ = r100;
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r101.setMessage(r100);
                goto L9
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r100, AnonymousClass1 r101) {
                this(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                FileResult r102 = null;
                FileResult r103 = (FileResult) FileResult.access$6800().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L7:
                th = th;
            L15:
                if (r102 == null) goto L17;
                mergeFrom(r102);
            L17:
                throw th;
            L9:
                e = move-exception;
                FileResult r104 = (FileResult) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r102 = r104;
                goto L15
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.setField(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return (Builder) super.setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }
        }

        static {
            DEFAULT_INSTANCE = new FileResult();
            PARSER = new AnonymousClass1();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
        public FileResultBizInfo getBizInfo() {
            FileResultBizInfo r100 = this.bizInfo_;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return FileResultBizInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if (getUploadIdBytes().isEmpty() == true) goto L9;
            r101 = 0 + GeneratedMessageV3.computeStringSize(1, this.uploadId_);
        L9:
            if (getUriBytes().isEmpty() == true) goto L12;
            r101 = r101 + GeneratedMessageV3.computeStringSize(2, this.uri_);
        L12:
            if (getUrlBytes().isEmpty() == true) goto L15;
            r101 = r101 + GeneratedMessageV3.computeStringSize(3, this.url_);
        L15:
            if (this.bizInfo_ == null) goto L17;
            r101 = r101 + CodedOutputStream.computeMessageSize(4, getBizInfo());
        L17:
            int r102 = r101 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r102;
            return r102;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
        public String getUploadId() {
            Object r100 = this.uploadId_;
            if ((r100 instanceof String) == true) goto L5;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.uploadId_ = r101;
            return r101;
        L5:
            return (String) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
        public ByteString getUploadIdBytes() {
            Object r100 = this.uploadId_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.uploadId_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
        public String getUri() {
            Object r100 = this.uri_;
            if ((r100 instanceof String) == true) goto L5;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.uri_ = r101;
            return r101;
        L5:
            return (String) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
        public ByteString getUriBytes() {
            Object r100 = this.uri_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.uri_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
        public String getUrl() {
            Object r100 = this.url_;
            if ((r100 instanceof String) == true) goto L5;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.url_ = r101;
            return r101;
        L5:
            return (String) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
        public ByteString getUrlBytes() {
            Object r100 = this.url_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.url_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
        public boolean hasBizInfo() {
            if (this.bizInfo_ == null) goto L5;
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
            int r101 = ((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUploadId().hashCode()) * 37) + 2) * 53) + getUri().hashCode()) * 37) + 3) * 53) + getUrl().hashCode();
            if (hasBizInfo() == false) goto L8;
            r101 = (((r101 * 37) + 4) * 53) + getBizInfo().hashCode();
        L8:
            int r102 = (r101 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = r102;
            return r102;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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
        public Builder toBuilder() {
            AnonymousClass1 r100 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r100);
        L6:
            return new Builder(r100).mergeFrom(this);
        }

        private FileResult() {
            this.memoizedIsInitialized = -1;
            this.uploadId_ = "";
            this.uri_ = "";
            this.url_ = "";
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvFile.access$5700();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileResultOrBuilder
        public FileResultBizInfoOrBuilder getBizInfoOrBuilder() {
            return getBizInfo();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvFile.access$5800().ensureFieldAccessorsInitialized(FileResult.class, Builder.class);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static /* synthetic */ boolean access$6100() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ Parser access$6800() {
            return PARSER;
        }

        public static FileResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FileResult> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FileResult> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FileResult getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private FileResult(GeneratedMessageV3.Builder<?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ Object access$6300(FileResult r100) {
            return r100.uploadId_;
        }

        public static /* synthetic */ Object access$6400(FileResult r100) {
            return r100.uri_;
        }

        public static /* synthetic */ Object access$6500(FileResult r100) {
            return r100.url_;
        }

        public static /* synthetic */ UnknownFieldSet access$6700(FileResult r100) {
            return r100.unknownFields;
        }

        public static /* synthetic */ void access$6900(ByteString r100) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(r100);
        }

        public static /* synthetic */ void access$7000(ByteString r100) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(r100);
        }

        public static /* synthetic */ void access$7100(ByteString r100) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(r100);
        }

        public static Builder newBuilder(FileResult r100) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
        }

        public static FileResult parseDelimitedFrom(InputStream r100) throws IOException {
            return (FileResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
        }

        public static FileResult parseFrom(ByteString r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof FileResult) == false) goto L8;
            FileResult r101 = (FileResult) r100;
            if (getUploadId().equals(r101.getUploadId()) == false) goto L12;
            boolean r102 = true;
        L13:
            if (r102 == true) goto L15;
        L17:
            boolean r103 = false;
        L18:
            if (r103 == true) goto L20;
        L22:
            boolean r104 = false;
        L23:
            if (r104 == true) goto L25;
        L27:
            boolean r105 = false;
        L29:
            if (hasBizInfo() == false) goto L35;
            if (r105 == true) goto L32;
        L34:
            r105 = false;
            goto L35
        L32:
            if (getBizInfo().equals(r101.getBizInfo()) == false) goto L34;
            r105 = true;
        L35:
            if (r105 == true) goto L37;
        L39:
            return false;
        L37:
            if (this.unknownFields.equals(r101.unknownFields) == false) goto L39;
            return true;
        L25:
            if (hasBizInfo() != r101.hasBizInfo()) goto L27;
            r105 = true;
            goto L29
        L20:
            if (getUrl().equals(r101.getUrl()) == false) goto L22;
            r104 = true;
            goto L23
        L15:
            if (getUri().equals(r101.getUri()) == false) goto L17;
            r103 = true;
            goto L18
        L12:
            r102 = false;
            goto L13
        L8:
            return super.equals(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return new Builder(r100, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            if (getUploadIdBytes().isEmpty() == true) goto L6;
            GeneratedMessageV3.writeString(r100, 1, this.uploadId_);
        L6:
            if (getUriBytes().isEmpty() == true) goto L9;
            GeneratedMessageV3.writeString(r100, 2, this.uri_);
        L9:
            if (getUrlBytes().isEmpty() == true) goto L12;
            GeneratedMessageV3.writeString(r100, 3, this.url_);
        L12:
            if (this.bizInfo_ == null) goto L14;
            r100.writeMessage(4, getBizInfo());
        L14:
            this.unknownFields.writeTo(r100);
        }

        public static FileResult parseFrom(CodedInputStream r100) throws IOException {
            return (FileResult) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return newBuilderForType(r100);
        }

        public static FileResult parseFrom(InputStream r100) throws IOException {
            return (FileResult) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        public static FileResult parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        public static FileResult parseFrom(byte[] r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        private FileResult(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this();
            if (r101 == null) goto L43;
            UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
            boolean r103 = false;
        L5:
            if (r103 == true) goto L41;
            int r104 = r100.readTag();     // Catch: Throwable -> L31 IOException -> L33 InvalidProtocolBufferException -> L36
            if (r104 == 0) goto L30;
            if (r104 != 10) goto L11;
            this.uploadId_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L31 IOException -> L33 InvalidProtocolBufferException -> L36
            goto L5
        L11:
            if (r104 != 18) goto L13;
            this.uri_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L31 IOException -> L33 InvalidProtocolBufferException -> L36
            goto L5
        L13:
            if (r104 != 26) goto L15;
            this.url_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L31 IOException -> L33 InvalidProtocolBufferException -> L36
            goto L5
        L15:
            if (r104 != 34) goto L17;
            FileResultBizInfo r105 = this.bizInfo_;     // Catch: Throwable -> L31 IOException -> L33 InvalidProtocolBufferException -> L36
            if (r105 == null) goto L22;
            FileResultBizInfo.Builder r106 = r105.toBuilder();     // Catch: Throwable -> L31 IOException -> L33 InvalidProtocolBufferException -> L36
        L23:
            FileResultBizInfo r107 = (FileResultBizInfo) r100.readMessage(FileResultBizInfo.parser(), r101);     // Catch: Throwable -> L31 IOException -> L33 InvalidProtocolBufferException -> L36
            this.bizInfo_ = r107;     // Catch: Throwable -> L31 IOException -> L33 InvalidProtocolBufferException -> L36
            if (r106 == null) goto L5;
            r106.mergeFrom(r107);     // Catch: Throwable -> L31 IOException -> L33 InvalidProtocolBufferException -> L36
            this.bizInfo_ = r106.buildPartial();     // Catch: Throwable -> L31 IOException -> L33 InvalidProtocolBufferException -> L36
            goto L5
        L22:
            r106 = null;
            goto L23
        L17:
            if (parseUnknownFieldProto3(r100, r102, r101, r104) == true) goto L5;
        L30:
            r103 = true;
            goto L5
        L31:
            th = move-exception;
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            throw th;
        L36:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L31
        L33:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L31
        L41:
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            return;
        L43:
            throw null;
        }

        public static /* synthetic */ Object access$6302(FileResult r100, Object r101) {
            r100.uploadId_ = r101;
            return r101;
        }

        public static /* synthetic */ Object access$6402(FileResult r100, Object r101) {
            r100.uri_ = r101;
            return r101;
        }

        public static /* synthetic */ Object access$6502(FileResult r100, Object r101) {
            r100.url_ = r101;
            return r101;
        }

        public static /* synthetic */ FileResultBizInfo access$6602(FileResult r100, FileResultBizInfo r101) {
            r100.bizInfo_ = r101;
            return r101;
        }

        public static FileResult parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
        }

        public static FileResult parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ FileResult(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static FileResult parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileResult) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static FileResult parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileResult) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static FileResult parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public static FileResult parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ FileResult(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public static final class FileResultBizInfo extends GeneratedMessageV3 implements FileResultBizInfoOrBuilder {
        public static final int BIZ_INFO_FIELD_NUMBER = 2;
        public static final int BIZ_TYPE_FIELD_NUMBER = 1;
        private static final FileResultBizInfo DEFAULT_INSTANCE = null;
        private static final Parser<FileResultBizInfo> PARSER = null;
        private static final long serialVersionUID = 0;
        private volatile Object bizInfo_;
        private int bizType_;
        private byte memoizedIsInitialized;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FileResultBizInfoOrBuilder {
            private Object bizInfo_;
            private int bizType_;

            public Builder clearBizType() {
                this.bizType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileResultBizInfo buildPartial() {
                FileResultBizInfo r100 = new FileResultBizInfo(this, null);
                FileResultBizInfo.access$7902(r100, this.bizType_);
                FileResultBizInfo.access$8002(r100, this.bizInfo_);
                onBuilt();
                return r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileResultBizInfoOrBuilder
            public String getBizInfo() {
                Object r100 = this.bizInfo_;
                if ((r100 instanceof String) == true) goto L7;
                String r101 = ((ByteString) r100).toStringUtf8();
                this.bizInfo_ = r101;
                return r101;
            L7:
                return (String) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileResultBizInfoOrBuilder
            public ByteString getBizInfoBytes() {
                Object r100 = this.bizInfo_;
                if ((r100 instanceof String) == false) goto L7;
                ByteString r101 = ByteString.copyFromUtf8((String) r100);
                this.bizInfo_ = r101;
                return r101;
            L7:
                return (ByteString) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileResultBizInfoOrBuilder
            public FileBizType getBizType() {
                FileBizType r100 = FileBizType.valueOf(this.bizType_);
                if (r100 == null) goto L5;
                return r100;
            L5:
                return FileBizType.UNRECOGNIZED;
            }

            private Builder() {
                this.bizType_ = 0;
                this.bizInfo_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvFile.access$7300();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileResultBizInfo build() {
                FileResultBizInfo r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bizType_ = 0;
                this.bizInfo_ = "";
                return this;
            }

            public Builder clearBizInfo() {
                this.bizInfo_ = FileResultBizInfo.getDefaultInstance().getBizInfo();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvFile.access$7300();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvFile.access$7400().ensureFieldAccessorsInitialized(FileResultBizInfo.class, Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                FileResultBizInfo.access$7700();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileResultBizInfoOrBuilder
            public int getBizTypeValue() {
                return this.bizType_;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FileResultBizInfo getDefaultInstanceForType() {
                return FileResultBizInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo8531clone() throws CloneNotSupportedException {
                return clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r100) {
                super(r100);
                this.bizType_ = 0;
                this.bizInfo_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor r100) {
                return (Builder) super.clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return (Builder) super.clearOneof(r100);
            }

            public Builder mergeFrom(FileResultBizInfo r100) {
                if (r100 != FileResultBizInfo.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (FileResultBizInfo.access$7900(r100) == 0) goto L9;
                setBizTypeValue(r100.getBizTypeValue());
            L9:
                if (r100.getBizInfo().isEmpty() == true) goto L11;
                this.bizInfo_ = FileResultBizInfo.access$8000(r100);
                onChanged();
            L11:
                mergeUnknownFields(FileResultBizInfo.access$8100(r100));
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.mergeUnknownFields(r100);
            }

            public Builder setBizInfo(String r100) {
                if (r100 == null) goto L6;
                this.bizInfo_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setBizInfoBytes(ByteString r100) {
                if (r100 == null) goto L6;
                FileResultBizInfo.access$8300(r100);
                this.bizInfo_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setBizType(FileBizType r100) {
                if (r100 == null) goto L6;
                this.bizType_ = r100.getNumber();
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setBizTypeValue(int r100) {
                this.bizType_ = r100;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.setUnknownFieldsProto3(r100);
            }

            public /* synthetic */ Builder(AnonymousClass1 r100) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r100) {
                if ((r100 instanceof FileResultBizInfo) == true) goto L5;
                super.mergeFrom(r100);
                return this;
            L5:
                return mergeFrom((FileResultBizInfo) r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r100, AnonymousClass1 r101) {
                this(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                FileResultBizInfo r102 = null;
                FileResultBizInfo r103 = (FileResultBizInfo) FileResultBizInfo.access$8200().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L7:
                th = th;
            L15:
                if (r102 == null) goto L17;
                mergeFrom(r102);
            L17:
                throw th;
            L9:
                e = move-exception;
                FileResultBizInfo r104 = (FileResultBizInfo) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r102 = r104;
                goto L15
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.setField(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return (Builder) super.setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }
        }

        static {
            DEFAULT_INSTANCE = new FileResultBizInfo();
            PARSER = new AnonymousClass1();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileResultBizInfoOrBuilder
        public String getBizInfo() {
            Object r100 = this.bizInfo_;
            if ((r100 instanceof String) == true) goto L5;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.bizInfo_ = r101;
            return r101;
        L5:
            return (String) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileResultBizInfoOrBuilder
        public ByteString getBizInfoBytes() {
            Object r100 = this.bizInfo_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.bizInfo_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileResultBizInfoOrBuilder
        public FileBizType getBizType() {
            FileBizType r100 = FileBizType.valueOf(this.bizType_);
            if (r100 == null) goto L5;
            return r100;
        L5:
            return FileBizType.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if (this.bizType_ == FileBizType.ImageBizType_UNSPECIFIED.getNumber()) goto L9;
            r101 = 0 + CodedOutputStream.computeEnumSize(1, this.bizType_);
        L9:
            if (getBizInfoBytes().isEmpty() == true) goto L11;
            r101 = r101 + GeneratedMessageV3.computeStringSize(2, this.bizInfo_);
        L11:
            int r102 = r101 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r102;
            return r102;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int r100 = this.memoizedHashCode;
            if (r100 == 0) goto L5;
            return r100;
        L5:
            int r101 = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.bizType_) * 37) + 2) * 53) + getBizInfo().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = r101;
            return r101;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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
        public Builder toBuilder() {
            AnonymousClass1 r100 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r100);
        L6:
            return new Builder(r100).mergeFrom(this);
        }

        private FileResultBizInfo() {
            this.memoizedIsInitialized = -1;
            this.bizType_ = 0;
            this.bizInfo_ = "";
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvFile.access$7300();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvFile.access$7400().ensureFieldAccessorsInitialized(FileResultBizInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static /* synthetic */ boolean access$7700() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ Parser access$8200() {
            return PARSER;
        }

        public static FileResultBizInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FileResultBizInfo> parser() {
            return PARSER;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileResultBizInfoOrBuilder
        public int getBizTypeValue() {
            return this.bizType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FileResultBizInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FileResultBizInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private FileResultBizInfo(GeneratedMessageV3.Builder<?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ int access$7900(FileResultBizInfo r100) {
            return r100.bizType_;
        }

        public static /* synthetic */ Object access$8000(FileResultBizInfo r100) {
            return r100.bizInfo_;
        }

        public static /* synthetic */ UnknownFieldSet access$8100(FileResultBizInfo r100) {
            return r100.unknownFields;
        }

        public static /* synthetic */ void access$8300(ByteString r100) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(r100);
        }

        public static Builder newBuilder(FileResultBizInfo r100) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
        }

        public static FileResultBizInfo parseDelimitedFrom(InputStream r100) throws IOException {
            return (FileResultBizInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
        }

        public static FileResultBizInfo parseFrom(ByteString r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof FileResultBizInfo) == false) goto L8;
            FileResultBizInfo r101 = (FileResultBizInfo) r100;
            if (this.bizType_ != r101.bizType_) goto L12;
            boolean r102 = true;
        L13:
            if (r102 == true) goto L15;
        L17:
            boolean r103 = false;
        L18:
            if (r103 == true) goto L20;
        L22:
            return false;
        L20:
            if (this.unknownFields.equals(r101.unknownFields) == false) goto L22;
            return true;
        L15:
            if (getBizInfo().equals(r101.getBizInfo()) == false) goto L17;
            r103 = true;
            goto L18
        L12:
            r102 = false;
            goto L13
        L8:
            return super.equals(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return new Builder(r100, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            if (this.bizType_ == FileBizType.ImageBizType_UNSPECIFIED.getNumber()) goto L6;
            r100.writeEnum(1, this.bizType_);
        L6:
            if (getBizInfoBytes().isEmpty() == true) goto L8;
            GeneratedMessageV3.writeString(r100, 2, this.bizInfo_);
        L8:
            this.unknownFields.writeTo(r100);
        }

        public static FileResultBizInfo parseFrom(CodedInputStream r100) throws IOException {
            return (FileResultBizInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return newBuilderForType(r100);
        }

        public static FileResultBizInfo parseFrom(InputStream r100) throws IOException {
            return (FileResultBizInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        public static FileResultBizInfo parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        public static FileResultBizInfo parseFrom(byte[] r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        private FileResultBizInfo(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this();
            if (r101 == null) goto L32;
            UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
            boolean r103 = false;
        L5:
            if (r103 == true) goto L29;
            int r104 = r100.readTag();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L24
            if (r104 == 0) goto L18;
            if (r104 != 8) goto L11;
            this.bizType_ = r100.readEnum();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L24
            goto L5
        L11:
            if (r104 != 18) goto L13;
            this.bizInfo_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L24
            goto L5
        L13:
            if (parseUnknownFieldProto3(r100, r102, r101, r104) == true) goto L5;
        L18:
            r103 = true;
            goto L5
        L19:
            th = move-exception;
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            throw th;
        L21:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L19
        L24:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L19
        L29:
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            return;
        L32:
            throw null;
        }

        public static /* synthetic */ int access$7902(FileResultBizInfo r100, int r101) {
            r100.bizType_ = r101;
            return r101;
        }

        public static /* synthetic */ Object access$8002(FileResultBizInfo r100, Object r101) {
            r100.bizInfo_ = r101;
            return r101;
        }

        public static FileResultBizInfo parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileResultBizInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
        }

        public static FileResultBizInfo parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ FileResultBizInfo(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static FileResultBizInfo parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileResultBizInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static FileResultBizInfo parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileResultBizInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static FileResultBizInfo parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public static FileResultBizInfo parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ FileResultBizInfo(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface FileResultBizInfoOrBuilder extends MessageOrBuilder {
        String getBizInfo();

        ByteString getBizInfoBytes();

        FileBizType getBizType();

        int getBizTypeValue();
    }

    public interface FileResultOrBuilder extends MessageOrBuilder {
        FileResultBizInfo getBizInfo();

        FileResultBizInfoOrBuilder getBizInfoOrBuilder();

        String getUploadId();

        ByteString getUploadIdBytes();

        String getUri();

        ByteString getUriBytes();

        String getUrl();

        ByteString getUrlBytes();

        boolean hasBizInfo();
    }

    public static final enum FileType extends Enum<FileType> implements ProtocolMessageEnum {
        private static final /* synthetic */ FileType[] $VALUES = null;
        public static final FileType CONTENT_TYPE_UNSPECIFIED = null;
        public static final int CONTENT_TYPE_UNSPECIFIED_VALUE = 0;
        public static final FileType IMAGE = null;
        public static final int IMAGE_VALUE = 1;
        public static final FileType OCR_META = null;
        public static final int OCR_META_VALUE = 2;
        public static final FileType UNRECOGNIZED = null;
        private static final FileType[] VALUES = null;
        private static final Internal.EnumLiteMap<FileType> internalValueMap = null;
        private final int value;

        static {
            FileType r100 = new FileType("CONTENT_TYPE_UNSPECIFIED", 0, 0);
            CONTENT_TYPE_UNSPECIFIED = r100;
            FileType r101 = new FileType("IMAGE", 1, 1);
            IMAGE = r101;
            FileType r102 = new FileType("OCR_META", 2, 2);
            OCR_META = r102;
            FileType r103 = new FileType("UNRECOGNIZED", 3, -1);
            UNRECOGNIZED = r103;
            $VALUES = new FileType[]{r100, r101, r102, r103};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        public static FileType[] values() {
            return (FileType[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ListProtector.get(AvFile.getDescriptor().getEnumTypes(), 0);
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
        }

        public static Internal.EnumLiteMap<FileType> internalGetValueMap() {
            return internalValueMap;
        }

        public static FileType forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return OCR_META;
        L12:
            return IMAGE;
        L14:
            return CONTENT_TYPE_UNSPECIFIED;
        }

        public static FileType valueOf(Descriptors.EnumValueDescriptor r100) {
            if (r100.getType() != getDescriptor()) goto L11;
            if (r100.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r100.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static FileType valueOf(String r100) {
            return (FileType) a.a(FileType.class, r100);
        }

        public static FileType valueOf(int r100) {
            return forNumber(r100);
        }

        private FileType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class FileUplinkBody extends GeneratedMessageV3 implements FileUplinkBodyOrBuilder {
        private static final FileUplinkBody DEFAULT_INSTANCE = null;
        private static final Parser<FileUplinkBody> PARSER = null;
        public static final int UPLOAD_FILES_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private List<FileData> uploadFiles_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FileUplinkBodyOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> uploadFilesBuilder_;
            private List<FileData> uploadFiles_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private void ensureUploadFilesIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.uploadFiles_ = new ArrayList(this.uploadFiles_);
                this.bitField0_ |= 1;
                return;
            }

            private RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> getUploadFilesFieldBuilder() {
                if (this.uploadFilesBuilder_ != null) goto L10;
                List<FileData> r100 = this.uploadFiles_;
                boolean r101 = true;
                if ((this.bitField0_ & 1) == 1) goto L8;
                r101 = false;
            L8:
                this.uploadFilesBuilder_ = new RepeatedFieldBuilderV3(r100, r101, getParentForChildren(), isClean());
                this.uploadFiles_ = null;
            L10:
                return this.uploadFilesBuilder_;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileUplinkBody buildPartial() {
                FileUplinkBody r100 = new FileUplinkBody(this, null);
                int r101 = this.bitField0_;
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r102 = this.uploadFilesBuilder_;
                if (r102 == null) goto L5;
                FileUplinkBody.access$9102(r100, r102.build());
            L9:
                onBuilt();
                return r100;
            L5:
                if ((r101 & 1) != 1) goto L7;
                this.uploadFiles_ = Collections.unmodifiableList(this.uploadFiles_);
                this.bitField0_ &= -2;
            L7:
                FileUplinkBody.access$9102(r100, this.uploadFiles_);
                goto L9
            }

            public Builder clearUploadFiles() {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r100 = this.uploadFilesBuilder_;
                if (r100 != null) goto L5;
                this.uploadFiles_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            L6:
                return this;
            L5:
                r100.clear();
                goto L6
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileUplinkBodyOrBuilder
            public int getUploadFilesCount() {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r100 = this.uploadFilesBuilder_;
                if (r100 != null) goto L7;
                return this.uploadFiles_.size();
            L7:
                return r100.getCount();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileUplinkBodyOrBuilder
            public List<FileData> getUploadFilesList() {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r100 = this.uploadFilesBuilder_;
                if (r100 != null) goto L7;
                return Collections.unmodifiableList(this.uploadFiles_);
            L7:
                return r100.getMessageList();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileUplinkBodyOrBuilder
            public List<? extends FileDataOrBuilder> getUploadFilesOrBuilderList() {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r100 = this.uploadFilesBuilder_;
                if (r100 == null) goto L7;
                return r100.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.uploadFiles_);
            }

            private Builder() {
                this.uploadFiles_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvFile.access$8500();
            }

            private void maybeForceBuilderInitialization() {
                if (FileUplinkBody.access$8900() == false) goto L6;
                getUploadFilesFieldBuilder();
                return;
            }

            public FileData.Builder addUploadFilesBuilder() {
                return (FileData.Builder) getUploadFilesFieldBuilder().addBuilder(FileData.getDefaultInstance());
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileUplinkBody build() {
                FileUplinkBody r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r100 = this.uploadFilesBuilder_;
                if (r100 != null) goto L5;
                this.uploadFiles_ = Collections.emptyList();
                this.bitField0_ &= -2;
            L6:
                return this;
            L5:
                r100.clear();
                goto L6
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvFile.access$8500();
            }

            public List<FileData.Builder> getUploadFilesBuilderList() {
                return getUploadFilesFieldBuilder().getBuilderList();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvFile.access$8600().ensureFieldAccessorsInitialized(FileUplinkBody.class, Builder.class);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FileUplinkBody getDefaultInstanceForType() {
                return FileUplinkBody.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo8531clone() throws CloneNotSupportedException {
                return clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r100) {
                super(r100);
                this.uploadFiles_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addAllUploadFiles(Iterable<? extends FileData> r100) {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r101 = this.uploadFilesBuilder_;
                if (r101 != null) goto L5;
                ensureUploadFilesIsMutable();
                AbstractMessageLite.Builder.addAll(r100, this.uploadFiles_);
                onChanged();
            L6:
                return this;
            L5:
                r101.addAllMessages(r100);
                goto L6
            }

            public Builder addUploadFiles(FileData.Builder r100) {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r101 = this.uploadFilesBuilder_;
                if (r101 != null) goto L5;
                ensureUploadFilesIsMutable();
                this.uploadFiles_.add(r100.build());
                onChanged();
            L6:
                return this;
            L5:
                r101.addMessage(r100.build());
                goto L6
            }

            public FileData.Builder addUploadFilesBuilder(int r100) {
                return (FileData.Builder) getUploadFilesFieldBuilder().addBuilder(r100, FileData.getDefaultInstance());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor r100) {
                return (Builder) super.clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return (Builder) super.clearOneof(r100);
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileUplinkBodyOrBuilder
            public FileData getUploadFiles(int r100) {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r101 = this.uploadFilesBuilder_;
                if (r101 != null) goto L7;
                return (FileData) ListProtector.get(this.uploadFiles_, r100);
            L7:
                return (FileData) r101.getMessage(r100);
            }

            public FileData.Builder getUploadFilesBuilder(int r100) {
                return (FileData.Builder) getUploadFilesFieldBuilder().getBuilder(r100);
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.FileUplinkBodyOrBuilder
            public FileDataOrBuilder getUploadFilesOrBuilder(int r100) {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r101 = this.uploadFilesBuilder_;
                if (r101 != null) goto L7;
                return (FileDataOrBuilder) ListProtector.get(this.uploadFiles_, r100);
            L7:
                return (FileDataOrBuilder) r101.getMessageOrBuilder(r100);
            }

            public Builder mergeFrom(FileUplinkBody r100) {
                if (r100 != FileUplinkBody.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (this.uploadFilesBuilder_ != null) goto L15;
                if (FileUplinkBody.access$9100(r100).isEmpty() == false) goto L10;
            L23:
                mergeUnknownFields(FileUplinkBody.access$9300(r100));
                onChanged();
                return this;
            L10:
                if (this.uploadFiles_.isEmpty() == false) goto L12;
                this.uploadFiles_ = FileUplinkBody.access$9100(r100);
                this.bitField0_ &= -2;
            L13:
                onChanged();
                goto L23
            L12:
                ensureUploadFilesIsMutable();
                this.uploadFiles_.addAll(FileUplinkBody.access$9100(r100));
                goto L13
            L15:
                if (FileUplinkBody.access$9100(r100).isEmpty() == true) goto L23;
                if (this.uploadFilesBuilder_.isEmpty() == false) goto L22;
                this.uploadFilesBuilder_.dispose();
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r101 = null;
                this.uploadFilesBuilder_ = null;
                this.uploadFiles_ = FileUplinkBody.access$9100(r100);
                this.bitField0_ &= -2;
                if (FileUplinkBody.access$9200() == false) goto L21;
                r101 = getUploadFilesFieldBuilder();
            L21:
                this.uploadFilesBuilder_ = r101;
                goto L23
            L22:
                this.uploadFilesBuilder_.addAllMessages(FileUplinkBody.access$9100(r100));
                goto L23
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.mergeUnknownFields(r100);
            }

            public Builder removeUploadFiles(int r100) {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r101 = this.uploadFilesBuilder_;
                if (r101 != null) goto L5;
                ensureUploadFilesIsMutable();
                ListProtector.remove(this.uploadFiles_, r100);
                onChanged();
            L6:
                return this;
            L5:
                r101.remove(r100);
                goto L6
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.setUnknownFieldsProto3(r100);
            }

            public /* synthetic */ Builder(AnonymousClass1 r100) {
                this();
            }

            public Builder addUploadFiles(FileData r100) {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r101 = this.uploadFilesBuilder_;
                if (r101 != null) goto L8;
                if (r100 == null) goto L7;
                ensureUploadFilesIsMutable();
                this.uploadFiles_.add(r100);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r101.addMessage(r100);
                goto L9
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r100) {
                if ((r100 instanceof FileUplinkBody) == true) goto L5;
                super.mergeFrom(r100);
                return this;
            L5:
                return mergeFrom((FileUplinkBody) r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r100, AnonymousClass1 r101) {
                this(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.addRepeatedField(r100, r101);
            }

            public Builder addUploadFiles(int r100, FileData.Builder r101) {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r102 = this.uploadFilesBuilder_;
                if (r102 != null) goto L5;
                ensureUploadFilesIsMutable();
                ListProtector.add(this.uploadFiles_, r100, r101.build());
                onChanged();
            L6:
                return this;
            L5:
                r102.addMessage(r100, r101.build());
                goto L6
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                FileUplinkBody r102 = null;
                FileUplinkBody r103 = (FileUplinkBody) FileUplinkBody.access$9400().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L7:
                th = th;
            L15:
                if (r102 == null) goto L17;
                mergeFrom(r102);
            L17:
                throw th;
            L9:
                e = move-exception;
                FileUplinkBody r104 = (FileUplinkBody) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r102 = r104;
                goto L15
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.setField(r100, r101);
            }

            public Builder setUploadFiles(int r100, FileData.Builder r101) {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r102 = this.uploadFilesBuilder_;
                if (r102 != null) goto L5;
                ensureUploadFilesIsMutable();
                ListProtector.set(this.uploadFiles_, r100, r101.build());
                onChanged();
            L6:
                return this;
            L5:
                r102.setMessage(r100, r101.build());
                goto L6
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            public Builder addUploadFiles(int r100, FileData r101) {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r102 = this.uploadFilesBuilder_;
                if (r102 != null) goto L8;
                if (r101 == null) goto L7;
                ensureUploadFilesIsMutable();
                ListProtector.add(this.uploadFiles_, r100, r101);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r102.addMessage(r100, r101);
                goto L9
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            public Builder setUploadFiles(int r100, FileData r101) {
                RepeatedFieldBuilderV3<FileData, FileData.Builder, FileDataOrBuilder> r102 = this.uploadFilesBuilder_;
                if (r102 != null) goto L8;
                if (r101 == null) goto L7;
                ensureUploadFilesIsMutable();
                ListProtector.set(this.uploadFiles_, r100, r101);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r102.setMessage(r100, r101);
                goto L9
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return (Builder) super.setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }
        }

        static {
            DEFAULT_INSTANCE = new FileUplinkBody();
            PARSER = new AnonymousClass1();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            int r102 = 0;
        L7:
            if (r101 >= this.uploadFiles_.size()) goto L9;
            r102 = r102 + CodedOutputStream.computeMessageSize(1, (MessageLite) ListProtector.get(this.uploadFiles_, r101));
            r101 = r101 + 1;
            goto L7
        L9:
            int r103 = r102 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r103;
            return r103;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileUplinkBodyOrBuilder
        public int getUploadFilesCount() {
            return this.uploadFiles_.size();
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int r100 = this.memoizedHashCode;
            if (r100 == 0) goto L5;
            return r100;
        L5:
            int r101 = 779 + getDescriptor().hashCode();
            if (getUploadFilesCount() <= 0) goto L8;
            r101 = (((r101 * 37) + 1) * 53) + getUploadFilesList().hashCode();
        L8:
            int r102 = (r101 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = r102;
            return r102;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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
        public Builder toBuilder() {
            AnonymousClass1 r100 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r100);
        L6:
            return new Builder(r100).mergeFrom(this);
        }

        private FileUplinkBody() {
            this.memoizedIsInitialized = -1;
            this.uploadFiles_ = Collections.emptyList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvFile.access$8500();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvFile.access$8600().ensureFieldAccessorsInitialized(FileUplinkBody.class, Builder.class);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static /* synthetic */ boolean access$8900() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$9200() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ Parser access$9400() {
            return PARSER;
        }

        public static FileUplinkBody getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FileUplinkBody> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FileUplinkBody> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileUplinkBodyOrBuilder
        public List<FileData> getUploadFilesList() {
            return this.uploadFiles_;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileUplinkBodyOrBuilder
        public List<? extends FileDataOrBuilder> getUploadFilesOrBuilderList() {
            return this.uploadFiles_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FileUplinkBody getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private FileUplinkBody(GeneratedMessageV3.Builder<?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ List access$9100(FileUplinkBody r100) {
            return r100.uploadFiles_;
        }

        public static /* synthetic */ UnknownFieldSet access$9300(FileUplinkBody r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(FileUplinkBody r100) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
        }

        public static FileUplinkBody parseDelimitedFrom(InputStream r100) throws IOException {
            return (FileUplinkBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
        }

        public static FileUplinkBody parseFrom(ByteString r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof FileUplinkBody) == false) goto L8;
            FileUplinkBody r101 = (FileUplinkBody) r100;
            if (getUploadFilesList().equals(r101.getUploadFilesList()) == false) goto L12;
            boolean r102 = true;
        L13:
            if (r102 == true) goto L15;
        L17:
            return false;
        L15:
            if (this.unknownFields.equals(r101.unknownFields) == false) goto L17;
            return true;
        L12:
            r102 = false;
            goto L13
        L8:
            return super.equals(r100);
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileUplinkBodyOrBuilder
        public FileData getUploadFiles(int r100) {
            return (FileData) ListProtector.get(this.uploadFiles_, r100);
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.FileUplinkBodyOrBuilder
        public FileDataOrBuilder getUploadFilesOrBuilder(int r100) {
            return (FileDataOrBuilder) ListProtector.get(this.uploadFiles_, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return new Builder(r100, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            int r101 = 0;
        L4:
            if (r101 >= this.uploadFiles_.size()) goto L6;
            r100.writeMessage(1, (MessageLite) ListProtector.get(this.uploadFiles_, r101));
            r101 = r101 + 1;
            goto L4
        L6:
            this.unknownFields.writeTo(r100);
        }

        public static FileUplinkBody parseFrom(CodedInputStream r100) throws IOException {
            return (FileUplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return newBuilderForType(r100);
        }

        public static FileUplinkBody parseFrom(InputStream r100) throws IOException {
            return (FileUplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        public static FileUplinkBody parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        public static FileUplinkBody parseFrom(byte[] r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        private FileUplinkBody(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this();
            if (r101 == null) goto L39;
            UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
            boolean r103 = false;
            boolean r104 = false;
        L6:
            if (r103 == true) goto L34;
            int r105 = r100.readTag();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            if (r105 == 0) goto L19;
            if (r105 != 10) goto L12;
            if ((r104 & true) == true) goto L17;
            this.uploadFiles_ = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            r104 = r104 | true;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
        L17:
            this.uploadFiles_.add((FileData) r100.readMessage(FileData.parser(), r101));     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            goto L6
        L12:
            if (parseUnknownFieldProto3(r100, r102, r101, r105) == true) goto L6;
        L19:
            r103 = true;
            goto L6
        L20:
            th = move-exception;
            if ((r104 & true) != true) goto L31;
            this.uploadFiles_ = Collections.unmodifiableList(this.uploadFiles_);
        L31:
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            throw th;
        L25:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L20
        L22:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L20
        L34:
            if ((r104 & true) != true) goto L36;
            this.uploadFiles_ = Collections.unmodifiableList(this.uploadFiles_);
        L36:
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            return;
        L39:
            throw null;
        }

        public static /* synthetic */ List access$9102(FileUplinkBody r100, List r101) {
            r100.uploadFiles_ = r101;
            return r101;
        }

        public static FileUplinkBody parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileUplinkBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
        }

        public static FileUplinkBody parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ FileUplinkBody(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static FileUplinkBody parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileUplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static FileUplinkBody parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (FileUplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static FileUplinkBody parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public static FileUplinkBody parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ FileUplinkBody(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface FileUplinkBodyOrBuilder extends MessageOrBuilder {
        FileData getUploadFiles(int r100);

        int getUploadFilesCount();

        List<FileData> getUploadFilesList();

        FileDataOrBuilder getUploadFilesOrBuilder(int r100);

        List<? extends FileDataOrBuilder> getUploadFilesOrBuilderList();
    }

    public static final class ImageBaseInfo extends GeneratedMessageV3 implements ImageBaseInfoOrBuilder {
        private static final ImageBaseInfo DEFAULT_INSTANCE = null;
        public static final int FORMAT_FIELD_NUMBER = 1;
        public static final int HEIGHT_FIELD_NUMBER = 3;
        private static final Parser<ImageBaseInfo> PARSER = null;
        public static final int WIDTH_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int format_;
        private long height_;
        private byte memoizedIsInitialized;
        private long width_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ImageBaseInfoOrBuilder {
            private int format_;
            private long height_;
            private long width_;

            public Builder clearFormat() {
                this.format_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ImageBaseInfo buildPartial() {
                ImageBaseInfo r100 = new ImageBaseInfo(this, null);
                ImageBaseInfo.access$602(r100, this.format_);
                ImageBaseInfo.access$702(r100, this.width_);
                ImageBaseInfo.access$802(r100, this.height_);
                onBuilt();
                return r100;
            }

            public Builder clearHeight() {
                this.height_ = 0;
                onChanged();
                return this;
            }

            public Builder clearWidth() {
                this.width_ = 0;
                onChanged();
                return this;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.ImageBaseInfoOrBuilder
            public ImageFormat getFormat() {
                ImageFormat r100 = ImageFormat.valueOf(this.format_);
                if (r100 == null) goto L5;
                return r100;
            L5:
                return ImageFormat.UNRECOGNIZED;
            }

            private Builder() {
                this.format_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvFile.access$000();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ImageBaseInfo build() {
                ImageBaseInfo r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.format_ = 0;
                this.width_ = 0;
                this.height_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvFile.access$000();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvFile.access$100().ensureFieldAccessorsInitialized(ImageBaseInfo.class, Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                ImageBaseInfo.access$400();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.ImageBaseInfoOrBuilder
            public int getFormatValue() {
                return this.format_;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.ImageBaseInfoOrBuilder
            public long getHeight() {
                return this.height_;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.ImageBaseInfoOrBuilder
            public long getWidth() {
                return this.width_;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ImageBaseInfo getDefaultInstanceForType() {
                return ImageBaseInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo8531clone() throws CloneNotSupportedException {
                return clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r100) {
                super(r100);
                this.format_ = 0;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor r100) {
                return (Builder) super.clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return (Builder) super.clearOneof(r100);
            }

            public Builder mergeFrom(ImageBaseInfo r100) {
                if (r100 != ImageBaseInfo.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (ImageBaseInfo.access$600(r100) == 0) goto L9;
                setFormatValue(r100.getFormatValue());
            L9:
                if (r100.getWidth() == 0) goto L12;
                setWidth(r100.getWidth());
            L12:
                if (r100.getHeight() == 0) goto L14;
                setHeight(r100.getHeight());
            L14:
                mergeUnknownFields(ImageBaseInfo.access$900(r100));
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.mergeUnknownFields(r100);
            }

            public Builder setFormat(ImageFormat r100) {
                if (r100 == null) goto L6;
                this.format_ = r100.getNumber();
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setFormatValue(int r100) {
                this.format_ = r100;
                onChanged();
                return this;
            }

            public Builder setHeight(long r100) {
                this.height_ = r100;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.setUnknownFieldsProto3(r100);
            }

            public Builder setWidth(long r100) {
                this.width_ = r100;
                onChanged();
                return this;
            }

            public /* synthetic */ Builder(AnonymousClass1 r100) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r100) {
                if ((r100 instanceof ImageBaseInfo) == true) goto L5;
                super.mergeFrom(r100);
                return this;
            L5:
                return mergeFrom((ImageBaseInfo) r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r100, AnonymousClass1 r101) {
                this(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                ImageBaseInfo r102 = null;
                ImageBaseInfo r103 = (ImageBaseInfo) ImageBaseInfo.access$1000().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L7:
                th = th;
            L15:
                if (r102 == null) goto L17;
                mergeFrom(r102);
            L17:
                throw th;
            L9:
                e = move-exception;
                ImageBaseInfo r104 = (ImageBaseInfo) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r102 = r104;
                goto L15
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.setField(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return (Builder) super.setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }
        }

        static {
            DEFAULT_INSTANCE = new ImageBaseInfo();
            PARSER = new AnonymousClass1();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.ImageBaseInfoOrBuilder
        public ImageFormat getFormat() {
            ImageFormat r100 = ImageFormat.valueOf(this.format_);
            if (r100 == null) goto L5;
            return r100;
        L5:
            return ImageFormat.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if (this.format_ == ImageFormat.FILE_FORMAT_UNSPECIFIED.getNumber()) goto L8;
            r101 = 0 + CodedOutputStream.computeEnumSize(1, this.format_);
        L8:
            long r102 = this.width_;
            if (r102 == 0) goto L11;
            r101 = r101 + CodedOutputStream.computeInt64Size(2, r102);
        L11:
            long r103 = this.height_;
            if (r103 == 0) goto L14;
            r101 = r101 + CodedOutputStream.computeInt64Size(3, r103);
        L14:
            int r104 = r101 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r104;
            return r104;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int r100 = this.memoizedHashCode;
            if (r100 == 0) goto L5;
            return r100;
        L5:
            int r101 = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.format_) * 37) + 2) * 53) + Internal.hashLong(getWidth())) * 37) + 3) * 53) + Internal.hashLong(getHeight())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = r101;
            return r101;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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
        public Builder toBuilder() {
            AnonymousClass1 r100 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r100);
        L6:
            return new Builder(r100).mergeFrom(this);
        }

        private ImageBaseInfo() {
            this.memoizedIsInitialized = -1;
            this.format_ = 0;
            this.width_ = 0;
            this.height_ = 0;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvFile.access$000();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvFile.access$100().ensureFieldAccessorsInitialized(ImageBaseInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static /* synthetic */ Parser access$1000() {
            return PARSER;
        }

        public static /* synthetic */ boolean access$400() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static ImageBaseInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ImageBaseInfo> parser() {
            return PARSER;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.ImageBaseInfoOrBuilder
        public int getFormatValue() {
            return this.format_;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.ImageBaseInfoOrBuilder
        public long getHeight() {
            return this.height_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ImageBaseInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.ImageBaseInfoOrBuilder
        public long getWidth() {
            return this.width_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ImageBaseInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private ImageBaseInfo(GeneratedMessageV3.Builder<?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ int access$600(ImageBaseInfo r100) {
            return r100.format_;
        }

        public static /* synthetic */ UnknownFieldSet access$900(ImageBaseInfo r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(ImageBaseInfo r100) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
        }

        public static ImageBaseInfo parseDelimitedFrom(InputStream r100) throws IOException {
            return (ImageBaseInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
        }

        public static ImageBaseInfo parseFrom(ByteString r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof ImageBaseInfo) == false) goto L8;
            ImageBaseInfo r101 = (ImageBaseInfo) r100;
            if (this.format_ != r101.format_) goto L12;
            boolean r102 = true;
        L13:
            if (r102 == true) goto L15;
        L17:
            boolean r103 = false;
        L18:
            if (r103 == true) goto L20;
        L22:
            boolean r104 = false;
        L23:
            if (r104 == true) goto L25;
        L27:
            return false;
        L25:
            if (this.unknownFields.equals(r101.unknownFields) == false) goto L27;
            return true;
        L20:
            if (getHeight() != r101.getHeight()) goto L22;
            r104 = true;
            goto L23
        L15:
            if (getWidth() != r101.getWidth()) goto L17;
            r103 = true;
            goto L18
        L12:
            r102 = false;
            goto L13
        L8:
            return super.equals(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return new Builder(r100, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            if (this.format_ == ImageFormat.FILE_FORMAT_UNSPECIFIED.getNumber()) goto L5;
            r100.writeEnum(1, this.format_);
        L5:
            long r101 = this.width_;
            if (r101 == 0) goto L8;
            r100.writeInt64(2, r101);
        L8:
            long r102 = this.height_;
            if (r102 == 0) goto L11;
            r100.writeInt64(3, r102);
        L11:
            this.unknownFields.writeTo(r100);
        }

        public static ImageBaseInfo parseFrom(CodedInputStream r100) throws IOException {
            return (ImageBaseInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return newBuilderForType(r100);
        }

        public static ImageBaseInfo parseFrom(InputStream r100) throws IOException {
            return (ImageBaseInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        public static ImageBaseInfo parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        public static ImageBaseInfo parseFrom(byte[] r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        private ImageBaseInfo(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this();
            if (r101 == null) goto L35;
            UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
            boolean r103 = false;
        L5:
            if (r103 == true) goto L32;
            int r104 = r100.readTag();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
            if (r104 == 0) goto L21;
            if (r104 != 8) goto L11;
            this.format_ = r100.readEnum();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
            goto L5
        L11:
            if (r104 != 16) goto L13;
            this.width_ = r100.readInt64();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
            goto L5
        L13:
            if (r104 != 24) goto L15;
            this.height_ = r100.readInt64();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
            goto L5
        L15:
            if (parseUnknownFieldProto3(r100, r102, r101, r104) == true) goto L5;
        L21:
            r103 = true;
            goto L5
        L22:
            th = move-exception;
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            throw th;
        L27:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L22
        L24:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L22
        L32:
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            return;
        L35:
            throw null;
        }

        public static /* synthetic */ int access$602(ImageBaseInfo r100, int r101) {
            r100.format_ = r101;
            return r101;
        }

        public static /* synthetic */ long access$702(ImageBaseInfo r100, long r101) {
            r100.width_ = r101;
            return r101;
        }

        public static /* synthetic */ long access$802(ImageBaseInfo r100, long r101) {
            r100.height_ = r101;
            return r101;
        }

        public static ImageBaseInfo parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (ImageBaseInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
        }

        public static ImageBaseInfo parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ ImageBaseInfo(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static ImageBaseInfo parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (ImageBaseInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static ImageBaseInfo parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (ImageBaseInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static ImageBaseInfo parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public static ImageBaseInfo parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ ImageBaseInfo(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface ImageBaseInfoOrBuilder extends MessageOrBuilder {
        ImageFormat getFormat();

        int getFormatValue();

        long getHeight();

        long getWidth();
    }

    public static final enum ImageFormat extends Enum<ImageFormat> implements ProtocolMessageEnum {
        private static final /* synthetic */ ImageFormat[] $VALUES = null;
        public static final ImageFormat FILE_FORMAT_UNSPECIFIED = null;
        public static final int FILE_FORMAT_UNSPECIFIED_VALUE = 0;
        public static final ImageFormat HEIF = null;
        public static final int HEIF_VALUE = 2;
        public static final ImageFormat JPEG = null;
        public static final int JPEG_VALUE = 1;
        public static final ImageFormat UNRECOGNIZED = null;
        private static final ImageFormat[] VALUES = null;
        private static final Internal.EnumLiteMap<ImageFormat> internalValueMap = null;
        private final int value;

        static {
            ImageFormat r100 = new ImageFormat("FILE_FORMAT_UNSPECIFIED", 0, 0);
            FILE_FORMAT_UNSPECIFIED = r100;
            ImageFormat r101 = new ImageFormat("JPEG", 1, 1);
            JPEG = r101;
            ImageFormat r102 = new ImageFormat("HEIF", 2, 2);
            HEIF = r102;
            ImageFormat r103 = new ImageFormat("UNRECOGNIZED", 3, -1);
            UNRECOGNIZED = r103;
            $VALUES = new ImageFormat[]{r100, r101, r102, r103};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        public static ImageFormat[] values() {
            return (ImageFormat[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ListProtector.get(AvFile.getDescriptor().getEnumTypes(), 1);
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
        }

        public static Internal.EnumLiteMap<ImageFormat> internalGetValueMap() {
            return internalValueMap;
        }

        public static ImageFormat forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return HEIF;
        L12:
            return JPEG;
        L14:
            return FILE_FORMAT_UNSPECIFIED;
        }

        public static ImageFormat valueOf(Descriptors.EnumValueDescriptor r100) {
            if (r100.getType() != getDescriptor()) goto L11;
            if (r100.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r100.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static ImageFormat valueOf(String r100) {
            return (ImageFormat) a.a(ImageFormat.class, r100);
        }

        public static ImageFormat valueOf(int r100) {
            return forNumber(r100);
        }

        private ImageFormat(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class OcrInfo extends GeneratedMessageV3 implements OcrInfoOrBuilder {
        private static final OcrInfo DEFAULT_INSTANCE = null;
        public static final int HAS_OCR_TEXT_FIELD_NUMBER = 1;
        public static final int OCR_TEXT_FIELD_NUMBER = 2;
        private static final Parser<OcrInfo> PARSER = null;
        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        public static final int VIDEO_FRAME_INDEX_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private boolean hasOcrText_;
        private byte memoizedIsInitialized;
        private volatile Object ocrText_;
        private long timestamp_;
        private long videoFrameIndex_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OcrInfoOrBuilder {
            private boolean hasOcrText_;
            private Object ocrText_;
            private long timestamp_;
            private long videoFrameIndex_;

            public Builder clearHasOcrText() {
                this.hasOcrText_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OcrInfo buildPartial() {
                OcrInfo r100 = new OcrInfo(this, null);
                OcrInfo.access$1802(r100, this.hasOcrText_);
                OcrInfo.access$1902(r100, this.ocrText_);
                OcrInfo.access$2002(r100, this.timestamp_);
                OcrInfo.access$2102(r100, this.videoFrameIndex_);
                onBuilt();
                return r100;
            }

            public Builder clearTimestamp() {
                this.timestamp_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVideoFrameIndex() {
                this.videoFrameIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.OcrInfoOrBuilder
            public String getOcrText() {
                Object r100 = this.ocrText_;
                if ((r100 instanceof String) == true) goto L7;
                String r101 = ((ByteString) r100).toStringUtf8();
                this.ocrText_ = r101;
                return r101;
            L7:
                return (String) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.OcrInfoOrBuilder
            public ByteString getOcrTextBytes() {
                Object r100 = this.ocrText_;
                if ((r100 instanceof String) == false) goto L7;
                ByteString r101 = ByteString.copyFromUtf8((String) r100);
                this.ocrText_ = r101;
                return r101;
            L7:
                return (ByteString) r100;
            }

            private Builder() {
                this.ocrText_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvFile.access$1200();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OcrInfo build() {
                OcrInfo r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.hasOcrText_ = false;
                this.ocrText_ = "";
                this.timestamp_ = 0;
                this.videoFrameIndex_ = 0;
                return this;
            }

            public Builder clearOcrText() {
                this.ocrText_ = OcrInfo.getDefaultInstance().getOcrText();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvFile.access$1200();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvFile.access$1300().ensureFieldAccessorsInitialized(OcrInfo.class, Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                OcrInfo.access$1600();
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.OcrInfoOrBuilder
            public boolean getHasOcrText() {
                return this.hasOcrText_;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.OcrInfoOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.larus.im.internal.network.proto2.AvFile.OcrInfoOrBuilder
            public long getVideoFrameIndex() {
                return this.videoFrameIndex_;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public OcrInfo getDefaultInstanceForType() {
                return OcrInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo8531clone() throws CloneNotSupportedException {
                return clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r100) {
                super(r100);
                this.ocrText_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor r100) {
                return (Builder) super.clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return (Builder) super.clearOneof(r100);
            }

            public Builder mergeFrom(OcrInfo r100) {
                if (r100 != OcrInfo.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.getHasOcrText() == false) goto L9;
                setHasOcrText(r100.getHasOcrText());
            L9:
                if (r100.getOcrText().isEmpty() == true) goto L12;
                this.ocrText_ = OcrInfo.access$1900(r100);
                onChanged();
            L12:
                if (r100.getTimestamp() == 0) goto L15;
                setTimestamp(r100.getTimestamp());
            L15:
                if (r100.getVideoFrameIndex() == 0) goto L17;
                setVideoFrameIndex(r100.getVideoFrameIndex());
            L17:
                mergeUnknownFields(OcrInfo.access$2200(r100));
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.mergeUnknownFields(r100);
            }

            public Builder setHasOcrText(boolean r100) {
                this.hasOcrText_ = r100;
                onChanged();
                return this;
            }

            public Builder setOcrText(String r100) {
                if (r100 == null) goto L6;
                this.ocrText_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setOcrTextBytes(ByteString r100) {
                if (r100 == null) goto L6;
                OcrInfo.access$2400(r100);
                this.ocrText_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTimestamp(long r100) {
                this.timestamp_ = r100;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.setUnknownFieldsProto3(r100);
            }

            public Builder setVideoFrameIndex(long r100) {
                this.videoFrameIndex_ = r100;
                onChanged();
                return this;
            }

            public /* synthetic */ Builder(AnonymousClass1 r100) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r100) {
                if ((r100 instanceof OcrInfo) == true) goto L5;
                super.mergeFrom(r100);
                return this;
            L5:
                return mergeFrom((OcrInfo) r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r100) {
                return clearField(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r100) {
                return clearOneof(r100);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r100) {
                return mergeFrom(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r100, AnonymousClass1 r101) {
                this(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                OcrInfo r102 = null;
                OcrInfo r103 = (OcrInfo) OcrInfo.access$2300().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L7:
                th = th;
            L15:
                if (r102 == null) goto L17;
                mergeFrom(r102);
            L17:
                throw th;
            L9:
                e = move-exception;
                OcrInfo r104 = (OcrInfo) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r102 = r104;
                goto L15
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return (Builder) super.setField(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r100, Object r101) {
                return addRepeatedField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r100, Object r101) {
                return setField(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return (Builder) super.setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r100, int r101, Object r102) {
                return setRepeatedField(r100, r101, r102);
            }
        }

        static {
            DEFAULT_INSTANCE = new OcrInfo();
            PARSER = new AnonymousClass1();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.OcrInfoOrBuilder
        public String getOcrText() {
            Object r100 = this.ocrText_;
            if ((r100 instanceof String) == true) goto L5;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.ocrText_ = r101;
            return r101;
        L5:
            return (String) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.OcrInfoOrBuilder
        public ByteString getOcrTextBytes() {
            Object r100 = this.ocrText_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.ocrText_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            boolean r101 = this.hasOcrText_;
            int r102 = 0;
            if (r101 == false) goto L9;
            r102 = 0 + CodedOutputStream.computeBoolSize(1, r101);
        L9:
            if (getOcrTextBytes().isEmpty() == true) goto L11;
            r102 = r102 + GeneratedMessageV3.computeStringSize(2, this.ocrText_);
        L11:
            long r103 = this.timestamp_;
            if (r103 == 0) goto L14;
            r102 = r102 + CodedOutputStream.computeInt64Size(3, r103);
        L14:
            long r104 = this.videoFrameIndex_;
            if (r104 == 0) goto L17;
            r102 = r102 + CodedOutputStream.computeInt64Size(4, r104);
        L17:
            int r105 = r102 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r105;
            return r105;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int r100 = this.memoizedHashCode;
            if (r100 == 0) goto L5;
            return r100;
        L5:
            int r101 = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashBoolean(getHasOcrText())) * 37) + 2) * 53) + getOcrText().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getTimestamp())) * 37) + 4) * 53) + Internal.hashLong(getVideoFrameIndex())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = r101;
            return r101;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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
        public Builder toBuilder() {
            AnonymousClass1 r100 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r100);
        L6:
            return new Builder(r100).mergeFrom(this);
        }

        private OcrInfo() {
            this.memoizedIsInitialized = -1;
            this.hasOcrText_ = false;
            this.ocrText_ = "";
            this.timestamp_ = 0;
            this.videoFrameIndex_ = 0;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvFile.access$1200();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvFile.access$1300().ensureFieldAccessorsInitialized(OcrInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static /* synthetic */ boolean access$1600() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ Parser access$2300() {
            return PARSER;
        }

        public static OcrInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OcrInfo> parser() {
            return PARSER;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.OcrInfoOrBuilder
        public boolean getHasOcrText() {
            return this.hasOcrText_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<OcrInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.OcrInfoOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.larus.im.internal.network.proto2.AvFile.OcrInfoOrBuilder
        public long getVideoFrameIndex() {
            return this.videoFrameIndex_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public OcrInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private OcrInfo(GeneratedMessageV3.Builder<?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ Object access$1900(OcrInfo r100) {
            return r100.ocrText_;
        }

        public static /* synthetic */ UnknownFieldSet access$2200(OcrInfo r100) {
            return r100.unknownFields;
        }

        public static /* synthetic */ void access$2400(ByteString r100) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(r100);
        }

        public static Builder newBuilder(OcrInfo r100) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
        }

        public static OcrInfo parseDelimitedFrom(InputStream r100) throws IOException {
            return (OcrInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
        }

        public static OcrInfo parseFrom(ByteString r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof OcrInfo) == false) goto L8;
            OcrInfo r101 = (OcrInfo) r100;
            if (getHasOcrText() != r101.getHasOcrText()) goto L12;
            boolean r102 = true;
        L13:
            if (r102 == true) goto L15;
        L17:
            boolean r103 = false;
        L18:
            if (r103 == true) goto L20;
        L22:
            boolean r104 = false;
        L23:
            if (r104 == true) goto L25;
        L27:
            boolean r105 = false;
        L28:
            if (r105 == true) goto L30;
        L32:
            return false;
        L30:
            if (this.unknownFields.equals(r101.unknownFields) == false) goto L32;
            return true;
        L25:
            if (getVideoFrameIndex() != r101.getVideoFrameIndex()) goto L27;
            r105 = true;
            goto L28
        L20:
            if (getTimestamp() != r101.getTimestamp()) goto L22;
            r104 = true;
            goto L23
        L15:
            if (getOcrText().equals(r101.getOcrText()) == false) goto L17;
            r103 = true;
            goto L18
        L12:
            r102 = false;
            goto L13
        L8:
            return super.equals(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return new Builder(r100, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            boolean r101 = this.hasOcrText_;
            if (r101 == false) goto L6;
            r100.writeBool(1, r101);
        L6:
            if (getOcrTextBytes().isEmpty() == true) goto L8;
            GeneratedMessageV3.writeString(r100, 2, this.ocrText_);
        L8:
            long r102 = this.timestamp_;
            if (r102 == 0) goto L11;
            r100.writeInt64(3, r102);
        L11:
            long r103 = this.videoFrameIndex_;
            if (r103 == 0) goto L14;
            r100.writeInt64(4, r103);
        L14:
            this.unknownFields.writeTo(r100);
        }

        public static OcrInfo parseFrom(CodedInputStream r100) throws IOException {
            return (OcrInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return newBuilderForType(r100);
        }

        public static OcrInfo parseFrom(InputStream r100) throws IOException {
            return (OcrInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        public static OcrInfo parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        public static OcrInfo parseFrom(byte[] r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        private OcrInfo(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this();
            if (r101 == null) goto L38;
            UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
            boolean r103 = false;
        L5:
            if (r103 == true) goto L35;
            int r104 = r100.readTag();     // Catch: Throwable -> L25 IOException -> L27 InvalidProtocolBufferException -> L30
            if (r104 == 0) goto L24;
            if (r104 != 8) goto L11;
            this.hasOcrText_ = r100.readBool();     // Catch: Throwable -> L25 IOException -> L27 InvalidProtocolBufferException -> L30
            goto L5
        L11:
            if (r104 != 18) goto L13;
            this.ocrText_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L25 IOException -> L27 InvalidProtocolBufferException -> L30
            goto L5
        L13:
            if (r104 != 24) goto L15;
            this.timestamp_ = r100.readInt64();     // Catch: Throwable -> L25 IOException -> L27 InvalidProtocolBufferException -> L30
            goto L5
        L15:
            if (r104 != 32) goto L17;
            this.videoFrameIndex_ = r100.readInt64();     // Catch: Throwable -> L25 IOException -> L27 InvalidProtocolBufferException -> L30
            goto L5
        L17:
            if (parseUnknownFieldProto3(r100, r102, r101, r104) == true) goto L5;
        L24:
            r103 = true;
            goto L5
        L25:
            th = move-exception;
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            throw th;
        L30:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L25
        L27:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L25
        L35:
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            return;
        L38:
            throw null;
        }

        public static /* synthetic */ boolean access$1802(OcrInfo r100, boolean r101) {
            r100.hasOcrText_ = r101;
            return r101;
        }

        public static /* synthetic */ Object access$1902(OcrInfo r100, Object r101) {
            r100.ocrText_ = r101;
            return r101;
        }

        public static /* synthetic */ long access$2002(OcrInfo r100, long r101) {
            r100.timestamp_ = r101;
            return r101;
        }

        public static /* synthetic */ long access$2102(OcrInfo r100, long r101) {
            r100.videoFrameIndex_ = r101;
            return r101;
        }

        public static OcrInfo parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (OcrInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
        }

        public static OcrInfo parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ OcrInfo(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static OcrInfo parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (OcrInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static OcrInfo parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (OcrInfo) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static OcrInfo parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public static OcrInfo parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ OcrInfo(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface OcrInfoOrBuilder extends MessageOrBuilder {
        boolean getHasOcrText();

        String getOcrText();

        ByteString getOcrTextBytes();

        long getTimestamp();

        long getVideoFrameIndex();
    }

    private AvFile() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite r100) {
    }

    static {
        Descriptors.FileDescriptor[] r100 = new Descriptors.FileDescriptor[0];
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rav_file.proto\u0012$com.larus.im.internal.network.proto2\"q\n\rImageBaseInfo\u0012A\n\u0006format\u0018\u0001 \u0001(\u000e21.com.larus.im.internal.network.proto2.ImageFormat\u0012\r\n\u0005width\u0018\u0002 \u0001(\u0003\u0012\u000e\n\u0006height\u0018\u0003 \u0001(\u0003\"_\n\u0007OcrInfo\u0012\u0014\n\fhas_ocr_text\u0018\u0001 \u0001(\b\u0012\u0010\n\bocr_text\u0018\u0002 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0003\u0012\u0019\n\u0011video_frame_index\u0018\u0004 \u0001(\u0003\"d\n\u000bFileBizInfo\u0012C\n\bbiz_type\u0018\u0001 \u0001(\u000e21.com.larus.im.internal.network.proto2.FileBizType\u0012\u0010\n\bbiz_info\u0018\u0002 \u0001(\t\"ñ\u0002\n\bFileData\u0012\u0011\n\tupload_id\u0018\u0001 \u0001(\t\u0012A\n\tfile_type\u0018\u0002 \u0001(\u000e2..com.larus.im.internal.network.proto2.FileType\u0012\f\n\u0004data\u0018\u0003 \u0001(\f\u0012\u0012\n\nsize_bytes\u0018\u0004 \u0001(\u0003\u0012\u0014\n\fchecksum_md5\u0018\u0005 \u0001(\t\u0012?\n\bocr_info\u0018\u0006 \u0001(\u000b2-.com.larus.im.internal.network.proto2.OcrInfo\u0012L\n\u000fimage_base_info\u0018\u000b \u0001(\u000b23.com.larus.im.internal.network.proto2.ImageBaseInfo\u0012H\n\rfile_biz_info\u0018\f \u0001(\u000b21.com.larus.im.internal.network.proto2.FileBizInfo\"\u0084\u0001\n\nFileResult\u0012\u0011\n\tupload_id\u0018\u0001 \u0001(\t\u0012\u000b\n\u0003uri\u0018\u0002 \u0001(\t\u0012\u000b\n\u0003url\u0018\u0003 \u0001(\t\u0012I\n\bbiz_info\u0018\u0004 \u0001(\u000b27.com.larus.im.internal.network.proto2.FileResultBizInfo\"j\n\u0011FileResultBizInfo\u0012C\n\bbiz_type\u0018\u0001 \u0001(\u000e21.com.larus.im.internal.network.proto2.FileBizType\u0012\u0010\n\bbiz_info\u0018\u0002 \u0001(\t\"V\n\u000eFileUplinkBody\u0012D\n\fupload_files\u0018\u0001 \u0003(\u000b2..com.larus.im.internal.network.proto2.FileData\"ó\u0001\n\u0010FileDownlinkBody\u0012\f\n\u0004code\u0018\u0001 \u0001(\u0003\u0012\u000f\n\u0007message\u0018\u0002 \u0001(\t\u0012F\n\ffile_results\u0018\u0003 \u0003(\u000b20.com.larus.im.internal.network.proto2.FileResult\u0012L\n\u0003ext\u0018\u000b \u0003(\u000b2?.com.larus.im.internal.network.proto2.FileDownlinkBody.ExtEntry\u001a*\n\bExtEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001*A\n\bFileType\u0012\u001c\n\u0018CONTENT_TYPE_UNSPECIFIED\u0010\u0000\u0012\t\n\u0005IMAGE\u0010\u0001\u0012\f\n\bOCR_META\u0010\u0002*>\n\u000bImageFormat\u0012\u001b\n\u0017FILE_FORMAT_UNSPECIFIED\u0010\u0000\u0012\b\n\u0004JPEG\u0010\u0001\u0012\b\n\u0004HEIF\u0010\u0002*K\n\u000bFileBizType\u0012\u001c\n\u0018ImageBizType_UNSPECIFIED\u0010\u0000\u0012\r\n\tDoraImage\u0010\u0001\u0012\u000f\n\u000bDoraOcrMeta\u0010\u0002B'Z%code.byted.org/flow/alice_protocol/avb\u0006proto3"}, r100, new AnonymousClass1());
        Descriptors.Descriptor r101 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 0);
        internal_static_com_larus_im_internal_network_proto2_ImageBaseInfo_descriptor = r101;
        internal_static_com_larus_im_internal_network_proto2_ImageBaseInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r101, new String[]{"Format", "Width", "Height"});
        Descriptors.Descriptor r102 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 1);
        internal_static_com_larus_im_internal_network_proto2_OcrInfo_descriptor = r102;
        internal_static_com_larus_im_internal_network_proto2_OcrInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r102, new String[]{"HasOcrText", "OcrText", "Timestamp", "VideoFrameIndex"});
        Descriptors.Descriptor r103 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 2);
        internal_static_com_larus_im_internal_network_proto2_FileBizInfo_descriptor = r103;
        internal_static_com_larus_im_internal_network_proto2_FileBizInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r103, new String[]{"BizType", "BizInfo"});
        Descriptors.Descriptor r104 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 3);
        internal_static_com_larus_im_internal_network_proto2_FileData_descriptor = r104;
        internal_static_com_larus_im_internal_network_proto2_FileData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r104, new String[]{"UploadId", "FileType", "Data", "SizeBytes", "ChecksumMd5", "OcrInfo", "ImageBaseInfo", "FileBizInfo"});
        Descriptors.Descriptor r105 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 4);
        internal_static_com_larus_im_internal_network_proto2_FileResult_descriptor = r105;
        internal_static_com_larus_im_internal_network_proto2_FileResult_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r105, new String[]{"UploadId", "Uri", "Url", "BizInfo"});
        Descriptors.Descriptor r106 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 5);
        internal_static_com_larus_im_internal_network_proto2_FileResultBizInfo_descriptor = r106;
        internal_static_com_larus_im_internal_network_proto2_FileResultBizInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r106, new String[]{"BizType", "BizInfo"});
        Descriptors.Descriptor r107 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 6);
        internal_static_com_larus_im_internal_network_proto2_FileUplinkBody_descriptor = r107;
        internal_static_com_larus_im_internal_network_proto2_FileUplinkBody_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r107, new String[]{"UploadFiles"});
        Descriptors.Descriptor r108 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 7);
        internal_static_com_larus_im_internal_network_proto2_FileDownlinkBody_descriptor = r108;
        internal_static_com_larus_im_internal_network_proto2_FileDownlinkBody_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r108, new String[]{"Code", ServiceType.IM, "FileResults", "Ext"});
        Descriptors.Descriptor r109 = (Descriptors.Descriptor) ListProtector.get(r108.getNestedTypes(), 0);
        internal_static_com_larus_im_internal_network_proto2_FileDownlinkBody_ExtEntry_descriptor = r109;
        internal_static_com_larus_im_internal_network_proto2_FileDownlinkBody_ExtEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r109, new String[]{"Key", "Value"});
    }

    public static /* synthetic */ Descriptors.Descriptor access$000() {
        return internal_static_com_larus_im_internal_network_proto2_ImageBaseInfo_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$100() {
        return internal_static_com_larus_im_internal_network_proto2_ImageBaseInfo_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$1200() {
        return internal_static_com_larus_im_internal_network_proto2_OcrInfo_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$1300() {
        return internal_static_com_larus_im_internal_network_proto2_OcrInfo_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$2600() {
        return internal_static_com_larus_im_internal_network_proto2_FileBizInfo_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$2700() {
        return internal_static_com_larus_im_internal_network_proto2_FileBizInfo_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$3800() {
        return internal_static_com_larus_im_internal_network_proto2_FileData_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$3900() {
        return internal_static_com_larus_im_internal_network_proto2_FileData_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$5700() {
        return internal_static_com_larus_im_internal_network_proto2_FileResult_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$5800() {
        return internal_static_com_larus_im_internal_network_proto2_FileResult_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$7300() {
        return internal_static_com_larus_im_internal_network_proto2_FileResultBizInfo_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$7400() {
        return internal_static_com_larus_im_internal_network_proto2_FileResultBizInfo_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$8500() {
        return internal_static_com_larus_im_internal_network_proto2_FileUplinkBody_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$8600() {
        return internal_static_com_larus_im_internal_network_proto2_FileUplinkBody_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$9600() {
        return internal_static_com_larus_im_internal_network_proto2_FileDownlinkBody_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$9700() {
        return internal_static_com_larus_im_internal_network_proto2_FileDownlinkBody_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$9800() {
        return internal_static_com_larus_im_internal_network_proto2_FileDownlinkBody_ExtEntry_descriptor;
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static /* synthetic */ Descriptors.FileDescriptor access$11402(Descriptors.FileDescriptor r100) {
        descriptor = r100;
        return r100;
    }

    public static void registerAllExtensions(ExtensionRegistry r100) {
        registerAllExtensions(r100);
    }
}
