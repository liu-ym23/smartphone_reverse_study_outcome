package com.bytedance.lark.pb.space.drive.v1;

import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UploadRequest extends Message<UploadRequest, Builder> {
    public static final ProtoAdapter<UploadRequest> ADAPTER = null;
    public static final ApiType DEFAULT_API_TYPE = null;
    public static final String DEFAULT_BASE_VERSION = "";
    public static final Integer DEFAULT_CHANGE_HISTORY = null;
    public static final String DEFAULT_CONTENT_VERSION = "";
    public static final ByteString DEFAULT_FILE_BODY = null;
    public static final String DEFAULT_FILE_NAME = "";
    public static final String DEFAULT_FILE_TOKEN = "";
    public static final String DEFAULT_LOCAL_PATH = "";
    public static final String DEFAULT_MOUNT_NODE_POINT = "";
    public static final String DEFAULT_MOUNT_POINT = "";
    public static final Integer DEFAULT_OBJ_TYPE = null;
    public static final Integer DEFAULT_PRIORITY = null;
    public static final Boolean DEFAULT_RELATIVE_PATH = null;
    public static final String DEFAULT_REQUEST_ID = "";
    public static final UploadScene DEFAULT_SCENE = null;
    public static final String DEFAULT_TREE_ID = "";
    public static final String DEFAULT_TREE_VERSION = "";
    public static final String DEFAULT_UNIQUE_KEY = "";
    public static final String DEFAULT_UPLOAD_CODE = "";
    public static final String DEFAULT_URI_STR = "";
    public static final Boolean DEFAULT_USE_PATH_NAME_FOR_HISTORY = null;
    public static final Boolean DEFAULT_WITH_PARALLEL = null;
    public static final Boolean DEFAULT_WITH_SLICE = null;
    public static final ProtoAdapter_UploadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ApiType api_type;
    public final String base_version;
    public final Integer change_history;
    public final String content_version;
    public final Map<String, String> ext_rust;
    public final Map<String, String> extra_headers;
    public final Map<String, String> extra_params;
    public final ByteString file_body;
    public final String file_name;
    public final String file_token;
    public final String local_path;
    public final String mount_node_point;
    public final String mount_point;
    public final Integer obj_type;
    public final Integer priority;
    public final Boolean relative_path;
    public final String request_id;
    public final UploadScene scene;
    public final String tree_id;
    public final String tree_version;
    public final String unique_key;
    public final String upload_code;
    public final String uri_str;
    public final Boolean use_path_name_for_history;
    public final Boolean with_parallel;
    public final Boolean with_slice;

    public static final enum ApiType extends Enum<ApiType> implements WireEnum {
        private static final /* synthetic */ ApiType[] $VALUES = null;
        public static final ProtoAdapter<ApiType> ADAPTER = null;
        public static final ApiType DRIVE = null;
        public static final ApiType IMG = null;
        private final int value;

        static {
            ApiType r100 = new ApiType("DRIVE", 0, 0);
            DRIVE = r100;
            ApiType r101 = new ApiType("IMG", 1, 1);
            IMG = r101;
            $VALUES = new ApiType[]{r100, r101};
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
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return IMG;
        L10:
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

    public static final class Builder extends Message.Builder<UploadRequest, Builder> implements d<UploadRequest> {
        public ApiType api_type;
        public String base_version;
        public Integer change_history;
        public String content_version;
        public Map<String, String> ext_rust;
        public Map<String, String> extra_headers;
        public Map<String, String> extra_params;
        public ByteString file_body;
        public String file_name;
        public String file_token;
        public String local_path;
        public String mount_node_point;
        public String mount_point;
        public Integer obj_type;
        public Integer priority;
        public Boolean relative_path;
        public String request_id;
        public UploadScene scene;
        public String tree_id;
        public String tree_version;
        public String unique_key;
        public String upload_code;
        public String uri_str;
        public Boolean use_path_name_for_history;
        public Boolean with_parallel;
        public Boolean with_slice;

        @Override // com.squareup.wire.Message.Builder
        public UploadRequest build() {
            String r100 = this.local_path;
            if (r100 == null) goto L13;
            if (this.file_name == null) goto L13;
            if (this.mount_node_point == null) goto L13;
            if (this.mount_point == null) goto L13;
            return new UploadRequest(this.local_path, this.file_name, this.mount_node_point, this.mount_point, this.file_token, this.relative_path, this.base_version, this.obj_type, this.api_type, this.priority, this.tree_version, this.content_version, this.with_slice, this.change_history, this.tree_id, this.request_id, this.scene, this.unique_key, this.use_path_name_for_history, this.file_body, this.extra_params, this.extra_headers, this.ext_rust, this.uri_str, this.with_parallel, this.upload_code, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "local_path", this.file_name, "file_name", this.mount_node_point, "mount_node_point", this.mount_point, DrivePreviewOpenItem.EXTRA_MOUNT_POINT});
        }

        public Builder() {
            this.extra_params = Internal.newMutableMap();
            this.extra_headers = Internal.newMutableMap();
            this.ext_rust = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder api_type(ApiType r100) {
            this.api_type = r100;
            return this;
        }

        public Builder base_version(String r100) {
            this.base_version = r100;
            return this;
        }

        public Builder change_history(Integer r100) {
            this.change_history = r100;
            return this;
        }

        public Builder content_version(String r100) {
            this.content_version = r100;
            return this;
        }

        public Builder ext_rust(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.ext_rust = r100;
            return this;
        }

        public Builder extra_headers(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extra_headers = r100;
            return this;
        }

        public Builder extra_params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.extra_params = r100;
            return this;
        }

        public Builder file_body(ByteString r100) {
            this.file_body = r100;
            return this;
        }

        public Builder file_name(String r100) {
            this.file_name = r100;
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

        public Builder obj_type(Integer r100) {
            this.obj_type = r100;
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

        public Builder request_id(String r100) {
            this.request_id = r100;
            return this;
        }

        public Builder scene(UploadScene r100) {
            this.scene = r100;
            return this;
        }

        public Builder tree_id(String r100) {
            this.tree_id = r100;
            return this;
        }

        public Builder tree_version(String r100) {
            this.tree_version = r100;
            return this;
        }

        public Builder unique_key(String r100) {
            this.unique_key = r100;
            return this;
        }

        public Builder upload_code(String r100) {
            this.upload_code = r100;
            return this;
        }

        public Builder uri_str(String r100) {
            this.uri_str = r100;
            return this;
        }

        public Builder use_path_name_for_history(Boolean r100) {
            this.use_path_name_for_history = r100;
            return this;
        }

        public Builder with_parallel(Boolean r100) {
            this.with_parallel = r100;
            return this;
        }

        public Builder with_slice(Boolean r100) {
            this.with_slice = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UploadRequest extends ProtoAdapter<UploadRequest> implements c<UploadRequest> {
        private final ProtoAdapter<Map<String, String>> ext_rust;
        private final ProtoAdapter<Map<String, String>> extra_headers;
        private final ProtoAdapter<Map<String, String>> extra_params;

        public ProtoAdapter_UploadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.extra_params = ProtoAdapter.newMapAdapter(r100, r100);
            this.extra_headers = ProtoAdapter.newMapAdapter(r100, r100);
            this.ext_rust = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.local_path = "";
            r101.file_name = "";
            r101.mount_node_point = "";
            r101.mount_point = "";
            r101.file_token = "";
            Boolean r102 = Boolean.FALSE;
            r101.relative_path = r102;
            r101.base_version = "";
            r101.obj_type = 2;
            r101.api_type = ApiType.DRIVE;
            r101.priority = 0;
            r101.tree_version = "";
            r101.content_version = "";
            r101.with_slice = Boolean.TRUE;
            r101.change_history = 1;
            r101.tree_id = "";
            r101.request_id = "";
            r101.scene = UploadScene.UNKNOWN;
            r101.unique_key = "";
            r101.use_path_name_for_history = r102;
            r101.file_body = ByteString.EMPTY;
            r101.uri_str = "";
            r101.with_parallel = r102;
            r101.upload_code = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L39;
            switch(r104) {
                case 1: goto L38;
                case 2: goto L37;
                case 3: goto L36;
                case 4: goto L35;
                case 5: goto L34;
                case 6: goto L33;
                case 7: goto L32;
                case 8: goto L31;
                case 9: goto L43;
                case 10: goto L26;
                case 11: goto L25;
                case 12: goto L24;
                case 13: goto L23;
                case 14: goto L22;
                case 15: goto L21;
                case 16: goto L20;
                case 17: goto L41;
                case 18: goto L15;
                case 19: goto L14;
                case 20: goto L13;
                case 21: goto L12;
                case 22: goto L11;
                case 23: goto L10;
                case 24: goto L9;
                case 25: goto L8;
                case 26: goto L7;
                default: goto L6;
            };
        L41:
            r101.scene = UploadScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L43:
            r101.api_type = ApiType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.upload_code = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.with_parallel = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.uri_str = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.ext_rust.putAll(this.ext_rust.decode(r100));
            goto L3
        L11:
            r101.extra_headers.putAll(this.extra_headers.decode(r100));
            goto L3
        L12:
            r101.extra_params.putAll(this.extra_params.decode(r100));
            goto L3
        L13:
            r101.file_body = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L14:
            r101.use_path_name_for_history = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.unique_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.request_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.tree_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.change_history = ProtoAdapter.INT32.decode(r100);
            goto L3
        L23:
            r101.with_slice = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.content_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.tree_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            r101.priority = ProtoAdapter.INT32.decode(r100);
            goto L3
        L31:
            r101.obj_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L32:
            r101.base_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L33:
            r101.relative_path = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L34:
            r101.file_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L35:
            r101.mount_point = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.mount_node_point = ProtoAdapter.STRING.decode(r100);
            goto L3
        L37:
            r101.file_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L38:
            r101.local_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L39:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UploadRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.encodedSizeWithTag(1, r100.local_path) + r101.encodedSizeWithTag(2, r100.file_name)) + r101.encodedSizeWithTag(3, r100.mount_node_point)) + r101.encodedSizeWithTag(4, r100.mount_point);
            String r103 = r100.file_token;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(5, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.relative_path;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.base_version;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(7, r110);
        L14:
            int r112 = r109 + r111;
            Integer r113 = r100.obj_type;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(8, r113);
        L18:
            int r115 = r112 + r114;
            ApiType r116 = r100.api_type;
            if (r116 == null) goto L21;
            int r117 = ApiType.ADAPTER.encodedSizeWithTag(9, r116);
        L22:
            int r118 = r115 + r117;
            Integer r119 = r100.priority;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.INT32.encodedSizeWithTag(10, r119);
        L26:
            int r121 = r118 + r120;
            String r122 = r100.tree_version;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(11, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.content_version;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(12, r125);
        L34:
            int r127 = r124 + r126;
            Boolean r128 = r100.with_slice;
            if (r128 == null) goto L37;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r128);
        L38:
            int r130 = r127 + r129;
            Integer r131 = r100.change_history;
            if (r131 == null) goto L41;
            int r132 = ProtoAdapter.INT32.encodedSizeWithTag(14, r131);
        L42:
            int r133 = r130 + r132;
            String r134 = r100.tree_id;
            if (r134 == null) goto L45;
            int r135 = r101.encodedSizeWithTag(15, r134);
        L46:
            int r136 = r133 + r135;
            String r137 = r100.request_id;
            if (r137 == null) goto L49;
            int r138 = r101.encodedSizeWithTag(16, r137);
        L50:
            int r139 = r136 + r138;
            UploadScene r140 = r100.scene;
            if (r140 == null) goto L53;
            int r141 = UploadScene.ADAPTER.encodedSizeWithTag(17, r140);
        L54:
            int r142 = r139 + r141;
            String r143 = r100.unique_key;
            if (r143 == null) goto L57;
            int r144 = r101.encodedSizeWithTag(18, r143);
        L58:
            int r145 = r142 + r144;
            Boolean r146 = r100.use_path_name_for_history;
            if (r146 == null) goto L61;
            int r147 = ProtoAdapter.BOOL.encodedSizeWithTag(19, r146);
        L62:
            int r148 = r145 + r147;
            ByteString r149 = r100.file_body;
            if (r149 == null) goto L65;
            int r150 = ProtoAdapter.BYTES.encodedSizeWithTag(20, r149);
        L66:
            int r151 = (((r148 + r150) + this.extra_params.encodedSizeWithTag(21, r100.extra_params)) + this.extra_headers.encodedSizeWithTag(22, r100.extra_headers)) + this.ext_rust.encodedSizeWithTag(23, r100.ext_rust);
            String r152 = r100.uri_str;
            if (r152 == null) goto L69;
            int r153 = r101.encodedSizeWithTag(24, r152);
        L70:
            int r154 = r151 + r153;
            Boolean r155 = r100.with_parallel;
            if (r155 == null) goto L73;
            int r156 = ProtoAdapter.BOOL.encodedSizeWithTag(25, r155);
        L74:
            int r157 = r154 + r156;
            String r158 = r100.upload_code;
            if (r158 == null) goto L78;
            r104 = r101.encodedSizeWithTag(26, r158);
        L78:
            return (r157 + r104) + r100.unknownFields().size();
        L73:
            r156 = 0;
            goto L74
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
        public /* bridge */ /* synthetic */ UploadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.local_path);
            r102.encodeWithTag(r100, 2, r101.file_name);
            r102.encodeWithTag(r100, 3, r101.mount_node_point);
            r102.encodeWithTag(r100, 4, r101.mount_point);
            String r103 = r101.file_token;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 5, r103);
        L5:
            Boolean r104 = r101.relative_path;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r104);
        L8:
            String r105 = r101.base_version;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 7, r105);
        L11:
            Integer r106 = r101.obj_type;
            if (r106 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r106);
        L14:
            ApiType r107 = r101.api_type;
            if (r107 == null) goto L17;
            ApiType.ADAPTER.encodeWithTag(r100, 9, r107);
        L17:
            Integer r108 = r101.priority;
            if (r108 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 10, r108);
        L20:
            String r109 = r101.tree_version;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 11, r109);
        L23:
            String r110 = r101.content_version;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 12, r110);
        L26:
            Boolean r111 = r101.with_slice;
            if (r111 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 13, r111);
        L29:
            Integer r112 = r101.change_history;
            if (r112 == null) goto L32;
            ProtoAdapter.INT32.encodeWithTag(r100, 14, r112);
        L32:
            String r113 = r101.tree_id;
            if (r113 == null) goto L35;
            r102.encodeWithTag(r100, 15, r113);
        L35:
            String r114 = r101.request_id;
            if (r114 == null) goto L38;
            r102.encodeWithTag(r100, 16, r114);
        L38:
            UploadScene r115 = r101.scene;
            if (r115 == null) goto L41;
            UploadScene.ADAPTER.encodeWithTag(r100, 17, r115);
        L41:
            String r116 = r101.unique_key;
            if (r116 == null) goto L44;
            r102.encodeWithTag(r100, 18, r116);
        L44:
            Boolean r117 = r101.use_path_name_for_history;
            if (r117 == null) goto L47;
            ProtoAdapter.BOOL.encodeWithTag(r100, 19, r117);
        L47:
            ByteString r118 = r101.file_body;
            if (r118 == null) goto L50;
            ProtoAdapter.BYTES.encodeWithTag(r100, 20, r118);
        L50:
            this.extra_params.encodeWithTag(r100, 21, r101.extra_params);
            this.extra_headers.encodeWithTag(r100, 22, r101.extra_headers);
            this.ext_rust.encodeWithTag(r100, 23, r101.ext_rust);
            String r119 = r101.uri_str;
            if (r119 == null) goto L53;
            r102.encodeWithTag(r100, 24, r119);
        L53:
            Boolean r120 = r101.with_parallel;
            if (r120 == null) goto L56;
            ProtoAdapter.BOOL.encodeWithTag(r100, 25, r120);
        L56:
            String r121 = r101.upload_code;
            if (r121 == null) goto L59;
            r102.encodeWithTag(r100, 26, r121);
        L59:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UploadRequest r100 = new ProtoAdapter_UploadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_RELATIVE_PATH = r101;
        DEFAULT_OBJ_TYPE = 2;
        DEFAULT_API_TYPE = ApiType.DRIVE;
        DEFAULT_PRIORITY = 0;
        DEFAULT_WITH_SLICE = Boolean.TRUE;
        DEFAULT_CHANGE_HISTORY = 1;
        DEFAULT_SCENE = UploadScene.UNKNOWN;
        DEFAULT_USE_PATH_NAME_FOR_HISTORY = r101;
        DEFAULT_FILE_BODY = ByteString.EMPTY;
        DEFAULT_WITH_PARALLEL = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.local_path = this.local_path;
        r100.file_name = this.file_name;
        r100.mount_node_point = this.mount_node_point;
        r100.mount_point = this.mount_point;
        r100.file_token = this.file_token;
        r100.relative_path = this.relative_path;
        r100.base_version = this.base_version;
        r100.obj_type = this.obj_type;
        r100.api_type = this.api_type;
        r100.priority = this.priority;
        r100.tree_version = this.tree_version;
        r100.content_version = this.content_version;
        r100.with_slice = this.with_slice;
        r100.change_history = this.change_history;
        r100.tree_id = this.tree_id;
        r100.request_id = this.request_id;
        r100.scene = this.scene;
        r100.unique_key = this.unique_key;
        r100.use_path_name_for_history = this.use_path_name_for_history;
        r100.file_body = this.file_body;
        r100.extra_params = Internal.copyOf("extra_params", this.extra_params);
        r100.extra_headers = Internal.copyOf(DownloadSettingKeys.DownloadTaskParam.EXTRA_HEADERS, this.extra_headers);
        r100.ext_rust = Internal.copyOf("ext_rust", this.ext_rust);
        r100.uri_str = this.uri_str;
        r100.with_parallel = this.with_parallel;
        r100.upload_code = this.upload_code;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadRequest(String r210, String r310, String r311, String r312, String r313, Boolean r314, String r315, Integer r316, ApiType r317, Integer r318, String r319, String r410, Boolean r411, Integer r412, String r413, String r414, UploadScene r415, String r416, Boolean r417, ByteString r418, Map<String, String> r419, Map<String, String> r510, Map<String, String> r511, String r512, Boolean r513, String r514) {
        this(r210, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, ByteString.EMPTY);
    }

    public UploadRequest(String r100, String r101, String r102, String r103, String r104, Boolean r105, String r110, Integer r111, ApiType r112, Integer r113, String r114, String r115, Boolean r116, Integer r117, String r118, String r119, UploadScene r210, String r211, Boolean r212, ByteString r213, Map<String, String> r214, Map<String, String> r215, Map<String, String> r216, String r217, Boolean r218, String r219, ByteString r310) {
        super(ADAPTER, r310);
        this.local_path = r100;
        this.file_name = r101;
        this.mount_node_point = r102;
        this.mount_point = r103;
        this.file_token = r104;
        this.relative_path = r105;
        this.base_version = r110;
        this.obj_type = r111;
        this.api_type = r112;
        this.priority = r113;
        this.tree_version = r114;
        this.content_version = r115;
        this.with_slice = r116;
        this.change_history = r117;
        this.tree_id = r118;
        this.request_id = r119;
        this.scene = r210;
        this.unique_key = r211;
        this.use_path_name_for_history = r212;
        this.file_body = r213;
        this.extra_params = Internal.immutableCopyOf("extra_params", r214);
        this.extra_headers = Internal.immutableCopyOf(DownloadSettingKeys.DownloadTaskParam.EXTRA_HEADERS, r215);
        this.ext_rust = Internal.immutableCopyOf("ext_rust", r216);
        this.uri_str = r217;
        this.with_parallel = r218;
        this.upload_code = r219;
    }
}
