package com.bytedance.ee.bear.list.cache.migration;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration56_57 extends Migration {
    public Migration56_57() {
        super(56, 57);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r110) {
        r110.execSQL("ALTER TABLE `ListTypes` ADD COLUMN is_hidden_share INTEGER NOT NULL DEFAULT 0");
        r110.execSQL("ALTER TABLE `ListTypes` ADD COLUMN share_time_share TEXT");
        r110.execSQL("ALTER TABLE `FilterCache` ADD COLUMN is_hidden_share INTEGER NOT NULL DEFAULT 0");
        r110.execSQL("ALTER TABLE `FilterCache` ADD COLUMN share_time_share TEXT");
        Cursor r100 = r110.query("select obj_token, share_time, is_hidden from DocMetaInfo");
        if (r100 != null) goto L5;
    L12:
        if (r100 != null) goto L14;
        return;
    L14:
        if (r100.isClosed() == true) goto L20;
        r100.close();
        return;
    L20:
        return;
    L5:
        if (r100.moveToFirst() == false) goto L12;
    L6:
        String r101 = r100.getString(r100.getColumnIndex("obj_token"));
        String r102 = r100.getString(r100.getColumnIndex("share_time"));
        if (r100.getInt(r100.getColumnIndex("is_hidden")) != 1) goto L9;
        boolean r103 = true;
    L10:
        ContentValues r111 = new ContentValues();
        r111.put("share_time_share", r102);
        r111.put("is_hidden_share", Boolean.valueOf(r103));
        String[] r104 = {r101};
        r110.update("ListTypes", 5, r111, "obj_token = ?", r104);
        r110.update("FilterCache", 5, r111, "obj_token = ?", r104);
        if (r100.moveToNext() == true) goto L6;
    L9:
        r103 = false;
        goto L10
    }
}
