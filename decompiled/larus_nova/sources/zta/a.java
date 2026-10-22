package zta;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;
import f06.b;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static int b(Context r100) {
        if (r100 == null) goto L21;
        String r101 = r100.getPackageName();
        int r102 = 1;
        Cursor r103 = a(r100.getContentResolver(), UriProtector.parse("content://com.iqoo.secure.provider.secureprovider/allowfloatwindowapp"), new String[]{r101});     // Catch: Exception -> L6
    L8:
        if (r103 == null) goto L19;
        r103.getColumnNames();
        if (r103.moveToFirst() == false) goto L16;
        int r104 = r103.getColumnIndex("currentlmode");
        if (r104 < 0) goto L14;
        r102 = r103.getInt(r104);
    L14:
        r103.close();
        return r102;
    L16:
        r103.close();
        return c(r100);
    L19:
        return c(r100);
    L6:
        e = move-exception;
        Log.e("VivoFloatPermission", Arrays.toString(e.getStackTrace()));
        r103 = null;
        goto L8
    L21:
        throw new IllegalArgumentException("context is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int c(Context r100) {
        int r101 = 1;
        Cursor r102 = a(r100.getContentResolver(), UriProtector.parse("content://com.vivo.permissionmanager.provider.permission/float_window_apps"), new String[]{r100.getPackageName()});     // Catch: Exception -> L5
    L8:
        if (r102 == null) goto L26;
        if (r102.moveToFirst() == false) goto L16;
        int r103 = r102.getColumnIndex("currentmode");
        if (r103 < 0) goto L14;
        r101 = r102.getInt(r103);
    L14:
        r102.close();
        return r101;
    L16:
        r102.close();
        if (Build.VERSION.SDK_INT >= 23) goto L38;
    L22:
        boolean r104 = 1;
    L24:
        return !r104;
    L38:
        r104 = Settings.canDrawOverlays(r100);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Log.e("VivoFloatPermission", e.getMessage());
        goto L22
    L26:
        if (Build.VERSION.SDK_INT >= 23) goto L34;
    L31:
        boolean r105 = 1;
    L33:
        return !r105;
    L34:
        r105 = Settings.canDrawOverlays(r100);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        Log.e("VivoFloatPermission", e.getMessage());
    L5:
        e = move-exception;
        Log.e("VivoFloatPermission", e.getMessage());
        r102 = null;
        goto L8
    }

    public static void d(Context r100) {
        ArrayList r101 = new ArrayList();
        Intent r102 = new Intent();
        r102.putExtra("packagename", r100.getPackageName());
        r102.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
        r101.add(r102);
        Intent r103 = new Intent();
        r103.putExtra("packagename", r100.getPackageName());
        r103.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager"));
        r101.add(r103);
        Intent r104 = new Intent();
        r104.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.PurviewTabActivity"));
        r101.add(r104);
        Intent r105 = new Intent();
        r105.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.MainActivity"));
        r101.add(r105);
        Intent r106 = new Intent();
        r106.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.MainGuideActivity"));
        r101.add(r106);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Intent r107 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        r107.setData(UriProtector.parse("package:" + r100.getPackageName()));
        r101.add(r107);
    L5:
        Intent r108 = null;
        if (r101.isEmpty() == true) goto L17;
        Iterator r109 = r101.iterator();
    L10:
        if (r109.hasNext() == false) goto L17;
        Intent r110 = (Intent) r109.next();
        if (r100.getPackageManager().queryIntentActivities(r110, 4096).size() <= 0) goto L14;
        boolean r111 = true;
    L15:
        if (r111 == false) goto L10;
        r108 = r110;
        goto L17
    L14:
        r111 = false;
    L17:
        r108.setFlags(268435456);
        r100.startActivity(r108);
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112) {
        c r113 = new c();
        Object[] r114 = {r111, null, "pkgname = ?", r112, null};
        b r115 = new b();
        d r100 = r113.b(240004, "android/content/ContentResolver", "query", r110, r114, "android.database.Cursor", r115);
        if (r100.f474982a == false) goto L6;
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, null, r115, false);
        return (Cursor) r100.f474983b;
    L6:
        Cursor r101 = r110.query(r111, null, "pkgname = ?", r112, null);
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, r101, r115, true);
        return r101;
    }
}
