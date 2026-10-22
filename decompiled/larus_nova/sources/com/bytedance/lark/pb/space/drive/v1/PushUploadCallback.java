package com.bytedance.lark.pb.space.drive.v1;

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
public final class PushUploadCallback extends Message<PushUploadCallback, Builder> {
    public static final ProtoAdapter<PushUploadCallback> ADAPTER = null;
    public static final String DEFAULT_BYTES_TOTAL = "";
    public static final String DEFAULT_BYTES_TRANSFERRED = "";
    public static final String DEFAULT_DATA_VERSION = "";
    public static final String DEFAULT_FILE_PATH = "";
    public static final String DEFAULT_FILE_TOKEN = "";
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_MOUNT_NODE_POINT = "";
    public static final String DEFAULT_MOUNT_POINT = "";
    public static final UploadScene DEFAULT_SCENE = null;
    public static final Status DEFAULT_STATUS = null;
    public static final String DEFAULT_URI_STR = "";
    public static final ProtoAdapter_PushUploadCallback RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String bytes_total;
    public final String bytes_transferred;
    public final String data_version;
    public final UploadExtraInfo extra_info;
    public final UploadFailedInfo failed_info;
    public final String file_path;
    public final String file_token;
    public final String key;
    public final String mount_node_point;
    public final String mount_point;
    public final UploadScene scene;
    public final Status status;
    public final String uri_str;

    public static final class Builder extends Message.Builder<PushUploadCallback, Builder> implements d<PushUploadCallback> {
        public String bytes_total;
        public String bytes_transferred;
        public String data_version;
        public UploadExtraInfo extra_info;
        public UploadFailedInfo failed_info;
        public String file_path;
        public String file_token;
        public String key;
        public String mount_node_point;
        public String mount_point;
        public UploadScene scene;
        public Status status;
        public String uri_str;

        @Override // com.squareup.wire.Message.Builder
        public PushUploadCallback build() {
            String r100 = this.key;
            if (r100 == null) goto L7;
            return new PushUploadCallback(this.key, this.status, this.bytes_transferred, this.bytes_total, this.file_token, this.file_path, this.mount_node_point, this.failed_info, this.data_version, this.mount_point, this.extra_info, this.scene, this.uri_str, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "key"});
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

        public Builder extra_info(UploadExtraInfo r100) {
            this.extra_info = r100;
            return this;
        }

        public Builder failed_info(UploadFailedInfo r100) {
            this.failed_info = r100;
            return this;
        }

        public Builder file_path(String r100) {
            this.file_path = r100;
            return this;
        }

