package com.ss.android.lark.rustinfrabridge.netstate.api;

/* JADX INFO: loaded from: classes38.dex */
public final enum WSConnState$ConnState extends Enum<WSConnState$ConnState> {
    public static final WSConnState$ConnState ConnectClosed = null;
    public static final WSConnState$ConnState ConnectFailed = null;
    public static final WSConnState$ConnState ConnectUnknown = null;
    public static final WSConnState$ConnState Connected = null;
    public static final WSConnState$ConnState Connecting = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WSConnState$ConnState[] f439692a = null;

    static {
        WSConnState$ConnState r100 = new WSConnState$ConnState("ConnectUnknown", 0);
        ConnectUnknown = r100;
        WSConnState$ConnState r101 = new WSConnState$ConnState("Connecting", 1);
        Connecting = r101;
        WSConnState$ConnState r102 = new WSConnState$ConnState("ConnectFailed", 2);
        ConnectFailed = r102;
        WSConnState$ConnState r103 = new WSConnState$ConnState("ConnectClosed", 3);
        ConnectClosed = r103;
        WSConnState$ConnState r104 = new WSConnState$ConnState("Connected", 4);
        Connected = r104;
        f439692a = new WSConnState$ConnState[]{r100, r101, r102, r103, r104};
    }

    public static WSConnState$ConnState[] values() {
        return (WSConnState$ConnState[]) f439692a.clone();
    }

    public static WSConnState$ConnState valueOf(String r100) {
        return (WSConnState$ConnState) r27.a.a(WSConnState$ConnState.class, r100);
    }

    public WSConnState$ConnState(String r100, int r101) {
        super(r100, r101);
    }
}
