package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class ListConfig extends Message<ListConfig, Builder> {
    public static final ProtoAdapter<ListConfig> ADAPTER = null;
    public static final Float DEFAULT_BLOCK_GAP = null;
    public static final Float DEFAULT_ITEM_GAP = null;
    public static final String DEFAULT_ORDERED_MARKER_COLOR = "";
    public static final Float DEFAULT_ORDERED_MARKER_FONT_SIZE = null;
    public static final String DEFAULT_UNORDERED_MARKER_COLOR = "";
    public static final Float DEFAULT_UNORDERED_MARKER_FONT_SIZE = null;
    private static final long serialVersionUID = 0;
    public final Float block_gap;
    public final Float item_gap;
    public final EdgeInsets item_padding;
    public final String ordered_marker_color;
    public final Float ordered_marker_font_size;
    public final String unordered_marker_color;
    public final Float unordered_marker_font_size;

    public static final class Builder extends Message.Builder<ListConfig, Builder> {
        public Float block_gap;
        public Float item_gap;
        public EdgeInsets item_padding;
        public String ordered_marker_color;
        public Float ordered_marker_font_size;
        public String unordered_marker_color;
        public Float unordered_marker_font_size;

        @Override // com.squareup.wire.Message.Builder
        public ListConfig build() {
            return new ListConfig(this.ordered_marker_color, this.ordered_marker_font_size, this.unordered_marker_color, this.unordered_marker_font_size, this.block_gap, this.item_gap, this.item_padding, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder block_gap(Float r100) {
            this.block_gap = r100;
            return this;
        }

        public Builder item_gap(Float r100) {
            this.item_gap = r100;
            return this;
        }

        public Builder item_padding(EdgeInsets r100) {
            this.item_padding = r100;
            return this;
        }

        public Builder ordered_marker_color(String r100) {
            this.ordered_marker_color = r100;
            return this;
        }

        public Builder ordered_marker_font_size(Float r100) {
            this.ordered_marker_font_size = r100;
            return this;
        }

        public Builder unordered_marker_color(String r100) {
            this.unordered_marker_color = r100;
            return this;
        }

        public Builder unordered_marker_font_size(Float r100) {
            this.unordered_marker_font_size = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ListConfig extends ProtoAdapter<ListConfig> {
        public ProtoAdapter_ListConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, ListConfig.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ListConfig decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.item_padding = EdgeInsets.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.item_gap = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L9:
            r101.block_gap = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L10:
            r101.unordered_marker_font_size = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L11:
            r101.unordered_marker_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.ordered_marker_font_size = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L13:
            r101.ordered_marker_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ListConfig r100) {
            String r101 = r100.ordered_marker_color;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Float r104 = r100.ordered_marker_font_size;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.unordered_marker_color;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Float r110 = r100.unordered_marker_font_size;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Float r113 = r100.block_gap;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.FLOAT.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Float r116 = r100.item_gap;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.FLOAT.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            EdgeInsets r119 = r100.item_padding;
            if (r119 == null) goto L30;
            r102 = EdgeInsets.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ListConfig decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ListConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ListConfig r101) throws IOException {
            String r102 = r101.ordered_marker_color;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Float r103 = r101.ordered_marker_font_size;
            if (r103 == null) goto L8;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.unordered_marker_color;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Float r105 = r101.unordered_marker_font_size;
            if (r105 == null) goto L14;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 4, r105);
        L14:
            Float r106 = r101.block_gap;
            if (r106 == null) goto L17;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 5, r106);
        L17:
            Float r107 = r101.item_gap;
            if (r107 == null) goto L20;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 6, r107);
        L20:
            EdgeInsets r108 = r101.item_padding;
            if (r108 == null) goto L23;
            EdgeInsets.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ListConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ListConfig();
        Float r100 = Float.valueOf(0.0f);
        DEFAULT_ORDERED_MARKER_FONT_SIZE = r100;
        DEFAULT_UNORDERED_MARKER_FONT_SIZE = r100;
        DEFAULT_BLOCK_GAP = r100;
        DEFAULT_ITEM_GAP = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ordered_marker_color = this.ordered_marker_color;
        r100.ordered_marker_font_size = this.ordered_marker_font_size;
        r100.unordered_marker_color = this.unordered_marker_color;
        r100.unordered_marker_font_size = this.unordered_marker_font_size;
        r100.block_gap = this.block_gap;
        r100.item_gap = this.item_gap;
        r100.item_padding = this.item_padding;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ListConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ListConfig(String r110, Float r111, String r112, Float r113, Float r114, Float r115, EdgeInsets r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public ListConfig(String r100, Float r101, String r102, Float r103, Float r104, Float r105, EdgeInsets r106, ByteString r107) {
        super(ADAPTER, r107);
        this.ordered_marker_color = r100;
        this.ordered_marker_font_size = r101;
        this.unordered_marker_color = r102;
        this.unordered_marker_font_size = r103;
        this.block_gap = r104;
        this.item_gap = r105;
        this.item_padding = r106;
    }
}
