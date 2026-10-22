package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class AvatarMeta extends com.squareup.wire.Message<AvatarMeta, Builder> {
    public static final ProtoAdapter<AvatarMeta> ADAPTER = null;
    public static final Integer DEFAULT_BACKGROUND_COLOR = null;
    public static final Integer DEFAULT_BORDER_COLOR = null;
    public static final Integer DEFAULT_CENTER_COLOR = null;
    public static final Integer DEFAULT_COLOR = null;
    public static final Integer DEFAULT_END_COLOR = null;
    public static final Integer DEFAULT_START_COLOR = null;
    public static final AvatarStyleType DEFAULT_STYLE_TYPE = null;
    public static final String DEFAULT_TEXT = "";
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Integer background_color;
    public final Integer border_color;
    public final Integer center_color;
    public final List<CollageData> collage_data;
    public final Integer color;
    public final Integer end_color;
    public final RichText rich_text;
    public final Integer start_color;
    public final AvatarStyleType style_type;
    public final String text;
    public final Type type;

    public static final enum AvatarStyleType extends Enum<AvatarStyleType> implements WireEnum {
        private static final /* synthetic */ AvatarStyleType[] $VALUES = null;
        public static final ProtoAdapter<AvatarStyleType> ADAPTER = null;
        public static final AvatarStyleType BORDER = null;
        public static final AvatarStyleType FILL = null;
        public static final AvatarStyleType UNKNOWN_STYLE = null;
        private final int value;

        static {
            AvatarStyleType r100 = new AvatarStyleType("UNKNOWN_STYLE", 0, 0);
            UNKNOWN_STYLE = r100;
            AvatarStyleType r101 = new AvatarStyleType("FILL", 1, 1);
            FILL = r101;
            AvatarStyleType r102 = new AvatarStyleType("BORDER", 2, 2);
            BORDER = r102;
            $VALUES = new AvatarStyleType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(AvatarStyleType.class);
        }

        public static AvatarStyleType[] values() {
            return (AvatarStyleType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AvatarStyleType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return BORDER;
        L12:
            return FILL;
        L14:
            return UNKNOWN_STYLE;
        }

        public static AvatarStyleType valueOf(String r100) {
            return (AvatarStyleType) a.a(AvatarStyleType.class, r100);
        }

        private AvatarStyleType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<AvatarMeta, Builder> {
        public Integer background_color;
        public Integer border_color;
        public Integer center_color;
        public List<CollageData> collage_data;
        public Integer color;
        public Integer end_color;
        public RichText rich_text;
        public Integer start_color;
        public AvatarStyleType style_type;
        public String text;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public AvatarMeta build() {
            Type r100 = this.type;
            if (r100 == null) goto L7;
            return new AvatarMeta(this.type, this.color, this.text, this.border_color, this.background_color, this.center_color, this.start_color, this.end_color, this.style_type, this.collage_data, this.rich_text, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
            this.collage_data = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder background_color(Integer r100) {
            this.background_color = r100;
            return this;
        }

        public Builder border_color(Integer r100) {
            this.border_color = r100;
            return this;
        }

        public Builder center_color(Integer r100) {
            this.center_color = r100;
            return this;
        }

        public Builder collage_data(List<CollageData> r100) {
            Internal.checkElementsNotNull(r100);
            this.collage_data = r100;
            return this;
        }

        public Builder color(Integer r100) {
            this.color = r100;
            return this;
        }

        public Builder end_color(Integer r100) {
            this.end_color = r100;
            return this;
        }

        public Builder rich_text(RichText r100) {
            this.rich_text = r100;
            return this;
        }

        public Builder start_color(Integer r100) {
            this.start_color = r100;
            return this;
        }

        public Builder style_type(AvatarStyleType r100) {
            this.style_type = r100;
            return this;
        }

        public Builder text(String r100) {
            this.text = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class CollageData extends com.squareup.wire.Message<CollageData, Builder> {
        public static final ProtoAdapter<CollageData> ADAPTER = null;
        public static final String DEFAULT_AVATAR_KEY = "";
        public static final Long DEFAULT_USER_ID = null;
        private static final long serialVersionUID = 0;
        public final String avatar_key;
        public final Long user_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<CollageData, Builder> {
            public String avatar_key;
            public Long user_id;

            @Override // com.squareup.wire.Message.Builder
            public CollageData build() {
                return new CollageData(this.user_id, this.avatar_key, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder avatar_key(String r100) {
                this.avatar_key = r100;
                return this;
            }

            public Builder user_id(Long r100) {
                this.user_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CollageData extends ProtoAdapter<CollageData> {
            public ProtoAdapter_CollageData() {
                super(FieldEncoding.LENGTH_DELIMITED, CollageData.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CollageData decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.user_id = 0L;
                r101.avatar_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.user_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.avatar_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CollageData r100) {
                Long r101 = r100.user_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.avatar_key;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CollageData decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CollageData r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CollageData r101) throws IOException {
                Long r102 = r101.user_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.avatar_key;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CollageData r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CollageData();
            DEFAULT_USER_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_id = this.user_id;
            r100.avatar_key = this.avatar_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CollageData.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CollageData(Long r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public CollageData(Long r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.user_id = r100;
            this.avatar_key = r101;
        }
    }

    public static final class ProtoAdapter_AvatarMeta extends ProtoAdapter<AvatarMeta> {
        public ProtoAdapter_AvatarMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, AvatarMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AvatarMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.UNKNOWN;
            r101.color = 0;
            r101.text = "";
            r101.border_color = 0;
            r101.background_color = 0;
            r101.center_color = 0;
            r101.start_color = 0;
            r101.end_color = 0;
            r101.style_type = AvatarStyleType.UNKNOWN_STYLE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            switch(r103) {
                case 1: goto L26;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L6;
                case 5: goto L17;
                case 6: goto L6;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L28;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L26:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L28:
            r101.style_type = AvatarStyleType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.rich_text = RichText.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.collage_data.add(CollageData.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.end_color = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.start_color = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.center_color = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.background_color = ProtoAdapter.INT32.decode(r100);
            goto L3
        L17:
            r101.border_color = ProtoAdapter.INT32.decode(r100);
            goto L3
        L18:
            r101.text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.color = ProtoAdapter.INT32.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AvatarMeta r100) {
            int r101 = Type.ADAPTER.encodedSizeWithTag(1, r100.type);
            Integer r102 = r100.color;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.text;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Integer r109 = r100.border_color;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.INT32.encodedSizeWithTag(5, r109);
        L14:
            int r111 = r108 + r110;
            Integer r112 = r100.background_color;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.INT32.encodedSizeWithTag(7, r112);
        L18:
            int r114 = r111 + r113;
            Integer r115 = r100.center_color;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.INT32.encodedSizeWithTag(8, r115);
        L22:
            int r117 = r114 + r116;
            Integer r118 = r100.start_color;
            if (r118 == null) goto L25;
            int r119 = ProtoAdapter.INT32.encodedSizeWithTag(9, r118);
        L26:
            int r120 = r117 + r119;
            Integer r121 = r100.end_color;
            if (r121 == null) goto L29;
            int r122 = ProtoAdapter.INT32.encodedSizeWithTag(10, r121);
        L30:
            int r123 = r120 + r122;
            AvatarStyleType r124 = r100.style_type;
            if (r124 == null) goto L33;
            int r125 = AvatarStyleType.ADAPTER.encodedSizeWithTag(11, r124);
        L34:
            int r126 = (r123 + r125) + CollageData.ADAPTER.asRepeated().encodedSizeWithTag(12, r100.collage_data);
            RichText r127 = r100.rich_text;
            if (r127 == null) goto L38;
            r103 = RichText.ADAPTER.encodedSizeWithTag(13, r127);
        L38:
            return (r126 + r103) + r100.unknownFields().size();
        L33:
            r125 = 0;
            goto L34
        L29:
            r122 = 0;
            goto L30
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AvatarMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AvatarMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AvatarMeta r101) throws IOException {
            Type.ADAPTER.encodeWithTag(r100, 1, r101.type);
            Integer r102 = r101.color;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.text;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            Integer r104 = r101.border_color;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r104);
        L11:
            Integer r105 = r101.background_color;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r105);
        L14:
            Integer r106 = r101.center_color;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r106);
        L17:
            Integer r107 = r101.start_color;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 9, r107);
        L20:
            Integer r108 = r101.end_color;
            if (r108 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 10, r108);
        L23:
            AvatarStyleType r109 = r101.style_type;
            if (r109 == null) goto L26;
            AvatarStyleType.ADAPTER.encodeWithTag(r100, 11, r109);
        L26:
            CollageData.ADAPTER.asRepeated().encodeWithTag(r100, 12, r101.collage_data);
            RichText r110 = r101.rich_text;
            if (r110 == null) goto L29;
            RichText.ADAPTER.encodeWithTag(r100, 13, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AvatarMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type COLLAGE = null;
        public static final Type RANDOM = null;
        public static final Type UNKNOWN = null;
        public static final Type UPLOAD = null;
        public static final Type WORDS = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("RANDOM", 1, 1);
            RANDOM = r101;
            Type r102 = new Type("WORDS", 2, 2);
            WORDS = r102;
            Type r103 = new Type("UPLOAD", 3, 3);
            UPLOAD = r103;
            Type r104 = new Type("COLLAGE", 4, 4);
            COLLAGE = r104;
            $VALUES = new Type[]{r100, r101, r102, r103, r104};
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
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return COLLAGE;
        L16:
            return UPLOAD;
        L18:
            return WORDS;
        L20:
            return RANDOM;
        L22:
            return UNKNOWN;
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
        ADAPTER = new ProtoAdapter_AvatarMeta();
        DEFAULT_TYPE = Type.UNKNOWN;
        DEFAULT_COLOR = 0;
        DEFAULT_BORDER_COLOR = 0;
        DEFAULT_BACKGROUND_COLOR = 0;
        DEFAULT_CENTER_COLOR = 0;
        DEFAULT_START_COLOR = 0;
        DEFAULT_END_COLOR = 0;
        DEFAULT_STYLE_TYPE = AvatarStyleType.UNKNOWN_STYLE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.color = this.color;
        r100.text = this.text;
        r100.border_color = this.border_color;
        r100.background_color = this.background_color;
        r100.center_color = this.center_color;
        r100.start_color = this.start_color;
        r100.end_color = this.end_color;
        r100.style_type = this.style_type;
        r100.collage_data = Internal.copyOf("collage_data", this.collage_data);
        r100.rich_text = this.rich_text;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AvatarMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AvatarMeta(Type r110, Integer r111, String r112, Integer r113, Integer r114, Integer r115, Integer r210, Integer r211, AvatarStyleType r212, List<CollageData> r213, RichText r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public AvatarMeta(Type r100, Integer r101, String r102, Integer r103, Integer r104, Integer r105, Integer r106, Integer r107, AvatarStyleType r110, List<CollageData> r111, RichText r112, ByteString r113) {
        super(ADAPTER, r113);
        this.type = r100;
        this.color = r101;
        this.text = r102;
        this.border_color = r103;
        this.background_color = r104;
        this.center_color = r105;
        this.start_color = r106;
        this.end_color = r107;
        this.style_type = r110;
        this.collage_data = Internal.immutableCopyOf("collage_data", r111);
        this.rich_text = r112;
    }
}
