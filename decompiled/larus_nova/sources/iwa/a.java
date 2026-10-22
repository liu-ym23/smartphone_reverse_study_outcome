package iwa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f496242a;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        Iterator<String> r101 = this.f496242a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = r101.next();
        Log.i("WsDB", "create table: " + r102);
        r100.execSQL("create table if not exists " + r102 + " ( time long primary key, data TEXT )");
        goto L4
    }

    public a(Context r100, String r101, List<String> r102) {
        super(r100, r101, null, 1);
        this.f496242a = r102;
    }
}
