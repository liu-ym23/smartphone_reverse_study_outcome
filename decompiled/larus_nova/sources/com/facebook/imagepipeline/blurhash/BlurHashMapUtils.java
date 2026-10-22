package com.facebook.imagepipeline.blurhash;

import android.net.Uri;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class BlurHashMapUtils {
    private static boolean OpenBlurhash;
    private static Map<String, WeakReference<BlurHashListener>> requestUriMap;

    public BlurHashMapUtils() {
    }

    static {
        requestUriMap = new ConcurrentHashMap();
        OpenBlurhash = false;
    }

    public static boolean isEnableBlurHash() {
        return OpenBlurhash;
    }

    public static WeakReference<BlurHashListener> getListener(Uri r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return requestUriMap.get(r100.toString());
    }

    public static void removeListener(Uri r100) {
        if (isEnableBlurHash() == false) goto L7;
        if (r100 == null) goto L8;
        requestUriMap.remove(r100.toString());
        return;
    L8:
        return;
    }

    public static void setOpenBlurhash(boolean r100) {
        OpenBlurhash = r100;
    }

    public static synchronized void putListener(Uri r100, WeakReference<BlurHashListener> r101) {
        monitor-enter(BlurHashMapUtils.class);
        if (r100 != null) goto L12;
    L10:
        monitor-exit(BlurHashMapUtils.class);
        return;
    L12:
        requestUriMap.put(r100.toString(), r101);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }
}
