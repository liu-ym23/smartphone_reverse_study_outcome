package com.bytedance.lark.pb.url.v1;

import com.bytedance.lark.pb.basic.v1.MessageLink;
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
public final class GetPreviewByHangPointsResponse extends Message<GetPreviewByHangPointsResponse, Builder> {
    public static final ProtoAdapter<GetPreviewByHangPointsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetPreviewByHangPointsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, MessageLink> message_links;
    public final Map<String, UrlPreviewEntity> preview_entity_map;

    public static final class Builder extends Message.Builder<GetPreviewByHangPointsResponse, Builder> implements d<GetPreviewByHangPointsResponse> {
        public Map<String, MessageLink> message_links;
        public Map<String, UrlPreviewEntity> preview_entity_map;

        @Override // com.squareup.wire.Message.Builder
        public GetPreviewByHangPointsResponse build() {
            return new GetPreviewByHangPointsResponse(this.preview_entity_map, this.message_links, super.buildUnknownFields());
        }

        public Builder() {
            this.preview_entity_map = Internal.newMutableMap();
            this.message_links = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_links(Map<String, MessageLink> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_links = r100;
            return this;
        }

        public Builder preview_entity_map(Map<String, UrlPreviewEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_entity_map = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPreviewByHangPointsResponse extends ProtoAdapter<GetPreviewByHangPointsResponse> implements c<GetPreviewByHangPointsResponse> {
        private final ProtoAdapter<Map<String, MessageLink>> message_links;
        private final ProtoAdapter<Map<String, UrlPreviewEntity>> preview_entity_map;

        public ProtoAdapter_GetPreviewByHangPointsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPreviewByHangPointsResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.preview_entity_map = ProtoAdapter.newMapAdapter(r100, UrlPreviewEntity.ADAPTER);
            this.message_links = ProtoAdapter.newMapAdapter(r100, MessageLink.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetPreviewByHangPointsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.preview_entity_map.putAll(this.preview_entity_map.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.message_links.putAll(this.message_links.decode(r100));
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
        public int encodedSize2(GetPreviewByHangPointsResponse r100) {
            return (this.preview_entity_map.encodedSizeWithTag(1, r100.preview_entity_map) + this.message_links.encodedSizeWithTag(2, r100.message_links)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetPreviewByHangPointsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPreviewByHangPointsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPreviewByHangPointsResponse r101) throws IOException {
            this.preview_entity_map.encodeWithTag(r100, 1, r101.preview_entity_map);
            this.message_links.encodeWithTag(r100, 2, r101.message_links);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPreviewByHangPointsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetPreviewByHangPointsResponse r100 = new ProtoAdapter_GetPreviewByHangPointsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_entity_map = Internal.copyOf("preview_entity_map", this.preview_entity_map);
        r100.message_links = Internal.copyOf("message_links", this.message_links);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPreviewByHangPointsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPreviewByHangPointsResponse(Map<String, UrlPreviewEntity> r100, Map<String, MessageLink> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetPreviewByHangPointsResponse(Map<String, UrlPreviewEntity> r100, Map<String, MessageLink> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.preview_entity_map = Internal.immutableCopyOf("preview_entity_map", r100);
        this.message_links = Internal.immutableCopyOf("message_links", r101);
    }
}
