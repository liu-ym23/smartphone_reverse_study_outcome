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
public final class FuncParamsX128e7aed481f35b9 extends Message<FuncParamsX128e7aed481f35b9, Builder> {
    public static final ProtoAdapter<FuncParamsX128e7aed481f35b9> ADAPTER = null;
    public static final String DEFAULT_MARKDOWN = "";
    public static final Float DEFAULT_PREFER_WIDTH = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String markdown;
    public final Float prefer_width;
    public final MovableRenderConfig render_config;
    public final MovableRenderUrlPreviewInlines url_preview_inlines;

    public static final class Builder extends Message.Builder<FuncParamsX128e7aed481f35b9, Builder> {
        public ByteString _molten_ctx;
        public String markdown;
        public Float prefer_width;
        public MovableRenderConfig render_config;
        public MovableRenderUrlPreviewInlines url_preview_inlines;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX128e7aed481f35b9 build() {
            String r100 = this.markdown;
            if (r100 == null) goto L9;
            if (this.prefer_width == null) goto L9;
            return new FuncParamsX128e7aed481f35b9(this.markdown, this.prefer_width, this.render_config, this.url_preview_inlines, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "markdown", this.prefer_width, "prefer_width"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder markdown(String r100) {
            this.markdown = r100;
            return this;
        }

        public Builder prefer_width(Float r100) {
            this.prefer_width = r100;
            return this;
        }

        public Builder render_config(MovableRenderConfig r100) {
            this.render_config = r100;
            return this;
        }

        public Builder url_preview_inlines(MovableRenderUrlPreviewInlines r100) {
            this.url_preview_inlines = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX128e7aed481f35b9 extends ProtoAdapter<FuncParamsX128e7aed481f35b9> {
        public ProtoAdapter_FuncParamsX128e7aed481f35b9() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX128e7aed481f35b9.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX128e7aed481f35b9 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.markdown = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.prefer_width = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.render_config = MovableRenderConfig.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.url_preview_inlines = MovableRenderUrlPreviewInlines.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 255) goto L15;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX128e7aed481f35b9 r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.markdown) + ProtoAdapter.FLOAT.encodedSizeWithTag(2, r100.prefer_width);
            MovableRenderConfig r102 = r100.render_config;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = MovableRenderConfig.ADAPTER.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            MovableRenderUrlPreviewInlines r106 = r100.url_preview_inlines;
            if (r106 == null) goto L9;
            int r107 = MovableRenderUrlPreviewInlines.ADAPTER.encodedSizeWithTag(4, r106);
        L10:
            int r108 = r105 + r107;
            ByteString r109 = r100._molten_ctx;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX128e7aed481f35b9 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX128e7aed481f35b9 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX128e7aed481f35b9 r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.markdown);
            ProtoAdapter.FLOAT.encodeWithTag(r100, 2, r101.prefer_width);
            MovableRenderConfig r102 = r101.render_config;
            if (r102 == null) goto L5;
            MovableRenderConfig.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            MovableRenderUrlPreviewInlines r103 = r101.url_preview_inlines;
            if (r103 == null) goto L8;
            MovableRenderUrlPreviewInlines.ADAPTER.encodeWithTag(r100, 4, r103);
        L8:
            ByteString r104 = r101._molten_ctx;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX128e7aed481f35b9 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX128e7aed481f35b9();
        DEFAULT_PREFER_WIDTH = Float.valueOf(0.0f);
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.markdown = this.markdown;
        r100.prefer_width = this.prefer_width;
        r100.render_config = this.render_config;
        r100.url_preview_inlines = this.url_preview_inlines;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX128e7aed481f35b9.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX128e7aed481f35b9(String r100, Float r101, MovableRenderConfig r110, MovableRenderUrlPreviewInlines r111, ByteString r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public FuncParamsX128e7aed481f35b9(String r100, Float r101, MovableRenderConfig r102, MovableRenderUrlPreviewInlines r103, ByteString r104, ByteString r105) {
        super(ADAPTER, r105);
        this.markdown = r100;
        this.prefer_width = r101;
        this.render_config = r102;
        this.url_preview_inlines = r103;
        this._molten_ctx = r104;
    }
}
