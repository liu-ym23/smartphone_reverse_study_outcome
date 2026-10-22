package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes23.dex */
public final class Timestamp extends GeneratedMessageV3 implements TimestampOrBuilder {
    private static final Timestamp DEFAULT_INSTANCE = null;
    public static final int NANOS_FIELD_NUMBER = 2;
    private static final Parser<Timestamp> PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private int nanos_;
    private long seconds_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TimestampOrBuilder {
        private int nanos_;
        private long seconds_;

        public Builder clearNanos() {
            this.nanos_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Timestamp buildPartial() {
            Timestamp r100 = new Timestamp(this, null);
            Timestamp.access$302(r100, this.seconds_);
            Timestamp.access$402(r100, this.nanos_);
            onBuilt();
            return r100;
        }

        public Builder clearSeconds() {
            this.seconds_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TimestampProto.internal_static_google_protobuf_Timestamp_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamp.class, Builder.class);
        }

        private Builder() {
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Timestamp build() {
            Timestamp r100 = buildPartial();
            if (r100.isInitialized() == false) goto L6;
            return r100;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.seconds_ = 0;
            this.nanos_ = 0;
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

        public static final Descriptors.Descriptor getDescriptor() {
            return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean r100 = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
        }

        @Override // com.google.protobuf.TimestampOrBuilder
        public int getNanos() {
            return this.nanos_;
        }

        @Override // com.google.protobuf.TimestampOrBuilder
        public long getSeconds() {
            return this.seconds_;
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
        public Timestamp getDefaultInstanceForType() {
            return Timestamp.getDefaultInstance();
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

        public Builder mergeFrom(Timestamp r100) {
            if (r100 != Timestamp.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r100.getSeconds() == 0) goto L9;
            setSeconds(r100.getSeconds());
        L9:
            if (r100.getNanos() == 0) goto L11;
            setNanos(r100.getNanos());
        L11:
            mergeUnknownFields(r100.unknownFields);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r100) {
            return (Builder) super.mergeUnknownFields(r100);
        }

        public Builder setNanos(int r100) {
            this.nanos_ = r100;
            onChanged();
            return this;
        }

        public Builder setSeconds(long r100) {
            this.seconds_ = r100;
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
            if ((r100 instanceof Timestamp) == true) goto L5;
            super.mergeFrom(r100);
            return this;
        L5:
            return mergeFrom((Timestamp) r100);
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
            Timestamp r102 = null;
            Timestamp r103 = (Timestamp) Timestamp.access$500().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
            Timestamp r104 = (Timestamp) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
        DEFAULT_INSTANCE = new Timestamp();
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
        long r101 = this.seconds_;
        int r102 = 0;
        if (r101 == 0) goto L8;
        r102 = 0 + CodedOutputStream.computeInt64Size(1, r101);
    L8:
        int r103 = this.nanos_;
        if (r103 == 0) goto L11;
        r102 = r102 + CodedOutputStream.computeInt32Size(2, r103);
    L11:
        int r104 = r102 + this.unknownFields.getSerializedSize();
        this.memoizedSize = r104;
        return r104;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r100 = this.memoizedHashCode;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        int r101 = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getSeconds())) * 37) + 2) * 53) + getNanos()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r101;
        return r101;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamp.class, Builder.class);
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

    private Timestamp() {
        this.memoizedIsInitialized = -1;
        this.seconds_ = 0;
        this.nanos_ = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    public static /* synthetic */ Parser access$500() {
        return PARSER;
    }

    public static Timestamp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
    }

    public static Parser<Timestamp> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.TimestampOrBuilder
    public int getNanos() {
        return this.nanos_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Timestamp> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.TimestampOrBuilder
    public long getSeconds() {
        return this.seconds_;
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
    public Timestamp getDefaultInstanceForType() {
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

    private Timestamp(GeneratedMessageV3.Builder<?> r100) {
        super(r100);
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(Timestamp r100) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
    }

    public static Timestamp parseDelimitedFrom(InputStream r100) throws IOException {
        return (Timestamp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
    }

    public static Timestamp parseFrom(ByteString r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Timestamp) == false) goto L8;
        Timestamp r101 = (Timestamp) r100;
        if (getSeconds() != r101.getSeconds()) goto L12;
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
        if (getNanos() != r101.getNanos()) goto L17;
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
        long r101 = this.seconds_;
        if (r101 == 0) goto L5;
        r100.writeInt64(1, r101);
    L5:
        int r102 = this.nanos_;
        if (r102 == 0) goto L8;
        r100.writeInt32(2, r102);
    L8:
        this.unknownFields.writeTo(r100);
    }

    public static Timestamp parseFrom(CodedInputStream r100) throws IOException {
        return (Timestamp) GeneratedMessageV3.parseWithIOException(PARSER, r100);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
        return newBuilderForType(r100);
    }

    public static Timestamp parseFrom(InputStream r100) throws IOException {
        return (Timestamp) GeneratedMessageV3.parseWithIOException(PARSER, r100);
    }

    public static Timestamp parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    public static Timestamp parseFrom(byte[] r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    private Timestamp(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        this();
        if (r101 == null) goto L32;
        UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
        boolean r103 = false;
    L5:
        if (r103 == true) goto L29;
        int r104 = r100.readTag();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L24
        if (r104 == 0) goto L18;
        if (r104 != 8) goto L11;
        this.seconds_ = r100.readInt64();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L24
        goto L5
    L11:
        if (r104 != 16) goto L13;
        this.nanos_ = r100.readInt32();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L24
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

    public static /* synthetic */ long access$302(Timestamp r100, long r101) {
        r100.seconds_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$402(Timestamp r100, int r101) {
        r100.nanos_ = r101;
        return r101;
    }

    public static Timestamp parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (Timestamp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
    }

    public static Timestamp parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public /* synthetic */ Timestamp(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static Timestamp parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (Timestamp) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
    }

    public static Timestamp parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (Timestamp) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
    }

    public static Timestamp parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public static Timestamp parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public /* synthetic */ Timestamp(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
        this(r100, r101);
    }
}
