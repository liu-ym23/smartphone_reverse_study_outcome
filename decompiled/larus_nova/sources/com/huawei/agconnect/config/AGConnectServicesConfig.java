package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.config.impl.c;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AGConnectServicesConfig implements AGConnectOptions {
    private static final Map<String, AGConnectServicesConfig> INSTANCES = null;
    private static final Object INSTANCES_LOCK = null;

    static {
        INSTANCES = new HashMap();
        INSTANCES_LOCK = new Object();
    }

    public AGConnectServicesConfig() {
    }

    public static AGConnectServicesConfig fromContext(Context r100) {
        Context r101 = r100.getApplicationContext();
        if (r101 == null) goto L7;
        r100 = r101;
    L7:
        return fromContext(r100, r100.getPackageName());
    }

    public static AGConnectServicesConfig fromContext(Context r100, String r101) {
        Object r102 = INSTANCES_LOCK;
        monitor-enter(r102);
        Map<String, AGConnectServicesConfig> r103 = INSTANCES;     // Catch: Throwable -> L9
        AGConnectServicesConfig r104 = r103.get(r101);     // Catch: Throwable -> L9
        if (r104 != null) goto L7;
        r104 = new c(r100, r101);     // Catch: Throwable -> L9
        r103.put(r101, r104);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
        return r104;
    L9:
        th = move-exception;
        throw th;
    }

    public abstract void overlayWith(LazyInputStream r100);

    public abstract void overlayWith(InputStream r100);

    public abstract void setParam(String r100, String r101);

    public abstract void setRoutePolicy(AGCRoutePolicy r100);
}
