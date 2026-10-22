package h1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.apm.lite.c;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public final class b extends SQLiteOpenHelper {
    public b(Context r100) {
        super(r100, "npth_log.db", null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L8
        r101.append("CREATE TABLE ");     // Catch: Throwable -> L8
        r101.append("duplicatelog");     // Catch: Throwable -> L8
        r101.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");     // Catch: Throwable -> L8
        HashMap r102 = new HashMap();     // Catch: Throwable -> L8
        r102.put("path", CardAdapter.TEXT);     // Catch: Throwable -> L8
        r102.put("insert_time", "INTEGER");     // Catch: Throwable -> L8
        r102.put("ext1", CardAdapter.TEXT);     // Catch: Throwable -> L8
        r102.put("ext2", CardAdapter.TEXT);     // Catch: Throwable -> L8
        Iterator r103 = r102.keySet().iterator();     // Catch: Throwable -> L8
    L4:
        if (r103.hasNext() == false) goto L6;
        String r104 = (String) r103.next();     // Catch: Throwable -> L8
        r101.append(r104);     // Catch: Throwable -> L8
        r101.append(" ");     // Catch: Throwable -> L8
        r101.append((String) r102.get(r104));     // Catch: Throwable -> L8
        r101.append(",");     // Catch: Throwable -> L8
        goto L4
    L6:
        r101.delete(r101.length() - 1, r101.length());     // Catch: Throwable -> L8
        r101.append(")");     // Catch: Throwable -> L8
        r100.execSQL(r101.toString());     // Catch: Throwable -> L8
        return;
    L8:
        c.a();
    }
}
