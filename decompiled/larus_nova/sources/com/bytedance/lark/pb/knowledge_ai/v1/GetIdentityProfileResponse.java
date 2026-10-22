package com.bytedance.lark.pb.knowledge_ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetIdentityProfileResponse extends Message<GetIdentityProfileResponse, Builder> {
    public static final ProtoAdapter<GetIdentityProfileResponse> ADAPTER = null;
    public static final ProtoAdapter_GetIdentityProfileResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Identity identity;
    public final IdentityResource resource;

    public static final class Builder extends Message.Builder<GetIdentityProfileResponse, Builder> implements d<GetIdentityProfileResponse> {
        public Identity identity;
        public IdentityResource resource;

        @Override // com.squareup.wire.Message.Builder
        public GetIdentityProfileResponse build() {
            return new GetIdentityProfileResponse(this.identity, this.resource, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder identity(Identity r100) {
            this.identity = r100;
            return this;
        }

        public Builder resource(IdentityResource r100) {
            this.resource = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetIdentityProfileResponse extends ProtoAdapter<GetIdentityProfileResponse> implements c<GetIdentityProfileResponse> {
        public ProtoAdapter_GetIdentityProfileResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIdentityProfileResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetIdentityProfileResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.identity = Identity.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.resource = IdentityResource.ADAPTER.decode(r100);
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
        public int encodedSize2(GetIdentityProfileResponse r100) {
            Identity r101 = r100.identity;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Identity.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            IdentityResource r104 = r100.resource;
            if (r104 == null) goto L10;
            r102 = IdentityResource.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIdentityProfileResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetIdentityProfileResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetIdentityProfileResponse r101) throws IOException {
            Identity r102 = r101.identity;
            if (r102 == null) goto L5;
            Identity.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            IdentityResource r103 = r101.resource;
            if (r103 == null) goto L8;
            IdentityResource.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetIdentityProfileResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetIdentityProfileResponse r100 = new ProtoAdapter_GetIdentityProfileResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.identity = this.identity;
        r100.resource = this.resource;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetIdentityProfileResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetIdentityProfileResponse(Identity r100, IdentityResource r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetIdentityProfileResponse(Identity r100, IdentityResource r101, ByteString r102) {
        super(ADAPTER, r102);
        this.identity = r100;
        this.resource = r101;
    }
}
