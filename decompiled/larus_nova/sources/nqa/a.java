package nqa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.push.utils.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f520147b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f520148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f520149d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f520150a;

    /* JADX INFO: renamed from: nqa.a$a, reason: collision with other inner class name */
    public static class C6962a extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        }

        public C6962a(Context r100) {
            super(r100, "alive_monitor.db", null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE process_start_info ( _id INTEGER PRIMARY KEY AUTOINCREMENT, data_json TEXT, end_time INTEGER )");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            f.e("MonitorLiveDBHelper", "create db exception " + th);
        }
    }

    public final synchronized b b() {
        monitor-enter(this);
        Cursor r100 = this.f520150a.query("process_start_info", f520147b, null, null, null, null, "_id DESC", "1");     // Catch: Throwable -> L14
    L12:
        Throwable th10 = th;
    L26:
        th10.printStackTrace();     // Catch: Throwable -> L20
    L17:
        d(r100);     // Catch: Throwable -> L23
        monitor-exit(this);
        return null;
    L20:
        th = move-exception;
        d(r100);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L7:
        if (r100.moveToNext() == false) goto L17;
        b r101 = new b();     // Catch: Throwable -> L12
        r101.f520151a = r100.getLong(0);     // Catch: Throwable -> L12
        r101.f520152b = r100.getString(1);     // Catch: Throwable -> L12
        r101.f520153c = r100.getLong(2);     // Catch: Throwable -> L12
        d(r100);     // Catch: Throwable -> L23
        monitor-exit(this);
        return r101;
    L23:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        th10 = th;
        r100 = null;
        goto L26
    }

    static {
        f520147b = new String[]{DBDefinition.ID, "data_json", "end_time"};
        f520149d = new Object();
    }

    public a(Context r100) {
        this.f520150a = new C6962a(r100).getWritableDatabase();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        f.f("MonitorLiveDBHelper", "error when init com.bytedance.alliance.helper.DatabaseHelper.DatabaseHelper ", th);
        s67.b.a(th, "error when init com.bytedance.alliance.helper.DatabaseHelper.DatabaseHelper");
    }

    public static a a(Context r100) {
        Object r101 = f520149d;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f520148c != null) goto L7;
        f520148c = new a(r100);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return f520148c;
    }

    public static void d(Cursor r100) {
        if (r100 == null) goto L10;
        if (r100.isClosed() == true) goto L11;
        r100.close();     // Catch: Throwable -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public final synchronized void c(b r100) {
        monitor-enter(this);
        SQLiteDatabase r101 = this.f520150a;     // Catch: Throwable -> L15
        if (r101 != null) goto L7;
    L12:
        f.b("MonitorLiveDBHelper", "db not establish and open");     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L7:
        if (r101.isOpen() == false) goto L12;
        f.b("MonitorLiveDBHelper", "insert = " + r100);     // Catch: Throwable -> L15
        ContentValues r102 = new ContentValues();     // Catch: Throwable -> L15
        r102.put("data_json", r100.f520152b);     // Catch: Throwable -> L15
        r102.put("end_time", Long.valueOf(r100.f520153c));     // Catch: Throwable -> L15
        this.f520150a.insert("process_start_info", null, r102);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean e(b r100) {
        monitor-enter(this);
        SQLiteDatabase r101 = this.f520150a;     // Catch: Throwable -> L24
        boolean r102 = false;
        if (r101 != null) goto L7;
    L21:
        f.b("MonitorLiveDBHelper", "db not establish and open");     // Catch: Throwable -> L24
        monitor-exit(this);
        return false;
    L7:
        if (r101.isOpen() == false) goto L21;
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L24
        return false;
    L10:
        if (f.f267065a == false) goto L12;
        f.b("MonitorLiveDBHelper", "updateProcessStartDbInfo processStartDbInfo = " + r100);     // Catch: Throwable -> L17
    L12:
        ContentValues r103 = new ContentValues();     // Catch: Throwable -> L17
        r103.put("data_json", r100.f520152b);     // Catch: Throwable -> L17
        r103.put("end_time", Long.valueOf(r100.f520153c));     // Catch: Throwable -> L17
        if (this.f520150a.update("process_start_info", r103, "_id = ?", new String[]{String.valueOf(r100.f520151a)}) <= 0) goto L15;
        r102 = true;
    L15:
        monitor-exit(this);
        return r102;
    L24:
        th = move-exception;
        throw th;
    }
}
