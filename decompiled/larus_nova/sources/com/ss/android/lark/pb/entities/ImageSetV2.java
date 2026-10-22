package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ImageSetV2 extends com.squareup.wire.Message<ImageSetV2, Builder> {
    public static final ProtoAdapter<ImageSetV2> ADAPTER = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final String DEFAULT_IMAGE_KEY = "";
    public static final ByteString DEFAULT_INLINE_PREVIEW = null;
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final Long DEFAULT_SCENE_ID = null;
    private static final long serialVersionUID = 0;
    public final Crypto mcrypto;
    public final String mfs_unit;
    public final String mimage_key;
    public final List<ImageAttribute> mimages;
    public final ByteString minline_preview;
    public final Boolean mis_destroyed;
    public final Long mscene_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<ImageSetV2, Builder> {
        public Crypto mcrypto;
        public String mfs_unit;
        public String mimage_key;
        public List<ImageAttribute> mimages;
        public ByteString minline_preview;
        public Boolean mis_destroyed;
        public Long mscene_id;

        @Override // com.squareup.wire.Message.Builder
        public ImageSetV2 build() {
            return new ImageSetV2(this.mimage_key, this.mfs_unit, this.mcrypto, this.mimages, this.minline_preview, this.mis_destroyed, this.mscene_id, super.buildUnknownFields());
        }

        public Builder() {
            this.mimages = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder crypto(Crypto r100) {
            this.mcrypto = r100;
            return this;
        }

        public Builder fs_unit(String r100) {
            this.mfs_unit = r100;
            return this;
        }

        public Builder image_key(String r100) {
            this.mimage_key = r100;
            return this;
        }

        public Builder images(List<ImageAttribute> r100) {
            Internal.checkElementsNotNull(r100);
            this.mimages = r100;
            return this;
        }

        public Builder inline_preview(ByteString r100) {
            this.minline_preview = r100;
            return this;
        }

        public Builder is_destroyed(Boolean r100) {
            this.mis_destroyed = r100;
            return this;
        }

        public Builder scene_id(Long r100) {
            this.mscene_id = r100;
            return this;
        }
    }

    public static final class ImageAttribute extends com.squareup.wire.Message<ImageAttribute, Builder> {
        public static final ProtoAdapter<ImageAttribute> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ImageBaseAttribute mattribute;
        public final ImageCropType mtype;

        public static final class Builder extends com.squareup.wire.Message.Builder<ImageAttribute, Builder> {
            public ImageBaseAttribute mattribute;
            public ImageCropType mtype;

            @Override // com.squareup.wire.Message.Builder
            public ImageAttribute build() {
                ImageCropType r100 = this.mtype;
                if (r100 == null) goto L9;
                if (this.mattribute == null) goto L9;
                return new ImageAttribute(this.mtype, this.mattribute, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, GearStrategyConsts.EV_MEDIA_TYPE, this.mattribute, "mattribute"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder attribute(ImageBaseAttribute r100) {
                this.mattribute = r100;
                return this;
            }

            public Builder type(ImageCropType r100) {
                this.mtype = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ImageAttribute extends ProtoAdapter<ImageAttribute> {
            public ProtoAdapter_ImageAttribute() {
                super(FieldEncoding.LENGTH_DELIMITED, ImageAttribute.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ImageAttribute decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mtype = ImageCropType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mattribute = ImageBaseAttribute.ADAPTER.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ImageAttribute r100) {
                return (ImageCropType.ADAPTER.encodedSizeWithTag(1, r100.mtype) + ImageBaseAttribute.ADAPTER.encodedSizeWithTag(2, r100.mattribute)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ImageAttribute decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ImageAttribute r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ImageAttribute r101) throws IOException {
                ImageCropType.ADAPTER.encodeWithTag(r100, 1, r101.mtype);
                ImageBaseAttribute.ADAPTER.encodeWithTag(r100, 2, r101.mattribute);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageAttribute r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImageAttribute();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mtype = this.mtype;
            r100.mattribute = this.mattribute;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ImageAttribute.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ImageAttribute(ImageCropType r100, ImageBaseAttribute r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ImageAttribute(ImageCropType r100, ImageBaseAttribute r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mtype = r100;
            this.mattribute = r101;
        }
    }

    public static final class ProtoAdapter_ImageSetV2 extends ProtoAdapter<ImageSetV2> {
        public ProtoAdapter_ImageSetV2() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageSetV2.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ImageSetV2 decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mimage_key = "";
            r101.mfs_unit = "";
            r101.minline_preview = ByteString.EMPTY;
            r101.mis_destroyed = Boolean.FALSE;
            r101.mscene_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.mscene_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.mis_destroyed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.minline_preview = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L10:
            r101.mimages.add(ImageAttribute.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.mcrypto = Crypto.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.mfs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mimage_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ImageSetV2 r100) {
            String r101 = r100.mimage_key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mfs_unit;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Crypto r107 = r100.mcrypto;
            if (r107 == null) goto L13;
            int r108 = Crypto.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = (r106 + r108) + ImageAttribute.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mimages);
            ByteString r110 = r100.minline_preview;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BYTES.encodedSizeWithTag(5, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.mis_destroyed;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.mscene_id;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(7, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ImageSetV2 decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ImageSetV2 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ImageSetV2 r101) throws IOException {
            String r102 = r101.mimage_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mfs_unit;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Crypto r104 = r101.mcrypto;
            if (r104 == null) goto L11;
            Crypto.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            ImageAttribute.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mimages);
            ByteString r105 = r101.minline_preview;
            if (r105 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r100, 5, r105);
        L14:
            Boolean r106 = r101.mis_destroyed;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r106);
        L17:
            Long r107 = r101.mscene_id;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageSetV2 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageSetV2();
        DEFAULT_INLINE_PREVIEW = ByteString.EMPTY;
        DEFAULT_IS_DESTROYED = Boolean.FALSE;
        DEFAULT_SCENE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mimage_key = this.mimage_key;
        r100.mfs_unit = this.mfs_unit;
        r100.mcrypto = this.mcrypto;
        r100.mimages = Internal.copyOf("mimages", this.mimages);
        r100.minline_preview = this.minline_preview;
        r100.mis_destroyed = this.mis_destroyed;
        r100.mscene_id = this.mscene_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ImageSetV2.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ImageSetV2(String r110, String r111, Crypto r112, List<ImageAttribute> r113, ByteString r114, Boolean r115, Long r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public ImageSetV2(String r100, String r101, Crypto r102, List<ImageAttribute> r103, ByteString r104, Boolean r105, Long r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mimage_key = r100;
        this.mfs_unit = r101;
        this.mcrypto = r102;
        this.mimages = Internal.immutableCopyOf("mimages", r103);
        this.minline_preview = r104;
        this.mis_destroyed = r105;
        this.mscene_id = r106;
    }
}
