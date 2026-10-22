package com.bytedance.sysoptimizer.javahook;

import android.graphics.SurfaceTexture;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes22.dex */
public class ProxySurface {
    private static final String TAG = "ProxySurface";

    public ProxySurface() throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_SURFACE_INIT, this, new Object[0]);
        AHook.getCallback().e(TAG, "ProxySurface() called", new Throwable());
    }

    public ProxySurface(long r100) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_SURFACE_INIT_1, this, new Object[]{Long.valueOf(r100)});
        AHook.getCallback().e(TAG, "ProxySurface() called with: nativeObject = [" + Long.toHexString(r100) + "]", new Throwable());
    }

    public ProxySurface(SurfaceTexture r100) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_SURFACE_INIT_2, this, new Object[]{r100});
        AHook.getCallback().e(TAG, "ProxySurface() called with: surfaceTexture = [" + r100 + "]", new Throwable());
    }

    public ProxySurface(SurfaceControl r100) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_SURFACE_INIT_3, this, new Object[]{r100});
        AHook.getCallback().e(TAG, "ProxySurface() called with: from = [" + r100 + "]", new Throwable());
    }
}
