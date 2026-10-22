package j25;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f496972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f496973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f496974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f496975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f496976e;

    public f(OfflineDatabase r100) {
        this.f496972a = r100;
        this.f496973b = new b(r100);
        this.f496974c = new c(r100);
        this.f496975d = new d(r100);
        this.f496976e = new e(r100);
    }

    public final int a(List<Long> r100) {
        this.f496972a.assertNotSuspendingTransaction();
        StringBuilder r101 = StringUtil.newStringBuilder();
        r101.append("DELETE FROM bitable_file_model WHERE _id IN (");
        StringUtil.appendPlaceholders(r101, r100.size());
        r101.append(")");
        String r102 = r101.toString();
        SupportSQLiteStatement r103 = this.f496972a.compileStatement(r102);
        Iterator<Long> r104 = r100.iterator();
        int r105 = 1;
    L4:
        if (r104.hasNext() == false) goto L10;
        Long r106 = r104.next();
        if (r106 != null) goto L8;
        r103.bindNull(r105);
    L9:
        r105 = r105 + 1;
        goto L4
    L8:
        r103.bindLong(r105, r106.longValue());
        goto L9
    L10:
        this.f496972a.beginTransaction();
        int r107 = r103.executeUpdateDelete();     // Catch: Throwable -> L14
        this.f496972a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f496972a.endTransaction();
        return r107;
    L14:
        th = move-exception;
        this.f496972a.endTransaction();
        throw th;
    }

    public final List<g> b(String r210) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM bitable_file_model WHERE table_id= ?", 1);
        if (r210 != null) goto L5;
        r100.bindNull(1);
    L6:
        this.f496972a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f496972a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, DBDefinition.ID);     // Catch: Throwable -> L22
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "name");     // Catch: Throwable -> L22
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "token");     // Catch: Throwable -> L22
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "doc_url");     // Catch: Throwable -> L22
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "table_id");     // Catch: Throwable -> L22
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "field_id");     // Catch: Throwable -> L22
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "record_id");     // Catch: Throwable -> L22
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "path");     // Catch: Throwable -> L22
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "uri");     // Catch: Throwable -> L22
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "mime_type");     // Catch: Throwable -> L22
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "width");     // Catch: Throwable -> L22
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "height");     // Catch: Throwable -> L22
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "upload_task_key");     // Catch: Throwable -> L22
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "upload_progress");     // Catch: Throwable -> L22
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "attachment_token");     // Catch: Throwable -> L20
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "is_camera_only");     // Catch: Throwable -> L20
        int r119 = r109;
        ArrayList r120 = new ArrayList(r101.getCount());     // Catch: Throwable -> L20
    L11:
        if (r101.moveToNext() == false) goto L18;
        g r121 = new g();     // Catch: Throwable -> L20
        ArrayList r211 = r120;
        int r212 = r107;
        r121.f496977a = r101.getLong(r102);     // Catch: Throwable -> L20
        r121.f496978b = r101.getString(r103);     // Catch: Throwable -> L20
        r121.f496979c = r101.getString(r104);     // Catch: Throwable -> L20
        r121.f496980d = r101.getString(r105);     // Catch: Throwable -> L20
        r121.f496981e = r101.getString(r106);     // Catch: Throwable -> L20
        r121.f496982f = r101.getString(r110);     // Catch: Throwable -> L20
        r121.f496983g = r101.getString(r111);     // Catch: Throwable -> L20
        r121.f496984h = r101.getString(r112);     // Catch: Throwable -> L20
        r121.f496985i = r101.getString(r113);     // Catch: Throwable -> L20
        r121.f496986j = r101.getString(r114);     // Catch: Throwable -> L20
        r121.f496987k = r101.getInt(r115);     // Catch: Throwable -> L20
        r121.f496988l = r101.getInt(r212);     // Catch: Throwable -> L20
        r121.f496989m = r101.getString(r108);     // Catch: Throwable -> L20
        int r122 = r119;
        int r123 = r102;
        r121.f496990n = r101.getInt(r122);     // Catch: Throwable -> L20
        r117 = r117;
        r121.f496991o = r101.getString(r117);     // Catch: Throwable -> L20
        int r124 = r118;
        if (r101.getInt(r124) == 0) goto L15;
        boolean r125 = true;
    L16:
        r121.f496992p = r125;     // Catch: Throwable -> L20
        r211.add(r121);     // Catch: Throwable -> L20
        r118 = r124;
        r120 = r211;
        r102 = r123;
        r119 = r122;
        r107 = r212;
        goto L11
    L15:
        r125 = false;
        goto L16
    L18:
        ArrayList r126 = r120;
        r101.close();
        r116.release();
        return r126;
    L20:
        th = th;
    L24:
        r101.close();
        r116.release();
        throw th;
    L22:
        th = th;
        r116 = r100;
        goto L24
    L5:
        r100.bindString(1, r210);
        goto L6
    }

    public final List<g> c(String r210) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM bitable_file_model WHERE table_id!= ?", 1);
        if (r210 != null) goto L5;
        r100.bindNull(1);
    L6:
        this.f496972a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f496972a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, DBDefinition.ID);     // Catch: Throwable -> L22
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "name");     // Catch: Throwable -> L22
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "token");     // Catch: Throwable -> L22
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "doc_url");     // Catch: Throwable -> L22
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "table_id");     // Catch: Throwable -> L22
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "field_id");     // Catch: Throwable -> L22
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "record_id");     // Catch: Throwable -> L22
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "path");     // Catch: Throwable -> L22
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "uri");     // Catch: Throwable -> L22
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "mime_type");     // Catch: Throwable -> L22
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "width");     // Catch: Throwable -> L22
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "height");     // Catch: Throwable -> L22
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "upload_task_key");     // Catch: Throwable -> L22
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "upload_progress");     // Catch: Throwable -> L22
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "attachment_token");     // Catch: Throwable -> L20
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "is_camera_only");     // Catch: Throwable -> L20
        int r119 = r109;
        ArrayList r120 = new ArrayList(r101.getCount());     // Catch: Throwable -> L20
    L11:
        if (r101.moveToNext() == false) goto L18;
        g r121 = new g();     // Catch: Throwable -> L20
        ArrayList r211 = r120;
        int r212 = r107;
        r121.f496977a = r101.getLong(r102);     // Catch: Throwable -> L20
        r121.f496978b = r101.getString(r103);     // Catch: Throwable -> L20
        r121.f496979c = r101.getString(r104);     // Catch: Throwable -> L20
        r121.f496980d = r101.getString(r105);     // Catch: Throwable -> L20
        r121.f496981e = r101.getString(r106);     // Catch: Throwable -> L20
        r121.f496982f = r101.getString(r110);     // Catch: Throwable -> L20
        r121.f496983g = r101.getString(r111);     // Catch: Throwable -> L20
        r121.f496984h = r101.getString(r112);     // Catch: Throwable -> L20
        r121.f496985i = r101.getString(r113);     // Catch: Throwable -> L20
        r121.f496986j = r101.getString(r114);     // Catch: Throwable -> L20
        r121.f496987k = r101.getInt(r115);     // Catch: Throwable -> L20
        r121.f496988l = r101.getInt(r212);     // Catch: Throwable -> L20
        r121.f496989m = r101.getString(r108);     // Catch: Throwable -> L20
        int r122 = r119;
        int r123 = r102;
        r121.f496990n = r101.getInt(r122);     // Catch: Throwable -> L20
        r117 = r117;
        r121.f496991o = r101.getString(r117);     // Catch: Throwable -> L20
        int r124 = r118;
        if (r101.getInt(r124) == 0) goto L15;
        boolean r125 = true;
    L16:
        r121.f496992p = r125;     // Catch: Throwable -> L20
        r211.add(r121);     // Catch: Throwable -> L20
        r118 = r124;
        r120 = r211;
        r102 = r123;
        r119 = r122;
        r107 = r212;
        goto L11
    L15:
        r125 = false;
        goto L16
    L18:
        ArrayList r126 = r120;
        r101.close();
        r116.release();
        return r126;
    L20:
        th = th;
    L24:
        r101.close();
        r116.release();
        throw th;
    L22:
        th = th;
        r116 = r100;
        goto L24
    L5:
        r100.bindString(1, r210);
        goto L6
    }

    public final int d(long r100, String r101) {
        this.f496972a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.f496976e.acquire();
        if (r101 != null) goto L5;
        r102.bindNull(1);
    L6:
        r102.bindLong(2, r100);
        this.f496972a.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f496972a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f496972a.endTransaction();
        this.f496976e.release(r102);
        return r103;
    L10:
        th = move-exception;
        this.f496972a.endTransaction();
        this.f496976e.release(r102);
        throw th;
    L5:
        r102.bindString(1, r101);
        goto L6
    }

    public final int f(long r100, String r101) {
        this.f496972a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.f496975d.acquire();
        if (r101 != null) goto L5;
        r102.bindNull(1);
    L6:
        r102.bindLong(2, r100);
        this.f496972a.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f496972a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f496972a.endTransaction();
        this.f496975d.release(r102);
        return r103;
    L10:
        th = move-exception;
        this.f496972a.endTransaction();
        this.f496975d.release(r102);
        throw th;
    L5:
        r102.bindString(1, r101);
        goto L6
    }

    public final int e(long r100, String r101, int r102) {
        this.f496972a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r103 = this.f496974c.acquire();
        r103.bindLong(1, r102);
        if (r101 != null) goto L5;
        r103.bindNull(2);
    L6:
        r103.bindLong(3, r100);
        this.f496972a.beginTransaction();
        int r104 = r103.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f496972a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f496972a.endTransaction();
        this.f496974c.release(r103);
        return r104;
    L10:
        th = move-exception;
        this.f496972a.endTransaction();
        this.f496974c.release(r103);
        throw th;
    L5:
        r103.bindString(2, r101);
        goto L6
    }
}
