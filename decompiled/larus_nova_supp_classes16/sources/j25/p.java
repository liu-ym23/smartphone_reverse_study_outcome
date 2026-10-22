package j25;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p implements h {
    public final RoomDatabase a;
    public final i b;
    public final j c;
    public final k d;
    public final l e;
    public final m f;
    public final n g;
    public final o h;

    public final List<String> e() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT name FROM file_model group by name", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r0, false, null);
        ArrayList r3 = new ArrayList(r2.getCount());     // Catch: Throwable -> L10
    L5:
        if (r2.moveToNext() == false) goto L8;
        r3.add(r2.getString(0));     // Catch: Throwable -> L10
        goto L5
    L8:
        r2.close();
        r0.release();
        return r3;
    L10:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    }

    public final List<q> i() {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM file_model WHERE net_url IS NULL AND local_url IS NOT NULL", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "name");     // Catch: Throwable -> L14
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "token");     // Catch: Throwable -> L14
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "doc_url");     // Catch: Throwable -> L14
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "path");     // Catch: Throwable -> L14
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "uri");     // Catch: Throwable -> L14
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "local_url");     // Catch: Throwable -> L14
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "net_url");     // Catch: Throwable -> L14
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "file_modified_time");     // Catch: Throwable -> L14
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "new_upload_key");     // Catch: Throwable -> L14
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "upload_key");     // Catch: Throwable -> L14
        ArrayList r14 = new ArrayList(r2.getCount());     // Catch: Throwable -> L14
    L4:
        if (r2.moveToNext() == false) goto L12;
        q r16 = new q();     // Catch: Throwable -> L14
        r16.a = r2.getString(r0);     // Catch: Throwable -> L14
        r16.b = r2.getString(r5);     // Catch: Throwable -> L14
        r16.c = r2.getString(r6);     // Catch: Throwable -> L14
        r16.d = r2.getString(r7);     // Catch: Throwable -> L14
        r16.e = r2.getString(r8);     // Catch: Throwable -> L14
        r16.f = r2.getString(r9);     // Catch: Throwable -> L14
        r16.g = r2.getString(r10);     // Catch: Throwable -> L14
        if (r2.isNull(r11) == false) goto L9;
        Long r4 = null;
    L10:
        r16.h = r4;     // Catch: Throwable -> L14
        r16.i = r2.getString(r12);     // Catch: Throwable -> L14
        r16.j = r2.getString(r13);     // Catch: Throwable -> L14
        r14.add(r16);     // Catch: Throwable -> L14
        goto L4
    L9:
        r4 = Long.valueOf(r2.getLong(r11));     // Catch: Throwable -> L14
        goto L10
    L12:
        r2.close();
        r3.release();
        return r14;
    L14:
        th = move-exception;
        r2.close();
        r3.release();
        throw th;
    }

    public p(OfflineDatabase r2) {
        this.a = r2;
        this.b = new i(r2);
        this.c = new j(r2);
        this.d = new k(r2);
        this.e = new l(r2);
        this.f = new m(r2);
        this.g = new n(r2);
        this.h = new o(r2);
    }

    public final int b(String r3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.h.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.h.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.h.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    public final int c(String r3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.e.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
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
        r0.bindString(1, r3);
        goto L6
    }

    public final q f(String r14) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM file_model WHERE local_url = ?", 1);
        if (r14 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        q r2 = null;
        Long r3 = null;
        Cursor r16 = DBUtil.query(this.a, r0, false, null);
        int r1 = CursorUtil.getColumnIndexOrThrow(r16, "name");     // Catch: Throwable -> L17
        int r4 = CursorUtil.getColumnIndexOrThrow(r16, "token");     // Catch: Throwable -> L17
        int r5 = CursorUtil.getColumnIndexOrThrow(r16, "doc_url");     // Catch: Throwable -> L17
        int r6 = CursorUtil.getColumnIndexOrThrow(r16, "path");     // Catch: Throwable -> L17
        int r7 = CursorUtil.getColumnIndexOrThrow(r16, "uri");     // Catch: Throwable -> L17
        int r8 = CursorUtil.getColumnIndexOrThrow(r16, "local_url");     // Catch: Throwable -> L17
        int r9 = CursorUtil.getColumnIndexOrThrow(r16, "net_url");     // Catch: Throwable -> L17
        int r10 = CursorUtil.getColumnIndexOrThrow(r16, "file_modified_time");     // Catch: Throwable -> L17
        int r11 = CursorUtil.getColumnIndexOrThrow(r16, "new_upload_key");     // Catch: Throwable -> L17
        int r12 = CursorUtil.getColumnIndexOrThrow(r16, "upload_key");     // Catch: Throwable -> L17
        if (r16.moveToFirst() == false) goto L15;
        q r13 = new q();     // Catch: Throwable -> L17
        r13.a = r16.getString(r1);     // Catch: Throwable -> L17
        r13.b = r16.getString(r4);     // Catch: Throwable -> L17
        r13.c = r16.getString(r5);     // Catch: Throwable -> L17
        r13.d = r16.getString(r6);     // Catch: Throwable -> L17
        r13.e = r16.getString(r7);     // Catch: Throwable -> L17
        r13.f = r16.getString(r8);     // Catch: Throwable -> L17
        r13.g = r16.getString(r9);     // Catch: Throwable -> L17
        if (r16.isNull(r10) == true) goto L13;
        r3 = Long.valueOf(r16.getLong(r10));     // Catch: Throwable -> L17
    L13:
        r13.h = r3;     // Catch: Throwable -> L17
        r13.i = r16.getString(r11);     // Catch: Throwable -> L17
        r13.j = r16.getString(r12);     // Catch: Throwable -> L17
        r2 = r13;
    L15:
        r16.close();
        r0.release();
        return r2;
    L17:
        th = move-exception;
        r16.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r14);
        goto L6
    }

    public final q g(String r14) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM file_model WHERE net_url = ?", 1);
        if (r14 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        q r2 = null;
        Long r3 = null;
        Cursor r16 = DBUtil.query(this.a, r0, false, null);
        int r1 = CursorUtil.getColumnIndexOrThrow(r16, "name");     // Catch: Throwable -> L17
        int r4 = CursorUtil.getColumnIndexOrThrow(r16, "token");     // Catch: Throwable -> L17
        int r5 = CursorUtil.getColumnIndexOrThrow(r16, "doc_url");     // Catch: Throwable -> L17
        int r6 = CursorUtil.getColumnIndexOrThrow(r16, "path");     // Catch: Throwable -> L17
        int r7 = CursorUtil.getColumnIndexOrThrow(r16, "uri");     // Catch: Throwable -> L17
        int r8 = CursorUtil.getColumnIndexOrThrow(r16, "local_url");     // Catch: Throwable -> L17
        int r9 = CursorUtil.getColumnIndexOrThrow(r16, "net_url");     // Catch: Throwable -> L17
        int r10 = CursorUtil.getColumnIndexOrThrow(r16, "file_modified_time");     // Catch: Throwable -> L17
        int r11 = CursorUtil.getColumnIndexOrThrow(r16, "new_upload_key");     // Catch: Throwable -> L17
        int r12 = CursorUtil.getColumnIndexOrThrow(r16, "upload_key");     // Catch: Throwable -> L17
        if (r16.moveToFirst() == false) goto L15;
        q r13 = new q();     // Catch: Throwable -> L17
        r13.a = r16.getString(r1);     // Catch: Throwable -> L17
        r13.b = r16.getString(r4);     // Catch: Throwable -> L17
        r13.c = r16.getString(r5);     // Catch: Throwable -> L17
        r13.d = r16.getString(r6);     // Catch: Throwable -> L17
        r13.e = r16.getString(r7);     // Catch: Throwable -> L17
        r13.f = r16.getString(r8);     // Catch: Throwable -> L17
        r13.g = r16.getString(r9);     // Catch: Throwable -> L17
        if (r16.isNull(r10) == true) goto L13;
        r3 = Long.valueOf(r16.getLong(r10));     // Catch: Throwable -> L17
    L13:
        r13.h = r3;     // Catch: Throwable -> L17
        r13.i = r16.getString(r11);     // Catch: Throwable -> L17
        r13.j = r16.getString(r12);     // Catch: Throwable -> L17
        r2 = r13;
    L15:
        r16.close();
        r0.release();
        return r2;
    L17:
        th = move-exception;
        r16.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r14);
        goto L6
    }

    public final List<q> h(String r19) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM file_model WHERE token = ?", 1);
        if (r19 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.a, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r3, "name");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r3, "token");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r3, "doc_url");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r3, "path");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r3, "uri");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r3, "local_url");     // Catch: Throwable -> L18
        int r10 = CursorUtil.getColumnIndexOrThrow(r3, "net_url");     // Catch: Throwable -> L18
        int r11 = CursorUtil.getColumnIndexOrThrow(r3, "file_modified_time");     // Catch: Throwable -> L18
        int r12 = CursorUtil.getColumnIndexOrThrow(r3, "new_upload_key");     // Catch: Throwable -> L18
        int r13 = CursorUtil.getColumnIndexOrThrow(r3, "upload_key");     // Catch: Throwable -> L18
        ArrayList r14 = new ArrayList(r3.getCount());     // Catch: Throwable -> L18
    L8:
        if (r3.moveToNext() == false) goto L16;
        q r16 = new q();     // Catch: Throwable -> L18
        r16.a = r3.getString(r0);     // Catch: Throwable -> L18
        r16.b = r3.getString(r5);     // Catch: Throwable -> L18
        r16.c = r3.getString(r6);     // Catch: Throwable -> L18
        r16.d = r3.getString(r7);     // Catch: Throwable -> L18
        r16.e = r3.getString(r8);     // Catch: Throwable -> L18
        r16.f = r3.getString(r9);     // Catch: Throwable -> L18
        r16.g = r3.getString(r10);     // Catch: Throwable -> L18
        if (r3.isNull(r11) == false) goto L13;
        Long r4 = null;
    L14:
        r16.h = r4;     // Catch: Throwable -> L18
        r16.i = r3.getString(r12);     // Catch: Throwable -> L18
        r16.j = r3.getString(r13);     // Catch: Throwable -> L18
        r14.add(r16);     // Catch: Throwable -> L18
        goto L8
    L13:
        r4 = Long.valueOf(r3.getLong(r11));     // Catch: Throwable -> L18
        goto L14
    L16:
        r3.close();
        r2.release();
        return r14;
    L18:
        th = move-exception;
        r3.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r19);
        goto L6
    }

    public final int a(String r3, String r4) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.g.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.a.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.g.release(r0);
        return r5;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.g.release(r0);
        throw th;
    L9:
        r0.bindString(2, r4);
        goto L10
    L5:
        r0.bindString(1, r3);
        goto L7
    }

    public final int d(String r3, String r4) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.f.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.a.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.f.release(r0);
        return r5;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.f.release(r0);
        throw th;
    L9:
        r0.bindString(2, r4);
        goto L10
    L5:
        r0.bindString(1, r3);
        goto L7
    }
}
