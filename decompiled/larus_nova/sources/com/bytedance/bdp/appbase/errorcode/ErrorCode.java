package com.bytedance.bdp.appbase.errorcode;

import com.baidu.mapapi.SDKInitializer;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
public interface ErrorCode {

    public static final enum DOWNLOAD extends Enum<DOWNLOAD> implements ErrorCode {
        public static final DOWNLOAD APP_ID_NULL = null;
        public static final DOWNLOAD APP_VERSION_NULL = null;
        public static final DOWNLOAD BUILT_IN_PLUGIN_NOT_FOUND = null;
        public static final DOWNLOAD FILE_NOT_FOUND = null;
        public static final DOWNLOAD INVALID_URL = null;
        public static final DOWNLOAD LOADTASK_ALREADY_FAIL = null;
        public static final DOWNLOAD LOADTASK_ALREADY_RELEASED = null;
        public static final DOWNLOAD LOADTASK_ROOT_NOT_FOUND = null;
        public static final DOWNLOAD MAGIC_STRING_ERROR = null;
        public static final DOWNLOAD MOVE_FILE_FAILED = null;
        public static final DOWNLOAD NETWORK_ERROR = null;
        public static final DOWNLOAD PACKAGE_CONFIG_IS_NULL = null;
        public static final DOWNLOAD PKG_FILE_OFFSET_WRONG = null;
        public static final DOWNLOAD PKG_MD5_ERROR = null;
        public static final DOWNLOAD REQUEST_STOP = null;
        public static final DOWNLOAD REQUEST_TWICE = null;
        public static final DOWNLOAD START_PAGE_ERROR = null;
        public static final DOWNLOAD TTWEBVIEW_INSTALL_ERROR = null;
        public static final DOWNLOAD UNKNOWN = null;
        public static final DOWNLOAD UNSUPPORT_TTAPKG_VERSION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DOWNLOAD[] f200791a = null;
        private int code;
        private String desc;
        private int monitorStatus;

        static {
            DOWNLOAD r100 = new DOWNLOAD("FILE_NOT_FOUND", 0, 100, "file not exist", 1017);
            FILE_NOT_FOUND = r100;
            DOWNLOAD r101 = new DOWNLOAD("NETWORK_ERROR", 1, 101, SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR, 6070);
            NETWORK_ERROR = r101;
            DOWNLOAD r102 = new DOWNLOAD("MAGIC_STRING_ERROR", 2, 102, "the head of ttpkg of contains TTPKG", 1017);
            MAGIC_STRING_ERROR = r102;
            DOWNLOAD r103 = new DOWNLOAD("INVALID_URL", 3, 103, "illegal download url", 1017);
            INVALID_URL = r103;
            DOWNLOAD r104 = new DOWNLOAD("PKG_FILE_OFFSET_WRONG", 4, 104, "file offset error", 1017);
            PKG_FILE_OFFSET_WRONG = r104;
            DOWNLOAD r105 = new DOWNLOAD("APP_ID_NULL", 5, 105, "appId is AppInfo is null", 1017);
            APP_ID_NULL = r105;
            DOWNLOAD r106 = new DOWNLOAD("APP_VERSION_NULL", 6, 106, "version of AppInfo is null", 1017);
            APP_VERSION_NULL = r106;
            DOWNLOAD r110 = new DOWNLOAD("PKG_MD5_ERROR", 7, 107, "ttpkg md5 verify error", 1000);
            PKG_MD5_ERROR = r110;
            DOWNLOAD r107 = new DOWNLOAD("UNKNOWN", 8, 108, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN, 1017);
            UNKNOWN = r107;
            DOWNLOAD r108 = new DOWNLOAD("UNSUPPORT_TTAPKG_VERSION", 9, 109, "unsupported version of littleapp pkg", 1017);
            UNSUPPORT_TTAPKG_VERSION = r108;
            DOWNLOAD r109 = new DOWNLOAD("LOADTASK_ALREADY_FAIL", 10, 110, "LoadTask has failed before", 1017);
            LOADTASK_ALREADY_FAIL = r109;
            DOWNLOAD r111 = new DOWNLOAD("LOADTASK_ALREADY_RELEASED", 11, 111, "LoadTask has canceled", 1017);
            LOADTASK_ALREADY_RELEASED = r111;
            DOWNLOAD r112 = new DOWNLOAD("LOADTASK_ROOT_NOT_FOUND", 12, 112, "cannot find the Root", 1017);
            LOADTASK_ROOT_NOT_FOUND = r112;
            DOWNLOAD r113 = new DOWNLOAD("REQUEST_TWICE", 13, 113, "cannot request twice", 1017);
            REQUEST_TWICE = r113;
            DOWNLOAD r210 = new DOWNLOAD("PACKAGE_CONFIG_IS_NULL", 14, 115, "Meta has no PackageConfig", 1017);
            PACKAGE_CONFIG_IS_NULL = r210;
            DOWNLOAD r114 = new DOWNLOAD("REQUEST_STOP", 15, 116, "request stop ", 1017);
            REQUEST_STOP = r114;
            DOWNLOAD r115 = new DOWNLOAD("MOVE_FILE_FAILED", 16, 117, "move file failed", 1017);
            MOVE_FILE_FAILED = r115;
            DOWNLOAD r116 = new DOWNLOAD("BUILT_IN_PLUGIN_NOT_FOUND", 17, 118, "built-in plugin not found", 1017);
            BUILT_IN_PLUGIN_NOT_FOUND = r116;
            DOWNLOAD r117 = new DOWNLOAD("START_PAGE_ERROR", 18, 119, "start page error", 1017);
            START_PAGE_ERROR = r117;
            DOWNLOAD r118 = new DOWNLOAD("TTWEBVIEW_INSTALL_ERROR", 19, 120, "ttWebView install error", 1017);
            TTWEBVIEW_INSTALL_ERROR = r118;
            f200791a = new DOWNLOAD[]{r100, r101, r102, r103, r104, r105, r106, r110, r107, r108, r109, r111, r112, r113, r210, r114, r115, r116, r117, r118};
        }

