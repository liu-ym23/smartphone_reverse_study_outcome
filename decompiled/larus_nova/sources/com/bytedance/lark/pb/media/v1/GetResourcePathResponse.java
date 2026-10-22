package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetResourcePathResponse extends Message<GetResourcePathResponse, Builder> {
    public static final ProtoAdapter<GetResourcePathResponse> ADAPTER = null;
    public static final ProtoAdapter_GetResourcePathResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final LocalResource resource;

    public static final class Builder extends Message.Builder<GetResourcePathResponse, Builder> implements d<GetResourcePathResponse> {
        public LocalResource resource;

        @Override // com.squareup.wire.Message.Builder
        public GetResourcePathResponse build() {
            LocalResource r100 = this.resource;
            if (r100 == null) goto L7;
            return new GetResourcePathResponse(this.resource, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "resource"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder resource(LocalResource r100) {
            this.resource = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetResourcePathResponse extends ProtoAdapter<GetResourcePathResponse> implements c<GetResourcePathResponse> {
        public ProtoAdapter_GetResourcePathResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetResourcePathResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetResourcePathResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.resource = LocalResource.ADAPTER.decode(r100);
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
        public int encodedSize2(GetResourcePathResponse r100) {
            return LocalResource.ADAPTER.encodedSizeWithTag(1, r100.resource) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetResourcePathResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetResourcePathResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetResourcePathResponse r101) throws IOException {
            LocalResource.ADAPTER.encodeWithTag(r100, 1, r101.resource);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetResourcePathResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetResourcePathResponse r100 = new ProtoAdapter_GetResourcePathResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.resource = this.resource;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetResourcePathResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetResourcePathResponse(LocalResource r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetResourcePathResponse(LocalResource r100, ByteString r101) {
        super(ADAPTER, r101);
        this.resource = r100;
    }
}
