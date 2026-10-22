package com.ss.android.lark.pb.ug.brand;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullTenantBuildResourceResponse extends Message<PullTenantBuildResourceResponse, Builder> {
    public static final ProtoAdapter<PullTenantBuildResourceResponse> ADAPTER = null;
    public static final String DEFAULT_RESOURCE_URL = "";
    public static final String DEFAULT_TASK_ID = "";
    private static final long serialVersionUID = 0;
    public final String mresource_url;
    public final String mtask_id;

    public static final class Builder extends Message.Builder<PullTenantBuildResourceResponse, Builder> {
        public String mresource_url;
        public String mtask_id;

        @Override // com.squareup.wire.Message.Builder
        public PullTenantBuildResourceResponse build() {
            return new PullTenantBuildResourceResponse(this.mresource_url, this.mtask_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder resource_url(String r100) {
            this.mresource_url = r100;
            return this;
        }

        public Builder task_id(String r100) {
            this.mtask_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullTenantBuildResourceResponse extends ProtoAdapter<PullTenantBuildResourceResponse> {
        public ProtoAdapter_PullTenantBuildResourceResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullTenantBuildResourceResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullTenantBuildResourceResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mresource_url = "";
            r101.mtask_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mresource_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mtask_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PullTenantBuildResourceResponse r100) {
            String r101 = r100.mresource_url;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mtask_id;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullTenantBuildResourceResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullTenantBuildResourceResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullTenantBuildResourceResponse r101) throws IOException {
            String r102 = r101.mresource_url;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mtask_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullTenantBuildResourceResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullTenantBuildResourceResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mresource_url = this.mresource_url;
        r100.mtask_id = this.mtask_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullTenantBuildResourceResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullTenantBuildResourceResponse(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PullTenantBuildResourceResponse(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mresource_url = r100;
        this.mtask_id = r101;
    }
}
