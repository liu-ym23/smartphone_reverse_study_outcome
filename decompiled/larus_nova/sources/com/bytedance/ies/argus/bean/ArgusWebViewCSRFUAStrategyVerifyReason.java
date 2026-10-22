package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusWebViewCSRFUAStrategyVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "APPID_IS_NULL", "UA_CONTAINS_ALL_PART", "REWRITE_UA", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusWebViewCSRFUAStrategyVerifyReason extends Enum<ArgusWebViewCSRFUAStrategyVerifyReason> implements o {
    public static final ArgusWebViewCSRFUAStrategyVerifyReason APPID_IS_NULL = null;
    public static final ArgusWebViewCSRFUAStrategyVerifyReason REWRITE_UA = null;
    public static final ArgusWebViewCSRFUAStrategyVerifyReason UA_CONTAINS_ALL_PART = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusWebViewCSRFUAStrategyVerifyReason[] f245981a = null;
    private final int code;
    private final String strValue;

    public static ArgusWebViewCSRFUAStrategyVerifyReason valueOf(String r100) {
        return (ArgusWebViewCSRFUAStrategyVerifyReason) r27.a.a(ArgusWebViewCSRFUAStrategyVerifyReason.class, r100);
    }

    public static ArgusWebViewCSRFUAStrategyVerifyReason[] values() {
        return (ArgusWebViewCSRFUAStrategyVerifyReason[]) f245981a.clone();
    }

    static {
        ArgusWebViewCSRFUAStrategyVerifyReason r100 = new ArgusWebViewCSRFUAStrategyVerifyReason("APPID_IS_NULL", 0, 1, "appid is null");
        APPID_IS_NULL = r100;
        ArgusWebViewCSRFUAStrategyVerifyReason r101 = new ArgusWebViewCSRFUAStrategyVerifyReason("UA_CONTAINS_ALL_PART", 1, 2, "ua already contains all part");
        UA_CONTAINS_ALL_PART = r101;
        ArgusWebViewCSRFUAStrategyVerifyReason r102 = new ArgusWebViewCSRFUAStrategyVerifyReason("REWRITE_UA", 2, 3, "rewrite ua");
        REWRITE_UA = r102;
        f245981a = new ArgusWebViewCSRFUAStrategyVerifyReason[]{r100, r101, r102};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusWebViewCSRFUAStrategyVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
