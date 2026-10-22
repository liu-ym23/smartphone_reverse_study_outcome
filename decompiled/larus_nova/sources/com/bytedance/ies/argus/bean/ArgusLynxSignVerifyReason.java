package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b#\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*¨\u0006+"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusLynxSignVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "TASM_SIGN_FAIL", "NO_CONFIG", "UN_KNOWN", "URL_DEGRADE_FAILED", "DISABLE_GLOBAL_SIGN", "TASM_PARSE_FAILED", "FORCE_USE_URL_VERIFY_FAILED", "FORBID_FE_PAGE_LOAD_SOURCE", "URL_DEGRADE_CONTAINS_PATH_TRAVERSAL", "LEGACY_CHECK_SIGN_ERROR", "FE_INJECT_SEC_CID_BUT_NOT_MATCH", "FORCE_DISABLE_ALL_LYNX_LOAD", "FORBIDDEN_VERIFY_URL_LOAD", "FORBID_FE_PAGE_LOAD_SOURCE_NO_VIEW", "READ_BLOCK_FAILED", "SIGN_SUCCESS", "URL_DEGRADE_SUCCESS", "NOT_VERIFY_UNSIGNED_FILE", "VERIFY_ONLY_NO_CONFIG", "CONTAINER_DISABLE_SIGN", "FE_PAGE_LOAD_LIMIT_SOURCE_PASS_NOT_MAIN_TEMPLATE", "FE_PAGE_LOAD_LIMIT_SOURCE_PASS", "FE_INJECT_SEC_CID_AND_PASS_VERIFY", "LOGIC_ERROR", "FORCE_USE_URL_VERIFY_SUCCESS", "USE_DEGRAED_BUT_WHITE_LIST_IS_NULL", "TS_VERIFY_PARAMS_IS_NULL", "FE_PAGE_LOAD_LIMIT_SOURCE_ABNORMAL_PASS_NO_VIEW", "FE_INJECT_SEC_CID_BUT_NO_STRATEGY_CONFIG", "FE_INJECT_SEC_CID_BUT_ARGUS_CID_IS_NULL", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusLynxSignVerifyReason extends Enum<ArgusLynxSignVerifyReason> implements o {
    public static final ArgusLynxSignVerifyReason CONTAINER_DISABLE_SIGN = null;
    public static final ArgusLynxSignVerifyReason DISABLE_GLOBAL_SIGN = null;
    public static final ArgusLynxSignVerifyReason FE_INJECT_SEC_CID_AND_PASS_VERIFY = null;
    public static final ArgusLynxSignVerifyReason FE_INJECT_SEC_CID_BUT_ARGUS_CID_IS_NULL = null;
    public static final ArgusLynxSignVerifyReason FE_INJECT_SEC_CID_BUT_NOT_MATCH = null;
    public static final ArgusLynxSignVerifyReason FE_INJECT_SEC_CID_BUT_NO_STRATEGY_CONFIG = null;
    public static final ArgusLynxSignVerifyReason FE_PAGE_LOAD_LIMIT_SOURCE_ABNORMAL_PASS_NO_VIEW = null;
    public static final ArgusLynxSignVerifyReason FE_PAGE_LOAD_LIMIT_SOURCE_PASS = null;
    public static final ArgusLynxSignVerifyReason FE_PAGE_LOAD_LIMIT_SOURCE_PASS_NOT_MAIN_TEMPLATE = null;
    public static final ArgusLynxSignVerifyReason FORBIDDEN_VERIFY_URL_LOAD = null;
    public static final ArgusLynxSignVerifyReason FORBID_FE_PAGE_LOAD_SOURCE = null;
    public static final ArgusLynxSignVerifyReason FORBID_FE_PAGE_LOAD_SOURCE_NO_VIEW = null;
    public static final ArgusLynxSignVerifyReason FORCE_DISABLE_ALL_LYNX_LOAD = null;
    public static final ArgusLynxSignVerifyReason FORCE_USE_URL_VERIFY_FAILED = null;
    public static final ArgusLynxSignVerifyReason FORCE_USE_URL_VERIFY_SUCCESS = null;
    public static final ArgusLynxSignVerifyReason LEGACY_CHECK_SIGN_ERROR = null;
    public static final ArgusLynxSignVerifyReason LOGIC_ERROR = null;
    public static final ArgusLynxSignVerifyReason NOT_VERIFY_UNSIGNED_FILE = null;
    public static final ArgusLynxSignVerifyReason NO_CONFIG = null;
    public static final ArgusLynxSignVerifyReason READ_BLOCK_FAILED = null;
    public static final ArgusLynxSignVerifyReason SIGN_SUCCESS = null;
    public static final ArgusLynxSignVerifyReason TASM_PARSE_FAILED = null;
    public static final ArgusLynxSignVerifyReason TASM_SIGN_FAIL = null;
    public static final ArgusLynxSignVerifyReason TS_VERIFY_PARAMS_IS_NULL = null;
    public static final ArgusLynxSignVerifyReason UN_KNOWN = null;
    public static final ArgusLynxSignVerifyReason URL_DEGRADE_CONTAINS_PATH_TRAVERSAL = null;
    public static final ArgusLynxSignVerifyReason URL_DEGRADE_FAILED = null;
    public static final ArgusLynxSignVerifyReason URL_DEGRADE_SUCCESS = null;
    public static final ArgusLynxSignVerifyReason USE_DEGRAED_BUT_WHITE_LIST_IS_NULL = null;
    public static final ArgusLynxSignVerifyReason VERIFY_ONLY_NO_CONFIG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusLynxSignVerifyReason[] f245963a = null;
    private final int code;
    private final String strValue;

    public static ArgusLynxSignVerifyReason valueOf(String r100) {
        return (ArgusLynxSignVerifyReason) r27.a.a(ArgusLynxSignVerifyReason.class, r100);
    }

    public static ArgusLynxSignVerifyReason[] values() {
        return (ArgusLynxSignVerifyReason[]) f245963a.clone();
    }

    static {
        ArgusLynxSignVerifyReason r100 = new ArgusLynxSignVerifyReason("TASM_SIGN_FAIL", 0, -1, "lynx sign verify failed");
        TASM_SIGN_FAIL = r100;
        ArgusLynxSignVerifyReason r101 = new ArgusLynxSignVerifyReason("NO_CONFIG", 1, -2, "no fe public key");
        NO_CONFIG = r101;
        ArgusLynxSignVerifyReason r102 = new ArgusLynxSignVerifyReason("UN_KNOWN", 2, -3, "unknown");
        UN_KNOWN = r102;
        ArgusLynxSignVerifyReason r103 = new ArgusLynxSignVerifyReason("URL_DEGRADE_FAILED", 3, -4, "url degrade failed");
        URL_DEGRADE_FAILED = r103;
        ArgusLynxSignVerifyReason r104 = new ArgusLynxSignVerifyReason("DISABLE_GLOBAL_SIGN", 4, -5, "disable global sign");
        DISABLE_GLOBAL_SIGN = r104;
        ArgusLynxSignVerifyReason r105 = new ArgusLynxSignVerifyReason("TASM_PARSE_FAILED", 5, -6, "parse tasm failed");
        TASM_PARSE_FAILED = r105;
        ArgusLynxSignVerifyReason r106 = new ArgusLynxSignVerifyReason("FORCE_USE_URL_VERIFY_FAILED", 6, -7, "force use url verify failed");
        FORCE_USE_URL_VERIFY_FAILED = r106;
        ArgusLynxSignVerifyReason r110 = new ArgusLynxSignVerifyReason("FORBID_FE_PAGE_LOAD_SOURCE", 7, -10, "fe enable load source verify but not match");
        FORBID_FE_PAGE_LOAD_SOURCE = r110;
        ArgusLynxSignVerifyReason r107 = new ArgusLynxSignVerifyReason("URL_DEGRADE_CONTAINS_PATH_TRAVERSAL", 8, -11, "url degrade contains path traversal");
        URL_DEGRADE_CONTAINS_PATH_TRAVERSAL = r107;
        ArgusLynxSignVerifyReason r111 = new ArgusLynxSignVerifyReason("LEGACY_CHECK_SIGN_ERROR", 9, -12, "legacy check sign error");
        LEGACY_CHECK_SIGN_ERROR = r111;
        ArgusLynxSignVerifyReason r112 = new ArgusLynxSignVerifyReason("FE_INJECT_SEC_CID_BUT_NOT_MATCH", 10, -12, "fe inject sec cid but not match");
        FE_INJECT_SEC_CID_BUT_NOT_MATCH = r112;
        ArgusLynxSignVerifyReason r113 = new ArgusLynxSignVerifyReason("FORCE_DISABLE_ALL_LYNX_LOAD", 11, -13, "force disable all lynx load");
        FORCE_DISABLE_ALL_LYNX_LOAD = r113;
        ArgusLynxSignVerifyReason r108 = new ArgusLynxSignVerifyReason("FORBIDDEN_VERIFY_URL_LOAD", 12, -14, "verify url is forbidden load");
        FORBIDDEN_VERIFY_URL_LOAD = r108;
        ArgusLynxSignVerifyReason r109 = new ArgusLynxSignVerifyReason("FORBID_FE_PAGE_LOAD_SOURCE_NO_VIEW", 13, -15, "fe enable load source verify but no view, block for fail-close");
        FORBID_FE_PAGE_LOAD_SOURCE_NO_VIEW = r109;
        ArgusLynxSignVerifyReason r114 = new ArgusLynxSignVerifyReason("READ_BLOCK_FAILED", 14, -16, "read block failed");
        READ_BLOCK_FAILED = r114;
        ArgusLynxSignVerifyReason r115 = new ArgusLynxSignVerifyReason("SIGN_SUCCESS", 15, 1, "sign success");
        SIGN_SUCCESS = r115;
        ArgusLynxSignVerifyReason r116 = new ArgusLynxSignVerifyReason("URL_DEGRADE_SUCCESS", 16, 2, "url degrade success");
        URL_DEGRADE_SUCCESS = r116;
        ArgusLynxSignVerifyReason r117 = new ArgusLynxSignVerifyReason("NOT_VERIFY_UNSIGNED_FILE", 17, 3, "not verify unsigned failed");
        NOT_VERIFY_UNSIGNED_FILE = r117;
        ArgusLynxSignVerifyReason r118 = new ArgusLynxSignVerifyReason("VERIFY_ONLY_NO_CONFIG", 18, 4, "mode is verify only, no config");
        VERIFY_ONLY_NO_CONFIG = r118;
        ArgusLynxSignVerifyReason r119 = new ArgusLynxSignVerifyReason("CONTAINER_DISABLE_SIGN", 19, 5, "container disable sign");
        CONTAINER_DISABLE_SIGN = r119;
        ArgusLynxSignVerifyReason r120 = new ArgusLynxSignVerifyReason("FE_PAGE_LOAD_LIMIT_SOURCE_PASS_NOT_MAIN_TEMPLATE", 20, 7, "fe enable load source verify, pass because not main template");
        FE_PAGE_LOAD_LIMIT_SOURCE_PASS_NOT_MAIN_TEMPLATE = r120;
        ArgusLynxSignVerifyReason r121 = new ArgusLynxSignVerifyReason("FE_PAGE_LOAD_LIMIT_SOURCE_PASS", 21, 8, "fe enable load source verify and pass");
        FE_PAGE_LOAD_LIMIT_SOURCE_PASS = r121;
        ArgusLynxSignVerifyReason r122 = new ArgusLynxSignVerifyReason("FE_INJECT_SEC_CID_AND_PASS_VERIFY", 22, 10, "fe inject sec cid and pass verify");
        FE_INJECT_SEC_CID_AND_PASS_VERIFY = r122;
        ArgusLynxSignVerifyReason r123 = new ArgusLynxSignVerifyReason("LOGIC_ERROR", 23, 102, "logic error");
        LOGIC_ERROR = r123;
        ArgusLynxSignVerifyReason r124 = new ArgusLynxSignVerifyReason("FORCE_USE_URL_VERIFY_SUCCESS", 24, 104, "force use url verify success");
        FORCE_USE_URL_VERIFY_SUCCESS = r124;
        ArgusLynxSignVerifyReason r125 = new ArgusLynxSignVerifyReason("USE_DEGRAED_BUT_WHITE_LIST_IS_NULL", 25, 105, "use degrade but white list is null");
        USE_DEGRAED_BUT_WHITE_LIST_IS_NULL = r125;
        ArgusLynxSignVerifyReason r126 = new ArgusLynxSignVerifyReason("TS_VERIFY_PARAMS_IS_NULL", 26, 107, "ts verify param is null");
        TS_VERIFY_PARAMS_IS_NULL = r126;
        ArgusLynxSignVerifyReason r127 = new ArgusLynxSignVerifyReason("FE_PAGE_LOAD_LIMIT_SOURCE_ABNORMAL_PASS_NO_VIEW", 27, 108, "fe enable load source verify, pass because no view");
        FE_PAGE_LOAD_LIMIT_SOURCE_ABNORMAL_PASS_NO_VIEW = r127;
        ArgusLynxSignVerifyReason r128 = new ArgusLynxSignVerifyReason("FE_INJECT_SEC_CID_BUT_NO_STRATEGY_CONFIG", 28, 109, "fe inject sec cid but no strategy config");
        FE_INJECT_SEC_CID_BUT_NO_STRATEGY_CONFIG = r128;
        ArgusLynxSignVerifyReason r129 = new ArgusLynxSignVerifyReason("FE_INJECT_SEC_CID_BUT_ARGUS_CID_IS_NULL", 29, 110, "fe inject sec cid but argus cid is null");
        FE_INJECT_SEC_CID_BUT_ARGUS_CID_IS_NULL = r129;
        f245963a = new ArgusLynxSignVerifyReason[]{r100, r101, r102, r103, r104, r105, r106, r110, r107, r111, r112, r113, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusLynxSignVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
