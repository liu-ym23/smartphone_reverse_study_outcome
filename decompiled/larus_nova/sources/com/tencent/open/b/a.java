package com.tencent.open.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.tencent.open.log.SLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes31.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Uri f461706a = null;

    public static String b(Context r100) {
        return "";
    }

    static {
        f461706a = UriProtector.parse("content://telephony/carriers/preferapn");
    }

    public static String a(Context r100) {
        int r101 = d(r100);
        if (r101 != 2) goto L7;
        return "wifi";
    L7:
        if (r101 != 1) goto L11;
        return "cmwap";
    L11:
        if (r101 != 4) goto L15;
        return "cmnet";
    L15:
        if (r101 != 16) goto L19;
        return "uniwap";
    L19:
        if (r101 != 8) goto L23;
        return "uninet";
    L23:
        if (r101 != 64) goto L27;
        return "wap";
    L27:
        if (r101 != 32) goto L31;
        return com.alipay.sdk.m.k.b.f25406k;
    L31:
        if (r101 != 512) goto L35;
        return "ctwap";
    L35:
        if (r101 != 256) goto L39;
        return "ctnet";
    L39:
        if (r101 != 2048) goto L43;
        return "3gnet";
    L43:
        if (r101 != 1024) goto L46;
        return "3gwap";
    L46:
        String r102 = b(r100);
        if (r102 != null) goto L49;
        return "none";
    L49:
        if (r102.length() == 0) goto L54;
        return r102;
    L54:
        return "none";
    }

    public static String c(Context r100) {
        Cursor r101 = com_tencent_open_b_a_android_content_ContentResolver_query(r100.getContentResolver(), f461706a, null, null, null, null);     // Catch: SecurityException -> L11
        if (r101 != null) goto L5;
        return null;
    L5:
        r101.moveToFirst();     // Catch: SecurityException -> L11
        if (r101.isAfterLast() == false) goto L9;
        r101.close();     // Catch: SecurityException -> L11
        return null;
    L9:
        String r102 = r101.getString(r101.getColumnIndex("proxy"));     // Catch: SecurityException -> L11
        r101.close();     // Catch: SecurityException -> L11
        return r102;
    L11:
        e = move-exception;
        SLog.e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e.getMessage());
        return "";
    }

    private static String com_tencent_open_b_a_android_net_NetworkInfo_getExtraInfo(NetworkInfo r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102026);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(102026, "android/net/NetworkInfo", "getExtraInfo", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.getExtraInfo();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static int d(Context r100) {
        NetworkInfo r101 = e(r100);     // Catch: Exception -> L59
        if (r101 != null) goto L7;
        return 128;
    L7:
        if (r101.getTypeName().toUpperCase().equals("WIFI") == false) goto L10;
        return 2;
    L10:
        String r102 = com_tencent_open_b_a_android_net_NetworkInfo_getExtraInfo(r101).toLowerCase();     // Catch: Exception -> L59
        if (r102.startsWith("cmwap") == false) goto L15;
        return 1;
    L15:
        if (r102.startsWith("cmnet") == false) goto L17;
        return 4;
    L17:
        if (r102.startsWith("epc.tmobile.com") == false) goto L20;
        return 4;
    L20:
        if (r102.startsWith("uniwap") == false) goto L24;
        return 16;
    L24:
        if (r102.startsWith("uninet") == false) goto L28;
        return 8;
    L28:
        if (r102.startsWith("wap") == false) goto L32;
        return 64;
    L32:
        if (r102.startsWith(com.alipay.sdk.m.k.b.f25406k) == false) goto L36;
        return 32;
    L36:
        if (r102.startsWith("ctwap") == false) goto L39;
        return 512;
    L39:
        if (r102.startsWith("ctnet") == false) goto L42;
        return 256;
    L42:
        if (r102.startsWith("3gwap") == false) goto L46;
        return 1024;
    L46:
        if (r102.startsWith("3gnet") == false) goto L50;
        return 2048;
    L50:
        if (r102.startsWith("#777") == false) goto L61;
        String r103 = c(r100);     // Catch: Exception -> L59
        if (r103 == null) goto L56;
        if (r103.length() <= 0) goto L56;
        return 512;
    L56:
        return 256;
    L61:
        return 128;
    L59:
        e = move-exception;
        SLog.e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e.getMessage());
        goto L61
    }

    public static NetworkInfo e(Context r100) {
        if (r100 != null) goto L8;
        return null;
    L8:
        return ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();
    L7:
        return null;
    }

    private static Cursor com_tencent_open_b_a_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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
