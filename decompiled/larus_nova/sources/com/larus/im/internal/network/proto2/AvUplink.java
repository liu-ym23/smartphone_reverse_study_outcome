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
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
public final class AvUplink {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_CommandUplinkBody_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_CommandUplinkBody_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_UplinkBody_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_UplinkBody_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_UplinkMessage_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_UplinkMessage_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_VideoSwitchModal_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_VideoSwitchModal_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_larus_im_internal_network_proto2_VideoUplinkBody_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_larus_im_internal_network_proto2_VideoUplinkBody_fieldAccessorTable = null;

    public static final class CommandUplinkBody extends GeneratedMessageV3 implements CommandUplinkBodyOrBuilder {
        public static final int CLI_MS_FIELD_NUMBER = 3;
        public static final int COMMAND_FIELD_NUMBER = 1;
        private static final CommandUplinkBody DEFAULT_INSTANCE = null;
        public static final int EXTRA_FIELD_NUMBER = 2;
        private static final Parser<CommandUplinkBody> PARSER = null;
        private static final long serialVersionUID = 0;
        private long cliMs_;
        private int command_;
        private volatile Object extra_;
        private byte memoizedIsInitialized;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommandUplinkBodyOrBuilder {
            private long cliMs_;
            private int command_;
            private Object extra_;

            public Builder clearCommand() {
                this.command_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CommandUplinkBody buildPartial() {
                CommandUplinkBody r100 = new CommandUplinkBody(this, null);
                CommandUplinkBody.access$5802(r100, this.command_);
                CommandUplinkBody.access$5902(r100, this.extra_);
                CommandUplinkBody.access$6002(r100, this.cliMs_);
                onBuilt();
                return r100;
            }

            public Builder clearCliMs() {
                this.cliMs_ = 0;
                onChanged();
                return this;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.CommandUplinkBodyOrBuilder
            public AvCmd.CommandEventType getCommand() {
                AvCmd.CommandEventType r100 = AvCmd.CommandEventType.valueOf(this.command_);
                if (r100 == null) goto L5;
                return r100;
            L5:
                return AvCmd.CommandEventType.UNRECOGNIZED;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.CommandUplinkBodyOrBuilder
            public String getExtra() {
                Object r100 = this.extra_;
                if ((r100 instanceof String) == true) goto L7;
                String r101 = ((ByteString) r100).toStringUtf8();
                this.extra_ = r101;
                return r101;
            L7:
                return (String) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.CommandUplinkBodyOrBuilder
            public ByteString getExtraBytes() {
                Object r100 = this.extra_;
                if ((r100 instanceof String) == false) goto L7;
                ByteString r101 = ByteString.copyFromUtf8((String) r100);
                this.extra_ = r101;
                return r101;
            L7:
                return (ByteString) r100;
            }

            private Builder() {
                this.command_ = 0;
                this.extra_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvUplink.access$5200();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CommandUplinkBody build() {
                CommandUplinkBody r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.command_ = 0;
                this.extra_ = "";
                this.cliMs_ = 0;
                return this;
            }

            public Builder clearExtra() {
                this.extra_ = CommandUplinkBody.getDefaultInstance().getExtra();
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
                return AvUplink.access$5200();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvUplink.access$5300().ensureFieldAccessorsInitialized(CommandUplinkBody.class, Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                CommandUplinkBody.access$5600();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.CommandUplinkBodyOrBuilder
            public long getCliMs() {
                return this.cliMs_;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.CommandUplinkBodyOrBuilder
            public int getCommandValue() {
                return this.command_;
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
            public CommandUplinkBody getDefaultInstanceForType() {
                return CommandUplinkBody.getDefaultInstance();
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
                this.command_ = 0;
                this.extra_ = "";
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

            public Builder mergeFrom(CommandUplinkBody r100) {
                if (r100 != CommandUplinkBody.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (CommandUplinkBody.access$5800(r100) == 0) goto L9;
                setCommandValue(r100.getCommandValue());
            L9:
                if (r100.getExtra().isEmpty() == true) goto L12;
                this.extra_ = CommandUplinkBody.access$5900(r100);
                onChanged();
            L12:
                if (r100.getCliMs() == 0) goto L14;
                setCliMs(r100.getCliMs());
            L14:
                mergeUnknownFields(CommandUplinkBody.access$6100(r100));
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.mergeUnknownFields(r100);
            }

            public Builder setCliMs(long r100) {
                this.cliMs_ = r100;
                onChanged();
                return this;
            }

            public Builder setCommand(AvCmd.CommandEventType r100) {
                if (r100 == null) goto L6;
                this.command_ = r100.getNumber();
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setCommandValue(int r100) {
                this.command_ = r100;
                onChanged();
                return this;
            }

            public Builder setExtra(String r100) {
                if (r100 == null) goto L6;
                this.extra_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setExtraBytes(ByteString r100) {
                if (r100 == null) goto L6;
                CommandUplinkBody.access$6300(r100);
                this.extra_ = r100;
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
                if ((r100 instanceof CommandUplinkBody) == true) goto L5;
                super.mergeFrom(r100);
                return this;
            L5:
                return mergeFrom((CommandUplinkBody) r100);
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
                CommandUplinkBody r102 = null;
                CommandUplinkBody r103 = (CommandUplinkBody) CommandUplinkBody.access$6200().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
                CommandUplinkBody r104 = (CommandUplinkBody) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            DEFAULT_INSTANCE = new CommandUplinkBody();
            PARSER = new AnonymousClass1();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.CommandUplinkBodyOrBuilder
        public AvCmd.CommandEventType getCommand() {
            AvCmd.CommandEventType r100 = AvCmd.CommandEventType.valueOf(this.command_);
            if (r100 == null) goto L5;
            return r100;
        L5:
            return AvCmd.CommandEventType.UNRECOGNIZED;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.CommandUplinkBodyOrBuilder
        public String getExtra() {
            Object r100 = this.extra_;
            if ((r100 instanceof String) == true) goto L5;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.extra_ = r101;
            return r101;
        L5:
            return (String) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.CommandUplinkBodyOrBuilder
        public ByteString getExtraBytes() {
            Object r100 = this.extra_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.extra_ = r101;
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
            int r101 = 0;
            if (this.command_ == AvCmd.CommandEventType.COMMON_UNUSED.getNumber()) goto L9;
            r101 = 0 + CodedOutputStream.computeEnumSize(1, this.command_);
        L9:
            if (getExtraBytes().isEmpty() == true) goto L11;
            r101 = r101 + GeneratedMessageV3.computeStringSize(2, this.extra_);
        L11:
            long r102 = this.cliMs_;
            if (r102 == 0) goto L14;
            r101 = r101 + CodedOutputStream.computeUInt64Size(3, r102);
        L14:
            int r103 = r101 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r103;
            return r103;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int r100 = this.memoizedHashCode;
            if (r100 == 0) goto L5;
            return r100;
        L5:
            int r101 = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.command_) * 37) + 2) * 53) + getExtra().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getCliMs())) * 29) + this.unknownFields.hashCode();
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

        private CommandUplinkBody() {
            this.memoizedIsInitialized = -1;
            this.command_ = 0;
            this.extra_ = "";
            this.cliMs_ = 0;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvUplink.access$5200();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvUplink.access$5300().ensureFieldAccessorsInitialized(CommandUplinkBody.class, Builder.class);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static /* synthetic */ boolean access$5600() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ Parser access$6200() {
            return PARSER;
        }

        public static CommandUplinkBody getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CommandUplinkBody> parser() {
            return PARSER;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.CommandUplinkBodyOrBuilder
        public long getCliMs() {
            return this.cliMs_;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.CommandUplinkBodyOrBuilder
        public int getCommandValue() {
            return this.command_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CommandUplinkBody> getParserForType() {
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
        public CommandUplinkBody getDefaultInstanceForType() {
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

        private CommandUplinkBody(GeneratedMessageV3.Builder<?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ int access$5800(CommandUplinkBody r100) {
            return r100.command_;
        }

        public static /* synthetic */ Object access$5900(CommandUplinkBody r100) {
            return r100.extra_;
        }

        public static /* synthetic */ UnknownFieldSet access$6100(CommandUplinkBody r100) {
            return r100.unknownFields;
        }

        public static /* synthetic */ void access$6300(ByteString r100) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(r100);
        }

        public static Builder newBuilder(CommandUplinkBody r100) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
        }

        public static CommandUplinkBody parseDelimitedFrom(InputStream r100) throws IOException {
            return (CommandUplinkBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
        }

        public static CommandUplinkBody parseFrom(ByteString r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof CommandUplinkBody) == false) goto L8;
            CommandUplinkBody r101 = (CommandUplinkBody) r100;
            if (this.command_ != r101.command_) goto L12;
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
            if (getCliMs() != r101.getCliMs()) goto L22;
            r104 = true;
            goto L23
        L15:
            if (getExtra().equals(r101.getExtra()) == false) goto L17;
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
            if (this.command_ == AvCmd.CommandEventType.COMMON_UNUSED.getNumber()) goto L6;
            r100.writeEnum(1, this.command_);
        L6:
            if (getExtraBytes().isEmpty() == true) goto L8;
            GeneratedMessageV3.writeString(r100, 2, this.extra_);
        L8:
            long r101 = this.cliMs_;
            if (r101 == 0) goto L11;
            r100.writeUInt64(3, r101);
        L11:
            this.unknownFields.writeTo(r100);
        }

        public static CommandUplinkBody parseFrom(CodedInputStream r100) throws IOException {
            return (CommandUplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return newBuilderForType(r100);
        }

        public static CommandUplinkBody parseFrom(InputStream r100) throws IOException {
            return (CommandUplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        public static CommandUplinkBody parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        public static CommandUplinkBody parseFrom(byte[] r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        private CommandUplinkBody(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this();
            if (r101 == null) goto L35;
            UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
            boolean r103 = false;
        L5:
            if (r103 == true) goto L32;
            int r104 = r100.readTag();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
            if (r104 == 0) goto L21;
            if (r104 != 8) goto L11;
            this.command_ = r100.readEnum();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
            goto L5
        L11:
            if (r104 != 18) goto L13;
            this.extra_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
            goto L5
        L13:
            if (r104 != 24) goto L15;
            this.cliMs_ = r100.readUInt64();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
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

        public static /* synthetic */ int access$5802(CommandUplinkBody r100, int r101) {
            r100.command_ = r101;
            return r101;
        }

        public static /* synthetic */ Object access$5902(CommandUplinkBody r100, Object r101) {
            r100.extra_ = r101;
            return r101;
        }

        public static /* synthetic */ long access$6002(CommandUplinkBody r100, long r101) {
            r100.cliMs_ = r101;
            return r101;
        }

        public static CommandUplinkBody parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (CommandUplinkBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
        }

        public static CommandUplinkBody parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ CommandUplinkBody(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static CommandUplinkBody parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (CommandUplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static CommandUplinkBody parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (CommandUplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static CommandUplinkBody parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public static CommandUplinkBody parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ CommandUplinkBody(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface CommandUplinkBodyOrBuilder extends MessageOrBuilder {
        long getCliMs();

        AvCmd.CommandEventType getCommand();

        int getCommandValue();

        String getExtra();

        ByteString getExtraBytes();
    }

    public static final enum ModalType extends Enum<ModalType> implements ProtocolMessageEnum {
        private static final /* synthetic */ ModalType[] $VALUES = null;
        public static final ModalType MODAL_TYPE_AUDIO = null;
        public static final int MODAL_TYPE_AUDIO_VALUE = 1;
        public static final ModalType MODAL_TYPE_UNKNOWN = null;
        public static final int MODAL_TYPE_UNKNOWN_VALUE = 0;
        public static final ModalType MODAL_TYPE_VIDEO = null;
        public static final int MODAL_TYPE_VIDEO_VALUE = 2;
        public static final ModalType UNRECOGNIZED = null;
        private static final ModalType[] VALUES = null;
        private static final Internal.EnumLiteMap<ModalType> internalValueMap = null;
        private final int value;

        static {
            ModalType r100 = new ModalType("MODAL_TYPE_UNKNOWN", 0, 0);
            MODAL_TYPE_UNKNOWN = r100;
            ModalType r101 = new ModalType("MODAL_TYPE_AUDIO", 1, 1);
            MODAL_TYPE_AUDIO = r101;
            ModalType r102 = new ModalType("MODAL_TYPE_VIDEO", 2, 2);
            MODAL_TYPE_VIDEO = r102;
            ModalType r103 = new ModalType("UNRECOGNIZED", 3, -1);
            UNRECOGNIZED = r103;
            $VALUES = new ModalType[]{r100, r101, r102, r103};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        public static ModalType[] values() {
            return (ModalType[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ListProtector.get(AvUplink.getDescriptor().getEnumTypes(), 0);
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
        }

        public static Internal.EnumLiteMap<ModalType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ModalType forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return MODAL_TYPE_VIDEO;
        L12:
            return MODAL_TYPE_AUDIO;
        L14:
            return MODAL_TYPE_UNKNOWN;
        }

        public static ModalType valueOf(Descriptors.EnumValueDescriptor r100) {
            if (r100.getType() != getDescriptor()) goto L11;
            if (r100.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r100.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static ModalType valueOf(String r100) {
            return (ModalType) a.a(ModalType.class, r100);
        }

        public static ModalType valueOf(int r100) {
            return forNumber(r100);
        }

        private ModalType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class UplinkBody extends GeneratedMessageV3 implements UplinkBodyOrBuilder {
        public static final int AUDIO_BODY_FIELD_NUMBER = 1;
        public static final int COMMAND_BODY_FIELD_NUMBER = 3;
        private static final UplinkBody DEFAULT_INSTANCE = null;
        public static final int FILE_BODY_FIELD_NUMBER = 4;
        private static final Parser<UplinkBody> PARSER = null;
        public static final int VIDEO_BODY_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private AvAudioUplink.AudioUplinkBody audioBody_;
        private CommandUplinkBody commandBody_;
        private AvFile.FileUplinkBody fileBody_;
        private byte memoizedIsInitialized;
        private VideoUplinkBody videoBody_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UplinkBodyOrBuilder {
            private SingleFieldBuilderV3<AvAudioUplink.AudioUplinkBody, AvAudioUplink.AudioUplinkBody.Builder, AvAudioUplink.AudioUplinkBodyOrBuilder> audioBodyBuilder_;
            private AvAudioUplink.AudioUplinkBody audioBody_;
            private SingleFieldBuilderV3<CommandUplinkBody, CommandUplinkBody.Builder, CommandUplinkBodyOrBuilder> commandBodyBuilder_;
            private CommandUplinkBody commandBody_;
            private SingleFieldBuilderV3<AvFile.FileUplinkBody, AvFile.FileUplinkBody.Builder, AvFile.FileUplinkBodyOrBuilder> fileBodyBuilder_;
            private AvFile.FileUplinkBody fileBody_;
            private SingleFieldBuilderV3<VideoUplinkBody, VideoUplinkBody.Builder, VideoUplinkBodyOrBuilder> videoBodyBuilder_;
            private VideoUplinkBody videoBody_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private SingleFieldBuilderV3<AvAudioUplink.AudioUplinkBody, AvAudioUplink.AudioUplinkBody.Builder, AvAudioUplink.AudioUplinkBodyOrBuilder> getAudioBodyFieldBuilder() {
                if (this.audioBodyBuilder_ != null) goto L6;
                this.audioBodyBuilder_ = new SingleFieldBuilderV3(getAudioBody(), getParentForChildren(), isClean());
                this.audioBody_ = null;
            L6:
                return this.audioBodyBuilder_;
            }

            private SingleFieldBuilderV3<CommandUplinkBody, CommandUplinkBody.Builder, CommandUplinkBodyOrBuilder> getCommandBodyFieldBuilder() {
                if (this.commandBodyBuilder_ != null) goto L6;
                this.commandBodyBuilder_ = new SingleFieldBuilderV3(getCommandBody(), getParentForChildren(), isClean());
                this.commandBody_ = null;
            L6:
                return this.commandBodyBuilder_;
            }

            private SingleFieldBuilderV3<AvFile.FileUplinkBody, AvFile.FileUplinkBody.Builder, AvFile.FileUplinkBodyOrBuilder> getFileBodyFieldBuilder() {
                if (this.fileBodyBuilder_ != null) goto L6;
                this.fileBodyBuilder_ = new SingleFieldBuilderV3(getFileBody(), getParentForChildren(), isClean());
                this.fileBody_ = null;
            L6:
                return this.fileBodyBuilder_;
            }

            private SingleFieldBuilderV3<VideoUplinkBody, VideoUplinkBody.Builder, VideoUplinkBodyOrBuilder> getVideoBodyFieldBuilder() {
                if (this.videoBodyBuilder_ != null) goto L6;
                this.videoBodyBuilder_ = new SingleFieldBuilderV3(getVideoBody(), getParentForChildren(), isClean());
                this.videoBody_ = null;
            L6:
                return this.videoBodyBuilder_;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UplinkBody buildPartial() {
                UplinkBody r100 = new UplinkBody(this, null);
                SingleFieldBuilderV3<AvAudioUplink.AudioUplinkBody, AvAudioUplink.AudioUplinkBody.Builder, AvAudioUplink.AudioUplinkBodyOrBuilder> r101 = this.audioBodyBuilder_;
                if (r101 != null) goto L5;
                UplinkBody.access$2302(r100, this.audioBody_);
            L6:
                SingleFieldBuilderV3<VideoUplinkBody, VideoUplinkBody.Builder, VideoUplinkBodyOrBuilder> r102 = this.videoBodyBuilder_;
                if (r102 != null) goto L9;
                UplinkBody.access$2402(r100, this.videoBody_);
            L10:
                SingleFieldBuilderV3<CommandUplinkBody, CommandUplinkBody.Builder, CommandUplinkBodyOrBuilder> r103 = this.commandBodyBuilder_;
                if (r103 != null) goto L13;
                UplinkBody.access$2502(r100, this.commandBody_);
            L14:
                SingleFieldBuilderV3<AvFile.FileUplinkBody, AvFile.FileUplinkBody.Builder, AvFile.FileUplinkBodyOrBuilder> r104 = this.fileBodyBuilder_;
                if (r104 != null) goto L17;
                UplinkBody.access$2602(r100, this.fileBody_);
            L18:
                onBuilt();
                return r100;
            L17:
                UplinkBody.access$2602(r100, (AvFile.FileUplinkBody) r104.build());
                goto L18
            L13:
                UplinkBody.access$2502(r100, (CommandUplinkBody) r103.build());
                goto L14
            L9:
                UplinkBody.access$2402(r100, (VideoUplinkBody) r102.build());
                goto L10
            L5:
                UplinkBody.access$2302(r100, (AvAudioUplink.AudioUplinkBody) r101.build());
                goto L6
            }

            public Builder clearAudioBody() {
                if (this.audioBodyBuilder_ != null) goto L5;
                this.audioBody_ = null;
                onChanged();
            L6:
                return this;
            L5:
                this.audioBody_ = null;
                this.audioBodyBuilder_ = null;
                goto L6
            }

            public Builder clearCommandBody() {
                if (this.commandBodyBuilder_ != null) goto L5;
                this.commandBody_ = null;
                onChanged();
            L6:
                return this;
            L5:
                this.commandBody_ = null;
                this.commandBodyBuilder_ = null;
                goto L6
            }

            public Builder clearFileBody() {
                if (this.fileBodyBuilder_ != null) goto L5;
                this.fileBody_ = null;
                onChanged();
            L6:
                return this;
            L5:
                this.fileBody_ = null;
                this.fileBodyBuilder_ = null;
                goto L6
            }

            public Builder clearVideoBody() {
                if (this.videoBodyBuilder_ != null) goto L5;
                this.videoBody_ = null;
                onChanged();
            L6:
                return this;
            L5:
                this.videoBody_ = null;
                this.videoBodyBuilder_ = null;
                goto L6
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
            public AvAudioUplink.AudioUplinkBody getAudioBody() {
                SingleFieldBuilderV3<AvAudioUplink.AudioUplinkBody, AvAudioUplink.AudioUplinkBody.Builder, AvAudioUplink.AudioUplinkBodyOrBuilder> r100 = this.audioBodyBuilder_;
                if (r100 != null) goto L9;
                AvAudioUplink.AudioUplinkBody r101 = this.audioBody_;
                if (r101 == null) goto L7;
                return r101;
            L7:
                return AvAudioUplink.AudioUplinkBody.getDefaultInstance();
            L9:
                return (AvAudioUplink.AudioUplinkBody) r100.getMessage();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
            public AvAudioUplink.AudioUplinkBodyOrBuilder getAudioBodyOrBuilder() {
                SingleFieldBuilderV3<AvAudioUplink.AudioUplinkBody, AvAudioUplink.AudioUplinkBody.Builder, AvAudioUplink.AudioUplinkBodyOrBuilder> r100 = this.audioBodyBuilder_;
                if (r100 != null) goto L5;
                AvAudioUplink.AudioUplinkBody r101 = this.audioBody_;
                if (r101 == null) goto L9;
                return r101;
            L9:
                return AvAudioUplink.AudioUplinkBody.getDefaultInstance();
            L5:
                return (AvAudioUplink.AudioUplinkBodyOrBuilder) r100.getMessageOrBuilder();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
            public CommandUplinkBody getCommandBody() {
                SingleFieldBuilderV3<CommandUplinkBody, CommandUplinkBody.Builder, CommandUplinkBodyOrBuilder> r100 = this.commandBodyBuilder_;
                if (r100 != null) goto L9;
                CommandUplinkBody r101 = this.commandBody_;
                if (r101 == null) goto L7;
                return r101;
            L7:
                return CommandUplinkBody.getDefaultInstance();
            L9:
                return (CommandUplinkBody) r100.getMessage();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
            public CommandUplinkBodyOrBuilder getCommandBodyOrBuilder() {
                SingleFieldBuilderV3<CommandUplinkBody, CommandUplinkBody.Builder, CommandUplinkBodyOrBuilder> r100 = this.commandBodyBuilder_;
                if (r100 != null) goto L5;
                CommandUplinkBody r101 = this.commandBody_;
                if (r101 == null) goto L9;
                return r101;
            L9:
                return CommandUplinkBody.getDefaultInstance();
            L5:
                return (CommandUplinkBodyOrBuilder) r100.getMessageOrBuilder();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
            public AvFile.FileUplinkBody getFileBody() {
                SingleFieldBuilderV3<AvFile.FileUplinkBody, AvFile.FileUplinkBody.Builder, AvFile.FileUplinkBodyOrBuilder> r100 = this.fileBodyBuilder_;
                if (r100 != null) goto L9;
                AvFile.FileUplinkBody r101 = this.fileBody_;
                if (r101 == null) goto L7;
                return r101;
            L7:
                return AvFile.FileUplinkBody.getDefaultInstance();
            L9:
                return (AvFile.FileUplinkBody) r100.getMessage();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
            public AvFile.FileUplinkBodyOrBuilder getFileBodyOrBuilder() {
                SingleFieldBuilderV3<AvFile.FileUplinkBody, AvFile.FileUplinkBody.Builder, AvFile.FileUplinkBodyOrBuilder> r100 = this.fileBodyBuilder_;
                if (r100 != null) goto L5;
                AvFile.FileUplinkBody r101 = this.fileBody_;
                if (r101 == null) goto L9;
                return r101;
            L9:
                return AvFile.FileUplinkBody.getDefaultInstance();
            L5:
                return (AvFile.FileUplinkBodyOrBuilder) r100.getMessageOrBuilder();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
            public VideoUplinkBody getVideoBody() {
                SingleFieldBuilderV3<VideoUplinkBody, VideoUplinkBody.Builder, VideoUplinkBodyOrBuilder> r100 = this.videoBodyBuilder_;
                if (r100 != null) goto L9;
                VideoUplinkBody r101 = this.videoBody_;
                if (r101 == null) goto L7;
                return r101;
            L7:
                return VideoUplinkBody.getDefaultInstance();
            L9:
                return (VideoUplinkBody) r100.getMessage();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
            public VideoUplinkBodyOrBuilder getVideoBodyOrBuilder() {
                SingleFieldBuilderV3<VideoUplinkBody, VideoUplinkBody.Builder, VideoUplinkBodyOrBuilder> r100 = this.videoBodyBuilder_;
                if (r100 != null) goto L5;
                VideoUplinkBody r101 = this.videoBody_;
                if (r101 == null) goto L9;
                return r101;
            L9:
                return VideoUplinkBody.getDefaultInstance();
            L5:
                return (VideoUplinkBodyOrBuilder) r100.getMessageOrBuilder();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
            public boolean hasAudioBody() {
                if (this.audioBodyBuilder_ == null) goto L5;
            L8:
                return true;
            L5:
                if (this.audioBody_ != null) goto L8;
                return false;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
            public boolean hasCommandBody() {
                if (this.commandBodyBuilder_ == null) goto L5;
            L8:
                return true;
            L5:
                if (this.commandBody_ != null) goto L8;
                return false;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
            public boolean hasFileBody() {
                if (this.fileBodyBuilder_ == null) goto L5;
            L8:
                return true;
            L5:
                if (this.fileBody_ != null) goto L8;
                return false;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
            public boolean hasVideoBody() {
                if (this.videoBodyBuilder_ == null) goto L5;
            L8:
                return true;
            L5:
                if (this.videoBody_ != null) goto L8;
                return false;
            }

            private Builder() {
                this.audioBody_ = null;
                this.videoBody_ = null;
                this.commandBody_ = null;
                this.fileBody_ = null;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvUplink.access$1700();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UplinkBody build() {
                UplinkBody r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.audioBodyBuilder_ != null) goto L5;
                this.audioBody_ = null;
            L7:
                if (this.videoBodyBuilder_ != null) goto L9;
                this.videoBody_ = null;
            L11:
                if (this.commandBodyBuilder_ != null) goto L13;
                this.commandBody_ = null;
            L15:
                if (this.fileBodyBuilder_ != null) goto L17;
                this.fileBody_ = null;
            L18:
                return this;
            L17:
                this.fileBody_ = null;
                this.fileBodyBuilder_ = null;
                goto L18
            L13:
                this.commandBody_ = null;
                this.commandBodyBuilder_ = null;
                goto L15
            L9:
                this.videoBody_ = null;
                this.videoBodyBuilder_ = null;
                goto L11
            L5:
                this.audioBody_ = null;
                this.audioBodyBuilder_ = null;
                goto L7
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            public AvAudioUplink.AudioUplinkBody.Builder getAudioBodyBuilder() {
                onChanged();
                return (AvAudioUplink.AudioUplinkBody.Builder) getAudioBodyFieldBuilder().getBuilder();
            }

            public CommandUplinkBody.Builder getCommandBodyBuilder() {
                onChanged();
                return (CommandUplinkBody.Builder) getCommandBodyFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvUplink.access$1700();
            }

            public AvFile.FileUplinkBody.Builder getFileBodyBuilder() {
                onChanged();
                return (AvFile.FileUplinkBody.Builder) getFileBodyFieldBuilder().getBuilder();
            }

            public VideoUplinkBody.Builder getVideoBodyBuilder() {
                onChanged();
                return (VideoUplinkBody.Builder) getVideoBodyFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvUplink.access$1800().ensureFieldAccessorsInitialized(UplinkBody.class, Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                UplinkBody.access$2100();
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
            public UplinkBody getDefaultInstanceForType() {
                return UplinkBody.getDefaultInstance();
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
                this.audioBody_ = null;
                this.videoBody_ = null;
                this.commandBody_ = null;
                this.fileBody_ = null;
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

            public Builder mergeAudioBody(AvAudioUplink.AudioUplinkBody r100) {
                SingleFieldBuilderV3<AvAudioUplink.AudioUplinkBody, AvAudioUplink.AudioUplinkBody.Builder, AvAudioUplink.AudioUplinkBodyOrBuilder> r101 = this.audioBodyBuilder_;
                if (r101 != null) goto L9;
                AvAudioUplink.AudioUplinkBody r102 = this.audioBody_;
                if (r102 == null) goto L7;
                this.audioBody_ = AvAudioUplink.AudioUplinkBody.newBuilder(r102).mergeFrom(r100).buildPartial();
            L8:
                onChanged();
            L10:
                return this;
            L7:
                this.audioBody_ = r100;
                goto L8
            L9:
                r101.mergeFrom(r100);
                goto L10
            }

            public Builder mergeCommandBody(CommandUplinkBody r100) {
                SingleFieldBuilderV3<CommandUplinkBody, CommandUplinkBody.Builder, CommandUplinkBodyOrBuilder> r101 = this.commandBodyBuilder_;
                if (r101 != null) goto L9;
                CommandUplinkBody r102 = this.commandBody_;
                if (r102 == null) goto L7;
                this.commandBody_ = CommandUplinkBody.newBuilder(r102).mergeFrom(r100).buildPartial();
            L8:
                onChanged();
            L10:
                return this;
            L7:
                this.commandBody_ = r100;
                goto L8
            L9:
                r101.mergeFrom(r100);
                goto L10
            }

            public Builder mergeFileBody(AvFile.FileUplinkBody r100) {
                SingleFieldBuilderV3<AvFile.FileUplinkBody, AvFile.FileUplinkBody.Builder, AvFile.FileUplinkBodyOrBuilder> r101 = this.fileBodyBuilder_;
                if (r101 != null) goto L9;
                AvFile.FileUplinkBody r102 = this.fileBody_;
                if (r102 == null) goto L7;
                this.fileBody_ = AvFile.FileUplinkBody.newBuilder(r102).mergeFrom(r100).buildPartial();
            L8:
                onChanged();
            L10:
                return this;
            L7:
                this.fileBody_ = r100;
                goto L8
            L9:
                r101.mergeFrom(r100);
                goto L10
            }

            public Builder mergeFrom(UplinkBody r100) {
                if (r100 != UplinkBody.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasAudioBody() == false) goto L9;
                mergeAudioBody(r100.getAudioBody());
            L9:
                if (r100.hasVideoBody() == false) goto L12;
                mergeVideoBody(r100.getVideoBody());
            L12:
                if (r100.hasCommandBody() == false) goto L15;
                mergeCommandBody(r100.getCommandBody());
            L15:
                if (r100.hasFileBody() == false) goto L17;
                mergeFileBody(r100.getFileBody());
            L17:
                mergeUnknownFields(UplinkBody.access$2700(r100));
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.mergeUnknownFields(r100);
            }

            public Builder mergeVideoBody(VideoUplinkBody r100) {
                SingleFieldBuilderV3<VideoUplinkBody, VideoUplinkBody.Builder, VideoUplinkBodyOrBuilder> r101 = this.videoBodyBuilder_;
                if (r101 != null) goto L9;
                VideoUplinkBody r102 = this.videoBody_;
                if (r102 == null) goto L7;
                this.videoBody_ = VideoUplinkBody.newBuilder(r102).mergeFrom(r100).buildPartial();
            L8:
                onChanged();
            L10:
                return this;
            L7:
                this.videoBody_ = r100;
                goto L8
            L9:
                r101.mergeFrom(r100);
                goto L10
            }

            public Builder setAudioBody(AvAudioUplink.AudioUplinkBody.Builder r100) {
                SingleFieldBuilderV3<AvAudioUplink.AudioUplinkBody, AvAudioUplink.AudioUplinkBody.Builder, AvAudioUplink.AudioUplinkBodyOrBuilder> r101 = this.audioBodyBuilder_;
                if (r101 != null) goto L5;
                this.audioBody_ = r100.build();
                onChanged();
            L6:
                return this;
            L5:
                r101.setMessage(r100.build());
                goto L6
            }

            public Builder setCommandBody(CommandUplinkBody.Builder r100) {
                SingleFieldBuilderV3<CommandUplinkBody, CommandUplinkBody.Builder, CommandUplinkBodyOrBuilder> r101 = this.commandBodyBuilder_;
                if (r101 != null) goto L5;
                this.commandBody_ = r100.build();
                onChanged();
            L6:
                return this;
            L5:
                r101.setMessage(r100.build());
                goto L6
            }

            public Builder setFileBody(AvFile.FileUplinkBody.Builder r100) {
                SingleFieldBuilderV3<AvFile.FileUplinkBody, AvFile.FileUplinkBody.Builder, AvFile.FileUplinkBodyOrBuilder> r101 = this.fileBodyBuilder_;
                if (r101 != null) goto L5;
                this.fileBody_ = r100.build();
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

            public Builder setVideoBody(VideoUplinkBody.Builder r100) {
                SingleFieldBuilderV3<VideoUplinkBody, VideoUplinkBody.Builder, VideoUplinkBodyOrBuilder> r101 = this.videoBodyBuilder_;
                if (r101 != null) goto L5;
                this.videoBody_ = r100.build();
                onChanged();
            L6:
                return this;
            L5:
                r101.setMessage(r100.build());
                goto L6
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
                if ((r100 instanceof UplinkBody) == true) goto L5;
                super.mergeFrom(r100);
                return this;
            L5:
                return mergeFrom((UplinkBody) r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            public Builder setAudioBody(AvAudioUplink.AudioUplinkBody r100) {
                SingleFieldBuilderV3<AvAudioUplink.AudioUplinkBody, AvAudioUplink.AudioUplinkBody.Builder, AvAudioUplink.AudioUplinkBodyOrBuilder> r101 = this.audioBodyBuilder_;
                if (r101 != null) goto L8;
                if (r100 == null) goto L7;
                this.audioBody_ = r100;
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r101.setMessage(r100);
                goto L9
            }

            public Builder setCommandBody(CommandUplinkBody r100) {
                SingleFieldBuilderV3<CommandUplinkBody, CommandUplinkBody.Builder, CommandUplinkBodyOrBuilder> r101 = this.commandBodyBuilder_;
                if (r101 != null) goto L8;
                if (r100 == null) goto L7;
                this.commandBody_ = r100;
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r101.setMessage(r100);
                goto L9
            }

            public Builder setFileBody(AvFile.FileUplinkBody r100) {
                SingleFieldBuilderV3<AvFile.FileUplinkBody, AvFile.FileUplinkBody.Builder, AvFile.FileUplinkBodyOrBuilder> r101 = this.fileBodyBuilder_;
                if (r101 != null) goto L8;
                if (r100 == null) goto L7;
                this.fileBody_ = r100;
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

            public Builder setVideoBody(VideoUplinkBody r100) {
                SingleFieldBuilderV3<VideoUplinkBody, VideoUplinkBody.Builder, VideoUplinkBodyOrBuilder> r101 = this.videoBodyBuilder_;
                if (r101 != null) goto L8;
                if (r100 == null) goto L7;
                this.videoBody_ = r100;
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
                UplinkBody r102 = null;
                UplinkBody r103 = (UplinkBody) UplinkBody.access$2800().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
                UplinkBody r104 = (UplinkBody) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            DEFAULT_INSTANCE = new UplinkBody();
            PARSER = new AnonymousClass1();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
        public AvAudioUplink.AudioUplinkBody getAudioBody() {
            AvAudioUplink.AudioUplinkBody r100 = this.audioBody_;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return AvAudioUplink.AudioUplinkBody.getDefaultInstance();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
        public CommandUplinkBody getCommandBody() {
            CommandUplinkBody r100 = this.commandBody_;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return CommandUplinkBody.getDefaultInstance();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
        public AvFile.FileUplinkBody getFileBody() {
            AvFile.FileUplinkBody r100 = this.fileBody_;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return AvFile.FileUplinkBody.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if (this.audioBody_ == null) goto L9;
            r101 = 0 + CodedOutputStream.computeMessageSize(1, getAudioBody());
        L9:
            if (this.videoBody_ == null) goto L12;
            r101 = r101 + CodedOutputStream.computeMessageSize(2, getVideoBody());
        L12:
            if (this.commandBody_ == null) goto L15;
            r101 = r101 + CodedOutputStream.computeMessageSize(3, getCommandBody());
        L15:
            if (this.fileBody_ == null) goto L17;
            r101 = r101 + CodedOutputStream.computeMessageSize(4, getFileBody());
        L17:
            int r102 = r101 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r102;
            return r102;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
        public VideoUplinkBody getVideoBody() {
            VideoUplinkBody r100 = this.videoBody_;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return VideoUplinkBody.getDefaultInstance();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
        public boolean hasAudioBody() {
            if (this.audioBody_ == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
        public boolean hasCommandBody() {
            if (this.commandBody_ == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
        public boolean hasFileBody() {
            if (this.fileBody_ == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
        public boolean hasVideoBody() {
            if (this.videoBody_ == null) goto L5;
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
            int r101 = 779 + getDescriptor().hashCode();
            if (hasAudioBody() == false) goto L9;
            r101 = (((r101 * 37) + 1) * 53) + getAudioBody().hashCode();
        L9:
            if (hasVideoBody() == false) goto L12;
            r101 = (((r101 * 37) + 2) * 53) + getVideoBody().hashCode();
        L12:
            if (hasCommandBody() == false) goto L15;
            r101 = (((r101 * 37) + 3) * 53) + getCommandBody().hashCode();
        L15:
            if (hasFileBody() == false) goto L17;
            r101 = (((r101 * 37) + 4) * 53) + getFileBody().hashCode();
        L17:
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

        private UplinkBody() {
            this.memoizedIsInitialized = -1;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvUplink.access$1700();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
        public AvAudioUplink.AudioUplinkBodyOrBuilder getAudioBodyOrBuilder() {
            return getAudioBody();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
        public CommandUplinkBodyOrBuilder getCommandBodyOrBuilder() {
            return getCommandBody();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
        public AvFile.FileUplinkBodyOrBuilder getFileBodyOrBuilder() {
            return getFileBody();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkBodyOrBuilder
        public VideoUplinkBodyOrBuilder getVideoBodyOrBuilder() {
            return getVideoBody();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvUplink.access$1800().ensureFieldAccessorsInitialized(UplinkBody.class, Builder.class);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static /* synthetic */ boolean access$2100() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ Parser access$2800() {
            return PARSER;
        }

        public static UplinkBody getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UplinkBody> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UplinkBody> getParserForType() {
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
        public UplinkBody getDefaultInstanceForType() {
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

        private UplinkBody(GeneratedMessageV3.Builder<?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ UnknownFieldSet access$2700(UplinkBody r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(UplinkBody r100) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
        }

        public static UplinkBody parseDelimitedFrom(InputStream r100) throws IOException {
            return (UplinkBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
        }

        public static UplinkBody parseFrom(ByteString r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof UplinkBody) == false) goto L8;
            UplinkBody r101 = (UplinkBody) r100;
            if (hasAudioBody() != r101.hasAudioBody()) goto L12;
            boolean r102 = true;
        L14:
            if (hasAudioBody() == false) goto L20;
            if (r102 == true) goto L17;
        L19:
            r102 = false;
            goto L20
        L17:
            if (getAudioBody().equals(r101.getAudioBody()) == false) goto L19;
            r102 = true;
        L20:
            if (r102 == true) goto L22;
        L24:
            boolean r103 = false;
        L26:
            if (hasVideoBody() == false) goto L32;
            if (r103 == true) goto L29;
        L31:
            r103 = false;
            goto L32
        L29:
            if (getVideoBody().equals(r101.getVideoBody()) == false) goto L31;
            r103 = true;
        L32:
            if (r103 == true) goto L34;
        L36:
            boolean r104 = false;
        L38:
            if (hasCommandBody() == false) goto L44;
            if (r104 == true) goto L41;
        L43:
            r104 = false;
            goto L44
        L41:
            if (getCommandBody().equals(r101.getCommandBody()) == false) goto L43;
            r104 = true;
        L44:
            if (r104 == true) goto L46;
        L48:
            boolean r105 = false;
        L50:
            if (hasFileBody() == false) goto L56;
            if (r105 == true) goto L53;
        L55:
            r105 = false;
            goto L56
        L53:
            if (getFileBody().equals(r101.getFileBody()) == false) goto L55;
            r105 = true;
        L56:
            if (r105 == true) goto L58;
        L60:
            return false;
        L58:
            if (this.unknownFields.equals(r101.unknownFields) == false) goto L60;
            return true;
        L46:
            if (hasFileBody() != r101.hasFileBody()) goto L48;
            r105 = true;
            goto L50
        L34:
            if (hasCommandBody() != r101.hasCommandBody()) goto L36;
            r104 = true;
            goto L38
        L22:
            if (hasVideoBody() != r101.hasVideoBody()) goto L24;
            r103 = true;
            goto L26
        L12:
            r102 = false;
            goto L14
        L8:
            return super.equals(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return new Builder(r100, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            if (this.audioBody_ == null) goto L6;
            r100.writeMessage(1, getAudioBody());
        L6:
            if (this.videoBody_ == null) goto L9;
            r100.writeMessage(2, getVideoBody());
        L9:
            if (this.commandBody_ == null) goto L12;
            r100.writeMessage(3, getCommandBody());
        L12:
            if (this.fileBody_ == null) goto L14;
            r100.writeMessage(4, getFileBody());
        L14:
            this.unknownFields.writeTo(r100);
        }

        public static UplinkBody parseFrom(CodedInputStream r100) throws IOException {
            return (UplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return newBuilderForType(r100);
        }

        public static UplinkBody parseFrom(InputStream r100) throws IOException {
            return (UplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        public static UplinkBody parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        public static UplinkBody parseFrom(byte[] r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        private UplinkBody(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this();
            if (r101 == null) goto L61;
            UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
            boolean r103 = false;
        L5:
            if (r103 == true) goto L59;
            int r104 = r100.readTag();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r104 == 0) goto L48;
            if (r104 != 10) goto L11;
            AvAudioUplink.AudioUplinkBody r105 = this.audioBody_;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r105 == null) goto L43;
            AvAudioUplink.AudioUplinkBody.Builder r106 = r105.toBuilder();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L44:
            AvAudioUplink.AudioUplinkBody r107 = (AvAudioUplink.AudioUplinkBody) r100.readMessage(AvAudioUplink.AudioUplinkBody.parser(), r101);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.audioBody_ = r107;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r106 == null) goto L5;
            r106.mergeFrom(r107);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.audioBody_ = r106.buildPartial();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L5
        L43:
            r106 = null;
            goto L44
        L11:
            if (r104 != 18) goto L13;
            VideoUplinkBody r108 = this.videoBody_;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r108 == null) goto L36;
            VideoUplinkBody.Builder r109 = r108.toBuilder();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L37:
            VideoUplinkBody r110 = (VideoUplinkBody) r100.readMessage(VideoUplinkBody.parser(), r101);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.videoBody_ = r110;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r109 == null) goto L5;
            r109.mergeFrom(r110);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.videoBody_ = r109.buildPartial();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L5
        L36:
            r109 = null;
            goto L37
        L13:
            if (r104 != 26) goto L15;
            CommandUplinkBody r111 = this.commandBody_;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r111 == null) goto L29;
            CommandUplinkBody.Builder r112 = r111.toBuilder();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L30:
            CommandUplinkBody r113 = (CommandUplinkBody) r100.readMessage(CommandUplinkBody.parser(), r101);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.commandBody_ = r113;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r112 == null) goto L5;
            r112.mergeFrom(r113);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.commandBody_ = r112.buildPartial();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L5
        L29:
            r112 = null;
            goto L30
        L15:
            if (r104 != 34) goto L17;
            AvFile.FileUplinkBody r114 = this.fileBody_;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r114 == null) goto L22;
            AvFile.FileUplinkBody.Builder r115 = r114.toBuilder();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L23:
            AvFile.FileUplinkBody r116 = (AvFile.FileUplinkBody) r100.readMessage(AvFile.FileUplinkBody.parser(), r101);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.fileBody_ = r116;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r115 == null) goto L5;
            r115.mergeFrom(r116);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.fileBody_ = r115.buildPartial();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L5
        L22:
            r115 = null;
            goto L23
        L17:
            if (parseUnknownFieldProto3(r100, r102, r101, r104) == true) goto L5;
        L48:
            r103 = true;
            goto L5
        L49:
            th = move-exception;
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            throw th;
        L54:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L49
        L51:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L49
        L59:
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            return;
        L61:
            throw null;
        }

        public static /* synthetic */ AvAudioUplink.AudioUplinkBody access$2302(UplinkBody r100, AvAudioUplink.AudioUplinkBody r101) {
            r100.audioBody_ = r101;
            return r101;
        }

        public static /* synthetic */ VideoUplinkBody access$2402(UplinkBody r100, VideoUplinkBody r101) {
            r100.videoBody_ = r101;
            return r101;
        }

        public static /* synthetic */ CommandUplinkBody access$2502(UplinkBody r100, CommandUplinkBody r101) {
            r100.commandBody_ = r101;
            return r101;
        }

        public static /* synthetic */ AvFile.FileUplinkBody access$2602(UplinkBody r100, AvFile.FileUplinkBody r101) {
            r100.fileBody_ = r101;
            return r101;
        }

        public static UplinkBody parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (UplinkBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
        }

        public static UplinkBody parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ UplinkBody(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static UplinkBody parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (UplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static UplinkBody parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (UplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static UplinkBody parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public static UplinkBody parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ UplinkBody(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface UplinkBodyOrBuilder extends MessageOrBuilder {
        AvAudioUplink.AudioUplinkBody getAudioBody();

        AvAudioUplink.AudioUplinkBodyOrBuilder getAudioBodyOrBuilder();

        CommandUplinkBody getCommandBody();

        CommandUplinkBodyOrBuilder getCommandBodyOrBuilder();

        AvFile.FileUplinkBody getFileBody();

        AvFile.FileUplinkBodyOrBuilder getFileBodyOrBuilder();

        VideoUplinkBody getVideoBody();

        VideoUplinkBodyOrBuilder getVideoBodyOrBuilder();

        boolean hasAudioBody();

        boolean hasCommandBody();

        boolean hasFileBody();

        boolean hasVideoBody();
    }

    public static final class UplinkMessage extends GeneratedMessageV3 implements UplinkMessageOrBuilder {
        public static final int COMMAND_EVENT_FIELD_NUMBER = 4;
        private static final UplinkMessage DEFAULT_INSTANCE = null;
        public static final int EVENT_FIELD_NUMBER = 1;
        private static final Parser<UplinkMessage> PARSER = null;
        public static final int SEQUENCE_ID_FIELD_NUMBER = 5;
        public static final int SPEECH_EVENT_FIELD_NUMBER = 2;
        public static final int UPLINK_BODY_FIELD_NUMBER = 6;
        public static final int VIDEO_EVENT_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int commandEvent_;
        private int event_;
        private byte memoizedIsInitialized;
        private volatile Object sequenceId_;
        private volatile Object speechEvent_;
        private UplinkBody uplinkBody_;
        private int videoEvent_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UplinkMessageOrBuilder {
            private int commandEvent_;
            private int event_;
            private Object sequenceId_;
            private Object speechEvent_;
            private SingleFieldBuilderV3<UplinkBody, UplinkBody.Builder, UplinkBodyOrBuilder> uplinkBodyBuilder_;
            private UplinkBody uplinkBody_;
            private int videoEvent_;

            public Builder clearCommandEvent() {
                this.commandEvent_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVideoEvent() {
                this.videoEvent_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private SingleFieldBuilderV3<UplinkBody, UplinkBody.Builder, UplinkBodyOrBuilder> getUplinkBodyFieldBuilder() {
                if (this.uplinkBodyBuilder_ != null) goto L6;
                this.uplinkBodyBuilder_ = new SingleFieldBuilderV3(getUplinkBody(), getParentForChildren(), isClean());
                this.uplinkBody_ = null;
            L6:
                return this.uplinkBodyBuilder_;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UplinkMessage buildPartial() {
                UplinkMessage r100 = new UplinkMessage(this, null);
                UplinkMessage.access$602(r100, this.event_);
                UplinkMessage.access$702(r100, this.speechEvent_);
                UplinkMessage.access$802(r100, this.videoEvent_);
                UplinkMessage.access$902(r100, this.commandEvent_);
                UplinkMessage.access$1002(r100, this.sequenceId_);
                SingleFieldBuilderV3<UplinkBody, UplinkBody.Builder, UplinkBodyOrBuilder> r101 = this.uplinkBodyBuilder_;
                if (r101 != null) goto L5;
                UplinkMessage.access$1102(r100, this.uplinkBody_);
            L6:
                onBuilt();
                return r100;
            L5:
                UplinkMessage.access$1102(r100, (UplinkBody) r101.build());
                goto L6
            }

            public Builder clearUplinkBody() {
                if (this.uplinkBodyBuilder_ != null) goto L5;
                this.uplinkBody_ = null;
                onChanged();
            L6:
                return this;
            L5:
                this.uplinkBody_ = null;
                this.uplinkBodyBuilder_ = null;
                goto L6
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
            public AvCmd.CommandEventType getCommandEvent() {
                AvCmd.CommandEventType r100 = AvCmd.CommandEventType.valueOf(this.commandEvent_);
                if (r100 == null) goto L5;
                return r100;
            L5:
                return AvCmd.CommandEventType.UNRECOGNIZED;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
            public AvCmd.AVCMD getEvent() {
                AvCmd.AVCMD r100 = AvCmd.AVCMD.valueOf(this.event_);
                if (r100 == null) goto L5;
                return r100;
            L5:
                return AvCmd.AVCMD.UNRECOGNIZED;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
            public String getSequenceId() {
                Object r100 = this.sequenceId_;
                if ((r100 instanceof String) == true) goto L7;
                String r101 = ((ByteString) r100).toStringUtf8();
                this.sequenceId_ = r101;
                return r101;
            L7:
                return (String) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
            public ByteString getSequenceIdBytes() {
                Object r100 = this.sequenceId_;
                if ((r100 instanceof String) == false) goto L7;
                ByteString r101 = ByteString.copyFromUtf8((String) r100);
                this.sequenceId_ = r101;
                return r101;
            L7:
                return (ByteString) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
            public String getSpeechEvent() {
                Object r100 = this.speechEvent_;
                if ((r100 instanceof String) == true) goto L7;
                String r101 = ((ByteString) r100).toStringUtf8();
                this.speechEvent_ = r101;
                return r101;
            L7:
                return (String) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
            public ByteString getSpeechEventBytes() {
                Object r100 = this.speechEvent_;
                if ((r100 instanceof String) == false) goto L7;
                ByteString r101 = ByteString.copyFromUtf8((String) r100);
                this.speechEvent_ = r101;
                return r101;
            L7:
                return (ByteString) r100;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
            public UplinkBody getUplinkBody() {
                SingleFieldBuilderV3<UplinkBody, UplinkBody.Builder, UplinkBodyOrBuilder> r100 = this.uplinkBodyBuilder_;
                if (r100 != null) goto L9;
                UplinkBody r101 = this.uplinkBody_;
                if (r101 == null) goto L7;
                return r101;
            L7:
                return UplinkBody.getDefaultInstance();
            L9:
                return (UplinkBody) r100.getMessage();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
            public UplinkBodyOrBuilder getUplinkBodyOrBuilder() {
                SingleFieldBuilderV3<UplinkBody, UplinkBody.Builder, UplinkBodyOrBuilder> r100 = this.uplinkBodyBuilder_;
                if (r100 != null) goto L5;
                UplinkBody r101 = this.uplinkBody_;
                if (r101 == null) goto L9;
                return r101;
            L9:
                return UplinkBody.getDefaultInstance();
            L5:
                return (UplinkBodyOrBuilder) r100.getMessageOrBuilder();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
            public AvCmd.CommandEventType getVideoEvent() {
                AvCmd.CommandEventType r100 = AvCmd.CommandEventType.valueOf(this.videoEvent_);
                if (r100 == null) goto L5;
                return r100;
            L5:
                return AvCmd.CommandEventType.UNRECOGNIZED;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
            public boolean hasUplinkBody() {
                if (this.uplinkBodyBuilder_ == null) goto L5;
            L8:
                return true;
            L5:
                if (this.uplinkBody_ != null) goto L8;
                return false;
            }

            private Builder() {
                this.event_ = 0;
                this.speechEvent_ = "";
                this.videoEvent_ = 0;
                this.commandEvent_ = 0;
                this.sequenceId_ = "";
                this.uplinkBody_ = null;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvUplink.access$000();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UplinkMessage build() {
                UplinkMessage r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.speechEvent_ = "";
                this.videoEvent_ = 0;
                this.commandEvent_ = 0;
                this.sequenceId_ = "";
                if (this.uplinkBodyBuilder_ != null) goto L5;
                this.uplinkBody_ = null;
            L6:
                return this;
            L5:
                this.uplinkBody_ = null;
                this.uplinkBodyBuilder_ = null;
                goto L6
            }

            public Builder clearSequenceId() {
                this.sequenceId_ = UplinkMessage.getDefaultInstance().getSequenceId();
                onChanged();
                return this;
            }

            public Builder clearSpeechEvent() {
                this.speechEvent_ = UplinkMessage.getDefaultInstance().getSpeechEvent();
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
                return AvUplink.access$000();
            }

            public UplinkBody.Builder getUplinkBodyBuilder() {
                onChanged();
                return (UplinkBody.Builder) getUplinkBodyFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvUplink.access$100().ensureFieldAccessorsInitialized(UplinkMessage.class, Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                UplinkMessage.access$400();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
            public int getCommandEventValue() {
                return this.commandEvent_;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
            public int getVideoEventValue() {
                return this.videoEvent_;
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
            public UplinkMessage getDefaultInstanceForType() {
                return UplinkMessage.getDefaultInstance();
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
                this.event_ = 0;
                this.speechEvent_ = "";
                this.videoEvent_ = 0;
                this.commandEvent_ = 0;
                this.sequenceId_ = "";
                this.uplinkBody_ = null;
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

            public Builder mergeFrom(UplinkMessage r100) {
                if (r100 != UplinkMessage.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (UplinkMessage.access$600(r100) == 0) goto L9;
                setEventValue(r100.getEventValue());
            L9:
                if (r100.getSpeechEvent().isEmpty() == true) goto L12;
                this.speechEvent_ = UplinkMessage.access$700(r100);
                onChanged();
            L12:
                if (UplinkMessage.access$800(r100) == 0) goto L15;
                setVideoEventValue(r100.getVideoEventValue());
            L15:
                if (UplinkMessage.access$900(r100) == 0) goto L18;
                setCommandEventValue(r100.getCommandEventValue());
            L18:
                if (r100.getSequenceId().isEmpty() == true) goto L21;
                this.sequenceId_ = UplinkMessage.access$1000(r100);
                onChanged();
            L21:
                if (r100.hasUplinkBody() == false) goto L23;
                mergeUplinkBody(r100.getUplinkBody());
            L23:
                mergeUnknownFields(UplinkMessage.access$1200(r100));
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.mergeUnknownFields(r100);
            }

            public Builder mergeUplinkBody(UplinkBody r100) {
                SingleFieldBuilderV3<UplinkBody, UplinkBody.Builder, UplinkBodyOrBuilder> r101 = this.uplinkBodyBuilder_;
                if (r101 != null) goto L9;
                UplinkBody r102 = this.uplinkBody_;
                if (r102 == null) goto L7;
                this.uplinkBody_ = UplinkBody.newBuilder(r102).mergeFrom(r100).buildPartial();
            L8:
                onChanged();
            L10:
                return this;
            L7:
                this.uplinkBody_ = r100;
                goto L8
            L9:
                r101.mergeFrom(r100);
                goto L10
            }

            public Builder setCommandEvent(AvCmd.CommandEventType r100) {
                if (r100 == null) goto L6;
                this.commandEvent_ = r100.getNumber();
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setCommandEventValue(int r100) {
                this.commandEvent_ = r100;
                onChanged();
                return this;
            }

            public Builder setEvent(AvCmd.AVCMD r100) {
                if (r100 == null) goto L6;
                this.event_ = r100.getNumber();
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventValue(int r100) {
                this.event_ = r100;
                onChanged();
                return this;
            }

            public Builder setSequenceId(String r100) {
                if (r100 == null) goto L6;
                this.sequenceId_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setSequenceIdBytes(ByteString r100) {
                if (r100 == null) goto L6;
                UplinkMessage.access$1500(r100);
                this.sequenceId_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setSpeechEvent(String r100) {
                if (r100 == null) goto L6;
                this.speechEvent_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setSpeechEventBytes(ByteString r100) {
                if (r100 == null) goto L6;
                UplinkMessage.access$1400(r100);
                this.speechEvent_ = r100;
                onChanged();
                return this;
            L6:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.setUnknownFieldsProto3(r100);
            }

            public Builder setUplinkBody(UplinkBody.Builder r100) {
                SingleFieldBuilderV3<UplinkBody, UplinkBody.Builder, UplinkBodyOrBuilder> r101 = this.uplinkBodyBuilder_;
                if (r101 != null) goto L5;
                this.uplinkBody_ = r100.build();
                onChanged();
            L6:
                return this;
            L5:
                r101.setMessage(r100.build());
                goto L6
            }

            public Builder setVideoEvent(AvCmd.CommandEventType r100) {
                if (r100 == null) goto L6;
                this.videoEvent_ = r100.getNumber();
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setVideoEventValue(int r100) {
                this.videoEvent_ = r100;
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
                if ((r100 instanceof UplinkMessage) == true) goto L5;
                super.mergeFrom(r100);
                return this;
            L5:
                return mergeFrom((UplinkMessage) r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r100) {
                return setUnknownFields(r100);
            }

            public Builder setUplinkBody(UplinkBody r100) {
                SingleFieldBuilderV3<UplinkBody, UplinkBody.Builder, UplinkBodyOrBuilder> r101 = this.uplinkBodyBuilder_;
                if (r101 != null) goto L8;
                if (r100 == null) goto L7;
                this.uplinkBody_ = r100;
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
                UplinkMessage r102 = null;
                UplinkMessage r103 = (UplinkMessage) UplinkMessage.access$1300().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
                UplinkMessage r104 = (UplinkMessage) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            DEFAULT_INSTANCE = new UplinkMessage();
            PARSER = new AnonymousClass1();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
        public AvCmd.CommandEventType getCommandEvent() {
            AvCmd.CommandEventType r100 = AvCmd.CommandEventType.valueOf(this.commandEvent_);
            if (r100 == null) goto L5;
            return r100;
        L5:
            return AvCmd.CommandEventType.UNRECOGNIZED;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
        public AvCmd.AVCMD getEvent() {
            AvCmd.AVCMD r100 = AvCmd.AVCMD.valueOf(this.event_);
            if (r100 == null) goto L5;
            return r100;
        L5:
            return AvCmd.AVCMD.UNRECOGNIZED;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
        public String getSequenceId() {
            Object r100 = this.sequenceId_;
            if ((r100 instanceof String) == true) goto L5;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.sequenceId_ = r101;
            return r101;
        L5:
            return (String) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
        public ByteString getSequenceIdBytes() {
            Object r100 = this.sequenceId_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.sequenceId_ = r101;
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
            int r101 = 0;
            if (this.event_ == AvCmd.AVCMD.UNUSED.getNumber()) goto L9;
            r101 = 0 + CodedOutputStream.computeEnumSize(1, this.event_);
        L9:
            if (getSpeechEventBytes().isEmpty() == true) goto L11;
            r101 = r101 + GeneratedMessageV3.computeStringSize(2, this.speechEvent_);
        L11:
            int r102 = this.videoEvent_;
            AvCmd.CommandEventType r103 = AvCmd.CommandEventType.COMMON_UNUSED;
            if (r102 == r103.getNumber()) goto L15;
            r101 = r101 + CodedOutputStream.computeEnumSize(3, this.videoEvent_);
        L15:
            if (this.commandEvent_ == r103.getNumber()) goto L18;
            r101 = r101 + CodedOutputStream.computeEnumSize(4, this.commandEvent_);
        L18:
            if (getSequenceIdBytes().isEmpty() == true) goto L21;
            r101 = r101 + GeneratedMessageV3.computeStringSize(5, this.sequenceId_);
        L21:
            if (this.uplinkBody_ == null) goto L23;
            r101 = r101 + CodedOutputStream.computeMessageSize(6, getUplinkBody());
        L23:
            int r104 = r101 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r104;
            return r104;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
        public String getSpeechEvent() {
            Object r100 = this.speechEvent_;
            if ((r100 instanceof String) == true) goto L5;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.speechEvent_ = r101;
            return r101;
        L5:
            return (String) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
        public ByteString getSpeechEventBytes() {
            Object r100 = this.speechEvent_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.speechEvent_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
        public UplinkBody getUplinkBody() {
            UplinkBody r100 = this.uplinkBody_;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return UplinkBody.getDefaultInstance();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
        public AvCmd.CommandEventType getVideoEvent() {
            AvCmd.CommandEventType r100 = AvCmd.CommandEventType.valueOf(this.videoEvent_);
            if (r100 == null) goto L5;
            return r100;
        L5:
            return AvCmd.CommandEventType.UNRECOGNIZED;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
        public boolean hasUplinkBody() {
            if (this.uplinkBody_ == null) goto L5;
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
            int r101 = ((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + getSpeechEvent().hashCode()) * 37) + 3) * 53) + this.videoEvent_) * 37) + 4) * 53) + this.commandEvent_) * 37) + 5) * 53) + getSequenceId().hashCode();
            if (hasUplinkBody() == false) goto L8;
            r101 = (((r101 * 37) + 6) * 53) + getUplinkBody().hashCode();
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

        private UplinkMessage() {
            this.memoizedIsInitialized = -1;
            this.event_ = 0;
            this.speechEvent_ = "";
            this.videoEvent_ = 0;
            this.commandEvent_ = 0;
            this.sequenceId_ = "";
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvUplink.access$000();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
        public UplinkBodyOrBuilder getUplinkBodyOrBuilder() {
            return getUplinkBody();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvUplink.access$100().ensureFieldAccessorsInitialized(UplinkMessage.class, Builder.class);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static /* synthetic */ Parser access$1300() {
            return PARSER;
        }

        public static /* synthetic */ boolean access$400() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static UplinkMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UplinkMessage> parser() {
            return PARSER;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
        public int getCommandEventValue() {
            return this.commandEvent_;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UplinkMessage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.UplinkMessageOrBuilder
        public int getVideoEventValue() {
            return this.videoEvent_;
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
        public UplinkMessage getDefaultInstanceForType() {
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

        private UplinkMessage(GeneratedMessageV3.Builder<?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ Object access$1000(UplinkMessage r100) {
            return r100.sequenceId_;
        }

        public static /* synthetic */ UnknownFieldSet access$1200(UplinkMessage r100) {
            return r100.unknownFields;
        }

        public static /* synthetic */ void access$1400(ByteString r100) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(r100);
        }

        public static /* synthetic */ void access$1500(ByteString r100) throws IllegalArgumentException {
            AbstractMessageLite.checkByteStringIsUtf8(r100);
        }

        public static /* synthetic */ int access$600(UplinkMessage r100) {
            return r100.event_;
        }

        public static /* synthetic */ Object access$700(UplinkMessage r100) {
            return r100.speechEvent_;
        }

        public static /* synthetic */ int access$800(UplinkMessage r100) {
            return r100.videoEvent_;
        }

        public static /* synthetic */ int access$900(UplinkMessage r100) {
            return r100.commandEvent_;
        }

        public static Builder newBuilder(UplinkMessage r100) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
        }

        public static UplinkMessage parseDelimitedFrom(InputStream r100) throws IOException {
            return (UplinkMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
        }

        public static UplinkMessage parseFrom(ByteString r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof UplinkMessage) == false) goto L8;
            UplinkMessage r101 = (UplinkMessage) r100;
            if (this.event_ != r101.event_) goto L12;
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
            if (hasUplinkBody() == false) goto L45;
            if (r107 == true) goto L42;
        L44:
            r107 = false;
            goto L45
        L42:
            if (getUplinkBody().equals(r101.getUplinkBody()) == false) goto L44;
            r107 = true;
        L45:
            if (r107 == true) goto L47;
        L49:
            return false;
        L47:
            if (this.unknownFields.equals(r101.unknownFields) == false) goto L49;
            return true;
        L35:
            if (hasUplinkBody() != r101.hasUplinkBody()) goto L37;
            r107 = true;
            goto L39
        L30:
            if (getSequenceId().equals(r101.getSequenceId()) == false) goto L32;
            r106 = true;
            goto L33
        L25:
            if (this.commandEvent_ != r101.commandEvent_) goto L27;
            r105 = true;
            goto L28
        L20:
            if (this.videoEvent_ != r101.videoEvent_) goto L22;
            r104 = true;
            goto L23
        L15:
            if (getSpeechEvent().equals(r101.getSpeechEvent()) == false) goto L17;
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
            if (this.event_ == AvCmd.AVCMD.UNUSED.getNumber()) goto L6;
            r100.writeEnum(1, this.event_);
        L6:
            if (getSpeechEventBytes().isEmpty() == true) goto L8;
            GeneratedMessageV3.writeString(r100, 2, this.speechEvent_);
        L8:
            int r101 = this.videoEvent_;
            AvCmd.CommandEventType r102 = AvCmd.CommandEventType.COMMON_UNUSED;
            if (r101 == r102.getNumber()) goto L12;
            r100.writeEnum(3, this.videoEvent_);
        L12:
            if (this.commandEvent_ == r102.getNumber()) goto L15;
            r100.writeEnum(4, this.commandEvent_);
        L15:
            if (getSequenceIdBytes().isEmpty() == true) goto L18;
            GeneratedMessageV3.writeString(r100, 5, this.sequenceId_);
        L18:
            if (this.uplinkBody_ == null) goto L20;
            r100.writeMessage(6, getUplinkBody());
        L20:
            this.unknownFields.writeTo(r100);
        }

        public static UplinkMessage parseFrom(CodedInputStream r100) throws IOException {
            return (UplinkMessage) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return newBuilderForType(r100);
        }

        public static UplinkMessage parseFrom(InputStream r100) throws IOException {
            return (UplinkMessage) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        public static UplinkMessage parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        public static UplinkMessage parseFrom(byte[] r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        private UplinkMessage(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this();
            if (r101 == null) goto L49;
            UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
            boolean r103 = false;
        L5:
            if (r103 == true) goto L47;
            int r104 = r100.readTag();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            if (r104 == 0) goto L36;
            if (r104 != 8) goto L11;
            this.event_ = r100.readEnum();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            goto L5
        L11:
            if (r104 != 18) goto L13;
            this.speechEvent_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            goto L5
        L13:
            if (r104 != 24) goto L15;
            this.videoEvent_ = r100.readEnum();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            goto L5
        L15:
            if (r104 != 32) goto L17;
            this.commandEvent_ = r100.readEnum();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            goto L5
        L17:
            if (r104 != 42) goto L19;
            this.sequenceId_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            goto L5
        L19:
            if (r104 != 50) goto L21;
            UplinkBody r105 = this.uplinkBody_;     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            if (r105 == null) goto L26;
            UplinkBody.Builder r106 = r105.toBuilder();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
        L27:
            UplinkBody r107 = (UplinkBody) r100.readMessage(UplinkBody.parser(), r101);     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            this.uplinkBody_ = r107;     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            if (r106 == null) goto L5;
            r106.mergeFrom(r107);     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            this.uplinkBody_ = r106.buildPartial();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            goto L5
        L26:
            r106 = null;
            goto L27
        L21:
            if (parseUnknownFieldProto3(r100, r102, r101, r104) == true) goto L5;
        L36:
            r103 = true;
            goto L5
        L37:
            th = move-exception;
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            throw th;
        L42:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L37
        L39:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L37
        L47:
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            return;
        L49:
            throw null;
        }

        public static /* synthetic */ Object access$1002(UplinkMessage r100, Object r101) {
            r100.sequenceId_ = r101;
            return r101;
        }

        public static /* synthetic */ UplinkBody access$1102(UplinkMessage r100, UplinkBody r101) {
            r100.uplinkBody_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$602(UplinkMessage r100, int r101) {
            r100.event_ = r101;
            return r101;
        }

        public static /* synthetic */ Object access$702(UplinkMessage r100, Object r101) {
            r100.speechEvent_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$802(UplinkMessage r100, int r101) {
            r100.videoEvent_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$902(UplinkMessage r100, int r101) {
            r100.commandEvent_ = r101;
            return r101;
        }

        public static UplinkMessage parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (UplinkMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
        }

        public static UplinkMessage parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ UplinkMessage(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static UplinkMessage parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (UplinkMessage) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static UplinkMessage parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (UplinkMessage) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static UplinkMessage parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public static UplinkMessage parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ UplinkMessage(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface UplinkMessageOrBuilder extends MessageOrBuilder {
        AvCmd.CommandEventType getCommandEvent();

        int getCommandEventValue();

        AvCmd.AVCMD getEvent();

        int getEventValue();

        String getSequenceId();

        ByteString getSequenceIdBytes();

        String getSpeechEvent();

        ByteString getSpeechEventBytes();

        UplinkBody getUplinkBody();

        UplinkBodyOrBuilder getUplinkBodyOrBuilder();

        AvCmd.CommandEventType getVideoEvent();

        int getVideoEventValue();

        boolean hasUplinkBody();
    }

    public static final enum VideoSourceType extends Enum<VideoSourceType> implements ProtocolMessageEnum {
        private static final /* synthetic */ VideoSourceType[] $VALUES = null;
        public static final VideoSourceType UNRECOGNIZED = null;
        private static final VideoSourceType[] VALUES = null;
        public static final VideoSourceType VIDEO_SOURCE_CAMERA = null;
        public static final int VIDEO_SOURCE_CAMERA_VALUE = 1;
        public static final VideoSourceType VIDEO_SOURCE_DEFAULT = null;
        public static final int VIDEO_SOURCE_DEFAULT_VALUE = 0;
        public static final VideoSourceType VIDEO_SOURCE_SCREEN = null;
        public static final int VIDEO_SOURCE_SCREEN_VALUE = 2;
        private static final Internal.EnumLiteMap<VideoSourceType> internalValueMap = null;
        private final int value;

        static {
            VideoSourceType r100 = new VideoSourceType("VIDEO_SOURCE_DEFAULT", 0, 0);
            VIDEO_SOURCE_DEFAULT = r100;
            VideoSourceType r101 = new VideoSourceType("VIDEO_SOURCE_CAMERA", 1, 1);
            VIDEO_SOURCE_CAMERA = r101;
            VideoSourceType r102 = new VideoSourceType("VIDEO_SOURCE_SCREEN", 2, 2);
            VIDEO_SOURCE_SCREEN = r102;
            VideoSourceType r103 = new VideoSourceType("UNRECOGNIZED", 3, -1);
            UNRECOGNIZED = r103;
            $VALUES = new VideoSourceType[]{r100, r101, r102, r103};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        public static VideoSourceType[] values() {
            return (VideoSourceType[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ListProtector.get(AvUplink.getDescriptor().getEnumTypes(), 1);
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
        }

        public static Internal.EnumLiteMap<VideoSourceType> internalGetValueMap() {
            return internalValueMap;
        }

        public static VideoSourceType forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return VIDEO_SOURCE_SCREEN;
        L12:
            return VIDEO_SOURCE_CAMERA;
        L14:
            return VIDEO_SOURCE_DEFAULT;
        }

        public static VideoSourceType valueOf(Descriptors.EnumValueDescriptor r100) {
            if (r100.getType() != getDescriptor()) goto L11;
            if (r100.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r100.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static VideoSourceType valueOf(String r100) {
            return (VideoSourceType) a.a(VideoSourceType.class, r100);
        }

        public static VideoSourceType valueOf(int r100) {
            return forNumber(r100);
        }

        private VideoSourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class VideoSwitchModal extends GeneratedMessageV3 implements VideoSwitchModalOrBuilder {
        public static final int CHAT_FIELD_NUMBER = 2;
        private static final VideoSwitchModal DEFAULT_INSTANCE = null;
        public static final int MODAL_TYPE_FIELD_NUMBER = 1;
        private static final Parser<VideoSwitchModal> PARSER = null;
        public static final int SOURCE_TYPE_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private AvAudioUplink.ChatConfig chat_;
        private byte memoizedIsInitialized;
        private int modalType_;
        private int sourceType_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VideoSwitchModalOrBuilder {
            private SingleFieldBuilderV3<AvAudioUplink.ChatConfig, AvAudioUplink.ChatConfig.Builder, AvAudioUplink.ChatConfigOrBuilder> chatBuilder_;
            private AvAudioUplink.ChatConfig chat_;
            private int modalType_;
            private int sourceType_;

            public Builder clearModalType() {
                this.modalType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSourceType() {
                this.sourceType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private SingleFieldBuilderV3<AvAudioUplink.ChatConfig, AvAudioUplink.ChatConfig.Builder, AvAudioUplink.ChatConfigOrBuilder> getChatFieldBuilder() {
                if (this.chatBuilder_ != null) goto L6;
                this.chatBuilder_ = new SingleFieldBuilderV3(getChat(), getParentForChildren(), isClean());
                this.chat_ = null;
            L6:
                return this.chatBuilder_;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VideoSwitchModal buildPartial() {
                VideoSwitchModal r100 = new VideoSwitchModal(this, null);
                VideoSwitchModal.access$4602(r100, this.modalType_);
                SingleFieldBuilderV3<AvAudioUplink.ChatConfig, AvAudioUplink.ChatConfig.Builder, AvAudioUplink.ChatConfigOrBuilder> r101 = this.chatBuilder_;
                if (r101 != null) goto L5;
                VideoSwitchModal.access$4702(r100, this.chat_);
            L6:
                VideoSwitchModal.access$4802(r100, this.sourceType_);
                onBuilt();
                return r100;
            L5:
                VideoSwitchModal.access$4702(r100, (AvAudioUplink.ChatConfig) r101.build());
                goto L6
            }

            public Builder clearChat() {
                if (this.chatBuilder_ != null) goto L5;
                this.chat_ = null;
                onChanged();
            L6:
                return this;
            L5:
                this.chat_ = null;
                this.chatBuilder_ = null;
                goto L6
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
            public AvAudioUplink.ChatConfig getChat() {
                SingleFieldBuilderV3<AvAudioUplink.ChatConfig, AvAudioUplink.ChatConfig.Builder, AvAudioUplink.ChatConfigOrBuilder> r100 = this.chatBuilder_;
                if (r100 != null) goto L9;
                AvAudioUplink.ChatConfig r101 = this.chat_;
                if (r101 == null) goto L7;
                return r101;
            L7:
                return AvAudioUplink.ChatConfig.getDefaultInstance();
            L9:
                return (AvAudioUplink.ChatConfig) r100.getMessage();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
            public AvAudioUplink.ChatConfigOrBuilder getChatOrBuilder() {
                SingleFieldBuilderV3<AvAudioUplink.ChatConfig, AvAudioUplink.ChatConfig.Builder, AvAudioUplink.ChatConfigOrBuilder> r100 = this.chatBuilder_;
                if (r100 != null) goto L5;
                AvAudioUplink.ChatConfig r101 = this.chat_;
                if (r101 == null) goto L9;
                return r101;
            L9:
                return AvAudioUplink.ChatConfig.getDefaultInstance();
            L5:
                return (AvAudioUplink.ChatConfigOrBuilder) r100.getMessageOrBuilder();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
            public ModalType getModalType() {
                ModalType r100 = ModalType.valueOf(this.modalType_);
                if (r100 == null) goto L5;
                return r100;
            L5:
                return ModalType.UNRECOGNIZED;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
            public VideoSourceType getSourceType() {
                VideoSourceType r100 = VideoSourceType.valueOf(this.sourceType_);
                if (r100 == null) goto L5;
                return r100;
            L5:
                return VideoSourceType.UNRECOGNIZED;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
            public boolean hasChat() {
                if (this.chatBuilder_ == null) goto L5;
            L8:
                return true;
            L5:
                if (this.chat_ != null) goto L8;
                return false;
            }

            private Builder() {
                this.modalType_ = 0;
                this.chat_ = null;
                this.sourceType_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvUplink.access$4000();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VideoSwitchModal build() {
                VideoSwitchModal r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.modalType_ = 0;
                if (this.chatBuilder_ != null) goto L5;
                this.chat_ = null;
            L6:
                this.sourceType_ = 0;
                return this;
            L5:
                this.chat_ = null;
                this.chatBuilder_ = null;
                goto L6
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            public AvAudioUplink.ChatConfig.Builder getChatBuilder() {
                onChanged();
                return (AvAudioUplink.ChatConfig.Builder) getChatFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvUplink.access$4000();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvUplink.access$4100().ensureFieldAccessorsInitialized(VideoSwitchModal.class, Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                VideoSwitchModal.access$4400();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
            public int getModalTypeValue() {
                return this.modalType_;
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
            public int getSourceTypeValue() {
                return this.sourceType_;
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
            public VideoSwitchModal getDefaultInstanceForType() {
                return VideoSwitchModal.getDefaultInstance();
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
                this.modalType_ = 0;
                this.chat_ = null;
                this.sourceType_ = 0;
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

            public Builder mergeChat(AvAudioUplink.ChatConfig r100) {
                SingleFieldBuilderV3<AvAudioUplink.ChatConfig, AvAudioUplink.ChatConfig.Builder, AvAudioUplink.ChatConfigOrBuilder> r101 = this.chatBuilder_;
                if (r101 != null) goto L9;
                AvAudioUplink.ChatConfig r102 = this.chat_;
                if (r102 == null) goto L7;
                this.chat_ = AvAudioUplink.ChatConfig.newBuilder(r102).mergeFrom(r100).buildPartial();
            L8:
                onChanged();
            L10:
                return this;
            L7:
                this.chat_ = r100;
                goto L8
            L9:
                r101.mergeFrom(r100);
                goto L10
            }

            public Builder mergeFrom(VideoSwitchModal r100) {
                if (r100 != VideoSwitchModal.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (VideoSwitchModal.access$4600(r100) == 0) goto L9;
                setModalTypeValue(r100.getModalTypeValue());
            L9:
                if (r100.hasChat() == false) goto L12;
                mergeChat(r100.getChat());
            L12:
                if (VideoSwitchModal.access$4800(r100) == 0) goto L14;
                setSourceTypeValue(r100.getSourceTypeValue());
            L14:
                mergeUnknownFields(VideoSwitchModal.access$4900(r100));
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.mergeUnknownFields(r100);
            }

            public Builder setChat(AvAudioUplink.ChatConfig.Builder r100) {
                SingleFieldBuilderV3<AvAudioUplink.ChatConfig, AvAudioUplink.ChatConfig.Builder, AvAudioUplink.ChatConfigOrBuilder> r101 = this.chatBuilder_;
                if (r101 != null) goto L5;
                this.chat_ = r100.build();
                onChanged();
            L6:
                return this;
            L5:
                r101.setMessage(r100.build());
                goto L6
            }

            public Builder setModalType(ModalType r100) {
                if (r100 == null) goto L6;
                this.modalType_ = r100.getNumber();
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setModalTypeValue(int r100) {
                this.modalType_ = r100;
                onChanged();
                return this;
            }

            public Builder setSourceType(VideoSourceType r100) {
                if (r100 == null) goto L6;
                this.sourceType_ = r100.getNumber();
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setSourceTypeValue(int r100) {
                this.sourceType_ = r100;
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
                if ((r100 instanceof VideoSwitchModal) == true) goto L5;
                super.mergeFrom(r100);
                return this;
            L5:
                return mergeFrom((VideoSwitchModal) r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            public Builder setChat(AvAudioUplink.ChatConfig r100) {
                SingleFieldBuilderV3<AvAudioUplink.ChatConfig, AvAudioUplink.ChatConfig.Builder, AvAudioUplink.ChatConfigOrBuilder> r101 = this.chatBuilder_;
                if (r101 != null) goto L8;
                if (r100 == null) goto L7;
                this.chat_ = r100;
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
                VideoSwitchModal r102 = null;
                VideoSwitchModal r103 = (VideoSwitchModal) VideoSwitchModal.access$5000().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
                VideoSwitchModal r104 = (VideoSwitchModal) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            DEFAULT_INSTANCE = new VideoSwitchModal();
            PARSER = new AnonymousClass1();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
        public AvAudioUplink.ChatConfig getChat() {
            AvAudioUplink.ChatConfig r100 = this.chat_;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return AvAudioUplink.ChatConfig.getDefaultInstance();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
        public ModalType getModalType() {
            ModalType r100 = ModalType.valueOf(this.modalType_);
            if (r100 == null) goto L5;
            return r100;
        L5:
            return ModalType.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if (this.modalType_ == ModalType.MODAL_TYPE_UNKNOWN.getNumber()) goto L9;
            r101 = 0 + CodedOutputStream.computeEnumSize(1, this.modalType_);
        L9:
            if (this.chat_ == null) goto L12;
            r101 = r101 + CodedOutputStream.computeMessageSize(2, getChat());
        L12:
            if (this.sourceType_ == VideoSourceType.VIDEO_SOURCE_DEFAULT.getNumber()) goto L14;
            r101 = r101 + CodedOutputStream.computeEnumSize(3, this.sourceType_);
        L14:
            int r102 = r101 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r102;
            return r102;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
        public VideoSourceType getSourceType() {
            VideoSourceType r100 = VideoSourceType.valueOf(this.sourceType_);
            if (r100 == null) goto L5;
            return r100;
        L5:
            return VideoSourceType.UNRECOGNIZED;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
        public boolean hasChat() {
            if (this.chat_ == null) goto L5;
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
            int r101 = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.modalType_;
            if (hasChat() == false) goto L8;
            r101 = (((r101 * 37) + 2) * 53) + getChat().hashCode();
        L8:
            int r102 = (((((r101 * 37) + 3) * 53) + this.sourceType_) * 29) + this.unknownFields.hashCode();
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

        private VideoSwitchModal() {
            this.memoizedIsInitialized = -1;
            this.modalType_ = 0;
            this.sourceType_ = 0;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvUplink.access$4000();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
        public AvAudioUplink.ChatConfigOrBuilder getChatOrBuilder() {
            return getChat();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvUplink.access$4100().ensureFieldAccessorsInitialized(VideoSwitchModal.class, Builder.class);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static /* synthetic */ boolean access$4400() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ Parser access$5000() {
            return PARSER;
        }

        public static VideoSwitchModal getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VideoSwitchModal> parser() {
            return PARSER;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
        public int getModalTypeValue() {
            return this.modalType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VideoSwitchModal> getParserForType() {
            return PARSER;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.VideoSwitchModalOrBuilder
        public int getSourceTypeValue() {
            return this.sourceType_;
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
        public VideoSwitchModal getDefaultInstanceForType() {
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

        private VideoSwitchModal(GeneratedMessageV3.Builder<?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ int access$4600(VideoSwitchModal r100) {
            return r100.modalType_;
        }

        public static /* synthetic */ int access$4800(VideoSwitchModal r100) {
            return r100.sourceType_;
        }

        public static /* synthetic */ UnknownFieldSet access$4900(VideoSwitchModal r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(VideoSwitchModal r100) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
        }

        public static VideoSwitchModal parseDelimitedFrom(InputStream r100) throws IOException {
            return (VideoSwitchModal) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
        }

        public static VideoSwitchModal parseFrom(ByteString r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof VideoSwitchModal) == false) goto L8;
            VideoSwitchModal r101 = (VideoSwitchModal) r100;
            if (this.modalType_ != r101.modalType_) goto L12;
            boolean r102 = true;
        L13:
            if (r102 == true) goto L15;
        L17:
            boolean r103 = false;
        L19:
            if (hasChat() == false) goto L25;
            if (r103 == true) goto L22;
        L24:
            r103 = false;
            goto L25
        L22:
            if (getChat().equals(r101.getChat()) == false) goto L24;
            r103 = true;
        L25:
            if (r103 == true) goto L27;
        L29:
            boolean r104 = false;
        L30:
            if (r104 == true) goto L32;
        L34:
            return false;
        L32:
            if (this.unknownFields.equals(r101.unknownFields) == false) goto L34;
            return true;
        L27:
            if (this.sourceType_ != r101.sourceType_) goto L29;
            r104 = true;
            goto L30
        L15:
            if (hasChat() != r101.hasChat()) goto L17;
            r103 = true;
            goto L19
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
            if (this.modalType_ == ModalType.MODAL_TYPE_UNKNOWN.getNumber()) goto L6;
            r100.writeEnum(1, this.modalType_);
        L6:
            if (this.chat_ == null) goto L9;
            r100.writeMessage(2, getChat());
        L9:
            if (this.sourceType_ == VideoSourceType.VIDEO_SOURCE_DEFAULT.getNumber()) goto L11;
            r100.writeEnum(3, this.sourceType_);
        L11:
            this.unknownFields.writeTo(r100);
        }

        public static VideoSwitchModal parseFrom(CodedInputStream r100) throws IOException {
            return (VideoSwitchModal) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return newBuilderForType(r100);
        }

        public static VideoSwitchModal parseFrom(InputStream r100) throws IOException {
            return (VideoSwitchModal) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        public static VideoSwitchModal parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        public static VideoSwitchModal parseFrom(byte[] r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        private VideoSwitchModal(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this();
            if (r101 == null) goto L40;
            UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
            boolean r103 = false;
        L5:
            if (r103 == true) goto L38;
            int r104 = r100.readTag();     // Catch: Throwable -> L28 IOException -> L30 InvalidProtocolBufferException -> L33
            if (r104 == 0) goto L27;
            if (r104 != 8) goto L11;
            this.modalType_ = r100.readEnum();     // Catch: Throwable -> L28 IOException -> L30 InvalidProtocolBufferException -> L33
            goto L5
        L11:
            if (r104 != 18) goto L13;
            AvAudioUplink.ChatConfig r105 = this.chat_;     // Catch: Throwable -> L28 IOException -> L30 InvalidProtocolBufferException -> L33
            if (r105 == null) goto L21;
            AvAudioUplink.ChatConfig.Builder r106 = r105.toBuilder();     // Catch: Throwable -> L28 IOException -> L30 InvalidProtocolBufferException -> L33
        L22:
            AvAudioUplink.ChatConfig r107 = (AvAudioUplink.ChatConfig) r100.readMessage(AvAudioUplink.ChatConfig.parser(), r101);     // Catch: Throwable -> L28 IOException -> L30 InvalidProtocolBufferException -> L33
            this.chat_ = r107;     // Catch: Throwable -> L28 IOException -> L30 InvalidProtocolBufferException -> L33
            if (r106 == null) goto L5;
            r106.mergeFrom(r107);     // Catch: Throwable -> L28 IOException -> L30 InvalidProtocolBufferException -> L33
            this.chat_ = r106.buildPartial();     // Catch: Throwable -> L28 IOException -> L30 InvalidProtocolBufferException -> L33
            goto L5
        L21:
            r106 = null;
            goto L22
        L13:
            if (r104 != 24) goto L15;
            this.sourceType_ = r100.readEnum();     // Catch: Throwable -> L28 IOException -> L30 InvalidProtocolBufferException -> L33
            goto L5
        L15:
            if (parseUnknownFieldProto3(r100, r102, r101, r104) == true) goto L5;
        L27:
            r103 = true;
            goto L5
        L28:
            th = move-exception;
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            throw th;
        L33:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L28
        L30:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L28
        L38:
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            return;
        L40:
            throw null;
        }

        public static /* synthetic */ int access$4602(VideoSwitchModal r100, int r101) {
            r100.modalType_ = r101;
            return r101;
        }

        public static /* synthetic */ AvAudioUplink.ChatConfig access$4702(VideoSwitchModal r100, AvAudioUplink.ChatConfig r101) {
            r100.chat_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$4802(VideoSwitchModal r100, int r101) {
            r100.sourceType_ = r101;
            return r101;
        }

        public static VideoSwitchModal parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (VideoSwitchModal) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
        }

        public static VideoSwitchModal parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ VideoSwitchModal(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static VideoSwitchModal parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (VideoSwitchModal) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static VideoSwitchModal parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (VideoSwitchModal) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static VideoSwitchModal parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public static VideoSwitchModal parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ VideoSwitchModal(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface VideoSwitchModalOrBuilder extends MessageOrBuilder {
        AvAudioUplink.ChatConfig getChat();

        AvAudioUplink.ChatConfigOrBuilder getChatOrBuilder();

        ModalType getModalType();

        int getModalTypeValue();

        VideoSourceType getSourceType();

        int getSourceTypeValue();

        boolean hasChat();
    }

    public static final class VideoUplinkBody extends GeneratedMessageV3 implements VideoUplinkBodyOrBuilder {
        private static final VideoUplinkBody DEFAULT_INSTANCE = null;
        private static final Parser<VideoUplinkBody> PARSER = null;
        public static final int SWITCH_MODAL_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private VideoSwitchModal switchModal_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VideoUplinkBodyOrBuilder {
            private SingleFieldBuilderV3<VideoSwitchModal, VideoSwitchModal.Builder, VideoSwitchModalOrBuilder> switchModalBuilder_;
            private VideoSwitchModal switchModal_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private SingleFieldBuilderV3<VideoSwitchModal, VideoSwitchModal.Builder, VideoSwitchModalOrBuilder> getSwitchModalFieldBuilder() {
                if (this.switchModalBuilder_ != null) goto L6;
                this.switchModalBuilder_ = new SingleFieldBuilderV3(getSwitchModal(), getParentForChildren(), isClean());
                this.switchModal_ = null;
            L6:
                return this.switchModalBuilder_;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VideoUplinkBody buildPartial() {
                VideoUplinkBody r100 = new VideoUplinkBody(this, null);
                SingleFieldBuilderV3<VideoSwitchModal, VideoSwitchModal.Builder, VideoSwitchModalOrBuilder> r101 = this.switchModalBuilder_;
                if (r101 != null) goto L5;
                VideoUplinkBody.access$3602(r100, this.switchModal_);
            L6:
                onBuilt();
                return r100;
            L5:
                VideoUplinkBody.access$3602(r100, (VideoSwitchModal) r101.build());
                goto L6
            }

            public Builder clearSwitchModal() {
                if (this.switchModalBuilder_ != null) goto L5;
                this.switchModal_ = null;
                onChanged();
            L6:
                return this;
            L5:
                this.switchModal_ = null;
                this.switchModalBuilder_ = null;
                goto L6
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.VideoUplinkBodyOrBuilder
            public VideoSwitchModal getSwitchModal() {
                SingleFieldBuilderV3<VideoSwitchModal, VideoSwitchModal.Builder, VideoSwitchModalOrBuilder> r100 = this.switchModalBuilder_;
                if (r100 != null) goto L9;
                VideoSwitchModal r101 = this.switchModal_;
                if (r101 == null) goto L7;
                return r101;
            L7:
                return VideoSwitchModal.getDefaultInstance();
            L9:
                return (VideoSwitchModal) r100.getMessage();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.VideoUplinkBodyOrBuilder
            public VideoSwitchModalOrBuilder getSwitchModalOrBuilder() {
                SingleFieldBuilderV3<VideoSwitchModal, VideoSwitchModal.Builder, VideoSwitchModalOrBuilder> r100 = this.switchModalBuilder_;
                if (r100 != null) goto L5;
                VideoSwitchModal r101 = this.switchModal_;
                if (r101 == null) goto L9;
                return r101;
            L9:
                return VideoSwitchModal.getDefaultInstance();
            L5:
                return (VideoSwitchModalOrBuilder) r100.getMessageOrBuilder();
            }

            @Override // com.larus.im.internal.network.proto2.AvUplink.VideoUplinkBodyOrBuilder
            public boolean hasSwitchModal() {
                if (this.switchModalBuilder_ == null) goto L5;
            L8:
                return true;
            L5:
                if (this.switchModal_ != null) goto L8;
                return false;
            }

            private Builder() {
                this.switchModal_ = null;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvUplink.access$3000();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VideoUplinkBody build() {
                VideoUplinkBody r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.switchModalBuilder_ != null) goto L5;
                this.switchModal_ = null;
            L6:
                return this;
            L5:
                this.switchModal_ = null;
                this.switchModalBuilder_ = null;
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
                return AvUplink.access$3000();
            }

            public VideoSwitchModal.Builder getSwitchModalBuilder() {
                onChanged();
                return (VideoSwitchModal.Builder) getSwitchModalFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvUplink.access$3100().ensureFieldAccessorsInitialized(VideoUplinkBody.class, Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                VideoUplinkBody.access$3400();
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
            public VideoUplinkBody getDefaultInstanceForType() {
                return VideoUplinkBody.getDefaultInstance();
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
                this.switchModal_ = null;
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

            public Builder mergeFrom(VideoUplinkBody r100) {
                if (r100 != VideoUplinkBody.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasSwitchModal() == false) goto L8;
                mergeSwitchModal(r100.getSwitchModal());
            L8:
                mergeUnknownFields(VideoUplinkBody.access$3700(r100));
                onChanged();
                return this;
            }

            public Builder mergeSwitchModal(VideoSwitchModal r100) {
                SingleFieldBuilderV3<VideoSwitchModal, VideoSwitchModal.Builder, VideoSwitchModalOrBuilder> r101 = this.switchModalBuilder_;
                if (r101 != null) goto L9;
                VideoSwitchModal r102 = this.switchModal_;
                if (r102 == null) goto L7;
                this.switchModal_ = VideoSwitchModal.newBuilder(r102).mergeFrom(r100).buildPartial();
            L8:
                onChanged();
            L10:
                return this;
            L7:
                this.switchModal_ = r100;
                goto L8
            L9:
                r101.mergeFrom(r100);
                goto L10
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet r100) {
                return (Builder) super.mergeUnknownFields(r100);
            }

            public Builder setSwitchModal(VideoSwitchModal.Builder r100) {
                SingleFieldBuilderV3<VideoSwitchModal, VideoSwitchModal.Builder, VideoSwitchModalOrBuilder> r101 = this.switchModalBuilder_;
                if (r101 != null) goto L5;
                this.switchModal_ = r100.build();
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
                if ((r100 instanceof VideoUplinkBody) == true) goto L5;
                super.mergeFrom(r100);
                return this;
            L5:
                return mergeFrom((VideoUplinkBody) r100);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
                return mergeUnknownFields(r100);
            }

            public Builder setSwitchModal(VideoSwitchModal r100) {
                SingleFieldBuilderV3<VideoSwitchModal, VideoSwitchModal.Builder, VideoSwitchModalOrBuilder> r101 = this.switchModalBuilder_;
                if (r101 != null) goto L8;
                if (r100 == null) goto L7;
                this.switchModal_ = r100;
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
                VideoUplinkBody r102 = null;
                VideoUplinkBody r103 = (VideoUplinkBody) VideoUplinkBody.access$3800().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
                VideoUplinkBody r104 = (VideoUplinkBody) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            DEFAULT_INSTANCE = new VideoUplinkBody();
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
            if (this.switchModal_ == null) goto L8;
            r101 = 0 + CodedOutputStream.computeMessageSize(1, getSwitchModal());
        L8:
            int r102 = r101 + this.unknownFields.getSerializedSize();
            this.memoizedSize = r102;
            return r102;
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.VideoUplinkBodyOrBuilder
        public VideoSwitchModal getSwitchModal() {
            VideoSwitchModal r100 = this.switchModal_;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return VideoSwitchModal.getDefaultInstance();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.VideoUplinkBodyOrBuilder
        public boolean hasSwitchModal() {
            if (this.switchModal_ == null) goto L5;
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
            int r101 = 779 + getDescriptor().hashCode();
            if (hasSwitchModal() == false) goto L8;
            r101 = (((r101 * 37) + 1) * 53) + getSwitchModal().hashCode();
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

        private VideoUplinkBody() {
            this.memoizedIsInitialized = -1;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvUplink.access$3000();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.larus.im.internal.network.proto2.AvUplink.VideoUplinkBodyOrBuilder
        public VideoSwitchModalOrBuilder getSwitchModalOrBuilder() {
            return getSwitchModal();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvUplink.access$3100().ensureFieldAccessorsInitialized(VideoUplinkBody.class, Builder.class);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static /* synthetic */ boolean access$3400() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ Parser access$3800() {
            return PARSER;
        }

        public static VideoUplinkBody getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VideoUplinkBody> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VideoUplinkBody> getParserForType() {
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
        public VideoUplinkBody getDefaultInstanceForType() {
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

        private VideoUplinkBody(GeneratedMessageV3.Builder<?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ UnknownFieldSet access$3700(VideoUplinkBody r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(VideoUplinkBody r100) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
        }

        public static VideoUplinkBody parseDelimitedFrom(InputStream r100) throws IOException {
            return (VideoUplinkBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
        }

        public static VideoUplinkBody parseFrom(ByteString r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof VideoUplinkBody) == false) goto L8;
            VideoUplinkBody r101 = (VideoUplinkBody) r100;
            if (hasSwitchModal() != r101.hasSwitchModal()) goto L12;
            boolean r102 = true;
        L14:
            if (hasSwitchModal() == false) goto L20;
            if (r102 == true) goto L17;
        L19:
            r102 = false;
            goto L20
        L17:
            if (getSwitchModal().equals(r101.getSwitchModal()) == false) goto L19;
            r102 = true;
        L20:
            if (r102 == true) goto L22;
        L24:
            return false;
        L22:
            if (this.unknownFields.equals(r101.unknownFields) == false) goto L24;
            return true;
        L12:
            r102 = false;
            goto L14
        L8:
            return super.equals(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return new Builder(r100, null);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            if (this.switchModal_ == null) goto L5;
            r100.writeMessage(1, getSwitchModal());
        L5:
            this.unknownFields.writeTo(r100);
        }

        public static VideoUplinkBody parseFrom(CodedInputStream r100) throws IOException {
            return (VideoUplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
            return newBuilderForType(r100);
        }

        public static VideoUplinkBody parseFrom(InputStream r100) throws IOException {
            return (VideoUplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100);
        }

        public static VideoUplinkBody parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        public static VideoUplinkBody parseFrom(byte[] r100) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100);
        }

        private VideoUplinkBody(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this();
            if (r101 == null) goto L34;
            UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
            boolean r103 = false;
        L5:
            if (r103 == true) goto L32;
            int r104 = r100.readTag();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
            if (r104 == 0) goto L21;
            if (r104 != 10) goto L11;
            VideoSwitchModal r105 = this.switchModal_;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
            if (r105 == null) goto L16;
            VideoSwitchModal.Builder r106 = r105.toBuilder();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
        L17:
            VideoSwitchModal r107 = (VideoSwitchModal) r100.readMessage(VideoSwitchModal.parser(), r101);     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
            this.switchModal_ = r107;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
            if (r106 == null) goto L5;
            r106.mergeFrom(r107);     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
            this.switchModal_ = r106.buildPartial();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L27
            goto L5
        L16:
            r106 = null;
            goto L17
        L11:
            if (parseUnknownFieldProto3(r100, r102, r101, r104) == true) goto L5;
        L21:
            r103 = true;
            goto L5
        L22:
            th = move-exception;
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            throw th;
        L24:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L22
        L27:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L22
        L32:
            this.unknownFields = r102.build();
            makeExtensionsImmutable();
            return;
        L34:
            throw null;
        }

        public static /* synthetic */ VideoSwitchModal access$3602(VideoUplinkBody r100, VideoSwitchModal r101) {
            r100.switchModal_ = r101;
            return r101;
        }

        public static VideoUplinkBody parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (VideoUplinkBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
        }

        public static VideoUplinkBody parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ VideoUplinkBody(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static VideoUplinkBody parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (VideoUplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static VideoUplinkBody parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return (VideoUplinkBody) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
        }

        public static VideoUplinkBody parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public static VideoUplinkBody parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ VideoUplinkBody(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface VideoUplinkBodyOrBuilder extends MessageOrBuilder {
        VideoSwitchModal getSwitchModal();

        VideoSwitchModalOrBuilder getSwitchModalOrBuilder();

        boolean hasSwitchModal();
    }

    private AvUplink() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite r100) {
    }

    static {
        Descriptors.FileDescriptor.InternalDescriptorAssigner r100 = new AnonymousClass1();
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fav_uplink.proto\u0012$com.larus.im.internal.network.proto2\u001a\fav_cmd.proto\u001a\u0015av_audio_uplink.proto\u001a\rav_file.proto\"Ù\u0002\n\rUplinkMessage\u0012:\n\u0005event\u0018\u0001 \u0001(\u000e2+.com.larus.im.internal.network.proto2.AVCMD\u0012\u0014\n\fspeech_event\u0018\u0002 \u0001(\t\u0012K\n\u000bvideo_event\u0018\u0003 \u0001(\u000e26.com.larus.im.internal.network.proto2.CommandEventType\u0012M\n\rcommand_event\u0018\u0004 \u0001(\u000e26.com.larus.im.internal.network.proto2.CommandEventType\u0012\u0013\n\u000bsequence_id\u0018\u0005 \u0001(\t\u0012E\n\u000buplink_body\u0018\u0006 \u0001(\u000b20.com.larus.im.internal.network.proto2.UplinkBody\"º\u0002\n\nUplinkBody\u0012I\n\naudio_body\u0018\u0001 \u0001(\u000b25.com.larus.im.internal.network.proto2.AudioUplinkBody\u0012I\n\nvideo_body\u0018\u0002 \u0001(\u000b25.com.larus.im.internal.network.proto2.VideoUplinkBody\u0012M\n\fcommand_body\u0018\u0003 \u0001(\u000b27.com.larus.im.internal.network.proto2.CommandUplinkBody\u0012G\n\tfile_body\u0018\u0004 \u0001(\u000b24.com.larus.im.internal.network.proto2.FileUplinkBody\"_\n\u000fVideoUplinkBody\u0012L\n\fswitch_modal\u0018\u0001 \u0001(\u000b26.com.larus.im.internal.network.proto2.VideoSwitchModal\"ã\u0001\n\u0010VideoSwitchModal\u0012C\n\nmodal_type\u0018\u0001 \u0001(\u000e2/.com.larus.im.internal.network.proto2.ModalType\u0012>\n\u0004chat\u0018\u0002 \u0001(\u000b20.com.larus.im.internal.network.proto2.ChatConfig\u0012J\n\u000bsource_type\u0018\u0003 \u0001(\u000e25.com.larus.im.internal.network.proto2.VideoSourceType\"{\n\u0011CommandUplinkBody\u0012G\n\u0007command\u0018\u0001 \u0001(\u000e26.com.larus.im.internal.network.proto2.CommandEventType\u0012\r\n\u0005extra\u0018\u0002 \u0001(\t\u0012\u000e\n\u0006cli_ms\u0018\u0003 \u0001(\u0004*O\n\tModalType\u0012\u0016\n\u0012MODAL_TYPE_UNKNOWN\u0010\u0000\u0012\u0014\n\u0010MODAL_TYPE_AUDIO\u0010\u0001\u0012\u0014\n\u0010MODAL_TYPE_VIDEO\u0010\u0002*]\n\u000fVideoSourceType\u0012\u0018\n\u0014VIDEO_SOURCE_DEFAULT\u0010\u0000\u0012\u0017\n\u0013VIDEO_SOURCE_CAMERA\u0010\u0001\u0012\u0017\n\u0013VIDEO_SOURCE_SCREEN\u0010\u0002B'Z%code.byted.org/flow/alice_protocol/avb\u0006proto3"}, new Descriptors.FileDescriptor[]{AvCmd.getDescriptor(), AvAudioUplink.getDescriptor(), AvFile.getDescriptor()}, r100);
        Descriptors.Descriptor r101 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 0);
        internal_static_com_larus_im_internal_network_proto2_UplinkMessage_descriptor = r101;
        internal_static_com_larus_im_internal_network_proto2_UplinkMessage_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r101, new String[]{"Event", "SpeechEvent", "VideoEvent", "CommandEvent", "SequenceId", "UplinkBody"});
        Descriptors.Descriptor r102 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 1);
        internal_static_com_larus_im_internal_network_proto2_UplinkBody_descriptor = r102;
        internal_static_com_larus_im_internal_network_proto2_UplinkBody_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r102, new String[]{"AudioBody", "VideoBody", "CommandBody", "FileBody"});
        Descriptors.Descriptor r103 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 2);
        internal_static_com_larus_im_internal_network_proto2_VideoUplinkBody_descriptor = r103;
        internal_static_com_larus_im_internal_network_proto2_VideoUplinkBody_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r103, new String[]{"SwitchModal"});
        Descriptors.Descriptor r104 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 3);
        internal_static_com_larus_im_internal_network_proto2_VideoSwitchModal_descriptor = r104;
        internal_static_com_larus_im_internal_network_proto2_VideoSwitchModal_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r104, new String[]{"ModalType", "Chat", "SourceType"});
        Descriptors.Descriptor r105 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 4);
        internal_static_com_larus_im_internal_network_proto2_CommandUplinkBody_descriptor = r105;
        internal_static_com_larus_im_internal_network_proto2_CommandUplinkBody_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r105, new String[]{"Command", "Extra", "CliMs"});
        AvCmd.getDescriptor();
        AvAudioUplink.getDescriptor();
        AvFile.getDescriptor();
    }

    public static /* synthetic */ Descriptors.Descriptor access$000() {
        return internal_static_com_larus_im_internal_network_proto2_UplinkMessage_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$100() {
        return internal_static_com_larus_im_internal_network_proto2_UplinkMessage_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$1700() {
        return internal_static_com_larus_im_internal_network_proto2_UplinkBody_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$1800() {
        return internal_static_com_larus_im_internal_network_proto2_UplinkBody_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$3000() {
        return internal_static_com_larus_im_internal_network_proto2_VideoUplinkBody_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$3100() {
        return internal_static_com_larus_im_internal_network_proto2_VideoUplinkBody_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$4000() {
        return internal_static_com_larus_im_internal_network_proto2_VideoSwitchModal_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$4100() {
        return internal_static_com_larus_im_internal_network_proto2_VideoSwitchModal_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$5200() {
        return internal_static_com_larus_im_internal_network_proto2_CommandUplinkBody_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$5300() {
        return internal_static_com_larus_im_internal_network_proto2_CommandUplinkBody_fieldAccessorTable;
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static /* synthetic */ Descriptors.FileDescriptor access$6502(Descriptors.FileDescriptor r100) {
        descriptor = r100;
        return r100;
    }

    public static void registerAllExtensions(ExtensionRegistry r100) {
        registerAllExtensions(r100);
    }
}
