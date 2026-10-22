package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DriveFile extends Message<DriveFile, Builder> {
    public static final ProtoAdapter<DriveFile> ADAPTER = null;
    public static final String DEFAULT_BYTES_TOTAL = "";
    public static final String DEFAULT_BYTES_TRANSFERRED = "";
    public static final String DEFAULT_DATA_VERSION = "";
    public static final String DEFAULT_ERROR_CODE = "";
    public static final String DEFAULT_FILE_NAME = "";
    public static final String DEFAULT_FILE_TYPE = "";
    public static final Integer DEFAULT_ID = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_MOUNT_NODE_POINT = "";
    public static final String DEFAULT_PATH = "";
    public static final Integer DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    public final String bytes_total;
    public final String bytes_transferred;
    public final String data_version;
    public final String error_code;
    public final String file_name;
    public final String file_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Integer f253765id;
    public final String key;
    public final String mount_node_point;
    public final String path;
    public final Integer status;

    public static final class Builder extends Message.Builder<DriveFile, Builder> {
        public String bytes_total;
        public String bytes_transferred;
        public String data_version;
        public String error_code;
        public String file_name;
        public String file_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Integer f253766id;
        public String key;
        public String mount_node_point;
        public String path;
        public Integer status;

        @Override // com.squareup.wire.Message.Builder
        public DriveFile build() {
            String r100 = this.key;
            if (r100 == null) goto L11;
            if (this.file_name == null) goto L11;
            if (this.path == null) goto L11;
            return new DriveFile(this.key, this.file_name, this.path, this.status, this.bytes_transferred, this.bytes_total, this.mount_node_point, this.data_version, this.file_type, this.error_code, this.f253766id, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "key", this.file_name, "file_name", this.path, "path"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bytes_total(String r100) {
            this.bytes_total = r100;
            return this;
        }

        public Builder bytes_transferred(String r100) {
            this.bytes_transferred = r100;
            return this;
        }

        public Builder data_version(String r100) {
            this.data_version = r100;
            return this;
        }

        public Builder error_code(String r100) {
            this.error_code = r100;
            return this;
        }

        public Builder file_name(String r100) {
            this.file_name = r100;
            return this;
        }

        public Builder file_type(String r100) {
            this.file_type = r100;
            return this;
        }

        public Builder id(Integer r100) {
            this.f253766id = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder mount_node_point(String r100) {
            this.mount_node_point = r100;
            return this;
        }

        public Builder path(String r100) {
            this.path = r100;
            return this;
        }

        public Builder status(Integer r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DriveFile extends ProtoAdapter<DriveFile> {
        public ProtoAdapter_DriveFile() {
            super(FieldEncoding.LENGTH_DELIMITED, DriveFile.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DriveFile decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.file_name = "";
            r101.path = "";
            r101.status = 0;
            r101.bytes_transferred = "";
            r101.bytes_total = "";
            r101.mount_node_point = "";
            r101.data_version = "";
            r101.file_type = "";
            r101.error_code = "";
            r101.f253766id = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r101.f253766id = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.error_code = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.file_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.data_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mount_node_point = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.bytes_total = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.bytes_transferred = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.status = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.file_name = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(DriveFile r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.key) + r101.encodedSizeWithTag(2, r100.file_name)) + r101.encodedSizeWithTag(3, r100.path);
            Integer r103 = r100.status;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.bytes_transferred;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.bytes_total;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(6, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.mount_node_point;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(7, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.data_version;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(8, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.file_type;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(9, r119);
        L26:
            int r121 = r118 + r120;
            String r122 = r100.error_code;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(10, r122);
        L30:
            int r124 = r121 + r123;
            Integer r125 = r100.f253765id;
            if (r125 == null) goto L34;
            r104 = ProtoAdapter.INT32.encodedSizeWithTag(11, r125);
        L34:
            return (r124 + r104) + r100.unknownFields().size();
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
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
        public /* bridge */ /* synthetic */ DriveFile decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DriveFile r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DriveFile r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.key);
            r102.encodeWithTag(r100, 2, r101.file_name);
            r102.encodeWithTag(r100, 3, r101.path);
            Integer r103 = r101.status;
            if (r103 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r103);
        L5:
            String r104 = r101.bytes_transferred;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 5, r104);
        L8:
            String r105 = r101.bytes_total;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 6, r105);
        L11:
            String r106 = r101.mount_node_point;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 7, r106);
        L14:
            String r107 = r101.data_version;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 8, r107);
        L17:
            String r108 = r101.file_type;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 9, r108);
        L20:
            String r109 = r101.error_code;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 10, r109);
        L23:
            Integer r110 = r101.f253765id;
            if (r110 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 11, r110);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DriveFile r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DriveFile();
        DEFAULT_STATUS = 0;
        DEFAULT_ID = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.file_name = this.file_name;
        r100.path = this.path;
        r100.status = this.status;
        r100.bytes_transferred = this.bytes_transferred;
        r100.bytes_total = this.bytes_total;
        r100.mount_node_point = this.mount_node_point;
        r100.data_version = this.data_version;
        r100.file_type = this.file_type;
        r100.error_code = this.error_code;
        r100.f253766id = this.f253765id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DriveFile.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DriveFile(String r110, String r111, String r112, Integer r113, String r114, String r115, String r210, String r211, String r212, String r213, Integer r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public DriveFile(String r100, String r101, String r102, Integer r103, String r104, String r105, String r106, String r107, String r110, String r111, Integer r112, ByteString r113) {
        super(ADAPTER, r113);
        this.key = r100;
        this.file_name = r101;
        this.path = r102;
        this.status = r103;
        this.bytes_transferred = r104;
        this.bytes_total = r105;
        this.mount_node_point = r106;
        this.data_version = r107;
        this.file_type = r110;
        this.error_code = r111;
        this.f253765id = r112;
    }
}
