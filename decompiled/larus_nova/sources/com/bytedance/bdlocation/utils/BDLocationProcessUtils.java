package com.bytedance.bdlocation.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.bdlocation.log.Logger;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class BDLocationProcessUtils {
    private static volatile String sCurrentProcessName;

    public BDLocationProcessUtils() {
    }

    public static String getCurrentProcessName(Context r100) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Application.getProcessName();
    L7:
        if (sCurrentProcessName == null) goto L11;
        return sCurrentProcessName;
    L11:
        monitor-enter(BDLocationProcessUtils.class);
    L34:
        th = move-exception;
        throw th;
    L13:
        if (sCurrentProcessName == null) goto L37;
        String r101 = sCurrentProcessName;     // Catch: Throwable -> L34
        monitor-exit(BDLocationProcessUtils.class);     // Catch: Throwable -> L34
        return r101;
    L37:
        Iterator<ActivityManager.RunningAppProcessInfo> r102 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Throwable -> L30
    L20:
        if (r102.hasNext() == false) goto L28;
        ActivityManager.RunningAppProcessInfo r103 = r102.next();     // Catch: Throwable -> L30
        if (r103.uid != Process.myUid()) goto L20;
        if (r103.pid != Process.myPid()) goto L20;
        sCurrentProcessName = r103.processName;     // Catch: Throwable -> L30
        String r104 = sCurrentProcessName;     // Catch: Throwable -> L30
        monitor-exit(BDLocationProcessUtils.class);     // Catch: Throwable -> L34
        return r104;
    L28:
        monitor-exit(BDLocationProcessUtils.class);     // Catch: Throwable -> L34
        return null;
    L30:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L34
        Logger.e("getCurrentProcessName failed, " + th, th);     // Catch: Throwable -> L34
        return null;
    }
}
