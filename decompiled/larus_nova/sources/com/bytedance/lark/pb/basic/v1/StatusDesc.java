package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class StatusDesc extends com.squareup.wire.Message<StatusDesc, Builder> {
    public static final ProtoAdapter<StatusDesc> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final RichText rich_text;
    public final Map<String, PreviewHangPoint> url_hang_point_map;
    public final Map<String, UrlPreviewEntity> url_preview_entity_map;

    public static final class Builder extends com.squareup.wire.Message.Builder<StatusDesc, Builder> {
        public RichText rich_text;
        public Map<String, PreviewHangPoint> url_hang_point_map;
        public Map<String, UrlPreviewEntity> url_preview_entity_map;

        @Override // com.squareup.wire.Message.Builder
        public StatusDesc build() {
            return new StatusDesc(this.rich_text, this.url_hang_point_map, this.url_preview_entity_map, super.buildUnknownFields());
        }

        public Builder() {
            this.url_hang_point_map = Internal.newMutableMap();
            this.url_preview_entity_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder rich_text(RichText r100) {
            this.rich_text = r100;
            return this;
        }

        public Builder url_hang_point_map(Map<String, PreviewHangPoint> r100) {
            Internal.checkElementsNotNull(r100);
            this.url_hang_point_map = r100;
            return this;
        }

        public Builder url_preview_entity_map(Map<String, UrlPreviewEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.url_preview_entity_map = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_StatusDesc extends ProtoAdapter<StatusDesc> {
        private final ProtoAdapter<Map<String, PreviewHangPoint>> url_hang_point_map;
        private final ProtoAdapter<Map<String, UrlPreviewEntity>> url_preview_entity_map;

        public ProtoAdapter_StatusDesc() {
            super(FieldEncoding.LENGTH_DELIMITED, StatusDesc.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.url_hang_point_map = ProtoAdapter.newMapAdapter(r100, PreviewHangPoint.ADAPTER);
            this.url_preview_entity_map = ProtoAdapter.newMapAdapter(r100, UrlPreviewEntity.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public StatusDesc decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.rich_text = RichText.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.url_hang_point_map.putAll(this.url_hang_point_map.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.url_preview_entity_map.putAll(this.url_preview_entity_map.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(StatusDesc r100) {
            RichText r101 = r100.rich_text;
            if (r101 == null) goto L5;
            int r102 = RichText.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return ((r102 + this.url_hang_point_map.encodedSizeWithTag(2, r100.url_hang_point_map)) + this.url_preview_entity_map.encodedSizeWithTag(3, r100.url_preview_entity_map)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StatusDesc decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StatusDesc r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, StatusDesc r101) throws IOException {
            RichText r102 = r101.rich_text;
            if (r102 == null) goto L5;
            RichText.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            this.url_hang_point_map.encodeWithTag(r100, 2, r101.url_hang_point_map);
            this.url_preview_entity_map.encodeWithTag(r100, 3, r101.url_preview_entity_map);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StatusDesc r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StatusDesc();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.rich_text = this.rich_text;
        r100.url_hang_point_map = Internal.copyOf("url_hang_point_map", this.url_hang_point_map);
        r100.url_preview_entity_map = Internal.copyOf("url_preview_entity_map", this.url_preview_entity_map);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return StatusDesc.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public StatusDesc(RichText r100, Map<String, PreviewHangPoint> r101, Map<String, UrlPreviewEntity> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public StatusDesc(RichText r100, Map<String, PreviewHangPoint> r101, Map<String, UrlPreviewEntity> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.rich_text = r100;
        this.url_hang_point_map = Internal.immutableCopyOf("url_hang_point_map", r101);
        this.url_preview_entity_map = Internal.immutableCopyOf("url_preview_entity_map", r102);
    }
}
