package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusWebInjectJSStrategyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "MATCH_DISABLE_URL_REG", "MATCH_DISABLE_URL_HOST", "NOT_MATCHED_PATTERN", "MATCH_ALL_EXTERN_HOST", "MATCH_ENABLE_URL_HOST", "MATCH_ENABLE_URL_REG", "WEB_DOM_MONITOR_INJECT", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusWebInjectJSStrategyReason extends Enum<ArgusWebInjectJSStrategyReason> implements o {
    public static final ArgusWebInjectJSStrategyReason MATCH_ALL_EXTERN_HOST = null;
    public static final ArgusWebInjectJSStrategyReason MATCH_DISABLE_URL_HOST = null;
    public static final ArgusWebInjectJSStrategyReason MATCH_DISABLE_URL_REG = null;
    public static final ArgusWebInjectJSStrategyReason MATCH_ENABLE_URL_HOST = null;
    public static final ArgusWebInjectJSStrategyReason MATCH_ENABLE_URL_REG = null;
    public static final ArgusWebInjectJSStrategyReason NOT_MATCHED_PATTERN = null;
    public static final ArgusWebInjectJSStrategyReason WEB_DOM_MONITOR_INJECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusWebInjectJSStrategyReason[] f245978a = null;
    private final int code;
    private final String strValue;

    public static ArgusWebInjectJSStrategyReason valueOf(String r100) {
        return (ArgusWebInjectJSStrategyReason) r27.a.a(ArgusWebInjectJSStrategyReason.class, r100);
    }

    public static ArgusWebInjectJSStrategyReason[] values() {
        return (ArgusWebInjectJSStrategyReason[]) f245978a.clone();
    }

    static {
        ArgusWebInjectJSStrategyReason r100 = new ArgusWebInjectJSStrategyReason("MATCH_DISABLE_URL_REG", 0, 1, "match disable_url_host");
        MATCH_DISABLE_URL_REG = r100;
        ArgusWebInjectJSStrategyReason r101 = new ArgusWebInjectJSStrategyReason("MATCH_DISABLE_URL_HOST", 1, 2, "match disable_url_reg");
        MATCH_DISABLE_URL_HOST = r101;
        ArgusWebInjectJSStrategyReason r102 = new ArgusWebInjectJSStrategyReason("NOT_MATCHED_PATTERN", 2, 3, "not matched pattern");
        NOT_MATCHED_PATTERN = r102;
        ArgusWebInjectJSStrategyReason r103 = new ArgusWebInjectJSStrategyReason("MATCH_ALL_EXTERN_HOST", 3, -1, "match all_extern_host");
        MATCH_ALL_EXTERN_HOST = r103;
        ArgusWebInjectJSStrategyReason r104 = new ArgusWebInjectJSStrategyReason("MATCH_ENABLE_URL_HOST", 4, -1, "match enable_url_host");
        MATCH_ENABLE_URL_HOST = r104;
        ArgusWebInjectJSStrategyReason r105 = new ArgusWebInjectJSStrategyReason("MATCH_ENABLE_URL_REG", 5, -2, "match enable_url_reg");
        MATCH_ENABLE_URL_REG = r105;
        ArgusWebInjectJSStrategyReason r110 = new ArgusWebInjectJSStrategyReason("WEB_DOM_MONITOR_INJECT", 6, -3, "web dom monitor inject");
        WEB_DOM_MONITOR_INJECT = r110;
        f245978a = new ArgusWebInjectJSStrategyReason[]{r100, r101, r102, r103, r104, r105, r110};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusWebInjectJSStrategyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
