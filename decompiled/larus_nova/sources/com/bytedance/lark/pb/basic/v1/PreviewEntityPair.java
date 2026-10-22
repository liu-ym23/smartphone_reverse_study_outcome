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
public final class PreviewEntityPair extends com.squareup.wire.Message<PreviewEntityPair, Builder> {
    public static final ProtoAdapter<PreviewEntityPair> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, UrlPreviewEntity> preview_entity;
    public final Map<String, URLPreviewTemplate> templates;

    public static final class Builder extends com.squareup.wire.Message.Builder<PreviewEntityPair, Builder> {
        public Map<String, UrlPreviewEntity> preview_entity;
        public Map<String, URLPreviewTemplate> templates;

        @Override // com.squareup.wire.Message.Builder
        public PreviewEntityPair build() {
            return new PreviewEntityPair(this.preview_entity, this.templates, super.buildUnknownFields());
        }

        public Builder() {
            this.preview_entity = Internal.newMutableMap();
            this.templates = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder preview_entity(Map<String, UrlPreviewEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_entity = r100;
            return this;
        }

        public Builder templates(Map<String, URLPreviewTemplate> r100) {
            Internal.checkElementsNotNull(r100);
            this.templates = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PreviewEntityPair extends ProtoAdapter<PreviewEntityPair> {
        private final ProtoAdapter<Map<String, UrlPreviewEntity>> preview_entity;
        private final ProtoAdapter<Map<String, URLPreviewTemplate>> templates;

        public ProtoAdapter_PreviewEntityPair() {
            super(FieldEncoding.LENGTH_DELIMITED, PreviewEntityPair.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.preview_entity = ProtoAdapter.newMapAdapter(r100, UrlPreviewEntity.ADAPTER);
            this.templates = ProtoAdapter.newMapAdapter(r100, URLPreviewTemplate.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PreviewEntityPair decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.preview_entity.putAll(this.preview_entity.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.templates.putAll(this.templates.decode(r100));
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
        public int encodedSize2(PreviewEntityPair r100) {
            return (this.preview_entity.encodedSizeWithTag(1, r100.preview_entity) + this.templates.encodedSizeWithTag(2, r100.templates)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PreviewEntityPair decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PreviewEntityPair r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PreviewEntityPair r101) throws IOException {
            this.preview_entity.encodeWithTag(r100, 1, r101.preview_entity);
            this.templates.encodeWithTag(r100, 2, r101.templates);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PreviewEntityPair r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PreviewEntityPair();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_entity = Internal.copyOf("preview_entity", this.preview_entity);
        r100.templates = Internal.copyOf("templates", this.templates);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PreviewEntityPair.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public PreviewEntityPair(Map<String, UrlPreviewEntity> r100, Map<String, URLPreviewTemplate> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PreviewEntityPair(Map<String, UrlPreviewEntity> r100, Map<String, URLPreviewTemplate> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.preview_entity = Internal.immutableCopyOf("preview_entity", r100);
        this.templates = Internal.immutableCopyOf("templates", r101);
    }
}