        public static DOWNLOAD[] values() {
            return (DOWNLOAD[]) f200791a.clone();
        }

        @Override // com.bytedance.bdp.appbase.errorcode.ErrorCode
        public String getCode() {
            return Flow.Download.getCode() + this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public int getMonitorStatus() {
            return this.monitorStatus;
        }

        public static DOWNLOAD valueOf(String r100) {
            return (DOWNLOAD) a.a(DOWNLOAD.class, r100);
        }

        public DOWNLOAD(String r100, int r101, int r102, String r103, int r104) {
            super(r100, r101);
            this.code = r102;
            this.desc = r103;
            this.monitorStatus = r104;
        }
    }

    public static final enum JSCORE extends Enum<JSCORE> implements ErrorCode {
        public static final JSCORE JS_LOAD_SCRIPT_ERROR = null;
        public static final JSCORE MAIN_JS_EXECUTE_ERROR = null;
        public static final JSCORE MAIN_JS_NOT_FOUND = null;
        public static final JSCORE TMA_CONFIG_EXECUTE_ERROR = null;
        public static final JSCORE TMA_CORE_EXECUTE_ERROR = null;
        public static final JSCORE TMA_CORE_NOT_FOUND = null;
        public static final JSCORE TMA_JS_ENGINE_ERROR = null;
        public static final JSCORE TMG_CORE_EXECUTE_ERROR = null;
        public static final JSCORE TMG_CORE_NOT_FOUND = null;
        public static final JSCORE TMG_GAME_JS_EXECUTE_ERROR = null;
        public static final JSCORE TMG_GAME_JS_NOT_FOUND = null;
        public static final JSCORE TMG_SETUP_ENGINE_ERROR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ JSCORE[] f200792a = null;
        private int code;
        private String desc;
        private int monitorStatus;

