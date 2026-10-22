package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusLoginStateSourceVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "NOT_HTTPS", "CONFIG_IS_EMPTY", "NOT_MATCH", "MATCH", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusLoginStateSourceVerifyReason extends Enum<ArgusLoginStateSourceVerifyReason> implements o {
    public static final ArgusLoginStateSourceVerifyReason CONFIG_IS_EMPTY = null;
    public static final ArgusLoginStateSourceVerifyReason MATCH = null;
    public static final ArgusLoginStateSourceVerifyReason NOT_HTTPS = null;
    public static final ArgusLoginStateSourceVerifyReason NOT_MATCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusLoginStateSourceVerifyReason[] f245961a = null;
    private final int code;
    private final String strValue;

    public static ArgusLoginStateSourceVerifyReason valueOf(String r100) {
        return (ArgusLoginStateSourceVerifyReason) r27.a.a(ArgusLoginStateSourceVerifyReason.class, r100);
    }

    public static ArgusLoginStateSourceVerifyReason[] values() {
        return (ArgusLoginStateSourceVerifyReason[]) f245961a.clone();
    }

    static {
        ArgusLoginStateSourceVerifyReason r100 = new ArgusLoginStateSourceVerifyReason("NOT_HTTPS", 0, -3, "not https");
        NOT_HTTPS = r100;
        ArgusLoginStateSourceVerifyReason r101 = new ArgusLoginStateSourceVerifyReason("CONFIG_IS_EMPTY", 1, -2, "config is empty");
        CONFIG_IS_EMPTY = r101;
        ArgusLoginStateSourceVerifyReason r102 = new ArgusLoginStateSourceVerifyReason("NOT_MATCH", 2, -1, "not match white list");
        NOT_MATCH = r102;
        ArgusLoginStateSourceVerifyReason r103 = new ArgusLoginStateSourceVerifyReason("MATCH", 3, 1, "match white list");
        MATCH = r103;
        f245961a = new ArgusLoginStateSourceVerifyReason[]{r100, r101, r102, r103};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusLoginStateSourceVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
