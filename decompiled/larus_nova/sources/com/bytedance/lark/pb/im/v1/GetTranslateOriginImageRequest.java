package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ImageTranslationInfo;
import com.obric.capabilitykit.EntityProvider;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetTranslateOriginImageRequest extends Message<GetTranslateOriginImageRequest, Builder> {
    public static final ProtoAdapter<GetTranslateOriginImageRequest> ADAPTER = null;
    public static final String DEFAULT_ENTITY_ID = "";
    public static final ImageTranslationInfo.EntityType DEFAULT_ENTITY_TYPE = null;
    public static final String DEFAULT_TRANSLATE_IMAGE_KEY = "";
    public static final ProtoAdapter_GetTranslateOriginImageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String entity_id;
    public final ImageTranslationInfo.EntityType entity_type;
    public final String translate_image_key;

    public static final class Builder extends Message.Builder<GetTranslateOriginImageRequest, Builder> implements d<GetTranslateOriginImageRequest> {
        public String entity_id;
        public ImageTranslationInfo.EntityType entity_type;
        public String translate_image_key;

        @Override // com.squareup.wire.Message.Builder
        public GetTranslateOriginImageRequest build() {
            String r100 = this.entity_id;
            if (r100 == null) goto L11;
            if (this.entity_type == null) goto L11;
            if (this.translate_image_key == null) goto L11;
            return new GetTranslateOriginImageRequest(this.entity_id, this.entity_type, this.translate_image_key, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, PickerReporterConstants.KEY.ENTITY_ID, this.entity_type, EntityProvider.KEY_ENTITY_TYPE, this.translate_image_key, "translate_image_key"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder entity_id(String r100) {
            this.entity_id = r100;
            return this;
        }

        public Builder entity_type(ImageTranslationInfo.EntityType r100) {
            this.entity_type = r100;
            return this;
        }

        public Builder translate_image_key(String r100) {
            this.translate_image_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTranslateOriginImageRequest extends ProtoAdapter<GetTranslateOriginImageRequest> implements c<GetTranslateOriginImageRequest> {
        public ProtoAdapter_GetTranslateOriginImageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTranslateOriginImageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTranslateOriginImageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.entity_id = "";
            r101.entity_type = ImageTranslationInfo.EntityType.UNKNOWN_ENTITY;
            r101.translate_image_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.entity_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.entity_type = ImageTranslationInfo.EntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.translate_image_key = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetTranslateOriginImageRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.entity_id) + ImageTranslationInfo.EntityType.ADAPTER.encodedSizeWithTag(2, r100.entity_type)) + r101.encodedSizeWithTag(3, r100.translate_image_key)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTranslateOriginImageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTranslateOriginImageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTranslateOriginImageRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.entity_id);
            ImageTranslationInfo.EntityType.ADAPTER.encodeWithTag(r100, 2, r101.entity_type);
            r102.encodeWithTag(r100, 3, r101.translate_image_key);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTranslateOriginImageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTranslateOriginImageRequest r100 = new ProtoAdapter_GetTranslateOriginImageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ENTITY_TYPE = ImageTranslationInfo.EntityType.UNKNOWN_ENTITY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.entity_id = this.entity_id;
        r100.entity_type = this.entity_type;
        r100.translate_image_key = this.translate_image_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTranslateOriginImageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTranslateOriginImageRequest(String r100, ImageTranslationInfo.EntityType r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetTranslateOriginImageRequest(String r100, ImageTranslationInfo.EntityType r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.entity_id = r100;
        this.entity_type = r101;
        this.translate_image_key = r102;
    }
}
