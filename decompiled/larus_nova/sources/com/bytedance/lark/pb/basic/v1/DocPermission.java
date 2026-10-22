package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DocPermission extends com.squareup.wire.Message<DocPermission, Builder> {
    public static final ProtoAdapter<DocPermission> ADAPTER = null;
    public static final Long DEFAULT_AUTHED_BY_USER_ID = null;
    public static final Integer DEFAULT_AUTHED_PERM = null;
    public static final String DEFAULT_CHANNEL_ID = "";
    public static final String DEFAULT_DOC_URL = "";
    public static final Long DEFAULT_EXPIRES = null;
    public static final String DEFAULT_EXTRA = "";
    public static final String DEFAULT_KEY = "";
    public static final Boolean DEFAULT_MESSAGE_EXISTED = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Integer DEFAULT_RECEIVER_PERM = null;
    public static final Integer DEFAULT_SELECTED_PERMISSION_INDEX = null;
    public static final Boolean DEFAULT_SENDER_IS_EXTERNAL = null;
    public static final Long DEFAULT_SHARE_STATUS = null;
    public static final String DEFAULT_SHARE_TEXT = "";
    public static final Boolean DEFAULT_SHOULD_RENDER = null;
    public static final String DEFAULT_THUMBNAIL_DETAIL = "";
    public static final String DEFAULT_TITLE = "";
    public static final Integer DEFAULT_USER_PERM = null;
    private static final long serialVersionUID = 0;
    public final Long authed_by_user_id;
    public final Integer authed_perm;
    public final String channel_id;
    public final String doc_url;
    public final Long expires;
    public final String extra;
    public final String key;
    public final Boolean message_existed;
    public final String message_id;
    public final List<Permission> optional_permissions;
    public final Integer receiver_perm;
    public final Integer selected_permission_index;
    public final Boolean sender_is_external;
    public final Long share_status;
    public final String share_text;
    public final Boolean should_render;
    public final String thumbnail_detail;
    public final String title;
    public final Integer user_perm;

    public static final class Builder extends com.squareup.wire.Message.Builder<DocPermission, Builder> {
        public Long authed_by_user_id;
        public Integer authed_perm;
        public String channel_id;
        public String doc_url;
        public Long expires;
        public String extra;
        public String key;
        public Boolean message_existed;
        public String message_id;
        public List<Permission> optional_permissions;
        public Integer receiver_perm;
        public Integer selected_permission_index;
        public Boolean sender_is_external;
        public Long share_status;
        public String share_text;
        public Boolean should_render;
        public String thumbnail_detail;
        public String title;
        public Integer user_perm;

        @Override // com.squareup.wire.Message.Builder
        public DocPermission build() {
            return new DocPermission(this.key, this.message_id, this.channel_id, this.optional_permissions, this.selected_permission_index, this.share_text, this.should_render, this.title, this.expires, this.user_perm, this.authed_by_user_id, this.authed_perm, this.message_existed, this.share_status, this.thumbnail_detail, this.doc_url, this.receiver_perm, this.sender_is_external, this.extra, super.buildUnknownFields());
        }

        public Builder() {
            this.optional_permissions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder authed_by_user_id(Long r100) {
            this.authed_by_user_id = r100;
            return this;
        }

        public Builder authed_perm(Integer r100) {
            this.authed_perm = r100;
            return this;
        }

        public Builder channel_id(String r100) {
            this.channel_id = r100;
            return this;
        }

        public Builder doc_url(String r100) {
            this.doc_url = r100;
            return this;
        }

        public Builder expires(Long r100) {
            this.expires = r100;
            return this;
        }

        public Builder extra(String r100) {
            this.extra = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder message_existed(Boolean r100) {
            this.message_existed = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder optional_permissions(List<Permission> r100) {
            Internal.checkElementsNotNull(r100);
            this.optional_permissions = r100;
            return this;
        }

        public Builder receiver_perm(Integer r100) {
            this.receiver_perm = r100;
            return this;
        }

        public Builder selected_permission_index(Integer r100) {
            this.selected_permission_index = r100;
            return this;
        }

        public Builder sender_is_external(Boolean r100) {
            this.sender_is_external = r100;
            return this;
        }

        public Builder share_status(Long r100) {
            this.share_status = r100;
            return this;
        }

        public Builder share_text(String r100) {
            this.share_text = r100;
            return this;
        }

        public Builder should_render(Boolean r100) {
            this.should_render = r100;
            return this;
        }

        public Builder thumbnail_detail(String r100) {
            this.thumbnail_detail = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder user_perm(Integer r100) {
            this.user_perm = r100;
            return this;
        }
    }

    public static final class Permission extends com.squareup.wire.Message<Permission, Builder> {
        public static final ProtoAdapter<Permission> ADAPTER = null;
        public static final Integer DEFAULT_CODE = null;
        public static final String DEFAULT_NAME = "";
        private static final long serialVersionUID = 0;
        public final Integer code;
        public final String name;

        public static final class Builder extends com.squareup.wire.Message.Builder<Permission, Builder> {
            public Integer code;
            public String name;

            @Override // com.squareup.wire.Message.Builder
            public Permission build() {
                return new Permission(this.code, this.name, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder code(Integer r100) {
                this.code = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Permission extends ProtoAdapter<Permission> {
            public ProtoAdapter_Permission() {
                super(FieldEncoding.LENGTH_DELIMITED, Permission.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Permission decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.code = 0;
                r101.name = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.code = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.name = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(Permission r100) {
                Integer r101 = r100.code;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.name;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Permission decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Permission r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Permission r101) throws IOException {
                Integer r102 = r101.code;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Permission r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Permission();
            DEFAULT_CODE = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.code = this.code;
            r100.name = this.name;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Permission.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Permission(Integer r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Permission(Integer r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.code = r100;
            this.name = r101;
        }
    }

    public static final class ProtoAdapter_DocPermission extends ProtoAdapter<DocPermission> {
        public ProtoAdapter_DocPermission() {
            super(FieldEncoding.LENGTH_DELIMITED, DocPermission.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DocPermission decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.message_id = "";
            r101.channel_id = "";
            r101.selected_permission_index = 0;
            r101.share_text = "";
            Boolean r102 = Boolean.FALSE;
            r101.should_render = r102;
            r101.title = "";
            r101.expires = 0L;
            r101.user_perm = -1;
            r101.authed_by_user_id = 0L;
            r101.authed_perm = -1;
            r101.message_existed = r102;
            r101.share_status = 0L;
            r101.thumbnail_detail = "";
            r101.doc_url = "";
            r101.receiver_perm = 0;
            r101.sender_is_external = r102;
            r101.extra = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L26;
            switch(r104) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L17;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L13;
                case 14: goto L12;
                case 15: goto L11;
                case 16: goto L10;
                case 17: goto L9;
                case 18: goto L8;
                case 19: goto L7;
                default: goto L6;
            };
        L7:
            r101.extra = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.sender_is_external = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.receiver_perm = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.doc_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.thumbnail_detail = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.share_status = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.message_existed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.authed_perm = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.authed_by_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.user_perm = ProtoAdapter.INT32.decode(r100);
            goto L3
        L17:
            r101.expires = ProtoAdapter.INT64.decode(r100);
            goto L3
        L18:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.should_render = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L20:
            r101.share_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.selected_permission_index = ProtoAdapter.INT32.decode(r100);
            goto L3
        L22:
            r101.optional_permissions.add(Permission.ADAPTER.decode(r100));
            goto L3
        L23:
            r101.channel_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L26:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DocPermission r100) {
            String r101 = r100.key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.message_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.channel_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = (r106 + r108) + Permission.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.optional_permissions);
            Integer r110 = r100.selected_permission_index;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(5, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.share_text;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(6, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.should_render;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.title;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(8, r119);
        L30:
            int r121 = r118 + r120;
            Long r122 = r100.expires;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(9, r122);
        L34:
            int r124 = r121 + r123;
            Integer r125 = r100.user_perm;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.INT32.encodedSizeWithTag(10, r125);
        L38:
            int r127 = r124 + r126;
            Long r128 = r100.authed_by_user_id;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.INT64.encodedSizeWithTag(11, r128);
        L42:
            int r130 = r127 + r129;
            Integer r131 = r100.authed_perm;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.INT32.encodedSizeWithTag(12, r131);
        L46:
            int r133 = r130 + r132;
            Boolean r134 = r100.message_existed;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r134);
        L50:
            int r136 = r133 + r135;
            Long r137 = r100.share_status;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.INT64.encodedSizeWithTag(14, r137);
        L54:
            int r139 = r136 + r138;
            String r140 = r100.thumbnail_detail;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.STRING.encodedSizeWithTag(15, r140);
        L58:
            int r142 = r139 + r141;
            String r143 = r100.doc_url;
            if (r143 == null) goto L61;
            int r144 = ProtoAdapter.STRING.encodedSizeWithTag(16, r143);
        L62:
            int r145 = r142 + r144;
            Integer r146 = r100.receiver_perm;
            if (r146 == null) goto L65;
            int r147 = ProtoAdapter.INT32.encodedSizeWithTag(17, r146);
        L66:
            int r148 = r145 + r147;
            Boolean r149 = r100.sender_is_external;
            if (r149 == null) goto L69;
            int r150 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r149);
        L70:
            int r151 = r148 + r150;
            String r152 = r100.extra;
            if (r152 == null) goto L74;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(19, r152);
        L74:
            return (r151 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ DocPermission decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DocPermission r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DocPermission r101) throws IOException {
            String r102 = r101.key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.message_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.channel_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Permission.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.optional_permissions);
            Integer r105 = r101.selected_permission_index;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r105);
        L14:
            String r106 = r101.share_text;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
        L17:
            Boolean r107 = r101.should_render;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
        L20:
            String r108 = r101.title;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r108);
        L23:
            Long r109 = r101.expires;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r109);
        L26:
            Integer r110 = r101.user_perm;
            if (r110 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r100, 10, r110);
        L29:
            Long r111 = r101.authed_by_user_id;
            if (r111 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 11, r111);
        L32:
            Integer r112 = r101.authed_perm;
            if (r112 == null) goto L35;
            ProtoAdapter.INT32.encodeWithTag(r100, 12, r112);
        L35:
            Boolean r113 = r101.message_existed;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 13, r113);
        L38:
            Long r114 = r101.share_status;
            if (r114 == null) goto L41;
            ProtoAdapter.INT64.encodeWithTag(r100, 14, r114);
        L41:
            String r115 = r101.thumbnail_detail;
            if (r115 == null) goto L44;
            ProtoAdapter.STRING.encodeWithTag(r100, 15, r115);
        L44:
            String r116 = r101.doc_url;
            if (r116 == null) goto L47;
            ProtoAdapter.STRING.encodeWithTag(r100, 16, r116);
        L47:
            Integer r117 = r101.receiver_perm;
            if (r117 == null) goto L50;
            ProtoAdapter.INT32.encodeWithTag(r100, 17, r117);
        L50:
            Boolean r118 = r101.sender_is_external;
            if (r118 == null) goto L53;
            ProtoAdapter.BOOL.encodeWithTag(r100, 18, r118);
        L53:
            String r119 = r101.extra;
            if (r119 == null) goto L56;
            ProtoAdapter.STRING.encodeWithTag(r100, 19, r119);
        L56:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocPermission r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocPermission();
        DEFAULT_SELECTED_PERMISSION_INDEX = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SHOULD_RENDER = r100;
        DEFAULT_EXPIRES = 0L;
        DEFAULT_USER_PERM = -1;
        DEFAULT_AUTHED_BY_USER_ID = 0L;
        DEFAULT_AUTHED_PERM = -1;
        DEFAULT_MESSAGE_EXISTED = r100;
        DEFAULT_SHARE_STATUS = 0L;
        DEFAULT_RECEIVER_PERM = 0;
        DEFAULT_SENDER_IS_EXTERNAL = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.message_id = this.message_id;
        r100.channel_id = this.channel_id;
        r100.optional_permissions = Internal.copyOf("optional_permissions", this.optional_permissions);
        r100.selected_permission_index = this.selected_permission_index;
        r100.share_text = this.share_text;
        r100.should_render = this.should_render;
        r100.title = this.title;
        r100.expires = this.expires;
        r100.user_perm = this.user_perm;
        r100.authed_by_user_id = this.authed_by_user_id;
        r100.authed_perm = this.authed_perm;
        r100.message_existed = this.message_existed;
        r100.share_status = this.share_status;
        r100.thumbnail_detail = this.thumbnail_detail;
        r100.doc_url = this.doc_url;
        r100.receiver_perm = this.receiver_perm;
        r100.sender_is_external = this.sender_is_external;
        r100.extra = this.extra;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DocPermission.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DocPermission(String r210, String r211, String r212, List<Permission> r213, Integer r214, String r215, Boolean r216, String r217, Long r310, Integer r311, Long r312, Integer r313, Boolean r314, Long r315, String r316, String r317, Integer r318, Boolean r319, String r410) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, ByteString.EMPTY);
    }

    public DocPermission(String r100, String r101, String r102, List<Permission> r103, Integer r104, String r105, Boolean r110, String r111, Long r112, Integer r113, Long r114, Integer r115, Boolean r116, Long r117, String r118, String r119, Integer r210, Boolean r211, String r212, ByteString r213) {
        super(ADAPTER, r213);
        this.key = r100;
        this.message_id = r101;
        this.channel_id = r102;
        this.optional_permissions = Internal.immutableCopyOf("optional_permissions", r103);
        this.selected_permission_index = r104;
        this.share_text = r105;
        this.should_render = r110;
        this.title = r111;
        this.expires = r112;
        this.user_perm = r113;
        this.authed_by_user_id = r114;
        this.authed_perm = r115;
        this.message_existed = r116;
        this.share_status = r117;
        this.thumbnail_detail = r118;
        this.doc_url = r119;
        this.receiver_perm = r210;
        this.sender_is_external = r211;
        this.extra = r212;
    }
}
