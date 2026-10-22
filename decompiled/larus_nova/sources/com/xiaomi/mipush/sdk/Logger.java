package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.db;
import com.xiaomi.push.dc;
import java.io.File;

/* JADX INFO: loaded from: classes41.dex */
public class Logger {
    private static boolean sDisablePushLog;
    private static LoggerInterface sUserLogger;

    public Logger() {
    }

    public static File getLogFile(String r100) {
        return null;
    }

    public static void uploadLogFile(Context r100, boolean r101) {
    }

    public static LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    public static void disablePushFileLog(Context r100) {
        sDisablePushLog = true;
        setPushLog(r100);
    }

    public static void enablePushFileLog(Context r100) {
        sDisablePushLog = false;
        setPushLog(r100);
    }

    public static void setPushLog(Context r100) {
        LoggerInterface r101 = sUserLogger;
        boolean r102 = false;
        if (r101 == null) goto L5;
        boolean r103 = true;
    L6:
        boolean r104 = sDisablePushLog;
        if (r104 == true) goto L10;
        r102 = r103;
    L10:
        boolean r105 = true ^ r104;
        dc r106 = null;
        if (r102 == true) goto L14;
        r101 = null;
    L14:
        if (r105 == false) goto L16;
        r106 = dc.a(r100);
    L16:
        com.xiaomi.channel.commonutils.logger.b.a(new db(r101, r106));
        return;
    L5:
        r103 = false;
        goto L6
    }

    public static void setLogger(Context r100, LoggerInterface r101) {
        sUserLogger = r101;
        setPushLog(r100);
    }
}
