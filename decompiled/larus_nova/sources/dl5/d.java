package dl5;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.ee.bear.operation.database.OperationDatabase;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f469124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f469125b;

    public final List b() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM OperationData info WHERE (info.module_token) in (select module_token from OperationData limit 1) LIMIT ?", 1);
        r100.bindLong(1, 100);
        this.f469124a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f469124a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, DBDefinition.ID);     // Catch: Throwable -> L14
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, com.bytedance.android.ec.core.event.a.KEY_MODULE_TYPE);     // Catch: Throwable -> L14
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "module_token");     // Catch: Throwable -> L14
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "operator_id");     // Catch: Throwable -> L14
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "operation_name");     // Catch: Throwable -> L14
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "operation_scene");     // Catch: Throwable -> L14
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "operation_time");     // Catch: Throwable -> L14
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "extra");     // Catch: Throwable -> L14
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, ST.UUID_DEVICE);     // Catch: Throwable -> L14
        ArrayList r113 = new ArrayList(r101.getCount());     // Catch: Throwable -> L14
    L4:
        if (r101.moveToNext() == false) goto L12;
        a r114 = new a();     // Catch: Throwable -> L14
        r114.f469115a = r101.getInt(r102);     // Catch: Throwable -> L14
        r114.f469116b = r101.getInt(r103);     // Catch: Throwable -> L14
        r114.f469117c = r101.getString(r104);     // Catch: Throwable -> L14
        r114.f469118d = r101.getString(r105);     // Catch: Throwable -> L14
        r114.f469119e = r101.getString(r106);     // Catch: Throwable -> L14
        r114.f469120f = r101.getInt(r107);     // Catch: Throwable -> L14
        if (r101.isNull(r110) == false) goto L9;
        Long r115 = null;
    L10:
        r114.f469121g = r115;     // Catch: Throwable -> L14
        r114.f469122h = r101.getString(r111);     // Catch: Throwable -> L14
        r114.f469123i = r101.getString(r112);     // Catch: Throwable -> L14
        r113.add(r114);     // Catch: Throwable -> L14
        goto L4
    L9:
        r115 = Long.valueOf(r101.getLong(r110));     // Catch: Throwable -> L14
        goto L10
    L12:
        r101.close();
        r100.release();
        return r113;
    L14:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    }

    public d(OperationDatabase r100) {
        this.f469124a = r100;
        this.f469125b = new c(r100);
    }

    public final int a(List<Integer> r100) {
        this.f469124a.assertNotSuspendingTransaction();
        StringBuilder r101 = StringUtil.newStringBuilder();
        r101.append("DELETE FROM OperationData WHERE _id IN (");
        ArrayList r102 = (ArrayList) r100;
        StringUtil.appendPlaceholders(r101, r102.size());
        r101.append(")");
        SupportSQLiteStatement r103 = this.f469124a.compileStatement(r101.toString());
        Iterator r104 = r102.iterator();
        int r105 = 1;
    L4:
        if (r104.hasNext() == false) goto L10;
        Integer r106 = (Integer) r104.next();
        if (r106 != null) goto L8;
        r103.bindNull(r105);
    L9:
        r105 = r105 + 1;
        goto L4
    L8:
        r103.bindLong(r105, r106.intValue());
        goto L9
    L10:
        this.f469124a.beginTransaction();
        int r107 = r103.executeUpdateDelete();     // Catch: Throwable -> L14
        this.f469124a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f469124a.endTransaction();
        return r107;
    L14:
        th = move-exception;
        this.f469124a.endTransaction();
        throw th;
    }

    public final List c(String r110) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM OperationData info WHERE (info.module_token) = ? LIMIT ?", 2);
        if (r110 != null) goto L5;
        r100.bindNull(1);
    L6:
        r100.bindLong(2, 100);
        this.f469124a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f469124a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, DBDefinition.ID);     // Catch: Throwable -> L18
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, com.bytedance.android.ec.core.event.a.KEY_MODULE_TYPE);     // Catch: Throwable -> L18
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "module_token");     // Catch: Throwable -> L18
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "operator_id");     // Catch: Throwable -> L18
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "operation_name");     // Catch: Throwable -> L18
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "operation_scene");     // Catch: Throwable -> L18
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "operation_time");     // Catch: Throwable -> L18
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "extra");     // Catch: Throwable -> L18
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, ST.UUID_DEVICE);     // Catch: Throwable -> L18
        ArrayList r114 = new ArrayList(r101.getCount());     // Catch: Throwable -> L18
    L8:
        if (r101.moveToNext() == false) goto L16;
        a r115 = new a();     // Catch: Throwable -> L18
        r115.f469115a = r101.getInt(r102);     // Catch: Throwable -> L18
        r115.f469116b = r101.getInt(r103);     // Catch: Throwable -> L18
        r115.f469117c = r101.getString(r104);     // Catch: Throwable -> L18
        r115.f469118d = r101.getString(r105);     // Catch: Throwable -> L18
        r115.f469119e = r101.getString(r106);     // Catch: Throwable -> L18
        r115.f469120f = r101.getInt(r107);     // Catch: Throwable -> L18
        if (r101.isNull(r111) == false) goto L13;
        Long r116 = null;
    L14:
        r115.f469121g = r116;     // Catch: Throwable -> L18
        r115.f469122h = r101.getString(r112);     // Catch: Throwable -> L18
        r115.f469123i = r101.getString(r113);     // Catch: Throwable -> L18
        r114.add(r115);     // Catch: Throwable -> L18
        goto L8
    L13:
        r116 = Long.valueOf(r101.getLong(r111));     // Catch: Throwable -> L18
        goto L14
    L16:
        r101.close();
        r100.release();
        return r114;
    L18:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    L5:
        r100.bindString(1, r110);
        goto L6
    }
}
