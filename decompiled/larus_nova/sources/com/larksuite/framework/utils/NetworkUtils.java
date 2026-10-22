package com.larksuite.framework.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes24.dex */
public final class NetworkUtils {

    public static final enum CompressType extends Enum<CompressType> {
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CompressType[] f285914a = null;
        final int nativeInt;

        static {
            CompressType r100 = new CompressType(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            CompressType r101 = new CompressType("GZIP", 1, 1);
            GZIP = r101;
            CompressType r102 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r102;
            f285914a = new CompressType[]{r100, r101, r102};
        }

        public static CompressType[] values() {
            return (CompressType[]) f285914a.clone();
        }

        public static CompressType valueOf(String r100) {
            return (CompressType) r27.a.a(CompressType.class, r100);
        }

        public CompressType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType MOBILE_5G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType UNKNOWN = null;
        public static final NetworkType WIFI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NetworkType[] f285915a = null;
        final int nativeInt;
        private final String nativeName;

        static {
            NetworkType r100 = new NetworkType(UserProfileEvent.POSITION_NONE, 0, 0, "unvailable");
            NONE = r100;
            NetworkType r101 = new NetworkType("MOBILE", 1, 1, "mobile");
            MOBILE = r101;
            NetworkType r102 = new NetworkType("MOBILE_2G", 2, 2, "mobile_2g");
            MOBILE_2G = r102;
            NetworkType r103 = new NetworkType("MOBILE_3G", 3, 3, "mobile_3g");
            MOBILE_3G = r103;
            NetworkType r104 = new NetworkType("WIFI", 4, 4, "wifi");
            WIFI = r104;
            NetworkType r105 = new NetworkType("MOBILE_4G", 5, 5, "mobile_4g");
            MOBILE_4G = r105;
            NetworkType r110 = new NetworkType("MOBILE_5G", 6, 6, "mobile_5g");
            MOBILE_5G = r110;
            NetworkType r111 = new NetworkType("UNKNOWN", 7, 7, "unknown");
            UNKNOWN = r111;
            f285915a = new NetworkType[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) f285915a.clone();
        }

        public String getNativeName() {
            return this.nativeName;
        }

        public int getValue() {
            return this.nativeInt;
        }

        public static NetworkType valueOf(String r100) {
            return (NetworkType) r27.a.a(NetworkType.class, r100);
        }

        public NetworkType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.nativeInt = r102;
            this.nativeName = r103;
        }
    }

    public static NetworkType a(int r100) {
        switch(r100) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L10;
            case 10: goto L10;
            case 11: goto L12;
            case 12: goto L10;
            case 13: goto L8;
            case 14: goto L10;
            case 15: goto L10;
            case 16: goto L12;
            case 17: goto L4;
            case 18: goto L10;
            case 19: goto L4;
            case 20: goto L6;
            default: goto L4;
        };
    L4:
        return NetworkType.MOBILE;
    L6:
        return NetworkType.MOBILE_5G;
    L8:
        return NetworkType.MOBILE_4G;
    L10:
        return NetworkType.MOBILE_3G;
    L12:
        return NetworkType.MOBILE_2G;
    }

    public static NetworkType b(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L43
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Throwable -> L43
        if (r102 != null) goto L6;
    L39:
        int r103 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L43
        Log.i("NetworkUtils", "old getNetworkType info == null || !info.isAvailable(), apinum is " + r103);     // Catch: Throwable -> L43
        NetworkType r104 = c(r100);     // Catch: Throwable -> L43
        if (r104 == NetworkType.NONE) goto L42;
        Log.e("NetworkUtils", "new getNetworkType correct nettype, apinum is " + r103, null, true);     // Catch: Throwable -> L43
    L42:
        return r104;
    L6:
        if (r102.isAvailable() == false) goto L39;
        int r105 = r102.getType();     // Catch: Throwable -> L43
        if (1 == r105) goto L11;
        if (r105 != 0) goto L38;
        if (Build.VERSION.SDK_INT <= 29) goto L36;
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L43
        Network[] r107 = r101.getAllNetworks();     // Catch: Throwable -> L43
        int r108 = r107.length;     // Catch: Throwable -> L43
        int r109 = 0;
    L16:
        if (r109 >= r108) goto L26;
        NetworkInfo r110 = r101.getNetworkInfo(r107[r109]);     // Catch: Throwable -> L43
        if (r110 == null) goto L25;
        NetworkInfo.State r111 = r110.getState();     // Catch: Throwable -> L43
        if (r111 != NetworkInfo.State.CONNECTING) goto L23;
    L24:
        r106.add(r110);     // Catch: Throwable -> L43
        goto L25
    L23:
        if (r111 == NetworkInfo.State.CONNECTED) goto L24;
    L25:
        r109 = r109 + 1;     // Catch: Throwable -> L43
        goto L16
    L26:
        Iterator r112 = r106.iterator();     // Catch: Throwable -> L43
    L28:
        if (r112.hasNext() == false) goto L34;
        NetworkInfo r113 = (NetworkInfo) r112.next();     // Catch: Throwable -> L43
        if ("MOBILE".equals(r113.getTypeName()) == false) goto L28;
        return a(r113.getSubtype());
    L34:
        return NetworkType.MOBILE;
    L36:
        return a(((TelephonyManager) r100.getSystemService("phone")).getNetworkType());
    L38:
        return NetworkType.MOBILE;
    L11:
        return NetworkType.WIFI;
    L43:
        th = move-exception;
        Log.e("network", th.getMessage());
        return NetworkType.MOBILE;
    }

    public static NetworkType c(Context r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        Log.i("NetworkUtils", "current os verion < M，cannot support this method judge network!");
        return NetworkType.NONE;
    L6:
        ConnectivityManager r101 = (ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity");
        Network r102 = r101.getActiveNetwork();
        if (r102 != null) goto L10;
        Log.w("NetworkUtils", "ConnectivityManager.getActiveNetwork return null");
        return NetworkType.NONE;
    L10:
        NetworkCapabilities r103 = r101.getNetworkCapabilities(r102);
        if (r103 == null) goto L17;
        if (r103.hasTransport(0) == false) goto L17;
        return NetworkType.MOBILE_4G;
    L17:
        return NetworkType.WIFI;
    }

    public static boolean d(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
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

    public static boolean e(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.isAvailable() == false) goto L17;
        if (1 != r101.getType()) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L19:
        return false;
    }
}
