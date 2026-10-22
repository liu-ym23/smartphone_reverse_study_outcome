package com.huawei.hms.framework.common;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public class ContextCompat {
    private static final String TAG = "ContextCompat";

    public ContextCompat() {
    }

    public static Context getProtectedStorageContext(Context r100) {
        if (r100 != null) goto L6;
        Logger.w(TAG, "context is null");
        return null;
    L6:
        if (Build.VERSION.SDK_INT >= 24) goto L9;
        return r100;
    L9:
        return r100.createDeviceProtectedStorageContext();
    }

    public static boolean checkSelfPermission(Context r100, String r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        if (com_huawei_hms_framework_common_ContextCompat_android_content_Context_checkPermission(r100, r101, Process.myPid(), Process.myUid()) == 0) goto L17;
        return false;
    L17:
        return true;
    L9:
        e = move-exception;
        Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
        return false;
    L12:
        Logger.w(TAG, "param is null");
        return false;
    }

    public static Object getSystemService(Context r100, String r101) {
        if (r100 != null) goto L11;
        Logger.w(TAG, "context is null");
        return null;
    L11:
        return r100.getSystemService(r101);
    L8:
        e = move-exception;
        Logger.e(TAG, "SystemServer error:", e);
        return null;
    }

    private static int com_huawei_hms_framework_common_ContextCompat_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        b r112 = new b("auto_cert_com_huawei_hms_framework_common_ContextCompat_android_content_Context_checkPermission");
        a r102 = ApiHookConfig.f245611b.get(102607);
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
        d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
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
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
