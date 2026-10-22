package tp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f547024a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f547025b = null;

    static {
        f547024a = Boolean.valueOf(v.a());
        f547025b = new c(jc1.a.b());
    }

    public c(Context r100) {
        super(r100, "VSCacheSQLHelper.db", null, 6);
    }

    public static long insert(ContentValues r100) {
        if (f547024a.booleanValue() == false) goto L9;
        ALogger.e("VSCacheSQLHelper", new RuntimeException("insert"));
    L9:
        return f547025b.getWritableDatabase().insert("VSVideoCache", null, r100);
    L7:
        return -1;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        r100.execSQL("CREATE TABLE IF NOT EXISTS VSVideoCache (_id integer primary key autoincrement, title varchar(256),video_id varchar(256) NOT NULL,download_size long,total_size long,time long,state integer,error_code integer,season_name varchar(256),season_id varchar(256),definition varchar(256),episode_id long,video_key varchar(256),video_duration long,current_period varchar(256),cover_url varchar(256),item_id varchar(256),style integer,position long,vertical_url varchar(256),vertical_width long,vertical_margin_l long,vertical_margin_p long,horizontal_url varchar(256),horizontal_width long,horizontal_margin_l long,horizontal_margin_p long,episode_stage_type integer,download_uid varchar(256))");
    }

    public static int delete(String r100, String[] r101) {
        if (f547024a.booleanValue() == false) goto L9;
        ALogger.e("VSCacheSQLHelper", new RuntimeException("delete"));
    L9:
        return f547025b.getWritableDatabase().delete("VSVideoCache", r100, r101);
    L7:
        return 0;
    }

    public static void a(SQLiteDatabase r100, String r101, String r102) {
        if (f547024a.booleanValue() == false) goto L5;
        ALogger.e("VSCacheSQLHelper", new RuntimeException("checkAndAddColumn"));
    L5:
        Cursor r103 = null;
        boolean r104 = false;
        r103 = r100.rawQuery("SELECT * FROM VSVideoCache LIMIT 0", null);     // Catch: Throwable -> L12
        if (r103 == null) goto L13;
        if (r103.getColumnIndex(r101) == (-1)) goto L13;
        r104 = true;
    L13:
        if (r103 != null) goto L15;
    L21:
        if (r104 == true) goto L26;
        r100.execSQL(r102);
        return;
    L26:
        return;
    L15:
        if (r103.isClosed() == true) goto L21;
    L20:
        r103.close();
    L17:
        if (r103 == null) goto L21;
        if (r103.isClosed() == true) goto L21;
        goto L20
    }

    public static void update(ContentValues r100, String r101, String[] r102) {
        if (f547024a.booleanValue() == false) goto L5;
        ALogger.e("VSCacheSQLHelper", new RuntimeException("update"));
    L5:
        SQLiteDatabase r103 = null;
        r103 = f547025b.getWritableDatabase();     // Catch: Throwable -> L8
        r103.beginTransaction();     // Catch: Throwable -> L8
        r103.update("VSVideoCache", r100, r101, r102);     // Catch: Throwable -> L8
        r103.setTransactionSuccessful();     // Catch: Throwable -> L8
    L10:
        r103.endTransaction();
        return;
    L9:
        if (r103 != null) goto L10;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        if (r101 >= 2) goto L6;
        r100.execSQL("ALTER TABLE VSVideoCache ADD COLUMN item_id varchar(256)");
    L6:
        if (r101 >= 3) goto L9;
        r100.execSQL("ALTER TABLE VSVideoCache ADD COLUMN style integer");
    L9:
        if (r101 >= 4) goto L12;
        a(r100, "position", "ALTER TABLE VSVideoCache ADD COLUMN position long");
        a(r100, "vertical_url", "ALTER TABLE VSVideoCache ADD COLUMN vertical_url varchar(256)");
        a(r100, "vertical_width", "ALTER TABLE VSVideoCache ADD COLUMN vertical_width long");
        a(r100, "vertical_margin_l", "ALTER TABLE VSVideoCache ADD COLUMN vertical_margin_l long");
        a(r100, "vertical_margin_p", "ALTER TABLE VSVideoCache ADD COLUMN vertical_margin_p long");
        a(r100, "horizontal_url", "ALTER TABLE VSVideoCache ADD COLUMN horizontal_url varchar(256)");
        a(r100, "horizontal_width", "ALTER TABLE VSVideoCache ADD COLUMN horizontal_width long");
        a(r100, "horizontal_margin_l", "ALTER TABLE VSVideoCache ADD COLUMN horizontal_margin_l long");
        a(r100, "horizontal_margin_p", "ALTER TABLE VSVideoCache ADD COLUMN horizontal_margin_p long");
    L12:
        if (r101 >= 5) goto L15;
        a(r100, "episode_stage_type", "ALTER TABLE VSVideoCache ADD COLUMN episode_stage_type integer");
    L15:
        if (r101 >= 6) goto L25;
        r100.beginTransaction();
        r100.execSQL("create table VSVideoCache_dg_tmp( _id integer primary key autoincrement, title varchar(256), video_id varchar(256) not null, download_size long, total_size long, time long, state integer, error_code integer, season_name varchar(256), season_id varchar(256), definition varchar(256), episode_id long, video_key varchar(256), video_duration long, current_period varchar(256), cover_url varchar(256), item_id varchar(256), style integer, position long, vertical_url varchar(256), vertical_width long, vertical_margin_l long, vertical_margin_p long, horizontal_url varchar(256), horizontal_width long, horizontal_margin_l long, horizontal_margin_p long, episode_stage_type integer, download_uid varchar(256))");     // Catch: Throwable -> L19
        r100.execSQL("insert into VSVideoCache_dg_tmp( title, video_id, download_size, total_size, time, state, error_code, season_name, season_id, definition, episode_id, video_key, video_duration, current_period, cover_url, item_id, style, position, vertical_url, vertical_width, vertical_margin_l, vertical_margin_p, horizontal_url, horizontal_width, horizontal_margin_l, horizontal_margin_p, episode_stage_type)select  title, video_id, download_size, total_size, time, state, error_code, season_name, season_id, definition, episode_id, video_key, video_duration, current_period, cover_url, item_id, style, position, vertical_url, vertical_width, vertical_margin_l, vertical_margin_p, horizontal_url, horizontal_width, horizontal_margin_l, horizontal_margin_p, episode_stage_type from VSVideoCache");     // Catch: Throwable -> L19
        r100.execSQL("drop table VSVideoCache");     // Catch: Throwable -> L19
        r100.execSQL("alter table VSVideoCache_dg_tmp rename to VSVideoCache");     // Catch: Throwable -> L19
        r100.setTransactionSuccessful();     // Catch: Throwable -> L19
    L21:
        r100.endTransaction();
        return;
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r100.endTransaction();
        throw th;
    }

    public static Cursor query(String[] r100, String r110, String[] r111, String r112, String r113, String r114) {
        if (f547024a.booleanValue() == false) goto L9;
        ALogger.e("VSCacheSQLHelper", new RuntimeException("query"));
    L9:
        return f547025b.getReadableDatabase().query("VSVideoCache", r100, r110, r111, r112, r113, r114);
    L7:
        return null;
    }
}
