package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final class FieldDescriptorProto extends com.squareup.wire.Message<FieldDescriptorProto, Builder> {
    public static final ProtoAdapter<FieldDescriptorProto> ADAPTER = null;
    public static final String DEFAULT_DEFAULT_VALUE = "";
    public static final String DEFAULT_EXTENDEE = "";
    public static final String DEFAULT_JSON_NAME = "";
    public static final Label DEFAULT_LABEL = null;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_NUMBER = null;
    public static final Integer DEFAULT_ONEOF_INDEX = null;
    public static final Boolean DEFAULT_PROTO3_OPTIONAL = null;
    public static final Type DEFAULT_TYPE = null;
    public static final String DEFAULT_TYPE_NAME = "";
    private static final long serialVersionUID = 0;
    public final String default_value;
    public final String extendee;
    public final String json_name;
    public final Label label;
    public final String name;
    public final Integer number;
    public final Integer oneof_index;
    public final FieldOptions options;
    public final Boolean proto3_optional;
    public final Type type;
    public final String type_name;

    public static final class Builder extends com.squareup.wire.Message.Builder<FieldDescriptorProto, Builder> {
        public String default_value;
        public String extendee;
        public String json_name;
        public Label label;
        public String name;
        public Integer number;
        public Integer oneof_index;
        public FieldOptions options;
        public Boolean proto3_optional;
        public Type type;
        public String type_name;

        @Override // com.squareup.wire.Message.Builder
        public FieldDescriptorProto build() {
            return new FieldDescriptorProto(this.name, this.number, this.label, this.type, this.type_name, this.extendee, this.default_value, this.oneof_index, this.json_name, this.options, this.proto3_optional, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder default_value(String r100) {
            this.default_value = r100;
            return this;
        }

        public Builder extendee(String r100) {
            this.extendee = r100;
            return this;
        }

        public Builder json_name(String r100) {
            this.json_name = r100;
            return this;
        }

        public Builder label(Label r100) {
            this.label = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder number(Integer r100) {
            this.number = r100;
            return this;
        }

        public Builder oneof_index(Integer r100) {
            this.oneof_index = r100;
            return this;
        }

        public Builder options(FieldOptions r100) {
            this.options = r100;
            return this;
        }

        public Builder proto3_optional(Boolean r100) {
            this.proto3_optional = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder type_name(String r100) {
            this.type_name = r100;
            return this;
        }
    }

    public static final enum Label extends java.lang.Enum<Label> implements WireEnum {
        private static final /* synthetic */ Label[] $VALUES = null;
        public static final ProtoAdapter<Label> ADAPTER = null;
        public static final Label LABEL_OPTIONAL = null;
        public static final Label LABEL_REPEATED = null;
        public static final Label LABEL_REQUIRED = null;
        private final int value;

        static {
            Label r100 = new Label("LABEL_OPTIONAL", 0, 1);
            LABEL_OPTIONAL = r100;
            Label r101 = new Label("LABEL_REQUIRED", 1, 2);
            LABEL_REQUIRED = r101;
            Label r102 = new Label("LABEL_REPEATED", 2, 3);
            LABEL_REPEATED = r102;
            $VALUES = new Label[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Label.class);
        }

        public static Label[] values() {
            return (Label[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Label fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return LABEL_REPEATED;
        L13:
            return LABEL_REQUIRED;
        L15:
            return LABEL_OPTIONAL;
        }

        public static Label valueOf(String r100) {
            return (Label) a.a(Label.class, r100);
        }

        private Label(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_FieldDescriptorProto extends ProtoAdapter<FieldDescriptorProto> {
        public ProtoAdapter_FieldDescriptorProto() {
            super(FieldEncoding.LENGTH_DELIMITED, FieldDescriptorProto.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FieldDescriptorProto decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            r101.number = 0;
            r101.label = Label.LABEL_OPTIONAL;
            r101.type = Type.TYPE_DOUBLE;
            r101.type_name = "";
            r101.extendee = "";
            r101.default_value = "";
            r101.oneof_index = 0;
            r101.json_name = "";
            r101.proto3_optional = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L26;
            if (r103 != 17) goto L7;
            r101.proto3_optional = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L7:
            switch(r103) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L28;
                case 5: goto L30;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                default: goto L8;
            };
        L28:
            r101.label = Label.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            r101.json_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.oneof_index = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.options = FieldOptions.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.default_value = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.type_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.number = ProtoAdapter.INT32.decode(r100);
            goto L3
        L23:
            r101.extendee = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L26:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FieldDescriptorProto r100) {
            String r101 = r100.name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.number;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(3, r104);
        L10:
            int r106 = r103 + r105;
            Label r107 = r100.label;
            if (r107 == null) goto L13;
            int r108 = Label.ADAPTER.encodedSizeWithTag(4, r107);
        L14:
            int r109 = r106 + r108;
            Type r110 = r100.type;
            if (r110 == null) goto L17;
            int r111 = Type.ADAPTER.encodedSizeWithTag(5, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.type_name;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(6, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.extendee;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(2, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.default_value;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Integer r122 = r100.oneof_index;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT32.encodedSizeWithTag(9, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.json_name;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(10, r125);
        L38:
            int r127 = r124 + r126;
            FieldOptions r128 = r100.options;
            if (r128 == null) goto L41;
            int r129 = FieldOptions.ADAPTER.encodedSizeWithTag(8, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.proto3_optional;
            if (r131 == null) goto L46;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r131);
        L46:
            return (r130 + r102) + r100.unknownFields().size();
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FieldDescriptorProto decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FieldDescriptorProto r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FieldDescriptorProto r101) throws IOException {
            String r102 = r101.name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.number;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
        L8:
            Label r104 = r101.label;
            if (r104 == null) goto L11;
            Label.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            Type r105 = r101.type;
            if (r105 == null) goto L14;
            Type.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            String r106 = r101.type_name;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
        L17:
            String r107 = r101.extendee;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r107);
        L20:
            String r108 = r101.default_value;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            Integer r109 = r101.oneof_index;
            if (r109 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 9, r109);
        L26:
            String r110 = r101.json_name;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r110);
        L29:
            FieldOptions r111 = r101.options;
            if (r111 == null) goto L32;
            FieldOptions.ADAPTER.encodeWithTag(r100, 8, r111);
        L32:
            Boolean r112 = r101.proto3_optional;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 17, r112);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FieldDescriptorProto r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends java.lang.Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type TYPE_BOOL = null;
        public static final Type TYPE_BYTES = null;
        public static final Type TYPE_DOUBLE = null;
        public static final Type TYPE_ENUM = null;
        public static final Type TYPE_FIXED32 = null;
        public static final Type TYPE_FIXED64 = null;
        public static final Type TYPE_FLOAT = null;
        public static final Type TYPE_GROUP = null;
        public static final Type TYPE_INT32 = null;
        public static final Type TYPE_INT64 = null;
        public static final Type TYPE_MESSAGE = null;
        public static final Type TYPE_SFIXED32 = null;
        public static final Type TYPE_SFIXED64 = null;
        public static final Type TYPE_SINT32 = null;
        public static final Type TYPE_SINT64 = null;
        public static final Type TYPE_STRING = null;
        public static final Type TYPE_UINT32 = null;
        public static final Type TYPE_UINT64 = null;
        private final int value;

        static {
            Type r100 = new Type("TYPE_DOUBLE", 0, 1);
            TYPE_DOUBLE = r100;
            Type r101 = new Type("TYPE_FLOAT", 1, 2);
            TYPE_FLOAT = r101;
            Type r102 = new Type("TYPE_INT64", 2, 3);
            TYPE_INT64 = r102;
            Type r103 = new Type("TYPE_UINT64", 3, 4);
            TYPE_UINT64 = r103;
            Type r104 = new Type("TYPE_INT32", 4, 5);
            TYPE_INT32 = r104;
            Type r110 = new Type("TYPE_FIXED64", 5, 6);
            TYPE_FIXED64 = r110;
            Type r111 = new Type("TYPE_FIXED32", 6, 7);
            TYPE_FIXED32 = r111;
            Type r112 = new Type("TYPE_BOOL", 7, 8);
            TYPE_BOOL = r112;
            Type r113 = new Type("TYPE_STRING", 8, 9);
            TYPE_STRING = r113;
            Type r114 = new Type("TYPE_GROUP", 9, 10);
            TYPE_GROUP = r114;
            Type r115 = new Type("TYPE_MESSAGE", 10, 11);
            TYPE_MESSAGE = r115;
            Type r105 = new Type("TYPE_BYTES", 11, 12);
            TYPE_BYTES = r105;
            Type r106 = new Type("TYPE_UINT32", 12, 13);
            TYPE_UINT32 = r106;
            Type r107 = new Type("TYPE_ENUM", 13, 14);
            TYPE_ENUM = r107;
            Type r108 = new Type("TYPE_SFIXED32", 14, 15);
            TYPE_SFIXED32 = r108;
            Type r109 = new Type("TYPE_SFIXED64", 15, 16);
            TYPE_SFIXED64 = r109;
            Type r116 = new Type("TYPE_SINT32", 16, 17);
            TYPE_SINT32 = r116;
            Type r117 = new Type("TYPE_SINT64", 17, 18);
            TYPE_SINT64 = r117;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r105, r106, r107, r108, r109, r116, r117};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            switch(r100) {
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
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FieldDescriptorProto();
        DEFAULT_NUMBER = 0;
        DEFAULT_LABEL = Label.LABEL_OPTIONAL;
        DEFAULT_TYPE = Type.TYPE_DOUBLE;
        DEFAULT_ONEOF_INDEX = 0;
        DEFAULT_PROTO3_OPTIONAL = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.number = this.number;
        r100.label = this.label;
        r100.type = this.type;
        r100.type_name = this.type_name;
        r100.extendee = this.extendee;
        r100.default_value = this.default_value;
        r100.oneof_index = this.oneof_index;
        r100.json_name = this.json_name;
        r100.options = this.options;
        r100.proto3_optional = this.proto3_optional;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FieldDescriptorProto.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public FieldDescriptorProto(String r110, Integer r111, Label r112, Type r113, String r114, String r115, String r210, Integer r211, String r212, FieldOptions r213, Boolean r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, okio.ByteString.EMPTY);
    }

    public FieldDescriptorProto(String r100, Integer r101, Label r102, Type r103, String r104, String r105, String r106, Integer r107, String r110, FieldOptions r111, Boolean r112, okio.ByteString r113) {
        super(ADAPTER, r113);
        this.name = r100;
        this.number = r101;
        this.label = r102;
        this.type = r103;
        this.type_name = r104;
        this.extendee = r105;
        this.default_value = r106;
        this.oneof_index = r107;
        this.json_name = r110;
        this.options = r111;
        this.proto3_optional = r112;
    }
}
