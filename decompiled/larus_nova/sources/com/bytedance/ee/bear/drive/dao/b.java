package com.bytedance.ee.bear.drive.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements com.bytedance.ee.bear.drive.dao.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f224387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f224388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C3218b f224389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f224390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f224391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f224392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f224393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f224394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h f224395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f224396j;

    public class a extends EntityInsertionAdapter<y75.a> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `t_drive_cache` (`cache_key`,`obj_token`,`src_ext`,`preview_ext`,`data_version`,`source_from`,`cache_source_from`,`file_path`,`partial_file_path`,`temp_file_path`,`file_size`,`type`,`last_access_time`,`modification_time`,`file_name`,`cache_uid`,`cache_tenant_id`,`preview_extra`,`is_use_partial_file`,`cache_host`,`sdk_app_id`,`sdk_extra`,`flags`,`mime_type`,`risk_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        public a(RoomDatabase r100) {
            super(r100);
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement r100, y75.a r101) {
            y75.a r102 = r101;
            String r103 = r102.f566594a;
            if (r103 != null) goto L5;
            r100.bindNull(1);
        L6:
            String r104 = r102.f566595b;
            if (r104 != null) goto L9;
            r100.bindNull(2);
        L10:
            String r105 = r102.f566596c;
            if (r105 != null) goto L13;
            r100.bindNull(3);
        L14:
            String r106 = r102.f566597d;
            if (r106 != null) goto L17;
            r100.bindNull(4);
        L18:
            String r107 = r102.f566598e;
            if (r107 != null) goto L21;
            r100.bindNull(5);
        L22:
            String r108 = r102.f566599f;
            if (r108 != null) goto L25;
            r100.bindNull(6);
        L26:
            String r109 = r102.f566600g;
            if (r109 != null) goto L29;
            r100.bindNull(7);
        L30:
            String r110 = r102.f566601h;
            String r111 = "";
            if (r110 != null) goto L33;
            r110 = "";
        L33:
            r100.bindString(8, r110);
            String r112 = r102.f566602i;
            if (r112 != null) goto L36;
            r112 = "";
        L36:
            r100.bindString(9, r112);
            String r113 = r102.f566603j;
            if (r113 == null) goto L40;
            r111 = r113;
        L40:
            r100.bindString(10, r111);
            r100.bindLong(11, r102.f566604k);
            r100.bindLong(12, r102.getType());
            r100.bindLong(13, r102.f566606m);
            r100.bindLong(14, r102.f566607n);
            String r114 = r102.f566608o;
            if (r114 != null) goto L43;
            r100.bindNull(15);
        L44:
            String r115 = r102.f566609p;
            if (r115 != null) goto L47;
            r100.bindNull(16);
        L48:
            String r116 = r102.f566610q;
            if (r116 != null) goto L51;
            r100.bindNull(17);
        L52:
            String r117 = r102.f566611r;
            if (r117 != null) goto L55;
            r100.bindNull(18);
        L56:
            r100.bindLong(19, r102.f566612s ? 1 : 0);
            r100.bindLong(20, r102.f566613t);
            String r118 = r102.f566614u;
            if (r118 != null) goto L59;
            r100.bindNull(21);
        L60:
            String r119 = r102.f566615v;
            if (r119 != null) goto L63;
            r100.bindNull(22);
        L64:
            r100.bindLong(23, r102.f566616w);
            String r120 = r102.f566617x;
            if (r120 != null) goto L67;
            r100.bindNull(24);
        L68:
            r100.bindLong(25, r102.f566618y);
            return;
        L67:
            r100.bindString(24, r120);
            goto L68
        L63:
            r100.bindString(22, r119);
            goto L64
        L59:
            r100.bindString(21, r118);
            goto L60
        L55:
            r100.bindString(18, r117);
            goto L56
        L51:
            r100.bindString(17, r116);
            goto L52
        L47:
            r100.bindString(16, r115);
            goto L48
        L43:
            r100.bindString(15, r114);
            goto L44
        L29:
            r100.bindString(7, r109);
            goto L30
        L25:
            r100.bindString(6, r108);
            goto L26
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

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.dao.b$b, reason: collision with other inner class name */
    public class C3218b extends EntityDeletionOrUpdateAdapter<y75.a> {
        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE OR ABORT `t_drive_cache` SET `cache_key` = ?,`obj_token` = ?,`src_ext` = ?,`preview_ext` = ?,`data_version` = ?,`source_from` = ?,`cache_source_from` = ?,`file_path` = ?,`partial_file_path` = ?,`temp_file_path` = ?,`file_size` = ?,`type` = ?,`last_access_time` = ?,`modification_time` = ?,`file_name` = ?,`cache_uid` = ?,`cache_tenant_id` = ?,`preview_extra` = ?,`is_use_partial_file` = ?,`cache_host` = ?,`sdk_app_id` = ?,`sdk_extra` = ?,`flags` = ?,`mime_type` = ?,`risk_status` = ? WHERE `cache_key` = ?";
        }

        public C3218b(RoomDatabase r100) {
            super(r100);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public final void bind(SupportSQLiteStatement r100, y75.a r101) {
            y75.a r102 = r101;
            String r103 = r102.f566594a;
            if (r103 != null) goto L5;
            r100.bindNull(1);
        L6:
            String r104 = r102.f566595b;
            if (r104 != null) goto L9;
            r100.bindNull(2);
        L10:
            String r105 = r102.f566596c;
            if (r105 != null) goto L13;
            r100.bindNull(3);
        L14:
            String r106 = r102.f566597d;
            if (r106 != null) goto L17;
            r100.bindNull(4);
        L18:
            String r107 = r102.f566598e;
            if (r107 != null) goto L21;
            r100.bindNull(5);
        L22:
            String r108 = r102.f566599f;
            if (r108 != null) goto L25;
            r100.bindNull(6);
        L26:
            String r109 = r102.f566600g;
            if (r109 != null) goto L29;
            r100.bindNull(7);
        L30:
            String r110 = r102.f566601h;
            String r111 = "";
            if (r110 != null) goto L33;
            r110 = "";
        L33:
            r100.bindString(8, r110);
            String r112 = r102.f566602i;
            if (r112 != null) goto L36;
            r112 = "";
        L36:
            r100.bindString(9, r112);
            String r113 = r102.f566603j;
            if (r113 == null) goto L40;
            r111 = r113;
        L40:
            r100.bindString(10, r111);
            r100.bindLong(11, r102.f566604k);
            r100.bindLong(12, r102.getType());
            r100.bindLong(13, r102.f566606m);
            r100.bindLong(14, r102.f566607n);
            String r114 = r102.f566608o;
            if (r114 != null) goto L43;
            r100.bindNull(15);
        L44:
            String r115 = r102.f566609p;
            if (r115 != null) goto L47;
            r100.bindNull(16);
        L48:
            String r116 = r102.f566610q;
            if (r116 != null) goto L51;
            r100.bindNull(17);
        L52:
            String r117 = r102.f566611r;
            if (r117 != null) goto L55;
            r100.bindNull(18);
        L56:
            r100.bindLong(19, r102.f566612s ? 1 : 0);
            r100.bindLong(20, r102.f566613t);
            String r118 = r102.f566614u;
            if (r118 != null) goto L59;
            r100.bindNull(21);
        L60:
            String r119 = r102.f566615v;
            if (r119 != null) goto L63;
            r100.bindNull(22);
        L64:
            r100.bindLong(23, r102.f566616w);
            String r120 = r102.f566617x;
            if (r120 != null) goto L67;
            r100.bindNull(24);
        L68:
            r100.bindLong(25, r102.f566618y);
            String r121 = r102.f566594a;
            if (r121 != null) goto L71;
            r100.bindNull(26);
            return;
        L71:
            r100.bindString(26, r121);
            return;
        L67:
            r100.bindString(24, r120);
            goto L68
        L63:
            r100.bindString(22, r119);
            goto L64
        L59:
            r100.bindString(21, r118);
            goto L60
        L55:
            r100.bindString(18, r117);
            goto L56
        L51:
            r100.bindString(17, r116);
            goto L52
        L47:
            r100.bindString(16, r115);
            goto L48
        L43:
            r100.bindString(15, r114);
            goto L44
        L29:
            r100.bindString(7, r109);
            goto L30
        L25:
            r100.bindString(6, r108);
            goto L26
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

    public class c extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE t_drive_cache set last_access_time = ? WHERE cache_key = ?";
        }

        public c(RoomDatabase r100) {
            super(r100);
        }
    }

    public class d extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM t_drive_cache WHERE cache_key = ?";
        }

        public d(RoomDatabase r100) {
            super(r100);
        }
    }

    public class e extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM t_drive_cache WHERE obj_token = ?";
        }

        public e(RoomDatabase r100) {
            super(r100);
        }
    }

    public class f extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM t_drive_cache";
        }

        public f(RoomDatabase r100) {
            super(r100);
        }
    }

    public class g extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE t_drive_cache SET type = ?, file_path = ?  WHERE cache_key = ?";
        }

        public g(RoomDatabase r100) {
            super(r100);
        }
    }

    public class h extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE t_drive_cache SET cache_source_from= ?, file_path= ? WHERE cache_key= ?";
        }

        public h(RoomDatabase r100) {
            super(r100);
        }
    }

    public class i extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE t_drive_cache SET file_name = ? WHERE cache_key = ?";
        }

        public i(RoomDatabase r100) {
            super(r100);
        }
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List a0() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE type = ? ORDER BY last_access_time ASC LIMIT ?", 2);
        r100.bindLong(1, 0);
        r100.bindLong(2, 16);
        this.f224387a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f224387a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "cache_key");     // Catch: Throwable -> L18
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L18
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "src_ext");     // Catch: Throwable -> L18
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "preview_ext");     // Catch: Throwable -> L18
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "data_version");     // Catch: Throwable -> L18
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "source_from");     // Catch: Throwable -> L18
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "cache_source_from");     // Catch: Throwable -> L18
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "file_path");     // Catch: Throwable -> L18
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "partial_file_path");     // Catch: Throwable -> L18
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "temp_file_path");     // Catch: Throwable -> L18
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "file_size");     // Catch: Throwable -> L18
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L18
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "last_access_time");     // Catch: Throwable -> L18
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "modification_time");     // Catch: Throwable -> L18
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "file_name");     // Catch: Throwable -> L16
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "cache_uid");     // Catch: Throwable -> L16
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "cache_tenant_id");     // Catch: Throwable -> L16
        int r210 = CursorUtil.getColumnIndexOrThrow(r101, "preview_extra");     // Catch: Throwable -> L16
        int r211 = CursorUtil.getColumnIndexOrThrow(r101, "is_use_partial_file");     // Catch: Throwable -> L16
        int r212 = CursorUtil.getColumnIndexOrThrow(r101, "cache_host");     // Catch: Throwable -> L16
        int r213 = CursorUtil.getColumnIndexOrThrow(r101, MonitorConstants.EXTRA_SDK_ID);     // Catch: Throwable -> L16
        int r214 = CursorUtil.getColumnIndexOrThrow(r101, "sdk_extra");     // Catch: Throwable -> L16
        int r215 = CursorUtil.getColumnIndexOrThrow(r101, "flags");     // Catch: Throwable -> L16
        int r216 = CursorUtil.getColumnIndexOrThrow(r101, "mime_type");     // Catch: Throwable -> L16
        int r217 = CursorUtil.getColumnIndexOrThrow(r101, "risk_status");     // Catch: Throwable -> L16
        int r218 = r109;
        ArrayList r120 = new ArrayList(r101.getCount());     // Catch: Throwable -> L16
    L7:
        if (r101.moveToNext() == false) goto L14;
        y75.a r121 = new y75.a();     // Catch: Throwable -> L16
        ArrayList r219 = r120;
        r121.f566594a = r101.getString(r102);     // Catch: Throwable -> L16
        r121.f566595b = r101.getString(r103);     // Catch: Throwable -> L16
        r121.f566596c = r101.getString(r104);     // Catch: Throwable -> L16
        r121.f566597d = r101.getString(r105);     // Catch: Throwable -> L16
        r121.f566598e = r101.getString(r106);     // Catch: Throwable -> L16
        r121.f566599f = r101.getString(r110);     // Catch: Throwable -> L16
        r121.f566600g = r101.getString(r111);     // Catch: Throwable -> L16
        r121.f566601h = r101.getString(r112);     // Catch: Throwable -> L16
        r121.f566602i = r101.getString(r113);     // Catch: Throwable -> L16
        r121.f566603j = r101.getString(r114);     // Catch: Throwable -> L16
        int r310 = r102;
        r121.f566604k = r101.getLong(r115);     // Catch: Throwable -> L16
        r121.f566605l = r101.getInt(r107);     // Catch: Throwable -> L16
        r121.f566606m = r101.getLong(r108);     // Catch: Throwable -> L16
        int r122 = r218;
        int r220 = r103;
        r121.f566607n = r101.getLong(r122);     // Catch: Throwable -> L16
        int r123 = r117;
        r121.f566608o = r101.getString(r123);     // Catch: Throwable -> L16
        int r124 = r107;
        int r125 = r118;
        r121.f566609p = r101.getString(r125);     // Catch: Throwable -> L16
        int r126 = r119;
        r121.f566610q = r101.getString(r126);     // Catch: Throwable -> L16
        r119 = r126;
        int r127 = r210;
        r121.f566611r = r101.getString(r127);     // Catch: Throwable -> L16
        int r128 = r211;
        r211 = r128;
        if (r101.getInt(r128) == 0) goto L11;
        boolean r129 = true;
    L12:
        r121.f566612s = r129;     // Catch: Throwable -> L16
        r210 = r127;
        int r130 = r212;
        r121.f566613t = r101.getInt(r130);     // Catch: Throwable -> L16
        r212 = r130;
        int r131 = r213;
        r121.f566614u = r101.getString(r131);     // Catch: Throwable -> L16
        r213 = r131;
        int r132 = r214;
        r121.f566615v = r101.getString(r132);     // Catch: Throwable -> L16
        r214 = r132;
        int r133 = r215;
        r121.f566616w = r101.getInt(r133);     // Catch: Throwable -> L16
        r215 = r133;
        int r134 = r216;
        r121.f566617x = r101.getString(r134);     // Catch: Throwable -> L16
        r216 = r134;
        int r135 = r217;
        r121.f566618y = r101.getInt(r135);     // Catch: Throwable -> L16
        r219.add(r121);     // Catch: Throwable -> L16
        r217 = r135;
        r120 = r219;
        r107 = r124;
        r117 = r123;
        r102 = r310;
        r118 = r125;
        r103 = r220;
        r218 = r122;
        goto L7
    L11:
        r129 = false;
        goto L12
    L14:
        ArrayList r136 = r120;
        r101.close();
        r116.release();
        return r136;
    L16:
        th = th;
    L20:
        r101.close();
        r116.release();
        throw th;
    L18:
        th = th;
        r116 = r100;
        goto L20
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final long b0() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT SUM(file_size) FROM t_drive_cache WHERE type = ?", 1);
        r100.bindLong(1, 0);
        this.f224387a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f224387a, r100, false, null);
    L10:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    L4:
        if (r101.moveToFirst() == false) goto L7;
        long r102 = r101.getLong(0);     // Catch: Throwable -> L10
    L8:
        r101.close();
        r100.release();
        return r102;
    L7:
        r102 = 0;
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int deleteAll() {
        this.f224387a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r100 = this.f224393g.acquire();
        this.f224387a.beginTransaction();
        int r101 = r100.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f224387a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f224387a.endTransaction();
        this.f224393g.release(r100);
        return r101;
    L6:
        th = move-exception;
        this.f224387a.endTransaction();
        this.f224393g.release(r100);
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List<y75.a> g0() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache ORDER BY last_access_time DESC", 0);
        this.f224387a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f224387a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "cache_key");     // Catch: Throwable -> L18
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L18
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "src_ext");     // Catch: Throwable -> L18
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "preview_ext");     // Catch: Throwable -> L18
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "data_version");     // Catch: Throwable -> L18
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "source_from");     // Catch: Throwable -> L18
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "cache_source_from");     // Catch: Throwable -> L18
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "file_path");     // Catch: Throwable -> L18
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "partial_file_path");     // Catch: Throwable -> L18
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "temp_file_path");     // Catch: Throwable -> L18
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "file_size");     // Catch: Throwable -> L18
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L18
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "last_access_time");     // Catch: Throwable -> L18
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "modification_time");     // Catch: Throwable -> L18
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "file_name");     // Catch: Throwable -> L16
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "cache_uid");     // Catch: Throwable -> L16
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "cache_tenant_id");     // Catch: Throwable -> L16
        int r210 = CursorUtil.getColumnIndexOrThrow(r101, "preview_extra");     // Catch: Throwable -> L16
        int r211 = CursorUtil.getColumnIndexOrThrow(r101, "is_use_partial_file");     // Catch: Throwable -> L16
        int r212 = CursorUtil.getColumnIndexOrThrow(r101, "cache_host");     // Catch: Throwable -> L16
        int r213 = CursorUtil.getColumnIndexOrThrow(r101, MonitorConstants.EXTRA_SDK_ID);     // Catch: Throwable -> L16
        int r214 = CursorUtil.getColumnIndexOrThrow(r101, "sdk_extra");     // Catch: Throwable -> L16
        int r215 = CursorUtil.getColumnIndexOrThrow(r101, "flags");     // Catch: Throwable -> L16
        int r216 = CursorUtil.getColumnIndexOrThrow(r101, "mime_type");     // Catch: Throwable -> L16
        int r217 = CursorUtil.getColumnIndexOrThrow(r101, "risk_status");     // Catch: Throwable -> L16
        int r218 = r109;
        ArrayList r120 = new ArrayList(r101.getCount());     // Catch: Throwable -> L16
    L7:
        if (r101.moveToNext() == false) goto L14;
        y75.a r121 = new y75.a();     // Catch: Throwable -> L16
        ArrayList r219 = r120;
        r121.f566594a = r101.getString(r102);     // Catch: Throwable -> L16
        r121.f566595b = r101.getString(r103);     // Catch: Throwable -> L16
        r121.f566596c = r101.getString(r104);     // Catch: Throwable -> L16
        r121.f566597d = r101.getString(r105);     // Catch: Throwable -> L16
        r121.f566598e = r101.getString(r106);     // Catch: Throwable -> L16
        r121.f566599f = r101.getString(r107);     // Catch: Throwable -> L16
        r121.f566600g = r101.getString(r110);     // Catch: Throwable -> L16
        r121.f566601h = r101.getString(r111);     // Catch: Throwable -> L16
        r121.f566602i = r101.getString(r112);     // Catch: Throwable -> L16
        r121.f566603j = r101.getString(r113);     // Catch: Throwable -> L16
        int r122 = r103;
        int r310 = r104;
        r121.f566604k = r101.getLong(r114);     // Catch: Throwable -> L16
        r121.f566605l = r101.getInt(r115);     // Catch: Throwable -> L16
        r121.f566606m = r101.getLong(r108);     // Catch: Throwable -> L16
        int r123 = r108;
        int r124 = r218;
        r121.f566607n = r101.getLong(r124);     // Catch: Throwable -> L16
        int r125 = r117;
        r121.f566608o = r101.getString(r125);     // Catch: Throwable -> L16
        int r126 = r102;
        int r127 = r118;
        r121.f566609p = r101.getString(r127);     // Catch: Throwable -> L16
        int r128 = r119;
        r121.f566610q = r101.getString(r128);     // Catch: Throwable -> L16
        r119 = r128;
        int r129 = r210;
        r121.f566611r = r101.getString(r129);     // Catch: Throwable -> L16
        r211 = r211;
        if (r101.getInt(r211) == 0) goto L11;
        boolean r130 = true;
    L12:
        r121.f566612s = r130;     // Catch: Throwable -> L16
        r210 = r129;
        int r131 = r212;
        r121.f566613t = r101.getInt(r131);     // Catch: Throwable -> L16
        r212 = r131;
        int r132 = r213;
        r121.f566614u = r101.getString(r132);     // Catch: Throwable -> L16
        r213 = r132;
        int r133 = r214;
        r121.f566615v = r101.getString(r133);     // Catch: Throwable -> L16
        r214 = r133;
        int r134 = r215;
        r121.f566616w = r101.getInt(r134);     // Catch: Throwable -> L16
        r215 = r134;
        int r135 = r216;
        r121.f566617x = r101.getString(r135);     // Catch: Throwable -> L16
        r216 = r135;
        int r136 = r217;
        r121.f566618y = r101.getInt(r136);     // Catch: Throwable -> L16
        r219.add(r121);     // Catch: Throwable -> L16
        r217 = r136;
        r108 = r123;
        r104 = r310;
        r120 = r219;
        r102 = r126;
        r117 = r125;
        r118 = r127;
        r218 = r124;
        r103 = r122;
        goto L7
    L11:
        r130 = false;
        goto L12
    L14:
        ArrayList r137 = r120;
        r101.close();
        r116.release();
        return r137;
    L16:
        th = th;
    L20:
        r101.close();
        r116.release();
        throw th;
    L18:
        th = th;
        r116 = r100;
        goto L20
    }

    public b(RoomDatabase r100) {
        this.f224387a = r100;
        this.f224388b = new a(r100);
        this.f224389c = new C3218b(r100);
        this.f224390d = new c(r100);
        this.f224391e = new d(r100);
        this.f224392f = new e(r100);
        this.f224393g = new f(r100);
        this.f224394h = new g(r100);
        this.f224395i = new h(r100);
        this.f224396j = new i(r100);
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int S(String r100) {
        this.f224387a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f224392f.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f224387a.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f224387a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f224387a.endTransaction();
        this.f224392f.release(r101);
        return r102;
    L10:
        th = move-exception;
        this.f224387a.endTransaction();
        this.f224392f.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List U(long r310) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE type = ? AND last_access_time <= ?", 2);
        r100.bindLong(1, 0);
        r100.bindLong(2, r310);
        this.f224387a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f224387a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "cache_key");     // Catch: Throwable -> L18
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L18
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "src_ext");     // Catch: Throwable -> L18
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "preview_ext");     // Catch: Throwable -> L18
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "data_version");     // Catch: Throwable -> L18
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "source_from");     // Catch: Throwable -> L18
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "cache_source_from");     // Catch: Throwable -> L18
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "file_path");     // Catch: Throwable -> L18
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "partial_file_path");     // Catch: Throwable -> L18
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "temp_file_path");     // Catch: Throwable -> L18
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "file_size");     // Catch: Throwable -> L18
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L18
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "last_access_time");     // Catch: Throwable -> L18
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "modification_time");     // Catch: Throwable -> L18
        RoomSQLiteQuery r116 = r100;
        int r311 = CursorUtil.getColumnIndexOrThrow(r101, "file_name");     // Catch: Throwable -> L16
        int r312 = CursorUtil.getColumnIndexOrThrow(r101, "cache_uid");     // Catch: Throwable -> L16
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "cache_tenant_id");     // Catch: Throwable -> L16
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "preview_extra");     // Catch: Throwable -> L16
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "is_use_partial_file");     // Catch: Throwable -> L16
        int r210 = CursorUtil.getColumnIndexOrThrow(r101, "cache_host");     // Catch: Throwable -> L16
        int r211 = CursorUtil.getColumnIndexOrThrow(r101, MonitorConstants.EXTRA_SDK_ID);     // Catch: Throwable -> L16
        int r212 = CursorUtil.getColumnIndexOrThrow(r101, "sdk_extra");     // Catch: Throwable -> L16
        int r213 = CursorUtil.getColumnIndexOrThrow(r101, "flags");     // Catch: Throwable -> L16
        int r214 = CursorUtil.getColumnIndexOrThrow(r101, "mime_type");     // Catch: Throwable -> L16
        int r215 = CursorUtil.getColumnIndexOrThrow(r101, "risk_status");     // Catch: Throwable -> L16
        int r216 = r109;
        ArrayList r120 = new ArrayList(r101.getCount());     // Catch: Throwable -> L16
    L7:
        if (r101.moveToNext() == false) goto L14;
        y75.a r121 = new y75.a();     // Catch: Throwable -> L16
        ArrayList r217 = r120;
        r121.f566594a = r101.getString(r102);     // Catch: Throwable -> L16
        r121.f566595b = r101.getString(r103);     // Catch: Throwable -> L16
        r121.f566596c = r101.getString(r104);     // Catch: Throwable -> L16
        r121.f566597d = r101.getString(r105);     // Catch: Throwable -> L16
        r121.f566598e = r101.getString(r106);     // Catch: Throwable -> L16
        r121.f566599f = r101.getString(r110);     // Catch: Throwable -> L16
        r121.f566600g = r101.getString(r111);     // Catch: Throwable -> L16
        r121.f566601h = r101.getString(r112);     // Catch: Throwable -> L16
        r121.f566602i = r101.getString(r113);     // Catch: Throwable -> L16
        r121.f566603j = r101.getString(r114);     // Catch: Throwable -> L16
        int r218 = r102;
        r121.f566604k = r101.getLong(r115);     // Catch: Throwable -> L16
        r121.f566605l = r101.getInt(r107);     // Catch: Throwable -> L16
        r121.f566606m = r101.getLong(r108);     // Catch: Throwable -> L16
        int r122 = r216;
        int r219 = r103;
        r121.f566607n = r101.getLong(r122);     // Catch: Throwable -> L16
        int r123 = r311;
        r121.f566608o = r101.getString(r123);     // Catch: Throwable -> L16
        int r124 = r312;
        int r313 = r107;
        r121.f566609p = r101.getString(r124);     // Catch: Throwable -> L16
        int r125 = r117;
        r121.f566610q = r101.getString(r125);     // Catch: Throwable -> L16
        int r126 = r118;
        r121.f566611r = r101.getString(r126);     // Catch: Throwable -> L16
        r119 = r119;
        if (r101.getInt(r119) == 0) goto L11;
        boolean r127 = true;
    L12:
        r121.f566612s = r127;     // Catch: Throwable -> L16
        int r128 = r210;
        r121.f566613t = r101.getInt(r128);     // Catch: Throwable -> L16
        int r129 = r211;
        r121.f566614u = r101.getString(r129);     // Catch: Throwable -> L16
        int r130 = r212;
        r121.f566615v = r101.getString(r130);     // Catch: Throwable -> L16
        int r131 = r213;
        r121.f566616w = r101.getInt(r131);     // Catch: Throwable -> L16
        int r132 = r214;
        r121.f566617x = r101.getString(r132);     // Catch: Throwable -> L16
        int r133 = r215;
        r121.f566618y = r101.getInt(r133);     // Catch: Throwable -> L16
        r217.add(r121);     // Catch: Throwable -> L16
        r312 = r124;
        r103 = r219;
        r216 = r122;
        r117 = r125;
        r118 = r126;
        r210 = r128;
        r211 = r129;
        r212 = r130;
        r213 = r131;
        r214 = r132;
        r215 = r133;
        r120 = r217;
        r107 = r313;
        r311 = r123;
        r102 = r218;
        goto L7
    L11:
        r127 = false;
        goto L12
    L14:
        ArrayList r134 = r120;
        r101.close();
        r116.release();
        return r134;
    L16:
        th = th;
    L20:
        r101.close();
        r116.release();
        throw th;
    L18:
        th = th;
        r116 = r100;
        goto L20
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List W(int r310) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE type = ? AND cache_host = ? ORDER BY last_access_time DESC", 2);
        r100.bindLong(1, 0);
        r100.bindLong(2, r310);
        this.f224387a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f224387a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "cache_key");     // Catch: Throwable -> L18
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L18
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "src_ext");     // Catch: Throwable -> L18
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "preview_ext");     // Catch: Throwable -> L18
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "data_version");     // Catch: Throwable -> L18
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "source_from");     // Catch: Throwable -> L18
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "cache_source_from");     // Catch: Throwable -> L18
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "file_path");     // Catch: Throwable -> L18
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "partial_file_path");     // Catch: Throwable -> L18
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "temp_file_path");     // Catch: Throwable -> L18
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "file_size");     // Catch: Throwable -> L18
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L18
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "last_access_time");     // Catch: Throwable -> L18
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "modification_time");     // Catch: Throwable -> L18
        RoomSQLiteQuery r116 = r100;
        int r311 = CursorUtil.getColumnIndexOrThrow(r101, "file_name");     // Catch: Throwable -> L16
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "cache_uid");     // Catch: Throwable -> L16
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "cache_tenant_id");     // Catch: Throwable -> L16
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "preview_extra");     // Catch: Throwable -> L16
        int r210 = CursorUtil.getColumnIndexOrThrow(r101, "is_use_partial_file");     // Catch: Throwable -> L16
        int r211 = CursorUtil.getColumnIndexOrThrow(r101, "cache_host");     // Catch: Throwable -> L16
        int r212 = CursorUtil.getColumnIndexOrThrow(r101, MonitorConstants.EXTRA_SDK_ID);     // Catch: Throwable -> L16
        int r213 = CursorUtil.getColumnIndexOrThrow(r101, "sdk_extra");     // Catch: Throwable -> L16
        int r214 = CursorUtil.getColumnIndexOrThrow(r101, "flags");     // Catch: Throwable -> L16
        int r215 = CursorUtil.getColumnIndexOrThrow(r101, "mime_type");     // Catch: Throwable -> L16
        int r216 = CursorUtil.getColumnIndexOrThrow(r101, "risk_status");     // Catch: Throwable -> L16
        int r217 = r109;
        ArrayList r120 = new ArrayList(r101.getCount());     // Catch: Throwable -> L16
    L7:
        if (r101.moveToNext() == false) goto L14;
        y75.a r121 = new y75.a();     // Catch: Throwable -> L16
        ArrayList r218 = r120;
        r121.f566594a = r101.getString(r102);     // Catch: Throwable -> L16
        r121.f566595b = r101.getString(r103);     // Catch: Throwable -> L16
        r121.f566596c = r101.getString(r104);     // Catch: Throwable -> L16
        r121.f566597d = r101.getString(r105);     // Catch: Throwable -> L16
        r121.f566598e = r101.getString(r106);     // Catch: Throwable -> L16
        r121.f566599f = r101.getString(r110);     // Catch: Throwable -> L16
        r121.f566600g = r101.getString(r111);     // Catch: Throwable -> L16
        r121.f566601h = r101.getString(r112);     // Catch: Throwable -> L16
        r121.f566602i = r101.getString(r113);     // Catch: Throwable -> L16
        r121.f566603j = r101.getString(r114);     // Catch: Throwable -> L16
        int r219 = r102;
        r121.f566604k = r101.getLong(r115);     // Catch: Throwable -> L16
        r121.f566605l = r101.getInt(r107);     // Catch: Throwable -> L16
        r121.f566606m = r101.getLong(r108);     // Catch: Throwable -> L16
        int r122 = r217;
        int r220 = r103;
        r121.f566607n = r101.getLong(r122);     // Catch: Throwable -> L16
        int r123 = r311;
        r121.f566608o = r101.getString(r123);     // Catch: Throwable -> L16
        int r312 = r107;
        int r124 = r117;
        r121.f566609p = r101.getString(r124);     // Catch: Throwable -> L16
        int r125 = r118;
        r121.f566610q = r101.getString(r125);     // Catch: Throwable -> L16
        r118 = r125;
        int r126 = r119;
        r121.f566611r = r101.getString(r126);     // Catch: Throwable -> L16
        int r127 = r210;
        r210 = r127;
        if (r101.getInt(r127) == 0) goto L11;
        boolean r128 = true;
    L12:
        r121.f566612s = r128;     // Catch: Throwable -> L16
        r119 = r126;
        int r129 = r211;
        r121.f566613t = r101.getInt(r129);     // Catch: Throwable -> L16
        r211 = r129;
        int r130 = r212;
        r121.f566614u = r101.getString(r130);     // Catch: Throwable -> L16
        r212 = r130;
        int r131 = r213;
        r121.f566615v = r101.getString(r131);     // Catch: Throwable -> L16
        r213 = r131;
        int r132 = r214;
        r121.f566616w = r101.getInt(r132);     // Catch: Throwable -> L16
        r214 = r132;
        int r133 = r215;
        r121.f566617x = r101.getString(r133);     // Catch: Throwable -> L16
        r215 = r133;
        int r134 = r216;
        r121.f566618y = r101.getInt(r134);     // Catch: Throwable -> L16
        r218.add(r121);     // Catch: Throwable -> L16
        r216 = r134;
        r120 = r218;
        r107 = r312;
        r311 = r123;
        r102 = r219;
        r117 = r124;
        r103 = r220;
        r217 = r122;
        goto L7
    L11:
        r128 = false;
        goto L12
    L14:
        ArrayList r135 = r120;
        r101.close();
        r116.release();
        return r135;
    L16:
        th = th;
    L20:
        r101.close();
        r116.release();
        throw th;
    L18:
        th = th;
        r116 = r100;
        goto L20
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final long X(y75.a r100) {
        this.f224387a.assertNotSuspendingTransaction();
        this.f224387a.beginTransaction();
        long r101 = this.f224388b.insertAndReturnId(r100);     // Catch: Throwable -> L6
        this.f224387a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f224387a.endTransaction();
        return r101;
    L6:
        th = move-exception;
        this.f224387a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List<y75.a> Y(String r310) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE obj_token = ?", 1);
        if (r310 != null) goto L5;
        r100.bindNull(1);
    L6:
        this.f224387a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f224387a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "cache_key");     // Catch: Throwable -> L22
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L22
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "src_ext");     // Catch: Throwable -> L22
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "preview_ext");     // Catch: Throwable -> L22
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "data_version");     // Catch: Throwable -> L22
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "source_from");     // Catch: Throwable -> L22
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "cache_source_from");     // Catch: Throwable -> L22
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "file_path");     // Catch: Throwable -> L22
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "partial_file_path");     // Catch: Throwable -> L22
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "temp_file_path");     // Catch: Throwable -> L22
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "file_size");     // Catch: Throwable -> L22
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L22
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "last_access_time");     // Catch: Throwable -> L22
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "modification_time");     // Catch: Throwable -> L22
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "file_name");     // Catch: Throwable -> L20
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "cache_uid");     // Catch: Throwable -> L20
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "cache_tenant_id");     // Catch: Throwable -> L20
        int r210 = CursorUtil.getColumnIndexOrThrow(r101, "preview_extra");     // Catch: Throwable -> L20
        int r211 = CursorUtil.getColumnIndexOrThrow(r101, "is_use_partial_file");     // Catch: Throwable -> L20
        int r212 = CursorUtil.getColumnIndexOrThrow(r101, "cache_host");     // Catch: Throwable -> L20
        int r213 = CursorUtil.getColumnIndexOrThrow(r101, MonitorConstants.EXTRA_SDK_ID);     // Catch: Throwable -> L20
        int r214 = CursorUtil.getColumnIndexOrThrow(r101, "sdk_extra");     // Catch: Throwable -> L20
        int r215 = CursorUtil.getColumnIndexOrThrow(r101, "flags");     // Catch: Throwable -> L20
        int r216 = CursorUtil.getColumnIndexOrThrow(r101, "mime_type");     // Catch: Throwable -> L20
        int r217 = CursorUtil.getColumnIndexOrThrow(r101, "risk_status");     // Catch: Throwable -> L20
        int r218 = r109;
        ArrayList r120 = new ArrayList(r101.getCount());     // Catch: Throwable -> L20
    L11:
        if (r101.moveToNext() == false) goto L18;
        y75.a r121 = new y75.a();     // Catch: Throwable -> L20
        ArrayList r219 = r120;
        r121.f566594a = r101.getString(r102);     // Catch: Throwable -> L20
        r121.f566595b = r101.getString(r103);     // Catch: Throwable -> L20
        r121.f566596c = r101.getString(r104);     // Catch: Throwable -> L20
        r121.f566597d = r101.getString(r105);     // Catch: Throwable -> L20
        r121.f566598e = r101.getString(r106);     // Catch: Throwable -> L20
        r121.f566599f = r101.getString(r110);     // Catch: Throwable -> L20
        r121.f566600g = r101.getString(r111);     // Catch: Throwable -> L20
        r121.f566601h = r101.getString(r112);     // Catch: Throwable -> L20
        r121.f566602i = r101.getString(r113);     // Catch: Throwable -> L20
        r121.f566603j = r101.getString(r114);     // Catch: Throwable -> L20
        int r122 = r103;
        int r311 = r104;
        r121.f566604k = r101.getLong(r115);     // Catch: Throwable -> L20
        r121.f566605l = r101.getInt(r107);     // Catch: Throwable -> L20
        r121.f566606m = r101.getLong(r108);     // Catch: Throwable -> L20
        int r123 = r107;
        int r124 = r218;
        r121.f566607n = r101.getLong(r124);     // Catch: Throwable -> L20
        int r125 = r117;
        r121.f566608o = r101.getString(r125);     // Catch: Throwable -> L20
        int r126 = r102;
        int r127 = r118;
        r121.f566609p = r101.getString(r127);     // Catch: Throwable -> L20
        int r128 = r119;
        r121.f566610q = r101.getString(r128);     // Catch: Throwable -> L20
        r119 = r128;
        int r129 = r210;
        r121.f566611r = r101.getString(r129);     // Catch: Throwable -> L20
        int r130 = r211;
        r211 = r130;
        if (r101.getInt(r130) == 0) goto L15;
        boolean r131 = true;
    L16:
        r121.f566612s = r131;     // Catch: Throwable -> L20
        r210 = r129;
        int r132 = r212;
        r121.f566613t = r101.getInt(r132);     // Catch: Throwable -> L20
        r212 = r132;
        int r133 = r213;
        r121.f566614u = r101.getString(r133);     // Catch: Throwable -> L20
        r213 = r133;
        int r134 = r214;
        r121.f566615v = r101.getString(r134);     // Catch: Throwable -> L20
        r214 = r134;
        int r135 = r215;
        r121.f566616w = r101.getInt(r135);     // Catch: Throwable -> L20
        r215 = r135;
        int r136 = r216;
        r121.f566617x = r101.getString(r136);     // Catch: Throwable -> L20
        r216 = r136;
        int r137 = r217;
        r121.f566618y = r101.getInt(r137);     // Catch: Throwable -> L20
        r219.add(r121);     // Catch: Throwable -> L20
        r217 = r137;
        r120 = r219;
        r102 = r126;
        r117 = r125;
        r118 = r127;
        r107 = r123;
        r104 = r311;
        r218 = r124;
        r103 = r122;
        goto L11
    L15:
        r131 = false;
        goto L16
    L18:
        ArrayList r138 = r120;
        r101.close();
        r116.release();
        return r138;
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
        r100.bindString(1, r310);
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List<y75.a> c0(int r310) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE type = ? ORDER BY last_access_time DESC", 1);
        r100.bindLong(1, r310);
        this.f224387a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f224387a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "cache_key");     // Catch: Throwable -> L18
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L18
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "src_ext");     // Catch: Throwable -> L18
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "preview_ext");     // Catch: Throwable -> L18
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "data_version");     // Catch: Throwable -> L18
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "source_from");     // Catch: Throwable -> L18
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "cache_source_from");     // Catch: Throwable -> L18
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "file_path");     // Catch: Throwable -> L18
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "partial_file_path");     // Catch: Throwable -> L18
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "temp_file_path");     // Catch: Throwable -> L18
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "file_size");     // Catch: Throwable -> L18
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L18
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "last_access_time");     // Catch: Throwable -> L18
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "modification_time");     // Catch: Throwable -> L18
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "file_name");     // Catch: Throwable -> L16
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "cache_uid");     // Catch: Throwable -> L16
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "cache_tenant_id");     // Catch: Throwable -> L16
        int r210 = CursorUtil.getColumnIndexOrThrow(r101, "preview_extra");     // Catch: Throwable -> L16
        int r211 = CursorUtil.getColumnIndexOrThrow(r101, "is_use_partial_file");     // Catch: Throwable -> L16
        int r212 = CursorUtil.getColumnIndexOrThrow(r101, "cache_host");     // Catch: Throwable -> L16
        int r213 = CursorUtil.getColumnIndexOrThrow(r101, MonitorConstants.EXTRA_SDK_ID);     // Catch: Throwable -> L16
        int r214 = CursorUtil.getColumnIndexOrThrow(r101, "sdk_extra");     // Catch: Throwable -> L16
        int r215 = CursorUtil.getColumnIndexOrThrow(r101, "flags");     // Catch: Throwable -> L16
        int r216 = CursorUtil.getColumnIndexOrThrow(r101, "mime_type");     // Catch: Throwable -> L16
        int r217 = CursorUtil.getColumnIndexOrThrow(r101, "risk_status");     // Catch: Throwable -> L16
        int r218 = r109;
        ArrayList r120 = new ArrayList(r101.getCount());     // Catch: Throwable -> L16
    L7:
        if (r101.moveToNext() == false) goto L14;
        y75.a r121 = new y75.a();     // Catch: Throwable -> L16
        ArrayList r219 = r120;
        r121.f566594a = r101.getString(r102);     // Catch: Throwable -> L16
        r121.f566595b = r101.getString(r103);     // Catch: Throwable -> L16
        r121.f566596c = r101.getString(r104);     // Catch: Throwable -> L16
        r121.f566597d = r101.getString(r105);     // Catch: Throwable -> L16
        r121.f566598e = r101.getString(r106);     // Catch: Throwable -> L16
        r121.f566599f = r101.getString(r110);     // Catch: Throwable -> L16
        r121.f566600g = r101.getString(r111);     // Catch: Throwable -> L16
        r121.f566601h = r101.getString(r112);     // Catch: Throwable -> L16
        r121.f566602i = r101.getString(r113);     // Catch: Throwable -> L16
        r121.f566603j = r101.getString(r114);     // Catch: Throwable -> L16
        int r122 = r103;
        int r311 = r104;
        r121.f566604k = r101.getLong(r115);     // Catch: Throwable -> L16
        r121.f566605l = r101.getInt(r107);     // Catch: Throwable -> L16
        r121.f566606m = r101.getLong(r108);     // Catch: Throwable -> L16
        int r123 = r107;
        int r124 = r218;
        r121.f566607n = r101.getLong(r124);     // Catch: Throwable -> L16
        int r125 = r117;
        r121.f566608o = r101.getString(r125);     // Catch: Throwable -> L16
        int r126 = r102;
        int r127 = r118;
        r121.f566609p = r101.getString(r127);     // Catch: Throwable -> L16
        int r128 = r119;
        r121.f566610q = r101.getString(r128);     // Catch: Throwable -> L16
        r119 = r128;
        int r129 = r210;
        r121.f566611r = r101.getString(r129);     // Catch: Throwable -> L16
        int r130 = r211;
        r211 = r130;
        if (r101.getInt(r130) == 0) goto L11;
        boolean r131 = true;
    L12:
        r121.f566612s = r131;     // Catch: Throwable -> L16
        r210 = r129;
        int r132 = r212;
        r121.f566613t = r101.getInt(r132);     // Catch: Throwable -> L16
        r212 = r132;
        int r133 = r213;
        r121.f566614u = r101.getString(r133);     // Catch: Throwable -> L16
        r213 = r133;
        int r134 = r214;
        r121.f566615v = r101.getString(r134);     // Catch: Throwable -> L16
        r214 = r134;
        int r135 = r215;
        r121.f566616w = r101.getInt(r135);     // Catch: Throwable -> L16
        r215 = r135;
        int r136 = r216;
        r121.f566617x = r101.getString(r136);     // Catch: Throwable -> L16
        r216 = r136;
        int r137 = r217;
        r121.f566618y = r101.getInt(r137);     // Catch: Throwable -> L16
        r219.add(r121);     // Catch: Throwable -> L16
        r217 = r137;
        r107 = r123;
        r104 = r311;
        r120 = r219;
        r102 = r126;
        r117 = r125;
        r118 = r127;
        r218 = r124;
        r103 = r122;
        goto L7
    L11:
        r131 = false;
        goto L12
    L14:
        ArrayList r138 = r120;
        r101.close();
        r116.release();
        return r138;
    L16:
        th = th;
    L20:
        r101.close();
        r116.release();
        throw th;
    L18:
        th = th;
        r116 = r100;
        goto L20
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List<y75.a> d0(List<String> r310) {
        StringBuilder r100 = StringUtil.newStringBuilder();
        r100.append("SELECT ");
        r100.append("*");
        r100.append(" FROM t_drive_cache WHERE cache_key in (");
        int r101 = r310.size();
        StringUtil.appendPlaceholders(r100, r101);
        r100.append(")");
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire(r100.toString(), r101 + 0);
        Iterator<String> r103 = r310.iterator();
        int r104 = 1;
    L4:
        if (r103.hasNext() == false) goto L10;
        String r105 = r103.next();
        if (r105 != null) goto L8;
        r102.bindNull(r104);
    L9:
        r104 = r104 + 1;
        goto L4
    L8:
        r102.bindString(r104, r105);
        goto L9
    L10:
        this.f224387a.assertNotSuspendingTransaction();
        Cursor r106 = DBUtil.query(this.f224387a, r102, false, null);
        int r107 = CursorUtil.getColumnIndexOrThrow(r106, "cache_key");     // Catch: Throwable -> L26
        int r108 = CursorUtil.getColumnIndexOrThrow(r106, "obj_token");     // Catch: Throwable -> L26
        int r109 = CursorUtil.getColumnIndexOrThrow(r106, "src_ext");     // Catch: Throwable -> L26
        int r110 = CursorUtil.getColumnIndexOrThrow(r106, "preview_ext");     // Catch: Throwable -> L26
        int r111 = CursorUtil.getColumnIndexOrThrow(r106, "data_version");     // Catch: Throwable -> L26
        int r112 = CursorUtil.getColumnIndexOrThrow(r106, "source_from");     // Catch: Throwable -> L26
        int r113 = CursorUtil.getColumnIndexOrThrow(r106, "cache_source_from");     // Catch: Throwable -> L26
        int r114 = CursorUtil.getColumnIndexOrThrow(r106, "file_path");     // Catch: Throwable -> L26
        int r115 = CursorUtil.getColumnIndexOrThrow(r106, "partial_file_path");     // Catch: Throwable -> L26
        int r116 = CursorUtil.getColumnIndexOrThrow(r106, "temp_file_path");     // Catch: Throwable -> L26
        int r117 = CursorUtil.getColumnIndexOrThrow(r106, "file_size");     // Catch: Throwable -> L26
        int r118 = CursorUtil.getColumnIndexOrThrow(r106, "type");     // Catch: Throwable -> L26
        int r119 = CursorUtil.getColumnIndexOrThrow(r106, "last_access_time");     // Catch: Throwable -> L26
        int r120 = CursorUtil.getColumnIndexOrThrow(r106, "modification_time");     // Catch: Throwable -> L26
        RoomSQLiteQuery r121 = r102;
        int r122 = CursorUtil.getColumnIndexOrThrow(r106, "file_name");     // Catch: Throwable -> L24
        int r123 = CursorUtil.getColumnIndexOrThrow(r106, "cache_uid");     // Catch: Throwable -> L24
        int r124 = CursorUtil.getColumnIndexOrThrow(r106, "cache_tenant_id");     // Catch: Throwable -> L24
        int r210 = CursorUtil.getColumnIndexOrThrow(r106, "preview_extra");     // Catch: Throwable -> L24
        int r211 = CursorUtil.getColumnIndexOrThrow(r106, "is_use_partial_file");     // Catch: Throwable -> L24
        int r212 = CursorUtil.getColumnIndexOrThrow(r106, "cache_host");     // Catch: Throwable -> L24
        int r213 = CursorUtil.getColumnIndexOrThrow(r106, MonitorConstants.EXTRA_SDK_ID);     // Catch: Throwable -> L24
        int r214 = CursorUtil.getColumnIndexOrThrow(r106, "sdk_extra");     // Catch: Throwable -> L24
        int r215 = CursorUtil.getColumnIndexOrThrow(r106, "flags");     // Catch: Throwable -> L24
        int r216 = CursorUtil.getColumnIndexOrThrow(r106, "mime_type");     // Catch: Throwable -> L24
        int r217 = CursorUtil.getColumnIndexOrThrow(r106, "risk_status");     // Catch: Throwable -> L24
        int r218 = r120;
        ArrayList r125 = new ArrayList(r106.getCount());     // Catch: Throwable -> L24
    L15:
        if (r106.moveToNext() == false) goto L22;
        y75.a r126 = new y75.a();     // Catch: Throwable -> L24
        ArrayList r219 = r125;
        r126.f566594a = r106.getString(r107);     // Catch: Throwable -> L24
        r126.f566595b = r106.getString(r108);     // Catch: Throwable -> L24
        r126.f566596c = r106.getString(r109);     // Catch: Throwable -> L24
        r126.f566597d = r106.getString(r110);     // Catch: Throwable -> L24
        r126.f566598e = r106.getString(r111);     // Catch: Throwable -> L24
        r126.f566599f = r106.getString(r112);     // Catch: Throwable -> L24
        r126.f566600g = r106.getString(r113);     // Catch: Throwable -> L24
        r126.f566601h = r106.getString(r114);     // Catch: Throwable -> L24
        r126.f566602i = r106.getString(r115);     // Catch: Throwable -> L24
        r126.f566603j = r106.getString(r116);     // Catch: Throwable -> L24
        int r127 = r108;
        int r311 = r109;
        r126.f566604k = r106.getLong(r117);     // Catch: Throwable -> L24
        r126.f566605l = r106.getInt(r118);     // Catch: Throwable -> L24
        r126.f566606m = r106.getLong(r119);     // Catch: Throwable -> L24
        int r128 = r118;
        int r129 = r218;
        r126.f566607n = r106.getLong(r129);     // Catch: Throwable -> L24
        int r130 = r122;
        r126.f566608o = r106.getString(r130);     // Catch: Throwable -> L24
        int r131 = r107;
        int r132 = r123;
        r126.f566609p = r106.getString(r132);     // Catch: Throwable -> L24
        int r133 = r124;
        r126.f566610q = r106.getString(r133);     // Catch: Throwable -> L24
        r124 = r133;
        int r134 = r210;
        r126.f566611r = r106.getString(r134);     // Catch: Throwable -> L24
        int r135 = r211;
        r211 = r135;
        if (r106.getInt(r135) == 0) goto L19;
        boolean r136 = true;
    L20:
        r126.f566612s = r136;     // Catch: Throwable -> L24
        r210 = r134;
        int r137 = r212;
        r126.f566613t = r106.getInt(r137);     // Catch: Throwable -> L24
        r212 = r137;
        int r138 = r213;
        r126.f566614u = r106.getString(r138);     // Catch: Throwable -> L24
        r213 = r138;
        int r139 = r214;
        r126.f566615v = r106.getString(r139);     // Catch: Throwable -> L24
        r214 = r139;
        int r140 = r215;
        r126.f566616w = r106.getInt(r140);     // Catch: Throwable -> L24
        r215 = r140;
        int r141 = r216;
        r126.f566617x = r106.getString(r141);     // Catch: Throwable -> L24
        r216 = r141;
        int r142 = r217;
        r126.f566618y = r106.getInt(r142);     // Catch: Throwable -> L24
        r219.add(r126);     // Catch: Throwable -> L24
        r217 = r142;
        r125 = r219;
        r107 = r131;
        r122 = r130;
        r123 = r132;
        r118 = r128;
        r109 = r311;
        r218 = r129;
        r108 = r127;
        goto L15
    L19:
        r136 = false;
        goto L20
    L22:
        ArrayList r143 = r125;
        r106.close();
        r121.release();
        return r143;
    L24:
        th = th;
    L28:
        r106.close();
        r121.release();
        throw th;
    L26:
        th = th;
        r121 = r102;
        goto L28
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int deleteCache(String r100) {
        this.f224387a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f224391e.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f224387a.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f224387a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f224387a.endTransaction();
        this.f224391e.release(r101);
        return r102;
    L10:
        th = move-exception;
        this.f224387a.endTransaction();
        this.f224391e.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final y75.a e0(String r210) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE cache_key = ? LIMIT 1", 1);
        if (r210 != null) goto L5;
        r100.bindNull(1);
    L6:
        this.f224387a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f224387a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "cache_key");     // Catch: Throwable -> L22
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L22
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "src_ext");     // Catch: Throwable -> L22
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "preview_ext");     // Catch: Throwable -> L22
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "data_version");     // Catch: Throwable -> L22
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "source_from");     // Catch: Throwable -> L22
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "cache_source_from");     // Catch: Throwable -> L22
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "file_path");     // Catch: Throwable -> L22
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "partial_file_path");     // Catch: Throwable -> L22
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "temp_file_path");     // Catch: Throwable -> L22
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "file_size");     // Catch: Throwable -> L22
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L22
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "last_access_time");     // Catch: Throwable -> L22
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "modification_time");     // Catch: Throwable -> L22
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "file_name");     // Catch: Throwable -> L20
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "cache_uid");     // Catch: Throwable -> L20
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "cache_tenant_id");     // Catch: Throwable -> L20
        int r120 = CursorUtil.getColumnIndexOrThrow(r101, "preview_extra");     // Catch: Throwable -> L20
        int r121 = CursorUtil.getColumnIndexOrThrow(r101, "is_use_partial_file");     // Catch: Throwable -> L20
        int r122 = CursorUtil.getColumnIndexOrThrow(r101, "cache_host");     // Catch: Throwable -> L20
        int r123 = CursorUtil.getColumnIndexOrThrow(r101, MonitorConstants.EXTRA_SDK_ID);     // Catch: Throwable -> L20
        int r124 = CursorUtil.getColumnIndexOrThrow(r101, "sdk_extra");     // Catch: Throwable -> L20
        int r125 = CursorUtil.getColumnIndexOrThrow(r101, "flags");     // Catch: Throwable -> L20
        int r126 = CursorUtil.getColumnIndexOrThrow(r101, "mime_type");     // Catch: Throwable -> L20
        int r127 = CursorUtil.getColumnIndexOrThrow(r101, "risk_status");     // Catch: Throwable -> L20
        if (r101.moveToFirst() == false) goto L17;
        y75.a r128 = new y75.a();     // Catch: Throwable -> L20
        r128.f566594a = r101.getString(r102);     // Catch: Throwable -> L20
        r128.f566595b = r101.getString(r103);     // Catch: Throwable -> L20
        r128.f566596c = r101.getString(r104);     // Catch: Throwable -> L20
        r128.f566597d = r101.getString(r105);     // Catch: Throwable -> L20
        r128.f566598e = r101.getString(r110);     // Catch: Throwable -> L20
        r128.f566599f = r101.getString(r111);     // Catch: Throwable -> L20
        r128.f566600g = r101.getString(r112);     // Catch: Throwable -> L20
        r128.f566601h = r101.getString(r113);     // Catch: Throwable -> L20
        r128.f566602i = r101.getString(r114);     // Catch: Throwable -> L20
        r128.f566603j = r101.getString(r115);     // Catch: Throwable -> L20
        r128.f566604k = r101.getLong(r106);     // Catch: Throwable -> L20
        r128.f566605l = r101.getInt(r107);     // Catch: Throwable -> L20
        r128.f566606m = r101.getLong(r108);     // Catch: Throwable -> L20
        r128.f566607n = r101.getLong(r109);     // Catch: Throwable -> L20
        r128.f566608o = r101.getString(r117);     // Catch: Throwable -> L20
        r128.f566609p = r101.getString(r118);     // Catch: Throwable -> L20
        r128.f566610q = r101.getString(r119);     // Catch: Throwable -> L20
        r128.f566611r = r101.getString(r120);     // Catch: Throwable -> L20
        if (r101.getInt(r121) == 0) goto L14;
        boolean r129 = true;
    L15:
        r128.f566612s = r129;     // Catch: Throwable -> L20
        r128.f566613t = r101.getInt(r122);     // Catch: Throwable -> L20
        r128.f566614u = r101.getString(r123);     // Catch: Throwable -> L20
        r128.f566615v = r101.getString(r124);     // Catch: Throwable -> L20
        r128.f566616w = r101.getInt(r125);     // Catch: Throwable -> L20
        r128.f566617x = r101.getString(r126);     // Catch: Throwable -> L20
        r128.f566618y = r101.getInt(r127);     // Catch: Throwable -> L20
        y75.a r130 = r128;
    L18:
        r101.close();
        r116.release();
        return r130;
    L14:
        r129 = false;
        goto L15
    L17:
        r130 = null;
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

    @Override // com.bytedance.ee.bear.drive.dao.a
    public int update(y75.a r100) {
        this.f224387a.assertNotSuspendingTransaction();
        this.f224387a.beginTransaction();
        int r101 = this.f224389c.handle(r100) + 0;     // Catch: Throwable -> L6
        this.f224387a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f224387a.endTransaction();
        return r101;
    L6:
        th = move-exception;
        this.f224387a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int H(String r100, String r101) {
        this.f224387a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.f224396j.acquire();
        if (r101 != null) goto L5;
        r102.bindNull(1);
    L7:
        if (r100 != null) goto L9;
        r102.bindNull(2);
    L10:
        this.f224387a.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L14
        this.f224387a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f224387a.endTransaction();
        this.f224396j.release(r102);
        return r103;
    L14:
        th = move-exception;
        this.f224387a.endTransaction();
        this.f224396j.release(r102);
        throw th;
    L9:
        r102.bindString(2, r100);
        goto L10
    L5:
        r102.bindString(1, r101);
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int T(String r100, String r101) {
        this.f224387a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.f224395i.acquire();
        r102.bindString(1, "-1");
        if (r101 != null) goto L5;
        r102.bindNull(2);
    L7:
        if (r100 != null) goto L9;
        r102.bindNull(3);
    L10:
        this.f224387a.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L14
        this.f224387a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f224387a.endTransaction();
        this.f224395i.release(r102);
        return r103;
    L14:
        th = move-exception;
        this.f224387a.endTransaction();
        this.f224395i.release(r102);
        throw th;
    L9:
        r102.bindString(3, r100);
        goto L10
    L5:
        r102.bindString(2, r101);
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int f0(String r100, long r101) {
        this.f224387a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.f224390d.acquire();
        r102.bindLong(1, r101);
        if (r100 != null) goto L5;
        r102.bindNull(2);
    L6:
        this.f224387a.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f224387a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f224387a.endTransaction();
        this.f224390d.release(r102);
        return r103;
    L10:
        th = move-exception;
        this.f224387a.endTransaction();
        this.f224390d.release(r102);
        throw th;
    L5:
        r102.bindString(2, r100);
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int V(String r100, int r101, String r102) {
        this.f224387a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r103 = this.f224394h.acquire();
        r103.bindLong(1, r101);
        if (r102 != null) goto L5;
        r103.bindNull(2);
    L7:
        if (r100 != null) goto L9;
        r103.bindNull(3);
    L10:
        this.f224387a.beginTransaction();
        int r104 = r103.executeUpdateDelete();     // Catch: Throwable -> L14
        this.f224387a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f224387a.endTransaction();
        this.f224394h.release(r103);
        return r104;
    L14:
        th = move-exception;
        this.f224387a.endTransaction();
        this.f224394h.release(r103);
        throw th;
    L9:
        r103.bindString(3, r100);
        goto L10
    L5:
        r103.bindString(2, r102);
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List Z(long r310, String r311, String r312) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE type = ? AND cache_uid = ? AND cache_tenant_id = ? AND last_access_time <= ? AND modification_time <= ?", 5);
        r100.bindLong(1, 2);
        if (r311 != null) goto L5;
        r100.bindNull(2);
    L7:
        if (r312 != null) goto L9;
        r100.bindNull(3);
    L10:
        r100.bindLong(4, r310);
        r100.bindLong(5, r310);
        this.f224387a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f224387a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "cache_key");     // Catch: Throwable -> L26
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L26
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "src_ext");     // Catch: Throwable -> L26
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "preview_ext");     // Catch: Throwable -> L26
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "data_version");     // Catch: Throwable -> L26
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "source_from");     // Catch: Throwable -> L26
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "cache_source_from");     // Catch: Throwable -> L26
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "file_path");     // Catch: Throwable -> L26
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "partial_file_path");     // Catch: Throwable -> L26
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "temp_file_path");     // Catch: Throwable -> L26
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "file_size");     // Catch: Throwable -> L26
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L26
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "last_access_time");     // Catch: Throwable -> L26
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "modification_time");     // Catch: Throwable -> L26
        RoomSQLiteQuery r116 = r100;
        int r313 = CursorUtil.getColumnIndexOrThrow(r101, "file_name");     // Catch: Throwable -> L24
        int r314 = CursorUtil.getColumnIndexOrThrow(r101, "cache_uid");     // Catch: Throwable -> L24
        int r315 = CursorUtil.getColumnIndexOrThrow(r101, "cache_tenant_id");     // Catch: Throwable -> L24
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "preview_extra");     // Catch: Throwable -> L24
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "is_use_partial_file");     // Catch: Throwable -> L24
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "cache_host");     // Catch: Throwable -> L24
        int r210 = CursorUtil.getColumnIndexOrThrow(r101, MonitorConstants.EXTRA_SDK_ID);     // Catch: Throwable -> L24
        int r211 = CursorUtil.getColumnIndexOrThrow(r101, "sdk_extra");     // Catch: Throwable -> L24
        int r212 = CursorUtil.getColumnIndexOrThrow(r101, "flags");     // Catch: Throwable -> L24
        int r213 = CursorUtil.getColumnIndexOrThrow(r101, "mime_type");     // Catch: Throwable -> L24
        int r214 = CursorUtil.getColumnIndexOrThrow(r101, "risk_status");     // Catch: Throwable -> L24
        int r215 = r109;
        ArrayList r120 = new ArrayList(r101.getCount());     // Catch: Throwable -> L24
    L15:
        if (r101.moveToNext() == false) goto L22;
        y75.a r121 = new y75.a();     // Catch: Throwable -> L24
        ArrayList r216 = r120;
        r121.f566594a = r101.getString(r102);     // Catch: Throwable -> L24
        r121.f566595b = r101.getString(r103);     // Catch: Throwable -> L24
        r121.f566596c = r101.getString(r104);     // Catch: Throwable -> L24
        r121.f566597d = r101.getString(r105);     // Catch: Throwable -> L24
        r121.f566598e = r101.getString(r106);     // Catch: Throwable -> L24
        r121.f566599f = r101.getString(r107);     // Catch: Throwable -> L24
        r121.f566600g = r101.getString(r110);     // Catch: Throwable -> L24
        r121.f566601h = r101.getString(r111);     // Catch: Throwable -> L24
        r121.f566602i = r101.getString(r112);     // Catch: Throwable -> L24
        r121.f566603j = r101.getString(r113);     // Catch: Throwable -> L24
        int r217 = r103;
        r121.f566604k = r101.getLong(r114);     // Catch: Throwable -> L24
        r121.f566605l = r101.getInt(r108);     // Catch: Throwable -> L24
        r121.f566606m = r101.getLong(r115);     // Catch: Throwable -> L24
        int r122 = r215;
        int r218 = r104;
        r121.f566607n = r101.getLong(r122);     // Catch: Throwable -> L24
        int r123 = r313;
        r121.f566608o = r101.getString(r123);     // Catch: Throwable -> L24
        int r124 = r314;
        int r316 = r102;
        r121.f566609p = r101.getString(r124);     // Catch: Throwable -> L24
        int r125 = r315;
        int r317 = r108;
        r121.f566610q = r101.getString(r125);     // Catch: Throwable -> L24
        r315 = r125;
        int r126 = r117;
        r121.f566611r = r101.getString(r126);     // Catch: Throwable -> L24
        int r127 = r118;
        r118 = r127;
        if (r101.getInt(r127) == 0) goto L19;
        boolean r128 = true;
    L20:
        r121.f566612s = r128;     // Catch: Throwable -> L24
        r117 = r126;
        int r129 = r119;
        r121.f566613t = r101.getInt(r129);     // Catch: Throwable -> L24
        r119 = r129;
        int r130 = r210;
        r121.f566614u = r101.getString(r130);     // Catch: Throwable -> L24
        r210 = r130;
        int r131 = r211;
        r121.f566615v = r101.getString(r131);     // Catch: Throwable -> L24
        r211 = r131;
        int r132 = r212;
        r121.f566616w = r101.getInt(r132);     // Catch: Throwable -> L24
        r212 = r132;
        int r133 = r213;
        r121.f566617x = r101.getString(r133);     // Catch: Throwable -> L24
        r213 = r133;
        int r134 = r214;
        r121.f566618y = r101.getInt(r134);     // Catch: Throwable -> L24
        r216.add(r121);     // Catch: Throwable -> L24
        r214 = r134;
        r108 = r317;
        r314 = r124;
        r104 = r218;
        r215 = r122;
        r103 = r217;
        r102 = r316;
        r313 = r123;
        r120 = r216;
        goto L15
    L19:
        r128 = false;
        goto L20
    L22:
        ArrayList r135 = r120;
        r101.close();
        r116.release();
        return r135;
    L24:
        th = th;
    L28:
        r101.close();
        r116.release();
        throw th;
    L26:
        th = th;
        r116 = r100;
        goto L28
    L9:
        r100.bindString(3, r312);
        goto L10
    L5:
        r100.bindString(2, r311);
        goto L7
    }
}
