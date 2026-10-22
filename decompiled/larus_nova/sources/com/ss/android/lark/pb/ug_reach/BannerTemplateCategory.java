package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class BannerTemplateCategory extends Message<BannerTemplateCategory, Builder> {
    public static final ProtoAdapter<BannerTemplateCategory> ADAPTER = null;
    public static final String DEFAULT_BACKGROUND_COLOR = "";
    public static final String DEFAULT_CTA_BACKGROUND_COLOR = "";
    public static final String DEFAULT_CTA_FRAME_COLOR = "";
    public static final String DEFAULT_CTA_SHADOW_COLOR = "";
    public static final String DEFAULT_CTA_TITLE_COLOR = "";
    public static final String DEFAULT_FRAME_COLOR = "";
    public static final Integer DEFAULT_TEMPLATE_NUM = null;
    private static final long serialVersionUID = 0;
    public final String mbackground_color;
    public final TextElement mcategory_name;
    public final String mcta_background_color;
    public final String mcta_frame_color;
    public final String mcta_shadow_color;
    public final TextElement mcta_title;
    public final String mcta_title_color;
    public final List<ImageElement> mdym_pics;
    public final String mframe_color;
    public final ImageElement mfront_pic;
    public final TextElement mlink;
    public final Integer mtemplate_num;

    public static final class Builder extends Message.Builder<BannerTemplateCategory, Builder> {
        public String mbackground_color;
        public TextElement mcategory_name;
        public String mcta_background_color;
        public String mcta_frame_color;
        public String mcta_shadow_color;
        public TextElement mcta_title;
        public String mcta_title_color;
        public List<ImageElement> mdym_pics;
        public String mframe_color;
        public ImageElement mfront_pic;
        public TextElement mlink;
        public Integer mtemplate_num;

        @Override // com.squareup.wire.Message.Builder
        public BannerTemplateCategory build() {
            return new BannerTemplateCategory(this.mbackground_color, this.mfront_pic, this.mcategory_name, this.mlink, this.mtemplate_num, this.mdym_pics, this.mcta_title, this.mcta_title_color, this.mframe_color, this.mcta_frame_color, this.mcta_background_color, this.mcta_shadow_color, super.buildUnknownFields());
        }

        public Builder() {
            this.mdym_pics = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder background_color(String r100) {
            this.mbackground_color = r100;
            return this;
        }

        public Builder category_name(TextElement r100) {
            this.mcategory_name = r100;
            return this;
        }

        public Builder cta_background_color(String r100) {
            this.mcta_background_color = r100;
            return this;
        }

        public Builder cta_frame_color(String r100) {
            this.mcta_frame_color = r100;
            return this;
        }

        public Builder cta_shadow_color(String r100) {
            this.mcta_shadow_color = r100;
            return this;
        }

        public Builder cta_title(TextElement r100) {
            this.mcta_title = r100;
            return this;
        }

        public Builder cta_title_color(String r100) {
            this.mcta_title_color = r100;
            return this;
        }

        public Builder dym_pics(List<ImageElement> r100) {
            Internal.checkElementsNotNull(r100);
            this.mdym_pics = r100;
            return this;
        }

        public Builder frame_color(String r100) {
            this.mframe_color = r100;
            return this;
        }

        public Builder front_pic(ImageElement r100) {
            this.mfront_pic = r100;
            return this;
        }

        public Builder link(TextElement r100) {
            this.mlink = r100;
            return this;
        }

        public Builder template_num(Integer r100) {
            this.mtemplate_num = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerTemplateCategory extends ProtoAdapter<BannerTemplateCategory> {
        public ProtoAdapter_BannerTemplateCategory() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerTemplateCategory.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BannerTemplateCategory decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mbackground_color = "";
            r101.mtemplate_num = 0;
            r101.mcta_title_color = "";
            r101.mframe_color = "";
            r101.mcta_frame_color = "";
            r101.mcta_background_color = "";
            r101.mcta_shadow_color = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            r101.mcta_shadow_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mcta_background_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mcta_frame_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mframe_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mcta_title_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mcta_title = TextElement.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.mdym_pics.add(ImageElement.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.mtemplate_num = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.mlink = TextElement.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.mcategory_name = TextElement.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.mfront_pic = ImageElement.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.mbackground_color = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(BannerTemplateCategory r100) {
            String r101 = r100.mbackground_color;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ImageElement r104 = r100.mfront_pic;
            if (r104 == null) goto L9;
            int r105 = ImageElement.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TextElement r107 = r100.mcategory_name;
            if (r107 == null) goto L13;
            int r108 = TextElement.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TextElement r110 = r100.mlink;
            if (r110 == null) goto L17;
            int r111 = TextElement.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.mtemplate_num;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L22:
            int r115 = (r112 + r114) + ImageElement.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.mdym_pics);
            TextElement r116 = r100.mcta_title;
            if (r116 == null) goto L25;
            int r117 = TextElement.ADAPTER.encodedSizeWithTag(7, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.mcta_title_color;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(8, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.mframe_color;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(9, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.mcta_frame_color;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(10, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.mcta_background_color;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(11, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.mcta_shadow_color;
            if (r131 == null) goto L46;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(12, r131);
        L46:
            return (r130 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ BannerTemplateCategory decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BannerTemplateCategory r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BannerTemplateCategory r101) throws IOException {
            String r102 = r101.mbackground_color;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ImageElement r103 = r101.mfront_pic;
            if (r103 == null) goto L8;
            ImageElement.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TextElement r104 = r101.mcategory_name;
            if (r104 == null) goto L11;
            TextElement.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TextElement r105 = r101.mlink;
            if (r105 == null) goto L14;
            TextElement.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Integer r106 = r101.mtemplate_num;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L17:
            ImageElement.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.mdym_pics);
            TextElement r107 = r101.mcta_title;
            if (r107 == null) goto L20;
            TextElement.ADAPTER.encodeWithTag(r100, 7, r107);
        L20:
            String r108 = r101.mcta_title_color;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r108);
        L23:
            String r109 = r101.mframe_color;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r109);
        L26:
            String r110 = r101.mcta_frame_color;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r110);
        L29:
            String r111 = r101.mcta_background_color;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r111);
        L32:
            String r112 = r101.mcta_shadow_color;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 12, r112);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BannerTemplateCategory r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerTemplateCategory();
        DEFAULT_TEMPLATE_NUM = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mbackground_color = this.mbackground_color;
        r100.mfront_pic = this.mfront_pic;
        r100.mcategory_name = this.mcategory_name;
        r100.mlink = this.mlink;
        r100.mtemplate_num = this.mtemplate_num;
        r100.mdym_pics = Internal.copyOf("mdym_pics", this.mdym_pics);
        r100.mcta_title = this.mcta_title;
        r100.mcta_title_color = this.mcta_title_color;
        r100.mframe_color = this.mframe_color;
        r100.mcta_frame_color = this.mcta_frame_color;
        r100.mcta_background_color = this.mcta_background_color;
        r100.mcta_shadow_color = this.mcta_shadow_color;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BannerTemplateCategory.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BannerTemplateCategory(String r110, ImageElement r111, TextElement r112, TextElement r113, Integer r114, List<ImageElement> r210, TextElement r211, String r212, String r213, String r214, String r215, String r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public BannerTemplateCategory(String r100, ImageElement r101, TextElement r102, TextElement r103, Integer r104, List<ImageElement> r105, TextElement r106, String r107, String r110, String r111, String r112, String r113, ByteString r114) {
        super(ADAPTER, r114);
        this.mbackground_color = r100;
        this.mfront_pic = r101;
        this.mcategory_name = r102;
        this.mlink = r103;
        this.mtemplate_num = r104;
        this.mdym_pics = Internal.immutableCopyOf("mdym_pics", r105);
        this.mcta_title = r106;
        this.mcta_title_color = r107;
        this.mframe_color = r110;
        this.mcta_frame_color = r111;
        this.mcta_background_color = r112;
        this.mcta_shadow_color = r113;
    }
}
