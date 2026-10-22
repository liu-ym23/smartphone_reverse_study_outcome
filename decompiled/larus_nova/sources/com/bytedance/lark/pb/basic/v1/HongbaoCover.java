package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class HongbaoCover extends com.squareup.wire.Message<HongbaoCover, Builder> {
    public static final ProtoAdapter<HongbaoCover> ADAPTER = null;
    public static final String DEFAULT_COMPANY_NAME = "";
    public static final CoverType DEFAULT_COVER_TYPE = null;
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final ImageSetPassThrough company_logo;
    public final String company_name;
    public final CoverType cover_type;
    public final DisplayName display_name;
    public final ImageSetPassThrough head_cover;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253505id;
    public final ImageSetPassThrough main_cover;
    public final ImageSetPassThrough message_cover;
    public final String name;
    public final ImageSetPassThrough select_cover;

    public static final class Builder extends com.squareup.wire.Message.Builder<HongbaoCover, Builder> {
        public ImageSetPassThrough company_logo;
        public String company_name;
        public CoverType cover_type;
        public DisplayName display_name;
        public ImageSetPassThrough head_cover;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253506id;
        public ImageSetPassThrough main_cover;
        public ImageSetPassThrough message_cover;
        public String name;
        public ImageSetPassThrough select_cover;

        @Override // com.squareup.wire.Message.Builder
        public HongbaoCover build() {
            return new HongbaoCover(this.f253506id, this.name, this.cover_type, this.main_cover, this.message_cover, this.head_cover, this.company_logo, this.select_cover, this.display_name, this.company_name, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder company_logo(ImageSetPassThrough r100) {
            this.company_logo = r100;
            return this;
        }

        public Builder company_name(String r100) {
            this.company_name = r100;
            return this;
        }

        public Builder cover_type(CoverType r100) {
            this.cover_type = r100;
            return this;
        }

        public Builder display_name(DisplayName r100) {
            this.display_name = r100;
            return this;
        }

        public Builder head_cover(ImageSetPassThrough r100) {
            this.head_cover = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.f253506id = r100;
            return this;
        }

        public Builder main_cover(ImageSetPassThrough r100) {
            this.main_cover = r100;
            return this;
        }

        public Builder message_cover(ImageSetPassThrough r100) {
            this.message_cover = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder select_cover(ImageSetPassThrough r100) {
            this.select_cover = r100;
            return this;
        }
    }

    public static final enum CoverType extends Enum<CoverType> implements WireEnum {
        private static final /* synthetic */ CoverType[] $VALUES = null;
        public static final ProtoAdapter<CoverType> ADAPTER = null;
        public static final CoverType CUSTOMIZE = null;
        public static final CoverType TEMPLATE = null;
        public static final CoverType UNKNOWN = null;
        private final int value;

        static {
            CoverType r100 = new CoverType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            CoverType r101 = new CoverType("TEMPLATE", 1, 1);
            TEMPLATE = r101;
            CoverType r102 = new CoverType("CUSTOMIZE", 2, 2);
            CUSTOMIZE = r102;
            $VALUES = new CoverType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(CoverType.class);
        }

        public static CoverType[] values() {
            return (CoverType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CoverType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CUSTOMIZE;
        L12:
            return TEMPLATE;
        L14:
            return UNKNOWN;
        }

        public static CoverType valueOf(String r100) {
            return (CoverType) a.a(CoverType.class, r100);
        }

        private CoverType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class DisplayName extends com.squareup.wire.Message<DisplayName, Builder> {
        public static final ProtoAdapter<DisplayName> ADAPTER = null;
        public static final Integer DEFAULT_BG_BORDER_WIDTH = null;
        public static final String DEFAULT_DISPLAY_NAME = "";
        private static final long serialVersionUID = 0;
        public final ImageSetPassThrough background_img;
        public final Integer bg_border_width;
        public final ImageSetPassThrough bg_img_dot_9;
        public final String display_name;

        public static final class Builder extends com.squareup.wire.Message.Builder<DisplayName, Builder> {
            public ImageSetPassThrough background_img;
            public Integer bg_border_width;
            public ImageSetPassThrough bg_img_dot_9;
            public String display_name;

            @Override // com.squareup.wire.Message.Builder
            public DisplayName build() {
                return new DisplayName(this.background_img, this.display_name, this.bg_border_width, this.bg_img_dot_9, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder background_img(ImageSetPassThrough r100) {
                this.background_img = r100;
                return this;
            }

            public Builder bg_border_width(Integer r100) {
                this.bg_border_width = r100;
                return this;
            }

            public Builder bg_img_dot_9(ImageSetPassThrough r100) {
                this.bg_img_dot_9 = r100;
                return this;
            }

            public Builder display_name(String r100) {
                this.display_name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DisplayName extends ProtoAdapter<DisplayName> {
            public ProtoAdapter_DisplayName() {
                super(FieldEncoding.LENGTH_DELIMITED, DisplayName.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DisplayName decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.display_name = "";
                r101.bg_border_width = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.background_img = ImageSetPassThrough.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.display_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.bg_border_width = ProtoAdapter.INT32.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.bg_img_dot_9 = ImageSetPassThrough.ADAPTER.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DisplayName r100) {
                ImageSetPassThrough r101 = r100.background_img;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.display_name;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Integer r107 = r100.bg_border_width;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                ImageSetPassThrough r110 = r100.bg_img_dot_9;
                if (r110 == null) goto L18;
                r102 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ DisplayName decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DisplayName r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DisplayName r101) throws IOException {
                ImageSetPassThrough r102 = r101.background_img;
                if (r102 == null) goto L5;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.display_name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Integer r104 = r101.bg_border_width;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
            L11:
                ImageSetPassThrough r105 = r101.bg_img_dot_9;
                if (r105 == null) goto L14;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DisplayName r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DisplayName();
            DEFAULT_BG_BORDER_WIDTH = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.background_img = this.background_img;
            r100.display_name = this.display_name;
            r100.bg_border_width = this.bg_border_width;
            r100.bg_img_dot_9 = this.bg_img_dot_9;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DisplayName.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DisplayName(ImageSetPassThrough r100, String r101, Integer r102, ImageSetPassThrough r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public DisplayName(ImageSetPassThrough r100, String r101, Integer r102, ImageSetPassThrough r103, ByteString r104) {
            super(ADAPTER, r104);
            this.background_img = r100;
            this.display_name = r101;
            this.bg_border_width = r102;
            this.bg_img_dot_9 = r103;
        }
    }

    public static final class ProtoAdapter_HongbaoCover extends ProtoAdapter<HongbaoCover> {
        public ProtoAdapter_HongbaoCover() {
            super(FieldEncoding.LENGTH_DELIMITED, HongbaoCover.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public HongbaoCover decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253506id = 0L;
            r101.name = "";
            r101.cover_type = CoverType.UNKNOWN;
            r101.company_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L20;
            switch(r103) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L22;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L22:
            r101.cover_type = CoverType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.company_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.display_name = DisplayName.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.select_cover = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.company_logo = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.head_cover = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.message_cover = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.main_cover = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.f253506id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(HongbaoCover r100) {
            Long r101 = r100.f253505id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            CoverType r107 = r100.cover_type;
            if (r107 == null) goto L13;
            int r108 = CoverType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ImageSetPassThrough r110 = r100.main_cover;
            if (r110 == null) goto L17;
            int r111 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ImageSetPassThrough r113 = r100.message_cover;
            if (r113 == null) goto L21;
            int r114 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            ImageSetPassThrough r116 = r100.head_cover;
            if (r116 == null) goto L25;
            int r117 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            ImageSetPassThrough r119 = r100.company_logo;
            if (r119 == null) goto L29;
            int r120 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            ImageSetPassThrough r122 = r100.select_cover;
            if (r122 == null) goto L33;
            int r123 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            DisplayName r125 = r100.display_name;
            if (r125 == null) goto L37;
            int r126 = DisplayName.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.company_name;
            if (r128 == null) goto L42;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            return (r127 + r102) + r100.unknownFields().size();
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
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
        public /* bridge */ /* synthetic */ HongbaoCover decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HongbaoCover r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HongbaoCover r101) throws IOException {
            Long r102 = r101.f253505id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            CoverType r104 = r101.cover_type;
            if (r104 == null) goto L11;
            CoverType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            ImageSetPassThrough r105 = r101.main_cover;
            if (r105 == null) goto L14;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            ImageSetPassThrough r106 = r101.message_cover;
            if (r106 == null) goto L17;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            ImageSetPassThrough r107 = r101.head_cover;
            if (r107 == null) goto L20;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            ImageSetPassThrough r108 = r101.company_logo;
            if (r108 == null) goto L23;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            ImageSetPassThrough r109 = r101.select_cover;
            if (r109 == null) goto L26;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            DisplayName r110 = r101.display_name;
            if (r110 == null) goto L29;
            DisplayName.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.company_name;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HongbaoCover r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HongbaoCover();
        DEFAULT_ID = 0L;
        DEFAULT_COVER_TYPE = CoverType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253506id = this.f253505id;
        r100.name = this.name;
        r100.cover_type = this.cover_type;
        r100.main_cover = this.main_cover;
        r100.message_cover = this.message_cover;
        r100.head_cover = this.head_cover;
        r100.company_logo = this.company_logo;
        r100.select_cover = this.select_cover;
        r100.display_name = this.display_name;
        r100.company_name = this.company_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HongbaoCover.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public HongbaoCover(Long r110, String r111, CoverType r112, ImageSetPassThrough r113, ImageSetPassThrough r114, ImageSetPassThrough r115, ImageSetPassThrough r116, ImageSetPassThrough r210, DisplayName r211, String r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public HongbaoCover(Long r100, String r101, CoverType r102, ImageSetPassThrough r103, ImageSetPassThrough r104, ImageSetPassThrough r105, ImageSetPassThrough r106, ImageSetPassThrough r107, DisplayName r110, String r111, ByteString r112) {
        super(ADAPTER, r112);
        this.f253505id = r100;
        this.name = r101;
        this.cover_type = r102;
        this.main_cover = r103;
        this.message_cover = r104;
        this.head_cover = r105;
        this.company_logo = r106;
        this.select_cover = r107;
        this.display_name = r110;
        this.company_name = r111;
    }
}
