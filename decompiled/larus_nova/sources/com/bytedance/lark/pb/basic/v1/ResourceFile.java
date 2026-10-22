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
public final class ResourceFile extends com.squareup.wire.Message<ResourceFile, Builder> {
    public static final ProtoAdapter<ResourceFile> ADAPTER = null;
    public static final ByteString DEFAULT_FILE_DATA = null;
    public static final Long DEFAULT_FILE_HANDLE = null;
    public static final String DEFAULT_FILE_NAME = "";
    public static final String DEFAULT_FILE_PATH = "";
    public static final FileType DEFAULT_FILE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final ByteString file_data;
    public final Long file_handle;
    public final String file_name;
    public final String file_path;
    public final FileType file_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<ResourceFile, Builder> {
        public ByteString file_data;
        public Long file_handle;
        public String file_name;
        public String file_path;
        public FileType file_type;

        @Override // com.squareup.wire.Message.Builder
        public ResourceFile build() {
            FileType r100 = this.file_type;
            if (r100 == null) goto L9;
            if (this.file_path == null) goto L9;
            return new ResourceFile(this.file_type, this.file_path, this.file_handle, this.file_data, this.file_name, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "file_type", this.file_path, "file_path"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder file_data(ByteString r100) {
            this.file_data = r100;
            return this;
        }

        public Builder file_handle(Long r100) {
            this.file_handle = r100;
            return this;
        }

        public Builder file_name(String r100) {
            this.file_name = r100;
            return this;
        }

        public Builder file_path(String r100) {
            this.file_path = r100;
            return this;
        }

        public Builder file_type(FileType r100) {
            this.file_type = r100;
            return this;
        }
    }

    public static final enum FileType extends Enum<FileType> implements WireEnum {
        private static final /* synthetic */ FileType[] $VALUES = null;
        public static final ProtoAdapter<FileType> ADAPTER = null;
        public static final FileType FILE = null;
        public static final FileType FOLDER = null;
        public static final FileType IMAGE = null;
        public static final FileType MEDIA = null;
        private final int value;

        static {
            FileType r100 = new FileType("FILE", 0, 1);
            FILE = r100;
            FileType r101 = new FileType("IMAGE", 1, 2);
            IMAGE = r101;
            FileType r102 = new FileType("MEDIA", 2, 5);
            MEDIA = r102;
            FileType r103 = new FileType("FOLDER", 3, 9);
            FOLDER = r103;
            $VALUES = new FileType[]{r100, r101, r102, r103};
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
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 5) goto L15;
            if (r100 == 9) goto L13;
            return null;
        L13:
            return FOLDER;
        L15:
            return MEDIA;
        L17:
            return IMAGE;
        L19:
            return FILE;
        }

        public static FileType valueOf(String r100) {
            return (FileType) a.a(FileType.class, r100);
        }

        private FileType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ResourceFile extends ProtoAdapter<ResourceFile> {
        public ProtoAdapter_ResourceFile() {
            super(FieldEncoding.LENGTH_DELIMITED, ResourceFile.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ResourceFile decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.file_type = FileType.FILE;
            r101.file_path = "";
            r101.file_handle = 0L;
            r101.file_data = ByteString.EMPTY;
            r101.file_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.file_type = FileType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.file_handle = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.file_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.file_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ResourceFile r100) {
            int r101 = FileType.ADAPTER.encodedSizeWithTag(1, r100.file_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.file_path);
            Long r104 = r100.file_handle;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = ProtoAdapter.INT64.encodedSizeWithTag(3, r104);
        L6:
            int r107 = r103 + r106;
            ByteString r108 = r100.file_data;
            if (r108 == null) goto L9;
            int r109 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r108);
        L10:
            int r110 = r107 + r109;
            String r111 = r100.file_name;
            if (r111 == null) goto L14;
            r105 = r102.encodedSizeWithTag(5, r111);
        L14:
            return (r110 + r105) + r100.unknownFields().size();
        L9:
            r109 = 0;
            goto L10
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResourceFile decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ResourceFile r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ResourceFile r101) throws IOException {
            FileType.ADAPTER.encodeWithTag(r100, 1, r101.file_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.file_path);
            Long r103 = r101.file_handle;
            if (r103 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
        L5:
            ByteString r104 = r101.file_data;
            if (r104 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r104);
        L8:
            String r105 = r101.file_name;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 5, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResourceFile r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ResourceFile();
        DEFAULT_FILE_TYPE = FileType.FILE;
        DEFAULT_FILE_HANDLE = 0L;
        DEFAULT_FILE_DATA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_type = this.file_type;
        r100.file_path = this.file_path;
        r100.file_handle = this.file_handle;
        r100.file_data = this.file_data;
        r100.file_name = this.file_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ResourceFile.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ResourceFile(FileType r100, String r101, Long r110, ByteString r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ResourceFile(FileType r100, String r101, Long r102, ByteString r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.file_type = r100;
        this.file_path = r101;
        this.file_handle = r102;
        this.file_data = r103;
        this.file_name = r104;
    }
}