        public Builder file_token(String r100) {
            this.file_token = r100;
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

        public Builder mount_point(String r100) {
            this.mount_point = r100;
            return this;
        }

        public Builder scene(UploadScene r100) {
            this.scene = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }

        public Builder uri_str(String r100) {
            this.uri_str = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushUploadCallback extends ProtoAdapter<PushUploadCallback> implements c<PushUploadCallback> {
        public ProtoAdapter_PushUploadCallback() {
            super(FieldEncoding.LENGTH_DELIMITED, PushUploadCallback.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushUploadCallback decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.status = Status.PENDING;
            r101.bytes_transferred = "";
            r101.bytes_total = "";
            r101.file_token = "";
            r101.file_path = "";
            r101.mount_node_point = "";
            r101.data_version = "";
            r101.mount_point = "";
            r101.scene = UploadScene.UNKNOWN;
            r101.uri_str = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L26;
            switch(r103) {
                case 1: goto L25;
                case 2: goto L28;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L30;
                case 13: goto L7;
                default: goto L6;
            };
        L28:
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r101.scene = UploadScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.uri_str = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.extra_info = UploadExtraInfo.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.mount_point = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.data_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.failed_info = UploadFailedInfo.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.mount_node_point = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.file_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.bytes_total = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.bytes_transferred = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L26:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushUploadCallback r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.key);
            Status r103 = r100.status;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = Status.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.bytes_transferred;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.bytes_total;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.file_token;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.file_path;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.mount_node_point;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            UploadFailedInfo r122 = r100.failed_info;
            if (r122 == null) goto L29;
            int r123 = UploadFailedInfo.ADAPTER.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.data_version;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(9, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.mount_point;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(10, r128);
        L38:
            int r130 = r127 + r129;
            UploadExtraInfo r131 = r100.extra_info;
            if (r131 == null) goto L41;
            int r132 = UploadExtraInfo.ADAPTER.encodedSizeWithTag(11, r131);
        L42:
            int r133 = r130 + r132;
            UploadScene r134 = r100.scene;
            if (r134 == null) goto L45;
            int r135 = UploadScene.ADAPTER.encodedSizeWithTag(12, r134);
        L46:
            int r136 = r133 + r135;
            String r137 = r100.uri_str;
            if (r137 == null) goto L50;
            r104 = r101.encodedSizeWithTag(13, r137);
        L50:
            return (r136 + r104) + r100.unknownFields().size();
        L45:
            r135 = 0;
            goto L46
        L41:
            r132 = 0;
            goto L42
        L37:
            r129 = 0;
            goto L38
        L33:
            r126 = 0;
            goto L34
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
        public /* bridge */ /* synthetic */ PushUploadCallback decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushUploadCallback r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushUploadCallback r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.key);
            Status r103 = r101.status;
            if (r103 == null) goto L5;
            Status.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.bytes_transferred;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.bytes_total;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.file_token;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 5, r106);
        L14:
            String r107 = r101.file_path;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.mount_node_point;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            UploadFailedInfo r109 = r101.failed_info;
            if (r109 == null) goto L23;
            UploadFailedInfo.ADAPTER.encodeWithTag(r100, 8, r109);
        L23:
            String r110 = r101.data_version;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 9, r110);
        L26:
            String r111 = r101.mount_point;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 10, r111);
        L29:
            UploadExtraInfo r112 = r101.extra_info;
            if (r112 == null) goto L32;
            UploadExtraInfo.ADAPTER.encodeWithTag(r100, 11, r112);
        L32:
            UploadScene r113 = r101.scene;
            if (r113 == null) goto L35;
            UploadScene.ADAPTER.encodeWithTag(r100, 12, r113);
        L35:
            String r114 = r101.uri_str;
            if (r114 == null) goto L38;
            r102.encodeWithTag(r100, 13, r114);
        L38:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushUploadCallback r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status CANCEL = null;
        public static final Status FAILED = null;
        public static final Status INFLIGHT = null;
        public static final Status PENDING = null;
        public static final Status QUEUE = null;
        public static final Status READY = null;
        public static final Status SUCCESS = null;
        private final int value;

        static {
            Status r100 = new Status("PENDING", 0, 0);
            PENDING = r100;
            Status r101 = new Status("INFLIGHT", 1, 1);
            INFLIGHT = r101;
            Status r102 = new Status("FAILED", 2, 2);
            FAILED = r102;
            Status r103 = new Status("SUCCESS", 3, 3);
            SUCCESS = r103;
            Status r104 = new Status("QUEUE", 4, 4);
            QUEUE = r104;
            Status r105 = new Status("READY", 5, 5);
            READY = r105;
            Status r110 = new Status("CANCEL", 6, 6);
            CANCEL = r110;
            $VALUES = new Status[]{r100, r101, r102, r103, r104, r105, r110};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            switch(r100) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return CANCEL;
        L8:
            return READY;
        L10:
            return QUEUE;
        L12:
            return SUCCESS;
        L14:
            return FAILED;
        L16:
            return INFLIGHT;
        L18:
            return PENDING;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_PushUploadCallback r100 = new ProtoAdapter_PushUploadCallback();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATUS = Status.PENDING;
        DEFAULT_SCENE = UploadScene.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.status = this.status;
        r100.bytes_transferred = this.bytes_transferred;
        r100.bytes_total = this.bytes_total;
        r100.file_token = this.file_token;
        r100.file_path = this.file_path;
        r100.mount_node_point = this.mount_node_point;
        r100.failed_info = this.failed_info;
        r100.data_version = this.data_version;
        r100.mount_point = this.mount_point;
        r100.extra_info = this.extra_info;
        r100.scene = this.scene;
        r100.uri_str = this.uri_str;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushUploadCallback.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushUploadCallback(String r110, Status r111, String r112, String r113, String r210, String r211, String r212, UploadFailedInfo r213, String r214, String r215, UploadExtraInfo r216, UploadScene r217, String r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public PushUploadCallback(String r100, Status r101, String r102, String r103, String r104, String r105, String r106, UploadFailedInfo r107, String r110, String r111, UploadExtraInfo r112, UploadScene r113, String r114, ByteString r115) {
        super(ADAPTER, r115);
        this.key = r100;
        this.status = r101;
        this.bytes_transferred = r102;
        this.bytes_total = r103;
        this.file_token = r104;
        this.file_path = r105;
        this.mount_node_point = r106;
        this.failed_info = r107;
        this.data_version = r110;
        this.mount_point = r111;
        this.extra_info = r112;
        this.scene = r113;
        this.uri_str = r114;
    }
}
