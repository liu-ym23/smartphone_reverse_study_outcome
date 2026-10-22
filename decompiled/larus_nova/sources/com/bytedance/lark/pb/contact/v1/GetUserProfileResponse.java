package com.bytedance.lark.pb.contact.v1;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import com.bytedance.lark.pb.basic.v1.WorkStatus;
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
public final class GetUserProfileResponse extends Message<GetUserProfileResponse, Builder> {
    public static final ProtoAdapter<GetUserProfileResponse> ADAPTER = null;
    public static final Long DEFAULT_DO_NOT_DISTURB_END_TIME = null;
    public static final ProtoAdapter_GetUserProfileResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Chatter.AccessInfo access_info;
    public final AdminInfo admin_info;
    public final Company company;
    public final Long do_not_disturb_end_time;
    public final Leader leader;
    public final Personal personal;
    public final WorkStatus work_status;

    public static final class AdminInfo extends Message<AdminInfo, Builder> {
        public static final ProtoAdapter<AdminInfo> ADAPTER = null;
        public static final String DEFAULT_ADMIN_URL = "";
        public static final Boolean DEFAULT_IS_ADMIN = null;
        public static final Boolean DEFAULT_IS_TOPIC_GROUP_ADMIN = null;
        private static final long serialVersionUID = 0;
        public final String admin_url;
        public final Boolean is_admin;
        public final Boolean is_topic_group_admin;

        public static final class Builder extends Message.Builder<AdminInfo, Builder> {
            public String admin_url;
            public Boolean is_admin;
            public Boolean is_topic_group_admin;

