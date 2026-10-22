package com.bytedance.ee.bear.list.cache.migration;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.bear.document.DocViewModel;
import iu5.d;

/* JADX INFO: loaded from: classes18.dex */
public class Migration49_50 extends Migration {
    public Migration49_50() {
        super(49, 50);
    }

    public final void a(SupportSQLiteDatabase r310) {
        Cursor r100 = r310.query("select * from ListTypes");
        if (r100 != null) goto L5;
    L25:
        Cursor r210 = r100;
    L26:
        if (r210 != null) goto L28;
        return;
    L28:
        if (r210.isClosed() == true) goto L33;
        r210.close();
        return;
    L33:
        return;
    L5:
        if (r100.moveToFirst() == false) goto L25;
    L6:
        String r101 = r100.getString(r100.getColumnIndex("obj_token"));
        int r102 = r100.getInt(r100.getColumnIndex("list_type"));
        String r103 = r100.getString(r100.getColumnIndex("file_path"));
        String r104 = r100.getString(r100.getColumnIndex("token"));
        String r110 = r100.getString(r100.getColumnIndex("extra"));
        String r111 = r100.getString(r100.getColumnIndex(DocViewModel.EXTRA_SPACE_ID));
        String r112 = r100.getString(r100.getColumnIndex("add_time_manualoffline"));
        if (r100.getInt(r100.getColumnIndex("is_need_wifi_download")) != 1) goto L9;
        boolean r113 = true;
    L10:
        boolean r114 = r113;
        String r115 = r100.getString(r100.getColumnIndex("open_time_recent"));
        String r116 = r100.getString(r100.getColumnIndex("my_edit_time_recent"));
        String r117 = r100.getString(r100.getColumnIndex("activity_time_recent"));
        if (r100.getInt(r100.getColumnIndex("has_perm_folder")) != 1) goto L13;
        boolean r118 = true;
    L14:
        boolean r211 = r118;
        int r119 = r100.getInt(r100.getColumnIndex("show_external_hint_folder"));
        r210 = r100;
        boolean r105 = true;
        if (r119 == 1) goto L18;
        r105 = false;
    L18:
        ContentValues r120 = new ContentValues();
        r120.put("obj_token", r101);
        r120.put("list_type", Integer.valueOf(r102));
        r120.put("file_path", r103);
        if (r104 != null) goto L21;
        r104 = "";
    L21:
        r120.put("token", r104);
        r120.put("extra", r110);
        r120.put(DocViewModel.EXTRA_SPACE_ID, r111);
        r120.put("add_time_manualoffline", r112);
        r120.put("is_need_wifi_download", Boolean.valueOf(r114));
        r120.put("open_time_recent", r115);
        r120.put("my_edit_time_recent", r116);
        r120.put("activity_time_recent", r117);
        r120.put("has_perm_folder", Boolean.valueOf(r211));
        r120.put("show_external_hint_folder", Boolean.valueOf(r105));
        r120.put("node_type_folder", 0);
        r120.put("shortcut_name_folder", "");
        r310.insert("ListTypes_New", 5, r120);
        if (r210.moveToNext() == false) goto L26;
        r100 = r210;
        goto L6
    L13:
        r118 = false;
        goto L14
    L9:
        r113 = false;
        goto L10
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN is_share_folder INTEGER NOT NULL DEFAULT 0");
        r100.execSQL("ALTER TABLE `FilterCache` ADD COLUMN node_type_folder INTEGER NOT NULL DEFAULT 0");
        r100.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_name_folder TEXT");
        r100.execSQL("CREATE TABLE IF NOT EXISTS `ListTypes_New` (`obj_token` TEXT NOT NULL, `list_type` INTEGER NOT NULL DEFAULT 0, `file_path` TEXT NOT NULL DEFAULT '',`token` TEXT NOT NULL DEFAULT '', `extra` TEXT, `space_id` TEXT,`add_time_manualoffline` TEXT,`is_need_wifi_download` INTEGER NOT NULL DEFAULT 0,`open_time_recent` TEXT,`my_edit_time_recent` TEXT,`activity_time_recent` TEXT,`has_perm_folder` INTEGER NOT NULL DEFAULT 1,`show_external_hint_folder` INTEGER NOT NULL DEFAULT 0,`node_type_folder` INTEGER NOT NULL DEFAULT 0,`shortcut_name_folder` TEXT,FOREIGN KEY(`obj_token`) REFERENCES DocMetaInfo(`obj_token`) ON UPDATE CASCADE,PRIMARY KEY(`obj_token`, `list_type`, `token`))");
        a(r100);     // Catch: Exception -> L5
    L7:
        r100.execSQL("DROP TABLE IF EXISTS 'ListTypes'");
        r100.execSQL("ALTER TABLE ListTypes_New RENAME TO ListTypes");
        r100.execSQL("CREATE INDEX IF NOT EXISTS `index_ListTypes_obj_token_list_type` ON `ListTypes` (`obj_token`, `list_type`)");
        return;
    L5:
        e = move-exception;
        d.c(e);
        goto L7
    }
}
