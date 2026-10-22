package com.bytedance.ee.lark.infra.config.mina.keys;

import com.bytedance.bdp.appbase.settings.SettingsConstants;
import com.heytap.mcssdk.constant.b;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum Settings extends Enum<Settings> {
    public static final Settings BDP_ANTI_ADDICTION = null;
    public static final Settings BDP_FAVORITES = null;
    public static final Settings BDP_HELIUM_CONFIG = null;
    public static final Settings BDP_LAUNCH_APP_SCENE_LIST = null;
    public static final Settings BDP_META_CONFIG = null;
    public static final Settings BDP_MORE_GAME_CENTER = null;
    public static final Settings BDP_OFFLINE_ZIP = null;
    public static final Settings BDP_REENTER_TIPS = null;
    public static final Settings BDP_STARTPAGE_PREFETCH = null;
    public static final Settings BDP_TTPKG_CONFIG = null;
    public static final Settings BDP_TTREQUEST_CONFIG = null;
    public static final Settings BLOCK_SDK_CONFIG = null;
    public static final Settings LYNX_MESSAGE_CARD_SDK_CONFIG = null;
    public static final Settings PRE_RENDER = null;
    public static final Settings SNAPSHOT = null;
    public static final Settings TMA_REGION_CONFIG = null;
    public static final Settings TMA_SDK_CONFIG = null;
    public static final Settings TMA_VDOM_TEST = null;
    public static final Settings TT_TMA_ABTEST = null;
    public static final Settings TT_TMA_BLACKLIST = null;
    public static final Settings TT_TMA_NATIVE_UI = null;
    public static final Settings TT_TMA_SWITCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Settings[] f242774a = null;
    private String name;

    public static final enum BdpLaunchSceneList extends Enum<BdpLaunchSceneList> {
        public static final BdpLaunchSceneList GRAY_LIST = null;
        public static final BdpLaunchSceneList WHITE_LIST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BdpLaunchSceneList[] f242775a = null;
        private String name;

        static {
            BdpLaunchSceneList r100 = new BdpLaunchSceneList("WHITE_LIST", 0, "white_list");
            WHITE_LIST = r100;
            BdpLaunchSceneList r101 = new BdpLaunchSceneList("GRAY_LIST", 1, "gray_list");
            GRAY_LIST = r101;
            f242775a = new BdpLaunchSceneList[]{r100, r101};
        }

        public static BdpLaunchSceneList[] values() {
            return (BdpLaunchSceneList[]) f242775a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static BdpLaunchSceneList valueOf(String r100) {
            return (BdpLaunchSceneList) a.a(BdpLaunchSceneList.class, r100);
        }

        public BdpLaunchSceneList(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static final enum BdpMetaConfig extends Enum<BdpMetaConfig> {
        public static final BdpMetaConfig MAIN_PROCESS_PREFETCH_KEY = null;
        public static final BdpMetaConfig URLS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BdpMetaConfig[] f242776a = null;
        private String name;

        static {
            BdpMetaConfig r100 = new BdpMetaConfig("MAIN_PROCESS_PREFETCH_KEY", 0, "main_process_prefetch");
            MAIN_PROCESS_PREFETCH_KEY = r100;
            BdpMetaConfig r101 = new BdpMetaConfig("URLS", 1, "urls");
            URLS = r101;
            f242776a = new BdpMetaConfig[]{r100, r101};
        }

        public static BdpMetaConfig[] values() {
            return (BdpMetaConfig[]) f242776a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static BdpMetaConfig valueOf(String r100) {
            return (BdpMetaConfig) a.a(BdpMetaConfig.class, r100);
        }

        public BdpMetaConfig(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static final enum BdpReenterTips extends Enum<BdpReenterTips> {
        public static final BdpReenterTips TMA = null;
        public static final BdpReenterTips TMG = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BdpReenterTips[] f242777a = null;
        private String name;

        static {
            BdpReenterTips r100 = new BdpReenterTips("TMA", 0, "tma");
            TMA = r100;
            BdpReenterTips r101 = new BdpReenterTips("TMG", 1, "tmg");
            TMG = r101;
            f242777a = new BdpReenterTips[]{r100, r101};
        }

        public static BdpReenterTips[] values() {
            return (BdpReenterTips[]) f242777a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static BdpReenterTips valueOf(String r100) {
            return (BdpReenterTips) a.a(BdpReenterTips.class, r100);
        }

        public BdpReenterTips(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static final enum BdpStartpagePrefetchConfig extends Enum<BdpStartpagePrefetchConfig> {
        public static final BdpStartpagePrefetchConfig ENABLE = null;
        public static final BdpStartpagePrefetchConfig MAX_CONCURRENT_COUNT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BdpStartpagePrefetchConfig[] f242778a = null;
        private String name;

        static {
            BdpStartpagePrefetchConfig r100 = new BdpStartpagePrefetchConfig("ENABLE", 0, "enable");
            ENABLE = r100;
            BdpStartpagePrefetchConfig r101 = new BdpStartpagePrefetchConfig("MAX_CONCURRENT_COUNT", 1, "max_concurrent_count");
            MAX_CONCURRENT_COUNT = r101;
            f242778a = new BdpStartpagePrefetchConfig[]{r100, r101};
        }

        public static BdpStartpagePrefetchConfig[] values() {
            return (BdpStartpagePrefetchConfig[]) f242778a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static BdpStartpagePrefetchConfig valueOf(String r100) {
            return (BdpStartpagePrefetchConfig) a.a(BdpStartpagePrefetchConfig.class, r100);
        }

        public BdpStartpagePrefetchConfig(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static final enum BdpTtPkgConfig extends Enum<BdpTtPkgConfig> {
        public static final BdpTtPkgConfig HOSTS_ADD_GZIP = null;
        public static final BdpTtPkgConfig NORMAL_LAUNCH_PKG_LIMIT = null;
        public static final BdpTtPkgConfig PKG_COMPRESS_DOWNGRADE = null;
        public static final BdpTtPkgConfig PRELOAD_MODE = null;
        public static final BdpTtPkgConfig PRELOAD_PKG_LIMIT = null;
        public static final BdpTtPkgConfig PRELOAD_REAL_CONTENT_LENGTH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BdpTtPkgConfig[] f242779a = null;
        private String name;

        static {
            BdpTtPkgConfig r100 = new BdpTtPkgConfig("PRELOAD_MODE", 0, "preload_mode");
            PRELOAD_MODE = r100;
            BdpTtPkgConfig r101 = new BdpTtPkgConfig("HOSTS_ADD_GZIP", 1, "hosts_add_gzip");
            HOSTS_ADD_GZIP = r101;
            BdpTtPkgConfig r102 = new BdpTtPkgConfig("PRELOAD_REAL_CONTENT_LENGTH", 2, SettingsConstants.PRELOAD_REAL_CONTENT_LENGTH);
            PRELOAD_REAL_CONTENT_LENGTH = r102;
            BdpTtPkgConfig r103 = new BdpTtPkgConfig("PKG_COMPRESS_DOWNGRADE", 3, "compress_downgrade");
            PKG_COMPRESS_DOWNGRADE = r103;
            BdpTtPkgConfig r104 = new BdpTtPkgConfig("PRELOAD_PKG_LIMIT", 4, SettingsConstants.PRELOAD_PKG_LIMIT);
            PRELOAD_PKG_LIMIT = r104;
            BdpTtPkgConfig r105 = new BdpTtPkgConfig("NORMAL_LAUNCH_PKG_LIMIT", 5, SettingsConstants.NORMAL_LAUNCH_PKG_LIMIT);
            NORMAL_LAUNCH_PKG_LIMIT = r105;
            f242779a = new BdpTtPkgConfig[]{r100, r101, r102, r103, r104, r105};
        }

        public static BdpTtPkgConfig[] values() {
            return (BdpTtPkgConfig[]) f242779a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static BdpTtPkgConfig valueOf(String r100) {
            return (BdpTtPkgConfig) a.a(BdpTtPkgConfig.class, r100);
        }

        public BdpTtPkgConfig(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static final enum BdpTtRequestConfig extends Enum<BdpTtRequestConfig> {
        public static final BdpTtRequestConfig REQUEST_TYPE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BdpTtRequestConfig[] f242780a = null;
        private String name;

        static {
            BdpTtRequestConfig r100 = new BdpTtRequestConfig();
            REQUEST_TYPE = r100;
            f242780a = new BdpTtRequestConfig[]{r100};
        }

        public BdpTtRequestConfig() {
            super("REQUEST_TYPE", 0);
            this.name = "request_type";
        }

        public static BdpTtRequestConfig[] values() {
            return (BdpTtRequestConfig[]) f242780a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static BdpTtRequestConfig valueOf(String r100) {
            return (BdpTtRequestConfig) a.a(BdpTtRequestConfig.class, r100);
        }
    }

    public static final enum TmaABTest extends Enum<TmaABTest> {
        public static final TmaABTest AUTHORIZE_LIST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TmaABTest[] f242781a = null;
        private String name;

        public static final enum AuthorizeList extends Enum<AuthorizeList> {
            public static final AuthorizeList DID = null;
            public static final AuthorizeList MP_ID = null;
            public static final AuthorizeList ON = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ AuthorizeList[] f242782a = null;
            private String name;

            static {
                AuthorizeList r100 = new AuthorizeList("ON", 0, "on");
                ON = r100;
                AuthorizeList r101 = new AuthorizeList("MP_ID", 1, "mpid");
                MP_ID = r101;
                AuthorizeList r102 = new AuthorizeList("DID", 2, com.bytedance.android.ec.core.event.a.KEY_DID);
                DID = r102;
                f242782a = new AuthorizeList[]{r100, r101, r102};
            }

            public static AuthorizeList[] values() {
                return (AuthorizeList[]) f242782a.clone();
            }

            @Override // java.lang.Enum
            public String toString() {
                return this.name;
            }

            public static AuthorizeList valueOf(String r100) {
                return (AuthorizeList) a.a(AuthorizeList.class, r100);
            }

            public AuthorizeList(String r100, int r101, String r102) {
                super(r100, r101);
                this.name = r102;
            }
        }

        static {
            TmaABTest r100 = new TmaABTest();
            AUTHORIZE_LIST = r100;
            f242781a = new TmaABTest[]{r100};
        }

        public TmaABTest() {
            super("AUTHORIZE_LIST", 0);
            this.name = "authorize_list";
        }

        public static TmaABTest[] values() {
            return (TmaABTest[]) f242781a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static TmaABTest valueOf(String r100) {
            return (TmaABTest) a.a(TmaABTest.class, r100);
        }
    }

    public static final enum TmaBlackList extends Enum<TmaBlackList> {
        public static final TmaBlackList DEVICE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TmaBlackList[] f242783a = null;
        private String name;

        public static final enum DeviceBlackList extends Enum<DeviceBlackList> {
            public static final DeviceBlackList TMA = null;
            public static final DeviceBlackList TMG = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ DeviceBlackList[] f242784a = null;
            private String name;

            static {
                DeviceBlackList r100 = new DeviceBlackList("TMA", 0, "tma");
                TMA = r100;
                DeviceBlackList r101 = new DeviceBlackList("TMG", 1, "tmg");
                TMG = r101;
                f242784a = new DeviceBlackList[]{r100, r101};
            }

            public static DeviceBlackList[] values() {
                return (DeviceBlackList[]) f242784a.clone();
            }

            @Override // java.lang.Enum
            public String toString() {
                return this.name;
            }

            public static DeviceBlackList valueOf(String r100) {
                return (DeviceBlackList) a.a(DeviceBlackList.class, r100);
            }

            public DeviceBlackList(String r100, int r101, String r102) {
                super(r100, r101);
                this.name = r102;
            }
        }

        static {
            TmaBlackList r100 = new TmaBlackList();
            DEVICE = r100;
            f242783a = new TmaBlackList[]{r100};
        }

        public TmaBlackList() {
            super(FeatureConfigInfo.DEVICE_FEATURE_TYPE_ID, 0);
            this.name = "device";
        }

        public static TmaBlackList[] values() {
            return (TmaBlackList[]) f242783a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static TmaBlackList valueOf(String r100) {
            return (TmaBlackList) a.a(TmaBlackList.class, r100);
        }
    }

    public static final enum TmaNativeUI extends Enum<TmaNativeUI> {
        public static final TmaNativeUI ENABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TmaNativeUI[] f242785a = null;
        private String name;

        static {
            TmaNativeUI r100 = new TmaNativeUI();
            ENABLE = r100;
            f242785a = new TmaNativeUI[]{r100};
        }

        public TmaNativeUI() {
            super("ENABLE", 0);
            this.name = "enable";
        }

        public static TmaNativeUI[] values() {
            return (TmaNativeUI[]) f242785a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static TmaNativeUI valueOf(String r100) {
            return (TmaNativeUI) a.a(TmaNativeUI.class, r100);
        }
    }

    public static final enum TmaSdkConfig extends Enum<TmaSdkConfig> {
        public static final TmaSdkConfig LATEST_SDK_URL = null;
        public static final TmaSdkConfig SDK_UPDATE_VERSION = null;
        public static final TmaSdkConfig SDK_VERSION = null;
        public static final TmaSdkConfig TMA_SWITCH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TmaSdkConfig[] f242786a = null;
        private String name;

        static {
            TmaSdkConfig r100 = new TmaSdkConfig("SDK_UPDATE_VERSION", 0, "sdkUpdateVersion");
            SDK_UPDATE_VERSION = r100;
            TmaSdkConfig r101 = new TmaSdkConfig("SDK_VERSION", 1, b.C);
            SDK_VERSION = r101;
            TmaSdkConfig r102 = new TmaSdkConfig("LATEST_SDK_URL", 2, "latestSDKUrl");
            LATEST_SDK_URL = r102;
            TmaSdkConfig r103 = new TmaSdkConfig("TMA_SWITCH", 3, "tmaSwitch");
            TMA_SWITCH = r103;
            f242786a = new TmaSdkConfig[]{r100, r101, r102, r103};
        }

        public static TmaSdkConfig[] values() {
            return (TmaSdkConfig[]) f242786a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static TmaSdkConfig valueOf(String r100) {
            return (TmaSdkConfig) a.a(TmaSdkConfig.class, r100);
        }

        public TmaSdkConfig(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static final enum TmaSwitch extends Enum<TmaSwitch> {
        public static final TmaSwitch BLOCK_JS_BRIDGE = null;
        public static final TmaSwitch BLOCK_JS_BRIDGE_API_LIST = null;
        public static final TmaSwitch BLOCK_WEB_BRIDGE = null;
        public static final TmaSwitch BLOCK_WEB_BRIDGE_API_LIST = null;
        public static final TmaSwitch DISABLE_META_READY = null;
        public static final TmaSwitch ENABLE_CODE_CACHE = null;
        public static final TmaSwitch FAVORITES = null;
        public static final TmaSwitch JS_RUNTIME_ERROR_REPORT_MAX_TIMES = null;
        public static final TmaSwitch LAUNCH_FLAG = null;
        public static final TmaSwitch MMKV_SWITCH = null;
        public static final TmaSwitch MORE_PANEL = null;
        public static final TmaSwitch PAGE_BLOCK = null;
        public static final TmaSwitch PRELOAD_WEBVIEW = null;
        public static final TmaSwitch TT_RENDER_IN_BROWSER = null;
        public static final TmaSwitch VIDEO_EFFECT_SWITCH = null;
        public static final TmaSwitch WEBVIEW_STREAM_DOWNGRADE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TmaSwitch[] f242787a = null;
        private String name;

        public static final enum Favorites extends Enum<Favorites> {
            public static final Favorites TMA = null;
            public static final Favorites TMG = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Favorites[] f242788a = null;
            private String name;

            static {
                Favorites r100 = new Favorites("TMA", 0, "tma");
                TMA = r100;
                Favorites r101 = new Favorites("TMG", 1, "tmg");
                TMG = r101;
                f242788a = new Favorites[]{r100, r101};
            }

            public static Favorites[] values() {
                return (Favorites[]) f242788a.clone();
            }

            @Override // java.lang.Enum
            public String toString() {
                return this.name;
            }

            public static Favorites valueOf(String r100) {
                return (Favorites) a.a(Favorites.class, r100);
            }

            public Favorites(String r100, int r101, String r102) {
                super(r100, r101);
                this.name = r102;
            }
        }

        static {
            TmaSwitch r100 = new TmaSwitch("PRELOAD_WEBVIEW", 0, "preloadWebview");
            PRELOAD_WEBVIEW = r100;
            TmaSwitch r101 = new TmaSwitch("MMKV_SWITCH", 1, "mkSwitch");
            MMKV_SWITCH = r101;
            TmaSwitch r102 = new TmaSwitch("LAUNCH_FLAG", 2, "launchFlag");
            LAUNCH_FLAG = r102;
            TmaSwitch r103 = new TmaSwitch("FAVORITES", 3, "favorites");
            FAVORITES = r103;
            TmaSwitch r104 = new TmaSwitch("WEBVIEW_STREAM_DOWNGRADE", 4, "webviewStreamDowngrade");
            WEBVIEW_STREAM_DOWNGRADE = r104;
            TmaSwitch r105 = new TmaSwitch("TT_RENDER_IN_BROWSER", 5, "tt_render_in_browser");
            TT_RENDER_IN_BROWSER = r105;
            TmaSwitch r110 = new TmaSwitch("MORE_PANEL", 6, "morePanel");
            MORE_PANEL = r110;
            TmaSwitch r111 = new TmaSwitch("VIDEO_EFFECT_SWITCH", 7, "videoEffectSwitch");
            VIDEO_EFFECT_SWITCH = r111;
            TmaSwitch r112 = new TmaSwitch("PAGE_BLOCK", 8, "pageBlock");
            PAGE_BLOCK = r112;
            TmaSwitch r113 = new TmaSwitch("BLOCK_JS_BRIDGE", 9, "blockJSBridge");
            BLOCK_JS_BRIDGE = r113;
            TmaSwitch r114 = new TmaSwitch("BLOCK_JS_BRIDGE_API_LIST", 10, "blockJSBridgeAPIList");
            BLOCK_JS_BRIDGE_API_LIST = r114;
            TmaSwitch r106 = new TmaSwitch("BLOCK_WEB_BRIDGE", 11, "blockWebBridge");
            BLOCK_WEB_BRIDGE = r106;
            TmaSwitch r107 = new TmaSwitch("BLOCK_WEB_BRIDGE_API_LIST", 12, "blockWebBridgeAPIList");
            BLOCK_WEB_BRIDGE_API_LIST = r107;
            TmaSwitch r108 = new TmaSwitch("JS_RUNTIME_ERROR_REPORT_MAX_TIMES", 13, "jsRuntimeErrorReportMaxTimes");
            JS_RUNTIME_ERROR_REPORT_MAX_TIMES = r108;
            TmaSwitch r109 = new TmaSwitch("DISABLE_META_READY", 14, "disableMetaReady");
            DISABLE_META_READY = r109;
            TmaSwitch r115 = new TmaSwitch("ENABLE_CODE_CACHE", 15, "enableCodeCache");
            ENABLE_CODE_CACHE = r115;
            f242787a = new TmaSwitch[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115};
        }

        public static TmaSwitch[] values() {
            return (TmaSwitch[]) f242787a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static TmaSwitch valueOf(String r100) {
            return (TmaSwitch) a.a(TmaSwitch.class, r100);
        }

        public TmaSwitch(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static final enum TmaVdomTest extends Enum<TmaVdomTest> {
        public static final TmaVdomTest ENABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TmaVdomTest[] f242789a = null;
        private String name;

        static {
            TmaVdomTest r100 = new TmaVdomTest();
            ENABLE = r100;
            f242789a = new TmaVdomTest[]{r100};
        }

        public TmaVdomTest() {
            super("ENABLE", 0);
            this.name = "enable";
        }

        public static TmaVdomTest[] values() {
            return (TmaVdomTest[]) f242789a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static TmaVdomTest valueOf(String r100) {
            return (TmaVdomTest) a.a(TmaVdomTest.class, r100);
        }
    }

    static {
        Settings r100 = new Settings("TMA_SDK_CONFIG", 0, "tt_tma_sdk_config");
        TMA_SDK_CONFIG = r100;
        Settings r101 = new Settings("TMA_REGION_CONFIG", 1, "tt_tma_region_config");
        TMA_REGION_CONFIG = r101;
        Settings r102 = new Settings("BDP_META_CONFIG", 2, SettingsConstants.BDP_META_CONFIG);
        BDP_META_CONFIG = r102;
        Settings r103 = new Settings("BDP_REENTER_TIPS", 3, "bdp_reenter_tips");
        BDP_REENTER_TIPS = r103;
        Settings r104 = new Settings("TT_TMA_SWITCH", 4, "tt_tma_switch");
        TT_TMA_SWITCH = r104;
        Settings r105 = new Settings("BDP_FAVORITES", 5, "bdp_favorites");
        BDP_FAVORITES = r105;
        Settings r110 = new Settings("TT_TMA_BLACKLIST", 6, "tt_tma_blacklist");
        TT_TMA_BLACKLIST = r110;
        Settings r111 = new Settings("BDP_OFFLINE_ZIP", 7, "bdp_offline_zip");
        BDP_OFFLINE_ZIP = r111;
        Settings r112 = new Settings("TT_TMA_ABTEST", 8, "tt_tma_abtest");
        TT_TMA_ABTEST = r112;
        Settings r113 = new Settings("BDP_TTPKG_CONFIG", 9, SettingsConstants.BDP_TTPKG_CONFIG);
        BDP_TTPKG_CONFIG = r113;
        Settings r114 = new Settings("BDP_MORE_GAME_CENTER", 10, "bdp_more_game_center");
        BDP_MORE_GAME_CENTER = r114;
        Settings r106 = new Settings("BDP_LAUNCH_APP_SCENE_LIST", 11, "bdp_launch_app_scene_list");
        BDP_LAUNCH_APP_SCENE_LIST = r106;
        Settings r107 = new Settings("BDP_TTREQUEST_CONFIG", 12, "bdp_ttrequest_config");
        BDP_TTREQUEST_CONFIG = r107;
        Settings r108 = new Settings("BDP_STARTPAGE_PREFETCH", 13, "bdp_startpage_prefetch");
        BDP_STARTPAGE_PREFETCH = r108;
        Settings r109 = new Settings("BDP_HELIUM_CONFIG", 14, "bdp_helium_config");
        BDP_HELIUM_CONFIG = r109;
        Settings r115 = new Settings("TT_TMA_NATIVE_UI", 15, "tma_native_ui_test");
        TT_TMA_NATIVE_UI = r115;
        Settings r116 = new Settings("TMA_VDOM_TEST", 16, "tma_vdom_test");
        TMA_VDOM_TEST = r116;
        Settings r117 = new Settings("BDP_ANTI_ADDICTION", 17, "bdp_anti_addiction");
        BDP_ANTI_ADDICTION = r117;
        Settings r118 = new Settings("SNAPSHOT", 18, "snapshot_config");
        SNAPSHOT = r118;
        Settings r119 = new Settings("PRE_RENDER", 19, "pre_render_config");
        PRE_RENDER = r119;
        Settings r120 = new Settings("BLOCK_SDK_CONFIG", 20, "tt_block_sdk_config");
        BLOCK_SDK_CONFIG = r120;
        Settings r121 = new Settings("LYNX_MESSAGE_CARD_SDK_CONFIG", 21, "tt_lynx_message_card_sdk_config");
        LYNX_MESSAGE_CARD_SDK_CONFIG = r121;
        f242774a = new Settings[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121};
    }

    public static Settings[] values() {
        return (Settings[]) f242774a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }

    public static Settings valueOf(String r100) {
        return (Settings) a.a(Settings.class, r100);
    }

    public Settings(String r100, int r101, String r102) {
        super(r100, r101);
        this.name = r102;
    }
}
