package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusCSRFProtectVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "REWRITE_HEADER", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusCSRFProtectVerifyReason extends Enum<ArgusCSRFProtectVerifyReason> implements o {
    public static final ArgusCSRFProtectVerifyReason REWRITE_HEADER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusCSRFProtectVerifyReason[] f245950a = null;
    private final int code;
    private final String strValue;

    public static ArgusCSRFProtectVerifyReason valueOf(String r100) {
        return (ArgusCSRFProtectVerifyReason) r27.a.a(ArgusCSRFProtectVerifyReason.class, r100);
    }

    public static ArgusCSRFProtectVerifyReason[] values() {
        return (ArgusCSRFProtectVerifyReason[]) f245950a.clone();
    }

    static {
        ArgusCSRFProtectVerifyReason r100 = new ArgusCSRFProtectVerifyReason();
        REWRITE_HEADER = r100;
        f245950a = new ArgusCSRFProtectVerifyReason[]{r100};
    }

    public ArgusCSRFProtectVerifyReason() {
        super("REWRITE_HEADER", 0);
        this.code = 1;
        this.strValue = "rewrite header success";
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }
}
