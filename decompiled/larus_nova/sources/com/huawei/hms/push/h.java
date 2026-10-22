package com.huawei.hms.push;

import android.R;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class h {
    private static int a(Context r100) {
        int r101 = r100.getApplicationInfo().icon;
        if (r101 != 0) goto L8;
        int r102 = r100.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
        HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
        if (r102 != 0) goto L9;
        HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
        return R.drawable.sym_def_app_icon;
    L9:
        return r102;
    L8:
        return r101;
    }

    public static Bitmap a(Context r100, o r101) {
        if (r100 == null) goto L18;
        if (r101 == null) goto L21;
    L15:
        HMSLog.e("PushSelfShowLog", "build left icon occur NameNotFoundException.");
        return null;
    L14:
        HMSLog.e("PushSelfShowLog", "build left icon occur Exception.");
        return null;
    L7:
        if (HwBuildEx.VERSION.EMUI_SDK_INT < 11) goto L11;
        HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");     // Catch: Exception -> L14 PackageManager.NameNotFoundException -> L15
        return null;
    L11:
        if ("com.huawei.android.pushagent".equals(r101.j()) == true) goto L19;
        HMSLog.i("PushSelfShowLog", "get left bitmap from " + r101.j());     // Catch: Exception -> L14 PackageManager.NameNotFoundException -> L15
        return ((BitmapDrawable) r100.getPackageManager().getApplicationIcon(r101.j())).getBitmap();
    L19:
        return null;
    L21:
        return null;
    L18:
        return null;
    }

    private static int b(Context r100, o r101) {
        int r102 = 0;
        if (r100 == null) goto L17;
        if (r101 == null) goto L17;
        if (TextUtils.isEmpty(r101.l()) == true) goto L11;
        String[] r103 = r101.l().split(HTTP.URL_DEFAULT);
        if (r103.length != 3) goto L11;
        r102 = s.a(r100, r103[1], r103[2]);
    L11:
        if (r102 != 0) goto L13;
        r102 = s.a(r100, "com.huawei.messaging.default_notification_icon");
    L13:
        if (r102 == 0) goto L16;
        return r102;
    L16:
        return a(r100);
    L17:
        HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
        return 0;
    }

    public static void a(Context r100, Notification.Builder r101, o r102) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        if (r102 == null) goto L8;
        r101.setSmallIcon(b(r100, r102));
        return;
    L8:
        HMSLog.e("PushSelfShowLog", "msg is null");
    }
}
