package com.ss.videoarch.nliveplayer.utils;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public class NetworkMonitor {

    public static final enum NetType extends Enum<NetType> {
        public static final NetType BLUETOOTH = null;
        public static final NetType CELLULAR = null;
        public static final NetType ETHERNET = null;
        public static final NetType NONE = null;
        public static final NetType VPN = null;
        public static final NetType WIFI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NetType[] f459712a = null;

        static {
            NetType r100 = new NetType("CELLULAR", 0);
            CELLULAR = r100;
            NetType r101 = new NetType("WIFI", 1);
            WIFI = r101;
            NetType r102 = new NetType("BLUETOOTH", 2);
            BLUETOOTH = r102;
            NetType r103 = new NetType("ETHERNET", 3);
            ETHERNET = r103;
            NetType r104 = new NetType("VPN", 4);
            VPN = r104;
            NetType r105 = new NetType(UserProfileEvent.POSITION_NONE, 5);
            NONE = r105;
            f459712a = new NetType[]{r100, r101, r102, r103, r104, r105};
        }

        public static NetType[] values() {
            return (NetType[]) f459712a.clone();
        }

        public static NetType valueOf(String r100) {
            return (NetType) a.a(NetType.class, r100);
        }

        public NetType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public NetworkMonitor() {
    }

    private static native void onConnectionProperties(String r100);

    private static native void onNetBlockStatusChange(boolean r100);

    private static native void onNetCapabilitiesChanged(int r100, int r101);

    private static native void onNetLost();

    private static native void onNetUnavailable();

    private static native void onNetworkAvailable();
}
