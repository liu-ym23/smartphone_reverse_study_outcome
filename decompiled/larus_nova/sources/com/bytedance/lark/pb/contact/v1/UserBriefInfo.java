package com.bytedance.lark.pb.contact.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UserBriefInfo extends Message<UserBriefInfo, Builder> {
    public static final ProtoAdapter<UserBriefInfo> ADAPTER = null;
    public static final String DEFAULT_ALIAS = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final String DEFAULT_CONTACT_TOKEN = "";
    public static final String DEFAULT_EN_NAME = "";
    public static final String DEFAULT_LOCALIZED_NAME = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_TENANT_ID = "";
    public static final String DEFAULT_TENANT_NAME = "";
    public static final String DEFAULT_USER_ID = "";
    private static final long serialVersionUID = 0;
    public final String alias;
    public final String avatar_key;
    public final String avatar_path;
    public final String contact_token;
    public final String en_name;
    public final String localized_name;
    public final String name;
    public final String tenant_id;
    public final String tenant_name;
    public final String user_id;

    public static final class Builder extends Message.Builder<UserBriefInfo, Builder> {
        public String alias;
        public String avatar_key;
        public String avatar_path;
        public String contact_token;
        public String en_name;
        public String localized_name;
        public String name;
        public String tenant_id;
        public String tenant_name;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public UserBriefInfo build() {
            return new UserBriefInfo(this.user_id, this.name, this.en_name, this.avatar_key, this.tenant_id, this.tenant_name, this.localized_name, this.alias, this.contact_token, this.avatar_path, super.buildUnknownFields());
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

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder avatar_path(String r100) {
            this.avatar_path = r100;
            return this;
        }

        public Builder contact_token(String r100) {
            this.contact_token = r100;
            return this;
        }

        public Builder en_name(String r100) {
            this.en_name = r100;
            return this;
        }

        public Builder localized_name(String r100) {
            this.localized_name = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
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

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserBriefInfo extends ProtoAdapter<UserBriefInfo> {
        public ProtoAdapter_UserBriefInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, UserBriefInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserBriefInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = "";
            r101.name = "";
            r101.en_name = "";
            r101.avatar_key = "";
            r101.tenant_id = "";
            r101.tenant_name = "";
            r101.localized_name = "";
            r101.alias = "";
            r101.contact_token = "";
            r101.avatar_path = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.avatar_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.contact_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.alias = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.localized_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.tenant_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.en_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UserBriefInfo r100) {
            String r101 = r100.user_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.en_name;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.avatar_key;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.tenant_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.tenant_name;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.localized_name;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.alias;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.contact_token;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.avatar_path;
            if (r128 == null) goto L42;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            return (r127 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ UserBriefInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserBriefInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserBriefInfo r101) throws IOException {
            String r102 = r101.user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.en_name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.avatar_key;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.tenant_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.tenant_name;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.localized_name;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.alias;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.contact_token;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.avatar_path;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserBriefInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserBriefInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.name = this.name;
        r100.en_name = this.en_name;
        r100.avatar_key = this.avatar_key;
        r100.tenant_id = this.tenant_id;
        r100.tenant_name = this.tenant_name;
        r100.localized_name = this.localized_name;
        r100.alias = this.alias;
        r100.contact_token = this.contact_token;
        r100.avatar_path = this.avatar_path;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserBriefInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserBriefInfo(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public UserBriefInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, ByteString r112) {
        super(ADAPTER, r112);
        this.user_id = r100;
        this.name = r101;
        this.en_name = r102;
        this.avatar_key = r103;
        this.tenant_id = r104;
        this.tenant_name = r105;
        this.localized_name = r106;
        this.alias = r107;
        this.contact_token = r110;
        this.avatar_path = r111;
    }
}
