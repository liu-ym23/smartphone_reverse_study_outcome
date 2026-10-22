package com.bytedance.ug.sdk.luckycat.api.depend;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/api/depend/SDKResultCode;", "", "", "value", "I", "getValue", "()I", "Unknown", "Success", "NoPermission", "ArgumentError", "NoAccount", "NotFound", "StoreError", "NoRequestPermissionInvoker", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final enum SDKResultCode extends Enum<SDKResultCode> {
    public static final SDKResultCode ArgumentError = null;
    public static final SDKResultCode NoAccount = null;
    public static final SDKResultCode NoPermission = null;
    public static final SDKResultCode NoRequestPermissionInvoker = null;
    public static final SDKResultCode NotFound = null;
    public static final SDKResultCode StoreError = null;
    public static final SDKResultCode Success = null;
    public static final SDKResultCode Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SDKResultCode[] f271067a = null;
    private final int value;

    public static SDKResultCode valueOf(String r100) {
        return (SDKResultCode) r27.a.a(SDKResultCode.class, r100);
    }

    public static SDKResultCode[] values() {
        return (SDKResultCode[]) f271067a.clone();
    }

    static {
        SDKResultCode r100 = new SDKResultCode("Unknown", 0, -1);
        Unknown = r100;
        SDKResultCode r101 = new SDKResultCode("Success", 1, 1);
        Success = r101;
        SDKResultCode r102 = new SDKResultCode("NoPermission", 2, 10000);
        NoPermission = r102;
        SDKResultCode r103 = new SDKResultCode("ArgumentError", 3, 10001);
        ArgumentError = r103;
        SDKResultCode r104 = new SDKResultCode("NoAccount", 4, 10002);
        NoAccount = r104;
        SDKResultCode r105 = new SDKResultCode("NotFound", 5, 10003);
        NotFound = r105;
        SDKResultCode r106 = new SDKResultCode("StoreError", 6, 10004);
        StoreError = r106;
        SDKResultCode r107 = new SDKResultCode("NoRequestPermissionInvoker", 7, 10005);
        NoRequestPermissionInvoker = r107;
        f271067a = new SDKResultCode[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final int getValue() {
        return this.value;
    }

    public SDKResultCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
