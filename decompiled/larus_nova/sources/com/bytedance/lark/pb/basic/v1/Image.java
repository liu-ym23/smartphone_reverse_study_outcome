package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Image extends com.squareup.wire.Message<Image, Builder> {
    public static final ProtoAdapter<Image> ADAPTER = null;
    public static final ByteString DEFAULT_CRYPTO = null;
    public static final Integer DEFAULT_EXIF_ORIENTATION = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final Integer DEFAULT_HEIGHT = null;
    public static final String DEFAULT_KEY = "";
    public static final Type DEFAULT_TYPE = null;
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final ByteString crypto;
    public final Integer exif_orientation;
    public final String fs_unit;
    public final Integer height;
    public final String key;
    public final Type type;
    public final List<String> urls;
    public final Integer width;

    public static final class Builder extends com.squareup.wire.Message.Builder<Image, Builder> {
        public ByteString crypto;
        public Integer exif_orientation;
        public String fs_unit;
        public Integer height;
        public String key;
        public Type type;
        public List<String> urls;
        public Integer width;

        @Override // com.squareup.wire.Message.Builder
        public Image build() {
            return new Image(this.key, this.urls, this.width, this.height, this.type, this.exif_orientation, this.crypto, this.fs_unit, super.buildUnknownFields());
        }

        public Builder() {
            this.urls = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder crypto(ByteString r100) {
            this.crypto = r100;
            return this;
        }

        public Builder exif_orientation(Integer r100) {
            this.exif_orientation = r100;
            return this;
        }

        public Builder fs_unit(String r100) {
            this.fs_unit = r100;
            return this;
        }

        public Builder height(Integer r100) {
            this.height = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.urls = r100;
            return this;
        }

        public Builder width(Integer r100) {
            this.width = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Image extends ProtoAdapter<Image> {
        public ProtoAdapter_Image() {
            super(FieldEncoding.LENGTH_DELIMITED, Image.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Image decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.width = 0;
            r101.height = 0;
            r101.type = Type.NORMAL;
            r101.exif_orientation = 0;
            r101.crypto = ByteString.EMPTY;
            r101.fs_unit = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L20;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.fs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.crypto = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L9:
            r101.exif_orientation = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L14:
            r101.height = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.width = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L17:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Image r100) {
            String r101 = r100.key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            int r105 = r103 + r104.asRepeated().encodedSizeWithTag(2, r100.urls);
            Integer r106 = r100.width;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.INT32.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Integer r109 = r100.height;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.INT32.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            Type r112 = r100.type;
            if (r112 == null) goto L17;
            int r113 = Type.ADAPTER.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            Integer r115 = r100.exif_orientation;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.UINT32.encodedSizeWithTag(6, r115);
        L22:
            int r117 = r114 + r116;
            ByteString r118 = r100.crypto;
            if (r118 == null) goto L25;
            int r119 = ProtoAdapter.BYTES.encodedSizeWithTag(7, r118);
        L26:
            int r120 = r117 + r119;
            String r121 = r100.fs_unit;
            if (r121 == null) goto L30;
            r102 = r104.encodedSizeWithTag(8, r121);
        L30:
            return (r120 + r102) + r100.unknownFields().size();
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
            String r102 = r101.key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.asRepeated().encodeWithTag(r100, 2, r101.urls);
            Integer r104 = r101.width;
            if (r104 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L8:
            Integer r105 = r101.height;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L11:
            Type r106 = r101.type;
            if (r106 == null) goto L14;
            Type.ADAPTER.encodeWithTag(r100, 5, r106);
        L14:
            Integer r107 = r101.exif_orientation;
            if (r107 == null) goto L17;
            ProtoAdapter.UINT32.encodeWithTag(r100, 6, r107);
        L17:
            ByteString r108 = r101.crypto;
            if (r108 == null) goto L20;
            ProtoAdapter.BYTES.encodeWithTag(r100, 7, r108);
        L20:
            String r109 = r101.fs_unit;
            if (r109 == null) goto L23;
            r103.encodeWithTag(r100, 8, r109);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Image r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type ENCRYPTED = null;
        public static final Type NORMAL = null;
        private final int value;

        static {
            Type r100 = new Type(EffectConstants.NORMAL, 0, 1);
            NORMAL = r100;
            Type r101 = new Type("ENCRYPTED", 1, 2);
            ENCRYPTED = r101;
            $VALUES = new Type[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return ENCRYPTED;
        L11:
            return NORMAL;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Image();
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_TYPE = Type.NORMAL;
        DEFAULT_EXIF_ORIENTATION = 0;
        DEFAULT_CRYPTO = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.urls = Internal.copyOf("urls", this.urls);
        r100.width = this.width;
        r100.height = this.height;
        r100.type = this.type;
        r100.exif_orientation = this.exif_orientation;
        r100.crypto = this.crypto;
        r100.fs_unit = this.fs_unit;
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

    public Image(String r110, List<String> r111, Integer r112, Integer r113, Type r114, Integer r115, ByteString r116, String r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public Image(String r100, List<String> r101, Integer r102, Integer r103, Type r104, Integer r105, ByteString r106, String r107, ByteString r110) {
        super(ADAPTER, r110);
        this.key = r100;
        this.urls = Internal.immutableCopyOf("urls", r101);
        this.width = r102;
        this.height = r103;
        this.type = r104;
        this.exif_orientation = r105;
        this.crypto = r106;
        this.fs_unit = r107;
    }
}
