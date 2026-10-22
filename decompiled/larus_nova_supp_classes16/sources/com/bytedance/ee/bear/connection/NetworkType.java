package com.bytedance.ee.bear.connection;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum NetworkType extends Enum<NetworkType> {
    public static final NetworkType NETWORK_2G = null;
    public static final NetworkType NETWORK_3G = null;
    public static final NetworkType NETWORK_4G = null;
    public static final NetworkType NETWORK_MOBILE = null;
    public static final NetworkType NETWORK_NO = null;
    public static final NetworkType NETWORK_UNKNOWN = null;
    public static final NetworkType NETWORK_WIFI = null;
    public static final /* synthetic */ NetworkType[] a = null;
    private String desc;

    static {
        NetworkType r0 = new NetworkType("NETWORK_UNKNOWN", 0, "Unknown");
        NETWORK_UNKNOWN = r0;
        NetworkType r1 = new NetworkType("NETWORK_WIFI", 1, "WiFi");
        NETWORK_WIFI = r1;
        NetworkType r2 = new NetworkType("NETWORK_4G", 2, "4G");
        NETWORK_4G = r2;
        NetworkType r4 = new NetworkType("NETWORK_3G", 3, "3G");
        NETWORK_3G = r4;
        NetworkType r6 = new NetworkType("NETWORK_2G", 4, "2G");
        NETWORK_2G = r6;
        NetworkType r8 = new NetworkType("NETWORK_MOBILE", 5, "MOBILE");
        NETWORK_MOBILE = r8;
        NetworkType r10 = new NetworkType("NETWORK_NO", 6, "No network");
        NETWORK_NO = r10;
        a = new NetworkType[]{r0, r1, r2, r4, r6, r8, r10};
    }

    public static NetworkType[] values() {
        return (NetworkType[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.desc;
    }

    public static NetworkType valueOf(String r1) {
        return (NetworkType) a.a(NetworkType.class, r1);
    }

    public NetworkType(String r1, int r2, String r3) {
        super(r1, r2);
        this.desc = r3;
    }
}
