package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ImageTranslationAbility;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class DetectImagesLanguageResponse extends Message<DetectImagesLanguageResponse, Builder> {
    public static final ProtoAdapter<DetectImagesLanguageResponse> ADAPTER = null;
    public static final ProtoAdapter_DetectImagesLanguageResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ImageTranslationAbility> images_translation_ability;

    public static final class Builder extends Message.Builder<DetectImagesLanguageResponse, Builder> implements d<DetectImagesLanguageResponse> {
        public List<ImageTranslationAbility> images_translation_ability;

        @Override // com.squareup.wire.Message.Builder
        public DetectImagesLanguageResponse build() {
            return new DetectImagesLanguageResponse(this.images_translation_ability, super.buildUnknownFields());
        }

        public Builder() {
            this.images_translation_ability = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder images_translation_ability(List<ImageTranslationAbility> r100) {
            Internal.checkElementsNotNull(r100);
            this.images_translation_ability = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DetectImagesLanguageResponse extends ProtoAdapter<DetectImagesLanguageResponse> implements c<DetectImagesLanguageResponse> {
        public ProtoAdapter_DetectImagesLanguageResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, DetectImagesLanguageResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DetectImagesLanguageResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.images_translation_ability.add(ImageTranslationAbility.ADAPTER.decode(r100));
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
        public int encodedSize2(DetectImagesLanguageResponse r100) {
            return ImageTranslationAbility.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.images_translation_ability) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DetectImagesLanguageResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DetectImagesLanguageResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DetectImagesLanguageResponse r101) throws IOException {
            ImageTranslationAbility.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.images_translation_ability);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DetectImagesLanguageResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DetectImagesLanguageResponse r100 = new ProtoAdapter_DetectImagesLanguageResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.images_translation_ability = Internal.copyOf("images_translation_ability", this.images_translation_ability);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DetectImagesLanguageResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DetectImagesLanguageResponse(List<ImageTranslationAbility> r100) {
        this(r100, ByteString.EMPTY);
    }

    public DetectImagesLanguageResponse(List<ImageTranslationAbility> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.images_translation_ability = Internal.immutableCopyOf("images_translation_ability", r100);
    }
}
