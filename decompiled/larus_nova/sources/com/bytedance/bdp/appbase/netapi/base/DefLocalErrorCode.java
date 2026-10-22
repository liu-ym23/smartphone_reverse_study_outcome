package com.bytedance.bdp.appbase.netapi.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/base/DefLocalErrorCode;", "", "()V", "fatalError", "Lcom/bytedance/bdp/appbase/netapi/base/ErrorCode;", "interruptError", "netError", "netNotAvailableError", "reqParamError", "resultParseError", "success", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public final class DefLocalErrorCode {
    public static final DefLocalErrorCode INSTANCE = null;
    public static final ErrorCode fatalError = null;
    public static final ErrorCode interruptError = null;
    public static final ErrorCode netError = null;
    public static final ErrorCode netNotAvailableError = null;
    public static final ErrorCode reqParamError = null;
    public static final ErrorCode resultParseError = null;
    public static final ErrorCode success = null;

    private DefLocalErrorCode() {
    }

    static {
        INSTANCE = new DefLocalErrorCode();
        success = new ErrorCode(0, "success");
        fatalError = new ErrorCode(-10000, "fatal error");
        netError = new ErrorCode(-10001, "net error");
        reqParamError = new ErrorCode(-10002, "request param error");
        resultParseError = new ErrorCode(-10003, "server result error");
        interruptError = new ErrorCode(-10004, "interrupt exception error");
        netNotAvailableError = new ErrorCode(-10005, "net not available");
    }
}
