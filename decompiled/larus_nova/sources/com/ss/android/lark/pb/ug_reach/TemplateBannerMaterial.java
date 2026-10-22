package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class TemplateBannerMaterial extends Message<TemplateBannerMaterial, Builder> {
    public static final ProtoAdapter<TemplateBannerMaterial> ADAPTER = null;
    public static final String DEFAULT_BACKGROUND_COLOR = "";
    public static final Boolean DEFAULT_BANNER_CLOSEABLE = null;
    public static final String DEFAULT_BANNER_CLOSEABLE_COLOR = "";
    public static final String DEFAULT_FRAME_COLOR = "";
    public static final String DEFAULT_SUB_TITLE_COLOR = "";
    public static final String DEFAULT_TITLE_COLOR = "";
    private static final long serialVersionUID = 0;
    public final String mbackground_color;
    public final ImageElement mbackground_pic;
    public final Boolean mbanner_closeable;
    public final String mbanner_closeable_color;
    public final ImageElement mbanner_icon;
    public final String mframe_color;
    public final Layout mlayout;
    public final TextElement msub_title;
    public final String msub_title_color;
    public final List<BannerTemplateCategory> mtemplate_categories;
    public final BannerTemplateMore mtemplate_more;
    public final TextElement mtitle;
    public final String mtitle_color;

    public static final class Builder extends Message.Builder<TemplateBannerMaterial, Builder> {
        public String mbackground_color;
        public ImageElement mbackground_pic;
        public Boolean mbanner_closeable;
        public String mbanner_closeable_color;
        public ImageElement mbanner_icon;
        public String mframe_color;
        public Layout mlayout;
        public TextElement msub_title;
        public String msub_title_color;
        public List<BannerTemplateCategory> mtemplate_categories;
        public BannerTemplateMore mtemplate_more;
        public TextElement mtitle;
        public String mtitle_color;

        @Override // com.squareup.wire.Message.Builder
        public TemplateBannerMaterial build() {
            return new TemplateBannerMaterial(this.mbackground_color, this.mbanner_icon, this.mbackground_pic, this.mtitle, this.mtitle_color, this.mbanner_closeable, this.mbanner_closeable_color, this.mlayout, this.mtemplate_categories, this.mtemplate_more, this.mframe_color, this.msub_title, this.msub_title_color, super.buildUnknownFields());
        }

        public Builder() {
            this.mtemplate_categories = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder background_color(String r100) {
            this.mbackground_color = r100;
            return this;
        }

        public Builder background_pic(ImageElement r100) {
            this.mbackground_pic = r100;
            return this;
        }

        public Builder banner_closeable(Boolean r100) {
            this.mbanner_closeable = r100;
            return this;
        }

        public Builder banner_closeable_color(String r100) {
            this.mbanner_closeable_color = r100;
            return this;
        }

        public Builder banner_icon(ImageElement r100) {
            this.mbanner_icon = r100;
            return this;
        }

        public Builder frame_color(String r100) {
            this.mframe_color = r100;
            return this;
        }

        public Builder layout(Layout r100) {
            this.mlayout = r100;
            return this;
        }

        public Builder sub_title(TextElement r100) {
            this.msub_title = r100;
            return this;
        }

        public Builder sub_title_color(String r100) {
            this.msub_title_color = r100;
            return this;
        }

        public Builder template_categories(List<BannerTemplateCategory> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtemplate_categories = r100;
            return this;
        }

        public Builder template_more(BannerTemplateMore r100) {
            this.mtemplate_more = r100;
            return this;
        }

        public Builder title(TextElement r100) {
            this.mtitle = r100;
            return this;
        }

        public Builder title_color(String r100) {
            this.mtitle_color = r100;
            return this;
        }
    }

    public static final enum Layout extends Enum<Layout> implements WireEnum {
        private static final /* synthetic */ Layout[] $VALUES = null;
        public static final ProtoAdapter<Layout> ADAPTER = null;
        public static final Layout STYLE1 = null;
        public static final Layout STYLE2 = null;
        public static final Layout STYLE3 = null;
        public static final Layout STYLE4 = null;
        public static final Layout UNKNOWN = null;
        private final int value;

        static {
            Layout r100 = new Layout("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Layout r101 = new Layout("STYLE1", 1, 1);
            STYLE1 = r101;
            Layout r102 = new Layout("STYLE2", 2, 2);
            STYLE2 = r102;
            Layout r103 = new Layout("STYLE3", 3, 3);
            STYLE3 = r103;
            Layout r104 = new Layout("STYLE4", 4, 4);
            STYLE4 = r104;
            $VALUES = new Layout[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(Layout.class);
        }

        public static Layout[] values() {
            return (Layout[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Layout fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return STYLE4;
        L16:
            return STYLE3;
        L18:
            return STYLE2;
        L20:
            return STYLE1;
        L22:
            return UNKNOWN;
        }

        public static Layout valueOf(String r100) {
            return (Layout) a.a(Layout.class, r100);
        }

        private Layout(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_TemplateBannerMaterial extends ProtoAdapter<TemplateBannerMaterial> {
        public ProtoAdapter_TemplateBannerMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, TemplateBannerMaterial.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TemplateBannerMaterial decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mbackground_color = "";
            r101.mtitle_color = "";
            r101.mbanner_closeable = Boolean.FALSE;
            r101.mbanner_closeable_color = "";
            r101.mframe_color = "";
            r101.msub_title_color = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L23;
            switch(r103) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L25;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L25:
            r101.mlayout = Layout.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.msub_title_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.msub_title = TextElement.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.mframe_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mtemplate_more = BannerTemplateMore.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.mtemplate_categories.add(BannerTemplateCategory.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.mbanner_closeable_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.mbanner_closeable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.mtitle_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.mtitle = TextElement.ADAPTER.decode(r100);
            goto L3
        L20:
            r101.mbackground_pic = ImageElement.ADAPTER.decode(r100);
            goto L3
        L21:
            r101.mbanner_icon = ImageElement.ADAPTER.decode(r100);
            goto L3
        L22:
            r101.mbackground_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L23:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TemplateBannerMaterial r100) {
            String r101 = r100.mbackground_color;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ImageElement r104 = r100.mbanner_icon;
            if (r104 == null) goto L9;
            int r105 = ImageElement.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ImageElement r107 = r100.mbackground_pic;
            if (r107 == null) goto L13;
            int r108 = ImageElement.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TextElement r110 = r100.mtitle;
            if (r110 == null) goto L17;
            int r111 = TextElement.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mtitle_color;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.mbanner_closeable;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.mbanner_closeable_color;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Layout r122 = r100.mlayout;
            if (r122 == null) goto L33;
            int r123 = Layout.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = (r121 + r123) + BannerTemplateCategory.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.mtemplate_categories);
            BannerTemplateMore r125 = r100.mtemplate_more;
            if (r125 == null) goto L37;
            int r126 = BannerTemplateMore.ADAPTER.encodedSizeWithTag(10, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.mframe_color;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(11, r128);
        L42:
            int r130 = r127 + r129;
            TextElement r131 = r100.msub_title;
            if (r131 == null) goto L45;
            int r132 = TextElement.ADAPTER.encodedSizeWithTag(12, r131);
        L46:
            int r133 = r130 + r132;
            String r134 = r100.msub_title_color;
            if (r134 == null) goto L50;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(13, r134);
        L50:
            return (r133 + r102) + r100.unknownFields().size();
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
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
        public /* bridge */ /* synthetic */ TemplateBannerMaterial decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TemplateBannerMaterial r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TemplateBannerMaterial r101) throws IOException {
            String r102 = r101.mbackground_color;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ImageElement r103 = r101.mbanner_icon;
            if (r103 == null) goto L8;
            ImageElement.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ImageElement r104 = r101.mbackground_pic;
            if (r104 == null) goto L11;
            ImageElement.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TextElement r105 = r101.mtitle;
            if (r105 == null) goto L14;
            TextElement.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mtitle_color;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.mbanner_closeable;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.mbanner_closeable_color;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            Layout r109 = r101.mlayout;
            if (r109 == null) goto L26;
            Layout.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            BannerTemplateCategory.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.mtemplate_categories);
            BannerTemplateMore r110 = r101.mtemplate_more;
            if (r110 == null) goto L29;
            BannerTemplateMore.ADAPTER.encodeWithTag(r100, 10, r110);
        L29:
            String r111 = r101.mframe_color;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r111);
        L32:
            TextElement r112 = r101.msub_title;
            if (r112 == null) goto L35;
            TextElement.ADAPTER.encodeWithTag(r100, 12, r112);
        L35:
            String r113 = r101.msub_title_color;
            if (r113 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r100, 13, r113);
        L38:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TemplateBannerMaterial r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TemplateBannerMaterial();
        DEFAULT_BANNER_CLOSEABLE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mbackground_color = this.mbackground_color;
        r100.mbanner_icon = this.mbanner_icon;
        r100.mbackground_pic = this.mbackground_pic;
        r100.mtitle = this.mtitle;
        r100.mtitle_color = this.mtitle_color;
        r100.mbanner_closeable = this.mbanner_closeable;
        r100.mbanner_closeable_color = this.mbanner_closeable_color;
        r100.mlayout = this.mlayout;
        r100.mtemplate_categories = Internal.copyOf("mtemplate_categories", this.mtemplate_categories);
        r100.mtemplate_more = this.mtemplate_more;
        r100.mframe_color = this.mframe_color;
        r100.msub_title = this.msub_title;
        r100.msub_title_color = this.msub_title_color;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TemplateBannerMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TemplateBannerMaterial(String r110, ImageElement r111, ImageElement r112, TextElement r113, String r210, Boolean r211, String r212, Layout r213, List<BannerTemplateCategory> r214, BannerTemplateMore r215, String r216, TextElement r217, String r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public TemplateBannerMaterial(String r100, ImageElement r101, ImageElement r102, TextElement r103, String r104, Boolean r105, String r106, Layout r107, List<BannerTemplateCategory> r110, BannerTemplateMore r111, String r112, TextElement r113, String r114, ByteString r115) {
        super(ADAPTER, r115);
        this.mbackground_color = r100;
        this.mbanner_icon = r101;
        this.mbackground_pic = r102;
        this.mtitle = r103;
        this.mtitle_color = r104;
        this.mbanner_closeable = r105;
        this.mbanner_closeable_color = r106;
        this.mlayout = r107;
        this.mtemplate_categories = Internal.immutableCopyOf("mtemplate_categories", r110);
        this.mtemplate_more = r111;
        this.mframe_color = r112;
        this.msub_title = r113;
        this.msub_title_color = r114;
    }
}
