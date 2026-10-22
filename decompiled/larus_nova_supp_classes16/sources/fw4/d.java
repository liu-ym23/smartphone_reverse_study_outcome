package fw4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.ee.bear.connection.NetworkType;
import com.bytedance.ee.bear.connection.rust.NetStateChangeRustManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static NetworkType a() {
        int r0 = c.a;
        return NetStateChangeRustManager.e.c;
    }

    public static NetworkType b(Context r3) {
        if (r3 != null) goto L30;
        tt5.a.h("NetworkCheck", "getNetworkState: context == null");
        return NetworkType.NETWORK_NO;
    L30:
        NetworkInfo r1 = ((ConnectivityManager) r3.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L27
        if (r1 != null) goto L9;
    L25:
        tt5.a.h("NetworkCheck", "getNetworkState: info is null or not available.");     // Catch: Throwable -> L27
        return NetworkType.NETWORK_NO;
    L9:
        if (r1.isAvailable() == false) goto L25;
        int r2 = r1.getType();     // Catch: Throwable -> L27
        if (1 != r2) goto L15;
        tt5.a.h("NetworkCheck", "getNetworkState: type is wifi");     // Catch: Throwable -> L27
        return NetworkType.NETWORK_WIFI;
    L15:
        if (r2 != 0) goto L24;
        tt5.a.h("NetworkCheck", "getNetworkState: type is mobile");     // Catch: Throwable -> L27
        switch(((TelephonyManager) r3.getSystemService("phone")).getNetworkType()) {
            case 3: goto L22;
            case 4: goto L31;
            case 5: goto L22;
            case 6: goto L22;
            case 7: goto L31;
            case 8: goto L22;
            case 9: goto L22;
            case 10: goto L22;
            case 11: goto L31;
            case 12: goto L22;
            case 13: goto L20;
            case 14: goto L22;
            case 15: goto L22;
            default: goto L31;
        };     // Catch: Throwable -> L27
    L31:
        return NetworkType.NETWORK_MOBILE;
    L20:
        return NetworkType.NETWORK_4G;
    L22:
        return NetworkType.NETWORK_3G;
    L24:
        return NetworkType.NETWORK_MOBILE;
    L27:
        th = move-exception;
        tt5.a.d("network", th.getMessage());
        return NetworkType.NETWORK_UNKNOWN;
    }
}
