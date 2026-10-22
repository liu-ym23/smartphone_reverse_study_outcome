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
public final class GetInlinePreviewResponse extends Message<GetInlinePreviewResponse, Builder> {
    public static final ProtoAdapter<GetInlinePreviewResponse> ADAPTER = null;
    public static final ProtoAdapter_GetInlinePreviewResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, UrlPreviewEntity> preview_entity_map;

    public static final class Builder extends Message.Builder<GetInlinePreviewResponse, Builder> implements d<GetInlinePreviewResponse> {
        public Map<String, UrlPreviewEntity> preview_entity_map;

        @Override // com.squareup.wire.Message.Builder
        public GetInlinePreviewResponse build() {
            return new GetInlinePreviewResponse(this.preview_entity_map, super.buildUnknownFields());
        }

        public Builder() {
            this.preview_entity_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder preview_entity_map(Map<String, UrlPreviewEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_entity_map = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetInlinePreviewResponse extends ProtoAdapter<GetInlinePreviewResponse> implements c<GetInlinePreviewResponse> {
        private final ProtoAdapter<Map<String, UrlPreviewEntity>> preview_entity_map;

        public ProtoAdapter_GetInlinePreviewResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetInlinePreviewResponse.class);
            this.preview_entity_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, UrlPreviewEntity.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetInlinePreviewResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.preview_entity_map.putAll(this.preview_entity_map.decode(r100));
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
        public int encodedSize2(GetInlinePreviewResponse r100) {
            return this.preview_entity_map.encodedSizeWithTag(1, r100.preview_entity_map) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetInlinePreviewResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetInlinePreviewResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetInlinePreviewResponse r101) throws IOException {
            this.preview_entity_map.encodeWithTag(r100, 1, r101.preview_entity_map);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetInlinePreviewResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetInlinePreviewResponse r100 = new ProtoAdapter_GetInlinePreviewResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_entity_map = Internal.copyOf("preview_entity_map", this.preview_entity_map);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetInlinePreviewResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetInlinePreviewResponse(Map<String, UrlPreviewEntity> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetInlinePreviewResponse(Map<String, UrlPreviewEntity> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.preview_entity_map = Internal.immutableCopyOf("preview_entity_map", r100);
    }
}
