package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusGlobalPropsUrlVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "SHORTEN_HOST_UNPARSEABLE", "HOST_UNPARSEABLE", "NOT_MATCH", "MATCH", "EMPTY_WHITE_LIST", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusGlobalPropsUrlVerifyReason extends Enum<ArgusGlobalPropsUrlVerifyReason> implements o {
    public static final ArgusGlobalPropsUrlVerifyReason EMPTY_WHITE_LIST = null;
    public static final ArgusGlobalPropsUrlVerifyReason HOST_UNPARSEABLE = null;
    public static final ArgusGlobalPropsUrlVerifyReason MATCH = null;
    public static final ArgusGlobalPropsUrlVerifyReason NOT_MATCH = null;
    public static final ArgusGlobalPropsUrlVerifyReason SHORTEN_HOST_UNPARSEABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusGlobalPropsUrlVerifyReason[] f245958a = null;
    private final int code;
    private final String strValue;

    public static ArgusGlobalPropsUrlVerifyReason valueOf(String r100) {
        return (ArgusGlobalPropsUrlVerifyReason) r27.a.a(ArgusGlobalPropsUrlVerifyReason.class, r100);
    }

    public static ArgusGlobalPropsUrlVerifyReason[] values() {
        return (ArgusGlobalPropsUrlVerifyReason[]) f245958a.clone();
    }

    static {
        ArgusGlobalPropsUrlVerifyReason r100 = new ArgusGlobalPropsUrlVerifyReason("SHORTEN_HOST_UNPARSEABLE", 0, -3, "shortened host unparseable");
        SHORTEN_HOST_UNPARSEABLE = r100;
        ArgusGlobalPropsUrlVerifyReason r101 = new ArgusGlobalPropsUrlVerifyReason("HOST_UNPARSEABLE", 1, -2, "host unparseable");
        HOST_UNPARSEABLE = r101;
        ArgusGlobalPropsUrlVerifyReason r102 = new ArgusGlobalPropsUrlVerifyReason("NOT_MATCH", 2, -1, "not match white list");
        NOT_MATCH = r102;
        ArgusGlobalPropsUrlVerifyReason r103 = new ArgusGlobalPropsUrlVerifyReason("MATCH", 3, 1, "match white list");
        MATCH = r103;
        ArgusGlobalPropsUrlVerifyReason r104 = new ArgusGlobalPropsUrlVerifyReason("EMPTY_WHITE_LIST", 4, 100, "empty white list config");
        EMPTY_WHITE_LIST = r104;
        f245958a = new ArgusGlobalPropsUrlVerifyReason[]{r100, r101, r102, r103, r104};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusGlobalPropsUrlVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
