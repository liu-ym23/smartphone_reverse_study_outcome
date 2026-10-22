package space.permission_sdk.v1;

import annotation.OptionsExt;
import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class OwnerMeta extends Message<OwnerMeta, Builder> {
    public static final ProtoAdapter<OwnerMeta> ADAPTER = null;
    public static final String DEFAULT_AVATAR_URL = "";
    public static final Integer DEFAULT_BLOCK_STATUS = null;
    public static final Boolean DEFAULT_CAN_MODIFY_PERM = null;
    public static final String DEFAULT_DEPARTMENT_NAME = "";
    public static final String DEFAULT_GROUP_DESCRIPTION = "";
    public static final Boolean DEFAULT_HAS_TIPS = null;
    public static final String DEFAULT_ICON_TOKEN = "";
    public static final Boolean DEFAULT_IS_ANONYMOUS = null;
    public static final Boolean DEFAULT_IS_EXTERNAL = null;
    public static final Boolean DEFAULT_IS_OWNER = null;
    public static final String DEFAULT_OWNER_ID = "";
    public static final String DEFAULT_OWNER_NAME = "";
    public static final OwnerTypeCode DEFAULT_OWNER_TYPE = null;
    public static final Integer DEFAULT_PERMISSIONS = null;
    public static final String DEFAULT_PERM_SOURCE = "";
    public static final Integer DEFAULT_PERM_TYPE = null;
    public static final String DEFAULT_TENANT_ID = "";
    public static final String DEFAULT_TENANT_NAME = "";
    public static final String DEFAULT_TENANT_TAG = "";
    public static final Integer DEFAULT_TOOLTIPS_TYPE = null;
    public static final String DEFAULT_WIKI_DESCRIPTION = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final String avatar_url;
    public final Integer block_status;
    public final Boolean can_modify_perm;
    public final String department_name;
    public final CollaboratorTag display_tag;
    public final Map<String, String> extra_info;
    public final String group_description;
    public final Boolean has_tips;
    public final String icon_token;
    public final Boolean is_anonymous;
    public final Boolean is_external;
    public final Boolean is_owner;
    public final String owner_id;
    public final String owner_name;
    public final OwnerTypeCode owner_type;
    public final String perm_source;
    public final Integer perm_type;
    public final Integer permissions;
    public final String tenant_id;
    public final String tenant_name;
    public final String tenant_tag;
    public final Integer tooltips_type;
    public final String wiki_description;

    public static final class Builder extends Message.Builder<OwnerMeta, Builder> {
        public String avatar_url;
        public Integer block_status;
        public Boolean can_modify_perm;
        public String department_name;
        public CollaboratorTag display_tag;
        public Map<String, String> extra_info;
        public String group_description;
        public Boolean has_tips;
        public String icon_token;
        public Boolean is_anonymous;
        public Boolean is_external;
        public Boolean is_owner;
        public String owner_id;
        public String owner_name;
        public OwnerTypeCode owner_type;
        public String perm_source;
        public Integer perm_type;
        public Integer permissions;
        public String tenant_id;
        public String tenant_name;
        public String tenant_tag;
        public Integer tooltips_type;
        public String wiki_description;

        @Override // com.squareup.wire.Message.Builder
        public OwnerMeta build() {
            return new OwnerMeta(this.owner_type, this.owner_id, this.owner_name, this.avatar_url, this.permissions, this.department_name, this.group_description, this.is_external, this.can_modify_perm, this.is_anonymous, this.has_tips, this.is_owner, this.perm_source, this.icon_token, this.tooltips_type, this.wiki_description, this.block_status, this.display_tag, this.extra_info, this.tenant_name, this.tenant_id, this.tenant_tag, this.perm_type, super.buildUnknownFields());
        }

        public Builder() {
            this.extra_info = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_url(String r100) {
            this.avatar_url = r100;
            return this;
        }

        public Builder block_status(Integer r100) {
            this.block_status = r100;
            return this;
        }

        public Builder can_modify_perm(Boolean r100) {
            this.can_modify_perm = r100;
            return this;
        }

        public Builder department_name(String r100) {
            this.department_name = r100;
            return this;
        }

        public Builder display_tag(CollaboratorTag r100) {
            this.display_tag = r100;
            return this;
        }

        public Builder extra_info(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extra_info = r100;
            return this;
        }

        public Builder group_description(String r100) {
            this.group_description = r100;
            return this;
        }

        public Builder has_tips(Boolean r100) {
            this.has_tips = r100;
            return this;
        }

        public Builder icon_token(String r100) {
            this.icon_token = r100;
            return this;
        }

        public Builder is_anonymous(Boolean r100) {
            this.is_anonymous = r100;
            return this;
        }

        public Builder is_external(Boolean r100) {
            this.is_external = r100;
            return this;
        }

        public Builder is_owner(Boolean r100) {
            this.is_owner = r100;
            return this;
        }

        public Builder owner_id(String r100) {
            this.owner_id = r100;
            return this;
        }

        public Builder owner_name(String r100) {
            this.owner_name = r100;
            return this;
        }

        public Builder owner_type(OwnerTypeCode r100) {
            this.owner_type = r100;
            return this;
        }

        public Builder perm_source(String r100) {
            this.perm_source = r100;
            return this;
        }

        public Builder perm_type(Integer r100) {
            this.perm_type = r100;
            return this;
        }

        public Builder permissions(Integer r100) {
            this.permissions = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.tenant_id = r100;
            return this;
        }

        public Builder tenant_name(String r100) {
            this.tenant_name = r100;
            return this;
        }

        public Builder tenant_tag(String r100) {
            this.tenant_tag = r100;
            return this;
        }

        public Builder tooltips_type(Integer r100) {
            this.tooltips_type = r100;
            return this;
        }

        public Builder wiki_description(String r100) {
            this.wiki_description = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OwnerMeta extends ProtoAdapter<OwnerMeta> {
        private final ProtoAdapter<Map<String, String>> extra_info;

        public ProtoAdapter_OwnerMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, OwnerMeta.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.extra_info = ProtoAdapter.newMapAdapter(r100, r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public OwnerMeta decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.owner_type = OwnerTypeCode.USER;
            r101.owner_id = "";
            r101.owner_name = "";
            r101.avatar_url = "";
            r101.permissions = 0;
            r101.department_name = "";
            r101.group_description = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_external = r102;
            r101.can_modify_perm = r102;
            r101.is_anonymous = r102;
            r101.has_tips = r102;
            r101.is_owner = r102;
            r101.perm_source = "";
            r101.icon_token = "";
            r101.tooltips_type = 0;
            r101.wiki_description = "";
            r101.block_status = 0;
            r101.tenant_name = "";
            r101.tenant_id = "";
            r101.tenant_tag = "";
            r101.perm_type = 0;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L33;
            switch(r104) {
                case 1: goto L35;
                case 2: goto L28;
                case 3: goto L27;
                case 4: goto L26;
                case 5: goto L25;
                case 6: goto L24;
                case 7: goto L23;
                case 8: goto L22;
                case 9: goto L21;
                case 10: goto L20;
                case 11: goto L19;
                case 12: goto L18;
                case 13: goto L17;
                case 14: goto L16;
                case 15: goto L15;
                case 16: goto L14;
                case 17: goto L13;
                case 18: goto L12;
                case 19: goto L11;
                case 20: goto L10;
                case 21: goto L9;
                case 22: goto L8;
                case 23: goto L7;
                default: goto L6;
            };
        L35:
            r101.owner_type = OwnerTypeCode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        L31:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.perm_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.tenant_tag = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.tenant_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.extra_info.putAll(this.extra_info.decode(r100));
            goto L3
        L12:
            r101.display_tag = CollaboratorTag.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.block_status = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.wiki_description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.tooltips_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.icon_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.perm_source = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.is_owner = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.has_tips = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L20:
            r101.is_anonymous = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L21:
            r101.can_modify_perm = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L22:
            r101.is_external = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L23:
            r101.group_description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.department_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.permissions = ProtoAdapter.INT32.decode(r100);
            goto L3
        L26:
            r101.avatar_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L27:
            r101.owner_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            r101.owner_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L33:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OwnerMeta r100) {
            OwnerTypeCode r101 = r100.owner_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = OwnerTypeCode.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.owner_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.owner_name;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.avatar_url;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.permissions;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.department_name;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.group_description;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.is_external;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.can_modify_perm;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Boolean r128 = r100.is_anonymous;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.has_tips;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            Boolean r134 = r100.is_owner;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            String r137 = r100.perm_source;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.STRING.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            String r140 = r100.icon_token;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.STRING.encodedSizeWithTag(14, r140);
        L58:
            int r142 = r139 + r141;
            Integer r143 = r100.tooltips_type;
            if (r143 == null) goto L61;
            int r144 = ProtoAdapter.INT32.encodedSizeWithTag(15, r143);
        L62:
            int r145 = r142 + r144;
            String r146 = r100.wiki_description;
            if (r146 == null) goto L65;
            int r147 = ProtoAdapter.STRING.encodedSizeWithTag(16, r146);
        L66:
            int r148 = r145 + r147;
            Integer r149 = r100.block_status;
            if (r149 == null) goto L69;
            int r150 = ProtoAdapter.INT32.encodedSizeWithTag(17, r149);
        L70:
            int r151 = r148 + r150;
            CollaboratorTag r152 = r100.display_tag;
            if (r152 == null) goto L73;
            int r153 = CollaboratorTag.ADAPTER.encodedSizeWithTag(18, r152);
        L74:
            int r154 = (r151 + r153) + this.extra_info.encodedSizeWithTag(19, r100.extra_info);
            String r155 = r100.tenant_name;
            if (r155 == null) goto L77;
            int r156 = ProtoAdapter.STRING.encodedSizeWithTag(20, r155);
        L78:
            int r157 = r154 + r156;
            String r158 = r100.tenant_id;
            if (r158 == null) goto L81;
            int r159 = ProtoAdapter.STRING.encodedSizeWithTag(21, r158);
        L82:
            int r160 = r157 + r159;
            String r161 = r100.tenant_tag;
            if (r161 == null) goto L85;
            int r162 = ProtoAdapter.STRING.encodedSizeWithTag(22, r161);
        L86:
            int r163 = r160 + r162;
            Integer r164 = r100.perm_type;
            if (r164 == null) goto L90;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(23, r164);
        L90:
            return (r163 + r102) + r100.unknownFields().size();
        L85:
            r162 = 0;
            goto L86
        L81:
            r159 = 0;
            goto L82
        L77:
            r156 = 0;
            goto L78
        L73:
            r153 = 0;
            goto L74
        L69:
            r150 = 0;
            goto L70
        L65:
            r147 = 0;
            goto L66
        L61:
            r144 = 0;
            goto L62
        L57:
            r141 = 0;
            goto L58
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
        public /* bridge */ /* synthetic */ OwnerMeta decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OwnerMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OwnerMeta r101) throws IOException {
            OwnerTypeCode r102 = r101.owner_type;
            if (r102 == null) goto L5;
            OwnerTypeCode.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.owner_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.owner_name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.avatar_url;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Integer r106 = r101.permissions;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.department_name;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.group_description;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            Boolean r109 = r101.is_external;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L26:
            Boolean r110 = r101.can_modify_perm;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L29:
            Boolean r111 = r101.is_anonymous;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r111);
        L32:
            Boolean r112 = r101.has_tips;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r112);
        L35:
            Boolean r113 = r101.is_owner;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r113);
        L38:
            String r114 = r101.perm_source;
            if (r114 == null) goto L41;
            ProtoAdapter.STRING.encodeWithTag(r100, 13, r114);
        L41:
            String r115 = r101.icon_token;
            if (r115 == null) goto L44;
            ProtoAdapter.STRING.encodeWithTag(r100, 14, r115);
        L44:
            Integer r116 = r101.tooltips_type;
            if (r116 == null) goto L47;
            ProtoAdapter.INT32.encodeWithTag(r100, 15, r116);
        L47:
            String r117 = r101.wiki_description;
            if (r117 == null) goto L50;
            ProtoAdapter.STRING.encodeWithTag(r100, 16, r117);
        L50:
            Integer r118 = r101.block_status;
            if (r118 == null) goto L53;
            ProtoAdapter.INT32.encodeWithTag(r100, 17, r118);
        L53:
            CollaboratorTag r119 = r101.display_tag;
            if (r119 == null) goto L56;
            CollaboratorTag.ADAPTER.encodeWithTag(r100, 18, r119);
        L56:
            this.extra_info.encodeWithTag(r100, 19, r101.extra_info);
            String r120 = r101.tenant_name;
            if (r120 == null) goto L59;
            ProtoAdapter.STRING.encodeWithTag(r100, 20, r120);
        L59:
            String r121 = r101.tenant_id;
            if (r121 == null) goto L62;
            ProtoAdapter.STRING.encodeWithTag(r100, 21, r121);
        L62:
            String r122 = r101.tenant_tag;
            if (r122 == null) goto L65;
            ProtoAdapter.STRING.encodeWithTag(r100, 22, r122);
        L65:
            Integer r123 = r101.perm_type;
            if (r123 == null) goto L68;
            ProtoAdapter.INT32.encodeWithTag(r100, 23, r123);
        L68:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OwnerMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OwnerMeta();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
        DEFAULT_OWNER_TYPE = OwnerTypeCode.USER;
        DEFAULT_PERMISSIONS = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_EXTERNAL = r100;
        DEFAULT_CAN_MODIFY_PERM = r100;
        DEFAULT_IS_ANONYMOUS = r100;
        DEFAULT_HAS_TIPS = r100;
        DEFAULT_IS_OWNER = r100;
        DEFAULT_TOOLTIPS_TYPE = 0;
        DEFAULT_BLOCK_STATUS = 0;
        DEFAULT_PERM_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.owner_type = this.owner_type;
        r100.owner_id = this.owner_id;
        r100.owner_name = this.owner_name;
        r100.avatar_url = this.avatar_url;
        r100.permissions = this.permissions;
        r100.department_name = this.department_name;
        r100.group_description = this.group_description;
        r100.is_external = this.is_external;
        r100.can_modify_perm = this.can_modify_perm;
        r100.is_anonymous = this.is_anonymous;
        r100.has_tips = this.has_tips;
        r100.is_owner = this.is_owner;
        r100.perm_source = this.perm_source;
        r100.icon_token = this.icon_token;
        r100.tooltips_type = this.tooltips_type;
        r100.wiki_description = this.wiki_description;
        r100.block_status = this.block_status;
        r100.display_tag = this.display_tag;
        r100.extra_info = Internal.copyOf("extra_info", this.extra_info);
        r100.tenant_name = this.tenant_name;
        r100.tenant_id = this.tenant_id;
        r100.tenant_tag = this.tenant_tag;
        r100.perm_type = this.perm_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OwnerMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OwnerMeta(OwnerTypeCode r210, String r211, String r212, String r213, Integer r310, String r311, String r312, Boolean r313, Boolean r314, Boolean r315, Boolean r316, Boolean r317, String r318, String r319, Integer r410, String r411, Integer r412, CollaboratorTag r413, Map<String, String> r414, String r415, String r416, String r417, Integer r418) {
        this(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, ByteString.EMPTY);
    }

    public OwnerMeta(OwnerTypeCode r100, String r101, String r102, String r103, Integer r104, String r105, String r110, Boolean r111, Boolean r112, Boolean r113, Boolean r114, Boolean r115, String r116, String r117, Integer r118, String r119, Integer r210, CollaboratorTag r211, Map<String, String> r212, String r213, String r214, String r215, Integer r216, ByteString r217) {
        super(ADAPTER, r217);
        this.owner_type = r100;
        this.owner_id = r101;
        this.owner_name = r102;
        this.avatar_url = r103;
        this.permissions = r104;
        this.department_name = r105;
        this.group_description = r110;
        this.is_external = r111;
        this.can_modify_perm = r112;
        this.is_anonymous = r113;
        this.has_tips = r114;
        this.is_owner = r115;
        this.perm_source = r116;
        this.icon_token = r117;
        this.tooltips_type = r118;
        this.wiki_description = r119;
        this.block_status = r210;
        this.display_tag = r211;
        this.extra_info = Internal.immutableCopyOf("extra_info", r212);
        this.tenant_name = r213;
        this.tenant_id = r214;
        this.tenant_tag = r215;
        this.perm_type = r216;
    }
}
