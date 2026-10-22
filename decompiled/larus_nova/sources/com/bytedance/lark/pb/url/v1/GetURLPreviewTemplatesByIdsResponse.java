package com.bytedance.lark.pb.url.v1;

import com.bytedance.lark.pb.basic.v1.URLPreviewTemplate;
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
public final class GetURLPreviewTemplatesByIdsResponse extends Message<GetURLPreviewTemplatesByIdsResponse, Builder> {
    public static final ProtoAdapter<GetURLPreviewTemplatesByIdsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetURLPreviewTemplatesByIdsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, URLPreviewTemplate> templates;

    public static final class Builder extends Message.Builder<GetURLPreviewTemplatesByIdsResponse, Builder> implements d<GetURLPreviewTemplatesByIdsResponse> {
        public Map<String, URLPreviewTemplate> templates;

        @Override // com.squareup.wire.Message.Builder
        public GetURLPreviewTemplatesByIdsResponse build() {
            return new GetURLPreviewTemplatesByIdsResponse(this.templates, super.buildUnknownFields());
        }

        public Builder() {
            this.templates = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder templates(Map<String, URLPreviewTemplate> r100) {
            Internal.checkElementsNotNull(r100);
            this.templates = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetURLPreviewTemplatesByIdsResponse extends ProtoAdapter<GetURLPreviewTemplatesByIdsResponse> implements c<GetURLPreviewTemplatesByIdsResponse> {
        private final ProtoAdapter<Map<String, URLPreviewTemplate>> templates;

        public ProtoAdapter_GetURLPreviewTemplatesByIdsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetURLPreviewTemplatesByIdsResponse.class);
            this.templates = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, URLPreviewTemplate.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetURLPreviewTemplatesByIdsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.templates.putAll(this.templates.decode(r100));
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
        public int encodedSize2(GetURLPreviewTemplatesByIdsResponse r100) {
            return this.templates.encodedSizeWithTag(1, r100.templates) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetURLPreviewTemplatesByIdsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetURLPreviewTemplatesByIdsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetURLPreviewTemplatesByIdsResponse r101) throws IOException {
            this.templates.encodeWithTag(r100, 1, r101.templates);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetURLPreviewTemplatesByIdsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetURLPreviewTemplatesByIdsResponse r100 = new ProtoAdapter_GetURLPreviewTemplatesByIdsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.templates = Internal.copyOf("templates", this.templates);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetURLPreviewTemplatesByIdsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetURLPreviewTemplatesByIdsResponse(Map<String, URLPreviewTemplate> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetURLPreviewTemplatesByIdsResponse(Map<String, URLPreviewTemplate> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.templates = Internal.immutableCopyOf("templates", r100);
    }
}
