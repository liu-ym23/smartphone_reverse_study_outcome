package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ImageSet extends com.squareup.wire.Message<ImageSet, Builder> {
    public static final ProtoAdapter<ImageSet> ADAPTER = null;
    public static final String DEFAULT_IMAGE_KEY = "";
    public static final String DEFAULT_KEY = "";
    private static final long serialVersionUID = 0;
    public final Image mcover;
    public final String mimage_key;
    public final Image mintact;
    public final String mkey;
    public final Image mmiddle;
    public final Image mmiddle_mp4;
    public final Image mmiddle_webp;
    public final Image morigin;
    public final Image mthumbnail;
    public final Image mthumbnail_webp;

    public static final class Builder extends com.squareup.wire.Message.Builder<ImageSet, Builder> {
        public Image mcover;
        public String mimage_key;
        public Image mintact;
        public String mkey;
        public Image mmiddle;
        public Image mmiddle_mp4;
        public Image mmiddle_webp;
        public Image morigin;
        public Image mthumbnail;
        public Image mthumbnail_webp;

        @Override // com.squareup.wire.Message.Builder
        public ImageSet build() {
            return new ImageSet(this.mkey, this.morigin, this.mthumbnail, this.mimage_key, this.mmiddle, this.mthumbnail_webp, this.mmiddle_webp, this.mmiddle_mp4, this.mcover, this.mintact, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder cover(Image r100) {
            this.mcover = r100;
            return this;
        }

        public Builder image_key(String r100) {
            this.mimage_key = r100;
            return this;
        }

        public Builder intact(Image r100) {
            this.mintact = r100;
            return this;
        }

        public Builder key(String r100) {
            this.mkey = r100;
            return this;
        }

        public Builder middle(Image r100) {
            this.mmiddle = r100;
            return this;
        }

        public Builder middle_mp4(Image r100) {
            this.mmiddle_mp4 = r100;
            return this;
        }

        public Builder middle_webp(Image r100) {
            this.mmiddle_webp = r100;
            return this;
        }

        public Builder origin(Image r100) {
            this.morigin = r100;
            return this;
        }

        public Builder thumbnail(Image r100) {
            this.mthumbnail = r100;
            return this;
        }

        public Builder thumbnail_webp(Image r100) {
            this.mthumbnail_webp = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ImageSet extends ProtoAdapter<ImageSet> {
        public ProtoAdapter_ImageSet() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageSet.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ImageSet decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mkey = "";
            r101.mimage_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.mintact = Image.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.mcover = Image.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.mmiddle_mp4 = Image.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.mmiddle_webp = Image.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.mthumbnail_webp = Image.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.mmiddle = Image.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.mimage_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mthumbnail = Image.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.morigin = Image.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.mkey = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ImageSet r100) {
            String r101 = r100.mkey;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Image r104 = r100.morigin;
            if (r104 == null) goto L9;
            int r105 = Image.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Image r107 = r100.mthumbnail;
            if (r107 == null) goto L13;
            int r108 = Image.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mimage_key;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Image r113 = r100.mmiddle;
            if (r113 == null) goto L21;
            int r114 = Image.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Image r116 = r100.mthumbnail_webp;
            if (r116 == null) goto L25;
            int r117 = Image.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Image r119 = r100.mmiddle_webp;
            if (r119 == null) goto L29;
            int r120 = Image.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Image r122 = r100.mmiddle_mp4;
            if (r122 == null) goto L33;
            int r123 = Image.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Image r125 = r100.mcover;
            if (r125 == null) goto L37;
            int r126 = Image.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Image r128 = r100.mintact;
            if (r128 == null) goto L42;
            r102 = Image.ADAPTER.encodedSizeWithTag(10, r128);
        L42:
            return (r127 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ImageSet decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ImageSet r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ImageSet r101) throws IOException {
            String r102 = r101.mkey;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Image r103 = r101.morigin;
            if (r103 == null) goto L8;
            Image.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Image r104 = r101.mthumbnail;
            if (r104 == null) goto L11;
            Image.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mimage_key;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Image r106 = r101.mmiddle;
            if (r106 == null) goto L17;
            Image.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            Image r107 = r101.mthumbnail_webp;
            if (r107 == null) goto L20;
            Image.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            Image r108 = r101.mmiddle_webp;
            if (r108 == null) goto L23;
            Image.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            Image r109 = r101.mmiddle_mp4;
            if (r109 == null) goto L26;
            Image.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            Image r110 = r101.mcover;
            if (r110 == null) goto L29;
            Image.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            Image r111 = r101.mintact;
            if (r111 == null) goto L32;
            Image.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageSet r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageSet();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mkey = this.mkey;
        r100.morigin = this.morigin;
        r100.mthumbnail = this.mthumbnail;
        r100.mimage_key = this.mimage_key;
        r100.mmiddle = this.mmiddle;
        r100.mthumbnail_webp = this.mthumbnail_webp;
        r100.mmiddle_webp = this.mmiddle_webp;
        r100.mmiddle_mp4 = this.mmiddle_mp4;
        r100.mcover = this.mcover;
        r100.mintact = this.mintact;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ImageSet.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ImageSet(String r110, Image r111, Image r112, String r113, Image r114, Image r115, Image r116, Image r210, Image r211, Image r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public ImageSet(String r100, Image r101, Image r102, String r103, Image r104, Image r105, Image r106, Image r107, Image r110, Image r111, ByteString r112) {
        super(ADAPTER, r112);
        this.mkey = r100;
        this.morigin = r101;
        this.mthumbnail = r102;
        this.mimage_key = r103;
        this.mmiddle = r104;
        this.mthumbnail_webp = r105;
        this.mmiddle_webp = r106;
        this.mmiddle_mp4 = r107;
        this.mcover = r110;
        this.mintact = r111;
    }
}
