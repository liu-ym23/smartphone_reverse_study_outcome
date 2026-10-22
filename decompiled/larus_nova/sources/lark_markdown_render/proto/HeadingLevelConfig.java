package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class HeadingLevelConfig extends Message<HeadingLevelConfig, Builder> {
    public static final ProtoAdapter<HeadingLevelConfig> ADAPTER = null;
    public static final Float DEFAULT_FONT_SIZE = null;
    public static final FontWeight DEFAULT_FONT_WEIGHT = null;
    public static final Float DEFAULT_LINE_HEIGHT = null;
    private static final long serialVersionUID = 0;
    public final Float font_size;
    public final FontWeight font_weight;
    public final Float line_height;
    public final EdgeInsets padding;

    public static final class Builder extends Message.Builder<HeadingLevelConfig, Builder> {
        public Float font_size;
        public FontWeight font_weight;
        public Float line_height;
        public EdgeInsets padding;

        @Override // com.squareup.wire.Message.Builder
        public HeadingLevelConfig build() {
            return new HeadingLevelConfig(this.font_size, this.font_weight, this.line_height, this.padding, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder font_size(Float r100) {
            this.font_size = r100;
            return this;
        }

        public Builder font_weight(FontWeight r100) {
            this.font_weight = r100;
            return this;
        }

        public Builder line_height(Float r100) {
            this.line_height = r100;
            return this;
        }

        public Builder padding(EdgeInsets r100) {
            this.padding = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HeadingLevelConfig extends ProtoAdapter<HeadingLevelConfig> {
        public ProtoAdapter_HeadingLevelConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, HeadingLevelConfig.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public HeadingLevelConfig decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.font_size = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.font_weight = FontWeight.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.line_height = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.padding = EdgeInsets.ADAPTER.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(HeadingLevelConfig r100) {
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
            Float r107 = r100.line_height;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            EdgeInsets r110 = r100.padding;
            if (r110 == null) goto L18;
            r102 = EdgeInsets.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ HeadingLevelConfig decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HeadingLevelConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HeadingLevelConfig r101) throws IOException {
            Float r102 = r101.font_size;
            if (r102 == null) goto L5;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 1, r102);
        L5:
            FontWeight r103 = r101.font_weight;
            if (r103 == null) goto L8;
            FontWeight.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Float r104 = r101.line_height;
            if (r104 == null) goto L11;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r104);
        L11:
            EdgeInsets r105 = r101.padding;
            if (r105 == null) goto L14;
            EdgeInsets.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HeadingLevelConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HeadingLevelConfig();
        Float r100 = Float.valueOf(0.0f);
        DEFAULT_FONT_SIZE = r100;
        DEFAULT_FONT_WEIGHT = FontWeight.VAR_FONT_WEIGHT_REGULAR;
        DEFAULT_LINE_HEIGHT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.font_size = this.font_size;
        r100.font_weight = this.font_weight;
        r100.line_height = this.line_height;
        r100.padding = this.padding;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HeadingLevelConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public HeadingLevelConfig(Float r100, FontWeight r101, Float r102, EdgeInsets r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public HeadingLevelConfig(Float r100, FontWeight r101, Float r102, EdgeInsets r103, ByteString r104) {
        super(ADAPTER, r104);
        this.font_size = r100;
        this.font_weight = r101;
        this.line_height = r102;
        this.padding = r103;
    }
}
