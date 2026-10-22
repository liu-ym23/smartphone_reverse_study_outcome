package com.bytedance.ee.bear.lynx.impl.xbridge.method.cache;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements d {
    public final RoomDatabase a;
    public final e b;
    public final f c;
    public final g d;

    public final int b() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.c.acquire();
        this.a.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.c.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.c.release(r0);
        throw th;
    }

    public h(LynxCacheDatabase r2) {
        this.a = r2;
        this.b = new e(r2);
        this.c = new f(r2);
        this.d = new g(r2);
    }

    public final int a(long r3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.d.acquire();
        r0.bindLong(1, r3);
        this.a.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.d.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.d.release(r0);
        throw th;
    }

    public final i c(String r7, String r8) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM lynx_cache_model WHERE  business = ? AND [key] = ? ", 2);
        if (r7 != null) goto L5;
        r0.bindNull(1);
    L6:
        if (r8 != null) goto L8;
        r0.bindNull(2);
    L9:
        this.a.assertNotSuspendingTransaction();
        i r1 = null;
        Cursor r9 = DBUtil.query(this.a, r0, false, null);
        int r10 = CursorUtil.getColumnIndexOrThrow(r9, "business");     // Catch: Throwable -> L19
        int r2 = CursorUtil.getColumnIndexOrThrow(r9, "key");     // Catch: Throwable -> L19
        int r3 = CursorUtil.getColumnIndexOrThrow(r9, "value");     // Catch: Throwable -> L19
        int r4 = CursorUtil.getColumnIndexOrThrow(r9, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L19
        if (r9.moveToFirst() == false) goto L17;
        i r5 = new i(r9.getString(r10), r9.getString(r2), r9.getString(r3));     // Catch: Throwable -> L19
        if (r9.isNull(r4) == false) goto L15;
        r5.d = null;     // Catch: Throwable -> L19
    L16:
        r1 = r5;
        goto L17
    L15:
        r5.d = Long.valueOf(r9.getLong(r4));     // Catch: Throwable -> L19
    L17:
        r9.close();
        r0.release();
        return r1;
    L19:
        th = move-exception;
        r9.close();
        r0.release();
        throw th;
    L8:
        r0.bindString(2, r8);
        goto L9
    L5:
        r0.bindString(1, r7);
        goto L6
    }
}
