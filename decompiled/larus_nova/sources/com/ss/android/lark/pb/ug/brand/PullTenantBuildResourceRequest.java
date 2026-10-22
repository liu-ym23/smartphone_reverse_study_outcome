package com.ss.android.lark.pb.ug.brand;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullTenantBuildResourceRequest extends Message<PullTenantBuildResourceRequest, Builder> {
    public static final ProtoAdapter<PullTenantBuildResourceRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Platform mplatform;

    public static final class Builder extends Message.Builder<PullTenantBuildResourceRequest, Builder> {
        public Platform mplatform;

        @Override // com.squareup.wire.Message.Builder
        public PullTenantBuildResourceRequest build() {
            Platform r100 = this.mplatform;
            if (r100 == null) goto L7;
            return new PullTenantBuildResourceRequest(this.mplatform, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mplatform"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder platform(Platform r100) {
            this.mplatform = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullTenantBuildResourceRequest extends ProtoAdapter<PullTenantBuildResourceRequest> {
        public ProtoAdapter_PullTenantBuildResourceRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullTenantBuildResourceRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullTenantBuildResourceRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.mplatform = Platform.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullTenantBuildResourceRequest r100) {
            return Platform.ADAPTER.encodedSizeWithTag(1, r100.mplatform) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullTenantBuildResourceRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullTenantBuildResourceRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullTenantBuildResourceRequest r101) throws IOException {
            Platform.ADAPTER.encodeWithTag(r100, 1, r101.mplatform);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullTenantBuildResourceRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullTenantBuildResourceRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mplatform = this.mplatform;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullTenantBuildResourceRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullTenantBuildResourceRequest(Platform r100) {
        this(r100, ByteString.EMPTY);
    }

    public PullTenantBuildResourceRequest(Platform r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mplatform = r100;
    }
}
