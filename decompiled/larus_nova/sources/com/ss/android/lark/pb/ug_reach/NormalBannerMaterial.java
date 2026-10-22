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
public final class NormalBannerMaterial extends Message<NormalBannerMaterial, Builder> {
    public static final ProtoAdapter<NormalBannerMaterial> ADAPTER = null;
    public static final String DEFAULT_BACKGROUND_COLOR = "";
    public static final Boolean DEFAULT_BANNER_CLOSEABLE = null;
    public static final String DEFAULT_BANNER_CLOSEABLE_COLOR = "";
    public static final String DEFAULT_CTA_BACKGROUND_COLOR = "";
    public static final String DEFAULT_CTA_TITLE_COLOR = "";
    public static final String DEFAULT_FRAME_COLOR = "";
    public static final String DEFAULT_SUB_TITLE_COLOR = "";
    public static final String DEFAULT_TITLE_COLOR = "";
    private static final long serialVersionUID = 0;
    public final String mbackground_color;
    public final ImageElement mbackground_pic;
    public final Boolean mbanner_closeable;
    public final String mbanner_closeable_color;
    public final ImageElement mbanner_icon;
    public final TextElement mbutton_link;
    public final List<ButtonElement> mbuttons;
    public final String mcta_background_color;
    public final TextElement mcta_title;
    public final String mcta_title_color;
    public final String mframe_color;
    public final Layout mlayout;
    public final TextElement msub_title;
    public final String msub_title_color;
    public final TextElement mtitle;
    public final String mtitle_color;

    public static final class Builder extends Message.Builder<NormalBannerMaterial, Builder> {
        public String mbackground_color;
        public ImageElement mbackground_pic;
        public Boolean mbanner_closeable;
        public String mbanner_closeable_color;
        public ImageElement mbanner_icon;
        public TextElement mbutton_link;
        public List<ButtonElement> mbuttons;
        public String mcta_background_color;
        public TextElement mcta_title;
        public String mcta_title_color;
        public String mframe_color;
        public Layout mlayout;
        public TextElement msub_title;
        public String msub_title_color;
        public TextElement mtitle;
        public String mtitle_color;

        @Override // com.squareup.wire.Message.Builder
        public NormalBannerMaterial build() {
            return new NormalBannerMaterial(this.mbackground_color, this.mbanner_icon, this.mbackground_pic, this.mtitle, this.mtitle_color, this.msub_title, this.msub_title_color, this.mcta_title, this.mcta_title_color, this.mcta_background_color, this.mbanner_closeable, this.mbanner_closeable_color, this.mbutton_link, this.mlayout, this.mframe_color, this.mbuttons, super.buildUnknownFields());
        }

