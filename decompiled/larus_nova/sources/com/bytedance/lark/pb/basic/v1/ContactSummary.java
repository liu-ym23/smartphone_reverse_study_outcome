package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ContactSummary extends com.squareup.wire.Message<ContactSummary, Builder> {
    public static final ProtoAdapter<ContactSummary> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final String DEFAULT_DEPARTMENT_NAME = "";
    public static final Boolean DEFAULT_IS_SPECIAL_FOCUS = null;
    public static final String DEFAULT_TENANT_NAME = "";
    public static final TenantNameStatus DEFAULT_TENANT_NAME_STATUS = null;
    public static final String DEFAULT_USER_EN_NAME = "";
    public static final String DEFAULT_USER_ID = "";
    public static final String DEFAULT_USER_NAME = "";
    public static final String DEFAULT_USER_NAME_I18N = "";
    private static final long serialVersionUID = 0;
    public final String avatar_key;
    public final String avatar_path;
    public final CertificationInfo certification_info;
    public final String department_name;
    public final Boolean is_special_focus;
    public final String tenant_name;
    public final TenantNameStatus tenant_name_status;
    public final String user_en_name;
    public final String user_id;
    public final String user_name;
    public final String user_name_i18n;

    public static final class Builder extends com.squareup.wire.Message.Builder<ContactSummary, Builder> {
        public String avatar_key;
        public String avatar_path;
        public CertificationInfo certification_info;
        public String department_name;
        public Boolean is_special_focus;
        public String tenant_name;
        public TenantNameStatus tenant_name_status;
        public String user_en_name;
        public String user_id;
        public String user_name;
        public String user_name_i18n;

        @Override // com.squareup.wire.Message.Builder
        public ContactSummary build() {
            return new ContactSummary(this.user_id, this.user_name, this.user_en_name, this.department_name, this.avatar_key, this.tenant_name, this.avatar_path, this.is_special_focus, this.tenant_name_status, this.certification_info, this.user_name_i18n, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder avatar_path(String r100) {
            this.avatar_path = r100;
            return this;
        }

        public Builder certification_info(CertificationInfo r100) {
            this.certification_info = r100;
            return this;
        }

        public Builder department_name(String r100) {
            this.department_name = r100;
            return this;
        }

        public Builder is_special_focus(Boolean r100) {
            this.is_special_focus = r100;
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

        public Builder user_en_name(String r100) {
            this.user_en_name = r100;
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

        public Builder user_name_i18n(String r100) {
            this.user_name_i18n = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ContactSummary extends ProtoAdapter<ContactSummary> {
        public ProtoAdapter_ContactSummary() {
            super(FieldEncoding.LENGTH_DELIMITED, ContactSummary.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ContactSummary decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = "";
            r101.user_name = "";
            r101.user_en_name = "";
            r101.department_name = "";
            r101.avatar_key = "";
            r101.tenant_name = "";
            r101.avatar_path = "";
            r101.is_special_focus = Boolean.FALSE;
            r101.tenant_name_status = TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN;
            r101.user_name_i18n = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            switch(r103) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L23;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L23:
            r101.tenant_name_status = TenantNameStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.user_name_i18n = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.certification_info = CertificationInfo.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.is_special_focus = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.avatar_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.tenant_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.department_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.user_en_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.user_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ContactSummary r100) {
            String r101 = r100.user_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.user_name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.user_en_name;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.department_name;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.avatar_key;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.tenant_name;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.avatar_path;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.is_special_focus;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            TenantNameStatus r125 = r100.tenant_name_status;
            if (r125 == null) goto L37;
            int r126 = TenantNameStatus.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            CertificationInfo r128 = r100.certification_info;
            if (r128 == null) goto L41;
            int r129 = CertificationInfo.ADAPTER.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.user_name_i18n;
            if (r131 == null) goto L46;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(11, r131);
        L46:
            return (r130 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ContactSummary decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ContactSummary r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ContactSummary r101) throws IOException {
            String r102 = r101.user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.user_name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.user_en_name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.department_name;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.avatar_key;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.tenant_name;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.avatar_path;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            Boolean r109 = r101.is_special_focus;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L26:
            TenantNameStatus r110 = r101.tenant_name_status;
            if (r110 == null) goto L29;
            TenantNameStatus.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            CertificationInfo r111 = r101.certification_info;
            if (r111 == null) goto L32;
            CertificationInfo.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            String r112 = r101.user_name_i18n;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r112);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContactSummary r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContactSummary();
        DEFAULT_IS_SPECIAL_FOCUS = Boolean.FALSE;
        DEFAULT_TENANT_NAME_STATUS = TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.user_name = this.user_name;
        r100.user_en_name = this.user_en_name;
        r100.department_name = this.department_name;
        r100.avatar_key = this.avatar_key;
        r100.tenant_name = this.tenant_name;
        r100.avatar_path = this.avatar_path;
        r100.is_special_focus = this.is_special_focus;
        r100.tenant_name_status = this.tenant_name_status;
        r100.certification_info = this.certification_info;
        r100.user_name_i18n = this.user_name_i18n;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ContactSummary.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ContactSummary(String r110, String r111, String r112, String r113, String r114, String r115, String r210, Boolean r211, TenantNameStatus r212, CertificationInfo r213, String r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public ContactSummary(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Boolean r107, TenantNameStatus r110, CertificationInfo r111, String r112, ByteString r113) {
        super(ADAPTER, r113);
        this.user_id = r100;
        this.user_name = r101;
        this.user_en_name = r102;
        this.department_name = r103;
        this.avatar_key = r104;
        this.tenant_name = r105;
        this.avatar_path = r106;
        this.is_special_focus = r107;
        this.tenant_name_status = r110;
        this.certification_info = r111;
        this.user_name_i18n = r112;
    }
}
