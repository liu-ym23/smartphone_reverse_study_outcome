package rx1;

import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
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
import android.os.Process;
import android.provider.Settings;
import com.bytedance.android.live.core.utils.SystemPropertiesUtil;
import com.bytedance.android.livesdk.z;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.huawei.hms.android.SystemUtils;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f539806a = null;

    static {
        f539806a = m.class.getCanonicalName();
    }

    public static String c() {
        return jc1.a.b().getPackageName();
    }

    public m() {
    }

    public static boolean a(Context r100) {
        String r101 = Build.MANUFACTURER;
        r101.getClass();
        if (r101.equals("Xiaomi") == false) goto L15;
        AppOpsManager r102 = (AppOpsManager) r100.getSystemService("appops");     // Catch: Exception -> L9
        Class<?> r103 = r102.getClass();     // Catch: Exception -> L9
        Class<?> r104 = Integer.TYPE;     // Catch: Exception -> L9
        if (((Integer) r103.getMethod("checkOpNoThrow", new Class[]{r104, r104, String.class}).invoke(r102, new Object[]{10021, Integer.valueOf(Process.myUid()), r100.getPackageName()})).intValue() == 0) goto L16;
        return false;
    L16:
        return true;
    L9:
        e = move-exception;
        Logger.e(f539806a, "not support", e);
        return true;
    L15:
        return true;
    }

    public static void d(Context r100) {
        j(r100, "android.settings.APPLICATION_DETAILS_SETTINGS");
    }

    public static boolean e(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L17;
        AppOpsManager r101 = (AppOpsManager) r100.getSystemService("appops");     // Catch: Exception -> L14
        Class r102 = Integer.TYPE;     // Catch: Exception -> L14
        if (((Integer) AppOpsManager.class.getMethod("checkOp", new Class[]{r102, r102, String.class}).invoke(r101, new Object[]{24, Integer.valueOf(Binder.getCallingUid()), r100.getApplicationContext().getPackageName()})).intValue() != 0) goto L19;
        return true;
    L19:
        return false;
    L20:
        return false;
    L17:
        return Settings.canDrawOverlays(r100);
    L9:
        return false;
    }

    public static boolean f(Context r100) {
        if (Build.VERSION.SDK_INT < 26) goto L11;
        if (((AppOpsManager) r100.getSystemService("appops")).checkOpNoThrow("android:picture_in_picture", Binder.getCallingUid(), r100.getApplicationContext().getPackageName()) != 0) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    L11:
        return false;
    }

    public static void h(Context r100) {
        if (z.f162557a.getValue().booleanValue() == false) goto L6;
        com.ss.android.ugc.route_monitor.impl.route_out.control.i.a("91101186");
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L9;
        j(r100, "android.settings.action.MANAGE_OVERLAY_PERMISSION");
        return;
    L9:
        i(r100);
    }

    public static void i(Context r100) {
        String r101 = Build.MANUFACTURER;
        Logger.e(m.class.getCanonicalName(), "jumpPermissionPage --- name : " + r101);
        r101.getClass();
        switch(r101.hashCode()) {
            case -1678088054: goto L38;
            case -1675632421: goto L34;
            case 2427: goto L30;
            case 2432928: goto L26;
            case 2582855: goto L22;
            case 3620012: goto L18;
            case 74224812: goto L14;
            case 1864941562: goto L10;
            case 2141820391: goto L6;
            default: goto L41;
        };
    L41:
        byte r102 = -1;
    L42:
        String r103 = f539806a;
        switch(r102) {
            case 0: goto L95;
            case 1: goto L74;
            case 2: goto L101;
            case 3: goto L67;
            case 4: goto L107;
            case 5: goto L59;
            case 6: goto L98;
            case 7: goto L51;
            case 8: goto L104;
            default: goto L44;
        };
    L44:
        d(r100);
        return;
    L51:
        d(r100);
        return;
    L59:
        b("com.bairenkeji.icaller", r100);
        return;
    L67:
        b("com.coloros.safecenter", r100);
        return;
    L74:
        String r104 = SystemPropertiesUtil.getProp("ro.miui.ui.version.name");
        Logger.e(r103, "goMiaoMiMainager --- rom : " + r104);
        Intent r105 = new Intent();
        if ("V6".equals(r104) == false) goto L77;
    L91:
        r105.setAction("miui.intent.action.APP_PERM_EDITOR");
        r105.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        r105.putExtra("extra_pkgname", c());
    L93:
        if (g(r100, r105) == false) goto L123;
        n.a(r105);
        r100.startActivity(r105);
        return;
    L123:
        return;
    L77:
        if ("V7".equals(r104) == true) goto L91;
        if ("V8".equals(r104) == false) goto L82;
    L90:
        r105.setAction("miui.intent.action.APP_PERM_EDITOR");
        r105.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        r105.putExtra("extra_pkgname", c());
        goto L93
    L82:
        if ("V9".equals(r104) == true) goto L90;
        if ("V10".equals(r104) == true) goto L90;
        if ("V11".equals(r104) == false) goto L89;
        j(r100, "android.settings.action.MANAGE_OVERLAY_PERMISSION");
        return;
    L89:
        d(r100);
        return;
    L95:
        b("com.yulong.android.security:remote", r100);
        return;
    L98:
        Intent r106 = new Intent("com.meizu.safe.security.SHOW_APPSEC");     // Catch: ActivityNotFoundException -> L57
        r106.addCategory("android.intent.category.DEFAULT");     // Catch: ActivityNotFoundException -> L57
        r106.putExtra("packageName", c());     // Catch: ActivityNotFoundException -> L57
        if (g(r100, r106) == false) goto L55;
        n.a(r106);     // Catch: ActivityNotFoundException -> L57
        r100.startActivity(r106);     // Catch: ActivityNotFoundException -> L57
    L97:
        return;
    L55:
        d(r100);     // Catch: ActivityNotFoundException -> L57
    L57:
        e = move-exception;
        Logger.e(e.getMessage());
        d(r100);
        return;
    L101:
        Intent r107 = new Intent(c());     // Catch: Exception -> L73
        r107.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));     // Catch: Exception -> L73
        if (g(r100, r107) == false) goto L71;
        n.a(r107);     // Catch: Exception -> L73
        r100.startActivity(r107);     // Catch: Exception -> L73
    L100:
        return;
    L71:
        d(r100);     // Catch: Exception -> L73
    L73:
        d(r100);
        return;
    L104:
        Intent r108 = new Intent(c());     // Catch: Exception -> L50
        r108.setFlags(268435456);     // Catch: Exception -> L50
        r108.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));     // Catch: Exception -> L50
        if (g(r100, r108) == false) goto L48;
        n.a(r108);     // Catch: Exception -> L50
        r100.startActivity(r108);     // Catch: Exception -> L50
    L103:
        return;
    L48:
        d(r100);     // Catch: Exception -> L50
    L50:
        d(r100);
        return;
    L107:
        Intent r109 = new Intent(c());     // Catch: Exception -> L65
        r109.setComponent(new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));     // Catch: Exception -> L65
        if (g(r100, r109) == false) goto L63;
        n.a(r109);     // Catch: Exception -> L65
        r100.startActivity(r109);     // Catch: Exception -> L65
    L106:
        return;
    L63:
        d(r100);     // Catch: Exception -> L65
    L65:
        e = move-exception;
        Logger.e(r103, "goSonyMainager: ", e);
        d(r100);
        return;
    L6:
        if (r101.equals(SystemUtils.PRODUCT_HUAWEI) == false) goto L41;
        r102 = 8;
        goto L42
    L10:
        if (r101.equals(SmEditTextLeakOpt.SAMSUNG) == false) goto L41;
        r102 = 7;
        goto L42
    L14:
        if (r101.equals("Meizu") == false) goto L41;
        r102 = 6;
        goto L42
    L18:
        if (r101.equals(DimLocationCheckUtil.VIVO) == false) goto L41;
        r102 = 5;
        goto L42
    L22:
        if (r101.equals("Sony") == false) goto L41;
        r102 = 4;
        goto L42
    L26:
        if (r101.equals("OPPO") == false) goto L41;
        r102 = 3;
        goto L42
    L30:
        if (r101.equals("LG") == false) goto L41;
        r102 = 2;
        goto L42
    L34:
        if (r101.equals("Xiaomi") == false) goto L41;
        r102 = 1;
        goto L42
    L38:
        if (r101.equals("Coolpad") == false) goto L41;
        r102 = 0;
        goto L42
    }

    public static void b(String r100, Context r101) {
        String r102 = f539806a;
        int r103 = 0;
        PackageInfo r104 = r101.getPackageManager().getPackageInfo(r100, 0);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r104 != null) goto L10;
        d(r101);
        return;
    L10:
        Intent r105 = new Intent("android.intent.action.MAIN", null);
        r105.addCategory("android.intent.category.LAUNCHER");
        r105.setPackage(r104.packageName);
        List<ResolveInfo> r106 = r101.getPackageManager().queryIntentActivities(r105, 0);
        Logger.e("PermissionPageManager", "resolveinfoList" + r106.size());
    L12:
        if (r103 >= r106.size()) goto L23;
        Logger.e("PermissionPageManager", ((ResolveInfo) ListProtector.get(r106, r103)).activityInfo.packageName + ((ResolveInfo) ListProtector.get(r106, r103)).activityInfo.name);
        r103 = r103 + 1;
        goto L12
    L23:
        ResolveInfo r107 = r106.iterator().next();     // Catch: Exception -> L18
        if (r107 == null) goto L25;
        ActivityInfo r108 = r107.activityInfo;     // Catch: Exception -> L18
        String r109 = r108.packageName;     // Catch: Exception -> L18
        String r110 = r108.name;     // Catch: Exception -> L18
        Intent r111 = new Intent("android.intent.action.MAIN");     // Catch: Exception -> L18
        r111.addCategory("android.intent.category.LAUNCHER");     // Catch: Exception -> L18
        r111.setComponent(new ComponentName(r109, r110));     // Catch: Exception -> L18
        n.a(r111);     // Catch: Exception -> L18
        r101.startActivity(r111);     // Catch: Exception -> L18
        return;
    L25:
        return;
    L18:
        e = move-exception;
        d(r101);
        Logger.e(r102, "doStartApplicationWithPackageName: ", e);
        return;
    L5:
        e = move-exception;
        Logger.e(r102, "doStartApplicationWithPackageName: ", e);
        r104 = null;
        goto L7
    }

    public static boolean g(Context r100, Intent r101) {
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

    public static void j(Context r100, String r101) {
        Intent r102 = new Intent(r101);
        r102.setData(Uri.fromParts("package", r100.getPackageName(), null));
    L7:
        e = move-exception;
        Logger.e(e.getMessage());
        return;
    L4:
        if (g(r100, r102) == false) goto L12;
        r100.startActivity(r102);     // Catch: Exception -> L7
        n.a(r102);     // Catch: Exception -> L7
        return;
    }
}
