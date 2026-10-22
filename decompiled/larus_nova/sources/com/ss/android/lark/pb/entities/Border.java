package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Border extends com.squareup.wire.Message<Border, Builder> {
    public static final ProtoAdapter<Border> ADAPTER = null;
    public static final Integer DEFAULT_COLOR = null;
    public static final Float DEFAULT_CORNER_RADIUS = null;
    public static final Float DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final Integer mcolor;
    public final ThemeColor mcolor_v2;
    public final Float mcorner_radius;
    public final Float mwidth;

    public static final class Builder extends com.squareup.wire.Message.Builder<Border, Builder> {
        public Integer mcolor;
        public ThemeColor mcolor_v2;
        public Float mcorner_radius;
        public Float mwidth;

        @Override // com.squareup.wire.Message.Builder
        public Border build() {
            return new Border(this.mwidth, this.mcolor, this.mcorner_radius, this.mcolor_v2, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder color(Integer r100) {
            this.mcolor = r100;
            return this;
        }

        public Builder color_v2(ThemeColor r100) {
            this.mcolor_v2 = r100;
            return this;
        }

        public Builder corner_radius(Float r100) {
            this.mcorner_radius = r100;
            return this;
        }

        public Builder width(Float r100) {
            this.mwidth = r100;
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
            r101.mwidth = r102;
            r101.mcolor = 0;
            r101.mcorner_radius = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.mwidth = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.mcolor = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.mcorner_radius = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.mcolor_v2 = ThemeColor.ADAPTER.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Border r100) {
            Float r101 = r100.mwidth;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.FLOAT.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.mcolor;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.UINT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Float r107 = r100.mcorner_radius;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ThemeColor r110 = r100.mcolor_v2;
            if (r110 == null) goto L18;
            r102 = ThemeColor.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ Border decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Border r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Border r101) throws IOException {
            Float r102 = r101.mwidth;
            if (r102 == null) goto L5;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.mcolor;
            if (r103 == null) goto L8;
            ProtoAdapter.UINT32.encodeWithTag(r100, 2, r103);
        L8:
            Float r104 = r101.mcorner_radius;
            if (r104 == null) goto L11;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r104);
        L11:
            ThemeColor r105 = r101.mcolor_v2;
            if (r105 == null) goto L14;
            ThemeColor.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
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
        DEFAULT_COLOR = 0;
        DEFAULT_CORNER_RADIUS = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mwidth = this.mwidth;
        r100.mcolor = this.mcolor;
        r100.mcorner_radius = this.mcorner_radius;
        r100.mcolor_v2 = this.mcolor_v2;
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

    public Border(Float r100, Integer r101, Float r102, ThemeColor r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public Border(Float r100, Integer r101, Float r102, ThemeColor r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mwidth = r100;
        this.mcolor = r101;
        this.mcorner_radius = r102;
        this.mcolor_v2 = r103;
    }
}
