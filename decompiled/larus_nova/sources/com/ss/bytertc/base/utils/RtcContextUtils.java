package com.ss.bytertc.base.utils;

import android.content.Context;
import com.bytedance.realx.base.ContextUtils;

/* JADX INFO: loaded from: classes40.dex */
public class RtcContextUtils {
    private static final String TAG = "ContextUtils";
    private static Context applicationContext;

    public RtcContextUtils() {
    }

    public static String getAppExternalPath() {
        return ContextUtils.getAppPath();
    }

    public static Context getApplicationContext() {
        return ContextUtils.getApplicationContext();
    }

    public static void initialize(Context r100) {
        if (r100 == null) goto L6;
        ContextUtils.initialize(r100.getApplicationContext());
        return;
    L6:
        throw new IllegalArgumentException("Application context cannot be null for ContextUtils.initialize.");
    }
}
