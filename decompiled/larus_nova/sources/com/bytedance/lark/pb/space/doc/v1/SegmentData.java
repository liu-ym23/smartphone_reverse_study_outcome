package com.bytedance.lark.pb.space.doc.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SegmentData extends Message<SegmentData, Builder> {
    public static final ProtoAdapter<SegmentData> ADAPTER = null;
    public static final Boolean DEFAULT_BLOCK_NOTIFY = null;
    public static final String DEFAULT_CATEGORY = "";
    public static final String DEFAULT_EN_NAME = "";
    public static final String DEFAULT_ICON_INFO = "";
    public static final Boolean DEFAULT_IS_EXTERNAL = null;
    public static final String DEFAULT_LINK = "";
    public static final Boolean DEFAULT_MENTION_NOTIFY = null;
    public static final Integer DEFAULT_MENTION_TYPE = null;
    public static final String DEFAULT_NAME = "";
    public static final Boolean DEFAULT_NOT_NOTIFY = null;
    public static final Integer DEFAULT_SUB_MENTION_TYPE = null;
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    public final Boolean block_notify;
    public final String category;
    public final String en_name;
    public final String icon_info;
    public final Boolean is_external;
    public final String link;
    public final Boolean mention_notify;
    public final Integer mention_type;
    public final String name;
    public final Boolean not_notify;
    public final Integer sub_mention_type;
    public final String text;
    public final String token;
    public final String type;

    public static final class Builder extends Message.Builder<SegmentData, Builder> {
        public Boolean block_notify;
        public String category;
        public String en_name;
        public String icon_info;
        public Boolean is_external;
        public String link;
        public Boolean mention_notify;
        public Integer mention_type;
        public String name;
        public Boolean not_notify;
        public Integer sub_mention_type;
        public String text;
        public String token;
        public String type;

        @Override // com.squareup.wire.Message.Builder
        public SegmentData build() {
            return new SegmentData(this.type, this.text, this.link, this.token, this.name, this.en_name, this.category, this.mention_type, this.mention_notify, this.block_notify, this.sub_mention_type, this.not_notify, this.icon_info, this.is_external, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder block_notify(Boolean r100) {
            this.block_notify = r100;
            return this;
        }

        public Builder category(String r100) {
            this.category = r100;
            return this;
        }

        public Builder en_name(String r100) {
            this.en_name = r100;
            return this;
        }

        public Builder icon_info(String r100) {
            this.icon_info = r100;
            return this;
        }

        public Builder is_external(Boolean r100) {
            this.is_external = r100;
            return this;
        }

        public Builder link(String r100) {
            this.link = r100;
            return this;
        }

        public Builder mention_notify(Boolean r100) {
            this.mention_notify = r100;
            return this;
        }

        public Builder mention_type(Integer r100) {
            this.mention_type = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder not_notify(Boolean r100) {
            this.not_notify = r100;
            return this;
        }

        public Builder sub_mention_type(Integer r100) {
            this.sub_mention_type = r100;
            return this;
        }

        public Builder text(String r100) {
            this.text = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder type(String r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SegmentData extends ProtoAdapter<SegmentData> {
        public ProtoAdapter_SegmentData() {
            super(FieldEncoding.LENGTH_DELIMITED, SegmentData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SegmentData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = "";
            r101.text = "";
            r101.link = "";
            r101.token = "";
            r101.name = "";
            r101.en_name = "";
            r101.category = "";
            r101.mention_type = 0;
            Boolean r102 = Boolean.FALSE;
            r101.mention_notify = r102;
            r101.block_notify = r102;
            r101.sub_mention_type = 0;
            r101.not_notify = r102;
            r101.icon_info = "";
            r101.is_external = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            switch(r104) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L7:
            r101.is_external = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.icon_info = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.not_notify = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.sub_mention_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.block_notify = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.mention_notify = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.mention_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.category = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.en_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SegmentData r100) {
            String r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.text;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.link;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.token;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.name;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.en_name;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.category;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Integer r122 = r100.mention_type;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.mention_notify;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Boolean r128 = r100.block_notify;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            Integer r131 = r100.sub_mention_type;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.INT32.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            Boolean r134 = r100.not_notify;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            String r137 = r100.icon_info;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.STRING.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            Boolean r140 = r100.is_external;
            if (r140 == null) goto L58;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r140);
        L58:
            return (r139 + r102) + r100.unknownFields().size();
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
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
        public /* bridge */ /* synthetic */ SegmentData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SegmentData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SegmentData r101) throws IOException {
            String r102 = r101.type;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.text;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.link;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.token;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.name;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.en_name;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.category;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            Integer r109 = r101.mention_type;
            if (r109 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
        L26:
            Boolean r110 = r101.mention_notify;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L29:
            Boolean r111 = r101.block_notify;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r111);
        L32:
            Integer r112 = r101.sub_mention_type;
            if (r112 == null) goto L35;
            ProtoAdapter.INT32.encodeWithTag(r100, 11, r112);
        L35:
            Boolean r113 = r101.not_notify;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r113);
        L38:
            String r114 = r101.icon_info;
            if (r114 == null) goto L41;
            ProtoAdapter.STRING.encodeWithTag(r100, 13, r114);
        L41:
            Boolean r115 = r101.is_external;
            if (r115 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r115);
        L44:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SegmentData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SegmentData();
        DEFAULT_MENTION_TYPE = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_MENTION_NOTIFY = r100;
        DEFAULT_BLOCK_NOTIFY = r100;
        DEFAULT_SUB_MENTION_TYPE = 0;
        DEFAULT_NOT_NOTIFY = r100;
        DEFAULT_IS_EXTERNAL = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.text = this.text;
        r100.link = this.link;
        r100.token = this.token;
        r100.name = this.name;
        r100.en_name = this.en_name;
        r100.category = this.category;
        r100.mention_type = this.mention_type;
        r100.mention_notify = this.mention_notify;
        r100.block_notify = this.block_notify;
        r100.sub_mention_type = this.sub_mention_type;
        r100.not_notify = this.not_notify;
        r100.icon_info = this.icon_info;
        r100.is_external = this.is_external;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SegmentData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SegmentData(String r110, String r111, String r112, String r210, String r211, String r212, String r213, Integer r214, Boolean r215, Boolean r216, Integer r217, Boolean r218, String r219, Boolean r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public SegmentData(String r100, String r101, String r102, String r103, String r104, String r105, String r110, Integer r111, Boolean r112, Boolean r113, Integer r114, Boolean r115, String r116, Boolean r117, ByteString r118) {
        super(ADAPTER, r118);
        this.type = r100;
        this.text = r101;
        this.link = r102;
        this.token = r103;
        this.name = r104;
        this.en_name = r105;
        this.category = r110;
        this.mention_type = r111;
        this.mention_notify = r112;
        this.block_notify = r113;
        this.sub_mention_type = r114;
        this.not_notify = r115;
        this.icon_info = r116;
        this.is_external = r117;
    }
}
