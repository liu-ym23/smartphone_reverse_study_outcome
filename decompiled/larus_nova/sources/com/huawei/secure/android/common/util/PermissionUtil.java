package com.huawei.secure.android.common.util;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.core.content.PermissionChecker;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.huawei.secure.android.common.exception.NoPermissionCheckerException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public class PermissionUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278216a = "PermissionUtil";

    public PermissionUtil() {
    }

    public static boolean checkSelfPermission(Context r100, String r101) throws NoPermissionCheckerException {
        return checkPermission(r100, r101, Process.myPid(), Process.myUid(), r100.getPackageName());
    }

    public static boolean checkCallingPermission(Context r100, String r101, String r102) throws NoPermissionCheckerException {
        if (Binder.getCallingPid() != Process.myPid()) goto L7;
        return false;
    L7:
        return checkPermission(r100, r101, Binder.getCallingPid(), Binder.getCallingUid(), r102);
    }

    private static int com_huawei_secure_android_common_util_PermissionUtil_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) throws NoPermissionCheckerException {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_com_huawei_secure_android_common_util_PermissionUtil_android_content_Context_checkPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102607);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static boolean checkPermission(Context r100, String r101, int r102, int r103, String r104) throws NoPermissionCheckerException {
    L14:
        th = move-exception;
        th.getMessage();
        throw new NoPermissionCheckerException("you should implementation support library or androidx library");
    L3:
        if (r100.getApplicationInfo().targetSdkVersion <= 23) goto L10;
        if (com_huawei_secure_android_common_util_PermissionUtil_android_content_Context_checkPermission(r100, r101, r102, r103) == 0) goto L18;
        return false;
    L18:
        return true;
    L10:
        if (PermissionChecker.checkPermission(r100, r101, r102, r103, r104) == 0) goto L19;
        return false;
    L19:
        return true;
    }
}
