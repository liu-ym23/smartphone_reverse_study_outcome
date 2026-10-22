package com.bytedance.ee.bear.list.cache.migration;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import hu5.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration63_64 extends Migration {
    public Migration63_64() {
        super(63, 64);
    }

    public final void migrate(SupportSQLiteDatabase r7) {
        HashMap r0 = new HashMap();
        Cursor r1 = r7.query("select obj_token, doc_cache_status from CacheStatus where doc_cache_status != 0");
        if (r1 != null) goto L5;
    L14:
        if (r1 != null) goto L16;
    L18:
        r7.execSQL("DROP TABLE IF EXISTS `CacheStatus`");
        r7.execSQL("CREATE TABLE IF NOT EXISTS `CacheStatus`(`obj_token` TEXT NOT NULL PRIMARY KEY, `doc_cache_status` INTEGER NOT NULL DEFAULT 0)");
        if (a.g(r0) == false) goto L24;
        Iterator r2 = r0.entrySet().iterator();
    L22:
        if (r2.hasNext() == false) goto L28;
        Map.Entry r3 = (Map.Entry) r2.next();
        ContentValues r4 = new ContentValues();
        r4.put(ResourceData.KEY_OBJ_TOKEN, (String) r3.getKey());
        r4.put("doc_cache_status", (Integer) r3.getValue());
        r7.insert("CacheStatus", 5, r4);
        goto L22
    L28:
        return;
    L24:
        return;
    L16:
        if (r1.isClosed() == true) goto L18;
        r1.close();
        goto L18
    L5:
        if (r1.moveToFirst() == false) goto L14;
    L6:
        int r5 = r1.getColumnIndex(ResourceData.KEY_OBJ_TOKEN);
        int r6 = r1.getColumnIndex("doc_cache_status");
        if (r5 < 0) goto L13;
        if (r6 < 0) goto L13;
        String r8 = r1.getString(r5);
        int r9 = r1.getInt(r6);
        if (r9 == 0) goto L13;
        r0.put(r8, Integer.valueOf(r9));
    L13:
        if (r1.moveToNext() == true) goto L6;
        goto L14
    }
}
