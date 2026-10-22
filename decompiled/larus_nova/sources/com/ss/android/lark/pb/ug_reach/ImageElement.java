package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class ImageElement extends Message<ImageElement, Builder> {
    public static final ProtoAdapter<ImageElement> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final CdnImageElement mcdn_image;
    public final RawImageElement mraw_image;
    public final ImageType mtype;

    public static final class Builder extends Message.Builder<ImageElement, Builder> {
        public CdnImageElement mcdn_image;
        public RawImageElement mraw_image;
        public ImageType mtype;

        @Override // com.squareup.wire.Message.Builder
        public ImageElement build() {
            return new ImageElement(this.mtype, this.mraw_image, this.mcdn_image, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cdn_image(CdnImageElement r100) {
            this.mcdn_image = r100;
            this.mraw_image = null;
            return this;
        }

        public Builder raw_image(RawImageElement r100) {
            this.mraw_image = r100;
            this.mcdn_image = null;
            return this;
        }

        public Builder type(ImageType r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final enum ImageType extends Enum<ImageType> implements WireEnum {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ProtoAdapter<ImageType> ADAPTER = null;
        public static final ImageType ENCRYPTED_BYTES = null;
        public static final ImageType ENCRYPTED_CDN_URL = null;
        public static final ImageType RAW_BYTES = null;
        public static final ImageType RAW_CDN_URL = null;
        public static final ImageType UNKNOWN = null;
        private final int value;

        static {
            ImageType r100 = new ImageType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ImageType r101 = new ImageType("RAW_BYTES", 1, 1);
            RAW_BYTES = r101;
            ImageType r102 = new ImageType("ENCRYPTED_BYTES", 2, 2);
            ENCRYPTED_BYTES = r102;
            ImageType r103 = new ImageType("RAW_CDN_URL", 3, 3);
            RAW_CDN_URL = r103;
            ImageType r104 = new ImageType("ENCRYPTED_CDN_URL", 4, 4);
            ENCRYPTED_CDN_URL = r104;
            $VALUES = new ImageType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(ImageType.class);
        }

        public static ImageType[] values() {
            return (ImageType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ImageType fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return ENCRYPTED_CDN_URL;
        L16:
            return RAW_CDN_URL;
        L18:
            return ENCRYPTED_BYTES;
        L20:
            return RAW_BYTES;
        L22:
            return UNKNOWN;
        }

        public static ImageType valueOf(String r100) {
            return (ImageType) a.a(ImageType.class, r100);
        }

        private ImageType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ImageElement extends ProtoAdapter<ImageElement> {
        public ProtoAdapter_ImageElement() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageElement.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ImageElement decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mtype = ImageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.raw_image(RawImageElement.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.cdn_image(CdnImageElement.ADAPTER.decode(r100));
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
        public int encodedSize2(ImageElement r100) {
            ImageType r101 = r100.mtype;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ImageType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            RawImageElement r104 = r100.mraw_image;
            if (r104 == null) goto L9;
            int r105 = RawImageElement.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            CdnImageElement r107 = r100.mcdn_image;
            if (r107 == null) goto L14;
            r102 = CdnImageElement.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ ImageElement decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ImageElement r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ImageElement r101) throws IOException {
            ImageType r102 = r101.mtype;
            if (r102 == null) goto L5;
            ImageType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            RawImageElement r103 = r101.mraw_image;
            if (r103 == null) goto L8;
            RawImageElement.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            CdnImageElement r104 = r101.mcdn_image;
            if (r104 == null) goto L11;
            CdnImageElement.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageElement r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageElement();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtype = this.mtype;
        r100.mraw_image = this.mraw_image;
        r100.mcdn_image = this.mcdn_image;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ImageElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ImageElement(ImageType r100, RawImageElement r101, CdnImageElement r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ImageElement(ImageType r100, RawImageElement r101, CdnImageElement r102, ByteString r103) {
        super(ADAPTER, r103);
        if (Internal.countNonNull(r101, r102) > 1) goto L7;
        this.mtype = r100;
        this.mraw_image = r101;
        this.mcdn_image = r102;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mraw_image, mcdn_image may be non-null");
    }
}
