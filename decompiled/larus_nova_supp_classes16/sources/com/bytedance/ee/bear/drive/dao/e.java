package com.bytedance.ee.bear.drive.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements d {
    public final RoomDatabase a;
    public final a b;
    public final b c;

    public class a extends EntityInsertionAdapter<y75.b> {
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `drive_excel_sub_cache` (`sdk_app_id`,`obj_token`,`data_version`,`sub_id`,`json_data_file_path`,`json_data`) VALUES (?,?,?,?,?,?)";
        }

        public a(RoomDatabase r1) {
            super(r1);
        }

        public final void bind(SupportSQLiteStatement r3, Object r4) {
            y75.b r5 = (y75.b) r4;
            String r0 = r5.a;
            if (r0 != null) goto L5;
            r3.bindNull(1);
        L6:
            String r1 = r5.b;
            if (r1 != null) goto L9;
            r3.bindNull(2);
        L10:
            String r2 = r5.c;
            if (r2 != null) goto L13;
            r3.bindNull(3);
        L14:
            String r6 = r5.d;
            if (r6 != null) goto L17;
            r3.bindNull(4);
        L18:
            String r7 = r5.e;
            if (r7 != null) goto L21;
            r3.bindNull(5);
        L22:
            String r8 = r5.f;
            if (r8 != null) goto L25;
            r3.bindNull(6);
            return;
        L25:
            r3.bindString(6, r8);
            return;
        L21:
            r3.bindString(5, r7);
            goto L22
        L17:
            r3.bindString(4, r6);
            goto L18
        L13:
            r3.bindString(3, r2);
            goto L14
        L9:
            r3.bindString(2, r1);
            goto L10
        L5:
            r3.bindString(1, r0);
            goto L6
        }
    }

    public class b extends SharedSQLiteStatement {
        public final String createQuery() {
            return "DELETE FROM drive_excel_sub_cache WHERE sdk_app_id = ? AND obj_token = ? AND data_version = ?";
        }

        public b(RoomDatabase r1) {
            super(r1);
        }
    }

    public e(RoomDatabase r2) {
        this.a = r2;
        this.b = new a(r2);
        this.c = new b(r2);
    }

    public final int a(String r3, String r4, String r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.c.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(2);
    L11:
        if (r5 != null) goto L13;
        r0.bindNull(3);
    L14:
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L18
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.a.endTransaction();
        this.c.release(r0);
        return r6;
    L18:
        th = move-exception;
        this.a.endTransaction();
        this.c.release(r0);
        throw th;
    L13:
        r0.bindString(3, r5);
        goto L14
    L9:
        r0.bindString(2, r4);
        goto L11
    L5:
        r0.bindString(1, r3);
        goto L7
    }

    public final List<y75.b> b(String r9, String r10, String r11) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM drive_excel_sub_cache WHERE sdk_app_id = ? AND obj_token = ? AND data_version = ?", 3);
        if (r9 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r10 != null) goto L9;
        r0.bindNull(2);
    L10:
        if (r11 != null) goto L12;
        r0.bindNull(3);
    L13:
        this.a.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.a, r0, false, null);
        int r13 = CursorUtil.getColumnIndexOrThrow(r12, "sdk_app_id");     // Catch: Throwable -> L21
        int r14 = CursorUtil.getColumnIndexOrThrow(r12, "obj_token");     // Catch: Throwable -> L21
        int r1 = CursorUtil.getColumnIndexOrThrow(r12, "data_version");     // Catch: Throwable -> L21
        int r2 = CursorUtil.getColumnIndexOrThrow(r12, "sub_id");     // Catch: Throwable -> L21
        int r3 = CursorUtil.getColumnIndexOrThrow(r12, "json_data_file_path");     // Catch: Throwable -> L21
        int r4 = CursorUtil.getColumnIndexOrThrow(r12, "json_data");     // Catch: Throwable -> L21
        ArrayList r5 = new ArrayList(r12.getCount());     // Catch: Throwable -> L21
    L16:
        if (r12.moveToNext() == false) goto L19;
        y75.b r6 = new y75.b();     // Catch: Throwable -> L21
        r6.a = r12.getString(r13);     // Catch: Throwable -> L21
        r6.b = r12.getString(r14);     // Catch: Throwable -> L21
        r6.c = r12.getString(r1);     // Catch: Throwable -> L21
        r6.d = r12.getString(r2);     // Catch: Throwable -> L21
        r6.e = r12.getString(r3);     // Catch: Throwable -> L21
        r6.f = r12.getString(r4);     // Catch: Throwable -> L21
        r5.add(r6);     // Catch: Throwable -> L21
        goto L16
    L19:
        r12.close();
        r0.release();
        return r5;
    L21:
        th = move-exception;
        r12.close();
        r0.release();
        throw th;
    L12:
        r0.bindString(3, r11);
        goto L13
    L9:
        r0.bindString(2, r10);
        goto L10
    L5:
        r0.bindString(1, r9);
        goto L7
    }
}
