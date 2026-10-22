package com.lynx.debugrouter.base.service;

import com.lynx.debugrouter.log.LLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public class DebugRouterServiceCenter {
    private static final String TAG = "DebugRouterServiceCenter";
    private static volatile DebugRouterServiceCenter instance;
    private Map<Class<? extends IRouterServiceProvider>, IRouterServiceProvider> serviceMap;

    public static DebugRouterServiceCenter instance() {
        if (instance != null) goto L15;
        monitor-enter(DebugRouterServiceCenter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new DebugRouterServiceCenter();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DebugRouterServiceCenter.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public void unregisterAllService() {
        this.serviceMap.clear();
    }

    public DebugRouterServiceCenter() {
        this.serviceMap = new ConcurrentHashMap();
    }

    public <T extends IRouterServiceProvider> T getService(Class<T> r100) {
        if (this.serviceMap.containsKey(r100) == true) goto L5;
        LLog.e(TAG, r100.getSimpleName().concat(" is unregistered"));
        return null;
    L5:
        return (T) this.serviceMap.get(r100);
    }

    public void registerService(Class<? extends IRouterServiceProvider> r100, IRouterServiceProvider r101) {
        this.serviceMap.put(r100, r101);
    }

    public void unregisterService(Class<? extends IRouterServiceProvider> r100, IRouterServiceProvider r101) {
        this.serviceMap.remove(r100, r101);
    }
}
