package com.bytedance.ee.bear.lynx.impl.xbridge.method.cache;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f229953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f229954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f229955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f229956d;

    public final int b() {
        this.f229953a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r100 = this.f229955c.acquire();
        this.f229953a.beginTransaction();
        int r101 = r100.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f229953a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f229953a.endTransaction();
        this.f229955c.release(r100);
        return r101;
    L6:
        th = move-exception;
        this.f229953a.endTransaction();
        this.f229955c.release(r100);
        throw th;
    }

    public h(LynxCacheDatabase r100) {
        this.f229953a = r100;
        this.f229954b = new e(r100);
        this.f229955c = new f(r100);
        this.f229956d = new g(r100);
    }

    public final int a(long r100) {
        this.f229953a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f229956d.acquire();
        r101.bindLong(1, r100);
        this.f229953a.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f229953a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f229953a.endTransaction();
        this.f229956d.release(r101);
        return r102;
    L6:
        th = move-exception;
        this.f229953a.endTransaction();
        this.f229956d.release(r101);
        throw th;
    }

    public final i c(String r100, String r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT * FROM lynx_cache_model WHERE  business = ? AND [key] = ? ", 2);
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        if (r101 != null) goto L8;
        r102.bindNull(2);
    L9:
        this.f229953a.assertNotSuspendingTransaction();
        i r103 = null;
        Cursor r104 = DBUtil.query(this.f229953a, r102, false, null);
        int r105 = CursorUtil.getColumnIndexOrThrow(r104, "business");     // Catch: Throwable -> L19
        int r106 = CursorUtil.getColumnIndexOrThrow(r104, "key");     // Catch: Throwable -> L19
        int r107 = CursorUtil.getColumnIndexOrThrow(r104, "value");     // Catch: Throwable -> L19
        int r108 = CursorUtil.getColumnIndexOrThrow(r104, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L19
        if (r104.moveToFirst() == false) goto L17;
        i r109 = new i(r104.getString(r105), r104.getString(r106), r104.getString(r107));     // Catch: Throwable -> L19
        if (r104.isNull(r108) == false) goto L15;
        r109.f229960d = null;     // Catch: Throwable -> L19
    L16:
        r103 = r109;
        goto L17
    L15:
        r109.f229960d = Long.valueOf(r104.getLong(r108));     // Catch: Throwable -> L19
    L17:
        r104.close();
        r102.release();
        return r103;
    L19:
        th = move-exception;
        r104.close();
        r102.release();
        throw th;
    L8:
        r102.bindString(2, r101);
        goto L9
    L5:
        r102.bindString(1, r100);
        goto L6
    }
}
