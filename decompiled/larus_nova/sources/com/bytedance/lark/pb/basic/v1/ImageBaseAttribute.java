package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ImageBaseAttribute extends com.squareup.wire.Message<ImageBaseAttribute, Builder> {
    public static final ProtoAdapter<ImageBaseAttribute> ADAPTER = null;
    public static final Integer DEFAULT_EXIF_ORIENTATION = null;
    public static final Integer DEFAULT_HEIGHT = null;
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final Integer exif_orientation;
    public final Integer height;
    public final Integer width;

    public static final class Builder extends com.squareup.wire.Message.Builder<ImageBaseAttribute, Builder> {
        public Integer exif_orientation;
        public Integer height;
        public Integer width;

        @Override // com.squareup.wire.Message.Builder
        public ImageBaseAttribute build() {
            Integer r100 = this.width;
            if (r100 == null) goto L9;
            if (this.height == null) goto L9;
            return new ImageBaseAttribute(this.width, this.height, this.exif_orientation, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "width", this.height, "height"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder exif_orientation(Integer r100) {
            this.exif_orientation = r100;
            return this;
        }

        public Builder height(Integer r100) {
            this.height = r100;
            return this;
        }

        public Builder width(Integer r100) {
            this.width = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ImageBaseAttribute extends ProtoAdapter<ImageBaseAttribute> {
        public ProtoAdapter_ImageBaseAttribute() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageBaseAttribute.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ImageBaseAttribute decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.width = 0;
            r101.height = 0;
            r101.exif_orientation = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.width = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.height = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.exif_orientation = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ImageBaseAttribute r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.UINT32;
            int r102 = r101.encodedSizeWithTag(1, r100.width) + r101.encodedSizeWithTag(2, r100.height);
            Integer r103 = r100.exif_orientation;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(3, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ImageBaseAttribute decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ImageBaseAttribute r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ImageBaseAttribute r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.UINT32;
            r102.encodeWithTag(r100, 1, r101.width);
            r102.encodeWithTag(r100, 2, r101.height);
            Integer r103 = r101.exif_orientation;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageBaseAttribute r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageBaseAttribute();
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_EXIF_ORIENTATION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.width = this.width;
        r100.height = this.height;
        r100.exif_orientation = this.exif_orientation;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ImageBaseAttribute.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ImageBaseAttribute(Integer r100, Integer r101, Integer r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ImageBaseAttribute(Integer r100, Integer r101, Integer r102, ByteString r103) {
        super(ADAPTER, r103);
        this.width = r100;
        this.height = r101;
        this.exif_orientation = r102;
    }
}
