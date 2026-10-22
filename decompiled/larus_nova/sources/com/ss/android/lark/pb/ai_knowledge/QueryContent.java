package com.ss.android.lark.pb.ai_knowledge;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.ai_topic_stream_search.Resource;
import com.ss.android.lark.pb.entities.RichText;
import com.ss.android.lark.pb.entities.UrlPreviewHangPoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class QueryContent extends Message<QueryContent, Builder> {
    public static final ProtoAdapter<QueryContent> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_QUOTE_BLOCK = "";
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final Map<String, UrlPreviewHangPoint> mlink_preview_hang_points;
    public final Map<String, LinkPreviewInfo> mlink_preview_infos;
    public final String mquote_block;
    public final List<Resource> mresources;
    public final RichText mrich_text;

    public static final class Builder extends Message.Builder<QueryContent, Builder> {
        public String mcontent;
        public Map<String, UrlPreviewHangPoint> mlink_preview_hang_points;
        public Map<String, LinkPreviewInfo> mlink_preview_infos;
        public String mquote_block;
        public List<Resource> mresources;
        public RichText mrich_text;

        @Override // com.squareup.wire.Message.Builder
        public QueryContent build() {
            return new QueryContent(this.mcontent, this.mresources, this.mlink_preview_infos, this.mlink_preview_hang_points, this.mrich_text, this.mquote_block, super.buildUnknownFields());
        }

        public Builder() {
            this.mresources = Internal.newMutableList();
            this.mlink_preview_infos = Internal.newMutableMap();
            this.mlink_preview_hang_points = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.mcontent = r100;
            return this;
        }

        public Builder link_preview_hang_points(Map<String, UrlPreviewHangPoint> r100) {
            Internal.checkElementsNotNull(r100);
            this.mlink_preview_hang_points = r100;
            return this;
        }

        public Builder link_preview_infos(Map<String, LinkPreviewInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mlink_preview_infos = r100;
            return this;
        }

        public Builder quote_block(String r100) {
            this.mquote_block = r100;
            return this;
        }

        public Builder resources(List<Resource> r100) {
            Internal.checkElementsNotNull(r100);
            this.mresources = r100;
            return this;
        }

        public Builder rich_text(RichText r100) {
            this.mrich_text = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_QueryContent extends ProtoAdapter<QueryContent> {
        private final ProtoAdapter<Map<String, UrlPreviewHangPoint>> mlink_preview_hang_points;
        private final ProtoAdapter<Map<String, LinkPreviewInfo>> mlink_preview_infos;

        public ProtoAdapter_QueryContent() {
            super(FieldEncoding.LENGTH_DELIMITED, QueryContent.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mlink_preview_infos = ProtoAdapter.newMapAdapter(r100, LinkPreviewInfo.ADAPTER);
            this.mlink_preview_hang_points = ProtoAdapter.newMapAdapter(r100, UrlPreviewHangPoint.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public QueryContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcontent = "";
            r101.mquote_block = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.mquote_block = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mrich_text = RichText.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.mlink_preview_hang_points.putAll(this.mlink_preview_hang_points.decode(r100));
            goto L3
        L10:
            r101.mlink_preview_infos.putAll(this.mlink_preview_infos.decode(r100));
            goto L3
        L11:
            r101.mresources.add(Resource.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.mcontent = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(QueryContent r100) {
            String r101 = r100.mcontent;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = ((r103 + Resource.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mresources)) + this.mlink_preview_infos.encodedSizeWithTag(3, r100.mlink_preview_infos)) + this.mlink_preview_hang_points.encodedSizeWithTag(4, r100.mlink_preview_hang_points);
            RichText r105 = r100.mrich_text;
            if (r105 == null) goto L9;
            int r106 = RichText.ADAPTER.encodedSizeWithTag(5, r105);
        L10:
            int r107 = r104 + r106;
            String r108 = r100.mquote_block;
            if (r108 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(6, r108);
        L14:
            return (r107 + r102) + r100.unknownFields().size();
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ QueryContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(QueryContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, QueryContent r101) throws IOException {
            String r102 = r101.mcontent;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Resource.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mresources);
            this.mlink_preview_infos.encodeWithTag(r100, 3, r101.mlink_preview_infos);
            this.mlink_preview_hang_points.encodeWithTag(r100, 4, r101.mlink_preview_hang_points);
            RichText r103 = r101.mrich_text;
            if (r103 == null) goto L8;
            RichText.ADAPTER.encodeWithTag(r100, 5, r103);
        L8:
            String r104 = r101.mquote_block;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QueryContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QueryContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcontent = this.mcontent;
        r100.mresources = Internal.copyOf("mresources", this.mresources);
        r100.mlink_preview_infos = Internal.copyOf("mlink_preview_infos", this.mlink_preview_infos);
        r100.mlink_preview_hang_points = Internal.copyOf("mlink_preview_hang_points", this.mlink_preview_hang_points);
        r100.mrich_text = this.mrich_text;
        r100.mquote_block = this.mquote_block;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return QueryContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public QueryContent(String r100, List<Resource> r110, Map<String, LinkPreviewInfo> r111, Map<String, UrlPreviewHangPoint> r112, RichText r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public QueryContent(String r100, List<Resource> r101, Map<String, LinkPreviewInfo> r102, Map<String, UrlPreviewHangPoint> r103, RichText r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mcontent = r100;
        this.mresources = Internal.immutableCopyOf("mresources", r101);
        this.mlink_preview_infos = Internal.immutableCopyOf("mlink_preview_infos", r102);
        this.mlink_preview_hang_points = Internal.immutableCopyOf("mlink_preview_hang_points", r103);
        this.mrich_text = r104;
        this.mquote_block = r105;
    }
}
