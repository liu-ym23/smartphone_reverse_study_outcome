package com.bytedance.lynx.webview.internal;

/* JADX INFO: loaded from: classes21.dex */
public final enum DownloadEventType extends Enum<DownloadEventType> {
    public static final DownloadEventType Decompress_has_vPair = null;
    public static final DownloadEventType Decompress_prepareAssets_success = null;
    public static final DownloadEventType Decompress_right_md5 = null;
    public static final DownloadEventType Decompress_right_signData = null;
    public static final DownloadEventType Decompress_success = null;
    public static final DownloadEventType DoPrepare_begin = null;
    public static final DownloadEventType DoPrepare_finish_not_exists = null;
    public static final DownloadEventType DoPrepare_getSo_success = null;
    public static final DownloadEventType DownloadByBreakResume_first = null;
    public static final DownloadEventType DownloadByBreakResume_not_first = null;
    public static final DownloadEventType HasDownloadEnv_memory_enable = null;
    public static final DownloadEventType HasDownloadEnv_wifi_enable = null;
    public static final DownloadEventType InitDownload_getLength = null;
    public static final DownloadEventType InitSetting_download_begin = null;
    public static final DownloadEventType InitSetting_has_appInfo = null;
    public static final DownloadEventType InitSetting_has_miniappInfo = null;
    public static final DownloadEventType InitSetting_setting_not_empty = null;
    public static final DownloadEventType OnConfigLoaded_is_valid = null;
    public static final DownloadEventType OnSuccess_begin = null;
    public static final DownloadEventType PrepareAssetsApks_unzip_libwebviewresso = null;
    public static final DownloadEventType PrepareAssetsApks_unzip_libwebviewso = null;
    public static final DownloadEventType PrepareAssetsApks_unzip_webviewutilso = null;
    public static final DownloadEventType PrepareAsync_prepare_finish = null;
    public static final DownloadEventType PrepareByDownload_end = null;
    public static final DownloadEventType PrepareByDownload_start = null;
    public static final DownloadEventType PrepareFromAssets_begin = null;
    public static final DownloadEventType PrepareFromDataDir_begin = null;
    public static final DownloadEventType PrepareFromDebugPath_begin = null;
    public static final DownloadEventType PrepareFromSharedDir_begin = null;
    public static final DownloadEventType Prepare_abi_enable = null;
    public static final DownloadEventType Prepare_download_end = null;
    public static final DownloadEventType Prepare_prepare_once = null;
    public static final DownloadEventType Prepare_prepare_start = null;
    public static String[] SuccessStatus;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DownloadEventType[] f265112a = null;
    private int StatusCode;

