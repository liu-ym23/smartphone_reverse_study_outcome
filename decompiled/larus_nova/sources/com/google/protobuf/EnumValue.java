package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class EnumValue extends GeneratedMessageV3 implements EnumValueOrBuilder {
    private static final EnumValue DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final Parser<EnumValue> PARSER = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int number_;
    private List<Option> options_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EnumValueOrBuilder {
        private int bitField0_;
        private Object name_;
        private int number_;
        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;

        public Builder clearNumber() {
            this.number_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 4) == 4) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 4;
            return;
        }

        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> getOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r100 = this.options_;
            if ((this.bitField0_ & 4) != 4) goto L7;
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
        public EnumValue buildPartial() {
            EnumValue r100 = new EnumValue(this, null);
            EnumValue.access$302(r100, this.name_);
            EnumValue.access$402(r100, this.number_);
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r101 = this.optionsBuilder_;
            if (r101 == null) goto L5;
            EnumValue.access$502(r100, r101.build());
        L9:
            EnumValue.access$602(r100, 0);
            onBuilt();
            return r100;
        L5:
            if ((this.bitField0_ & 4) != 4) goto L7;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
        L7:
            EnumValue.access$502(r100, this.options_);
            goto L9
        }

        public Builder clearOptions() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r100 = this.optionsBuilder_;
            if (r100 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
            onChanged();
        L6:
            return this;
        L5:
            r100.clear();
            goto L6
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public String getName() {
            Object r100 = this.name_;
            if ((r100 instanceof String) == true) goto L7;
            String r101 = ((ByteString) r100).toStringUtf8();
            this.name_ = r101;
            return r101;
        L7:
            return (String) r100;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public ByteString getNameBytes() {
            Object r100 = this.name_;
            if ((r100 instanceof String) == false) goto L7;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            this.name_ = r101;
            return r101;
        L7:
            return (ByteString) r100;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r100 = this.optionsBuilder_;
            if (r100 != null) goto L7;
            return this.options_.size();
        L7:
            return r100.getCount();
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r100 = this.optionsBuilder_;
            if (r100 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r100.getMessageList();
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r100 = this.optionsBuilder_;
            if (r100 == null) goto L7;
            return r100.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.options_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public EnumValue build() {
            EnumValue r100 = buildPartial();
            if (r100.isInitialized() == false) goto L6;
            return r100;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.name_ = "";
            this.number_ = 0;
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r100 = this.optionsBuilder_;
            if (r100 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
        L6:
            return this;
        L5:
            r100.clear();
            goto L6
        }

        public Builder clearName() {
            this.name_ = EnumValue.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EnumValue getDefaultInstanceForType() {
            return EnumValue.getDefaultInstance();
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return getOptionsFieldBuilder().getBuilderList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
        }

        @Override // com.google.protobuf.EnumValueOrBuilder
        public int getNumber() {
            return this.number_;
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
            this.name_ = "";
            this.options_ = Collections.emptyList();
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

        @Override // com.google.protobuf.EnumValueOrBuilder
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

        @Override // com.google.protobuf.EnumValueOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r100) {
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r101 = this.optionsBuilder_;
            if (r101 != null) goto L7;
            return (OptionOrBuilder) ListProtector.get(this.options_, r100);
        L7:
            return (OptionOrBuilder) r101.getMessageOrBuilder(r100);
        }

        public Builder mergeFrom(EnumValue r100) {
            if (r100 != EnumValue.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r100.getName().isEmpty() == true) goto L9;
            this.name_ = EnumValue.access$300(r100);
            onChanged();
        L9:
            if (r100.getNumber() == 0) goto L12;
            setNumber(r100.getNumber());
        L12:
            if (this.optionsBuilder_ != null) goto L21;
            if (EnumValue.access$500(r100).isEmpty() == false) goto L16;
        L29:
            mergeUnknownFields(r100.unknownFields);
            onChanged();
            return this;
        L16:
            if (this.options_.isEmpty() == false) goto L18;
            this.options_ = EnumValue.access$500(r100);
            this.bitField0_ &= -5;
        L19:
            onChanged();
            goto L29
        L18:
            ensureOptionsIsMutable();
            this.options_.addAll(EnumValue.access$500(r100));
            goto L19
        L21:
            if (EnumValue.access$500(r100).isEmpty() == true) goto L29;
            if (this.optionsBuilder_.isEmpty() == false) goto L28;
            this.optionsBuilder_.dispose();
            RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> r101 = null;
            this.optionsBuilder_ = null;
            this.options_ = EnumValue.access$500(r100);
            this.bitField0_ &= -5;
            if (GeneratedMessageV3.alwaysUseFieldBuilders == false) goto L27;
            r101 = getOptionsFieldBuilder();
        L27:
            this.optionsBuilder_ = r101;
            goto L29
        L28:
            this.optionsBuilder_.addAllMessages(EnumValue.access$500(r100));
            goto L29
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
            if ((r100 instanceof EnumValue) == true) goto L5;
            super.mergeFrom(r100);
            return this;
        L5:
            return mergeFrom((EnumValue) r100);
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
            EnumValue r102 = null;
            EnumValue r103 = (EnumValue) EnumValue.access$700().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
            EnumValue r104 = (EnumValue) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

    static {
        DEFAULT_INSTANCE = new EnumValue();
        PARSER = new AnonymousClass1();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public String getName() {
        Object r100 = this.name_;
        if ((r100 instanceof String) == true) goto L5;
        String r101 = ((ByteString) r100).toStringUtf8();
        this.name_ = r101;
        return r101;
    L5:
        return (String) r100;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public ByteString getNameBytes() {
        Object r100 = this.name_;
        if ((r100 instanceof String) == false) goto L7;
        ByteString r101 = ByteString.copyFromUtf8((String) r100);
        this.name_ = r101;
        return r101;
    L7:
        return (ByteString) r100;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
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
        if (getNameBytes().isEmpty() == true) goto L8;
        int r102 = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    L9:
        int r103 = this.number_;
        if (r103 == 0) goto L13;
        r102 = r102 + CodedOutputStream.computeInt32Size(2, r103);
    L13:
        if (r101 >= this.options_.size()) goto L15;
        r102 = r102 + CodedOutputStream.computeMessageSize(3, (MessageLite) ListProtector.get(this.options_, r101));
        r101 = r101 + 1;
        goto L13
    L15:
        int r104 = r102 + this.unknownFields.getSerializedSize();
        this.memoizedSize = r104;
        return r104;
    L8:
        r102 = 0;
        goto L9
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r100 = this.memoizedHashCode;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        int r101 = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getNumber();
        if (getOptionsCount() <= 0) goto L8;
        r101 = (((r101 * 37) + 3) * 53) + getOptionsList().hashCode();
    L8:
        int r102 = (r101 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r102;
        return r102;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, Builder.class);
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

    private EnumValue() {
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.number_ = 0;
        this.options_ = Collections.emptyList();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static /* synthetic */ Parser access$700() {
        return PARSER;
    }

    public static EnumValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
    }

    public static Parser<EnumValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<EnumValue> getParserForType() {
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
    public EnumValue getDefaultInstanceForType() {
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

    private EnumValue(GeneratedMessageV3.Builder<?> r100) {
        super(r100);
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ Object access$300(EnumValue r100) {
        return r100.name_;
    }

    public static /* synthetic */ List access$500(EnumValue r100) {
        return r100.options_;
    }

    public static Builder newBuilder(EnumValue r100) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
    }

    public static EnumValue parseDelimitedFrom(InputStream r100) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
    }

    public static EnumValue parseFrom(ByteString r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof EnumValue) == false) goto L8;
        EnumValue r101 = (EnumValue) r100;
        if (getName().equals(r101.getName()) == false) goto L12;
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
        if (getOptionsList().equals(r101.getOptionsList()) == false) goto L22;
        r104 = true;
        goto L23
    L15:
        if (getNumber() != r101.getNumber()) goto L17;
        r103 = true;
        goto L18
    L12:
        r102 = false;
        goto L13
    L8:
        return super.equals(r100);
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public Option getOptions(int r100) {
        return (Option) ListProtector.get(this.options_, r100);
    }

    @Override // com.google.protobuf.EnumValueOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r100) {
        return (OptionOrBuilder) ListProtector.get(this.options_, r100);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
        return new Builder(r100, null);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r100) throws IOException {
        if (getNameBytes().isEmpty() == true) goto L5;
        GeneratedMessageV3.writeString(r100, 1, this.name_);
    L5:
        int r101 = this.number_;
        if (r101 == 0) goto L8;
        r100.writeInt32(2, r101);
    L8:
        int r102 = 0;
    L10:
        if (r102 >= this.options_.size()) goto L12;
        r100.writeMessage(3, (MessageLite) ListProtector.get(this.options_, r102));
        r102 = r102 + 1;
        goto L10
    L12:
        this.unknownFields.writeTo(r100);
    }

    public static EnumValue parseFrom(CodedInputStream r100) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseWithIOException(PARSER, r100);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
        return newBuilderForType(r100);
    }

    public static EnumValue parseFrom(InputStream r100) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseWithIOException(PARSER, r100);
    }

    public static EnumValue parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    public static EnumValue parseFrom(byte[] r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    private EnumValue(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        this();
        if (r101 == null) goto L45;
        UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
        boolean r103 = false;
        int r104 = 0;
    L6:
        if (r103 == true) goto L40;
        int r105 = r100.readTag();     // Catch: Throwable -> L26 IOException -> L28 InvalidProtocolBufferException -> L31
        if (r105 == 0) goto L25;
        if (r105 != 10) goto L12;
        this.name_ = r100.readStringRequireUtf8();     // Catch: Throwable -> L26 IOException -> L28 InvalidProtocolBufferException -> L31
        goto L6
    L12:
        if (r105 != 16) goto L14;
        this.number_ = r100.readInt32();     // Catch: Throwable -> L26 IOException -> L28 InvalidProtocolBufferException -> L31
        goto L6
    L14:
        if (r105 != 26) goto L16;
        if ((r104 & 4) == 4) goto L21;
        this.options_ = new ArrayList();     // Catch: Throwable -> L26 IOException -> L28 InvalidProtocolBufferException -> L31
        r104 = r104 | 4;     // Catch: Throwable -> L26 IOException -> L28 InvalidProtocolBufferException -> L31
    L21:
        this.options_.add((Option) r100.readMessage(Option.parser(), r101));     // Catch: Throwable -> L26 IOException -> L28 InvalidProtocolBufferException -> L31
        goto L6
    L16:
        if (parseUnknownFieldProto3(r100, r102, r101, r105) == true) goto L6;
    L25:
        r103 = true;
        goto L6
    L26:
        th = move-exception;
        if ((r104 & 4) != 4) goto L37;
        this.options_ = Collections.unmodifiableList(this.options_);
    L37:
        this.unknownFields = r102.build();
        makeExtensionsImmutable();
        throw th;
    L28:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L26
    L31:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L26
    L40:
        if ((r104 & 4) != 4) goto L42;
        this.options_ = Collections.unmodifiableList(this.options_);
    L42:
        this.unknownFields = r102.build();
        makeExtensionsImmutable();
        return;
    L45:
        throw null;
    }

    public static /* synthetic */ Object access$302(EnumValue r100, Object r101) {
        r100.name_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$402(EnumValue r100, int r101) {
        r100.number_ = r101;
        return r101;
    }

    public static /* synthetic */ List access$502(EnumValue r100, List r101) {
        r100.options_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$602(EnumValue r100, int r101) {
        r100.bitField0_ = r101;
        return r101;
    }

    public static EnumValue parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
    }

    public static EnumValue parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public /* synthetic */ EnumValue(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static EnumValue parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
    }

    public static EnumValue parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (EnumValue) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
    }

    public static EnumValue parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public static EnumValue parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public /* synthetic */ EnumValue(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
        this(r100, r101);
    }
}
