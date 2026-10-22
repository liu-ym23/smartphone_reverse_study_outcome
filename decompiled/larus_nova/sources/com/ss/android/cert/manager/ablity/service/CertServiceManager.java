package com.ss.android.cert.manager.ablity.service;

import com.ss.android.cert.manager.utils.CertLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes34.dex */
public class CertServiceManager {
    private final Map<String, Object> serviceInstanceMap;

    /* JADX INFO: renamed from: com.ss.android.cert.manager.ablity.service.CertServiceManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Holder {
        static final CertServiceManager sInstance = null;

        public Holder() {
        }

        static {
            sInstance = new CertServiceManager(null);
        }
    }

    private CertServiceManager() {
        this.serviceInstanceMap = new ConcurrentHashMap();
    }

    public static CertServiceManager getInst() {
        return Holder.sInstance;
    }

    public /* synthetic */ CertServiceManager(AnonymousClass1 r100) {
        this();
    }

    public <T extends ICertService> T getService(Class<T> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r101 = this.serviceInstanceMap.get(r100.getName());
        if (r101 != null) goto L12;
    L11:
        return null;
    L12:
        return (T) r101;
    L9:
        e = move-exception;
        CertLog.e("CertServiceManager", "getService cast failed: ".concat(r100.getName()), e);
        goto L11
    }

    public <T extends ICertService> void registerService(Class<T> r100, T r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        this.serviceInstanceMap.put(r100.getName(), r101);
        return;
    L7:
        return;
    }
}
