package com.huawei.hms.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class g {
    public static int a(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();
        if (r101 != null) goto L5;
    L8:
        HMSLog.i("NetworkUtil", "no connected network");
        return -1;
    L5:
        if (r101.isConnected() == false) goto L8;
        return r101.getType();
    }
}