        static {
            JSCORE r100 = new JSCORE("TMA_CORE_NOT_FOUND", 0, 100, "tma-core.js not exist");
            TMA_CORE_NOT_FOUND = r100;
            JSCORE r101 = new JSCORE("TMA_CORE_EXECUTE_ERROR", 1, 101, "tma-core.js execute failed");
            TMA_CORE_EXECUTE_ERROR = r101;
            JSCORE r102 = new JSCORE("TMA_CONFIG_EXECUTE_ERROR", 2, 102, "exception occured when execute TMAConfig");
            TMA_CONFIG_EXECUTE_ERROR = r102;
            JSCORE r103 = new JSCORE("MAIN_JS_NOT_FOUND", 3, 103, "main.js not exist");
            MAIN_JS_NOT_FOUND = r103;
            JSCORE r104 = new JSCORE("MAIN_JS_EXECUTE_ERROR", 4, 104, "main.js execute failed");
            MAIN_JS_EXECUTE_ERROR = r104;
            JSCORE r105 = new JSCORE("TMG_CORE_NOT_FOUND", 5, 105, "tmg-core not exist");
            TMG_CORE_NOT_FOUND = r105;
            JSCORE r106 = new JSCORE("TMG_CORE_EXECUTE_ERROR", 6, 106, "tmg-core execute failed");
            TMG_CORE_EXECUTE_ERROR = r106;
            JSCORE r110 = new JSCORE("TMG_GAME_JS_NOT_FOUND", 7, 107, "game.js not exist");
            TMG_GAME_JS_NOT_FOUND = r110;
            JSCORE r111 = new JSCORE("TMG_GAME_JS_EXECUTE_ERROR", 8, 108, "game.js execute failed");
            TMG_GAME_JS_EXECUTE_ERROR = r111;
            JSCORE r112 = new JSCORE("TMA_JS_ENGINE_ERROR", 9, 109, "JS Engine failed");
            TMA_JS_ENGINE_ERROR = r112;
            JSCORE r113 = new JSCORE("TMG_SETUP_ENGINE_ERROR", 10, 110, "littlegame setupEngine failed");
            TMG_SETUP_ENGINE_ERROR = r113;
            JSCORE r107 = new JSCORE("JS_LOAD_SCRIPT_ERROR", 11, 111, "js load failed");
            JS_LOAD_SCRIPT_ERROR = r107;
            f200792a = new JSCORE[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107};
        }

        public static JSCORE[] values() {
            return (JSCORE[]) f200792a.clone();
        }

        @Override // com.bytedance.bdp.appbase.errorcode.ErrorCode
        public String getCode() {
            return Flow.JsCore.getCode() + this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public int getMonitorStatus() {
            return this.monitorStatus;
        }

        public static JSCORE valueOf(String r100) {
            return (JSCORE) a.a(JSCORE.class, r100);
        }

        public JSCORE(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.code = r102;
            this.desc = r103;
            this.monitorStatus = 6050;
        }
    }

    public static final enum MAIN extends Enum<MAIN> implements ErrorCode {
        public static final MAIN BEFORE_ON_CREATE_CHECK_FAIL = null;
        public static final MAIN CAN_NOT_FOUND_MINI_APP_CONFIG = null;
        public static final MAIN CAN_NOT_FOUND_PKG_FILE = null;
        public static final MAIN CAN_NOT_FOUND_PLUGIN_APP_CONFIG = null;
        public static final MAIN DEVICE_BLACK_LIST = null;
        public static final MAIN GAME_MODULE_NOT_READY = null;
        public static final MAIN GET_LAUNCHCACHE_FILE_LOCK_FAIL = null;
        public static final MAIN GET_PLUGIN_CACHE_FILE_LOCK_FAIL = null;
        public static final MAIN HELIUM_HANDLE_NULL = null;
        public static final MAIN HELIUM_INIT_ERROR = null;
        public static final MAIN LAUNCH_INFO_ERROR = null;
        public static final MAIN OPEN_APP_ERROR = null;
        public static final MAIN PARSE_APPCONFIG_ERROR = null;
        public static final MAIN PLUGIN_NOT_INSTALL = null;
        public static final MAIN RENDER_SNAP_ERROR = null;
        public static final MAIN SCHEME_APPID_NULL = null;
        public static final MAIN SCHEME_NOT_MATCH = null;
        public static final MAIN SCHEME_NULL_ERROR = null;
        public static final MAIN SCHEME_PARAMS_ERROR = null;
        public static final MAIN SCHEME_PARSE_ERROR = null;
        public static final MAIN SDK_INIT_ERROR = null;
        public static final MAIN START_MINI_APP_ERROR = null;
        public static final MAIN START_MODE_ERROR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MAIN[] f200793a = null;
        private int code;
        private String desc;
        private int monitorStatus;

