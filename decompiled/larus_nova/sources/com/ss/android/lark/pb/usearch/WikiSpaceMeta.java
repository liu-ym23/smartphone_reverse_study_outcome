package com.ss.android.lark.pb.usearch;

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

/* JADX INFO: loaded from: classes37.dex */
public final class WikiSpaceMeta extends Message<WikiSpaceMeta, Builder> {
    public static final ProtoAdapter<WikiSpaceMeta> ADAPTER = null;
    public static final String DEFAULT_COVER_COLOR_VALUE = "";
    public static final Boolean DEFAULT_COVER_IS_GRAPH_DARK = null;
    public static final String DEFAULT_COVER_KEY = "";
    public static final String DEFAULT_COVER_ORIGIN = "";
    public static final String DEFAULT_COVER_THUMBNAIL = "";
    public static final Long DEFAULT_CREATE_TENANT_ID = null;
    public static final Long DEFAULT_CREATE_UID = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Boolean DEFAULT_IS_STAR = null;
    public static final Integer DEFAULT_MEMBER_COUNT = null;
    public static final Integer DEFAULT_NODE_COUNT = null;
    public static final String DEFAULT_PAY_AMOUNT = "";
    public static final String DEFAULT_ROOT_TOKEN = "";
    public static final String DEFAULT_SPACE_ID = "";
    public static final String DEFAULT_SPACE_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mcover_color_value;
    public final Boolean mcover_is_graph_dark;
    public final String mcover_key;
    public final String mcover_origin;
    public final String mcover_thumbnail;
    public final Long mcreate_tenant_id;
    public final Long mcreate_uid;
    public final String mdescription;
    public final DisplayCreateInfo mdisplay_create_info;
    public final Boolean mis_star;
    public final Integer mmember_count;
    public final Integer mnode_count;
    public final String mpay_amount;
    public final PaymentType mpayment_type;
    public final String mroot_token;
    public final String mspace_id;
    public final String mspace_name;
    public final SpaceScope mwiki_scope;
    public final SpaceType mwiki_space_type;

    public static final class Builder extends Message.Builder<WikiSpaceMeta, Builder> {
        public String mcover_color_value;
        public Boolean mcover_is_graph_dark;
        public String mcover_key;
        public String mcover_origin;
        public String mcover_thumbnail;
        public Long mcreate_tenant_id;
        public Long mcreate_uid;
        public String mdescription;
        public DisplayCreateInfo mdisplay_create_info;
        public Boolean mis_star;
        public Integer mmember_count;
        public Integer mnode_count;
        public String mpay_amount;
        public PaymentType mpayment_type;
        public String mroot_token;
        public String mspace_id;
        public String mspace_name;
        public SpaceScope mwiki_scope;
        public SpaceType mwiki_space_type;

