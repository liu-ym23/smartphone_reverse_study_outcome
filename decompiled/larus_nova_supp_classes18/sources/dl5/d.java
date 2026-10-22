package dl5;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.operation.database.OperationDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements b {
    public final RoomDatabase a;
    public final c b;

    public final List b() {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM OperationData info WHERE (info.module_token) in (select module_token from OperationData limit 1) LIMIT ?", 1);
        r3.bindLong(1, 100);
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "_id");     // Catch: Throwable -> L14
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "module_type");     // Catch: Throwable -> L14
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "module_token");     // Catch: Throwable -> L14
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "operator_id");     // Catch: Throwable -> L14
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "operation_name");     // Catch: Throwable -> L14
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "operation_scene");     // Catch: Throwable -> L14
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "operation_time");     // Catch: Throwable -> L14
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "extra");     // Catch: Throwable -> L14
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "uuid");     // Catch: Throwable -> L14
        ArrayList r13 = new ArrayList(r2.getCount());     // Catch: Throwable -> L14
    L4:
        if (r2.moveToNext() == false) goto L12;
        a r14 = new a();     // Catch: Throwable -> L14
        r14.a = r2.getInt(r0);     // Catch: Throwable -> L14
        r14.b = r2.getInt(r5);     // Catch: Throwable -> L14
        r14.c = r2.getString(r6);     // Catch: Throwable -> L14
        r14.d = r2.getString(r7);     // Catch: Throwable -> L14
        r14.e = r2.getString(r8);     // Catch: Throwable -> L14
        r14.f = r2.getInt(r9);     // Catch: Throwable -> L14
        if (r2.isNull(r10) == false) goto L9;
        Long r15 = null;
    L10:
        r14.g = r15;     // Catch: Throwable -> L14
        r14.h = r2.getString(r11);     // Catch: Throwable -> L14
        r14.i = r2.getString(r12);     // Catch: Throwable -> L14
        r13.add(r14);     // Catch: Throwable -> L14
        goto L4
    L9:
        r15 = Long.valueOf(r2.getLong(r10));     // Catch: Throwable -> L14
        goto L10
    L12:
        r2.close();
        r3.release();
        return r13;
    L14:
        th = move-exception;
        r2.close();
        r3.release();
        throw th;
    }

    public d(OperationDatabase r2) {
        this.a = r2;
        this.b = new c(r2);
    }

    public final int a(List<Integer> r5) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM OperationData WHERE _id IN (");
        ArrayList r6 = (ArrayList) r5;
        StringUtil.appendPlaceholders(r0, r6.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.a.compileStatement(r0.toString());
        Iterator r7 = r6.iterator();
        int r2 = 1;
    L4:
        if (r7.hasNext() == false) goto L10;
        Integer r3 = (Integer) r7.next();
        if (r3 != null) goto L8;
        r1.bindNull(r2);
    L9:
        r2 = r2 + 1;
        goto L4
    L8:
        r1.bindLong(r2, r3.intValue());
        goto L9
    L10:
        this.a.beginTransaction();
        int r8 = r1.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        return r8;
    L14:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public final List c(String r18) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM OperationData info WHERE (info.module_token) = ? LIMIT ?", 2);
        if (r18 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, 100);
        this.a.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.a, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r3, "_id");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r3, "module_type");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r3, "module_token");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r3, "operator_id");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r3, "operation_name");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r3, "operation_scene");     // Catch: Throwable -> L18
        int r10 = CursorUtil.getColumnIndexOrThrow(r3, "operation_time");     // Catch: Throwable -> L18
        int r11 = CursorUtil.getColumnIndexOrThrow(r3, "extra");     // Catch: Throwable -> L18
        int r12 = CursorUtil.getColumnIndexOrThrow(r3, "uuid");     // Catch: Throwable -> L18
        ArrayList r13 = new ArrayList(r3.getCount());     // Catch: Throwable -> L18
    L8:
        if (r3.moveToNext() == false) goto L16;
        a r14 = new a();     // Catch: Throwable -> L18
        r14.a = r3.getInt(r0);     // Catch: Throwable -> L18
        r14.b = r3.getInt(r5);     // Catch: Throwable -> L18
        r14.c = r3.getString(r6);     // Catch: Throwable -> L18
        r14.d = r3.getString(r7);     // Catch: Throwable -> L18
        r14.e = r3.getString(r8);     // Catch: Throwable -> L18
        r14.f = r3.getInt(r9);     // Catch: Throwable -> L18
        if (r3.isNull(r10) == false) goto L13;
        Long r15 = null;
    L14:
        r14.g = r15;     // Catch: Throwable -> L18
        r14.h = r3.getString(r11);     // Catch: Throwable -> L18
        r14.i = r3.getString(r12);     // Catch: Throwable -> L18
        r13.add(r14);     // Catch: Throwable -> L18
        goto L8
    L13:
        r15 = Long.valueOf(r3.getLong(r10));     // Catch: Throwable -> L18
        goto L14
    L16:
        r3.close();
        r2.release();
        return r13;
    L18:
        th = move-exception;
        r3.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r18);
        goto L6
    }
}
