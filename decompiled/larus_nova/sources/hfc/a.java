package hfc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.push.utils.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f484988b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f484989c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f484990d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f484991a;

    /* JADX INFO: renamed from: hfc.a$a, reason: collision with other inner class name */
    public static class C6141a extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        }

        public C6141a(Context r100) {
            super(r100, "ss_push_log.db", null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE event ( _id INTEGER PRIMARY KEY AUTOINCREMENT, category VARCHAR, tag VARCHAR, label VARCHAR, value INTEGER, ext_value INTEGER, ext_json TEXT )");     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            f.e("PushLog", "create db exception " + e);
        }
    }

    static {
        f484988b = new String[]{DBDefinition.ID, "category", "tag", "label", "value", "ext_value", "ext_json"};
        f484989c = new Object();
    }

    public a(Context r100) {
        this.f484991a = new C6141a(r100).getWritableDatabase();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        f.d("error when init DatabaseHelper:" + th.getLocalizedMessage());
        s67.b.a(th, "error when init com.ss.android.message.log.DBHelper.DBHelper");
    }

    public static a c(Context r100) {
        Object r101 = f484989c;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f484990d != null) goto L7;
        f484990d = new a(r100.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return f484990d;
    }

    public final synchronized void a(long r100) {
        monitor-enter(this);
        SQLiteDatabase r101 = this.f484991a;     // Catch: Throwable -> L14
        if (r101 != null) goto L6;
    L11:
        f.b("PushLog", "db not establish and open");     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L6:
        if (r101.isOpen() == false) goto L11;
        this.f484991a.delete("event", "_id = ?", new String[]{String.valueOf(r100)});     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized JSONArray b(long r210) {
        monitor-enter(this);
        int r100 = 1;
        int r110 = 0;
        String[] r101 = {String.valueOf(r210)};     // Catch: Throwable -> L86
        JSONArray r111 = new JSONArray();     // Catch: Throwable -> L86
        Cursor r102 = this.f484991a.query("event", f484988b, "_id > ? ", r101, null, null, "_id ASC", "5");     // Catch: Throwable -> L63
        int r103 = 0;
        long r104 = 0;
    L101:
    L60:
        th = th;
        JSONArray r105 = r111;
    L62:
        int r112 = r103;
    L97:
        th.printStackTrace();     // Catch: Throwable -> L79
        if (r102 != null) goto L90;
    L72:
        r103 = r112;
    L73:
        if (r103 <= 0) goto L76;
        monitor-exit(this);
        return r105;
    L76:
        monitor-exit(this);
        return null;
    L90:
        if (r102.isClosed() == true) goto L72;
        r102.close();     // Catch: Exception -> L71 Throwable -> L86
        goto L72
    L79:
        th = move-exception;
        if (r102 == null) goto L110;
        if (r102.isClosed() == true) goto L111;
        r102.close();     // Catch: Exception -> L89 Throwable -> L86
        throw th;     // Catch: Throwable -> L86
    L111:
        throw th;     // Catch: Throwable -> L86
    L112:
        throw th;     // Catch: Throwable -> L86
    L110:
        throw th;     // Catch: Throwable -> L86
    L8:
        if (r102.moveToNext() == false) goto L54;
        long r106 = r102.getLong(r110);     // Catch: Throwable -> L60
        String r113 = r102.getString(r100);     // Catch: Throwable -> L60
        String r114 = r102.getString(2);     // Catch: Throwable -> L60
        if (r102.isNull(3) == false) goto L99;
        String r115 = null;
    L17:
        if (r102.isNull(4) == false) goto L20;
        long r116 = 0;
    L95:
        if (r102.isNull(5) == true) goto L27;
        long r117 = r102.getLong(5);     // Catch: Throwable -> L52
    L29:
        if (r102.isNull(6) == true) goto L31;
        String r107 = r102.getString(6);     // Catch: Throwable -> L52
    L33:
        if (r104 >= r106) goto L35;
        r104 = r106;
    L35:
        JSONObject r118 = new JSONObject();     // Catch: Throwable -> L52
        r118.put(DBDefinition.ID, r106);     // Catch: Throwable -> L52
        if (StringUtils.isEmpty(r107) == true) goto L38;
        r118.put("ext_json", r107);     // Catch: Throwable -> L52
    L38:
        r118.put("category", r113);     // Catch: Throwable -> L52
        r118.put("tag", r114);     // Catch: Throwable -> L52
        if (StringUtils.isEmpty(r115) == true) goto L42;
        r118.put("label", r115);     // Catch: Throwable -> L52
    L42:
        if (r116 == 0) goto L44;
        r118.put("value", r116);     // Catch: Throwable -> L52
    L44:
        long r108 = r117;
        if (r108 == 0) goto L47;
        r118.put("ext_value", r108);     // Catch: Throwable -> L52
    L47:
        r105 = r111;
        r105.put(r118);     // Catch: Throwable -> L50
        r103 = r103 + 1;
        r111 = r105;
        r100 = 1;
        r110 = 0;
    L50:
        th = th;
        goto L62
    L31:
        r107 = null;
        goto L33
    L27:
        r117 = 0;
    L52:
        th = th;
        r105 = r111;
        goto L62
    L20:
        r116 = r102.getLong(4);     // Catch: Throwable -> L13
        goto L95
    L99:
        r115 = r102.getString(3);     // Catch: Throwable -> L13
    L13:
        th = th;
        r112 = r103;
        r105 = r111;
        goto L97
    L54:
        r105 = r111;
        if (r102.isClosed() == true) goto L73;
        r102.close();     // Catch: Exception -> L59 Throwable -> L86
    L63:
        th = th;
        r105 = r111;
        r102 = null;
        r112 = 0;
    L86:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(b r100) {
        monitor-enter(this);
        SQLiteDatabase r101 = this.f484991a;     // Catch: Throwable -> L20
        if (r101 != null) goto L6;
    L17:
        f.b("PushLog", "db not establish and open");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L6:
        if (r101.isOpen() == false) goto L17;
        ContentValues r102 = new ContentValues();     // Catch: Throwable -> L20
        r102.put("category", r100.f484992a);     // Catch: Throwable -> L20
        r102.put("tag", r100.f484993b);     // Catch: Throwable -> L20
        if (StringUtils.isEmpty(r100.f484994c) == true) goto L11;
        r102.put("label", r100.f484994c);     // Catch: Throwable -> L20
    L11:
        r102.put("value", Long.valueOf(r100.f484995d));     // Catch: Throwable -> L20
        r102.put("ext_value", Long.valueOf(r100.f484996e));     // Catch: Throwable -> L20
        if (StringUtils.isEmpty(r100.f484997f) == true) goto L14;
        r102.put("ext_json", r100.f484997f);     // Catch: Throwable -> L20
    L14:
        this.f484991a.insert("event", null, r102);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }
}
