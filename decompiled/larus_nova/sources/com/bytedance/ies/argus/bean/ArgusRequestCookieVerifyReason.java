package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusRequestCookieVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "NO_SESSION", "THIRD_HAS_SESSION_REWRITE", "THIRD_HAS_SESSION_REPORT", "WHITE_HAS_SESSION_REWRITE", "WHITE_HAS_SESSION_REPORT", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusRequestCookieVerifyReason extends Enum<ArgusRequestCookieVerifyReason> implements o {
    public static final ArgusRequestCookieVerifyReason NO_SESSION = null;
    public static final ArgusRequestCookieVerifyReason THIRD_HAS_SESSION_REPORT = null;
    public static final ArgusRequestCookieVerifyReason THIRD_HAS_SESSION_REWRITE = null;
    public static final ArgusRequestCookieVerifyReason WHITE_HAS_SESSION_REPORT = null;
    public static final ArgusRequestCookieVerifyReason WHITE_HAS_SESSION_REWRITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusRequestCookieVerifyReason[] f245967a = null;
    private final int code;
    private final String strValue;

    public static ArgusRequestCookieVerifyReason valueOf(String r100) {
        return (ArgusRequestCookieVerifyReason) r27.a.a(ArgusRequestCookieVerifyReason.class, r100);
    }

    public static ArgusRequestCookieVerifyReason[] values() {
        return (ArgusRequestCookieVerifyReason[]) f245967a.clone();
    }

    static {
        ArgusRequestCookieVerifyReason r100 = new ArgusRequestCookieVerifyReason("NO_SESSION", 0, 20, "no session");
        NO_SESSION = r100;
        ArgusRequestCookieVerifyReason r101 = new ArgusRequestCookieVerifyReason("THIRD_HAS_SESSION_REWRITE", 1, 21, "third has session rewrite");
        THIRD_HAS_SESSION_REWRITE = r101;
        ArgusRequestCookieVerifyReason r102 = new ArgusRequestCookieVerifyReason("THIRD_HAS_SESSION_REPORT", 2, 22, "third has session report");
        THIRD_HAS_SESSION_REPORT = r102;
        ArgusRequestCookieVerifyReason r103 = new ArgusRequestCookieVerifyReason("WHITE_HAS_SESSION_REWRITE", 3, 23, "white has session rewrite");
        WHITE_HAS_SESSION_REWRITE = r103;
        ArgusRequestCookieVerifyReason r104 = new ArgusRequestCookieVerifyReason("WHITE_HAS_SESSION_REPORT", 4, 24, "white has session report");
        WHITE_HAS_SESSION_REPORT = r104;
        f245967a = new ArgusRequestCookieVerifyReason[]{r100, r101, r102, r103, r104};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusRequestCookieVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
