package com.ss.android.cert.manager.permission;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.ablity.ICertCompliance;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.SystemInfoTools;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class PermissionHelper {
    public static final String TAG = "PermissionHelper";

    public interface OnPermissionEventListener {
        void onPermissionEvent(String r100, JSONObject r101);
    }

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int r100, String[] r101, int[] r102);
    }

    public interface PermissionRequestCallback {
        void onRequest(boolean r100, boolean r101, HashMap<String, PermissionEntity> r102, String r103);
    }

    public PermissionHelper() {
    }

    public static /* synthetic */ void a(String[] r100, Activity r101, int r102) {
        lambda$requestPermissions$0(r100, r101, r102);
    }

    private static Intent getMeiZuPermissionPageIntent(Context r100) {
        Intent r101 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        if (isActivityExistAndExported(r100, r101) == false) goto L6;
        r101.addCategory("android.intent.category.DEFAULT");
        r101.putExtra("packageName", r100.getPackageName());
        return r101;
    L6:
        return null;
    }

    private static Intent getMiPermissionPageIntent(Context r100) {
        Intent r101 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        if (isActivityExistAndExported(r100, r101) == false) goto L6;
        r101.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
        r101.putExtra("extra_pkgname", r100.getPackageName());
        return r101;
    L6:
        return null;
    }

    private static Intent getOppoPermissionPageIntent(Context r100) {
        if (Build.VERSION.SDK_INT > 23) goto L16;
        Intent r101 = new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.PermissionManagerActivity"));
        Intent r102 = new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.PermissionAppAllPermissionActivity"));
        Intent r103 = new Intent().setComponent(new ComponentName(RomUtils.PACKAGE_INSTALLER_GOOGLE, "com.android.packageinstaller.permission.ui.ManagePermissionsActivity"));
        if (isActivityExistAndExported(r100, r101) == false) goto L9;
        r101.putExtra("pkg_name", r100.getPackageName());
        r101.putExtra("app_name", r100.getResources().getString(r100.getApplicationInfo().labelRes));
        r101.putExtra("class_name", PermissionHelper.class.getName());
        r101.addFlags(268435456);
        return r101;
    L9:
        if (isActivityExistAndExported(r100, r102) == false) goto L13;
        r102.putExtra("packageName", r100.getPackageName());
        r102.addFlags(268435456);
        return r102;
    L13:
        if (isActivityExistAndExported(r100, r103) == false) goto L18;
        r103.putExtra("android.intent.extra.PACKAGE_NAME", r100.getPackageName());
        r103.addFlags(268435456);
        return r103;
    L18:
        return null;
    L16:
        return null;
    }

    private static Intent getPermissionPageIntent(Context r100) {
        String r101 = Build.MANUFACTURER.toLowerCase();
        if (BytedCertSdkManager.getInstance().isOptPermissionRequest() == true) goto L5;
        Intent r102 = null;
    L27:
        if (r102 != null) goto L32;
        Intent r103 = new Intent();
        r103.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        r103.setData(Uri.fromParts("package", r100.getPackageName(), null));
        return r103;
    L32:
        return r102;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L30;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -759499589: goto L18;
            case 3418016: goto L14;
            case 103777484: goto L10;
            default: goto L21;
        };
    L21:
        switch(r104) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            default: goto L31;
        };
    L23:
        r102 = getMeiZuPermissionPageIntent(r100);
        goto L27
    L24:
        r102 = getOppoPermissionPageIntent(r100);
        goto L27
    L25:
        r102 = getMiPermissionPageIntent(r100);
        goto L27
    L31:
        r102 = null;
        goto L27
    L10:
        if (r101.equals("meizu") == false) goto L21;
        r104 = 2;
        goto L21
    L14:
        if (r101.equals(AppConstants.CHANNEL_OPPO) == false) goto L21;
        r104 = 1;
        goto L21
    L18:
        if (r101.equals(DimLocationCheckUtil.XIAOMI) == false) goto L21;
        r104 = 0;
        goto L21
    L30:
        r102 = null;
        goto L27
    }

    public static boolean checkSelfPermission(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L16;
        if (TextUtils.equals(r101, "android.permission.CAMERA") == false) goto L11;
        if (Build.VERSION.SDK_INT > 23) goto L11;
        return SystemInfoTools.isCameraValid();
    L11:
        if (com_ss_android_cert_manager_permission_PermissionHelper_android_content_Context_checkPermission(r100, r101, Process.myPid(), Process.myUid()) != 0) goto L13;
        return true;
    L13:
        return false;
    L16:
        throw new IllegalArgumentException("permission is null");
    }

    private static boolean com_ss_android_cert_manager_permission_PermissionHelper_android_app_Activity_shouldShowRequestPermissionRationale(Activity r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b("auto_cert_com_ss_android_cert_manager_permission_PermissionHelper_android_app_Activity_shouldShowRequestPermissionRationale");
        g06.a r102 = ApiHookConfig.f245611b.get(102609);
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
        f06.d r107 = r106.preInvoke(102609, "android/app/Activity", "shouldShowRequestPermissionRationale", r110, r101, "boolean", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Boolean) r107.f474983b).booleanValue();
    L21:
        return r110.shouldShowRequestPermissionRationale(r111);
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

    private static boolean isActivityExistAndExported(Context r100, Intent r101) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        ResolveInfo r102 = r100.getPackageManager().resolveActivity(r101, 1);     // Catch: Exception -> L12
        if (r102 == null) goto L14;
        ActivityInfo r103 = r102.activityInfo;     // Catch: Exception -> L12
        if (r103 == null) goto L14;
        return r103.exported;
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        return false;
    }

    public static boolean isFulfill(Map<String, PermissionEntity> r100, Map<String, PermissionEntity> r101) {
        if (r100 != null) goto L5;
    L20:
        return true;
    L5:
        if (r100.isEmpty() == true) goto L20;
        if (r101 != null) goto L10;
    L19:
        return false;
    L10:
        if (r101.isEmpty() == true) goto L19;
        Iterator<PermissionEntity> r102 = r100.values().iterator();
    L14:
        if (r102.hasNext() == false) goto L18;
        if (r101.containsKey(r102.next().permission) == true) goto L14;
        return false;
    L18:
        return true;
    }

    public static void openSettings(Activity r100, int r101) {
        r100.startActivityForResult(getPermissionPageIntent(r100), r101);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity r100, String r101) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        return com_ss_android_cert_manager_permission_PermissionHelper_android_app_Activity_shouldShowRequestPermissionRationale(r100, r101);
    }

    public static void checkRequestPermissions(Context r100, OnPermissionEventListener r101, PermissionRequest r102) {
        checkRequestPermissions(r100, null, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static /* synthetic */ void lambda$requestPermissions$0(String[] r100, Activity r101, int r102) {
        int[] r103 = new int[r100.length];     // Catch: Exception -> L7
        PackageManager r104 = r101.getPackageManager();     // Catch: Exception -> L7
        String r105 = r101.getPackageName();     // Catch: Exception -> L7
        int r106 = r100.length;     // Catch: Exception -> L7
        int r107 = 0;
    L3:
        if (r107 >= r106) goto L5;
        r103[r107] = r104.checkPermission(r100[r107], r105);     // Catch: Exception -> L7
        r107 = r107 + 1;     // Catch: Exception -> L7
        goto L3
    L5:
        ((OnRequestPermissionsResultCallback) r101).onRequestPermissionsResult(r102, r100, r103);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static void requestPermissions(final Activity r100, final String[] r101, final int r102) {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        ICertCompliance r103 = CertManager.getInstance().getCertCompliance();
        if (r103 == null) goto L8;
        r103.requestPermissions(r100, r101, r102);
        return;
    L8:
        throw new NullPointerException("cert compliance is null");
    L10:
        if ((r100 instanceof OnRequestPermissionsResultCallback) == false) goto L14;
        new Handler(Looper.getMainLooper()).post(new e(r101, r100, r102));
        return;
    }

    public static void checkRequestPermissions(Context r110, HashMap<String, String> r111, OnPermissionEventListener r112, PermissionRequest r113) {
        if (r113.callback == null) goto L24;
        if (r110 == null) goto L24;
        HashMap<String, PermissionEntity> r100 = r113.entities;
        if (r100 != null) goto L9;
    L22:
        Boolean r101 = Boolean.TRUE;
        CertLog.d(TAG, String.format("checkRequestPermissions onRequest: checkSuccess=%s, requestSuccess=%s, grantEntities=%s", new Object[]{r101, r101, r113.entities}));
        r113.callback.onRequest(true, true, r113.entities, "none");
        return;
    L9:
        if (r100.isEmpty() == true) goto L22;
        HashMap r102 = new HashMap();
        Iterator<PermissionEntity> r114 = r113.entities.values().iterator();
    L13:
        if (r114.hasNext() == false) goto L18;
        PermissionEntity r115 = r114.next();
        if (checkSelfPermission(r110, r115.permission) == true) goto L13;
        r102.put(r115.permission, r115);
        goto L13
    L18:
        if (r102.isEmpty() == false) goto L20;
        Boolean r103 = Boolean.TRUE;
        CertLog.d(TAG, String.format("checkRequestPermissions onRequest: checkSuccess=%s, requestSuccess=%s, grantEntities=%s", new Object[]{r103, r103, r113.entities}));
        r113.callback.onRequest(true, true, r113.entities, "none");
        return;
    L20:
        PermissionActivity.launch(r110, r113.entities, r113.cancelable, r111, r113.callback, r112);
        return;
    L24:
        CertLog.d(TAG, "checkRequestPermissions: context==null or callback==null, return");
    }

    private static int com_ss_android_cert_manager_permission_PermissionHelper_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_com_ss_android_cert_manager_permission_PermissionHelper_android_content_Context_checkPermission");
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
}