        static {
            MAIN r100 = new MAIN("SDK_INIT_ERROR", 0, 100, "SDK init failed", 5000);
            SDK_INIT_ERROR = r100;
            MAIN r101 = new MAIN("SCHEME_NULL_ERROR", 1, 101, "scheme is null", 5000);
            SCHEME_NULL_ERROR = r101;
            MAIN r102 = new MAIN("SCHEME_NOT_MATCH", 2, 102, "host of schema not microgame/microapp", 5000);
            SCHEME_NOT_MATCH = r102;
            MAIN r103 = new MAIN("SCHEME_APPID_NULL", 3, 103, "AppId in schema is null", 5000);
            SCHEME_APPID_NULL = r103;
            MAIN r104 = new MAIN("PLUGIN_NOT_INSTALL", 4, 104, "plugin of miniapp not install", 5000);
            PLUGIN_NOT_INSTALL = r104;
            MAIN r105 = new MAIN("DEVICE_BLACK_LIST", 5, 105, "blocklist of device", 5000);
            DEVICE_BLACK_LIST = r105;
            MAIN r106 = new MAIN("START_MINI_APP_ERROR", 6, 106, "launch miniapp/minigame Activity failed", 5000);
            START_MINI_APP_ERROR = r106;
            MAIN r110 = new MAIN("PARSE_APPCONFIG_ERROR", 7, 107, "parse AppConfig failed", 1006);
            PARSE_APPCONFIG_ERROR = r110;
            MAIN r107 = new MAIN("OPEN_APP_ERROR", 8, 108, "open miniapp/game failed", 5000);
            OPEN_APP_ERROR = r107;
            MAIN r108 = new MAIN("HELIUM_HANDLE_NULL", 9, 109, "handler of game engine is null", 5000);
            HELIUM_HANDLE_NULL = r108;
            MAIN r109 = new MAIN("HELIUM_INIT_ERROR", 10, 110, "init game engine error", 5000);
            HELIUM_INIT_ERROR = r109;
            MAIN r111 = new MAIN("BEFORE_ON_CREATE_CHECK_FAIL", 11, 111, "beforeOnCreate verify error", 5000);
            BEFORE_ON_CREATE_CHECK_FAIL = r111;
            MAIN r112 = new MAIN("GAME_MODULE_NOT_READY", 12, 112, "game module not load", 5000);
            GAME_MODULE_NOT_READY = r112;
            MAIN r113 = new MAIN("GET_LAUNCHCACHE_FILE_LOCK_FAIL", 13, 113, "fetch LaunchCache file lock failed", 6012);
            GET_LAUNCHCACHE_FILE_LOCK_FAIL = r113;
            MAIN r210 = new MAIN("SCHEME_PARSE_ERROR", 14, 114, "schema_parse_error", 5000);
            SCHEME_PARSE_ERROR = r210;
            MAIN r114 = new MAIN("RENDER_SNAP_ERROR", 15, 115, "render_snap_error", 5000);
            RENDER_SNAP_ERROR = r114;
            MAIN r115 = new MAIN("START_MODE_ERROR", 16, 116, "start mode error", 5000);
            START_MODE_ERROR = r115;
            MAIN r116 = new MAIN("LAUNCH_INFO_ERROR", 17, 117, "launch info error", 5000);
            LAUNCH_INFO_ERROR = r116;
            MAIN r117 = new MAIN("SCHEME_PARAMS_ERROR", 18, 118, "schema param wrong", 5000);
            SCHEME_PARAMS_ERROR = r117;
            MAIN r118 = new MAIN("CAN_NOT_FOUND_PLUGIN_APP_CONFIG", 19, 119, "can not found plugin app config data", 5000);
            CAN_NOT_FOUND_PLUGIN_APP_CONFIG = r118;
            MAIN r119 = new MAIN("CAN_NOT_FOUND_MINI_APP_CONFIG", 20, 120, "can not found mini app config data", 5000);
            CAN_NOT_FOUND_MINI_APP_CONFIG = r119;
            MAIN r211 = new MAIN("CAN_NOT_FOUND_PKG_FILE", 21, 121, "can not found package file", 5000);
            CAN_NOT_FOUND_PKG_FILE = r211;
            MAIN r212 = new MAIN("GET_PLUGIN_CACHE_FILE_LOCK_FAIL", 22, 122, "fetch PluginCache file lock failed", 6013);
            GET_PLUGIN_CACHE_FILE_LOCK_FAIL = r212;
            f200793a = new MAIN[]{r100, r101, r102, r103, r104, r105, r106, r110, r107, r108, r109, r111, r112, r113, r210, r114, r115, r116, r117, r118, r119, r211, r212};
        }

