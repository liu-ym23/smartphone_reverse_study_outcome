package twb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.ss.android.lark.officesdk.utils.net.NetworkType;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public static NetworkType a(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L35
        if (r101 == null) goto L5;
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Throwable -> L35
    L6:
        if (r102 == null) goto L34;
        if (r102.isAvailable() == false) goto L34;
        int r103 = r102.getType();     // Catch: Throwable -> L35
        if (r103 == 1) goto L13;
        if (r103 != 0) goto L32;
        TelephonyManager r104 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Throwable -> L35
        if (r104 == null) goto L18;
        int r105 = r104.getNetworkType();     // Catch: Throwable -> L35
    L19:
        switch(r105) {
            case 1: goto L28;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L28;
            case 5: goto L26;
            case 6: goto L26;
            case 7: goto L28;
            case 8: goto L26;
            case 9: goto L26;
            case 10: goto L26;
            case 11: goto L28;
            case 12: goto L26;
            case 13: goto L24;
            case 14: goto L26;
            case 15: goto L26;
            default: goto L21;
        };     // Catch: Throwable -> L35
    L21:
        if (r105 != 20) goto L30;
        return NetworkType.NETWORK_5G;
    L30:
        return NetworkType.NETWORK_MOBILE;
    L24:
        return NetworkType.NETWORK_4G;
    L26:
        return NetworkType.NETWORK_3G;
    L28:
        return NetworkType.NETWORK_2G;
    L18:
        r105 = 0;
        goto L19
    L32:
        return NetworkType.NETWORK_MOBILE;
    L13:
        return NetworkType.NETWORK_WIFI;
    L34:
        return NetworkType.NETWORK_NO;
    L5:
        r102 = null;
        goto L6
    L36:
        return NetworkType.NETWORK_UNKNOWN;
    }
}
