package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ImageKeyInfo extends Message<ImageKeyInfo, Builder> {
    public static final ProtoAdapter<ImageKeyInfo> ADAPTER = null;
    public static final String DEFAULT_IMAGE_KEY = "";
    public static final Boolean DEFAULT_IS_ORIGIN = null;
    private static final long serialVersionUID = 0;
    public final String image_key;
    public final Boolean is_origin;

    public static final class Builder extends Message.Builder<ImageKeyInfo, Builder> {
        public String image_key;
        public Boolean is_origin;

        @Override // com.squareup.wire.Message.Builder
        public ImageKeyInfo build() {
            String r100 = this.image_key;
            if (r100 == null) goto L9;
            if (this.is_origin == null) goto L9;
            return new ImageKeyInfo(this.image_key, this.is_origin, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "image_key", this.is_origin, "is_origin"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder image_key(String r100) {
            this.image_key = r100;
            return this;
        }

        public Builder is_origin(Boolean r100) {
            this.is_origin = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ImageKeyInfo extends ProtoAdapter<ImageKeyInfo> {
        public ProtoAdapter_ImageKeyInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageKeyInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ImageKeyInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.image_key = "";
            r101.is_origin = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.image_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.is_origin = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ImageKeyInfo r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.image_key) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.is_origin)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ImageKeyInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ImageKeyInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ImageKeyInfo r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.image_key);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.is_origin);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageKeyInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageKeyInfo();
        DEFAULT_IS_ORIGIN = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.image_key = this.image_key;
        r100.is_origin = this.is_origin;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ImageKeyInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ImageKeyInfo(String r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ImageKeyInfo(String r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.image_key = r100;
        this.is_origin = r101;
    }
}
