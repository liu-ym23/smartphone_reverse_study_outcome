package com.ss.android.common.app.permission;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import com.bytedance.common.utility.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f407994a = null;

    public b() {
    }

    static {
        f407994a = b.class.getSimpleName();
    }

    public static boolean a(Context r110) {
        String r100 = "android.permission.WRITE_EXTERNAL_STORAGE".replaceFirst("android.permission.", "");     // Catch: Exception -> L10
        AppOpsManager r101 = (AppOpsManager) r110.getSystemService("appops");     // Catch: Exception -> L10
        PackageInfo r111 = r110.getPackageManager().getPackageInfo(r110.getPackageName(), 1);     // Catch: Exception -> L10
        Field r102 = AppOpsManager.class.getField("OP_" + r100);     // Catch: Exception -> L10
        Class r103 = Integer.TYPE;     // Catch: Exception -> L10
        Method r104 = AppOpsManager.class.getDeclaredMethod("checkOp", new Class[]{r103, r103, String.class});     // Catch: Exception -> L10
        r104.setAccessible(true);     // Catch: Exception -> L10
        int r112 = ((Integer) r104.invoke(r101, new Object[]{Integer.valueOf(r102.getInt(r101)), Integer.valueOf(r111.applicationInfo.uid), r111.packageName})).intValue();     // Catch: Exception -> L10
        if (r112 == 2) goto L9;
        if (r112 == 1) goto L9;
        if (r112 == 4) goto L9;
        return true;
    L9:
        return false;
    L10:
        e = move-exception;
        Logger.e(f407994a, "权限检查出错时默认返回有权限，异常代码：" + e);
        return true;
    }
}
