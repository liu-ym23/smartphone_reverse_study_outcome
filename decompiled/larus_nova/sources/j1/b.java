package j1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.apm.lite.k.p;

/* JADX INFO: loaded from: classes39.dex */
public final class b extends a<i1.a> {
    public b() {
    }

    public final boolean b(SQLiteDatabase r110, String r111) {
        if (r110 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r111) == false) goto L17;
        return false;
    L17:
        Cursor r112 = r110.query(this.f496855a, null, "path=?", new String[]{r111}, null, null, null);     // Catch: Throwable -> L11
        int r113 = r112.getCount();     // Catch: Throwable -> L11
        r112.close();     // Catch: Throwable -> L16
    L13:
        if (r113 <= 0) goto L22;
        return true;
    L22:
        return false;
    L12:
        p.c();
    L11:
        r113 = 0;
        goto L12
    }

    public final void a(SQLiteDatabase r100, i1.a r101) {
        if (b(r100, r101.f487923a) == true) goto L17;
        if (r100 != null) goto L15;
    L13:
        r100.execSQL("delete from " + this.f496855a + " where _id in (select _id from " + this.f496855a + " order by insert_time desc limit 1000 offset 500)");     // Catch: Exception -> L11
        return;
    L11:
        p.c();
        return;
    L15:
        String r102 = this.f496855a;     // Catch: Throwable -> L8
        ContentValues r103 = new ContentValues();     // Catch: Throwable -> L8
        r103.put("path", r101.f487923a);     // Catch: Throwable -> L8
        r103.put("insert_time", Long.valueOf(r101.f487924b));     // Catch: Throwable -> L8
        r100.insert(r102, null, r103);     // Catch: Throwable -> L8
    L8:
        p.c();
        goto L13
    }
}
