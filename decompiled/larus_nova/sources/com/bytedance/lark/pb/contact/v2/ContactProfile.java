package com.bytedance.lark.pb.contact.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ContactProfile extends Message<ContactProfile, Builder> {
    public static final ProtoAdapter<ContactProfile> ADAPTER = null;
    public static final String DEFAULT_ALIAS = "";
    public static final String DEFAULT_ALIAS_PINYIN = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final Long DEFAULT_DB_USER_ID = null;
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final String DEFAULT_DISPLAY_NAME_PINYIN = "";
    public static final String DEFAULT_DOUBAO_KEY = "";
    public static final Long DEFAULT_FEISHU_USER_ID = null;
    public static final Boolean DEFAULT_IS_B_USER = null;
    public static final Boolean DEFAULT_IS_CONTACT_DELETED = null;
    public static final Boolean DEFAULT_IS_RESIGNED = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PINYIN = "";
    private static final long serialVersionUID = 0;
    public final String alias;
    public final String alias_pinyin;
    public final String avatar_key;
    public final Long db_user_id;
    public final String display_name;
    public final String display_name_pinyin;
    public final String doubao_key;
    public final Long feishu_user_id;
    public final Boolean is_b_user;
    public final Boolean is_contact_deleted;
    public final Boolean is_resigned;
    public final String name;
    public final String pinyin;
    public final UserRelation relation;

    public static final class Builder extends Message.Builder<ContactProfile, Builder> {
        public String alias;
        public String alias_pinyin;
        public String avatar_key;
        public Long db_user_id;
        public String display_name;
        public String display_name_pinyin;
        public String doubao_key;
        public Long feishu_user_id;
        public Boolean is_b_user;
        public Boolean is_contact_deleted;
        public Boolean is_resigned;
        public String name;
        public String pinyin;
        public UserRelation relation;

        @Override // com.squareup.wire.Message.Builder
        public ContactProfile build() {
            return new ContactProfile(this.feishu_user_id, this.db_user_id, this.name, this.alias, this.doubao_key, this.is_contact_deleted, this.pinyin, this.avatar_key, this.is_b_user, this.relation, this.alias_pinyin, this.display_name, this.display_name_pinyin, this.is_resigned, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder alias(String r100) {
            this.alias = r100;
            return this;
        }

        public Builder alias_pinyin(String r100) {
            this.alias_pinyin = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder db_user_id(Long r100) {
            this.db_user_id = r100;
            return this;
        }

        public Builder display_name(String r100) {
            this.display_name = r100;
            return this;
        }

        public Builder display_name_pinyin(String r100) {
            this.display_name_pinyin = r100;
            return this;
        }

        public Builder doubao_key(String r100) {
            this.doubao_key = r100;
            return this;
        }

        public Builder feishu_user_id(Long r100) {
            this.feishu_user_id = r100;
            return this;
        }

        public Builder is_b_user(Boolean r100) {
            this.is_b_user = r100;
            return this;
        }

        public Builder is_contact_deleted(Boolean r100) {
            this.is_contact_deleted = r100;
            return this;
        }

        public Builder is_resigned(Boolean r100) {
            this.is_resigned = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder pinyin(String r100) {
            this.pinyin = r100;
            return this;
        }

        public Builder relation(UserRelation r100) {
            this.relation = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ContactProfile extends ProtoAdapter<ContactProfile> {
        public ProtoAdapter_ContactProfile() {
            super(FieldEncoding.LENGTH_DELIMITED, ContactProfile.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ContactProfile decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.feishu_user_id = 0L;
            r101.db_user_id = 0L;
            r101.name = "";
            r101.alias = "";
            r101.doubao_key = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_contact_deleted = r102;
            r101.pinyin = "";
            r101.avatar_key = "";
            r101.is_b_user = r102;
            r101.alias_pinyin = "";
            r101.display_name = "";
            r101.display_name_pinyin = "";
            r101.is_resigned = r102;
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
            r101.is_resigned = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.display_name_pinyin = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.display_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.alias_pinyin = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.relation = UserRelation.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.is_b_user = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.pinyin = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.is_contact_deleted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.doubao_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.alias = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.db_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L20:
            r101.feishu_user_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(ContactProfile r100) {
            Long r101 = r100.feishu_user_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.db_user_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.name;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.alias;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.doubao_key;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.is_contact_deleted;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.pinyin;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.avatar_key;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.is_b_user;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            UserRelation r128 = r100.relation;
            if (r128 == null) goto L41;
            int r129 = UserRelation.ADAPTER.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.alias_pinyin;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.STRING.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            String r134 = r100.display_name;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.STRING.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            String r137 = r100.display_name_pinyin;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.STRING.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            Boolean r140 = r100.is_resigned;
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
        public /* bridge */ /* synthetic */ ContactProfile decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ContactProfile r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ContactProfile r101) throws IOException {
            Long r102 = r101.feishu_user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.db_user_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.alias;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.doubao_key;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.is_contact_deleted;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.pinyin;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.avatar_key;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            Boolean r110 = r101.is_b_user;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L29:
            UserRelation r111 = r101.relation;
            if (r111 == null) goto L32;
            UserRelation.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            String r112 = r101.alias_pinyin;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r112);
        L35:
            String r113 = r101.display_name;
            if (r113 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r100, 12, r113);
        L38:
            String r114 = r101.display_name_pinyin;
            if (r114 == null) goto L41;
            ProtoAdapter.STRING.encodeWithTag(r100, 13, r114);
        L41:
            Boolean r115 = r101.is_resigned;
            if (r115 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r115);
        L44:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContactProfile r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContactProfile();
        DEFAULT_FEISHU_USER_ID = 0L;
        DEFAULT_DB_USER_ID = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_CONTACT_DELETED = r100;
        DEFAULT_IS_B_USER = r100;
        DEFAULT_IS_RESIGNED = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feishu_user_id = this.feishu_user_id;
        r100.db_user_id = this.db_user_id;
        r100.name = this.name;
        r100.alias = this.alias;
        r100.doubao_key = this.doubao_key;
        r100.is_contact_deleted = this.is_contact_deleted;
        r100.pinyin = this.pinyin;
        r100.avatar_key = this.avatar_key;
        r100.is_b_user = this.is_b_user;
        r100.relation = this.relation;
        r100.alias_pinyin = this.alias_pinyin;
        r100.display_name = this.display_name;
        r100.display_name_pinyin = this.display_name_pinyin;
        r100.is_resigned = this.is_resigned;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ContactProfile.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ContactProfile(Long r110, Long r111, String r112, String r210, String r211, Boolean r212, String r213, String r214, Boolean r215, UserRelation r216, String r217, String r218, String r219, Boolean r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public ContactProfile(Long r100, Long r101, String r102, String r103, String r104, Boolean r105, String r110, String r111, Boolean r112, UserRelation r113, String r114, String r115, String r116, Boolean r117, ByteString r118) {
        super(ADAPTER, r118);
        this.feishu_user_id = r100;
        this.db_user_id = r101;
        this.name = r102;
        this.alias = r103;
        this.doubao_key = r104;
        this.is_contact_deleted = r105;
        this.pinyin = r110;
        this.avatar_key = r111;
        this.is_b_user = r112;
        this.relation = r113;
        this.alias_pinyin = r114;
        this.display_name = r115;
        this.display_name_pinyin = r116;
        this.is_resigned = r117;
    }
}
