package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration60_61 extends Migration {
    public Migration60_61() {
        super(60, 61);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_obj_biz_type INTEGER NOT NULL DEFAULT 1");
        r2.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_obj_node_token TEXT");
        r2.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_obj_biz_type INTEGER NOT NULL DEFAULT 1");
        r2.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_obj_node_token TEXT");
    }
}
