package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetNutStoreFilePreviewUrlResponse extends Message<GetNutStoreFilePreviewUrlResponse, Builder> {
    public static final ProtoAdapter<GetNutStoreFilePreviewUrlResponse> ADAPTER = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final com.bytedance.lark.pb.basic.v1.Message.SourceType DEFAULT_SOURCE_TYPE = null;
    public static final String DEFAULT_URL = "";
    public static final ProtoAdapter_GetNutStoreFilePreviewUrlResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String source_id;
    public final com.bytedance.lark.pb.basic.v1.Message.SourceType source_type;
    public final String url;

    public static final class Builder extends Message.Builder<GetNutStoreFilePreviewUrlResponse, Builder> implements d<GetNutStoreFilePreviewUrlResponse> {
        public String source_id;
        public com.bytedance.lark.pb.basic.v1.Message.SourceType source_type;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public GetNutStoreFilePreviewUrlResponse build() {
            String r100 = this.url;
            if (r100 == null) goto L7;
            return new GetNutStoreFilePreviewUrlResponse(this.url, this.source_id, this.source_type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "url"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder source_type(com.bytedance.lark.pb.basic.v1.Message.SourceType r100) {
            this.source_type = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetNutStoreFilePreviewUrlResponse extends ProtoAdapter<GetNutStoreFilePreviewUrlResponse> implements c<GetNutStoreFilePreviewUrlResponse> {
        public ProtoAdapter_GetNutStoreFilePreviewUrlResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetNutStoreFilePreviewUrlResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetNutStoreFilePreviewUrlResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.url = "";
            r101.source_id = "";
            r101.source_type = com.bytedance.lark.pb.basic.v1.Message.SourceType.TYPE_FROM_UNKONWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.source_type = com.bytedance.lark.pb.basic.v1.Message.SourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetNutStoreFilePreviewUrlResponse r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.url);
            String r103 = r100.source_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            com.bytedance.lark.pb.basic.v1.Message.SourceType r107 = r100.source_type;
            if (r107 == null) goto L10;
            r104 = com.bytedance.lark.pb.basic.v1.Message.SourceType.ADAPTER.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetNutStoreFilePreviewUrlResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetNutStoreFilePreviewUrlResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetNutStoreFilePreviewUrlResponse r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.url);
            String r103 = r101.source_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            com.bytedance.lark.pb.basic.v1.Message.SourceType r104 = r101.source_type;
            if (r104 == null) goto L8;
            com.bytedance.lark.pb.basic.v1.Message.SourceType.ADAPTER.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetNutStoreFilePreviewUrlResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetNutStoreFilePreviewUrlResponse r100 = new ProtoAdapter_GetNutStoreFilePreviewUrlResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SOURCE_TYPE = com.bytedance.lark.pb.basic.v1.Message.SourceType.TYPE_FROM_UNKONWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.source_id = this.source_id;
        r100.source_type = this.source_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetNutStoreFilePreviewUrlResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetNutStoreFilePreviewUrlResponse(String r100, String r101, com.bytedance.lark.pb.basic.v1.Message.SourceType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetNutStoreFilePreviewUrlResponse(String r100, String r101, com.bytedance.lark.pb.basic.v1.Message.SourceType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.url = r100;
        this.source_id = r101;
        this.source_type = r102;
    }
}
