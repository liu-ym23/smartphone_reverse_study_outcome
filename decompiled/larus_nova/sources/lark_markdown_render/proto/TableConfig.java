package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class TableConfig extends Message<TableConfig, Builder> {
    public static final ProtoAdapter<TableConfig> ADAPTER = null;
    public static final String DEFAULT_CELL_BACKGROUND_COLOR = "";
    public static final Float DEFAULT_CELL_MAX_WIDTH = null;
    public static final Float DEFAULT_CELL_MIN_WIDTH = null;
    public static final Float DEFAULT_CELL_PADDING = null;
    public static final String DEFAULT_HEADER_BACKGROUND_COLOR = "";
    public static final String DEFAULT_TABLE_BORDER_COLOR = "";
    public static final Float DEFAULT_TABLE_BORDER_RADIUS = null;
    public static final Float DEFAULT_TABLE_BORDER_WIDTH = null;
    public static final Float DEFAULT_TABLE_FONT_SIZE = null;
    public static final Float DEFAULT_TABLE_LINE_HEIGHT = null;
    private static final long serialVersionUID = 0;
    public final String cell_background_color;
    public final Float cell_max_width;
    public final Float cell_min_width;
    public final Float cell_padding;
    public final EdgeInsets cell_padding_insets;
    public final String header_background_color;
    public final String table_border_color;
    public final Float table_border_radius;
    public final Float table_border_width;
    public final Float table_font_size;
    public final Float table_line_height;

    public static final class Builder extends Message.Builder<TableConfig, Builder> {
        public String cell_background_color;
        public Float cell_max_width;
        public Float cell_min_width;
        public Float cell_padding;
        public EdgeInsets cell_padding_insets;
        public String header_background_color;
        public String table_border_color;
        public Float table_border_radius;
        public Float table_border_width;
        public Float table_font_size;
        public Float table_line_height;

        @Override // com.squareup.wire.Message.Builder
        public TableConfig build() {
            return new TableConfig(this.header_background_color, this.cell_background_color, this.table_border_color, this.table_font_size, this.table_line_height, this.cell_min_width, this.cell_max_width, this.table_border_width, this.table_border_radius, this.cell_padding, this.cell_padding_insets, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cell_background_color(String r100) {
            this.cell_background_color = r100;
            return this;
        }

        public Builder cell_max_width(Float r100) {
            this.cell_max_width = r100;
            return this;
        }

        public Builder cell_min_width(Float r100) {
            this.cell_min_width = r100;
            return this;
        }

        public Builder cell_padding(Float r100) {
            this.cell_padding = r100;
            return this;
        }

        public Builder cell_padding_insets(EdgeInsets r100) {
            this.cell_padding_insets = r100;
            return this;
        }

        public Builder header_background_color(String r100) {
            this.header_background_color = r100;
            return this;
        }

        public Builder table_border_color(String r100) {
            this.table_border_color = r100;
            return this;
        }

        public Builder table_border_radius(Float r100) {
            this.table_border_radius = r100;
            return this;
        }

        public Builder table_border_width(Float r100) {
            this.table_border_width = r100;
            return this;
        }

        public Builder table_font_size(Float r100) {
            this.table_font_size = r100;
            return this;
        }

        public Builder table_line_height(Float r100) {
            this.table_line_height = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TableConfig extends ProtoAdapter<TableConfig> {
        public ProtoAdapter_TableConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, TableConfig.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public TableConfig decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r101.cell_padding_insets = EdgeInsets.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.cell_padding = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L9:
            r101.table_border_radius = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L10:
            r101.table_border_width = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L11:
            r101.cell_max_width = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L12:
            r101.cell_min_width = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L13:
            r101.table_line_height = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L14:
            r101.table_font_size = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L15:
            r101.table_border_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.cell_background_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.header_background_color = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(TableConfig r100) {
            String r101 = r100.header_background_color;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.cell_background_color;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.table_border_color;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Float r110 = r100.table_font_size;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Float r113 = r100.table_line_height;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.FLOAT.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Float r116 = r100.cell_min_width;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.FLOAT.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Float r119 = r100.cell_max_width;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.FLOAT.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Float r122 = r100.table_border_width;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.FLOAT.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Float r125 = r100.table_border_radius;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.FLOAT.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Float r128 = r100.cell_padding;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.FLOAT.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            EdgeInsets r131 = r100.cell_padding_insets;
            if (r131 == null) goto L46;
            r102 = EdgeInsets.ADAPTER.encodedSizeWithTag(11, r131);
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
        public /* bridge */ /* synthetic */ TableConfig decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TableConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TableConfig r101) throws IOException {
            String r102 = r101.header_background_color;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.cell_background_color;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.table_border_color;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Float r105 = r101.table_font_size;
            if (r105 == null) goto L14;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 4, r105);
        L14:
            Float r106 = r101.table_line_height;
            if (r106 == null) goto L17;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 5, r106);
        L17:
            Float r107 = r101.cell_min_width;
            if (r107 == null) goto L20;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 6, r107);
        L20:
            Float r108 = r101.cell_max_width;
            if (r108 == null) goto L23;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 7, r108);
        L23:
            Float r109 = r101.table_border_width;
            if (r109 == null) goto L26;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 8, r109);
        L26:
            Float r110 = r101.table_border_radius;
            if (r110 == null) goto L29;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 9, r110);
        L29:
            Float r111 = r101.cell_padding;
            if (r111 == null) goto L32;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 10, r111);
        L32:
            EdgeInsets r112 = r101.cell_padding_insets;
            if (r112 == null) goto L35;
            EdgeInsets.ADAPTER.encodeWithTag(r100, 11, r112);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TableConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TableConfig();
        Float r100 = Float.valueOf(0.0f);
        DEFAULT_TABLE_FONT_SIZE = r100;
        DEFAULT_TABLE_LINE_HEIGHT = r100;
        DEFAULT_CELL_MIN_WIDTH = r100;
        DEFAULT_CELL_MAX_WIDTH = r100;
        DEFAULT_TABLE_BORDER_WIDTH = r100;
        DEFAULT_TABLE_BORDER_RADIUS = r100;
        DEFAULT_CELL_PADDING = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.header_background_color = this.header_background_color;
        r100.cell_background_color = this.cell_background_color;
        r100.table_border_color = this.table_border_color;
        r100.table_font_size = this.table_font_size;
        r100.table_line_height = this.table_line_height;
        r100.cell_min_width = this.cell_min_width;
        r100.cell_max_width = this.cell_max_width;
        r100.table_border_width = this.table_border_width;
        r100.table_border_radius = this.table_border_radius;
        r100.cell_padding = this.cell_padding;
        r100.cell_padding_insets = this.cell_padding_insets;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TableConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TableConfig(String r110, String r111, String r112, Float r113, Float r114, Float r115, Float r210, Float r211, Float r212, Float r213, EdgeInsets r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public TableConfig(String r100, String r101, String r102, Float r103, Float r104, Float r105, Float r106, Float r107, Float r110, Float r111, EdgeInsets r112, ByteString r113) {
        super(ADAPTER, r113);
        this.header_background_color = r100;
        this.cell_background_color = r101;
        this.table_border_color = r102;
        this.table_font_size = r103;
        this.table_line_height = r104;
        this.cell_min_width = r105;
        this.cell_max_width = r106;
        this.table_border_width = r107;
        this.table_border_radius = r110;
        this.cell_padding = r111;
        this.cell_padding_insets = r112;
    }
}
