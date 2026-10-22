package s67;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.push.b0;
import com.bytedance.push.utils.f;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f540829d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static c f540830e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f540831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f540832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f540833c;

    public static class a extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        }

        public a(Context r100) {
            super(r100, "push_message.db", null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE message ( message_id BIGINT PRIMARY KEY, arrive_time BIGINT, client_intelligence_expire_time BIGINT, sender INT,handle_by_sdk INT,has_been_shown INT,push_body TEXT )");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            f.e("MultiProcessPushMessageDatabaseHelper", "create db exception " + th);
        }
    }

    public final synchronized List<b0> c() {
        monitor-enter(this);
        f.b("MultiProcessPushMessageDatabaseHelper", "[getAllMessageNotShown]");     // Catch: Throwable -> L39
        if (com.ss.android.pushmanager.setting.b.b().a() == true) goto L8;
        f.b("MultiProcessPushMessageDatabaseHelper", "[getAllMessageNotShown] do nothing because allowCacheMessageToDb is false");     // Catch: Throwable -> L39
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L39
        monitor-exit(this);
        return r100;
    L8:
        SQLiteDatabase r101 = f();     // Catch: Throwable -> L39
        if (r101 != null) goto L42;
    L32:
        f.i("MultiProcessPushMessageDatabaseHelper", "[addMessageToDb] db not establish and open");     // Catch: Throwable -> L36
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L36
        a();     // Catch: Throwable -> L39
        f.b("MultiProcessPushMessageDatabaseHelper", "[getAllMessageNotShown] finish query,close db");     // Catch: Throwable -> L39
        monitor-exit(this);
        return r102;
    L42:
    L36:
        th = move-exception;
        a();     // Catch: Throwable -> L39
        f.b("MultiProcessPushMessageDatabaseHelper", "[getAllMessageNotShown] finish query,close db");     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L11:
        if (r101.isOpen() == false) goto L32;
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L36
        Cursor r110 = null;
        r110 = r101.query("message", f540829d, "has_been_shown = 0", null, null, null, "arrive_time ASC", null);     // Catch: Throwable -> L23
    L17:
        if (r110.moveToNext() == false) goto L25;
        b0 r104 = new b0(r110);     // Catch: Throwable -> L23
        if (r104.b() == null) goto L17;
        r103.add(r104);     // Catch: Throwable -> L23
    L25:
        g(r110);     // Catch: Throwable -> L36
        f.b("MultiProcessPushMessageDatabaseHelper", "[getAllMessageNotShown] finish query,dbPushBodyArrayList size is " + r103.size());     // Catch: Throwable -> L36
        a();     // Catch: Throwable -> L39
        f.b("MultiProcessPushMessageDatabaseHelper", "[getAllMessageNotShown] finish query,close db");     // Catch: Throwable -> L39
        monitor-exit(this);
        return r103;
    L23:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        g(r110);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L39:
        th = move-exception;
        throw th;
    }

    public final void a() {
        SQLiteDatabase r100 = this.f540831a;     // Catch: Throwable -> L9
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isOpen() == false) goto L15;
        f.b("MultiProcessPushMessageDatabaseHelper", "close db and  unlock file");     // Catch: Throwable -> L9
        this.f540831a.close();     // Catch: Throwable -> L9
        this.f540831a = null;     // Catch: Throwable -> L9
        s67.a.a("push_message_db.lock").d();     // Catch: Throwable -> L9
        f.b("MultiProcessPushMessageDatabaseHelper", "success close db and unlock file");     // Catch: Throwable -> L9
        return;
    L15:
        return;
    L9:
        th = move-exception;
        f.e("MultiProcessPushMessageDatabaseHelper", "error when close db: " + th);
    }

    public final SQLiteDatabase f() {
        if (this.f540831a != null) goto L18;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.f540831a != null) goto L12;
        f.b("MultiProcessPushMessageDatabaseHelper", "lock file for open db");     // Catch: Throwable -> L14
        s67.a.a("push_message_db.lock").b(this.f540833c);     // Catch: Throwable -> L14
        this.f540831a = this.f540832b.getWritableDatabase();     // Catch: Throwable -> L10
        f.b("MultiProcessPushMessageDatabaseHelper", "success lock file and open db");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        f.f("MultiProcessPushMessageDatabaseHelper", "error when open db", th);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
    L18:
        return this.f540831a;
    }

    static {
        f540829d = new String[]{MusicAppletPage.KEY_MESSAGE_ID, "arrive_time", "client_intelligence_expire_time", "sender", "handle_by_sdk", "has_been_shown", "push_body"};
    }

    public c(Context r100) {
        this.f540833c = r100;     // Catch: Throwable -> L5
        this.f540832b = new a(r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        f.d("error when init DatabaseHelper:" + th.getLocalizedMessage());
        b.a(th, "error when init com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper.MultiProcessPushMessageDatabaseHelper");
    }

    public static c d(Context r100) {
        if (f540830e != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f540830e != null) goto L9;
        f540830e = new c(r100.getApplicationContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f540830e;
    }

    public static void g(Cursor r100) {
        if (r100 == null) goto L12;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (r100.isClosed() == true) goto L13;
        r100.close();     // Catch: Exception -> L7
        return;
    L13:
        return;
    }

    public final synchronized boolean b(long r110) {
        monitor-enter(this);
        boolean r100 = false;
        if (com.ss.android.pushmanager.setting.b.b().a() == true) goto L9;
        f.b("MultiProcessPushMessageDatabaseHelper", "[curMessageHasExists] do nothing because allowCacheMessageToDb is false");     // Catch: Throwable -> L34
        monitor-exit(this);
        return false;
    L9:
        f.b("MultiProcessPushMessageDatabaseHelper", "[curMessageHasExists] messageId is " + r110);     // Catch: Throwable -> L34
        SQLiteDatabase r101 = f();     // Catch: Throwable -> L34
        f.b("MultiProcessPushMessageDatabaseHelper", "[curMessageHasExists] success open db");     // Catch: Throwable -> L34
        if (r101 != null) goto L40;
    L27:
        f.i("MultiProcessPushMessageDatabaseHelper", "db not establish and open");     // Catch: Throwable -> L31
        f.b("MultiProcessPushMessageDatabaseHelper", "[curMessageHasExists] finish query, close db");     // Catch: Throwable -> L34
        a();     // Catch: Throwable -> L34
        monitor-exit(this);
        return false;
    L40:
    L31:
        th = move-exception;
        f.b("MultiProcessPushMessageDatabaseHelper", "[curMessageHasExists] finish query, close db");     // Catch: Throwable -> L34
        a();     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L12:
        if (r101.isOpen() == false) goto L27;
        Cursor r102 = null;
        r102 = r101.query("message", f540829d, "message_id = ?", new String[]{String.valueOf(r110)}, null, null, null, null);     // Catch: Throwable -> L18
        if (r102.getCount() < 1) goto L20;
        r100 = true;
    L20:
        g(r102);     // Catch: Throwable -> L31
        f.b("MultiProcessPushMessageDatabaseHelper", "[curMessageHasExists] finish query, close db");     // Catch: Throwable -> L34
        a();     // Catch: Throwable -> L34
        monitor-exit(this);
        return r100;
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        g(r102);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L34:
        th = move-exception;
        throw th;
    }

    public final synchronized long e(long r100) {
        monitor-enter(this);
    L47:
        th = move-exception;
        throw th;
    L5:
        if (com.ss.android.pushmanager.setting.b.b().a() == true) goto L10;
        f.b("MultiProcessPushMessageDatabaseHelper", "[markMessageAsShown] do nothing because allowCacheMessageToDb is false");     // Catch: Throwable -> L47
        monitor-exit(this);
        return 0;
    L10:
        f.b("MultiProcessPushMessageDatabaseHelper", "[markMessageAsShown] messageId is " + r100);     // Catch: Throwable -> L47
        SQLiteDatabase r101 = f();     // Catch: Throwable -> L47
        if (r101 != null) goto L51;
    L34:
        f.i("MultiProcessPushMessageDatabaseHelper", "db not establish and open");     // Catch: Throwable -> L38
        a();     // Catch: Throwable -> L47
        f.b("MultiProcessPushMessageDatabaseHelper", "[markMessageAsShown] finish update,close db");     // Catch: Throwable -> L47
        monitor-exit(this);
        return -1;
    L51:
    L38:
        th = move-exception;
        f.f("MultiProcessPushMessageDatabaseHelper", "[markMessageAsShown] error to update ", th);     // Catch: Throwable -> L44
        a();     // Catch: Throwable -> L47
        String r102 = "MultiProcessPushMessageDatabaseHelper";
    L41:
        f.b(r102, "[markMessageAsShown] finish update,close db");     // Catch: Throwable -> L47
        monitor-exit(this);
        return -1;
    L44:
        th = move-exception;
        a();     // Catch: Throwable -> L47
        f.b("MultiProcessPushMessageDatabaseHelper", "[markMessageAsShown] finish update,close db");     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L14:
        if (r101.isOpen() == false) goto L34;
        ContentValues r103 = new ContentValues();     // Catch: Throwable -> L38
        r103.put("has_been_shown", 1);     // Catch: Throwable -> L38
        String[] r104 = {String.valueOf(r100)};     // Catch: Throwable -> L38
        long r105 = r101.update("message", r103, "message_id = ?", r104);     // Catch: IllegalStateException -> L22 Throwable -> L38
        a();     // Catch: Throwable -> L47
        f.b("MultiProcessPushMessageDatabaseHelper", "[markMessageAsShown] finish update,close db");     // Catch: Throwable -> L47
        monitor-exit(this);
        return r105;
    L22:
        SQLiteDatabase r106 = f();     // Catch: Throwable -> L38
        if (r106 != null) goto L25;
    L31:
        a();     // Catch: Throwable -> L47
        r102 = "MultiProcessPushMessageDatabaseHelper";
        goto L41
    L25:
        if (r106.isOpen() == false) goto L31;
        long r107 = r106.update("message", r103, "message_id = ?", r104);     // Catch: Throwable -> L38
        a();     // Catch: Throwable -> L47
        f.b("MultiProcessPushMessageDatabaseHelper", "[markMessageAsShown] finish update,close db");     // Catch: Throwable -> L47
        return r107;
    }
}
