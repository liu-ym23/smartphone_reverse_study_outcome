package com.bytedance.ee.bear.list.cache.migration;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import iu5.d;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
public class Migration57_58 extends Migration {
    public Migration57_58() {
        super(57, 58);
    }

    public final void a(SupportSQLiteDatabase r100) {
        Cursor r101 = r100.query("select obj_token, doc_cache_status from DocMetaInfo where doc_cache_status != 0");
        if (r101 != null) goto L5;
    L11:
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.isClosed() == true) goto L19;
        r101.close();
        return;
    L19:
        return;
    L5:
        if (r101.moveToFirst() == false) goto L11;
    L6:
        String r102 = r101.getString(r101.getColumnIndex("obj_token"));
        int r103 = r101.getInt(r101.getColumnIndex("doc_cache_status"));
        a.b("Migration57_58", "obj_token = " + r102 + ", doc_cache_status = " + r103);
        if (r103 == 0) goto L10;
        ContentValues r104 = new ContentValues();
        r104.put("obj_token", r102);
        r104.put("doc_cache_status", Integer.valueOf(r103));
        a.b("Migration57_58", "insert ret = " + r100.insert("CacheStatus", 5, r104));
    L10:
        if (r101.moveToNext() == true) goto L6;
        goto L11
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("DROP TABLE IF EXISTS `CacheStatus`");
        r100.execSQL("CREATE TABLE IF NOT EXISTS `CacheStatus`(`obj_token` TEXT NOT NULL PRIMARY KEY, `doc_cache_status` INTEGER NOT NULL DEFAULT 0, FOREIGN KEY(`obj_token`) REFERENCES DocMetaInfo(`obj_token`) ON UPDATE CASCADE)");
        a(r100);     // Catch: Exception -> L5
        r100.execSQL("UPDATE DocMetaInfo SET doc_cache_status = 0");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.c(e);
    }
}
