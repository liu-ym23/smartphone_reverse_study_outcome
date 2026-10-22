package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkUtils {

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        final int nativeInt;

        static {
            NetworkType r100 = new NetworkType(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            NetworkType r101 = new NetworkType("MOBILE", 1, 1);
            MOBILE = r101;
            NetworkType r102 = new NetworkType("MOBILE_2G", 2, 2);
            MOBILE_2G = r102;
            NetworkType r103 = new NetworkType("MOBILE_3G", 3, 3);
            MOBILE_3G = r103;
            NetworkType r104 = new NetworkType("WIFI", 4, 4);
            WIFI = r104;
            NetworkType r105 = new NetworkType("MOBILE_4G", 5, 5);
            MOBILE_4G = r105;
            $VALUES = new NetworkType[]{r100, r101, r102, r103, r104, r105};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.nativeInt;
        }

        public static NetworkType valueOf(String r100) {
            return (NetworkType) a.a(NetworkType.class, r100);
        }

        private NetworkType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }
    }

    public static int getNetworkState(Context r100) {
        boolean r101 = isNetworkAvailable(r100);
        NetworkType r102 = getNetworkType(r100);
        if (r101 == true) goto L6;
        return 2;
    L6:
        if (NetworkType.WIFI != r102) goto L9;
        return 3;
    L9:
        if (NetworkType.NONE == r102) goto L11;
        return 4;
    L11:
        return 1;
    }

    public static NetworkType getNetworkType(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L47
        if (r101 == null) goto L46;
        if (r101.isAvailable() == false) goto L46;
        int r102 = r101.getType();     // Catch: Throwable -> L47
        if (1 == r102) goto L10;
        if (r102 != 0) goto L44;
        TelephonyManager r103 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Throwable -> L47
        if (r103 != null) goto L17;
        return NetworkType.MOBILE;
    L17:
        if (r103.getNetworkType() == 3) goto L42;
        if (r103.getNetworkType() == 5) goto L42;
        if (r103.getNetworkType() == 6) goto L42;
        if (r103.getNetworkType() == 8) goto L42;
        if (r103.getNetworkType() == 9) goto L42;
        if (r103.getNetworkType() == 10) goto L42;
        if (r103.getNetworkType() == 12) goto L42;
        if (r103.getNetworkType() == 14) goto L42;
        if (r103.getNetworkType() == 15) goto L42;
        if (r103.getNetworkType() != 13) goto L40;
        return NetworkType.MOBILE_4G;
    L40:
        return NetworkType.MOBILE;
    L42:
        return NetworkType.MOBILE_3G;
    L44:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L46:
        return NetworkType.NONE;
    L48:
        return NetworkType.MOBILE;
    }

    public static boolean isNetworkAvailable(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r101 == null) goto L12;
        if (r101.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }
}
