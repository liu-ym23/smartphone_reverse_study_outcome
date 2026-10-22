package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusSchemaParamRouteVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "SCHEMA_PARAM_NOT_ALLOWED", "FAILED_SCHEMA_PARAM_IN_BLACKLIST", "FAILED_NOT_IN_WHITE_LIST", "ROUTE_RISK_TYPE_TOO_HIGH", "SUCCESS_IN_WHITE_LIST", "SUCCESS_IS_INNER_HOST", "SUCCESS_PASS_ALL", "SUCCESS_PASS_BLOCK_BUT_REPORT_ONLY", "ABNORMAL_SCHEMA_PARAM", "ABNORMAL_SCHEMA_KEY_VALUE", "ABNORMAL_AUTH_CONFIG_IS_NULL", "ABNORMAL_BLOCK_BUT_VERIFY_RESULT_IS_NULL", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusSchemaParamRouteVerifyReason extends Enum<ArgusSchemaParamRouteVerifyReason> implements o {
    public static final ArgusSchemaParamRouteVerifyReason ABNORMAL_AUTH_CONFIG_IS_NULL = null;
    public static final ArgusSchemaParamRouteVerifyReason ABNORMAL_BLOCK_BUT_VERIFY_RESULT_IS_NULL = null;
    public static final ArgusSchemaParamRouteVerifyReason ABNORMAL_SCHEMA_KEY_VALUE = null;
    public static final ArgusSchemaParamRouteVerifyReason ABNORMAL_SCHEMA_PARAM = null;
    public static final ArgusSchemaParamRouteVerifyReason FAILED_NOT_IN_WHITE_LIST = null;
    public static final ArgusSchemaParamRouteVerifyReason FAILED_SCHEMA_PARAM_IN_BLACKLIST = null;
    public static final ArgusSchemaParamRouteVerifyReason ROUTE_RISK_TYPE_TOO_HIGH = null;
    public static final ArgusSchemaParamRouteVerifyReason SCHEMA_PARAM_NOT_ALLOWED = null;
    public static final ArgusSchemaParamRouteVerifyReason SUCCESS_IN_WHITE_LIST = null;
    public static final ArgusSchemaParamRouteVerifyReason SUCCESS_IS_INNER_HOST = null;
    public static final ArgusSchemaParamRouteVerifyReason SUCCESS_PASS_ALL = null;
    public static final ArgusSchemaParamRouteVerifyReason SUCCESS_PASS_BLOCK_BUT_REPORT_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusSchemaParamRouteVerifyReason[] f245969a = null;
    private final int code;
    private final String strValue;

    public static ArgusSchemaParamRouteVerifyReason valueOf(String r100) {
        return (ArgusSchemaParamRouteVerifyReason) r27.a.a(ArgusSchemaParamRouteVerifyReason.class, r100);
    }

    public static ArgusSchemaParamRouteVerifyReason[] values() {
        return (ArgusSchemaParamRouteVerifyReason[]) f245969a.clone();
    }

    static {
        ArgusSchemaParamRouteVerifyReason r100 = new ArgusSchemaParamRouteVerifyReason("SCHEMA_PARAM_NOT_ALLOWED", 0, -1, "schema param not allowed");
        SCHEMA_PARAM_NOT_ALLOWED = r100;
        ArgusSchemaParamRouteVerifyReason r101 = new ArgusSchemaParamRouteVerifyReason("FAILED_SCHEMA_PARAM_IN_BLACKLIST", 1, -2, "hit black list");
        FAILED_SCHEMA_PARAM_IN_BLACKLIST = r101;
        ArgusSchemaParamRouteVerifyReason r102 = new ArgusSchemaParamRouteVerifyReason("FAILED_NOT_IN_WHITE_LIST", 2, -3, "not in white list");
        FAILED_NOT_IN_WHITE_LIST = r102;
        ArgusSchemaParamRouteVerifyReason r103 = new ArgusSchemaParamRouteVerifyReason("ROUTE_RISK_TYPE_TOO_HIGH", 3, -4, "exceed entry route risk level limit");
        ROUTE_RISK_TYPE_TOO_HIGH = r103;
        ArgusSchemaParamRouteVerifyReason r104 = new ArgusSchemaParamRouteVerifyReason("SUCCESS_IN_WHITE_LIST", 4, 1, "success pass schema verify");
        SUCCESS_IN_WHITE_LIST = r104;
        ArgusSchemaParamRouteVerifyReason r105 = new ArgusSchemaParamRouteVerifyReason("SUCCESS_IS_INNER_HOST", 5, 2, "success pass inner host");
        SUCCESS_IS_INNER_HOST = r105;
        ArgusSchemaParamRouteVerifyReason r106 = new ArgusSchemaParamRouteVerifyReason("SUCCESS_PASS_ALL", 6, 3, "success pass all verify");
        SUCCESS_PASS_ALL = r106;
        ArgusSchemaParamRouteVerifyReason r110 = new ArgusSchemaParamRouteVerifyReason("SUCCESS_PASS_BLOCK_BUT_REPORT_ONLY", 7, 4, "success cause report only, origin is block");
        SUCCESS_PASS_BLOCK_BUT_REPORT_ONLY = r110;
        ArgusSchemaParamRouteVerifyReason r111 = new ArgusSchemaParamRouteVerifyReason("ABNORMAL_SCHEMA_PARAM", 8, 1001, "abnormal schema param");
        ABNORMAL_SCHEMA_PARAM = r111;
        ArgusSchemaParamRouteVerifyReason r112 = new ArgusSchemaParamRouteVerifyReason("ABNORMAL_SCHEMA_KEY_VALUE", 9, 1002, "abnormal schema key value");
        ABNORMAL_SCHEMA_KEY_VALUE = r112;
        ArgusSchemaParamRouteVerifyReason r113 = new ArgusSchemaParamRouteVerifyReason("ABNORMAL_AUTH_CONFIG_IS_NULL", 10, 1003, "auth config is null");
        ABNORMAL_AUTH_CONFIG_IS_NULL = r113;
        ArgusSchemaParamRouteVerifyReason r107 = new ArgusSchemaParamRouteVerifyReason("ABNORMAL_BLOCK_BUT_VERIFY_RESULT_IS_NULL", 11, 1004, "abnormal block but verify result is null, pass first");
        ABNORMAL_BLOCK_BUT_VERIFY_RESULT_IS_NULL = r107;
        f245969a = new ArgusSchemaParamRouteVerifyReason[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusSchemaParamRouteVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
