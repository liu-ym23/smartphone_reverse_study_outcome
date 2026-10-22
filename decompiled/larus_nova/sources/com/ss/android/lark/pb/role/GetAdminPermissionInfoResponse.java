package com.ss.android.lark.pb.role;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class GetAdminPermissionInfoResponse extends Message<GetAdminPermissionInfoResponse, Builder> {
    public static final ProtoAdapter<GetAdminPermissionInfoResponse> ADAPTER = null;
    public static final Boolean DEFAULT_ISADMINISTRATOR = null;
    public static final Boolean DEFAULT_ISDEPARTMENTADMINISTRATOR = null;
    public static final Boolean DEFAULT_ISSUPERADMINISTRATOR = null;
    private static final long serialVersionUID = 0;
    public final Boolean misAdministrator;
    public final Boolean misDepartmentAdministrator;
    public final Boolean misSuperAdministrator;

    public static final class Builder extends Message.Builder<GetAdminPermissionInfoResponse, Builder> {
        public Boolean misAdministrator;
        public Boolean misDepartmentAdministrator;
        public Boolean misSuperAdministrator;

        @Override // com.squareup.wire.Message.Builder
        public GetAdminPermissionInfoResponse build() {
            Boolean r100 = this.misSuperAdministrator;
            if (r100 == null) goto L7;
            return new GetAdminPermissionInfoResponse(this.misSuperAdministrator, this.misDepartmentAdministrator, this.misAdministrator, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "misSuperAdministrator"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder isAdministrator(Boolean r100) {
            this.misAdministrator = r100;
            return this;
        }

        public Builder isDepartmentAdministrator(Boolean r100) {
            this.misDepartmentAdministrator = r100;
            return this;
        }

        public Builder isSuperAdministrator(Boolean r100) {
            this.misSuperAdministrator = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAdminPermissionInfoResponse extends ProtoAdapter<GetAdminPermissionInfoResponse> {
        public ProtoAdapter_GetAdminPermissionInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAdminPermissionInfoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetAdminPermissionInfoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.misSuperAdministrator = r102;
            r101.misDepartmentAdministrator = r102;
            r101.misAdministrator = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.misSuperAdministrator = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.misDepartmentAdministrator = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.misAdministrator = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(GetAdminPermissionInfoResponse r100) {
            ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
            int r102 = r101.encodedSizeWithTag(1, r100.misSuperAdministrator);
            Boolean r103 = r100.misDepartmentAdministrator;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.misAdministrator;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetAdminPermissionInfoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetAdminPermissionInfoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetAdminPermissionInfoResponse r101) throws IOException {
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 1, r101.misSuperAdministrator);
            Boolean r103 = r101.misDepartmentAdministrator;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Boolean r104 = r101.misAdministrator;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAdminPermissionInfoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetAdminPermissionInfoResponse();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_ISSUPERADMINISTRATOR = r100;
        DEFAULT_ISDEPARTMENTADMINISTRATOR = r100;
        DEFAULT_ISADMINISTRATOR = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.misSuperAdministrator = this.misSuperAdministrator;
        r100.misDepartmentAdministrator = this.misDepartmentAdministrator;
        r100.misAdministrator = this.misAdministrator;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetAdminPermissionInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetAdminPermissionInfoResponse(Boolean r100, Boolean r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetAdminPermissionInfoResponse(Boolean r100, Boolean r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.misSuperAdministrator = r100;
        this.misDepartmentAdministrator = r101;
        this.misAdministrator = r102;
    }
}
