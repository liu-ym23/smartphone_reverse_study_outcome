package com.bytedance.ies.argus.bean;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusFeId;", "", "", "longValue", "J", "getLongValue", "()J", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "SIGN_BUT_VERIFY_ERROR", "UNSET", "NO_AUTH_CONFIG", "NOT_MATCH", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusFeId extends Enum<ArgusFeId> {
    public static final ArgusFeId NOT_MATCH = null;
    public static final ArgusFeId NO_AUTH_CONFIG = null;
    public static final ArgusFeId SIGN_BUT_VERIFY_ERROR = null;
    public static final ArgusFeId UNSET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusFeId[] f245955a = null;
    private final long longValue;
    private final String strValue;

    public static ArgusFeId valueOf(String r100) {
        return (ArgusFeId) r27.a.a(ArgusFeId.class, r100);
    }

    public static ArgusFeId[] values() {
        return (ArgusFeId[]) f245955a.clone();
    }

    static {
        ArgusFeId r100 = new ArgusFeId("SIGN_BUT_VERIFY_ERROR", 0, -4, OnekeyLoginConstants.ErrorCode.ERROR_CU_REQUEST_TIMEOUT);
        SIGN_BUT_VERIFY_ERROR = r100;
        ArgusFeId r101 = new ArgusFeId("UNSET", 1, -3, "-3");
        UNSET = r101;
        ArgusFeId r102 = new ArgusFeId("NO_AUTH_CONFIG", 2, -2, "-2");
        NO_AUTH_CONFIG = r102;
        ArgusFeId r103 = new ArgusFeId("NOT_MATCH", 3, -1, "-1");
        NOT_MATCH = r103;
        f245955a = new ArgusFeId[]{r100, r101, r102, r103};
    }

    public final long getLongValue() {
        return this.longValue;
    }

    public final String getStrValue() {
        return this.strValue;
    }

    public ArgusFeId(String r100, int r101, long r102, String r103) {
        super(r100, r101);
        this.longValue = r102;
        this.strValue = r103;
    }
}
