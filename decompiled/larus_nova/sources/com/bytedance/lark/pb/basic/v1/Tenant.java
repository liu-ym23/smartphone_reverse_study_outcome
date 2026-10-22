package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Tenant extends com.squareup.wire.Message<Tenant, Builder> {
    public static final ProtoAdapter<Tenant> ADAPTER = null;
    public static final String DEFAULT_ADDRESS = "";
    public static final String DEFAULT_CONTACT_EMAIL = "";
    public static final String DEFAULT_CONTACT_MOBILE = "";
    public static final String DEFAULT_CONTACT_NAME = "";
    public static final String DEFAULT_DOMAIN = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_POST_CODE = "";
    public static final String DEFAULT_REMARK = "";
    public static final String DEFAULT_TELEPHONE = "";
    public static final String DEFAULT_UNIT_LEAGUE = "";
    private static final long serialVersionUID = 0;
    public final String address;
    public final String contact_email;
    public final String contact_mobile;
    public final String contact_name;
    public final String domain;
    public final String icon_url;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253575id;
    public final String name;
    public final String post_code;
    public final String remark;
    public final String telephone;
    public final String unit_league;

    public static final class Builder extends com.squareup.wire.Message.Builder<Tenant, Builder> {
        public String address;
        public String contact_email;
        public String contact_mobile;
        public String contact_name;
        public String domain;
        public String icon_url;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253576id;
        public String name;
        public String post_code;
        public String remark;
        public String telephone;
        public String unit_league;

        @Override // com.squareup.wire.Message.Builder
        public Tenant build() {
            String r100 = this.f253576id;
            if (r100 == null) goto L9;
            if (this.name == null) goto L9;
            return new Tenant(this.f253576id, this.name, this.contact_name, this.contact_mobile, this.contact_email, this.address, this.domain, this.post_code, this.remark, this.telephone, this.icon_url, this.unit_league, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.name, "name"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder address(String r100) {
            this.address = r100;
            return this;
        }

        public Builder contact_email(String r100) {
            this.contact_email = r100;
            return this;
        }

        public Builder contact_mobile(String r100) {
            this.contact_mobile = r100;
            return this;
        }

        public Builder contact_name(String r100) {
            this.contact_name = r100;
            return this;
        }

        public Builder domain(String r100) {
            this.domain = r100;
            return this;
        }

        public Builder icon_url(String r100) {
            this.icon_url = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253576id = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder post_code(String r100) {
            this.post_code = r100;
            return this;
        }

        public Builder remark(String r100) {
            this.remark = r100;
            return this;
        }

        public Builder telephone(String r100) {
            this.telephone = r100;
            return this;
        }

        public Builder unit_league(String r100) {
            this.unit_league = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Tenant extends ProtoAdapter<Tenant> {
        public ProtoAdapter_Tenant() {
            super(FieldEncoding.LENGTH_DELIMITED, Tenant.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Tenant decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253576id = "";
            r101.name = "";
            r101.contact_name = "";
            r101.contact_mobile = "";
            r101.contact_email = "";
            r101.address = "";
            r101.domain = "";
            r101.post_code = "";
            r101.remark = "";
            r101.telephone = "";
            r101.icon_url = "";
            r101.unit_league = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            r101.unit_league = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.icon_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.telephone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.remark = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.post_code = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.domain = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.address = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.contact_email = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.contact_mobile = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.contact_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.f253576id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Tenant r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253575id) + r101.encodedSizeWithTag(2, r100.name);
            String r103 = r100.contact_name;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.contact_mobile;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.contact_email;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.address;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.domain;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(7, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.post_code;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(8, r119);
        L26:
            int r121 = r118 + r120;
            String r122 = r100.remark;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(9, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.telephone;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(10, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.icon_url;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(11, r128);
        L38:
            int r130 = r127 + r129;
            String r131 = r100.unit_league;
            if (r131 == null) goto L42;
            r104 = r101.encodedSizeWithTag(12, r131);
        L42:
            return (r130 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Tenant decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Tenant r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Tenant r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253575id);
            r102.encodeWithTag(r100, 2, r101.name);
            String r103 = r101.contact_name;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.contact_mobile;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            String r105 = r101.contact_email;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 5, r105);
        L11:
            String r106 = r101.address;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 6, r106);
        L14:
            String r107 = r101.domain;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 7, r107);
        L17:
            String r108 = r101.post_code;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 8, r108);
        L20:
            String r109 = r101.remark;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 9, r109);
        L23:
            String r110 = r101.telephone;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 10, r110);
        L26:
            String r111 = r101.icon_url;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 11, r111);
        L29:
            String r112 = r101.unit_league;
            if (r112 == null) goto L32;
            r102.encodeWithTag(r100, 12, r112);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Tenant r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Tenant();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253576id = this.f253575id;
        r100.name = this.name;
        r100.contact_name = this.contact_name;
        r100.contact_mobile = this.contact_mobile;
        r100.contact_email = this.contact_email;
        r100.address = this.address;
        r100.domain = this.domain;
        r100.post_code = this.post_code;
        r100.remark = this.remark;
        r100.telephone = this.telephone;
        r100.icon_url = this.icon_url;
        r100.unit_league = this.unit_league;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Tenant.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Tenant(String r110, String r111, String r112, String r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, String r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public Tenant(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, String r113, ByteString r114) {
        super(ADAPTER, r114);
        this.f253575id = r100;
        this.name = r101;
        this.contact_name = r102;
        this.contact_mobile = r103;
        this.contact_email = r104;
        this.address = r105;
        this.domain = r106;
        this.post_code = r107;
        this.remark = r110;
        this.telephone = r111;
        this.icon_url = r112;
        this.unit_league = r113;
    }
}
