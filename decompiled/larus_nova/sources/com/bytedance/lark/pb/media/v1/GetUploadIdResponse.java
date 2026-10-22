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
public final class GetUploadIdResponse extends Message<GetUploadIdResponse, Builder> {
    public static final ProtoAdapter<GetUploadIdResponse> ADAPTER = null;
    public static final String DEFAULT_UPLOAD_ID = "";
    public static final ProtoAdapter_GetUploadIdResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String upload_id;

    public static final class Builder extends Message.Builder<GetUploadIdResponse, Builder> implements d<GetUploadIdResponse> {
        public String upload_id;

        @Override // com.squareup.wire.Message.Builder
        public GetUploadIdResponse build() {
            String r100 = this.upload_id;
            if (r100 == null) goto L7;
            return new GetUploadIdResponse(this.upload_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "upload_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder upload_id(String r100) {
            this.upload_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUploadIdResponse extends ProtoAdapter<GetUploadIdResponse> implements c<GetUploadIdResponse> {
        public ProtoAdapter_GetUploadIdResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUploadIdResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUploadIdResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.upload_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.upload_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetUploadIdResponse r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.upload_id) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUploadIdResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUploadIdResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUploadIdResponse r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.upload_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUploadIdResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUploadIdResponse r100 = new ProtoAdapter_GetUploadIdResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.upload_id = this.upload_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUploadIdResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUploadIdResponse(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetUploadIdResponse(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.upload_id = r100;
    }
}
