package com.larus.im.ws;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/im/ws/FlowWsConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CONNECTING", "CONNECTED", "CONNECT_CLOSED", "CONNECT_FAILED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowWsConnectionState extends Enum<FlowWsConnectionState> {
    public static final FlowWsConnectionState CONNECTED = null;
    public static final FlowWsConnectionState CONNECTING = null;
    public static final FlowWsConnectionState CONNECT_CLOSED = null;
    public static final FlowWsConnectionState CONNECT_FAILED = null;
    public static final FlowWsConnectionState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowWsConnectionState[] f350907a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350908b = null;

    public static EnumEntries<FlowWsConnectionState> getEntries() {
        return f350908b;
    }

    static {
        FlowWsConnectionState r100 = new FlowWsConnectionState("UNKNOWN", 0);
        UNKNOWN = r100;
        FlowWsConnectionState r101 = new FlowWsConnectionState("CONNECTING", 1);
        CONNECTING = r101;
        FlowWsConnectionState r102 = new FlowWsConnectionState("CONNECTED", 2);
        CONNECTED = r102;
        FlowWsConnectionState r103 = new FlowWsConnectionState("CONNECT_CLOSED", 3);
        CONNECT_CLOSED = r103;
        FlowWsConnectionState r104 = new FlowWsConnectionState("CONNECT_FAILED", 4);
        CONNECT_FAILED = r104;
        FlowWsConnectionState[] r105 = {r100, r101, r102, r103, r104};
        f350907a = r105;
        f350908b = EnumEntriesKt.enumEntries(r105);
    }

    public static FlowWsConnectionState[] values() {
        return (FlowWsConnectionState[]) f350907a.clone();
    }

    public static FlowWsConnectionState valueOf(String r100) {
        return (FlowWsConnectionState) a.a(FlowWsConnectionState.class, r100);
    }

    public FlowWsConnectionState(String r100, int r101) {
        super(r100, r101);
    }
}
