package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UploadImageV2Request extends Message<UploadImageV2Request, Builder> {
    public static final ProtoAdapter<UploadImageV2Request> ADAPTER = null;
    public static final ByteString DEFAULT_IMAGE = null;
    public static final ImageType DEFAULT_IMAGE_TYPE = null;
    public static final ProtoAdapter_UploadImageV2Request RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ByteString image;
    public final ImageType image_type;

    public static final class Builder extends Message.Builder<UploadImageV2Request, Builder> implements d<UploadImageV2Request> {
        public ByteString image;
        public ImageType image_type;

        @Override // com.squareup.wire.Message.Builder
        public UploadImageV2Request build() {
            ImageType r100 = this.image_type;
            if (r100 == null) goto L7;
            return new UploadImageV2Request(this.image_type, this.image, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "image_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder image(ByteString r100) {
            this.image = r100;
            return this;
        }

        public Builder image_type(ImageType r100) {
            this.image_type = r100;
            return this;
        }
    }

    public static final enum ImageType extends Enum<ImageType> implements WireEnum {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ProtoAdapter<ImageType> ADAPTER = null;
        public static final ImageType ChatThemeImage = null;
        public static final ImageType ProfileTopImage = null;
        private final int value;

        static {
            ImageType r100 = new ImageType("ProfileTopImage", 0, 1);
            ProfileTopImage = r100;
            ImageType r101 = new ImageType("ChatThemeImage", 1, 2);
            ChatThemeImage = r101;
            $VALUES = new ImageType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(ImageType.class);
        }

        public static ImageType[] values() {
            return (ImageType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ImageType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return ChatThemeImage;
        L11:
            return ProfileTopImage;
        }

        public static ImageType valueOf(String r100) {
            return (ImageType) a.a(ImageType.class, r100);
        }

        private ImageType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_UploadImageV2Request extends ProtoAdapter<UploadImageV2Request> implements c<UploadImageV2Request> {
        public ProtoAdapter_UploadImageV2Request() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadImageV2Request.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadImageV2Request decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.image_type = ImageType.ProfileTopImage;
            r101.image = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.image_type = ImageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.image = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(UploadImageV2Request r100) {
            int r101 = ImageType.ADAPTER.encodedSizeWithTag(1, r100.image_type);
            ByteString r102 = r100.image;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UploadImageV2Request decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadImageV2Request r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadImageV2Request r101) throws IOException {
            ImageType.ADAPTER.encodeWithTag(r100, 1, r101.image_type);
            ByteString r102 = r101.image;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadImageV2Request r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UploadImageV2Request r100 = new ProtoAdapter_UploadImageV2Request();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IMAGE_TYPE = ImageType.ProfileTopImage;
        DEFAULT_IMAGE = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.image_type = this.image_type;
        r100.image = this.image;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadImageV2Request.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadImageV2Request(ImageType r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UploadImageV2Request(ImageType r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.image_type = r100;
        this.image = r101;
    }
}
