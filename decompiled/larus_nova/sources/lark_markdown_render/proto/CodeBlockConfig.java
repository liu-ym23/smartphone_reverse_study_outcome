package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class CodeBlockConfig extends Message<CodeBlockConfig, Builder> {
    public static final ProtoAdapter<CodeBlockConfig> ADAPTER = null;
    public static final String DEFAULT_BACKGROUND_COLOR = "";
    public static final String DEFAULT_BORDER_COLOR = "";
    public static final Float DEFAULT_BORDER_RADIUS = null;
    public static final Float DEFAULT_BORDER_WIDTH = null;
    public static final String DEFAULT_CAPTION_COLOR = "";
    public static final Float DEFAULT_COPY_SIZE = null;
    public static final Float DEFAULT_FONT_SIZE = null;
    public static final FontStyle DEFAULT_FONT_STYLE = null;
    public static final String DEFAULT_HEADER_BACKGROUND_COLOR = "";
    public static final Float DEFAULT_HEADER_HEIGHT = null;
    public static final Float DEFAULT_LINE_HEIGHT = null;
    public static final Float DEFAULT_PADDING = null;
    private static final long serialVersionUID = 0;
    public final String background_color;
    public final String border_color;
    public final Float border_radius;
    public final Float border_width;
    public final String caption_color;
    public final Float copy_size;
    public final Float font_size;
    public final FontStyle font_style;
    public final String header_background_color;
    public final Float header_height;
    public final EdgeInsets header_padding;
    public final Float line_height;
    public final Float padding;

    public static final class Builder extends Message.Builder<CodeBlockConfig, Builder> {
        public String background_color;
        public String border_color;
        public Float border_radius;
        public Float border_width;
        public String caption_color;
        public Float copy_size;
        public Float font_size;
        public FontStyle font_style;
        public String header_background_color;
        public Float header_height;
        public EdgeInsets header_padding;
        public Float line_height;
        public Float padding;

        @Override // com.squareup.wire.Message.Builder
        public CodeBlockConfig build() {
            return new CodeBlockConfig(this.font_size, this.font_style, this.line_height, this.caption_color, this.background_color, this.header_height, this.copy_size, this.header_background_color, this.border_radius, this.border_width, this.border_color, this.padding, this.header_padding, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder background_color(String r100) {
            this.background_color = r100;
            return this;
        }

        public Builder border_color(String r100) {
            this.border_color = r100;
            return this;
        }

        public Builder border_radius(Float r100) {
            this.border_radius = r100;
            return this;
        }

        public Builder border_width(Float r100) {
            this.border_width = r100;
            return this;
        }

        public Builder caption_color(String r100) {
            this.caption_color = r100;
            return this;
        }

        public Builder copy_size(Float r100) {
            this.copy_size = r100;
            return this;
        }

        public Builder font_size(Float r100) {
            this.font_size = r100;
            return this;
        }

        public Builder font_style(FontStyle r100) {
            this.font_style = r100;
            return this;
        }

        public Builder header_background_color(String r100) {
            this.header_background_color = r100;
            return this;
        }

        public Builder header_height(Float r100) {
            this.header_height = r100;
            return this;
        }

        public Builder header_padding(EdgeInsets r100) {
            this.header_padding = r100;
            return this;
        }

        public Builder line_height(Float r100) {
            this.line_height = r100;
            return this;
        }

        public Builder padding(Float r100) {
            this.padding = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CodeBlockConfig extends ProtoAdapter<CodeBlockConfig> {
        public ProtoAdapter_CodeBlockConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, CodeBlockConfig.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public CodeBlockConfig decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L23;
            switch(r103) {
                case 1: goto L22;
                case 2: goto L25;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L25:
            r101.font_style = FontStyle.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.header_padding = EdgeInsets.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.padding = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L9:
            r101.border_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.border_width = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L11:
            r101.border_radius = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L12:
            r101.header_background_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.copy_size = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L14:
            r101.header_height = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L15:
            r101.background_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.caption_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.line_height = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L22:
            r101.font_size = ProtoAdapter.FLOAT.decode(r100);
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
        public int encodedSize2(CodeBlockConfig r100) {
            Float r101 = r100.font_size;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.FLOAT.encodedSizeWithTag(1, r101);
        L6:
            FontStyle r104 = r100.font_style;
            if (r104 == null) goto L9;
            int r105 = FontStyle.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Float r107 = r100.line_height;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.caption_color;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.background_color;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Float r116 = r100.header_height;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.FLOAT.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Float r119 = r100.copy_size;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.FLOAT.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.header_background_color;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Float r125 = r100.border_radius;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.FLOAT.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Float r128 = r100.border_width;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.FLOAT.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.border_color;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.STRING.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            Float r134 = r100.padding;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.FLOAT.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            EdgeInsets r137 = r100.header_padding;
            if (r137 == null) goto L54;
            r102 = EdgeInsets.ADAPTER.encodedSizeWithTag(13, r137);
        L54:
            return (r136 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ CodeBlockConfig decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CodeBlockConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CodeBlockConfig r101) throws IOException {
            Float r102 = r101.font_size;
            if (r102 == null) goto L5;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 1, r102);
        L5:
            FontStyle r103 = r101.font_style;
            if (r103 == null) goto L8;
            FontStyle.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Float r104 = r101.line_height;
            if (r104 == null) goto L11;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.caption_color;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.background_color;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Float r107 = r101.header_height;
            if (r107 == null) goto L20;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 6, r107);
        L20:
            Float r108 = r101.copy_size;
            if (r108 == null) goto L23;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.header_background_color;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            Float r110 = r101.border_radius;
            if (r110 == null) goto L29;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 9, r110);
        L29:
            Float r111 = r101.border_width;
            if (r111 == null) goto L32;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 10, r111);
        L32:
            String r112 = r101.border_color;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r112);
        L35:
            Float r113 = r101.padding;
            if (r113 == null) goto L38;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 12, r113);
        L38:
            EdgeInsets r114 = r101.header_padding;
            if (r114 == null) goto L41;
            EdgeInsets.ADAPTER.encodeWithTag(r100, 13, r114);
        L41:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CodeBlockConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CodeBlockConfig();
        Float r100 = Float.valueOf(0.0f);
        DEFAULT_FONT_SIZE = r100;
        DEFAULT_FONT_STYLE = FontStyle.VAR_FONT_STYLE_NORMAL;
        DEFAULT_LINE_HEIGHT = r100;
        DEFAULT_HEADER_HEIGHT = r100;
        DEFAULT_COPY_SIZE = r100;
        DEFAULT_BORDER_RADIUS = r100;
        DEFAULT_BORDER_WIDTH = r100;
        DEFAULT_PADDING = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.font_size = this.font_size;
        r100.font_style = this.font_style;
        r100.line_height = this.line_height;
        r100.caption_color = this.caption_color;
        r100.background_color = this.background_color;
        r100.header_height = this.header_height;
        r100.copy_size = this.copy_size;
        r100.header_background_color = this.header_background_color;
        r100.border_radius = this.border_radius;
        r100.border_width = this.border_width;
        r100.border_color = this.border_color;
        r100.padding = this.padding;
        r100.header_padding = this.header_padding;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CodeBlockConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CodeBlockConfig(Float r110, FontStyle r111, Float r112, String r113, String r210, Float r211, Float r212, String r213, Float r214, Float r215, String r216, Float r217, EdgeInsets r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public CodeBlockConfig(Float r100, FontStyle r101, Float r102, String r103, String r104, Float r105, Float r106, String r107, Float r110, Float r111, String r112, Float r113, EdgeInsets r114, ByteString r115) {
        super(ADAPTER, r115);
        this.font_size = r100;
        this.font_style = r101;
        this.line_height = r102;
        this.caption_color = r103;
        this.background_color = r104;
        this.header_height = r105;
        this.copy_size = r106;
        this.header_background_color = r107;
        this.border_radius = r110;
        this.border_width = r111;
        this.border_color = r112;
        this.padding = r113;
        this.header_padding = r114;
    }
}
