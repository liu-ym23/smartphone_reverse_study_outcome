package k25;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static List<m0> b(SupportSQLiteDatabase r21) {
        Cursor r1 = r21.query("SELECT * FROM ResourceData");
        int r0 = r1.getColumnIndexOrThrow("id");     // Catch: Throwable -> L22
        int r2 = r1.getColumnIndexOrThrow("reskey");     // Catch: Throwable -> L22
        int r3 = r1.getColumnIndexOrThrow("resvalue");     // Catch: Throwable -> L22
        int r4 = r1.getColumnIndexOrThrow("resvalue_filepath");     // Catch: Throwable -> L22
        int r5 = r1.getColumnIndexOrThrow("update_time");     // Catch: Throwable -> L22
        int r6 = r1.getColumnIndexOrThrow("access_time");     // Catch: Throwable -> L22
        int r7 = r1.getColumnIndexOrThrow("isNeedSync");     // Catch: Throwable -> L22
        int r8 = r1.getColumnIndexOrThrow("config");     // Catch: Throwable -> L22
        int r9 = r1.getColumnIndexOrThrow("type");     // Catch: Throwable -> L22
        int r10 = r1.getColumnIndexOrThrow("token");     // Catch: Throwable -> L22
        int r11 = r1.getColumnIndexOrThrow("obj_token");     // Catch: Throwable -> L22
        int r12 = r1.getColumnIndexOrThrow("userToken");     // Catch: Throwable -> L22
        int r13 = r1.getColumnIndexOrThrow("tenantID");     // Catch: Throwable -> L22
        int r22 = r1.getColumnIndexOrThrow("url");     // Catch: Throwable -> L22
        ArrayList r16 = new ArrayList(r1.getCount());     // Catch: Throwable -> L22
    L4:
        if (r1.moveToNext() == false) goto L20;
        m0 r14 = new m0();     // Catch: Throwable -> L22
        ArrayList r17 = r16;
        r14.a = r1.getInt(r0);     // Catch: Throwable -> L22
        r14.b = r1.getString(r2);     // Catch: Throwable -> L22
        r14.c = r1.getString(r3);     // Catch: Throwable -> L22
        r14.d = r1.getString(r4);     // Catch: Throwable -> L22
        Long r18 = null;
        if (r1.isNull(r5) == false) goto L9;
        Long r19 = null;
    L10:
        r14.e = r19;     // Catch: Throwable -> L22
        if (r1.isNull(r6) == true) goto L14;
        r18 = Long.valueOf(r1.getLong(r6));     // Catch: Throwable -> L22
    L14:
        r14.f = r18;     // Catch: Throwable -> L22
        if (r1.getInt(r7) == 0) goto L17;
        boolean r110 = true;
    L18:
        r14.g = r110;     // Catch: Throwable -> L22
        r14.h = r1.getString(r8);     // Catch: Throwable -> L22
        r14.i = r1.getString(r9);     // Catch: Throwable -> L22
        r14.j = r1.getString(r10);     // Catch: Throwable -> L22
        r14.k = r1.getString(r11);     // Catch: Throwable -> L22
        r14.l = r1.getString(r12);     // Catch: Throwable -> L22
        r14.m = r1.getString(r13);     // Catch: Throwable -> L22
        int r111 = r22;
        int r23 = r0;
        r14.n = r1.getString(r111);     // Catch: Throwable -> L22
        r17.add(r14);     // Catch: Throwable -> L22
        r0 = r23;
        r22 = r111;
        r16 = r17;
        goto L4
    L17:
        r110 = false;
        goto L18
    L9:
        r19 = Long.valueOf(r1.getLong(r5));     // Catch: Throwable -> L22
        goto L10
    L20:
        ArrayList r20 = r16;
        r1.close();
        return r20;
    L22:
        th = move-exception;
        r1.close();
        throw th;
    }

    public static void a(SupportSQLiteDatabase r4, List<m0> r5) {
        ArrayList r6 = (ArrayList) r5;
        if (r6.size() == 0) goto L12;
        r4.beginTransaction();
        Iterator r0 = r6.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r4.delete("ResourceData", "id=?", new String[]{String.valueOf(((m0) r0.next()).a)});
        goto L7
    L9:
        r4.setTransactionSuccessful();
        r4.endTransaction();
        tt5.a.h("OfflineDataDBUtil", "OfflineDataDBUtil  deleteResourceDataList delete: " + r6.size());
        return;
    }

    public static void c(SupportSQLiteDatabase r8, List<m0> r9) {
        ArrayList r10 = (ArrayList) r9;
        if (r10.size() == 0) goto L12;
        r8.beginTransaction();
        Iterator r0 = r10.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        m0 r1 = (m0) r0.next();
        ContentValues r5 = new ContentValues();
        r5.put("resvalue", r1.c);
        r8.update("ResourceData", 5, r5, "id=?", new String[]{String.valueOf(r1.a)});
        goto L7
    L9:
        r8.setTransactionSuccessful();
        r8.endTransaction();
        tt5.a.h("OfflineDataDBUtil", "OfflineDataDBUtil  updateResourceDataList update: " + r10.size());
        return;
    }
}
