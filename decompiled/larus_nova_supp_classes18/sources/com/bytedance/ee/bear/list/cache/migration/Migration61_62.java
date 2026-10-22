package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration61_62 extends Migration {
    public Migration61_62() {
        super(61, 62);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_obj_delete_flag INTEGER NOT NULL DEFAULT 0");
    }
}
