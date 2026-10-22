package mc5;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j3 implements c3 {
    public final RoomDatabase a;
    public final d3 b;
    public final e3 c;
    public final f3 d;
    public final g3 e;
    public final h3 f;
    public final i3 g;

    public final List<b3> b() {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM WikiSpace ORDER BY browse_time DESC", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.a, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, "space_id");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "user_id");     // Catch: Throwable -> L22
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "space_name");     // Catch: Throwable -> L22
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "space_icon");     // Catch: Throwable -> L22
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "attr");     // Catch: Throwable -> L22
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "description");     // Catch: Throwable -> L22
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "is_star");     // Catch: Throwable -> L22
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "browse_time");     // Catch: Throwable -> L22
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "wiki_token");     // Catch: Throwable -> L22
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "obj_type");     // Catch: Throwable -> L22
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L22
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "origin");     // Catch: Throwable -> L22
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "thumbnail");     // Catch: Throwable -> L22
        int r1 = CursorUtil.getColumnIndexOrThrow(r4, "cover_key");     // Catch: Throwable -> L22
        RoomSQLiteQuery r16 = r3;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "is_graph_dark");     // Catch: Throwable -> L20
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "color_value");     // Catch: Throwable -> L20
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "wiki_scope");     // Catch: Throwable -> L20
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "space_type");     // Catch: Throwable -> L20
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "open_sharing");     // Catch: Throwable -> L20
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "tag_type");     // Catch: Throwable -> L20
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "tag_value");     // Catch: Throwable -> L20
        int r24 = r1;
        ArrayList r25 = new ArrayList(r4.getCount());     // Catch: Throwable -> L20
    L7:
        if (r4.moveToNext() == false) goto L18;
        b3 r26 = new b3();     // Catch: Throwable -> L20
        ArrayList r27 = r25;
        r26.a = r4.getString(r0);     // Catch: Throwable -> L20
        r26.b = r4.getString(r5);     // Catch: Throwable -> L20
        r26.c = r4.getString(r6);     // Catch: Throwable -> L20
        r26.d = r4.getString(r7);     // Catch: Throwable -> L20
        r26.e = r4.getInt(r8);     // Catch: Throwable -> L20
        r26.f = r4.getString(r9);     // Catch: Throwable -> L20
        if (r4.getInt(r10) == 0) goto L11;
        boolean r28 = true;
    L12:
        r26.g = r28;     // Catch: Throwable -> L20
        r26.h = r4.getString(r11);     // Catch: Throwable -> L20
        r26.i = r4.getString(r12);     // Catch: Throwable -> L20
        r26.j = r4.getInt(r13);     // Catch: Throwable -> L20
        r26.k = r4.getString(r14);     // Catch: Throwable -> L20
        r26.l = r4.getString(r15);     // Catch: Throwable -> L20
        r26.m = r4.getString(r2);     // Catch: Throwable -> L20
        int r29 = r24;
        int r210 = r0;
        r26.n = r4.getString(r29);     // Catch: Throwable -> L20
        r17 = r17;
        if (r4.getInt(r17) == 0) goto L15;
        boolean r30 = true;
    L16:
        r26.o = r30;     // Catch: Throwable -> L20
        int r31 = r18;
        int r110 = r2;
        r26.p = r4.getString(r31);     // Catch: Throwable -> L20
        int r32 = r19;
        r26.q = r4.getInt(r32);     // Catch: Throwable -> L20
        int r33 = r20;
        r26.r = r4.getInt(r33);     // Catch: Throwable -> L20
        int r34 = r21;
        r26.s = r4.getInt(r34);     // Catch: Throwable -> L20
        int r35 = r22;
        r26.t = r4.getInt(r35);     // Catch: Throwable -> L20
        int r36 = r23;
        r26.u = r4.getString(r36);     // Catch: Throwable -> L20
        r27.add(r26);     // Catch: Throwable -> L20
        r25 = r27;
        r0 = r210;
        r24 = r29;
        r23 = r36;
        r2 = r110;
        r18 = r31;
        r19 = r32;
        r20 = r33;
        r21 = r34;
        r22 = r35;
        goto L7
    L15:
        r30 = false;
        goto L16
    L11:
        r28 = false;
        goto L12
    L18:
        ArrayList r37 = r25;
        r4.close();
        r16.release();
        return r37;
    L20:
        th = th;
    L24:
        r4.close();
        r16.release();
        throw th;
    L22:
        th = th;
        r16 = r3;
        goto L24
    }

    public j3(BearDatabase r2) {
        this.a = r2;
        this.b = new d3(r2);
        this.c = new e3(r2);
        this.d = new f3(r2);
        this.e = new g3(r2);
        this.f = new h3(r2);
        this.g = new i3(r2);
    }

    public final int a(String r3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.d.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.d.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.d.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    public final List<b3> c(int r29) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM WikiSpace WHERE space_type=? ORDER BY browse_time DESC", 1);
        r3.bindLong(1, r29);
        this.a.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.a, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, "space_id");     // Catch: Throwable -> L22
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "user_id");     // Catch: Throwable -> L22
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "space_name");     // Catch: Throwable -> L22
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "space_icon");     // Catch: Throwable -> L22
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "attr");     // Catch: Throwable -> L22
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "description");     // Catch: Throwable -> L22
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "is_star");     // Catch: Throwable -> L22
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "browse_time");     // Catch: Throwable -> L22
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "wiki_token");     // Catch: Throwable -> L22
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "obj_type");     // Catch: Throwable -> L22
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L22
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "origin");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "thumbnail");     // Catch: Throwable -> L22
        int r1 = CursorUtil.getColumnIndexOrThrow(r4, "cover_key");     // Catch: Throwable -> L22
        RoomSQLiteQuery r16 = r3;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "is_graph_dark");     // Catch: Throwable -> L20
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "color_value");     // Catch: Throwable -> L20
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "wiki_scope");     // Catch: Throwable -> L20
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "space_type");     // Catch: Throwable -> L20
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "open_sharing");     // Catch: Throwable -> L20
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "tag_type");     // Catch: Throwable -> L20
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "tag_value");     // Catch: Throwable -> L20
        int r24 = r1;
        ArrayList r25 = new ArrayList(r4.getCount());     // Catch: Throwable -> L20
    L7:
        if (r4.moveToNext() == false) goto L18;
        b3 r26 = new b3();     // Catch: Throwable -> L20
        ArrayList r27 = r25;
        r26.a = r4.getString(r0);     // Catch: Throwable -> L20
        r26.b = r4.getString(r6);     // Catch: Throwable -> L20
        r26.c = r4.getString(r7);     // Catch: Throwable -> L20
        r26.d = r4.getString(r8);     // Catch: Throwable -> L20
        r26.e = r4.getInt(r9);     // Catch: Throwable -> L20
        r26.f = r4.getString(r10);     // Catch: Throwable -> L20
        if (r4.getInt(r11) == 0) goto L11;
        boolean r28 = true;
    L12:
        r26.g = r28;     // Catch: Throwable -> L20
        r26.h = r4.getString(r12);     // Catch: Throwable -> L20
        r26.i = r4.getString(r13);     // Catch: Throwable -> L20
        r26.j = r4.getInt(r14);     // Catch: Throwable -> L20
        r26.k = r4.getString(r15);     // Catch: Throwable -> L20
        r26.l = r4.getString(r2);     // Catch: Throwable -> L20
        r26.m = r4.getString(r5);     // Catch: Throwable -> L20
        int r30 = r24;
        int r210 = r0;
        r26.n = r4.getString(r30);     // Catch: Throwable -> L20
        r17 = r17;
        if (r4.getInt(r17) == 0) goto L15;
        boolean r31 = true;
    L16:
        r26.o = r31;     // Catch: Throwable -> L20
        int r32 = r18;
        int r110 = r2;
        r26.p = r4.getString(r32);     // Catch: Throwable -> L20
        int r33 = r19;
        r26.q = r4.getInt(r33);     // Catch: Throwable -> L20
        int r34 = r20;
        r26.r = r4.getInt(r34);     // Catch: Throwable -> L20
        int r35 = r21;
        r26.s = r4.getInt(r35);     // Catch: Throwable -> L20
        int r36 = r22;
        r26.t = r4.getInt(r36);     // Catch: Throwable -> L20
        int r37 = r23;
        r26.u = r4.getString(r37);     // Catch: Throwable -> L20
        r27.add(r26);     // Catch: Throwable -> L20
        r25 = r27;
        r0 = r210;
        r24 = r30;
        r23 = r37;
        r2 = r110;
        r18 = r32;
        r19 = r33;
        r20 = r34;
        r21 = r35;
        r22 = r36;
        goto L7
    L15:
        r31 = false;
        goto L16
    L11:
        r28 = false;
        goto L12
    L18:
        ArrayList r38 = r25;
        r4.close();
        r16.release();
        return r38;
    L20:
        th = th;
    L24:
        r4.close();
        r16.release();
        throw th;
    L22:
        th = th;
        r16 = r3;
        goto L24
    }

    public final b3 d(String r25) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM WikiSpace WHERE space_id=?", 1);
        if (r25 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.a, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, "space_id");     // Catch: Throwable -> L26
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, "user_id");     // Catch: Throwable -> L26
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, "space_name");     // Catch: Throwable -> L26
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, "space_icon");     // Catch: Throwable -> L26
        int r10 = CursorUtil.getColumnIndexOrThrow(r6, "attr");     // Catch: Throwable -> L26
        int r11 = CursorUtil.getColumnIndexOrThrow(r6, "description");     // Catch: Throwable -> L26
        int r12 = CursorUtil.getColumnIndexOrThrow(r6, "is_star");     // Catch: Throwable -> L26
        int r13 = CursorUtil.getColumnIndexOrThrow(r6, "browse_time");     // Catch: Throwable -> L26
        int r14 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_token");     // Catch: Throwable -> L26
        int r15 = CursorUtil.getColumnIndexOrThrow(r6, "obj_type");     // Catch: Throwable -> L26
        int r3 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L26
        int r4 = CursorUtil.getColumnIndexOrThrow(r6, "origin");     // Catch: Throwable -> L26
        int r5 = CursorUtil.getColumnIndexOrThrow(r6, "thumbnail");     // Catch: Throwable -> L26
        int r1 = CursorUtil.getColumnIndexOrThrow(r6, "cover_key");     // Catch: Throwable -> L26
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r6, "is_graph_dark");     // Catch: Throwable -> L24
        int r18 = CursorUtil.getColumnIndexOrThrow(r6, "color_value");     // Catch: Throwable -> L24
        int r19 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_scope");     // Catch: Throwable -> L24
        int r20 = CursorUtil.getColumnIndexOrThrow(r6, "space_type");     // Catch: Throwable -> L24
        int r21 = CursorUtil.getColumnIndexOrThrow(r6, "open_sharing");     // Catch: Throwable -> L24
        int r22 = CursorUtil.getColumnIndexOrThrow(r6, "tag_type");     // Catch: Throwable -> L24
        int r23 = CursorUtil.getColumnIndexOrThrow(r6, "tag_value");     // Catch: Throwable -> L24
        if (r6.moveToFirst() == false) goto L21;
        b3 r24 = new b3();     // Catch: Throwable -> L24
        r24.a = r6.getString(r0);     // Catch: Throwable -> L24
        r24.b = r6.getString(r7);     // Catch: Throwable -> L24
        r24.c = r6.getString(r8);     // Catch: Throwable -> L24
        r24.d = r6.getString(r9);     // Catch: Throwable -> L24
        r24.e = r6.getInt(r10);     // Catch: Throwable -> L24
        r24.f = r6.getString(r11);     // Catch: Throwable -> L24
        if (r6.getInt(r12) == 0) goto L14;
        boolean r26 = true;
    L15:
        r24.g = r26;     // Catch: Throwable -> L24
        r24.h = r6.getString(r13);     // Catch: Throwable -> L24
        r24.i = r6.getString(r14);     // Catch: Throwable -> L24
        r24.j = r6.getInt(r15);     // Catch: Throwable -> L24
        r24.k = r6.getString(r3);     // Catch: Throwable -> L24
        r24.l = r6.getString(r4);     // Catch: Throwable -> L24
        r24.m = r6.getString(r5);     // Catch: Throwable -> L24
        r24.n = r6.getString(r1);     // Catch: Throwable -> L24
        if (r6.getInt(r17) == 0) goto L18;
        boolean r27 = true;
    L19:
        r24.o = r27;     // Catch: Throwable -> L24
        r24.p = r6.getString(r18);     // Catch: Throwable -> L24
        r24.q = r6.getInt(r19);     // Catch: Throwable -> L24
        r24.r = r6.getInt(r20);     // Catch: Throwable -> L24
        r24.s = r6.getInt(r21);     // Catch: Throwable -> L24
        r24.t = r6.getInt(r22);     // Catch: Throwable -> L24
        r24.u = r6.getString(r23);     // Catch: Throwable -> L24
        b3 r28 = r24;
    L22:
        r6.close();
        r16.release();
        return r28;
    L18:
        r27 = false;
        goto L19
    L14:
        r26 = false;
        goto L15
    L21:
        r28 = null;
    L24:
        th = th;
    L28:
        r6.close();
        r16.release();
        throw th;
    L26:
        th = th;
        r16 = r2;
        goto L28
    L5:
        r2.bindString(1, r25);
        goto L6
    }

    public final int e(String r4, boolean r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.f.acquire();
        r0.bindLong(1, r5 ? 1 : 0);
        if (r4 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.f.release(r0);
        return r6;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.f.release(r0);
        throw th;
    L5:
        r0.bindString(2, r4);
        goto L6
    }

    public final int f(String r4, boolean r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.g.acquire();
        r0.bindLong(1, r5 ? 1 : 0);
        if (r4 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.g.release(r0);
        return r6;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.g.release(r0);
        throw th;
    L5:
        r0.bindString(2, r4);
        goto L6
    }

    public final int g(String r3, String r4) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.e.acquire();
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
        this.e.release(r0);
        return r5;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.e.release(r0);
        throw th;
    L9:
        r0.bindString(2, r3);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L7
    }
}
