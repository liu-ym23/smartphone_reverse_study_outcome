package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusJSIVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "BLOCK_NOT_IN_WHITELIST", "BLOCK_IN_BLACKLIST", "SUCCESS_IN_WHITE_LIST", "SUCCESS_NOT_IN_BLACKLIST", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusJSIVerifyReason extends Enum<ArgusJSIVerifyReason> implements o {
    public static final ArgusJSIVerifyReason BLOCK_IN_BLACKLIST = null;
    public static final ArgusJSIVerifyReason BLOCK_NOT_IN_WHITELIST = null;
    public static final ArgusJSIVerifyReason SUCCESS_IN_WHITE_LIST = null;
    public static final ArgusJSIVerifyReason SUCCESS_NOT_IN_BLACKLIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusJSIVerifyReason[] f245960a = null;
    private final int code;
    private final String strValue;

    public static ArgusJSIVerifyReason valueOf(String r100) {
        return (ArgusJSIVerifyReason) r27.a.a(ArgusJSIVerifyReason.class, r100);
    }

    public static ArgusJSIVerifyReason[] values() {
        return (ArgusJSIVerifyReason[]) f245960a.clone();
    }

    static {
        ArgusJSIVerifyReason r100 = new ArgusJSIVerifyReason("BLOCK_NOT_IN_WHITELIST", 0, -1, "not in whitelist");
        BLOCK_NOT_IN_WHITELIST = r100;
        ArgusJSIVerifyReason r101 = new ArgusJSIVerifyReason("BLOCK_IN_BLACKLIST", 1, -2, "in blacklist");
        BLOCK_IN_BLACKLIST = r101;
        ArgusJSIVerifyReason r102 = new ArgusJSIVerifyReason("SUCCESS_IN_WHITE_LIST", 2, 1, "in whitelist");
        SUCCESS_IN_WHITE_LIST = r102;
        ArgusJSIVerifyReason r103 = new ArgusJSIVerifyReason("SUCCESS_NOT_IN_BLACKLIST", 3, 2, "not in blacklist");
        SUCCESS_NOT_IN_BLACKLIST = r103;
        f245960a = new ArgusJSIVerifyReason[]{r100, r101, r102, r103};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusJSIVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
