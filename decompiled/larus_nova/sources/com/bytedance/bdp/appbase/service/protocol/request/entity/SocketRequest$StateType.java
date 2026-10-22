package com.bytedance.bdp.appbase.service.protocol.request.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"com/bytedance/bdp/appbase/service/protocol/request/entity/SocketRequest$StateType", "", "Lcom/bytedance/bdp/appbase/service/protocol/request/entity/SocketRequest$StateType;", "ON_OPEN", "ON_MESSAGE", "ON_CLOSING", "ON_CLOSED", "ON_FAIL", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final enum SocketRequest$StateType extends Enum<SocketRequest$StateType> {
    public static final SocketRequest$StateType ON_CLOSED = null;
    public static final SocketRequest$StateType ON_CLOSING = null;
    public static final SocketRequest$StateType ON_FAIL = null;
    public static final SocketRequest$StateType ON_MESSAGE = null;
    public static final SocketRequest$StateType ON_OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SocketRequest$StateType[] f201000a = null;

    static {
        SocketRequest$StateType r100 = new SocketRequest$StateType("ON_OPEN", 0);
        ON_OPEN = r100;
        SocketRequest$StateType r101 = new SocketRequest$StateType("ON_MESSAGE", 1);
        ON_MESSAGE = r101;
        SocketRequest$StateType r102 = new SocketRequest$StateType("ON_CLOSING", 2);
        ON_CLOSING = r102;
        SocketRequest$StateType r103 = new SocketRequest$StateType("ON_CLOSED", 3);
        ON_CLOSED = r103;
        SocketRequest$StateType r104 = new SocketRequest$StateType("ON_FAIL", 4);
        ON_FAIL = r104;
        f201000a = new SocketRequest$StateType[]{r100, r101, r102, r103, r104};
    }

    public static SocketRequest$StateType valueOf(String r100) {
        return (SocketRequest$StateType) a.a(SocketRequest$StateType.class, r100);
    }

    public static SocketRequest$StateType[] values() {
        return (SocketRequest$StateType[]) f201000a.clone();
    }

    public SocketRequest$StateType(String r100, int r101) {
        super(r100, r101);
    }
}
