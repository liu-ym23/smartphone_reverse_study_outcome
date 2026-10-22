package com.bytedance.ee.lark.infra.network.ref;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum NetworkConstant$RequestSource extends Enum<NetworkConstant$RequestSource> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkConstant$RequestSource[] f242806a = null;
    public static final NetworkConstant$RequestSource api = null;
    public static final NetworkConstant$RequestSource block = null;
    public static final NetworkConstant$RequestSource microAppContainer = null;
    public static final NetworkConstant$RequestSource msgCard = null;
    public static final NetworkConstant$RequestSource openAppCenter = null;
    public static final NetworkConstant$RequestSource other = null;
    public static final NetworkConstant$RequestSource webApp = null;

    static {
        NetworkConstant$RequestSource r100 = new NetworkConstant$RequestSource("microAppContainer", 0);
        microAppContainer = r100;
        NetworkConstant$RequestSource r101 = new NetworkConstant$RequestSource("webApp", 1);
        webApp = r101;
        NetworkConstant$RequestSource r102 = new NetworkConstant$RequestSource("api", 2);
        api = r102;
        NetworkConstant$RequestSource r103 = new NetworkConstant$RequestSource("msgCard", 3);
        msgCard = r103;
        NetworkConstant$RequestSource r104 = new NetworkConstant$RequestSource("openAppCenter", 4);
        openAppCenter = r104;
        NetworkConstant$RequestSource r105 = new NetworkConstant$RequestSource("block", 5);
        block = r105;
        NetworkConstant$RequestSource r110 = new NetworkConstant$RequestSource("other", 6);
        other = r110;
        f242806a = new NetworkConstant$RequestSource[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static NetworkConstant$RequestSource[] values() {
        return (NetworkConstant$RequestSource[]) f242806a.clone();
    }

    public static NetworkConstant$RequestSource valueOf(String r100) {
        return (NetworkConstant$RequestSource) a.a(NetworkConstant$RequestSource.class, r100);
    }

    public NetworkConstant$RequestSource(String r100, int r101) {
        super(r100, r101);
    }
}
