package com.ss.android.lark.pb.authorization;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullPermissionResponse extends Message<PullPermissionResponse, Builder> {
    public static final ProtoAdapter<PullPermissionResponse> ADAPTER = null;
    public static final Boolean DEFAULT_CLEAR_OLD = null;
    public static final String DEFAULT_PERM_VERSION = "";
    private static final long serialVersionUID = 0;
    public final Boolean mclear_old;
    public final String mperm_version;
    public final AllPermissionData mpermission_data;
    public final PermissionExtra mpermission_extra;

    public static final class Builder extends Message.Builder<PullPermissionResponse, Builder> {
        public Boolean mclear_old;
        public String mperm_version;
        public AllPermissionData mpermission_data;
        public PermissionExtra mpermission_extra;

        @Override // com.squareup.wire.Message.Builder
        public PullPermissionResponse build() {
            AllPermissionData r100 = this.mpermission_data;
            if (r100 == null) goto L11;
            if (this.mclear_old == null) goto L11;
            if (this.mperm_version == null) goto L11;
            return new PullPermissionResponse(this.mpermission_data, this.mclear_old, this.mperm_version, this.mpermission_extra, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "mpermission_data", this.mclear_old, "mclear_old", this.mperm_version, "mperm_version"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder clear_old(Boolean r100) {
            this.mclear_old = r100;
            return this;
        }

        public Builder perm_version(String r100) {
            this.mperm_version = r100;
            return this;
        }

        public Builder permission_data(AllPermissionData r100) {
            this.mpermission_data = r100;
            return this;
        }

        public Builder permission_extra(PermissionExtra r100) {
            this.mpermission_extra = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullPermissionResponse extends ProtoAdapter<PullPermissionResponse> {
        public ProtoAdapter_PullPermissionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullPermissionResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullPermissionResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mclear_old = Boolean.FALSE;
            r101.mperm_version = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mpermission_data = AllPermissionData.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mclear_old = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mperm_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mpermission_extra = PermissionExtra.ADAPTER.decode(r100);
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
        public int encodedSize2(PullPermissionResponse r100) {
            int r101 = (AllPermissionData.ADAPTER.encodedSizeWithTag(1, r100.mpermission_data) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.mclear_old)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r100.mperm_version);
            PermissionExtra r102 = r100.mpermission_extra;
            if (r102 == null) goto L5;
            int r103 = PermissionExtra.ADAPTER.encodedSizeWithTag(4, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullPermissionResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullPermissionResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullPermissionResponse r101) throws IOException {
            AllPermissionData.ADAPTER.encodeWithTag(r100, 1, r101.mpermission_data);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.mclear_old);
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r101.mperm_version);
            PermissionExtra r102 = r101.mpermission_extra;
            if (r102 == null) goto L5;
            PermissionExtra.ADAPTER.encodeWithTag(r100, 4, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullPermissionResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullPermissionResponse();
        DEFAULT_CLEAR_OLD = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mpermission_data = this.mpermission_data;
        r100.mclear_old = this.mclear_old;
        r100.mperm_version = this.mperm_version;
        r100.mpermission_extra = this.mpermission_extra;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullPermissionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullPermissionResponse(AllPermissionData r100, Boolean r101, String r102, PermissionExtra r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PullPermissionResponse(AllPermissionData r100, Boolean r101, String r102, PermissionExtra r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mpermission_data = r100;
        this.mclear_old = r101;
        this.mperm_version = r102;
        this.mpermission_extra = r103;
    }
}
