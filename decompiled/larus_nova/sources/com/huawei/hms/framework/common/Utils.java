package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes23.dex */
public class Utils {
    private static final String TAG = "Utils";

    public Utils() {
    }

    public static long getCurrentTime(boolean r100) {
        if (r100 == false) goto L6;
        return SystemClock.elapsedRealtime();
    L6:
        return System.currentTimeMillis();
    }

    public static boolean is64Bit(Context r100) {
        boolean r101 = false;
        if (r100 != null) goto L7;
        Logger.e(TAG, "Null context, please check it.");
        return false;
    L7:
        if (r100.getApplicationContext() != null) goto L9;
        Context r102 = r100;
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L29;
        return Process.is64Bit();
    L29:
        return r102.getPackageManager().getApplicationInfo(r102.getPackageName(), 128).nativeLibraryDir.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON);
    L16:
        Logger.e(TAG, "Get application info failed: name not found, try to get baseContext.");
        if ((r100 instanceof ContextWrapper) == false) goto L26;
        Context r103 = ((ContextWrapper) r100).getBaseContext();
        r101 = true;
        if (r103 != null) goto L27;
        Logger.w(TAG, "Get baseContext failed: null. Return default: is64-bit.");
        return true;
    L27:
        r101 = r103.getPackageManager().getApplicationInfo(r103.getPackageName(), 128).nativeLibraryDir.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON);     // Catch: Throwable -> L24
    L24:
        Logger.e(TAG, "Get baseContext application info failed: name not found");
    L26:
        return r101;
    L9:
        r102 = r100.getApplicationContext();
        goto L11
    }
}
