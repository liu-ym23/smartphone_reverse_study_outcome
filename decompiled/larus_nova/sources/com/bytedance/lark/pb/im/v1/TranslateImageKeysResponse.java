package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ImageTranslationInfo;
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
public final class TranslateImageKeysResponse extends Message<TranslateImageKeysResponse, Builder> {
    public static final ProtoAdapter<TranslateImageKeysResponse> ADAPTER = null;
    public static final Boolean DEFAULT_AFFECT_ENTITY_TO_TRANSLATE = null;
    public static final ProtoAdapter_TranslateImageKeysResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean affect_entity_to_translate;
    public final ImageTranslationInfo images_translation_info;

    public static final class Builder extends Message.Builder<TranslateImageKeysResponse, Builder> implements d<TranslateImageKeysResponse> {
        public Boolean affect_entity_to_translate;
        public ImageTranslationInfo images_translation_info;

        @Override // com.squareup.wire.Message.Builder
        public TranslateImageKeysResponse build() {
            ImageTranslationInfo r100 = this.images_translation_info;
            if (r100 == null) goto L7;
            return new TranslateImageKeysResponse(this.images_translation_info, this.affect_entity_to_translate, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "images_translation_info"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder affect_entity_to_translate(Boolean r100) {
            this.affect_entity_to_translate = r100;
            return this;
        }

        public Builder images_translation_info(ImageTranslationInfo r100) {
            this.images_translation_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TranslateImageKeysResponse extends ProtoAdapter<TranslateImageKeysResponse> implements c<TranslateImageKeysResponse> {
        public ProtoAdapter_TranslateImageKeysResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslateImageKeysResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TranslateImageKeysResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.affect_entity_to_translate = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.images_translation_info = ImageTranslationInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.affect_entity_to_translate = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(TranslateImageKeysResponse r100) {
            int r101 = ImageTranslationInfo.ADAPTER.encodedSizeWithTag(1, r100.images_translation_info);
            Boolean r102 = r100.affect_entity_to_translate;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TranslateImageKeysResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TranslateImageKeysResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TranslateImageKeysResponse r101) throws IOException {
            ImageTranslationInfo.ADAPTER.encodeWithTag(r100, 1, r101.images_translation_info);
            Boolean r102 = r101.affect_entity_to_translate;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslateImageKeysResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TranslateImageKeysResponse r100 = new ProtoAdapter_TranslateImageKeysResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_AFFECT_ENTITY_TO_TRANSLATE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.images_translation_info = this.images_translation_info;
        r100.affect_entity_to_translate = this.affect_entity_to_translate;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TranslateImageKeysResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TranslateImageKeysResponse(ImageTranslationInfo r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TranslateImageKeysResponse(ImageTranslationInfo r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.images_translation_info = r100;
        this.affect_entity_to_translate = r101;
    }
}
