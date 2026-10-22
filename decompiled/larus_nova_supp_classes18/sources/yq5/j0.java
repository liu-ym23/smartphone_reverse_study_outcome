package yq5;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j0 extends b0 {
    public final RoomDatabase a;
    public final c0 b;
    public final d0 c;
    public final e0 d;
    public final f0 e;
    public final g0 f;
    public final h0 g;
    public final i0 h;

    public j0(WikiDatabase r2) {
        this.a = r2;
        this.b = new c0(r2);
        this.c = new d0(r2);
        this.d = new e0(r2);
        this.e = new f0(r2);
        this.f = new g0(r2);
        this.g = new h0(r2);
        this.h = new i0(r2);
    }

    public static void e(j0 r3) {
        r3.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = r3.h.acquire();
        r3.a.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L11
        r3.a.setTransactionSuccessful();     // Catch: Throwable -> L11
        r3.a.endTransaction();
        r3.h.release(r0);
        r3.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r1 = r3.g.acquire();
        r3.a.beginTransaction();
        r1.executeUpdateDelete();     // Catch: Throwable -> L8
        r3.a.setTransactionSuccessful();     // Catch: Throwable -> L8
        r3.a.endTransaction();
        r3.g.release(r1);
        return;
    L8:
        th = move-exception;
        r3.a.endTransaction();
        r3.g.release(r1);
        throw th;
    L11:
        th = move-exception;
        r3.a.endTransaction();
        r3.h.release(r0);
        throw th;
    }

    public final long[] f(List<e> r2) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        long[] r3 = this.b.insertAndReturnIdsArray(r2);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public final long[] g(List<d> r2) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        long[] r3 = this.c.insertAndReturnIdsArray(r2);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    @Override // yq5.b0
    public final int c(String r4, boolean r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.d.acquire();
        r0.bindLong(1, r5 ? 1 : 0);
        if (r4 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.d.release(r0);
        return r6;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.d.release(r0);
        throw th;
    L5:
        r0.bindString(2, r4);
        goto L6
    }

    @Override // yq5.b0
    public final List<d> a(int r28, String r29, String r30) {
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("SELECT * FROM t_wiki_space_list_ref AS LT LEFT OUTER JOIN t_wiki_space AS DMI ON LT.space_id = DMI.space_id WHERE LT.space_list_type = ? AND LT.space_type_id = ? AND LT.space_class_id = ?", 3);
        r4.bindLong(1, r28);
        if (r29 != null) goto L5;
        r4.bindNull(2);
    L6:
        if (r30 != null) goto L8;
        r4.bindNull(3);
    L9:
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r4, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "space_id");     // Catch: Throwable -> L29
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "space_id");     // Catch: Throwable -> L29
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "space_name");     // Catch: Throwable -> L29
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "description");     // Catch: Throwable -> L29
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "space_icon");     // Catch: Throwable -> L29
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "tenant_id");     // Catch: Throwable -> L29
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "cover_origin");     // Catch: Throwable -> L29
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "cover_thumbnail");     // Catch: Throwable -> L29
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "cover_key");     // Catch: Throwable -> L29
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "cover_is_graph_dark");     // Catch: Throwable -> L29
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "cover_color_value");     // Catch: Throwable -> L29
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "root_token");     // Catch: Throwable -> L29
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "space_type");     // Catch: Throwable -> L29
        int r1 = CursorUtil.getColumnIndexOrThrow(r2, "wiki_scope");     // Catch: Throwable -> L29
        RoomSQLiteQuery r16 = r4;
        int r210 = CursorUtil.getColumnIndexOrThrow(r2, "is_star");     // Catch: Throwable -> L27
        int r31 = CursorUtil.getColumnIndexOrThrow(r2, "browse_time");     // Catch: Throwable -> L27
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "owner_perm_type");     // Catch: Throwable -> L27
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "open_sharing");     // Catch: Throwable -> L27
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "tag_type");     // Catch: Throwable -> L27
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "tag_value");     // Catch: Throwable -> L27
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "icon_info");     // Catch: Throwable -> L27
        int r22 = r1;
        ArrayList r23 = new ArrayList(r2.getCount());     // Catch: Throwable -> L27
    L14:
        if (r2.moveToNext() == false) goto L25;
        d r24 = new d();     // Catch: Throwable -> L27
        ArrayList r25 = r23;
        r24.a = r2.getString(r0);     // Catch: Throwable -> L27
        r24.a = r2.getString(r3);     // Catch: Throwable -> L27
        r24.b = r2.getString(r6);     // Catch: Throwable -> L27
        r24.c = r2.getString(r7);     // Catch: Throwable -> L27
        r24.d = r2.getString(r9);     // Catch: Throwable -> L27
        r24.e = r2.getString(r10);     // Catch: Throwable -> L27
        r24.f = r2.getString(r11);     // Catch: Throwable -> L27
        r24.g = r2.getString(r12);     // Catch: Throwable -> L27
        r24.h = r2.getString(r13);     // Catch: Throwable -> L27
        if (r2.getInt(r14) == 0) goto L18;
        boolean r26 = true;
    L19:
        r24.i = r26;     // Catch: Throwable -> L27
        r24.j = r2.getString(r15);     // Catch: Throwable -> L27
        r24.k = r2.getString(r5);     // Catch: Throwable -> L27
        r24.l = r2.getInt(r8);     // Catch: Throwable -> L27
        int r27 = r22;
        int r211 = r0;
        r24.m = r2.getInt(r27);     // Catch: Throwable -> L27
        int r32 = r210;
        r210 = r32;
        if (r2.getInt(r32) == 0) goto L22;
        boolean r33 = true;
    L23:
        r24.n = r33;     // Catch: Throwable -> L27
        int r34 = r31;
        int r35 = r3;
        r24.o = r2.getString(r34);     // Catch: Throwable -> L27
        int r36 = r17;
        r24.p = r2.getInt(r36);     // Catch: Throwable -> L27
        int r37 = r18;
        r24.q = r2.getInt(r37);     // Catch: Throwable -> L27
        int r38 = r19;
        r24.r = r2.getInt(r38);     // Catch: Throwable -> L27
        int r39 = r20;
        r24.s = r2.getString(r39);     // Catch: Throwable -> L27
        int r40 = r21;
        r24.t = r2.getString(r40);     // Catch: Throwable -> L27
        r25.add(r24);     // Catch: Throwable -> L27
        r3 = r35;
        r31 = r34;
        r17 = r36;
        r18 = r37;
        r19 = r38;
        r20 = r39;
        r21 = r40;
        r23 = r25;
        r0 = r211;
        r22 = r27;
        goto L14
    L22:
        r33 = false;
        goto L23
    L18:
        r26 = false;
        goto L19
    L25:
        ArrayList r41 = r23;
        r2.close();
        r16.release();
        return r41;
    L27:
        th = th;
    L31:
        r2.close();
        r16.release();
        throw th;
    L29:
        th = th;
        r16 = r4;
        goto L31
    L8:
        r4.bindString(3, r30);
        goto L9
    L5:
        r4.bindString(2, r29);
        goto L6
    }

    @Override // yq5.b0
    public final void b(List<d> r2, int r3, String r4, String r5) {
        this.a.beginTransaction();
        g(r2);     // Catch: Throwable -> L6
        f(zp5.a.a(r2, r3, r4, r5));     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public static void d(j0 r4, List r5, int r6, String r7, String r8) {
        r4.getClass();
        r4.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = r4.e.acquire();
        r0.bindLong(1, r6);
        if (r7 != null) goto L5;
        r0.bindNull(2);
    L7:
        if (r8 != null) goto L9;
        r0.bindNull(3);
    L10:
        r4.a.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L14
        r4.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        r4.a.endTransaction();
        r4.e.release(r0);
        r4.g(r5);
        r4.f(zp5.a.a(r5, r6, r7, r8));
        return;
    L14:
        th = move-exception;
        r4.a.endTransaction();
        r4.e.release(r0);
        throw th;
    L9:
        r0.bindString(3, r8);
        goto L10
    L5:
        r0.bindString(2, r7);
        goto L7
    }
}
