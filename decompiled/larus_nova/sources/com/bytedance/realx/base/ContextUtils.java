package com.bytedance.realx.base;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.BaseDexClassLoader;
import java.io.File;

/* JADX INFO: loaded from: classes21.dex */
public class ContextUtils {
    private static final String TAG = "ContextUtils";
    private static Context applicationContext;

    public ContextUtils() {
    }

    public static String getAppPath() {
        File r100 = applicationContext.getExternalFilesDir("");
        if (r100 != null) goto L9;
        File r101 = applicationContext.getFilesDir();
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.toString();
    L9:
        return r100.toString();
    }

    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static String getAppLibPath(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L13;
        return "";
    L13:
        String r101 = ((BaseDexClassLoader) applicationContext.getClassLoader()).findLibrary(r100);     // Catch: Exception -> L10
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L10:
        e = move-exception;
        RXLogging.e("realx Utils", "getAppLibPath Exception : " + e.getMessage());
        e.getMessage();
        throw e;
    }

    public static void initialize(Context r100) {
        if (r100 == null) goto L6;
        applicationContext = r100;
        return;
    L6:
        throw new IllegalArgumentException("Application context cannot be null for ContextUtils.initialize.");
    }
}