    static {
        DownloadEventType r100 = new DownloadEventType("InitSetting_download_begin", 0, 1);
        InitSetting_download_begin = r100;
        DownloadEventType r101 = new DownloadEventType("InitSetting_has_appInfo", 1, 2);
        InitSetting_has_appInfo = r101;
        DownloadEventType r102 = new DownloadEventType("InitSetting_has_miniappInfo", 2, 3);
        InitSetting_has_miniappInfo = r102;
        DownloadEventType r103 = new DownloadEventType("InitSetting_setting_not_empty", 3, 4);
        InitSetting_setting_not_empty = r103;
        DownloadEventType r104 = new DownloadEventType("OnSuccess_begin", 4, 5);
        OnSuccess_begin = r104;
        DownloadEventType r105 = new DownloadEventType("OnConfigLoaded_is_valid", 5, 6);
        OnConfigLoaded_is_valid = r105;
        DownloadEventType r110 = new DownloadEventType("PrepareAsync_prepare_finish", 6, 200);
        PrepareAsync_prepare_finish = r110;
        DownloadEventType r111 = new DownloadEventType("Prepare_prepare_start", 7, 201);
        Prepare_prepare_start = r111;
        DownloadEventType r112 = new DownloadEventType("Prepare_abi_enable", 8, 7);
        Prepare_abi_enable = r112;
        DownloadEventType r113 = new DownloadEventType("Prepare_prepare_once", 9, 8);
        Prepare_prepare_once = r113;
        DownloadEventType r114 = new DownloadEventType("DoPrepare_begin", 10, 101);
        DoPrepare_begin = r114;
        DownloadEventType r106 = new DownloadEventType("DoPrepare_finish_not_exists", 11, 9);
        DoPrepare_finish_not_exists = r106;
        DownloadEventType r115 = new DownloadEventType("PrepareFromDebugPath_begin", 12, 10);
        PrepareFromDebugPath_begin = r115;
        DownloadEventType r107 = new DownloadEventType("PrepareFromAssets_begin", 13, 11);
        PrepareFromAssets_begin = r107;
        DownloadEventType r108 = new DownloadEventType("PrepareFromDataDir_begin", 14, 12);
        PrepareFromDataDir_begin = r108;
        DownloadEventType r109 = new DownloadEventType("PrepareFromSharedDir_begin", 15, 13);
        PrepareFromSharedDir_begin = r109;
        DownloadEventType r116 = new DownloadEventType("HasDownloadEnv_wifi_enable", 16, 14);
        HasDownloadEnv_wifi_enable = r116;
        DownloadEventType r117 = new DownloadEventType("HasDownloadEnv_memory_enable", 17, 15);
        HasDownloadEnv_memory_enable = r117;
        DownloadEventType r118 = new DownloadEventType("PrepareByDownload_start", 18, 16);
        PrepareByDownload_start = r118;
        DownloadEventType r119 = new DownloadEventType("DownloadByBreakResume_not_first", 19, 17);
        DownloadByBreakResume_not_first = r119;
        DownloadEventType r120 = new DownloadEventType("DownloadByBreakResume_first", 20, 18);
        DownloadByBreakResume_first = r120;
        DownloadEventType r121 = new DownloadEventType("InitDownload_getLength", 21, 19);
        InitDownload_getLength = r121;
        DownloadEventType r122 = new DownloadEventType("PrepareByDownload_end", 22, 20);
        PrepareByDownload_end = r122;
        DownloadEventType r123 = new DownloadEventType("Decompress_has_vPair", 23, 21);
        Decompress_has_vPair = r123;
        DownloadEventType r124 = new DownloadEventType("Decompress_right_signData", 24, 22);
        Decompress_right_signData = r124;
        DownloadEventType r125 = new DownloadEventType("Decompress_right_md5", 25, 23);
        Decompress_right_md5 = r125;
        DownloadEventType r126 = new DownloadEventType("PrepareAssetsApks_unzip_webviewutilso", 26, 24);
        PrepareAssetsApks_unzip_webviewutilso = r126;
        DownloadEventType r127 = new DownloadEventType("PrepareAssetsApks_unzip_libwebviewso", 27, 25);
        PrepareAssetsApks_unzip_libwebviewso = r127;
        DownloadEventType r128 = new DownloadEventType("PrepareAssetsApks_unzip_libwebviewresso", 28, 26);
        PrepareAssetsApks_unzip_libwebviewresso = r128;
        DownloadEventType r129 = new DownloadEventType("Decompress_prepareAssets_success", 29, 27);
        Decompress_prepareAssets_success = r129;
        DownloadEventType r130 = new DownloadEventType("Decompress_success", 30, 28);
        Decompress_success = r130;
        DownloadEventType r131 = new DownloadEventType("DoPrepare_getSo_success", 31, 29);
        DoPrepare_getSo_success = r131;
        DownloadEventType r132 = new DownloadEventType("Prepare_download_end", 32, 999);
        Prepare_download_end = r132;
        f265112a = new DownloadEventType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r115, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132};
        SuccessStatus = new String[]{"DoPrepare_getSo_success", "Prepare_download_end", "DoPrepare_begin"};
    }

    public static DownloadEventType[] values() {
        return (DownloadEventType[]) f265112a.clone();
    }

    public int getStatusCode() {
        return this.StatusCode;
    }

    public static DownloadEventType getDownloadEventType(int r100) {
        DownloadEventType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        DownloadEventType r104 = r101[r103];
        if (r104.getStatusCode() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static DownloadEventType getDownloadEventTypeByIndex(int r100) {
        DownloadEventType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        DownloadEventType r104 = r101[r103];
        if (r104.ordinal() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static boolean isSucessStatus(String r100) {
        String[] r101 = SuccessStatus;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r100.equals(r101[r103]) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static DownloadEventType valueOf(String r100) {
        return (DownloadEventType) r27.a.a(DownloadEventType.class, r100);
    }

    public DownloadEventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.StatusCode = r102;
    }
}
