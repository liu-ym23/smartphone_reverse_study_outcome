package com.bytedance.lark.pb.im.v1;

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
public final class GenerateUrlPreviewEntityRequest extends Message<GenerateUrlPreviewEntityRequest, Builder> {
    public static final ProtoAdapter<GenerateUrlPreviewEntityRequest> ADAPTER = null;
    public static final String DEFAULT_URL = "";
    public static final ProtoAdapter_GenerateUrlPreviewEntityRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String url;

    public static final class Builder extends Message.Builder<GenerateUrlPreviewEntityRequest, Builder> implements d<GenerateUrlPreviewEntityRequest> {
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public GenerateUrlPreviewEntityRequest build() {
            String r100 = this.url;
            if (r100 == null) goto L7;
            return new GenerateUrlPreviewEntityRequest(this.url, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "url"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GenerateUrlPreviewEntityRequest extends ProtoAdapter<GenerateUrlPreviewEntityRequest> implements c<GenerateUrlPreviewEntityRequest> {
        public ProtoAdapter_GenerateUrlPreviewEntityRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GenerateUrlPreviewEntityRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GenerateUrlPreviewEntityRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.url = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GenerateUrlPreviewEntityRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.url) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenerateUrlPreviewEntityRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GenerateUrlPreviewEntityRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GenerateUrlPreviewEntityRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.url);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GenerateUrlPreviewEntityRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GenerateUrlPreviewEntityRequest r100 = new ProtoAdapter_GenerateUrlPreviewEntityRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GenerateUrlPreviewEntityRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GenerateUrlPreviewEntityRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public GenerateUrlPreviewEntityRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.url = r100;
    }
}
