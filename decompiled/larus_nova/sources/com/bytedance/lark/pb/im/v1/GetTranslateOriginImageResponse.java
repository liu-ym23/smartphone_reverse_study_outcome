package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.RichTextElement;
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
public final class GetTranslateOriginImageResponse extends Message<GetTranslateOriginImageResponse, Builder> {
    public static final ProtoAdapter<GetTranslateOriginImageResponse> ADAPTER = null;
    public static final String DEFAULT_ORIGIN_IMAGE_KEY = "";
    public static final ProtoAdapter_GetTranslateOriginImageResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String origin_image_key;
    public final RichTextElement.ImageProperty origin_image_property;
    public final ImageSet origin_image_set;

    public static final class Builder extends Message.Builder<GetTranslateOriginImageResponse, Builder> implements d<GetTranslateOriginImageResponse> {
        public String origin_image_key;
        public RichTextElement.ImageProperty origin_image_property;
        public ImageSet origin_image_set;

        @Override // com.squareup.wire.Message.Builder
        public GetTranslateOriginImageResponse build() {
            return new GetTranslateOriginImageResponse(this.origin_image_key, this.origin_image_set, this.origin_image_property, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder origin_image_key(String r100) {
            this.origin_image_key = r100;
            return this;
        }

        public Builder origin_image_property(RichTextElement.ImageProperty r100) {
            this.origin_image_property = r100;
            return this;
        }

        public Builder origin_image_set(ImageSet r100) {
            this.origin_image_set = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTranslateOriginImageResponse extends ProtoAdapter<GetTranslateOriginImageResponse> implements c<GetTranslateOriginImageResponse> {
        public ProtoAdapter_GetTranslateOriginImageResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTranslateOriginImageResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTranslateOriginImageResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.origin_image_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.origin_image_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.origin_image_set = ImageSet.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.origin_image_property = RichTextElement.ImageProperty.ADAPTER.decode(r100);
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
        public int encodedSize2(GetTranslateOriginImageResponse r100) {
            String r101 = r100.origin_image_key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ImageSet r104 = r100.origin_image_set;
            if (r104 == null) goto L9;
            int r105 = ImageSet.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            RichTextElement.ImageProperty r107 = r100.origin_image_property;
            if (r107 == null) goto L14;
            r102 = RichTextElement.ImageProperty.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ GetTranslateOriginImageResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTranslateOriginImageResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTranslateOriginImageResponse r101) throws IOException {
            String r102 = r101.origin_image_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ImageSet r103 = r101.origin_image_set;
            if (r103 == null) goto L8;
            ImageSet.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            RichTextElement.ImageProperty r104 = r101.origin_image_property;
            if (r104 == null) goto L11;
            RichTextElement.ImageProperty.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTranslateOriginImageResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTranslateOriginImageResponse r100 = new ProtoAdapter_GetTranslateOriginImageResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.origin_image_key = this.origin_image_key;
        r100.origin_image_set = this.origin_image_set;
        r100.origin_image_property = this.origin_image_property;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTranslateOriginImageResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTranslateOriginImageResponse(String r100, ImageSet r101, RichTextElement.ImageProperty r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetTranslateOriginImageResponse(String r100, ImageSet r101, RichTextElement.ImageProperty r102, ByteString r103) {
        super(ADAPTER, r103);
        this.origin_image_key = r100;
        this.origin_image_set = r101;
        this.origin_image_property = r102;
    }
}
