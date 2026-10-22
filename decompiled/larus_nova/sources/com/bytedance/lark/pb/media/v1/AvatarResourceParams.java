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
public final class AvatarResourceParams extends Message<AvatarResourceParams, Builder> {
    public static final ProtoAdapter<AvatarResourceParams> ADAPTER = null;
    public static final CutType DEFAULT_CUT_TYPE = null;
    public static final ImageFormat DEFAULT_FORMAT = null;
    public static final Integer DEFAULT_HEIGHT = null;
    public static final Boolean DEFAULT_NOOP = null;
    public static final Integer DEFAULT_QUALITY = null;
    public static final Integer DEFAULT_WIDTH = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final CutType cut_type;
    public final ImageFormat format;
    public final Integer height;
    public final Boolean noop;
    public final Integer quality;
    public final Integer width;

    public static final class Builder extends Message.Builder<AvatarResourceParams, Builder> {
        public CutType cut_type;
        public ImageFormat format;
        public Integer height;
        public Boolean noop;
        public Integer quality;
        public Integer width;

        @Override // com.squareup.wire.Message.Builder
        public AvatarResourceParams build() {
            return new AvatarResourceParams(this.width, this.height, this.cut_type, this.format, this.quality, this.noop, super.buildUnknownFields());
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

        public Builder format(ImageFormat r100) {
            this.format = r100;
            return this;
        }

        public Builder height(Integer r100) {
            this.height = r100;
            return this;
        }

        public Builder noop(Boolean r100) {
            this.noop = r100;
            return this;
        }

        public Builder quality(Integer r100) {
            this.quality = r100;
            return this;
        }

        public Builder width(Integer r100) {
            this.width = r100;
            return this;
        }
    }

    public static final enum CutType extends Enum<CutType> implements WireEnum {
        private static final /* synthetic */ CutType[] $VALUES = null;
        public static final ProtoAdapter<CutType> ADAPTER = null;
        public static final CutType BOTTOM = null;
        public static final CutType CENTER = null;
        public static final CutType FACE = null;
        public static final CutType LEFT = null;
        public static final CutType RIGHT = null;
        public static final CutType TOP = null;
        private final int value;

        static {
            CutType r100 = new CutType("TOP", 0, 1);
            TOP = r100;
            CutType r101 = new CutType("BOTTOM", 1, 2);
            BOTTOM = r101;
            CutType r102 = new CutType("LEFT", 2, 3);
            LEFT = r102;
            CutType r103 = new CutType("RIGHT", 3, 4);
            RIGHT = r103;
            CutType r104 = new CutType("CENTER", 4, 5);
            CENTER = r104;
            CutType r110 = new CutType("FACE", 5, 6);
            FACE = r110;
            $VALUES = new CutType[]{r100, r101, r102, r103, r104, r110};
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
            switch(r100) {
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return FACE;
        L8:
            return CENTER;
        L10:
            return RIGHT;
        L12:
            return LEFT;
        L14:
            return BOTTOM;
        L16:
            return TOP;
        }

        public static CutType valueOf(String r100) {
            return (CutType) a.a(CutType.class, r100);
        }

        private CutType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ImageFormat extends Enum<ImageFormat> implements WireEnum {
        private static final /* synthetic */ ImageFormat[] $VALUES = null;
        public static final ProtoAdapter<ImageFormat> ADAPTER = null;
        public static final ImageFormat JPEG = null;
        public static final ImageFormat PNG = null;
        public static final ImageFormat WEBP = null;
        private final int value;

        static {
            ImageFormat r100 = new ImageFormat("WEBP", 0, 1);
            WEBP = r100;
            ImageFormat r101 = new ImageFormat("JPEG", 1, 2);
            JPEG = r101;
            ImageFormat r102 = new ImageFormat("PNG", 2, 3);
            PNG = r102;
            $VALUES = new ImageFormat[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ImageFormat.class);
        }

        public static ImageFormat[] values() {
            return (ImageFormat[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ImageFormat fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return PNG;
        L13:
            return JPEG;
        L15:
            return WEBP;
        }

        public static ImageFormat valueOf(String r100) {
            return (ImageFormat) a.a(ImageFormat.class, r100);
        }

        private ImageFormat(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_AvatarResourceParams extends ProtoAdapter<AvatarResourceParams> {
        public ProtoAdapter_AvatarResourceParams() {
            super(FieldEncoding.LENGTH_DELIMITED, AvatarResourceParams.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AvatarResourceParams decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.width = 120;
            r101.height = 120;
            r101.cut_type = CutType.TOP;
            r101.format = ImageFormat.PNG;
            r101.quality = 70;
            r101.noop = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L23;
                case 4: goto L21;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L21:
            r101.format = ImageFormat.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r101.cut_type = CutType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.noop = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.quality = ProtoAdapter.INT32.decode(r100);
            goto L3
        L17:
            r101.height = ProtoAdapter.INT32.decode(r100);
            goto L3
        L18:
            r101.width = ProtoAdapter.INT32.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AvatarResourceParams r100) {
            Integer r101 = r100.width;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.height;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            CutType r107 = r100.cut_type;
            if (r107 == null) goto L13;
            int r108 = CutType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ImageFormat r110 = r100.format;
            if (r110 == null) goto L17;
            int r111 = ImageFormat.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.quality;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.noop;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ AvatarResourceParams decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AvatarResourceParams r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AvatarResourceParams r101) throws IOException {
            Integer r102 = r101.width;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.height;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            CutType r104 = r101.cut_type;
            if (r104 == null) goto L11;
            CutType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            ImageFormat r105 = r101.format;
            if (r105 == null) goto L14;
            ImageFormat.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Integer r106 = r101.quality;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.noop;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AvatarResourceParams r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AvatarResourceParams();
        MESSAGE_OPTIONS = new MessageOptions.Builder().deprecated(Boolean.TRUE).build();
        DEFAULT_WIDTH = 120;
        DEFAULT_HEIGHT = 120;
        DEFAULT_CUT_TYPE = CutType.TOP;
        DEFAULT_FORMAT = ImageFormat.PNG;
        DEFAULT_QUALITY = 70;
        DEFAULT_NOOP = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.width = this.width;
        r100.height = this.height;
        r100.cut_type = this.cut_type;
        r100.format = this.format;
        r100.quality = this.quality;
        r100.noop = this.noop;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AvatarResourceParams.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AvatarResourceParams(Integer r100, Integer r110, CutType r111, ImageFormat r112, Integer r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public AvatarResourceParams(Integer r100, Integer r101, CutType r102, ImageFormat r103, Integer r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        this.width = r100;
        this.height = r101;
        this.cut_type = r102;
        this.format = r103;
        this.quality = r104;
        this.noop = r105;
    }
}