        public static MAIN[] values() {
            return (MAIN[]) f200793a.clone();
        }

        @Override // com.bytedance.bdp.appbase.errorcode.ErrorCode
        public String getCode() {
            return Flow.Main.getCode() + this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public int getMonitorStatus() {
            return this.monitorStatus;
        }

        public static MAIN valueOf(String r100) {
            return (MAIN) a.a(MAIN.class, r100);
        }

        public MAIN(String r100, int r101, int r102, String r103, int r104) {
            super(r100, r101);
            this.code = r102;
            this.desc = r103;
            this.monitorStatus = r104;
        }
    }

    public static final enum META extends Enum<META> implements ErrorCode {
        public static final META CODE_ERROR = null;
        public static final META FORCE_FALLBACK_TO_NOT_ONLINE = null;
        public static final META HOST_MISMATCH = null;
        public static final META INTERACTION_GAME_SCHEMA_NULL = null;
        public static final META INVALID_APP_ID = null;
        public static final META INVALID_JS_SDK = null;
        public static final META INVALID_VERSION = null;
        public static final META JSON_ERROR = null;
        public static final META LOCAL_EXPIRED = null;
        public static final META MINIMUM_VERSION_LIMIT = null;
        public static final META NOT_ONLINE = null;
        public static final META NULL = null;
        public static final META OFFLINE = null;
        public static final META PARSE_DOWNLOAD_INFO_FAIL = null;
        public static final META PARSE_ERROR = null;
        public static final META PERMISSION_DENY = null;
        public static final META PLUGIN_ID_NULL = null;
        public static final META QRCODE_EXPIRED = null;
        public static final META SAVE_FAIL = null;
        public static final META SAVE_META_FAILED = null;
        public static final META TECH_TYPE_NOT_SUPPORT = null;
        public static final META UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ META[] f200794a = null;
        private int code;
        private String desc;
        private int monitorStatus;

