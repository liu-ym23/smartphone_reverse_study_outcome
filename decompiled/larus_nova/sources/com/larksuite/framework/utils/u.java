package com.larksuite.framework.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes24.dex */
public final class u {
    public static void a(Context r100) {
        Intent r101 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");     // Catch: Exception -> L4
        r101.addFlags(268435456);     // Catch: Exception -> L4
        r101.setData(Uri.fromParts("package", r100.getPackageName(), null));     // Catch: Exception -> L4
        r100.startActivity(r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("NavigationUtils", e.getMessage());
    }

    public static boolean startActivity(Context r100, Intent r101) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
    L12:
        e = move-exception;
        Log.e("NavigationUtils", e.getMessage());
        goto L14
    L7:
        if ((r100 instanceof Activity) == true) goto L9;
        r101.addFlags(268435456);     // Catch: Exception -> L12
    L9:
        r100.startActivity(r101);     // Catch: Exception -> L12
        return true;
    L14:
        return false;
    }

    public static boolean startActivity(Context r100, Class<? extends Activity> r101) {
        return startActivity(r100, r101, null);
    }

    public static boolean startActivity(Context r100, Class<? extends Activity> r101, Bundle r102) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L12;
        Intent r103 = new Intent();
        if (r102 == null) goto L8;
        r103.putExtras(r102);
    L8:
        r103.setClass(r100, r101);
        return startActivity(r100, r103);
    L12:
        return false;
    L10:
        return false;
    }

    public static boolean startActivityForResult(Activity r100, Intent r101, int r102) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L11;
        r100.startActivityForResult(r101, r102);     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        Log.e("NavigationUtils", e.getMessage());
    L11:
        return false;
    }
}
