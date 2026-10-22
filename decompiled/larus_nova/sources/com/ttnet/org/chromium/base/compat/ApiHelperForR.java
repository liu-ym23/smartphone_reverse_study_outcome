package com.ttnet.org.chromium.base.compat;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.input.InputManager;
import android.net.Uri;
import android.os.storage.StorageManager;
import android.view.Display;
import android.view.InputEvent;
import android.view.VerifiedInputEvent;
import android.view.WindowManager;
import java.io.File;

/* JADX INFO: loaded from: classes41.dex */
public final class ApiHelperForR {
    private ApiHelperForR() {
    }

    public static Display getDisplay(Context r100) throws UnsupportedOperationException {
        return r100.getDisplay();
    }

    public static Rect getMaximumWindowMetricsBounds(WindowManager r100) {
        return r100.getMaximumWindowMetrics().getBounds();
    }

    public static File getVolumeDir(StorageManager r100, Uri r101) {
        return r100.getStorageVolume(r101).getDirectory();
    }

    public static void setProcessStateSummary(ActivityManager r100, byte[] r101) {
        r100.setProcessStateSummary(r101);
    }

    public static VerifiedInputEvent verifyInputEvent(InputManager r100, InputEvent r101) {
        return r100.verifyInputEvent(r101);
    }
}
