package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusThirdRemoveSensitiveInfoStrategyVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "REWRITE", "IN_WHITE_LIST", "METHOD_NO_NEED", "NO_FIELD_HIT", "FE_ID_PASS", "CONTENT_DOMAIN_PASS", "ABNORMAL_PARAMS_INVALID", "ABNORMAL_CONFIG_ERROR", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusThirdRemoveSensitiveInfoStrategyVerifyReason extends Enum<ArgusThirdRemoveSensitiveInfoStrategyVerifyReason> implements o {
    public static final ArgusThirdRemoveSensitiveInfoStrategyVerifyReason ABNORMAL_CONFIG_ERROR = null;
    public static final ArgusThirdRemoveSensitiveInfoStrategyVerifyReason ABNORMAL_PARAMS_INVALID = null;
    public static final ArgusThirdRemoveSensitiveInfoStrategyVerifyReason CONTENT_DOMAIN_PASS = null;
    public static final ArgusThirdRemoveSensitiveInfoStrategyVerifyReason FE_ID_PASS = null;
    public static final ArgusThirdRemoveSensitiveInfoStrategyVerifyReason IN_WHITE_LIST = null;
    public static final ArgusThirdRemoveSensitiveInfoStrategyVerifyReason METHOD_NO_NEED = null;
    public static final ArgusThirdRemoveSensitiveInfoStrategyVerifyReason NO_FIELD_HIT = null;
    public static final ArgusThirdRemoveSensitiveInfoStrategyVerifyReason REWRITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusThirdRemoveSensitiveInfoStrategyVerifyReason[] f245973a = null;
    private final int code;
    private final String strValue;

    public static ArgusThirdRemoveSensitiveInfoStrategyVerifyReason valueOf(String r100) {
        return (ArgusThirdRemoveSensitiveInfoStrategyVerifyReason) r27.a.a(ArgusThirdRemoveSensitiveInfoStrategyVerifyReason.class, r100);
    }

    public static ArgusThirdRemoveSensitiveInfoStrategyVerifyReason[] values() {
        return (ArgusThirdRemoveSensitiveInfoStrategyVerifyReason[]) f245973a.clone();
    }

    static {
        ArgusThirdRemoveSensitiveInfoStrategyVerifyReason r100 = new ArgusThirdRemoveSensitiveInfoStrategyVerifyReason("REWRITE", 0, -1, "successfully removed sensitive fields");
        REWRITE = r100;
        ArgusThirdRemoveSensitiveInfoStrategyVerifyReason r101 = new ArgusThirdRemoveSensitiveInfoStrategyVerifyReason("IN_WHITE_LIST", 1, 1, "in white list, skip filter");
        IN_WHITE_LIST = r101;
        ArgusThirdRemoveSensitiveInfoStrategyVerifyReason r102 = new ArgusThirdRemoveSensitiveInfoStrategyVerifyReason("METHOD_NO_NEED", 2, 2, "method no need filter");
        METHOD_NO_NEED = r102;
        ArgusThirdRemoveSensitiveInfoStrategyVerifyReason r103 = new ArgusThirdRemoveSensitiveInfoStrategyVerifyReason("NO_FIELD_HIT", 3, 3, "no sensitive field hits");
        NO_FIELD_HIT = r103;
        ArgusThirdRemoveSensitiveInfoStrategyVerifyReason r104 = new ArgusThirdRemoveSensitiveInfoStrategyVerifyReason("FE_ID_PASS", 4, 4, "fe_id > 0, skip filter");
        FE_ID_PASS = r104;
        ArgusThirdRemoveSensitiveInfoStrategyVerifyReason r105 = new ArgusThirdRemoveSensitiveInfoStrategyVerifyReason("CONTENT_DOMAIN_PASS", 5, 5, "content pattern matched, skip filter");
        CONTENT_DOMAIN_PASS = r105;
        ArgusThirdRemoveSensitiveInfoStrategyVerifyReason r110 = new ArgusThirdRemoveSensitiveInfoStrategyVerifyReason("ABNORMAL_PARAMS_INVALID", 6, 101, "params invalid");
        ABNORMAL_PARAMS_INVALID = r110;
        ArgusThirdRemoveSensitiveInfoStrategyVerifyReason r111 = new ArgusThirdRemoveSensitiveInfoStrategyVerifyReason("ABNORMAL_CONFIG_ERROR", 7, 102, "config error");
        ABNORMAL_CONFIG_ERROR = r111;
        f245973a = new ArgusThirdRemoveSensitiveInfoStrategyVerifyReason[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusThirdRemoveSensitiveInfoStrategyVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
