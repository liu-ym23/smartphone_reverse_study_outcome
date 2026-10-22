package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.URLPreviewTemplate;
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
public final class GenerateUrlPreviewEntityResponse extends Message<GenerateUrlPreviewEntityResponse, Builder> {
    public static final ProtoAdapter<GenerateUrlPreviewEntityResponse> ADAPTER = null;
    public static final ProtoAdapter_GenerateUrlPreviewEntityResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final UrlPreviewEntity preview_entity;
    public final Map<String, URLPreviewTemplate> templates;

    public static final class Builder extends Message.Builder<GenerateUrlPreviewEntityResponse, Builder> implements d<GenerateUrlPreviewEntityResponse> {
        public UrlPreviewEntity preview_entity;
        public Map<String, URLPreviewTemplate> templates;

        @Override // com.squareup.wire.Message.Builder
        public GenerateUrlPreviewEntityResponse build() {
            return new GenerateUrlPreviewEntityResponse(this.preview_entity, this.templates, super.buildUnknownFields());
        }

        public Builder() {
            this.templates = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder preview_entity(UrlPreviewEntity r100) {
            this.preview_entity = r100;
            return this;
        }

        public Builder templates(Map<String, URLPreviewTemplate> r100) {
            Internal.checkElementsNotNull(r100);
            this.templates = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GenerateUrlPreviewEntityResponse extends ProtoAdapter<GenerateUrlPreviewEntityResponse> implements c<GenerateUrlPreviewEntityResponse> {
        private final ProtoAdapter<Map<String, URLPreviewTemplate>> templates;

        public ProtoAdapter_GenerateUrlPreviewEntityResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GenerateUrlPreviewEntityResponse.class);
            this.templates = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, URLPreviewTemplate.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GenerateUrlPreviewEntityResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.preview_entity = UrlPreviewEntity.ADAPTER.decode(r100);
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
        public int encodedSize2(GenerateUrlPreviewEntityResponse r100) {
            UrlPreviewEntity r101 = r100.preview_entity;
            if (r101 == null) goto L5;
            int r102 = UrlPreviewEntity.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + this.templates.encodedSizeWithTag(2, r100.templates)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenerateUrlPreviewEntityResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GenerateUrlPreviewEntityResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GenerateUrlPreviewEntityResponse r101) throws IOException {
            UrlPreviewEntity r102 = r101.preview_entity;
            if (r102 == null) goto L5;
            UrlPreviewEntity.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            this.templates.encodeWithTag(r100, 2, r101.templates);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GenerateUrlPreviewEntityResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GenerateUrlPreviewEntityResponse r100 = new ProtoAdapter_GenerateUrlPreviewEntityResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_entity = this.preview_entity;
        r100.templates = Internal.copyOf("templates", this.templates);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GenerateUrlPreviewEntityResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GenerateUrlPreviewEntityResponse(UrlPreviewEntity r100, Map<String, URLPreviewTemplate> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GenerateUrlPreviewEntityResponse(UrlPreviewEntity r100, Map<String, URLPreviewTemplate> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.preview_entity = r100;
        this.templates = Internal.immutableCopyOf("templates", r101);
    }
}
