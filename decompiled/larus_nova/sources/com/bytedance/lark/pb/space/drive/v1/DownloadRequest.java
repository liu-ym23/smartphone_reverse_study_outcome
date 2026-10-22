package com.bytedance.lark.pb.space.drive.v1;

import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class DownloadRequest extends Message<DownloadRequest, Builder> {
    public static final ProtoAdapter<DownloadRequest> ADAPTER = null;
    public static final ApiType DEFAULT_API_TYPE = null;
    public static final Boolean DEFAULT_AUTO_SUFFIX = null;
    public static final DriveBizScene DEFAULT_BIZ_SCENE = null;
    public static final String DEFAULT_DATA_VERSION = "";
    public static final Boolean DEFAULT_DISABLE_CDN_DOWNLOAD = null;
    public static final Boolean DEFAULT_DISABLE_COVER_RETRY = null;
    public static final String DEFAULT_EXTRA = "";
    public static final String DEFAULT_FILE_TOKEN = "";
    public static final String DEFAULT_LOCAL_PATH = "";
    public static final String DEFAULT_MOUNT_NODE_POINT = "";
    public static final String DEFAULT_MOUNT_POINT = "";
    public static final String DEFAULT_PREVIEW_TYPE = "";
    public static final Integer DEFAULT_PRIORITY = null;
    public static final Boolean DEFAULT_RELATIVE_PATH = null;
    public static final Boolean DEFAULT_REVERSE_ORDER = null;
    public static final DownloadScene DEFAULT_SCENE = null;
    public static final String DEFAULT_TASK_KEY = "";
    public static final String DEFAULT_UNIQUE_KEY = "";
    public static final DriveWatermarkScene DEFAULT_WATERMARK_SCENE = null;
    public static final Boolean DEFAULT_WITH_SLICE = null;
    public static final ProtoAdapter_DownloadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ApiType api_type;
    public final Boolean auto_suffix;
    public final DriveBizScene biz_scene;
    public final CoverDownloadInfo cover_info;
    public final String data_version;
    public final Boolean disable_cdn_download;
    public final Boolean disable_cover_retry;
    public final DocInfo doc_info;
    public final String extra;
    public final String file_token;
    public final String local_path;
    public final String mount_node_point;
    public final String mount_point;
    public final String preview_type;
    public final Integer priority;
    public final Boolean relative_path;
    public final Boolean reverse_order;
    public final DownloadScene scene;
    public final String task_key;
    public final Map<String, String> tea_params;
    public final String unique_key;
    public final DriveWatermarkScene watermark_scene;
    public final Boolean with_slice;

    public static final enum ApiType extends Enum<ApiType> implements WireEnum {
        private static final /* synthetic */ ApiType[] $VALUES = null;
        public static final ProtoAdapter<ApiType> ADAPTER = null;
        public static final ApiType COVER = null;
        public static final ApiType DRIVE = null;
        public static final ApiType IMG = null;
        public static final ApiType PREVIEW = null;
        public static final ApiType RANGE = null;
        private final int value;

        static {
            ApiType r100 = new ApiType("DRIVE", 0, 0);
            DRIVE = r100;
            ApiType r101 = new ApiType("COVER", 1, 1);
            COVER = r101;
            ApiType r102 = new ApiType("PREVIEW", 2, 2);
            PREVIEW = r102;
            ApiType r103 = new ApiType("IMG", 3, 3);
            IMG = r103;
            ApiType r104 = new ApiType("RANGE", 4, 4);
            RANGE = r104;
            $VALUES = new ApiType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(ApiType.class);
        }

        public static ApiType[] values() {
            return (ApiType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ApiType fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return RANGE;
        L16:
            return IMG;
        L18:
            return PREVIEW;
        L20:
            return COVER;
        L22:
            return DRIVE;
        }

        public static ApiType valueOf(String r100) {
            return (ApiType) a.a(ApiType.class, r100);
        }

        private ApiType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<DownloadRequest, Builder> implements d<DownloadRequest> {
        public ApiType api_type;
        public Boolean auto_suffix;
        public DriveBizScene biz_scene;
        public CoverDownloadInfo cover_info;
        public String data_version;
        public Boolean disable_cdn_download;
        public Boolean disable_cover_retry;
        public DocInfo doc_info;
        public String extra;
        public String file_token;
        public String local_path;
        public String mount_node_point;
        public String mount_point;
        public String preview_type;
        public Integer priority;
        public Boolean relative_path;
        public Boolean reverse_order;
        public DownloadScene scene;
        public String task_key;
        public Map<String, String> tea_params;
        public String unique_key;
        public DriveWatermarkScene watermark_scene;
        public Boolean with_slice;

        @Override // com.squareup.wire.Message.Builder
        public DownloadRequest build() {
            String r100 = this.local_path;
            if (r100 == null) goto L13;
            if (this.file_token == null) goto L13;
            if (this.mount_node_point == null) goto L13;
            if (this.mount_point == null) goto L13;
            return new DownloadRequest(this.local_path, this.file_token, this.mount_node_point, this.mount_point, this.auto_suffix, this.priority, this.data_version, this.relative_path, this.with_slice, this.api_type, this.cover_info, this.unique_key, this.scene, this.doc_info, this.disable_cdn_download, this.reverse_order, this.tea_params, this.disable_cover_retry, this.extra, this.preview_type, this.task_key, this.biz_scene, this.watermark_scene, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "local_path", this.file_token, "file_token", this.mount_node_point, "mount_node_point", this.mount_point, DrivePreviewOpenItem.EXTRA_MOUNT_POINT});
        }

        public Builder() {
            this.tea_params = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder api_type(ApiType r100) {
            this.api_type = r100;
            return this;
        }

        public Builder auto_suffix(Boolean r100) {
            this.auto_suffix = r100;
            return this;
        }

        public Builder biz_scene(DriveBizScene r100) {
            this.biz_scene = r100;
            return this;
        }

        public Builder cover_info(CoverDownloadInfo r100) {
            this.cover_info = r100;
            return this;
        }

        public Builder data_version(String r100) {
            this.data_version = r100;
            return this;
        }

        public Builder disable_cdn_download(Boolean r100) {
            this.disable_cdn_download = r100;
            return this;
        }

        public Builder disable_cover_retry(Boolean r100) {
            this.disable_cover_retry = r100;
            return this;
        }

        public Builder doc_info(DocInfo r100) {
            this.doc_info = r100;
            return this;
        }

        public Builder extra(String r100) {
            this.extra = r100;
            return this;
        }

        public Builder file_token(String r100) {
            this.file_token = r100;
            return this;
        }

        public Builder local_path(String r100) {
            this.local_path = r100;
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

        public Builder preview_type(String r100) {
            this.preview_type = r100;
            return this;
        }

        public Builder priority(Integer r100) {
            this.priority = r100;
            return this;
        }

        public Builder relative_path(Boolean r100) {
            this.relative_path = r100;
            return this;
        }

        public Builder reverse_order(Boolean r100) {
            this.reverse_order = r100;
            return this;
        }

        public Builder scene(DownloadScene r100) {
            this.scene = r100;
            return this;
        }

        public Builder task_key(String r100) {
            this.task_key = r100;
            return this;
        }

        public Builder tea_params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.tea_params = r100;
            return this;
        }

        public Builder unique_key(String r100) {
            this.unique_key = r100;
            return this;
        }

        public Builder watermark_scene(DriveWatermarkScene r100) {
            this.watermark_scene = r100;
            return this;
        }

        public Builder with_slice(Boolean r100) {
            this.with_slice = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DownloadRequest extends ProtoAdapter<DownloadRequest> implements c<DownloadRequest> {
        private final ProtoAdapter<Map<String, String>> tea_params;

        public ProtoAdapter_DownloadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DownloadRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.tea_params = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DownloadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.local_path = "";
            r101.file_token = "";
            r101.mount_node_point = "";
            r101.mount_point = "";
            Boolean r102 = Boolean.FALSE;
            r101.auto_suffix = r102;
            r101.priority = 0;
            r101.data_version = "";
            r101.relative_path = r102;
            Boolean r103 = Boolean.TRUE;
            r101.with_slice = r103;
            r101.api_type = ApiType.DRIVE;
            r101.unique_key = "";
            r101.scene = DownloadScene.unknown;
            r101.disable_cdn_download = r102;
            r101.reverse_order = r103;
            r101.disable_cover_retry = r102;
            r101.extra = "";
            r101.preview_type = "";
            r101.task_key = "";
            r101.biz_scene = DriveBizScene.DriveBizScene_UNKNOWN;
            r101.watermark_scene = DriveWatermarkScene.DriveWatermarkScene_NONE;
            long r104 = r100.beginMessage();
        L3:
            int r105 = r100.nextTag();
            if (r105 == (-1)) goto L42;
            switch(r105) {
                case 1: goto L41;
                case 2: goto L40;
                case 3: goto L39;
                case 4: goto L38;
                case 5: goto L37;
                case 6: goto L36;
                case 7: goto L35;
                case 8: goto L34;
                case 9: goto L33;
                case 10: goto L44;
                case 11: goto L28;
                case 12: goto L27;
                case 13: goto L48;
                case 14: goto L22;
                case 15: goto L21;
                case 16: goto L20;
                case 17: goto L19;
                case 18: goto L18;
                case 19: goto L17;
                case 20: goto L16;
                case 21: goto L15;
                case 22: goto L46;
                case 23: goto L50;
                default: goto L6;
            };
        L44:
            r101.api_type = ApiType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        L31:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L46:
            r101.biz_scene = DriveBizScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L48:
            r101.scene = DownloadScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L50:
            r101.watermark_scene = DriveWatermarkScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r105, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            r101.task_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.preview_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.extra = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.disable_cover_retry = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.tea_params.putAll(this.tea_params.decode(r100));
            goto L3
        L20:
            r101.reverse_order = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L21:
            r101.disable_cdn_download = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L22:
            r101.doc_info = DocInfo.ADAPTER.decode(r100);
            goto L3
        L27:
            r101.unique_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            r101.cover_info = CoverDownloadInfo.ADAPTER.decode(r100);
            goto L3
        L33:
            r101.with_slice = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L34:
            r101.relative_path = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L35:
            r101.data_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.priority = ProtoAdapter.INT32.decode(r100);
            goto L3
        L37:
            r101.auto_suffix = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L38:
            r101.mount_point = ProtoAdapter.STRING.decode(r100);
            goto L3
        L39:
            r101.mount_node_point = ProtoAdapter.STRING.decode(r100);
            goto L3
        L40:
            r101.file_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L41:
            r101.local_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r106 = r100.peekFieldEncoding();
            r101.addUnknownField(r105, r106, r106.rawProtoAdapter().decode(r100));
            goto L3
        L42:
            r100.endMessage(r104);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DownloadRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.encodedSizeWithTag(1, r100.local_path) + r101.encodedSizeWithTag(2, r100.file_token)) + r101.encodedSizeWithTag(3, r100.mount_node_point)) + r101.encodedSizeWithTag(4, r100.mount_point);
            Boolean r103 = r100.auto_suffix;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r103);
        L6:
            int r106 = r102 + r105;
            Integer r107 = r100.priority;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(6, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.data_version;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(7, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.relative_path;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.with_slice;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r116);
        L22:
            int r118 = r115 + r117;
            ApiType r119 = r100.api_type;
            if (r119 == null) goto L25;
            int r120 = ApiType.ADAPTER.encodedSizeWithTag(10, r119);
        L26:
            int r121 = r118 + r120;
            CoverDownloadInfo r122 = r100.cover_info;
            if (r122 == null) goto L29;
            int r123 = CoverDownloadInfo.ADAPTER.encodedSizeWithTag(11, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.unique_key;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(12, r125);
        L34:
            int r127 = r124 + r126;
            DownloadScene r128 = r100.scene;
            if (r128 == null) goto L37;
            int r129 = DownloadScene.ADAPTER.encodedSizeWithTag(13, r128);
        L38:
            int r130 = r127 + r129;
            DocInfo r131 = r100.doc_info;
            if (r131 == null) goto L41;
            int r132 = DocInfo.ADAPTER.encodedSizeWithTag(14, r131);
        L42:
            int r133 = r130 + r132;
            Boolean r134 = r100.disable_cdn_download;
            if (r134 == null) goto L45;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r134);
        L46:
            int r136 = r133 + r135;
            Boolean r137 = r100.reverse_order;
            if (r137 == null) goto L49;
            int r138 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r137);
        L50:
            int r139 = (r136 + r138) + this.tea_params.encodedSizeWithTag(17, r100.tea_params);
            Boolean r140 = r100.disable_cover_retry;
            if (r140 == null) goto L53;
            int r141 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r140);
        L54:
            int r142 = r139 + r141;
            String r143 = r100.extra;
            if (r143 == null) goto L57;
            int r144 = r101.encodedSizeWithTag(19, r143);
        L58:
            int r145 = r142 + r144;
            String r146 = r100.preview_type;
            if (r146 == null) goto L61;
            int r147 = r101.encodedSizeWithTag(20, r146);
        L62:
            int r148 = r145 + r147;
            String r149 = r100.task_key;
            if (r149 == null) goto L65;
            int r150 = r101.encodedSizeWithTag(21, r149);
        L66:
            int r151 = r148 + r150;
            DriveBizScene r152 = r100.biz_scene;
            if (r152 == null) goto L69;
            int r153 = DriveBizScene.ADAPTER.encodedSizeWithTag(22, r152);
        L70:
            int r154 = r151 + r153;
            DriveWatermarkScene r155 = r100.watermark_scene;
            if (r155 == null) goto L74;
            r104 = DriveWatermarkScene.ADAPTER.encodedSizeWithTag(23, r155);
        L74:
            return (r154 + r104) + r100.unknownFields().size();
        L69:
            r153 = 0;
            goto L70
        L65:
            r150 = 0;
            goto L66
        L61:
            r147 = 0;
            goto L62
        L57:
            r144 = 0;
            goto L58
        L53:
            r141 = 0;
            goto L54
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
        public /* bridge */ /* synthetic */ DownloadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DownloadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DownloadRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.local_path);
            r102.encodeWithTag(r100, 2, r101.file_token);
            r102.encodeWithTag(r100, 3, r101.mount_node_point);
            r102.encodeWithTag(r100, 4, r101.mount_point);
            Boolean r103 = r101.auto_suffix;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r103);
        L5:
            Integer r104 = r101.priority;
            if (r104 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r104);
        L8:
            String r105 = r101.data_version;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 7, r105);
        L11:
            Boolean r106 = r101.relative_path;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r106);
        L14:
            Boolean r107 = r101.with_slice;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r107);
        L17:
            ApiType r108 = r101.api_type;
            if (r108 == null) goto L20;
            ApiType.ADAPTER.encodeWithTag(r100, 10, r108);
        L20:
            CoverDownloadInfo r109 = r101.cover_info;
            if (r109 == null) goto L23;
            CoverDownloadInfo.ADAPTER.encodeWithTag(r100, 11, r109);
        L23:
            String r110 = r101.unique_key;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 12, r110);
        L26:
            DownloadScene r111 = r101.scene;
            if (r111 == null) goto L29;
            DownloadScene.ADAPTER.encodeWithTag(r100, 13, r111);
        L29:
            DocInfo r112 = r101.doc_info;
            if (r112 == null) goto L32;
            DocInfo.ADAPTER.encodeWithTag(r100, 14, r112);
        L32:
            Boolean r113 = r101.disable_cdn_download;
            if (r113 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 15, r113);
        L35:
            Boolean r114 = r101.reverse_order;
            if (r114 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 16, r114);
        L38:
            this.tea_params.encodeWithTag(r100, 17, r101.tea_params);
            Boolean r115 = r101.disable_cover_retry;
            if (r115 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 18, r115);
        L41:
            String r116 = r101.extra;
            if (r116 == null) goto L44;
            r102.encodeWithTag(r100, 19, r116);
        L44:
            String r117 = r101.preview_type;
            if (r117 == null) goto L47;
            r102.encodeWithTag(r100, 20, r117);
        L47:
            String r118 = r101.task_key;
            if (r118 == null) goto L50;
            r102.encodeWithTag(r100, 21, r118);
        L50:
            DriveBizScene r119 = r101.biz_scene;
            if (r119 == null) goto L53;
            DriveBizScene.ADAPTER.encodeWithTag(r100, 22, r119);
        L53:
            DriveWatermarkScene r120 = r101.watermark_scene;
            if (r120 == null) goto L56;
            DriveWatermarkScene.ADAPTER.encodeWithTag(r100, 23, r120);
        L56:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DownloadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DownloadRequest r100 = new ProtoAdapter_DownloadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_AUTO_SUFFIX = r101;
        DEFAULT_PRIORITY = 0;
        DEFAULT_RELATIVE_PATH = r101;
        Boolean r102 = Boolean.TRUE;
        DEFAULT_WITH_SLICE = r102;
        DEFAULT_API_TYPE = ApiType.DRIVE;
        DEFAULT_SCENE = DownloadScene.unknown;
        DEFAULT_DISABLE_CDN_DOWNLOAD = r101;
        DEFAULT_REVERSE_ORDER = r102;
        DEFAULT_DISABLE_COVER_RETRY = r101;
        DEFAULT_BIZ_SCENE = DriveBizScene.DriveBizScene_UNKNOWN;
        DEFAULT_WATERMARK_SCENE = DriveWatermarkScene.DriveWatermarkScene_NONE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.local_path = this.local_path;
        r100.file_token = this.file_token;
        r100.mount_node_point = this.mount_node_point;
        r100.mount_point = this.mount_point;
        r100.auto_suffix = this.auto_suffix;
        r100.priority = this.priority;
        r100.data_version = this.data_version;
        r100.relative_path = this.relative_path;
        r100.with_slice = this.with_slice;
        r100.api_type = this.api_type;
        r100.cover_info = this.cover_info;
        r100.unique_key = this.unique_key;
        r100.scene = this.scene;
        r100.doc_info = this.doc_info;
        r100.disable_cdn_download = this.disable_cdn_download;
        r100.reverse_order = this.reverse_order;
        r100.tea_params = Internal.copyOf("tea_params", this.tea_params);
        r100.disable_cover_retry = this.disable_cover_retry;
        r100.extra = this.extra;
        r100.preview_type = this.preview_type;
        r100.task_key = this.task_key;
        r100.biz_scene = this.biz_scene;
        r100.watermark_scene = this.watermark_scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DownloadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DownloadRequest(String r210, String r211, String r212, String r213, Boolean r310, Integer r311, String r312, Boolean r313, Boolean r314, ApiType r315, CoverDownloadInfo r316, String r317, DownloadScene r318, DocInfo r319, Boolean r410, Boolean r411, Map<String, String> r412, Boolean r413, String r414, String r415, String r416, DriveBizScene r417, DriveWatermarkScene r418) {
        this(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, ByteString.EMPTY);
    }

    public DownloadRequest(String r100, String r101, String r102, String r103, Boolean r104, Integer r105, String r110, Boolean r111, Boolean r112, ApiType r113, CoverDownloadInfo r114, String r115, DownloadScene r116, DocInfo r117, Boolean r118, Boolean r119, Map<String, String> r210, Boolean r211, String r212, String r213, String r214, DriveBizScene r215, DriveWatermarkScene r216, ByteString r217) {
        super(ADAPTER, r217);
        this.local_path = r100;
        this.file_token = r101;
        this.mount_node_point = r102;
        this.mount_point = r103;
        this.auto_suffix = r104;
        this.priority = r105;
        this.data_version = r110;
        this.relative_path = r111;
        this.with_slice = r112;
        this.api_type = r113;
        this.cover_info = r114;
        this.unique_key = r115;
        this.scene = r116;
        this.doc_info = r117;
        this.disable_cdn_download = r118;
        this.reverse_order = r119;
        this.tea_params = Internal.immutableCopyOf("tea_params", r210);
        this.disable_cover_retry = r211;
        this.extra = r212;
        this.preview_type = r213;
        this.task_key = r214;
        this.biz_scene = r215;
        this.watermark_scene = r216;
    }
}
