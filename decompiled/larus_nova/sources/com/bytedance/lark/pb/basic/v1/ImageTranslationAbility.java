package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ImageTranslationAbility extends com.squareup.wire.Message<ImageTranslationAbility, Builder> {
    public static final ProtoAdapter<ImageTranslationAbility> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_TRANSLATE = null;
    private static final long serialVersionUID = 0;
    public final Boolean can_translate;
    public final List<String> src_language;

    public static final class Builder extends com.squareup.wire.Message.Builder<ImageTranslationAbility, Builder> {
        public Boolean can_translate;
        public List<String> src_language;

        @Override // com.squareup.wire.Message.Builder
        public ImageTranslationAbility build() {
            Boolean r100 = this.can_translate;
            if (r100 == null) goto L7;
            return new ImageTranslationAbility(this.can_translate, this.src_language, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "can_translate"});
        }

        public Builder() {
            this.src_language = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder can_translate(Boolean r100) {
            this.can_translate = r100;
            return this;
        }

        public Builder src_language(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.src_language = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ImageTranslationAbility extends ProtoAdapter<ImageTranslationAbility> {
        public ProtoAdapter_ImageTranslationAbility() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageTranslationAbility.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ImageTranslationAbility decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.can_translate = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.can_translate = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.src_language.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(ImageTranslationAbility r100) {
            return (ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.can_translate) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.src_language)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ImageTranslationAbility decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ImageTranslationAbility r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ImageTranslationAbility r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.can_translate);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.src_language);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageTranslationAbility r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageTranslationAbility();
        DEFAULT_CAN_TRANSLATE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.can_translate = this.can_translate;
        r100.src_language = Internal.copyOf("src_language", this.src_language);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ImageTranslationAbility.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ImageTranslationAbility(Boolean r100, List<String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ImageTranslationAbility(Boolean r100, List<String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.can_translate = r100;
        this.src_language = Internal.immutableCopyOf("src_language", r101);
    }
}
