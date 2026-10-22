package com.bytedance.lark.pb.basic.v1;

import com.obric.capabilitykit.EntityProvider;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ImageTranslationInfo extends com.squareup.wire.Message<ImageTranslationInfo, Builder> {
    public static final ProtoAdapter<ImageTranslationInfo> ADAPTER = null;
    public static final String DEFAULT_ENTITY_ID = "";
    public static final EntityType DEFAULT_ENTITY_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String entity_id;
    public final EntityType entity_type;
    public final Map<String, TranslatedImage> translated_images;

    public static final class Builder extends com.squareup.wire.Message.Builder<ImageTranslationInfo, Builder> {
        public String entity_id;
        public EntityType entity_type;
        public Map<String, TranslatedImage> translated_images;

        @Override // com.squareup.wire.Message.Builder
        public ImageTranslationInfo build() {
            String r100 = this.entity_id;
            if (r100 == null) goto L9;
            if (this.entity_type == null) goto L9;
            return new ImageTranslationInfo(this.entity_id, this.entity_type, this.translated_images, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, PickerReporterConstants.KEY.ENTITY_ID, this.entity_type, EntityProvider.KEY_ENTITY_TYPE});
        }

        public Builder() {
            this.translated_images = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder entity_id(String r100) {
            this.entity_id = r100;
            return this;
        }

        public Builder entity_type(EntityType r100) {
            this.entity_type = r100;
            return this;
        }

        public Builder translated_images(Map<String, TranslatedImage> r100) {
            Internal.checkElementsNotNull(r100);
            this.translated_images = r100;
            return this;
        }
    }

    public static final enum EntityType extends Enum<EntityType> implements WireEnum {
        private static final /* synthetic */ EntityType[] $VALUES = null;
        public static final ProtoAdapter<EntityType> ADAPTER = null;
        public static final EntityType MESSAGE_ENTITY = null;
        public static final EntityType UNKNOWN_ENTITY = null;
        private final int value;

        static {
            EntityType r100 = new EntityType("UNKNOWN_ENTITY", 0, 0);
            UNKNOWN_ENTITY = r100;
            EntityType r101 = new EntityType("MESSAGE_ENTITY", 1, 1);
            MESSAGE_ENTITY = r101;
            $VALUES = new EntityType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(EntityType.class);
        }

        public static EntityType[] values() {
            return (EntityType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static EntityType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return MESSAGE_ENTITY;
        L10:
            return UNKNOWN_ENTITY;
        }

        public static EntityType valueOf(String r100) {
            return (EntityType) a.a(EntityType.class, r100);
        }

        private EntityType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ImageTranslationInfo extends ProtoAdapter<ImageTranslationInfo> {
        private final ProtoAdapter<Map<String, TranslatedImage>> translated_images;

        public ProtoAdapter_ImageTranslationInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageTranslationInfo.class);
            this.translated_images = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, TranslatedImage.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ImageTranslationInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.entity_id = "";
            r101.entity_type = EntityType.UNKNOWN_ENTITY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.entity_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.entity_type = EntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.translated_images.putAll(this.translated_images.decode(r100));
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
        public int encodedSize2(ImageTranslationInfo r100) {
            return ((ProtoAdapter.STRING.encodedSizeWithTag(1, r100.entity_id) + EntityType.ADAPTER.encodedSizeWithTag(2, r100.entity_type)) + this.translated_images.encodedSizeWithTag(3, r100.translated_images)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ImageTranslationInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ImageTranslationInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ImageTranslationInfo r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.entity_id);
            EntityType.ADAPTER.encodeWithTag(r100, 2, r101.entity_type);
            this.translated_images.encodeWithTag(r100, 3, r101.translated_images);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageTranslationInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageTranslationInfo();
        DEFAULT_ENTITY_TYPE = EntityType.UNKNOWN_ENTITY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.entity_id = this.entity_id;
        r100.entity_type = this.entity_type;
        r100.translated_images = Internal.copyOf("translated_images", this.translated_images);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ImageTranslationInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ImageTranslationInfo(String r100, EntityType r101, Map<String, TranslatedImage> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ImageTranslationInfo(String r100, EntityType r101, Map<String, TranslatedImage> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.entity_id = r100;
        this.entity_type = r101;
        this.translated_images = Internal.immutableCopyOf("translated_images", r102);
    }
}
