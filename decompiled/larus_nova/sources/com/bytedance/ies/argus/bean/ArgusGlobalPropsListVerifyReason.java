package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusGlobalPropsListVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "BLOCK_ALL_MODE_EMPTY_WHITELIST", "BLOCK_NOT_IN_WHITELIST", "BLOCK_IN_BLACKLIST", "SUCCESS_PASS_ALL_VERIFY", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusGlobalPropsListVerifyReason extends Enum<ArgusGlobalPropsListVerifyReason> implements o {
    public static final ArgusGlobalPropsListVerifyReason BLOCK_ALL_MODE_EMPTY_WHITELIST = null;
    public static final ArgusGlobalPropsListVerifyReason BLOCK_IN_BLACKLIST = null;
    public static final ArgusGlobalPropsListVerifyReason BLOCK_NOT_IN_WHITELIST = null;
    public static final ArgusGlobalPropsListVerifyReason SUCCESS_PASS_ALL_VERIFY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusGlobalPropsListVerifyReason[] f245957a = null;
    private final int code;
    private final String strValue;

    public static ArgusGlobalPropsListVerifyReason valueOf(String r100) {
        return (ArgusGlobalPropsListVerifyReason) r27.a.a(ArgusGlobalPropsListVerifyReason.class, r100);
    }

    public static ArgusGlobalPropsListVerifyReason[] values() {
        return (ArgusGlobalPropsListVerifyReason[]) f245957a.clone();
    }

    static {
        ArgusGlobalPropsListVerifyReason r100 = new ArgusGlobalPropsListVerifyReason("BLOCK_ALL_MODE_EMPTY_WHITELIST", 0, -1, "block all mode with empty whitelist");
        BLOCK_ALL_MODE_EMPTY_WHITELIST = r100;
        ArgusGlobalPropsListVerifyReason r101 = new ArgusGlobalPropsListVerifyReason("BLOCK_NOT_IN_WHITELIST", 1, -2, "gp not in whitelist");
        BLOCK_NOT_IN_WHITELIST = r101;
        ArgusGlobalPropsListVerifyReason r102 = new ArgusGlobalPropsListVerifyReason("BLOCK_IN_BLACKLIST", 2, -3, "gp in blacklist");
        BLOCK_IN_BLACKLIST = r102;
        ArgusGlobalPropsListVerifyReason r103 = new ArgusGlobalPropsListVerifyReason("SUCCESS_PASS_ALL_VERIFY", 3, 1, "pass all verify");
        SUCCESS_PASS_ALL_VERIFY = r103;
        f245957a = new ArgusGlobalPropsListVerifyReason[]{r100, r101, r102, r103};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusGlobalPropsListVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
