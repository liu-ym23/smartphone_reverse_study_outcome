package com.bytedance.timon.permission.storage.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/timon/permission/storage/constant/ResultCode;", "", "", "value", "I", "getValue", "()I", "RESULT_OK", "Unknown", "NoPermission", "DeniedPermission", "DeniedDialog", "GrantDialog", "ArgumentError", "CreateSaveUriError", "permission-keeper-storage_release"}, k = 1, mv = {1, 7, 1})
public final enum ResultCode extends Enum<ResultCode> {
    public static final ResultCode ArgumentError = null;
    public static final ResultCode CreateSaveUriError = null;
    public static final ResultCode DeniedDialog = null;
    public static final ResultCode DeniedPermission = null;
    public static final ResultCode GrantDialog = null;
    public static final ResultCode NoPermission = null;
    public static final ResultCode RESULT_OK = null;
    public static final ResultCode Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultCode[] f270653a = null;
    private final int value;

    public static ResultCode valueOf(String r100) {
        return (ResultCode) a.a(ResultCode.class, r100);
    }

    public static ResultCode[] values() {
        return (ResultCode[]) f270653a.clone();
    }

    static {
        ResultCode r100 = new ResultCode("RESULT_OK", 0, -1);
        RESULT_OK = r100;
        ResultCode r101 = new ResultCode("Unknown", 1, 1);
        Unknown = r101;
        ResultCode r102 = new ResultCode("NoPermission", 2, 10000);
        NoPermission = r102;
        ResultCode r103 = new ResultCode("DeniedPermission", 3, 10001);
        DeniedPermission = r103;
        ResultCode r104 = new ResultCode("DeniedDialog", 4, 10002);
        DeniedDialog = r104;
        ResultCode r105 = new ResultCode("GrantDialog", 5, 10003);
        GrantDialog = r105;
        ResultCode r110 = new ResultCode("ArgumentError", 6, 10004);
        ArgumentError = r110;
        ResultCode r111 = new ResultCode("CreateSaveUriError", 7, 10005);
        CreateSaveUriError = r111;
        f270653a = new ResultCode[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public final int getValue() {
        return this.value;
    }

    public ResultCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
