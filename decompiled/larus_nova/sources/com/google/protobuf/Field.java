package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final class Field extends GeneratedMessageV3 implements FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    private static final Field DEFAULT_INSTANCE = null;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    private static final Parser<Field> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int cardinality_;
    private volatile Object defaultValue_;
    private volatile Object jsonName_;
    private int kind_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int number_;
    private int oneofIndex_;
    private List<Option> options_;
    private boolean packed_;
    private volatile Object typeUrl_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FieldOrBuilder {
        private int bitField0_;
        private int cardinality_;
        private Object defaultValue_;
        private Object jsonName_;
        private int kind_;
        private Object name_;
        private int number_;
        private int oneofIndex_;
        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private boolean packed_;
        private Object typeUrl_;

        public Builder clearCardinality() {
            this.cardinality_ = 0;
            onChanged();
            return this;
        }

        public Builder clearKind() {
            this.kind_ = 0;
            onChanged();
            return this;
        }

        public Builder clearNumber() {
            this.number_ = 0;
            onChanged();
            return this;
        }

        public Builder clearOneofIndex() {
            this.oneofIndex_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPacked() {
            this.packed_ = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 128) == 128) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 128;
            return;
        }

        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> getOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r100 = this.options_;
            if ((this.bitField0_ & 128) != 128) goto L7;
            boolean r101 = true;
        L8:
            this.optionsBuilder_ = new RepeatedFieldBuilderV3(r100, r101, getParentForChildren(), isClean());
            this.options_ = null;
            goto L10
        L7:
            r101 = false;
        L10:
            return this.optionsBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L6;
            getOptionsFieldBuilder();
            return;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Field buildPartial() {
            Field r100 = new Field(this, null);
            Field.access$302(r100, this.kind_);
            Field.access$402(r100, this.cardinality_);
            Field.access$502(r100, this.number_);
            Field.access$602(r100, this.name_);
            Field.access$702(r100, this.typeUrl_);
            Field.access$802(r100, this.oneofIndex_);
            Field.access$902(r100, this.packed_);
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r101 = this.optionsBuilder_;
            if (r101 == null) goto L5;
            Field.access$1002(r100, r101.build());
        L9:
            Field.access$1102(r100, this.jsonName_);
            Field.access$1202(r100, this.defaultValue_);
            Field.access$1302(r100, 0);
            onBuilt();
            return r100;
        L5:
            if ((this.bitField0_ & 128) != 128) goto L7;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -129;
        L7:
            Field.access$1002(r100, this.options_);
            goto L9
        }

        public Builder clearOptions() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r100 = this.optionsBuilder_;
            if (r100 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -129;
            onChanged();
        L6:
            return this;
        L5:
            r100.clear();
            goto L6
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Cardinality getCardinality() {
            Cardinality r100 = Cardinality.valueOf(this.cardinality_);
            if (r100 == null) goto L5;
            return r100;
        L5:
            return Cardinality.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getDefaultValue() {
            Object r100 = this.defaultValue_;
            if ((r100 instanceof String) == true) goto L7;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.defaultValue_ = r101;
            return r101;
        L7:
            return (String) r100;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getDefaultValueBytes() {
            Object r100 = this.defaultValue_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.defaultValue_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getJsonName() {
            Object r100 = this.jsonName_;
            if ((r100 instanceof String) == true) goto L7;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.jsonName_ = r101;
            return r101;
        L7:
            return (String) r100;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getJsonNameBytes() {
            Object r100 = this.jsonName_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.jsonName_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Kind getKind() {
            Kind r100 = Kind.valueOf(this.kind_);
            if (r100 == null) goto L5;
            return r100;
        L5:
            return Kind.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getName() {
            Object r100 = this.name_;
            if ((r100 instanceof String) == true) goto L7;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.name_ = r101;
            return r101;
        L7:
            return (String) r100;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getNameBytes() {
            Object r100 = this.name_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.name_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r100 = this.optionsBuilder_;
            if (r100 != null) goto L7;
            return this.options_.size();
        L7:
            return r100.getCount();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r100 = this.optionsBuilder_;
            if (r100 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r100.getMessageList();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r100 = this.optionsBuilder_;
            if (r100 == null) goto L7;
            return r100.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getTypeUrl() {
            Object r100 = this.typeUrl_;
            if ((r100 instanceof String) == true) goto L7;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.typeUrl_ = r101;
            return r101;
        L7:
            return (String) r100;
        }

        @Override // com.google.protobuf.FieldOrBuilder
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
            return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Builder.class);
        }

        private Builder() {
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.jsonName_ = "";
            this.defaultValue_ = "";
            maybeForceBuilderInitialization();
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Field build() {
            Field r100 = buildPartial();
            if (r100.isInitialized() == false) goto L6;
            return r100;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.number_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.oneofIndex_ = 0;
            this.packed_ = false;
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r100 = this.optionsBuilder_;
            if (r100 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -129;
        L6:
            this.jsonName_ = "";
            this.defaultValue_ = "";
            return this;
        L5:
            r100.clear();
            goto L6
        }

        public Builder clearDefaultValue() {
            this.defaultValue_ = Field.getDefaultInstance().getDefaultValue();
            onChanged();
            return this;
        }

        public Builder clearJsonName() {
            this.jsonName_ = Field.getDefaultInstance().getJsonName();
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Field.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public Builder clearTypeUrl() {
            this.typeUrl_ = Field.getDefaultInstance().getTypeUrl();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Field getDefaultInstanceForType() {
            return Field.getDefaultInstance();
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return getOptionsFieldBuilder().getBuilderList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_Field_descriptor;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getCardinalityValue() {
            return this.cardinality_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Field_descriptor;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getKindValue() {
            return this.kind_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getNumber() {
            return this.number_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOneofIndex() {
            return this.oneofIndex_;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public boolean getPacked() {
            return this.packed_;
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
            this.kind_ = 0;
            this.cardinality_ = 0;
            this.name_ = "";
            this.typeUrl_ = "";
            this.options_ = Collections.emptyList();
            this.jsonName_ = "";
            this.defaultValue_ = "";
            maybeForceBuilderInitialization();
        }

        public Builder addAllOptions(Iterable<? extends Option> r100) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r101 = this.optionsBuilder_;
            if (r101 != null) goto L5;
            ensureOptionsIsMutable();
            AbstractMessageLite.Builder.addAll(r100, this.options_);
            onChanged();
        L6:
            return this;
        L5:
            r101.addAllMessages(r100);
            goto L6
        }

        public Builder addOptions(Option.Builder r100) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r101 = this.optionsBuilder_;
            if (r101 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r100.build());
            onChanged();
        L6:
            return this;
        L5:
            r101.addMessage(r100.build());
            goto L6
        }

        public Option.Builder addOptionsBuilder(int r100) {
            return (Option.Builder) getOptionsFieldBuilder().addBuilder(r100, Option.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor r100) {
            return (Builder) super.clearField(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor r100) {
            return (Builder) super.clearOneof(r100);
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Option getOptions(int r100) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r101 = this.optionsBuilder_;
            if (r101 != null) goto L7;
            return (Option) ListProtector.get(this.options_, r100);
        L7:
            return (Option) r101.getMessage(r100);
        }

        public Option.Builder getOptionsBuilder(int r100) {
            return (Option.Builder) getOptionsFieldBuilder().getBuilder(r100);
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r100) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r101 = this.optionsBuilder_;
            if (r101 != null) goto L7;
            return (OptionOrBuilder) ListProtector.get(this.options_, r100);
        L7:
            return (OptionOrBuilder) r101.getMessageOrBuilder(r100);
        }

        public Builder mergeFrom(Field r100) {
            if (r100 != Field.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (Field.access$300(r100) == 0) goto L9;
            setKindValue(r100.getKindValue());
        L9:
            if (Field.access$400(r100) == 0) goto L12;
            setCardinalityValue(r100.getCardinalityValue());
        L12:
            if (r100.getNumber() == 0) goto L15;
            setNumber(r100.getNumber());
        L15:
            if (r100.getName().isEmpty() == true) goto L18;
            this.name_ = Field.access$600(r100);
            onChanged();
        L18:
            if (r100.getTypeUrl().isEmpty() == true) goto L21;
            this.typeUrl_ = Field.access$700(r100);
            onChanged();
        L21:
            if (r100.getOneofIndex() == 0) goto L24;
            setOneofIndex(r100.getOneofIndex());
        L24:
            if (r100.getPacked() == false) goto L27;
            setPacked(r100.getPacked());
        L27:
            if (this.optionsBuilder_ != null) goto L36;
            if (Field.access$1000(r100).isEmpty() == true) goto L45;
            if (this.options_.isEmpty() == false) goto L33;
            this.options_ = Field.access$1000(r100);
            this.bitField0_ &= -129;
        L34:
            onChanged();
            goto L45
        L33:
            ensureOptionsIsMutable();
            this.options_.addAll(Field.access$1000(r100));
        L45:
            if (r100.getJsonName().isEmpty() == true) goto L48;
            this.jsonName_ = Field.access$1100(r100);
            onChanged();
        L48:
            if (r100.getDefaultValue().isEmpty() == true) goto L50;
            this.defaultValue_ = Field.access$1200(r100);
            onChanged();
        L50:
            mergeUnknownFields(r100.unknownFields);
            onChanged();
            return this;
        L36:
            if (Field.access$1000(r100).isEmpty() == true) goto L45;
            if (this.optionsBuilder_.isEmpty() == false) goto L43;
            this.optionsBuilder_.dispose();
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r101 = null;
            this.optionsBuilder_ = null;
            this.options_ = Field.access$1000(r100);
            this.bitField0_ &= -129;
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L42;
            r101 = getOptionsFieldBuilder();
        L42:
            this.optionsBuilder_ = r101;
            goto L45
        L43:
            this.optionsBuilder_.addAllMessages(Field.access$1000(r100));
            goto L45
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r100) {
            return (Builder) super.mergeUnknownFields(r100);
        }

        public Builder removeOptions(int r100) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r101 = this.optionsBuilder_;
            if (r101 != null) goto L5;
            ensureOptionsIsMutable();
            ListProtector.remove(this.options_, r100);
            onChanged();
        L6:
            return this;
        L5:
            r101.remove(r100);
            goto L6
        }

        public Builder setCardinality(Cardinality r100) {
            if (r100 == null) goto L6;
            this.cardinality_ = r100.getNumber();
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setCardinalityValue(int r100) {
            this.cardinality_ = r100;
            onChanged();
            return this;
        }

        public Builder setDefaultValue(String r100) {
            if (r100 == null) goto L6;
            this.defaultValue_ = r100;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDefaultValueBytes(ByteString r100) {
            if (r100 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r100);
            this.defaultValue_ = r100;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setJsonName(String r100) {
            if (r100 == null) goto L6;
            this.jsonName_ = r100;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setJsonNameBytes(ByteString r100) {
            if (r100 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r100);
            this.jsonName_ = r100;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setKind(Kind r100) {
            if (r100 == null) goto L6;
            this.kind_ = r100.getNumber();
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setKindValue(int r100) {
            this.kind_ = r100;
            onChanged();
            return this;
        }

        public Builder setName(String r100) {
            if (r100 == null) goto L6;
            this.name_ = r100;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setNameBytes(ByteString r100) {
            if (r100 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r100);
            this.name_ = r100;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setNumber(int r100) {
            this.number_ = r100;
            onChanged();
            return this;
        }

        public Builder setOneofIndex(int r100) {
            this.oneofIndex_ = r100;
            onChanged();
            return this;
        }

        public Builder setPacked(boolean r100) {
            this.packed_ = r100;
            onChanged();
            return this;
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

        public /* synthetic */ Builder(AnonymousClass1 r100) {
            this();
        }

        public Builder addOptions(Option r100) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r101 = this.optionsBuilder_;
            if (r101 != null) goto L8;
            if (r100 == null) goto L7;
            ensureOptionsIsMutable();
            this.options_.add(r100);
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
            if ((r100 instanceof Field) == true) goto L5;
            super.mergeFrom(r100);
            return this;
        L5:
            return mergeFrom((Field) r100);
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

        public Builder addOptions(int r100, Option.Builder r101) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r102 = this.optionsBuilder_;
            if (r102 != null) goto L5;
            ensureOptionsIsMutable();
            ListProtector.add(this.options_, r100, r101.build());
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

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            Field r102 = null;
            Field r103 = (Field) Field.access$1400().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
            Field r104 = (Field) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

        public Builder setOptions(int r100, Option.Builder r101) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r102 = this.optionsBuilder_;
            if (r102 != null) goto L5;
            ensureOptionsIsMutable();
            ListProtector.set(this.options_, r100, r101.build());
            onChanged();
        L6:
            return this;
        L5:
            r102.setMessage(r100, r101.build());
            goto L6
        }

        public Builder addOptions(int r100, Option r101) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r102 = this.optionsBuilder_;
            if (r102 != null) goto L8;
            if (r101 == null) goto L7;
            ensureOptionsIsMutable();
            ListProtector.add(this.options_, r100, r101);
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

        public Builder setOptions(int r100, Option r101) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r102 = this.optionsBuilder_;
            if (r102 != null) goto L8;
            if (r101 == null) goto L7;
            ensureOptionsIsMutable();
            ListProtector.set(this.options_, r100, r101);
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

    public static final enum Cardinality extends java.lang.Enum<Cardinality> implements ProtocolMessageEnum {
        private static final /* synthetic */ Cardinality[] $VALUES = null;
        public static final Cardinality CARDINALITY_OPTIONAL = null;
        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final Cardinality CARDINALITY_REPEATED = null;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        public static final Cardinality CARDINALITY_REQUIRED = null;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final Cardinality CARDINALITY_UNKNOWN = null;
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;
        public static final Cardinality UNRECOGNIZED = null;
        private static final Cardinality[] VALUES = null;
        private static final Internal.EnumLiteMap<Cardinality> internalValueMap = null;
        private final int value;

        static {
            Cardinality r100 = new Cardinality("CARDINALITY_UNKNOWN", 0, 0);
            CARDINALITY_UNKNOWN = r100;
            Cardinality r101 = new Cardinality("CARDINALITY_OPTIONAL", 1, 1);
            CARDINALITY_OPTIONAL = r101;
            Cardinality r102 = new Cardinality("CARDINALITY_REQUIRED", 2, 2);
            CARDINALITY_REQUIRED = r102;
            Cardinality r103 = new Cardinality("CARDINALITY_REPEATED", 3, 3);
            CARDINALITY_REPEATED = r103;
            Cardinality r104 = new Cardinality("UNRECOGNIZED", 4, -1);
            UNRECOGNIZED = r104;
            $VALUES = new Cardinality[]{r100, r101, r102, r103, r104};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        public static Cardinality[] values() {
            return (Cardinality[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ListProtector.get(Field.getDescriptor().getEnumTypes(), 1);
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
        }

        public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        public static Cardinality forNumber(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return CARDINALITY_REPEATED;
        L14:
            return CARDINALITY_REQUIRED;
        L16:
            return CARDINALITY_OPTIONAL;
        L18:
            return CARDINALITY_UNKNOWN;
        }

        public static Cardinality valueOf(Descriptors.EnumValueDescriptor r100) {
            if (r100.getType() != getDescriptor()) goto L11;
            if (r100.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r100.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static Cardinality valueOf(String r100) {
            return (Cardinality) a.a(Cardinality.class, r100);
        }

        public static Cardinality valueOf(int r100) {
            return forNumber(r100);
        }

        private Cardinality(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Kind extends java.lang.Enum<Kind> implements ProtocolMessageEnum {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind TYPE_BOOL = null;
        public static final int TYPE_BOOL_VALUE = 8;
        public static final Kind TYPE_BYTES = null;
        public static final int TYPE_BYTES_VALUE = 12;
        public static final Kind TYPE_DOUBLE = null;
        public static final int TYPE_DOUBLE_VALUE = 1;
        public static final Kind TYPE_ENUM = null;
        public static final int TYPE_ENUM_VALUE = 14;
        public static final Kind TYPE_FIXED32 = null;
        public static final int TYPE_FIXED32_VALUE = 7;
        public static final Kind TYPE_FIXED64 = null;
        public static final int TYPE_FIXED64_VALUE = 6;
        public static final Kind TYPE_FLOAT = null;
        public static final int TYPE_FLOAT_VALUE = 2;
        public static final Kind TYPE_GROUP = null;
        public static final int TYPE_GROUP_VALUE = 10;
        public static final Kind TYPE_INT32 = null;
        public static final int TYPE_INT32_VALUE = 5;
        public static final Kind TYPE_INT64 = null;
        public static final int TYPE_INT64_VALUE = 3;
        public static final Kind TYPE_MESSAGE = null;
        public static final int TYPE_MESSAGE_VALUE = 11;
        public static final Kind TYPE_SFIXED32 = null;
        public static final int TYPE_SFIXED32_VALUE = 15;
        public static final Kind TYPE_SFIXED64 = null;
        public static final int TYPE_SFIXED64_VALUE = 16;
        public static final Kind TYPE_SINT32 = null;
        public static final int TYPE_SINT32_VALUE = 17;
        public static final Kind TYPE_SINT64 = null;
        public static final int TYPE_SINT64_VALUE = 18;
        public static final Kind TYPE_STRING = null;
        public static final int TYPE_STRING_VALUE = 9;
        public static final Kind TYPE_UINT32 = null;
        public static final int TYPE_UINT32_VALUE = 13;
        public static final Kind TYPE_UINT64 = null;
        public static final int TYPE_UINT64_VALUE = 4;
        public static final Kind TYPE_UNKNOWN = null;
        public static final int TYPE_UNKNOWN_VALUE = 0;
        public static final Kind UNRECOGNIZED = null;
        private static final Kind[] VALUES = null;
        private static final Internal.EnumLiteMap<Kind> internalValueMap = null;
        private final int value;

        static {
            Kind r100 = new Kind("TYPE_UNKNOWN", 0, 0);
            TYPE_UNKNOWN = r100;
            Kind r101 = new Kind("TYPE_DOUBLE", 1, 1);
            TYPE_DOUBLE = r101;
            Kind r102 = new Kind("TYPE_FLOAT", 2, 2);
            TYPE_FLOAT = r102;
            Kind r103 = new Kind("TYPE_INT64", 3, 3);
            TYPE_INT64 = r103;
            Kind r104 = new Kind("TYPE_UINT64", 4, 4);
            TYPE_UINT64 = r104;
            Kind r105 = new Kind("TYPE_INT32", 5, 5);
            TYPE_INT32 = r105;
            Kind r110 = new Kind("TYPE_FIXED64", 6, 6);
            TYPE_FIXED64 = r110;
            Kind r111 = new Kind("TYPE_FIXED32", 7, 7);
            TYPE_FIXED32 = r111;
            Kind r112 = new Kind("TYPE_BOOL", 8, 8);
            TYPE_BOOL = r112;
            Kind r113 = new Kind("TYPE_STRING", 9, 9);
            TYPE_STRING = r113;
            Kind r114 = new Kind("TYPE_GROUP", 10, 10);
            TYPE_GROUP = r114;
            Kind r115 = new Kind("TYPE_MESSAGE", 11, 11);
            TYPE_MESSAGE = r115;
            Kind r106 = new Kind("TYPE_BYTES", 12, 12);
            TYPE_BYTES = r106;
            Kind r107 = new Kind("TYPE_UINT32", 13, 13);
            TYPE_UINT32 = r107;
            Kind r108 = new Kind("TYPE_ENUM", 14, 14);
            TYPE_ENUM = r108;
            Kind r109 = new Kind("TYPE_SFIXED32", 15, 15);
            TYPE_SFIXED32 = r109;
            Kind r116 = new Kind("TYPE_SFIXED64", 16, 16);
            TYPE_SFIXED64 = r116;
            Kind r117 = new Kind("TYPE_SINT32", 17, 17);
            TYPE_SINT32 = r117;
            Kind r118 = new Kind("TYPE_SINT64", 18, 18);
            TYPE_SINT64 = r118;
            Kind r119 = new Kind("UNRECOGNIZED", 19, -1);
            UNRECOGNIZED = r119;
            $VALUES = new Kind[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ListProtector.get(Field.getDescriptor().getEnumTypes(), 0);
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
        }

        public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
            return internalValueMap;
        }

        public static Kind forNumber(int r100) {
            switch(r100) {
                case 0: goto L42;
                case 1: goto L40;
                case 2: goto L38;
                case 3: goto L36;
                case 4: goto L34;
                case 5: goto L32;
                case 6: goto L30;
                case 7: goto L28;
                case 8: goto L26;
                case 9: goto L24;
                case 10: goto L22;
                case 11: goto L20;
                case 12: goto L18;
                case 13: goto L16;
                case 14: goto L14;
                case 15: goto L12;
                case 16: goto L10;
                case 17: goto L8;
                case 18: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return TYPE_SINT64;
        L8:
            return TYPE_SINT32;
        L10:
            return TYPE_SFIXED64;
        L12:
            return TYPE_SFIXED32;
        L14:
            return TYPE_ENUM;
        L16:
            return TYPE_UINT32;
        L18:
            return TYPE_BYTES;
        L20:
            return TYPE_MESSAGE;
        L22:
            return TYPE_GROUP;
        L24:
            return TYPE_STRING;
        L26:
            return TYPE_BOOL;
        L28:
            return TYPE_FIXED32;
        L30:
            return TYPE_FIXED64;
        L32:
            return TYPE_INT32;
        L34:
            return TYPE_UINT64;
        L36:
            return TYPE_INT64;
        L38:
            return TYPE_FLOAT;
        L40:
            return TYPE_DOUBLE;
        L42:
            return TYPE_UNKNOWN;
        }

        public static Kind valueOf(Descriptors.EnumValueDescriptor r100) {
            if (r100.getType() != getDescriptor()) goto L11;
            if (r100.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r100.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static Kind valueOf(String r100) {
            return (Kind) a.a(Kind.class, r100);
        }

        public static Kind valueOf(int r100) {
            return forNumber(r100);
        }

        private Kind(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        DEFAULT_INSTANCE = new Field();
        PARSER = new AnonymousClass1();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Cardinality getCardinality() {
        Cardinality r100 = Cardinality.valueOf(this.cardinality_);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return Cardinality.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getDefaultValue() {
        Object r100 = this.defaultValue_;
        if ((r100 instanceof String) == true) goto L5;
        String r101 = ((ByteString) r100).toStringUtf8();
        this.defaultValue_ = r101;
        return r101;
    L5:
        return (String) r100;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getDefaultValueBytes() {
        Object r100 = this.defaultValue_;
        if ((r100 instanceof String) == false) goto L7;
        ByteString r101 = ByteString.copyFromUtf8((String) r100);
        this.defaultValue_ = r101;
        return r101;
    L7:
        return (ByteString) r100;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getJsonName() {
        Object r100 = this.jsonName_;
        if ((r100 instanceof String) == true) goto L5;
        String r101 = ((ByteString) r100).toStringUtf8();
        this.jsonName_ = r101;
        return r101;
    L5:
        return (String) r100;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getJsonNameBytes() {
        Object r100 = this.jsonName_;
        if ((r100 instanceof String) == false) goto L7;
        ByteString r101 = ByteString.copyFromUtf8((String) r100);
        this.jsonName_ = r101;
        return r101;
    L7:
        return (ByteString) r100;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Kind getKind() {
        Kind r100 = Kind.valueOf(this.kind_);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return Kind.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getName() {
        Object r100 = this.name_;
        if ((r100 instanceof String) == true) goto L5;
        String r101 = ((ByteString) r100).toStringUtf8();
        this.name_ = r101;
        return r101;
    L5:
        return (String) r100;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getNameBytes() {
        Object r100 = this.name_;
        if ((r100 instanceof String) == false) goto L7;
        ByteString r101 = ByteString.copyFromUtf8((String) r100);
        this.name_ = r101;
        return r101;
    L7:
        return (ByteString) r100;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r100 = this.memoizedSize;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        int r101 = 0;
        if (this.kind_ == Kind.TYPE_UNKNOWN.getNumber()) goto L8;
        int r102 = CodedOutputStream.computeEnumSize(1, this.kind_) + 0;
    L10:
        if (this.cardinality_ == Cardinality.CARDINALITY_UNKNOWN.getNumber()) goto L12;
        r102 = r102 + CodedOutputStream.computeEnumSize(2, this.cardinality_);
    L12:
        int r103 = this.number_;
        if (r103 == 0) goto L16;
        r102 = r102 + CodedOutputStream.computeInt32Size(3, r103);
    L16:
        if (getNameBytes().isEmpty() == true) goto L19;
        r102 = r102 + GeneratedMessageV3.computeStringSize(4, this.name_);
    L19:
        if (getTypeUrlBytes().isEmpty() == true) goto L21;
        r102 = r102 + GeneratedMessageV3.computeStringSize(6, this.typeUrl_);
    L21:
        int r104 = this.oneofIndex_;
        if (r104 == 0) goto L24;
        r102 = r102 + CodedOutputStream.computeInt32Size(7, r104);
    L24:
        boolean r105 = this.packed_;
        if (r105 == false) goto L28;
        r102 = r102 + CodedOutputStream.computeBoolSize(8, r105);
    L28:
        if (r101 >= this.options_.size()) goto L31;
        r102 = r102 + CodedOutputStream.computeMessageSize(9, (MessageLite) ListProtector.get(this.options_, r101));
        r101 = r101 + 1;
        goto L28
    L31:
        if (getJsonNameBytes().isEmpty() == true) goto L34;
        r102 = r102 + GeneratedMessageV3.computeStringSize(10, this.jsonName_);
    L34:
        if (getDefaultValueBytes().isEmpty() == true) goto L36;
        r102 = r102 + GeneratedMessageV3.computeStringSize(11, this.defaultValue_);
    L36:
        int r106 = r102 + this.unknownFields.getSerializedSize();
        this.memoizedSize = r106;
        return r106;
    L8:
        r102 = 0;
        goto L10
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getTypeUrl() {
        Object r100 = this.typeUrl_;
        if ((r100 instanceof String) == true) goto L5;
        String r101 = ((ByteString) r100).toStringUtf8();
        this.typeUrl_ = r101;
        return r101;
    L5:
        return (String) r100;
    }

    @Override // com.google.protobuf.FieldOrBuilder
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
        int r101 = ((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.kind_) * 37) + 2) * 53) + this.cardinality_) * 37) + 3) * 53) + getNumber()) * 37) + 4) * 53) + getName().hashCode()) * 37) + 6) * 53) + getTypeUrl().hashCode()) * 37) + 7) * 53) + getOneofIndex()) * 37) + 8) * 53) + Internal.hashBoolean(getPacked());
        if (getOptionsCount() <= 0) goto L8;
        r101 = (((r101 * 37) + 9) * 53) + getOptionsList().hashCode();
    L8:
        int r102 = (((((((((r101 * 37) + 10) * 53) + getJsonName().hashCode()) * 37) + 11) * 53) + getDefaultValue().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r102;
        return r102;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Builder.class);
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

    private Field() {
        this.memoizedIsInitialized = -1;
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.number_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.oneofIndex_ = 0;
        this.packed_ = false;
        this.options_ = Collections.emptyList();
        this.jsonName_ = "";
        this.defaultValue_ = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static /* synthetic */ Parser access$1400() {
        return PARSER;
    }

    public static Field getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }

    public static Parser<Field> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getCardinalityValue() {
        return this.cardinality_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getKindValue() {
        return this.kind_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public boolean getPacked() {
        return this.packed_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Field> getParserForType() {
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
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Field getDefaultInstanceForType() {
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

    private Field(GeneratedMessageV3.Builder<?> r100) {
        super(r100);
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ List access$1000(Field r100) {
        return r100.options_;
    }

    public static /* synthetic */ Object access$1100(Field r100) {
        return r100.jsonName_;
    }

    public static /* synthetic */ Object access$1200(Field r100) {
        return r100.defaultValue_;
    }

    public static /* synthetic */ int access$300(Field r100) {
        return r100.kind_;
    }

    public static /* synthetic */ int access$400(Field r100) {
        return r100.cardinality_;
    }

    public static /* synthetic */ Object access$600(Field r100) {
        return r100.name_;
    }

    public static /* synthetic */ Object access$700(Field r100) {
        return r100.typeUrl_;
    }

    public static Builder newBuilder(Field r100) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
    }

    public static Field parseDelimitedFrom(InputStream r100) throws IOException {
        return (Field) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
    }

    public static Field parseFrom(ByteString r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Field) == false) goto L8;
        Field r101 = (Field) r100;
        if (this.kind_ != r101.kind_) goto L12;
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
    L38:
        if (r107 == true) goto L40;
    L42:
        boolean r108 = false;
    L43:
        if (r108 == true) goto L45;
    L47:
        boolean r109 = false;
    L48:
        if (r109 == true) goto L50;
    L52:
        boolean r110 = false;
    L53:
        if (r110 == true) goto L55;
    L57:
        boolean r111 = false;
    L58:
        if (r111 == true) goto L60;
    L62:
        return false;
    L60:
        if (this.unknownFields.equals(r101.unknownFields) == false) goto L62;
        return true;
    L55:
        if (getDefaultValue().equals(r101.getDefaultValue()) == false) goto L57;
        r111 = true;
        goto L58
    L50:
        if (getJsonName().equals(r101.getJsonName()) == false) goto L52;
        r110 = true;
        goto L53
    L45:
        if (getOptionsList().equals(r101.getOptionsList()) == false) goto L47;
        r109 = true;
        goto L48
    L40:
        if (getPacked() != r101.getPacked()) goto L42;
        r108 = true;
        goto L43
    L35:
        if (getOneofIndex() != r101.getOneofIndex()) goto L37;
        r107 = true;
        goto L38
    L30:
        if (getTypeUrl().equals(r101.getTypeUrl()) == false) goto L32;
        r106 = true;
        goto L33
    L25:
        if (getName().equals(r101.getName()) == false) goto L27;
        r105 = true;
        goto L28
    L20:
        if (getNumber() != r101.getNumber()) goto L22;
        r104 = true;
        goto L23
    L15:
        if (this.cardinality_ != r101.cardinality_) goto L17;
        r103 = true;
        goto L18
    L12:
        r102 = false;
        goto L13
    L8:
        return super.equals(r100);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Option getOptions(int r100) {
        return (Option) ListProtector.get(this.options_, r100);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r100) {
        return (OptionOrBuilder) ListProtector.get(this.options_, r100);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
        return new Builder(r100, null);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r100) throws IOException {
        if (this.kind_ == Kind.TYPE_UNKNOWN.getNumber()) goto L6;
        r100.writeEnum(1, this.kind_);
    L6:
        if (this.cardinality_ == Cardinality.CARDINALITY_UNKNOWN.getNumber()) goto L8;
        r100.writeEnum(2, this.cardinality_);
    L8:
        int r101 = this.number_;
        if (r101 == 0) goto L12;
        r100.writeInt32(3, r101);
    L12:
        if (getNameBytes().isEmpty() == true) goto L15;
        GeneratedMessageV3.writeString(r100, 4, this.name_);
    L15:
        if (getTypeUrlBytes().isEmpty() == true) goto L17;
        GeneratedMessageV3.writeString(r100, 6, this.typeUrl_);
    L17:
        int r102 = this.oneofIndex_;
        if (r102 == 0) goto L20;
        r100.writeInt32(7, r102);
    L20:
        boolean r103 = this.packed_;
        if (r103 == false) goto L23;
        r100.writeBool(8, r103);
    L23:
        int r104 = 0;
    L25:
        if (r104 >= this.options_.size()) goto L28;
        r100.writeMessage(9, (MessageLite) ListProtector.get(this.options_, r104));
        r104 = r104 + 1;
        goto L25
    L28:
        if (getJsonNameBytes().isEmpty() == true) goto L31;
        GeneratedMessageV3.writeString(r100, 10, this.jsonName_);
    L31:
        if (getDefaultValueBytes().isEmpty() == true) goto L33;
        GeneratedMessageV3.writeString(r100, 11, this.defaultValue_);
    L33:
        this.unknownFields.writeTo(r100);
    }

    public static Field parseFrom(CodedInputStream r100) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, r100);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
        return newBuilderForType(r100);
    }

    public static Field parseFrom(InputStream r100) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, r100);
    }

    public static Field parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    public static Field parseFrom(byte[] r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    private Field(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        this();
        if (r101 == null) goto L46;
        UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
        boolean r103 = false;
        int r104 = 0;
    L6:
        if (r103 == true) goto L41;
        int r105 = r100.readTag();     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
        switch(r105) {
            case 0: goto L24;
            case 8: goto L22;
            case 16: goto L21;
            case 24: goto L20;
            case 34: goto L19;
            case 50: goto L18;
            case 56: goto L17;
            case 64: goto L16;
            case 74: goto L13;
            case 82: goto L11;
            case 90: goto L10;
            default: goto L25;
        };     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
    L10:
        this.defaultValue_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
        goto L6
    L11:
        this.jsonName_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
        goto L6
    L13:
        if ((r104 & 128) == 128) goto L15;
        this.options_ = new ArrayList();     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
        r104 = r104 | 128;     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
    L15:
        this.options_.add((Option) r100.readMessage(Option.parser(), r101));     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
        goto L6
    L16:
        this.packed_ = r100.readBool();     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
        goto L6
    L17:
        this.oneofIndex_ = r100.readInt32();     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
        goto L6
    L18:
        this.typeUrl_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
        goto L6
    L19:
        this.name_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
        goto L6
    L20:
        this.number_ = r100.readInt32();     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
        goto L6
    L21:
        this.cardinality_ = r100.readEnum();     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
        goto L6
    L22:
        this.kind_ = r100.readEnum();     // Catch: Throwable -> L27 IOException -> L29 InvalidProtocolBufferException -> L32
    L24:
        r103 = true;
        goto L6
    L25:
        if (parseUnknownFieldProto3(r100, r102, r101, r105) == true) goto L6;
    L27:
        th = move-exception;
        if ((r104 & 128) != 128) goto L38;
        this.options_ = Collections.unmodifiableList(this.options_);
    L38:
        this.unknownFields = r102.build();
        makeExtensionsImmutable();
        throw th;
    L32:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L27
    L29:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L27
    L41:
        if ((r104 & 128) != 128) goto L43;
        this.options_ = Collections.unmodifiableList(this.options_);
    L43:
        this.unknownFields = r102.build();
        makeExtensionsImmutable();
        return;
    L46:
        throw null;
    }

    public static /* synthetic */ List access$1002(Field r100, List r101) {
        r100.options_ = r101;
        return r101;
    }

    public static /* synthetic */ Object access$1102(Field r100, Object r101) {
        r100.jsonName_ = r101;
        return r101;
    }

    public static /* synthetic */ Object access$1202(Field r100, Object r101) {
        r100.defaultValue_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$1302(Field r100, int r101) {
        r100.bitField0_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$302(Field r100, int r101) {
        r100.kind_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$402(Field r100, int r101) {
        r100.cardinality_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$502(Field r100, int r101) {
        r100.number_ = r101;
        return r101;
    }

    public static /* synthetic */ Object access$602(Field r100, Object r101) {
        r100.name_ = r101;
        return r101;
    }

    public static /* synthetic */ Object access$702(Field r100, Object r101) {
        r100.typeUrl_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$802(Field r100, int r101) {
        r100.oneofIndex_ = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$902(Field r100, boolean r101) {
        r100.packed_ = r101;
        return r101;
    }

    public static Field parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (Field) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
    }

    public static Field parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public /* synthetic */ Field(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static Field parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
    }

    public static Field parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (Field) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
    }

    public static Field parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public static Field parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public /* synthetic */ Field(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
        this(r100, r101);
    }
}
