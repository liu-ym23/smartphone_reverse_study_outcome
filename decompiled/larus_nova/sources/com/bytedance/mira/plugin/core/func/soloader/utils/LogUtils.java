package com.bytedance.mira.plugin.core.func.soloader.utils;

import com.bytedance.mira.plugin.core.func.soloader.SoLoader;

/* JADX INFO: loaded from: classes.dex */
public class LogUtils {
    private static SoLoader.ILog logProxy;

    public LogUtils() {
    }

    public static void setLogProxy(SoLoader.ILog r100) {
        logProxy = r100;
    }

    public static void d(String r100, String r101) {
        SoLoader.ILog r102 = logProxy;
        if (r102 == null) goto L7;
        r102.d(r100, r101);
        return;
    }

    public static void e(String r100, String r101) {
        SoLoader.ILog r102 = logProxy;
        if (r102 == null) goto L7;
        r102.e(r100, r101);
        return;
    }
}