            @Override // com.squareup.wire.Message.Builder
            public AdminInfo build() {
                Boolean r100 = this.is_admin;
                if (r100 == null) goto L7;
                return new AdminInfo(this.is_admin, this.admin_url, this.is_topic_group_admin, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "is_admin"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder admin_url(String r100) {
                this.admin_url = r100;
                return this;
            }

            public Builder is_admin(Boolean r100) {
                this.is_admin = r100;
                return this;
            }

            public Builder is_topic_group_admin(Boolean r100) {
                this.is_topic_group_admin = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AdminInfo extends ProtoAdapter<AdminInfo> {
            public ProtoAdapter_AdminInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, AdminInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AdminInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                Boolean r102 = Boolean.FALSE;
                r101.is_admin = r102;
                r101.admin_url = "";
                r101.is_topic_group_admin = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L15;
                if (r104 != 1) goto L8;
                r101.is_admin = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.admin_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L11;
                r101.is_topic_group_admin = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(AdminInfo r100) {
                ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
                int r102 = r101.encodedSizeWithTag(1, r100.is_admin);
                String r103 = r100.admin_url;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r103);
            L6:
                int r106 = r102 + r105;
                Boolean r107 = r100.is_topic_group_admin;
                if (r107 == null) goto L10;
                r104 = r101.encodedSizeWithTag(3, r107);
            L10:
                return (r106 + r104) + r100.unknownFields().size();
            L5:
                r105 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AdminInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AdminInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AdminInfo r101) throws IOException {
                ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
                r102.encodeWithTag(r100, 1, r101.is_admin);
                String r103 = r101.admin_url;
                if (r103 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L5:
                Boolean r104 = r101.is_topic_group_admin;
                if (r104 == null) goto L8;
                r102.encodeWithTag(r100, 3, r104);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AdminInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AdminInfo();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_ADMIN = r100;
            DEFAULT_IS_TOPIC_GROUP_ADMIN = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_admin = this.is_admin;
            r100.admin_url = this.admin_url;
            r100.is_topic_group_admin = this.is_topic_group_admin;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AdminInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public AdminInfo(Boolean r100, String r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public AdminInfo(Boolean r100, String r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.is_admin = r100;
            this.admin_url = r101;
            this.is_topic_group_admin = r102;
        }
    }

    public static final class Builder extends Message.Builder<GetUserProfileResponse, Builder> implements d<GetUserProfileResponse> {
        public Chatter.AccessInfo access_info;
        public AdminInfo admin_info;
        public Company company;
        public Long do_not_disturb_end_time;
        public Leader leader;
        public Personal personal;
        public WorkStatus work_status;

        @Override // com.squareup.wire.Message.Builder
        public GetUserProfileResponse build() {
            Personal r100 = this.personal;
            if (r100 == null) goto L7;
            return new GetUserProfileResponse(this.company, this.personal, this.leader, this.admin_info, this.work_status, this.access_info, this.do_not_disturb_end_time, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, WikiSpaceType.PERSONAL});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder access_info(Chatter.AccessInfo r100) {
            this.access_info = r100;
            return this;
        }

        public Builder admin_info(AdminInfo r100) {
            this.admin_info = r100;
            return this;
        }

        public Builder company(Company r100) {
            this.company = r100;
            return this;
        }

        public Builder do_not_disturb_end_time(Long r100) {
            this.do_not_disturb_end_time = r100;
            return this;
        }

        public Builder leader(Leader r100) {
            this.leader = r100;
            return this;
        }

        public Builder personal(Personal r100) {
            this.personal = r100;
            return this;
        }

        public Builder work_status(WorkStatus r100) {
            this.work_status = r100;
            return this;
        }
    }

    public static final class Company extends Message<Company, Builder> {
        public static final ProtoAdapter<Company> ADAPTER = null;
        public static final String DEFAULT_DEPARTMENT_NAME = "";
        public static final Boolean DEFAULT_IS_TENANT_CERTIFICATION = null;
        public static final String DEFAULT_TENANT_NAME = "";
        public static final TenantNameStatus DEFAULT_TENANT_NAME_STATUS = null;
        private static final long serialVersionUID = 0;
        public final CertificationInfo certification_info;
        public final String department_name;
        public final DepartmentList departments;
        public final Boolean is_tenant_certification;
        public final OrgUnit org_unit;
        public final Position position;
        public final String tenant_name;
        public final TenantNameStatus tenant_name_status;

        public static final class Builder extends Message.Builder<Company, Builder> {
            public CertificationInfo certification_info;
            public String department_name;
            public DepartmentList departments;
            public Boolean is_tenant_certification;
            public OrgUnit org_unit;
            public Position position;
            public String tenant_name;
            public TenantNameStatus tenant_name_status;

            @Override // com.squareup.wire.Message.Builder
            public Company build() {
                return new Company(this.department_name, this.tenant_name, this.position, this.org_unit, this.departments, this.is_tenant_certification, this.tenant_name_status, this.certification_info, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder certification_info(CertificationInfo r100) {
                this.certification_info = r100;
                return this;
            }

            public Builder department_name(String r100) {
                this.department_name = r100;
                return this;
            }

            public Builder departments(DepartmentList r100) {
                this.departments = r100;
                return this;
            }

            public Builder is_tenant_certification(Boolean r100) {
                this.is_tenant_certification = r100;
                return this;
            }

            public Builder org_unit(OrgUnit r100) {
                this.org_unit = r100;
                return this;
            }

            public Builder position(Position r100) {
                this.position = r100;
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
        }

        public static final enum CertificateStatus extends Enum<CertificateStatus> implements WireEnum {
            private static final /* synthetic */ CertificateStatus[] $VALUES = null;
            public static final ProtoAdapter<CertificateStatus> ADAPTER = null;
            public static final CertificateStatus CERTIFICATED = null;
            public static final CertificateStatus EXPIRED = null;
            public static final CertificateStatus TEAM_CERTIFICATED = null;
            public static final CertificateStatus UNCERTIFICATED = null;
            private final int value;

            static {
                CertificateStatus r100 = new CertificateStatus("UNCERTIFICATED", 0, 0);
                UNCERTIFICATED = r100;
                CertificateStatus r101 = new CertificateStatus("CERTIFICATED", 1, 1);
                CERTIFICATED = r101;
                CertificateStatus r102 = new CertificateStatus("EXPIRED", 2, 2);
                EXPIRED = r102;
                CertificateStatus r103 = new CertificateStatus("TEAM_CERTIFICATED", 3, 3);
                TEAM_CERTIFICATED = r103;
                $VALUES = new CertificateStatus[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(CertificateStatus.class);
            }

            public static CertificateStatus[] values() {
                return (CertificateStatus[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static CertificateStatus fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return TEAM_CERTIFICATED;
            L14:
                return EXPIRED;
            L16:
                return CERTIFICATED;
            L18:
                return UNCERTIFICATED;
            }

            public static CertificateStatus valueOf(String r100) {
                return (CertificateStatus) a.a(CertificateStatus.class, r100);
            }

            private CertificateStatus(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class CertificationInfo extends Message<CertificationInfo, Builder> {
            public static final ProtoAdapter<CertificationInfo> ADAPTER = null;
            public static final CertificateStatus DEFAULT_CERTIFICATE_STATUS = null;
            public static final Boolean DEFAULT_IS_SHOW_CERT_SIGN = null;
            public static final String DEFAULT_TENANT_CERTIFICATION_URL = "";
            private static final long serialVersionUID = 0;
            public final CertificateStatus certificate_status;
            public final Boolean is_show_cert_sign;
            public final String tenant_certification_url;

            public static final class Builder extends Message.Builder<CertificationInfo, Builder> {
                public CertificateStatus certificate_status;
                public Boolean is_show_cert_sign;
                public String tenant_certification_url;

                @Override // com.squareup.wire.Message.Builder
                public CertificationInfo build() {
                    return new CertificationInfo(this.is_show_cert_sign, this.certificate_status, this.tenant_certification_url, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder certificate_status(CertificateStatus r100) {
                    this.certificate_status = r100;
                    return this;
                }

                public Builder is_show_cert_sign(Boolean r100) {
                    this.is_show_cert_sign = r100;
                    return this;
                }

                public Builder tenant_certification_url(String r100) {
                    this.tenant_certification_url = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_CertificationInfo extends ProtoAdapter<CertificationInfo> {
                public ProtoAdapter_CertificationInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, CertificationInfo.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public CertificationInfo decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.is_show_cert_sign = Boolean.FALSE;
                    r101.certificate_status = CertificateStatus.UNCERTIFICATED;
                    r101.tenant_certification_url = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.is_show_cert_sign = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.certificate_status = CertificateStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
                L15:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.tenant_certification_url = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L11:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L18:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(CertificationInfo r100) {
                    Boolean r101 = r100.is_show_cert_sign;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
                L6:
                    CertificateStatus r104 = r100.certificate_status;
                    if (r104 == null) goto L9;
                    int r105 = CertificateStatus.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    String r107 = r100.tenant_certification_url;
                    if (r107 == null) goto L14;
                    r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
                L14:
                    return (r106 + r102) + r100.unknownFields().size();
                L9:
                    r105 = 0;
                    goto L10
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ CertificationInfo decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(CertificationInfo r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, CertificationInfo r101) throws IOException {
                    Boolean r102 = r101.is_show_cert_sign;
                    if (r102 == null) goto L5;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
                L5:
                    CertificateStatus r103 = r101.certificate_status;
                    if (r103 == null) goto L8;
                    CertificateStatus.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    String r104 = r101.tenant_certification_url;
                    if (r104 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
                L11:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CertificationInfo r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_CertificationInfo();
                DEFAULT_IS_SHOW_CERT_SIGN = Boolean.FALSE;
                DEFAULT_CERTIFICATE_STATUS = CertificateStatus.UNCERTIFICATED;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.is_show_cert_sign = this.is_show_cert_sign;
                r100.certificate_status = this.certificate_status;
                r100.tenant_certification_url = this.tenant_certification_url;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return CertificationInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public CertificationInfo(Boolean r100, CertificateStatus r101, String r102) {
                this(r100, r101, r102, ByteString.EMPTY);
            }

            public CertificationInfo(Boolean r100, CertificateStatus r101, String r102, ByteString r103) {
                super(ADAPTER, r103);
                this.is_show_cert_sign = r100;
                this.certificate_status = r101;
                this.tenant_certification_url = r102;
            }
        }

        public static final class DepartmentList extends Message<DepartmentList, Builder> {
            public static final ProtoAdapter<DepartmentList> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<DepartmentMeta> dept_metas;

            public static final class Builder extends Message.Builder<DepartmentList, Builder> {
                public List<DepartmentMeta> dept_metas;

                @Override // com.squareup.wire.Message.Builder
                public DepartmentList build() {
                    return new DepartmentList(this.dept_metas, super.buildUnknownFields());
                }

                public Builder() {
                    this.dept_metas = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder dept_metas(List<DepartmentMeta> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.dept_metas = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_DepartmentList extends ProtoAdapter<DepartmentList> {
                public ProtoAdapter_DepartmentList() {
                    super(FieldEncoding.LENGTH_DELIMITED, DepartmentList.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public DepartmentList decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.dept_metas.add(DepartmentMeta.ADAPTER.decode(r100));
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
                public int encodedSize2(DepartmentList r100) {
                    return DepartmentMeta.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.dept_metas) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ DepartmentList decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(DepartmentList r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, DepartmentList r101) throws IOException {
                    DepartmentMeta.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.dept_metas);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DepartmentList r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_DepartmentList();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.dept_metas = Internal.copyOf("dept_metas", this.dept_metas);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return DepartmentList.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public DepartmentList(List<DepartmentMeta> r100) {
                this(r100, ByteString.EMPTY);
            }

            public DepartmentList(List<DepartmentMeta> r100, ByteString r101) {
                super(ADAPTER, r101);
                this.dept_metas = Internal.immutableCopyOf("dept_metas", r100);
            }
        }

        public static final class DepartmentMeta extends Message<DepartmentMeta, Builder> {
            public static final ProtoAdapter<DepartmentMeta> ADAPTER = null;
            public static final String DEFAULT_ID = "";
            public static final String DEFAULT_NAME = "";
            private static final long serialVersionUID = 0;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public final String f253609id;
            public final String name;

            public static final class Builder extends Message.Builder<DepartmentMeta, Builder> {

                /* JADX INFO: renamed from: id, reason: collision with root package name */
                public String f253610id;
                public String name;

                @Override // com.squareup.wire.Message.Builder
                public DepartmentMeta build() {
                    String r100 = this.f253610id;
                    if (r100 == null) goto L9;
                    if (this.name == null) goto L9;
                    return new DepartmentMeta(this.f253610id, this.name, super.buildUnknownFields());
                L9:
                    throw Internal.missingRequiredFields(new Object[]{r100, "id", this.name, "name"});
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder id(String r100) {
                    this.f253610id = r100;
                    return this;
                }

                public Builder name(String r100) {
                    this.name = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_DepartmentMeta extends ProtoAdapter<DepartmentMeta> {
                public ProtoAdapter_DepartmentMeta() {
                    super(FieldEncoding.LENGTH_DELIMITED, DepartmentMeta.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public DepartmentMeta decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.f253610id = "";
                    r101.name = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.f253610id = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(DepartmentMeta r100) {
                    ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                    return (r101.encodedSizeWithTag(1, r100.f253609id) + r101.encodedSizeWithTag(2, r100.name)) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ DepartmentMeta decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(DepartmentMeta r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, DepartmentMeta r101) throws IOException {
                    ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                    r102.encodeWithTag(r100, 1, r101.f253609id);
                    r102.encodeWithTag(r100, 2, r101.name);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DepartmentMeta r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_DepartmentMeta();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.f253610id = this.f253609id;
                r100.name = this.name;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return DepartmentMeta.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public DepartmentMeta(String r100, String r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public DepartmentMeta(String r100, String r101, ByteString r102) {
                super(ADAPTER, r102);
                this.f253609id = r100;
                this.name = r101;
            }
        }

        public static final class OrgUnit extends Message<OrgUnit, Builder> {
            public static final ProtoAdapter<OrgUnit> ADAPTER = null;
            public static final String DEFAULT_NAME = "";
            private static final long serialVersionUID = 0;
            public final String name;

            public static final class Builder extends Message.Builder<OrgUnit, Builder> {
                public String name;

                @Override // com.squareup.wire.Message.Builder
                public OrgUnit build() {
                    String r100 = this.name;
                    if (r100 == null) goto L7;
                    return new OrgUnit(this.name, super.buildUnknownFields());
                L7:
                    throw Internal.missingRequiredFields(new Object[]{r100, "name"});
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder name(String r100) {
                    this.name = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_OrgUnit extends ProtoAdapter<OrgUnit> {
                public ProtoAdapter_OrgUnit() {
                    super(FieldEncoding.LENGTH_DELIMITED, OrgUnit.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public OrgUnit decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.name = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.name = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(OrgUnit r100) {
                    return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.name) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ OrgUnit decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(OrgUnit r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, OrgUnit r101) throws IOException {
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.name);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OrgUnit r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_OrgUnit();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.name = this.name;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return OrgUnit.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public OrgUnit(String r100) {
                this(r100, ByteString.EMPTY);
            }

            public OrgUnit(String r100, ByteString r101) {
                super(ADAPTER, r101);
                this.name = r100;
            }
        }

        public static final class Position extends Message<Position, Builder> {
            public static final ProtoAdapter<Position> ADAPTER = null;
            public static final String DEFAULT_NAME = "";
            private static final long serialVersionUID = 0;
            public final String name;

            public static final class Builder extends Message.Builder<Position, Builder> {
                public String name;

                @Override // com.squareup.wire.Message.Builder
                public Position build() {
                    String r100 = this.name;
                    if (r100 == null) goto L7;
                    return new Position(this.name, super.buildUnknownFields());
                L7:
                    throw Internal.missingRequiredFields(new Object[]{r100, "name"});
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder name(String r100) {
                    this.name = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Position extends ProtoAdapter<Position> {
                public ProtoAdapter_Position() {
                    super(FieldEncoding.LENGTH_DELIMITED, Position.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Position decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.name = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.name = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(Position r100) {
                    return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.name) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ Position decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Position r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Position r101) throws IOException {
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.name);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Position r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Position();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.name = this.name;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Position.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public Position(String r100) {
                this(r100, ByteString.EMPTY);
            }

            public Position(String r100, ByteString r101) {
                super(ADAPTER, r101);
                this.name = r100;
            }
        }

        public static final class ProtoAdapter_Company extends ProtoAdapter<Company> {
            public ProtoAdapter_Company() {
                super(FieldEncoding.LENGTH_DELIMITED, Company.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Company decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.department_name = "";
                r101.tenant_name = "";
                r101.is_tenant_certification = Boolean.FALSE;
                r101.tenant_name_status = TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                switch(r103) {
                    case 1: goto L17;
                    case 2: goto L16;
                    case 3: goto L15;
                    case 4: goto L14;
                    case 5: goto L13;
                    case 6: goto L12;
                    case 7: goto L20;
                    case 8: goto L7;
                    default: goto L6;
                };
            L20:
                r101.tenant_name_status = TenantNameStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.certification_info = CertificationInfo.ADAPTER.decode(r100);
                goto L3
            L12:
                r101.is_tenant_certification = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.departments = DepartmentList.ADAPTER.decode(r100);
                goto L3
            L14:
                r101.org_unit = OrgUnit.ADAPTER.decode(r100);
                goto L3
            L15:
                r101.position = Position.ADAPTER.decode(r100);
                goto L3
            L16:
                r101.tenant_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L17:
                r101.department_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Company r100) {
                String r101 = r100.department_name;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.tenant_name;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Position r107 = r100.position;
                if (r107 == null) goto L13;
                int r108 = Position.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                OrgUnit r110 = r100.org_unit;
                if (r110 == null) goto L17;
                int r111 = OrgUnit.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                DepartmentList r113 = r100.departments;
                if (r113 == null) goto L21;
                int r114 = DepartmentList.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.is_tenant_certification;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                TenantNameStatus r119 = r100.tenant_name_status;
                if (r119 == null) goto L29;
                int r120 = TenantNameStatus.ADAPTER.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                CertificationInfo r122 = r100.certification_info;
                if (r122 == null) goto L34;
                r102 = CertificationInfo.ADAPTER.encodedSizeWithTag(8, r122);
            L34:
                return (r121 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Company decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Company r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Company r101) throws IOException {
                String r102 = r101.department_name;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.tenant_name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Position r104 = r101.position;
                if (r104 == null) goto L11;
                Position.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                OrgUnit r105 = r101.org_unit;
                if (r105 == null) goto L14;
                OrgUnit.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                DepartmentList r106 = r101.departments;
                if (r106 == null) goto L17;
                DepartmentList.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.is_tenant_certification;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                TenantNameStatus r108 = r101.tenant_name_status;
                if (r108 == null) goto L23;
                TenantNameStatus.ADAPTER.encodeWithTag(r100, 7, r108);
            L23:
                CertificationInfo r109 = r101.certification_info;
                if (r109 == null) goto L26;
                CertificationInfo.ADAPTER.encodeWithTag(r100, 8, r109);
            L26:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Company r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Company();
            DEFAULT_IS_TENANT_CERTIFICATION = Boolean.FALSE;
            DEFAULT_TENANT_NAME_STATUS = TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.department_name = this.department_name;
            r100.tenant_name = this.tenant_name;
            r100.position = this.position;
            r100.org_unit = this.org_unit;
            r100.departments = this.departments;
            r100.is_tenant_certification = this.is_tenant_certification;
            r100.tenant_name_status = this.tenant_name_status;
            r100.certification_info = this.certification_info;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Company.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Company(String r110, String r111, Position r112, OrgUnit r113, DepartmentList r114, Boolean r115, TenantNameStatus r116, CertificationInfo r117) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
        }

        public Company(String r100, String r101, Position r102, OrgUnit r103, DepartmentList r104, Boolean r105, TenantNameStatus r106, CertificationInfo r107, ByteString r110) {
            super(ADAPTER, r110);
            this.department_name = r100;
            this.tenant_name = r101;
            this.position = r102;
            this.org_unit = r103;
            this.departments = r104;
            this.is_tenant_certification = r105;
            this.tenant_name_status = r106;
            this.certification_info = r107;
        }
    }

    public static final class Leader extends Message<Leader, Builder> {
        public static final ProtoAdapter<Leader> ADAPTER = null;
        public static final String DEFAULT_EN_NAME = "";
        public static final String DEFAULT_ID = "";
        public static final String DEFAULT_LOCALIZED_NAME = "";
        public static final String DEFAULT_NAME = "";
        public static final String DEFAULT_PROFILE_URL = "";
        private static final long serialVersionUID = 0;
        public final String en_name;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253611id;
        public final String localized_name;
        public final String name;
        public final String profile_url;

        public static final class Builder extends Message.Builder<Leader, Builder> {
            public String en_name;

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253612id;
            public String localized_name;
            public String name;
            public String profile_url;

            @Override // com.squareup.wire.Message.Builder
            public Leader build() {
                return new Leader(this.f253612id, this.name, this.en_name, this.profile_url, this.localized_name, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder en_name(String r100) {
                this.en_name = r100;
                return this;
            }

            public Builder id(String r100) {
                this.f253612id = r100;
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

            public Builder profile_url(String r100) {
                this.profile_url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Leader extends ProtoAdapter<Leader> {
            public ProtoAdapter_Leader() {
                super(FieldEncoding.LENGTH_DELIMITED, Leader.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Leader decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.f253612id = "";
                r101.name = "";
                r101.en_name = "";
                r101.profile_url = "";
                r101.localized_name = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.f253612id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.en_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.profile_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.localized_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Leader r100) {
                String r101 = r100.f253611id;
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
                String r110 = r100.profile_url;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.localized_name;
                if (r113 == null) goto L22;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                return (r112 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Leader decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Leader r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Leader r101) throws IOException {
                String r102 = r101.f253611id;
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
                String r105 = r101.profile_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.localized_name;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Leader r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Leader();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.f253612id = this.f253611id;
            r100.name = this.name;
            r100.en_name = this.en_name;
            r100.profile_url = this.profile_url;
            r100.localized_name = this.localized_name;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Leader.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Leader(String r100, String r101, String r110, String r111, String r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public Leader(String r100, String r101, String r102, String r103, String r104, ByteString r105) {
            super(ADAPTER, r105);
            this.f253611id = r100;
            this.name = r101;
            this.en_name = r102;
            this.profile_url = r103;
            this.localized_name = r104;
        }
    }

    public static final class Personal extends Message<Personal, Builder> {
        public static final ProtoAdapter<Personal> ADAPTER = null;
        public static final String DEFAULT_ALIAS = "";
        public static final String DEFAULT_APPLICATION_REASON = "";
        public static final String DEFAULT_AVATAR_KEY = "";
        public static final String DEFAULT_AVATAR_PATH = "";
        public static final String DEFAULT_CITY = "";
        public static final String DEFAULT_CONTACT_APPLICATION_ID = "";
        public static final String DEFAULT_CONTACT_TOKEN = "";
        public static final String DEFAULT_DESCRIPTION = "";
        public static final Chatter.Description.Type DEFAULT_DESCRIPTION_TYPE = null;
        public static final String DEFAULT_EMAIL = "";
        public static final String DEFAULT_EMPLOYEE_ID = "";
        public static final String DEFAULT_EN_NAME = "";
        public static final String DEFAULT_GENDER = "";
        public static final Boolean DEFAULT_IS_FRIEND = null;
        public static final Boolean DEFAULT_IS_RESIGNED = null;
        public static final String DEFAULT_LOCALIZED_NAME = "";
        public static final String DEFAULT_MALAITA_PROFILE_URL = "";
        public static final String DEFAULT_MICROAPP_PROFILE_URL = "";
        public static final String DEFAULT_NAME = "";
        public static final Boolean DEFAULT_REQUEST_USER_APPLY = null;
        public static final Boolean DEFAULT_TARGET_USER_APPLY = null;
        public static final String DEFAULT_TENANT_ID = "";
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final String alias;
        public final String application_reason;
        public final String avatar_key;
        public final String avatar_path;
        public final String city;
        public final String contact_application_id;
        public final String contact_token;
        public final String description;
        public final Chatter.Description.Type description_type;
        public final String email;
        public final String employee_id;
        public final String en_name;
        public final String gender;
        public final Boolean is_friend;
        public final Boolean is_resigned;
        public final String localized_name;
        public final String malaita_profile_url;
        public final String microapp_profile_url;
        public final String name;
        public final ProfileValue profile_value;
        public final Boolean request_user_apply;
        public final Boolean target_user_apply;
        public final String tenant_id;
        public final String user_id;

        public static final class Builder extends Message.Builder<Personal, Builder> {
            public String alias;
            public String application_reason;
            public String avatar_key;
            public String avatar_path;
            public String city;
            public String contact_application_id;
            public String contact_token;
            public String description;
            public Chatter.Description.Type description_type;
            public String email;
            public String employee_id;
            public String en_name;
            public String gender;
            public Boolean is_friend;
            public Boolean is_resigned;
            public String localized_name;
            public String malaita_profile_url;
            public String microapp_profile_url;
            public String name;
            public ProfileValue profile_value;
            public Boolean request_user_apply;
            public Boolean target_user_apply;
            public String tenant_id;
            public String user_id;

            @Override // com.squareup.wire.Message.Builder
            public Personal build() {
                String r100 = this.name;
                if (r100 == null) goto L7;
                return new Personal(this.name, this.description, this.email, this.gender, this.malaita_profile_url, this.description_type, this.city, this.employee_id, this.en_name, this.is_friend, this.request_user_apply, this.target_user_apply, this.contact_token, this.contact_application_id, this.application_reason, this.user_id, this.tenant_id, this.avatar_key, this.is_resigned, this.localized_name, this.alias, this.microapp_profile_url, this.profile_value, this.avatar_path, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "name"});
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

            public Builder application_reason(String r100) {
                this.application_reason = r100;
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

            public Builder city(String r100) {
                this.city = r100;
                return this;
            }

            public Builder contact_application_id(String r100) {
                this.contact_application_id = r100;
                return this;
            }

            public Builder contact_token(String r100) {
                this.contact_token = r100;
                return this;
            }

            public Builder description(String r100) {
                this.description = r100;
                return this;
            }

            public Builder description_type(Chatter.Description.Type r100) {
                this.description_type = r100;
                return this;
            }

            public Builder email(String r100) {
                this.email = r100;
                return this;
            }

            public Builder employee_id(String r100) {
                this.employee_id = r100;
                return this;
            }

            public Builder en_name(String r100) {
                this.en_name = r100;
                return this;
            }

            public Builder gender(String r100) {
                this.gender = r100;
                return this;
            }

            public Builder is_friend(Boolean r100) {
                this.is_friend = r100;
                return this;
            }

            public Builder is_resigned(Boolean r100) {
                this.is_resigned = r100;
                return this;
            }

            public Builder localized_name(String r100) {
                this.localized_name = r100;
                return this;
            }

            public Builder malaita_profile_url(String r100) {
                this.malaita_profile_url = r100;
                return this;
            }

            public Builder microapp_profile_url(String r100) {
                this.microapp_profile_url = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }

            public Builder profile_value(ProfileValue r100) {
                this.profile_value = r100;
                return this;
            }

            public Builder request_user_apply(Boolean r100) {
                this.request_user_apply = r100;
                return this;
            }

            public Builder target_user_apply(Boolean r100) {
                this.target_user_apply = r100;
                return this;
            }

            public Builder tenant_id(String r100) {
                this.tenant_id = r100;
                return this;
            }

            public Builder user_id(String r100) {
                this.user_id = r100;
                return this;
            }
        }

        public static final class ProfileField extends Message<ProfileField, Builder> {
            public static final ProtoAdapter<ProfileField> ADAPTER = null;
            public static final String DEFAULT_DEFAULT_LOCALE = "";
            public static final FieldType DEFAULT_FIELD_TYPE = null;
            public static final FieldValueType DEFAULT_FIELD_VALUE_TYPE = null;
            public static final String DEFAULT_I18N_FIELD_NAME = "";
            public static final String DEFAULT_KEY = "";
            public static final Boolean DEFAULT_VISIBLE = null;
            private static final long serialVersionUID = 0;
            public final String default_locale;
            public final FieldType field_type;
            public final FieldValueType field_value_type;
            public final String i18n_field_name;
            public final Map<String, String> i18n_names;
            public final String key;
            public final Boolean visible;

            public static final class Builder extends Message.Builder<ProfileField, Builder> {
                public String default_locale;
                public FieldType field_type;
                public FieldValueType field_value_type;
                public String i18n_field_name;
                public Map<String, String> i18n_names;
                public String key;
                public Boolean visible;

                @Override // com.squareup.wire.Message.Builder
                public ProfileField build() {
                    String r100 = this.key;
                    if (r100 == null) goto L15;
                    if (this.visible == null) goto L15;
                    if (this.field_type == null) goto L15;
                    if (this.default_locale == null) goto L15;
                    if (this.i18n_field_name == null) goto L15;
                    return new ProfileField(this.key, this.i18n_names, this.visible, this.field_type, this.default_locale, this.i18n_field_name, this.field_value_type, super.buildUnknownFields());
                L15:
                    throw Internal.missingRequiredFields(new Object[]{r100, "key", this.visible, "visible", this.field_type, "field_type", this.default_locale, "default_locale", this.i18n_field_name, "i18n_field_name"});
                }

                public Builder() {
                    this.i18n_names = Internal.newMutableMap();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder default_locale(String r100) {
                    this.default_locale = r100;
                    return this;
                }

                public Builder field_type(FieldType r100) {
                    this.field_type = r100;
                    return this;
                }

                public Builder field_value_type(FieldValueType r100) {
                    this.field_value_type = r100;
                    return this;
                }

                public Builder i18n_field_name(String r100) {
                    this.i18n_field_name = r100;
                    return this;
                }

                public Builder i18n_names(Map<String, String> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.i18n_names = r100;
                    return this;
                }

                public Builder key(String r100) {
                    this.key = r100;
                    return this;
                }

                public Builder visible(Boolean r100) {
                    this.visible = r100;
                    return this;
                }
            }

            public static final enum FieldType extends Enum<FieldType> implements WireEnum {
                private static final /* synthetic */ FieldType[] $VALUES = null;
                public static final ProtoAdapter<FieldType> ADAPTER = null;
                public static final FieldType CUSTOM = null;
                public static final FieldType DEFAULT = null;
                public static final FieldType UNKNOWN = null;
                private final int value;

                static {
                    FieldType r100 = new FieldType("UNKNOWN", 0, 0);
                    UNKNOWN = r100;
                    FieldType r101 = new FieldType("DEFAULT", 1, 1);
                    DEFAULT = r101;
                    FieldType r102 = new FieldType("CUSTOM", 2, 2);
                    CUSTOM = r102;
                    $VALUES = new FieldType[]{r100, r101, r102};
                    ADAPTER = ProtoAdapter.newEnumAdapter(FieldType.class);
                }

                public static FieldType[] values() {
                    return (FieldType[]) $VALUES.clone();
                }

                @Override // com.squareup.wire.WireEnum
                public final int getValue() {
                    return this.value;
                }

                public static FieldType fromValue(int r100) {
                    if (r100 == 0) goto L14;
                    if (r100 == 1) goto L12;
                    if (r100 == 2) goto L10;
                    return null;
                L10:
                    return CUSTOM;
                L12:
                    return DEFAULT;
                L14:
                    return UNKNOWN;
                }

                public static FieldType valueOf(String r100) {
                    return (FieldType) a.a(FieldType.class, r100);
                }

                private FieldType(String r100, int r101, int r102) {
                    super(r100, r101);
                    this.value = r102;
                }
            }

            public static final enum FieldValueType extends Enum<FieldValueType> implements WireEnum {
                private static final /* synthetic */ FieldValueType[] $VALUES = null;
                public static final ProtoAdapter<FieldValueType> ADAPTER = null;
                public static final FieldValueType HREF = null;
                public static final FieldValueType TEXT = null;
                public static final FieldValueType UNKNOWN_TYPE = null;
                private final int value;

                static {
                    FieldValueType r100 = new FieldValueType("UNKNOWN_TYPE", 0, 0);
                    UNKNOWN_TYPE = r100;
                    FieldValueType r101 = new FieldValueType(CardAdapter.TEXT, 1, 1);
                    TEXT = r101;
                    FieldValueType r102 = new FieldValueType("HREF", 2, 2);
                    HREF = r102;
                    $VALUES = new FieldValueType[]{r100, r101, r102};
                    ADAPTER = ProtoAdapter.newEnumAdapter(FieldValueType.class);
                }

                public static FieldValueType[] values() {
                    return (FieldValueType[]) $VALUES.clone();
                }

                @Override // com.squareup.wire.WireEnum
                public final int getValue() {
                    return this.value;
                }

                public static FieldValueType fromValue(int r100) {
                    if (r100 == 0) goto L14;
                    if (r100 == 1) goto L12;
                    if (r100 == 2) goto L10;
                    return null;
                L10:
                    return HREF;
                L12:
                    return TEXT;
                L14:
                    return UNKNOWN_TYPE;
                }

                public static FieldValueType valueOf(String r100) {
                    return (FieldValueType) a.a(FieldValueType.class, r100);
                }

                private FieldValueType(String r100, int r101, int r102) {
                    super(r100, r101);
                    this.value = r102;
                }
            }

            public static final class ProtoAdapter_ProfileField extends ProtoAdapter<ProfileField> {
                private final ProtoAdapter<Map<String, String>> i18n_names;

                public ProtoAdapter_ProfileField() {
                    super(FieldEncoding.LENGTH_DELIMITED, ProfileField.class);
                    ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                    this.i18n_names = ProtoAdapter.newMapAdapter(r100, r100);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public ProfileField decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.key = "";
                    r101.visible = Boolean.FALSE;
                    r101.field_type = FieldType.UNKNOWN;
                    r101.default_locale = "";
                    r101.i18n_field_name = "";
                    r101.field_value_type = FieldValueType.UNKNOWN_TYPE;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L20;
                    switch(r103) {
                        case 1: goto L19;
                        case 2: goto L18;
                        case 3: goto L17;
                        case 4: goto L24;
                        case 5: goto L12;
                        case 6: goto L11;
                        case 7: goto L22;
                        default: goto L6;
                    };
                L22:
                    r101.field_value_type = FieldValueType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
                L9:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L24:
                    r101.field_type = FieldType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
                L15:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L11:
                    r101.i18n_field_name = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L12:
                    r101.default_locale = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L17:
                    r101.visible = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L18:
                    r101.i18n_names.putAll(this.i18n_names.decode(r100));
                    goto L3
                L19:
                    r101.key = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L6:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L20:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(ProfileField r100) {
                    ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                    int r102 = ((((r101.encodedSizeWithTag(1, r100.key) + this.i18n_names.encodedSizeWithTag(2, r100.i18n_names)) + ProtoAdapter.BOOL.encodedSizeWithTag(3, r100.visible)) + FieldType.ADAPTER.encodedSizeWithTag(4, r100.field_type)) + r101.encodedSizeWithTag(5, r100.default_locale)) + r101.encodedSizeWithTag(6, r100.i18n_field_name);
                    FieldValueType r103 = r100.field_value_type;
                    if (r103 == null) goto L5;
                    int r104 = FieldValueType.ADAPTER.encodedSizeWithTag(7, r103);
                L7:
                    return (r102 + r104) + r100.unknownFields().size();
                L5:
                    r104 = 0;
                    goto L7
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ ProfileField decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(ProfileField r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, ProfileField r101) throws IOException {
                    ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                    r102.encodeWithTag(r100, 1, r101.key);
                    this.i18n_names.encodeWithTag(r100, 2, r101.i18n_names);
                    ProtoAdapter.BOOL.encodeWithTag(r100, 3, r101.visible);
                    FieldType.ADAPTER.encodeWithTag(r100, 4, r101.field_type);
                    r102.encodeWithTag(r100, 5, r101.default_locale);
                    r102.encodeWithTag(r100, 6, r101.i18n_field_name);
                    FieldValueType r103 = r101.field_value_type;
                    if (r103 == null) goto L5;
                    FieldValueType.ADAPTER.encodeWithTag(r100, 7, r103);
                L5:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ProfileField r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_ProfileField();
                DEFAULT_VISIBLE = Boolean.FALSE;
                DEFAULT_FIELD_TYPE = FieldType.UNKNOWN;
                DEFAULT_FIELD_VALUE_TYPE = FieldValueType.UNKNOWN_TYPE;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.key = this.key;
                r100.i18n_names = Internal.copyOf("i18n_names", this.i18n_names);
                r100.visible = this.visible;
                r100.field_type = this.field_type;
                r100.default_locale = this.default_locale;
                r100.i18n_field_name = this.i18n_field_name;
                r100.field_value_type = this.field_value_type;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return ProfileField.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public ProfileField(String r110, Map<String, String> r111, Boolean r112, FieldType r113, String r114, String r115, FieldValueType r116) {
                this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
            }

            public ProfileField(String r100, Map<String, String> r101, Boolean r102, FieldType r103, String r104, String r105, FieldValueType r106, ByteString r107) {
                super(ADAPTER, r107);
                this.key = r100;
                this.i18n_names = Internal.immutableCopyOf("i18n_names", r101);
                this.visible = r102;
                this.field_type = r103;
                this.default_locale = r104;
                this.i18n_field_name = r105;
                this.field_value_type = r106;
            }
        }

        public static final class ProfileValue extends Message<ProfileValue, Builder> {
            public static final ProtoAdapter<ProfileValue> ADAPTER = null;
            public static final Gender DEFAULT_GENDER_ENUM = null;
            private static final long serialVersionUID = 0;
            public final Map<String, String> custom_field_values;
            public final Map<String, FieldValue> custom_field_values_v2;
            public final Gender gender_enum;
            public final List<ProfileField> profile_fields_order;

            public static final class Builder extends Message.Builder<ProfileValue, Builder> {
                public Map<String, String> custom_field_values;
                public Map<String, FieldValue> custom_field_values_v2;
                public Gender gender_enum;
                public List<ProfileField> profile_fields_order;

                @Override // com.squareup.wire.Message.Builder
                public ProfileValue build() {
                    return new ProfileValue(this.custom_field_values, this.profile_fields_order, this.gender_enum, this.custom_field_values_v2, super.buildUnknownFields());
                }

                public Builder() {
                    this.custom_field_values = Internal.newMutableMap();
                    this.profile_fields_order = Internal.newMutableList();
                    this.custom_field_values_v2 = Internal.newMutableMap();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder custom_field_values(Map<String, String> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.custom_field_values = r100;
                    return this;
                }

                public Builder custom_field_values_v2(Map<String, FieldValue> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.custom_field_values_v2 = r100;
                    return this;
                }

                public Builder gender_enum(Gender r100) {
                    this.gender_enum = r100;
                    return this;
                }

                public Builder profile_fields_order(List<ProfileField> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.profile_fields_order = r100;
                    return this;
                }
            }

            public static final class FieldValue extends Message<FieldValue, Builder> {
                public static final ProtoAdapter<FieldValue> ADAPTER = null;
                public static final String DEFAULT_TEXT = "";
                public static final String DEFAULT_URL = "";
                private static final long serialVersionUID = 0;
                public final String TEXT;
                public final String URL;

                public static final class Builder extends Message.Builder<FieldValue, Builder> {
                    public String TEXT;
                    public String URL;

                    @Override // com.squareup.wire.Message.Builder
                    public FieldValue build() {
                        return new FieldValue(this.TEXT, this.URL, super.buildUnknownFields());
                    }

                    public Builder() {
                    }

                    @Override // com.squareup.wire.Message.Builder
                    public /* bridge */ /* synthetic */ Message build() {
                        return build();
                    }

                    public Builder TEXT(String r100) {
                        this.TEXT = r100;
                        return this;
                    }

                    public Builder URL(String r100) {
                        this.URL = r100;
                        return this;
                    }
                }

                public static final class ProtoAdapter_FieldValue extends ProtoAdapter<FieldValue> {
                    public ProtoAdapter_FieldValue() {
                        super(FieldEncoding.LENGTH_DELIMITED, FieldValue.class);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.squareup.wire.ProtoAdapter
                    public FieldValue decode(ProtoReader r100) throws IOException {
                        Builder r101 = new Builder();
                        r101.TEXT = "";
                        r101.URL = "";
                        long r102 = r100.beginMessage();
                    L3:
                        int r103 = r100.nextTag();
                        if (r103 == (-1)) goto L12;
                        if (r103 != 1) goto L8;
                        r101.TEXT = ProtoAdapter.STRING.decode(r100);
                        goto L3
                    L8:
                        if (r103 != 2) goto L9;
                        r101.URL = ProtoAdapter.STRING.decode(r100);
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
                    public int encodedSize2(FieldValue r100) {
                        String r101 = r100.TEXT;
                        int r102 = 0;
                        if (r101 == null) goto L5;
                        int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                    L6:
                        String r104 = r100.URL;
                        if (r104 == null) goto L10;
                        r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                    L10:
                        return (r103 + r102) + r100.unknownFields().size();
                    L5:
                        r103 = 0;
                        goto L6
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ FieldValue decode(ProtoReader r100) throws IOException {
                        return decode(r100);
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ int encodedSize(FieldValue r100) {
                        return encodedSize2(r100);
                    }

                    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                    public void encode2(ProtoWriter r100, FieldValue r101) throws IOException {
                        String r102 = r101.TEXT;
                        if (r102 == null) goto L5;
                        ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                    L5:
                        String r103 = r101.URL;
                        if (r103 == null) goto L8;
                        ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                    L8:
                        r100.writeBytes(r101.unknownFields());
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FieldValue r101) throws IOException {
                        encode2(r100, r101);
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_FieldValue();
                }

                @Override // com.squareup.wire.Message
                public Builder newBuilder() {
                    Builder r100 = new Builder();
                    r100.TEXT = this.TEXT;
                    r100.URL = this.URL;
                    r100.addUnknownFields(unknownFields());
                    return r100;
                }

                @Override // com.squareup.wire.Message
                public String toString() {
                    return FieldValue.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                @Override // com.squareup.wire.Message
                public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                    return newBuilder();
                }

                public FieldValue(String r100, String r101) {
                    this(r100, r101, ByteString.EMPTY);
                }

                public FieldValue(String r100, String r101, ByteString r102) {
                    super(ADAPTER, r102);
                    this.TEXT = r100;
                    this.URL = r101;
                }
            }

            public static final enum Gender extends Enum<Gender> implements WireEnum {
                private static final /* synthetic */ Gender[] $VALUES = null;
                public static final ProtoAdapter<Gender> ADAPTER = null;
                public static final Gender DEFAULT = null;
                public static final Gender MAN = null;
                public static final Gender WOMAN = null;
                private final int value;

                static {
                    Gender r100 = new Gender("DEFAULT", 0, 0);
                    DEFAULT = r100;
                    Gender r101 = new Gender(HTTP.MAN, 1, 1);
                    MAN = r101;
                    Gender r102 = new Gender("WOMAN", 2, 2);
                    WOMAN = r102;
                    $VALUES = new Gender[]{r100, r101, r102};
                    ADAPTER = ProtoAdapter.newEnumAdapter(Gender.class);
                }

                public static Gender[] values() {
                    return (Gender[]) $VALUES.clone();
                }

                @Override // com.squareup.wire.WireEnum
                public final int getValue() {
                    return this.value;
                }

                public static Gender fromValue(int r100) {
                    if (r100 == 0) goto L14;
                    if (r100 == 1) goto L12;
                    if (r100 == 2) goto L10;
                    return null;
                L10:
                    return WOMAN;
                L12:
                    return MAN;
                L14:
                    return DEFAULT;
                }

                public static Gender valueOf(String r100) {
                    return (Gender) a.a(Gender.class, r100);
                }

                private Gender(String r100, int r101, int r102) {
                    super(r100, r101);
                    this.value = r102;
                }
            }

            public static final class ProtoAdapter_ProfileValue extends ProtoAdapter<ProfileValue> {
                private final ProtoAdapter<Map<String, String>> custom_field_values;
                private final ProtoAdapter<Map<String, FieldValue>> custom_field_values_v2;

                public ProtoAdapter_ProfileValue() {
                    super(FieldEncoding.LENGTH_DELIMITED, ProfileValue.class);
                    ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                    this.custom_field_values = ProtoAdapter.newMapAdapter(r100, r100);
                    this.custom_field_values_v2 = ProtoAdapter.newMapAdapter(r100, FieldValue.ADAPTER);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public ProfileValue decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.gender_enum = Gender.DEFAULT;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L21;
                    if (r103 != 1) goto L8;
                    r101.custom_field_values.putAll(this.custom_field_values.decode(r100));
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.profile_fields_order.add(ProfileField.ADAPTER.decode(r100));
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.gender_enum = Gender.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
                L17:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.custom_field_values_v2.putAll(this.custom_field_values_v2.decode(r100));
                    goto L3
                L13:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L21:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(ProfileValue r100) {
                    int r101 = this.custom_field_values.encodedSizeWithTag(1, r100.custom_field_values) + ProfileField.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.profile_fields_order);
                    Gender r102 = r100.gender_enum;
                    if (r102 == null) goto L5;
                    int r103 = Gender.ADAPTER.encodedSizeWithTag(3, r102);
                L7:
                    return ((r101 + r103) + this.custom_field_values_v2.encodedSizeWithTag(4, r100.custom_field_values_v2)) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L7
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ ProfileValue decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(ProfileValue r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, ProfileValue r101) throws IOException {
                    this.custom_field_values.encodeWithTag(r100, 1, r101.custom_field_values);
                    ProfileField.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.profile_fields_order);
                    Gender r102 = r101.gender_enum;
                    if (r102 == null) goto L5;
                    Gender.ADAPTER.encodeWithTag(r100, 3, r102);
                L5:
                    this.custom_field_values_v2.encodeWithTag(r100, 4, r101.custom_field_values_v2);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ProfileValue r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_ProfileValue();
                DEFAULT_GENDER_ENUM = Gender.DEFAULT;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.custom_field_values = Internal.copyOf("custom_field_values", this.custom_field_values);
                r100.profile_fields_order = Internal.copyOf("profile_fields_order", this.profile_fields_order);
                r100.gender_enum = this.gender_enum;
                r100.custom_field_values_v2 = Internal.copyOf("custom_field_values_v2", this.custom_field_values_v2);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return ProfileValue.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public ProfileValue(Map<String, String> r100, List<ProfileField> r101, Gender r102, Map<String, FieldValue> r110) {
                this(r100, r101, r102, r110, ByteString.EMPTY);
            }

            public ProfileValue(Map<String, String> r100, List<ProfileField> r101, Gender r102, Map<String, FieldValue> r103, ByteString r104) {
                super(ADAPTER, r104);
                this.custom_field_values = Internal.immutableCopyOf("custom_field_values", r100);
                this.profile_fields_order = Internal.immutableCopyOf("profile_fields_order", r101);
                this.gender_enum = r102;
                this.custom_field_values_v2 = Internal.immutableCopyOf("custom_field_values_v2", r103);
            }
        }

        public static final class ProtoAdapter_Personal extends ProtoAdapter<Personal> {
            public ProtoAdapter_Personal() {
                super(FieldEncoding.LENGTH_DELIMITED, Personal.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Personal decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.name = "";
                r101.description = "";
                r101.email = "";
                r101.gender = "";
                r101.malaita_profile_url = "";
                r101.description_type = Chatter.Description.Type.ON_DEFAULT;
                r101.city = "";
                r101.employee_id = "";
                r101.en_name = "";
                Boolean r102 = Boolean.FALSE;
                r101.is_friend = r102;
                r101.request_user_apply = r102;
                r101.target_user_apply = r102;
                r101.contact_token = "";
                r101.contact_application_id = "";
                r101.application_reason = "";
                r101.user_id = "";
                r101.tenant_id = "";
                r101.avatar_key = "";
                r101.is_resigned = r102;
                r101.localized_name = "";
                r101.alias = "";
                r101.microapp_profile_url = "";
                r101.avatar_path = "";
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L34;
                switch(r104) {
                    case 1: goto L33;
                    case 2: goto L32;
                    case 3: goto L31;
                    case 4: goto L30;
                    case 5: goto L29;
                    case 6: goto L36;
                    case 7: goto L24;
                    case 8: goto L23;
                    case 9: goto L22;
                    case 10: goto L21;
                    case 11: goto L20;
                    case 12: goto L19;
                    case 13: goto L18;
                    case 14: goto L17;
                    case 15: goto L16;
                    case 16: goto L15;
                    case 17: goto L14;
                    case 18: goto L13;
                    case 19: goto L12;
                    case 20: goto L11;
                    case 21: goto L10;
                    case 22: goto L9;
                    case 23: goto L8;
                    case 24: goto L7;
                    default: goto L6;
                };
            L36:
                r101.description_type = Chatter.Description.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
            L27:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.avatar_path = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.profile_value = ProfileValue.ADAPTER.decode(r100);
                goto L3
            L9:
                r101.microapp_profile_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.alias = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.localized_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.is_resigned = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.avatar_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.tenant_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L16:
                r101.application_reason = ProtoAdapter.STRING.decode(r100);
                goto L3
            L17:
                r101.contact_application_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L18:
                r101.contact_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L19:
                r101.target_user_apply = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L20:
                r101.request_user_apply = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L21:
                r101.is_friend = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L22:
                r101.en_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L23:
                r101.employee_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L24:
                r101.city = ProtoAdapter.STRING.decode(r100);
                goto L3
            L29:
                r101.malaita_profile_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L30:
                r101.gender = ProtoAdapter.STRING.decode(r100);
                goto L3
            L31:
                r101.email = ProtoAdapter.STRING.decode(r100);
                goto L3
            L32:
                r101.description = ProtoAdapter.STRING.decode(r100);
                goto L3
            L33:
                r101.name = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(Personal r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.name);
                String r103 = r100.description;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(2, r103);
            L6:
                int r106 = r102 + r105;
                String r107 = r100.email;
                if (r107 == null) goto L9;
                int r108 = r101.encodedSizeWithTag(3, r107);
            L10:
                int r109 = r106 + r108;
                String r110 = r100.gender;
                if (r110 == null) goto L13;
                int r111 = r101.encodedSizeWithTag(4, r110);
            L14:
                int r112 = r109 + r111;
                String r113 = r100.malaita_profile_url;
                if (r113 == null) goto L17;
                int r114 = r101.encodedSizeWithTag(5, r113);
            L18:
                int r115 = r112 + r114;
                Chatter.Description.Type r116 = r100.description_type;
                if (r116 == null) goto L21;
                int r117 = Chatter.Description.Type.ADAPTER.encodedSizeWithTag(6, r116);
            L22:
                int r118 = r115 + r117;
                String r119 = r100.city;
                if (r119 == null) goto L25;
                int r120 = r101.encodedSizeWithTag(7, r119);
            L26:
                int r121 = r118 + r120;
                String r122 = r100.employee_id;
                if (r122 == null) goto L29;
                int r123 = r101.encodedSizeWithTag(8, r122);
            L30:
                int r124 = r121 + r123;
                String r125 = r100.en_name;
                if (r125 == null) goto L33;
                int r126 = r101.encodedSizeWithTag(9, r125);
            L34:
                int r127 = r124 + r126;
                Boolean r128 = r100.is_friend;
                if (r128 == null) goto L37;
                int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r128);
            L38:
                int r130 = r127 + r129;
                Boolean r131 = r100.request_user_apply;
                if (r131 == null) goto L41;
                int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r131);
            L42:
                int r133 = r130 + r132;
                Boolean r134 = r100.target_user_apply;
                if (r134 == null) goto L45;
                int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r134);
            L46:
                int r136 = r133 + r135;
                String r137 = r100.contact_token;
                if (r137 == null) goto L49;
                int r138 = r101.encodedSizeWithTag(13, r137);
            L50:
                int r139 = r136 + r138;
                String r140 = r100.contact_application_id;
                if (r140 == null) goto L53;
                int r141 = r101.encodedSizeWithTag(14, r140);
            L54:
                int r142 = r139 + r141;
                String r143 = r100.application_reason;
                if (r143 == null) goto L57;
                int r144 = r101.encodedSizeWithTag(15, r143);
            L58:
                int r145 = r142 + r144;
                String r146 = r100.user_id;
                if (r146 == null) goto L61;
                int r147 = r101.encodedSizeWithTag(16, r146);
            L62:
                int r148 = r145 + r147;
                String r149 = r100.tenant_id;
                if (r149 == null) goto L65;
                int r150 = r101.encodedSizeWithTag(17, r149);
            L66:
                int r151 = r148 + r150;
                String r152 = r100.avatar_key;
                if (r152 == null) goto L69;
                int r153 = r101.encodedSizeWithTag(18, r152);
            L70:
                int r154 = r151 + r153;
                Boolean r155 = r100.is_resigned;
                if (r155 == null) goto L73;
                int r156 = ProtoAdapter.BOOL.encodedSizeWithTag(19, r155);
            L74:
                int r157 = r154 + r156;
                String r158 = r100.localized_name;
                if (r158 == null) goto L77;
                int r159 = r101.encodedSizeWithTag(20, r158);
            L78:
                int r160 = r157 + r159;
                String r161 = r100.alias;
                if (r161 == null) goto L81;
                int r162 = r101.encodedSizeWithTag(21, r161);
            L82:
                int r163 = r160 + r162;
                String r164 = r100.microapp_profile_url;
                if (r164 == null) goto L85;
                int r165 = r101.encodedSizeWithTag(22, r164);
            L86:
                int r166 = r163 + r165;
                ProfileValue r167 = r100.profile_value;
                if (r167 == null) goto L89;
                int r168 = ProfileValue.ADAPTER.encodedSizeWithTag(23, r167);
            L90:
                int r169 = r166 + r168;
                String r170 = r100.avatar_path;
                if (r170 == null) goto L94;
                r104 = r101.encodedSizeWithTag(24, r170);
            L94:
                return (r169 + r104) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Personal decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Personal r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Personal r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.name);
                String r103 = r101.description;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                String r104 = r101.email;
                if (r104 == null) goto L8;
                r102.encodeWithTag(r100, 3, r104);
            L8:
                String r105 = r101.gender;
                if (r105 == null) goto L11;
                r102.encodeWithTag(r100, 4, r105);
            L11:
                String r106 = r101.malaita_profile_url;
                if (r106 == null) goto L14;
                r102.encodeWithTag(r100, 5, r106);
            L14:
                Chatter.Description.Type r107 = r101.description_type;
                if (r107 == null) goto L17;
                Chatter.Description.Type.ADAPTER.encodeWithTag(r100, 6, r107);
            L17:
                String r108 = r101.city;
                if (r108 == null) goto L20;
                r102.encodeWithTag(r100, 7, r108);
            L20:
                String r109 = r101.employee_id;
                if (r109 == null) goto L23;
                r102.encodeWithTag(r100, 8, r109);
            L23:
                String r110 = r101.en_name;
                if (r110 == null) goto L26;
                r102.encodeWithTag(r100, 9, r110);
            L26:
                Boolean r111 = r101.is_friend;
                if (r111 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r100, 10, r111);
            L29:
                Boolean r112 = r101.request_user_apply;
                if (r112 == null) goto L32;
                ProtoAdapter.BOOL.encodeWithTag(r100, 11, r112);
            L32:
                Boolean r113 = r101.target_user_apply;
                if (r113 == null) goto L35;
                ProtoAdapter.BOOL.encodeWithTag(r100, 12, r113);
            L35:
                String r114 = r101.contact_token;
                if (r114 == null) goto L38;
                r102.encodeWithTag(r100, 13, r114);
            L38:
                String r115 = r101.contact_application_id;
                if (r115 == null) goto L41;
                r102.encodeWithTag(r100, 14, r115);
            L41:
                String r116 = r101.application_reason;
                if (r116 == null) goto L44;
                r102.encodeWithTag(r100, 15, r116);
            L44:
                String r117 = r101.user_id;
                if (r117 == null) goto L47;
                r102.encodeWithTag(r100, 16, r117);
            L47:
                String r118 = r101.tenant_id;
                if (r118 == null) goto L50;
                r102.encodeWithTag(r100, 17, r118);
            L50:
                String r119 = r101.avatar_key;
                if (r119 == null) goto L53;
                r102.encodeWithTag(r100, 18, r119);
            L53:
                Boolean r120 = r101.is_resigned;
                if (r120 == null) goto L56;
                ProtoAdapter.BOOL.encodeWithTag(r100, 19, r120);
            L56:
                String r121 = r101.localized_name;
                if (r121 == null) goto L59;
                r102.encodeWithTag(r100, 20, r121);
            L59:
                String r122 = r101.alias;
                if (r122 == null) goto L62;
                r102.encodeWithTag(r100, 21, r122);
            L62:
                String r123 = r101.microapp_profile_url;
                if (r123 == null) goto L65;
                r102.encodeWithTag(r100, 22, r123);
            L65:
                ProfileValue r124 = r101.profile_value;
                if (r124 == null) goto L68;
                ProfileValue.ADAPTER.encodeWithTag(r100, 23, r124);
            L68:
                String r125 = r101.avatar_path;
                if (r125 == null) goto L71;
                r102.encodeWithTag(r100, 24, r125);
            L71:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Personal r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Personal();
            DEFAULT_DESCRIPTION_TYPE = Chatter.Description.Type.ON_DEFAULT;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_FRIEND = r100;
            DEFAULT_REQUEST_USER_APPLY = r100;
            DEFAULT_TARGET_USER_APPLY = r100;
            DEFAULT_IS_RESIGNED = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.name = this.name;
            r100.description = this.description;
            r100.email = this.email;
            r100.gender = this.gender;
            r100.malaita_profile_url = this.malaita_profile_url;
            r100.description_type = this.description_type;
            r100.city = this.city;
            r100.employee_id = this.employee_id;
            r100.en_name = this.en_name;
            r100.is_friend = this.is_friend;
            r100.request_user_apply = this.request_user_apply;
            r100.target_user_apply = this.target_user_apply;
            r100.contact_token = this.contact_token;
            r100.contact_application_id = this.contact_application_id;
            r100.application_reason = this.application_reason;
            r100.user_id = this.user_id;
            r100.tenant_id = this.tenant_id;
            r100.avatar_key = this.avatar_key;
            r100.is_resigned = this.is_resigned;
            r100.localized_name = this.localized_name;
            r100.alias = this.alias;
            r100.microapp_profile_url = this.microapp_profile_url;
            r100.profile_value = this.profile_value;
            r100.avatar_path = this.avatar_path;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Personal.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Personal(String r210, String r211, String r212, String r310, String r311, Chatter.Description.Type r312, String r313, String r314, String r315, Boolean r316, Boolean r317, Boolean r318, String r319, String r410, String r411, String r412, String r413, String r414, Boolean r415, String r416, String r417, String r418, ProfileValue r419, String r510) {
            this(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, ByteString.EMPTY);
        }

        public Personal(String r100, String r101, String r102, String r103, String r104, Chatter.Description.Type r105, String r110, String r111, String r112, Boolean r113, Boolean r114, Boolean r115, String r116, String r117, String r118, String r119, String r210, String r211, Boolean r212, String r213, String r214, String r215, ProfileValue r216, String r217, ByteString r218) {
            super(ADAPTER, r218);
            this.name = r100;
            this.description = r101;
            this.email = r102;
            this.gender = r103;
            this.malaita_profile_url = r104;
            this.description_type = r105;
            this.city = r110;
            this.employee_id = r111;
            this.en_name = r112;
            this.is_friend = r113;
            this.request_user_apply = r114;
            this.target_user_apply = r115;
            this.contact_token = r116;
            this.contact_application_id = r117;
            this.application_reason = r118;
            this.user_id = r119;
            this.tenant_id = r210;
            this.avatar_key = r211;
            this.is_resigned = r212;
            this.localized_name = r213;
            this.alias = r214;
            this.microapp_profile_url = r215;
            this.profile_value = r216;
            this.avatar_path = r217;
        }
    }

    public static final class ProtoAdapter_GetUserProfileResponse extends ProtoAdapter<GetUserProfileResponse> implements c<GetUserProfileResponse> {
        public ProtoAdapter_GetUserProfileResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserProfileResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserProfileResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.do_not_disturb_end_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.do_not_disturb_end_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.access_info = Chatter.AccessInfo.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.work_status = WorkStatus.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.admin_info = AdminInfo.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.leader = Leader.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.personal = Personal.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.company = Company.ADAPTER.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUserProfileResponse r100) {
            Company r101 = r100.company;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Company.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + Personal.ADAPTER.encodedSizeWithTag(2, r100.personal);
            Leader r105 = r100.leader;
            if (r105 == null) goto L9;
            int r106 = Leader.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            AdminInfo r108 = r100.admin_info;
            if (r108 == null) goto L13;
            int r109 = AdminInfo.ADAPTER.encodedSizeWithTag(4, r108);
        L14:
            int r110 = r107 + r109;
            WorkStatus r111 = r100.work_status;
            if (r111 == null) goto L17;
            int r112 = WorkStatus.ADAPTER.encodedSizeWithTag(5, r111);
        L18:
            int r113 = r110 + r112;
            Chatter.AccessInfo r114 = r100.access_info;
            if (r114 == null) goto L21;
            int r115 = Chatter.AccessInfo.ADAPTER.encodedSizeWithTag(6, r114);
        L22:
            int r116 = r113 + r115;
            Long r117 = r100.do_not_disturb_end_time;
            if (r117 == null) goto L26;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(7, r117);
        L26:
            return (r116 + r102) + r100.unknownFields().size();
        L21:
            r115 = 0;
            goto L22
        L17:
            r112 = 0;
            goto L18
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserProfileResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserProfileResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserProfileResponse r101) throws IOException {
            Company r102 = r101.company;
            if (r102 == null) goto L5;
            Company.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Personal.ADAPTER.encodeWithTag(r100, 2, r101.personal);
            Leader r103 = r101.leader;
            if (r103 == null) goto L8;
            Leader.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            AdminInfo r104 = r101.admin_info;
            if (r104 == null) goto L11;
            AdminInfo.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            WorkStatus r105 = r101.work_status;
            if (r105 == null) goto L14;
            WorkStatus.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            Chatter.AccessInfo r106 = r101.access_info;
            if (r106 == null) goto L17;
            Chatter.AccessInfo.ADAPTER.encodeWithTag(r100, 6, r106);
        L17:
            Long r107 = r101.do_not_disturb_end_time;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserProfileResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUserProfileResponse r100 = new ProtoAdapter_GetUserProfileResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DO_NOT_DISTURB_END_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.company = this.company;
        r100.personal = this.personal;
        r100.leader = this.leader;
        r100.admin_info = this.admin_info;
        r100.work_status = this.work_status;
        r100.access_info = this.access_info;
        r100.do_not_disturb_end_time = this.do_not_disturb_end_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserProfileResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserProfileResponse(Company r110, Personal r111, Leader r112, AdminInfo r113, WorkStatus r114, Chatter.AccessInfo r115, Long r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public GetUserProfileResponse(Company r100, Personal r101, Leader r102, AdminInfo r103, WorkStatus r104, Chatter.AccessInfo r105, Long r106, ByteString r107) {
        super(ADAPTER, r107);
        this.company = r100;
        this.personal = r101;
        this.leader = r102;
        this.admin_info = r103;
        this.work_status = r104;
        this.access_info = r105;
        this.do_not_disturb_end_time = r106;
    }
}
