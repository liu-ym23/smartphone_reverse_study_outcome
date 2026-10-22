package com.vivo.push.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.net.NetUtils;

/* JADX INFO: loaded from: classes41.dex */
public final class x {
    public static NetworkInfo a(Context r100) {
        return ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();
    L4:
        e = move-exception;
        t.a(NetUtils.TAG, e);
        return null;
    }
}