        public Builder() {
            this.mbuttons = Internal.newMutableList();
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

        public Builder button_link(TextElement r100) {
            this.mbutton_link = r100;
            return this;
        }

        public Builder buttons(List<ButtonElement> r100) {
            Internal.checkElementsNotNull(r100);
            this.mbuttons = r100;
            return this;
        }

        public Builder cta_background_color(String r100) {
            this.mcta_background_color = r100;
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
        public static final Layout UNKNOWN = null;
        private final int value;

        static {
            Layout r100 = new Layout("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Layout r101 = new Layout("STYLE1", 1, 1);
            STYLE1 = r101;
            Layout r102 = new Layout("STYLE2", 2, 2);
            STYLE2 = r102;
            $VALUES = new Layout[]{r100, r101, r102};
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
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return STYLE2;
        L12:
            return STYLE1;
        L14:
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

    public static final class ProtoAdapter_NormalBannerMaterial extends ProtoAdapter<NormalBannerMaterial> {
        public ProtoAdapter_NormalBannerMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, NormalBannerMaterial.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NormalBannerMaterial decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mbackground_color = "";
            r101.mtitle_color = "";
            r101.msub_title_color = "";
            r101.mcta_title_color = "";
            r101.mcta_background_color = "";
            r101.mbanner_closeable = Boolean.FALSE;
            r101.mbanner_closeable_color = "";
            r101.mframe_color = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L26;
            switch(r103) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L17;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L13;
                case 14: goto L28;
                case 15: goto L8;
                case 16: goto L7;
                default: goto L6;
            };
        L28:
            r101.mlayout = Layout.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mbuttons.add(ButtonElement.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.mframe_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mbutton_link = TextElement.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.mbanner_closeable_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mbanner_closeable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.mcta_background_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.mcta_title_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.mcta_title = TextElement.ADAPTER.decode(r100);
            goto L3
        L19:
            r101.msub_title_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.msub_title = TextElement.ADAPTER.decode(r100);
            goto L3
        L21:
            r101.mtitle_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.mtitle = TextElement.ADAPTER.decode(r100);
            goto L3
        L23:
            r101.mbackground_pic = ImageElement.ADAPTER.decode(r100);
            goto L3
        L24:
            r101.mbanner_icon = ImageElement.ADAPTER.decode(r100);
            goto L3
        L25:
            r101.mbackground_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L26:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(NormalBannerMaterial r100) {
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
            TextElement r116 = r100.msub_title;
            if (r116 == null) goto L25;
            int r117 = TextElement.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.msub_title_color;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            TextElement r122 = r100.mcta_title;
            if (r122 == null) goto L33;
            int r123 = TextElement.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.mcta_title_color;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.mcta_background_color;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.mbanner_closeable;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            String r134 = r100.mbanner_closeable_color;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.STRING.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            TextElement r137 = r100.mbutton_link;
            if (r137 == null) goto L53;
            int r138 = TextElement.ADAPTER.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            Layout r140 = r100.mlayout;
            if (r140 == null) goto L57;
            int r141 = Layout.ADAPTER.encodedSizeWithTag(14, r140);
        L58:
            int r142 = r139 + r141;
            String r143 = r100.mframe_color;
            if (r143 == null) goto L62;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(15, r143);
        L62:
            return ((r142 + r102) + ButtonElement.ADAPTER.asRepeated().encodedSizeWithTag(16, r100.mbuttons)) + r100.unknownFields().size();
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
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
        public /* bridge */ /* synthetic */ NormalBannerMaterial decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NormalBannerMaterial r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NormalBannerMaterial r101) throws IOException {
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
            TextElement r107 = r101.msub_title;
            if (r107 == null) goto L20;
            TextElement.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.msub_title_color;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            TextElement r109 = r101.mcta_title;
            if (r109 == null) goto L26;
            TextElement.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.mcta_title_color;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.mcta_background_color;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            Boolean r112 = r101.mbanner_closeable;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r112);
        L35:
            String r113 = r101.mbanner_closeable_color;
            if (r113 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r100, 12, r113);
        L38:
            TextElement r114 = r101.mbutton_link;
            if (r114 == null) goto L41;
            TextElement.ADAPTER.encodeWithTag(r100, 13, r114);
        L41:
            Layout r115 = r101.mlayout;
            if (r115 == null) goto L44;
            Layout.ADAPTER.encodeWithTag(r100, 14, r115);
        L44:
            String r116 = r101.mframe_color;
            if (r116 == null) goto L47;
            ProtoAdapter.STRING.encodeWithTag(r100, 15, r116);
        L47:
            ButtonElement.ADAPTER.asRepeated().encodeWithTag(r100, 16, r101.mbuttons);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NormalBannerMaterial r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NormalBannerMaterial();
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
        r100.msub_title = this.msub_title;
        r100.msub_title_color = this.msub_title_color;
        r100.mcta_title = this.mcta_title;
        r100.mcta_title_color = this.mcta_title_color;
        r100.mcta_background_color = this.mcta_background_color;
        r100.mbanner_closeable = this.mbanner_closeable;
        r100.mbanner_closeable_color = this.mbanner_closeable_color;
        r100.mbutton_link = this.mbutton_link;
        r100.mlayout = this.mlayout;
        r100.mframe_color = this.mframe_color;
        r100.mbuttons = Internal.copyOf("mbuttons", this.mbuttons);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NormalBannerMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public NormalBannerMaterial(String r110, ImageElement r210, ImageElement r211, TextElement r212, String r213, TextElement r214, String r215, TextElement r216, String r217, String r218, Boolean r219, String r310, TextElement r311, Layout r312, String r313, List<ButtonElement> r314) {
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, ByteString.EMPTY);
    }

    public NormalBannerMaterial(String r100, ImageElement r101, ImageElement r102, TextElement r103, String r104, TextElement r105, String r110, TextElement r111, String r112, String r113, Boolean r114, String r115, TextElement r116, Layout r117, String r118, List<ButtonElement> r119, ByteString r210) {
        super(ADAPTER, r210);
        this.mbackground_color = r100;
        this.mbanner_icon = r101;
        this.mbackground_pic = r102;
        this.mtitle = r103;
        this.mtitle_color = r104;
        this.msub_title = r105;
        this.msub_title_color = r110;
        this.mcta_title = r111;
        this.mcta_title_color = r112;
        this.mcta_background_color = r113;
        this.mbanner_closeable = r114;
        this.mbanner_closeable_color = r115;
        this.mbutton_link = r116;
        this.mlayout = r117;
        this.mframe_color = r118;
        this.mbuttons = Internal.immutableCopyOf("mbuttons", r119);
    }
}
