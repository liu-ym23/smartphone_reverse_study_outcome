package com.bytedance.ug.sdk.luckycat.utils;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes22.dex */
public final enum NetworkUtils$NetworkType extends Enum<NetworkUtils$NetworkType> {
    public static final NetworkUtils$NetworkType MOBILE = null;
    public static final NetworkUtils$NetworkType MOBILE_2G = null;
    public static final NetworkUtils$NetworkType MOBILE_3G = null;
    public static final NetworkUtils$NetworkType MOBILE_4G = null;
    public static final NetworkUtils$NetworkType NONE = null;
    public static final NetworkUtils$NetworkType UNKNOWN = null;
    public static final NetworkUtils$NetworkType WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkUtils$NetworkType[] f271549a = null;
    final int nativeInt;

    static {
        NetworkUtils$NetworkType r100 = new NetworkUtils$NetworkType("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        NetworkUtils$NetworkType r101 = new NetworkUtils$NetworkType(UserProfileEvent.POSITION_NONE, 1, 0);
        NONE = r101;
        NetworkUtils$NetworkType r102 = new NetworkUtils$NetworkType("MOBILE", 2, 1);
        MOBILE = r102;
        NetworkUtils$NetworkType r103 = new NetworkUtils$NetworkType("MOBILE_2G", 3, 2);
        MOBILE_2G = r103;
        NetworkUtils$NetworkType r104 = new NetworkUtils$NetworkType("MOBILE_3G", 4, 3);
        MOBILE_3G = r104;
        NetworkUtils$NetworkType r105 = new NetworkUtils$NetworkType("WIFI", 5, 4);
        WIFI = r105;
        NetworkUtils$NetworkType r110 = new NetworkUtils$NetworkType("MOBILE_4G", 6, 5);
        MOBILE_4G = r110;
        f271549a = new NetworkUtils$NetworkType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static NetworkUtils$NetworkType[] values() {
        return (NetworkUtils$NetworkType[]) f271549a.clone();
    }

    public boolean is2G() {
        if (this != MOBILE) goto L5;
    L8:
        return true;
    L5:
        if (this == MOBILE_2G) goto L8;
        return false;
    }

    public boolean isAvailable() {
        if (this != UNKNOWN) goto L5;
    L7:
        return false;
    L5:
        if (this == NONE) goto L7;
        return true;
    }

    public boolean isWifi() {
        if (this != WIFI) goto L5;
        return true;
    L5:
        return false;
    }

    public int getValue() {
        return this.nativeInt;
    }

    public static NetworkUtils$NetworkType valueOf(String r100) {
        return (NetworkUtils$NetworkType) r27.a.a(NetworkUtils$NetworkType.class, r100);
    }

    public NetworkUtils$NetworkType(String r100, int r101, int r102) {
        super(r100, r101);
        this.nativeInt = r102;
    }
}
