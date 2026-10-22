package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.entities.ImageSetPassThrough;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class IconInfo extends Message<IconInfo, Builder> {
    public static final ProtoAdapter<IconInfo> ADAPTER = null;
    public static final String DEFAULT_UD_IMAGE = "";
    private static final long serialVersionUID = 0;
    public final IconImageType micon_image_type;
    public final ImageSetPassThrough mimage;
    public final String mud_image;

    public static final class Builder extends Message.Builder<IconInfo, Builder> {
        public IconImageType micon_image_type;
        public ImageSetPassThrough mimage;
        public String mud_image;

        @Override // com.squareup.wire.Message.Builder
        public IconInfo build() {
            return new IconInfo(this.micon_image_type, this.mud_image, this.mimage, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder icon_image_type(IconImageType r100) {
            this.micon_image_type = r100;
            return this;
        }

        public Builder image(ImageSetPassThrough r100) {
            this.mimage = r100;
            return this;
        }

        public Builder ud_image(String r100) {
            this.mud_image = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_IconInfo extends ProtoAdapter<IconInfo> {
        public ProtoAdapter_IconInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, IconInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public IconInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mud_image = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.micon_image_type = IconImageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mud_image = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mimage = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(IconInfo r100) {
            IconImageType r101 = r100.micon_image_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = IconImageType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mud_image;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ImageSetPassThrough r107 = r100.mimage;
            if (r107 == null) goto L14;
            r102 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ IconInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(IconInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, IconInfo r101) throws IOException {
            IconImageType r102 = r101.micon_image_type;
            if (r102 == null) goto L5;
            IconImageType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mud_image;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ImageSetPassThrough r104 = r101.mimage;
            if (r104 == null) goto L11;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, IconInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_IconInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.micon_image_type = this.micon_image_type;
        r100.mud_image = this.mud_image;
        r100.mimage = this.mimage;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return IconInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public IconInfo(IconImageType r100, String r101, ImageSetPassThrough r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public IconInfo(IconImageType r100, String r101, ImageSetPassThrough r102, ByteString r103) {
        super(ADAPTER, r103);
        this.micon_image_type = r100;
        this.mud_image = r101;
        this.mimage = r102;
    }
}
