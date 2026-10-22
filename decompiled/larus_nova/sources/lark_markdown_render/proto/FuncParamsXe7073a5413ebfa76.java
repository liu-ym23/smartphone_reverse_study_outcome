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
public final class FuncParamsXe7073a5413ebfa76 extends Message<FuncParamsXe7073a5413ebfa76, Builder> {
    public static final ProtoAdapter<FuncParamsXe7073a5413ebfa76> ADAPTER = null;
    public static final Integer DEFAULT_CANVAS_ID = null;
    public static final Float DEFAULT_HEIGHT = null;
    public static final Float DEFAULT_WIDTH = null;
    public static final Float DEFAULT_X = null;
    public static final Float DEFAULT_Y = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Integer canvas_id;
    public final Float height;
    public final Float width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Float f508261x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Float f508262y;

    public static final class Builder extends Message.Builder<FuncParamsXe7073a5413ebfa76, Builder> {
        public ByteString _molten_ctx;
        public Integer canvas_id;
        public Float height;
        public Float width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public Float f508263x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public Float f508264y;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXe7073a5413ebfa76 build() {
            Integer r100 = this.canvas_id;
            if (r100 == null) goto L15;
            if (this.f508263x == null) goto L15;
            if (this.f508264y == null) goto L15;
            if (this.width == null) goto L15;
            if (this.height == null) goto L15;
            return new FuncParamsXe7073a5413ebfa76(this.canvas_id, this.f508263x, this.f508264y, this.width, this.height, this._molten_ctx, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, "canvas_id", this.f508263x, "x", this.f508264y, "y", this.width, "width", this.height, "height"});
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

        public Builder canvas_id(Integer r100) {
            this.canvas_id = r100;
            return this;
        }

        public Builder height(Float r100) {
            this.height = r100;
            return this;
        }

        public Builder width(Float r100) {
            this.width = r100;
            return this;
        }

        public Builder x(Float r100) {
            this.f508263x = r100;
            return this;
        }

        public Builder y(Float r100) {
            this.f508264y = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXe7073a5413ebfa76 extends ProtoAdapter<FuncParamsXe7073a5413ebfa76> {
        public ProtoAdapter_FuncParamsXe7073a5413ebfa76() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXe7073a5413ebfa76.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXe7073a5413ebfa76 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.canvas_id = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.f508263x = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.f508264y = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.width = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L16;
            r101.height = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L16:
            if (r103 != 255) goto L17;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXe7073a5413ebfa76 r100) {
            int r101 = ProtoAdapter.UINT32.encodedSizeWithTag(1, r100.canvas_id);
            ProtoAdapter<Float> r102 = ProtoAdapter.FLOAT;
            int r103 = (((r101 + r102.encodedSizeWithTag(2, r100.f508261x)) + r102.encodedSizeWithTag(3, r100.f508262y)) + r102.encodedSizeWithTag(4, r100.width)) + r102.encodedSizeWithTag(5, r100.height);
            ByteString r104 = r100._molten_ctx;
            if (r104 == null) goto L5;
            int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r104);
        L7:
            return (r103 + r105) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXe7073a5413ebfa76 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXe7073a5413ebfa76 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXe7073a5413ebfa76 r101) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(r100, 1, r101.canvas_id);
            ProtoAdapter<Float> r102 = ProtoAdapter.FLOAT;
            r102.encodeWithTag(r100, 2, r101.f508261x);
            r102.encodeWithTag(r100, 3, r101.f508262y);
            r102.encodeWithTag(r100, 4, r101.width);
            r102.encodeWithTag(r100, 5, r101.height);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXe7073a5413ebfa76 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXe7073a5413ebfa76();
        DEFAULT_CANVAS_ID = 0;
        Float r100 = Float.valueOf(0.0f);
        DEFAULT_X = r100;
        DEFAULT_Y = r100;
        DEFAULT_WIDTH = r100;
        DEFAULT_HEIGHT = r100;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.canvas_id = this.canvas_id;
        r100.f508263x = this.f508261x;
        r100.f508264y = this.f508262y;
        r100.width = this.width;
        r100.height = this.height;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXe7073a5413ebfa76.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXe7073a5413ebfa76(Integer r100, Float r110, Float r111, Float r112, Float r113, ByteString r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public FuncParamsXe7073a5413ebfa76(Integer r100, Float r101, Float r102, Float r103, Float r104, ByteString r105, ByteString r106) {
        super(ADAPTER, r106);
        this.canvas_id = r100;
        this.f508261x = r101;
        this.f508262y = r102;
        this.width = r103;
        this.height = r104;
        this._molten_ctx = r105;
    }
}
