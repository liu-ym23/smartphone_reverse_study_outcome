package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Border extends com.squareup.wire.Message<Border, Builder> {
    public static final ProtoAdapter<Border> ADAPTER = null;
    public static final Float DEFAULT_CORNER_RADIUS = null;
    public static final Float DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final ThemeColor color_v2;
    public final Float corner_radius;
    public final Float width;

    public static final class Builder extends com.squareup.wire.Message.Builder<Border, Builder> {
        public ThemeColor color_v2;
        public Float corner_radius;
        public Float width;

        @Override // com.squareup.wire.Message.Builder
        public Border build() {
            return new Border(this.width, this.color_v2, this.corner_radius, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder color_v2(ThemeColor r100) {
            this.color_v2 = r100;
            return this;
        }

        public Builder corner_radius(Float r100) {
            this.corner_radius = r100;
            return this;
        }

        public Builder width(Float r100) {
            this.width = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Border extends ProtoAdapter<Border> {
        public ProtoAdapter_Border() {
            super(FieldEncoding.LENGTH_DELIMITED, Border.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Border decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Float r102 = Float.valueOf(0.0f);
            r101.width = r102;
            r101.corner_radius = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.width = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L8:
            if (r104 != 3) goto L10;
            r101.corner_radius = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L10:
            if (r104 != 4) goto L11;
            r101.color_v2 = ThemeColor.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Border r100) {
            Float r101 = r100.width;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.FLOAT.encodedSizeWithTag(1, r101);
        L6:
            ThemeColor r104 = r100.color_v2;
            if (r104 == null) goto L9;
            int r105 = ThemeColor.ADAPTER.encodedSizeWithTag(4, r104);
        L10:
            int r106 = r103 + r105;
            Float r107 = r100.corner_radius;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Border decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Border r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Border r101) throws IOException {
            Float r102 = r101.width;
            if (r102 == null) goto L5;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 1, r102);
        L5:
            ThemeColor r103 = r101.color_v2;
            if (r103 == null) goto L8;
            ThemeColor.ADAPTER.encodeWithTag(r100, 4, r103);
        L8:
            Float r104 = r101.corner_radius;
            if (r104 == null) goto L11;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Border r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Border();
        Float r100 = Float.valueOf(0.0f);
        DEFAULT_WIDTH = r100;
        DEFAULT_CORNER_RADIUS = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.width = this.width;
        r100.color_v2 = this.color_v2;
        r100.corner_radius = this.corner_radius;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Border.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Border(Float r100, ThemeColor r101, Float r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public Border(Float r100, ThemeColor r101, Float r102, ByteString r103) {
        super(ADAPTER, r103);
        this.width = r100;
        this.color_v2 = r101;
        this.corner_radius = r102;
    }
}
