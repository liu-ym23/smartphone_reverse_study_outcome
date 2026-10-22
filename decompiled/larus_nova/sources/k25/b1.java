package k25;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class b1 extends n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f501476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0 f501477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0 f501478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u0 f501479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y0 f501480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z0 f501481f;

    @Override // k25.n0
    public final List<String> c() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT obj_token FROM ResourceData group by obj_token", 0);
        this.f501476a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f501476a, r100, false, null);
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

    @Override // k25.n0
    public final List<c1> f() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("Select a.* from ResourceData a join (Select distinct id,reskey,obj_token from (Select id,reskey,obj_token,batch_num,total_page,max(page) as max_page from ResourceData group by reskey,obj_token,batch_num,total_page) where total_page > 1 and max_page + 1 < total_page)b\non a.reskey=b.reskey and a.obj_token=b.obj_token", 0);
        this.f501476a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f501476a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L14
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RES_KEY);     // Catch: Throwable -> L14
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L14
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L14
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L14
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "token");     // Catch: Throwable -> L14
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L14
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "url");     // Catch: Throwable -> L14
        ArrayList r111 = new ArrayList(r101.getCount());     // Catch: Throwable -> L14
    L4:
        if (r101.moveToNext() == false) goto L12;
        c1 r112 = new c1();     // Catch: Throwable -> L14
        r112.f501490f = r101.getInt(r102);     // Catch: Throwable -> L14
        r112.f501489e = r101.getString(r103);     // Catch: Throwable -> L14
        r112.f501485a = r101.getString(r104);     // Catch: Throwable -> L14
        if (r101.isNull(r105) == false) goto L9;
        Long r113 = null;
    L10:
        r112.f501491g = r113;     // Catch: Throwable -> L14
        r112.f501486b = r101.getString(r106);     // Catch: Throwable -> L14
        r101.getString(r107);     // Catch: Throwable -> L14
        r112.f501487c = r101.getString(r108);     // Catch: Throwable -> L14
        r112.f501488d = r101.getString(r110);     // Catch: Throwable -> L14
        r111.add(r112);     // Catch: Throwable -> L14
        goto L4
    L9:
        r113 = Long.valueOf(r101.getLong(r105));     // Catch: Throwable -> L14
        goto L10
    L12:
        r101.close();
        r100.release();
        return r111;
    L14:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    }

    @Override // k25.n0
    public final List l() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token,type,url,id FROM ResourceData WHERE isNeedSync= ?", 1);
        r100.bindLong(1, 1);
        this.f501476a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f501476a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L10
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L10
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "url");     // Catch: Throwable -> L10
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L10
        ArrayList r106 = new ArrayList(r101.getCount());     // Catch: Throwable -> L10
    L5:
        if (r101.moveToNext() == false) goto L8;
        c1 r107 = new c1();     // Catch: Throwable -> L10
        r107.f501487c = r101.getString(r102);     // Catch: Throwable -> L10
        r107.f501486b = r101.getString(r103);     // Catch: Throwable -> L10
        r107.f501488d = r101.getString(r104);     // Catch: Throwable -> L10
        r107.f501490f = r101.getInt(r105);     // Catch: Throwable -> L10
        r106.add(r107);     // Catch: Throwable -> L10
        goto L5
    L8:
        r101.close();
        r100.release();
        return r106;
    L10:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    }

    @Override // k25.n0
    public final List o() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token FROM ResourceData WHERE isNeedSync= ?", 1);
        r100.bindLong(1, 1);
        this.f501476a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f501476a, r100, false, null);
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

    public b1(OfflineDatabase r100) {
        this.f501476a = r100;
        this.f501477b = new s0(r100);
        this.f501478c = new t0(r100);
        this.f501479d = new u0(r100);
        new v0(r100);
        new w0(r100);
        new x0(r100);
        this.f501480e = new y0(r100);
        this.f501481f = new z0(r100);
        new a1(r100);
        new o0(r100);
        new p0(r100);
    }

    @Override // k25.n0
    public final long d(m0 r100) {
        this.f501476a.assertNotSuspendingTransaction();
        this.f501476a.beginTransaction();
        long r101 = this.f501477b.insertAndReturnId(r100);     // Catch: Throwable -> L6
        this.f501476a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f501476a.endTransaction();
        return r101;
    L6:
        th = move-exception;
        this.f501476a.endTransaction();
        throw th;
    }

    @Override // k25.n0
    public final List<Integer> h(String r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT DISTINCT id FROM ResourceData WHERE obj_token= ?", 1);
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f501476a.assertNotSuspendingTransaction();
        Cursor r102 = DBUtil.query(this.f501476a, r101, false, null);
        ArrayList r103 = new ArrayList(r102.getCount());     // Catch: Throwable -> L18
    L8:
        if (r102.moveToNext() == false) goto L16;
        if (r102.isNull(0) == false) goto L13;
        Integer r104 = null;
    L14:
        r103.add(r104);     // Catch: Throwable -> L18
        goto L8
    L13:
        r104 = Integer.valueOf(r102.getInt(0));     // Catch: Throwable -> L18
        goto L14
    L16:
        r102.close();
        r101.release();
        return r103;
    L18:
        th = move-exception;
        r102.close();
        r101.release();
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    @Override // k25.n0
    public final int b(List<String> r100, long r101) {
        this.f501476a.assertNotSuspendingTransaction();
        StringBuilder r102 = StringUtil.newStringBuilder();
        r102.append("DELETE FROM ResourceData WHERE obj_token IN(");
        int r103 = r100.size();
        StringUtil.appendPlaceholders(r102, r103);
        r102.append(") AND (category IS NULL OR (category IS NOT NULL AND access_time<= ");
        r102.append("?");
        r102.append("))");
        String r104 = r102.toString();
        SupportSQLiteStatement r105 = this.f501476a.compileStatement(r104);
        Iterator<String> r106 = r100.iterator();
        int r107 = 1;
    L4:
        if (r106.hasNext() == false) goto L10;
        String r108 = r106.next();
        if (r108 != null) goto L8;
        r105.bindNull(r107);
    L9:
        r107 = r107 + 1;
        goto L4
    L8:
        r105.bindString(r107, r108);
        goto L9
    L10:
        r105.bindLong(r103 + 1, r101);
        this.f501476a.beginTransaction();
        int r109 = r105.executeUpdateDelete();     // Catch: Throwable -> L14
        this.f501476a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f501476a.endTransaction();
        return r109;
    L14:
        th = move-exception;
        this.f501476a.endTransaction();
        throw th;
    }

    @Override // k25.n0
    public final List<String> e(List<String> r100, String r101) {
        StringBuilder r102 = StringUtil.newStringBuilder();
        r102.append("SELECT distinct obj_token FROM ResourceData WHERE obj_token IN (");
        ArrayList r103 = (ArrayList) r100;
        int r104 = r103.size();
        StringUtil.appendPlaceholders(r102, r104);
        r102.append(") AND reskey = ");
        r102.append("?");
        int r105 = 1;
        int r106 = r104 + 1;
        RoomSQLiteQuery r107 = RoomSQLiteQuery.acquire(r102.toString(), r106);
        Iterator r108 = r103.iterator();
    L4:
        if (r108.hasNext() == false) goto L10;
        String r109 = (String) r108.next();
        if (r109 != null) goto L8;
        r107.bindNull(r105);
    L9:
        r105 = r105 + 1;
        goto L4
    L8:
        r107.bindString(r105, r109);
        goto L9
    L10:
        if (r101 != null) goto L12;
        r107.bindNull(r106);
    L13:
        this.f501476a.assertNotSuspendingTransaction();
        Cursor r110 = DBUtil.query(this.f501476a, r107, false, null);
        ArrayList r111 = new ArrayList(r110.getCount());     // Catch: Throwable -> L21
    L16:
        if (r110.moveToNext() == false) goto L19;
        r111.add(r110.getString(0));     // Catch: Throwable -> L21
        goto L16
    L19:
        r110.close();
        r107.release();
        return r111;
    L21:
        th = move-exception;
        r110.close();
        r107.release();
        throw th;
    L12:
        r107.bindString(r106, r101);
        goto L13
    }

    @Override // k25.n0
    public final m0 j(String r210, String r211) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM ResourceData WHERE obj_token=? and category= ? and page = ?", 3);
        if (r211 != null) goto L5;
        r100.bindNull(1);
    L7:
        if (r210 != null) goto L9;
        r100.bindNull(2);
    L10:
        r100.bindLong(3, 0);
        this.f501476a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f501476a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L34
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RES_KEY);     // Catch: Throwable -> L34
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RESOURCE_VALUE);     // Catch: Throwable -> L34
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L34
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "update_time");     // Catch: Throwable -> L34
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L34
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "isNeedSync");     // Catch: Throwable -> L34
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "config");     // Catch: Throwable -> L34
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L34
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "token");     // Catch: Throwable -> L34
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L34
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "userToken");     // Catch: Throwable -> L34
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "tenantID");     // Catch: Throwable -> L34
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "url");     // Catch: Throwable -> L34
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_SUBBLOCK_PRELOAD_STATUS);     // Catch: Throwable -> L32
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "page");     // Catch: Throwable -> L32
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_TOTAL_PAGE);     // Catch: Throwable -> L32
        int r120 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_BATCH_NUM);     // Catch: Throwable -> L32
        int r121 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_LOAD_FROM);     // Catch: Throwable -> L32
        int r122 = CursorUtil.getColumnIndexOrThrow(r101, "category");     // Catch: Throwable -> L32
        if (r101.moveToFirst() == false) goto L29;
        m0 r123 = new m0();     // Catch: Throwable -> L32
        r123.f501540a = r101.getInt(r102);     // Catch: Throwable -> L32
        r123.f501541b = r101.getString(r103);     // Catch: Throwable -> L32
        r123.f501542c = r101.getString(r104);     // Catch: Throwable -> L32
        r123.f501543d = r101.getString(r105);     // Catch: Throwable -> L32
        if (r101.isNull(r110) == false) goto L18;
        Long r124 = null;
    L19:
        r123.f501544e = r124;     // Catch: Throwable -> L32
        if (r101.isNull(r111) == false) goto L22;
        Long r125 = null;
    L23:
        r123.f501545f = r125;     // Catch: Throwable -> L32
        if (r101.getInt(r112) == 0) goto L26;
        boolean r126 = true;
    L27:
        r123.f501546g = r126;     // Catch: Throwable -> L32
        r123.f501547h = r101.getString(r113);     // Catch: Throwable -> L32
        r123.f501548i = r101.getString(r114);     // Catch: Throwable -> L32
        r123.f501549j = r101.getString(r115);     // Catch: Throwable -> L32
        r123.f501550k = r101.getString(r106);     // Catch: Throwable -> L32
        r123.f501551l = r101.getString(r107);     // Catch: Throwable -> L32
        r123.f501552m = r101.getString(r108);     // Catch: Throwable -> L32
        r123.f501553n = r101.getString(r109);     // Catch: Throwable -> L32
        r123.f501554o = r101.getInt(r117);     // Catch: Throwable -> L32
        r123.f501555p = r101.getInt(r118);     // Catch: Throwable -> L32
        r123.f501556q = r101.getInt(r119);     // Catch: Throwable -> L32
        r123.f501557r = r101.getString(r120);     // Catch: Throwable -> L32
        r123.f501558s = r101.getString(r121);     // Catch: Throwable -> L32
        r123.f501559t = r101.getString(r122);     // Catch: Throwable -> L32
        m0 r127 = r123;
    L30:
        r101.close();
        r116.release();
        return r127;
    L26:
        r126 = false;
        goto L27
    L22:
        r125 = Long.valueOf(r101.getLong(r111));     // Catch: Throwable -> L32
        goto L23
    L18:
        r124 = Long.valueOf(r101.getLong(r110));     // Catch: Throwable -> L32
        goto L19
    L29:
        r127 = null;
    L32:
        th = th;
    L36:
        r101.close();
        r116.release();
        throw th;
    L34:
        th = th;
        r116 = r100;
        goto L36
    L9:
        r100.bindString(2, r210);
        goto L10
    L5:
        r100.bindString(1, r211);
        goto L7
    }

    @Override // k25.n0
    public final List<c1> k(String r100, long r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT resvalue_filepath,id FROM ResourceData WHERE obj_token= ? AND (category IS NULL OR (category IS NOT NULL AND access_time<= ?))", 2);
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        r102.bindLong(2, r101);
        this.f501476a.assertNotSuspendingTransaction();
        Cursor r103 = DBUtil.query(this.f501476a, r102, false, null);
        int r104 = CursorUtil.getColumnIndexOrThrow(r103, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L14
        int r105 = CursorUtil.getColumnIndexOrThrow(r103, "id");     // Catch: Throwable -> L14
        ArrayList r106 = new ArrayList(r103.getCount());     // Catch: Throwable -> L14
    L9:
        if (r103.moveToNext() == false) goto L12;
        c1 r107 = new c1();     // Catch: Throwable -> L14
        r107.f501485a = r103.getString(r104);     // Catch: Throwable -> L14
        r107.f501490f = r103.getInt(r105);     // Catch: Throwable -> L14
        r106.add(r107);     // Catch: Throwable -> L14
        goto L9
    L12:
        r103.close();
        r102.release();
        return r106;
    L14:
        th = move-exception;
        r103.close();
        r102.release();
        throw th;
    L5:
        r102.bindString(1, r100);
        goto L6
    }

    @Override // k25.n0
    public final List m(long r100, List r110) {
        StringBuilder r101 = StringUtil.newStringBuilder();
        r101.append("SELECT obj_token,resvalue_filepath,id,access_time FROM ResourceData WHERE access_time<= ");
        r101.append("?");
        r101.append(" AND obj_token NOT IN(");
        int r102 = r110.size();
        StringUtil.appendPlaceholders(r101, r102);
        r101.append(") limit ");
        r101.append("?");
        int r103 = 2;
        int r104 = r102 + 2;
        RoomSQLiteQuery r105 = RoomSQLiteQuery.acquire(r101.toString(), r104);
        r105.bindLong(1, r100);
        Iterator r106 = r110.iterator();
    L4:
        if (r106.hasNext() == false) goto L10;
        String r111 = (String) r106.next();
        if (r111 != null) goto L8;
        r105.bindNull(r103);
    L9:
        r103 = r103 + 1;
        goto L4
    L8:
        r105.bindString(r103, r111);
        goto L9
    L10:
        r105.bindLong(r104, 999);
        this.f501476a.assertNotSuspendingTransaction();
        Cursor r107 = DBUtil.query(this.f501476a, r105, false, null);
        int r112 = CursorUtil.getColumnIndexOrThrow(r107, "obj_token");     // Catch: Throwable -> L22
        int r108 = CursorUtil.getColumnIndexOrThrow(r107, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L22
        int r109 = CursorUtil.getColumnIndexOrThrow(r107, "id");     // Catch: Throwable -> L22
        int r113 = CursorUtil.getColumnIndexOrThrow(r107, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L22
        ArrayList r114 = new ArrayList(r107.getCount());     // Catch: Throwable -> L22
    L12:
        if (r107.moveToNext() == false) goto L20;
        c1 r115 = new c1();     // Catch: Throwable -> L22
        r115.f501487c = r107.getString(r112);     // Catch: Throwable -> L22
        r115.f501485a = r107.getString(r108);     // Catch: Throwable -> L22
        r115.f501490f = r107.getInt(r109);     // Catch: Throwable -> L22
        if (r107.isNull(r113) == false) goto L17;
        Long r116 = null;
    L18:
        r115.f501491g = r116;     // Catch: Throwable -> L22
        r114.add(r115);     // Catch: Throwable -> L22
        goto L12
    L17:
        r116 = Long.valueOf(r107.getLong(r113));     // Catch: Throwable -> L22
        goto L18
    L20:
        r107.close();
        r105.release();
        return r114;
    L22:
        th = move-exception;
        r107.close();
        r105.release();
        throw th;
    }

    @Override // k25.n0
    public final int p(String r100, int r101) {
        this.f501476a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.f501479d.acquire();
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        r102.bindString(2, "sheet_tab_ssr");
        if (r100 != null) goto L9;
        r102.bindNull(3);
    L10:
        r102.bindString(4, "sheet_tab_ssr");
        r102.bindLong(5, r101);
        this.f501476a.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L14
        this.f501476a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f501476a.endTransaction();
        this.f501479d.release(r102);
        return r103;
    L14:
        th = move-exception;
        this.f501476a.endTransaction();
        this.f501479d.release(r102);
        throw th;
    L9:
        r102.bindString(3, r100);
        goto L10
    L5:
        r102.bindString(1, r100);
        goto L6
    }

    @Override // k25.n0
    public final int a(String r100, String r101, long r102) {
        this.f501476a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r103 = this.f501481f.acquire();
        if (r100 != null) goto L5;
        r103.bindNull(1);
    L7:
        if (r101 != null) goto L9;
        r103.bindNull(2);
    L10:
        r103.bindLong(3, r102);
        this.f501476a.beginTransaction();
        int r104 = r103.executeUpdateDelete();     // Catch: Throwable -> L14
        this.f501476a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f501476a.endTransaction();
        this.f501481f.release(r103);
        return r104;
    L14:
        th = move-exception;
        this.f501476a.endTransaction();
        this.f501481f.release(r103);
        throw th;
    L9:
        r103.bindString(2, r101);
        goto L10
    L5:
        r103.bindString(1, r100);
        goto L7
    }

    @Override // k25.n0
    public final m0 i(String r210, String r211, int r212) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM ResourceData WHERE obj_token=? and reskey= ? and page = ?", 3);
        if (r210 != null) goto L5;
        r100.bindNull(1);
    L7:
        if (r211 != null) goto L9;
        r100.bindNull(2);
    L10:
        r100.bindLong(3, r212);
        this.f501476a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f501476a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L34
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RES_KEY);     // Catch: Throwable -> L34
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RESOURCE_VALUE);     // Catch: Throwable -> L34
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L34
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "update_time");     // Catch: Throwable -> L34
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L34
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "isNeedSync");     // Catch: Throwable -> L34
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "config");     // Catch: Throwable -> L34
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L34
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "token");     // Catch: Throwable -> L34
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L34
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "userToken");     // Catch: Throwable -> L34
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "tenantID");     // Catch: Throwable -> L34
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "url");     // Catch: Throwable -> L34
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_SUBBLOCK_PRELOAD_STATUS);     // Catch: Throwable -> L32
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "page");     // Catch: Throwable -> L32
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_TOTAL_PAGE);     // Catch: Throwable -> L32
        int r120 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_BATCH_NUM);     // Catch: Throwable -> L32
        int r121 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_LOAD_FROM);     // Catch: Throwable -> L32
        int r122 = CursorUtil.getColumnIndexOrThrow(r101, "category");     // Catch: Throwable -> L32
        if (r101.moveToFirst() == false) goto L29;
        m0 r123 = new m0();     // Catch: Throwable -> L32
        r123.f501540a = r101.getInt(r102);     // Catch: Throwable -> L32
        r123.f501541b = r101.getString(r103);     // Catch: Throwable -> L32
        r123.f501542c = r101.getString(r104);     // Catch: Throwable -> L32
        r123.f501543d = r101.getString(r105);     // Catch: Throwable -> L32
        if (r101.isNull(r110) == false) goto L18;
        Long r124 = null;
    L19:
        r123.f501544e = r124;     // Catch: Throwable -> L32
        if (r101.isNull(r111) == false) goto L22;
        Long r125 = null;
    L23:
        r123.f501545f = r125;     // Catch: Throwable -> L32
        if (r101.getInt(r112) == 0) goto L26;
        boolean r126 = true;
    L27:
        r123.f501546g = r126;     // Catch: Throwable -> L32
        r123.f501547h = r101.getString(r113);     // Catch: Throwable -> L32
        r123.f501548i = r101.getString(r114);     // Catch: Throwable -> L32
        r123.f501549j = r101.getString(r115);     // Catch: Throwable -> L32
        r123.f501550k = r101.getString(r106);     // Catch: Throwable -> L32
        r123.f501551l = r101.getString(r107);     // Catch: Throwable -> L32
        r123.f501552m = r101.getString(r108);     // Catch: Throwable -> L32
        r123.f501553n = r101.getString(r109);     // Catch: Throwable -> L32
        r123.f501554o = r101.getInt(r117);     // Catch: Throwable -> L32
        r123.f501555p = r101.getInt(r118);     // Catch: Throwable -> L32
        r123.f501556q = r101.getInt(r119);     // Catch: Throwable -> L32
        r123.f501557r = r101.getString(r120);     // Catch: Throwable -> L32
        r123.f501558s = r101.getString(r121);     // Catch: Throwable -> L32
        r123.f501559t = r101.getString(r122);     // Catch: Throwable -> L32
        m0 r127 = r123;
    L30:
        r101.close();
        r116.release();
        return r127;
    L26:
        r126 = false;
        goto L27
    L22:
        r125 = Long.valueOf(r101.getLong(r111));     // Catch: Throwable -> L32
        goto L23
    L18:
        r124 = Long.valueOf(r101.getLong(r110));     // Catch: Throwable -> L32
        goto L19
    L29:
        r127 = null;
    L32:
        th = th;
    L36:
        r101.close();
        r116.release();
        throw th;
    L34:
        th = th;
        r116 = r100;
        goto L36
    L9:
        r100.bindString(2, r211);
        goto L10
    L5:
        r100.bindString(1, r210);
        goto L7
    }

    @Override // k25.n0
    public final f1 n(String r100, String r101, int r102) {
        RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire("SELECT id,subblock_preload_status,page,total_page,resvalue_filepath FROM ResourceData WHERE obj_token = ? AND reskey = ? AND page = ?", 3);
        if (r101 != null) goto L5;
        r103.bindNull(1);
    L7:
        if (r100 != null) goto L9;
        r103.bindNull(2);
    L10:
        r103.bindLong(3, r102);
        this.f501476a.assertNotSuspendingTransaction();
        f1 r104 = null;
        Cursor r105 = DBUtil.query(this.f501476a, r103, false, null);
        int r106 = CursorUtil.getColumnIndexOrThrow(r105, "id");     // Catch: Throwable -> L16
        int r107 = CursorUtil.getColumnIndexOrThrow(r105, ResourceData.KEY_SUBBLOCK_PRELOAD_STATUS);     // Catch: Throwable -> L16
        int r108 = CursorUtil.getColumnIndexOrThrow(r105, "page");     // Catch: Throwable -> L16
        int r109 = CursorUtil.getColumnIndexOrThrow(r105, ResourceData.KEY_TOTAL_PAGE);     // Catch: Throwable -> L16
        if (r105.moveToFirst() == false) goto L14;
        r104 = new f1();     // Catch: Throwable -> L16
        r104.f501525a = r105.getInt(r106);     // Catch: Throwable -> L16
        r104.f501526b = r105.getInt(r107);     // Catch: Throwable -> L16
        r104.f501527c = r105.getInt(r108);     // Catch: Throwable -> L16
        r104.f501528d = r105.getInt(r109);     // Catch: Throwable -> L16
    L14:
        r105.close();
        r103.release();
        return r104;
    L16:
        th = move-exception;
        r105.close();
        r103.release();
        throw th;
    L9:
        r103.bindString(2, r100);
        goto L10
    L5:
        r103.bindString(1, r101);
        goto L7
    }

    @Override // k25.n0
    public final int q(String r100, String r101, List<Integer> r102) {
        this.f501476a.assertNotSuspendingTransaction();
        StringBuilder r103 = StringUtil.newStringBuilder();
        r103.append("UPDATE ResourceData SET obj_token = ");
        r103.append("?");
        r103.append(", token = ");
        r103.append("?");
        r103.append(" WHERE id in (");
        StringUtil.appendPlaceholders(r103, r102.size());
        r103.append(")");
        SupportSQLiteStatement r104 = this.f501476a.compileStatement(r103.toString());
        if (r100 != null) goto L5;
        r104.bindNull(1);
    L7:
        if (r101 != null) goto L9;
        r104.bindNull(2);
    L10:
        Iterator<Integer> r105 = r102.iterator();
        int r106 = 3;
    L12:
        if (r105.hasNext() == false) goto L18;
        Integer r107 = r105.next();
        if (r107 != null) goto L16;
        r104.bindNull(r106);
    L17:
        r106 = r106 + 1;
        goto L12
    L16:
        r104.bindLong(r106, r107.intValue());
        goto L17
    L18:
        this.f501476a.beginTransaction();
        int r108 = r104.executeUpdateDelete();     // Catch: Throwable -> L22
        this.f501476a.setTransactionSuccessful();     // Catch: Throwable -> L22
        this.f501476a.endTransaction();
        return r108;
    L22:
        th = move-exception;
        this.f501476a.endTransaction();
        throw th;
    L9:
        r104.bindString(2, r101);
        goto L10
    L5:
        r104.bindString(1, r100);
        goto L7
    }

    @Override // k25.n0
    public final List<String> g(int r100, String r101, String r102, long r103, int r104) {
        RoomSQLiteQuery r105 = RoomSQLiteQuery.acquire("SELECT A.obj_token FROM (SELECT DISTINCT obj_token FROM ResourceData WHERE reskey = ? AND type IS NOT 'doc' AND update_time>= ? order by update_time desc limit ?) AS A LEFT OUTER JOIN (SELECT DISTINCT obj_token FROM ResourceData WHERE reskey = ? AND resvalue IS NOT NULL) AS B on A.obj_token = B.obj_token WHERE B.obj_token IS NULL limit ?", 5);
        if (r101 != null) goto L5;
        r105.bindNull(1);
    L6:
        r105.bindLong(2, r103);
        r105.bindLong(3, r100);
        if (r102 != null) goto L9;
        r105.bindNull(4);
    L10:
        r105.bindLong(5, r104);
        this.f501476a.assertNotSuspendingTransaction();
        Cursor r106 = DBUtil.query(this.f501476a, r105, false, null);
        ArrayList r107 = new ArrayList(r106.getCount());     // Catch: Throwable -> L18
    L13:
        if (r106.moveToNext() == false) goto L16;
        r107.add(r106.getString(0));     // Catch: Throwable -> L18
        goto L13
    L16:
        r106.close();
        r105.release();
        return r107;
    L18:
        th = move-exception;
        r106.close();
        r105.release();
        throw th;
    L9:
        r105.bindString(4, r102);
        goto L10
    L5:
        r105.bindString(1, r101);
        goto L6
    }
}
