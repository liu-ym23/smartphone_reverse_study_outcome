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
public final class GetResourcesSizeResponse extends Message<GetResourcesSizeResponse, Builder> {
    public static final ProtoAdapter<GetResourcesSizeResponse> ADAPTER = null;
    public static final Float DEFAULT_SIZE_M = null;
    public static final ProtoAdapter_GetResourcesSizeResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Float size_m;

    public static final class Builder extends Message.Builder<GetResourcesSizeResponse, Builder> implements d<GetResourcesSizeResponse> {
        public Float size_m;

        @Override // com.squareup.wire.Message.Builder
        public GetResourcesSizeResponse build() {
            Float r100 = this.size_m;
            if (r100 == null) goto L7;
            return new GetResourcesSizeResponse(this.size_m, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "size_m"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder size_m(Float r100) {
            this.size_m = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetResourcesSizeResponse extends ProtoAdapter<GetResourcesSizeResponse> implements c<GetResourcesSizeResponse> {
        public ProtoAdapter_GetResourcesSizeResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetResourcesSizeResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetResourcesSizeResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.size_m = Float.valueOf(0.0f);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.size_m = ProtoAdapter.FLOAT.decode(r100);
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
        public int encodedSize2(GetResourcesSizeResponse r100) {
            return ProtoAdapter.FLOAT.encodedSizeWithTag(1, r100.size_m) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetResourcesSizeResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetResourcesSizeResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetResourcesSizeResponse r101) throws IOException {
            ProtoAdapter.FLOAT.encodeWithTag(r100, 1, r101.size_m);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetResourcesSizeResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetResourcesSizeResponse r100 = new ProtoAdapter_GetResourcesSizeResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SIZE_M = Float.valueOf(0.0f);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.size_m = this.size_m;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetResourcesSizeResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetResourcesSizeResponse(Float r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetResourcesSizeResponse(Float r100, ByteString r101) {
        super(ADAPTER, r101);
        this.size_m = r100;
    }
}