        @Override // com.squareup.wire.Message.Builder
        public WikiSpaceMeta build() {
            String r100 = this.mspace_id;
            if (r100 == null) goto L7;
            return new WikiSpaceMeta(this.mspace_id, this.mspace_name, this.mdescription, this.mis_star, this.mwiki_space_type, this.mwiki_scope, this.mroot_token, this.mcover_color_value, this.mcover_is_graph_dark, this.mcover_key, this.mcover_origin, this.mcover_thumbnail, this.mmember_count, this.mnode_count, this.mcreate_uid, this.mcreate_tenant_id, this.mdisplay_create_info, this.mpayment_type, this.mpay_amount, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mspace_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cover_color_value(String r100) {
            this.mcover_color_value = r100;
            return this;
        }

        public Builder cover_is_graph_dark(Boolean r100) {
            this.mcover_is_graph_dark = r100;
            return this;
        }

        public Builder cover_key(String r100) {
            this.mcover_key = r100;
            return this;
        }

        public Builder cover_origin(String r100) {
            this.mcover_origin = r100;
            return this;
        }

        public Builder cover_thumbnail(String r100) {
            this.mcover_thumbnail = r100;
            return this;
        }

        public Builder create_tenant_id(Long r100) {
            this.mcreate_tenant_id = r100;
            return this;
        }

        public Builder create_uid(Long r100) {
            this.mcreate_uid = r100;
            return this;
        }

        public Builder description(String r100) {
            this.mdescription = r100;
            return this;
        }

        public Builder display_create_info(DisplayCreateInfo r100) {
            this.mdisplay_create_info = r100;
            return this;
        }

        public Builder is_star(Boolean r100) {
            this.mis_star = r100;
            return this;
        }

        public Builder member_count(Integer r100) {
            this.mmember_count = r100;
            return this;
        }

        public Builder node_count(Integer r100) {
            this.mnode_count = r100;
            return this;
        }

        public Builder pay_amount(String r100) {
            this.mpay_amount = r100;
            return this;
        }

        public Builder payment_type(PaymentType r100) {
            this.mpayment_type = r100;
            return this;
        }

        public Builder root_token(String r100) {
            this.mroot_token = r100;
            return this;
        }

        public Builder space_id(String r100) {
            this.mspace_id = r100;
            return this;
        }

        public Builder space_name(String r100) {
            this.mspace_name = r100;
            return this;
        }

        public Builder wiki_scope(SpaceScope r100) {
            this.mwiki_scope = r100;
            return this;
        }

        public Builder wiki_space_type(SpaceType r100) {
            this.mwiki_space_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WikiSpaceMeta extends ProtoAdapter<WikiSpaceMeta> {
        public ProtoAdapter_WikiSpaceMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, WikiSpaceMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WikiSpaceMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mspace_id = "";
            r101.mspace_name = "";
            r101.mdescription = "";
            Boolean r102 = Boolean.FALSE;
            r101.mis_star = r102;
            r101.mroot_token = "";
            r101.mcover_color_value = "";
            r101.mcover_is_graph_dark = r102;
            r101.mcover_key = "";
            r101.mcover_origin = "";
            r101.mcover_thumbnail = "";
            r101.mmember_count = 0;
            r101.mnode_count = 0;
            r101.mcreate_uid = 0L;
            r101.mcreate_tenant_id = 0L;
            r101.mpay_amount = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L35;
            switch(r104) {
                case 1: goto L34;
                case 2: goto L33;
                case 3: goto L32;
                case 4: goto L31;
                case 5: goto L41;
                case 6: goto L37;
                case 7: goto L22;
                case 8: goto L21;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L18;
                case 12: goto L17;
                case 13: goto L16;
                case 14: goto L15;
                case 15: goto L14;
                case 16: goto L13;
                case 17: goto L12;
                case 18: goto L39;
                case 19: goto L7;
                default: goto L6;
            };
        L37:
            r101.mwiki_scope = SpaceScope.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L39:
            r101.mpayment_type = PaymentType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L41:
            r101.mwiki_space_type = SpaceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mpay_amount = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mdisplay_create_info = DisplayCreateInfo.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.mcreate_tenant_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.mcreate_uid = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.mnode_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.mmember_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L17:
            r101.mcover_thumbnail = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.mcover_origin = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.mcover_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.mcover_is_graph_dark = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L21:
            r101.mcover_color_value = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.mroot_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.mis_star = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L32:
            r101.mdescription = ProtoAdapter.STRING.decode(r100);
            goto L3
        L33:
            r101.mspace_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L34:
            r101.mspace_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L35:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(WikiSpaceMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mspace_id);
            String r103 = r100.mspace_name;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.mdescription;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.mis_star;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            SpaceType r113 = r100.mwiki_space_type;
            if (r113 == null) goto L17;
            int r114 = SpaceType.ADAPTER.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            SpaceScope r116 = r100.mwiki_scope;
            if (r116 == null) goto L21;
            int r117 = SpaceScope.ADAPTER.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.mroot_token;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            String r122 = r100.mcover_color_value;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            Boolean r125 = r100.mcover_is_graph_dark;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.mcover_key;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(10, r128);
        L38:
            int r130 = r127 + r129;
            String r131 = r100.mcover_origin;
            if (r131 == null) goto L41;
            int r132 = r101.encodedSizeWithTag(11, r131);
        L42:
            int r133 = r130 + r132;
            String r134 = r100.mcover_thumbnail;
            if (r134 == null) goto L45;
            int r135 = r101.encodedSizeWithTag(12, r134);
        L46:
            int r136 = r133 + r135;
            Integer r137 = r100.mmember_count;
            if (r137 == null) goto L49;
            int r138 = ProtoAdapter.INT32.encodedSizeWithTag(13, r137);
        L50:
            int r139 = r136 + r138;
            Integer r140 = r100.mnode_count;
            if (r140 == null) goto L53;
            int r141 = ProtoAdapter.INT32.encodedSizeWithTag(14, r140);
        L54:
            int r142 = r139 + r141;
            Long r143 = r100.mcreate_uid;
            if (r143 == null) goto L57;
            int r144 = ProtoAdapter.INT64.encodedSizeWithTag(15, r143);
        L58:
            int r145 = r142 + r144;
            Long r146 = r100.mcreate_tenant_id;
            if (r146 == null) goto L61;
            int r147 = ProtoAdapter.INT64.encodedSizeWithTag(16, r146);
        L62:
            int r148 = r145 + r147;
            DisplayCreateInfo r149 = r100.mdisplay_create_info;
            if (r149 == null) goto L65;
            int r150 = DisplayCreateInfo.ADAPTER.encodedSizeWithTag(17, r149);
        L66:
            int r151 = r148 + r150;
            PaymentType r152 = r100.mpayment_type;
            if (r152 == null) goto L69;
            int r153 = PaymentType.ADAPTER.encodedSizeWithTag(18, r152);
        L70:
            int r154 = r151 + r153;
            String r155 = r100.mpay_amount;
            if (r155 == null) goto L74;
            r104 = r101.encodedSizeWithTag(19, r155);
        L74:
            return (r154 + r104) + r100.unknownFields().size();
        L69:
            r153 = 0;
            goto L70
        L65:
            r150 = 0;
            goto L66
        L61:
            r147 = 0;
            goto L62
        L57:
            r144 = 0;
            goto L58
        L53:
            r141 = 0;
            goto L54
        L49:
            r138 = 0;
            goto L50
        L45:
            r135 = 0;
            goto L46
        L41:
            r132 = 0;
            goto L42
        L37:
            r129 = 0;
            goto L38
        L33:
            r126 = 0;
            goto L34
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ WikiSpaceMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WikiSpaceMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WikiSpaceMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mspace_id);
            String r103 = r101.mspace_name;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.mdescription;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            Boolean r105 = r101.mis_star;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L11:
            SpaceType r106 = r101.mwiki_space_type;
            if (r106 == null) goto L14;
            SpaceType.ADAPTER.encodeWithTag(r100, 5, r106);
        L14:
            SpaceScope r107 = r101.mwiki_scope;
            if (r107 == null) goto L17;
            SpaceScope.ADAPTER.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.mroot_token;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            String r109 = r101.mcover_color_value;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 8, r109);
        L23:
            Boolean r110 = r101.mcover_is_graph_dark;
            if (r110 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L26:
            String r111 = r101.mcover_key;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 10, r111);
        L29:
            String r112 = r101.mcover_origin;
            if (r112 == null) goto L32;
            r102.encodeWithTag(r100, 11, r112);
        L32:
            String r113 = r101.mcover_thumbnail;
            if (r113 == null) goto L35;
            r102.encodeWithTag(r100, 12, r113);
        L35:
            Integer r114 = r101.mmember_count;
            if (r114 == null) goto L38;
            ProtoAdapter.INT32.encodeWithTag(r100, 13, r114);
        L38:
            Integer r115 = r101.mnode_count;
            if (r115 == null) goto L41;
            ProtoAdapter.INT32.encodeWithTag(r100, 14, r115);
        L41:
            Long r116 = r101.mcreate_uid;
            if (r116 == null) goto L44;
            ProtoAdapter.INT64.encodeWithTag(r100, 15, r116);
        L44:
            Long r117 = r101.mcreate_tenant_id;
            if (r117 == null) goto L47;
            ProtoAdapter.INT64.encodeWithTag(r100, 16, r117);
        L47:
            DisplayCreateInfo r118 = r101.mdisplay_create_info;
            if (r118 == null) goto L50;
            DisplayCreateInfo.ADAPTER.encodeWithTag(r100, 17, r118);
        L50:
            PaymentType r119 = r101.mpayment_type;
            if (r119 == null) goto L53;
            PaymentType.ADAPTER.encodeWithTag(r100, 18, r119);
        L53:
            String r120 = r101.mpay_amount;
            if (r120 == null) goto L56;
            r102.encodeWithTag(r100, 19, r120);
        L56:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WikiSpaceMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SpaceScope extends Enum<SpaceScope> implements WireEnum {
        private static final /* synthetic */ SpaceScope[] $VALUES = null;
        public static final ProtoAdapter<SpaceScope> ADAPTER = null;
        public static final SpaceScope PRIVATE = null;
        public static final SpaceScope PUBLIC = null;
        private final int value;

        static {
            SpaceScope r100 = new SpaceScope("PRIVATE", 0, 0);
            PRIVATE = r100;
            SpaceScope r101 = new SpaceScope("PUBLIC", 1, 1);
            PUBLIC = r101;
            $VALUES = new SpaceScope[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(SpaceScope.class);
        }

        public static SpaceScope[] values() {
            return (SpaceScope[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SpaceScope fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return PUBLIC;
        L10:
            return PRIVATE;
        }

        public static SpaceScope valueOf(String r100) {
            return (SpaceScope) a.a(SpaceScope.class, r100);
        }

        private SpaceScope(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum SpaceType extends Enum<SpaceType> implements WireEnum {
        private static final /* synthetic */ SpaceType[] $VALUES = null;
        public static final ProtoAdapter<SpaceType> ADAPTER = null;
        public static final SpaceType MyLibrary = null;
        public static final SpaceType MyLibrary_Resigned = null;
        public static final SpaceType Personal = null;
        public static final SpaceType Team = null;
        private final int value;

        static {
            SpaceType r100 = new SpaceType("Team", 0, 0);
            Team = r100;
            SpaceType r101 = new SpaceType("Personal", 1, 1);
            Personal = r101;
            SpaceType r102 = new SpaceType("MyLibrary", 2, 2);
            MyLibrary = r102;
            SpaceType r103 = new SpaceType("MyLibrary_Resigned", 3, 3);
            MyLibrary_Resigned = r103;
            $VALUES = new SpaceType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(SpaceType.class);
        }

        public static SpaceType[] values() {
            return (SpaceType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SpaceType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return MyLibrary_Resigned;
        L14:
            return MyLibrary;
        L16:
            return Personal;
        L18:
            return Team;
        }

        public static SpaceType valueOf(String r100) {
            return (SpaceType) a.a(SpaceType.class, r100);
        }

        private SpaceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WikiSpaceMeta();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_STAR = r100;
        DEFAULT_COVER_IS_GRAPH_DARK = r100;
        DEFAULT_MEMBER_COUNT = 0;
        DEFAULT_NODE_COUNT = 0;
        DEFAULT_CREATE_UID = 0L;
        DEFAULT_CREATE_TENANT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mspace_id = this.mspace_id;
        r100.mspace_name = this.mspace_name;
        r100.mdescription = this.mdescription;
        r100.mis_star = this.mis_star;
        r100.mwiki_space_type = this.mwiki_space_type;
        r100.mwiki_scope = this.mwiki_scope;
        r100.mroot_token = this.mroot_token;
        r100.mcover_color_value = this.mcover_color_value;
        r100.mcover_is_graph_dark = this.mcover_is_graph_dark;
        r100.mcover_key = this.mcover_key;
        r100.mcover_origin = this.mcover_origin;
        r100.mcover_thumbnail = this.mcover_thumbnail;
        r100.mmember_count = this.mmember_count;
        r100.mnode_count = this.mnode_count;
        r100.mcreate_uid = this.mcreate_uid;
        r100.mcreate_tenant_id = this.mcreate_tenant_id;
        r100.mdisplay_create_info = this.mdisplay_create_info;
        r100.mpayment_type = this.mpayment_type;
        r100.mpay_amount = this.mpay_amount;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WikiSpaceMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WikiSpaceMeta(String r210, String r211, String r212, Boolean r213, SpaceType r214, SpaceScope r215, String r216, String r217, Boolean r310, String r311, String r312, String r313, Integer r314, Integer r315, Long r316, Long r317, DisplayCreateInfo r318, PaymentType r319, String r410) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, ByteString.EMPTY);
    }

    public WikiSpaceMeta(String r100, String r101, String r102, Boolean r103, SpaceType r104, SpaceScope r105, String r110, String r111, Boolean r112, String r113, String r114, String r115, Integer r116, Integer r117, Long r118, Long r119, DisplayCreateInfo r210, PaymentType r211, String r212, ByteString r213) {
        super(ADAPTER, r213);
        this.mspace_id = r100;
        this.mspace_name = r101;
        this.mdescription = r102;
        this.mis_star = r103;
        this.mwiki_space_type = r104;
        this.mwiki_scope = r105;
        this.mroot_token = r110;
        this.mcover_color_value = r111;
        this.mcover_is_graph_dark = r112;
        this.mcover_key = r113;
        this.mcover_origin = r114;
        this.mcover_thumbnail = r115;
        this.mmember_count = r116;
        this.mnode_count = r117;
        this.mcreate_uid = r118;
        this.mcreate_tenant_id = r119;
        this.mdisplay_create_info = r210;
        this.mpayment_type = r211;
        this.mpay_amount = r212;
    }
}
