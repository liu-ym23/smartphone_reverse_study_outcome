package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b!\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusCommonVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "REWRITE_BY_EXTERN_SERVICE", "BLOCK_BY_EXTERN_SERVICE", "BLOCK_BY_SEC_LINK_HANDLE", "UN_SET", "ASYNC_PASS_FIRST", "PASS_STRATEGY_CALCULATE", "PASS_BY_SEC_LINK_HANDLE", "SEC_LINK_STRATEGY_IS_NULL", "NO_AUTH_PACKAGE", "TTM_IS_NOT_ENABLED", "TTM_RULE_NAME_IS_NULL", "TTM_RULE_VERSION_IS_NULL", "TTM_RULE_INFO_IS_NULL", "TTM_RULE_ADDRESS_IS_NULL", "RUN_TTM_ERROR", "MISMATCH_PARAMS_TYPE", "TRY_CATCH_ERROR", "STRATEGY_RULE_NAME_IS_NULL", "ASPECT_CONFIG_IS_NULL", "CLIENT_STRATEGY_PROVIDER_NOT_FOUND", "STRATEGY_RULE_LIST_IS_EMPTY", "ASPECT_IS_REPORT_ONLY", "ASPECT_IS_OFF", "ASPECT_DISABLE_BY_RECOVERY", "TTM_STRATEGY_PROVIDER_NOT_FOUND", "STRATEGY_CONFIG_IS_NULL", "STRATEGY_DISABLE_BY_RECOVERY", "DISABLE_IN_DEBUG_ENV", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusCommonVerifyReason extends Enum<ArgusCommonVerifyReason> implements o {
    public static final ArgusCommonVerifyReason ASPECT_CONFIG_IS_NULL = null;
    public static final ArgusCommonVerifyReason ASPECT_DISABLE_BY_RECOVERY = null;
    public static final ArgusCommonVerifyReason ASPECT_IS_OFF = null;
    public static final ArgusCommonVerifyReason ASPECT_IS_REPORT_ONLY = null;
    public static final ArgusCommonVerifyReason ASYNC_PASS_FIRST = null;
    public static final ArgusCommonVerifyReason BLOCK_BY_EXTERN_SERVICE = null;
    public static final ArgusCommonVerifyReason BLOCK_BY_SEC_LINK_HANDLE = null;
    public static final ArgusCommonVerifyReason CLIENT_STRATEGY_PROVIDER_NOT_FOUND = null;
    public static final ArgusCommonVerifyReason DISABLE_IN_DEBUG_ENV = null;
    public static final ArgusCommonVerifyReason MISMATCH_PARAMS_TYPE = null;
    public static final ArgusCommonVerifyReason NO_AUTH_PACKAGE = null;
    public static final ArgusCommonVerifyReason PASS_BY_SEC_LINK_HANDLE = null;
    public static final ArgusCommonVerifyReason PASS_STRATEGY_CALCULATE = null;
    public static final ArgusCommonVerifyReason REWRITE_BY_EXTERN_SERVICE = null;
    public static final ArgusCommonVerifyReason RUN_TTM_ERROR = null;
    public static final ArgusCommonVerifyReason SEC_LINK_STRATEGY_IS_NULL = null;
    public static final ArgusCommonVerifyReason STRATEGY_CONFIG_IS_NULL = null;
    public static final ArgusCommonVerifyReason STRATEGY_DISABLE_BY_RECOVERY = null;
    public static final ArgusCommonVerifyReason STRATEGY_RULE_LIST_IS_EMPTY = null;
    public static final ArgusCommonVerifyReason STRATEGY_RULE_NAME_IS_NULL = null;
    public static final ArgusCommonVerifyReason TRY_CATCH_ERROR = null;
    public static final ArgusCommonVerifyReason TTM_IS_NOT_ENABLED = null;
    public static final ArgusCommonVerifyReason TTM_RULE_ADDRESS_IS_NULL = null;
    public static final ArgusCommonVerifyReason TTM_RULE_INFO_IS_NULL = null;
    public static final ArgusCommonVerifyReason TTM_RULE_NAME_IS_NULL = null;
    public static final ArgusCommonVerifyReason TTM_RULE_VERSION_IS_NULL = null;
    public static final ArgusCommonVerifyReason TTM_STRATEGY_PROVIDER_NOT_FOUND = null;
    public static final ArgusCommonVerifyReason UN_SET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusCommonVerifyReason[] f245952a = null;
    private final int code;
    private final String strValue;

    public static ArgusCommonVerifyReason valueOf(String r100) {
        return (ArgusCommonVerifyReason) r27.a.a(ArgusCommonVerifyReason.class, r100);
    }

    public static ArgusCommonVerifyReason[] values() {
        return (ArgusCommonVerifyReason[]) f245952a.clone();
    }

    static {
        ArgusCommonVerifyReason r100 = new ArgusCommonVerifyReason("REWRITE_BY_EXTERN_SERVICE", 0, -3, "rewrite by extern service");
        REWRITE_BY_EXTERN_SERVICE = r100;
        ArgusCommonVerifyReason r101 = new ArgusCommonVerifyReason("BLOCK_BY_EXTERN_SERVICE", 1, -2, "block by extern service");
        BLOCK_BY_EXTERN_SERVICE = r101;
        ArgusCommonVerifyReason r102 = new ArgusCommonVerifyReason("BLOCK_BY_SEC_LINK_HANDLE", 2, -1, "block handle by secLink strategy");
        BLOCK_BY_SEC_LINK_HANDLE = r102;
        ArgusCommonVerifyReason r103 = new ArgusCommonVerifyReason("UN_SET", 3, 0, "unset");
        UN_SET = r103;
        ArgusCommonVerifyReason r104 = new ArgusCommonVerifyReason("ASYNC_PASS_FIRST", 4, 1, "async pass first");
        ASYNC_PASS_FIRST = r104;
        ArgusCommonVerifyReason r105 = new ArgusCommonVerifyReason("PASS_STRATEGY_CALCULATE", 5, 2, "pass calculate");
        PASS_STRATEGY_CALCULATE = r105;
        ArgusCommonVerifyReason r110 = new ArgusCommonVerifyReason("PASS_BY_SEC_LINK_HANDLE", 6, 3, "pass by secLink handle");
        PASS_BY_SEC_LINK_HANDLE = r110;
        ArgusCommonVerifyReason r111 = new ArgusCommonVerifyReason("SEC_LINK_STRATEGY_IS_NULL", 7, 4, "secLink strategy is null");
        SEC_LINK_STRATEGY_IS_NULL = r111;
        ArgusCommonVerifyReason r112 = new ArgusCommonVerifyReason("NO_AUTH_PACKAGE", 8, 101, "all permission config not found");
        NO_AUTH_PACKAGE = r112;
        ArgusCommonVerifyReason r113 = new ArgusCommonVerifyReason("TTM_IS_NOT_ENABLED", 9, 1001, "ttm is not enabled");
        TTM_IS_NOT_ENABLED = r113;
        ArgusCommonVerifyReason r106 = new ArgusCommonVerifyReason("TTM_RULE_NAME_IS_NULL", 10, 1002, "ttm rule name is null");
        TTM_RULE_NAME_IS_NULL = r106;
        ArgusCommonVerifyReason r107 = new ArgusCommonVerifyReason("TTM_RULE_VERSION_IS_NULL", 11, 1003, "ttm rule version is null");
        TTM_RULE_VERSION_IS_NULL = r107;
        ArgusCommonVerifyReason r108 = new ArgusCommonVerifyReason("TTM_RULE_INFO_IS_NULL", 12, 1004, "ttm rule info is null");
        TTM_RULE_INFO_IS_NULL = r108;
        ArgusCommonVerifyReason r109 = new ArgusCommonVerifyReason("TTM_RULE_ADDRESS_IS_NULL", 13, 1005, "ttm rule address is null");
        TTM_RULE_ADDRESS_IS_NULL = r109;
        ArgusCommonVerifyReason r114 = new ArgusCommonVerifyReason("RUN_TTM_ERROR", 14, 1006, "run ttm error");
        RUN_TTM_ERROR = r114;
        ArgusCommonVerifyReason r115 = new ArgusCommonVerifyReason("MISMATCH_PARAMS_TYPE", 15, 1007, "mismatch param type");
        MISMATCH_PARAMS_TYPE = r115;
        ArgusCommonVerifyReason r116 = new ArgusCommonVerifyReason("TRY_CATCH_ERROR", 16, 1008, "try catch error");
        TRY_CATCH_ERROR = r116;
        ArgusCommonVerifyReason r117 = new ArgusCommonVerifyReason("STRATEGY_RULE_NAME_IS_NULL", 17, 1009, "strategy rule name is null");
        STRATEGY_RULE_NAME_IS_NULL = r117;
        ArgusCommonVerifyReason r118 = new ArgusCommonVerifyReason("ASPECT_CONFIG_IS_NULL", 18, 1010, "aspect config is null");
        ASPECT_CONFIG_IS_NULL = r118;
        ArgusCommonVerifyReason r119 = new ArgusCommonVerifyReason("CLIENT_STRATEGY_PROVIDER_NOT_FOUND", 19, 1011, "client strategy provider not found");
        CLIENT_STRATEGY_PROVIDER_NOT_FOUND = r119;
        ArgusCommonVerifyReason r120 = new ArgusCommonVerifyReason("STRATEGY_RULE_LIST_IS_EMPTY", 20, 1012, "strategy rule list is empty");
        STRATEGY_RULE_LIST_IS_EMPTY = r120;
        ArgusCommonVerifyReason r121 = new ArgusCommonVerifyReason("ASPECT_IS_REPORT_ONLY", 21, 1013, "aspect switch is report only");
        ASPECT_IS_REPORT_ONLY = r121;
        ArgusCommonVerifyReason r122 = new ArgusCommonVerifyReason("ASPECT_IS_OFF", 22, 1014, "aspect switch is off");
        ASPECT_IS_OFF = r122;
        ArgusCommonVerifyReason r123 = new ArgusCommonVerifyReason("ASPECT_DISABLE_BY_RECOVERY", 23, 1015, "aspect disable by recovery");
        ASPECT_DISABLE_BY_RECOVERY = r123;
        ArgusCommonVerifyReason r124 = new ArgusCommonVerifyReason("TTM_STRATEGY_PROVIDER_NOT_FOUND", 24, 1016, "ttm strategy provider not found");
        TTM_STRATEGY_PROVIDER_NOT_FOUND = r124;
        ArgusCommonVerifyReason r125 = new ArgusCommonVerifyReason("STRATEGY_CONFIG_IS_NULL", 25, 1017, "strategy config is null");
        STRATEGY_CONFIG_IS_NULL = r125;
        ArgusCommonVerifyReason r126 = new ArgusCommonVerifyReason("STRATEGY_DISABLE_BY_RECOVERY", 26, 1018, "strategy disable by recovery");
        STRATEGY_DISABLE_BY_RECOVERY = r126;
        ArgusCommonVerifyReason r127 = new ArgusCommonVerifyReason("DISABLE_IN_DEBUG_ENV", 27, 1019, "disable in debug env");
        DISABLE_IN_DEBUG_ENV = r127;
        f245952a = new ArgusCommonVerifyReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusCommonVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
