package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class DocumentConfig extends Message<DocumentConfig, Builder> {
    public static final ProtoAdapter<DocumentConfig> ADAPTER = null;
    public static final String DEFAULT_BACKGROUND_COLOR = "";
    public static final Float DEFAULT_FONT_SIZE = null;
    public static final FontWeight DEFAULT_FONT_WEIGHT = null;
    public static final String DEFAULT_FOREGROUND_COLOR = "";
    public static final Float DEFAULT_HEADING_GAP = null;
    public static final Float DEFAULT_ITEM_GAP = null;
    public static final Float DEFAULT_LINE_HEIGHT = null;
    public static final Float DEFAULT_MEDIA_BLOCK_MARGIN_BOTTOM = null;
    public static final Float DEFAULT_MEDIA_BLOCK_MARGIN_TOP = null;
    public static final Float DEFAULT_PARAGRAPH_GAP = null;
    private static final long serialVersionUID = 0;
    public final String background_color;
    public final EdgeInsets doc_padding;
    public final Float font_size;
    public final FontWeight font_weight;
    public final String foreground_color;
    public final Float heading_gap;
    public final Float item_gap;
    public final Float line_height;
    public final Float media_block_margin_bottom;
    public final Float media_block_margin_top;
    public final Float paragraph_gap;
    public final EdgeInsets paragraph_padding;

    public static final class Builder extends Message.Builder<DocumentConfig, Builder> {
        public String background_color;
        public EdgeInsets doc_padding;
        public Float font_size;
        public FontWeight font_weight;
        public String foreground_color;
        public Float heading_gap;
        public Float item_gap;
        public Float line_height;
        public Float media_block_margin_bottom;
        public Float media_block_margin_top;
        public Float paragraph_gap;
        public EdgeInsets paragraph_padding;

        @Override // com.squareup.wire.Message.Builder
        public DocumentConfig build() {
            return new DocumentConfig(this.font_size, this.font_weight, this.heading_gap, this.paragraph_gap, this.media_block_margin_top, this.media_block_margin_bottom, this.item_gap, this.line_height, this.background_color, this.foreground_color, this.doc_padding, this.paragraph_padding, super.buildUnknownFields());
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

        public Builder doc_padding(EdgeInsets r100) {
            this.doc_padding = r100;
            return this;
        }

        public Builder font_size(Float r100) {
            this.font_size = r100;
            return this;
        }

        public Builder font_weight(FontWeight r100) {
            this.font_weight = r100;
            return this;
        }

        public Builder foreground_color(String r100) {
            this.foreground_color = r100;
            return this;
        }

        public Builder heading_gap(Float r100) {
            this.heading_gap = r100;
            return this;
        }

        public Builder item_gap(Float r100) {
            this.item_gap = r100;
            return this;
        }

        public Builder line_height(Float r100) {
            this.line_height = r100;
            return this;
        }

        public Builder media_block_margin_bottom(Float r100) {
            this.media_block_margin_bottom = r100;
            return this;
        }

        public Builder media_block_margin_top(Float r100) {
            this.media_block_margin_top = r100;
            return this;
        }

        public Builder paragraph_gap(Float r100) {
            this.paragraph_gap = r100;
            return this;
        }

        public Builder paragraph_padding(EdgeInsets r100) {
            this.paragraph_padding = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DocumentConfig extends ProtoAdapter<DocumentConfig> {
        public ProtoAdapter_DocumentConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, DocumentConfig.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public DocumentConfig decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L22;
            switch(r103) {
                case 1: goto L21;
                case 2: goto L24;
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
        L24:
            r101.font_weight = FontWeight.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.paragraph_padding = EdgeInsets.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.doc_padding = EdgeInsets.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.foreground_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.background_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.line_height = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L12:
            r101.item_gap = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L13:
            r101.media_block_margin_bottom = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L14:
            r101.media_block_margin_top = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L15:
            r101.paragraph_gap = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L16:
            r101.heading_gap = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L21:
            r101.font_size = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L22:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DocumentConfig r100) {
            Float r101 = r100.font_size;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.FLOAT.encodedSizeWithTag(1, r101);
        L6:
            FontWeight r104 = r100.font_weight;
            if (r104 == null) goto L9;
            int r105 = FontWeight.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Float r107 = r100.heading_gap;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Float r110 = r100.paragraph_gap;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Float r113 = r100.media_block_margin_top;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.FLOAT.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Float r116 = r100.media_block_margin_bottom;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.FLOAT.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Float r119 = r100.item_gap;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.FLOAT.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Float r122 = r100.line_height;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.FLOAT.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.background_color;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.foreground_color;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            EdgeInsets r131 = r100.doc_padding;
            if (r131 == null) goto L45;
            int r132 = EdgeInsets.ADAPTER.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            EdgeInsets r134 = r100.paragraph_padding;
            if (r134 == null) goto L50;
            r102 = EdgeInsets.ADAPTER.encodedSizeWithTag(12, r134);
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
        public /* bridge */ /* synthetic */ DocumentConfig decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DocumentConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DocumentConfig r101) throws IOException {
            Float r102 = r101.font_size;
            if (r102 == null) goto L5;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 1, r102);
        L5:
            FontWeight r103 = r101.font_weight;
            if (r103 == null) goto L8;
            FontWeight.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Float r104 = r101.heading_gap;
            if (r104 == null) goto L11;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r104);
        L11:
            Float r105 = r101.paragraph_gap;
            if (r105 == null) goto L14;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 4, r105);
        L14:
            Float r106 = r101.media_block_margin_top;
            if (r106 == null) goto L17;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 5, r106);
        L17:
            Float r107 = r101.media_block_margin_bottom;
            if (r107 == null) goto L20;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 6, r107);
        L20:
            Float r108 = r101.item_gap;
            if (r108 == null) goto L23;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 7, r108);
        L23:
            Float r109 = r101.line_height;
            if (r109 == null) goto L26;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.background_color;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.foreground_color;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            EdgeInsets r112 = r101.doc_padding;
            if (r112 == null) goto L35;
            EdgeInsets.ADAPTER.encodeWithTag(r100, 11, r112);
        L35:
            EdgeInsets r113 = r101.paragraph_padding;
            if (r113 == null) goto L38;
            EdgeInsets.ADAPTER.encodeWithTag(r100, 12, r113);
        L38:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocumentConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocumentConfig();
        Float r100 = Float.valueOf(0.0f);
        DEFAULT_FONT_SIZE = r100;
        DEFAULT_FONT_WEIGHT = FontWeight.VAR_FONT_WEIGHT_REGULAR;
        DEFAULT_HEADING_GAP = r100;
        DEFAULT_PARAGRAPH_GAP = r100;
        DEFAULT_MEDIA_BLOCK_MARGIN_TOP = r100;
        DEFAULT_MEDIA_BLOCK_MARGIN_BOTTOM = r100;
        DEFAULT_ITEM_GAP = r100;
        DEFAULT_LINE_HEIGHT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.font_size = this.font_size;
        r100.font_weight = this.font_weight;
        r100.heading_gap = this.heading_gap;
        r100.paragraph_gap = this.paragraph_gap;
        r100.media_block_margin_top = this.media_block_margin_top;
        r100.media_block_margin_bottom = this.media_block_margin_bottom;
        r100.item_gap = this.item_gap;
        r100.line_height = this.line_height;
        r100.background_color = this.background_color;
        r100.foreground_color = this.foreground_color;
        r100.doc_padding = this.doc_padding;
        r100.paragraph_padding = this.paragraph_padding;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DocumentConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DocumentConfig(Float r110, FontWeight r111, Float r112, Float r113, Float r114, Float r210, Float r211, Float r212, String r213, String r214, EdgeInsets r215, EdgeInsets r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public DocumentConfig(Float r100, FontWeight r101, Float r102, Float r103, Float r104, Float r105, Float r106, Float r107, String r110, String r111, EdgeInsets r112, EdgeInsets r113, ByteString r114) {
        super(ADAPTER, r114);
        this.font_size = r100;
        this.font_weight = r101;
        this.heading_gap = r102;
        this.paragraph_gap = r103;
        this.media_block_margin_top = r104;
        this.media_block_margin_bottom = r105;
        this.item_gap = r106;
        this.line_height = r107;
        this.background_color = r110;
        this.foreground_color = r111;
        this.doc_padding = r112;
        this.paragraph_padding = r113;
    }
}
