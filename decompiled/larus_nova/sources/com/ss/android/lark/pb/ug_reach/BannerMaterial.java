package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class BannerMaterial extends Message<BannerMaterial, Builder> {
    public static final ProtoAdapter<BannerMaterial> ADAPTER = null;
    public static final String DEFAULT_BANNER_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mbanner_name;
    public final BannerType mbanner_type;
    public final MaterialBase mbase;
    public final CarouselBanner mcarousel_banner;
    public final CustomBannerMaterial mcustom_banner;
    public final NormalBannerMaterial mnormal_banner;
    public final NormalBannerMaterial msidebar_banner;
    public final TemplateBannerMaterial mtemplate_banner;

    public static final enum BannerType extends Enum<BannerType> implements WireEnum {
        private static final /* synthetic */ BannerType[] $VALUES = null;
        public static final ProtoAdapter<BannerType> ADAPTER = null;
        public static final BannerType CAROUSEL = null;
        public static final BannerType CUSTOM = null;
        public static final BannerType NORMAL = null;
        public static final BannerType SIDEBAR = null;
        public static final BannerType TEMPLATE = null;
        public static final BannerType UNKNOWN = null;
        private final int value;

        static {
            BannerType r100 = new BannerType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            BannerType r101 = new BannerType(EffectConstants.NORMAL, 1, 1);
            NORMAL = r101;
            BannerType r102 = new BannerType("TEMPLATE", 2, 2);
            TEMPLATE = r102;
            BannerType r103 = new BannerType("CAROUSEL", 3, 3);
            CAROUSEL = r103;
            BannerType r104 = new BannerType("SIDEBAR", 4, 4);
            SIDEBAR = r104;
            BannerType r105 = new BannerType("CUSTOM", 5, 5);
            CUSTOM = r105;
            $VALUES = new BannerType[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(BannerType.class);
        }

        public static BannerType[] values() {
            return (BannerType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static BannerType fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return CUSTOM;
        L18:
            return SIDEBAR;
        L20:
            return CAROUSEL;
        L22:
            return TEMPLATE;
        L24:
            return NORMAL;
        L26:
            return UNKNOWN;
        }

        public static BannerType valueOf(String r100) {
            return (BannerType) a.a(BannerType.class, r100);
        }

        private BannerType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<BannerMaterial, Builder> {
        public String mbanner_name;
        public BannerType mbanner_type;
        public MaterialBase mbase;
        public CarouselBanner mcarousel_banner;
        public CustomBannerMaterial mcustom_banner;
        public NormalBannerMaterial mnormal_banner;
        public NormalBannerMaterial msidebar_banner;
        public TemplateBannerMaterial mtemplate_banner;

        @Override // com.squareup.wire.Message.Builder
        public BannerMaterial build() {
            return new BannerMaterial(this.mbanner_name, this.mbanner_type, this.mbase, this.mnormal_banner, this.mtemplate_banner, this.mcarousel_banner, this.msidebar_banner, this.mcustom_banner, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder banner_name(String r100) {
            this.mbanner_name = r100;
            return this;
        }

        public Builder banner_type(BannerType r100) {
            this.mbanner_type = r100;
            return this;
        }

        public Builder base(MaterialBase r100) {
            this.mbase = r100;
            return this;
        }

        public Builder carousel_banner(CarouselBanner r100) {
            this.mcarousel_banner = r100;
            this.mnormal_banner = null;
            this.mtemplate_banner = null;
            this.msidebar_banner = null;
            this.mcustom_banner = null;
            return this;
        }

        public Builder custom_banner(CustomBannerMaterial r100) {
            this.mcustom_banner = r100;
            this.mnormal_banner = null;
            this.mtemplate_banner = null;
            this.mcarousel_banner = null;
            this.msidebar_banner = null;
            return this;
        }

        public Builder normal_banner(NormalBannerMaterial r100) {
            this.mnormal_banner = r100;
            this.mtemplate_banner = null;
            this.mcarousel_banner = null;
            this.msidebar_banner = null;
            this.mcustom_banner = null;
            return this;
        }

        public Builder sidebar_banner(NormalBannerMaterial r100) {
            this.msidebar_banner = r100;
            this.mnormal_banner = null;
            this.mtemplate_banner = null;
            this.mcarousel_banner = null;
            this.mcustom_banner = null;
            return this;
        }

        public Builder template_banner(TemplateBannerMaterial r100) {
            this.mtemplate_banner = r100;
            this.mnormal_banner = null;
            this.mcarousel_banner = null;
            this.msidebar_banner = null;
            this.mcustom_banner = null;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerMaterial extends ProtoAdapter<BannerMaterial> {
        public ProtoAdapter_BannerMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerMaterial.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BannerMaterial decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mbanner_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L20;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.mbanner_type = BannerType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.custom_banner(CustomBannerMaterial.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.mbase = MaterialBase.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.sidebar_banner(NormalBannerMaterial.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.carousel_banner(CarouselBanner.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.template_banner(TemplateBannerMaterial.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.normal_banner(NormalBannerMaterial.ADAPTER.decode(r100));
            goto L3
        L17:
            r101.mbanner_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BannerMaterial r100) {
            String r101 = r100.mbanner_name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            BannerType r104 = r100.mbanner_type;
            if (r104 == null) goto L9;
            int r105 = BannerType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            MaterialBase r107 = r100.mbase;
            if (r107 == null) goto L13;
            int r108 = MaterialBase.ADAPTER.encodedSizeWithTag(7, r107);
        L14:
            int r109 = r106 + r108;
            NormalBannerMaterial r110 = r100.mnormal_banner;
            if (r110 == null) goto L17;
            int r111 = NormalBannerMaterial.ADAPTER.encodedSizeWithTag(3, r110);
        L18:
            int r112 = r109 + r111;
            TemplateBannerMaterial r113 = r100.mtemplate_banner;
            if (r113 == null) goto L21;
            int r114 = TemplateBannerMaterial.ADAPTER.encodedSizeWithTag(4, r113);
        L22:
            int r115 = r112 + r114;
            CarouselBanner r116 = r100.mcarousel_banner;
            if (r116 == null) goto L25;
            int r117 = CarouselBanner.ADAPTER.encodedSizeWithTag(5, r116);
        L26:
            int r118 = r115 + r117;
            NormalBannerMaterial r119 = r100.msidebar_banner;
            if (r119 == null) goto L29;
            int r120 = NormalBannerMaterial.ADAPTER.encodedSizeWithTag(6, r119);
        L30:
            int r121 = r118 + r120;
            CustomBannerMaterial r122 = r100.mcustom_banner;
            if (r122 == null) goto L34;
            r102 = CustomBannerMaterial.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            return (r121 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ BannerMaterial decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BannerMaterial r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BannerMaterial r101) throws IOException {
            String r102 = r101.mbanner_name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            BannerType r103 = r101.mbanner_type;
            if (r103 == null) goto L8;
            BannerType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            MaterialBase r104 = r101.mbase;
            if (r104 == null) goto L11;
            MaterialBase.ADAPTER.encodeWithTag(r100, 7, r104);
        L11:
            NormalBannerMaterial r105 = r101.mnormal_banner;
            if (r105 == null) goto L14;
            NormalBannerMaterial.ADAPTER.encodeWithTag(r100, 3, r105);
        L14:
            TemplateBannerMaterial r106 = r101.mtemplate_banner;
            if (r106 == null) goto L17;
            TemplateBannerMaterial.ADAPTER.encodeWithTag(r100, 4, r106);
        L17:
            CarouselBanner r107 = r101.mcarousel_banner;
            if (r107 == null) goto L20;
            CarouselBanner.ADAPTER.encodeWithTag(r100, 5, r107);
        L20:
            NormalBannerMaterial r108 = r101.msidebar_banner;
            if (r108 == null) goto L23;
            NormalBannerMaterial.ADAPTER.encodeWithTag(r100, 6, r108);
        L23:
            CustomBannerMaterial r109 = r101.mcustom_banner;
            if (r109 == null) goto L26;
            CustomBannerMaterial.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BannerMaterial r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerMaterial();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mbanner_name = this.mbanner_name;
        r100.mbanner_type = this.mbanner_type;
        r100.mbase = this.mbase;
        r100.mnormal_banner = this.mnormal_banner;
        r100.mtemplate_banner = this.mtemplate_banner;
        r100.mcarousel_banner = this.mcarousel_banner;
        r100.msidebar_banner = this.msidebar_banner;
        r100.mcustom_banner = this.mcustom_banner;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BannerMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BannerMaterial(String r110, BannerType r111, MaterialBase r112, NormalBannerMaterial r113, TemplateBannerMaterial r114, CarouselBanner r115, NormalBannerMaterial r116, CustomBannerMaterial r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public BannerMaterial(String r100, BannerType r101, MaterialBase r102, NormalBannerMaterial r103, TemplateBannerMaterial r104, CarouselBanner r105, NormalBannerMaterial r106, CustomBannerMaterial r110, ByteString r111) {
        super(ADAPTER, r111);
        if (Internal.countNonNull(r103, r104, r105, r106, new Object[]{r110}) > 1) goto L7;
        this.mbanner_name = r100;
        this.mbanner_type = r101;
        this.mbase = r102;
        this.mnormal_banner = r103;
        this.mtemplate_banner = r104;
        this.mcarousel_banner = r105;
        this.msidebar_banner = r106;
        this.mcustom_banner = r110;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mnormal_banner, mtemplate_banner, mcarousel_banner, msidebar_banner, mcustom_banner may be non-null");
    }
}
