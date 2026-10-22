package com.bytedance.bdp.appbase.service.protocol.request.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/bdp/appbase/service/protocol/request/entity/SocketRequest$OperateTask$OperationFailType", "", "Lcom/bytedance/bdp/appbase/service/protocol/request/entity/SocketRequest$OperateTask$OperationFailType;", "", "errMsg", "Ljava/lang/String;", "getErrMsg", "()Ljava/lang/String;", "WsNotConnect", "InternalError", "ParamInvalid", "SocketIsNull", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final enum SocketRequest$OperateTask$OperationFailType extends Enum<SocketRequest$OperateTask$OperationFailType> {
    public static final SocketRequest$OperateTask$OperationFailType InternalError = null;
    public static final SocketRequest$OperateTask$OperationFailType ParamInvalid = null;
    public static final SocketRequest$OperateTask$OperationFailType SocketIsNull = null;
    public static final SocketRequest$OperateTask$OperationFailType WsNotConnect = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SocketRequest$OperateTask$OperationFailType[] f200999a = null;
    private final String errMsg;

    static {
        SocketRequest$OperateTask$OperationFailType r100 = new SocketRequest$OperateTask$OperationFailType("WsNotConnect", 0, "socket is not open");
        WsNotConnect = r100;
        SocketRequest$OperateTask$OperationFailType r101 = new SocketRequest$OperateTask$OperationFailType("InternalError", 1, "internal error");
        InternalError = r101;
        SocketRequest$OperateTask$OperationFailType r102 = new SocketRequest$OperateTask$OperationFailType("ParamInvalid", 2, "param is invalid");
        ParamInvalid = r102;
        SocketRequest$OperateTask$OperationFailType r103 = new SocketRequest$OperateTask$OperationFailType("SocketIsNull", 3, "socket does not exist");
        SocketIsNull = r103;
        f200999a = new SocketRequest$OperateTask$OperationFailType[]{r100, r101, r102, r103};
    }

    public static SocketRequest$OperateTask$OperationFailType valueOf(String r100) {
        return (SocketRequest$OperateTask$OperationFailType) a.a(SocketRequest$OperateTask$OperationFailType.class, r100);
    }

    public static SocketRequest$OperateTask$OperationFailType[] values() {
        return (SocketRequest$OperateTask$OperationFailType[]) f200999a.clone();
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public SocketRequest$OperateTask$OperationFailType(String r100, int r101, String r102) {
        super(r100, r101);
        this.errMsg = r102;
    }
}
