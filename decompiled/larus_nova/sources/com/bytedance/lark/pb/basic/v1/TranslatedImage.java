package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TranslatedImage extends com.squareup.wire.Message<TranslatedImage, Builder> {
    public static final ProtoAdapter<TranslatedImage> ADAPTER = null;
    public static final Boolean DEFAULT_IS_TRANSLATED = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_translated;
    public final ImageSet translated_image_set;

    public static final class Builder extends com.squareup.wire.Message.Builder<TranslatedImage, Builder> {
        public Boolean is_translated;
        public ImageSet translated_image_set;

        @Override // com.squareup.wire.Message.Builder
        public TranslatedImage build() {
            ImageSet r100 = this.translated_image_set;
            if (r100 == null) goto L9;
            if (this.is_translated == null) goto L9;
            return new TranslatedImage(this.translated_image_set, this.is_translated, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "translated_image_set", this.is_translated, "is_translated"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder is_translated(Boolean r100) {
            this.is_translated = r100;
            return this;
        }

        public Builder translated_image_set(ImageSet r100) {
            this.translated_image_set = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TranslatedImage extends ProtoAdapter<TranslatedImage> {
        public ProtoAdapter_TranslatedImage() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslatedImage.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TranslatedImage decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_translated = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.translated_image_set = ImageSet.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.is_translated = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(TranslatedImage r100) {
            return (ImageSet.ADAPTER.encodedSizeWithTag(1, r100.translated_image_set) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.is_translated)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TranslatedImage decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TranslatedImage r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TranslatedImage r101) throws IOException {
            ImageSet.ADAPTER.encodeWithTag(r100, 1, r101.translated_image_set);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.is_translated);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslatedImage r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TranslatedImage();
        DEFAULT_IS_TRANSLATED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.translated_image_set = this.translated_image_set;
        r100.is_translated = this.is_translated;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TranslatedImage.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TranslatedImage(ImageSet r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TranslatedImage(ImageSet r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.translated_image_set = r100;
        this.is_translated = r101;
    }
}
