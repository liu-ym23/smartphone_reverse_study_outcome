package com.bytedance.sdk.open.aweme.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public class OpenServiceManager {
    private static final String TAG = "OpenServiceManager";
    private final Map<String, Object> serviceInstanceMap;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final OpenServiceManager f269621a = null;

        static {
            f269621a = new OpenServiceManager(null);
        }

        public b() {
        }
    }

    private OpenServiceManager() {
        this.serviceInstanceMap = new ConcurrentHashMap();
    }

    public /* synthetic */ OpenServiceManager(a r100) {
        this();
    }

    public static OpenServiceManager getInst() {
        return b.f269621a;
    }

    public <T extends IOpenService> T getService(Class<T> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r101 = this.serviceInstanceMap.get(r100.getName());
        if (r101 != null) goto L11;
    L9:
        return null;
    L11:
        return (T) r101;
    }

    public <T extends IOpenService> void registerService(Class<T> r100, T r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        this.serviceInstanceMap.put(r100.getName(), r101);
        return;
    L7:
        return;
    }
}
