package ru;

import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import androidx.collection.SimpleArrayMap;
import com.bytedance.android.gamecp.common.utils.u;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleArrayMap<String, Integer> f539220a = null;

    static {
        SimpleArrayMap<String, Integer> r100 = new SimpleArrayMap(8);
        f539220a = r100;
        Integer r101 = r100.put("com.android.voicemail.permission.ADD_VOICEMAIL", 14);
        Integer r102 = r100.put("android.permission.BODY_SENSORS", 20);
        Integer r103 = r100.put("android.permission.READ_CALL_LOG", 16);
        Integer r104 = r100.put("android.permission.READ_EXTERNAL_STORAGE", 16);
        Integer r105 = r100.put("android.permission.USE_SIP", 9);
        Integer r106 = r100.put("android.permission.WRITE_CALL_LOG", 16);
        Integer r107 = r100.put("android.permission.SYSTEM_ALERT_WINDOW", 23);
        Integer r108 = r100.put("android.permission.WRITE_SETTINGS", 23);
    }

    public static String b() {
        return u.f57306a.getPackageName();
    }

    public static void c(Context r100) {
        f(r100, "android.settings.APPLICATION_DETAILS_SETTINGS");
    }

    @JvmStatic
    public static final boolean d(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L22;
        Object r101 = r100.getSystemService("appops");
        if (r101 == null) goto L19;
        Class r102 = Integer.TYPE;
        Object r103 = AppOpsManager.class.getMethod("checkOp", new Class[]{r102, r102, String.class}).invoke((AppOpsManager) r101, new Object[]{24, Integer.valueOf(Binder.getCallingUid()), r100.getApplicationContext().getPackageName()});
        if (r103 == null) goto L17;
        if (((Integer) r103).intValue() != 0) goto L20;
        return true;
    L20:
        return false;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.app.AppOpsManager");
    L22:
        return Settings.canDrawOverlays(r100);
    L26:
        return false;
    }

    public static void a(String r100, Context r110) {
        int r101 = 0;
        PackageInfo r102 = r110.getPackageManager().getPackageInfo(r100, 0);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r102 != null) goto L10;
        c(r110);
        return;
    L10:
        Intent r103 = new Intent("android.intent.action.MAIN", null);
        r103.addCategory("android.intent.category.LAUNCHER");
        r103.setPackage(r102.packageName);
        List<ResolveInfo> r104 = r110.getPackageManager().queryIntentActivities(r103, 0);
        Logger.e("PermissionPageManager", "resolveinfoList" + r104.size());
        int r105 = r104.size();
    L11:
        if (r101 >= r105) goto L22;
        Logger.e("PermissionPageManager", ((ResolveInfo) ListProtector.get(r104, r101)).activityInfo.packageName + ((ResolveInfo) ListProtector.get(r104, r101)).activityInfo.name);
        r101 = r101 + 1;
        goto L11
    L22:
        ResolveInfo r106 = r104.iterator().next();     // Catch: Exception -> L17
        if (r106 == null) goto L24;
        ActivityInfo r107 = r106.activityInfo;     // Catch: Exception -> L17
        String r108 = r107.packageName;     // Catch: Exception -> L17
        String r109 = r107.name;     // Catch: Exception -> L17
        Intent r111 = new Intent("android.intent.action.MAIN");     // Catch: Exception -> L17
        r111.addCategory("android.intent.category.LAUNCHER");     // Catch: Exception -> L17
        r111.setComponent(new ComponentName(r108, r109));     // Catch: Exception -> L17
        r110.startActivity(r111);     // Catch: Exception -> L17
        return;
    L24:
        return;
    L17:
        e = move-exception;
        c(r110);
        Logger.e("PermissionUtils", "doStartApplicationWithPackageName: ", e);
        return;
    L5:
        e = move-exception;
        Logger.e("PermissionUtils", "doStartApplicationWithPackageName: ", e);
        r102 = null;
        goto L7
    }

    public static boolean e(Context r100, Intent r101) {
        if (r100 != null) goto L11;
    L10:
        return false;
    L11:
        if (r100.getPackageManager().resolveActivity(r101, 0) == null) goto L13;
        return true;
    L13:
        return false;
    L8:
        e = move-exception;
        Logger.e(e.getMessage());
        goto L10
    }

    public static void f(Context r100, String r101) {
        Intent r102 = new Intent(r101);
        r102.setData(Uri.fromParts("package", r100.getPackageName(), null));
    L7:
        e = move-exception;
        Logger.e(e.getMessage());
        return;
    L4:
        if (e(r100, r102) == false) goto L12;
        r100.startActivity(r102);     // Catch: Exception -> L7
        return;
    }
}
