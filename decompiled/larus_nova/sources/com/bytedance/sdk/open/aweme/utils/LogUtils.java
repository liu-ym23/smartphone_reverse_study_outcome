package com.bytedance.sdk.open.aweme.utils;

import android.util.Log;
import com.bytedance.sdk.open.aweme.core.OpenLogService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.core.impl.SystemOpenLogServiceImpl;

/* JADX INFO: loaded from: classes22.dex */
public class LogUtils {
    private static final char BLANK_TAG = ' ';
    private static final String NULL_TAG = "null";
    private static final String TAG_PREFIX = "DYOpen_";
    public static boolean sDebuggable;

    public LogUtils() {
    }

    private static String createLog(Object[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L14;
        Object r104 = r100[r103];
        r101.append(BLANK_TAG);
        if (r104 != null) goto L7;
        String r105 = NULL_TAG;
    L11:
        r101.append(r105);
    L12:
        r103 = r103 + 1;
        goto L3
    L7:
        if ((r104 instanceof Throwable) == false) goto L9;
        r105 = Log.getStackTraceString((Throwable) r104);
        goto L11
    L9:
        r101.append(r104);
        goto L12
    L14:
        return r101.toString();
    }

    public static void d(String r100, Object... r101) {
        if (sDebuggable == false) goto L6;
        getLogger().d(formatTag(r100), createLog(r101));
        return;
    }

    public static void e(String r100, Object... r101) {
        getLogger().e(formatTag(r100), createLog(r101));
    }

    private static String formatTag(String r100) {
        if (r100 != null) goto L6;
        return "TAG_PREFIX";
    L6:
        if (r100.startsWith(TAG_PREFIX) == false) goto L8;
        return r100;
    L8:
        return TAG_PREFIX.concat(r100);
    }

    private static OpenLogService getLogger() {
        OpenLogService r100 = (OpenLogService) OpenServiceManager.getInst().getService(OpenLogService.class);
        if (r100 != null) goto L6;
        SystemOpenLogServiceImpl r101 = new SystemOpenLogServiceImpl();
        OpenServiceManager.getInst().registerService(OpenLogService.class, r101);
        return r101;
    L6:
        return r100;
    }

    public static void i(String r100, Object... r101) {
        getLogger().i(formatTag(r100), createLog(r101));
    }

    public static void w(String r100, Object... r101) {
        getLogger().w(formatTag(r100), createLog(r101));
    }
}
