package com.miui.easygo.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.miui.easygo.constant.EasyGoDbTable;
import com.miui.easygo.sdk.module.EasyGoServer;
import f06.b;
import f06.c;
import f06.d;
import java.util.Locale;

/* JADX INFO: loaded from: classes32.dex */
class DatabaseUtil extends BaseUtil {
    private static final Uri EASYGO_SERVER_URI = null;
    private static final String TAG = "DatabaseUtil";

    static {
        EASYGO_SERVER_URI = UriProtector.parse("content://com.miui.easygo.easygoprovider/t_server");
    }

    public DatabaseUtil() {
    }

    private static EasyGoServer assembleServer(Cursor r100) {
        EasyGoServer r101 = new EasyGoServer();
        if (r100 != null) goto L5;
        return r101;
    L5:
        r100.getString(r100.getColumnIndex("name"));
        r100.getString(r100.getColumnIndex(EasyGoDbTable.Server.PROVIDE_FUNCTION));
        r100.getString(r100.getColumnIndex(EasyGoDbTable.Server.IS_SYSTEM_SERVICE));
        r100.getString(r100.getColumnIndex(EasyGoDbTable.Server.DATA_SCHEMA));
        r100.getString(r100.getColumnIndex("service_name"));
        r100.getString(r100.getColumnIndex(EasyGoDbTable.Server.SERVICE_VERSION));
        r101.setName(r100.getString(r100.getColumnIndex("name")));
        r101.setProvideFunction(r100.getString(r100.getColumnIndex(EasyGoDbTable.Server.PROVIDE_FUNCTION)));
        r101.setIsSysService(r100.getString(r100.getColumnIndex(EasyGoDbTable.Server.IS_SYSTEM_SERVICE)));
        r101.setDataSchema(r100.getString(r100.getColumnIndex(EasyGoDbTable.Server.DATA_SCHEMA)));
        r101.setServiceName(r100.getString(r100.getColumnIndex("service_name")));
        r101.setServiceVersion(r100.getString(r100.getColumnIndex(EasyGoDbTable.Server.SERVICE_VERSION)));
        return r101;
    }

    public static boolean isDbSupport(Context r100) {
        Cursor r101 = com_miui_easygo_util_DatabaseUtil_android_content_ContentResolver_query(r100.getContentResolver(), EASYGO_SERVER_URI, null, "provide_function = \"\"", null, null);
        if (r101 != null) goto L5;
        boolean r102 = false;
    L6:
        if (r101 == null) goto L8;
        r101.close();
    L8:
        return r102;
    L5:
        r102 = true;
        goto L6
    }

    public static EasyGoServer queryServerInfo(Context r100, String r101) {
        Cursor r102 = null;
        EasyGoServer r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        String r104 = r101.trim().toLowerCase(Locale.ENGLISH);     // Catch: Throwable -> L24 IllegalArgumentException -> L26
        Cursor r105 = com_miui_easygo_util_DatabaseUtil_android_content_ContentResolver_query(r100.getContentResolver(), EASYGO_SERVER_URI, null, "provide_function = \"" + r104 + "\"", null, null);     // Catch: Throwable -> L24 IllegalArgumentException -> L26
        if (r105 == null) goto L20;
    L17:
        e = e;
    L28:
        e.getMessage();     // Catch: Throwable -> L32
        if (r105 == null) goto L31;
        r105.close();
    L31:
        return r103;
    L32:
        th = th;
        r102 = r105;
    L34:
        if (r102 == null) goto L36;
        r102.close();
    L36:
        throw th;
    L6:
        if (r105.getCount() == 0) goto L20;
        r105.moveToFirst();     // Catch: IllegalArgumentException -> L17 Throwable -> L32
    L8:
        EasyGoServer r106 = assembleServer(r105);     // Catch: IllegalArgumentException -> L17 Throwable -> L32
        if (r103 != null) goto L12;
    L13:
        r103 = r106;
    L15:
        if (r105.moveToNext() == true) goto L8;
    L12:
        if ("1".equals(r106.getIsSysService()) == false) goto L15;
    L20:
        r103.getServiceVersion();     // Catch: IllegalArgumentException -> L17 Throwable -> L32
        if (r105 == null) goto L23;
        r105.close();
    L23:
        return r103;
    L26:
        e = e;
        r105 = null;
    L24:
        th = th;
        goto L34
    }

    private static Cursor com_miui_easygo_util_DatabaseUtil_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
