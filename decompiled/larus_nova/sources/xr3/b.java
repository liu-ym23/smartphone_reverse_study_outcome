package xr3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.apm.d;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends SQLiteOpenHelper {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        r100.execSQL("CREATE TABLE t_battery ( _id INTEGER PRIMARY KEY AUTOINCREMENT, version_id Integer, front Integer, timestamp Integer, type TEXT, status Integer, scene TEXT, accumulation Integer, source TEXT, delete_flag Integer DEFAULT 0, process TEXT, main_process Integer, sid TEXT, extra1 TEXT, extra2 TEXT, extra3 TEXT, extra4 TEXT  )");     // Catch: Exception -> L4
        return;
    }

    public b(Context r100, String r101) {
        super(r100, r101, null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        if (d.j() == false) goto L6;
        av3.b.a("DBHelper", "Updating table from " + r101 + " to " + r102);
    L6:
        if (r101 >= 2) goto L12;
        r100.execSQL("DROP TABLE IF EXISTS local_monitor_log");     // Catch: Exception -> L9
        r100.execSQL("DROP TABLE IF EXISTS t_apiall");     // Catch: Exception -> L9
        r100.execSQL("DROP TABLE IF EXISTS local_monitor_version");     // Catch: Exception -> L9
        return;
    L13:
        return;
    }
}
