package com.ss.android.lark.officesdk.utils.net;

import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum NetworkType extends Enum<NetworkType> {
    public static final NetworkType NETWORK_2G = null;
    public static final NetworkType NETWORK_3G = null;
    public static final NetworkType NETWORK_4G = null;
    public static final NetworkType NETWORK_5G = null;
    public static final NetworkType NETWORK_MOBILE = null;
    public static final NetworkType NETWORK_NO = null;
    public static final NetworkType NETWORK_UNKNOWN = null;
    public static final NetworkType NETWORK_WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkType[] f437239a = null;

    static {
        NetworkType r100 = new NetworkType("NETWORK_NO", 0);
        NETWORK_NO = r100;
        NetworkType r101 = new NetworkType("NETWORK_WIFI", 1);
        NETWORK_WIFI = r101;
        NetworkType r102 = new NetworkType("NETWORK_2G", 2);
        NETWORK_2G = r102;
        NetworkType r103 = new NetworkType("NETWORK_3G", 3);
        NETWORK_3G = r103;
        NetworkType r104 = new NetworkType("NETWORK_4G", 4);
        NETWORK_4G = r104;
        NetworkType r105 = new NetworkType("NETWORK_5G", 5);
        NETWORK_5G = r105;
        NetworkType r110 = new NetworkType("NETWORK_MOBILE", 6);
        NETWORK_MOBILE = r110;
        NetworkType r111 = new NetworkType("NETWORK_UNKNOWN", 7);
        NETWORK_UNKNOWN = r111;
        f437239a = new NetworkType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static NetworkType[] values() {
        return (NetworkType[]) f437239a.clone();
    }

    public static NetworkType valueOf(String r100) {
        return (NetworkType) a.a(NetworkType.class, r100);
    }

    public NetworkType(String r100, int r101) {
        super(r100, r101);
    }
}
