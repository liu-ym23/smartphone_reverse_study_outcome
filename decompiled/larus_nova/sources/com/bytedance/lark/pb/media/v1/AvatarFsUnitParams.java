package com.bytedance.lark.pb.media.v1;

import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class AvatarFsUnitParams extends Message<AvatarFsUnitParams, Builder> {
    public static final ProtoAdapter<AvatarFsUnitParams> ADAPTER = null;
    public static final CutType DEFAULT_CUT_TYPE = null;
    public static final Format DEFAULT_FORMAT = null;
    public static final Quality DEFAULT_QUALITY = null;
    public static final ImageSizeType DEFAULT_SIZE_TYPE = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final CutType cut_type;
    public final Format format;
    public final Quality quality;
    public final ImageSizeType size_type;

    public static final class Builder extends Message.Builder<AvatarFsUnitParams, Builder> {
        public CutType cut_type;
        public Format format;
        public Quality quality;
        public ImageSizeType size_type;

        @Override // com.squareup.wire.Message.Builder
        public AvatarFsUnitParams build() {
            return new AvatarFsUnitParams(this.cut_type, this.size_type, this.format, this.quality, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cut_type(CutType r100) {
            this.cut_type = r100;
            return this;
        }

        public Builder format(Format r100) {
            this.format = r100;
            return this;
        }

        public Builder quality(Quality r100) {
            this.quality = r100;
            return this;
        }

        public Builder size_type(ImageSizeType r100) {
            this.size_type = r100;
            return this;
        }
    }

    public static final enum CutType extends Enum<CutType> implements WireEnum {
        private static final /* synthetic */ CutType[] $VALUES = null;
        public static final ProtoAdapter<CutType> ADAPTER = null;
        public static final CutType FACE = null;
        public static final CutType NOOP = null;
        private final int value;

        static {
            CutType r100 = new CutType("FACE", 0, 1);
            FACE = r100;
            CutType r101 = new CutType("NOOP", 1, 2);
            NOOP = r101;
            $VALUES = new CutType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(CutType.class);
        }

        public static CutType[] values() {
            return (CutType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CutType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return NOOP;
        L11:
            return FACE;
        }

        public static CutType valueOf(String r100) {
            return (CutType) a.a(CutType.class, r100);
        }

        private CutType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Format extends Enum<Format> implements WireEnum {
        private static final /* synthetic */ Format[] $VALUES = null;
        public static final ProtoAdapter<Format> ADAPTER = null;
        public static final Format IMAGE = null;
        public static final Format JPEG = null;
        public static final Format PNG = null;
        public static final Format WEBP = null;
        private final int value;

        static {
            Format r100 = new Format("WEBP", 0, 1);
            WEBP = r100;
            Format r101 = new Format("JPEG", 1, 2);
            JPEG = r101;
            Format r102 = new Format("PNG", 2, 3);
            PNG = r102;
            Format r103 = new Format("IMAGE", 3, 4);
            IMAGE = r103;
            $VALUES = new Format[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Format.class);
        }

        public static Format[] values() {
            return (Format[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Format fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return IMAGE;
        L15:
            return PNG;
        L17:
            return JPEG;
        L19:
            return WEBP;
        }

        public static Format valueOf(String r100) {
            return (Format) a.a(Format.class, r100);
        }

        private Format(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ImageSizeType extends Enum<ImageSizeType> implements WireEnum {
        private static final /* synthetic */ ImageSizeType[] $VALUES = null;
        public static final ProtoAdapter<ImageSizeType> ADAPTER = null;
        public static final ImageSizeType BIG = null;
        public static final ImageSizeType MIDDLE = null;
        public static final ImageSizeType ORIGIN = null;
        public static final ImageSizeType SMALL = null;
        private final int value;

        static {
            ImageSizeType r100 = new ImageSizeType("SMALL", 0, 1);
            SMALL = r100;
            ImageSizeType r101 = new ImageSizeType("MIDDLE", 1, 2);
            MIDDLE = r101;
            ImageSizeType r102 = new ImageSizeType("ORIGIN", 2, 3);
            ORIGIN = r102;
            ImageSizeType r103 = new ImageSizeType("BIG", 3, 4);
            BIG = r103;
            $VALUES = new ImageSizeType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(ImageSizeType.class);
        }

        public static ImageSizeType[] values() {
            return (ImageSizeType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ImageSizeType fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return BIG;
        L15:
            return ORIGIN;
        L17:
            return MIDDLE;
        L19:
            return SMALL;
        }

        public static ImageSizeType valueOf(String r100) {
            return (ImageSizeType) a.a(ImageSizeType.class, r100);
        }

        private ImageSizeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_AvatarFsUnitParams extends ProtoAdapter<AvatarFsUnitParams> {
        public ProtoAdapter_AvatarFsUnitParams() {
            super(FieldEncoding.LENGTH_DELIMITED, AvatarFsUnitParams.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AvatarFsUnitParams decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.cut_type = CutType.NOOP;
            r101.size_type = ImageSizeType.MIDDLE;
            r101.format = Format.WEBP;
            r101.quality = Quality.Q_NOOP;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L30;
            if (r103 != 1) goto L8;
            r101.cut_type = CutType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
        L28:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.size_type = ImageSizeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.format = Format.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.quality = Quality.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L30:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AvatarFsUnitParams r100) {
            CutType r101 = r100.cut_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = CutType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ImageSizeType r104 = r100.size_type;
            if (r104 == null) goto L9;
            int r105 = ImageSizeType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Format r107 = r100.format;
            if (r107 == null) goto L13;
            int r108 = Format.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Quality r110 = r100.quality;
            if (r110 == null) goto L18;
            r102 = Quality.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AvatarFsUnitParams decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AvatarFsUnitParams r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AvatarFsUnitParams r101) throws IOException {
            CutType r102 = r101.cut_type;
            if (r102 == null) goto L5;
            CutType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ImageSizeType r103 = r101.size_type;
            if (r103 == null) goto L8;
            ImageSizeType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Format r104 = r101.format;
            if (r104 == null) goto L11;
            Format.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Quality r105 = r101.quality;
            if (r105 == null) goto L14;
            Quality.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AvatarFsUnitParams r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Quality extends Enum<Quality> implements WireEnum {
        private static final /* synthetic */ Quality[] $VALUES = null;
        public static final ProtoAdapter<Quality> ADAPTER = null;
        public static final Quality Q1 = null;
        public static final Quality Q70 = null;
        public static final Quality Q_NOOP = null;
        private final int value;

        static {
            Quality r100 = new Quality("Q1", 0, 1);
            Q1 = r100;
            Quality r101 = new Quality("Q70", 1, 2);
            Q70 = r101;
            Quality r102 = new Quality("Q_NOOP", 2, 3);
            Q_NOOP = r102;
            $VALUES = new Quality[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Quality.class);
        }

        public static Quality[] values() {
            return (Quality[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Quality fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return Q_NOOP;
        L13:
            return Q70;
        L15:
            return Q1;
        }

        public static Quality valueOf(String r100) {
            return (Quality) a.a(Quality.class, r100);
        }

        private Quality(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AvatarFsUnitParams();
        MESSAGE_OPTIONS = new MessageOptions.Builder().deprecated(Boolean.TRUE).build();
        DEFAULT_CUT_TYPE = CutType.NOOP;
        DEFAULT_SIZE_TYPE = ImageSizeType.MIDDLE;
        DEFAULT_FORMAT = Format.WEBP;
        DEFAULT_QUALITY = Quality.Q_NOOP;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cut_type = this.cut_type;
        r100.size_type = this.size_type;
        r100.format = this.format;
        r100.quality = this.quality;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AvatarFsUnitParams.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AvatarFsUnitParams(CutType r100, ImageSizeType r101, Format r102, Quality r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public AvatarFsUnitParams(CutType r100, ImageSizeType r101, Format r102, Quality r103, ByteString r104) {
        super(ADAPTER, r104);
        this.cut_type = r100;
        this.size_type = r101;
        this.format = r102;
        this.quality = r103;
    }
}
