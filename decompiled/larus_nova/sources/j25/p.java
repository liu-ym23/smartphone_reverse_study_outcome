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

/* JADX INFO: loaded from: classes16.dex */
public final class p implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f496993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f496994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f496995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f496996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f496997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f496998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n f496999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f497000h;

    public final List<String> e() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT name FROM file_model group by name", 0);
        this.f496993a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f496993a, r100, false, null);
        ArrayList r102 = new ArrayList(r101.getCount());     // Catch: Throwable -> L10
    L5:
        if (r101.moveToNext() == false) goto L8;
        r102.add(r101.getString(0));     // Catch: Throwable -> L10
        goto L5
    L8:
        r101.close();
        r100.release();
        return r102;
    L10:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    }

    public final List<q> i() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM file_model WHERE net_url IS NULL AND local_url IS NOT NULL", 0);
        this.f496993a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f496993a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "name");     // Catch: Throwable -> L14
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "token");     // Catch: Throwable -> L14
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "doc_url");     // Catch: Throwable -> L14
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "path");     // Catch: Throwable -> L14
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "uri");     // Catch: Throwable -> L14
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "local_url");     // Catch: Throwable -> L14
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "net_url");     // Catch: Throwable -> L14
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "file_modified_time");     // Catch: Throwable -> L14
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "new_upload_key");     // Catch: Throwable -> L14
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "upload_key");     // Catch: Throwable -> L14
        ArrayList r114 = new ArrayList(r101.getCount());     // Catch: Throwable -> L14
    L4:
        if (r101.moveToNext() == false) goto L12;
        q r115 = new q();     // Catch: Throwable -> L14
        r115.f497001a = r101.getString(r102);     // Catch: Throwable -> L14
        r115.f497002b = r101.getString(r103);     // Catch: Throwable -> L14
        r115.f497003c = r101.getString(r104);     // Catch: Throwable -> L14
        r115.f497004d = r101.getString(r105);     // Catch: Throwable -> L14
        r115.f497005e = r101.getString(r106);     // Catch: Throwable -> L14
        r115.f497006f = r101.getString(r107);     // Catch: Throwable -> L14
        r115.f497007g = r101.getString(r110);     // Catch: Throwable -> L14
        if (r101.isNull(r111) == false) goto L9;
        Long r108 = null;
    L10:
        r115.f497008h = r108;     // Catch: Throwable -> L14
        r115.f497009i = r101.getString(r112);     // Catch: Throwable -> L14
        r115.f497010j = r101.getString(r113);     // Catch: Throwable -> L14
        r114.add(r115);     // Catch: Throwable -> L14
        goto L4
    L9:
        r108 = Long.valueOf(r101.getLong(r111));     // Catch: Throwable -> L14
        goto L10
    L12:
        r101.close();
        r100.release();
        return r114;
    L14:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    }

    public p(OfflineDatabase r100) {
        this.f496993a = r100;
        this.f496994b = new i(r100);
        this.f496995c = new j(r100);
        this.f496996d = new k(r100);
        this.f496997e = new l(r100);
        this.f496998f = new m(r100);
        this.f496999g = new n(r100);
        this.f497000h = new o(r100);
    }

    public final int b(String r100) {
        this.f496993a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f497000h.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f496993a.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f496993a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f496993a.endTransaction();
        this.f497000h.release(r101);
        return r102;
    L10:
        th = move-exception;
        this.f496993a.endTransaction();
        this.f497000h.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    public final int c(String r100) {
        this.f496993a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f496997e.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f496993a.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f496993a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f496993a.endTransaction();
        this.f496997e.release(r101);
        return r102;
    L10:
        th = move-exception;
        this.f496993a.endTransaction();
        this.f496997e.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    public final q f(String r110) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM file_model WHERE local_url = ?", 1);
        if (r110 != null) goto L5;
        r100.bindNull(1);
    L6:
        this.f496993a.assertNotSuspendingTransaction();
        q r101 = null;
        Long r102 = null;
        Cursor r111 = DBUtil.query(this.f496993a, r100, false, null);
        int r103 = CursorUtil.getColumnIndexOrThrow(r111, "name");     // Catch: Throwable -> L17
        int r104 = CursorUtil.getColumnIndexOrThrow(r111, "token");     // Catch: Throwable -> L17
        int r105 = CursorUtil.getColumnIndexOrThrow(r111, "doc_url");     // Catch: Throwable -> L17
        int r106 = CursorUtil.getColumnIndexOrThrow(r111, "path");     // Catch: Throwable -> L17
        int r107 = CursorUtil.getColumnIndexOrThrow(r111, "uri");     // Catch: Throwable -> L17
        int r108 = CursorUtil.getColumnIndexOrThrow(r111, "local_url");     // Catch: Throwable -> L17
        int r109 = CursorUtil.getColumnIndexOrThrow(r111, "net_url");     // Catch: Throwable -> L17
        int r112 = CursorUtil.getColumnIndexOrThrow(r111, "file_modified_time");     // Catch: Throwable -> L17
        int r113 = CursorUtil.getColumnIndexOrThrow(r111, "new_upload_key");     // Catch: Throwable -> L17
        int r114 = CursorUtil.getColumnIndexOrThrow(r111, "upload_key");     // Catch: Throwable -> L17
        if (r111.moveToFirst() == false) goto L15;
        q r115 = new q();     // Catch: Throwable -> L17
        r115.f497001a = r111.getString(r103);     // Catch: Throwable -> L17
        r115.f497002b = r111.getString(r104);     // Catch: Throwable -> L17
        r115.f497003c = r111.getString(r105);     // Catch: Throwable -> L17
        r115.f497004d = r111.getString(r106);     // Catch: Throwable -> L17
        r115.f497005e = r111.getString(r107);     // Catch: Throwable -> L17
        r115.f497006f = r111.getString(r108);     // Catch: Throwable -> L17
        r115.f497007g = r111.getString(r109);     // Catch: Throwable -> L17
        if (r111.isNull(r112) == true) goto L13;
        r102 = Long.valueOf(r111.getLong(r112));     // Catch: Throwable -> L17
    L13:
        r115.f497008h = r102;     // Catch: Throwable -> L17
        r115.f497009i = r111.getString(r113);     // Catch: Throwable -> L17
        r115.f497010j = r111.getString(r114);     // Catch: Throwable -> L17
        r101 = r115;
    L15:
        r111.close();
        r100.release();
        return r101;
    L17:
        th = move-exception;
        r111.close();
        r100.release();
        throw th;
    L5:
        r100.bindString(1, r110);
        goto L6
    }

    public final q g(String r110) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM file_model WHERE net_url = ?", 1);
        if (r110 != null) goto L5;
        r100.bindNull(1);
    L6:
        this.f496993a.assertNotSuspendingTransaction();
        q r101 = null;
        Long r102 = null;
        Cursor r111 = DBUtil.query(this.f496993a, r100, false, null);
        int r103 = CursorUtil.getColumnIndexOrThrow(r111, "name");     // Catch: Throwable -> L17
        int r104 = CursorUtil.getColumnIndexOrThrow(r111, "token");     // Catch: Throwable -> L17
        int r105 = CursorUtil.getColumnIndexOrThrow(r111, "doc_url");     // Catch: Throwable -> L17
        int r106 = CursorUtil.getColumnIndexOrThrow(r111, "path");     // Catch: Throwable -> L17
        int r107 = CursorUtil.getColumnIndexOrThrow(r111, "uri");     // Catch: Throwable -> L17
        int r108 = CursorUtil.getColumnIndexOrThrow(r111, "local_url");     // Catch: Throwable -> L17
        int r109 = CursorUtil.getColumnIndexOrThrow(r111, "net_url");     // Catch: Throwable -> L17
        int r112 = CursorUtil.getColumnIndexOrThrow(r111, "file_modified_time");     // Catch: Throwable -> L17
        int r113 = CursorUtil.getColumnIndexOrThrow(r111, "new_upload_key");     // Catch: Throwable -> L17
        int r114 = CursorUtil.getColumnIndexOrThrow(r111, "upload_key");     // Catch: Throwable -> L17
        if (r111.moveToFirst() == false) goto L15;
        q r115 = new q();     // Catch: Throwable -> L17
        r115.f497001a = r111.getString(r103);     // Catch: Throwable -> L17
        r115.f497002b = r111.getString(r104);     // Catch: Throwable -> L17
        r115.f497003c = r111.getString(r105);     // Catch: Throwable -> L17
        r115.f497004d = r111.getString(r106);     // Catch: Throwable -> L17
        r115.f497005e = r111.getString(r107);     // Catch: Throwable -> L17
        r115.f497006f = r111.getString(r108);     // Catch: Throwable -> L17
        r115.f497007g = r111.getString(r109);     // Catch: Throwable -> L17
        if (r111.isNull(r112) == true) goto L13;
        r102 = Long.valueOf(r111.getLong(r112));     // Catch: Throwable -> L17
    L13:
        r115.f497008h = r102;     // Catch: Throwable -> L17
        r115.f497009i = r111.getString(r113);     // Catch: Throwable -> L17
        r115.f497010j = r111.getString(r114);     // Catch: Throwable -> L17
        r101 = r115;
    L15:
        r111.close();
        r100.release();
        return r101;
    L17:
        th = move-exception;
        r111.close();
        r100.release();
        throw th;
    L5:
        r100.bindString(1, r110);
        goto L6
    }

    public final List<q> h(String r110) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM file_model WHERE token = ?", 1);
        if (r110 != null) goto L5;
        r100.bindNull(1);
    L6:
        this.f496993a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f496993a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "name");     // Catch: Throwable -> L18
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "token");     // Catch: Throwable -> L18
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "doc_url");     // Catch: Throwable -> L18
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "path");     // Catch: Throwable -> L18
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "uri");     // Catch: Throwable -> L18
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "local_url");     // Catch: Throwable -> L18
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "net_url");     // Catch: Throwable -> L18
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "file_modified_time");     // Catch: Throwable -> L18
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "new_upload_key");     // Catch: Throwable -> L18
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "upload_key");     // Catch: Throwable -> L18
        ArrayList r115 = new ArrayList(r101.getCount());     // Catch: Throwable -> L18
    L8:
        if (r101.moveToNext() == false) goto L16;
        q r116 = new q();     // Catch: Throwable -> L18
        r116.f497001a = r101.getString(r102);     // Catch: Throwable -> L18
        r116.f497002b = r101.getString(r103);     // Catch: Throwable -> L18
        r116.f497003c = r101.getString(r104);     // Catch: Throwable -> L18
        r116.f497004d = r101.getString(r105);     // Catch: Throwable -> L18
        r116.f497005e = r101.getString(r106);     // Catch: Throwable -> L18
        r116.f497006f = r101.getString(r107);     // Catch: Throwable -> L18
        r116.f497007g = r101.getString(r111);     // Catch: Throwable -> L18
        if (r101.isNull(r112) == false) goto L13;
        Long r108 = null;
    L14:
        r116.f497008h = r108;     // Catch: Throwable -> L18
        r116.f497009i = r101.getString(r113);     // Catch: Throwable -> L18
        r116.f497010j = r101.getString(r114);     // Catch: Throwable -> L18
        r115.add(r116);     // Catch: Throwable -> L18
        goto L8
    L13:
        r108 = Long.valueOf(r101.getLong(r112));     // Catch: Throwable -> L18
        goto L14
    L16:
        r101.close();
        r100.release();
        return r115;
    L18:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    L5:
        r100.bindString(1, r110);
        goto L6
    }

    public final int a(String r100, String r101) {
        this.f496993a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.f496999g.acquire();
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L7:
        if (r101 != null) goto L9;
        r102.bindNull(2);
    L10:
        this.f496993a.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L14
        this.f496993a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f496993a.endTransaction();
        this.f496999g.release(r102);
        return r103;
    L14:
        th = move-exception;
        this.f496993a.endTransaction();
        this.f496999g.release(r102);
        throw th;
    L9:
        r102.bindString(2, r101);
        goto L10
    L5:
        r102.bindString(1, r100);
        goto L7
    }

    public final int d(String r100, String r101) {
        this.f496993a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.f496998f.acquire();
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L7:
        if (r101 != null) goto L9;
        r102.bindNull(2);
    L10:
        this.f496993a.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L14
        this.f496993a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f496993a.endTransaction();
        this.f496998f.release(r102);
        return r103;
    L14:
        th = move-exception;
        this.f496993a.endTransaction();
        this.f496998f.release(r102);
        throw th;
    L9:
        r102.bindString(2, r101);
        goto L10
    L5:
        r102.bindString(1, r100);
        goto L7
    }
}
