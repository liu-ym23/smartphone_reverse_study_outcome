package com.obric.update.impl.v2.gateway;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes5.dex */
public final class c {
    public c() {
    }

    public static boolean a() {
        return NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication());
    }

    public static boolean b() {
        return NetworkUtils.isWifi(AppHost.f326268a.getApplication());
    }
}
