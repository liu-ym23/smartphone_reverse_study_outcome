package com.bytedance.lark.pb.url.v1;

import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetTempPreviewByBatchResponse extends Message<GetTempPreviewByBatchResponse, Builder> {
    public static final ProtoAdapter<GetTempPreviewByBatchResponse> ADAPTER = null;
    public static final ProtoAdapter_GetTempPreviewByBatchResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, UrlPreviewEntity> preview_entitys;

    public static final class Builder extends Message.Builder<GetTempPreviewByBatchResponse, Builder> implements d<GetTempPreviewByBatchResponse> {
        public Map<String, UrlPreviewEntity> preview_entitys;

        @Override // com.squareup.wire.Message.Builder
        public GetTempPreviewByBatchResponse build() {
            return new GetTempPreviewByBatchResponse(this.preview_entitys, super.buildUnknownFields());
        }

        public Builder() {
            this.preview_entitys = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder preview_entitys(Map<String, UrlPreviewEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_entitys = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTempPreviewByBatchResponse extends ProtoAdapter<GetTempPreviewByBatchResponse> implements c<GetTempPreviewByBatchResponse> {
        private final ProtoAdapter<Map<String, UrlPreviewEntity>> preview_entitys;

        public ProtoAdapter_GetTempPreviewByBatchResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTempPreviewByBatchResponse.class);
            this.preview_entitys = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, UrlPreviewEntity.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTempPreviewByBatchResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.preview_entitys.putAll(this.preview_entitys.decode(r100));
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
        public int encodedSize2(GetTempPreviewByBatchResponse r100) {
            return this.preview_entitys.encodedSizeWithTag(1, r100.preview_entitys) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTempPreviewByBatchResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTempPreviewByBatchResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTempPreviewByBatchResponse r101) throws IOException {
            this.preview_entitys.encodeWithTag(r100, 1, r101.preview_entitys);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTempPreviewByBatchResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTempPreviewByBatchResponse r100 = new ProtoAdapter_GetTempPreviewByBatchResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_entitys = Internal.copyOf("preview_entitys", this.preview_entitys);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTempPreviewByBatchResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTempPreviewByBatchResponse(Map<String, UrlPreviewEntity> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetTempPreviewByBatchResponse(Map<String, UrlPreviewEntity> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.preview_entitys = Internal.immutableCopyOf("preview_entitys", r100);
    }
}
