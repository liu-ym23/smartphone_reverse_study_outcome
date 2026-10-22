package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.AvatarMeta;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.PickEntities;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CreateChatRequest extends Message<CreateChatRequest, Builder> {
    public static final ProtoAdapter<CreateChatRequest> ADAPTER = null;
    public static final Chat.ChatMode DEFAULT_CHAT_MODE = null;
    public static final String DEFAULT_CHAT_TEMPLATE_ID = "";
    public static final String DEFAULT_DEPARTMENT_ID = "";
    public static final String DEFAULT_FROM_CHAT_ID = "";
    public static final String DEFAULT_GROUP_DESC = "";
    public static final String DEFAULT_GROUP_NAME = "";
    public static final String DEFAULT_ICON_KEY = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_CRYPTO = null;
    public static final Boolean DEFAULT_IS_PRIVATE_MODE = null;
    public static final Boolean DEFAULT_IS_PUBLIC = null;
    public static final Boolean DEFAULT_IS_PUBLIC_V2 = null;
    public static final PutChatSource DEFAULT_SOURCE = null;
    public static final Chat.Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_CreateChatRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AvatarMeta avatar_meta;
    public final Chat.ChatMode chat_mode;
    public final String chat_template_id;
    public final List<String> chatter_ids;
    public final CreateP2PChatSource create_p2p_chat_source;
    public final String department_id;
    public final String from_chat_id;
    public final String group_desc;
    public final String group_name;
    public final String icon_key;
    public final List<String> init_message_ids;
    public final Boolean is_cross_tenant;
    public final Boolean is_crypto;
    public final Boolean is_private_mode;
    public final Boolean is_public;
    public final Boolean is_public_v2;
    public final Map<String, DocPermissions> message_doc_permissions;
    public final Map<String, DocPermission> message_id2permission;
    public final List<PickEntities> pick_entities;
    public final PutChatSource source;
    public final List<ChatPageContext> to_link_pages;
    public final Chat.Type type;

    public static final class Builder extends Message.Builder<CreateChatRequest, Builder> implements d<CreateChatRequest> {
        public AvatarMeta avatar_meta;
        public Chat.ChatMode chat_mode;
        public String chat_template_id;
        public List<String> chatter_ids;
        public CreateP2PChatSource create_p2p_chat_source;
        public String department_id;
        public String from_chat_id;
        public String group_desc;
        public String group_name;
        public String icon_key;
        public List<String> init_message_ids;
        public Boolean is_cross_tenant;
        public Boolean is_crypto;
        public Boolean is_private_mode;
        public Boolean is_public;
        public Boolean is_public_v2;
        public Map<String, DocPermissions> message_doc_permissions;
        public Map<String, DocPermission> message_id2permission;
        public List<PickEntities> pick_entities;
        public PutChatSource source;
        public List<ChatPageContext> to_link_pages;
        public Chat.Type type;

        @Override // com.squareup.wire.Message.Builder
        public CreateChatRequest build() {
            Chat.Type r100 = this.type;
            if (r100 == null) goto L7;
            return new CreateChatRequest(this.type, this.chatter_ids, this.group_name, this.group_desc, this.is_public, this.from_chat_id, this.init_message_ids, this.icon_key, this.message_id2permission, this.is_crypto, this.department_id, this.is_cross_tenant, this.is_public_v2, this.chat_mode, this.message_doc_permissions, this.avatar_meta, this.create_p2p_chat_source, this.pick_entities, this.chat_template_id, this.is_private_mode, this.source, this.to_link_pages, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
            this.chatter_ids = Internal.newMutableList();
            this.init_message_ids = Internal.newMutableList();
            this.message_id2permission = Internal.newMutableMap();
            this.message_doc_permissions = Internal.newMutableMap();
            this.pick_entities = Internal.newMutableList();
            this.to_link_pages = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_meta(AvatarMeta r100) {
            this.avatar_meta = r100;
            return this;
        }

        public Builder chat_mode(Chat.ChatMode r100) {
            this.chat_mode = r100;
            return this;
        }

        public Builder chat_template_id(String r100) {
            this.chat_template_id = r100;
            return this;
        }

        public Builder chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_ids = r100;
            return this;
        }

        public Builder create_p2p_chat_source(CreateP2PChatSource r100) {
            this.create_p2p_chat_source = r100;
            return this;
        }

        public Builder department_id(String r100) {
            this.department_id = r100;
            return this;
        }

        public Builder from_chat_id(String r100) {
            this.from_chat_id = r100;
            return this;
        }

        public Builder group_desc(String r100) {
            this.group_desc = r100;
            return this;
        }

        public Builder group_name(String r100) {
            this.group_name = r100;
            return this;
        }

        public Builder icon_key(String r100) {
            this.icon_key = r100;
            return this;
        }

        public Builder init_message_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.init_message_ids = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.is_cross_tenant = r100;
            return this;
        }

        public Builder is_crypto(Boolean r100) {
            this.is_crypto = r100;
            return this;
        }

        public Builder is_private_mode(Boolean r100) {
            this.is_private_mode = r100;
            return this;
        }

        public Builder is_public(Boolean r100) {
            this.is_public = r100;
            return this;
        }

        public Builder is_public_v2(Boolean r100) {
            this.is_public_v2 = r100;
            return this;
        }

        public Builder message_doc_permissions(Map<String, DocPermissions> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_doc_permissions = r100;
            return this;
        }

        public Builder message_id2permission(Map<String, DocPermission> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_id2permission = r100;
            return this;
        }

        public Builder pick_entities(List<PickEntities> r100) {
            Internal.checkElementsNotNull(r100);
            this.pick_entities = r100;
            return this;
        }

        public Builder source(PutChatSource r100) {
            this.source = r100;
            return this;
        }

        public Builder to_link_pages(List<ChatPageContext> r100) {
            Internal.checkElementsNotNull(r100);
            this.to_link_pages = r100;
            return this;
        }

        public Builder type(Chat.Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final enum DocPermission extends Enum<DocPermission> implements WireEnum {
        private static final /* synthetic */ DocPermission[] $VALUES = null;
        public static final ProtoAdapter<DocPermission> ADAPTER = null;
        public static final DocPermission EDIT = null;
        public static final DocPermission READ = null;
        public static final DocPermission UNKNOWN = null;
        private final int value;

        static {
            DocPermission r100 = new DocPermission("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            DocPermission r101 = new DocPermission("READ", 1, 1);
            READ = r101;
            DocPermission r102 = new DocPermission("EDIT", 2, 2);
            EDIT = r102;
            $VALUES = new DocPermission[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(DocPermission.class);
        }

        public static DocPermission[] values() {
            return (DocPermission[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DocPermission fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return EDIT;
        L12:
            return READ;
        L14:
            return UNKNOWN;
        }

        public static DocPermission valueOf(String r100) {
            return (DocPermission) a.a(DocPermission.class, r100);
        }

        private DocPermission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class DocPermissions extends Message<DocPermissions, Builder> {
        public static final ProtoAdapter<DocPermissions> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<String, DocPermission> perms;

        public static final class Builder extends Message.Builder<DocPermissions, Builder> {
            public Map<String, DocPermission> perms;

            @Override // com.squareup.wire.Message.Builder
            public DocPermissions build() {
                return new DocPermissions(this.perms, super.buildUnknownFields());
            }

            public Builder() {
                this.perms = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder perms(Map<String, DocPermission> r100) {
                Internal.checkElementsNotNull(r100);
                this.perms = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DocPermissions extends ProtoAdapter<DocPermissions> {
            private final ProtoAdapter<Map<String, DocPermission>> perms;

            public ProtoAdapter_DocPermissions() {
                super(FieldEncoding.LENGTH_DELIMITED, DocPermissions.class);
                this.perms = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, DocPermission.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DocPermissions decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.perms.putAll(this.perms.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DocPermissions r100) {
                return this.perms.encodedSizeWithTag(1, r100.perms) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DocPermissions decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DocPermissions r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DocPermissions r101) throws IOException {
                this.perms.encodeWithTag(r100, 1, r101.perms);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocPermissions r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocPermissions();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.perms = Internal.copyOf("perms", this.perms);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DocPermissions.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DocPermissions(Map<String, DocPermission> r100) {
            this(r100, ByteString.EMPTY);
        }

        public DocPermissions(Map<String, DocPermission> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.perms = Internal.immutableCopyOf("perms", r100);
        }
    }

    public static final class ProtoAdapter_CreateChatRequest extends ProtoAdapter<CreateChatRequest> implements c<CreateChatRequest> {
        private final ProtoAdapter<Map<String, DocPermissions>> message_doc_permissions;
        private final ProtoAdapter<Map<String, DocPermission>> message_id2permission;

        public ProtoAdapter_CreateChatRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateChatRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.message_id2permission = ProtoAdapter.newMapAdapter(r100, DocPermission.ADAPTER);
            this.message_doc_permissions = ProtoAdapter.newMapAdapter(r100, DocPermissions.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateChatRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Chat.Type.P2P;
            r101.group_name = "";
            r101.group_desc = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_public = r102;
            r101.from_chat_id = "";
            r101.icon_key = "";
            r101.is_crypto = r102;
            r101.department_id = "";
            r101.is_cross_tenant = r102;
            r101.is_public_v2 = r102;
            r101.chat_mode = Chat.ChatMode.UNKNOWN;
            r101.chat_template_id = "";
            r101.is_private_mode = r102;
            r101.source = PutChatSource.UNKNOWN_SOURCE;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L38;
            switch(r104) {
                case 1: goto L44;
                case 2: goto L33;
                case 3: goto L32;
                case 4: goto L31;
                case 5: goto L30;
                case 6: goto L29;
                case 7: goto L28;
                case 8: goto L27;
                case 9: goto L26;
                case 10: goto L25;
                case 11: goto L24;
                case 12: goto L23;
                case 13: goto L22;
                case 14: goto L42;
                case 15: goto L17;
                case 16: goto L16;
                case 17: goto L15;
                case 18: goto L6;
                case 19: goto L14;
                case 20: goto L6;
                case 21: goto L13;
                case 22: goto L12;
                case 23: goto L40;
                case 24: goto L7;
                default: goto L6;
            };
        L40:
            r101.source = PutChatSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L42:
            r101.chat_mode = Chat.ChatMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L44:
            r101.type = Chat.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L36
        L36:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.to_link_pages.add(ChatPageContext.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.is_private_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.chat_template_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.pick_entities.add(PickEntities.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.create_p2p_chat_source = CreateP2PChatSource.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.avatar_meta = AvatarMeta.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.message_doc_permissions.putAll(this.message_doc_permissions.decode(r100));
            goto L3
        L22:
            r101.is_public_v2 = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L23:
            r101.is_cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.department_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.is_crypto = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L26:
            r101.message_id2permission.putAll(this.message_id2permission.decode(r100));
            goto L3
        L27:
            r101.icon_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            r101.init_message_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L29:
            r101.from_chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.is_public = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L31:
            r101.group_desc = ProtoAdapter.STRING.decode(r100);
            goto L3
        L32:
            r101.group_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L33:
            r101.chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L38:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CreateChatRequest r100) {
            int r101 = Chat.Type.ADAPTER.encodedSizeWithTag(1, r100.type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = r101 + r102.asRepeated().encodedSizeWithTag(2, r100.chatter_ids);
            String r104 = r100.group_name;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r102.encodedSizeWithTag(3, r104);
        L6:
            int r107 = r103 + r106;
            String r108 = r100.group_desc;
            if (r108 == null) goto L9;
            int r109 = r102.encodedSizeWithTag(4, r108);
        L10:
            int r110 = r107 + r109;
            Boolean r111 = r100.is_public;
            if (r111 == null) goto L13;
            int r112 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r111);
        L14:
            int r113 = r110 + r112;
            String r114 = r100.from_chat_id;
            if (r114 == null) goto L17;
            int r115 = r102.encodedSizeWithTag(6, r114);
        L18:
            int r116 = (r113 + r115) + r102.asRepeated().encodedSizeWithTag(7, r100.init_message_ids);
            String r117 = r100.icon_key;
            if (r117 == null) goto L21;
            int r118 = r102.encodedSizeWithTag(8, r117);
        L22:
            int r119 = (r116 + r118) + this.message_id2permission.encodedSizeWithTag(9, r100.message_id2permission);
            Boolean r120 = r100.is_crypto;
            if (r120 == null) goto L25;
            int r121 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r120);
        L26:
            int r122 = r119 + r121;
            String r123 = r100.department_id;
            if (r123 == null) goto L29;
            int r124 = r102.encodedSizeWithTag(11, r123);
        L30:
            int r125 = r122 + r124;
            Boolean r126 = r100.is_cross_tenant;
            if (r126 == null) goto L33;
            int r127 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r126);
        L34:
            int r128 = r125 + r127;
            Boolean r129 = r100.is_public_v2;
            if (r129 == null) goto L37;
            int r130 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r129);
        L38:
            int r131 = r128 + r130;
            Chat.ChatMode r132 = r100.chat_mode;
            if (r132 == null) goto L41;
            int r133 = Chat.ChatMode.ADAPTER.encodedSizeWithTag(14, r132);
        L42:
            int r134 = (r131 + r133) + this.message_doc_permissions.encodedSizeWithTag(15, r100.message_doc_permissions);
            AvatarMeta r135 = r100.avatar_meta;
            if (r135 == null) goto L45;
            int r136 = AvatarMeta.ADAPTER.encodedSizeWithTag(16, r135);
        L46:
            int r137 = r134 + r136;
            CreateP2PChatSource r138 = r100.create_p2p_chat_source;
            if (r138 == null) goto L49;
            int r139 = CreateP2PChatSource.ADAPTER.encodedSizeWithTag(17, r138);
        L50:
            int r140 = (r137 + r139) + PickEntities.ADAPTER.asRepeated().encodedSizeWithTag(19, r100.pick_entities);
            String r141 = r100.chat_template_id;
            if (r141 == null) goto L53;
            int r142 = r102.encodedSizeWithTag(21, r141);
        L54:
            int r143 = r140 + r142;
            Boolean r144 = r100.is_private_mode;
            if (r144 == null) goto L57;
            int r145 = ProtoAdapter.BOOL.encodedSizeWithTag(22, r144);
        L58:
            int r146 = r143 + r145;
            PutChatSource r147 = r100.source;
            if (r147 == null) goto L62;
            r105 = PutChatSource.ADAPTER.encodedSizeWithTag(23, r147);
        L62:
            return ((r146 + r105) + ChatPageContext.ADAPTER.asRepeated().encodedSizeWithTag(24, r100.to_link_pages)) + r100.unknownFields().size();
        L57:
            r145 = 0;
            goto L58
        L53:
            r142 = 0;
            goto L54
        L49:
            r139 = 0;
            goto L50
        L45:
            r136 = 0;
            goto L46
        L41:
            r133 = 0;
            goto L42
        L37:
            r130 = 0;
            goto L38
        L33:
            r127 = 0;
            goto L34
        L29:
            r124 = 0;
            goto L30
        L25:
            r121 = 0;
            goto L26
        L21:
            r118 = 0;
            goto L22
        L17:
            r115 = 0;
            goto L18
        L13:
            r112 = 0;
            goto L14
        L9:
            r109 = 0;
            goto L10
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateChatRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateChatRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateChatRequest r101) throws IOException {
            Chat.Type.ADAPTER.encodeWithTag(r100, 1, r101.type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 2, r101.chatter_ids);
            String r103 = r101.group_name;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.group_desc;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            Boolean r105 = r101.is_public;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L11:
            String r106 = r101.from_chat_id;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 6, r106);
        L14:
            r102.asRepeated().encodeWithTag(r100, 7, r101.init_message_ids);
            String r107 = r101.icon_key;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 8, r107);
        L17:
            this.message_id2permission.encodeWithTag(r100, 9, r101.message_id2permission);
            Boolean r108 = r101.is_crypto;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r108);
        L20:
            String r109 = r101.department_id;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 11, r109);
        L23:
            Boolean r110 = r101.is_cross_tenant;
            if (r110 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r110);
        L26:
            Boolean r111 = r101.is_public_v2;
            if (r111 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 13, r111);
        L29:
            Chat.ChatMode r112 = r101.chat_mode;
            if (r112 == null) goto L32;
            Chat.ChatMode.ADAPTER.encodeWithTag(r100, 14, r112);
        L32:
            this.message_doc_permissions.encodeWithTag(r100, 15, r101.message_doc_permissions);
            AvatarMeta r113 = r101.avatar_meta;
            if (r113 == null) goto L35;
            AvatarMeta.ADAPTER.encodeWithTag(r100, 16, r113);
        L35:
            CreateP2PChatSource r114 = r101.create_p2p_chat_source;
            if (r114 == null) goto L38;
            CreateP2PChatSource.ADAPTER.encodeWithTag(r100, 17, r114);
        L38:
            PickEntities.ADAPTER.asRepeated().encodeWithTag(r100, 19, r101.pick_entities);
            String r115 = r101.chat_template_id;
            if (r115 == null) goto L41;
            r102.encodeWithTag(r100, 21, r115);
        L41:
            Boolean r116 = r101.is_private_mode;
            if (r116 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r100, 22, r116);
        L44:
            PutChatSource r117 = r101.source;
            if (r117 == null) goto L47;
            PutChatSource.ADAPTER.encodeWithTag(r100, 23, r117);
        L47:
            ChatPageContext.ADAPTER.asRepeated().encodeWithTag(r100, 24, r101.to_link_pages);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateChatRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum PutChatSource extends Enum<PutChatSource> implements WireEnum {
        private static final /* synthetic */ PutChatSource[] $VALUES = null;
        public static final ProtoAdapter<PutChatSource> ADAPTER = null;
        public static final PutChatSource TO_LINK_PAGE = null;
        public static final PutChatSource UNKNOWN_SOURCE = null;
        private final int value;

        static {
            PutChatSource r100 = new PutChatSource("UNKNOWN_SOURCE", 0, 0);
            UNKNOWN_SOURCE = r100;
            PutChatSource r101 = new PutChatSource("TO_LINK_PAGE", 1, 1);
            TO_LINK_PAGE = r101;
            $VALUES = new PutChatSource[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(PutChatSource.class);
        }

        public static PutChatSource[] values() {
            return (PutChatSource[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PutChatSource fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return TO_LINK_PAGE;
        L10:
            return UNKNOWN_SOURCE;
        }

        public static PutChatSource valueOf(String r100) {
            return (PutChatSource) a.a(PutChatSource.class, r100);
        }

        private PutChatSource(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_CreateChatRequest r100 = new ProtoAdapter_CreateChatRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = Chat.Type.P2P;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_PUBLIC = r101;
        DEFAULT_IS_CRYPTO = r101;
        DEFAULT_IS_CROSS_TENANT = r101;
        DEFAULT_IS_PUBLIC_V2 = r101;
        DEFAULT_CHAT_MODE = Chat.ChatMode.UNKNOWN;
        DEFAULT_IS_PRIVATE_MODE = r101;
        DEFAULT_SOURCE = PutChatSource.UNKNOWN_SOURCE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
        r100.group_name = this.group_name;
        r100.group_desc = this.group_desc;
        r100.is_public = this.is_public;
        r100.from_chat_id = this.from_chat_id;
        r100.init_message_ids = Internal.copyOf("init_message_ids", this.init_message_ids);
        r100.icon_key = this.icon_key;
        r100.message_id2permission = Internal.copyOf("message_id2permission", this.message_id2permission);
        r100.is_crypto = this.is_crypto;
        r100.department_id = this.department_id;
        r100.is_cross_tenant = this.is_cross_tenant;
        r100.is_public_v2 = this.is_public_v2;
        r100.chat_mode = this.chat_mode;
        r100.message_doc_permissions = Internal.copyOf("message_doc_permissions", this.message_doc_permissions);
        r100.avatar_meta = this.avatar_meta;
        r100.create_p2p_chat_source = this.create_p2p_chat_source;
        r100.pick_entities = Internal.copyOf("pick_entities", this.pick_entities);
        r100.chat_template_id = this.chat_template_id;
        r100.is_private_mode = this.is_private_mode;
        r100.source = this.source;
        r100.to_link_pages = Internal.copyOf("to_link_pages", this.to_link_pages);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateChatRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateChatRequest(Chat.Type r210, List<String> r211, String r212, String r213, Boolean r214, String r310, List<String> r311, String r312, Map<String, DocPermission> r313, Boolean r314, String r315, Boolean r316, Boolean r317, Chat.ChatMode r318, Map<String, DocPermissions> r319, AvatarMeta r410, CreateP2PChatSource r411, List<PickEntities> r412, String r413, Boolean r414, PutChatSource r415, List<ChatPageContext> r416) {
        this(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, ByteString.EMPTY);
    }

    public CreateChatRequest(Chat.Type r100, List<String> r101, String r102, String r103, Boolean r104, String r105, List<String> r110, String r111, Map<String, DocPermission> r112, Boolean r113, String r114, Boolean r115, Boolean r116, Chat.ChatMode r117, Map<String, DocPermissions> r118, AvatarMeta r119, CreateP2PChatSource r210, List<PickEntities> r211, String r212, Boolean r213, PutChatSource r214, List<ChatPageContext> r215, ByteString r216) {
        super(ADAPTER, r216);
        this.type = r100;
        this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r101);
        this.group_name = r102;
        this.group_desc = r103;
        this.is_public = r104;
        this.from_chat_id = r105;
        this.init_message_ids = Internal.immutableCopyOf("init_message_ids", r110);
        this.icon_key = r111;
        this.message_id2permission = Internal.immutableCopyOf("message_id2permission", r112);
        this.is_crypto = r113;
        this.department_id = r114;
        this.is_cross_tenant = r115;
        this.is_public_v2 = r116;
        this.chat_mode = r117;
        this.message_doc_permissions = Internal.immutableCopyOf("message_doc_permissions", r118);
        this.avatar_meta = r119;
        this.create_p2p_chat_source = r210;
        this.pick_entities = Internal.immutableCopyOf("pick_entities", r211);
        this.chat_template_id = r212;
        this.is_private_mode = r213;
        this.source = r214;
        this.to_link_pages = Internal.immutableCopyOf("to_link_pages", r215);
    }
}
