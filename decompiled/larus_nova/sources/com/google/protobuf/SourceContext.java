package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes23.dex */
public final class SourceContext extends GeneratedMessageV3 implements SourceContextOrBuilder {
    private static final SourceContext DEFAULT_INSTANCE = null;
    public static final int FILE_NAME_FIELD_NUMBER = 1;
    private static final Parser<SourceContext> PARSER = null;
    private static final long serialVersionUID = 0;
    private volatile Object fileName_;
    private byte memoizedIsInitialized;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SourceContextOrBuilder {
        private Object fileName_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SourceContext buildPartial() {
            SourceContext r100 = new SourceContext(this, null);
            SourceContext.access$302(r100, this.fileName_);
            onBuilt();
            return r100;
        }

        @Override // com.google.protobuf.SourceContextOrBuilder
        public String getFileName() {
            Object r100 = this.fileName_;
            if ((r100 instanceof String) == true) goto L7;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.fileName_ = r101;
            return r101;
        L7:
            return (String) r100;
        }

        @Override // com.google.protobuf.SourceContextOrBuilder
        public ByteString getFileNameBytes() {
            Object r100 = this.fileName_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.fileName_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SourceContextProto.internal_static_google_protobuf_SourceContext_fieldAccessorTable.ensureFieldAccessorsInitialized(SourceContext.class, Builder.class);
        }

        private Builder() {
            this.fileName_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SourceContext build() {
            SourceContext r100 = buildPartial();
            if (r100.isInitialized() == false) goto L6;
            return r100;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.fileName_ = "";
            return this;
        }

        public Builder clearFileName() {
            this.fileName_ = SourceContext.getDefaultInstance().getFileName();
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

        public static final Descriptors.Descriptor getDescriptor() {
            return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean r100 = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
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
        public SourceContext getDefaultInstanceForType() {
            return SourceContext.getDefaultInstance();
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
            this.fileName_ = "";
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

        public Builder mergeFrom(SourceContext r100) {
            if (r100 != SourceContext.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r100.getFileName().isEmpty() == true) goto L8;
            this.fileName_ = SourceContext.access$300(r100);
            onChanged();
        L8:
            mergeUnknownFields(r100.unknownFields);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r100) {
            return (Builder) super.mergeUnknownFields(r100);
        }

        public Builder setFileName(String r100) {
            if (r100 == null) goto L6;
            this.fileName_ = r100;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setFileNameBytes(ByteString r100) {
            if (r100 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r100);
            this.fileName_ = r100;
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
            if ((r100 instanceof SourceContext) == true) goto L5;
            super.mergeFrom(r100);
            return this;
        L5:
            return mergeFrom((SourceContext) r100);
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
            SourceContext r102 = null;
            SourceContext r103 = (SourceContext) SourceContext.access$400().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
            SourceContext r104 = (SourceContext) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
        DEFAULT_INSTANCE = new SourceContext();
        PARSER = new AnonymousClass1();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    @Override // com.google.protobuf.SourceContextOrBuilder
    public String getFileName() {
        Object r100 = this.fileName_;
        if ((r100 instanceof String) == true) goto L5;
        String r101 = ((ByteString) r100).toStringUtf8();
        this.fileName_ = r101;
        return r101;
    L5:
        return (String) r100;
    }

    @Override // com.google.protobuf.SourceContextOrBuilder
    public ByteString getFileNameBytes() {
        Object r100 = this.fileName_;
        if ((r100 instanceof String) == false) goto L7;
        ByteString r101 = ByteString.copyFromUtf8((String) r100);
        this.fileName_ = r101;
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
        if (getFileNameBytes().isEmpty() == true) goto L8;
        r101 = 0 + GeneratedMessageV3.computeStringSize(1, this.fileName_);
    L8:
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
        int r101 = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getFileName().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r101;
        return r101;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_fieldAccessorTable.ensureFieldAccessorsInitialized(SourceContext.class, Builder.class);
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

    private SourceContext() {
        this.memoizedIsInitialized = -1;
        this.fileName_ = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    public static /* synthetic */ Parser access$400() {
        return PARSER;
    }

    public static SourceContext getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
    }

    public static Parser<SourceContext> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<SourceContext> getParserForType() {
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
    public SourceContext getDefaultInstanceForType() {
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

    private SourceContext(GeneratedMessageV3.Builder<?> r100) {
        super(r100);
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ Object access$300(SourceContext r100) {
        return r100.fileName_;
    }

    public static Builder newBuilder(SourceContext r100) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
    }

    public static SourceContext parseDelimitedFrom(InputStream r100) throws IOException {
        return (SourceContext) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
    }

    public static SourceContext parseFrom(ByteString r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SourceContext) == false) goto L8;
        SourceContext r101 = (SourceContext) r100;
        if (getFileName().equals(r101.getFileName()) == false) goto L12;
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

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
        return new Builder(r100, null);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r100) throws IOException {
        if (getFileNameBytes().isEmpty() == true) goto L5;
        GeneratedMessageV3.writeString(r100, 1, this.fileName_);
    L5:
        this.unknownFields.writeTo(r100);
    }

    public static SourceContext parseFrom(CodedInputStream r100) throws IOException {
        return (SourceContext) GeneratedMessageV3.parseWithIOException(PARSER, r100);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
        return newBuilderForType(r100);
    }

    public static SourceContext parseFrom(InputStream r100) throws IOException {
        return (SourceContext) GeneratedMessageV3.parseWithIOException(PARSER, r100);
    }

    public static SourceContext parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    public static SourceContext parseFrom(byte[] r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    private SourceContext(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        this();
        if (r101 == null) goto L29;
        UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
        boolean r103 = false;
    L5:
        if (r103 == true) goto L26;
        int r104 = r100.readTag();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L21
        if (r104 == 0) goto L15;
        if (r104 != 10) goto L11;
        this.fileName_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L21
        goto L5
    L11:
        if (parseUnknownFieldProto3(r100, r102, r101, r104) == true) goto L5;
    L15:
        r103 = true;
        goto L5
    L16:
        th = move-exception;
        this.unknownFields = r102.build();
        makeExtensionsImmutable();
        throw th;
    L21:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L16
    L18:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L16
    L26:
        this.unknownFields = r102.build();
        makeExtensionsImmutable();
        return;
    L29:
        throw null;
    }

    public static /* synthetic */ Object access$302(SourceContext r100, Object r101) {
        r100.fileName_ = r101;
        return r101;
    }

    public static SourceContext parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (SourceContext) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
    }

    public static SourceContext parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public /* synthetic */ SourceContext(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static SourceContext parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (SourceContext) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
    }

    public static SourceContext parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (SourceContext) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
    }

    public static SourceContext parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public static SourceContext parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public /* synthetic */ SourceContext(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
        this(r100, r101);
    }
}
