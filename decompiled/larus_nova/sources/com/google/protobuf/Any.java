package com.google.protobuf;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes23.dex */
public final class Any extends GeneratedMessageV3 implements AnyOrBuilder {
    private static final Any DEFAULT_INSTANCE = null;
    private static final Parser<Any> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile Message cachedUnpackValue;
    private byte memoizedIsInitialized;
    private volatile Object typeUrl_;
    private ByteString value_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AnyOrBuilder {
        private Object typeUrl_;
        private ByteString value_;

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Any buildPartial() {
            Any r100 = new Any(this, null);
            Any.access$302(r100, this.typeUrl_);
            Any.access$402(r100, this.value_);
            onBuilt();
            return r100;
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public String getTypeUrl() {
            Object r100 = this.typeUrl_;
            if ((r100 instanceof String) == true) goto L7;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.typeUrl_ = r101;
            return r101;
        L7:
            return (String) r100;
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public ByteString getTypeUrlBytes() {
            Object r100 = this.typeUrl_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.typeUrl_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Builder.class);
        }

        private Builder() {
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Any build() {
            Any r100 = buildPartial();
            if (r100.isInitialized() == false) goto L6;
            return r100;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
            return this;
        }

        public Builder clearTypeUrl() {
            this.typeUrl_ = Any.getDefaultInstance().getTypeUrl();
            onChanged();
            return this;
        }

        public Builder clearValue() {
            this.value_ = Any.getDefaultInstance().getValue();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Any getDefaultInstanceForType() {
            return Any.getDefaultInstance();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AnyProto.internal_static_google_protobuf_Any_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean r100 = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return AnyProto.internal_static_google_protobuf_Any_descriptor;
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public ByteString getValue() {
            return this.value_;
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
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
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
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
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
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
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

        public Builder mergeFrom(Any r100) {
            if (r100 != Any.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r100.getTypeUrl().isEmpty() == true) goto L9;
            this.typeUrl_ = Any.access$300(r100);
            onChanged();
        L9:
            if (r100.getValue() == ByteString.EMPTY) goto L11;
            setValue(r100.getValue());
        L11:
            mergeUnknownFields(r100.unknownFields);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r100) {
            return (Builder) super.mergeUnknownFields(r100);
        }

        public Builder setTypeUrl(String r100) {
            if (r100 == null) goto L6;
            this.typeUrl_ = r100;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setTypeUrlBytes(ByteString r100) {
            if (r100 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r100);
            this.typeUrl_ = r100;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet r100) {
            return (Builder) super.setUnknownFieldsProto3(r100);
        }

        public Builder setValue(ByteString r100) {
            if (r100 == null) goto L6;
            this.value_ = r100;
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
            if ((r100 instanceof Any) == true) goto L5;
            super.mergeFrom(r100);
            return this;
        L5:
            return mergeFrom((Any) r100);
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
            Any r102 = null;
            Any r103 = (Any) Any.access$500().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
            Any r104 = (Any) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
        DEFAULT_INSTANCE = new Any();
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
        if (getTypeUrlBytes().isEmpty() == true) goto L9;
        r101 = 0 + GeneratedMessageV3.computeStringSize(1, this.typeUrl_);
    L9:
        if (this.value_.isEmpty() == true) goto L11;
        r101 = r101 + CodedOutputStream.computeBytesSize(2, this.value_);
    L11:
        int r102 = r101 + this.unknownFields.getSerializedSize();
        this.memoizedSize = r102;
        return r102;
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public String getTypeUrl() {
        Object r100 = this.typeUrl_;
        if ((r100 instanceof String) == true) goto L5;
        String r101 = ((ByteString) r100).toStringUtf8();
        this.typeUrl_ = r101;
        return r101;
    L5:
        return (String) r100;
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public ByteString getTypeUrlBytes() {
        Object r100 = this.typeUrl_;
        if ((r100 instanceof String) == false) goto L7;
        ByteString r101 = ByteString.copyFromUtf8((String) r100);
        this.typeUrl_ = r101;
        return r101;
    L7:
        return (ByteString) r100;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r100 = this.memoizedHashCode;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        int r101 = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getTypeUrl().hashCode()) * 37) + 2) * 53) + getValue().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r101;
        return r101;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Builder.class);
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

    private Any() {
        this.memoizedIsInitialized = -1;
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static /* synthetic */ Parser access$500() {
        return PARSER;
    }

    public static Any getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }

    public static Parser<Any> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Any> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public ByteString getValue() {
        return this.value_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Any getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    private Any(GeneratedMessageV3.Builder<?> r100) {
        super(r100);
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ Object access$300(Any r100) {
        return r100.typeUrl_;
    }

    private static String getTypeNameFromTypeUrl(String r100) {
        int r101 = r100.lastIndexOf(47);
        if (r101 != (-1)) goto L6;
        return "";
    L6:
        return r100.substring(r101 + 1);
    }

    public static Builder newBuilder(Any r100) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
    }

    public static <T extends Message> Any pack(T r100) {
        return newBuilder().setTypeUrl(getTypeUrl("type.googleapis.com", r100.getDescriptorForType())).setValue(r100.toByteString()).build();
    }

    public static Any parseDelimitedFrom(InputStream r100) throws IOException {
        return (Any) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
    }

    public static Any parseFrom(ByteString r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Any) == false) goto L8;
        Any r101 = (Any) r100;
        if (getTypeUrl().equals(r101.getTypeUrl()) == false) goto L12;
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
        if (getValue().equals(r101.getValue()) == false) goto L17;
        r103 = true;
        goto L18
    L12:
        r102 = false;
        goto L13
    L8:
        return super.equals(r100);
    }

    public <T extends Message> boolean is(Class<T> r100) {
        Message r101 = (Message) Internal.getDefaultInstance(r100);
        return getTypeNameFromTypeUrl(getTypeUrl()).equals(r101.getDescriptorForType().getFullName());
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
        return new Builder(r100, null);
    }

    public <T extends Message> T unpack(Class<T> r100) throws InvalidProtocolBufferException {
        if (is(r100) == false) goto L11;
        if (this.cachedUnpackValue != null) goto L7;
        T r101 = (T) ((Message) Internal.getDefaultInstance(r100)).getParserForType().parseFrom(getValue());
        this.cachedUnpackValue = r101;
        return r101;
    L7:
        return (T) this.cachedUnpackValue;
    L11:
        throw new InvalidProtocolBufferException("Type of the Any message does not match the given class.");
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r100) throws IOException {
        if (getTypeUrlBytes().isEmpty() == true) goto L6;
        GeneratedMessageV3.writeString(r100, 1, this.typeUrl_);
    L6:
        if (this.value_.isEmpty() == true) goto L8;
        r100.writeBytes(2, this.value_);
    L8:
        this.unknownFields.writeTo(r100);
    }

    public static Any parseFrom(CodedInputStream r100) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, r100);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
        return newBuilderForType(r100);
    }

    public static Any parseFrom(InputStream r100) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, r100);
    }

