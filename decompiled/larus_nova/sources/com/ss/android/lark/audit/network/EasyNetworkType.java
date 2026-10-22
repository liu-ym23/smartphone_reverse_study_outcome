package com.ss.android.lark.audit.network;

import com.ss.android.lark.http.netstate.NetworkUtils;

/* JADX INFO: loaded from: classes34.dex */
public final enum EasyNetworkType extends Enum<EasyNetworkType> {
    public static final EasyNetworkType CELLULAR_DATA_NETWORK = null;
    public static final EasyNetworkType NO_INTERNET_CONNECTION = null;
    public static final EasyNetworkType VPN = null;
    public static final EasyNetworkType WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EasyNetworkType[] f409452a = null;
    private String typeName;
    private int value;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f409453a = null;

        static {
            int[] r100 = new int[NetworkUtils.NetworkType.values().length];
            f409453a = r100;
            r100[NetworkUtils.NetworkType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f409453a[NetworkUtils.NetworkType.MOBILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f409453a[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f409453a[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f409453a[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f409453a[NetworkUtils.NetworkType.UNKNOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f409453a[NetworkUtils.NetworkType.WIFI.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    static {
        EasyNetworkType r100 = new EasyNetworkType("NO_INTERNET_CONNECTION", 0, 1, "NO_INTERNET_CONNECTION");
        NO_INTERNET_CONNECTION = r100;
        EasyNetworkType r101 = new EasyNetworkType("CELLULAR_DATA_NETWORK", 1, 2, "CELLULAR_DATA_NETWORK");
        CELLULAR_DATA_NETWORK = r101;
        EasyNetworkType r102 = new EasyNetworkType("WIFI", 2, 3, "WIFI");
        WIFI = r102;
        EasyNetworkType r103 = new EasyNetworkType("VPN", 3, 4, "VPN");
        VPN = r103;
        f409452a = new EasyNetworkType[]{r100, r101, r102, r103};
    }

    public static EasyNetworkType[] values() {
        return (EasyNetworkType[]) f409452a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EasyNetworkType{value=" + this.value + ", typeName='" + this.typeName + "'}";
    }

    public int getNumber() {
        return this.value;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public static EasyNetworkType forNumber(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return WIFI;
    L9:
        return CELLULAR_DATA_NETWORK;
    L11:
        return NO_INTERNET_CONNECTION;
    }

    public static EasyNetworkType getBasicEasyType(NetworkUtils.NetworkType r100) {
        int r101 = a.f409453a[r100.ordinal()];
        if (r101 == 1) goto L17;
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L15;
        if (r101 == 4) goto L15;
        if (r101 == 5) goto L15;
        return WIFI;
    L15:
        return CELLULAR_DATA_NETWORK;
    L17:
        return NO_INTERNET_CONNECTION;
    }

    public static EasyNetworkType valueOf(String r100) {
        return (EasyNetworkType) r27.a.a(EasyNetworkType.class, r100);
    }

    public static EasyNetworkType valueOf(int r100) {
        return forNumber(r100);
    }

    public EasyNetworkType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.typeName = r103;
    }
}
