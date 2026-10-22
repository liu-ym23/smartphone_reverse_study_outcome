package open_pkm.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class MetaInfo extends Message<MetaInfo, Builder> {
    public static final ProtoAdapter<MetaInfo> ADAPTER = null;
    public static final String DEFAULT_APPID = "";
    public static final Long DEFAULT_APP_TYPE = null;
    public static final String DEFAULT_APP_VERSION = "";
    public static final Boolean DEFAULT_CHAT_ACTION = null;
    public static final String DEFAULT_COMPILE_VERSION = "";
    public static final String DEFAULT_DOMAIN = "";
    public static final String DEFAULT_EXTRA = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_MD5 = "";
    public static final Boolean DEFAULT_MESSAGE_ACTION = null;
    public static final String DEFAULT_MIN_JSSDK = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PCPATH_V2 = "";
    public static final String DEFAULT_PC_MD5_V2 = "";
    public static final Boolean DEFAULT_PC_USE_MOBILE_PKG = null;
    public static final Long DEFAULT_SCENE_TYPE = null;
    public static final String DEFAULT_SOCKET_ADDRESS = "";
    public static final Long DEFAULT_STATE = null;
    public static final String DEFAULT_TTBLACKCODE = "";
    public static final String DEFAULT_TTCODE = "";
    public static final String DEFAULT_TTID = "";
    public static final String DEFAULT_VERSION = "";
    public static final Long DEFAULT_VERSION_CODE = null;
    public static final Long DEFAULT_VERSION_STATE = null;
    public static final Long DEFAULT_VERSION_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final Long app_type;
    public final String app_version;
    public final String appid;
    public final Boolean chat_action;
    public final String compile_version;
    public final List<Component> components;
    public final Map<String, DiffPath> diff_path;
    public final String domain;
    public final String extra;
    public final List<String> gadget_safe_urls;
    public final String icon;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    public final String f524832md5;
    public final Boolean message_action;
    public final String min_jssdk;
    public final String name;
    public final Map<String, DiffPath> pc_diff_path;
    public final String pc_md5_v2;
    public final Boolean pc_use_mobile_pkg;
    public final String pcpath_v2;
    public final Long scene_type;
    public final String socket_address;
    public final Long state;
    public final String ttblackcode;
    public final String ttcode;
    public final String ttid;
    public final List<String> urls;
    public final String version;
    public final Long version_code;
    public final Long version_state;
    public final Long version_update_time;

    public static final class Builder extends Message.Builder<MetaInfo, Builder> {
        public Long app_type;
        public String app_version;
        public String appid;
        public Boolean chat_action;
        public String compile_version;
        public List<Component> components;
        public Map<String, DiffPath> diff_path;
        public String domain;
        public String extra;
        public List<String> gadget_safe_urls;
        public String icon;

        /* JADX INFO: renamed from: md5, reason: collision with root package name */
        public String f524833md5;
        public Boolean message_action;
        public String min_jssdk;
        public String name;
        public Map<String, DiffPath> pc_diff_path;
        public String pc_md5_v2;
        public Boolean pc_use_mobile_pkg;
        public String pcpath_v2;
        public Long scene_type;
        public String socket_address;
        public Long state;
        public String ttblackcode;
        public String ttcode;
        public String ttid;
        public List<String> urls;
        public String version;
        public Long version_code;
        public Long version_state;
        public Long version_update_time;

        @Override // com.squareup.wire.Message.Builder
        public MetaInfo build() {
            String r100 = this.app_version;
            if (r100 == null) goto L45;
            if (this.appid == null) goto L45;
            if (this.chat_action == null) goto L45;
            if (this.compile_version == null) goto L45;
            if (this.extra == null) goto L45;
            if (this.icon == null) goto L45;
            if (this.message_action == null) goto L45;
            if (this.pc_use_mobile_pkg == null) goto L45;
            if (this.domain == null) goto L45;
            if (this.f524833md5 == null) goto L45;
            if (this.name == null) goto L45;
            if (this.scene_type == null) goto L45;
            if (this.state == null) goto L45;
            if (this.ttblackcode == null) goto L45;
            if (this.ttcode == null) goto L45;
            if (this.ttid == null) goto L45;
            if (this.app_type == null) goto L45;
            if (this.version == null) goto L45;
            if (this.version_state == null) goto L45;
            if (this.version_update_time == null) goto L45;
            return new MetaInfo(this.app_version, this.appid, this.chat_action, this.compile_version, this.components, this.diff_path, this.extra, this.gadget_safe_urls, this.icon, this.message_action, this.min_jssdk, this.urls, this.pc_use_mobile_pkg, this.pc_diff_path, this.pc_md5_v2, this.pcpath_v2, this.socket_address, this.domain, this.f524833md5, this.name, this.scene_type, this.state, this.ttblackcode, this.ttcode, this.ttid, this.app_type, this.version, this.version_code, this.version_state, this.version_update_time, super.buildUnknownFields());
        L45:
            throw Internal.missingRequiredFields(new Object[]{r100, "app_version", this.appid, "appid", this.chat_action, "chat_action", this.compile_version, "compile_version", this.extra, "extra", this.icon, "icon", this.message_action, "message_action", this.pc_use_mobile_pkg, "pc_use_mobile_pkg", this.domain, "domain", this.f524833md5, "md5", this.name, "name", this.scene_type, "scene_type", this.state, "state", this.ttblackcode, "ttblackcode", this.ttcode, "ttcode", this.ttid, AppbrandHostConstants.Schema_BDP_LOG.FIELD_TTID, this.app_type, "app_type", this.version, "version", this.version_state, "version_state", this.version_update_time, "version_update_time"});
        }

        public Builder() {
            this.components = Internal.newMutableList();
            this.diff_path = Internal.newMutableMap();
            this.gadget_safe_urls = Internal.newMutableList();
            this.urls = Internal.newMutableList();
            this.pc_diff_path = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_type(Long r100) {
            this.app_type = r100;
            return this;
        }

        public Builder app_version(String r100) {
            this.app_version = r100;
            return this;
        }

        public Builder appid(String r100) {
            this.appid = r100;
            return this;
        }

        public Builder chat_action(Boolean r100) {
            this.chat_action = r100;
            return this;
        }

        public Builder compile_version(String r100) {
            this.compile_version = r100;
            return this;
        }

        public Builder components(List<Component> r100) {
            Internal.checkElementsNotNull(r100);
            this.components = r100;
            return this;
        }

        public Builder diff_path(Map<String, DiffPath> r100) {
            Internal.checkElementsNotNull(r100);
            this.diff_path = r100;
            return this;
        }

        public Builder domain(String r100) {
            this.domain = r100;
            return this;
        }

        public Builder extra(String r100) {
            this.extra = r100;
            return this;
        }

        public Builder gadget_safe_urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.gadget_safe_urls = r100;
            return this;
        }

        public Builder icon(String r100) {
            this.icon = r100;
            return this;
        }

        public Builder md5(String r100) {
            this.f524833md5 = r100;
            return this;
        }

        public Builder message_action(Boolean r100) {
            this.message_action = r100;
            return this;
        }

        public Builder min_jssdk(String r100) {
            this.min_jssdk = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder pc_diff_path(Map<String, DiffPath> r100) {
            Internal.checkElementsNotNull(r100);
            this.pc_diff_path = r100;
            return this;
        }

        public Builder pc_md5_v2(String r100) {
            this.pc_md5_v2 = r100;
            return this;
        }

        public Builder pc_use_mobile_pkg(Boolean r100) {
            this.pc_use_mobile_pkg = r100;
            return this;
        }

        public Builder pcpath_v2(String r100) {
            this.pcpath_v2 = r100;
            return this;
        }

        public Builder scene_type(Long r100) {
            this.scene_type = r100;
            return this;
        }

        public Builder socket_address(String r100) {
            this.socket_address = r100;
            return this;
        }

        public Builder state(Long r100) {
            this.state = r100;
            return this;
        }

        public Builder ttblackcode(String r100) {
            this.ttblackcode = r100;
            return this;
        }

        public Builder ttcode(String r100) {
            this.ttcode = r100;
            return this;
        }

        public Builder ttid(String r100) {
            this.ttid = r100;
            return this;
        }

        public Builder urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.urls = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }

        public Builder version_code(Long r100) {
            this.version_code = r100;
            return this;
        }

        public Builder version_state(Long r100) {
            this.version_state = r100;
            return this;
        }

        public Builder version_update_time(Long r100) {
            this.version_update_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MetaInfo extends ProtoAdapter<MetaInfo> {
        private final ProtoAdapter<Map<String, DiffPath>> diff_path;
        private final ProtoAdapter<Map<String, DiffPath>> pc_diff_path;

        public ProtoAdapter_MetaInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MetaInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            ProtoAdapter<DiffPath> r101 = DiffPath.ADAPTER;
            this.diff_path = ProtoAdapter.newMapAdapter(r100, r101);
            this.pc_diff_path = ProtoAdapter.newMapAdapter(r100, r101);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public MetaInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L37;
            switch(r103) {
                case 1: goto L36;
                case 2: goto L35;
                case 3: goto L34;
                case 4: goto L33;
                case 5: goto L32;
                case 6: goto L31;
                case 7: goto L30;
                case 8: goto L29;
                case 9: goto L28;
                case 10: goto L27;
                case 11: goto L26;
                case 12: goto L25;
                case 13: goto L24;
                case 14: goto L23;
                case 15: goto L22;
                case 16: goto L21;
                case 17: goto L20;
                case 18: goto L19;
                case 19: goto L18;
                case 20: goto L17;
                case 21: goto L16;
                case 22: goto L15;
                case 23: goto L14;
                case 24: goto L13;
                case 25: goto L12;
                case 26: goto L11;
                case 27: goto L10;
                case 28: goto L9;
                case 29: goto L8;
                case 30: goto L7;
                default: goto L6;
            };
        L7:
            r101.version_update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.version_state = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.version_code = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.app_type = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.ttid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.ttcode = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.ttblackcode = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.state = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.scene_type = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.f524833md5 = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.domain = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.socket_address = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.pcpath_v2 = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.pc_md5_v2 = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.pc_diff_path.putAll(this.pc_diff_path.decode(r100));
            goto L3
        L24:
            r101.pc_use_mobile_pkg = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L25:
            r101.urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L26:
            r101.min_jssdk = ProtoAdapter.STRING.decode(r100);
            goto L3
        L27:
            r101.message_action = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L28:
            r101.icon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L29:
            r101.gadget_safe_urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L30:
            r101.extra = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.diff_path.putAll(this.diff_path.decode(r100));
            goto L3
        L32:
            r101.components.add(Component.ADAPTER.decode(r100));
            goto L3
        L33:
            r101.compile_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L34:
            r101.chat_action = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L35:
            r101.appid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L36:
            r101.app_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L37:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MetaInfo r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.app_version) + r101.encodedSizeWithTag(2, r100.appid);
            ProtoAdapter<Boolean> r103 = ProtoAdapter.BOOL;
            int r104 = (((((((r102 + r103.encodedSizeWithTag(3, r100.chat_action)) + r101.encodedSizeWithTag(4, r100.compile_version)) + Component.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.components)) + this.diff_path.encodedSizeWithTag(6, r100.diff_path)) + r101.encodedSizeWithTag(7, r100.extra)) + r101.asRepeated().encodedSizeWithTag(8, r100.gadget_safe_urls)) + r101.encodedSizeWithTag(9, r100.icon)) + r103.encodedSizeWithTag(10, r100.message_action);
            String r105 = r100.min_jssdk;
            int r106 = 0;
            if (r105 == null) goto L5;
            int r107 = r101.encodedSizeWithTag(11, r105);
        L6:
            int r108 = (((r104 + r107) + r101.asRepeated().encodedSizeWithTag(12, r100.urls)) + r103.encodedSizeWithTag(13, r100.pc_use_mobile_pkg)) + this.pc_diff_path.encodedSizeWithTag(14, r100.pc_diff_path);
            String r109 = r100.pc_md5_v2;
            if (r109 == null) goto L9;
            int r110 = r101.encodedSizeWithTag(15, r109);
        L10:
            int r111 = r108 + r110;
            String r112 = r100.pcpath_v2;
            if (r112 == null) goto L13;
            int r113 = r101.encodedSizeWithTag(16, r112);
        L14:
            int r114 = r111 + r113;
            String r115 = r100.socket_address;
            if (r115 == null) goto L17;
            int r116 = r101.encodedSizeWithTag(17, r115);
        L18:
            int r117 = (((r114 + r116) + r101.encodedSizeWithTag(18, r100.domain)) + r101.encodedSizeWithTag(19, r100.f524832md5)) + r101.encodedSizeWithTag(20, r100.name);
            ProtoAdapter<Long> r118 = ProtoAdapter.INT64;
            int r119 = ((((((r117 + r118.encodedSizeWithTag(21, r100.scene_type)) + r118.encodedSizeWithTag(22, r100.state)) + r101.encodedSizeWithTag(23, r100.ttblackcode)) + r101.encodedSizeWithTag(24, r100.ttcode)) + r101.encodedSizeWithTag(25, r100.ttid)) + r118.encodedSizeWithTag(26, r100.app_type)) + r101.encodedSizeWithTag(27, r100.version);
            Long r120 = r100.version_code;
            if (r120 == null) goto L22;
            r106 = r118.encodedSizeWithTag(28, r120);
        L22:
            return (((r119 + r106) + r118.encodedSizeWithTag(29, r100.version_state)) + r118.encodedSizeWithTag(30, r100.version_update_time)) + r100.unknownFields().size();
        L17:
            r116 = 0;
            goto L18
        L13:
            r113 = 0;
            goto L14
        L9:
            r110 = 0;
            goto L10
        L5:
            r107 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MetaInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MetaInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MetaInfo r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.app_version);
            r102.encodeWithTag(r100, 2, r101.appid);
            ProtoAdapter<Boolean> r103 = ProtoAdapter.BOOL;
            r103.encodeWithTag(r100, 3, r101.chat_action);
            r102.encodeWithTag(r100, 4, r101.compile_version);
            Component.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.components);
            this.diff_path.encodeWithTag(r100, 6, r101.diff_path);
            r102.encodeWithTag(r100, 7, r101.extra);
            r102.asRepeated().encodeWithTag(r100, 8, r101.gadget_safe_urls);
            r102.encodeWithTag(r100, 9, r101.icon);
            r103.encodeWithTag(r100, 10, r101.message_action);
            String r104 = r101.min_jssdk;
            if (r104 == null) goto L5;
            r102.encodeWithTag(r100, 11, r104);
        L5:
            r102.asRepeated().encodeWithTag(r100, 12, r101.urls);
            r103.encodeWithTag(r100, 13, r101.pc_use_mobile_pkg);
            this.pc_diff_path.encodeWithTag(r100, 14, r101.pc_diff_path);
            String r105 = r101.pc_md5_v2;
            if (r105 == null) goto L8;
            r102.encodeWithTag(r100, 15, r105);
        L8:
            String r106 = r101.pcpath_v2;
            if (r106 == null) goto L11;
            r102.encodeWithTag(r100, 16, r106);
        L11:
            String r107 = r101.socket_address;
            if (r107 == null) goto L14;
            r102.encodeWithTag(r100, 17, r107);
        L14:
            r102.encodeWithTag(r100, 18, r101.domain);
            r102.encodeWithTag(r100, 19, r101.f524832md5);
            r102.encodeWithTag(r100, 20, r101.name);
            ProtoAdapter<Long> r108 = ProtoAdapter.INT64;
            r108.encodeWithTag(r100, 21, r101.scene_type);
            r108.encodeWithTag(r100, 22, r101.state);
            r102.encodeWithTag(r100, 23, r101.ttblackcode);
            r102.encodeWithTag(r100, 24, r101.ttcode);
            r102.encodeWithTag(r100, 25, r101.ttid);
            r108.encodeWithTag(r100, 26, r101.app_type);
            r102.encodeWithTag(r100, 27, r101.version);
            Long r109 = r101.version_code;
            if (r109 == null) goto L17;
            r108.encodeWithTag(r100, 28, r109);
        L17:
            r108.encodeWithTag(r100, 29, r101.version_state);
            r108.encodeWithTag(r100, 30, r101.version_update_time);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MetaInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MetaInfo();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_CHAT_ACTION = r100;
        DEFAULT_MESSAGE_ACTION = r100;
        DEFAULT_PC_USE_MOBILE_PKG = r100;
        DEFAULT_SCENE_TYPE = 0L;
        DEFAULT_STATE = 0L;
        DEFAULT_APP_TYPE = 0L;
        DEFAULT_VERSION_CODE = 0L;
        DEFAULT_VERSION_STATE = 0L;
        DEFAULT_VERSION_UPDATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_version = this.app_version;
        r100.appid = this.appid;
        r100.chat_action = this.chat_action;
        r100.compile_version = this.compile_version;
        r100.components = Internal.copyOf("components", this.components);
        r100.diff_path = Internal.copyOf("diff_path", this.diff_path);
        r100.extra = this.extra;
        r100.gadget_safe_urls = Internal.copyOf("gadget_safe_urls", this.gadget_safe_urls);
        r100.icon = this.icon;
        r100.message_action = this.message_action;
        r100.min_jssdk = this.min_jssdk;
        r100.urls = Internal.copyOf("urls", this.urls);
        r100.pc_use_mobile_pkg = this.pc_use_mobile_pkg;
        r100.pc_diff_path = Internal.copyOf("pc_diff_path", this.pc_diff_path);
        r100.pc_md5_v2 = this.pc_md5_v2;
        r100.pcpath_v2 = this.pcpath_v2;
        r100.socket_address = this.socket_address;
        r100.domain = this.domain;
        r100.f524833md5 = this.f524832md5;
        r100.name = this.name;
        r100.scene_type = this.scene_type;
        r100.state = this.state;
        r100.ttblackcode = this.ttblackcode;
        r100.ttcode = this.ttcode;
        r100.ttid = this.ttid;
        r100.app_type = this.app_type;
        r100.version = this.version;
        r100.version_code = this.version_code;
        r100.version_state = this.version_state;
        r100.version_update_time = this.version_update_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MetaInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MetaInfo(String r310, String r311, Boolean r312, String r313, List<Component> r314, Map<String, DiffPath> r315, String r316, List<String> r410, String r411, Boolean r412, String r413, List<String> r414, Boolean r415, Map<String, DiffPath> r416, String r417, String r418, String r419, String r510, String r511, String r512, Long r513, Long r514, String r515, String r516, String r517, Long r518, String r519, Long r610, Long r611, Long r612) {
        this(r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, ByteString.EMPTY);
    }

    public MetaInfo(String r100, String r101, Boolean r102, String r103, List<Component> r104, Map<String, DiffPath> r105, String r110, List<String> r111, String r112, Boolean r113, String r114, List<String> r115, Boolean r116, Map<String, DiffPath> r117, String r118, String r119, String r210, String r211, String r212, String r213, Long r214, Long r215, String r216, String r217, String r218, Long r219, String r310, Long r311, Long r312, Long r313, ByteString r314) {
        super(ADAPTER, r314);
        this.app_version = r100;
        this.appid = r101;
        this.chat_action = r102;
        this.compile_version = r103;
        this.components = Internal.immutableCopyOf("components", r104);
        this.diff_path = Internal.immutableCopyOf("diff_path", r105);
        this.extra = r110;
        this.gadget_safe_urls = Internal.immutableCopyOf("gadget_safe_urls", r111);
        this.icon = r112;
        this.message_action = r113;
        this.min_jssdk = r114;
        this.urls = Internal.immutableCopyOf("urls", r115);
        this.pc_use_mobile_pkg = r116;
        this.pc_diff_path = Internal.immutableCopyOf("pc_diff_path", r117);
        this.pc_md5_v2 = r118;
        this.pcpath_v2 = r119;
        this.socket_address = r210;
        this.domain = r211;
        this.f524832md5 = r212;
        this.name = r213;
        this.scene_type = r214;
        this.state = r215;
        this.ttblackcode = r216;
        this.ttcode = r217;
        this.ttid = r218;
        this.app_type = r219;
        this.version = r310;
        this.version_code = r311;
        this.version_state = r312;
        this.version_update_time = r313;
    }
}
