package com.ss.bytertc.base.media.screen;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.Context;
import android.os.Build;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;

/* JADX INFO: loaded from: classes40.dex */
public class ScreenServiceManager {
    private static final String TAG = "ScreenServiceManager";

    public void stopService() {
        if (Build.VERSION.SDK_INT > 28) goto L6;
        return;
    L6:
        if (RXScreenCaptureService.serviceStarted.get() == false) goto L12;
        Context r100 = ContextUtils.getApplicationContext();     // Catch: ForegroundServiceStartNotAllowedException -> L9
        r100.startForegroundService(RXScreenCaptureService.getServiceIntent(r100, 9, null));     // Catch: ForegroundServiceStartNotAllowedException -> L9
        RXLogging.w(TAG, String.format("[ScreenCapture] stopService!", new Object[0]));     // Catch: ForegroundServiceStartNotAllowedException -> L9
        return;
    L13:
        return;
    }

    public ScreenServiceManager() {
    }
}