        static {
            META r100 = new META("NULL", 0, 100, "the reslt of META is null", 1012);
            NULL = r100;
            META r101 = new META("PARSE_ERROR", 1, 101, "meta parse error", 1014);
            PARSE_ERROR = r101;
            META r102 = new META("CODE_ERROR", 2, 102, "the error field in meta response is not 0", 1014);
            CODE_ERROR = r102;
            META r103 = new META("INVALID_APP_ID", 3, 103, " appid is null in response of meta", 1014);
            INVALID_APP_ID = r103;
            META r104 = new META("INVALID_VERSION", 4, 104, "appVersion is null in response of meta", 1014);
            INVALID_VERSION = r104;
            META r105 = new META("JSON_ERROR", 5, 105, "JSONString error when parsing meta", 1014);
            JSON_ERROR = r105;
            META r106 = new META("OFFLINE", 6, 106, "miniapp/minigame offlined", 1026);
            OFFLINE = r106;
            META r110 = new META("HOST_MISMATCH", 7, 107, "miniapp/minigame not support current host", 1026);
            HOST_MISMATCH = r110;
            META r107 = new META("PERMISSION_DENY", 8, 108, "no permission access miniapp/minigame", 1026);
            PERMISSION_DENY = r107;
            META r108 = new META("INVALID_JS_SDK", 9, 109, "jssdk lower then the limit of miniapp/minigame", 1026);
            INVALID_JS_SDK = r108;
            META r109 = new META("UNKNOWN", 10, 110, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN, 1014);
            UNKNOWN = r109;
            META r111 = new META("QRCODE_EXPIRED", 11, 111, "QR CODE expired", 1026);
            QRCODE_EXPIRED = r111;
            META r112 = new META("SAVE_FAIL", 12, 112, "save meta failed", 1014);
            SAVE_FAIL = r112;
            META r113 = new META("LOCAL_EXPIRED", 13, 113, "local meta expired", 1014);
            LOCAL_EXPIRED = r113;
            META r210 = new META("NOT_ONLINE", 14, 114, "miniapp is not online on this host", 1026);
            NOT_ONLINE = r210;
            META r114 = new META("PARSE_DOWNLOAD_INFO_FAIL", 15, 115, "parse download info failed", 1014);
            PARSE_DOWNLOAD_INFO_FAIL = r114;
            META r115 = new META("MINIMUM_VERSION_LIMIT", 16, 116, "meta version less than bdp_miniapp_version", 1014);
            MINIMUM_VERSION_LIMIT = r115;
            META r116 = new META("PLUGIN_ID_NULL", 17, 117, "request meta but plugin id is null", 1014);
            PLUGIN_ID_NULL = r116;
            META r117 = new META("SAVE_META_FAILED", 18, 118, "save meta failed", 1014);
            SAVE_META_FAILED = r117;
            META r118 = new META("TECH_TYPE_NOT_SUPPORT", 19, 119, "tech type not support", 1026);
            TECH_TYPE_NOT_SUPPORT = r118;
            META r119 = new META("FORCE_FALLBACK_TO_NOT_ONLINE", 20, 120, "force fallback to not online", 1012);
            FORCE_FALLBACK_TO_NOT_ONLINE = r119;
            META r211 = new META("INTERACTION_GAME_SCHEMA_NULL", 21, 121, "interaction game schema null", 1014);
            INTERACTION_GAME_SCHEMA_NULL = r211;
            f200794a = new META[]{r100, r101, r102, r103, r104, r105, r106, r110, r107, r108, r109, r111, r112, r113, r210, r114, r115, r116, r117, r118, r119, r211};
        }

        public static META[] values() {
            return (META[]) f200794a.clone();
        }

        @Override // com.bytedance.bdp.appbase.errorcode.ErrorCode
        public String getCode() {
            return Flow.Meta.getCode() + this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public int getMonitorStatus() {
            return this.monitorStatus;
        }

        public static META valueOf(String r100) {
            return (META) a.a(META.class, r100);
        }

        public META(String r100, int r101, int r102, String r103, int r104) {
            super(r100, r101);
            this.code = r102;
            this.desc = r103;
            this.monitorStatus = r104;
        }
    }

    public static final enum WEBVIEW extends Enum<WEBVIEW> implements ErrorCode {
        public static final WEBVIEW ENTRY_PAGE_NOT_FOUND = null;
        public static final WEBVIEW EXECUTE_PAGE_FRAME_ERROR = null;
        public static final WEBVIEW EXECUTE_PATH_FRAME_ERROR = null;
        public static final WEBVIEW FRAME_HTML_INVALIDATE = null;
        public static final WEBVIEW FRAME_HTML_NOT_FOUND = null;
        public static final WEBVIEW FRAME_JS_INVALIDATE = null;
        public static final WEBVIEW FRAME_JS_NOT_FOUND = null;
        public static final WEBVIEW INVALIDATE_TTPKG_VERSION = null;
        public static final WEBVIEW LINE_UP_CANCELED = null;
        public static final WEBVIEW LOAD_TASK_ERROR = null;
        public static final WEBVIEW ON_RENDER_PROCESS_GONE = null;
        public static final WEBVIEW RECEIVE_WEBVIEW_ERROR = null;
        public static final WEBVIEW TEMPLATE_NOT_FOUND = null;
        public static final WEBVIEW TTWEBVIEW_INSTALL_ERROR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WEBVIEW[] f200795a = null;
        private int code;
        private String desc;
        private int monitorStatus;

