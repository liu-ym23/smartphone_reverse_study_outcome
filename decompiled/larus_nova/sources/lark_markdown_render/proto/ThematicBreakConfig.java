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
public final class ThematicBreakConfig extends Message<ThematicBreakConfig, Builder> {
    public static final ProtoAdapter<ThematicBreakConfig> ADAPTER = null;
    public static final Float DEFAULT_HEIGHT = null;
    public static final String DEFAULT_LINE_COLOR = "";
    public static final Float DEFAULT_MARGIN_BOTTOM = null;
    public static final Float DEFAULT_MARGIN_TOP = null;
    private static final long serialVersionUID = 0;
    public final Float height;
    public final String line_color;
    public final Float margin_bottom;
    public final Float margin_top;

    public static final class Builder extends Message.Builder<ThematicBreakConfig, Builder> {
        public Float height;
        public String line_color;
        public Float margin_bottom;
        public Float margin_top;

        @Override // com.squareup.wire.Message.Builder
        public ThematicBreakConfig build() {
            Float r100 = this.height;
            if (r100 == null) goto L7;
            return new ThematicBreakConfig(this.height, this.line_color, this.margin_top, this.margin_bottom, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "height"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder height(Float r100) {
            this.height = r100;
            return this;
        }

        public Builder line_color(String r100) {
            this.line_color = r100;
            return this;
        }

        public Builder margin_bottom(Float r100) {
            this.margin_bottom = r100;
            return this;
        }

        public Builder margin_top(Float r100) {
            this.margin_top = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ThematicBreakConfig extends ProtoAdapter<ThematicBreakConfig> {
        public ProtoAdapter_ThematicBreakConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, ThematicBreakConfig.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ThematicBreakConfig decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.height = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.line_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.margin_top = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.margin_bottom = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ThematicBreakConfig r100) {
            ProtoAdapter<Float> r101 = ProtoAdapter.FLOAT;
            int r102 = r101.encodedSizeWithTag(1, r100.height);
            String r103 = r100.line_color;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Float r107 = r100.margin_top;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Float r110 = r100.margin_bottom;
            if (r110 == null) goto L14;
            r104 = r101.encodedSizeWithTag(4, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ThematicBreakConfig decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ThematicBreakConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ThematicBreakConfig r101) throws IOException {
            ProtoAdapter<Float> r102 = ProtoAdapter.FLOAT;
            r102.encodeWithTag(r100, 1, r101.height);
            String r103 = r101.line_color;
            if (r103 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L5:
            Float r104 = r101.margin_top;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            Float r105 = r101.margin_bottom;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThematicBreakConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ThematicBreakConfig();
        Float r100 = Float.valueOf(0.0f);
        DEFAULT_HEIGHT = r100;
        DEFAULT_MARGIN_TOP = r100;
        DEFAULT_MARGIN_BOTTOM = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.height = this.height;
        r100.line_color = this.line_color;
        r100.margin_top = this.margin_top;
        r100.margin_bottom = this.margin_bottom;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ThematicBreakConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ThematicBreakConfig(Float r100, String r101, Float r102, Float r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ThematicBreakConfig(Float r100, String r101, Float r102, Float r103, ByteString r104) {
        super(ADAPTER, r104);
        this.height = r100;
        this.line_color = r101;
        this.margin_top = r102;
        this.margin_bottom = r103;
    }
}
