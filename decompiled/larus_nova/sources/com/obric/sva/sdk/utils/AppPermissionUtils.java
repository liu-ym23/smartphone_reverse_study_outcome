package com.obric.sva.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.obric.sva.sdk.PermissionActivity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public class AppPermissionUtils {
    public static final String[] APP_REQUIRED_PERMISSIONS = null;
    public static final String EXTRA_KEY_REQUIRED_PERMISSIONS = "required_permissions";
    private static final String TAG = null;

    public AppPermissionUtils() {
    }

    static {
        APP_REQUIRED_PERMISSIONS = new String[]{"android.permission.RECORD_AUDIO"};
        TAG = "AppPermissionUtils";
    }

    public static String[] checkPermissions(Context r100, String[] r101) {
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        String r105 = r101[r104];
        if (com_obric_sva_sdk_utils_AppPermissionUtils_android_content_Context_checkSelfPermission(r100, r105) != 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L10;
        r102.add(r105);
    L10:
        r104 = r104 + 1;
        goto L3
    L7:
        r106 = false;
        goto L8
    L11:
        String[] r107 = new String[r102.size()];
        r102.toArray(r107);
        return r107;
    }

    private static int com_obric_sva_sdk_utils_AppPermissionUtils_android_content_Context_checkSelfPermission(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b("auto_cert_com_obric_sva_sdk_utils_AppPermissionUtils_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
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
        f06.d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
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

    public static boolean isAllPermissionsGranted(Context r100, String[] r101) {
        if (checkPermissions(r100, r101).length != 0) goto L6;
        return true;
    L6:
        Intent r102 = new Intent();
        r102.setClass(r100.getApplicationContext(), PermissionActivity.class);
        r102.putExtra(EXTRA_KEY_REQUIRED_PERMISSIONS, r101);
        r100.startActivity(r102);
        ((Activity) r100).finish();
        return false;
    }
}
