package com.bytedance.sysoptimizer;

import android.view.Surface;

/* JADX INFO: loaded from: classes22.dex */
public class SurfaceUtils {
    public SurfaceUtils() {
    }

    private static native int nativeSetSurfaceGeometry(Surface r100, int r101, int r102);

    public static int setSurfaceGeometry(Surface r100, int r101, int r102) {
        return nativeSetSurfaceGeometry(r100, r101, r102);
    }
}
