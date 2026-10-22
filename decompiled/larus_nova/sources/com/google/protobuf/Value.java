package com.google.protobuf;

import androidx.camera.video.AudioStats;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final class Value extends GeneratedMessageV3 implements ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    private static final Value DEFAULT_INSTANCE = null;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    private static final Parser<Value> PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int kindCase_;
    private Object kind_;
    private byte memoizedIsInitialized;

    /* JADX INFO: renamed from: com.google.protobuf.Value$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Value$KindCase = null;

        static {
            int[] r100 = new int[KindCase.values().length];
            $SwitchMap$com$google$protobuf$Value$KindCase = r100;
            r100[KindCase.NULL_VALUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.NUMBER_VALUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.STRING_VALUE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.BOOL_VALUE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.STRUCT_VALUE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.LIST_VALUE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$google$protobuf$Value$KindCase[KindCase.KIND_NOT_SET.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ValueOrBuilder {
        private int kindCase_;
        private Object kind_;
        private SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> listValueBuilder_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> structValueBuilder_;

        public Builder clearKind() {
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        private SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> getListValueFieldBuilder() {
            if (this.listValueBuilder_ == null) goto L5;
        L8:
            this.kindCase_ = 6;
            onChanged();
            return this.listValueBuilder_;
        L5:
            if (this.kindCase_ == 6) goto L7;
            this.kind_ = ListValue.getDefaultInstance();
        L7:
            this.listValueBuilder_ = new SingleFieldBuilderV3((ListValue) this.kind_, getParentForChildren(), isClean());
            this.kind_ = null;
            goto L8
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getStructValueFieldBuilder() {
            if (this.structValueBuilder_ == null) goto L5;
        L8:
            this.kindCase_ = 5;
            onChanged();
            return this.structValueBuilder_;
        L5:
            if (this.kindCase_ == 5) goto L7;
            this.kind_ = Struct.getDefaultInstance();
        L7:
            this.structValueBuilder_ = new SingleFieldBuilderV3((Struct) this.kind_, getParentForChildren(), isClean());
            this.kind_ = null;
            goto L8
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Value buildPartial() {
            Value r100 = new Value(this, null);
            if (this.kindCase_ != 1) goto L6;
            Value.access$302(r100, this.kind_);
        L6:
            if (this.kindCase_ != 2) goto L9;
            Value.access$302(r100, this.kind_);
        L9:
            if (this.kindCase_ != 3) goto L12;
            Value.access$302(r100, this.kind_);
        L12:
            if (this.kindCase_ != 4) goto L15;
            Value.access$302(r100, this.kind_);
        L15:
            if (this.kindCase_ != 5) goto L21;
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r101 = this.structValueBuilder_;
            if (r101 != null) goto L19;
            Value.access$302(r100, this.kind_);
            goto L21
        L19:
            Value.access$302(r100, r101.build());
        L21:
            if (this.kindCase_ != 6) goto L26;
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r102 = this.listValueBuilder_;
            if (r102 != null) goto L25;
            Value.access$302(r100, this.kind_);
            goto L26
        L25:
            Value.access$302(r100, r102.build());
        L26:
            Value.access$402(r100, this.kindCase_);
            onBuilt();
            return r100;
        }

        public Builder clearBoolValue() {
            if (this.kindCase_ != 4) goto L5;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L5:
            return this;
        }

        public Builder clearListValue() {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r100 = this.listValueBuilder_;
            if (r100 != null) goto L8;
            if (this.kindCase_ != 6) goto L11;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L11:
            return this;
        L8:
            if (this.kindCase_ != 6) goto L10;
            this.kindCase_ = 0;
            this.kind_ = null;
        L10:
            r100.clear();
            goto L11
        }

        public Builder clearNullValue() {
            if (this.kindCase_ != 1) goto L5;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L5:
            return this;
        }

        public Builder clearNumberValue() {
            if (this.kindCase_ != 2) goto L5;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L5:
            return this;
        }

        public Builder clearStringValue() {
            if (this.kindCase_ != 3) goto L5;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L5:
            return this;
        }

        public Builder clearStructValue() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r100 = this.structValueBuilder_;
            if (r100 != null) goto L8;
            if (this.kindCase_ != 5) goto L11;
            this.kindCase_ = 0;
            this.kind_ = null;
            onChanged();
        L11:
            return this;
        L8:
            if (this.kindCase_ != 5) goto L10;
            this.kindCase_ = 0;
            this.kind_ = null;
        L10:
            r100.clear();
            goto L11
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean getBoolValue() {
            if (this.kindCase_ == 4) goto L5;
            return false;
        L5:
            return ((Boolean) this.kind_).booleanValue();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public KindCase getKindCase() {
            return KindCase.forNumber(this.kindCase_);
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ListValue getListValue() {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r100 = this.listValueBuilder_;
            if (r100 != null) goto L11;
            if (this.kindCase_ != 6) goto L9;
            return (ListValue) this.kind_;
        L9:
            return ListValue.getDefaultInstance();
        L11:
            if (this.kindCase_ != 6) goto L15;
            return (ListValue) r100.getMessage();
        L15:
            return ListValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ListValueOrBuilder getListValueOrBuilder() {
            int r100 = this.kindCase_;
            if (r100 != 6) goto L8;
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r101 = this.listValueBuilder_;
            if (r101 == null) goto L8;
            return (ListValueOrBuilder) r101.getMessageOrBuilder();
        L8:
            if (r100 != 6) goto L12;
            return (ListValue) this.kind_;
        L12:
            return ListValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public NullValue getNullValue() {
            if (this.kindCase_ != 1) goto L9;
            NullValue r100 = NullValue.valueOf(((Integer) this.kind_).intValue());
            if (r100 == null) goto L7;
            return r100;
        L7:
            return NullValue.UNRECOGNIZED;
        L9:
            return NullValue.NULL_VALUE;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public int getNullValueValue() {
            if (this.kindCase_ == 1) goto L5;
            return 0;
        L5:
            return ((Integer) this.kind_).intValue();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public double getNumberValue() {
            if (this.kindCase_ == 2) goto L5;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        L5:
            return ((Double) this.kind_).doubleValue();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public String getStringValue() {
            if (this.kindCase_ != 3) goto L5;
            Object r100 = this.kind_;
        L7:
            if ((r100 instanceof String) == true) goto L13;
            String r101 = ((ByteString) r100).toStringUtf8();
            if (this.kindCase_ != 3) goto L11;
            this.kind_ = r101;
        L11:
            return r101;
        L13:
            return (String) r100;
        L5:
            r100 = "";
            goto L7
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public ByteString getStringValueBytes() {
            if (this.kindCase_ != 3) goto L5;
            Object r100 = this.kind_;
        L7:
            if ((r100 instanceof String) == false) goto L13;
            ByteString r101 = ByteString.copyFromUtf8((String) r100);
            if (this.kindCase_ != 3) goto L11;
            this.kind_ = r101;
        L11:
            return r101;
        L13:
            return (ByteString) r100;
        L5:
            r100 = "";
            goto L7
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public Struct getStructValue() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r100 = this.structValueBuilder_;
            if (r100 != null) goto L11;
            if (this.kindCase_ != 5) goto L9;
            return (Struct) this.kind_;
        L9:
            return Struct.getDefaultInstance();
        L11:
            if (this.kindCase_ != 5) goto L15;
            return (Struct) r100.getMessage();
        L15:
            return Struct.getDefaultInstance();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public StructOrBuilder getStructValueOrBuilder() {
            int r100 = this.kindCase_;
            if (r100 != 5) goto L8;
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r101 = this.structValueBuilder_;
            if (r101 == null) goto L8;
            return (StructOrBuilder) r101.getMessageOrBuilder();
        L8:
            if (r100 != 5) goto L12;
            return (Struct) this.kind_;
        L12:
            return Struct.getDefaultInstance();
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasListValue() {
            if (this.kindCase_ != 6) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.ValueOrBuilder
        public boolean hasStructValue() {
            if (this.kindCase_ != 5) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Builder.class);
        }

        private Builder() {
            this.kindCase_ = 0;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Value build() {
            Value r100 = buildPartial();
            if (r100.isInitialized() == false) goto L6;
            return r100;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.kindCase_ = 0;
            this.kind_ = null;
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

        public ListValue.Builder getListValueBuilder() {
            return (ListValue.Builder) getListValueFieldBuilder().getBuilder();
        }

        public Struct.Builder getStructValueBuilder() {
            return (Struct.Builder) getStructValueFieldBuilder().getBuilder();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StructProto.internal_static_google_protobuf_Value_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean r100 = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return StructProto.internal_static_google_protobuf_Value_descriptor;
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
        public Value getDefaultInstanceForType() {
            return Value.getDefaultInstance();
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
            this.kindCase_ = 0;
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

        public Builder mergeFrom(Value r100) {
            if (r100 != Value.getDefaultInstance()) goto L6;
            return this;
        L6:
            switch(AnonymousClass2.$SwitchMap$com$google$protobuf$Value$KindCase[r100.getKindCase().ordinal()]) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                default: goto L14;
            };
        L8:
            mergeListValue(r100.getListValue());
            goto L14
        L9:
            mergeStructValue(r100.getStructValue());
            goto L14
        L10:
            setBoolValue(r100.getBoolValue());
            goto L14
        L11:
            this.kindCase_ = 3;
            this.kind_ = Value.access$300(r100);
            onChanged();
            goto L14
        L12:
            setNumberValue(r100.getNumberValue());
            goto L14
        L13:
            setNullValueValue(r100.getNullValueValue());
        L14:
            mergeUnknownFields(r100.unknownFields);
            onChanged();
            return this;
        }

        public Builder mergeListValue(ListValue r100) {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r101 = this.listValueBuilder_;
            if (r101 != null) goto L12;
            if (this.kindCase_ == 6) goto L7;
        L9:
            this.kind_ = r100;
        L10:
            onChanged();
        L15:
            this.kindCase_ = 6;
            return this;
        L7:
            if (this.kind_ == ListValue.getDefaultInstance()) goto L9;
            this.kind_ = ListValue.newBuilder((ListValue) this.kind_).mergeFrom(r100).buildPartial();
            goto L10
        L12:
            if (this.kindCase_ != 6) goto L14;
            r101.mergeFrom(r100);
        L14:
            this.listValueBuilder_.setMessage(r100);
            goto L15
        }

        public Builder mergeStructValue(Struct r100) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r101 = this.structValueBuilder_;
            if (r101 != null) goto L12;
            if (this.kindCase_ == 5) goto L7;
        L9:
            this.kind_ = r100;
        L10:
            onChanged();
        L15:
            this.kindCase_ = 5;
            return this;
        L7:
            if (this.kind_ == Struct.getDefaultInstance()) goto L9;
            this.kind_ = Struct.newBuilder((Struct) this.kind_).mergeFrom(r100).buildPartial();
            goto L10
        L12:
            if (this.kindCase_ != 5) goto L14;
            r101.mergeFrom(r100);
        L14:
            this.structValueBuilder_.setMessage(r100);
            goto L15
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r100) {
            return (Builder) super.mergeUnknownFields(r100);
        }

        public Builder setBoolValue(boolean r100) {
            this.kindCase_ = 4;
            this.kind_ = Boolean.valueOf(r100);
            onChanged();
            return this;
        }

        public Builder setListValue(ListValue.Builder r100) {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r101 = this.listValueBuilder_;
            if (r101 != null) goto L5;
            this.kind_ = r100.build();
            onChanged();
        L6:
            this.kindCase_ = 6;
            return this;
        L5:
            r101.setMessage(r100.build());
            goto L6
        }

        public Builder setNullValue(NullValue r100) {
            if (r100 == null) goto L6;
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(r100.getNumber());
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setNullValueValue(int r100) {
            this.kindCase_ = 1;
            this.kind_ = Integer.valueOf(r100);
            onChanged();
            return this;
        }

        public Builder setNumberValue(double r100) {
            this.kindCase_ = 2;
            this.kind_ = Double.valueOf(r100);
            onChanged();
            return this;
        }

        public Builder setStringValue(String r100) {
            if (r100 == null) goto L6;
            this.kindCase_ = 3;
            this.kind_ = r100;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setStringValueBytes(ByteString r100) {
            if (r100 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r100);
            this.kindCase_ = 3;
            this.kind_ = r100;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setStructValue(Struct.Builder r100) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r101 = this.structValueBuilder_;
            if (r101 != null) goto L5;
            this.kind_ = r100.build();
            onChanged();
        L6:
            this.kindCase_ = 5;
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
            if ((r100 instanceof Value) == true) goto L5;
            super.mergeFrom(r100);
            return this;
        L5:
            return mergeFrom((Value) r100);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r100) {
            return mergeUnknownFields(r100);
        }

        public Builder setListValue(ListValue r100) {
            SingleFieldBuilderV3<ListValue, ListValue.Builder, ListValueOrBuilder> r101 = this.listValueBuilder_;
            if (r101 != null) goto L8;
            if (r100 == null) goto L7;
            this.kind_ = r100;
            onChanged();
        L9:
            this.kindCase_ = 6;
            return this;
        L7:
            throw null;
        L8:
            r101.setMessage(r100);
            goto L9
        }

        public Builder setStructValue(Struct r100) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> r101 = this.structValueBuilder_;
            if (r101 != null) goto L8;
            if (r100 == null) goto L7;
            this.kind_ = r100;
            onChanged();
        L9:
            this.kindCase_ = 5;
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
            Value r102 = null;
            Value r103 = (Value) Value.access$500().parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
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
            Value r104 = (Value) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

    public static final enum KindCase extends java.lang.Enum<KindCase> implements Internal.EnumLite {
        private static final /* synthetic */ KindCase[] $VALUES = null;
        public static final KindCase BOOL_VALUE = null;
        public static final KindCase KIND_NOT_SET = null;
        public static final KindCase LIST_VALUE = null;
        public static final KindCase NULL_VALUE = null;
        public static final KindCase NUMBER_VALUE = null;
        public static final KindCase STRING_VALUE = null;
        public static final KindCase STRUCT_VALUE = null;
        private final int value;

        static {
            KindCase r100 = new KindCase("NULL_VALUE", 0, 1);
            NULL_VALUE = r100;
            KindCase r101 = new KindCase("NUMBER_VALUE", 1, 2);
            NUMBER_VALUE = r101;
            KindCase r102 = new KindCase("STRING_VALUE", 2, 3);
            STRING_VALUE = r102;
            KindCase r103 = new KindCase("BOOL_VALUE", 3, 4);
            BOOL_VALUE = r103;
            KindCase r104 = new KindCase("STRUCT_VALUE", 4, 5);
            STRUCT_VALUE = r104;
            KindCase r110 = new KindCase("LIST_VALUE", 5, 6);
            LIST_VALUE = r110;
            KindCase r111 = new KindCase("KIND_NOT_SET", 6, 0);
            KIND_NOT_SET = r111;
            $VALUES = new KindCase[]{r100, r101, r102, r103, r104, r110, r111};
        }

        public static KindCase[] values() {
            return (KindCase[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        public static KindCase forNumber(int r100) {
            switch(r100) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return LIST_VALUE;
        L8:
            return STRUCT_VALUE;
        L10:
            return BOOL_VALUE;
        L12:
            return STRING_VALUE;
        L14:
            return NUMBER_VALUE;
        L16:
            return NULL_VALUE;
        L18:
            return KIND_NOT_SET;
        }

        public static KindCase valueOf(String r100) {
            return (KindCase) a.a(KindCase.class, r100);
        }

        public static KindCase valueOf(int r100) {
            return forNumber(r100);
        }

        private KindCase(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        DEFAULT_INSTANCE = new Value();
        PARSER = new AnonymousClass1();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean getBoolValue() {
        if (this.kindCase_ == 4) goto L5;
        return false;
    L5:
        return ((Boolean) this.kind_).booleanValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public KindCase getKindCase() {
        return KindCase.forNumber(this.kindCase_);
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ListValue getListValue() {
        if (this.kindCase_ != 6) goto L7;
        return (ListValue) this.kind_;
    L7:
        return ListValue.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ListValueOrBuilder getListValueOrBuilder() {
        if (this.kindCase_ != 6) goto L7;
        return (ListValue) this.kind_;
    L7:
        return ListValue.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public NullValue getNullValue() {
        if (this.kindCase_ != 1) goto L9;
        NullValue r100 = NullValue.valueOf(((Integer) this.kind_).intValue());
        if (r100 == null) goto L7;
        return r100;
    L7:
        return NullValue.UNRECOGNIZED;
    L9:
        return NullValue.NULL_VALUE;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public int getNullValueValue() {
        if (this.kindCase_ == 1) goto L5;
        return 0;
    L5:
        return ((Integer) this.kind_).intValue();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public double getNumberValue() {
        if (this.kindCase_ == 2) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        return ((Double) this.kind_).doubleValue();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r100 = this.memoizedSize;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        int r101 = 0;
        if (this.kindCase_ != 1) goto L9;
        r101 = 0 + CodedOutputStream.computeEnumSize(1, ((Integer) this.kind_).intValue());
    L9:
        if (this.kindCase_ != 2) goto L12;
        r101 = r101 + CodedOutputStream.computeDoubleSize(2, ((Double) this.kind_).doubleValue());
    L12:
        if (this.kindCase_ != 3) goto L15;
        r101 = r101 + GeneratedMessageV3.computeStringSize(3, this.kind_);
    L15:
        if (this.kindCase_ != 4) goto L18;
        r101 = r101 + CodedOutputStream.computeBoolSize(4, ((Boolean) this.kind_).booleanValue());
    L18:
        if (this.kindCase_ != 5) goto L21;
        r101 = r101 + CodedOutputStream.computeMessageSize(5, (Struct) this.kind_);
    L21:
        if (this.kindCase_ != 6) goto L23;
        r101 = r101 + CodedOutputStream.computeMessageSize(6, (ListValue) this.kind_);
    L23:
        int r102 = r101 + this.unknownFields.getSerializedSize();
        this.memoizedSize = r102;
        return r102;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public String getStringValue() {
        if (this.kindCase_ != 3) goto L5;
        Object r100 = this.kind_;
    L7:
        if ((r100 instanceof String) == true) goto L9;
        String r101 = ((ByteString) r100).toStringUtf8();
        if (this.kindCase_ != 3) goto L13;
        this.kind_ = r101;
    L13:
        return r101;
    L9:
        return (String) r100;
    L5:
        r100 = "";
        goto L7
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public ByteString getStringValueBytes() {
        if (this.kindCase_ != 3) goto L5;
        Object r100 = this.kind_;
    L7:
        if ((r100 instanceof String) == false) goto L13;
        ByteString r101 = ByteString.copyFromUtf8((String) r100);
        if (this.kindCase_ != 3) goto L11;
        this.kind_ = r101;
    L11:
        return r101;
    L13:
        return (ByteString) r100;
    L5:
        r100 = "";
        goto L7
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public Struct getStructValue() {
        if (this.kindCase_ != 5) goto L7;
        return (Struct) this.kind_;
    L7:
        return Struct.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public StructOrBuilder getStructValueOrBuilder() {
        if (this.kindCase_ != 5) goto L7;
        return (Struct) this.kind_;
    L7:
        return Struct.getDefaultInstance();
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasListValue() {
        if (this.kindCase_ != 6) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.ValueOrBuilder
    public boolean hasStructValue() {
        if (this.kindCase_ != 5) goto L5;
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
        switch(this.kindCase_) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L15;
        };
    L8:
        int r102 = ((r101 * 37) + 6) * 53;
        int r103 = getListValue().hashCode();
    L14:
        r101 = r102 + r103;
        goto L15
    L9:
        r102 = ((r101 * 37) + 5) * 53;
        r103 = getStructValue().hashCode();
        goto L14
    L10:
        r102 = ((r101 * 37) + 4) * 53;
        r103 = Internal.hashBoolean(getBoolValue());
        goto L14
    L11:
        r102 = ((r101 * 37) + 3) * 53;
        r103 = getStringValue().hashCode();
        goto L14
    L12:
        r102 = ((r101 * 37) + 2) * 53;
        r103 = Internal.hashLong(Double.doubleToLongBits(getNumberValue()));
        goto L14
    L13:
        r102 = ((r101 * 37) + 1) * 53;
        r103 = getNullValueValue();
    L15:
        int r104 = (r101 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = r104;
        return r104;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Value.class, Builder.class);
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

    private Value() {
        this.kindCase_ = 0;
        this.memoizedIsInitialized = -1;
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

    public static Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Value_descriptor;
    }

    public static Parser<Value> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Value> getParserForType() {
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
    public Value getDefaultInstanceForType() {
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

    private Value(GeneratedMessageV3.Builder<?> r100) {
        super(r100);
        this.kindCase_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ Object access$300(Value r100) {
        return r100.kind_;
    }

    public static Builder newBuilder(Value r100) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r100);
    }

    public static Value parseDelimitedFrom(InputStream r100) throws IOException {
        return (Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100);
    }

    public static Value parseFrom(ByteString r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Value) == false) goto L8;
        Value r101 = (Value) r100;
        if (getKindCase().equals(r101.getKindCase()) == false) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == true) goto L16;
        return false;
    L16:
        switch(this.kindCase_) {
            case 1: goto L39;
            case 2: goto L35;
            case 3: goto L31;
            case 4: goto L27;
            case 5: goto L23;
            case 6: goto L18;
            default: goto L43;
        };
    L18:
        if (r102 == true) goto L20;
    L22:
        r102 = false;
        goto L43
    L20:
        if (getListValue().equals(r101.getListValue()) == false) goto L22;
    L21:
        r102 = true;
        goto L43
    L23:
        if (r102 == false) goto L22;
        if (getStructValue().equals(r101.getStructValue()) == false) goto L22;
    L27:
        if (r102 == false) goto L22;
        if (getBoolValue() != r101.getBoolValue()) goto L22;
    L31:
        if (r102 == false) goto L22;
        if (getStringValue().equals(r101.getStringValue()) == false) goto L22;
    L35:
        if (r102 == false) goto L22;
        if (Double.doubleToLongBits(getNumberValue()) != Double.doubleToLongBits(r101.getNumberValue())) goto L22;
    L39:
        if (r102 == false) goto L22;
        if (getNullValueValue() != r101.getNullValueValue()) goto L22;
    L43:
        if (r102 == true) goto L45;
    L47:
        return false;
    L45:
        if (this.unknownFields.equals(r101.unknownFields) == false) goto L47;
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
        if (this.kindCase_ != 1) goto L6;
        r100.writeEnum(1, ((Integer) this.kind_).intValue());
    L6:
        if (this.kindCase_ != 2) goto L9;
        r100.writeDouble(2, ((Double) this.kind_).doubleValue());
    L9:
        if (this.kindCase_ != 3) goto L12;
        GeneratedMessageV3.writeString(r100, 3, this.kind_);
    L12:
        if (this.kindCase_ != 4) goto L15;
        r100.writeBool(4, ((Boolean) this.kind_).booleanValue());
    L15:
        if (this.kindCase_ != 5) goto L18;
        r100.writeMessage(5, (Struct) this.kind_);
    L18:
        if (this.kindCase_ != 6) goto L20;
        r100.writeMessage(6, (ListValue) this.kind_);
    L20:
        this.unknownFields.writeTo(r100);
    }

    public static Value parseFrom(CodedInputStream r100) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, r100);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r100) {
        return newBuilderForType(r100);
    }

    public static Value parseFrom(InputStream r100) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, r100);
    }

    public static Value parseFrom(ByteBuffer r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    public static Value parseFrom(byte[] r100) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100);
    }

    private Value(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        this();
        if (r101 == null) goto L57;
        UnknownFieldSet.Builder r102 = UnknownFieldSet.newBuilder();
        boolean r103 = false;
    L5:
        if (r103 == true) goto L55;
        int r104 = r100.readTag();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        if (r104 == 0) goto L44;
        if (r104 != 8) goto L11;
        int r105 = r100.readEnum();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.kindCase_ = 1;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.kind_ = Integer.valueOf(r105);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        goto L5
    L11:
        if (r104 != 17) goto L13;
        this.kindCase_ = 2;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.kind_ = Double.valueOf(r100.readDouble());     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        goto L5
    L13:
        if (r104 != 26) goto L15;
        String r106 = r100.readStringRequireUtf8();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.kindCase_ = 3;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.kind_ = r106;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        goto L5
    L15:
        if (r104 != 32) goto L17;
        this.kindCase_ = 4;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.kind_ = Boolean.valueOf(r100.readBool());     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        goto L5
    L17:
        if (r104 != 42) goto L19;
        if (this.kindCase_ != 5) goto L34;
        Struct.Builder r107 = ((Struct) this.kind_).toBuilder();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
    L35:
        MessageLite r108 = r100.readMessage(Struct.parser(), r101);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.kind_ = r108;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        if (r107 == null) goto L38;
        r107.mergeFrom((Struct) r108);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.kind_ = r107.buildPartial();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
    L38:
        this.kindCase_ = 5;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        goto L5
    L34:
        r107 = null;
        goto L35
    L19:
        if (r104 != 50) goto L21;
        if (this.kindCase_ != 6) goto L26;
        ListValue.Builder r109 = ((ListValue) this.kind_).toBuilder();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
    L27:
        MessageLite r110 = r100.readMessage(ListValue.parser(), r101);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.kind_ = r110;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        if (r109 == null) goto L30;
        r109.mergeFrom((ListValue) r110);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.kind_ = r109.buildPartial();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
    L30:
        this.kindCase_ = 6;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        goto L5
    L26:
        r109 = null;
        goto L27
    L21:
        if (parseUnknownFieldProto3(r100, r102, r101, r104) == true) goto L5;
    L44:
        r103 = true;
        goto L5
    L45:
        th = move-exception;
        this.unknownFields = r102.build();
        makeExtensionsImmutable();
        throw th;
    L50:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L45
    L47:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L45
    L55:
        this.unknownFields = r102.build();
        makeExtensionsImmutable();
        return;
    L57:
        throw null;
    }

    public static /* synthetic */ Object access$302(Value r100, Object r101) {
        r100.kind_ = r101;
        return r101;
    }

    public static /* synthetic */ int access$402(Value r100, int r101) {
        r100.kindCase_ = r101;
        return r101;
    }

    public static Value parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (Value) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r100, r101);
    }

    public static Value parseFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public /* synthetic */ Value(GeneratedMessageV3.Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static Value parseFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
    }

    public static Value parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
        return (Value) GeneratedMessageV3.parseWithIOException(PARSER, r100, r101);
    }

    public static Value parseFrom(ByteBuffer r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public static Value parseFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(r100, r101);
    }

    public /* synthetic */ Value(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
        this(r100, r101);
    }
}
