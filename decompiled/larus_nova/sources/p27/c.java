package p27;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static int a(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L23
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (r101.isAvailable() == false) goto L26;
        int r102 = r101.getType();     // Catch: Throwable -> L23
        if (1 != r102) goto L12;
        return 4;
    L12:
        if (r102 != 0) goto L20;
        switch(((TelephonyManager) r100.getSystemService("phone")).getNetworkType()) {
            case 3: goto L18;
            case 4: goto L15;
            case 5: goto L18;
            case 6: goto L18;
            case 7: goto L15;
            case 8: goto L18;
            case 9: goto L18;
            case 10: goto L18;
            case 11: goto L15;
            case 12: goto L18;
            case 13: goto L16;
            case 14: goto L18;
            case 15: goto L18;
            default: goto L15;
        };
    L15:
        return 1;
    L16:
        return 5;
    L18:
        return 3;
    L20:
        return 1;
    L26:
        return 0;
    L23:
        return 1;
    }
}
