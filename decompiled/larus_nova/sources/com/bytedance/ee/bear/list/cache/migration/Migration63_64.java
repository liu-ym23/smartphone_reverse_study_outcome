package com.bytedance.ee.bear.list.cache.migration;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import hu5.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public class Migration63_64 extends Migration {
    public Migration63_64() {
        super(63, 64);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        HashMap r101 = new HashMap();
        Cursor r102 = r100.query("select obj_token, doc_cache_status from CacheStatus where doc_cache_status != 0");
        if (r102 != null) goto L5;
    L14:
        if (r102 != null) goto L16;
    L18:
        r100.execSQL("DROP TABLE IF EXISTS `CacheStatus`");
        r100.execSQL("CREATE TABLE IF NOT EXISTS `CacheStatus`(`obj_token` TEXT NOT NULL PRIMARY KEY, `doc_cache_status` INTEGER NOT NULL DEFAULT 0)");
        if (a.g(r101) == false) goto L24;
        Iterator r103 = r101.entrySet().iterator();
    L22:
        if (r103.hasNext() == false) goto L28;
        Map.Entry r104 = (Map.Entry) r103.next();
        ContentValues r105 = new ContentValues();
        r105.put("obj_token", (String) r104.getKey());
        r105.put("doc_cache_status", (Integer) r104.getValue());
        r100.insert("CacheStatus", 5, r105);
        goto L22
    L28:
        return;
    L24:
        return;
    L16:
        if (r102.isClosed() == true) goto L18;
        r102.close();
        goto L18
    L5:
        if (r102.moveToFirst() == false) goto L14;
    L6:
        int r106 = r102.getColumnIndex("obj_token");
        int r107 = r102.getColumnIndex("doc_cache_status");
        if (r106 < 0) goto L13;
        if (r107 < 0) goto L13;
        String r108 = r102.getString(r106);
        int r109 = r102.getInt(r107);
        if (r109 == 0) goto L13;
        r101.put(r108, Integer.valueOf(r109));
    L13:
        if (r102.moveToNext() == true) goto L6;
        goto L14
    }
}
