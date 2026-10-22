package com.bytedance.bdp.bdpbase.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;

/* JADX INFO: loaded from: classes11.dex */
public final class h {
    public static boolean a(Context r100) {
        boolean r101 = true;
        if (r100 != null) goto L20;
        return true;
    L20:
        NetworkInfo[] r102 = ((ConnectivityManager) r100.getSystemService("connectivity")).getAllNetworkInfo();     // Catch: Exception -> L19
        if (r102 == null) goto L16;
        int r103 = r102.length;     // Catch: Exception -> L19
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L16;
        NetworkInfo r105 = r102[r104];     // Catch: Exception -> L19
        if (r105.isAvailable() == false) goto L15;
        if (r105.getState() != NetworkInfo.State.CONNECTED) goto L15;
    L18:
        return r101;
    L15:
        r104 = r104 + 1;
    L16:
        r101 = false;
    L26:
        return false;
    }

    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (r100.endsWith(HTTP.URL_DEFAULT) == true) goto L7;
        return r100;
    L7:
        return r100.substring(0, r100.length() - 1);
    }
}
