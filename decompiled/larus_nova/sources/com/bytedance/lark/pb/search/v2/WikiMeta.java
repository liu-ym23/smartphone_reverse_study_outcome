package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.basic.v1.Doc;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class WikiMeta extends Message<WikiMeta, Builder> {
    public static final ProtoAdapter<WikiMeta> ADAPTER = null;
    public static final BitableBizType DEFAULT_BITABLE_BIZ_TYPE = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_DOC_URL = "";
    public static final Long DEFAULT_EDIT_TIME = null;
    public static final String DEFAULT_EDIT_USER_ID = "";
    public static final String DEFAULT_EDIT_USER_NAME = "";
    public static final String DEFAULT_FILE_TYPE = "";
    public static final String DEFAULT_ICON_INFO = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_RESTRICTED = null;
    public static final Long DEFAULT_LAST_OPEN_TIME = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_MESSAGE_SENDER_NAME = "";
    public static final String DEFAULT_ORI_ID = "";
    public static final Doc.Type DEFAULT_ORI_TYPE = null;
    public static final String DEFAULT_OWNER_ID = "";
    public static final String DEFAULT_OWNER_NAME = "";
    public static final Integer DEFAULT_POSITION = null;
    public static final Integer DEFAULT_ROOT_MESSAGE_POSITION = null;
    public static final Long DEFAULT_SPACE_ID = null;
    public static final String DEFAULT_SPACE_NAME = "";
    public static final Integer DEFAULT_THREAD_CHAT_POSITION = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType DEFAULT_THREAD_MESSAGE_TYPE = null;
    public static final Integer DEFAULT_THREAD_POSITION = null;
    public static final String DEFAULT_TOKEN = "";
    public static final Doc.Type DEFAULT_TYPE = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final String DEFAULT_URL = "";
    public static final String DEFAULT_WIKI_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final BitableBizType bitable_biz_type;
    public final String chat_id;
    public final Long create_time;
    public final Map<Integer, MessageBehavior> disabled_action;
    public final String doc_url;
    public final Long edit_time;
    public final String edit_user_id;
    public final String edit_user_name;
    public final String file_type;
    public final String icon_info;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253751id;
    public final Boolean is_cross_tenant;
    public final Boolean is_restricted;
    public final Long last_open_time;
    public final String message_id;
    public final String message_sender_name;
    public final String ori_id;
    public final Doc.Type ori_type;
    public final String owner_id;
    public final String owner_name;
    public final Integer position;
    public final TagData relation_tag;
    public final Integer root_message_position;
    public final Long space_id;
    public final String space_name;
    public final Integer thread_chat_position;
    public final String thread_id;
    public final com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType thread_message_type;
    public final Integer thread_position;
    public final String token;
    public final Doc.Type type;
    public final Long update_time;
    public final String url;
    public final String wiki_token;

    public static final class Builder extends Message.Builder<WikiMeta, Builder> {
        public BitableBizType bitable_biz_type;
        public String chat_id;
        public Long create_time;
        public Map<Integer, MessageBehavior> disabled_action;
        public String doc_url;
        public Long edit_time;
        public String edit_user_id;
        public String edit_user_name;
        public String file_type;
        public String icon_info;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253752id;
        public Boolean is_cross_tenant;
        public Boolean is_restricted;
        public Long last_open_time;
        public String message_id;
        public String message_sender_name;
        public String ori_id;
        public Doc.Type ori_type;
        public String owner_id;
        public String owner_name;
        public Integer position;
        public TagData relation_tag;
        public Integer root_message_position;
        public Long space_id;
        public String space_name;
        public Integer thread_chat_position;
        public String thread_id;
        public com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType thread_message_type;
        public Integer thread_position;
        public String token;
        public Doc.Type type;
        public Long update_time;
        public String url;
        public String wiki_token;

        @Override // com.squareup.wire.Message.Builder
        public WikiMeta build() {
            String r100 = this.f253752id;
            if (r100 == null) goto L7;
            return new WikiMeta(this.f253752id, this.type, this.update_time, this.is_cross_tenant, this.chat_id, this.position, this.thread_id, this.thread_position, this.thread_chat_position, this.message_id, this.create_time, this.last_open_time, this.edit_user_id, this.edit_user_name, this.url, this.doc_url, this.space_id, this.space_name, this.token, this.owner_id, this.owner_name, this.relation_tag, this.is_restricted, this.disabled_action, this.ori_id, this.ori_type, this.icon_info, this.thread_message_type, this.root_message_position, this.edit_time, this.message_sender_name, this.wiki_token, this.file_type, this.bitable_biz_type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
            this.disabled_action = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bitable_biz_type(BitableBizType r100) {
            this.bitable_biz_type = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder disabled_action(Map<Integer, MessageBehavior> r100) {
            Internal.checkElementsNotNull(r100);
            this.disabled_action = r100;
            return this;
        }

        public Builder doc_url(String r100) {
            this.doc_url = r100;
            return this;
        }

        public Builder edit_time(Long r100) {
            this.edit_time = r100;
            return this;
        }

        public Builder edit_user_id(String r100) {
            this.edit_user_id = r100;
            return this;
        }

        public Builder edit_user_name(String r100) {
            this.edit_user_name = r100;
            return this;
        }

        public Builder file_type(String r100) {
            this.file_type = r100;
            return this;
        }

        public Builder icon_info(String r100) {
            this.icon_info = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253752id = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.is_cross_tenant = r100;
            return this;
        }

        public Builder is_restricted(Boolean r100) {
            this.is_restricted = r100;
            return this;
        }

        public Builder last_open_time(Long r100) {
            this.last_open_time = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder message_sender_name(String r100) {
            this.message_sender_name = r100;
            return this;
        }

        public Builder ori_id(String r100) {
            this.ori_id = r100;
            return this;
        }

        public Builder ori_type(Doc.Type r100) {
            this.ori_type = r100;
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

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }

        public Builder relation_tag(TagData r100) {
            this.relation_tag = r100;
            return this;
        }

        public Builder root_message_position(Integer r100) {
            this.root_message_position = r100;
            return this;
        }

        public Builder space_id(Long r100) {
            this.space_id = r100;
            return this;
        }

        public Builder space_name(String r100) {
            this.space_name = r100;
            return this;
        }

        public Builder thread_chat_position(Integer r100) {
            this.thread_chat_position = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }

        public Builder thread_message_type(com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType r100) {
            this.thread_message_type = r100;
            return this;
        }

        public Builder thread_position(Integer r100) {
            this.thread_position = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder type(Doc.Type r100) {
            this.type = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }

        public Builder wiki_token(String r100) {
            this.wiki_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WikiMeta extends ProtoAdapter<WikiMeta> {
        private final ProtoAdapter<Map<Integer, MessageBehavior>> disabled_action;

        public ProtoAdapter_WikiMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, WikiMeta.class);
            this.disabled_action = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, MessageBehavior.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WikiMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253752id = "";
            Doc.Type r102 = Doc.Type.UNKNOWN;
            r101.type = r102;
            r101.update_time = 0L;
            Boolean r103 = Boolean.FALSE;
            r101.is_cross_tenant = r103;
            r101.chat_id = "";
            r101.position = 0;
            r101.thread_id = "";
            r101.thread_position = 0;
            r101.thread_chat_position = 0;
            r101.message_id = "";
            r101.create_time = 0L;
            r101.last_open_time = 0L;
            r101.edit_user_id = "";
            r101.edit_user_name = "";
            r101.url = "";
            r101.doc_url = "";
            r101.space_id = 0L;
            r101.space_name = "";
            r101.token = "";
            r101.owner_id = "";
            r101.owner_name = "";
            r101.is_restricted = r103;
            r101.ori_id = "";
            r101.ori_type = r102;
            r101.icon_info = "";
            r101.thread_message_type = com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType.UNKNOWN_THREAD_MESSAGE;
            r101.root_message_position = 0;
            r101.edit_time = 0L;
            r101.message_sender_name = "";
            r101.wiki_token = "";
            r101.file_type = "";
            r101.bitable_biz_type = BitableBizType.BITABLE_BIZ_TYPE_UNKNOWN;
            long r104 = r100.beginMessage();
        L3:
            int r105 = r100.nextTag();
            if (r105 == (-1)) goto L53;
            switch(r105) {
                case 1: goto L52;
                case 2: goto L55;
                case 3: goto L47;
                case 4: goto L46;
                case 5: goto L45;
                case 6: goto L44;
                case 7: goto L43;
                case 8: goto L42;
                case 9: goto L41;
                case 10: goto L40;
                case 11: goto L39;
                case 12: goto L38;
                case 13: goto L37;
                case 14: goto L36;
                case 15: goto L35;
                case 16: goto L34;
                case 17: goto L33;
                case 18: goto L32;
                case 19: goto L31;
                case 20: goto L30;
                case 21: goto L29;
                case 22: goto L6;
                case 23: goto L28;
                case 24: goto L27;
                case 25: goto L26;
                case 26: goto L25;
                case 27: goto L61;
                case 28: goto L6;
                case 29: goto L20;
                case 30: goto L57;
                case 31: goto L15;
                case 32: goto L14;
                case 33: goto L13;
                case 34: goto L12;
                case 35: goto L11;
                case 36: goto L59;
                default: goto L6;
            };
        L55:
            r101.type = Doc.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L50
        L50:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L57:
            r101.thread_message_type = com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L59:
            r101.bitable_biz_type = BitableBizType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L61:
            r101.ori_type = Doc.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.file_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.wiki_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.message_sender_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.edit_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.root_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L20:
            r101.icon_info = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.ori_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            r101.disabled_action.putAll(this.disabled_action.decode(r100));
            goto L3
        L27:
            r101.is_restricted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L28:
            r101.relation_tag = TagData.ADAPTER.decode(r100);
            goto L3
        L29:
            r101.owner_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.owner_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L32:
            r101.space_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L33:
            r101.space_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L34:
            r101.doc_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L35:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.edit_user_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L37:
            r101.edit_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L38:
            r101.last_open_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L39:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L40:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L41:
            r101.thread_chat_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L42:
            r101.thread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L43:
            r101.thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L44:
            r101.position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L45:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L46:
            r101.is_cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L47:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L52:
            r101.f253752id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r106 = r100.peekFieldEncoding();
            r101.addUnknownField(r105, r106, r106.rawProtoAdapter().decode(r100));
            goto L3
        L53:
            r100.endMessage(r104);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(WikiMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253751id);
            Doc.Type r103 = r100.type;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = Doc.Type.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Long r107 = r100.update_time;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_cross_tenant;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.chat_id;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Integer r116 = r100.position;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.thread_id;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            Integer r122 = r100.thread_position;
            if (r122 == null) goto L29;
            int r123 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            Integer r125 = r100.thread_chat_position;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.INT32.encodedSizeWithTag(9, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.message_id;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(10, r128);
        L38:
            int r130 = r127 + r129;
            Long r131 = r100.create_time;
            if (r131 == null) goto L41;
            int r132 = ProtoAdapter.INT64.encodedSizeWithTag(11, r131);
        L42:
            int r133 = r130 + r132;
            Long r134 = r100.last_open_time;
            if (r134 == null) goto L45;
            int r135 = ProtoAdapter.INT64.encodedSizeWithTag(12, r134);
        L46:
            int r136 = r133 + r135;
            String r137 = r100.edit_user_id;
            if (r137 == null) goto L49;
            int r138 = r101.encodedSizeWithTag(13, r137);
        L50:
            int r139 = r136 + r138;
            String r140 = r100.edit_user_name;
            if (r140 == null) goto L53;
            int r141 = r101.encodedSizeWithTag(14, r140);
        L54:
            int r142 = r139 + r141;
            String r143 = r100.url;
            if (r143 == null) goto L57;
            int r144 = r101.encodedSizeWithTag(15, r143);
        L58:
            int r145 = r142 + r144;
            String r146 = r100.doc_url;
            if (r146 == null) goto L61;
            int r147 = r101.encodedSizeWithTag(16, r146);
        L62:
            int r148 = r145 + r147;
            Long r149 = r100.space_id;
            if (r149 == null) goto L65;
            int r150 = ProtoAdapter.INT64.encodedSizeWithTag(17, r149);
        L66:
            int r151 = r148 + r150;
            String r152 = r100.space_name;
            if (r152 == null) goto L69;
            int r153 = r101.encodedSizeWithTag(18, r152);
        L70:
            int r154 = r151 + r153;
            String r155 = r100.token;
            if (r155 == null) goto L73;
            int r156 = r101.encodedSizeWithTag(19, r155);
        L74:
            int r157 = r154 + r156;
            String r158 = r100.owner_id;
            if (r158 == null) goto L77;
            int r159 = r101.encodedSizeWithTag(20, r158);
        L78:
            int r160 = r157 + r159;
            String r161 = r100.owner_name;
            if (r161 == null) goto L81;
            int r162 = r101.encodedSizeWithTag(21, r161);
        L82:
            int r163 = r160 + r162;
            TagData r164 = r100.relation_tag;
            if (r164 == null) goto L85;
            int r165 = TagData.ADAPTER.encodedSizeWithTag(23, r164);
        L86:
            int r166 = r163 + r165;
            Boolean r167 = r100.is_restricted;
            if (r167 == null) goto L89;
            int r168 = ProtoAdapter.BOOL.encodedSizeWithTag(24, r167);
        L90:
            int r169 = (r166 + r168) + this.disabled_action.encodedSizeWithTag(25, r100.disabled_action);
            String r170 = r100.ori_id;
            if (r170 == null) goto L93;
            int r171 = r101.encodedSizeWithTag(26, r170);
        L94:
            int r172 = r169 + r171;
            Doc.Type r173 = r100.ori_type;
            if (r173 == null) goto L97;
            int r174 = Doc.Type.ADAPTER.encodedSizeWithTag(27, r173);
        L98:
            int r175 = r172 + r174;
            String r176 = r100.icon_info;
            if (r176 == null) goto L101;
            int r177 = r101.encodedSizeWithTag(29, r176);
        L102:
            int r178 = r175 + r177;
            com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType r179 = r100.thread_message_type;
            if (r179 == null) goto L105;
            int r180 = com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType.ADAPTER.encodedSizeWithTag(30, r179);
        L106:
            int r181 = r178 + r180;
            Integer r182 = r100.root_message_position;
            if (r182 == null) goto L109;
            int r183 = ProtoAdapter.INT32.encodedSizeWithTag(31, r182);
        L110:
            int r184 = r181 + r183;
            Long r185 = r100.edit_time;
            if (r185 == null) goto L113;
            int r186 = ProtoAdapter.INT64.encodedSizeWithTag(32, r185);
        L114:
            int r187 = r184 + r186;
            String r188 = r100.message_sender_name;
            if (r188 == null) goto L117;
            int r189 = r101.encodedSizeWithTag(33, r188);
        L118:
            int r190 = r187 + r189;
            String r191 = r100.wiki_token;
            if (r191 == null) goto L121;
            int r192 = r101.encodedSizeWithTag(34, r191);
        L122:
            int r193 = r190 + r192;
            String r194 = r100.file_type;
            if (r194 == null) goto L125;
            int r195 = r101.encodedSizeWithTag(35, r194);
        L126:
            int r196 = r193 + r195;
            BitableBizType r197 = r100.bitable_biz_type;
            if (r197 == null) goto L130;
            r104 = BitableBizType.ADAPTER.encodedSizeWithTag(36, r197);
        L130:
            return (r196 + r104) + r100.unknownFields().size();
        L125:
            r195 = 0;
            goto L126
        L121:
            r192 = 0;
            goto L122
        L117:
            r189 = 0;
            goto L118
        L113:
            r186 = 0;
            goto L114
        L109:
            r183 = 0;
            goto L110
        L105:
            r180 = 0;
            goto L106
        L101:
            r177 = 0;
            goto L102
        L97:
            r174 = 0;
            goto L98
        L93:
            r171 = 0;
            goto L94
        L89:
            r168 = 0;
            goto L90
        L85:
            r165 = 0;
            goto L86
        L81:
            r162 = 0;
            goto L82
        L77:
            r159 = 0;
            goto L78
        L73:
            r156 = 0;
            goto L74
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
        public /* bridge */ /* synthetic */ WikiMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WikiMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WikiMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253751id);
            Doc.Type r103 = r101.type;
            if (r103 == null) goto L5;
            Doc.Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            Long r104 = r101.update_time;
            if (r104 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L8:
            Boolean r105 = r101.is_cross_tenant;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.chat_id;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 5, r106);
        L14:
            Integer r107 = r101.position;
            if (r107 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.thread_id;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            Integer r109 = r101.thread_position;
            if (r109 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
        L23:
            Integer r110 = r101.thread_chat_position;
            if (r110 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 9, r110);
        L26:
            String r111 = r101.message_id;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 10, r111);
        L29:
            Long r112 = r101.create_time;
            if (r112 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 11, r112);
        L32:
            Long r113 = r101.last_open_time;
            if (r113 == null) goto L35;
            ProtoAdapter.INT64.encodeWithTag(r100, 12, r113);
        L35:
            String r114 = r101.edit_user_id;
            if (r114 == null) goto L38;
            r102.encodeWithTag(r100, 13, r114);
        L38:
            String r115 = r101.edit_user_name;
            if (r115 == null) goto L41;
            r102.encodeWithTag(r100, 14, r115);
        L41:
            String r116 = r101.url;
            if (r116 == null) goto L44;
            r102.encodeWithTag(r100, 15, r116);
        L44:
            String r117 = r101.doc_url;
            if (r117 == null) goto L47;
            r102.encodeWithTag(r100, 16, r117);
        L47:
            Long r118 = r101.space_id;
            if (r118 == null) goto L50;
            ProtoAdapter.INT64.encodeWithTag(r100, 17, r118);
        L50:
            String r119 = r101.space_name;
            if (r119 == null) goto L53;
            r102.encodeWithTag(r100, 18, r119);
        L53:
            String r120 = r101.token;
            if (r120 == null) goto L56;
            r102.encodeWithTag(r100, 19, r120);
        L56:
            String r121 = r101.owner_id;
            if (r121 == null) goto L59;
            r102.encodeWithTag(r100, 20, r121);
        L59:
            String r122 = r101.owner_name;
            if (r122 == null) goto L62;
            r102.encodeWithTag(r100, 21, r122);
        L62:
            TagData r123 = r101.relation_tag;
            if (r123 == null) goto L65;
            TagData.ADAPTER.encodeWithTag(r100, 23, r123);
        L65:
            Boolean r124 = r101.is_restricted;
            if (r124 == null) goto L68;
            ProtoAdapter.BOOL.encodeWithTag(r100, 24, r124);
        L68:
            this.disabled_action.encodeWithTag(r100, 25, r101.disabled_action);
            String r125 = r101.ori_id;
            if (r125 == null) goto L71;
            r102.encodeWithTag(r100, 26, r125);
        L71:
            Doc.Type r126 = r101.ori_type;
            if (r126 == null) goto L74;
            Doc.Type.ADAPTER.encodeWithTag(r100, 27, r126);
        L74:
            String r127 = r101.icon_info;
            if (r127 == null) goto L77;
            r102.encodeWithTag(r100, 29, r127);
        L77:
            com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType r128 = r101.thread_message_type;
            if (r128 == null) goto L80;
            com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType.ADAPTER.encodeWithTag(r100, 30, r128);
        L80:
            Integer r129 = r101.root_message_position;
            if (r129 == null) goto L83;
            ProtoAdapter.INT32.encodeWithTag(r100, 31, r129);
        L83:
            Long r130 = r101.edit_time;
            if (r130 == null) goto L86;
            ProtoAdapter.INT64.encodeWithTag(r100, 32, r130);
        L86:
            String r131 = r101.message_sender_name;
            if (r131 == null) goto L89;
            r102.encodeWithTag(r100, 33, r131);
        L89:
            String r132 = r101.wiki_token;
            if (r132 == null) goto L92;
            r102.encodeWithTag(r100, 34, r132);
        L92:
            String r133 = r101.file_type;
            if (r133 == null) goto L95;
            r102.encodeWithTag(r100, 35, r133);
        L95:
            BitableBizType r134 = r101.bitable_biz_type;
            if (r134 == null) goto L98;
            BitableBizType.ADAPTER.encodeWithTag(r100, 36, r134);
        L98:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WikiMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WikiMeta();
        Doc.Type r100 = Doc.Type.UNKNOWN;
        DEFAULT_TYPE = r100;
        DEFAULT_UPDATE_TIME = 0L;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_CROSS_TENANT = r101;
        DEFAULT_POSITION = 0;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_THREAD_CHAT_POSITION = 0;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_LAST_OPEN_TIME = 0L;
        DEFAULT_SPACE_ID = 0L;
        DEFAULT_IS_RESTRICTED = r101;
        DEFAULT_ORI_TYPE = r100;
        DEFAULT_THREAD_MESSAGE_TYPE = com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType.UNKNOWN_THREAD_MESSAGE;
        DEFAULT_ROOT_MESSAGE_POSITION = 0;
        DEFAULT_EDIT_TIME = 0L;
        DEFAULT_BITABLE_BIZ_TYPE = BitableBizType.BITABLE_BIZ_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253752id = this.f253751id;
        r100.type = this.type;
        r100.update_time = this.update_time;
        r100.is_cross_tenant = this.is_cross_tenant;
        r100.chat_id = this.chat_id;
        r100.position = this.position;
        r100.thread_id = this.thread_id;
        r100.thread_position = this.thread_position;
        r100.thread_chat_position = this.thread_chat_position;
        r100.message_id = this.message_id;
        r100.create_time = this.create_time;
        r100.last_open_time = this.last_open_time;
        r100.edit_user_id = this.edit_user_id;
        r100.edit_user_name = this.edit_user_name;
        r100.url = this.url;
        r100.doc_url = this.doc_url;
        r100.space_id = this.space_id;
        r100.space_name = this.space_name;
        r100.token = this.token;
        r100.owner_id = this.owner_id;
        r100.owner_name = this.owner_name;
        r100.relation_tag = this.relation_tag;
        r100.is_restricted = this.is_restricted;
        r100.disabled_action = Internal.copyOf("disabled_action", this.disabled_action);
        r100.ori_id = this.ori_id;
        r100.ori_type = this.ori_type;
        r100.icon_info = this.icon_info;
        r100.thread_message_type = this.thread_message_type;
        r100.root_message_position = this.root_message_position;
        r100.edit_time = this.edit_time;
        r100.message_sender_name = this.message_sender_name;
        r100.wiki_token = this.wiki_token;
        r100.file_type = this.file_type;
        r100.bitable_biz_type = this.bitable_biz_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WikiMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WikiMeta(String r310, Doc.Type r311, Long r312, Boolean r410, String r411, Integer r412, String r413, Integer r414, Integer r415, String r416, Long r417, Long r418, String r419, String r510, String r511, String r512, Long r513, String r514, String r515, String r516, String r517, TagData r518, Boolean r519, Map<Integer, MessageBehavior> r610, String r611, Doc.Type r612, String r613, com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType r614, Integer r615, Long r616, String r617, String r618, String r619, BitableBizType r710) {
        this(r310, r311, r312, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, ByteString.EMPTY);
    }

    public WikiMeta(String r100, Doc.Type r101, Long r102, Boolean r103, String r104, Integer r105, String r110, Integer r111, Integer r112, String r113, Long r114, Long r115, String r116, String r117, String r118, String r119, Long r210, String r211, String r212, String r213, String r214, TagData r215, Boolean r216, Map<Integer, MessageBehavior> r217, String r218, Doc.Type r219, String r310, com.bytedance.lark.pb.basic.v1.Message.ThreadMessageType r311, Integer r312, Long r313, String r314, String r315, String r316, BitableBizType r317, ByteString r318) {
        super(ADAPTER, r318);
        this.f253751id = r100;
        this.type = r101;
        this.update_time = r102;
        this.is_cross_tenant = r103;
        this.chat_id = r104;
        this.position = r105;
        this.thread_id = r110;
        this.thread_position = r111;
        this.thread_chat_position = r112;
        this.message_id = r113;
        this.create_time = r114;
        this.last_open_time = r115;
        this.edit_user_id = r116;
        this.edit_user_name = r117;
        this.url = r118;
        this.doc_url = r119;
        this.space_id = r210;
        this.space_name = r211;
        this.token = r212;
        this.owner_id = r213;
        this.owner_name = r214;
        this.relation_tag = r215;
        this.is_restricted = r216;
        this.disabled_action = Internal.immutableCopyOf("disabled_action", r217);
        this.ori_id = r218;
        this.ori_type = r219;
        this.icon_info = r310;
        this.thread_message_type = r311;
        this.root_message_position = r312;
        this.edit_time = r313;
        this.message_sender_name = r314;
        this.wiki_token = r315;
        this.file_type = r316;
        this.bitable_biz_type = r317;
    }
}