    public static Any parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    public static Any parseFrom(byte[] r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    private Any(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        this();
        if (r101 == null) goto L32;
        UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
        boolean r103 = false;
    L5:
        if (r103 == true) goto L29;
        int r104 = r100.readTag();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L24
        if (r104 == 0) goto L18;
        if (r104 != 10) goto L11;
        this.typeUrl_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L24
        goto L5
    L11:
        if (r104 != 18) goto L13;
        this.value_ = r100.readBytes();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L24
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

    public static /* synthetic */ Object access$302(Any r100, Object r101) {
        r100.typeUrl_ = r101;
        return r101;
    }

    public static /* synthetic */ ByteString access$402(Any r100, ByteString r101) {
        r100.value_ = r101;
        return r101;
    }

    private static String getTypeUrl(String r100, Descriptors.Descriptor r101) {
        if (r100.endsWith(HTTP.URL_DEFAULT) == false) goto L6;
        return r100 + r101.getFullName();
    L6:
        return r100 + HTTP.URL_DEFAULT + r101.getFullName();
    }

    public static <T extends Message> Any pack(T r100, String r101) {
        return newBuilder().setTypeUrl(getTypeUrl(r101, r100.getDescriptorForType())).setValue(r100.toByteString()).build();
    }

    public static Any parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (Any) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
    }

    public static Any parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public /* synthetic */ Any(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static Any parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
    }

    public static Any parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (Any) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
    }

    public static Any parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public static Any parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public /* synthetic */ Any(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
        this(r100, r101);
    }
}
