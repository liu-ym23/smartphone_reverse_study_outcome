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
public final class UploadSecureImageResponse extends Message<UploadSecureImageResponse, Builder> {
    public static final ProtoAdapter<UploadSecureImageResponse> ADAPTER = null;
    public static final Integer DEFAULT_HEIGHT = null;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_WIDTH = null;
    public static final ProtoAdapter_UploadSecureImageResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer height;
    public final String token;
    public final Integer width;

    public static final class Builder extends Message.Builder<UploadSecureImageResponse, Builder> implements d<UploadSecureImageResponse> {
        public Integer height;
        public String token;
        public Integer width;

        @Override // com.squareup.wire.Message.Builder
        public UploadSecureImageResponse build() {
            return new UploadSecureImageResponse(this.token, this.width, this.height, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder height(Integer r100) {
            this.height = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder width(Integer r100) {
            this.width = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UploadSecureImageResponse extends ProtoAdapter<UploadSecureImageResponse> implements c<UploadSecureImageResponse> {
        public ProtoAdapter_UploadSecureImageResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadSecureImageResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadSecureImageResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.token = "";
            r101.width = 0;
            r101.height = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.width = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.height = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UploadSecureImageResponse r100) {
            String r101 = r100.token;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.width;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.height;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UploadSecureImageResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadSecureImageResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadSecureImageResponse r101) throws IOException {
            String r102 = r101.token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.width;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.height;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadSecureImageResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UploadSecureImageResponse r100 = new ProtoAdapter_UploadSecureImageResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.token = this.token;
        r100.width = this.width;
        r100.height = this.height;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadSecureImageResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadSecureImageResponse(String r100, Integer r101, Integer r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UploadSecureImageResponse(String r100, Integer r101, Integer r102, ByteString r103) {
        super(ADAPTER, r103);
        this.token = r100;
        this.width = r101;
        this.height = r102;
    }
}
