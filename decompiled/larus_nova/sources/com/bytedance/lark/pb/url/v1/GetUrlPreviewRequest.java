package com.bytedance.lark.pb.url.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUrlPreviewRequest extends Message<GetUrlPreviewRequest, Builder> {
    public static final ProtoAdapter<GetUrlPreviewRequest> ADAPTER = null;
    public static final Long DEFAULT_PRIVATE_DESCRIPTION_ID = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final String DEFAULT_SOURCE_TEXT_MD5 = "";
    public static final UrlPreviewSourceType DEFAULT_SOURCE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Long private_description_id;
    public final String source_id;
    public final String source_text_md5;
    public final UrlPreviewSourceType source_type;

    public static final class Builder extends Message.Builder<GetUrlPreviewRequest, Builder> {
        public Long private_description_id;
        public String source_id;
        public String source_text_md5;
        public UrlPreviewSourceType source_type;

        @Override // com.squareup.wire.Message.Builder
        public GetUrlPreviewRequest build() {
            return new GetUrlPreviewRequest(this.source_id, this.source_type, this.source_text_md5, this.private_description_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
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
    }

    public static final class ProtoAdapter_GetUrlPreviewRequest extends ProtoAdapter<GetUrlPreviewRequest> {
        public ProtoAdapter_GetUrlPreviewRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUrlPreviewRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUrlPreviewRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_id = "";
            r101.source_type = UrlPreviewSourceType.CHAT_ANNOUNCEMENT;
            r101.source_text_md5 = "";
            r101.private_description_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.source_type = UrlPreviewSourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.source_text_md5 = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.private_description_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUrlPreviewRequest r100) {
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
            int r109 = r106 + r108;
            Long r110 = r100.private_description_id;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ GetUrlPreviewRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUrlPreviewRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUrlPreviewRequest r101) throws IOException {
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
            Long r105 = r101.private_description_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUrlPreviewRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetUrlPreviewRequest();
        DEFAULT_SOURCE_TYPE = UrlPreviewSourceType.CHAT_ANNOUNCEMENT;
        DEFAULT_PRIVATE_DESCRIPTION_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_id = this.source_id;
        r100.source_type = this.source_type;
        r100.source_text_md5 = this.source_text_md5;
        r100.private_description_id = this.private_description_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUrlPreviewRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUrlPreviewRequest(String r100, UrlPreviewSourceType r101, String r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetUrlPreviewRequest(String r100, UrlPreviewSourceType r101, String r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.source_id = r100;
        this.source_type = r101;
        this.source_text_md5 = r102;
        this.private_description_id = r103;
    }
}
