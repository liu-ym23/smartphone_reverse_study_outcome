package androidx.camera.core.impl;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ExtendedCameraConfigProviderStore {
    private static final Map<Object, CameraConfigProvider> CAMERA_CONFIG_PROVIDERS = null;
    private static final Object LOCK = null;

    static {
        LOCK = new Object();
        CAMERA_CONFIG_PROVIDERS = new HashMap();
    }

    public static void clear() {
        Object r0 = LOCK;
        monitor-enter(r0);
        CAMERA_CONFIG_PROVIDERS.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ExtendedCameraConfigProviderStore() {
    }

    public static CameraConfigProvider getConfigProvider(Object r2) {
        Object r0 = LOCK;
        monitor-enter(r0);
        CameraConfigProvider r3 = CAMERA_CONFIG_PROVIDERS.get(r2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r3 == null) goto L8;
        return r3;
    L8:
        return CameraConfigProvider.EMPTY;
    L9:
        th = move-exception;
        throw th;
    }

    public static void addConfig(Object r2, CameraConfigProvider r3) {
        Object r0 = LOCK;
        monitor-enter(r0);
        CAMERA_CONFIG_PROVIDERS.put(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
