package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushDownloadCallback extends Message<PushDownloadCallback, Builder> {
    public static final ProtoAdapter<PushDownloadCallback> ADAPTER = null;
    public static final String DEFAULT_BYTES_TOTAL = "";
    public static final String DEFAULT_BYTES_TRANSFERRED = "";
    public static final String DEFAULT_DATA_VERSION = "";
    public static final String DEFAULT_FILE_NAME = "";
    public static final String DEFAULT_FILE_PATH = "";
    public static final String DEFAULT_FILE_TOKEN = "";
    public static final String DEFAULT_FILE_TYPE = "";
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_MIME_TYPE = "";
    public static final String DEFAULT_MOUNT_NODE_POINT = "";
    public static final String DEFAULT_MOUNT_POINT = "";
    public static final DownloadScene DEFAULT_SCENE = null;
    public static final Status DEFAULT_STATUS = null;
    public static final ProtoAdapter_PushDownloadCallback RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String bytes_total;
    public final String bytes_transferred;
    public final String data_version;
    public final List<DownloadRange> downloaded_ranges;
    public final DownloadFailedInfo failed_info;
    public final String file_name;
    public final String file_path;
    public final String file_token;
    public final String file_type;
    public final String key;
    public final String mime_type;
    public final String mount_node_point;
    public final String mount_point;
    public final DownloadScene scene;
    public final Status status;

    public static final class Builder extends Message.Builder<PushDownloadCallback, Builder> implements d<PushDownloadCallback> {
        public String bytes_total;
        public String bytes_transferred;
        public String data_version;
        public List<DownloadRange> downloaded_ranges;
        public DownloadFailedInfo failed_info;
        public String file_name;
        public String file_path;
        public String file_token;
        public String file_type;
        public String key;
        public String mime_type;
        public String mount_node_point;
        public String mount_point;
        public DownloadScene scene;
        public Status status;

        @Override // com.squareup.wire.Message.Builder
        public PushDownloadCallback build() {
            String r100 = this.key;
            if (r100 == null) goto L7;
            return new PushDownloadCallback(this.key, this.status, this.bytes_transferred, this.bytes_total, this.failed_info, this.file_name, this.file_type, this.file_path, this.data_version, this.mount_node_point, this.mount_point, this.mime_type, this.scene, this.downloaded_ranges, this.file_token, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "key"});
        }

        public Builder() {
            this.downloaded_ranges = Internal.newMutableList();
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

        public Builder downloaded_ranges(List<DownloadRange> r100) {
            Internal.checkElementsNotNull(r100);
            this.downloaded_ranges = r100;
            return this;
        }

        public Builder failed_info(DownloadFailedInfo r100) {
            this.failed_info = r100;
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

        public Builder file_token(String r100) {
            this.file_token = r100;
            return this;
        }

        public Builder file_type(String r100) {
            this.file_type = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder mime_type(String r100) {
            this.mime_type = r100;
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

        public Builder scene(DownloadScene r100) {
            this.scene = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushDownloadCallback extends ProtoAdapter<PushDownloadCallback> implements c<PushDownloadCallback> {
        public ProtoAdapter_PushDownloadCallback() {
            super(FieldEncoding.LENGTH_DELIMITED, PushDownloadCallback.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushDownloadCallback decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.status = Status.PENDING;
            r101.bytes_transferred = "";
            r101.bytes_total = "";
            r101.file_name = "";
            r101.file_type = "";
            r101.file_path = "";
            r101.data_version = "";
            r101.mount_node_point = "";
            r101.mount_point = "";
            r101.mime_type = "";
            r101.scene = DownloadScene.unknown;
            r101.file_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L28;
            switch(r103) {
                case 1: goto L27;
                case 2: goto L32;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L17;
                case 9: goto L16;
                case 10: goto L15;
                case 11: goto L14;
                case 12: goto L13;
                case 13: goto L30;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L30:
            r101.scene = DownloadScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L32:
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.file_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.downloaded_ranges.add(DownloadRange.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.mime_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mount_point = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mount_node_point = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.data_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.file_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.file_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.file_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.failed_info = DownloadFailedInfo.ADAPTER.decode(r100);
            goto L3
        L21:
            r101.bytes_total = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.bytes_transferred = ProtoAdapter.STRING.decode(r100);
            goto L3
        L27:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L28:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushDownloadCallback r100) {
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
            DownloadFailedInfo r113 = r100.failed_info;
            if (r113 == null) goto L17;
            int r114 = DownloadFailedInfo.ADAPTER.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.file_name;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.file_type;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            String r122 = r100.file_path;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.data_version;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(9, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.mount_node_point;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(10, r128);
        L38:
            int r130 = r127 + r129;
            String r131 = r100.mount_point;
            if (r131 == null) goto L41;
            int r132 = r101.encodedSizeWithTag(11, r131);
        L42:
            int r133 = r130 + r132;
            String r134 = r100.mime_type;
            if (r134 == null) goto L45;
            int r135 = r101.encodedSizeWithTag(12, r134);
        L46:
            int r136 = r133 + r135;
            DownloadScene r137 = r100.scene;
            if (r137 == null) goto L49;
            int r138 = DownloadScene.ADAPTER.encodedSizeWithTag(13, r137);
        L50:
            int r139 = (r136 + r138) + DownloadRange.ADAPTER.asRepeated().encodedSizeWithTag(14, r100.downloaded_ranges);
            String r140 = r100.file_token;
            if (r140 == null) goto L54;
            r104 = r101.encodedSizeWithTag(15, r140);
        L54:
            return (r139 + r104) + r100.unknownFields().size();
        L49:
            r138 = 0;
            goto L50
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
        public /* bridge */ /* synthetic */ PushDownloadCallback decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushDownloadCallback r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushDownloadCallback r101) throws IOException {
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
            DownloadFailedInfo r106 = r101.failed_info;
            if (r106 == null) goto L14;
            DownloadFailedInfo.ADAPTER.encodeWithTag(r100, 5, r106);
        L14:
            String r107 = r101.file_name;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.file_type;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            String r109 = r101.file_path;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 8, r109);
        L23:
            String r110 = r101.data_version;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 9, r110);
        L26:
            String r111 = r101.mount_node_point;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 10, r111);
        L29:
            String r112 = r101.mount_point;
            if (r112 == null) goto L32;
            r102.encodeWithTag(r100, 11, r112);
        L32:
            String r113 = r101.mime_type;
            if (r113 == null) goto L35;
            r102.encodeWithTag(r100, 12, r113);
        L35:
            DownloadScene r114 = r101.scene;
            if (r114 == null) goto L38;
            DownloadScene.ADAPTER.encodeWithTag(r100, 13, r114);
        L38:
            DownloadRange.ADAPTER.asRepeated().encodeWithTag(r100, 14, r101.downloaded_ranges);
            String r115 = r101.file_token;
            if (r115 == null) goto L41;
            r102.encodeWithTag(r100, 15, r115);
        L41:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushDownloadCallback r101) throws IOException {
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
        public static final Status RANGE_FINISH = null;
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
            Status r111 = new Status("RANGE_FINISH", 7, 7);
            RANGE_FINISH = r111;
            $VALUES = new Status[]{r100, r101, r102, r103, r104, r105, r110, r111};
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
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return RANGE_FINISH;
        L8:
            return CANCEL;
        L10:
            return READY;
        L12:
            return QUEUE;
        L14:
            return SUCCESS;
        L16:
            return FAILED;
        L18:
            return INFLIGHT;
        L20:
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
        ProtoAdapter_PushDownloadCallback r100 = new ProtoAdapter_PushDownloadCallback();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATUS = Status.PENDING;
        DEFAULT_SCENE = DownloadScene.unknown;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.status = this.status;
        r100.bytes_transferred = this.bytes_transferred;
        r100.bytes_total = this.bytes_total;
        r100.failed_info = this.failed_info;
        r100.file_name = this.file_name;
        r100.file_type = this.file_type;
        r100.file_path = this.file_path;
        r100.data_version = this.data_version;
        r100.mount_node_point = this.mount_node_point;
        r100.mount_point = this.mount_point;
        r100.mime_type = this.mime_type;
        r100.scene = this.scene;
        r100.downloaded_ranges = Internal.copyOf("downloaded_ranges", this.downloaded_ranges);
        r100.file_token = this.file_token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushDownloadCallback.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushDownloadCallback(String r110, Status r111, String r210, String r211, DownloadFailedInfo r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, DownloadScene r310, List<DownloadRange> r311, String r312) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
    }

    public PushDownloadCallback(String r100, Status r101, String r102, String r103, DownloadFailedInfo r104, String r105, String r110, String r111, String r112, String r113, String r114, String r115, DownloadScene r116, List<DownloadRange> r117, String r118, ByteString r119) {
        super(ADAPTER, r119);
        this.key = r100;
        this.status = r101;
        this.bytes_transferred = r102;
        this.bytes_total = r103;
        this.failed_info = r104;
        this.file_name = r105;
        this.file_type = r110;
        this.file_path = r111;
        this.data_version = r112;
        this.mount_node_point = r113;
        this.mount_point = r114;
        this.mime_type = r115;
        this.scene = r116;
        this.downloaded_ranges = Internal.immutableCopyOf("downloaded_ranges", r117);
        this.file_token = r118;
    }
}
