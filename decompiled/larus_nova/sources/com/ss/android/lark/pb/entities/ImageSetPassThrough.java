package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ImageSetPassThrough extends com.squareup.wire.Message<ImageSetPassThrough, Builder> {
    public static final ProtoAdapter<ImageSetPassThrough> ADAPTER = null;
    public static final Integer DEFAULT_FILE_TYPE = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final Integer DEFAULT_HEIGHT = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_URL = "";
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final Crypto mcrypto;
    public final Integer mfile_type;
    public final String mfs_unit;
    public final Integer mheight;
    public final String mkey;
    public final String murl;
    public final Integer mwidth;

    public static final class Builder extends com.squareup.wire.Message.Builder<ImageSetPassThrough, Builder> {
        public Crypto mcrypto;
        public Integer mfile_type;
        public String mfs_unit;
        public Integer mheight;
        public String mkey;
        public String murl;
        public Integer mwidth;

        @Override // com.squareup.wire.Message.Builder
        public ImageSetPassThrough build() {
            String r100 = this.mkey;
            if (r100 == null) goto L7;
            return new ImageSetPassThrough(this.mkey, this.mfs_unit, this.murl, this.mcrypto, this.mfile_type, this.mwidth, this.mheight, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mkey"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder crypto(Crypto r100) {
            this.mcrypto = r100;
            return this;
        }

        public Builder file_type(Integer r100) {
            this.mfile_type = r100;
            return this;
        }

        public Builder fs_unit(String r100) {
            this.mfs_unit = r100;
            return this;
        }

        public Builder height(Integer r100) {
            this.mheight = r100;
            return this;
        }

        public Builder key(String r100) {
            this.mkey = r100;
            return this;
        }

        public Builder url(String r100) {
            this.murl = r100;
            return this;
        }

        public Builder width(Integer r100) {
            this.mwidth = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ImageSetPassThrough extends ProtoAdapter<ImageSetPassThrough> {
        public ProtoAdapter_ImageSetPassThrough() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageSetPassThrough.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ImageSetPassThrough decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mkey = "";
            r101.mfs_unit = "";
            r101.murl = "";
            r101.mfile_type = 0;
            r101.mwidth = 0;
            r101.mheight = 0;
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
            r101.mheight = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.mwidth = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.mfile_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.mcrypto = Crypto.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.murl = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mfs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mkey = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ImageSetPassThrough r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mkey);
            String r103 = r100.mfs_unit;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.murl;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Crypto r110 = r100.mcrypto;
            if (r110 == null) goto L13;
            int r111 = Crypto.ADAPTER.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Integer r113 = r100.mfile_type;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Integer r116 = r100.mwidth;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            Integer r119 = r100.mheight;
            if (r119 == null) goto L26;
            r104 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
        L26:
            return (r118 + r104) + r100.unknownFields().size();
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ImageSetPassThrough decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ImageSetPassThrough r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ImageSetPassThrough r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mkey);
            String r103 = r101.mfs_unit;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.murl;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            Crypto r105 = r101.mcrypto;
            if (r105 == null) goto L11;
            Crypto.ADAPTER.encodeWithTag(r100, 4, r105);
        L11:
            Integer r106 = r101.mfile_type;
            if (r106 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L14:
            Integer r107 = r101.mwidth;
            if (r107 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L17:
            Integer r108 = r101.mheight;
            if (r108 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageSetPassThrough r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageSetPassThrough();
        DEFAULT_FILE_TYPE = 0;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mkey = this.mkey;
        r100.mfs_unit = this.mfs_unit;
        r100.murl = this.murl;
        r100.mcrypto = this.mcrypto;
        r100.mfile_type = this.mfile_type;
        r100.mwidth = this.mwidth;
        r100.mheight = this.mheight;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ImageSetPassThrough.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ImageSetPassThrough(String r110, String r111, String r112, Crypto r113, Integer r114, Integer r115, Integer r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public ImageSetPassThrough(String r100, String r101, String r102, Crypto r103, Integer r104, Integer r105, Integer r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mkey = r100;
        this.mfs_unit = r101;
        this.murl = r102;
        this.mcrypto = r103;
        this.mfile_type = r104;
        this.mwidth = r105;
        this.mheight = r106;
    }
}
