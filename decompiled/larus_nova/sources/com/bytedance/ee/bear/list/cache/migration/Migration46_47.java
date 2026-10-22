package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration46_47 extends Migration {
    public Migration46_47() {
        super(46, 47);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("CREATE TABLE IF NOT EXISTS `FilterCache` (`list_type` INTEGER NOT NULL DEFAULT 0, `filter_type` INTEGER NOT NULL DEFAULT 0, `file_type` TEXT NOT NULL DEFAULT '',`strategy` INTEGER NOT NULL DEFAULT 0, `is_asc` INTEGER NOT NULL DEFAULT 0,`obj_token` TEXT NOT NULL DEFAULT '',`file_path` TEXT NOT NULL DEFAULT '',`token` TEXT,`extra` TEXT, `space_id` TEXT,`add_time_manualoffline` TEXT,`is_need_wifi_download` INTEGER NOT NULL DEFAULT 0,`open_time_recent` TEXT,`my_edit_time_recent` TEXT,`activity_time_recent` TEXT,`has_perm_folder` INTEGER NOT NULL DEFAULT 1,`show_external_hint_folder` INTEGER NOT NULL DEFAULT 0,PRIMARY KEY(`list_type`, `filter_type`, `file_type`, `strategy`, `is_asc`, `obj_token`, `file_path`))");
    }
}
