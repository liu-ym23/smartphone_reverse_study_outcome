package com.ss.android.lark.download.service;

import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum NetworkType extends Enum<NetworkType> {
    public static final NetworkType CELLULAR_DATA_NETWORK = null;
    public static final NetworkType NO_INTERNET_CONNECTION = null;
    public static final NetworkType WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkType[] f420525a = null;
    private int value;

    static {
        NetworkType r100 = new NetworkType("NO_INTERNET_CONNECTION", 0, 1);
        NO_INTERNET_CONNECTION = r100;
        NetworkType r101 = new NetworkType("CELLULAR_DATA_NETWORK", 1, 2);
        CELLULAR_DATA_NETWORK = r101;
        NetworkType r102 = new NetworkType("WIFI", 2, 3);
        WIFI = r102;
        f420525a = new NetworkType[]{r100, r101, r102};
    }

    public static NetworkType[] values() {
        return (NetworkType[]) f420525a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static NetworkType forNumber(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return WIFI;
    L13:
        return CELLULAR_DATA_NETWORK;
    L15:
        return NO_INTERNET_CONNECTION;
    }

    public static NetworkType valueOf(String r100) {
        return (NetworkType) a.a(NetworkType.class, r100);
    }

    public static NetworkType valueOf(int r100) {
        return forNumber(r100);
    }

    public NetworkType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
