package com.bytedance.lark.pb.url.v1;

import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
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
public final class GetTempPreviewResponse extends Message<GetTempPreviewResponse, Builder> {
    public static final ProtoAdapter<GetTempPreviewResponse> ADAPTER = null;
    public static final ProtoAdapter_GetTempPreviewResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final UrlPreviewEntity preview_entity;

    public static final class Builder extends Message.Builder<GetTempPreviewResponse, Builder> implements d<GetTempPreviewResponse> {
        public UrlPreviewEntity preview_entity;

        @Override // com.squareup.wire.Message.Builder
        public GetTempPreviewResponse build() {
            return new GetTempPreviewResponse(this.preview_entity, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder preview_entity(UrlPreviewEntity r100) {
            this.preview_entity = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTempPreviewResponse extends ProtoAdapter<GetTempPreviewResponse> implements c<GetTempPreviewResponse> {
        public ProtoAdapter_GetTempPreviewResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTempPreviewResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTempPreviewResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.preview_entity = UrlPreviewEntity.ADAPTER.decode(r100);
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
        public int encodedSize2(GetTempPreviewResponse r100) {
            UrlPreviewEntity r101 = r100.preview_entity;
            if (r101 == null) goto L5;
            int r102 = UrlPreviewEntity.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTempPreviewResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTempPreviewResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTempPreviewResponse r101) throws IOException {
            UrlPreviewEntity r102 = r101.preview_entity;
            if (r102 == null) goto L5;
            UrlPreviewEntity.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTempPreviewResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTempPreviewResponse r100 = new ProtoAdapter_GetTempPreviewResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_entity = this.preview_entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTempPreviewResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTempPreviewResponse(UrlPreviewEntity r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetTempPreviewResponse(UrlPreviewEntity r100, ByteString r101) {
        super(ADAPTER, r101);
        this.preview_entity = r100;
    }
}
