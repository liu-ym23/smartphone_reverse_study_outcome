package com.bytedance.crypto.obfuscated;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes15.dex */
public final class k extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile k f204264a;

    public k(Context r100) {
        super(r100, "secret_item.db", null, 1);
    }

    public static k a(Context r100) {
        if (f204264a != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f204264a != null) goto L9;
        f204264a = new k(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f204264a;
    }

    public final i a(String r110, String r111) {
        Cursor r112 = getReadableDatabase().query("secret_item", null, "alias =? AND pkg_name =? ", new String[]{r110, r111}, null, null, null);
        if (r112 != null) goto L6;
        return null;
    L6:
        if (r112.getCount() != 0) goto L9;
        r112.close();
        return null;
    L9:
        i r100 = new i();
        if (r112.moveToFirst() == false) goto L12;
        r100.f204252c = r112.getString(r112.getColumnIndex("associate"));
        r100.f204251b = r112.getString(r112.getColumnIndex("data_type"));
        r100.f204253d = r112.getString(r112.getColumnIndex("public_data"));
        r100.f204254e = r112.getString(r112.getColumnIndex("private_data"));
        r100.f204255f = r112.getString(r112.getColumnIndex("secret_data"));
        r100.f204256g = r112.getString(r112.getColumnIndex("ext_info"));
        r100.f204257h = r112.getString(r112.getColumnIndex("search_info"));
        r100.f204261l = r112.getString(r112.getColumnIndex("create_time"));
        r100.f204262m = r112.getString(r112.getColumnIndex("latest_time"));
        r100.f204258i = r112.getString(r112.getColumnIndex("access_limit"));
        r100.f204259j = r112.getString(r112.getColumnIndex("auth_limit"));
        r100.f204260k = r112.getInt(r112.getColumnIndex("sync_limit"));
        r100.f204250a = r110;
    L12:
        r112.close();
        return r100;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        r100.execSQL("CREATE TABLE key_item (alias TEXT NOT NULL PRIMARY KEY, version INTEGER, cipher TEXT, iv TEXT,extra TEXT)");
        r100.execSQL("CREATE TABLE secret_item (alias TEXT NOT NULL, pkg_name TEXT NOT NULL, public_data TEXT, private_data TEXT, secret_data TEXT, data_type TEXT, associate TEXT, access_limit TEXT, auth_limit TEXT, sync_limit INTEGER, sync_status INTEGER, global_id TEXT, status INTEGER, search_info TEXT, ext_info TEXT, create_time TEXT, latest_time TEXT, PRIMARY KEY (alias, pkg_name))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
    }
}
