package com.ss.android.lark.chameleon.util;

import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum NetworkType extends Enum<NetworkType> {
    private static final /* synthetic */ NetworkType[] $VALUES = null;
    public static final NetworkType NETWORK_2G = null;
    public static final NetworkType NETWORK_3G = null;
    public static final NetworkType NETWORK_4G = null;
    public static final NetworkType NETWORK_MOBILE = null;
    public static final NetworkType NETWORK_NO = null;
    public static final NetworkType NETWORK_UNKNOWN = null;
    public static final NetworkType NETWORK_WIFI = null;
    private String desc;

    static {
        NetworkType r100 = new NetworkType("NETWORK_UNKNOWN", 0, "Unknown");
        NETWORK_UNKNOWN = r100;
        NetworkType r101 = new NetworkType("NETWORK_WIFI", 1, "WiFi");
        NETWORK_WIFI = r101;
        NetworkType r102 = new NetworkType("NETWORK_4G", 2, "4G");
        NETWORK_4G = r102;
        NetworkType r103 = new NetworkType("NETWORK_3G", 3, "3G");
        NETWORK_3G = r103;
        NetworkType r104 = new NetworkType("NETWORK_2G", 4, "2G");
        NETWORK_2G = r104;
        NetworkType r105 = new NetworkType("NETWORK_MOBILE", 5, "MOBILE");
        NETWORK_MOBILE = r105;
        NetworkType r110 = new NetworkType("NETWORK_NO", 6, "No network");
        NETWORK_NO = r110;
        $VALUES = new NetworkType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static NetworkType[] values() {
        return (NetworkType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.desc;
    }

    public static NetworkType valueOf(String r100) {
        return (NetworkType) a.a(NetworkType.class, r100);
    }

    private NetworkType(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
