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
import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements com.bytedance.ee.bear.drive.dao.a {
    public final RoomDatabase a;
    public final a b;
    public final C0162b c;
    public final c d;
    public final d e;
    public final e f;
    public final f g;
    public final g h;
    public final h i;
    public final i j;

    public class a extends EntityInsertionAdapter<y75.a> {
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `t_drive_cache` (`cache_key`,`obj_token`,`src_ext`,`preview_ext`,`data_version`,`source_from`,`cache_source_from`,`file_path`,`partial_file_path`,`temp_file_path`,`file_size`,`type`,`last_access_time`,`modification_time`,`file_name`,`cache_uid`,`cache_tenant_id`,`preview_extra`,`is_use_partial_file`,`cache_host`,`sdk_app_id`,`sdk_extra`,`flags`,`mime_type`,`risk_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        public a(RoomDatabase r1) {
            super(r1);
        }

        public final void bind(SupportSQLiteStatement r5, Object r6) {
            y75.a r7 = (y75.a) r6;
            String r0 = r7.a;
            if (r0 != null) goto L5;
            r5.bindNull(1);
        L6:
            String r1 = r7.b;
            if (r1 != null) goto L9;
            r5.bindNull(2);
        L10:
            String r2 = r7.c;
            if (r2 != null) goto L13;
            r5.bindNull(3);
        L14:
            String r3 = r7.d;
            if (r3 != null) goto L17;
            r5.bindNull(4);
        L18:
            String r4 = r7.e;
            if (r4 != null) goto L21;
            r5.bindNull(5);
        L22:
            String r8 = r7.f;
            if (r8 != null) goto L25;
            r5.bindNull(6);
        L26:
            String r9 = r7.g;
            if (r9 != null) goto L29;
            r5.bindNull(7);
        L30:
            String r10 = r7.h;
            String r11 = "";
            if (r10 != null) goto L33;
            r10 = "";
        L33:
            r5.bindString(8, r10);
            String r12 = r7.i;
            if (r12 != null) goto L36;
            r12 = "";
        L36:
            r5.bindString(9, r12);
            String r13 = r7.j;
            if (r13 == null) goto L40;
            r11 = r13;
        L40:
            r5.bindString(10, r11);
            r5.bindLong(11, r7.k);
            r5.bindLong(12, r7.getType());
            r5.bindLong(13, r7.m);
            r5.bindLong(14, r7.n);
            String r14 = r7.o;
            if (r14 != null) goto L43;
            r5.bindNull(15);
        L44:
            String r16 = r7.p;
            if (r16 != null) goto L47;
            r5.bindNull(16);
        L48:
            String r17 = r7.q;
            if (r17 != null) goto L51;
            r5.bindNull(17);
        L52:
            String r18 = r7.r;
            if (r18 != null) goto L55;
            r5.bindNull(18);
        L56:
            r5.bindLong(19, r7.s ? 1 : 0);
            r5.bindLong(20, r7.t);
            String r19 = r7.u;
            if (r19 != null) goto L59;
            r5.bindNull(21);
        L60:
            String r20 = r7.v;
            if (r20 != null) goto L63;
            r5.bindNull(22);
        L64:
            r5.bindLong(23, r7.w);
            String r21 = r7.x;
            if (r21 != null) goto L67;
            r5.bindNull(24);
        L68:
            r5.bindLong(25, r7.y);
            return;
        L67:
            r5.bindString(24, r21);
            goto L68
        L63:
            r5.bindString(22, r20);
            goto L64
        L59:
            r5.bindString(21, r19);
            goto L60
        L55:
            r5.bindString(18, r18);
            goto L56
        L51:
            r5.bindString(17, r17);
            goto L52
        L47:
            r5.bindString(16, r16);
            goto L48
        L43:
            r5.bindString(15, r14);
            goto L44
        L29:
            r5.bindString(7, r9);
            goto L30
        L25:
            r5.bindString(6, r8);
            goto L26
        L21:
            r5.bindString(5, r4);
            goto L22
        L17:
            r5.bindString(4, r3);
            goto L18
        L13:
            r5.bindString(3, r2);
            goto L14
        L9:
            r5.bindString(2, r1);
            goto L10
        L5:
            r5.bindString(1, r0);
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.dao.b$b, reason: collision with other inner class name */
    public class C0162b extends EntityDeletionOrUpdateAdapter<y75.a> {
        public final String createQuery() {
            return "UPDATE OR ABORT `t_drive_cache` SET `cache_key` = ?,`obj_token` = ?,`src_ext` = ?,`preview_ext` = ?,`data_version` = ?,`source_from` = ?,`cache_source_from` = ?,`file_path` = ?,`partial_file_path` = ?,`temp_file_path` = ?,`file_size` = ?,`type` = ?,`last_access_time` = ?,`modification_time` = ?,`file_name` = ?,`cache_uid` = ?,`cache_tenant_id` = ?,`preview_extra` = ?,`is_use_partial_file` = ?,`cache_host` = ?,`sdk_app_id` = ?,`sdk_extra` = ?,`flags` = ?,`mime_type` = ?,`risk_status` = ? WHERE `cache_key` = ?";
        }

        public C0162b(RoomDatabase r1) {
            super(r1);
        }

        public final void bind(SupportSQLiteStatement r5, Object r6) {
            y75.a r7 = (y75.a) r6;
            String r0 = r7.a;
            if (r0 != null) goto L5;
            r5.bindNull(1);
        L6:
            String r1 = r7.b;
            if (r1 != null) goto L9;
            r5.bindNull(2);
        L10:
            String r2 = r7.c;
            if (r2 != null) goto L13;
            r5.bindNull(3);
        L14:
            String r3 = r7.d;
            if (r3 != null) goto L17;
            r5.bindNull(4);
        L18:
            String r4 = r7.e;
            if (r4 != null) goto L21;
            r5.bindNull(5);
        L22:
            String r8 = r7.f;
            if (r8 != null) goto L25;
            r5.bindNull(6);
        L26:
            String r9 = r7.g;
            if (r9 != null) goto L29;
            r5.bindNull(7);
        L30:
            String r10 = r7.h;
            String r11 = "";
            if (r10 != null) goto L33;
            r10 = "";
        L33:
            r5.bindString(8, r10);
            String r12 = r7.i;
            if (r12 != null) goto L36;
            r12 = "";
        L36:
            r5.bindString(9, r12);
            String r13 = r7.j;
            if (r13 == null) goto L40;
            r11 = r13;
        L40:
            r5.bindString(10, r11);
            r5.bindLong(11, r7.k);
            r5.bindLong(12, r7.getType());
            r5.bindLong(13, r7.m);
            r5.bindLong(14, r7.n);
            String r14 = r7.o;
            if (r14 != null) goto L43;
            r5.bindNull(15);
        L44:
            String r16 = r7.p;
            if (r16 != null) goto L47;
            r5.bindNull(16);
        L48:
            String r17 = r7.q;
            if (r17 != null) goto L51;
            r5.bindNull(17);
        L52:
            String r18 = r7.r;
            if (r18 != null) goto L55;
            r5.bindNull(18);
        L56:
            r5.bindLong(19, r7.s ? 1 : 0);
            r5.bindLong(20, r7.t);
            String r19 = r7.u;
            if (r19 != null) goto L59;
            r5.bindNull(21);
        L60:
            String r20 = r7.v;
            if (r20 != null) goto L63;
            r5.bindNull(22);
        L64:
            r5.bindLong(23, r7.w);
            String r21 = r7.x;
            if (r21 != null) goto L67;
            r5.bindNull(24);
        L68:
            r5.bindLong(25, r7.y);
            String r22 = r7.a;
            if (r22 != null) goto L71;
            r5.bindNull(26);
            return;
        L71:
            r5.bindString(26, r22);
            return;
        L67:
            r5.bindString(24, r21);
            goto L68
        L63:
            r5.bindString(22, r20);
            goto L64
        L59:
            r5.bindString(21, r19);
            goto L60
        L55:
            r5.bindString(18, r18);
            goto L56
        L51:
            r5.bindString(17, r17);
            goto L52
        L47:
            r5.bindString(16, r16);
            goto L48
        L43:
            r5.bindString(15, r14);
            goto L44
        L29:
            r5.bindString(7, r9);
            goto L30
        L25:
            r5.bindString(6, r8);
            goto L26
        L21:
            r5.bindString(5, r4);
            goto L22
        L17:
            r5.bindString(4, r3);
            goto L18
        L13:
            r5.bindString(3, r2);
            goto L14
        L9:
            r5.bindString(2, r1);
            goto L10
        L5:
            r5.bindString(1, r0);
            goto L6
        }
    }

    public class c extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE t_drive_cache set last_access_time = ? WHERE cache_key = ?";
        }

        public c(RoomDatabase r1) {
            super(r1);
        }
    }

    public class d extends SharedSQLiteStatement {
        public final String createQuery() {
            return "DELETE FROM t_drive_cache WHERE cache_key = ?";
        }

        public d(RoomDatabase r1) {
            super(r1);
        }
    }

    public class e extends SharedSQLiteStatement {
        public final String createQuery() {
            return "DELETE FROM t_drive_cache WHERE obj_token = ?";
        }

        public e(RoomDatabase r1) {
            super(r1);
        }
    }

    public class f extends SharedSQLiteStatement {
        public final String createQuery() {
            return "DELETE FROM t_drive_cache";
        }

        public f(RoomDatabase r1) {
            super(r1);
        }
    }

    public class g extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE t_drive_cache SET type = ?, file_path = ?  WHERE cache_key = ?";
        }

        public g(RoomDatabase r1) {
            super(r1);
        }
    }

    public class h extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE t_drive_cache SET cache_source_from= ?, file_path= ? WHERE cache_key= ?";
        }

        public h(RoomDatabase r1) {
            super(r1);
        }
    }

    public class i extends SharedSQLiteStatement {
        public final String createQuery() {
            return "UPDATE t_drive_cache SET file_name = ? WHERE cache_key = ?";
        }

        public i(RoomDatabase r1) {
            super(r1);
        }
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List a0() {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE type = ? ORDER BY last_access_time ASC LIMIT ?", 2);
        r3.bindLong(1, 0);
        r3.bindLong(2, 16);
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r3, false, null);
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "cache_key");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "obj_token");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "src_ext");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "preview_ext");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "data_version");     // Catch: Throwable -> L18
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "source_from");     // Catch: Throwable -> L18
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "cache_source_from");     // Catch: Throwable -> L18
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "file_path");     // Catch: Throwable -> L18
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "partial_file_path");     // Catch: Throwable -> L18
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "temp_file_path");     // Catch: Throwable -> L18
        int r16 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L18
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "last_access_time");     // Catch: Throwable -> L18
        int r1 = CursorUtil.getColumnIndexOrThrow(r2, "modification_time");     // Catch: Throwable -> L18
        RoomSQLiteQuery r17 = r3;
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L16
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "cache_uid");     // Catch: Throwable -> L16
        int r110 = CursorUtil.getColumnIndexOrThrow(r2, "cache_tenant_id");     // Catch: Throwable -> L16
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "preview_extra");     // Catch: Throwable -> L16
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "is_use_partial_file");     // Catch: Throwable -> L16
        int r22 = CursorUtil.getColumnIndexOrThrow(r2, "cache_host");     // Catch: Throwable -> L16
        int r23 = CursorUtil.getColumnIndexOrThrow(r2, "sdk_app_id");     // Catch: Throwable -> L16
        int r24 = CursorUtil.getColumnIndexOrThrow(r2, "sdk_extra");     // Catch: Throwable -> L16
        int r26 = CursorUtil.getColumnIndexOrThrow(r2, "flags");     // Catch: Throwable -> L16
        int r27 = CursorUtil.getColumnIndexOrThrow(r2, "mime_type");     // Catch: Throwable -> L16
        int r28 = CursorUtil.getColumnIndexOrThrow(r2, "risk_status");     // Catch: Throwable -> L16
        int r29 = r1;
        ArrayList r30 = new ArrayList(r2.getCount());     // Catch: Throwable -> L16
    L7:
        if (r2.moveToNext() == false) goto L14;
        y75.a r31 = new y75.a();     // Catch: Throwable -> L16
        ArrayList r210 = r30;
        r31.a = r2.getString(r4);     // Catch: Throwable -> L16
        r31.b = r2.getString(r5);     // Catch: Throwable -> L16
        r31.c = r2.getString(r7);     // Catch: Throwable -> L16
        r31.d = r2.getString(r8);     // Catch: Throwable -> L16
        r31.e = r2.getString(r9);     // Catch: Throwable -> L16
        r31.f = r2.getString(r10);     // Catch: Throwable -> L16
        r31.g = r2.getString(r11);     // Catch: Throwable -> L16
        r31.h = r2.getString(r12);     // Catch: Throwable -> L16
        r31.i = r2.getString(r13);     // Catch: Throwable -> L16
        r31.j = r2.getString(r14);     // Catch: Throwable -> L16
        int r32 = r4;
        r31.k = r2.getLong(r16);     // Catch: Throwable -> L16
        r31.l = r2.getInt(r0);     // Catch: Throwable -> L16
        r31.m = r2.getLong(r6);     // Catch: Throwable -> L16
        int r33 = r29;
        int r211 = r5;
        r31.n = r2.getLong(r33);     // Catch: Throwable -> L16
        int r34 = r18;
        r31.o = r2.getString(r34);     // Catch: Throwable -> L16
        int r111 = r0;
        int r36 = r19;
        r31.p = r2.getString(r36);     // Catch: Throwable -> L16
        int r37 = r110;
        r31.q = r2.getString(r37);     // Catch: Throwable -> L16
        r110 = r37;
        int r38 = r20;
        r31.r = r2.getString(r38);     // Catch: Throwable -> L16
        int r39 = r21;
        r21 = r39;
        if (r2.getInt(r39) == 0) goto L11;
        boolean r40 = true;
    L12:
        r31.s = r40;     // Catch: Throwable -> L16
        r20 = r38;
        int r41 = r22;
        r31.t = r2.getInt(r41);     // Catch: Throwable -> L16
        r22 = r41;
        int r42 = r23;
        r31.u = r2.getString(r42);     // Catch: Throwable -> L16
        r23 = r42;
        int r43 = r24;
        r31.v = r2.getString(r43);     // Catch: Throwable -> L16
        r24 = r43;
        int r44 = r26;
        r31.w = r2.getInt(r44);     // Catch: Throwable -> L16
        r26 = r44;
        int r46 = r27;
        r31.x = r2.getString(r46);     // Catch: Throwable -> L16
        r27 = r46;
        int r47 = r28;
        r31.y = r2.getInt(r47);     // Catch: Throwable -> L16
        r210.add(r31);     // Catch: Throwable -> L16
        r28 = r47;
        r30 = r210;
        r0 = r111;
        r18 = r34;
        r4 = r32;
        r19 = r36;
        r5 = r211;
        r29 = r33;
        goto L7
    L11:
        r40 = false;
        goto L12
    L14:
        ArrayList r48 = r30;
        r2.close();
        r17.release();
        return r48;
    L16:
        th = th;
    L20:
        r2.close();
        r17.release();
        throw th;
    L18:
        th = th;
        r17 = r3;
        goto L20
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final long b0() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT SUM(file_size) FROM t_drive_cache WHERE type = ?", 1);
        r0.bindLong(1, 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.a, r0, false, null);
    L10:
        th = move-exception;
        r1.close();
        r0.release();
        throw th;
    L4:
        if (r1.moveToFirst() == false) goto L7;
        long r2 = r1.getLong(0);     // Catch: Throwable -> L10
    L8:
        r1.close();
        r0.release();
        return r2;
    L7:
        r2 = 0;
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int deleteAll() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.g.acquire();
        this.a.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.g.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.g.release(r0);
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List<y75.a> g0() {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache ORDER BY last_access_time DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.a, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, "cache_key");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "obj_token");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "src_ext");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "preview_ext");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "data_version");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "source_from");     // Catch: Throwable -> L18
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "cache_source_from");     // Catch: Throwable -> L18
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "file_path");     // Catch: Throwable -> L18
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "partial_file_path");     // Catch: Throwable -> L18
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "temp_file_path");     // Catch: Throwable -> L18
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "file_size");     // Catch: Throwable -> L18
        int r16 = CursorUtil.getColumnIndexOrThrow(r4, "type");     // Catch: Throwable -> L18
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "last_access_time");     // Catch: Throwable -> L18
        int r1 = CursorUtil.getColumnIndexOrThrow(r4, "modification_time");     // Catch: Throwable -> L18
        RoomSQLiteQuery r17 = r3;
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "file_name");     // Catch: Throwable -> L16
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "cache_uid");     // Catch: Throwable -> L16
        int r110 = CursorUtil.getColumnIndexOrThrow(r4, "cache_tenant_id");     // Catch: Throwable -> L16
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "preview_extra");     // Catch: Throwable -> L16
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "is_use_partial_file");     // Catch: Throwable -> L16
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "cache_host");     // Catch: Throwable -> L16
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "sdk_app_id");     // Catch: Throwable -> L16
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "sdk_extra");     // Catch: Throwable -> L16
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, "flags");     // Catch: Throwable -> L16
        int r27 = CursorUtil.getColumnIndexOrThrow(r4, "mime_type");     // Catch: Throwable -> L16
        int r28 = CursorUtil.getColumnIndexOrThrow(r4, "risk_status");     // Catch: Throwable -> L16
        int r29 = r1;
        ArrayList r30 = new ArrayList(r4.getCount());     // Catch: Throwable -> L16
    L7:
        if (r4.moveToNext() == false) goto L14;
        y75.a r31 = new y75.a();     // Catch: Throwable -> L16
        ArrayList r210 = r30;
        r31.a = r4.getString(r0);     // Catch: Throwable -> L16
        r31.b = r4.getString(r5);     // Catch: Throwable -> L16
        r31.c = r4.getString(r6);     // Catch: Throwable -> L16
        r31.d = r4.getString(r7);     // Catch: Throwable -> L16
        r31.e = r4.getString(r8);     // Catch: Throwable -> L16
        r31.f = r4.getString(r9);     // Catch: Throwable -> L16
        r31.g = r4.getString(r10);     // Catch: Throwable -> L16
        r31.h = r4.getString(r11);     // Catch: Throwable -> L16
        r31.i = r4.getString(r12);     // Catch: Throwable -> L16
        r31.j = r4.getString(r13);     // Catch: Throwable -> L16
        int r32 = r5;
        int r33 = r6;
        r31.k = r4.getLong(r14);     // Catch: Throwable -> L16
        r31.l = r4.getInt(r16);     // Catch: Throwable -> L16
        r31.m = r4.getLong(r2);     // Catch: Throwable -> L16
        int r34 = r2;
        int r36 = r29;
        r31.n = r4.getLong(r36);     // Catch: Throwable -> L16
        int r37 = r18;
        r31.o = r4.getString(r37);     // Catch: Throwable -> L16
        int r111 = r0;
        int r38 = r19;
        r31.p = r4.getString(r38);     // Catch: Throwable -> L16
        int r39 = r110;
        r31.q = r4.getString(r39);     // Catch: Throwable -> L16
        r110 = r39;
        int r40 = r20;
        r31.r = r4.getString(r40);     // Catch: Throwable -> L16
        r21 = r21;
        if (r4.getInt(r21) == 0) goto L11;
        boolean r41 = true;
    L12:
        r31.s = r41;     // Catch: Throwable -> L16
        r20 = r40;
        int r42 = r22;
        r31.t = r4.getInt(r42);     // Catch: Throwable -> L16
        r22 = r42;
        int r43 = r23;
        r31.u = r4.getString(r43);     // Catch: Throwable -> L16
        r23 = r43;
        int r44 = r24;
        r31.v = r4.getString(r44);     // Catch: Throwable -> L16
        r24 = r44;
        int r46 = r26;
        r31.w = r4.getInt(r46);     // Catch: Throwable -> L16
        r26 = r46;
        int r47 = r27;
        r31.x = r4.getString(r47);     // Catch: Throwable -> L16
        r27 = r47;
        int r48 = r28;
        r31.y = r4.getInt(r48);     // Catch: Throwable -> L16
        r210.add(r31);     // Catch: Throwable -> L16
        r28 = r48;
        r2 = r34;
        r6 = r33;
        r30 = r210;
        r0 = r111;
        r18 = r37;
        r19 = r38;
        r29 = r36;
        r5 = r32;
        goto L7
    L11:
        r41 = false;
        goto L12
    L14:
        ArrayList r49 = r30;
        r4.close();
        r17.release();
        return r49;
    L16:
        th = th;
    L20:
        r4.close();
        r17.release();
        throw th;
    L18:
        th = th;
        r17 = r3;
        goto L20
    }

    public b(RoomDatabase r2) {
        this.a = r2;
        this.b = new a(r2);
        this.c = new C0162b(r2);
        this.d = new c(r2);
        this.e = new d(r2);
        this.f = new e(r2);
        this.g = new f(r2);
        this.h = new g(r2);
        this.i = new h(r2);
        this.j = new i(r2);
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int S(String r3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.f.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.f.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.f.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List U(long r30) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE type = ? AND last_access_time <= ?", 2);
        r3.bindLong(1, 0);
        r3.bindLong(2, r30);
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r3, false, null);
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "cache_key");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "obj_token");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "src_ext");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "preview_ext");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "data_version");     // Catch: Throwable -> L18
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "source_from");     // Catch: Throwable -> L18
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "cache_source_from");     // Catch: Throwable -> L18
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "file_path");     // Catch: Throwable -> L18
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "partial_file_path");     // Catch: Throwable -> L18
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "temp_file_path");     // Catch: Throwable -> L18
        int r16 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L18
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "last_access_time");     // Catch: Throwable -> L18
        int r1 = CursorUtil.getColumnIndexOrThrow(r2, "modification_time");     // Catch: Throwable -> L18
        RoomSQLiteQuery r17 = r3;
        int r31 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L16
        int r32 = CursorUtil.getColumnIndexOrThrow(r2, "cache_uid");     // Catch: Throwable -> L16
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "cache_tenant_id");     // Catch: Throwable -> L16
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "preview_extra");     // Catch: Throwable -> L16
        int r110 = CursorUtil.getColumnIndexOrThrow(r2, "is_use_partial_file");     // Catch: Throwable -> L16
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "cache_host");     // Catch: Throwable -> L16
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "sdk_app_id");     // Catch: Throwable -> L16
        int r22 = CursorUtil.getColumnIndexOrThrow(r2, "sdk_extra");     // Catch: Throwable -> L16
        int r23 = CursorUtil.getColumnIndexOrThrow(r2, "flags");     // Catch: Throwable -> L16
        int r24 = CursorUtil.getColumnIndexOrThrow(r2, "mime_type");     // Catch: Throwable -> L16
        int r26 = CursorUtil.getColumnIndexOrThrow(r2, "risk_status");     // Catch: Throwable -> L16
        int r27 = r1;
        ArrayList r28 = new ArrayList(r2.getCount());     // Catch: Throwable -> L16
    L7:
        if (r2.moveToNext() == false) goto L14;
        y75.a r29 = new y75.a();     // Catch: Throwable -> L16
        ArrayList r210 = r28;
        r29.a = r2.getString(r4);     // Catch: Throwable -> L16
        r29.b = r2.getString(r5);     // Catch: Throwable -> L16
        r29.c = r2.getString(r7);     // Catch: Throwable -> L16
        r29.d = r2.getString(r8);     // Catch: Throwable -> L16
        r29.e = r2.getString(r9);     // Catch: Throwable -> L16
        r29.f = r2.getString(r10);     // Catch: Throwable -> L16
        r29.g = r2.getString(r11);     // Catch: Throwable -> L16
        r29.h = r2.getString(r12);     // Catch: Throwable -> L16
        r29.i = r2.getString(r13);     // Catch: Throwable -> L16
        r29.j = r2.getString(r14);     // Catch: Throwable -> L16
        int r211 = r4;
        r29.k = r2.getLong(r16);     // Catch: Throwable -> L16
        r29.l = r2.getInt(r0);     // Catch: Throwable -> L16
        r29.m = r2.getLong(r6);     // Catch: Throwable -> L16
        int r33 = r27;
        int r212 = r5;
        r29.n = r2.getLong(r33);     // Catch: Throwable -> L16
        int r34 = r31;
        r29.o = r2.getString(r34);     // Catch: Throwable -> L16
        int r36 = r32;
        int r37 = r0;
        r29.p = r2.getString(r36);     // Catch: Throwable -> L16
        int r38 = r18;
        r29.q = r2.getString(r38);     // Catch: Throwable -> L16
        int r39 = r19;
        r29.r = r2.getString(r39);     // Catch: Throwable -> L16
        r110 = r110;
        if (r2.getInt(r110) == 0) goto L11;
        boolean r40 = true;
    L12:
        r29.s = r40;     // Catch: Throwable -> L16
        int r41 = r20;
        r29.t = r2.getInt(r41);     // Catch: Throwable -> L16
        int r42 = r21;
        r29.u = r2.getString(r42);     // Catch: Throwable -> L16
        int r43 = r22;
        r29.v = r2.getString(r43);     // Catch: Throwable -> L16
        int r44 = r23;
        r29.w = r2.getInt(r44);     // Catch: Throwable -> L16
        int r46 = r24;
        r29.x = r2.getString(r46);     // Catch: Throwable -> L16
        int r47 = r26;
        r29.y = r2.getInt(r47);     // Catch: Throwable -> L16
        r210.add(r29);     // Catch: Throwable -> L16
        r32 = r36;
        r5 = r212;
        r27 = r33;
        r18 = r38;
        r19 = r39;
        r20 = r41;
        r21 = r42;
        r22 = r43;
        r23 = r44;
        r24 = r46;
        r26 = r47;
        r28 = r210;
        r0 = r37;
        r31 = r34;
        r4 = r211;
        goto L7
    L11:
        r40 = false;
        goto L12
    L14:
        ArrayList r48 = r28;
        r2.close();
        r17.release();
        return r48;
    L16:
        th = th;
    L20:
        r2.close();
        r17.release();
        throw th;
    L18:
        th = th;
        r17 = r3;
        goto L20
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List W(int r32) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE type = ? AND cache_host = ? ORDER BY last_access_time DESC", 2);
        r3.bindLong(1, 0);
        r3.bindLong(2, r32);
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r3, false, null);
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "cache_key");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "obj_token");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "src_ext");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "preview_ext");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "data_version");     // Catch: Throwable -> L18
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "source_from");     // Catch: Throwable -> L18
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "cache_source_from");     // Catch: Throwable -> L18
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "file_path");     // Catch: Throwable -> L18
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "partial_file_path");     // Catch: Throwable -> L18
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "temp_file_path");     // Catch: Throwable -> L18
        int r16 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L18
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "last_access_time");     // Catch: Throwable -> L18
        int r1 = CursorUtil.getColumnIndexOrThrow(r2, "modification_time");     // Catch: Throwable -> L18
        RoomSQLiteQuery r17 = r3;
        int r33 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L16
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "cache_uid");     // Catch: Throwable -> L16
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "cache_tenant_id");     // Catch: Throwable -> L16
        int r110 = CursorUtil.getColumnIndexOrThrow(r2, "preview_extra");     // Catch: Throwable -> L16
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "is_use_partial_file");     // Catch: Throwable -> L16
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "cache_host");     // Catch: Throwable -> L16
        int r22 = CursorUtil.getColumnIndexOrThrow(r2, "sdk_app_id");     // Catch: Throwable -> L16
        int r23 = CursorUtil.getColumnIndexOrThrow(r2, "sdk_extra");     // Catch: Throwable -> L16
        int r24 = CursorUtil.getColumnIndexOrThrow(r2, "flags");     // Catch: Throwable -> L16
        int r26 = CursorUtil.getColumnIndexOrThrow(r2, "mime_type");     // Catch: Throwable -> L16
        int r27 = CursorUtil.getColumnIndexOrThrow(r2, "risk_status");     // Catch: Throwable -> L16
        int r28 = r1;
        ArrayList r29 = new ArrayList(r2.getCount());     // Catch: Throwable -> L16
    L7:
        if (r2.moveToNext() == false) goto L14;
        y75.a r30 = new y75.a();     // Catch: Throwable -> L16
        ArrayList r210 = r29;
        r30.a = r2.getString(r4);     // Catch: Throwable -> L16
        r30.b = r2.getString(r5);     // Catch: Throwable -> L16
        r30.c = r2.getString(r7);     // Catch: Throwable -> L16
        r30.d = r2.getString(r8);     // Catch: Throwable -> L16
        r30.e = r2.getString(r9);     // Catch: Throwable -> L16
        r30.f = r2.getString(r10);     // Catch: Throwable -> L16
        r30.g = r2.getString(r11);     // Catch: Throwable -> L16
        r30.h = r2.getString(r12);     // Catch: Throwable -> L16
        r30.i = r2.getString(r13);     // Catch: Throwable -> L16
        r30.j = r2.getString(r14);     // Catch: Throwable -> L16
        int r211 = r4;
        r30.k = r2.getLong(r16);     // Catch: Throwable -> L16
        r30.l = r2.getInt(r0);     // Catch: Throwable -> L16
        r30.m = r2.getLong(r6);     // Catch: Throwable -> L16
        int r31 = r28;
        int r212 = r5;
        r30.n = r2.getLong(r31);     // Catch: Throwable -> L16
        int r34 = r33;
        r30.o = r2.getString(r34);     // Catch: Throwable -> L16
        int r36 = r0;
        int r37 = r18;
        r30.p = r2.getString(r37);     // Catch: Throwable -> L16
        int r38 = r19;
        r30.q = r2.getString(r38);     // Catch: Throwable -> L16
        r19 = r38;
        int r39 = r110;
        r30.r = r2.getString(r39);     // Catch: Throwable -> L16
        int r40 = r20;
        r20 = r40;
        if (r2.getInt(r40) == 0) goto L11;
        boolean r41 = true;
    L12:
        r30.s = r41;     // Catch: Throwable -> L16
        r110 = r39;
        int r42 = r21;
        r30.t = r2.getInt(r42);     // Catch: Throwable -> L16
        r21 = r42;
        int r43 = r22;
        r30.u = r2.getString(r43);     // Catch: Throwable -> L16
        r22 = r43;
        int r44 = r23;
        r30.v = r2.getString(r44);     // Catch: Throwable -> L16
        r23 = r44;
        int r46 = r24;
        r30.w = r2.getInt(r46);     // Catch: Throwable -> L16
        r24 = r46;
        int r47 = r26;
        r30.x = r2.getString(r47);     // Catch: Throwable -> L16
        r26 = r47;
        int r48 = r27;
        r30.y = r2.getInt(r48);     // Catch: Throwable -> L16
        r210.add(r30);     // Catch: Throwable -> L16
        r27 = r48;
        r29 = r210;
        r0 = r36;
        r33 = r34;
        r4 = r211;
        r18 = r37;
        r5 = r212;
        r28 = r31;
        goto L7
    L11:
        r41 = false;
        goto L12
    L14:
        ArrayList r49 = r29;
        r2.close();
        r17.release();
        return r49;
    L16:
        th = th;
    L20:
        r2.close();
        r17.release();
        throw th;
    L18:
        th = th;
        r17 = r3;
        goto L20
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final long X(y75.a r3) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        long r0 = this.b.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List<y75.a> Y(String r33) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE obj_token = ?", 1);
        if (r33 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.a, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, "cache_key");     // Catch: Throwable -> L22
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "obj_token");     // Catch: Throwable -> L22
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "src_ext");     // Catch: Throwable -> L22
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "preview_ext");     // Catch: Throwable -> L22
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "data_version");     // Catch: Throwable -> L22
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "source_from");     // Catch: Throwable -> L22
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "cache_source_from");     // Catch: Throwable -> L22
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "file_path");     // Catch: Throwable -> L22
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "partial_file_path");     // Catch: Throwable -> L22
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "temp_file_path");     // Catch: Throwable -> L22
        int r16 = CursorUtil.getColumnIndexOrThrow(r4, "file_size");     // Catch: Throwable -> L22
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "type");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "last_access_time");     // Catch: Throwable -> L22
        int r1 = CursorUtil.getColumnIndexOrThrow(r4, "modification_time");     // Catch: Throwable -> L22
        RoomSQLiteQuery r17 = r2;
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "file_name");     // Catch: Throwable -> L20
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "cache_uid");     // Catch: Throwable -> L20
        int r110 = CursorUtil.getColumnIndexOrThrow(r4, "cache_tenant_id");     // Catch: Throwable -> L20
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "preview_extra");     // Catch: Throwable -> L20
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "is_use_partial_file");     // Catch: Throwable -> L20
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "cache_host");     // Catch: Throwable -> L20
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "sdk_app_id");     // Catch: Throwable -> L20
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "sdk_extra");     // Catch: Throwable -> L20
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, "flags");     // Catch: Throwable -> L20
        int r27 = CursorUtil.getColumnIndexOrThrow(r4, "mime_type");     // Catch: Throwable -> L20
        int r28 = CursorUtil.getColumnIndexOrThrow(r4, "risk_status");     // Catch: Throwable -> L20
        int r29 = r1;
        ArrayList r30 = new ArrayList(r4.getCount());     // Catch: Throwable -> L20
    L11:
        if (r4.moveToNext() == false) goto L18;
        y75.a r31 = new y75.a();     // Catch: Throwable -> L20
        ArrayList r210 = r30;
        r31.a = r4.getString(r0);     // Catch: Throwable -> L20
        r31.b = r4.getString(r6);     // Catch: Throwable -> L20
        r31.c = r4.getString(r7);     // Catch: Throwable -> L20
        r31.d = r4.getString(r8);     // Catch: Throwable -> L20
        r31.e = r4.getString(r9);     // Catch: Throwable -> L20
        r31.f = r4.getString(r10);     // Catch: Throwable -> L20
        r31.g = r4.getString(r11);     // Catch: Throwable -> L20
        r31.h = r4.getString(r12);     // Catch: Throwable -> L20
        r31.i = r4.getString(r13);     // Catch: Throwable -> L20
        r31.j = r4.getString(r14);     // Catch: Throwable -> L20
        int r32 = r6;
        int r34 = r7;
        r31.k = r4.getLong(r16);     // Catch: Throwable -> L20
        r31.l = r4.getInt(r3);     // Catch: Throwable -> L20
        r31.m = r4.getLong(r5);     // Catch: Throwable -> L20
        int r36 = r3;
        int r37 = r29;
        r31.n = r4.getLong(r37);     // Catch: Throwable -> L20
        int r38 = r18;
        r31.o = r4.getString(r38);     // Catch: Throwable -> L20
        int r111 = r0;
        int r39 = r19;
        r31.p = r4.getString(r39);     // Catch: Throwable -> L20
        int r40 = r110;
        r31.q = r4.getString(r40);     // Catch: Throwable -> L20
        r110 = r40;
        int r41 = r20;
        r31.r = r4.getString(r41);     // Catch: Throwable -> L20
        int r42 = r21;
        r21 = r42;
        if (r4.getInt(r42) == 0) goto L15;
        boolean r43 = true;
    L16:
        r31.s = r43;     // Catch: Throwable -> L20
        r20 = r41;
        int r44 = r22;
        r31.t = r4.getInt(r44);     // Catch: Throwable -> L20
        r22 = r44;
        int r46 = r23;
        r31.u = r4.getString(r46);     // Catch: Throwable -> L20
        r23 = r46;
        int r47 = r24;
        r31.v = r4.getString(r47);     // Catch: Throwable -> L20
        r24 = r47;
        int r48 = r26;
        r31.w = r4.getInt(r48);     // Catch: Throwable -> L20
        r26 = r48;
        int r49 = r27;
        r31.x = r4.getString(r49);     // Catch: Throwable -> L20
        r27 = r49;
        int r50 = r28;
        r31.y = r4.getInt(r50);     // Catch: Throwable -> L20
        r210.add(r31);     // Catch: Throwable -> L20
        r28 = r50;
        r30 = r210;
        r0 = r111;
        r18 = r38;
        r19 = r39;
        r3 = r36;
        r7 = r34;
        r29 = r37;
        r6 = r32;
        goto L11
    L15:
        r43 = false;
        goto L16
    L18:
        ArrayList r51 = r30;
        r4.close();
        r17.release();
        return r51;
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
        r2.bindString(1, r33);
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List<y75.a> c0(int r34) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE type = ? ORDER BY last_access_time DESC", 1);
        r3.bindLong(1, r34);
        this.a.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.a, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "cache_key");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "obj_token");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "src_ext");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "preview_ext");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "data_version");     // Catch: Throwable -> L18
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "source_from");     // Catch: Throwable -> L18
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "cache_source_from");     // Catch: Throwable -> L18
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "file_path");     // Catch: Throwable -> L18
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "partial_file_path");     // Catch: Throwable -> L18
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "temp_file_path");     // Catch: Throwable -> L18
        int r16 = CursorUtil.getColumnIndexOrThrow(r5, "file_size");     // Catch: Throwable -> L18
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L18
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "last_access_time");     // Catch: Throwable -> L18
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "modification_time");     // Catch: Throwable -> L18
        RoomSQLiteQuery r17 = r3;
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "file_name");     // Catch: Throwable -> L16
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "cache_uid");     // Catch: Throwable -> L16
        int r110 = CursorUtil.getColumnIndexOrThrow(r5, "cache_tenant_id");     // Catch: Throwable -> L16
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "preview_extra");     // Catch: Throwable -> L16
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "is_use_partial_file");     // Catch: Throwable -> L16
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "cache_host");     // Catch: Throwable -> L16
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "sdk_app_id");     // Catch: Throwable -> L16
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "sdk_extra");     // Catch: Throwable -> L16
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "flags");     // Catch: Throwable -> L16
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "mime_type");     // Catch: Throwable -> L16
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "risk_status");     // Catch: Throwable -> L16
        int r29 = r1;
        ArrayList r30 = new ArrayList(r5.getCount());     // Catch: Throwable -> L16
    L7:
        if (r5.moveToNext() == false) goto L14;
        y75.a r31 = new y75.a();     // Catch: Throwable -> L16
        ArrayList r210 = r30;
        r31.a = r5.getString(r0);     // Catch: Throwable -> L16
        r31.b = r5.getString(r6);     // Catch: Throwable -> L16
        r31.c = r5.getString(r7);     // Catch: Throwable -> L16
        r31.d = r5.getString(r8);     // Catch: Throwable -> L16
        r31.e = r5.getString(r9);     // Catch: Throwable -> L16
        r31.f = r5.getString(r10);     // Catch: Throwable -> L16
        r31.g = r5.getString(r11);     // Catch: Throwable -> L16
        r31.h = r5.getString(r12);     // Catch: Throwable -> L16
        r31.i = r5.getString(r13);     // Catch: Throwable -> L16
        r31.j = r5.getString(r14);     // Catch: Throwable -> L16
        int r32 = r6;
        int r33 = r7;
        r31.k = r5.getLong(r16);     // Catch: Throwable -> L16
        r31.l = r5.getInt(r2);     // Catch: Throwable -> L16
        r31.m = r5.getLong(r4);     // Catch: Throwable -> L16
        int r36 = r2;
        int r37 = r29;
        r31.n = r5.getLong(r37);     // Catch: Throwable -> L16
        int r38 = r18;
        r31.o = r5.getString(r38);     // Catch: Throwable -> L16
        int r111 = r0;
        int r39 = r19;
        r31.p = r5.getString(r39);     // Catch: Throwable -> L16
        int r40 = r110;
        r31.q = r5.getString(r40);     // Catch: Throwable -> L16
        r110 = r40;
        int r41 = r20;
        r31.r = r5.getString(r41);     // Catch: Throwable -> L16
        int r42 = r21;
        r21 = r42;
        if (r5.getInt(r42) == 0) goto L11;
        boolean r43 = true;
    L12:
        r31.s = r43;     // Catch: Throwable -> L16
        r20 = r41;
        int r44 = r22;
        r31.t = r5.getInt(r44);     // Catch: Throwable -> L16
        r22 = r44;
        int r46 = r23;
        r31.u = r5.getString(r46);     // Catch: Throwable -> L16
        r23 = r46;
        int r47 = r24;
        r31.v = r5.getString(r47);     // Catch: Throwable -> L16
        r24 = r47;
        int r48 = r26;
        r31.w = r5.getInt(r48);     // Catch: Throwable -> L16
        r26 = r48;
        int r49 = r27;
        r31.x = r5.getString(r49);     // Catch: Throwable -> L16
        r27 = r49;
        int r50 = r28;
        r31.y = r5.getInt(r50);     // Catch: Throwable -> L16
        r210.add(r31);     // Catch: Throwable -> L16
        r28 = r50;
        r2 = r36;
        r7 = r33;
        r30 = r210;
        r0 = r111;
        r18 = r38;
        r19 = r39;
        r29 = r37;
        r6 = r32;
        goto L7
    L11:
        r43 = false;
        goto L12
    L14:
        ArrayList r51 = r30;
        r5.close();
        r17.release();
        return r51;
    L16:
        th = th;
    L20:
        r5.close();
        r17.release();
        throw th;
    L18:
        th = th;
        r17 = r3;
        goto L20
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List<y75.a> d0(List<String> r33) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT ");
        r0.append("*");
        r0.append(" FROM t_drive_cache WHERE cache_key in (");
        int r2 = r33.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator<String> r1 = r33.iterator();
        int r5 = 1;
    L4:
        if (r1.hasNext() == false) goto L10;
        String r6 = r1.next();
        if (r6 != null) goto L8;
        r3.bindNull(r5);
    L9:
        r5 = r5 + 1;
        goto L4
    L8:
        r3.bindString(r5, r6);
        goto L9
    L10:
        this.a.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.a, r3, false, null);
        int r4 = CursorUtil.getColumnIndexOrThrow(r7, "cache_key");     // Catch: Throwable -> L26
        int r8 = CursorUtil.getColumnIndexOrThrow(r7, "obj_token");     // Catch: Throwable -> L26
        int r9 = CursorUtil.getColumnIndexOrThrow(r7, "src_ext");     // Catch: Throwable -> L26
        int r10 = CursorUtil.getColumnIndexOrThrow(r7, "preview_ext");     // Catch: Throwable -> L26
        int r11 = CursorUtil.getColumnIndexOrThrow(r7, "data_version");     // Catch: Throwable -> L26
        int r12 = CursorUtil.getColumnIndexOrThrow(r7, "source_from");     // Catch: Throwable -> L26
        int r13 = CursorUtil.getColumnIndexOrThrow(r7, "cache_source_from");     // Catch: Throwable -> L26
        int r14 = CursorUtil.getColumnIndexOrThrow(r7, "file_path");     // Catch: Throwable -> L26
        int r16 = CursorUtil.getColumnIndexOrThrow(r7, "partial_file_path");     // Catch: Throwable -> L26
        int r17 = CursorUtil.getColumnIndexOrThrow(r7, "temp_file_path");     // Catch: Throwable -> L26
        int r18 = CursorUtil.getColumnIndexOrThrow(r7, "file_size");     // Catch: Throwable -> L26
        int r19 = CursorUtil.getColumnIndexOrThrow(r7, "type");     // Catch: Throwable -> L26
        int r20 = CursorUtil.getColumnIndexOrThrow(r7, "last_access_time");     // Catch: Throwable -> L26
        int r21 = CursorUtil.getColumnIndexOrThrow(r7, "modification_time");     // Catch: Throwable -> L26
        RoomSQLiteQuery r110 = r3;
        int r111 = CursorUtil.getColumnIndexOrThrow(r7, "file_name");     // Catch: Throwable -> L24
        int r112 = CursorUtil.getColumnIndexOrThrow(r7, "cache_uid");     // Catch: Throwable -> L24
        int r113 = CursorUtil.getColumnIndexOrThrow(r7, "cache_tenant_id");     // Catch: Throwable -> L24
        int r22 = CursorUtil.getColumnIndexOrThrow(r7, "preview_extra");     // Catch: Throwable -> L24
        int r23 = CursorUtil.getColumnIndexOrThrow(r7, "is_use_partial_file");     // Catch: Throwable -> L24
        int r24 = CursorUtil.getColumnIndexOrThrow(r7, "cache_host");     // Catch: Throwable -> L24
        int r26 = CursorUtil.getColumnIndexOrThrow(r7, "sdk_app_id");     // Catch: Throwable -> L24
        int r27 = CursorUtil.getColumnIndexOrThrow(r7, "sdk_extra");     // Catch: Throwable -> L24
        int r28 = CursorUtil.getColumnIndexOrThrow(r7, "flags");     // Catch: Throwable -> L24
        int r29 = CursorUtil.getColumnIndexOrThrow(r7, "mime_type");     // Catch: Throwable -> L24
        int r210 = CursorUtil.getColumnIndexOrThrow(r7, "risk_status");     // Catch: Throwable -> L24
        int r211 = r21;
        ArrayList r30 = new ArrayList(r7.getCount());     // Catch: Throwable -> L24
    L15:
        if (r7.moveToNext() == false) goto L22;
        y75.a r31 = new y75.a();     // Catch: Throwable -> L24
        ArrayList r212 = r30;
        r31.a = r7.getString(r4);     // Catch: Throwable -> L24
        r31.b = r7.getString(r8);     // Catch: Throwable -> L24
        r31.c = r7.getString(r9);     // Catch: Throwable -> L24
        r31.d = r7.getString(r10);     // Catch: Throwable -> L24
        r31.e = r7.getString(r11);     // Catch: Throwable -> L24
        r31.f = r7.getString(r12);     // Catch: Throwable -> L24
        r31.g = r7.getString(r13);     // Catch: Throwable -> L24
        r31.h = r7.getString(r14);     // Catch: Throwable -> L24
        r31.i = r7.getString(r16);     // Catch: Throwable -> L24
        r31.j = r7.getString(r17);     // Catch: Throwable -> L24
        int r32 = r8;
        int r34 = r9;
        r31.k = r7.getLong(r18);     // Catch: Throwable -> L24
        r31.l = r7.getInt(r19);     // Catch: Throwable -> L24
        r31.m = r7.getLong(r20);     // Catch: Throwable -> L24
        int r36 = r19;
        int r37 = r211;
        r31.n = r7.getLong(r37);     // Catch: Throwable -> L24
        int r38 = r111;
        r31.o = r7.getString(r38);     // Catch: Throwable -> L24
        int r114 = r4;
        int r39 = r112;
        r31.p = r7.getString(r39);     // Catch: Throwable -> L24
        int r40 = r113;
        r31.q = r7.getString(r40);     // Catch: Throwable -> L24
        r113 = r40;
        int r41 = r22;
        r31.r = r7.getString(r41);     // Catch: Throwable -> L24
        int r42 = r23;
        r23 = r42;
        if (r7.getInt(r42) == 0) goto L19;
        boolean r43 = true;
    L20:
        r31.s = r43;     // Catch: Throwable -> L24
        r22 = r41;
        int r44 = r24;
        r31.t = r7.getInt(r44);     // Catch: Throwable -> L24
        r24 = r44;
        int r46 = r26;
        r31.u = r7.getString(r46);     // Catch: Throwable -> L24
        r26 = r46;
        int r47 = r27;
        r31.v = r7.getString(r47);     // Catch: Throwable -> L24
        r27 = r47;
        int r48 = r28;
        r31.w = r7.getInt(r48);     // Catch: Throwable -> L24
        r28 = r48;
        int r49 = r29;
        r31.x = r7.getString(r49);     // Catch: Throwable -> L24
        r29 = r49;
        int r50 = r210;
        r31.y = r7.getInt(r50);     // Catch: Throwable -> L24
        r212.add(r31);     // Catch: Throwable -> L24
        r210 = r50;
        r30 = r212;
        r4 = r114;
        r111 = r38;
        r112 = r39;
        r19 = r36;
        r9 = r34;
        r211 = r37;
        r8 = r32;
        goto L15
    L19:
        r43 = false;
        goto L20
    L22:
        ArrayList r51 = r30;
        r7.close();
        r110.release();
        return r51;
    L24:
        th = th;
    L28:
        r7.close();
        r110.release();
        throw th;
    L26:
        th = th;
        r110 = r3;
        goto L28
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int deleteCache(String r3) {
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

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final y75.a e0(String r29) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE cache_key = ? LIMIT 1", 1);
        if (r29 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.a, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, "cache_key");     // Catch: Throwable -> L22
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, "obj_token");     // Catch: Throwable -> L22
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, "src_ext");     // Catch: Throwable -> L22
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, "preview_ext");     // Catch: Throwable -> L22
        int r10 = CursorUtil.getColumnIndexOrThrow(r6, "data_version");     // Catch: Throwable -> L22
        int r11 = CursorUtil.getColumnIndexOrThrow(r6, "source_from");     // Catch: Throwable -> L22
        int r12 = CursorUtil.getColumnIndexOrThrow(r6, "cache_source_from");     // Catch: Throwable -> L22
        int r13 = CursorUtil.getColumnIndexOrThrow(r6, "file_path");     // Catch: Throwable -> L22
        int r14 = CursorUtil.getColumnIndexOrThrow(r6, "partial_file_path");     // Catch: Throwable -> L22
        int r16 = CursorUtil.getColumnIndexOrThrow(r6, "temp_file_path");     // Catch: Throwable -> L22
        int r3 = CursorUtil.getColumnIndexOrThrow(r6, "file_size");     // Catch: Throwable -> L22
        int r4 = CursorUtil.getColumnIndexOrThrow(r6, "type");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r6, "last_access_time");     // Catch: Throwable -> L22
        int r1 = CursorUtil.getColumnIndexOrThrow(r6, "modification_time");     // Catch: Throwable -> L22
        RoomSQLiteQuery r17 = r2;
        int r18 = CursorUtil.getColumnIndexOrThrow(r6, "file_name");     // Catch: Throwable -> L20
        int r19 = CursorUtil.getColumnIndexOrThrow(r6, "cache_uid");     // Catch: Throwable -> L20
        int r20 = CursorUtil.getColumnIndexOrThrow(r6, "cache_tenant_id");     // Catch: Throwable -> L20
        int r21 = CursorUtil.getColumnIndexOrThrow(r6, "preview_extra");     // Catch: Throwable -> L20
        int r22 = CursorUtil.getColumnIndexOrThrow(r6, "is_use_partial_file");     // Catch: Throwable -> L20
        int r23 = CursorUtil.getColumnIndexOrThrow(r6, "cache_host");     // Catch: Throwable -> L20
        int r24 = CursorUtil.getColumnIndexOrThrow(r6, "sdk_app_id");     // Catch: Throwable -> L20
        int r26 = CursorUtil.getColumnIndexOrThrow(r6, "sdk_extra");     // Catch: Throwable -> L20
        int r27 = CursorUtil.getColumnIndexOrThrow(r6, "flags");     // Catch: Throwable -> L20
        int r28 = CursorUtil.getColumnIndexOrThrow(r6, "mime_type");     // Catch: Throwable -> L20
        int r30 = CursorUtil.getColumnIndexOrThrow(r6, "risk_status");     // Catch: Throwable -> L20
        if (r6.moveToFirst() == false) goto L17;
        y75.a r31 = new y75.a();     // Catch: Throwable -> L20
        r31.a = r6.getString(r0);     // Catch: Throwable -> L20
        r31.b = r6.getString(r7);     // Catch: Throwable -> L20
        r31.c = r6.getString(r8);     // Catch: Throwable -> L20
        r31.d = r6.getString(r9);     // Catch: Throwable -> L20
        r31.e = r6.getString(r10);     // Catch: Throwable -> L20
        r31.f = r6.getString(r11);     // Catch: Throwable -> L20
        r31.g = r6.getString(r12);     // Catch: Throwable -> L20
        r31.h = r6.getString(r13);     // Catch: Throwable -> L20
        r31.i = r6.getString(r14);     // Catch: Throwable -> L20
        r31.j = r6.getString(r16);     // Catch: Throwable -> L20
        r31.k = r6.getLong(r3);     // Catch: Throwable -> L20
        r31.l = r6.getInt(r4);     // Catch: Throwable -> L20
        r31.m = r6.getLong(r5);     // Catch: Throwable -> L20
        r31.n = r6.getLong(r1);     // Catch: Throwable -> L20
        r31.o = r6.getString(r18);     // Catch: Throwable -> L20
        r31.p = r6.getString(r19);     // Catch: Throwable -> L20
        r31.q = r6.getString(r20);     // Catch: Throwable -> L20
        r31.r = r6.getString(r21);     // Catch: Throwable -> L20
        if (r6.getInt(r22) == 0) goto L14;
        boolean r32 = true;
    L15:
        r31.s = r32;     // Catch: Throwable -> L20
        r31.t = r6.getInt(r23);     // Catch: Throwable -> L20
        r31.u = r6.getString(r24);     // Catch: Throwable -> L20
        r31.v = r6.getString(r26);     // Catch: Throwable -> L20
        r31.w = r6.getInt(r27);     // Catch: Throwable -> L20
        r31.x = r6.getString(r28);     // Catch: Throwable -> L20
        r31.y = r6.getInt(r30);     // Catch: Throwable -> L20
        y75.a r33 = r31;
    L18:
        r6.close();
        r17.release();
        return r33;
    L14:
        r32 = false;
        goto L15
    L17:
        r33 = null;
    L20:
        th = th;
    L24:
        r6.close();
        r17.release();
        throw th;
    L22:
        th = th;
        r17 = r2;
        goto L24
    L5:
        r2.bindString(1, r29);
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public int update(y75.a r2) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        int r3 = this.c.handle(r2) + 0;     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int H(String r3, String r4) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.j.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r3 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.a.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.j.release(r0);
        return r5;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.j.release(r0);
        throw th;
    L9:
        r0.bindString(2, r3);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int T(String r4, String r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.i.acquire();
        r0.bindString(1, ShowCardsJsData.ID_GLOBAL);
        if (r5 != null) goto L5;
        r0.bindNull(2);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(3);
    L10:
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.i.release(r0);
        return r6;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.i.release(r0);
        throw th;
    L9:
        r0.bindString(3, r4);
        goto L10
    L5:
        r0.bindString(2, r5);
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int f0(String r3, long r4) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.d.acquire();
        r0.bindLong(1, r4);
        if (r3 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.a.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.d.release(r0);
        return r5;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.d.release(r0);
        throw th;
    L5:
        r0.bindString(2, r3);
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final int V(String r5, int r6, String r7) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.h.acquire();
        r0.bindLong(1, r6);
        if (r7 != null) goto L5;
        r0.bindNull(2);
    L7:
        if (r5 != null) goto L9;
        r0.bindNull(3);
    L10:
        this.a.beginTransaction();
        int r8 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.h.release(r0);
        return r8;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.h.release(r0);
        throw th;
    L9:
        r0.bindString(3, r5);
        goto L10
    L5:
        r0.bindString(2, r7);
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.dao.a
    public final List Z(long r30, String r32, String r33) {
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire("SELECT * FROM t_drive_cache WHERE type = ? AND cache_uid = ? AND cache_tenant_id = ? AND last_access_time <= ? AND modification_time <= ?", 5);
        r5.bindLong(1, 2);
        if (r32 != null) goto L5;
        r5.bindNull(2);
    L7:
        if (r33 != null) goto L9;
        r5.bindNull(3);
    L10:
        r5.bindLong(4, r30);
        r5.bindLong(5, r30);
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r5, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "cache_key");     // Catch: Throwable -> L26
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "obj_token");     // Catch: Throwable -> L26
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "src_ext");     // Catch: Throwable -> L26
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "preview_ext");     // Catch: Throwable -> L26
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "data_version");     // Catch: Throwable -> L26
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "source_from");     // Catch: Throwable -> L26
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "cache_source_from");     // Catch: Throwable -> L26
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "file_path");     // Catch: Throwable -> L26
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "partial_file_path");     // Catch: Throwable -> L26
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "temp_file_path");     // Catch: Throwable -> L26
        int r16 = CursorUtil.getColumnIndexOrThrow(r2, "file_size");     // Catch: Throwable -> L26
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L26
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "last_access_time");     // Catch: Throwable -> L26
        int r1 = CursorUtil.getColumnIndexOrThrow(r2, "modification_time");     // Catch: Throwable -> L26
        RoomSQLiteQuery r17 = r5;
        int r31 = CursorUtil.getColumnIndexOrThrow(r2, "file_name");     // Catch: Throwable -> L24
        int r34 = CursorUtil.getColumnIndexOrThrow(r2, "cache_uid");     // Catch: Throwable -> L24
        int r36 = CursorUtil.getColumnIndexOrThrow(r2, "cache_tenant_id");     // Catch: Throwable -> L24
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "preview_extra");     // Catch: Throwable -> L24
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "is_use_partial_file");     // Catch: Throwable -> L24
        int r110 = CursorUtil.getColumnIndexOrThrow(r2, "cache_host");     // Catch: Throwable -> L24
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "sdk_app_id");     // Catch: Throwable -> L24
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "sdk_extra");     // Catch: Throwable -> L24
        int r22 = CursorUtil.getColumnIndexOrThrow(r2, "flags");     // Catch: Throwable -> L24
        int r23 = CursorUtil.getColumnIndexOrThrow(r2, "mime_type");     // Catch: Throwable -> L24
        int r24 = CursorUtil.getColumnIndexOrThrow(r2, "risk_status");     // Catch: Throwable -> L24
        int r26 = r1;
        ArrayList r27 = new ArrayList(r2.getCount());     // Catch: Throwable -> L24
    L15:
        if (r2.moveToNext() == false) goto L22;
        y75.a r28 = new y75.a();     // Catch: Throwable -> L24
        ArrayList r29 = r27;
        r28.a = r2.getString(r0);     // Catch: Throwable -> L24
        r28.b = r2.getString(r4);     // Catch: Throwable -> L24
        r28.c = r2.getString(r6);     // Catch: Throwable -> L24
        r28.d = r2.getString(r7);     // Catch: Throwable -> L24
        r28.e = r2.getString(r8);     // Catch: Throwable -> L24
        r28.f = r2.getString(r9);     // Catch: Throwable -> L24
        r28.g = r2.getString(r11);     // Catch: Throwable -> L24
        r28.h = r2.getString(r12);     // Catch: Throwable -> L24
        r28.i = r2.getString(r13);     // Catch: Throwable -> L24
        r28.j = r2.getString(r14);     // Catch: Throwable -> L24
        int r210 = r4;
        r28.k = r2.getLong(r16);     // Catch: Throwable -> L24
        r28.l = r2.getInt(r3);     // Catch: Throwable -> L24
        r28.m = r2.getLong(r10);     // Catch: Throwable -> L24
        int r37 = r26;
        int r211 = r6;
        r28.n = r2.getLong(r37);     // Catch: Throwable -> L24
        int r38 = r31;
        r28.o = r2.getString(r38);     // Catch: Throwable -> L24
        int r39 = r34;
        int r310 = r0;
        r28.p = r2.getString(r39);     // Catch: Throwable -> L24
        int r40 = r36;
        int r311 = r3;
        r28.q = r2.getString(r40);     // Catch: Throwable -> L24
        r36 = r40;
        int r41 = r18;
        r28.r = r2.getString(r41);     // Catch: Throwable -> L24
        int r42 = r19;
        r19 = r42;
        if (r2.getInt(r42) == 0) goto L19;
        boolean r43 = true;
    L20:
        r28.s = r43;     // Catch: Throwable -> L24
        r18 = r41;
        int r44 = r110;
        r28.t = r2.getInt(r44);     // Catch: Throwable -> L24
        r110 = r44;
        int r46 = r20;
        r28.u = r2.getString(r46);     // Catch: Throwable -> L24
        r20 = r46;
        int r47 = r21;
        r28.v = r2.getString(r47);     // Catch: Throwable -> L24
        r21 = r47;
        int r48 = r22;
        r28.w = r2.getInt(r48);     // Catch: Throwable -> L24
        r22 = r48;
        int r49 = r23;
        r28.x = r2.getString(r49);     // Catch: Throwable -> L24
        r23 = r49;
        int r50 = r24;
        r28.y = r2.getInt(r50);     // Catch: Throwable -> L24
        r29.add(r28);     // Catch: Throwable -> L24
        r24 = r50;
        r3 = r311;
        r34 = r39;
        r6 = r211;
        r26 = r37;
        r4 = r210;
        r0 = r310;
        r31 = r38;
        r27 = r29;
        goto L15
    L19:
        r43 = false;
        goto L20
    L22:
        ArrayList r51 = r27;
        r2.close();
        r17.release();
        return r51;
    L24:
        th = th;
    L28:
        r2.close();
        r17.release();
        throw th;
    L26:
        th = th;
        r17 = r5;
        goto L28
    L9:
        r5.bindString(3, r33);
        goto L10
    L5:
        r5.bindString(2, r32);
        goto L7
    }
}
