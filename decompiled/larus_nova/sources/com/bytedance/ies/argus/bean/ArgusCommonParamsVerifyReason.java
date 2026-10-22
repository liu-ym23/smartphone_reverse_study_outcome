package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusCommonParamsVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "NOT_IN_WHITELIST", "HOST_UNPARSEABLE", "MATCH", "CONFIG_IS_EMPTY", "CAN_NOT_GET_CDN_URL", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusCommonParamsVerifyReason extends Enum<ArgusCommonParamsVerifyReason> implements o {
    public static final ArgusCommonParamsVerifyReason CAN_NOT_GET_CDN_URL = null;
    public static final ArgusCommonParamsVerifyReason CONFIG_IS_EMPTY = null;
    public static final ArgusCommonParamsVerifyReason HOST_UNPARSEABLE = null;
    public static final ArgusCommonParamsVerifyReason MATCH = null;
    public static final ArgusCommonParamsVerifyReason NOT_IN_WHITELIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusCommonParamsVerifyReason[] f245951a = null;
    private final int code;
    private final String strValue;

    public static ArgusCommonParamsVerifyReason valueOf(String r100) {
        return (ArgusCommonParamsVerifyReason) r27.a.a(ArgusCommonParamsVerifyReason.class, r100);
    }

    public static ArgusCommonParamsVerifyReason[] values() {
        return (ArgusCommonParamsVerifyReason[]) f245951a.clone();
    }

    static {
        ArgusCommonParamsVerifyReason r100 = new ArgusCommonParamsVerifyReason("NOT_IN_WHITELIST", 0, -1, "host not in allow list");
        NOT_IN_WHITELIST = r100;
        ArgusCommonParamsVerifyReason r101 = new ArgusCommonParamsVerifyReason("HOST_UNPARSEABLE", 1, -2, "host unparseable");
        HOST_UNPARSEABLE = r101;
        ArgusCommonParamsVerifyReason r102 = new ArgusCommonParamsVerifyReason("MATCH", 2, 1, "match allow list");
        MATCH = r102;
        ArgusCommonParamsVerifyReason r103 = new ArgusCommonParamsVerifyReason("CONFIG_IS_EMPTY", 3, 2, "config is empty");
        CONFIG_IS_EMPTY = r103;
        ArgusCommonParamsVerifyReason r104 = new ArgusCommonParamsVerifyReason("CAN_NOT_GET_CDN_URL", 4, 3, "can not get cdn url");
        CAN_NOT_GET_CDN_URL = r104;
        f245951a = new ArgusCommonParamsVerifyReason[]{r100, r101, r102, r103, r104};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusCommonParamsVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
