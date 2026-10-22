package com.bytedance.lynx.webview.internal;

/* JADX INFO: loaded from: classes21.dex */
public final enum LoadEventType extends Enum<LoadEventType> {
    public static final LoadEventType CheckSoVersion_has_cachesoVersionCode = null;
    public static final LoadEventType CheckSoVersion_not_old_soVersion = null;
    public static final LoadEventType CheckSwitch_enable_ttwebview = null;
    public static final LoadEventType CheckSwitch_enable_ttwebview_by_multiprocess_setting = null;
    public static final LoadEventType Default_Type = null;
    public static final LoadEventType DoCreateHookProvider_begin = null;
    public static final LoadEventType DoCreateHookProvider_initProvider_success = null;
    public static final LoadEventType DoCrossProcessInitialization_begin = null;
    public static final LoadEventType DoCrossProcessInitialization_load_ttwebview = null;
    public static final LoadEventType ErrorCheck_success = null;
    public static final LoadEventType InitProvider_addClasses_success = null;
    public static final LoadEventType InitProvider_checkGlueVersion_success = null;
    public static final LoadEventType LoadPreCheck_abi_enbale = null;
    public static final LoadEventType LoadPreCheck_decompress_md5_empty = null;
    public static final LoadEventType LoadPreCheck_dex_compiled = null;
    public static final LoadEventType LoadPreCheck_first_download = null;
    public static final LoadEventType LoadPreCheck_hostabi_enable = null;
    public static final LoadEventType LoadPreCheck_integrity_check = null;
    public static final LoadEventType LoadPreCheck_md5_not_empty = null;
    public static final LoadEventType LoadPreCheck_not_first_download = null;
    public static final LoadEventType LoadPreCheck_not_support_core = null;
    public static final LoadEventType LoadPreCheck_rs_kernel = null;
    public static final LoadEventType LoadPreCheck_soVersion_suited = null;
    public static final LoadEventType LoadPreCheck_so_exits = null;
    public static final LoadEventType LoadPreCheck_so_runtime_environment = null;
    public static final LoadEventType LoadPreCheck_switch_enable = null;
    public static final LoadEventType OnLoad_Success = null;
    public static final LoadEventType StartImpl_begin = null;
    public static String[] SuccessStatus;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadEventType[] f265156a = null;
    private int StatusCode;

    static {
        LoadEventType r100 = new LoadEventType("StartImpl_begin", 0, 1);
        StartImpl_begin = r100;
        LoadEventType r101 = new LoadEventType("DoCrossProcessInitialization_begin", 1, 2);
        DoCrossProcessInitialization_begin = r101;
        LoadEventType r102 = new LoadEventType("LoadPreCheck_abi_enbale", 2, 3);
        LoadPreCheck_abi_enbale = r102;
        LoadEventType r103 = new LoadEventType("CheckSwitch_enable_ttwebview", 3, 4);
        CheckSwitch_enable_ttwebview = r103;
        LoadEventType r104 = new LoadEventType("LoadPreCheck_switch_enable", 4, 5);
        LoadPreCheck_switch_enable = r104;
        LoadEventType r110 = new LoadEventType("CheckSwitch_enable_ttwebview_by_multiprocess_setting", 5, 6);
        CheckSwitch_enable_ttwebview_by_multiprocess_setting = r110;
        LoadEventType r111 = new LoadEventType("CheckSoVersion_has_cachesoVersionCode", 6, 100);
        CheckSoVersion_has_cachesoVersionCode = r111;
        LoadEventType r112 = new LoadEventType("CheckSoVersion_not_old_soVersion", 7, 101);
        CheckSoVersion_not_old_soVersion = r112;
        LoadEventType r113 = new LoadEventType("LoadPreCheck_soVersion_suited", 8, 102);
        LoadPreCheck_soVersion_suited = r113;
        LoadEventType r114 = new LoadEventType("LoadPreCheck_decompress_md5_empty", 9, 103);
        LoadPreCheck_decompress_md5_empty = r114;
        LoadEventType r105 = new LoadEventType("LoadPreCheck_md5_not_empty", 10, 104);
        LoadPreCheck_md5_not_empty = r105;
        LoadEventType r106 = new LoadEventType("LoadPreCheck_not_first_download", 11, 105);
        LoadPreCheck_not_first_download = r106;
        LoadEventType r107 = new LoadEventType("LoadPreCheck_first_download", 12, 106);
        LoadPreCheck_first_download = r107;
        LoadEventType r108 = new LoadEventType("LoadPreCheck_so_exits", 13, 107);
        LoadPreCheck_so_exits = r108;
        LoadEventType r109 = new LoadEventType("LoadPreCheck_not_support_core", 14, 108);
        LoadPreCheck_not_support_core = r109;
        LoadEventType r115 = new LoadEventType("LoadPreCheck_hostabi_enable", 15, 109);
        LoadPreCheck_hostabi_enable = r115;
        LoadEventType r116 = new LoadEventType("LoadPreCheck_dex_compiled", 16, 110);
        LoadPreCheck_dex_compiled = r116;
        LoadEventType r117 = new LoadEventType("LoadPreCheck_rs_kernel", 17, 111);
        LoadPreCheck_rs_kernel = r117;
        LoadEventType r118 = new LoadEventType("LoadPreCheck_so_runtime_environment", 18, 112);
        LoadPreCheck_so_runtime_environment = r118;
        LoadEventType r119 = new LoadEventType("LoadPreCheck_integrity_check", 19, 113);
        LoadPreCheck_integrity_check = r119;
        LoadEventType r120 = new LoadEventType("ErrorCheck_success", 20, 120);
        ErrorCheck_success = r120;
        LoadEventType r121 = new LoadEventType("DoCrossProcessInitialization_load_ttwebview", 21, 200);
        DoCrossProcessInitialization_load_ttwebview = r121;
        LoadEventType r122 = new LoadEventType("DoCreateHookProvider_begin", 22, 201);
        DoCreateHookProvider_begin = r122;
        LoadEventType r123 = new LoadEventType("InitProvider_addClasses_success", 23, 202);
        InitProvider_addClasses_success = r123;
        LoadEventType r124 = new LoadEventType("InitProvider_checkGlueVersion_success", 24, 203);
        InitProvider_checkGlueVersion_success = r124;
        LoadEventType r125 = new LoadEventType("DoCreateHookProvider_initProvider_success", 25, 204);
        DoCreateHookProvider_initProvider_success = r125;
        LoadEventType r126 = new LoadEventType("OnLoad_Success", 26, 999);
        OnLoad_Success = r126;
        LoadEventType r127 = new LoadEventType("Default_Type", 27, -1);
        Default_Type = r127;
        f265156a = new LoadEventType[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r105, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
        SuccessStatus = new String[]{"DoCreateHookProvider_initProvider_success"};
    }

    public static LoadEventType[] values() {
        return (LoadEventType[]) f265156a.clone();
    }

    public int getStatusCode() {
        return this.StatusCode;
    }

    public static LoadEventType getLoadEventType(int r100) {
        LoadEventType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LoadEventType r104 = r101[r103];
        if (r104.getStatusCode() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static LoadEventType getLoadEventTypeByIndex(int r100) {
        LoadEventType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LoadEventType r104 = r101[r103];
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

    public static LoadEventType valueOf(String r100) {
        return (LoadEventType) r27.a.a(LoadEventType.class, r100);
    }

    public LoadEventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.StatusCode = r102;
    }
}
