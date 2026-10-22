package com.bytedance.badger.collect.impl.utils;

import com.bytedance.badger.collect.impl.interfaces.ILogger;
import com.bytedance.badger.collect.impl.model.DefaultLogger;

/* JADX INFO: loaded from: classes3.dex */
public class KLog {
    private static final String TAG = "collect ";
    private static final boolean isDebug = false;
    private static ILogger logger;

    public KLog() {
    }

    public static boolean isDebug() {
        return false;
    }

    static {
        logger = new DefaultLogger();
    }

    public static void setLogger(ILogger r100) {
        logger = r100;
    }

    public static void d(String r100, String r101) {
        ILogger r102 = logger;
        if (r102 == null) goto L6;
        r102.debug(TAG, r100 + r101);
        return;
    }

    public static void e(String r100, String r101) {
        ILogger r102 = logger;
        if (r102 == null) goto L6;
        r102.error(TAG, r100 + r101, null);
        return;
    }

    public static void i(String r100, String r101) {
        ILogger r102 = logger;
        if (r102 == null) goto L6;
        r102.info(TAG, r100 + r101);
        return;
    }

    public static void w(String r100, String r101) {
        ILogger r102 = logger;
        if (r102 == null) goto L6;
        r102.warn(TAG, r100 + r101);
        return;
    }

    public static void e(String r100, Throwable r101) {
        ILogger r102 = logger;
        if (r102 == null) goto L6;
        r102.error(TAG, r100, r101);
        return;
    }
}
