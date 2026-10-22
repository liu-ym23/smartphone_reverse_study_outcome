package com.bytedance.lark.pb.contact.v1;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateChatterRequest extends Message<UpdateChatterRequest, Builder> {
    public static final ProtoAdapter<UpdateChatterRequest> ADAPTER = null;
    public static final String DEFAULT_CHATTER_ID = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Chatter.Description.Type DEFAULT_DESCRIPTION_TYPE = null;
    public static final ByteString DEFAULT_ICON_DATA = null;
    public static final String DEFAULT_ICON_KEY = "";
    public static final String DEFAULT_STATION = "";
    public static final String DEFAULT_TIME_ZONE = "";
    public static final ProtoAdapter_UpdateChatterRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chatter_id;
    public final String description;
    public final Chatter.Description.Type description_type;
    public final Map<String, ExtAttrValue> ext_attr;
    public final ByteString icon_data;
    public final String icon_key;
    public final Chatter.BotMutedInfo muted_info;
    public final String station;
    public final String time_zone;

    public static final class Builder extends Message.Builder<UpdateChatterRequest, Builder> implements d<UpdateChatterRequest> {
        public String chatter_id;
        public String description;
        public Chatter.Description.Type description_type;
        public Map<String, ExtAttrValue> ext_attr;
        public ByteString icon_data;
        public String icon_key;
        public Chatter.BotMutedInfo muted_info;
        public String station;
        public String time_zone;

        @Override // com.squareup.wire.Message.Builder
        public UpdateChatterRequest build() {
            return new UpdateChatterRequest(this.description, this.description_type, this.icon_data, this.icon_key, this.time_zone, this.chatter_id, this.muted_info, this.station, this.ext_attr, super.buildUnknownFields());
        }

        public Builder() {
            this.ext_attr = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatter_id(String r100) {
            this.chatter_id = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder description_type(Chatter.Description.Type r100) {
            this.description_type = r100;
            return this;
        }

        public Builder ext_attr(Map<String, ExtAttrValue> r100) {
            Internal.checkElementsNotNull(r100);
            this.ext_attr = r100;
            return this;
        }

        public Builder icon_data(ByteString r100) {
            this.icon_data = r100;
            return this;
        }

        public Builder icon_key(String r100) {
            this.icon_key = r100;
            return this;
        }

        public Builder muted_info(Chatter.BotMutedInfo r100) {
            this.muted_info = r100;
            return this;
        }

        public Builder station(String r100) {
            this.station = r100;
            return this;
        }

        public Builder time_zone(String r100) {
            this.time_zone = r100;
            return this;
        }
    }

    public static final class ExtAttrValue extends Message<ExtAttrValue, Builder> {
        public static final ProtoAdapter<ExtAttrValue> ADAPTER = null;
        public static final String DEFAULT_EXTENSION_NUMBER = "";
        public static final String DEFAULT_LINK = "";
        public static final String DEFAULT_PHONE_NUMBER = "";
        public static final String DEFAULT_TEXT = "";
        public static final FieldValueType DEFAULT_VALUETYPE = null;
        private static final long serialVersionUID = 0;
        public final String extension_number;
        public final String link;
        public final String phone_number;
        public final String text;
        public final FieldValueType valueType;

        public static final class Builder extends Message.Builder<ExtAttrValue, Builder> {
            public String extension_number;
            public String link;
            public String phone_number;
            public String text;
            public FieldValueType valueType;

            @Override // com.squareup.wire.Message.Builder
            public ExtAttrValue build() {
                return new ExtAttrValue(this.text, this.link, this.phone_number, this.extension_number, this.valueType, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder extension_number(String r100) {
                this.extension_number = r100;
                return this;
            }

            public Builder link(String r100) {
                this.link = r100;
                return this;
            }

            public Builder phone_number(String r100) {
                this.phone_number = r100;
                return this;
            }

            public Builder text(String r100) {
                this.text = r100;
                return this;
            }

            public Builder valueType(FieldValueType r100) {
                this.valueType = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ExtAttrValue extends ProtoAdapter<ExtAttrValue> {
            public ProtoAdapter_ExtAttrValue() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtAttrValue.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ExtAttrValue decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.text = "";
                r101.link = "";
                r101.phone_number = "";
                r101.extension_number = "";
                r101.valueType = FieldValueType.Field_Value_UNKNOWN;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.link = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.valueType = FieldValueType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.phone_number = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.extension_number = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L24:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ExtAttrValue r100) {
                String r101 = r100.text;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.link;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.phone_number;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(4, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.extension_number;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(5, r110);
            L18:
                int r112 = r109 + r111;
                FieldValueType r113 = r100.valueType;
                if (r113 == null) goto L22;
                r102 = FieldValueType.ADAPTER.encodedSizeWithTag(3, r113);
            L22:
                return (r112 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ ExtAttrValue decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ExtAttrValue r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ExtAttrValue r101) throws IOException {
                String r102 = r101.text;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.link;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.phone_number;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
            L11:
                String r105 = r101.extension_number;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
            L14:
                FieldValueType r106 = r101.valueType;
                if (r106 == null) goto L17;
                FieldValueType.ADAPTER.encodeWithTag(r100, 3, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtAttrValue r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ExtAttrValue();
            DEFAULT_VALUETYPE = FieldValueType.Field_Value_UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.text = this.text;
            r100.link = this.link;
            r100.phone_number = this.phone_number;
            r100.extension_number = this.extension_number;
            r100.valueType = this.valueType;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ExtAttrValue.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ExtAttrValue(String r100, String r101, String r110, String r111, FieldValueType r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public ExtAttrValue(String r100, String r101, String r102, String r103, FieldValueType r104, ByteString r105) {
            super(ADAPTER, r105);
            this.text = r100;
            this.link = r101;
            this.phone_number = r102;
            this.extension_number = r103;
            this.valueType = r104;
        }
    }

    public static final enum FieldValueType extends Enum<FieldValueType> implements WireEnum {
        private static final /* synthetic */ FieldValueType[] $VALUES = null;
        public static final ProtoAdapter<FieldValueType> ADAPTER = null;
        public static final FieldValueType FieldValue_CUSTOM_PHONE = null;
        public static final FieldValueType FieldValue_LINK = null;
        public static final FieldValueType FieldValue_TEXT = null;
        public static final FieldValueType Field_Value_UNKNOWN = null;
        private final int value;

        static {
            FieldValueType r100 = new FieldValueType("Field_Value_UNKNOWN", 0, 0);
            Field_Value_UNKNOWN = r100;
            FieldValueType r101 = new FieldValueType("FieldValue_TEXT", 1, 1);
            FieldValue_TEXT = r101;
            FieldValueType r102 = new FieldValueType("FieldValue_LINK", 2, 2);
            FieldValue_LINK = r102;
            FieldValueType r103 = new FieldValueType("FieldValue_CUSTOM_PHONE", 3, 9);
            FieldValue_CUSTOM_PHONE = r103;
            $VALUES = new FieldValueType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(FieldValueType.class);
        }

        public static FieldValueType[] values() {
            return (FieldValueType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FieldValueType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 9) goto L12;
            return null;
        L12:
            return FieldValue_CUSTOM_PHONE;
        L14:
            return FieldValue_LINK;
        L16:
            return FieldValue_TEXT;
        L18:
            return Field_Value_UNKNOWN;
        }

        public static FieldValueType valueOf(String r100) {
            return (FieldValueType) a.a(FieldValueType.class, r100);
        }

        private FieldValueType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_UpdateChatterRequest extends ProtoAdapter<UpdateChatterRequest> implements c<UpdateChatterRequest> {
        private final ProtoAdapter<Map<String, ExtAttrValue>> ext_attr;

        public ProtoAdapter_UpdateChatterRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateChatterRequest.class);
            this.ext_attr = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ExtAttrValue.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateChatterRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.description = "";
            r101.description_type = Chatter.Description.Type.ON_DEFAULT;
            r101.icon_data = ByteString.EMPTY;
            r101.icon_key = "";
            r101.time_zone = "";
            r101.chatter_id = "";
            r101.station = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L21;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r101.description_type = Chatter.Description.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.ext_attr.putAll(this.ext_attr.decode(r100));
            goto L3
        L8:
            r101.station = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.muted_info = Chatter.BotMutedInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.time_zone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.icon_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.icon_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L18:
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateChatterRequest r100) {
            String r101 = r100.description;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Chatter.Description.Type r104 = r100.description_type;
            if (r104 == null) goto L9;
            int r105 = Chatter.Description.Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ByteString r107 = r100.icon_data;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.icon_key;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.time_zone;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.chatter_id;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Chatter.BotMutedInfo r119 = r100.muted_info;
            if (r119 == null) goto L29;
            int r120 = Chatter.BotMutedInfo.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.station;
            if (r122 == null) goto L34;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            return ((r121 + r102) + this.ext_attr.encodedSizeWithTag(9, r100.ext_attr)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ UpdateChatterRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateChatterRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateChatterRequest r101) throws IOException {
            String r102 = r101.description;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Chatter.Description.Type r103 = r101.description_type;
            if (r103 == null) goto L8;
            Chatter.Description.Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ByteString r104 = r101.icon_data;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.icon_key;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.time_zone;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.chatter_id;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            Chatter.BotMutedInfo r108 = r101.muted_info;
            if (r108 == null) goto L23;
            Chatter.BotMutedInfo.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.station;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            this.ext_attr.encodeWithTag(r100, 9, r101.ext_attr);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateChatterRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateChatterRequest r100 = new ProtoAdapter_UpdateChatterRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DESCRIPTION_TYPE = Chatter.Description.Type.ON_DEFAULT;
        DEFAULT_ICON_DATA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.description = this.description;
        r100.description_type = this.description_type;
        r100.icon_data = this.icon_data;
        r100.icon_key = this.icon_key;
        r100.time_zone = this.time_zone;
        r100.chatter_id = this.chatter_id;
        r100.muted_info = this.muted_info;
        r100.station = this.station;
        r100.ext_attr = Internal.copyOf("ext_attr", this.ext_attr);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateChatterRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateChatterRequest(String r110, Chatter.Description.Type r111, ByteString r112, String r113, String r114, String r115, Chatter.BotMutedInfo r116, String r117, Map<String, ExtAttrValue> r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public UpdateChatterRequest(String r100, Chatter.Description.Type r101, ByteString r102, String r103, String r104, String r105, Chatter.BotMutedInfo r106, String r107, Map<String, ExtAttrValue> r110, ByteString r111) {
        super(ADAPTER, r111);
        this.description = r100;
        this.description_type = r101;
        this.icon_data = r102;
        this.icon_key = r103;
        this.time_zone = r104;
        this.chatter_id = r105;
        this.muted_info = r106;
        this.station = r107;
        this.ext_attr = Internal.immutableCopyOf("ext_attr", r110);
    }
}
