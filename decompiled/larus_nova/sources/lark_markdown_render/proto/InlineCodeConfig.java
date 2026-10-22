package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class InlineCodeConfig extends Message<InlineCodeConfig, Builder> {
    public static final ProtoAdapter<InlineCodeConfig> ADAPTER = null;
    public static final String DEFAULT_BACKGROUND_COLOR = "";
    public static final String DEFAULT_BORDER_COLOR = "";
    public static final Float DEFAULT_BORDER_RADIUS = null;
    public static final Float DEFAULT_BORDER_WIDTH = null;
    public static final Float DEFAULT_FONT_SIZE = null;
    public static final FontStyle DEFAULT_FONT_STYLE = null;
    public static final String DEFAULT_FOREGROUND_COLOR = "";
    public static final Float DEFAULT_HORIZONTAL_INNER_MARGIN = null;
    public static final Float DEFAULT_HORIZONTAL_MARGIN = null;
    public static final Float DEFAULT_LINE_HEIGHT = null;
    private static final long serialVersionUID = 0;
    public final String background_color;
    public final String border_color;
    public final Float border_radius;
    public final Float border_width;
    public final Float font_size;
    public final FontStyle font_style;
    public final String foreground_color;
    public final Float horizontal_inner_margin;
    public final Float horizontal_margin;
    public final Float line_height;

    public static final class Builder extends Message.Builder<InlineCodeConfig, Builder> {
        public String background_color;
        public String border_color;
        public Float border_radius;
        public Float border_width;
        public Float font_size;
        public FontStyle font_style;
        public String foreground_color;
        public Float horizontal_inner_margin;
        public Float horizontal_margin;
        public Float line_height;

        @Override // com.squareup.wire.Message.Builder
        public InlineCodeConfig build() {
            Float r100 = this.horizontal_margin;
            if (r100 == null) goto L13;
            if (this.horizontal_inner_margin == null) goto L13;
            if (this.border_width == null) goto L13;
            if (this.border_radius == null) goto L13;
            return new InlineCodeConfig(this.font_size, this.font_style, this.line_height, this.horizontal_margin, this.horizontal_inner_margin, this.background_color, this.foreground_color, this.border_color, this.border_width, this.border_radius, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "horizontal_margin", this.horizontal_inner_margin, "horizontal_inner_margin", this.border_width, "border_width", this.border_radius, "border_radius"});
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

        public Builder font_size(Float r100) {
            this.font_size = r100;
            return this;
        }

        public Builder font_style(FontStyle r100) {
            this.font_style = r100;
            return this;
        }

        public Builder foreground_color(String r100) {
            this.foreground_color = r100;
            return this;
        }

        public Builder horizontal_inner_margin(Float r100) {
            this.horizontal_inner_margin = r100;
            return this;
        }

        public Builder horizontal_margin(Float r100) {
            this.horizontal_margin = r100;
            return this;
        }

        public Builder line_height(Float r100) {
            this.line_height = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_InlineCodeConfig extends ProtoAdapter<InlineCodeConfig> {
        public ProtoAdapter_InlineCodeConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, InlineCodeConfig.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public InlineCodeConfig decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L20;
            switch(r103) {
                case 1: goto L19;
                case 2: goto L22;
                case 3: goto L14;
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
            r101.font_style = FontStyle.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.border_radius = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L8:
            r101.border_width = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L9:
            r101.border_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.foreground_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.background_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.horizontal_inner_margin = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L13:
            r101.horizontal_margin = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L14:
            r101.line_height = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L19:
            r101.font_size = ProtoAdapter.FLOAT.decode(r100);
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
        public int encodedSize2(InlineCodeConfig r100) {
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
            ProtoAdapter<Float> r110 = ProtoAdapter.FLOAT;
            int r111 = (r109 + r110.encodedSizeWithTag(4, r100.horizontal_margin)) + r110.encodedSizeWithTag(5, r100.horizontal_inner_margin);
            String r112 = r100.background_color;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.STRING.encodedSizeWithTag(6, r112);
        L18:
            int r114 = r111 + r113;
            String r115 = r100.foreground_color;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.STRING.encodedSizeWithTag(7, r115);
        L22:
            int r117 = r114 + r116;
            String r118 = r100.border_color;
            if (r118 == null) goto L26;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(8, r118);
        L26:
            return (((r117 + r102) + r110.encodedSizeWithTag(9, r100.border_width)) + r110.encodedSizeWithTag(10, r100.border_radius)) + r100.unknownFields().size();
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
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
        public /* bridge */ /* synthetic */ InlineCodeConfig decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(InlineCodeConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, InlineCodeConfig r101) throws IOException {
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
            ProtoAdapter<Float> r105 = ProtoAdapter.FLOAT;
            r105.encodeWithTag(r100, 4, r101.horizontal_margin);
            r105.encodeWithTag(r100, 5, r101.horizontal_inner_margin);
            String r106 = r101.background_color;
            if (r106 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
        L14:
            String r107 = r101.foreground_color;
            if (r107 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
        L17:
            String r108 = r101.border_color;
            if (r108 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r108);
        L20:
            r105.encodeWithTag(r100, 9, r101.border_width);
            r105.encodeWithTag(r100, 10, r101.border_radius);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InlineCodeConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_InlineCodeConfig();
        Float r100 = Float.valueOf(0.0f);
        DEFAULT_FONT_SIZE = r100;
        DEFAULT_FONT_STYLE = FontStyle.VAR_FONT_STYLE_NORMAL;
        DEFAULT_LINE_HEIGHT = r100;
        DEFAULT_HORIZONTAL_MARGIN = r100;
        DEFAULT_HORIZONTAL_INNER_MARGIN = r100;
        DEFAULT_BORDER_WIDTH = r100;
        DEFAULT_BORDER_RADIUS = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.font_size = this.font_size;
        r100.font_style = this.font_style;
        r100.line_height = this.line_height;
        r100.horizontal_margin = this.horizontal_margin;
        r100.horizontal_inner_margin = this.horizontal_inner_margin;
        r100.background_color = this.background_color;
        r100.foreground_color = this.foreground_color;
        r100.border_color = this.border_color;
        r100.border_width = this.border_width;
        r100.border_radius = this.border_radius;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return InlineCodeConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public InlineCodeConfig(Float r110, FontStyle r111, Float r112, Float r113, Float r114, String r115, String r116, String r210, Float r211, Float r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public InlineCodeConfig(Float r100, FontStyle r101, Float r102, Float r103, Float r104, String r105, String r106, String r107, Float r110, Float r111, ByteString r112) {
        super(ADAPTER, r112);
        this.font_size = r100;
        this.font_style = r101;
        this.line_height = r102;
        this.horizontal_margin = r103;
        this.horizontal_inner_margin = r104;
        this.background_color = r105;
        this.foreground_color = r106;
        this.border_color = r107;
        this.border_width = r110;
        this.border_radius = r111;
    }
}
