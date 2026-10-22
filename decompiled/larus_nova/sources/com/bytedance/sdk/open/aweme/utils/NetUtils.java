package com.bytedance.sdk.open.aweme.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public class NetUtils {

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        final int nativeInt;

        static {
            NetworkType r100 = new NetworkType("MOBILE", 0, 0);
            MOBILE = r100;
            NetworkType r101 = new NetworkType("WIFI", 1, 1);
            WIFI = r101;
            NetworkType r102 = new NetworkType(UserProfileEvent.POSITION_NONE, 2, 2);
            NONE = r102;
            $VALUES = new NetworkType[]{r100, r101, r102};
        }

        private NetworkType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }

        public static NetworkType valueOf(String r100) {
            return (NetworkType) a.a(NetworkType.class, r100);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.nativeInt;
        }
    }

    public NetUtils() {
    }

    public static NetworkType getNetWorkType(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L18
        if (r101 == null) goto L17;
        if (r101.isAvailable() == false) goto L17;
        int r102 = r101.getType();     // Catch: Exception -> L18
        if (1 == r102) goto L10;
        if (r102 != 0) goto L15;
        return NetworkType.MOBILE;
    L15:
        return NetworkType.NONE;
    L10:
        return NetworkType.WIFI;
    L17:
        return NetworkType.NONE;
    L19:
        return NetworkType.MOBILE;
    }

    public static boolean isNetworkAvailable(Context r100) {
        if (r100 != null) goto L19;
        return true;
    L19:
        NetworkInfo[] r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getAllNetworkInfo();     // Catch: Exception -> L18
        if (r101 == null) goto L16;
        int r102 = r101.length;     // Catch: Exception -> L18
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L16;
        NetworkInfo r104 = r101[r103];     // Catch: Exception -> L18
        if (r104.isAvailable() == false) goto L15;
        if (r104.getState() != NetworkInfo.State.CONNECTED) goto L15;
        return true;
    L15:
        r103 = r103 + 1;
    L16:
        return false;
    }
}
