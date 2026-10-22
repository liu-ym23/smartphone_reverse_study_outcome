package com.bytedance.gamecenter.base;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes19.dex */
public final enum NetworkUtils$NetworkType extends Enum<NetworkUtils$NetworkType> {
    public static final NetworkUtils$NetworkType MOBILE = null;
    public static final NetworkUtils$NetworkType MOBILE_2G = null;
    public static final NetworkUtils$NetworkType MOBILE_3G = null;
    public static final NetworkUtils$NetworkType MOBILE_4G = null;
    public static final NetworkUtils$NetworkType NONE = null;
    public static final NetworkUtils$NetworkType WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkUtils$NetworkType[] f244938a = null;
    final int nativeInt;

    static {
        NetworkUtils$NetworkType r100 = new NetworkUtils$NetworkType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        NetworkUtils$NetworkType r101 = new NetworkUtils$NetworkType("MOBILE", 1, 1);
        MOBILE = r101;
        NetworkUtils$NetworkType r102 = new NetworkUtils$NetworkType("MOBILE_2G", 2, 2);
        MOBILE_2G = r102;
        NetworkUtils$NetworkType r103 = new NetworkUtils$NetworkType("MOBILE_3G", 3, 3);
        MOBILE_3G = r103;
        NetworkUtils$NetworkType r104 = new NetworkUtils$NetworkType("WIFI", 4, 4);
        WIFI = r104;
        NetworkUtils$NetworkType r105 = new NetworkUtils$NetworkType("MOBILE_4G", 5, 5);
        MOBILE_4G = r105;
        f244938a = new NetworkUtils$NetworkType[]{r100, r101, r102, r103, r104, r105};
    }

    public static NetworkUtils$NetworkType[] values() {
        return (NetworkUtils$NetworkType[]) f244938a.clone();
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
