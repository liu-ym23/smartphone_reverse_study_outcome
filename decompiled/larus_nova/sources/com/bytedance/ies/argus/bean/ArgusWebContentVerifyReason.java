package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusWebContentVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "MATCHED_BY_REG", "MATCHED_BY_STR", "STRATEGY_CONFIG_EMPTY", "VERIFY_RULE_EMPTY", "NO_MATCHING_RULES", "REPORT_ONLY", "ENABLE_SCENE_EMPTY", "ENABLE_SCENE_MISMATCH", "WARNING_REDIRECT_TO_URL_EMPTY", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusWebContentVerifyReason extends Enum<ArgusWebContentVerifyReason> implements o {
    public static final ArgusWebContentVerifyReason ENABLE_SCENE_EMPTY = null;
    public static final ArgusWebContentVerifyReason ENABLE_SCENE_MISMATCH = null;
    public static final ArgusWebContentVerifyReason MATCHED_BY_REG = null;
    public static final ArgusWebContentVerifyReason MATCHED_BY_STR = null;
    public static final ArgusWebContentVerifyReason NO_MATCHING_RULES = null;
    public static final ArgusWebContentVerifyReason REPORT_ONLY = null;
    public static final ArgusWebContentVerifyReason STRATEGY_CONFIG_EMPTY = null;
    public static final ArgusWebContentVerifyReason VERIFY_RULE_EMPTY = null;
    public static final ArgusWebContentVerifyReason WARNING_REDIRECT_TO_URL_EMPTY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusWebContentVerifyReason[] f245976a = null;
    private final int code;
    private final String strValue;

    public static ArgusWebContentVerifyReason valueOf(String r100) {
        return (ArgusWebContentVerifyReason) r27.a.a(ArgusWebContentVerifyReason.class, r100);
    }

    public static ArgusWebContentVerifyReason[] values() {
        return (ArgusWebContentVerifyReason[]) f245976a.clone();
    }

    static {
        ArgusWebContentVerifyReason r100 = new ArgusWebContentVerifyReason("MATCHED_BY_REG", 0, -1, "content verify, matched by risk reg rule");
        MATCHED_BY_REG = r100;
        ArgusWebContentVerifyReason r101 = new ArgusWebContentVerifyReason("MATCHED_BY_STR", 1, -2, "content verify, matched by risk string rule");
        MATCHED_BY_STR = r101;
        ArgusWebContentVerifyReason r102 = new ArgusWebContentVerifyReason("STRATEGY_CONFIG_EMPTY", 2, 0, "strategy config is empty");
        STRATEGY_CONFIG_EMPTY = r102;
        ArgusWebContentVerifyReason r103 = new ArgusWebContentVerifyReason("VERIFY_RULE_EMPTY", 3, 1, "verify rule is empty");
        VERIFY_RULE_EMPTY = r103;
        ArgusWebContentVerifyReason r104 = new ArgusWebContentVerifyReason("NO_MATCHING_RULES", 4, 2, "not match rule");
        NO_MATCHING_RULES = r104;
        ArgusWebContentVerifyReason r105 = new ArgusWebContentVerifyReason("REPORT_ONLY", 5, 3, "content verify report only, pass");
        REPORT_ONLY = r105;
        ArgusWebContentVerifyReason r110 = new ArgusWebContentVerifyReason("ENABLE_SCENE_EMPTY", 6, 1001, "enable scene is empty");
        ENABLE_SCENE_EMPTY = r110;
        ArgusWebContentVerifyReason r111 = new ArgusWebContentVerifyReason("ENABLE_SCENE_MISMATCH", 7, 1002, "enable scene mismatch");
        ENABLE_SCENE_MISMATCH = r111;
        ArgusWebContentVerifyReason r112 = new ArgusWebContentVerifyReason("WARNING_REDIRECT_TO_URL_EMPTY", 8, 1003, "warning mode, redirect url is empty is abnormal, not rewrite first");
        WARNING_REDIRECT_TO_URL_EMPTY = r112;
        f245976a = new ArgusWebContentVerifyReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusWebContentVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
