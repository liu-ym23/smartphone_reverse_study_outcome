package com.bytedance.mira.plugin.core.func.soloader.utils;

import com.bytedance.mira.plugin.core.func.soloader.SoLoader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class LogUtils {
    private static SoLoader.ILog logProxy;

    public LogUtils() {
    }

    public static void setLogProxy(SoLoader.ILog r0) {
        logProxy = r0;
    }

    public static void d(String r1, String r2) {
        SoLoader.ILog r0 = logProxy;
        if (r0 == null) goto L7;
        r0.d(r1, r2);
        return;
    }

    public static void e(String r1, String r2) {
        SoLoader.ILog r0 = logProxy;
        if (r0 == null) goto L7;
        r0.e(r1, r2);
        return;
    }
}
