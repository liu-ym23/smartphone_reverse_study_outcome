package com.bytedance.ee.bear.list.cache.migration;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import iu5.d;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration57_58 extends Migration {
    public Migration57_58() {
        super(57, 58);
    }

    public final void a(SupportSQLiteDatabase r8) {
        Cursor r0 = r8.query("select obj_token, doc_cache_status from DocMetaInfo where doc_cache_status != 0");
        if (r0 != null) goto L5;
    L11:
        if (r0 != null) goto L13;
        return;
    L13:
        if (r0.isClosed() == true) goto L19;
        r0.close();
        return;
    L19:
        return;
    L5:
        if (r0.moveToFirst() == false) goto L11;
    L6:
        String r2 = r0.getString(r0.getColumnIndex(ResourceData.KEY_OBJ_TOKEN));
        int r4 = r0.getInt(r0.getColumnIndex("doc_cache_status"));
        a.b("Migration57_58", "obj_token = " + r2 + ", doc_cache_status = " + r4);
        if (r4 == 0) goto L10;
        ContentValues r5 = new ContentValues();
        r5.put(ResourceData.KEY_OBJ_TOKEN, r2);
        r5.put("doc_cache_status", Integer.valueOf(r4));
        a.b("Migration57_58", "insert ret = " + r8.insert("CacheStatus", 5, r5));
    L10:
        if (r0.moveToNext() == true) goto L6;
        goto L11
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("DROP TABLE IF EXISTS `CacheStatus`");
        r2.execSQL("CREATE TABLE IF NOT EXISTS `CacheStatus`(`obj_token` TEXT NOT NULL PRIMARY KEY, `doc_cache_status` INTEGER NOT NULL DEFAULT 0, FOREIGN KEY(`obj_token`) REFERENCES DocMetaInfo(`obj_token`) ON UPDATE CASCADE)");
        a(r2);     // Catch: Exception -> L5
        r2.execSQL("UPDATE DocMetaInfo SET doc_cache_status = 0");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.c(e);
    }
}
