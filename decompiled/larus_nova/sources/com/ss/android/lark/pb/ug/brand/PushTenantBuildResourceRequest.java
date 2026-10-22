package com.ss.android.lark.pb.ug.brand;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PushTenantBuildResourceRequest extends Message<PushTenantBuildResourceRequest, Builder> {
    public static final ProtoAdapter<PushTenantBuildResourceRequest> ADAPTER = null;
    public static final String DEFAULT_TENANT_ID = "";
    private static final long serialVersionUID = 0;
    public final List<BuildResource> mbuild_resources;
    public final String mtenant_id;

    public static final class Builder extends Message.Builder<PushTenantBuildResourceRequest, Builder> {
        public List<BuildResource> mbuild_resources;
        public String mtenant_id;

        @Override // com.squareup.wire.Message.Builder
        public PushTenantBuildResourceRequest build() {
            String r100 = this.mtenant_id;
            if (r100 == null) goto L7;
            return new PushTenantBuildResourceRequest(this.mtenant_id, this.mbuild_resources, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mtenant_id"});
        }

        public Builder() {
            this.mbuild_resources = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder build_resources(List<BuildResource> r100) {
            Internal.checkElementsNotNull(r100);
            this.mbuild_resources = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.mtenant_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushTenantBuildResourceRequest extends ProtoAdapter<PushTenantBuildResourceRequest> {
        public ProtoAdapter_PushTenantBuildResourceRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PushTenantBuildResourceRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushTenantBuildResourceRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtenant_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mtenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mbuild_resources.add(BuildResource.ADAPTER.decode(r100));
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
        public int encodedSize2(PushTenantBuildResourceRequest r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mtenant_id) + BuildResource.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mbuild_resources)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushTenantBuildResourceRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushTenantBuildResourceRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushTenantBuildResourceRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mtenant_id);
            BuildResource.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mbuild_resources);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushTenantBuildResourceRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PushTenantBuildResourceRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtenant_id = this.mtenant_id;
        r100.mbuild_resources = Internal.copyOf("mbuild_resources", this.mbuild_resources);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushTenantBuildResourceRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushTenantBuildResourceRequest(String r100, List<BuildResource> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PushTenantBuildResourceRequest(String r100, List<BuildResource> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mtenant_id = r100;
        this.mbuild_resources = Internal.immutableCopyOf("mbuild_resources", r101);
    }
}
