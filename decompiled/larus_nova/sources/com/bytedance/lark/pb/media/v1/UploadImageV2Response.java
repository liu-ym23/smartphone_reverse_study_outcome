package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UploadImageV2Response extends Message<UploadImageV2Response, Builder> {
    public static final ProtoAdapter<UploadImageV2Response> ADAPTER = null;
    public static final String DEFAULT_IMAGE_KEY = "";
    public static final ProtoAdapter_UploadImageV2Response RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String image_key;

    public static final class Builder extends Message.Builder<UploadImageV2Response, Builder> implements d<UploadImageV2Response> {
        public String image_key;

        @Override // com.squareup.wire.Message.Builder
        public UploadImageV2Response build() {
            return new UploadImageV2Response(this.image_key, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder image_key(String r100) {
            this.image_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UploadImageV2Response extends ProtoAdapter<UploadImageV2Response> implements c<UploadImageV2Response> {
        public ProtoAdapter_UploadImageV2Response() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadImageV2Response.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadImageV2Response decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.image_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.image_key = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UploadImageV2Response r100) {
            String r101 = r100.image_key;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UploadImageV2Response decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadImageV2Response r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadImageV2Response r101) throws IOException {
            String r102 = r101.image_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadImageV2Response r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UploadImageV2Response r100 = new ProtoAdapter_UploadImageV2Response();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.image_key = this.image_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadImageV2Response.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadImageV2Response(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public UploadImageV2Response(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.image_key = r100;
    }
}
