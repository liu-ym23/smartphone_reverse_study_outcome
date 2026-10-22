package com.ss.android.lark.gadget.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import java.util.Iterator;
import java.util.List;
import njb.b;

/* JADX INFO: loaded from: classes36.dex */
public class MiniAppProcessUtils {
    private static final String TAG = "MiniAppProcessUtils";

    public MiniAppProcessUtils() {
    }

    public static boolean checkMiniAppProcessExistInMainProcess(Context r100) {
        b r101 = b.a.f519472a;
        if (r101.f519471c == false) goto L5;
        return false;
    L5:
        r101.f519471c = true;
        long r102 = System.currentTimeMillis();
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L12
    L8:
        if (r103.hasNext() == false) goto L14;
        if (r103.next().processName.contains(":miniapp") == false) goto L8;
        boolean r104 = true;
    L15:
        AppBrandLogger.i(TAG, new Object[]{"checkMiniAppProcessExistInMainProcess hasMiniAppProcessExist:", Boolean.valueOf(r104), "duration:", Long.valueOf(System.currentTimeMillis() - r102)});
        return r104;
    L14:
        r104 = false;
    L12:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{e});
        goto L14
    }

    public static String getCurProcessName(Context r100) {
        b r101 = b.a.f519472a;
        String r102 = r101.f519470b;     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r102) == true) goto L6;
        return r102;
    L6:
        int r103 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r104 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L8:
        if (r104.hasNext() == false) goto L21;
        ActivityManager.RunningAppProcessInfo r105 = r104.next();     // Catch: Exception -> L15
        if (r105.pid != r103) goto L8;
        String r106 = r105.processName;     // Catch: Exception -> L15
        r101.f519470b = r106;     // Catch: Exception -> L15
        return r106;
    L21:
        return "";
    L13:
        return "";
    }

    public static boolean isMainProcess(Context r100) {
        String r101 = getCurProcessName(r100);
        if (r101 != null) goto L5;
    L7:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (r101 != null) goto L11;
        return false;
    L11:
        if (r101.equals(r100.getPackageName()) == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r101.contains(":") == false) goto L7;
        return false;
    }

    public static boolean isMicroAppActivity(Activity r100) {
        String r101 = r100.getClass().getCanonicalName();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.substring(r101.lastIndexOf(".") + 1).matches("MiniappTabActivity\\d") == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isMiniAppProcess(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.contains(":miniapp") == false) goto L8;
    L9:
        return true;
    L8:
        if (r100.contains(":oryx") == true) goto L9;
        return false;
    }

    public static boolean isOryxProcess(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.contains(":oryx");
    }

    public static void killCurrentAppTask(Context r110) {
        String r100 = getCurProcessName(r110);     // Catch: Exception -> L24
        ActivityManager r111 = (ActivityManager) r110.getSystemService("activity");     // Catch: Exception -> L24
        if (r111 == null) goto L37;
        List<ActivityManager.AppTask> r112 = r111.getAppTasks();     // Catch: Exception -> L24
        if (r112 != null) goto L8;
        return;
    L8:
        if (r112.size() <= 0) goto L39;
        Iterator<ActivityManager.AppTask> r113 = r112.iterator();     // Catch: Exception -> L24
    L10:
        if (r113.hasNext() == false) goto L40;
        ActivityManager.AppTask r101 = r113.next();     // Catch: Exception -> L24
        ComponentName r102 = r101.getTaskInfo().baseIntent.getComponent();     // Catch: Exception -> L24
        if (r102 == null) goto L10;
        int r103 = r100.indexOf(":");     // Catch: Exception -> L24
        if (r103 < 0) goto L17;
        String r104 = r100.substring(r103 + 1).replace("miniapp", "");     // Catch: Exception -> L24
    L18:
        String r105 = r102.getClassName();     // Catch: Exception -> L24
        AppBrandLogger.i(TAG, new Object[]{"killCurrentAppTask processName", r100, "miniAppProcessIndex", r104, "componentClassName", r105});     // Catch: Exception -> L24
        if (r105.endsWith("MiniappTabActivity" + r104) == true) goto L22;
        if (r105.endsWith("MiniappTabHostStackActivity" + r104) == false) goto L10;
    L22:
        AppBrandLogger.i(TAG, new Object[]{"finishAndRemoveMiniAppTask"});     // Catch: Exception -> L24
        r101.finishAndRemoveTask();     // Catch: Exception -> L24
        goto L10
    L17:
        r104 = null;
        goto L18
    L40:
        return;
    L39:
        return;
    L37:
        return;
    L24:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{e});
    }

    public static void killCurrentProcess(Context r100) {
        if (isMiniAppProcess(r100) == true) goto L11;
        return;
    L11:
        Thread.sleep(200);     // Catch: InterruptedException -> L7
    L9:
        killCurrentAppTask(r100);
        AppBrandLogger.i(TAG, new Object[]{"kill mini app process"});
        Process.killProcess(Process.myPid());
        System.exit(0);
        return;
    L7:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{e});
        goto L9
    }

    public static boolean isMiniAppProcess(Context r100) {
        return isMiniAppProcess(getCurProcessName(r100));
    }
}
