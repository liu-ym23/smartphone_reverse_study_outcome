package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ImageSetPassThrough extends com.squareup.wire.Message<ImageSetPassThrough, Builder> {
    public static final ProtoAdapter<ImageSetPassThrough> ADAPTER = null;
    public static final FileType DEFAULT_FILE_TYPE = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final Integer DEFAULT_HEIGHT = null;
    public static final String DEFAULT_KEY = "";
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final SerCrypto crypto;
    public final FileType file_type;
    public final String fs_unit;
    public final Integer height;
    public final String key;
    public final Integer width;

    public static final class Builder extends com.squareup.wire.Message.Builder<ImageSetPassThrough, Builder> {
        public SerCrypto crypto;
        public FileType file_type;
        public String fs_unit;
        public Integer height;
        public String key;
        public Integer width;

        @Override // com.squareup.wire.Message.Builder
        public ImageSetPassThrough build() {
            String r100 = this.key;
            if (r100 == null) goto L7;
            return new ImageSetPassThrough(this.key, this.fs_unit, this.crypto, this.file_type, this.width, this.height, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "key"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder crypto(SerCrypto r100) {
            this.crypto = r100;
            return this;
        }

        public Builder file_type(FileType r100) {
            this.file_type = r100;
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

        public Builder width(Integer r100) {
            this.width = r100;
            return this;
        }
    }

    public static final enum FileType extends Enum<FileType> implements WireEnum {
        private static final /* synthetic */ FileType[] $VALUES = null;
        public static final ProtoAdapter<FileType> ADAPTER = null;
        public static final FileType PROFILE_TOP_IMAGE = null;
        public static final FileType URL_PREVIEW_INLINE_ICON = null;
        private final int value;

        static {
            FileType r100 = new FileType("PROFILE_TOP_IMAGE", 0, 1);
            PROFILE_TOP_IMAGE = r100;
            FileType r101 = new FileType("URL_PREVIEW_INLINE_ICON", 1, 2);
            URL_PREVIEW_INLINE_ICON = r101;
            $VALUES = new FileType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(FileType.class);
        }

        public static FileType[] values() {
            return (FileType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FileType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return URL_PREVIEW_INLINE_ICON;
        L11:
            return PROFILE_TOP_IMAGE;
        }

        public static FileType valueOf(String r100) {
            return (FileType) a.a(FileType.class, r100);
        }

        private FileType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
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
            r101.key = "";
            r101.fs_unit = "";
            r101.file_type = FileType.PROFILE_TOP_IMAGE;
            r101.width = 0;
            r101.height = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.fs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 4) goto L12;
            r101.crypto = SerCrypto.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 5) goto L14;
            r101.file_type = FileType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r103 != 6) goto L16;
            r101.width = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            if (r103 != 7) goto L17;
            r101.height = ProtoAdapter.INT32.decode(r100);
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ImageSetPassThrough r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.key);
            String r103 = r100.fs_unit;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            SerCrypto r107 = r100.crypto;
            if (r107 == null) goto L9;
            int r108 = SerCrypto.ADAPTER.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            FileType r110 = r100.file_type;
            if (r110 == null) goto L13;
            int r111 = FileType.ADAPTER.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            Integer r113 = r100.width;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            Integer r116 = r100.height;
            if (r116 == null) goto L22;
            r104 = ProtoAdapter.INT32.encodedSizeWithTag(7, r116);
        L22:
            return (r115 + r104) + r100.unknownFields().size();
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
            r102.encodeWithTag(r100, 1, r101.key);
            String r103 = r101.fs_unit;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            SerCrypto r104 = r101.crypto;
            if (r104 == null) goto L8;
            SerCrypto.ADAPTER.encodeWithTag(r100, 4, r104);
        L8:
            FileType r105 = r101.file_type;
            if (r105 == null) goto L11;
            FileType.ADAPTER.encodeWithTag(r100, 5, r105);
        L11:
            Integer r106 = r101.width;
            if (r106 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r106);
        L14:
            Integer r107 = r101.height;
            if (r107 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageSetPassThrough r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageSetPassThrough();
        DEFAULT_FILE_TYPE = FileType.PROFILE_TOP_IMAGE;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.fs_unit = this.fs_unit;
        r100.crypto = this.crypto;
        r100.file_type = this.file_type;
        r100.width = this.width;
        r100.height = this.height;
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

    public ImageSetPassThrough(String r100, String r110, SerCrypto r111, FileType r112, Integer r113, Integer r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public ImageSetPassThrough(String r100, String r101, SerCrypto r102, FileType r103, Integer r104, Integer r105, ByteString r106) {
        super(ADAPTER, r106);
        this.key = r100;
        this.fs_unit = r101;
        this.crypto = r102;
        this.file_type = r103;
        this.width = r104;
        this.height = r105;
    }
}
