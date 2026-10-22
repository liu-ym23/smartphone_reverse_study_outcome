package com.bytedance.lark.pb.basic.v1;

import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UserInfo extends com.squareup.wire.Message<UserInfo, Builder> {
    public static final ProtoAdapter<UserInfo> ADAPTER = null;
    public static final Long DEFAULT_AGREE_TIME = null;
    public static final String DEFAULT_ALIAS = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Boolean DEFAULT_IS_SPECIAL_FOCUS = null;
    public static final Integer DEFAULT_LAST_SEVEN_DAY_ONLINE_MINUTES = null;
    public static final String DEFAULT_NAME_PY = "";
    public static final String DEFAULT_NAME_WITH_ANOTHER_NAME = "";
    public static final String DEFAULT_TENANT_ID = "";
    public static final String DEFAULT_TENANT_NAME = "";
    public static final TenantNameStatus DEFAULT_TENANT_NAME_STATUS = null;
    public static final String DEFAULT_USER_ID = "";
    public static final String DEFAULT_USER_NAME = "";
    private static final long serialVersionUID = 0;
    public final Long agree_time;
    public final String alias;
    public final String avatar_key;
    public final CertificationInfo certification_info;
    public final String description;
    public final Boolean is_special_focus;
    public final Integer last_seven_day_online_minutes;
    public final String name_py;
    public final String name_with_another_name;
    public final String tenant_id;
    public final String tenant_name;
    public final TenantNameStatus tenant_name_status;
    public final String user_id;
    public final String user_name;

    public static final class Builder extends com.squareup.wire.Message.Builder<UserInfo, Builder> {
        public Long agree_time;
        public String alias;
        public String avatar_key;
        public CertificationInfo certification_info;
        public String description;
        public Boolean is_special_focus;
        public Integer last_seven_day_online_minutes;
        public String name_py;
        public String name_with_another_name;
        public String tenant_id;
        public String tenant_name;
        public TenantNameStatus tenant_name_status;
        public String user_id;
        public String user_name;

        @Override // com.squareup.wire.Message.Builder
        public UserInfo build() {
            String r100 = this.avatar_key;
            if (r100 == null) goto L11;
            if (this.user_name == null) goto L11;
            if (this.user_id == null) goto L11;
            return new UserInfo(this.avatar_key, this.user_name, this.name_py, this.tenant_name, this.last_seven_day_online_minutes, this.user_id, this.tenant_id, this.alias, this.description, this.agree_time, this.is_special_focus, this.name_with_another_name, this.tenant_name_status, this.certification_info, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "avatar_key", this.user_name, ITwitterService.ResponseConstants.USER_NAME, this.user_id, "user_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder agree_time(Long r100) {
            this.agree_time = r100;
            return this;
        }

        public Builder alias(String r100) {
            this.alias = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder certification_info(CertificationInfo r100) {
            this.certification_info = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder is_special_focus(Boolean r100) {
            this.is_special_focus = r100;
            return this;
        }

        public Builder last_seven_day_online_minutes(Integer r100) {
            this.last_seven_day_online_minutes = r100;
            return this;
        }

        public Builder name_py(String r100) {
            this.name_py = r100;
            return this;
        }

        public Builder name_with_another_name(String r100) {
            this.name_with_another_name = r100;
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

        public Builder tenant_name_status(TenantNameStatus r100) {
            this.tenant_name_status = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }

        public Builder user_name(String r100) {
            this.user_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserInfo extends ProtoAdapter<UserInfo> {
        public ProtoAdapter_UserInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, UserInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.avatar_key = "";
            r101.user_name = "";
            r101.name_py = "";
            r101.tenant_name = "";
            r101.last_seven_day_online_minutes = 0;
            r101.user_id = "";
            r101.tenant_id = "";
            r101.alias = "";
            r101.description = "";
            r101.agree_time = 0L;
            r101.is_special_focus = Boolean.FALSE;
            r101.name_with_another_name = "";
            r101.tenant_name_status = TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            switch(r103) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L17;
                case 8: goto L16;
                case 9: goto L15;
                case 10: goto L14;
                case 11: goto L13;
                case 12: goto L12;
                case 13: goto L6;
                case 14: goto L26;
                case 15: goto L7;
                default: goto L6;
            };
        L26:
            r101.tenant_name_status = TenantNameStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.certification_info = CertificationInfo.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.name_with_another_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.is_special_focus = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.agree_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.alias = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.last_seven_day_online_minutes = ProtoAdapter.INT32.decode(r100);
            goto L3
        L20:
            r101.tenant_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.name_py = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.user_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UserInfo r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.avatar_key) + r101.encodedSizeWithTag(2, r100.user_name);
            String r103 = r100.name_py;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.tenant_name;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            Integer r110 = r100.last_seven_day_online_minutes;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(5, r110);
        L14:
            int r112 = (r109 + r111) + r101.encodedSizeWithTag(6, r100.user_id);
            String r113 = r100.tenant_id;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(7, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.alias;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(8, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.description;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(9, r119);
        L26:
            int r121 = r118 + r120;
            Long r122 = r100.agree_time;
            if (r122 == null) goto L29;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(10, r122);
        L30:
            int r124 = r121 + r123;
            Boolean r125 = r100.is_special_focus;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.name_with_another_name;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(12, r128);
        L38:
            int r130 = r127 + r129;
            TenantNameStatus r131 = r100.tenant_name_status;
            if (r131 == null) goto L41;
            int r132 = TenantNameStatus.ADAPTER.encodedSizeWithTag(14, r131);
        L42:
            int r133 = r130 + r132;
            CertificationInfo r134 = r100.certification_info;
            if (r134 == null) goto L46;
            r104 = CertificationInfo.ADAPTER.encodedSizeWithTag(15, r134);
        L46:
            return (r133 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ UserInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserInfo r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.avatar_key);
            r102.encodeWithTag(r100, 2, r101.user_name);
            String r103 = r101.name_py;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.tenant_name;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            Integer r105 = r101.last_seven_day_online_minutes;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r105);
        L11:
            r102.encodeWithTag(r100, 6, r101.user_id);
            String r106 = r101.tenant_id;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 7, r106);
        L14:
            String r107 = r101.alias;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 8, r107);
        L17:
            String r108 = r101.description;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 9, r108);
        L20:
            Long r109 = r101.agree_time;
            if (r109 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 10, r109);
        L23:
            Boolean r110 = r101.is_special_focus;
            if (r110 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r110);
        L26:
            String r111 = r101.name_with_another_name;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 12, r111);
        L29:
            TenantNameStatus r112 = r101.tenant_name_status;
            if (r112 == null) goto L32;
            TenantNameStatus.ADAPTER.encodeWithTag(r100, 14, r112);
        L32:
            CertificationInfo r113 = r101.certification_info;
            if (r113 == null) goto L35;
            CertificationInfo.ADAPTER.encodeWithTag(r100, 15, r113);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserInfo();
        DEFAULT_LAST_SEVEN_DAY_ONLINE_MINUTES = 0;
        DEFAULT_AGREE_TIME = 0L;
        DEFAULT_IS_SPECIAL_FOCUS = Boolean.FALSE;
        DEFAULT_TENANT_NAME_STATUS = TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.avatar_key = this.avatar_key;
        r100.user_name = this.user_name;
        r100.name_py = this.name_py;
        r100.tenant_name = this.tenant_name;
        r100.last_seven_day_online_minutes = this.last_seven_day_online_minutes;
        r100.user_id = this.user_id;
        r100.tenant_id = this.tenant_id;
        r100.alias = this.alias;
        r100.description = this.description;
        r100.agree_time = this.agree_time;
        r100.is_special_focus = this.is_special_focus;
        r100.name_with_another_name = this.name_with_another_name;
        r100.tenant_name_status = this.tenant_name_status;
        r100.certification_info = this.certification_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserInfo(String r110, String r111, String r112, String r210, Integer r211, String r212, String r213, String r214, String r215, Long r216, Boolean r217, String r218, TenantNameStatus r219, CertificationInfo r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public UserInfo(String r100, String r101, String r102, String r103, Integer r104, String r105, String r110, String r111, String r112, Long r113, Boolean r114, String r115, TenantNameStatus r116, CertificationInfo r117, ByteString r118) {
        super(ADAPTER, r118);
        this.avatar_key = r100;
        this.user_name = r101;
        this.name_py = r102;
        this.tenant_name = r103;
        this.last_seven_day_online_minutes = r104;
        this.user_id = r105;
        this.tenant_id = r110;
        this.alias = r111;
        this.description = r112;
        this.agree_time = r113;
        this.is_special_focus = r114;
        this.name_with_another_name = r115;
        this.tenant_name_status = r116;
        this.certification_info = r117;
    }
}
