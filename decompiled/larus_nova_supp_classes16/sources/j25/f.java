package j25;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements a {
    public final RoomDatabase a;
    public final b b;
    public final c c;
    public final d d;
    public final e e;

    public f(OfflineDatabase r2) {
        this.a = r2;
        this.b = new b(r2);
        this.c = new c(r2);
        this.d = new d(r2);
        this.e = new e(r2);
    }

    public final int a(List<Long> r5) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM bitable_file_model WHERE _id IN (");
        StringUtil.appendPlaceholders(r0, r5.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.a.compileStatement(r1);
        Iterator<Long> r6 = r5.iterator();
        int r3 = 1;
    L4:
        if (r6.hasNext() == false) goto L10;
        Long r4 = r6.next();
        if (r4 != null) goto L8;
        r2.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r2.bindLong(r3, r4.longValue());
        goto L9
    L10:
        this.a.beginTransaction();
        int r7 = r2.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        return r7;
    L14:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public final List<g> b(String r23) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM bitable_file_model WHERE table_id= ?", 1);
        if (r23 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.a, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, "_id");     // Catch: Throwable -> L22
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "name");     // Catch: Throwable -> L22
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "token");     // Catch: Throwable -> L22
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "doc_url");     // Catch: Throwable -> L22
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "table_id");     // Catch: Throwable -> L22
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "field_id");     // Catch: Throwable -> L22
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "record_id");     // Catch: Throwable -> L22
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "path");     // Catch: Throwable -> L22
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "uri");     // Catch: Throwable -> L22
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "mime_type");     // Catch: Throwable -> L22
        int r16 = CursorUtil.getColumnIndexOrThrow(r4, "width");     // Catch: Throwable -> L22
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "height");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "upload_task_key");     // Catch: Throwable -> L22
        int r1 = CursorUtil.getColumnIndexOrThrow(r4, "upload_progress");     // Catch: Throwable -> L22
        RoomSQLiteQuery r17 = r2;
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "attachment_token");     // Catch: Throwable -> L20
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "is_camera_only");     // Catch: Throwable -> L20
        int r110 = r1;
        ArrayList r20 = new ArrayList(r4.getCount());     // Catch: Throwable -> L20
    L11:
        if (r4.moveToNext() == false) goto L18;
        g r21 = new g();     // Catch: Throwable -> L20
        ArrayList r22 = r20;
        int r24 = r3;
        r21.a = r4.getLong(r0);     // Catch: Throwable -> L20
        r21.b = r4.getString(r6);     // Catch: Throwable -> L20
        r21.c = r4.getString(r7);     // Catch: Throwable -> L20
        r21.d = r4.getString(r8);     // Catch: Throwable -> L20
        r21.e = r4.getString(r9);     // Catch: Throwable -> L20
        r21.f = r4.getString(r10);     // Catch: Throwable -> L20
        r21.g = r4.getString(r11);     // Catch: Throwable -> L20
        r21.h = r4.getString(r12);     // Catch: Throwable -> L20
        r21.i = r4.getString(r13);     // Catch: Throwable -> L20
        r21.j = r4.getString(r14);     // Catch: Throwable -> L20
        r21.k = r4.getInt(r16);     // Catch: Throwable -> L20
        r21.l = r4.getInt(r24);     // Catch: Throwable -> L20
        r21.m = r4.getString(r5);     // Catch: Throwable -> L20
        int r26 = r110;
        int r111 = r0;
        r21.n = r4.getInt(r26);     // Catch: Throwable -> L20
        r18 = r18;
        r21.o = r4.getString(r18);     // Catch: Throwable -> L20
        int r27 = r19;
        if (r4.getInt(r27) == 0) goto L15;
        boolean r28 = true;
    L16:
        r21.p = r28;     // Catch: Throwable -> L20
        r22.add(r21);     // Catch: Throwable -> L20
        r19 = r27;
        r20 = r22;
        r0 = r111;
        r110 = r26;
        r3 = r24;
        goto L11
    L15:
        r28 = false;
        goto L16
    L18:
        ArrayList r29 = r20;
        r4.close();
        r17.release();
        return r29;
    L20:
        th = th;
    L24:
        r4.close();
        r17.release();
        throw th;
    L22:
        th = th;
        r17 = r2;
        goto L24
    L5:
        r2.bindString(1, r23);
        goto L6
    }

    public final List<g> c(String r23) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM bitable_file_model WHERE table_id!= ?", 1);
        if (r23 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.a, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, "_id");     // Catch: Throwable -> L22
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "name");     // Catch: Throwable -> L22
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "token");     // Catch: Throwable -> L22
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "doc_url");     // Catch: Throwable -> L22
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "table_id");     // Catch: Throwable -> L22
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "field_id");     // Catch: Throwable -> L22
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "record_id");     // Catch: Throwable -> L22
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "path");     // Catch: Throwable -> L22
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "uri");     // Catch: Throwable -> L22
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "mime_type");     // Catch: Throwable -> L22
        int r16 = CursorUtil.getColumnIndexOrThrow(r4, "width");     // Catch: Throwable -> L22
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "height");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "upload_task_key");     // Catch: Throwable -> L22
        int r1 = CursorUtil.getColumnIndexOrThrow(r4, "upload_progress");     // Catch: Throwable -> L22
        RoomSQLiteQuery r17 = r2;
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "attachment_token");     // Catch: Throwable -> L20
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "is_camera_only");     // Catch: Throwable -> L20
        int r110 = r1;
        ArrayList r20 = new ArrayList(r4.getCount());     // Catch: Throwable -> L20
    L11:
        if (r4.moveToNext() == false) goto L18;
        g r21 = new g();     // Catch: Throwable -> L20
        ArrayList r22 = r20;
        int r24 = r3;
        r21.a = r4.getLong(r0);     // Catch: Throwable -> L20
        r21.b = r4.getString(r6);     // Catch: Throwable -> L20
        r21.c = r4.getString(r7);     // Catch: Throwable -> L20
        r21.d = r4.getString(r8);     // Catch: Throwable -> L20
        r21.e = r4.getString(r9);     // Catch: Throwable -> L20
        r21.f = r4.getString(r10);     // Catch: Throwable -> L20
        r21.g = r4.getString(r11);     // Catch: Throwable -> L20
        r21.h = r4.getString(r12);     // Catch: Throwable -> L20
        r21.i = r4.getString(r13);     // Catch: Throwable -> L20
        r21.j = r4.getString(r14);     // Catch: Throwable -> L20
        r21.k = r4.getInt(r16);     // Catch: Throwable -> L20
        r21.l = r4.getInt(r24);     // Catch: Throwable -> L20
        r21.m = r4.getString(r5);     // Catch: Throwable -> L20
        int r26 = r110;
        int r111 = r0;
        r21.n = r4.getInt(r26);     // Catch: Throwable -> L20
        r18 = r18;
        r21.o = r4.getString(r18);     // Catch: Throwable -> L20
        int r27 = r19;
        if (r4.getInt(r27) == 0) goto L15;
        boolean r28 = true;
    L16:
        r21.p = r28;     // Catch: Throwable -> L20
        r22.add(r21);     // Catch: Throwable -> L20
        r19 = r27;
        r20 = r22;
        r0 = r111;
        r110 = r26;
        r3 = r24;
        goto L11
    L15:
        r28 = false;
        goto L16
    L18:
        ArrayList r29 = r20;
        r4.close();
        r17.release();
        return r29;
    L20:
        th = th;
    L24:
        r4.close();
        r17.release();
        throw th;
    L22:
        th = th;
        r17 = r2;
        goto L24
    L5:
        r2.bindString(1, r23);
        goto L6
    }

    public final int d(long r3, String r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.e.acquire();
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r3);
        this.a.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.e.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.e.release(r0);
        throw th;
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    public final int f(long r3, String r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.d.acquire();
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r3);
        this.a.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.d.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.d.release(r0);
        throw th;
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    public final int e(long r5, String r7, int r8) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.c.acquire();
        r0.bindLong(1, r8);
        if (r7 != null) goto L5;
        r0.bindNull(2);
    L6:
        r0.bindLong(3, r5);
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.c.release(r0);
        return r6;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.c.release(r0);
        throw th;
    L5:
        r0.bindString(2, r7);
        goto L6
    }
}
