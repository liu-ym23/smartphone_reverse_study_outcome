package com.tencent.open.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;

/* JADX INFO: loaded from: classes35.dex */
public class h {
    private static boolean a(String r100) {
        if (r100 != null) goto L5;
    L18:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L18;
        String[] r101 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r101.length >= 3) goto L10;
        return false;
    L10:
        int r102 = r101.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L16;
        CastIntegerProtector.parseInt(r101[r103]);     // Catch: NumberFormatException -> L15
        r103 = r103 + 1;
    L15:
        return false;
    L16:
        return true;
    }

    public static String a(Context r100, String r101, String r102) {
        if (r100 == null) goto L15;
        if (r102 == null) goto L15;
        if (r101 == null) goto L15;
        if ("com.tencent.mobileqq".equals(r102) == false) goto L12;
        return b(r100, r101, "com.tencent.mobileqq");
    L12:
        if (Constants.PACKAGE_TIM.equals(r102) == false) goto L15;
        return b(r100, r101, Constants.PACKAGE_TIM);
    L15:
        return null;
    }

    private static String b(Context r100, String r101, String r102) {
        Cursor r103 = c(r100, r101, r102);     // Catch: Exception -> L16
        if (r103 != null) goto L8;
        SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion null");     // Catch: Exception -> L16
        return null;
    L8:
        if (r103.getCount() > 0) goto L11;
        SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion empty");     // Catch: Exception -> L16
        return null;
    L11:
        r103.moveToFirst();     // Catch: Exception -> L16
        String r104 = r103.getString(0);     // Catch: Exception -> L16
        r103.close();     // Catch: Exception -> L16
        SLog.i("openSDK_LOG.OpenApiProviderUtils", "AppVersion: " + r104);     // Catch: Exception -> L16
        if (a(r104) == false) goto L14;
        return r104;
    L14:
        return "UNKNOWN";
    L16:
        e = move-exception;
        SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion exception: ", e);
        return null;
    }

    private static Cursor c(Context r110, String r111, String r112) {
        if (r110 != null) goto L10;
        return null;
    L10:
        return com_tencent_open_utils_h_android_content_ContentResolver_query(r110.getContentResolver(), UriProtector.parse("content://" + r112 + ".openapi.provider/query_app_version?appid=" + r111 + "&pkgName=" + r110.getPackageName()), new String[0], null, null, null);
    L7:
        e = move-exception;
        SLog.e("openSDK_LOG.OpenApiProviderUtils", "query exception: ", e);
        return null;
    }

    private static Cursor com_tencent_open_utils_h_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
