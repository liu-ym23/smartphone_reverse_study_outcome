package net.sqlcipher.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.c;
import f06.d;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes42.dex */
public final class SqliteWrapper {
    private static final String SQLITE_EXCEPTION_DETAIL_MESSAGE = "unable to open database file";
    private static final String TAG = "SqliteWrapper";

    private SqliteWrapper() {
    }

    private static boolean isLowMemory(SQLiteException r100) {
        return r100.getMessage().equals(SQLITE_EXCEPTION_DETAIL_MESSAGE);
    }

    public static void checkSQLiteException(Context r100, SQLiteException r101) {
        if (isLowMemory(r101) == false) goto L6;
        Toast.makeText(r100, r101.getMessage(), 0).show();
        return;
    L6:
        throw r101;
    }

    public static boolean requery(Context r100, Cursor r101) {
        return r101.requery();
    L4:
        e = move-exception;
        checkSQLiteException(r100, e);
        return false;
    }

    private static Uri net_sqlcipher_database_SqliteWrapper_android_content_ContentResolver_insert(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(240017);
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
        d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (Uri) r107.f474983b;
    L21:
        return r110.insert(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Uri insert(Context r100, ContentResolver r101, Uri r102, ContentValues r103) {
        return net_sqlcipher_database_SqliteWrapper_android_content_ContentResolver_insert(r101, r102, r103);
    L4:
        e = move-exception;
        checkSQLiteException(r100, e);
        return null;
    }

    private static int net_sqlcipher_database_SqliteWrapper_android_content_ContentResolver_delete(ContentResolver r110, Uri r111, String r210, String[] r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(240019);
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
        d r107 = r106.preInvoke(240019, "android/content/ContentResolver", "delete", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.delete(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static int delete(Context r100, ContentResolver r101, Uri r102, String r103, String[] r104) {
        return net_sqlcipher_database_SqliteWrapper_android_content_ContentResolver_delete(r101, r102, r103, r104);
    L4:
        e = move-exception;
        checkSQLiteException(r100, e);
        return -1;
    }

    private static int net_sqlcipher_database_SqliteWrapper_android_content_ContentResolver_update(ContentResolver r110, Uri r111, ContentValues r210, String r211, String[] r212) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211, r212};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(240018);
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
        d r107 = r106.preInvoke(240018, "android/content/ContentResolver", "update", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.update(r111, r210, r211, r212);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static Cursor net_sqlcipher_database_SqliteWrapper_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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

    public static int update(Context r100, ContentResolver r101, Uri r102, ContentValues r103, String r104, String[] r105) {
        return net_sqlcipher_database_SqliteWrapper_android_content_ContentResolver_update(r101, r102, r103, r104, r105);
    L4:
        e = move-exception;
        checkSQLiteException(r100, e);
        return -1;
    }

    public static net.sqlcipher.Cursor query(Context r100, ContentResolver r101, Uri r102, String[] r103, String r104, String[] r105, String r106) {
        return (net.sqlcipher.Cursor) net_sqlcipher_database_SqliteWrapper_android_content_ContentResolver_query(r101, r102, r103, r104, r105, r106);
    L4:
        e = move-exception;
        checkSQLiteException(r100, e);
        return null;
    }
}
