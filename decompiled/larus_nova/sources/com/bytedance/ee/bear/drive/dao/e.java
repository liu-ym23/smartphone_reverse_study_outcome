package com.bytedance.ee.bear.drive.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f224398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f224399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f224400c;

    public class a extends EntityInsertionAdapter<y75.b> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `drive_excel_sub_cache` (`sdk_app_id`,`obj_token`,`data_version`,`sub_id`,`json_data_file_path`,`json_data`) VALUES (?,?,?,?,?,?)";
        }

        public a(RoomDatabase r100) {
            super(r100);
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement r100, y75.b r101) {
            y75.b r102 = r101;
            String r103 = r102.f566619a;
            if (r103 != null) goto L5;
            r100.bindNull(1);
        L6:
            String r104 = r102.f566620b;
            if (r104 != null) goto L9;
            r100.bindNull(2);
        L10:
            String r105 = r102.f566621c;
            if (r105 != null) goto L13;
            r100.bindNull(3);
        L14:
            String r106 = r102.f566622d;
            if (r106 != null) goto L17;
            r100.bindNull(4);
        L18:
            String r107 = r102.f566623e;
            if (r107 != null) goto L21;
            r100.bindNull(5);
        L22:
            String r108 = r102.f566624f;
            if (r108 != null) goto L25;
            r100.bindNull(6);
            return;
        L25:
            r100.bindString(6, r108);
            return;
        L21:
            r100.bindString(5, r107);
            goto L22
        L17:
            r100.bindString(4, r106);
            goto L18
        L13:
            r100.bindString(3, r105);
            goto L14
        L9:
            r100.bindString(2, r104);
            goto L10
        L5:
            r100.bindString(1, r103);
            goto L6
        }
    }

    public class b extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM drive_excel_sub_cache WHERE sdk_app_id = ? AND obj_token = ? AND data_version = ?";
        }

        public b(RoomDatabase r100) {
            super(r100);
        }
    }

    public e(RoomDatabase r100) {
        this.f224398a = r100;
        this.f224399b = new a(r100);
        this.f224400c = new b(r100);
    }

    public final int a(String r100, String r101, String r102) {
        this.f224398a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r103 = this.f224400c.acquire();
        if (r100 != null) goto L5;
        r103.bindNull(1);
    L7:
        if (r101 != null) goto L9;
        r103.bindNull(2);
    L11:
        if (r102 != null) goto L13;
        r103.bindNull(3);
    L14:
        this.f224398a.beginTransaction();
        int r104 = r103.executeUpdateDelete();     // Catch: Throwable -> L18
        this.f224398a.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.f224398a.endTransaction();
        this.f224400c.release(r103);
        return r104;
    L18:
        th = move-exception;
        this.f224398a.endTransaction();
        this.f224400c.release(r103);
        throw th;
    L13:
        r103.bindString(3, r102);
        goto L14
    L9:
        r103.bindString(2, r101);
        goto L11
    L5:
        r103.bindString(1, r100);
        goto L7
    }

    public final List<y75.b> b(String r100, String r110, String r111) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM drive_excel_sub_cache WHERE sdk_app_id = ? AND obj_token = ? AND data_version = ?", 3);
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L7:
        if (r110 != null) goto L9;
        r101.bindNull(2);
    L10:
        if (r111 != null) goto L12;
        r101.bindNull(3);
    L13:
        this.f224398a.assertNotSuspendingTransaction();
        Cursor r102 = DBUtil.query(this.f224398a, r101, false, null);
        int r112 = CursorUtil.getColumnIndexOrThrow(r102, MonitorConstants.EXTRA_SDK_ID);     // Catch: Throwable -> L21
        int r113 = CursorUtil.getColumnIndexOrThrow(r102, "obj_token");     // Catch: Throwable -> L21
        int r103 = CursorUtil.getColumnIndexOrThrow(r102, "data_version");     // Catch: Throwable -> L21
        int r104 = CursorUtil.getColumnIndexOrThrow(r102, SubInfo.KEY_SUB_ID);     // Catch: Throwable -> L21
        int r105 = CursorUtil.getColumnIndexOrThrow(r102, "json_data_file_path");     // Catch: Throwable -> L21
        int r106 = CursorUtil.getColumnIndexOrThrow(r102, "json_data");     // Catch: Throwable -> L21
        ArrayList r107 = new ArrayList(r102.getCount());     // Catch: Throwable -> L21
    L16:
        if (r102.moveToNext() == false) goto L19;
        y75.b r108 = new y75.b();     // Catch: Throwable -> L21
        r108.f566619a = r102.getString(r112);     // Catch: Throwable -> L21
        r108.f566620b = r102.getString(r113);     // Catch: Throwable -> L21
        r108.f566621c = r102.getString(r103);     // Catch: Throwable -> L21
        r108.f566622d = r102.getString(r104);     // Catch: Throwable -> L21
        r108.f566623e = r102.getString(r105);     // Catch: Throwable -> L21
        r108.f566624f = r102.getString(r106);     // Catch: Throwable -> L21
        r107.add(r108);     // Catch: Throwable -> L21
        goto L16
    L19:
        r102.close();
        r101.release();
        return r107;
    L21:
        th = move-exception;
        r102.close();
        r101.release();
        throw th;
    L12:
        r101.bindString(3, r111);
        goto L13
    L9:
        r101.bindString(2, r110);
        goto L10
    L5:
        r101.bindString(1, r100);
        goto L7
    }
}
