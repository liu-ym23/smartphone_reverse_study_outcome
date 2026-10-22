package com.ss.alive.monitor.model;

import com.bytedance.mira.stub.BaseStubService;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum StartType extends Enum<StartType> {
    public static final StartType BIND_SERVICE = null;
    public static final StartType PROVIDER_GET_TYPE = null;
    public static final StartType PROVIDER_QUERY = null;
    public static final StartType SEND_BROADCAST = null;
    public static final StartType START_ACTIVITY = null;
    public static final StartType START_SERVICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StartType[] f406209a = null;
    public final String methodName;
    public final String startType;

    static {
        StartType r100 = new StartType("START_SERVICE", 0, "startService", BaseStubService.CodeConst.EXTRA_START_SERVICE);
        START_SERVICE = r100;
        StartType r101 = new StartType("BIND_SERVICE", 1, "bindIsolatedService", "bind_service");
        BIND_SERVICE = r101;
        StartType r102 = new StartType("PROVIDER_GET_TYPE", 2, "getProviderMimeType", "provider_get_type");
        PROVIDER_GET_TYPE = r102;
        StartType r103 = new StartType("PROVIDER_QUERY", 3, "getContentProvider", "provider_query");
        PROVIDER_QUERY = r103;
        StartType r104 = new StartType("SEND_BROADCAST", 4, "broadcastIntent", "send_broadcast");
        SEND_BROADCAST = r104;
        StartType r105 = new StartType("START_ACTIVITY", 5, "startActivity", "start_activity");
        START_ACTIVITY = r105;
        f406209a = new StartType[]{r100, r101, r102, r103, r104, r105};
    }

    public static StartType[] values() {
        return (StartType[]) f406209a.clone();
    }

    public static StartType valueOf(String r100) {
        return (StartType) a.a(StartType.class, r100);
    }

    public StartType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.methodName = r102;
        this.startType = r103;
    }
}
