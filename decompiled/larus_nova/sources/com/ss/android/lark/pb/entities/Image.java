package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Image extends com.squareup.wire.Message<Image, Builder> {
    public static final ProtoAdapter<Image> ADAPTER = null;
    public static final String DEFAULT_ETAG = "";
    public static final String DEFAULT_FS_UNIT = "";
    public static final Integer DEFAULT_HEIGHT = null;
    public static final String DEFAULT_KEY = "";
    public static final Integer DEFAULT_SECURE_HEIGHT = null;
    public static final String DEFAULT_SECURE_KEY = "";
    public static final Integer DEFAULT_SECURE_WIDTH = null;
    public static final Integer DEFAULT_SIZE = null;
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final Crypto mcrypto;
    public final String metag;
    public final String mfs_unit;
    public final Integer mheight;
    public final String mkey;
    public final Map<String, String> mparams;
    public final Integer msecure_height;
    public final String msecure_key;
    public final List<String> msecure_urls;
    public final Integer msecure_width;
    public final Integer msize;
    public final List<String> murls;
    public final Integer mwidth;

    public static final class Builder extends com.squareup.wire.Message.Builder<Image, Builder> {
        public Crypto mcrypto;
        public String metag;
        public String mfs_unit;
        public Integer mheight;
        public String mkey;
        public Map<String, String> mparams;
        public Integer msecure_height;
        public String msecure_key;
        public List<String> msecure_urls;
        public Integer msecure_width;
        public Integer msize;
        public List<String> murls;
        public Integer mwidth;

        @Override // com.squareup.wire.Message.Builder
        public Image build() {
            return new Image(this.mkey, this.murls, this.mwidth, this.mheight, this.msecure_key, this.msecure_urls, this.msecure_width, this.msecure_height, this.mcrypto, this.msize, this.mfs_unit, this.mparams, this.metag, super.buildUnknownFields());
        }

        public Builder() {
            this.murls = Internal.newMutableList();
            this.msecure_urls = Internal.newMutableList();
            this.mparams = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder crypto(Crypto r100) {
            this.mcrypto = r100;
            return this;
        }

        public Builder etag(String r100) {
            this.metag = r100;
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

        public Builder params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mparams = r100;
            return this;
        }

        public Builder secure_height(Integer r100) {
            this.msecure_height = r100;
            return this;
        }

        public Builder secure_key(String r100) {
            this.msecure_key = r100;
            return this;
        }

        public Builder secure_urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.msecure_urls = r100;
            return this;
        }

        public Builder secure_width(Integer r100) {
            this.msecure_width = r100;
            return this;
        }

        public Builder size(Integer r100) {
            this.msize = r100;
            return this;
        }

        public Builder urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.murls = r100;
            return this;
        }

        public Builder width(Integer r100) {
            this.mwidth = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Image extends ProtoAdapter<Image> {
        private final ProtoAdapter<Map<String, String>> mparams;

        public ProtoAdapter_Image() {
            super(FieldEncoding.LENGTH_DELIMITED, Image.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mparams = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Image decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mkey = "";
            r101.mwidth = 0;
            r101.mheight = 0;
            r101.msecure_key = "";
            r101.msecure_width = 0;
            r101.msecure_height = 0;
            r101.msize = 0;
            r101.mfs_unit = "";
            r101.metag = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L20;
            switch(r103) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L7:
            r101.metag = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mparams.putAll(this.mparams.decode(r100));
            goto L3
        L9:
            r101.mfs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.msize = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.mcrypto = Crypto.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.msecure_height = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            r101.msecure_width = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.msecure_urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L15:
            r101.msecure_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mheight = ProtoAdapter.INT32.decode(r100);
            goto L3
        L17:
            r101.mwidth = ProtoAdapter.INT32.decode(r100);
            goto L3
        L18:
            r101.murls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L19:
            r101.mkey = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Image r100) {
            String r101 = r100.mkey;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            int r105 = r103 + r104.asRepeated().encodedSizeWithTag(2, r100.murls);
            Integer r106 = r100.mwidth;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.INT32.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Integer r109 = r100.mheight;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.INT32.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.msecure_key;
            if (r112 == null) goto L17;
            int r113 = r104.encodedSizeWithTag(5, r112);
        L18:
            int r114 = (r111 + r113) + r104.asRepeated().encodedSizeWithTag(6, r100.msecure_urls);
            Integer r115 = r100.msecure_width;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.INT32.encodedSizeWithTag(7, r115);
        L22:
            int r117 = r114 + r116;
            Integer r118 = r100.msecure_height;
            if (r118 == null) goto L25;
            int r119 = ProtoAdapter.INT32.encodedSizeWithTag(8, r118);
        L26:
            int r120 = r117 + r119;
            Crypto r121 = r100.mcrypto;
            if (r121 == null) goto L29;
            int r122 = Crypto.ADAPTER.encodedSizeWithTag(9, r121);
        L30:
            int r123 = r120 + r122;
            Integer r124 = r100.msize;
            if (r124 == null) goto L33;
            int r125 = ProtoAdapter.INT32.encodedSizeWithTag(10, r124);
        L34:
            int r126 = r123 + r125;
            String r127 = r100.mfs_unit;
            if (r127 == null) goto L37;
            int r128 = r104.encodedSizeWithTag(11, r127);
        L38:
            int r129 = (r126 + r128) + this.mparams.encodedSizeWithTag(12, r100.mparams);
            String r130 = r100.metag;
            if (r130 == null) goto L42;
            r102 = r104.encodedSizeWithTag(13, r130);
        L42:
            return (r129 + r102) + r100.unknownFields().size();
        L37:
            r128 = 0;
            goto L38
        L33:
            r125 = 0;
            goto L34
        L29:
            r122 = 0;
            goto L30
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Image decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Image r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Image r101) throws IOException {
            String r102 = r101.mkey;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.asRepeated().encodeWithTag(r100, 2, r101.murls);
            Integer r104 = r101.mwidth;
            if (r104 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L8:
            Integer r105 = r101.mheight;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.msecure_key;
            if (r106 == null) goto L14;
            r103.encodeWithTag(r100, 5, r106);
        L14:
            r103.asRepeated().encodeWithTag(r100, 6, r101.msecure_urls);
            Integer r107 = r101.msecure_width;
            if (r107 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r107);
        L17:
            Integer r108 = r101.msecure_height;
            if (r108 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r108);
        L20:
            Crypto r109 = r101.mcrypto;
            if (r109 == null) goto L23;
            Crypto.ADAPTER.encodeWithTag(r100, 9, r109);
        L23:
            Integer r110 = r101.msize;
            if (r110 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 10, r110);
        L26:
            String r111 = r101.mfs_unit;
            if (r111 == null) goto L29;
            r103.encodeWithTag(r100, 11, r111);
        L29:
            this.mparams.encodeWithTag(r100, 12, r101.mparams);
            String r112 = r101.metag;
            if (r112 == null) goto L32;
            r103.encodeWithTag(r100, 13, r112);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Image r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Image();
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_SECURE_WIDTH = 0;
        DEFAULT_SECURE_HEIGHT = 0;
        DEFAULT_SIZE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mkey = this.mkey;
        r100.murls = Internal.copyOf("murls", this.murls);
        r100.mwidth = this.mwidth;
        r100.mheight = this.mheight;
        r100.msecure_key = this.msecure_key;
        r100.msecure_urls = Internal.copyOf("msecure_urls", this.msecure_urls);
        r100.msecure_width = this.msecure_width;
        r100.msecure_height = this.msecure_height;
        r100.mcrypto = this.mcrypto;
        r100.msize = this.msize;
        r100.mfs_unit = this.mfs_unit;
        r100.mparams = Internal.copyOf("mparams", this.mparams);
        r100.metag = this.metag;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Image.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Image(String r110, List<String> r111, Integer r112, Integer r113, String r210, List<String> r211, Integer r212, Integer r213, Crypto r214, Integer r215, String r216, Map<String, String> r217, String r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public Image(String r100, List<String> r101, Integer r102, Integer r103, String r104, List<String> r105, Integer r106, Integer r107, Crypto r110, Integer r111, String r112, Map<String, String> r113, String r114, ByteString r115) {
        super(ADAPTER, r115);
        this.mkey = r100;
        this.murls = Internal.immutableCopyOf("murls", r101);
        this.mwidth = r102;
        this.mheight = r103;
        this.msecure_key = r104;
        this.msecure_urls = Internal.immutableCopyOf("msecure_urls", r105);
        this.msecure_width = r106;
        this.msecure_height = r107;
        this.mcrypto = r110;
        this.msize = r111;
        this.mfs_unit = r112;
        this.mparams = Internal.immutableCopyOf("mparams", r113);
        this.metag = r114;
    }
}
