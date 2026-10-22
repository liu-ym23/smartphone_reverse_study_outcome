package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class CustomizationMeta extends Message<CustomizationMeta, Builder> {
    public static final ProtoAdapter<CustomizationMeta> ADAPTER = null;
    public static final CardType DEFAULT_CARD_TYPE = null;
    public static final String DEFAULT_DATA_SOURCE_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_NEED_STICKY_POST = null;
    public static final String DEFAULT_RENDER_CONTENT = "";
    public static final String DEFAULT_TEMPLATE_NAME = "";
    private static final long serialVersionUID = 0;
    public final CardType card_type;
    public final String data_source_id;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253707id;
    public final Boolean need_sticky_post;
    public final String render_content;
    public final String template_name;

    public static final class Builder extends Message.Builder<CustomizationMeta, Builder> {
        public CardType card_type;
        public String data_source_id;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253708id;
        public Boolean need_sticky_post;
        public String render_content;
        public String template_name;

        @Override // com.squareup.wire.Message.Builder
        public CustomizationMeta build() {
            String r100 = this.f253708id;
            if (r100 == null) goto L7;
            return new CustomizationMeta(this.f253708id, this.render_content, this.data_source_id, this.template_name, this.card_type, this.need_sticky_post, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder card_type(CardType r100) {
            this.card_type = r100;
            return this;
        }

        public Builder data_source_id(String r100) {
            this.data_source_id = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253708id = r100;
            return this;
        }

        public Builder need_sticky_post(Boolean r100) {
            this.need_sticky_post = r100;
            return this;
        }

        public Builder render_content(String r100) {
            this.render_content = r100;
            return this;
        }

        public Builder template_name(String r100) {
            this.template_name = r100;
            return this;
        }
    }

    public static final enum CardType extends Enum<CardType> implements WireEnum {
        private static final /* synthetic */ CardType[] $VALUES = null;
        public static final ProtoAdapter<CardType> ADAPTER = null;
        public static final CardType ASL_LYNX = null;
        public static final CardType BLOCK = null;
        private final int value;

        static {
            CardType r100 = new CardType("ASL_LYNX", 0, 0);
            ASL_LYNX = r100;
            CardType r101 = new CardType("BLOCK", 1, 1);
            BLOCK = r101;
            $VALUES = new CardType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(CardType.class);
        }

        public static CardType[] values() {
            return (CardType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CardType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return BLOCK;
        L10:
            return ASL_LYNX;
        }

        public static CardType valueOf(String r100) {
            return (CardType) a.a(CardType.class, r100);
        }

        private CardType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_CustomizationMeta extends ProtoAdapter<CustomizationMeta> {
        public ProtoAdapter_CustomizationMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomizationMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomizationMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253708id = "";
            r101.render_content = "";
            r101.data_source_id = "";
            r101.template_name = "";
            r101.card_type = CardType.ASL_LYNX;
            r101.need_sticky_post = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L18;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.card_type = CardType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.need_sticky_post = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.template_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.data_source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.render_content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.f253708id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CustomizationMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253707id);
            String r103 = r100.render_content;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.data_source_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.template_name;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            CardType r113 = r100.card_type;
            if (r113 == null) goto L17;
            int r114 = CardType.ADAPTER.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.need_sticky_post;
            if (r116 == null) goto L22;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L22:
            return (r115 + r104) + r100.unknownFields().size();
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomizationMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomizationMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomizationMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253707id);
            String r103 = r101.render_content;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.data_source_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.template_name;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            CardType r106 = r101.card_type;
            if (r106 == null) goto L14;
            CardType.ADAPTER.encodeWithTag(r100, 5, r106);
        L14:
            Boolean r107 = r101.need_sticky_post;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomizationMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomizationMeta();
        DEFAULT_CARD_TYPE = CardType.ASL_LYNX;
        DEFAULT_NEED_STICKY_POST = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253708id = this.f253707id;
        r100.render_content = this.render_content;
        r100.data_source_id = this.data_source_id;
        r100.template_name = this.template_name;
        r100.card_type = this.card_type;
        r100.need_sticky_post = this.need_sticky_post;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomizationMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomizationMeta(String r100, String r110, String r111, String r112, CardType r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public CustomizationMeta(String r100, String r101, String r102, String r103, CardType r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        this.f253707id = r100;
        this.render_content = r101;
        this.data_source_id = r102;
        this.template_name = r103;
        this.card_type = r104;
        this.need_sticky_post = r105;
    }
}
