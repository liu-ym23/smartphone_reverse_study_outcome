package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ImageTranslationInfo;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushImageTranslationInfo extends Message<PushImageTranslationInfo, Builder> {
    public static final ProtoAdapter<PushImageTranslationInfo> ADAPTER = null;
    public static final Boolean DEFAULT_AFFECT_ENTITY_TO_ORIGIN = null;
    public static final ProtoAdapter_PushImageTranslationInfo RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> affect_addition_info;
    public final Boolean affect_entity_to_origin;
    public final ImageTranslationInfo images_translation_info;

    public static final class Builder extends Message.Builder<PushImageTranslationInfo, Builder> implements d<PushImageTranslationInfo> {
        public Map<String, String> affect_addition_info;
        public Boolean affect_entity_to_origin;
        public ImageTranslationInfo images_translation_info;

        @Override // com.squareup.wire.Message.Builder
        public PushImageTranslationInfo build() {
            ImageTranslationInfo r100 = this.images_translation_info;
            if (r100 == null) goto L7;
            return new PushImageTranslationInfo(this.images_translation_info, this.affect_entity_to_origin, this.affect_addition_info, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "images_translation_info"});
        }

        public Builder() {
            this.affect_addition_info = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder affect_addition_info(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.affect_addition_info = r100;
            return this;
        }

        public Builder affect_entity_to_origin(Boolean r100) {
            this.affect_entity_to_origin = r100;
            return this;
        }

        public Builder images_translation_info(ImageTranslationInfo r100) {
            this.images_translation_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushImageTranslationInfo extends ProtoAdapter<PushImageTranslationInfo> implements c<PushImageTranslationInfo> {
        private final ProtoAdapter<Map<String, String>> affect_addition_info;

        public ProtoAdapter_PushImageTranslationInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, PushImageTranslationInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.affect_addition_info = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushImageTranslationInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.affect_entity_to_origin = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.images_translation_info = ImageTranslationInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.affect_entity_to_origin = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.affect_addition_info.putAll(this.affect_addition_info.decode(r100));
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
        public int encodedSize2(PushImageTranslationInfo r100) {
            int r101 = ImageTranslationInfo.ADAPTER.encodedSizeWithTag(1, r100.images_translation_info);
            Boolean r102 = r100.affect_entity_to_origin;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return ((r101 + r103) + this.affect_addition_info.encodedSizeWithTag(3, r100.affect_addition_info)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushImageTranslationInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushImageTranslationInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushImageTranslationInfo r101) throws IOException {
            ImageTranslationInfo.ADAPTER.encodeWithTag(r100, 1, r101.images_translation_info);
            Boolean r102 = r101.affect_entity_to_origin;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            this.affect_addition_info.encodeWithTag(r100, 3, r101.affect_addition_info);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushImageTranslationInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushImageTranslationInfo r100 = new ProtoAdapter_PushImageTranslationInfo();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_AFFECT_ENTITY_TO_ORIGIN = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.images_translation_info = this.images_translation_info;
        r100.affect_entity_to_origin = this.affect_entity_to_origin;
        r100.affect_addition_info = Internal.copyOf("affect_addition_info", this.affect_addition_info);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushImageTranslationInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushImageTranslationInfo(ImageTranslationInfo r100, Boolean r101, Map<String, String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushImageTranslationInfo(ImageTranslationInfo r100, Boolean r101, Map<String, String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.images_translation_info = r100;
        this.affect_entity_to_origin = r101;
        this.affect_addition_info = Internal.immutableCopyOf("affect_addition_info", r102);
    }
}
