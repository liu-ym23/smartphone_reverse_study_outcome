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
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class TranslateImageKeysRequest extends Message<TranslateImageKeysRequest, Builder> {
    public static final ProtoAdapter<TranslateImageKeysRequest> ADAPTER = null;
    public static final String DEFAULT_ENTITY_ID = "";
    public static final ImageTranslationInfo.EntityType DEFAULT_ENTITY_TYPE = null;
    public static final ImageTranslateScene DEFAULT_SCENE = null;
    public static final String DEFAULT_TARGET_LANGUAGE = "";
    public static final ProtoAdapter_TranslateImageKeysRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String entity_id;
    public final ImageTranslationInfo.EntityType entity_type;
    public final List<ImageKeyInfo> image_keys_info;
    public final ImageTranslateScene scene;
    public final String target_language;

    public static final class Builder extends Message.Builder<TranslateImageKeysRequest, Builder> implements d<TranslateImageKeysRequest> {
        public String entity_id;
        public ImageTranslationInfo.EntityType entity_type;
        public List<ImageKeyInfo> image_keys_info;
        public ImageTranslateScene scene;
        public String target_language;

        @Override // com.squareup.wire.Message.Builder
        public TranslateImageKeysRequest build() {
            String r100 = this.entity_id;
            if (r100 == null) goto L9;
            if (this.entity_type == null) goto L9;
            return new TranslateImageKeysRequest(this.entity_id, this.entity_type, this.image_keys_info, this.target_language, this.scene, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, PickerReporterConstants.KEY.ENTITY_ID, this.entity_type, EntityProvider.KEY_ENTITY_TYPE});
        }

        public Builder() {
            this.image_keys_info = Internal.newMutableList();
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

        public Builder image_keys_info(List<ImageKeyInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.image_keys_info = r100;
            return this;
        }

        public Builder scene(ImageTranslateScene r100) {
            this.scene = r100;
            return this;
        }

        public Builder target_language(String r100) {
            this.target_language = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TranslateImageKeysRequest extends ProtoAdapter<TranslateImageKeysRequest> implements c<TranslateImageKeysRequest> {
        public ProtoAdapter_TranslateImageKeysRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslateImageKeysRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TranslateImageKeysRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.entity_id = "";
            r101.entity_type = ImageTranslationInfo.EntityType.UNKNOWN_ENTITY;
            r101.target_language = "";
            r101.scene = ImageTranslateScene.IMAGE_TRANSLATION_SCENE_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.entity_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.entity_type = ImageTranslationInfo.EntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.image_keys_info.add(ImageKeyInfo.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.target_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.scene = ImageTranslateScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TranslateImageKeysRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.entity_id) + ImageTranslationInfo.EntityType.ADAPTER.encodedSizeWithTag(2, r100.entity_type)) + ImageKeyInfo.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.image_keys_info);
            String r103 = r100.target_language;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            ImageTranslateScene r107 = r100.scene;
            if (r107 == null) goto L10;
            r104 = ImageTranslateScene.ADAPTER.encodedSizeWithTag(5, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TranslateImageKeysRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TranslateImageKeysRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TranslateImageKeysRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.entity_id);
            ImageTranslationInfo.EntityType.ADAPTER.encodeWithTag(r100, 2, r101.entity_type);
            ImageKeyInfo.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.image_keys_info);
            String r103 = r101.target_language;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            ImageTranslateScene r104 = r101.scene;
            if (r104 == null) goto L8;
            ImageTranslateScene.ADAPTER.encodeWithTag(r100, 5, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslateImageKeysRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TranslateImageKeysRequest r100 = new ProtoAdapter_TranslateImageKeysRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ENTITY_TYPE = ImageTranslationInfo.EntityType.UNKNOWN_ENTITY;
        DEFAULT_SCENE = ImageTranslateScene.IMAGE_TRANSLATION_SCENE_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.entity_id = this.entity_id;
        r100.entity_type = this.entity_type;
        r100.image_keys_info = Internal.copyOf("image_keys_info", this.image_keys_info);
        r100.target_language = this.target_language;
        r100.scene = this.scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TranslateImageKeysRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TranslateImageKeysRequest(String r100, ImageTranslationInfo.EntityType r101, List<ImageKeyInfo> r110, String r111, ImageTranslateScene r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public TranslateImageKeysRequest(String r100, ImageTranslationInfo.EntityType r101, List<ImageKeyInfo> r102, String r103, ImageTranslateScene r104, ByteString r105) {
        super(ADAPTER, r105);
        this.entity_id = r100;
        this.entity_type = r101;
        this.image_keys_info = Internal.immutableCopyOf("image_keys_info", r102);
        this.target_language = r103;
        this.scene = r104;
    }
}
