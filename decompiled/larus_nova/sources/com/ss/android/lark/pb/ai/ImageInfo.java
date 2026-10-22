package com.ss.android.lark.pb.ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ImageInfo extends Message<ImageInfo, Builder> {
    public static final ProtoAdapter<ImageInfo> ADAPTER = null;
    public static final ByteString DEFAULT_DATA = null;
    public static final String DEFAULT_TOS_OBJECT = "";
    private static final long serialVersionUID = 0;
    public final ByteString mdata;
    public final String mtos_object;

    public static final class Builder extends Message.Builder<ImageInfo, Builder> {
        public ByteString mdata;
        public String mtos_object;

        @Override // com.squareup.wire.Message.Builder
        public ImageInfo build() {
            return new ImageInfo(this.mdata, this.mtos_object, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder data(ByteString r100) {
            this.mdata = r100;
            return this;
        }

        public Builder tos_object(String r100) {
            this.mtos_object = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ImageInfo extends ProtoAdapter<ImageInfo> {
        public ProtoAdapter_ImageInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ImageInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mdata = ByteString.EMPTY;
            r101.mtos_object = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mdata = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mtos_object = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ImageInfo r100) {
            ByteString r101 = r100.mdata;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mtos_object;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ImageInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ImageInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ImageInfo r101) throws IOException {
            ByteString r102 = r101.mdata;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mtos_object;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageInfo();
        DEFAULT_DATA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mdata = this.mdata;
        r100.mtos_object = this.mtos_object;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ImageInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ImageInfo(ByteString r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ImageInfo(ByteString r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mdata = r100;
        this.mtos_object = r101;
    }
}
