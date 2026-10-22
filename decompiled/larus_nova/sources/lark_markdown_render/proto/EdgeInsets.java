package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class EdgeInsets extends Message<EdgeInsets, Builder> {
    public static final ProtoAdapter<EdgeInsets> ADAPTER = null;
    public static final Float DEFAULT_BOTTOM = null;
    public static final Float DEFAULT_LEFT = null;
    public static final Float DEFAULT_RIGHT = null;
    public static final Float DEFAULT_TOP = null;
    private static final long serialVersionUID = 0;
    public final Float bottom;
    public final Float left;
    public final Float right;
    public final Float top;

    public static final class Builder extends Message.Builder<EdgeInsets, Builder> {
        public Float bottom;
        public Float left;
        public Float right;
        public Float top;

        @Override // com.squareup.wire.Message.Builder
        public EdgeInsets build() {
            return new EdgeInsets(this.top, this.right, this.bottom, this.left, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bottom(Float r100) {
            this.bottom = r100;
            return this;
        }

        public Builder left(Float r100) {
            this.left = r100;
            return this;
        }

        public Builder right(Float r100) {
            this.right = r100;
            return this;
        }

        public Builder top(Float r100) {
            this.top = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EdgeInsets extends ProtoAdapter<EdgeInsets> {
        public ProtoAdapter_EdgeInsets() {
            super(FieldEncoding.LENGTH_DELIMITED, EdgeInsets.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public EdgeInsets decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.top = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.right = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.bottom = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.left = ProtoAdapter.FLOAT.decode(r100);
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
        public int encodedSize2(EdgeInsets r100) {
            Float r101 = r100.top;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.FLOAT.encodedSizeWithTag(1, r101);
        L6:
            Float r104 = r100.right;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Float r107 = r100.bottom;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Float r110 = r100.left;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ EdgeInsets decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EdgeInsets r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EdgeInsets r101) throws IOException {
            Float r102 = r101.top;
            if (r102 == null) goto L5;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 1, r102);
        L5:
            Float r103 = r101.right;
            if (r103 == null) goto L8;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 2, r103);
        L8:
            Float r104 = r101.bottom;
            if (r104 == null) goto L11;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r104);
        L11:
            Float r105 = r101.left;
            if (r105 == null) goto L14;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EdgeInsets r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EdgeInsets();
        Float r100 = Float.valueOf(0.0f);
        DEFAULT_TOP = r100;
        DEFAULT_RIGHT = r100;
        DEFAULT_BOTTOM = r100;
        DEFAULT_LEFT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.top = this.top;
        r100.right = this.right;
        r100.bottom = this.bottom;
        r100.left = this.left;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EdgeInsets.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EdgeInsets(Float r100, Float r101, Float r102, Float r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public EdgeInsets(Float r100, Float r101, Float r102, Float r103, ByteString r104) {
        super(ADAPTER, r104);
        this.top = r100;
        this.right = r101;
        this.bottom = r102;
        this.left = r103;
    }
}
