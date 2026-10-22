package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ImageSet extends com.squareup.wire.Message<ImageSet, Builder> {
    public static final ProtoAdapter<ImageSet> ADAPTER = null;
    public static final ByteString DEFAULT_INLINE_PREVIEW = null;
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final String DEFAULT_KEY = "";
    public static final Long DEFAULT_SCENE_ID = null;
    private static final long serialVersionUID = 0;
    public final Image cover;
    public final ByteString inline_preview;
    public final Image intact;
    public final Boolean is_destroyed;
    public final String key;
    public final Image middle;
    public final Image middle_mp4;
    public final Image middle_webp;
    public final Image origin;
    public final Long scene_id;
    public final Image thumbnail;
    public final Image thumbnail_webp;

    public static final class Builder extends com.squareup.wire.Message.Builder<ImageSet, Builder> {
        public Image cover;
        public ByteString inline_preview;
        public Image intact;
        public Boolean is_destroyed;
        public String key;
        public Image middle;
        public Image middle_mp4;
        public Image middle_webp;
        public Image origin;
        public Long scene_id;
        public Image thumbnail;
        public Image thumbnail_webp;

        @Override // com.squareup.wire.Message.Builder
        public ImageSet build() {
            return new ImageSet(this.key, this.origin, this.thumbnail, this.middle, this.thumbnail_webp, this.middle_webp, this.middle_mp4, this.cover, this.inline_preview, this.intact, this.is_destroyed, this.scene_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder cover(Image r100) {
            this.cover = r100;
            return this;
        }

        public Builder inline_preview(ByteString r100) {
            this.inline_preview = r100;
            return this;
        }

        public Builder intact(Image r100) {
            this.intact = r100;
            return this;
        }

        public Builder is_destroyed(Boolean r100) {
            this.is_destroyed = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder middle(Image r100) {
            this.middle = r100;
            return this;
        }

        public Builder middle_mp4(Image r100) {
            this.middle_mp4 = r100;
            return this;
        }

        public Builder middle_webp(Image r100) {
            this.middle_webp = r100;
            return this;
        }

        public Builder origin(Image r100) {
            this.origin = r100;
            return this;
        }

        public Builder scene_id(Long r100) {
            this.scene_id = r100;
            return this;
        }

        public Builder thumbnail(Image r100) {
            this.thumbnail = r100;
            return this;
        }

        public Builder thumbnail_webp(Image r100) {
            this.thumbnail_webp = r100;
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
            r101.key = "";
            r101.inline_preview = ByteString.EMPTY;
            r101.is_destroyed = Boolean.FALSE;
            r101.scene_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            r101.scene_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.is_destroyed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.intact = Image.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.inline_preview = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L11:
            r101.cover = Image.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.middle_mp4 = Image.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.middle_webp = Image.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.thumbnail_webp = Image.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.middle = Image.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.thumbnail = Image.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.origin = Image.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ImageSet r100) {
            String r101 = r100.key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Image r104 = r100.origin;
            if (r104 == null) goto L9;
            int r105 = Image.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Image r107 = r100.thumbnail;
            if (r107 == null) goto L13;
            int r108 = Image.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Image r110 = r100.middle;
            if (r110 == null) goto L17;
            int r111 = Image.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Image r113 = r100.thumbnail_webp;
            if (r113 == null) goto L21;
            int r114 = Image.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Image r116 = r100.middle_webp;
            if (r116 == null) goto L25;
            int r117 = Image.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Image r119 = r100.middle_mp4;
            if (r119 == null) goto L29;
            int r120 = Image.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Image r122 = r100.cover;
            if (r122 == null) goto L33;
            int r123 = Image.ADAPTER.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            ByteString r125 = r100.inline_preview;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BYTES.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Image r128 = r100.intact;
            if (r128 == null) goto L41;
            int r129 = Image.ADAPTER.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.is_destroyed;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            Long r134 = r100.scene_id;
            if (r134 == null) goto L50;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(12, r134);
        L50:
            return (r133 + r102) + r100.unknownFields().size();
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
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
            String r102 = r101.key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Image r103 = r101.origin;
            if (r103 == null) goto L8;
            Image.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Image r104 = r101.thumbnail;
            if (r104 == null) goto L11;
            Image.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Image r105 = r101.middle;
            if (r105 == null) goto L14;
            Image.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Image r106 = r101.thumbnail_webp;
            if (r106 == null) goto L17;
            Image.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            Image r107 = r101.middle_webp;
            if (r107 == null) goto L20;
            Image.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            Image r108 = r101.middle_mp4;
            if (r108 == null) goto L23;
            Image.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            Image r109 = r101.cover;
            if (r109 == null) goto L26;
            Image.ADAPTER.encodeWithTag(r100, 8, r109);
        L26:
            ByteString r110 = r101.inline_preview;
            if (r110 == null) goto L29;
            ProtoAdapter.BYTES.encodeWithTag(r100, 9, r110);
        L29:
            Image r111 = r101.intact;
            if (r111 == null) goto L32;
            Image.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            Boolean r112 = r101.is_destroyed;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r112);
        L35:
            Long r113 = r101.scene_id;
            if (r113 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r100, 12, r113);
        L38:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageSet r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageSet();
        DEFAULT_INLINE_PREVIEW = ByteString.EMPTY;
        DEFAULT_IS_DESTROYED = Boolean.FALSE;
        DEFAULT_SCENE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.origin = this.origin;
        r100.thumbnail = this.thumbnail;
        r100.middle = this.middle;
        r100.thumbnail_webp = this.thumbnail_webp;
        r100.middle_webp = this.middle_webp;
        r100.middle_mp4 = this.middle_mp4;
        r100.cover = this.cover;
        r100.inline_preview = this.inline_preview;
        r100.intact = this.intact;
        r100.is_destroyed = this.is_destroyed;
        r100.scene_id = this.scene_id;
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

    public ImageSet(String r110, Image r111, Image r112, Image r113, Image r114, Image r210, Image r211, Image r212, ByteString r213, Image r214, Boolean r215, Long r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public ImageSet(String r100, Image r101, Image r102, Image r103, Image r104, Image r105, Image r106, Image r107, ByteString r110, Image r111, Boolean r112, Long r113, ByteString r114) {
        super(ADAPTER, r114);
        this.key = r100;
        this.origin = r101;
        this.thumbnail = r102;
        this.middle = r103;
        this.thumbnail_webp = r104;
        this.middle_webp = r105;
        this.middle_mp4 = r106;
        this.cover = r107;
        this.inline_preview = r110;
        this.intact = r111;
        this.is_destroyed = r112;
        this.scene_id = r113;
    }
}