        static {
            WEBVIEW r100 = new WEBVIEW("TEMPLATE_NOT_FOUND", 0, 100, "template.html not exist", 6002);
            TEMPLATE_NOT_FOUND = r100;
            WEBVIEW r101 = new WEBVIEW("FRAME_JS_NOT_FOUND", 1, 101, " page-frame.js not exist", AuthCode.StatusCode.PERMISSION_NOT_EXIST);
            FRAME_JS_NOT_FOUND = r101;
            WEBVIEW r102 = new WEBVIEW("FRAME_JS_INVALIDATE", 2, 102, "page-frame.js content invalid", 5000);
            FRAME_JS_INVALIDATE = r102;
            WEBVIEW r103 = new WEBVIEW("FRAME_HTML_NOT_FOUND", 3, 103, "page-frame.html not found", 5000);
            FRAME_HTML_NOT_FOUND = r103;
            WEBVIEW r104 = new WEBVIEW("FRAME_HTML_INVALIDATE", 4, 104, "page-frame.html invalid", 5000);
            FRAME_HTML_INVALIDATE = r104;
            WEBVIEW r105 = new WEBVIEW("INVALIDATE_TTPKG_VERSION", 5, 105, "invalid ttpkg version", 5000);
            INVALIDATE_TTPKG_VERSION = r105;
            WEBVIEW r106 = new WEBVIEW("LOAD_TASK_ERROR", 6, 106, "loadTask is null", 5000);
            LOAD_TASK_ERROR = r106;
            WEBVIEW r110 = new WEBVIEW("ENTRY_PAGE_NOT_FOUND", 7, 107, "entryPage not found in appConfig", 5000);
            ENTRY_PAGE_NOT_FOUND = r110;
            WEBVIEW r107 = new WEBVIEW("EXECUTE_PAGE_FRAME_ERROR", 8, 108, "execute  page-frame.js error", 5000);
            EXECUTE_PAGE_FRAME_ERROR = r107;
            WEBVIEW r108 = new WEBVIEW("EXECUTE_PATH_FRAME_ERROR", 9, 109, "execute path-frame.js error", 5000);
            EXECUTE_PATH_FRAME_ERROR = r108;
            WEBVIEW r109 = new WEBVIEW("RECEIVE_WEBVIEW_ERROR", 10, 111, "receive webview exception when executing js", 3002);
            RECEIVE_WEBVIEW_ERROR = r109;
            WEBVIEW r111 = new WEBVIEW("ON_RENDER_PROCESS_GONE", 11, 112, "receive onRenderProcessGone event", 3003);
            ON_RENDER_PROCESS_GONE = r111;
            WEBVIEW r112 = new WEBVIEW("TTWEBVIEW_INSTALL_ERROR", 12, 113, "install ttwebview error", 5000);
            TTWEBVIEW_INSTALL_ERROR = r112;
            WEBVIEW r113 = new WEBVIEW("LINE_UP_CANCELED", 13, 114, "line up canceled by relaunch", 0);
            LINE_UP_CANCELED = r113;
            f200795a = new WEBVIEW[]{r100, r101, r102, r103, r104, r105, r106, r110, r107, r108, r109, r111, r112, r113};
        }

        public static WEBVIEW[] values() {
            return (WEBVIEW[]) f200795a.clone();
        }

        @Override // com.bytedance.bdp.appbase.errorcode.ErrorCode
        public String getCode() {
            return Flow.WebView.getCode() + this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public int getMonitorStatus() {
            return this.monitorStatus;
        }

        public static WEBVIEW valueOf(String r100) {
            return (WEBVIEW) a.a(WEBVIEW.class, r100);
        }

        public WEBVIEW(String r100, int r101, int r102, String r103, int r104) {
            super(r100, r101);
            this.code = r102;
            this.desc = r103;
            this.monitorStatus = r104;
        }
    }

    String getCode();
}
