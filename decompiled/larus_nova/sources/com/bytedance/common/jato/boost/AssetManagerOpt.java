package com.bytedance.common.jato.boost;

import android.os.Build;

/* JADX INFO: loaded from: classes15.dex */
public class AssetManagerOpt {
    public AssetManagerOpt() {
    }

    private static native void nativeCacheReference();

    private static native void nativeCacheStringPool();

    public static void cacheReference() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 26) goto L5;
        return;
    L5:
        if (r100 > 30) goto L9;
        nativeCacheReference();
        return;
    }

    public static void cacheStringPool() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 26) goto L5;
        return;
    L5:
        if (r100 > 34) goto L9;
        nativeCacheStringPool();
        return;
    }
}
