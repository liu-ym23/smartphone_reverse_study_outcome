package com.bytedance.lark.pb.url.v1;

import com.bytedance.lark.pb.basic.v1.URLPreviewTemplate;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUrlPreviewResponse extends Message<GetUrlPreviewResponse, Builder> {
    public static final ProtoAdapter<GetUrlPreviewResponse> ADAPTER = null;
    public static final Long DEFAULT_PRIVATE_DESCRIPTION_ID = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final String DEFAULT_SOURCE_TEXT_MD5 = "";
    public static final UrlPreviewSourceType DEFAULT_SOURCE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final List<UrlPreviewEntry> preview_entries;
    public final Long private_description_id;
    public final String source_id;
    public final String source_text_md5;
    public final UrlPreviewSourceType source_type;
    public final Map<String, URLPreviewTemplate> templates;

    public static final class Builder extends Message.Builder<GetUrlPreviewResponse, Builder> {
        public List<UrlPreviewEntry> preview_entries;
        public Long private_description_id;
        public String source_id;
        public String source_text_md5;
        public UrlPreviewSourceType source_type;
        public Map<String, URLPreviewTemplate> templates;

        @Override // com.squareup.wire.Message.Builder
        public GetUrlPreviewResponse build() {
            return new GetUrlPreviewResponse(this.source_id, this.source_type, this.source_text_md5, this.preview_entries, this.templates, this.private_description_id, super.buildUnknownFields());
        }

        public Builder() {
            this.preview_entries = Internal.newMutableList();
            this.templates = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder preview_entries(List<UrlPreviewEntry> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_entries = r100;
            return this;
        }

        public Builder private_description_id(Long r100) {
            this.private_description_id = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder source_text_md5(String r100) {
            this.source_text_md5 = r100;
            return this;
        }

        public Builder source_type(UrlPreviewSourceType r100) {
            this.source_type = r100;
            return this;
        }

        public Builder templates(Map<String, URLPreviewTemplate> r100) {
            Internal.checkElementsNotNull(r100);
            this.templates = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUrlPreviewResponse extends ProtoAdapter<GetUrlPreviewResponse> {
        private final ProtoAdapter<Map<String, URLPreviewTemplate>> templates;

        public ProtoAdapter_GetUrlPreviewResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUrlPreviewResponse.class);
            this.templates = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, URLPreviewTemplate.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUrlPreviewResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_id = "";
            r101.source_type = UrlPreviewSourceType.CHAT_ANNOUNCEMENT;
            r101.source_text_md5 = "";
            r101.private_description_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L18;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.source_type = UrlPreviewSourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.private_description_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.templates.putAll(this.templates.decode(r100));
            goto L3
        L9:
            r101.preview_entries.add(UrlPreviewEntry.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.source_text_md5 = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUrlPreviewResponse r100) {
            String r101 = r100.source_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            UrlPreviewSourceType r104 = r100.source_type;
            if (r104 == null) goto L9;
            int r105 = UrlPreviewSourceType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.source_text_md5;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = ((r106 + r108) + UrlPreviewEntry.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.preview_entries)) + this.templates.encodedSizeWithTag(5, r100.templates);
            Long r110 = r100.private_description_id;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(6, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUrlPreviewResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUrlPreviewResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUrlPreviewResponse r101) throws IOException {
            String r102 = r101.source_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            UrlPreviewSourceType r103 = r101.source_type;
            if (r103 == null) goto L8;
            UrlPreviewSourceType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.source_text_md5;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            UrlPreviewEntry.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.preview_entries);
            this.templates.encodeWithTag(r100, 5, r101.templates);
            Long r105 = r101.private_description_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUrlPreviewResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetUrlPreviewResponse();
        DEFAULT_SOURCE_TYPE = UrlPreviewSourceType.CHAT_ANNOUNCEMENT;
        DEFAULT_PRIVATE_DESCRIPTION_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_id = this.source_id;
        r100.source_type = this.source_type;
        r100.source_text_md5 = this.source_text_md5;
        r100.preview_entries = Internal.copyOf("preview_entries", this.preview_entries);
        r100.templates = Internal.copyOf("templates", this.templates);
        r100.private_description_id = this.private_description_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUrlPreviewResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUrlPreviewResponse(String r100, UrlPreviewSourceType r110, String r111, List<UrlPreviewEntry> r112, Map<String, URLPreviewTemplate> r113, Long r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public GetUrlPreviewResponse(String r100, UrlPreviewSourceType r101, String r102, List<UrlPreviewEntry> r103, Map<String, URLPreviewTemplate> r104, Long r105, ByteString r106) {
        super(ADAPTER, r106);
        this.source_id = r100;
        this.source_type = r101;
        this.source_text_md5 = r102;
        this.preview_entries = Internal.immutableCopyOf("preview_entries", r103);
        this.templates = Internal.immutableCopyOf("templates", r104);
        this.private_description_id = r105;
    }
}
