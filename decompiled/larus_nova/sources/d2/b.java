package d2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends SQLiteOpenHelper {
    public b(Context r100) {
        super(r100, "policy.db", null, 1);
    }

    public void delete(String r100) {
        getWritableDatabase().delete("policies", "app_id=?", new String[]{r100});     // Catch: Exception -> L5
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        r100.execSQL("CREATE TABLE policies (app_id TEXT PRIMARY KEY, content TEXT, version INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        r100.execSQL("DROP TABLE IF EXISTS policies");
        r100.execSQL("CREATE TABLE policies (app_id TEXT PRIMARY KEY, content TEXT, version INTEGER)");
    }
}
