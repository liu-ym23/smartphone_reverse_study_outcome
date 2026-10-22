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
public final class PullPermissionRequest extends Message<PullPermissionRequest, Builder> {
    public static final ProtoAdapter<PullPermissionRequest> ADAPTER = null;
    public static final String DEFAULT_API_VERSION = "";
    public static final Long DEFAULT_APP_ID = null;
    public static final String DEFAULT_PERM_VERSION = "";
    private static final long serialVersionUID = 0;
    public final String mapi_version;
    public final Long mapp_id;
    public final String mperm_version;

    public static final class Builder extends Message.Builder<PullPermissionRequest, Builder> {
        public String mapi_version;
        public Long mapp_id;
        public String mperm_version;

        @Override // com.squareup.wire.Message.Builder
        public PullPermissionRequest build() {
            Long r100 = this.mapp_id;
            if (r100 == null) goto L11;
            if (this.mapi_version == null) goto L11;
            if (this.mperm_version == null) goto L11;
            return new PullPermissionRequest(this.mapp_id, this.mapi_version, this.mperm_version, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "mapp_id", this.mapi_version, "mapi_version", this.mperm_version, "mperm_version"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder api_version(String r100) {
            this.mapi_version = r100;
            return this;
        }

        public Builder app_id(Long r100) {
            this.mapp_id = r100;
            return this;
        }

        public Builder perm_version(String r100) {
            this.mperm_version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullPermissionRequest extends ProtoAdapter<PullPermissionRequest> {
        public ProtoAdapter_PullPermissionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullPermissionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullPermissionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mapp_id = 0L;
            r101.mapi_version = "";
            r101.mperm_version = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mapp_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mapi_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mperm_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullPermissionRequest r100) {
            int r101 = ProtoAdapter.INT64.encodedSizeWithTag(1, r100.mapp_id);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return ((r101 + r102.encodedSizeWithTag(2, r100.mapi_version)) + r102.encodedSizeWithTag(3, r100.mperm_version)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullPermissionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullPermissionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullPermissionRequest r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.mapp_id);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.mapi_version);
            r102.encodeWithTag(r100, 3, r101.mperm_version);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullPermissionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullPermissionRequest();
        DEFAULT_APP_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mapp_id = this.mapp_id;
        r100.mapi_version = this.mapi_version;
        r100.mperm_version = this.mperm_version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullPermissionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullPermissionRequest(Long r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PullPermissionRequest(Long r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mapp_id = r100;
        this.mapi_version = r101;
        this.mperm_version = r102;
    }
}
