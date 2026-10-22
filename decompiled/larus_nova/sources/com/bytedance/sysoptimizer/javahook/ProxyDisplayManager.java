package com.bytedance.sysoptimizer.javahook;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyDisplayManager {
    private static final String TAG = "ProxyDisplayManager";

    public ProxyDisplayManager() {
    }

    public void registerDisplayListener(DisplayManager.DisplayListener r100, Handler r101) throws Throwable {
        Throwable r102 = new Throwable();
        AHook.getCallback().e(TAG, "registerDisplayListener() called with: listener = [" + r100 + "], handler = [" + r101 + "]", r102);
        if (r101 == null) goto L5;
        Looper.getMainLooper();
        r101.getLooper();
    L5:
        AHook.callOrigin(OriginMethodKey.KEY_DISPLAYMANAGER_REGISTERDISPLAYLISTENER, this, new Object[]{r100, r101});
    }
}
