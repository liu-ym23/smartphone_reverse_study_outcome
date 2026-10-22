package com.bytedance.ee.bear.list.cache.migration;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration56_57 extends Migration {
    public Migration56_57() {
        super(56, 57);
    }

    public final void migrate(SupportSQLiteDatabase r14) {
        r14.execSQL("ALTER TABLE `ListTypes` ADD COLUMN is_hidden_share INTEGER NOT NULL DEFAULT 0");
        r14.execSQL("ALTER TABLE `ListTypes` ADD COLUMN share_time_share TEXT");
        r14.execSQL("ALTER TABLE `FilterCache` ADD COLUMN is_hidden_share INTEGER NOT NULL DEFAULT 0");
        r14.execSQL("ALTER TABLE `FilterCache` ADD COLUMN share_time_share TEXT");
        Cursor r0 = r14.query("select obj_token, share_time, is_hidden from DocMetaInfo");
        if (r0 != null) goto L5;
    L12:
        if (r0 != null) goto L14;
        return;
    L14:
        if (r0.isClosed() == true) goto L20;
        r0.close();
        return;
    L20:
        return;
    L5:
        if (r0.moveToFirst() == false) goto L12;
    L6:
        String r1 = r0.getString(r0.getColumnIndex(ResourceData.KEY_OBJ_TOKEN));
        String r2 = r0.getString(r0.getColumnIndex("share_time"));
        if (r0.getInt(r0.getColumnIndex("is_hidden")) != 1) goto L9;
        boolean r3 = true;
    L10:
        ContentValues r12 = new ContentValues();
        r12.put("share_time_share", r2);
        r12.put("is_hidden_share", Boolean.valueOf(r3));
        String[] r4 = {r1};
        r14.update("ListTypes", 5, r12, "obj_token = ?", r4);
        r14.update("FilterCache", 5, r12, "obj_token = ?", r4);
        if (r0.moveToNext() == true) goto L6;
    L9:
        r3 = false;
        goto L10
    }
}
