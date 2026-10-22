package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, c> f277173a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f277174b = null;

    static {
        f277173a = new ConcurrentHashMap(16);
        f277174b = new Object();
    }

    public static c a(GrsBaseInfo r100, Context r101) {
        Object r102 = f277174b;
        monitor-enter(r102);
        int r103 = r100.uniqueCode();     // Catch: Throwable -> L16
        Map<String, c> r104 = f277173a;     // Catch: Throwable -> L16
        c r105 = r104.get(r101.getPackageName() + r103);     // Catch: Throwable -> L16
        if (r105 != null) goto L7;
        Logger.i("GrsClientManager", "grsClientImpl == null, and new GrsClientImpl");     // Catch: Throwable -> L16
        c r106 = new c(r101, r100);     // Catch: Throwable -> L16
        r104.put(r101.getPackageName() + r103, r106);     // Catch: Throwable -> L16
        monitor-exit(r102);     // Catch: Throwable -> L16
        return r106;
    L7:
        if (r105.a(new c(r100)) == false) goto L10;
        monitor-exit(r102);     // Catch: Throwable -> L16
        return r105;
    L10:
        Logger.i("GrsClientManager", "The app_name, ser_country, reg_country and issue_country is equal, but other not.");     // Catch: Throwable -> L16
        c r107 = new c(r101, r100);     // Catch: Throwable -> L16
        r104.put(r101.getPackageName() + r103, r107);     // Catch: Throwable -> L16
        monitor-exit(r102);     // Catch: Throwable -> L16
        return r107;
    L16:
        th = move-exception;
        throw th;
    }
}
