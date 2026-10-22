package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class RichContent extends com.squareup.wire.Message<RichContent, Builder> {
    public static final ProtoAdapter<RichContent> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DocEntity doc_entity;
    public final List<String> fake_preview_ids;
    public final RichText rich_text;
    public final PreviewEntityPair url_preview_entities;
    public final Map<String, UrlPreviewHangPoint> url_preview_hang_points;

    public static final class Builder extends com.squareup.wire.Message.Builder<RichContent, Builder> {
        public DocEntity doc_entity;
        public List<String> fake_preview_ids;
        public RichText rich_text;
        public PreviewEntityPair url_preview_entities;
        public Map<String, UrlPreviewHangPoint> url_preview_hang_points;

        @Override // com.squareup.wire.Message.Builder
        public RichContent build() {
            return new RichContent(this.rich_text, this.doc_entity, this.url_preview_hang_points, this.url_preview_entities, this.fake_preview_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.url_preview_hang_points = Internal.newMutableMap();
            this.fake_preview_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder doc_entity(DocEntity r100) {
            this.doc_entity = r100;
            return this;
        }

        public Builder fake_preview_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.fake_preview_ids = r100;
            return this;
        }

        public Builder rich_text(RichText r100) {
            this.rich_text = r100;
            return this;
        }

        public Builder url_preview_entities(PreviewEntityPair r100) {
            this.url_preview_entities = r100;
            return this;
        }

        public Builder url_preview_hang_points(Map<String, UrlPreviewHangPoint> r100) {
            Internal.checkElementsNotNull(r100);
            this.url_preview_hang_points = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RichContent extends ProtoAdapter<RichContent> {
        private final ProtoAdapter<Map<String, UrlPreviewHangPoint>> url_preview_hang_points;

        public ProtoAdapter_RichContent() {
            super(FieldEncoding.LENGTH_DELIMITED, RichContent.class);
            this.url_preview_hang_points = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, UrlPreviewHangPoint.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RichContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.rich_text = RichText.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.doc_entity = DocEntity.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.url_preview_hang_points.putAll(this.url_preview_hang_points.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.url_preview_entities = PreviewEntityPair.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.fake_preview_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RichContent r100) {
            RichText r101 = r100.rich_text;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = RichText.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            DocEntity r104 = r100.doc_entity;
            if (r104 == null) goto L9;
            int r105 = DocEntity.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = (r103 + r105) + this.url_preview_hang_points.encodedSizeWithTag(3, r100.url_preview_hang_points);
            PreviewEntityPair r107 = r100.url_preview_entities;
            if (r107 == null) goto L14;
            r102 = PreviewEntityPair.ADAPTER.encodedSizeWithTag(4, r107);
        L14:
            return ((r106 + r102) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, r100.fake_preview_ids)) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RichContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RichContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RichContent r101) throws IOException {
            RichText r102 = r101.rich_text;
            if (r102 == null) goto L5;
            RichText.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            DocEntity r103 = r101.doc_entity;
            if (r103 == null) goto L8;
            DocEntity.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            this.url_preview_hang_points.encodeWithTag(r100, 3, r101.url_preview_hang_points);
            PreviewEntityPair r104 = r101.url_preview_entities;
            if (r104 == null) goto L11;
            PreviewEntityPair.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 5, r101.fake_preview_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RichContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RichContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.rich_text = this.rich_text;
        r100.doc_entity = this.doc_entity;
        r100.url_preview_hang_points = Internal.copyOf("url_preview_hang_points", this.url_preview_hang_points);
        r100.url_preview_entities = this.url_preview_entities;
        r100.fake_preview_ids = Internal.copyOf("fake_preview_ids", this.fake_preview_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RichContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public RichContent(RichText r100, DocEntity r101, Map<String, UrlPreviewHangPoint> r110, PreviewEntityPair r111, List<String> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public RichContent(RichText r100, DocEntity r101, Map<String, UrlPreviewHangPoint> r102, PreviewEntityPair r103, List<String> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.rich_text = r100;
        this.doc_entity = r101;
        this.url_preview_hang_points = Internal.immutableCopyOf("url_preview_hang_points", r102);
        this.url_preview_entities = r103;
        this.fake_preview_ids = Internal.immutableCopyOf("fake_preview_ids", r104);
    }
}
