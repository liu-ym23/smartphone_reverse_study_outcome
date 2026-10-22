package iwa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ss.android.lark.audit.db.AuditDBData;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements gwa.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public iwa.a f496243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Context f496244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f496245c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f496246a = null;

        static {
            f496246a = new b();
        }
    }

    public b() {
        this.f496245c = false;
    }

    public final synchronized void a(Context r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f496244b != null) goto L6;
    L8:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.f496244b = r100;     // Catch: Throwable -> L15
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L15
        r102.add(gwa.d.class.getSimpleName());     // Catch: Throwable -> L15
        iwa.a r103 = new iwa.a(r100, "audit_sdk", r102);     // Catch: Throwable -> L15
        this.f496243a = r103;     // Catch: Throwable -> L15
        SQLiteDatabase r104 = r103.getWritableDatabase();     // Catch: Throwable -> L15
        this.f496243a.onCreate(r104);     // Catch: Throwable -> L15
        this.f496245c = true;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L6:
        if (this.f496245c == false) goto L8;
        r101 = true;
        goto L9
    }

    @Override // gwa.g.a
    public final void deleteAuditData(String r100, List<AuditDBData> r101) {
        if (this.f496244b != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        Log.i("WsDB", "[delete data]: tableName = " + r100 + " delete count = " + r101.size());
        SQLiteDatabase r103 = this.f496243a.getWritableDatabase();
        StringBuilder r104 = new StringBuilder();
        Iterator<AuditDBData> r105 = r101.iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        r104.append(r105.next().f409449a);
        r104.append(",");
        goto L12
    L14:
        String r106 = r104.toString();
        if (r101.size() <= 0) goto L17;
        r106 = r106.substring(0, r106.length() - 1);
    L17:
        r103.execSQL("delete from " + r100 + " where time in(" + r106 + ")");
        return;
    L5:
        if (this.f496245c == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // gwa.g.a
    public final List<AuditDBData> queryAuditData(String r110, int r111) {
        if (this.f496244b != null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L10;
        Log.i("WsDB", "[query data]: tableName = " + r110 + " query count = " + r111);
        StringBuilder r101 = new StringBuilder();
        r101.append(r111);
        r101.append("");
        Cursor r112 = this.f496243a.getReadableDatabase().query(r110, new String[]{"time", "data"}, null, null, null, null, "time", r101.toString());
        ArrayList r113 = new ArrayList();
    L13:
        if (r112.moveToNext() == false) goto L15;
        r113.add(new AuditDBData(r112.getLong(r112.getColumnIndex("time")), r112.getString(r112.getColumnIndex("data"))));
        goto L13
    L15:
        r112.close();
        return r113;
    L10:
        return new ArrayList();
    L5:
        if (this.f496245c == false) goto L7;
        r100 = true;
        goto L8
    }

    @Override // gwa.g.a
    public final void recordAuditData(String r100, String r110) {
        boolean r101 = true;
        if (this.f496244b != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        Log.i("WsDB", "[insert data]: tableName = " + r100 + " data = " + r110);
        SQLiteDatabase r103 = this.f496243a.getWritableDatabase();
        ContentValues r104 = new ContentValues();
        r104.put("time", Long.valueOf(System.nanoTime()));
        r104.put("data", r110);
        long r105 = r103.insert(r100, null, r104);
        StringBuilder r111 = new StringBuilder();
        r111.append(r100);
        r111.append(" background save record ");
        if (r105 != (-1)) goto L14;
        r101 = false;
    L14:
        r111.append(r101);
        Log.i("WsDB", r111.toString());
        return;
    L5:
        if (this.f496245c == false) goto L7;
        r102 = true;
        goto L8
    }
}
