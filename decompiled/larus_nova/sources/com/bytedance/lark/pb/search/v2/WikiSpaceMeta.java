package com.bytedance.lark.pb.search.v2;

import com.bytedance.ee.bear.document.DocViewModel;
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
    public static final PaymentType DEFAULT_PAYMENT_TYPE = null;
    public static final String DEFAULT_PAY_AMOUNT = "";
    public static final String DEFAULT_ROOT_TOKEN = "";
    public static final String DEFAULT_SPACE_ID = "";
    public static final String DEFAULT_SPACE_NAME = "";
    public static final SpaceScope DEFAULT_WIKI_SCOPE = null;
    public static final UniversalFilters.WikiSpaceFilter.SpaceType DEFAULT_WIKI_SPACE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String cover_color_value;
    public final Boolean cover_is_graph_dark;
    public final String cover_key;
    public final String cover_origin;
    public final String cover_thumbnail;
    public final Long create_tenant_id;
    public final Long create_uid;
    public final String description;
    public final Boolean is_star;
    public final Integer member_count;
    public final Integer node_count;
    public final String pay_amount;
    public final PaymentType payment_type;
    public final String root_token;
    public final String space_id;
    public final String space_name;
    public final SpaceScope wiki_scope;
    public final UniversalFilters.WikiSpaceFilter.SpaceType wiki_space_type;

    public static final class Builder extends Message.Builder<WikiSpaceMeta, Builder> {
        public String cover_color_value;
        public Boolean cover_is_graph_dark;
        public String cover_key;
        public String cover_origin;
        public String cover_thumbnail;
        public Long create_tenant_id;
        public Long create_uid;
        public String description;
        public Boolean is_star;
        public Integer member_count;
        public Integer node_count;
        public String pay_amount;
        public PaymentType payment_type;
        public String root_token;
        public String space_id;
        public String space_name;
        public SpaceScope wiki_scope;
        public UniversalFilters.WikiSpaceFilter.SpaceType wiki_space_type;

        @Override // com.squareup.wire.Message.Builder
        public WikiSpaceMeta build() {
            String r100 = this.space_id;
            if (r100 == null) goto L7;
            return new WikiSpaceMeta(this.space_id, this.space_name, this.description, this.is_star, this.wiki_space_type, this.wiki_scope, this.root_token, this.cover_color_value, this.cover_is_graph_dark, this.cover_key, this.cover_origin, this.cover_thumbnail, this.member_count, this.node_count, this.create_uid, this.create_tenant_id, this.payment_type, this.pay_amount, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, DocViewModel.EXTRA_SPACE_ID});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cover_color_value(String r100) {
            this.cover_color_value = r100;
            return this;
        }

        public Builder cover_is_graph_dark(Boolean r100) {
            this.cover_is_graph_dark = r100;
            return this;
        }

        public Builder cover_key(String r100) {
            this.cover_key = r100;
            return this;
        }

        public Builder cover_origin(String r100) {
            this.cover_origin = r100;
            return this;
        }

        public Builder cover_thumbnail(String r100) {
            this.cover_thumbnail = r100;
            return this;
        }

        public Builder create_tenant_id(Long r100) {
            this.create_tenant_id = r100;
            return this;
        }

        public Builder create_uid(Long r100) {
            this.create_uid = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder is_star(Boolean r100) {
            this.is_star = r100;
            return this;
        }

        public Builder member_count(Integer r100) {
            this.member_count = r100;
            return this;
        }

        public Builder node_count(Integer r100) {
            this.node_count = r100;
            return this;
        }

        public Builder pay_amount(String r100) {
            this.pay_amount = r100;
            return this;
        }

        public Builder payment_type(PaymentType r100) {
            this.payment_type = r100;
            return this;
        }

        public Builder root_token(String r100) {
            this.root_token = r100;
            return this;
        }

        public Builder space_id(String r100) {
            this.space_id = r100;
            return this;
        }

        public Builder space_name(String r100) {
            this.space_name = r100;
            return this;
        }

        public Builder wiki_scope(SpaceScope r100) {
            this.wiki_scope = r100;
            return this;
        }

        public Builder wiki_space_type(UniversalFilters.WikiSpaceFilter.SpaceType r100) {
            this.wiki_space_type = r100;
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
            r101.space_id = "";
            r101.space_name = "";
            r101.description = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_star = r102;
            r101.wiki_space_type = UniversalFilters.WikiSpaceFilter.SpaceType.Team;
            r101.wiki_scope = SpaceScope.PRIVATE;
            r101.root_token = "";
            r101.cover_color_value = "";
            r101.cover_is_graph_dark = r102;
            r101.cover_key = "";
            r101.cover_origin = "";
            r101.cover_thumbnail = "";
            r101.member_count = 0;
            r101.node_count = 0;
            r101.create_uid = 0L;
            r101.create_tenant_id = 0L;
            r101.payment_type = PaymentType.Free;
            r101.pay_amount = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L34;
            switch(r104) {
                case 1: goto L33;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L40;
                case 6: goto L36;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L17;
                case 12: goto L16;
                case 13: goto L15;
                case 14: goto L14;
                case 15: goto L13;
                case 16: goto L12;
                case 17: goto L6;
                case 18: goto L38;
                case 19: goto L7;
                default: goto L6;
            };
        L36:
            r101.wiki_scope = SpaceScope.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L38:
            r101.payment_type = PaymentType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L40:
            r101.wiki_space_type = UniversalFilters.WikiSpaceFilter.SpaceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
        L28:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.pay_amount = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.create_tenant_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.create_uid = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.node_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.member_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.cover_thumbnail = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.cover_origin = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.cover_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.cover_is_graph_dark = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L20:
            r101.cover_color_value = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.root_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.is_star = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L31:
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L32:
            r101.space_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L33:
            r101.space_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L34:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(WikiSpaceMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.space_id);
            String r103 = r100.space_name;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.description;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_star;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            UniversalFilters.WikiSpaceFilter.SpaceType r113 = r100.wiki_space_type;
            if (r113 == null) goto L17;
            int r114 = UniversalFilters.WikiSpaceFilter.SpaceType.ADAPTER.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            SpaceScope r116 = r100.wiki_scope;
            if (r116 == null) goto L21;
            int r117 = SpaceScope.ADAPTER.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.root_token;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            String r122 = r100.cover_color_value;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            Boolean r125 = r100.cover_is_graph_dark;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.cover_key;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(10, r128);
        L38:
            int r130 = r127 + r129;
            String r131 = r100.cover_origin;
            if (r131 == null) goto L41;
            int r132 = r101.encodedSizeWithTag(11, r131);
        L42:
            int r133 = r130 + r132;
            String r134 = r100.cover_thumbnail;
            if (r134 == null) goto L45;
            int r135 = r101.encodedSizeWithTag(12, r134);
        L46:
            int r136 = r133 + r135;
            Integer r137 = r100.member_count;
            if (r137 == null) goto L49;
            int r138 = ProtoAdapter.INT32.encodedSizeWithTag(13, r137);
        L50:
            int r139 = r136 + r138;
            Integer r140 = r100.node_count;
            if (r140 == null) goto L53;
            int r141 = ProtoAdapter.INT32.encodedSizeWithTag(14, r140);
        L54:
            int r142 = r139 + r141;
            Long r143 = r100.create_uid;
            if (r143 == null) goto L57;
            int r144 = ProtoAdapter.INT64.encodedSizeWithTag(15, r143);
        L58:
            int r145 = r142 + r144;
            Long r146 = r100.create_tenant_id;
            if (r146 == null) goto L61;
            int r147 = ProtoAdapter.INT64.encodedSizeWithTag(16, r146);
        L62:
            int r148 = r145 + r147;
            PaymentType r149 = r100.payment_type;
            if (r149 == null) goto L65;
            int r150 = PaymentType.ADAPTER.encodedSizeWithTag(18, r149);
        L66:
            int r151 = r148 + r150;
            String r152 = r100.pay_amount;
            if (r152 == null) goto L70;
            r104 = r101.encodedSizeWithTag(19, r152);
        L70:
            return (r151 + r104) + r100.unknownFields().size();
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
            r102.encodeWithTag(r100, 1, r101.space_id);
            String r103 = r101.space_name;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.description;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            Boolean r105 = r101.is_star;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L11:
            UniversalFilters.WikiSpaceFilter.SpaceType r106 = r101.wiki_space_type;
            if (r106 == null) goto L14;
            UniversalFilters.WikiSpaceFilter.SpaceType.ADAPTER.encodeWithTag(r100, 5, r106);
        L14:
            SpaceScope r107 = r101.wiki_scope;
            if (r107 == null) goto L17;
            SpaceScope.ADAPTER.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.root_token;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            String r109 = r101.cover_color_value;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 8, r109);
        L23:
            Boolean r110 = r101.cover_is_graph_dark;
            if (r110 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L26:
            String r111 = r101.cover_key;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 10, r111);
        L29:
            String r112 = r101.cover_origin;
            if (r112 == null) goto L32;
            r102.encodeWithTag(r100, 11, r112);
        L32:
            String r113 = r101.cover_thumbnail;
            if (r113 == null) goto L35;
            r102.encodeWithTag(r100, 12, r113);
        L35:
            Integer r114 = r101.member_count;
            if (r114 == null) goto L38;
            ProtoAdapter.INT32.encodeWithTag(r100, 13, r114);
        L38:
            Integer r115 = r101.node_count;
            if (r115 == null) goto L41;
            ProtoAdapter.INT32.encodeWithTag(r100, 14, r115);
        L41:
            Long r116 = r101.create_uid;
            if (r116 == null) goto L44;
            ProtoAdapter.INT64.encodeWithTag(r100, 15, r116);
        L44:
            Long r117 = r101.create_tenant_id;
            if (r117 == null) goto L47;
            ProtoAdapter.INT64.encodeWithTag(r100, 16, r117);
        L47:
            PaymentType r118 = r101.payment_type;
            if (r118 == null) goto L50;
            PaymentType.ADAPTER.encodeWithTag(r100, 18, r118);
        L50:
            String r119 = r101.pay_amount;
            if (r119 == null) goto L53;
            r102.encodeWithTag(r100, 19, r119);
        L53:
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

    static {
        ADAPTER = new ProtoAdapter_WikiSpaceMeta();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_STAR = r100;
        DEFAULT_WIKI_SPACE_TYPE = UniversalFilters.WikiSpaceFilter.SpaceType.Team;
        DEFAULT_WIKI_SCOPE = SpaceScope.PRIVATE;
        DEFAULT_COVER_IS_GRAPH_DARK = r100;
        DEFAULT_MEMBER_COUNT = 0;
        DEFAULT_NODE_COUNT = 0;
        DEFAULT_CREATE_UID = 0L;
        DEFAULT_CREATE_TENANT_ID = 0L;
        DEFAULT_PAYMENT_TYPE = PaymentType.Free;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.space_id = this.space_id;
        r100.space_name = this.space_name;
        r100.description = this.description;
        r100.is_star = this.is_star;
        r100.wiki_space_type = this.wiki_space_type;
        r100.wiki_scope = this.wiki_scope;
        r100.root_token = this.root_token;
        r100.cover_color_value = this.cover_color_value;
        r100.cover_is_graph_dark = this.cover_is_graph_dark;
        r100.cover_key = this.cover_key;
        r100.cover_origin = this.cover_origin;
        r100.cover_thumbnail = this.cover_thumbnail;
        r100.member_count = this.member_count;
        r100.node_count = this.node_count;
        r100.create_uid = this.create_uid;
        r100.create_tenant_id = this.create_tenant_id;
        r100.payment_type = this.payment_type;
        r100.pay_amount = this.pay_amount;
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

    public WikiSpaceMeta(String r210, String r211, String r212, Boolean r213, UniversalFilters.WikiSpaceFilter.SpaceType r214, SpaceScope r215, String r216, String r217, Boolean r218, String r310, String r311, String r312, Integer r313, Integer r314, Long r315, Long r316, PaymentType r317, String r318) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318, ByteString.EMPTY);
    }

    public WikiSpaceMeta(String r100, String r101, String r102, Boolean r103, UniversalFilters.WikiSpaceFilter.SpaceType r104, SpaceScope r105, String r110, String r111, Boolean r112, String r113, String r114, String r115, Integer r116, Integer r117, Long r118, Long r119, PaymentType r210, String r211, ByteString r212) {
        super(ADAPTER, r212);
        this.space_id = r100;
        this.space_name = r101;
        this.description = r102;
        this.is_star = r103;
        this.wiki_space_type = r104;
        this.wiki_scope = r105;
        this.root_token = r110;
        this.cover_color_value = r111;
        this.cover_is_graph_dark = r112;
        this.cover_key = r113;
        this.cover_origin = r114;
        this.cover_thumbnail = r115;
        this.member_count = r116;
        this.node_count = r117;
        this.create_uid = r118;
        this.create_tenant_id = r119;
        this.payment_type = r210;
        this.pay_amount = r211;
    }
}
