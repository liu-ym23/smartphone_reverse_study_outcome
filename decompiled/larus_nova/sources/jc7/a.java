package jc7;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends SQLiteOpenHelper {
    public a(Context r100) {
        super(r100, "account_db", null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        r100.execSQL("CREATE TABLE IF NOT EXISTS login_info (time integer primary key , type integer , info text , uid integer , avatar_url text , screen_name text , platform_avatar_url text, platform_screen_name text,sec_uid text,ext text);");     // Catch: SQLException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        if (r101 >= 2) goto L6;
        r100.execSQL("alter TABLE login_info add COLUMN sec_uid text ");
        r100.execSQL("alter TABLE login_info add COLUMN ext text ");
        tb7.a.a("DBHelper", "update db ");
        return;
    }
}
