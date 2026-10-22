package k25;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b1 extends n0 {
    public final RoomDatabase a;
    public final s0 b;
    public final t0 c;
    public final u0 d;
    public final y0 e;
    public final z0 f;

    @Override // k25.n0
    public final List<String> c() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT obj_token FROM ResourceData group by obj_token", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r0, false, null);
        ArrayList r3 = new ArrayList(r2.getCount());     // Catch: Throwable -> L10
    L5:
        if (r2.moveToNext() == false) goto L8;
        r3.add(r2.getString(0));     // Catch: Throwable -> L10
        goto L5
    L8:
        r2.close();
        r0.release();
        return r3;
    L10:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    }

    @Override // k25.n0
    public final List<c1> f() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("Select a.* from ResourceData a join (Select distinct id,reskey,obj_token from (Select id,reskey,obj_token,batch_num,total_page,max(page) as max_page from ResourceData group by reskey,obj_token,batch_num,total_page) where total_page > 1 and max_page + 1 < total_page)b\non a.reskey=b.reskey and a.obj_token=b.obj_token", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.a, r0, false, null);
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "id");     // Catch: Throwable -> L14
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "reskey");     // Catch: Throwable -> L14
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "resvalue_filepath");     // Catch: Throwable -> L14
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "access_time");     // Catch: Throwable -> L14
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L14
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "token");     // Catch: Throwable -> L14
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "obj_token");     // Catch: Throwable -> L14
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "url");     // Catch: Throwable -> L14
        ArrayList r11 = new ArrayList(r1.getCount());     // Catch: Throwable -> L14
    L4:
        if (r1.moveToNext() == false) goto L12;
        c1 r12 = new c1();     // Catch: Throwable -> L14
        r12.f = r1.getInt(r2);     // Catch: Throwable -> L14
        r12.e = r1.getString(r4);     // Catch: Throwable -> L14
        r12.a = r1.getString(r5);     // Catch: Throwable -> L14
        if (r1.isNull(r6) == false) goto L9;
        Long r13 = null;
    L10:
        r12.g = r13;     // Catch: Throwable -> L14
        r12.b = r1.getString(r7);     // Catch: Throwable -> L14
        r1.getString(r8);     // Catch: Throwable -> L14
        r12.c = r1.getString(r9);     // Catch: Throwable -> L14
        r12.d = r1.getString(r10);     // Catch: Throwable -> L14
        r11.add(r12);     // Catch: Throwable -> L14
        goto L4
    L9:
        r13 = Long.valueOf(r1.getLong(r6));     // Catch: Throwable -> L14
        goto L10
    L12:
        r1.close();
        r0.release();
        return r11;
    L14:
        th = move-exception;
        r1.close();
        r0.release();
        throw th;
    }

    @Override // k25.n0
    public final List l() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token,type,url,id FROM ResourceData WHERE isNeedSync= ?", 1);
        r0.bindLong(1, 1);
        this.a.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.a, r0, false, null);
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "obj_token");     // Catch: Throwable -> L10
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L10
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "url");     // Catch: Throwable -> L10
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "id");     // Catch: Throwable -> L10
        ArrayList r6 = new ArrayList(r1.getCount());     // Catch: Throwable -> L10
    L5:
        if (r1.moveToNext() == false) goto L8;
        c1 r7 = new c1();     // Catch: Throwable -> L10
        r7.c = r1.getString(r2);     // Catch: Throwable -> L10
        r7.b = r1.getString(r3);     // Catch: Throwable -> L10
        r7.d = r1.getString(r4);     // Catch: Throwable -> L10
        r7.f = r1.getInt(r5);     // Catch: Throwable -> L10
        r6.add(r7);     // Catch: Throwable -> L10
        goto L5
    L8:
        r1.close();
        r0.release();
        return r6;
    L10:
        th = move-exception;
        r1.close();
        r0.release();
        throw th;
    }

    @Override // k25.n0
    public final List o() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token FROM ResourceData WHERE isNeedSync= ?", 1);
        r0.bindLong(1, 1);
        this.a.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.a, r0, false, null);
        ArrayList r3 = new ArrayList(r1.getCount());     // Catch: Throwable -> L10
    L5:
        if (r1.moveToNext() == false) goto L8;
        r3.add(r1.getString(0));     // Catch: Throwable -> L10
        goto L5
    L8:
        r1.close();
        r0.release();
        return r3;
    L10:
        th = move-exception;
        r1.close();
        r0.release();
        throw th;
    }

    public b1(OfflineDatabase r2) {
        this.a = r2;
        this.b = new s0(r2);
        this.c = new t0(r2);
        this.d = new u0(r2);
        new v0(r2);
        new w0(r2);
        new x0(r2);
        this.e = new y0(r2);
        this.f = new z0(r2);
        new a1(r2);
        new o0(r2);
        new p0(r2);
    }

    @Override // k25.n0
    public final long d(m0 r3) {
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

    @Override // k25.n0
    public final List<Integer> h(String r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT id FROM ResourceData WHERE obj_token= ?", 1);
        if (r6 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.a, r0, false, null);
        ArrayList r3 = new ArrayList(r7.getCount());     // Catch: Throwable -> L18
    L8:
        if (r7.moveToNext() == false) goto L16;
        if (r7.isNull(0) == false) goto L13;
        Integer r4 = null;
    L14:
        r3.add(r4);     // Catch: Throwable -> L18
        goto L8
    L13:
        r4 = Integer.valueOf(r7.getInt(0));     // Catch: Throwable -> L18
        goto L14
    L16:
        r7.close();
        r0.release();
        return r3;
    L18:
        th = move-exception;
        r7.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r6);
        goto L6
    }

    @Override // k25.n0
    public final int b(List<String> r6, long r7) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM ResourceData WHERE obj_token IN(");
        int r1 = r6.size();
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(") AND (category IS NULL OR (category IS NOT NULL AND access_time<= ");
        r0.append("?");
        r0.append("))");
        String r2 = r0.toString();
        SupportSQLiteStatement r3 = this.a.compileStatement(r2);
        Iterator<String> r8 = r6.iterator();
        int r4 = 1;
    L4:
        if (r8.hasNext() == false) goto L10;
        String r5 = r8.next();
        if (r5 != null) goto L8;
        r3.bindNull(r4);
    L9:
        r4 = r4 + 1;
        goto L4
    L8:
        r3.bindString(r4, r5);
        goto L9
    L10:
        r3.bindLong(r1 + 1, r7);
        this.a.beginTransaction();
        int r9 = r3.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        return r9;
    L14:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    @Override // k25.n0
    public final List<String> e(List<String> r5, String r6) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT distinct obj_token FROM ResourceData WHERE obj_token IN (");
        ArrayList r7 = (ArrayList) r5;
        int r1 = r7.size();
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(") AND reskey = ");
        r0.append("?");
        int r2 = 1;
        int r3 = r1 + 1;
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire(r0.toString(), r3);
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        String r9 = (String) r8.next();
        if (r9 != null) goto L8;
        r4.bindNull(r2);
    L9:
        r2 = r2 + 1;
        goto L4
    L8:
        r4.bindString(r2, r9);
        goto L9
    L10:
        if (r6 != null) goto L12;
        r4.bindNull(r3);
    L13:
        this.a.assertNotSuspendingTransaction();
        Cursor r10 = DBUtil.query(this.a, r4, false, null);
        ArrayList r11 = new ArrayList(r10.getCount());     // Catch: Throwable -> L21
    L16:
        if (r10.moveToNext() == false) goto L19;
        r11.add(r10.getString(0));     // Catch: Throwable -> L21
        goto L16
    L19:
        r10.close();
        r4.release();
        return r11;
    L21:
        th = move-exception;
        r10.close();
        r4.release();
        throw th;
    L12:
        r4.bindString(r3, r6);
        goto L13
    }

    @Override // k25.n0
    public final m0 j(String r24, String r26) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM ResourceData WHERE obj_token=? and category= ? and page = ?", 3);
        if (r26 != null) goto L5;
        r3.bindNull(1);
    L7:
        if (r24 != null) goto L9;
        r3.bindNull(2);
    L10:
        r3.bindLong(3, 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r3, false, null);
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "reskey");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "resvalue");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "resvalue_filepath");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "update_time");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "access_time");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "isNeedSync");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "config");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L34
        int r16 = CursorUtil.getColumnIndexOrThrow(r2, "token");     // Catch: Throwable -> L34
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "obj_token");     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "userToken");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "tenantID");     // Catch: Throwable -> L34
        int r1 = CursorUtil.getColumnIndexOrThrow(r2, "url");     // Catch: Throwable -> L34
        RoomSQLiteQuery r17 = r3;
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "subblock_preload_status");     // Catch: Throwable -> L32
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "page");     // Catch: Throwable -> L32
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "total_page");     // Catch: Throwable -> L32
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "batch_num");     // Catch: Throwable -> L32
        int r22 = CursorUtil.getColumnIndexOrThrow(r2, "load_from");     // Catch: Throwable -> L32
        int r23 = CursorUtil.getColumnIndexOrThrow(r2, "category");     // Catch: Throwable -> L32
        if (r2.moveToFirst() == false) goto L29;
        m0 r27 = new m0();     // Catch: Throwable -> L32
        r27.a = r2.getInt(r6);     // Catch: Throwable -> L32
        r27.b = r2.getString(r7);     // Catch: Throwable -> L32
        r27.c = r2.getString(r8);     // Catch: Throwable -> L32
        r27.d = r2.getString(r9);     // Catch: Throwable -> L32
        if (r2.isNull(r10) == false) goto L18;
        Long r28 = null;
    L19:
        r27.e = r28;     // Catch: Throwable -> L32
        if (r2.isNull(r11) == false) goto L22;
        Long r29 = null;
    L23:
        r27.f = r29;     // Catch: Throwable -> L32
        if (r2.getInt(r12) == 0) goto L26;
        boolean r30 = true;
    L27:
        r27.g = r30;     // Catch: Throwable -> L32
        r27.h = r2.getString(r13);     // Catch: Throwable -> L32
        r27.i = r2.getString(r14);     // Catch: Throwable -> L32
        r27.j = r2.getString(r16);     // Catch: Throwable -> L32
        r27.k = r2.getString(r0);     // Catch: Throwable -> L32
        r27.l = r2.getString(r4);     // Catch: Throwable -> L32
        r27.m = r2.getString(r5);     // Catch: Throwable -> L32
        r27.n = r2.getString(r1);     // Catch: Throwable -> L32
        r27.o = r2.getInt(r18);     // Catch: Throwable -> L32
        r27.p = r2.getInt(r19);     // Catch: Throwable -> L32
        r27.q = r2.getInt(r20);     // Catch: Throwable -> L32
        r27.r = r2.getString(r21);     // Catch: Throwable -> L32
        r27.s = r2.getString(r22);     // Catch: Throwable -> L32
        r27.t = r2.getString(r23);     // Catch: Throwable -> L32
        m0 r31 = r27;
    L30:
        r2.close();
        r17.release();
        return r31;
    L26:
        r30 = false;
        goto L27
    L22:
        r29 = Long.valueOf(r2.getLong(r11));     // Catch: Throwable -> L32
        goto L23
    L18:
        r28 = Long.valueOf(r2.getLong(r10));     // Catch: Throwable -> L32
        goto L19
    L29:
        r31 = null;
    L32:
        th = th;
    L36:
        r2.close();
        r17.release();
        throw th;
    L34:
        th = th;
        r17 = r3;
        goto L36
    L9:
        r3.bindString(2, r24);
        goto L10
    L5:
        r3.bindString(1, r26);
        goto L7
    }

    @Override // k25.n0
    public final List<c1> k(String r5, long r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT resvalue_filepath,id FROM ResourceData WHERE obj_token= ? AND (category IS NULL OR (category IS NOT NULL AND access_time<= ?))", 2);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r6);
        this.a.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.a, r0, false, null);
        int r8 = CursorUtil.getColumnIndexOrThrow(r7, "resvalue_filepath");     // Catch: Throwable -> L14
        int r9 = CursorUtil.getColumnIndexOrThrow(r7, "id");     // Catch: Throwable -> L14
        ArrayList r1 = new ArrayList(r7.getCount());     // Catch: Throwable -> L14
    L9:
        if (r7.moveToNext() == false) goto L12;
        c1 r2 = new c1();     // Catch: Throwable -> L14
        r2.a = r7.getString(r8);     // Catch: Throwable -> L14
        r2.f = r7.getInt(r9);     // Catch: Throwable -> L14
        r1.add(r2);     // Catch: Throwable -> L14
        goto L9
    L12:
        r7.close();
        r0.release();
        return r1;
    L14:
        th = move-exception;
        r7.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    @Override // k25.n0
    public final List m(long r9, List r11) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT obj_token,resvalue_filepath,id,access_time FROM ResourceData WHERE access_time<= ");
        r0.append("?");
        r0.append(" AND obj_token NOT IN(");
        int r2 = r11.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") limit ");
        r0.append("?");
        int r1 = 2;
        int r3 = r2 + 2;
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire(r0.toString(), r3);
        r4.bindLong(1, r9);
        Iterator r10 = r11.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        String r12 = (String) r10.next();
        if (r12 != null) goto L8;
        r4.bindNull(r1);
    L9:
        r1 = r1 + 1;
        goto L4
    L8:
        r4.bindString(r1, r12);
        goto L9
    L10:
        r4.bindLong(r3, 999);
        this.a.assertNotSuspendingTransaction();
        Cursor r13 = DBUtil.query(this.a, r4, false, null);
        int r14 = CursorUtil.getColumnIndexOrThrow(r13, "obj_token");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r13, "resvalue_filepath");     // Catch: Throwable -> L22
        int r6 = CursorUtil.getColumnIndexOrThrow(r13, "id");     // Catch: Throwable -> L22
        int r7 = CursorUtil.getColumnIndexOrThrow(r13, "access_time");     // Catch: Throwable -> L22
        ArrayList r8 = new ArrayList(r13.getCount());     // Catch: Throwable -> L22
    L12:
        if (r13.moveToNext() == false) goto L20;
        c1 r16 = new c1();     // Catch: Throwable -> L22
        r16.c = r13.getString(r14);     // Catch: Throwable -> L22
        r16.a = r13.getString(r5);     // Catch: Throwable -> L22
        r16.f = r13.getInt(r6);     // Catch: Throwable -> L22
        if (r13.isNull(r7) == false) goto L17;
        Long r17 = null;
    L18:
        r16.g = r17;     // Catch: Throwable -> L22
        r8.add(r16);     // Catch: Throwable -> L22
        goto L12
    L17:
        r17 = Long.valueOf(r13.getLong(r7));     // Catch: Throwable -> L22
        goto L18
    L20:
        r13.close();
        r4.release();
        return r8;
    L22:
        th = move-exception;
        r13.close();
        r4.release();
        throw th;
    }

    @Override // k25.n0
    public final int p(String r4, int r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.d.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindString(2, "sheet_tab_ssr");
        if (r4 != null) goto L9;
        r0.bindNull(3);
    L10:
        r0.bindString(4, "sheet_tab_ssr");
        r0.bindLong(5, r5);
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.d.release(r0);
        return r6;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.d.release(r0);
        throw th;
    L9:
        r0.bindString(3, r4);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // k25.n0
    public final int a(String r3, String r4, long r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.f.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(2);
    L10:
        r0.bindLong(3, r5);
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.f.release(r0);
        return r6;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.f.release(r0);
        throw th;
    L9:
        r0.bindString(2, r4);
        goto L10
    L5:
        r0.bindString(1, r3);
        goto L7
    }

    @Override // k25.n0
    public final m0 i(String r23, String r24, int r26) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM ResourceData WHERE obj_token=? and reskey= ? and page = ?", 3);
        if (r23 != null) goto L5;
        r3.bindNull(1);
    L7:
        if (r24 != null) goto L9;
        r3.bindNull(2);
    L10:
        r3.bindLong(3, r26);
        this.a.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.a, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, "id");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, "reskey");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, "resvalue");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, "resvalue_filepath");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r6, "update_time");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r6, "access_time");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r6, "isNeedSync");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r6, "config");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r6, "type");     // Catch: Throwable -> L34
        int r16 = CursorUtil.getColumnIndexOrThrow(r6, "token");     // Catch: Throwable -> L34
        int r2 = CursorUtil.getColumnIndexOrThrow(r6, "obj_token");     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r6, "userToken");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r6, "tenantID");     // Catch: Throwable -> L34
        int r1 = CursorUtil.getColumnIndexOrThrow(r6, "url");     // Catch: Throwable -> L34
        RoomSQLiteQuery r17 = r3;
        int r18 = CursorUtil.getColumnIndexOrThrow(r6, "subblock_preload_status");     // Catch: Throwable -> L32
        int r19 = CursorUtil.getColumnIndexOrThrow(r6, "page");     // Catch: Throwable -> L32
        int r20 = CursorUtil.getColumnIndexOrThrow(r6, "total_page");     // Catch: Throwable -> L32
        int r21 = CursorUtil.getColumnIndexOrThrow(r6, "batch_num");     // Catch: Throwable -> L32
        int r22 = CursorUtil.getColumnIndexOrThrow(r6, "load_from");     // Catch: Throwable -> L32
        int r27 = CursorUtil.getColumnIndexOrThrow(r6, "category");     // Catch: Throwable -> L32
        if (r6.moveToFirst() == false) goto L29;
        m0 r28 = new m0();     // Catch: Throwable -> L32
        r28.a = r6.getInt(r0);     // Catch: Throwable -> L32
        r28.b = r6.getString(r7);     // Catch: Throwable -> L32
        r28.c = r6.getString(r8);     // Catch: Throwable -> L32
        r28.d = r6.getString(r9);     // Catch: Throwable -> L32
        if (r6.isNull(r10) == false) goto L18;
        Long r29 = null;
    L19:
        r28.e = r29;     // Catch: Throwable -> L32
        if (r6.isNull(r11) == false) goto L22;
        Long r30 = null;
    L23:
        r28.f = r30;     // Catch: Throwable -> L32
        if (r6.getInt(r12) == 0) goto L26;
        boolean r31 = true;
    L27:
        r28.g = r31;     // Catch: Throwable -> L32
        r28.h = r6.getString(r13);     // Catch: Throwable -> L32
        r28.i = r6.getString(r14);     // Catch: Throwable -> L32
        r28.j = r6.getString(r16);     // Catch: Throwable -> L32
        r28.k = r6.getString(r2);     // Catch: Throwable -> L32
        r28.l = r6.getString(r4);     // Catch: Throwable -> L32
        r28.m = r6.getString(r5);     // Catch: Throwable -> L32
        r28.n = r6.getString(r1);     // Catch: Throwable -> L32
        r28.o = r6.getInt(r18);     // Catch: Throwable -> L32
        r28.p = r6.getInt(r19);     // Catch: Throwable -> L32
        r28.q = r6.getInt(r20);     // Catch: Throwable -> L32
        r28.r = r6.getString(r21);     // Catch: Throwable -> L32
        r28.s = r6.getString(r22);     // Catch: Throwable -> L32
        r28.t = r6.getString(r27);     // Catch: Throwable -> L32
        m0 r32 = r28;
    L30:
        r6.close();
        r17.release();
        return r32;
    L26:
        r31 = false;
        goto L27
    L22:
        r30 = Long.valueOf(r6.getLong(r11));     // Catch: Throwable -> L32
        goto L23
    L18:
        r29 = Long.valueOf(r6.getLong(r10));     // Catch: Throwable -> L32
        goto L19
    L29:
        r32 = null;
    L32:
        th = th;
    L36:
        r6.close();
        r17.release();
        throw th;
    L34:
        th = th;
        r17 = r3;
        goto L36
    L9:
        r3.bindString(2, r24);
        goto L10
    L5:
        r3.bindString(1, r23);
        goto L7
    }

    @Override // k25.n0
    public final f1 n(String r6, String r7, int r8) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id,subblock_preload_status,page,total_page,resvalue_filepath FROM ResourceData WHERE obj_token = ? AND reskey = ? AND page = ?", 3);
        if (r7 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r6 != null) goto L9;
        r0.bindNull(2);
    L10:
        r0.bindLong(3, r8);
        this.a.assertNotSuspendingTransaction();
        f1 r9 = null;
        Cursor r10 = DBUtil.query(this.a, r0, false, null);
        int r11 = CursorUtil.getColumnIndexOrThrow(r10, "id");     // Catch: Throwable -> L16
        int r1 = CursorUtil.getColumnIndexOrThrow(r10, "subblock_preload_status");     // Catch: Throwable -> L16
        int r2 = CursorUtil.getColumnIndexOrThrow(r10, "page");     // Catch: Throwable -> L16
        int r3 = CursorUtil.getColumnIndexOrThrow(r10, "total_page");     // Catch: Throwable -> L16
        if (r10.moveToFirst() == false) goto L14;
        r9 = new f1();     // Catch: Throwable -> L16
        r9.a = r10.getInt(r11);     // Catch: Throwable -> L16
        r9.b = r10.getInt(r1);     // Catch: Throwable -> L16
        r9.c = r10.getInt(r2);     // Catch: Throwable -> L16
        r9.d = r10.getInt(r3);     // Catch: Throwable -> L16
    L14:
        r10.close();
        r0.release();
        return r9;
    L16:
        th = move-exception;
        r10.close();
        r0.release();
        throw th;
    L9:
        r0.bindString(2, r6);
        goto L10
    L5:
        r0.bindString(1, r7);
        goto L7
    }

    @Override // k25.n0
    public final int q(String r4, String r5, List<Integer> r6) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE ResourceData SET obj_token = ");
        r0.append("?");
        r0.append(", token = ");
        r0.append("?");
        r0.append(" WHERE id in (");
        StringUtil.appendPlaceholders(r0, r6.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.a.compileStatement(r0.toString());
        if (r4 != null) goto L5;
        r1.bindNull(1);
    L7:
        if (r5 != null) goto L9;
        r1.bindNull(2);
    L10:
        Iterator<Integer> r7 = r6.iterator();
        int r8 = 3;
    L12:
        if (r7.hasNext() == false) goto L18;
        Integer r9 = r7.next();
        if (r9 != null) goto L16;
        r1.bindNull(r8);
    L17:
        r8 = r8 + 1;
        goto L12
    L16:
        r1.bindLong(r8, r9.intValue());
        goto L17
    L18:
        this.a.beginTransaction();
        int r10 = r1.executeUpdateDelete();     // Catch: Throwable -> L22
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L22
        this.a.endTransaction();
        return r10;
    L22:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    L9:
        r1.bindString(2, r5);
        goto L10
    L5:
        r1.bindString(1, r4);
        goto L7
    }

    @Override // k25.n0
    public final List<String> g(int r4, String r5, String r6, long r7, int r9) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT A.obj_token FROM (SELECT DISTINCT obj_token FROM ResourceData WHERE reskey = ? AND type IS NOT 'doc' AND update_time>= ? order by update_time desc limit ?) AS A LEFT OUTER JOIN (SELECT DISTINCT obj_token FROM ResourceData WHERE reskey = ? AND resvalue IS NOT NULL) AS B on A.obj_token = B.obj_token WHERE B.obj_token IS NULL limit ?", 5);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r7);
        r0.bindLong(3, r4);
        if (r6 != null) goto L9;
        r0.bindNull(4);
    L10:
        r0.bindLong(5, r9);
        this.a.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.a, r0, false, null);
        ArrayList r10 = new ArrayList(r8.getCount());     // Catch: Throwable -> L18
    L13:
        if (r8.moveToNext() == false) goto L16;
        r10.add(r8.getString(0));     // Catch: Throwable -> L18
        goto L13
    L16:
        r8.close();
        r0.release();
        return r10;
    L18:
        th = move-exception;
        r8.close();
        r0.release();
        throw th;
    L9:
        r0.bindString(4, r6);
        goto L10
    L5:
        r0.bindString(1, r5);
        goto L6
    }
}
