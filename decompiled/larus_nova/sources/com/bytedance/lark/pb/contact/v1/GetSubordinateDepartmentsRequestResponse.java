package com.bytedance.lark.pb.contact.v1;

import com.bytedance.lark.pb.basic.v1.Department;
import com.bytedance.lark.pb.basic.v1.Tenant;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetSubordinateDepartmentsRequestResponse extends Message<GetSubordinateDepartmentsRequestResponse, Builder> {
    public static final ProtoAdapter<GetSubordinateDepartmentsRequestResponse> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SHOW_MEMBER_COUNT = null;
    public static final Integer DEFAULT_MEMBER_COUNT = null;
    public static final ProtoAdapter_GetSubordinateDepartmentsRequestResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Department> departments;
    public final Boolean is_show_member_count;
    public final Integer member_count;
    public final Tenant tenant;

    public static final class Builder extends Message.Builder<GetSubordinateDepartmentsRequestResponse, Builder> implements d<GetSubordinateDepartmentsRequestResponse> {
        public List<Department> departments;
        public Boolean is_show_member_count;
        public Integer member_count;
        public Tenant tenant;

        @Override // com.squareup.wire.Message.Builder
        public GetSubordinateDepartmentsRequestResponse build() {
            return new GetSubordinateDepartmentsRequestResponse(this.departments, this.member_count, this.is_show_member_count, this.tenant, super.buildUnknownFields());
        }

        public Builder() {
            this.departments = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder departments(List<Department> r100) {
            Internal.checkElementsNotNull(r100);
            this.departments = r100;
            return this;
        }

        public Builder is_show_member_count(Boolean r100) {
            this.is_show_member_count = r100;
            return this;
        }

        public Builder member_count(Integer r100) {
            this.member_count = r100;
            return this;
        }

        public Builder tenant(Tenant r100) {
            this.tenant = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSubordinateDepartmentsRequestResponse extends ProtoAdapter<GetSubordinateDepartmentsRequestResponse> implements c<GetSubordinateDepartmentsRequestResponse> {
        public ProtoAdapter_GetSubordinateDepartmentsRequestResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSubordinateDepartmentsRequestResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSubordinateDepartmentsRequestResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.member_count = 0;
            r101.is_show_member_count = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.departments.add(Department.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.member_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.is_show_member_count = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.tenant = Tenant.ADAPTER.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetSubordinateDepartmentsRequestResponse r100) {
            int r101 = Department.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.departments);
            Integer r102 = r100.member_count;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.is_show_member_count;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Tenant r109 = r100.tenant;
            if (r109 == null) goto L14;
            r103 = Tenant.ADAPTER.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSubordinateDepartmentsRequestResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSubordinateDepartmentsRequestResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSubordinateDepartmentsRequestResponse r101) throws IOException {
            Department.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.departments);
            Integer r102 = r101.member_count;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.is_show_member_count;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            Tenant r104 = r101.tenant;
            if (r104 == null) goto L11;
            Tenant.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSubordinateDepartmentsRequestResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetSubordinateDepartmentsRequestResponse r100 = new ProtoAdapter_GetSubordinateDepartmentsRequestResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_MEMBER_COUNT = 0;
        DEFAULT_IS_SHOW_MEMBER_COUNT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.departments = Internal.copyOf(InvRouter.DEPARTMENTS, this.departments);
        r100.member_count = this.member_count;
        r100.is_show_member_count = this.is_show_member_count;
        r100.tenant = this.tenant;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSubordinateDepartmentsRequestResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSubordinateDepartmentsRequestResponse(List<Department> r100, Integer r101, Boolean r102, Tenant r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetSubordinateDepartmentsRequestResponse(List<Department> r100, Integer r101, Boolean r102, Tenant r103, ByteString r104) {
        super(ADAPTER, r104);
        this.departments = Internal.immutableCopyOf(InvRouter.DEPARTMENTS, r100);
        this.member_count = r101;
        this.is_show_member_count = r102;
        this.tenant = r103;
    }
}
