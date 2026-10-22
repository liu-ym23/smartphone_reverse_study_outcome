package com.bytedance.ee.bear.list.cache.migration;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import iu5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration49_50 extends Migration {
    public Migration49_50() {
        super(49, 50);
    }

    public final void a(SupportSQLiteDatabase r30) {
        Cursor r1 = r30.query("select * from ListTypes");
        if (r1 != null) goto L5;
    L25:
        Cursor r28 = r1;
    L26:
        if (r28 != null) goto L28;
        return;
    L28:
        if (r28.isClosed() == true) goto L33;
        r28.close();
        return;
    L33:
        return;
    L5:
        if (r1.moveToFirst() == false) goto L25;
    L6:
        String r3 = r1.getString(r1.getColumnIndex(ResourceData.KEY_OBJ_TOKEN));
        int r5 = r1.getInt(r1.getColumnIndex("list_type"));
        String r7 = r1.getString(r1.getColumnIndex("file_path"));
        String r9 = r1.getString(r1.getColumnIndex(ResourceData.KEY_TOKEN));
        String r11 = r1.getString(r1.getColumnIndex("extra"));
        String r13 = r1.getString(r1.getColumnIndex("space_id"));
        String r15 = r1.getString(r1.getColumnIndex("add_time_manualoffline"));
        if (r1.getInt(r1.getColumnIndex("is_need_wifi_download")) != 1) goto L9;
        boolean r14 = true;
    L10:
        boolean r19 = r14;
        String r16 = r1.getString(r1.getColumnIndex("open_time_recent"));
        String r17 = r1.getString(r1.getColumnIndex("my_edit_time_recent"));
        String r18 = r1.getString(r1.getColumnIndex("activity_time_recent"));
        if (r1.getInt(r1.getColumnIndex("has_perm_folder")) != 1) goto L13;
        boolean r110 = true;
    L14:
        boolean r27 = r110;
        int r111 = r1.getInt(r1.getColumnIndex("show_external_hint_folder"));
        r28 = r1;
        boolean r2 = true;
        if (r111 == 1) goto L18;
        r2 = false;
    L18:
        ContentValues r112 = new ContentValues();
        r112.put(ResourceData.KEY_OBJ_TOKEN, r3);
        r112.put("list_type", Integer.valueOf(r5));
        r112.put("file_path", r7);
        if (r9 != null) goto L21;
        r9 = "";
    L21:
        r112.put(ResourceData.KEY_TOKEN, r9);
        r112.put("extra", r11);
        r112.put("space_id", r13);
        r112.put("add_time_manualoffline", r15);
        r112.put("is_need_wifi_download", Boolean.valueOf(r19));
        r112.put("open_time_recent", r16);
        r112.put("my_edit_time_recent", r17);
        r112.put("activity_time_recent", r18);
        r112.put("has_perm_folder", Boolean.valueOf(r27));
        r112.put("show_external_hint_folder", Boolean.valueOf(r2));
        r112.put("node_type_folder", 0);
        r112.put("shortcut_name_folder", "");
        r30.insert("ListTypes_New", 5, r112);
        if (r28.moveToNext() == false) goto L26;
        r1 = r28;
        goto L6
    L13:
        r110 = false;
        goto L14
    L9:
        r14 = false;
        goto L10
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN is_share_folder INTEGER NOT NULL DEFAULT 0");
        r2.execSQL("ALTER TABLE `FilterCache` ADD COLUMN node_type_folder INTEGER NOT NULL DEFAULT 0");
        r2.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_name_folder TEXT");
        r2.execSQL("CREATE TABLE IF NOT EXISTS `ListTypes_New` (`obj_token` TEXT NOT NULL, `list_type` INTEGER NOT NULL DEFAULT 0, `file_path` TEXT NOT NULL DEFAULT '',`token` TEXT NOT NULL DEFAULT '', `extra` TEXT, `space_id` TEXT,`add_time_manualoffline` TEXT,`is_need_wifi_download` INTEGER NOT NULL DEFAULT 0,`open_time_recent` TEXT,`my_edit_time_recent` TEXT,`activity_time_recent` TEXT,`has_perm_folder` INTEGER NOT NULL DEFAULT 1,`show_external_hint_folder` INTEGER NOT NULL DEFAULT 0,`node_type_folder` INTEGER NOT NULL DEFAULT 0,`shortcut_name_folder` TEXT,FOREIGN KEY(`obj_token`) REFERENCES DocMetaInfo(`obj_token`) ON UPDATE CASCADE,PRIMARY KEY(`obj_token`, `list_type`, `token`))");
        a(r2);     // Catch: Exception -> L5
    L7:
        r2.execSQL("DROP TABLE IF EXISTS 'ListTypes'");
        r2.execSQL("ALTER TABLE ListTypes_New RENAME TO ListTypes");
        r2.execSQL("CREATE INDEX IF NOT EXISTS `index_ListTypes_obj_token_list_type` ON `ListTypes` (`obj_token`, `list_type`)");
        return;
    L5:
        e = move-exception;
        d.c(e);
        goto L7
    }
}
