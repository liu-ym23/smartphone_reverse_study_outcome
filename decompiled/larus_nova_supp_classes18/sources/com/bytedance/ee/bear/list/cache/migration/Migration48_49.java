package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration48_49 extends Migration {
    public Migration48_49() {
        super(48, 49);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("DROP TABLE IF EXISTS `RecentWiki`");
        r2.execSQL("CREATE TABLE IF NOT EXISTS `RecentWiki` (`wiki_token` TEXT NOT NULL PRIMARY KEY, `space_id` TEXT, `open_time` TEXT,`open_count` TEXT,`title` TEXT,`owner_id` TEXT,`creator_cn_name` TEXT,`creator_en_name` TEXT,`edit_uid` TEXT,`edit_time` TEXT,`url` TEXT,`obj_type` INTEGER NOT NULL DEFAULT 0, `obj_token` TEXT)");
    }
}
